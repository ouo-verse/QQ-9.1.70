package com.tencent.aelight.camera.ae.camera.core;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.camera.core.AEEditorGenerateBroadcastReceiver;
import com.tencent.aelight.camera.ae.camera.core.AEEditorUIBroadcastReceiver;
import com.tencent.aelight.camera.aebase.PeakService;
import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
import com.tencent.aelight.camera.api.IAEEditorUICallbackListener;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.export.j;
import com.tencent.mobileqq.wink.model.WinkEditorVideoInfo;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorManagerForQzone implements AEEditorGenerateBroadcastReceiver.AEEditorGenerateListener, AEEditorUIBroadcastReceiver.AEEditorUIListener {
    private final String TAG = "AEEditorManagerForQzone";
    private AEEditorGenerateBroadcastReceiver mAEEditorGenerateBroadcastReceiver = new AEEditorGenerateBroadcastReceiver(this);
    private AEEditorUIBroadcastReceiver mAEEditorUIBroadcastReceiver = new AEEditorUIBroadcastReceiver(this);
    private List<IAEEditorGenerateResultListener> mListenerList = new CopyOnWriteArrayList();
    private Map<String, LocalMediaInfo> mMissionStatus = new ConcurrentHashMap();
    private List<IAEEditorUICallbackListener> mUICallBackListener = new CopyOnWriteArrayList();
    private ServiceConnection mServiceConnection = null;
    private volatile boolean mPeakServiceBinded = false;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class InstanceHolder {
        static final AEEditorManagerForQzone INSTANCE = new AEEditorManagerForQzone();

        InstanceHolder() {
        }
    }

    AEEditorManagerForQzone() {
    }

    private void bindPeakService() {
        ms.a.f("AEEditorManagerForQzone", "bindPeakService");
        QzoneConfig.getInstance();
        if (QzoneConfig.isBindPeakServiceEnable() && !this.mPeakServiceBinded) {
            if (this.mServiceConnection == null) {
                this.mServiceConnection = new ServiceConnection() { // from class: com.tencent.aelight.camera.ae.camera.core.AEEditorManagerForQzone.1
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        ms.a.f("AEEditorManagerForQzone", "QFSBoxProgressPart onServiceConnected");
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        ms.a.f("AEEditorManagerForQzone", "QFSBoxProgressPart onServiceDisconnected");
                    }
                };
            }
            BaseApplicationImpl.getApplication().bindService(new Intent(BaseApplicationImpl.getApplication(), (Class<?>) PeakService.class), this.mServiceConnection, 1);
            this.mPeakServiceBinded = true;
        }
    }

    public static AEEditorManagerForQzone getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void sendBroadCast(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra(AEEditorConstants.GENERATE_MISSION, str2);
            BaseApplication.getContext().sendBroadcast(intent);
            return;
        }
        ms.a.c("AEEditorManagerForQzone", "[sendBroadCast] action or missionID is null");
    }

    private void unBindPeakService() {
        ms.a.f("AEEditorManagerForQzone", "unBindPeakService");
        if (this.mServiceConnection == null || !this.mPeakServiceBinded) {
            return;
        }
        try {
            BaseApplicationImpl.getApplication().unbindService(this.mServiceConnection);
            this.mPeakServiceBinded = false;
        } catch (Exception e16) {
            ms.a.e("AEEditorManagerForQzone", e16);
        }
    }

    public void addListener(IAEEditorGenerateResultListener iAEEditorGenerateResultListener) {
        ms.a.f("AEEditorManagerForQzone", "[addListener]");
        if (iAEEditorGenerateResultListener == null || this.mListenerList.contains(iAEEditorGenerateResultListener)) {
            return;
        }
        this.mListenerList.add(iAEEditorGenerateResultListener);
    }

    public void addUICallbackListener(IAEEditorUICallbackListener iAEEditorUICallbackListener) {
        ms.a.f("AEEditorManagerForQzone", "[addUICallbackListener]");
        if (iAEEditorUICallbackListener == null || this.mUICallBackListener.contains(iAEEditorUICallbackListener)) {
            return;
        }
        this.mUICallBackListener.add(iAEEditorUICallbackListener);
    }

    @Deprecated
    public void cancelMission(String str) {
        ms.a.f("AEEditorManagerForQzone", "[cancel]");
        sendBroadCast(AEEditorConstants.AEEDITOR_ORDER_CANCEL, str);
    }

    public void cancelQFSMission(String str) {
        ms.a.f("AEEditorManagerForQzone", "[cancel]");
        clearMissionInfo(str);
        sendBroadCast(AEEditorConstants.AEEDITOR_ORDER_QFS_CANCEL, str);
        j.t().i();
    }

    public void clean() {
        ms.a.f("AEEditorManagerForQzone", "[clean]");
        this.mAEEditorGenerateBroadcastReceiver.unRegisterSelf(BaseApplication.getContext());
        this.mAEEditorUIBroadcastReceiver.unRegisterSelf(BaseApplication.getContext());
    }

    public void clearMissionInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMissionStatus.remove(str);
    }

    public void composeVideo(String str, int i3, int i16, int i17, String str2) {
        ms.a.f("AEEditorManagerForQzone", "[retry]forceQFSMissionV2");
        Intent intent = new Intent(BaseApplicationImpl.getApplication(), (Class<?>) PeakService.class);
        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 10);
        intent.putExtra(AEEditorConstants.GENERATE_MISSION, str);
        intent.putExtra(AEEditorConstants.VIDEO_RESOLUTION, i3);
        intent.putExtra(AEEditorConstants.VIDEO_BITRATE, i16);
        intent.putExtra(AEEditorConstants.VIDEO_FRAMERATE, i17);
        intent.putExtra(AEEditorConstants.VIDEO_OUTPUT_PATH, str2);
        BaseApplicationImpl.getApplication().startService(intent);
        bindPeakService();
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AEEditorUIBroadcastReceiver.AEEditorUIListener
    public void deteleMedia(int i3) {
        Iterator<IAEEditorUICallbackListener> it = this.mUICallBackListener.iterator();
        while (it.hasNext()) {
            it.next().deleteMedia(i3);
        }
    }

    public void forceQFSMission(String str) {
        ms.a.f("AEEditorManagerForQzone", "[retry]forceQFSMission");
        Intent intent = new Intent(BaseApplicationImpl.getApplication(), (Class<?>) PeakService.class);
        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 9);
        intent.putExtra(AEEditorConstants.GENERATE_MISSION, str);
        BaseApplicationImpl.getApplication().startService(intent);
        bindPeakService();
    }

    public LocalMediaInfo getMissionInfo(String str) {
        LocalMediaInfo localMediaInfo = this.mMissionStatus.get(str);
        if (localMediaInfo != null) {
            return localMediaInfo;
        }
        return null;
    }

    public void init() {
        ms.a.f("AEEditorManagerForQzone", "[init]");
        this.mAEEditorGenerateBroadcastReceiver.registerSelf(BaseApplication.getContext());
        this.mAEEditorUIBroadcastReceiver.registerSelf(BaseApplication.getContext());
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AEEditorGenerateBroadcastReceiver.AEEditorGenerateListener
    public void onAETavSessionExportCompleted(WinkEditorVideoInfo winkEditorVideoInfo) {
        if (winkEditorVideoInfo == null) {
            ms.a.c("AEEditorManagerForQzone", "[onAETavSessionExportCompleted] winkEditorVideoInfo == null");
            return;
        }
        if (TextUtils.isEmpty(winkEditorVideoInfo.missionID)) {
            ms.a.c("AEEditorManagerForQzone", "[onAETavSessionExportCompleted] mission is null");
            return;
        }
        LocalMediaInfo b16 = er.b.b(winkEditorVideoInfo);
        if (b16 == null) {
            onAETavSessionExportError(winkEditorVideoInfo.missionID, -4L, "");
            return;
        }
        com.tencent.aelight.camera.ae.report.b.b().E(b16);
        this.mMissionStatus.put(winkEditorVideoInfo.missionID, b16);
        List<IAEEditorGenerateResultListener> list = this.mListenerList;
        if (list == null || list.size() == 0) {
            ms.a.c("AEEditorManagerForQzone", "[onAETavSessionExportCompleted] mListenerList is null");
        }
        Iterator<IAEEditorGenerateResultListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().onAETavSessionExportCompleted(winkEditorVideoInfo.missionID, b16);
        }
        unBindPeakService();
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AEEditorGenerateBroadcastReceiver.AEEditorGenerateListener
    public void onAETavSessionExportError(String str, long j3, String str2) {
        if (TextUtils.isEmpty(str)) {
            ms.a.c("AEEditorManagerForQzone", "[onAETavSessionExportError] mission is null");
            return;
        }
        LocalMediaInfo localMediaInfo = this.mMissionStatus.get(str);
        if (localMediaInfo == null) {
            this.mMissionStatus.put(str, er.b.a(null, "", 0, 0, null, null, str));
        } else {
            localMediaInfo.isVideoReady = false;
        }
        Iterator<IAEEditorGenerateResultListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().onAETavSessionExportError(str, j3, str2);
        }
        unBindPeakService();
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AEEditorGenerateBroadcastReceiver.AEEditorGenerateListener
    public void onAETavSessionExporting(WinkEditorVideoInfo winkEditorVideoInfo) {
        LocalMediaInfo localMediaInfo = getLocalMediaInfo(winkEditorVideoInfo);
        if (localMediaInfo == null) {
            ms.a.c("AEEditorManagerForQzone", "[onAETavSessionExporting] localMediaInfo == null");
            return;
        }
        Iterator<IAEEditorGenerateResultListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().onAETavSessionExporting(winkEditorVideoInfo.missionID, winkEditorVideoInfo.progress, localMediaInfo, winkEditorVideoInfo.predictTime);
        }
    }

    public void removeAllListener() {
        ms.a.f("AEEditorManagerForQzone", "[removeAllListener]");
        this.mListenerList.clear();
        this.mUICallBackListener.clear();
    }

    public void removeCallbackListener(IAEEditorUICallbackListener iAEEditorUICallbackListener) {
        ms.a.f("AEEditorManagerForQzone", "[removeCallbackListener]");
        if (iAEEditorUICallbackListener == null || !this.mUICallBackListener.contains(iAEEditorUICallbackListener)) {
            return;
        }
        this.mUICallBackListener.remove(iAEEditorUICallbackListener);
    }

    public void removeListener(IAEEditorGenerateResultListener iAEEditorGenerateResultListener) {
        ms.a.f("AEEditorManagerForQzone", "[removeListener]");
        if (iAEEditorGenerateResultListener == null || !this.mListenerList.contains(iAEEditorGenerateResultListener)) {
            return;
        }
        this.mListenerList.remove(iAEEditorGenerateResultListener);
    }

    public void retryMission(String str) {
        ms.a.f("AEEditorManagerForQzone", "[retry]");
        Intent intent = new Intent(BaseApplicationImpl.getApplication(), (Class<?>) PeakService.class);
        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 4);
        intent.putExtra(AEEditorConstants.GENERATE_MISSION, str);
        BaseApplicationImpl.getApplication().startService(intent);
    }

    public void retryQFSMission(String str) {
        ms.a.f("AEEditorManagerForQzone", "[retry]retryQFSMission");
        Intent intent = new Intent(BaseApplicationImpl.getApplication(), (Class<?>) PeakService.class);
        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 7);
        intent.putExtra(AEEditorConstants.GENERATE_MISSION, str);
        BaseApplicationImpl.getApplication().startService(intent);
        bindPeakService();
    }

    public void saveMission(String str) {
        ms.a.f("AEEditorManagerForQzone", "[save]");
        sendBroadCast(AEEditorConstants.AEEDITOR_ORDER_SAVE, str);
    }

    private LocalMediaInfo getLocalMediaInfo(WinkEditorVideoInfo winkEditorVideoInfo) {
        if (winkEditorVideoInfo != null && !TextUtils.isEmpty(winkEditorVideoInfo.missionID)) {
            LocalMediaInfo localMediaInfo = this.mMissionStatus.get(winkEditorVideoInfo.missionID);
            if (localMediaInfo == null && (localMediaInfo = er.b.b(winkEditorVideoInfo)) == null) {
                ms.a.c("AEEditorManagerForQzone", "[getLocalMediaInfo] localMediaInfo == null");
                return null;
            }
            localMediaInfo.isVideoReady = false;
            this.mMissionStatus.put(winkEditorVideoInfo.missionID, localMediaInfo);
            return localMediaInfo;
        }
        ms.a.c("AEEditorManagerForQzone", "[getLocalMediaInfo] winkEditorVideoInfo == null || mission is null");
        return null;
    }
}
