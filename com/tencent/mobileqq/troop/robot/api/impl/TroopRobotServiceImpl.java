package com.tencent.mobileqq.troop.robot.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$RobotSubscribeCategory;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$UinRange;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.cg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import h44.OpenRobotProfileCardArgs;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x934.cmd0x934$ReqBody;
import tencent.im.oidb.cmd0x934.cmd0x934$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopRobotServiceImpl implements ITroopRobotService {
    private static final String COLUMN_ITEM = "barItem";
    private static final String COLUMN_UIN = "robotUin";
    private static final String KEY_END_UIN = "endUin";
    private static final String KEY_START_UIN = "startUin";
    private static final String KEY_UIN_RANGE = "key_robot_uin_range";
    public static final String TAG = "TroopRobotServiceImpl";
    private static final int UIN_RANGES_MAX = 1000;
    static Object sLock = new Object();
    protected AppRuntime mApp;
    protected WeakReference<ITroopRobotService.b> mOnTalkingChangeListener;
    protected List<ITroopRobotService.c> mUinRanges = new CopyOnWriteArrayList();
    protected List<String> mKeywords = new ArrayList(5);
    protected List<String> mStartWords = new ArrayList(5);
    protected List<String> mEndWords = new ArrayList(5);
    List<oidb_0x496$RobotSubscribeCategory> mCategories = new ArrayList();
    protected int mKeepOnTime = 60000;
    protected Handler mUIHandler = new Handler(Looper.getMainLooper());
    protected String mCurrentRobotUin = null;
    protected boolean mIsTalking = false;
    public String talkingRobotUin = null;
    public String talkingRobotUid = null;
    public String talkingNickname = null;
    public String talkingTroopUin = null;
    public String currentAtRobotUin = null;
    public String currentAtRobotUid = null;
    private HashMap<String, ArrayList<String>> mAioBarConfig = new HashMap<>();
    private String mUserTailFormat = "";
    private String mRobotTailFormat = "";
    private boolean mRobotSwitch = false;
    private String mRobotWarning = null;
    private final boolean mUinRangeMMKVSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("uin_range_mmkv_910", true);
    HashMap<String, Long> mSubscribeMsgs = new HashMap<>();
    protected ArrayList<String> mRobotRedListInShowed = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ITroopRobotService.a f298297d;

        b(ITroopRobotService.a aVar) {
            this.f298297d = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            cmd0x934$RspBody cmd0x934_rspbody = new cmd0x934$RspBody();
            if (i3 == 0 && bArr != null) {
                try {
                    cmd0x934_rspbody.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TroopRobotServiceImpl.TAG, 2, QLog.getStackTraceString(e16));
                    }
                }
            }
            this.f298297d.a(i3, cmd0x934_rspbody);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ITroopRobotService.a f298299d;

        c(ITroopRobotService.a aVar) {
            this.f298299d = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            cmd0x934$RspBody cmd0x934_rspbody = new cmd0x934$RspBody();
            if (i3 == 0 && bArr != null) {
                try {
                    cmd0x934_rspbody.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TroopRobotServiceImpl.TAG, 2, QLog.getStackTraceString(e16));
                    }
                }
            }
            this.f298299d.a(i3, cmd0x934_rspbody);
        }
    }

    private List<ITroopRobotService.c> getRobotUinRange() {
        ArrayList arrayList = new ArrayList();
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(KEY_UIN_RANGE, "");
        if (TextUtils.isEmpty(decodeString)) {
            QLog.e(TAG, 1, "getRobotUinRange isEmpty");
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(decodeString);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                ITroopRobotService.c cVar = new ITroopRobotService.c();
                cVar.f298293a = jSONObject.getLong(KEY_START_UIN);
                cVar.f298294b = jSONObject.getLong(KEY_END_UIN);
                arrayList.add(cVar);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "getRobotUinRange", e16);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasRobotUinRangeMMKV() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").containsKey(KEY_UIN_RANGE);
    }

    private void initRobotInRedList(AppRuntime appRuntime) {
        synchronized (sLock) {
            if (this.mRobotRedListInShowed == null) {
                QLog.d(TAG, 2, "initRobotRedInRedList ");
                ArrayList<String> newRobotListFromSp = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getNewRobotListFromSp(appRuntime);
                this.mRobotRedListInShowed = newRobotListFromSp;
                if (newRobotListFromSp == null) {
                    this.mRobotRedListInShowed = new ArrayList<>();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadConfigFromSP() {
        String robotAioBar = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getRobotAioBar(BaseApplication.getContext(), this.mApp.getCurrentAccountUin());
        if (!TextUtils.isEmpty(robotAioBar)) {
            try {
                JSONArray jSONArray = new JSONArray(robotAioBar);
                this.mAioBarConfig.clear();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString(COLUMN_UIN);
                        JSONArray optJSONArray = optJSONObject.optJSONArray(COLUMN_ITEM);
                        if (!TextUtils.isEmpty(optString) && optJSONArray != null) {
                            ArrayList<String> arrayList = new ArrayList<>(optJSONArray.length());
                            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                                arrayList.add(optJSONArray.optString(i16));
                            }
                            this.mAioBarConfig.put(optString, arrayList);
                        }
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        String robotVoiceTail = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getRobotVoiceTail(BaseApplication.getContext(), this.mApp.getCurrentAccountUin());
        if (!TextUtils.isEmpty(robotVoiceTail)) {
            try {
                JSONObject jSONObject = new JSONObject(robotVoiceTail);
                this.mUserTailFormat = jSONObject.optString("userTail");
                this.mRobotTailFormat = jSONObject.optString("robotTail");
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        bt2.b b16 = bt2.b.b();
        if (b16 != null) {
            updateConfig(b16.c(), b16.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRobotUinRangeMMKV(List<oidb_0x496$UinRange> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (oidb_0x496$UinRange oidb_0x496_uinrange : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(KEY_START_UIN, oidb_0x496_uinrange.start_uin.get());
                jSONObject.put(KEY_END_UIN, oidb_0x496_uinrange.end_uin.get());
                jSONArray.mo162put(jSONObject);
            }
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString(KEY_UIN_RANGE, jSONArray.toString());
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "setRobotUinRangeMMKV", e16);
        }
    }

    private void setTalking(boolean z16) {
        this.mIsTalking = z16;
        this.mUIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.troop.robot.api.impl.TroopRobotServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                ITroopRobotService.b bVar;
                WeakReference<ITroopRobotService.b> weakReference = TroopRobotServiceImpl.this.mOnTalkingChangeListener;
                if (weakReference != null && (bVar = weakReference.get()) != null) {
                    TroopRobotServiceImpl troopRobotServiceImpl = TroopRobotServiceImpl.this;
                    bVar.a(troopRobotServiceImpl.talkingTroopUin, troopRobotServiceImpl.talkingRobotUin, troopRobotServiceImpl.mIsTalking);
                }
            }
        });
    }

    private void syncCacheTimestamp(MessageRecord messageRecord, String str) {
        SharedPreferences sharedPreferences = this.mApp.getApp().getSharedPreferences("robot_subcribmsg_timestamp", 0);
        if (!this.mSubscribeMsgs.containsKey(str)) {
            this.mSubscribeMsgs.put(str, Long.valueOf(sharedPreferences.getLong(str, 0L)));
        } else {
            long max = Math.max(this.mSubscribeMsgs.get(str).longValue(), sharedPreferences.getLong(str, 0L));
            sharedPreferences.edit().putLong(str, max).commit();
            this.mSubscribeMsgs.put(str, Long.valueOf(max));
        }
        if (messageRecord.shmsgseq > this.mSubscribeMsgs.get(str).longValue()) {
            sharedPreferences.edit().putLong(str, messageRecord.shmsgseq).commit();
            this.mSubscribeMsgs.put(str, Long.valueOf(messageRecord.shmsgseq));
        }
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public boolean checkAndProcessJumpRobotPage(Context context, String str, long j3) {
        if (isRobotUin(j3)) {
            ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, String.valueOf(j3), str, 0, 0, null));
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void closeTalking() {
        this.talkingRobotUin = null;
        this.talkingRobotUid = null;
        this.talkingNickname = null;
        this.talkingTroopUin = null;
        setTalking(false);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void configRobotFromServer(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(AppConstants.Preferences.ROBOT_AIO_BAR);
        if (optJSONArray != null) {
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).updateRobotAioBar(BaseApplication.getContext(), this.mApp.getCurrentAccountUin(), optJSONArray.toString());
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(AppConstants.Preferences.ROBOT_VOICE_TAIL);
        if (optJSONObject != null) {
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).updateRobotVoiceTail(BaseApplication.getContext(), this.mApp.getCurrentAccountUin(), optJSONObject.toString());
        }
        loadConfigFromSP();
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public oidb_0x496$RobotSubscribeCategory findSubscribeCategory(int i3) {
        for (oidb_0x496$RobotSubscribeCategory oidb_0x496_robotsubscribecategory : this.mCategories) {
            if (oidb_0x496_robotsubscribecategory.f298093id.get() == i3) {
                return oidb_0x496_robotsubscribecategory;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public String generateMoreDetailMsg(MessageRecord messageRecord) {
        if (hasRobotNewsClassId(messageRecord)) {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(ITroopRobotService.ROBOT_SHORT_LINK_URL);
            String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr(ITroopRobotService.ROBOT_SHORT_LINK_DESCRIPTION);
            if (!TextUtils.isEmpty(extInfoFromExtStr) && !TextUtils.isEmpty(extInfoFromExtStr2)) {
                return extInfoFromExtStr2 + HardCodeUtil.qqStr(R.string.uq9);
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public String getMessageKey(MessageRecord messageRecord) {
        return messageRecord.frienduin + "_" + messageRecord.getExtInfoFromExtStr(ITroopRobotService.ROBOT_NEWS_CLASS_ID);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public String getRobotWarning() {
        return this.mRobotWarning;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public boolean hasNext(MessageRecord messageRecord) {
        if (!isRobotUin(messageRecord.senderuin)) {
            return false;
        }
        String messageKey = getMessageKey(messageRecord);
        if (TextUtils.isEmpty(messageKey)) {
            return false;
        }
        syncCacheTimestamp(messageRecord, messageKey);
        if (messageRecord.shmsgseq != this.mSubscribeMsgs.get(messageKey).longValue()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public boolean hasProcessedMoreDetail(MessageRecord messageRecord) {
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(ITroopRobotService.ROBOT_SHORT_LINK_PROCESSED);
        if (!TextUtils.isEmpty(extInfoFromExtStr) && extInfoFromExtStr.equals("true")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public boolean hasRobotNewsClassId(MessageRecord messageRecord) {
        return false;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public boolean isRobotSwichOn() {
        return this.mRobotSwitch;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public boolean isRobotUin(String str) {
        try {
            return isRobotUin(Long.valueOf(str).longValue());
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.e(TAG, 2, QLog.getStackTraceString(e16));
            return false;
        }
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public boolean isRobotUinNeedShowRed(AppRuntime appRuntime, String str, String str2) {
        boolean z16 = false;
        if (!((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getIfTheRightRoleInTroopShowRobotRedDot(appRuntime, str2)) {
            QLog.d(TAG, 2, "isRobotUinNeedShowRed RobotRed \uff1a" + str + " role not show red in troop:" + str2);
            return false;
        }
        initRobotInRedList(appRuntime);
        synchronized (sLock) {
            ArrayList<String> arrayList = this.mRobotRedListInShowed;
            if (arrayList != null && arrayList.contains(str)) {
                z16 = true;
            }
        }
        QLog.d(TAG, 2, "isRobotUinNeedShowRed RobotRed \uff1a" + str + " " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public boolean isTalking() {
        return this.mIsTalking;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        this.mStartWords.add(HardCodeUtil.qqStr(R.string.uqc));
        this.mEndWords.add(HardCodeUtil.qqStr(R.string.upz));
        if (this.mUinRangeMMKVSwitch) {
            this.mUinRanges.addAll(getRobotUinRange());
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.robot.api.impl.TroopRobotServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                oidb_0x496$Robot oidb_0x496_robot = new oidb_0x496$Robot();
                byte[] readRobotConfig = TroopRobotServiceImpl.this.readRobotConfig();
                if (readRobotConfig != null) {
                    try {
                        oidb_0x496_robot.mergeFrom(readRobotConfig);
                        TroopRobotServiceImpl.this.setRobotConfig(oidb_0x496_robot);
                        if (TroopRobotServiceImpl.this.mUinRangeMMKVSwitch && !TroopRobotServiceImpl.this.hasRobotUinRangeMMKV()) {
                            QLog.d(TroopRobotServiceImpl.TAG, 1, "init robotUin mmkv");
                            TroopRobotServiceImpl.this.setRobotUinRangeMMKV(oidb_0x496_robot.uin_range.get());
                        }
                    } catch (InvalidProtocolBufferMicroException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TroopRobotServiceImpl.TAG, 2, "file data error");
                        }
                    }
                }
                TroopRobotServiceImpl.this.loadConfigFromSP();
            }
        }, 5, null, true);
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).onCreate();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).onDestroy();
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void onGetRobotRedInfo(AppRuntime appRuntime, long j3, ArrayList<String> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetRobotRedInfo cacheTime" + j3);
        }
        initRobotInRedList(appRuntime);
        synchronized (sLock) {
            ArrayList<String> historyRobotListFromSp = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getHistoryRobotListFromSp(appRuntime);
            if (historyRobotListFromSp == null) {
                historyRobotListFromSp = new ArrayList<>();
            }
            if (arrayList != null && arrayList.size() != 0) {
                QLog.d(TAG, 2, "onGetRobotRedInfo historyList " + historyRobotListFromSp.size() + " uinList: " + arrayList.size() + " red:" + this.mRobotRedListInShowed.size());
                try {
                    for (int size = this.mRobotRedListInShowed.size() - 1; size >= 0; size--) {
                        String str = this.mRobotRedListInShowed.get(size);
                        if (!arrayList.contains(str)) {
                            this.mRobotRedListInShowed.remove(size);
                            QLog.d(TAG, 2, "onGetRobotRedInfo remove red newing " + str + " index: " + size);
                        }
                    }
                    for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                        String str2 = arrayList.get(size2);
                        if (historyRobotListFromSp.contains(str2)) {
                            arrayList.remove(size2);
                            QLog.d(TAG, 2, "onGetRobotRedInfo remove red uinList " + str2 + " index: " + size2);
                        } else {
                            historyRobotListFromSp.add(str2);
                        }
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        String str3 = arrayList.get(i3);
                        if (!this.mRobotRedListInShowed.contains(str3)) {
                            this.mRobotRedListInShowed.add(str3);
                            QLog.d(TAG, 2, "onGetRobotRedInfo add red uinList " + str3 + " index: " + i3);
                        }
                    }
                    ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setNewRobotListToSp(appRuntime, this.mRobotRedListInShowed);
                    ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setHistoryRobotListToSp(appRuntime, historyRobotListFromSp);
                    if (arrayList.size() > 0) {
                        ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setRobotItemRedShowed(appRuntime, true);
                        ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setNeedShowRobotRedDotAio(appRuntime, true);
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 2, "onGetRobotRedInfo REMOVE EXCEPTION" + e16.toString());
                }
                return;
            }
            this.mRobotRedListInShowed.clear();
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setNewRobotListToSp(appRuntime, this.mRobotRedListInShowed);
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setRobotItemRedShowed(appRuntime, false);
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setNeedShowRobotRedDotAio(appRuntime, false);
        }
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void preProcessMessageMoreDetail(MessageRecord messageRecord) {
        String group;
        int indexOf;
        if (!TextUtils.isEmpty(messageRecord.f203106msg)) {
            Matcher matcher = cg.f307525d.matcher(messageRecord.f203106msg);
            if (matcher.find() && (indexOf = messageRecord.f203106msg.indexOf((group = matcher.group(0)))) >= 0) {
                String substring = messageRecord.f203106msg.substring(0, indexOf);
                messageRecord.saveExtInfoToExtStr(ITroopRobotService.ROBOT_SHORT_LINK_URL, group);
                messageRecord.saveExtInfoToExtStr(ITroopRobotService.ROBOT_SHORT_LINK_DESCRIPTION, substring);
                messageRecord.saveExtInfoToExtStr(ITroopRobotService.ROBOT_SHORT_LINK_PROCESSED, "true");
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public byte[] readRobotConfig() {
        return FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath("troop_robot_config"));
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void release(String str, String str2, String str3) {
        if (this.talkingNickname != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    reqGrayTips(Long.parseLong(str), Long.parseLong(str2), str3, new a());
                } catch (Exception unused) {
                    QLog.e(TAG, 2, "release exception, troopuin:" + str + " robotuin:" + str2);
                }
            }
            closeTalking();
        }
        this.mUIHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void removeRobotUinInRed(AppRuntime appRuntime, String str) {
        initRobotInRedList(appRuntime);
        synchronized (sLock) {
            ArrayList<String> arrayList = this.mRobotRedListInShowed;
            if (arrayList != null && arrayList.contains(str)) {
                this.mRobotRedListInShowed.remove(str);
            }
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setNewRobotListToSp(appRuntime, this.mRobotRedListInShowed);
            QLog.d(TAG, 2, "removeRobotRedUinInRed " + str);
        }
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void report(String str, String str2, String str3, String str4, String str5, String str6) {
        ReportController.o(null, "dc00899", "Grp_robot", "", str, str2, 0, 0, str3, str4, str5, str6);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void reqGrayTips(long j3, String str, ITroopRobotService.a aVar) {
        reqGrayTipsInner(2, Long.valueOf("1").longValue(), j3, str, aVar);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void reqGrayTipsInner(int i3, long j3, long j16, String str, ITroopRobotService.a aVar) {
        cmd0x934$ReqBody cmd0x934_reqbody = new cmd0x934$ReqBody();
        cmd0x934_reqbody.cmd.set(i3, true);
        cmd0x934_reqbody.group_id.set(j3, true);
        cmd0x934_reqbody.keyword.set(str, true);
        cmd0x934_reqbody.robot_uin.set(j16);
        ProtoUtils.c(this.mApp, new c(aVar), cmd0x934_reqbody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void saveRobotConfig(final oidb_0x496$Robot oidb_0x496_robot) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.robot.api.impl.TroopRobotServiceImpl.4
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
            
                if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
            
                com.tencent.qphone.base.util.QLog.e(com.tencent.mobileqq.troop.robot.api.impl.TroopRobotServiceImpl.TAG, 2, com.tencent.qphone.base.util.QLog.getStackTraceString(r4));
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x004e, code lost:
            
                if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L23;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        fileOutputStream = BaseApplication.getContext().openFileOutput("troop_robot_config", 0);
                        fileOutputStream.write(oidb_0x496_robot.toByteArray());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        try {
                            fileOutputStream.close();
                        } catch (IOException e16) {
                            e = e16;
                        }
                    } catch (IOException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TroopRobotServiceImpl.TAG, 2, QLog.getStackTraceString(e17));
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                e = e18;
                            }
                        }
                    }
                    BaseApplication.getContext().getSharedPreferences("troop_robot_config", 0).edit().putInt("troop_robot_config_version", oidb_0x496_robot.version.get()).commit();
                    if (TroopRobotServiceImpl.this.mUinRangeMMKVSwitch) {
                        TroopRobotServiceImpl.this.setRobotUinRangeMMKV(oidb_0x496_robot.uin_range.get());
                    }
                } catch (Throwable th5) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TroopRobotServiceImpl.TAG, 2, QLog.getStackTraceString(e19));
                            }
                        }
                    }
                    throw th5;
                }
            }
        }, 5, null, true);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void sendContent(long j3, String str, ITroopRobotService.a aVar) {
        sendContent(Long.valueOf("1").longValue(), j3, str, aVar);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void sendContentInner(int i3, long j3, long j16, String str, ITroopRobotService.a aVar) {
        cmd0x934$ReqBody cmd0x934_reqbody = new cmd0x934$ReqBody();
        cmd0x934_reqbody.cmd.set(i3, true);
        cmd0x934_reqbody.group_id.set(j3, true);
        cmd0x934_reqbody.keyword.set(str, true);
        cmd0x934_reqbody.robot_uin.set(j16);
        ProtoUtils.c(this.mApp, new b(aVar), cmd0x934_reqbody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void setOnTalkingChangeListener(ITroopRobotService.b bVar) {
        if (bVar == null) {
            this.mOnTalkingChangeListener = null;
        } else {
            this.mOnTalkingChangeListener = new WeakReference<>(bVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void setRobotConfig(oidb_0x496$Robot oidb_0x496_robot) {
        if (oidb_0x496_robot.uin_range.has()) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < oidb_0x496_robot.uin_range.size() && i3 < 1000; i3++) {
                oidb_0x496$UinRange oidb_0x496_uinrange = oidb_0x496_robot.uin_range.get(i3);
                ITroopRobotService.c cVar = new ITroopRobotService.c();
                cVar.f298293a = oidb_0x496_uinrange.start_uin.get();
                cVar.f298294b = oidb_0x496_uinrange.end_uin.get();
                arrayList.add(cVar);
            }
            this.mUinRanges.clear();
            this.mUinRanges.addAll(arrayList);
            QLog.i(TAG, 1, "setRobotConfig " + this.mUinRanges.toString());
        }
        synchronized (this) {
            if (oidb_0x496_robot.fire_keywords.has()) {
                this.mKeywords.clear();
                for (int i16 = 0; i16 < oidb_0x496_robot.fire_keywords.size() && i16 < 5; i16++) {
                    this.mKeywords.add(oidb_0x496_robot.fire_keywords.get(i16));
                }
            }
            if (oidb_0x496_robot.start_keywords.has()) {
                this.mStartWords.clear();
                for (int i17 = 0; i17 < oidb_0x496_robot.start_keywords.size() && i17 < 5; i17++) {
                    this.mStartWords.add(oidb_0x496_robot.start_keywords.get(i17));
                }
            }
            if (oidb_0x496_robot.end_keywords.has()) {
                this.mEndWords.clear();
                for (int i18 = 0; i18 < oidb_0x496_robot.end_keywords.size() && i18 < 5; i18++) {
                    this.mEndWords.add(oidb_0x496_robot.end_keywords.get(i18));
                }
            }
            if (oidb_0x496_robot.session_timeout.has()) {
                this.mKeepOnTime = oidb_0x496_robot.session_timeout.get();
            }
            if (oidb_0x496_robot.subscribe_categories.has()) {
                this.mCategories.clear();
                this.mCategories.addAll(oidb_0x496_robot.subscribe_categories.get());
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void updateConfig(boolean z16, String str) {
        this.mRobotSwitch = z16;
        this.mRobotWarning = str;
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void reqGrayTips(long j3, long j16, String str, ITroopRobotService.a aVar) {
        reqGrayTipsInner(2, j3, j16, str, aVar);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public void sendContent(long j3, long j16, String str, ITroopRobotService.a aVar) {
        sendContentInner(3, j3, j16, str, aVar);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    public boolean isRobotUin(long j3) {
        for (ITroopRobotService.c cVar : this.mUinRanges) {
            if (cVar != null && j3 >= cVar.f298293a && j3 <= cVar.f298294b) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ITroopRobotService.a {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService.a
        public void a(int i3, cmd0x934$RspBody cmd0x934_rspbody) {
        }
    }
}
