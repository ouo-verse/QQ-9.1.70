package com.tencent.mobileqq.qqlive.anchor.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.datareport.StatisticData;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.utils.e;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import ft3.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f270761l;

    /* renamed from: a, reason: collision with root package name */
    private IDataReportModule f270762a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f270763b;

    /* renamed from: c, reason: collision with root package name */
    private QQLiveAnchorRoom f270764c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f270765d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f270766e;

    /* renamed from: f, reason: collision with root package name */
    private long f270767f;

    /* renamed from: g, reason: collision with root package name */
    private String f270768g;

    /* renamed from: h, reason: collision with root package name */
    private int f270769h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f270770i;

    /* renamed from: j, reason: collision with root package name */
    private long f270771j;

    /* renamed from: k, reason: collision with root package name */
    private IQQLiveAnchorRoomThirdPushCallback f270772k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class C8352a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f270773a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52597);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[QQLiveAnchorStreamRecordType.values().length];
            f270773a = iArr;
            try {
                iArr[QQLiveAnchorStreamRecordType.SCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f270773a[QQLiveAnchorStreamRecordType.THIRD_PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f270773a[QQLiveAnchorStreamRecordType.CAMERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b extends QQLiveAnchorRoomThirdPushBaseCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private a f270774d;

        public b(@NonNull a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else {
                this.f270774d = aVar;
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
        public void onEnter(QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQLiveAnchorDataEnter);
                return;
            }
            if (qQLiveAnchorDataEnter == null) {
                this.f270774d.f(false, null);
            } else if (qQLiveAnchorDataEnter.isSuccess) {
                this.f270774d.f(true, null);
            } else {
                this.f270774d.f(false, qQLiveAnchorDataEnter.errorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onPrepare(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataPrepare);
                return;
            }
            if (qQLiveAnchorDataPrepare == null) {
                this.f270774d.p(false, null);
            } else if (qQLiveAnchorDataPrepare.isSuccess) {
                this.f270774d.p(true, null);
            } else {
                this.f270774d.p(false, qQLiveAnchorDataPrepare.errorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPublish
        public void onPublishStream(QQLiveAnchorDataPublishStream qQLiveAnchorDataPublishStream) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQLiveAnchorDataPublishStream);
                return;
            }
            if (qQLiveAnchorDataPublishStream == null) {
                this.f270774d.r(false, null);
            } else if (qQLiveAnchorDataPublishStream.isSuccess) {
                this.f270774d.r(true, null);
            } else {
                this.f270774d.r(false, qQLiveAnchorDataPublishStream.errorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream
        public void onScreenCapturePause(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
            } else {
                super.onScreenCapturePause(i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream
        public void onScreenCaptureStarted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                super.onScreenCaptureStarted();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
        public void onSet(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQLiveAnchorDataSet);
                return;
            }
            if (qQLiveAnchorDataSet == null) {
                this.f270774d.y(false, null);
            } else if (qQLiveAnchorDataSet.isSuccess) {
                this.f270774d.y(true, null);
            } else {
                this.f270774d.y(false, qQLiveAnchorDataSet.errorMsg);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
        public void onStartEnter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.f270774d.g();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
        public void onStartPrepare() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f270774d.q();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPublish
        public void onStartPublishStream() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                this.f270774d.s();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback, com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
        public void onStartSet() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f270774d.B();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            f270761l = new ConcurrentHashMap<>();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f270763b = false;
        this.f270765d = false;
        this.f270766e = false;
        this.f270767f = System.currentTimeMillis();
        this.f270768g = null;
        this.f270769h = -1;
        this.f270771j = 0L;
        this.f270772k = new b(this);
    }

    private void A(BaseRoomInfo baseRoomInfo) {
        if (!this.f270763b && baseRoomInfo != null) {
            try {
                IDataReportModule iDataReportModule = this.f270762a;
                if (iDataReportModule != null) {
                    iDataReportModule.setRoomInfo(baseRoomInfo);
                }
                this.f270766e = true;
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
            }
        }
    }

    private void a() {
        if (this.f270765d) {
            return;
        }
        try {
            z(this.f270764c.v().getLoginModule().getLoginInfo());
        } catch (Throwable unused) {
            this.f270770i = true;
        }
    }

    private void b() {
        if (this.f270766e) {
            return;
        }
        try {
            A(this.f270764c.getRoomInfo());
        } catch (Throwable unused) {
            this.f270770i = true;
        }
    }

    private void c() {
        QQLiveAnchorRoom qQLiveAnchorRoom;
        if (this.f270768g == null && (qQLiveAnchorRoom = this.f270764c) != null) {
            try {
                BaseRoomInfo roomInfo = qQLiveAnchorRoom.getRoomInfo();
                if (roomInfo == null) {
                    QLog.w("QQLiveAnchor_techReport", 1, "roomInfo == null");
                    return;
                }
                long roomId = roomInfo.getRoomId();
                String programId = roomInfo.getProgramId();
                if (roomId > 0 && !TextUtils.isEmpty(programId)) {
                    this.f270768g = roomId + "_" + programId + "_" + this.f270767f;
                    return;
                }
                QLog.w("QQLiveAnchor_techReport", 1, "roomId <= 0 || TextUtils.isEmpty(programId)");
            } catch (Throwable unused) {
                this.f270770i = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:3:0x000a, B:6:0x0026, B:10:0x0059, B:14:0x0070, B:15:0x0074, B:19:0x0080, B:20:0x0084, B:23:0x0090, B:26:0x009c, B:30:0x009a, B:31:0x008e, B:34:0x004f), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:3:0x000a, B:6:0x0026, B:10:0x0059, B:14:0x0070, B:15:0x0074, B:19:0x0080, B:20:0x0084, B:23:0x0090, B:26:0x009c, B:30:0x009a, B:31:0x008e, B:34:0x004f), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c d(String str, boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        int i3;
        String currentUin;
        int i16;
        String str2;
        c();
        b();
        a();
        try {
            c addKeyValue = this.f270762a.newReportTask().a(str).addKeyValue("sequenceId", this.f270768g);
            int i17 = 0;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            c addKeyValue2 = addKeyValue.addKeyValue("result", i3).addKeyValue(DKEngine.GlobalKey.NET_WORK_TYPE, NetworkUtil.getNetWorkType()).addKeyValue("sdkVersion", "1.0.0");
            String str3 = "";
            if (this.f270764c.y() == null) {
                currentUin = "";
            } else {
                currentUin = this.f270764c.y().getCurrentUin();
            }
            c addKeyValue3 = addKeyValue2.addKeyValue("qqUin", currentUin).addKeyValue("liveType", k());
            if (!z16 && qQLiveErrorMsg != null) {
                i16 = qQLiveErrorMsg.bizErrCode;
                c addKeyValue4 = addKeyValue3.addKeyValue("errCode", i16);
                if (!z16 && qQLiveErrorMsg != null) {
                    str2 = qQLiveErrorMsg.bizErrMsg;
                    c addKeyValue5 = addKeyValue4.addKeyValue("errMsg", str2);
                    if (qQLiveErrorMsg == null) {
                        i17 = qQLiveErrorMsg.originErrCode;
                    }
                    c addKeyValue6 = addKeyValue5.addKeyValue("originErrCode", i17);
                    if (qQLiveErrorMsg == null) {
                        str3 = qQLiveErrorMsg.originErrMsg;
                    }
                    return addKeyValue6.addKeyValue("originErrMsg", str3);
                }
                str2 = "";
                c addKeyValue52 = addKeyValue4.addKeyValue("errMsg", str2);
                if (qQLiveErrorMsg == null) {
                }
                c addKeyValue62 = addKeyValue52.addKeyValue("originErrCode", i17);
                if (qQLiveErrorMsg == null) {
                }
                return addKeyValue62.addKeyValue("originErrMsg", str3);
            }
            i16 = 0;
            c addKeyValue42 = addKeyValue3.addKeyValue("errCode", i16);
            if (!z16) {
                str2 = qQLiveErrorMsg.bizErrMsg;
                c addKeyValue522 = addKeyValue42.addKeyValue("errMsg", str2);
                if (qQLiveErrorMsg == null) {
                }
                c addKeyValue622 = addKeyValue522.addKeyValue("originErrCode", i17);
                if (qQLiveErrorMsg == null) {
                }
                return addKeyValue622.addKeyValue("originErrMsg", str3);
            }
            str2 = "";
            c addKeyValue5222 = addKeyValue42.addKeyValue("errMsg", str2);
            if (qQLiveErrorMsg == null) {
            }
            c addKeyValue6222 = addKeyValue5222.addKeyValue("originErrCode", i17);
            if (qQLiveErrorMsg == null) {
            }
            return addKeyValue6222.addKeyValue("originErrMsg", str3);
        } catch (Throwable unused) {
            this.f270770i = true;
            return null;
        }
    }

    private void j(c cVar, StatisticData.LocalStatisticsData localStatisticsData) {
        if (cVar != null && localStatisticsData != null) {
            int i3 = localStatisticsData.streamType;
            if (i3 != 0 && i3 != 1 && i3 != 2) {
                return;
            }
            cVar.addKeyValue("audioBitrate_" + i3, localStatisticsData.audioBitrate).addKeyValue("audioCaptureState_" + i3, localStatisticsData.audioCaptureState).addKeyValue("audioSampleRate_" + i3, localStatisticsData.audioSampleRate).addKeyValue("videoBitrate_" + i3, localStatisticsData.videoBitrate).addKeyValue("frameRate_" + i3, localStatisticsData.frameRate).addKeyValue("height_" + i3, localStatisticsData.height).addKeyValue("width_" + i3, localStatisticsData.width);
        }
    }

    private int k() {
        int i3 = this.f270769h;
        if (i3 != -1) {
            return i3;
        }
        QQLiveAnchorRoom qQLiveAnchorRoom = this.f270764c;
        if (qQLiveAnchorRoom == null) {
            this.f270770i = true;
            return i3;
        }
        try {
            int i16 = C8352a.f270773a[qQLiveAnchorRoom.getRoomConfig().streamRecordType.ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        this.f270769h = 0;
                    }
                } else {
                    this.f270769h = 2;
                }
            } else {
                this.f270769h = 1;
            }
        } catch (Throwable unused) {
            this.f270770i = true;
        }
        return this.f270769h;
    }

    private long l(String str) {
        try {
            return f270761l.get(str).longValue();
        } catch (Throwable unused) {
            this.f270770i = true;
            return 0L;
        }
    }

    private void u(String str) {
        f270761l.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    private void z(LoginInfo loginInfo) {
        if (!this.f270763b && loginInfo != null) {
            try {
                IDataReportModule iDataReportModule = this.f270762a;
                if (iDataReportModule != null) {
                    iDataReportModule.setLoginInfo(loginInfo);
                }
                this.f270765d = true;
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
            }
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (this.f270763b) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_techReport", 1, "setStart");
            }
            u("time_set_start");
        }
    }

    public void C(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), qQLiveErrorMsg);
            return;
        }
        if (this.f270763b) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_techReport", 1, "stopPushEnd");
        }
        u("time_stop_push_end");
        try {
            d("anchor_room_push_end", z16, qQLiveErrorMsg).addKeyValue("duration", l("time_stop_push_end") - l("time_stop_push_start")).send();
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
        }
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            if (this.f270763b) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_techReport", 1, "stopPushStart");
            }
            u("time_stop_push_start");
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.f270763b = true;
        try {
            QQLiveAnchorRoom qQLiveAnchorRoom = this.f270764c;
            if (qQLiveAnchorRoom != null) {
                qQLiveAnchorRoom.unRegisterAnchorCallback(this.f270772k);
            }
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
        }
        this.f270764c = null;
        this.f270762a = null;
        f270761l.clear();
    }

    public void f(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), qQLiveErrorMsg);
            return;
        }
        if (this.f270763b) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_techReport", 1, "enterRoomEnd");
        }
        try {
            u("time_enter_end");
            d("anchor_room_enter", z16, qQLiveErrorMsg).addKeyValue("duration", l("time_enter_end") - l("time_enter_start")).addKeyValue("enterRoomTime", l("time_enter_start")).send();
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (this.f270763b) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_techReport", 1, "enterRoomStart");
            }
            u("time_enter_start");
        }
    }

    public void h(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), qQLiveErrorMsg);
            return;
        }
        if (this.f270763b) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_techReport", 1, "exitRoom");
        }
        try {
            u("time_exit_end");
            d("anchor_room_exit", z16, qQLiveErrorMsg).addKeyValue("duration", l("time_exit_end") - l("time_exit_start")).send();
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            if (this.f270763b) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_techReport", 1, "exitRoomStart");
            }
            u("time_exit_start");
        }
    }

    public void m(QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) qQLiveErrorMsg);
        } else {
            if (this.f270763b) {
                return;
            }
            try {
                d("anchor_room_heart", false, qQLiveErrorMsg).send();
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
            }
        }
    }

    public void n(QQLiveAnchorRoom qQLiveAnchorRoom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorRoom);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_techReport", 1, "init, " + this.f270770i);
        }
        try {
            this.f270764c = qQLiveAnchorRoom;
            this.f270762a = qQLiveAnchorRoom.v().getDataReportModule();
            this.f270764c.registerAnchorCallback(this.f270772k);
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
        }
    }

    public void o(QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) qQLiveErrorMsg);
        } else {
            if (this.f270763b) {
                return;
            }
            try {
                d("anchor_room_pull_stream", false, qQLiveErrorMsg).send();
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
            }
        }
    }

    public void p(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), qQLiveErrorMsg);
            return;
        }
        if (this.f270763b) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_techReport", 1, "prepareEnd");
        }
        u("time_prepare_end");
        try {
            d("anchor_room_prepare", z16, qQLiveErrorMsg).addKeyValue("duration", l("time_prepare_end") - l("time_prepare_start")).addKeyValue("machineId", e.a()).send();
        } catch (Throwable th5) {
            QLog.d("QQLiveAnchor_techReport", 1, th5, new Object[0]);
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (this.f270763b) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_techReport", 1, "prepareStart");
            }
            u("time_prepare_start");
        }
    }

    public void r(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), qQLiveErrorMsg);
            return;
        }
        if (this.f270763b) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_techReport", 1, "publishStreamEnd");
        }
        try {
            u("time_publish_end");
            d("anchor_room_push_begin", z16, qQLiveErrorMsg).addKeyValue("duration", l("time_publish_end") - l("time_publish_start")).send();
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_techReport", 1, th5, new Object[0]);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (this.f270763b) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_techReport", 1, "publishStreamStart");
            }
            u("time_publish_start");
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            if (this.f270763b) {
                return;
            }
            u("time_trtc_enter_room_start");
        }
    }

    public void v(StatisticData statisticData) {
        TRTCVideoQualityParams videoQuality;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) statisticData);
            return;
        }
        if (!this.f270763b && statisticData != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f270771j < 3000) {
                return;
            }
            this.f270771j = currentTimeMillis;
            try {
                IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f270764c;
                if (!(iQQLiveAnchorRoom instanceof IQQLiveAnchorTRTCRoom) || (videoQuality = ((IQQLiveAnchorTRTCRoom) iQQLiveAnchorRoom).getVideoQuality()) == null) {
                    return;
                }
                c addKeyValue = d("anchor_quality_statictis", true, null).addKeyValue("fps", videoQuality.getVideoFps()).addKeyValue("bitrate", videoQuality.getVideoBitRate()).addKeyValue("resolution", videoQuality.getVideoResolution()).addKeyValue("resolutionMode", videoQuality.getVideoResolutionMode()).addKeyValue("appCpu", statisticData.appCpu).addKeyValue("systemCpu", statisticData.systemCpu).addKeyValue("rtt", statisticData.rtt).addKeyValue("upLoss", statisticData.upLoss).addKeyValue("downLoss", statisticData.downLoss).addKeyValue("sendBytes", statisticData.sendBytes).addKeyValue("receiveBytes", statisticData.receiveBytes);
                ArrayList<StatisticData.LocalStatisticsData> arrayList = statisticData.localArray;
                if (arrayList != null && arrayList.size() != 0) {
                    Iterator<StatisticData.LocalStatisticsData> it = statisticData.localArray.iterator();
                    while (it.hasNext()) {
                        j(addKeyValue, it.next());
                    }
                }
                addKeyValue.send();
            } catch (Throwable unused) {
                this.f270770i = true;
            }
        }
    }

    public void w(long j3, String str) {
        QQLiveErrorMsg qQLiveErrorMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), str);
            return;
        }
        if (this.f270763b) {
            return;
        }
        u("time_trtc_enter_room_end");
        if (j3 != 0) {
            try {
                qQLiveErrorMsg = new QQLiveErrorMsg();
                qQLiveErrorMsg.bizModule = 2;
                qQLiveErrorMsg.bizErrCode = 6106;
                qQLiveErrorMsg.bizErrMsg = "trtc error";
                qQLiveErrorMsg.originErrCode = (int) j3;
                qQLiveErrorMsg.originErrMsg = str;
            } catch (Throwable unused) {
                this.f270770i = true;
                return;
            }
        } else {
            qQLiveErrorMsg = null;
        }
        if (j3 == 0) {
            z16 = true;
        }
        d("anchor_room_enter_sdk", z16, qQLiveErrorMsg).addKeyValue("duration", l("time_trtc_enter_room_end") - l("time_trtc_enter_room_start")).send();
    }

    public void x(int i3, String str) {
        QQLiveErrorMsg qQLiveErrorMsg;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) str);
            return;
        }
        if (this.f270763b) {
            return;
        }
        if (i3 != 0) {
            try {
                qQLiveErrorMsg = new QQLiveErrorMsg();
                qQLiveErrorMsg.bizModule = 2;
                qQLiveErrorMsg.bizErrCode = 6106;
                qQLiveErrorMsg.bizErrMsg = "trtc error";
                qQLiveErrorMsg.originErrCode = i3;
                qQLiveErrorMsg.originErrMsg = str;
            } catch (Throwable unused) {
                this.f270770i = true;
                return;
            }
        } else {
            qQLiveErrorMsg = null;
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        d("anchor_trtc_sdk_error", z16, qQLiveErrorMsg).send();
    }

    public void y(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), qQLiveErrorMsg);
            return;
        }
        if (this.f270763b) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_techReport", 1, "setEnd");
        }
        u("time_set_end");
        try {
            d("anchor_room_set", z16, qQLiveErrorMsg).addKeyValue("duration", l("time_set_end") - l("time_set_start")).send();
        } catch (Throwable th5) {
            QLog.d("QQLiveAnchor_techReport", 1, th5, new Object[0]);
        }
    }
}
