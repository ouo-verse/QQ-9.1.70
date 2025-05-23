package com.tencent.qqmini.sdk.core.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

@MiniKeep
/* loaded from: classes23.dex */
public class VoIPManager {
    private static final int ROOM_STATE_ENTERED = 2;
    private static final int ROOM_STATE_ENTERING = 1;
    private static final int ROOM_STATE_INITIAL = 0;
    public static final String TAG = "VoIPManager";
    public static final int UNKNOWN = -1;
    public static volatile VoIPManager sInstance;
    private EventListener mEventListener;
    private JoinRoomListener mJoinRoomListener;
    private MuteConfig mMuteConfig;
    private boolean mQAvHasInitSDK;
    private VoIPProxy mVoIPProxy = (VoIPProxy) ProxyManager.get(VoIPProxy.class);
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.tencent.qqmini.sdk.core.manager.VoIPManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            if ("android.intent.action.HEADSET_PLUG".equals(action)) {
                int intExtra = intent.getIntExtra("state", -1);
                QMLog.d(VoIPManager.TAG, String.format("onReceive ACTION_HEADSET_PLUG state=%s", Integer.valueOf(intExtra)));
                if (intExtra == 0) {
                    VoIPManager.this.switchAudioRoute();
                    return;
                } else {
                    if (intExtra == 1) {
                        VoIPManager.this.switchAudioRoute(0);
                        return;
                    }
                    return;
                }
            }
            if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                QMLog.d(VoIPManager.TAG, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra2)));
                if (intExtra2 == 2) {
                    VoIPManager.this.switchAudioRoute(2);
                    return;
                } else {
                    if (intExtra2 == 0) {
                        VoIPManager.this.switchAudioRoute();
                        return;
                    }
                    return;
                }
            }
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                int intExtra3 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                QMLog.d(VoIPManager.TAG, String.format("onReceive ACTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra3)));
                if (intExtra3 == 10 || intExtra3 == 13) {
                    VoIPManager.this.switchAudioRoute();
                }
            }
        }
    };
    private volatile AtomicInteger mQAvRoomState = new AtomicInteger(0);
    private boolean needExitRoomImmediatelyAfterEntering = false;
    private Map<Long, UserModel> mRoomUserModelList = new ConcurrentHashMap();
    private long mSelfUin = -1;
    private int mSelfMicStat = -1;
    private int mSelfMuteStat = -1;
    private VoIPProxy.VoIPListener mVoIPListener = new VoIPProxy.VoIPListener() { // from class: com.tencent.qqmini.sdk.core.manager.VoIPManager.2
        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener
        public void onEnterRoom() {
            VoIPManager.this.handleOnEnterRoom();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener
        public void onError(int i3) {
            VoIPManager.this.handleOnError(i3);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener
        public void onUserAudioAvailable(VoIPProxy.MultiUserInfo multiUserInfo, boolean z16) {
            QMLog.d(VoIPManager.TAG, String.format("onUserAudioAvailable userInfo=%s available=%s", multiUserInfo, Boolean.valueOf(z16)));
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener
        public void onUserEnter(VoIPProxy.MultiUserInfo multiUserInfo) {
            VoIPManager.this.handleOnUserEnter(multiUserInfo);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener
        public void onUserExit(VoIPProxy.MultiUserInfo multiUserInfo) {
            VoIPManager.this.handleOnUserExit(multiUserInfo);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener
        public void onUserSpeaking(VoIPProxy.MultiUserInfo multiUserInfo, boolean z16) {
            VoIPManager.this.handleOnUserSpecking(multiUserInfo, z16);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener
        public void onUserUpdate(List<VoIPProxy.MultiUserInfo> list) {
            VoIPManager.this.handleOnUserUpdate(list);
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface EnableStat {
        public static final int DISABLED = 2;
        public static final int ENABLED = 1;
        public static final int NONE = -1;
    }

    /* loaded from: classes23.dex */
    public interface EventListener {
        void onInterrupt(int i3, String str);

        void onRoomMemberChange(JSONArray jSONArray);

        void onRoomMemberSpeaking(JSONArray jSONArray);
    }

    /* loaded from: classes23.dex */
    public static class IdResult {

        @JsonORM.Column(key = "openId")
        public String openId;

        @JsonORM.Column(key = "roomId")
        public long roomId;

        @JsonORM.Column(key = "tinyId")
        public long tinyId;

        public String toString() {
            return "IdResult{openId='" + this.openId + "', tinyId=" + this.tinyId + ", roomId=" + this.roomId + '}';
        }
    }

    /* loaded from: classes23.dex */
    public interface JoinRoomListener {
        void onError(int i3);

        void onJoinRoom(JSONArray jSONArray);
    }

    /* loaded from: classes23.dex */
    public static class MuteConfig {

        @JsonORM.Column(key = "muteEarphone")
        public boolean isMuteEarphone;

        @JsonORM.Column(key = "muteMicrophone")
        public boolean isMuteMicrophone;

        public String toString() {
            return "muteConfig{isMuteMicrophone=" + this.isMuteMicrophone + ", isMuteEarphone=" + this.isMuteEarphone + '}';
        }
    }

    /* loaded from: classes23.dex */
    public interface MuteConfigListener {
        void onFail(int i3);

        void onSuccess();
    }

    /* loaded from: classes23.dex */
    public static class RoomConfig {

        @JsonORM.Column(key = "groupId")
        public String groupId;

        @JsonORM.Column(key = "muteConfig")
        public MuteConfig muteConfig;

        @JsonORM.Column(key = PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY)
        public String nonceStr;

        @JsonORM.Column(key = "signature")
        public String signature;

        @JsonORM.Column(key = PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY)
        public int timeStamp;

        public String toString() {
            return "RoomConfig{signature='" + this.signature + "', nonceStr='" + this.nonceStr + "', timeStamp=" + this.timeStamp + ", groupId=" + this.groupId + ", muteConfig=" + this.muteConfig + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class UserModel {
        public int mMicStat;
        public String mOpenId;
        public boolean mSpeaking;
        public long mUin;

        UserModel() {
        }
    }

    VoIPManager() {
    }

    private void doExitRoom() {
        QMLog.i(TAG, "exitRoom!");
        MiniAppEnv.g().getContext().unregisterReceiver(this.mReceiver);
        this.mVoIPProxy.exitRoom();
        this.mVoIPProxy.unInit();
        this.mQAvHasInitSDK = false;
        this.mQAvRoomState.set(0);
    }

    public static VoIPManager getInstance() {
        if (sInstance == null) {
            synchronized (VoIPManager.class) {
                if (sInstance == null) {
                    sInstance = new VoIPManager();
                }
            }
        }
        return sInstance;
    }

    private JSONArray getRoomOpenIdList() {
        JSONArray jSONArray;
        Map<Long, UserModel> map = this.mRoomUserModelList;
        if (map != null) {
            Set<Long> keySet = map.keySet();
            HashSet hashSet = new HashSet();
            Iterator<Long> it = keySet.iterator();
            while (it.hasNext()) {
                UserModel userModel = getUserModel(it.next().longValue());
                if (userModel != null) {
                    hashSet.add(userModel.mOpenId);
                }
            }
            jSONArray = new JSONArray((Collection) hashSet);
        } else {
            jSONArray = null;
        }
        if (jSONArray == null) {
            return new JSONArray();
        }
        return jSONArray;
    }

    private JSONArray getSpeakingOpenIdList() {
        JSONArray jSONArray = new JSONArray();
        Map<Long, UserModel> map = this.mRoomUserModelList;
        if (map != null) {
            for (Map.Entry<Long, UserModel> entry : map.entrySet()) {
                if (entry.getValue().mSpeaking && entry.getValue().mMicStat == 1) {
                    jSONArray.mo162put(entry.getValue().mOpenId);
                }
            }
        }
        return jSONArray;
    }

    private UserModel getUserModel(long j3) {
        Map<Long, UserModel> map = this.mRoomUserModelList;
        if (map != null) {
            return map.get(Long.valueOf(j3));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnEnterRoom() {
        QMLog.d(TAG, "onEnterRoom");
        this.mQAvRoomState.set(2);
        MuteConfig muteConfig = this.mMuteConfig;
        if (muteConfig != null) {
            updateMuteConfig(muteConfig, null);
        }
        this.mVoIPProxy.updateRoomInfo();
        switchAudioRoute();
        if (this.needExitRoomImmediatelyAfterEntering) {
            exitRoom();
            this.needExitRoomImmediatelyAfterEntering = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnError(int i3) {
        EventListener eventListener;
        QMLog.d(TAG, String.format("onEnterRoom errorType=%s", Integer.valueOf(i3)));
        if (i3 != 2 && i3 != 1) {
            if (i3 == 4) {
                EventListener eventListener2 = this.mEventListener;
                if (eventListener2 != null) {
                    eventListener2.onInterrupt(4, "\u7b2c\u4e09\u65b9\u901a\u8bdd\u4e2d\u65ad");
                    return;
                }
                return;
            }
            if (i3 == 3 && (eventListener = this.mEventListener) != null) {
                eventListener.onInterrupt(3, "\u7f51\u7edc\u539f\u56e0\u4e2d\u65ad");
                return;
            }
            return;
        }
        JoinRoomListener joinRoomListener = this.mJoinRoomListener;
        if (joinRoomListener != null) {
            joinRoomListener.onError(i3);
            this.mJoinRoomListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnUserEnter(VoIPProxy.MultiUserInfo multiUserInfo) {
        QMLog.d(TAG, String.format("onUserEnter userInfo=%s", multiUserInfo));
        if (this.mJoinRoomListener == null && getUserModel(multiUserInfo.mUin) == null) {
            UserModel userModel = new UserModel();
            userModel.mUin = multiUserInfo.mUin;
            userModel.mOpenId = multiUserInfo.mOpenId;
            userModel.mMicStat = 1;
            putUserModel(userModel);
            EventListener eventListener = this.mEventListener;
            if (eventListener != null) {
                eventListener.onRoomMemberChange(getRoomOpenIdList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnUserExit(VoIPProxy.MultiUserInfo multiUserInfo) {
        QMLog.d(TAG, String.format("onUserExit userInfo=%s", multiUserInfo));
        if (this.mJoinRoomListener == null) {
            removeUserModel(multiUserInfo.mUin);
            EventListener eventListener = this.mEventListener;
            if (eventListener != null) {
                eventListener.onRoomMemberChange(getRoomOpenIdList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnUserSpecking(VoIPProxy.MultiUserInfo multiUserInfo, boolean z16) {
        QMLog.d(TAG, String.format("onUserSpeaking userInfo=%s speaking=%s", multiUserInfo, Boolean.valueOf(z16)));
        UserModel userModel = getUserModel(multiUserInfo.mUin);
        if (userModel != null) {
            userModel.mSpeaking = z16;
            EventListener eventListener = this.mEventListener;
            if (eventListener != null) {
                eventListener.onRoomMemberSpeaking(getSpeakingOpenIdList());
                return;
            }
            return;
        }
        QMLog.e(TAG, "onUserSpeaking userModel==null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnUserUpdate(List<VoIPProxy.MultiUserInfo> list) {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleOnUserUpdate userInfoList size ");
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        QMLog.d(TAG, sb5.toString());
        if (this.mJoinRoomListener != null && list != null) {
            JSONArray jSONArray = new JSONArray();
            for (VoIPProxy.MultiUserInfo multiUserInfo : list) {
                QMLog.d(TAG, String.format("handleOnUserUpdate userInfo=%s", multiUserInfo));
                if (multiUserInfo.mUin != 0) {
                    jSONArray.mo162put(multiUserInfo.mOpenId);
                }
            }
            this.mJoinRoomListener.onJoinRoom(jSONArray);
            updateUserModelList(list);
            this.mJoinRoomListener = null;
        }
    }

    private boolean isBluetoothOn() {
        return ((AudioManager) MiniAppEnv.g().getContext().getSystemService("audio")).isBluetoothA2dpOn();
    }

    private boolean isHeadsetPlugged() {
        return ((AudioManager) MiniAppEnv.g().getContext().getSystemService("audio")).isWiredHeadsetOn();
    }

    private boolean isMicAvailable() {
        Boolean bool = Boolean.TRUE;
        AudioRecord audioRecord = new AudioRecord(1, 44100, 16, 1, 44100);
        try {
            if (audioRecord.getRecordingState() != 1) {
                bool = Boolean.FALSE;
            }
            AudioMonitor.startRecording(audioRecord);
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                bool = Boolean.FALSE;
            }
            audioRecord.stop();
            audioRecord.release();
            return bool.booleanValue();
        } catch (Throwable th5) {
            try {
                QMLog.e(TAG, "validateMicAvailability", th5);
                audioRecord.release();
                return false;
            } catch (Throwable th6) {
                audioRecord.release();
                throw th6;
            }
        }
    }

    private void putUserModel(UserModel userModel) {
        Map<Long, UserModel> map = this.mRoomUserModelList;
        if (map != null) {
            map.put(Long.valueOf(userModel.mUin), userModel);
        }
    }

    private void qavInitSDK(long j3) {
        QMLog.i(TAG, "qavInitSDK");
        this.mVoIPProxy.init(j3, this.mVoIPListener);
    }

    private int qavOpMic(boolean z16) {
        int i3 = 2;
        if (this.mQAvRoomState.get() != 2) {
            QMLog.e(TAG, "cant op mic currently");
            return -1;
        }
        int enableLocalAudio = this.mVoIPProxy.enableLocalAudio(z16);
        if (enableLocalAudio == 0) {
            if (z16) {
                i3 = 1;
            }
            this.mSelfMicStat = i3;
            UserModel userModel = getUserModel(this.mSelfUin);
            if (userModel != null) {
                userModel.mMicStat = this.mSelfMicStat;
            }
            QMLog.i(TAG, "OpMic " + z16);
        } else {
            QMLog.e(TAG, "multiOperator null");
        }
        return enableLocalAudio;
    }

    private int qavOpMute(boolean z16) {
        int i3 = 2;
        if (this.mQAvRoomState.get() != 2) {
            QMLog.e(TAG, "cant op mute currently");
            return -1;
        }
        int enableRemoteAudio = this.mVoIPProxy.enableRemoteAudio(z16);
        if (enableRemoteAudio == 0) {
            if (z16) {
                i3 = 1;
            }
            this.mSelfMuteStat = i3;
            QMLog.i(TAG, "OpMute " + z16);
        } else {
            QMLog.e(TAG, "multiOperator null");
        }
        return enableRemoteAudio;
    }

    private UserModel removeUserModel(long j3) {
        Map<Long, UserModel> map = this.mRoomUserModelList;
        if (map != null) {
            return map.remove(Long.valueOf(j3));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchAudioRoute(int i3) {
        QMLog.d(TAG, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s", Integer.valueOf(i3), Boolean.valueOf(isHeadsetPlugged()), Boolean.valueOf(isBluetoothOn())));
        this.mVoIPProxy.setAudioRoute(i3);
    }

    private void updateUserModelList(List<VoIPProxy.MultiUserInfo> list) {
        EventListener eventListener;
        Set<Long> keySet = this.mRoomUserModelList.keySet();
        HashSet hashSet = new HashSet();
        Iterator<VoIPProxy.MultiUserInfo> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(it.next().mUin));
        }
        keySet.retainAll(hashSet);
        boolean z16 = false;
        for (VoIPProxy.MultiUserInfo multiUserInfo : list) {
            if (getUserModel(multiUserInfo.mUin) == null) {
                UserModel userModel = new UserModel();
                userModel.mUin = multiUserInfo.mUin;
                userModel.mOpenId = multiUserInfo.mOpenId;
                userModel.mMicStat = 1;
                putUserModel(userModel);
                z16 = true;
            }
        }
        if (z16 && (eventListener = this.mEventListener) != null) {
            eventListener.onRoomMemberChange(getRoomOpenIdList());
        }
    }

    public synchronized void exitRoom() {
        int i3 = this.mQAvRoomState.get();
        if (i3 != 1) {
            if (i3 == 2) {
                doExitRoom();
                this.mQAvRoomState.set(0);
            }
        } else {
            this.needExitRoomImmediatelyAfterEntering = true;
        }
    }

    public synchronized boolean isEarPhoneMute() {
        boolean z16;
        z16 = true;
        if (this.mSelfMuteStat != 1) {
            z16 = false;
        }
        return z16;
    }

    public boolean isInRoom() {
        if (this.mQAvRoomState.get() == 2) {
            return true;
        }
        return false;
    }

    public synchronized boolean isMicMute() {
        boolean z16;
        if (this.mSelfMicStat == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized void joinRoom(IdResult idResult, MuteConfig muteConfig, byte[] bArr, JoinRoomListener joinRoomListener) {
        if (this.mQAvRoomState.get() != 0) {
            QMLog.e(TAG, "\u4e0d\u80fd\u91cd\u590d\u8fdb\u623f");
            if (joinRoomListener != null) {
                joinRoomListener.onError(-3);
            }
            return;
        }
        exitRoom();
        if (!this.mQAvHasInitSDK) {
            if (isMicAvailable()) {
                qavInitSDK(idResult.tinyId);
                this.mQAvHasInitSDK = true;
            } else {
                if (joinRoomListener != null) {
                    joinRoomListener.onError(-2);
                }
                return;
            }
        }
        this.mJoinRoomListener = joinRoomListener;
        long j3 = idResult.tinyId;
        this.mSelfUin = j3;
        int joinRoom = this.mVoIPProxy.joinRoom(j3, idResult.roomId, idResult.openId, bArr);
        if (joinRoom == 0) {
            this.mMuteConfig = muteConfig;
            this.mQAvRoomState.set(1);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            MiniAppEnv.g().getContext().registerReceiver(this.mReceiver, intentFilter);
            this.mRoomUserModelList.clear();
        } else {
            QMLog.e(TAG, "joinRoom ret = " + joinRoom);
            JoinRoomListener joinRoomListener2 = this.mJoinRoomListener;
            if (joinRoomListener2 != null) {
                joinRoomListener2.onError(joinRoom);
                this.mJoinRoomListener = null;
            }
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.mEventListener = eventListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
    
        r3.onFail(-1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateMuteConfig(MuteConfig muteConfig, MuteConfigListener muteConfigListener) {
        boolean z16;
        if (!muteConfig.isMuteMicrophone) {
            z16 = true;
        } else {
            z16 = false;
        }
        int qavOpMic = qavOpMic(z16);
        int qavOpMute = qavOpMute(muteConfig.isMuteEarphone);
        if (qavOpMic == 0 && qavOpMute == 0) {
            if (muteConfigListener != null) {
                muteConfigListener.onSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchAudioRoute() {
        QMLog.d(TAG, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", Boolean.valueOf(isHeadsetPlugged()), Boolean.valueOf(isBluetoothOn())));
        if (isHeadsetPlugged()) {
            this.mVoIPProxy.setAudioRoute(0);
        } else if (isBluetoothOn()) {
            this.mVoIPProxy.setAudioRoute(2);
        } else {
            this.mVoIPProxy.setAudioRoute(1);
        }
    }
}
