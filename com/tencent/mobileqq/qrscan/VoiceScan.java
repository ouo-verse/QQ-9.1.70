package com.tencent.mobileqq.qrscan;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PCMRecorder;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.StatableSpanTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import mk2.a;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class VoiceScan implements Handler.Callback, PCMRecorder.a, a.InterfaceC10793a {
    static IPatchRedirector $redirector_;
    private static final String I;
    private static final String J;
    private boolean C;
    private Dialog D;
    private ChirpSoHandler E;
    private Handler F;
    private boolean G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private Context f276524d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f276525e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f276526f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f276527h;

    /* renamed from: i, reason: collision with root package name */
    private PCMRecorder f276528i;

    /* renamed from: m, reason: collision with root package name */
    private ChirpWrapper f276529m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24680);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            I = HardCodeUtil.qqStr(R.string.f21715609);
            J = HardCodeUtil.qqStr(R.string.f21714608);
        }
    }

    public VoiceScan(Context context, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) appInterface);
            return;
        }
        this.f276526f = false;
        this.C = false;
        this.G = false;
        this.H = false;
        this.f276524d = context;
        this.f276525e = appInterface;
        this.F = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.f276527h = new Handler(this);
    }

    private boolean f() {
        if (this.f276525e == null) {
            return false;
        }
        ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).setTalkbackSwitch();
        if (QLog.isColorLevel()) {
            QLog.d("IQRScanConst_VoiceScan", 2, "checkVoiceScanEnable enableTalkBack = " + AppSetting.f99565y);
        }
        return false;
    }

    private static void g(byte[] bArr, short[] sArr) {
        for (int i3 = 0; i3 < sArr.length; i3++) {
            int i16 = i3 * 2;
            sArr[i3] = (short) (((bArr[i16 + 1] << 8) & 65280) | (bArr[i16] & 255));
        }
    }

    private void h() {
        boolean d16 = ChirpWrapper.d();
        if (QLog.isColorLevel()) {
            QLog.d("IQRScanConst_VoiceScan", 2, "isSoLoaded " + d16);
        }
        if (!d16) {
            if (this.E == null) {
                this.E = (ChirpSoHandler) ((IEarlyDownloadService) this.f276525e.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler("qq.android.system.chirp");
            }
            ChirpSoHandler chirpSoHandler = this.E;
            if (chirpSoHandler != null) {
                chirpSoHandler.a(this);
                this.E.I(true);
                return;
            }
            return;
        }
        if (AudioUtil.h(1)) {
            if (QLog.isColorLevel()) {
                QLog.d("IQRScanConst_VoiceScan", 2, "checkInitVoiceScan, permission is forbidden, " + this.C);
            }
            if (!this.C) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qrscan.VoiceScan.1
                    static IPatchRedirector $redirector_;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.qrscan.VoiceScan$1$a */
                    /* loaded from: classes17.dex */
                    class a implements ClickableColorSpanTextView.a {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.widget.ClickableColorSpanTextView.a
                        public void a(ClickableColorSpanTextView clickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan statableForegroundColorSpan) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) clickableColorSpanTextView, (Object) statableForegroundColorSpan);
                                return;
                            }
                            Intent intent = new Intent(VoiceScan.this.f276524d, (Class<?>) QQBrowserActivity.class);
                            intent.putExtra("url", IQQRecorderUtils.ABNORMAL_RECORD_URL);
                            VoiceScan.this.f276524d.startActivity(intent);
                        }
                    }

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) VoiceScan.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        SpannableString spannableString = new SpannableString(VoiceScan.this.f276524d.getString(R.string.f6p));
                        spannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(VoiceScan.this.f276524d.getResources().getColor(R.color.f157037i4), VoiceScan.this.f276524d.getResources().getColor(R.color.f157042i9)), spannableString.length() - 7, spannableString.length() - 1, 33);
                        VoiceScan voiceScan = VoiceScan.this;
                        voiceScan.D = DialogUtil.createContentClickableDialog(voiceScan.f276524d, VoiceScan.this.f276524d.getString(R.string.f6o), spannableString, 0, R.string.f170648xe, null, null, new a());
                        VoiceScan.this.D.show();
                    }
                });
                return;
            }
            return;
        }
        if (((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).isVideoChatting(this.f276525e)) {
            if (QLog.isColorLevel()) {
                QLog.d("IQRScanConst_VoiceScan", 2, "isVedioChatting");
                return;
            }
            return;
        }
        SharedPreferences mMKVMigratedSharePreferencesSync = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, "qrcode", 0);
        boolean z16 = mMKVMigratedSharePreferencesSync.getBoolean("key_first_enter_voice_qrcode" + this.f276525e.getCurrentAccountUin(), true);
        if (QLog.isColorLevel()) {
            QLog.d("IQRScanConst_VoiceScan", 2, "checkInitVoiceScan, isFirst = " + z16);
        }
        if (z16) {
            mMKVMigratedSharePreferencesSync.edit().putBoolean("key_first_enter_voice_qrcode" + this.f276525e.getCurrentAccountUin(), false).commit();
            Handler handler = this.F;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(295, 2000L);
            }
        }
        if (this.f276529m == null) {
            ChirpWrapper chirpWrapper = new ChirpWrapper();
            this.f276529m = chirpWrapper;
            int c16 = chirpWrapper.c();
            if (c16 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("IQRScanConst_VoiceScan", 2, "decode chirp init failed = " + c16);
                    return;
                }
                return;
            }
            PCMRecorder pCMRecorder = new PCMRecorder(this.f276524d, 44100, this);
            this.f276528i = pCMRecorder;
            pCMRecorder.f();
        }
    }

    private void l() {
        PCMRecorder pCMRecorder = this.f276528i;
        if (pCMRecorder != null) {
            pCMRecorder.g();
            this.f276528i = null;
        }
        ChirpWrapper chirpWrapper = this.f276529m;
        if (chirpWrapper != null) {
            chirpWrapper.e();
            this.f276529m = null;
        }
    }

    @Override // mk2.a.InterfaceC10793a
    public void B1() {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.f276526f && (handler = this.F) != null) {
            handler.sendEmptyMessage(293);
        }
    }

    @Override // com.tencent.chirp.PCMRecorder.a
    public void a(byte[] bArr) {
        AllInOne allInOne;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr);
            return;
        }
        if (this.f276529m == null) {
            return;
        }
        short[] sArr = new short[bArr.length / 2];
        g(bArr, sArr);
        String a16 = this.f276529m.a(sArr, 15);
        if (!TextUtils.isEmpty(a16)) {
            if (QLog.isColorLevel()) {
                QLog.d("IQRScanConst_VoiceScan", 2, "onRecord data: " + a16);
            }
            if (a16.startsWith("0")) {
                int i3 = 0;
                while (i3 < a16.length() && a16.charAt(i3) == '0') {
                    i3++;
                }
                String substring = a16.substring(i3);
                if (QLog.isColorLevel()) {
                    QLog.d("IQRScanConst_VoiceScan", 2, "onRecorderData uin:" + substring);
                }
                try {
                    Long.parseLong(substring);
                    ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).speak(HardCodeUtil.qqStr(R.string.f21713607));
                    try {
                        LockMethodProxy.sleep(1500L);
                    } catch (Exception unused) {
                    }
                    if (substring != null && !"".equals(substring) && !this.f276525e.getCurrentAccountUin().equals(substring)) {
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(substring);
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = null;
                        if (!TextUtils.isEmpty(uidFromUin)) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            arrayList.add(uidFromUin);
                            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendSimpleInfoWithUid(arrayList, "voiceScan");
                            if (friendSimpleInfoWithUid != null && friendSimpleInfoWithUid.size() > 0) {
                                dVar = friendSimpleInfoWithUid.get(0);
                            }
                        }
                        if (dVar != null && dVar.f() >= 0) {
                            allInOne = new AllInOne(substring, 1);
                            allInOne.nickname = dVar.p();
                            allInOne.remark = dVar.r();
                        } else {
                            allInOne = new AllInOne(substring, 3);
                            allInOne.subSourceId = 12;
                        }
                        ProfileUtils.openProfileCard(this.f276524d, allInOne);
                        ReportController.o(this.f276525e, "CliOper", "", "", "0X8007098", "0X8007098", 0, 0, "", "", "", "");
                        return;
                    }
                    allInOne = new AllInOne(this.f276525e.getCurrentAccountUin(), 0);
                    ProfileUtils.openProfileCard(this.f276524d, allInOne);
                    ReportController.o(this.f276525e, "CliOper", "", "", "0X8007098", "0X8007098", 0, 0, "", "", "", "");
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("IQRScanConst_VoiceScan", 2, "", e16);
                        return;
                    }
                    return;
                }
            }
            ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).speak(J);
        }
    }

    @Override // com.tencent.chirp.PCMRecorder.a
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IQRScanConst_VoiceScan", 2, "record error = " + i3);
        }
        l();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 291:
                if (this.F != null) {
                    Process.setThreadPriority(-19);
                    this.F.removeCallbacksAndMessages(null);
                    this.F.sendEmptyMessage(293);
                    break;
                }
                break;
            case 292:
                boolean f16 = f();
                this.G = f16;
                this.H = true;
                if (f16) {
                    this.f276527h.sendEmptyMessage(291);
                    break;
                }
                break;
            case 293:
                h();
                break;
            case 295:
                ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).speak(I);
                break;
        }
        return true;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IQRScanConst_VoiceScan", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.f276526f = false;
        Handler handler = this.f276527h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f276527h = null;
        }
        Handler handler2 = this.F;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.F = null;
        }
        ChirpSoHandler chirpSoHandler = this.E;
        if (chirpSoHandler != null) {
            chirpSoHandler.b(this);
            this.E = null;
        }
        Dialog dialog = this.D;
        if (dialog != null && dialog.isShowing()) {
            try {
                this.D.dismiss();
                this.D = null;
            } catch (Exception unused) {
            }
        }
        l();
        this.f276524d = null;
        this.f276525e = null;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IQRScanConst_VoiceScan", 2, "onScannerPause");
        }
        this.f276526f = false;
        this.F.removeCallbacksAndMessages(null);
        this.f276527h.removeCallbacksAndMessages(291);
        if (this.G) {
            Process.setThreadPriority(0);
            l();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IQRScanConst_VoiceScan", 2, "onScannerResume");
        }
        this.f276526f = true;
        if (this.G) {
            Process.setThreadPriority(-19);
            this.F.sendEmptyMessage(293);
        } else if (!this.H) {
            this.F.sendEmptyMessage(292);
        }
    }
}
