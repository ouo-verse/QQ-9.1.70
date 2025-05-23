package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.anchor.room.an;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorHelperFastResume {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final int f270840b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f270841c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f270842d;

    /* renamed from: e, reason: collision with root package name */
    private static long f270843e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f270844a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends QQLiveAnchorRoomThirdPushBaseCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorRoom f270847d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IQQLiveAnchorRoomThirdPushCallback f270848e;

        a(QQLiveAnchorRoom qQLiveAnchorRoom, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
            this.f270847d = qQLiveAnchorRoom;
            this.f270848e = iQQLiveAnchorRoomThirdPushCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQLiveAnchorHelperFastResume.this, qQLiveAnchorRoom, iQQLiveAnchorRoomThirdPushCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorLiveStatusCallBack
        public void onAnchorLiveNetStatus(AnchorLiveSystemInfo anchorLiveSystemInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) anchorLiveSystemInfo);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
        public void onEnter(QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQLiveAnchorDataEnter);
                return;
            }
            if (!this.f270847d.isDestroyed() && !this.f270847d.isExitRoom()) {
                super.onEnter(qQLiveAnchorDataEnter);
                if (QLog.isColorLevel()) {
                    QLog.i("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "onEnter:" + qQLiveAnchorDataEnter.isSuccess);
                }
                if (qQLiveAnchorDataEnter.isSuccess) {
                    this.f270847d.startPublishStream();
                } else {
                    this.f270848e.onFastResumeResult(new QQLiveAnchorDataFastResume(qQLiveAnchorDataEnter));
                }
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomInit
        public void onInit(QQLiveAnchorDataInit qQLiveAnchorDataInit) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataInit);
                return;
            }
            if (!this.f270847d.isDestroyed() && !this.f270847d.isExitRoom()) {
                if (qQLiveAnchorDataInit.isSuccess) {
                    QQLiveAnchorHelperFastResume.this.r(this.f270847d, this.f270848e);
                } else {
                    this.f270848e.onFastResumeResult(new QQLiveAnchorDataFastResume(qQLiveAnchorDataInit));
                }
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPublish
        public void onPublishStream(QQLiveAnchorDataPublishStream qQLiveAnchorDataPublishStream) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQLiveAnchorDataPublishStream);
            } else {
                super.onPublishStream(qQLiveAnchorDataPublishStream);
                this.f270848e.onFastResumeResult(new QQLiveAnchorDataFastResume(qQLiveAnchorDataPublishStream));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
        public void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQLiveAnchorDataThirdPushCheck);
                return;
            }
            if (!this.f270847d.isDestroyed() && !this.f270847d.isExitRoom()) {
                if (QLog.isColorLevel()) {
                    QLog.i("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "onGetPullInfo:" + qQLiveAnchorDataThirdPushCheck.isSuccess);
                }
                if (qQLiveAnchorDataThirdPushCheck.isSuccess) {
                    this.f270847d.enterRoom();
                } else {
                    this.f270848e.onFastResumeResult(new QQLiveAnchorDataFastResume(qQLiveAnchorDataThirdPushCheck));
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f270840b = QQLiveAnchorStreamRecordType.CAMERA.ordinal();
        f270841c = QQLiveAnchorStreamRecordType.SCREEN.ordinal();
        f270842d = QQLiveAnchorStreamRecordType.THIRD_PUSH.ordinal();
        f270843e = 0L;
    }

    public QQLiveAnchorHelperFastResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270844a = false;
        }
    }

    static /* bridge */ /* synthetic */ SharedPreferences b() {
        return i();
    }

    private static boolean e(QQLiveAnchorRecord qQLiveAnchorRecord) {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        if (qQLiveAnchorRecord == null) {
            QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: record is null");
            return false;
        }
        if (qQLiveAnchorRecord.uid <= 0) {
            QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: uid <= 0");
            return false;
        }
        if (qQLiveAnchorRecord.roomId <= 0) {
            QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: roomId <= 0");
            return false;
        }
        if (TextUtils.isEmpty(qQLiveAnchorRecord.programId)) {
            QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: programId empty");
            return false;
        }
        if (qQLiveAnchorRecord.streamType == null) {
            QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: streamType is null");
            return false;
        }
        if (qQLiveAnchorRecord.enterRoomTime <= 0) {
            QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: enterRoomTime valid");
            return false;
        }
        if (qQLiveAnchorRecord.recordTime <= 0) {
            QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: time invalid, " + qQLiveAnchorRecord.recordTime);
            return false;
        }
        if (qQLiveAnchorRecord.lastHeartTime > 0 && System.currentTimeMillis() - qQLiveAnchorRecord.lastHeartTime < 120000) {
            QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo = qQLiveAnchorRecord.roomInfo;
            if (qQLiveAnchorRoomInfo != null && (qQLiveAnchorDataRoomInfo = qQLiveAnchorRoomInfo.roomData) != null) {
                if (qQLiveAnchorDataRoomInfo.f271212id == qQLiveAnchorRecord.roomId && TextUtils.equals(qQLiveAnchorDataRoomInfo.programId, qQLiveAnchorRecord.programId)) {
                    return true;
                }
                QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: id diff");
                return false;
            }
            QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: roomInfo or roomData is null ");
            return false;
        }
        QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "checkValid: lastHeartTime invalid, " + qQLiveAnchorRecord.lastHeartTime);
        return false;
    }

    public static IQQLiveAnchorRoom f(IQQLiveSDK iQQLiveSDK, QQLiveAnchorRecord qQLiveAnchorRecord, IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        IQQLiveAnchorRoom createRoom = iQQLiveSDK.getAnchorModule().createRoom(iQQLiveSDK.getAppRuntime().getApplicationContext(), qQLiveAnchorRecord.roomConfig, iQQLiveAnchorRoomCallback);
        QQLiveAnchorRoom qQLiveAnchorRoom = (QQLiveAnchorRoom) createRoom;
        qQLiveAnchorRoom.setAnchorRoomInfo(qQLiveAnchorRecord.roomInfo);
        qQLiveAnchorRoom.setAnchorRoomConfig(qQLiveAnchorRecord.roomConfig);
        qQLiveAnchorRoom.setEnterRoomTime(qQLiveAnchorRecord.enterRoomTime);
        return createRoom;
    }

    private static QQLiveAnchorStreamRecordType h(int i3) {
        if (i3 == f270840b) {
            return QQLiveAnchorStreamRecordType.CAMERA;
        }
        if (i3 == f270841c) {
            return QQLiveAnchorStreamRecordType.SCREEN;
        }
        if (i3 == f270842d) {
            return QQLiveAnchorStreamRecordType.THIRD_PUSH;
        }
        return null;
    }

    private static SharedPreferences i() {
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), "qqlive_fastresume_record", QMMKVFile.FILE_QQLIVE);
    }

    public static QQLiveAnchorRecord j(Context context, String str, String str2, IQQLiveSDK iQQLiveSDK) {
        m();
        SharedPreferences i3 = i();
        String string = i3.getString(l(str, str2), null);
        String string2 = i3.getString("anchor_record_heart_" + str2, null);
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            try {
                QQLiveAnchorRecord qQLiveAnchorRecord = new QQLiveAnchorRecord();
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(string, "UTF-8"));
                qQLiveAnchorRecord.uid = jSONObject.optLong("uid", 0L);
                qQLiveAnchorRecord.roomId = jSONObject.optLong("roomId", 0L);
                qQLiveAnchorRecord.programId = jSONObject.optString("programId", "");
                qQLiveAnchorRecord.streamType = h(jSONObject.optInt("streamType", -1));
                qQLiveAnchorRecord.recordTime = jSONObject.optLong("recordTime", 0L);
                qQLiveAnchorRecord.roomInfo = (QQLiveAnchorRoomInfo) new Gson().fromJson(jSONObject.optString("roomInfo", "{}"), QQLiveAnchorRoomInfo.class);
                qQLiveAnchorRecord.roomConfig = (QQLiveAnchorRoomConfig) new Gson().fromJson(jSONObject.optString("roomConfig", "{}"), QQLiveAnchorRoomConfig.class);
                qQLiveAnchorRecord.enterRoomTime = jSONObject.optLong("enterRoomTime", 0L);
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(string2, "UTF-8"));
                long optLong = jSONObject2.optLong("uid", 0L);
                long optLong2 = jSONObject2.optLong("roomId", 0L);
                String optString = jSONObject2.optString("programId", "");
                long optLong3 = jSONObject2.optLong("lastHeartTime", 0L);
                if (qQLiveAnchorRecord.uid == optLong && qQLiveAnchorRecord.roomId == optLong2 && TextUtils.equals(optString, qQLiveAnchorRecord.programId)) {
                    qQLiveAnchorRecord.lastHeartTime = optLong3;
                    if (e(qQLiveAnchorRecord)) {
                        q(iQQLiveSDK, true, false);
                        return qQLiveAnchorRecord;
                    }
                    q(iQQLiveSDK, true, true);
                    p(context, str, str2);
                    return null;
                }
                QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "heart info error");
                q(iQQLiveSDK, true, true);
                return null;
            } catch (Throwable th5) {
                QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "getRecord error: ", th5);
                return null;
            }
        }
        q(iQQLiveSDK, false, true);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(QQLiveAnchorRoom qQLiveAnchorRoom, long j3) {
        try {
            m();
            SharedPreferences i3 = i();
            QQLiveAnchorRoomInfo w3 = qQLiveAnchorRoom.w();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", w3.uid);
            jSONObject.put("roomId", w3.roomData.f271212id);
            jSONObject.put("programId", w3.roomData.programId);
            jSONObject.put("lastHeartTime", j3);
            i3.edit().putString("anchor_record_heart_" + qQLiveAnchorRoom.y().getCurrentUin(), URLEncoder.encode(jSONObject.toString(), "UTF-8")).apply();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, th5, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l(String str, String str2) {
        return "anchor_record_" + str2 + "_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        SharedPreferences i3 = i();
        if (i3.getBoolean("sp_key_has_migrate_qqlive_fastresume_record", false)) {
            return;
        }
        QMMKV.migrate(BaseApplication.getContext(), QMMKVFile.FILE_QQLIVE, BaseApplication.getContext().getSharedPreferences("qqlive_fastresume_record", 0));
        i3.edit().putBoolean("sp_key_has_migrate_qqlive_fastresume_record", true).apply();
    }

    public static void p(Context context, String str, String str2) {
        AegisLogger.i("Open_Live|FastResume|QQLiveAnchorHelperFastResume", "removeRecord", "appid=" + str);
        if (AegisLogger.isColorLevel()) {
            AegisLogger.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", "removeRecord", "appid=" + str + ", \u8fd9\u4e0d\u662f\u9519\u8bef\uff0c\u7070\u5ea6\u7248\u6765\u8ddf\u8e2a\u4e0b\u5230\u5e95\u8c01\u5220\u4e86\u8bb0\u5f55", new RuntimeException());
        }
        m();
        i().edit().remove(l(str, str2)).apply();
    }

    public static void q(IQQLiveSDK iQQLiveSDK, boolean z16, boolean z17) {
        if (z16 && iQQLiveSDK != null) {
            com.tencent.mobileqq.qqlive.report.h.c(iQQLiveSDK.getAppId(), "T_CATCH_IMPORTANT_INFO", QQLiveReportConstants.Scene.SCENE_EXCEPTION_ANCHOR_RECORD, null);
            return;
        }
        QLog.i("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "[reportFastResumeResult] no report, hasRecord=" + z16 + ", liveSDK=" + iQQLiveSDK);
    }

    public void g(QQLiveAnchorRoom qQLiveAnchorRoom, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQLiveAnchorRoom, (Object) iQQLiveAnchorRoomThirdPushCallback);
            return;
        }
        if (qQLiveAnchorRoom != null && iQQLiveAnchorRoomThirdPushCallback != null) {
            qQLiveAnchorRoom.registerAnchorCallback(new a(qQLiveAnchorRoom, iQQLiveAnchorRoomThirdPushCallback));
            if (qQLiveAnchorRoom.isInited()) {
                r(qQLiveAnchorRoom, iQQLiveAnchorRoomThirdPushCallback);
                return;
            }
            return;
        }
        QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "fastResume, something is null");
    }

    public void n(Context context, String str, QQLiveAnchorRoom qQLiveAnchorRoom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, qQLiveAnchorRoom);
            return;
        }
        AegisLogger.i("Open_Live|FastResume|QQLiveAnchorHelperFastResume", "recordAnchorRoomInfo", "appid=" + str);
        if (qQLiveAnchorRoom == null) {
            QLog.w("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "anchorRoom is null");
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable(qQLiveAnchorRoom, str) { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQLiveAnchorRoom f270845d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f270846e;

                {
                    this.f270845d = qQLiveAnchorRoom;
                    this.f270846e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQLiveAnchorHelperFastResume.this, qQLiveAnchorRoom, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int ordinal;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QQLiveAnchorHelperFastResume.m();
                        SharedPreferences b16 = QQLiveAnchorHelperFastResume.b();
                        JSONObject jSONObject = new JSONObject();
                        QQLiveAnchorRoomInfo w3 = this.f270845d.w();
                        if (w3 == null) {
                            QLog.w("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "originRoomInfo is null");
                            return;
                        }
                        try {
                            jSONObject.put("uid", w3.uid);
                            jSONObject.put("roomId", w3.roomData.f271212id);
                            jSONObject.put("programId", w3.roomData.programId);
                            if (this.f270845d.getRoomConfig() == null) {
                                ordinal = 0;
                            } else {
                                ordinal = this.f270845d.getRoomConfig().streamRecordType.ordinal();
                            }
                            jSONObject.put("streamType", ordinal);
                            jSONObject.put("recordTime", System.currentTimeMillis());
                            jSONObject.put("roomInfo", new Gson().toJson(w3));
                            jSONObject.put("roomConfig", new Gson().toJson(this.f270845d.getRoomConfig()));
                            jSONObject.put("enterRoomTime", this.f270845d.getEnterRoomTime());
                            b16.edit().putString(QQLiveAnchorHelperFastResume.l(this.f270846e, this.f270845d.y().getCurrentUin()), URLEncoder.encode(jSONObject.toString(), "UTF-8")).apply();
                            return;
                        } catch (Throwable th5) {
                            QLog.e("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "record err: ", th5);
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    public void o(Context context, final QQLiveAnchorRoom qQLiveAnchorRoom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) qQLiveAnchorRoom);
            return;
        }
        if (context != null && qQLiveAnchorRoom != null && !qQLiveAnchorRoom.isExitRoom() && !qQLiveAnchorRoom.isDestroyed()) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f270843e < 3000) {
                return;
            }
            f270843e = currentTimeMillis;
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAnchorHelperFastResume.k(QQLiveAnchorRoom.this, currentTimeMillis);
                }
            });
        }
    }

    public void r(QQLiveAnchorRoom qQLiveAnchorRoom, IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQLiveAnchorRoom, (Object) iQQLiveAnchorRoomThirdPushCallback);
            return;
        }
        if (qQLiveAnchorRoom.isDestroyed() || this.f270844a) {
            return;
        }
        synchronized (this) {
            if (this.f270844a) {
                return;
            }
            this.f270844a = true;
            iQQLiveAnchorRoomThirdPushCallback.onStartFastResume();
            if (QLog.isColorLevel()) {
                QLog.i("Open_Live|FastResume|QQLiveAnchorHelperFastResume", 1, "startAfterInited");
            }
            QQLiveAnchorRoomConfig roomConfig = qQLiveAnchorRoom.getRoomConfig();
            if (roomConfig != null && roomConfig.streamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH) {
                if (qQLiveAnchorRoom instanceof an) {
                    QQLiveAnchorAutoCheckPullPlayParams qQLiveAnchorAutoCheckPullPlayParams = new QQLiveAnchorAutoCheckPullPlayParams();
                    qQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay = true;
                    ((an) qQLiveAnchorRoom).getRtmpPullUrl(qQLiveAnchorAutoCheckPullPlayParams);
                }
            } else {
                qQLiveAnchorRoom.enterRoom();
            }
        }
    }
}
