package com.tencent.mobileqq.msgbackup.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.i;
import com.tencent.mobileqq.msgbackup.data.d;
import com.tencent.mobileqq.msgbackup.data.g;
import com.tencent.mobileqq.msgbackup.data.j;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupQRFragment extends MsgBackupBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: o0, reason: collision with root package name */
    private Runnable f251233o0;

    /* renamed from: p0, reason: collision with root package name */
    private Bitmap f251234p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f251235q0;

    /* renamed from: r0, reason: collision with root package name */
    private d f251236r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f251237s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f251238t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f251239u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f251240v0;

    /* renamed from: w0, reason: collision with root package name */
    private Runnable f251241w0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupQRFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 1) {
                if (QLog.isColorLevel()) {
                    QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click left btn");
                }
                MsgBackupManager.x().I();
                MsgBackupQRFragment.this.onBackEvent();
                com.tencent.mobileqq.msgbackup.util.d.f("0X800A242", 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupQRFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d("MsgBackup.MsgBackupQRFragment", 1, "New To Old is not allow onClick");
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).gotoChatHistoryFragment(MsgBackupQRFragment.this.getActivity(), intent);
            MsgBackupManager.x().I();
            MsgBackupQRFragment.this.f251239u0 = true;
            dialogInterface.dismiss();
        }
    }

    public MsgBackupQRFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251239u0 = true;
        this.f251240v0 = false;
        this.f251241w0 = new Runnable() { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupQRFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                MsgBackupManager x16 = MsgBackupManager.x();
                String f16 = x16.y().f();
                if (f16 != null) {
                    x16.Q(f16);
                    MsgBackupQRFragment.this.X.postDelayed(this, 500L);
                }
            }
        };
    }

    private void Sh() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.X.post(new Runnable() { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupQRFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        MsgBackupQRFragment.this.Yh(MsgBackupQRFragment.this.Rh(null));
                    }
                }
            });
        } else {
            Yh(Rh(null));
        }
    }

    private void Th() {
        DialogUtil.createCustomDialog(getContext(), 231, (String) null, getString(R.string.zd7), (String) null, getString(R.string.o_a), new b(), (DialogInterface.OnClickListener) null).show();
    }

    private void Uh(d dVar) {
        if (dVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupQRFragment", 2, "refreshQRLayout QRCode fail, data is null!");
                return;
            }
            return;
        }
        String d16 = dVar.d();
        String c16 = dVar.c();
        String b16 = dVar.b();
        int a16 = dVar.a();
        MsgBackupManager x16 = MsgBackupManager.x();
        MsgBackupTransportProcessor z16 = x16.z();
        z16.P0(b16);
        x16.y().j(d16);
        x16.y().i(c16);
        x16.y().h(a16);
        z16.O0(2);
        this.X.postDelayed(this.f251241w0, 800L);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.X.post(new Runnable(dVar) { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ d f251244d;

                {
                    this.f251244d = dVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupQRFragment.this, (Object) dVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        MsgBackupQRFragment.this.Xh(MsgBackupQRFragment.this.Rh(this.f251244d));
                    }
                }
            });
        } else {
            Xh(Rh(dVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(boolean z16, boolean z17) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.X.post(new Runnable(z17, z16) { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f251242d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f251243e;

                {
                    this.f251242d = z17;
                    this.f251243e = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, MsgBackupQRFragment.this, Boolean.valueOf(z17), Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    MsgBackupQRFragment.this.Yh(MsgBackupQRFragment.this.Rh(null));
                    if (this.f251242d) {
                        MsgBackupQRFragment.this.Wh();
                    } else {
                        MsgBackupQRFragment.this.Zh(this.f251243e);
                    }
                }
            });
        } else {
            Yh(Rh(null));
            if (z17) {
                Wh();
            } else {
                Zh(z16);
            }
        }
        com.tencent.mobileqq.msgbackup.util.d.f("0X800A241", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        this.W.sendMessage(this.W.obtainMessage(10015));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public void Xh(Bitmap bitmap) {
        ?? r16 = 1;
        if (NetworkUtil.getSystemNetwork(getActivity()) != 1) {
            r16 = 0;
        }
        Zh(r16);
        Message obtainMessage = this.W.obtainMessage(10004);
        obtainMessage.arg1 = r16;
        obtainMessage.obj = bitmap;
        this.W.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh(Bitmap bitmap) {
        Message obtainMessage = this.W.obtainMessage(10006);
        obtainMessage.obj = bitmap;
        this.W.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh(boolean z16) {
        Message obtainMessage = this.W.obtainMessage(10005);
        obtainMessage.arg1 = z16 ? 1 : 0;
        this.W.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void Ah(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar);
            return;
        }
        super.Ah(dVar);
        this.f251240v0 = false;
        Uh(dVar);
        MsgBackupManager.x().Y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void Bh(g gVar) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) gVar);
            return;
        }
        super.Bh(gVar);
        if (gVar != null) {
            if (gVar.c() == 2) {
                Runnable runnable = this.f251233o0;
                if (runnable != null) {
                    this.X.removeCallbacks(runnable);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupQRFragment", 1, "processQueryStateRsp: " + gVar);
                }
                if (!MsgBackupManager.O && this.f251239u0) {
                    this.X.removeCallbacks(this.f251241w0);
                    String b16 = gVar.b();
                    String d16 = gVar.d();
                    int a16 = gVar.a();
                    String b17 = gVar.e().b();
                    List<Integer> f16 = gVar.e().f();
                    if (f16.size() == 2) {
                        i16 = f16.get(0).intValue();
                        i3 = f16.get(1).intValue();
                    } else {
                        i3 = 0;
                        i16 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: client ip = " + b17 + ", udpport = " + i3 + ", tcpport = " + i16);
                    }
                    MsgBackupManager x16 = MsgBackupManager.x();
                    MsgBackupTransportProcessor z16 = x16.z();
                    z16.P0(b16);
                    z16.L0(b17);
                    z16.M0(i16);
                    z16.N0(i3);
                    x16.y().h(a16);
                    x16.y().j(d16);
                    z16.O0(2);
                    z16.R0(2);
                    if (!gVar.e().c()) {
                        QLog.d("MsgBackup.MsgBackupQRFragment", 1, "New To Old is not allow inner");
                        this.f251239u0 = false;
                        Th();
                        MsgBackupManager.x().z().n();
                        return;
                    }
                    MsgBackupManager.O = true;
                    if (getActivity() != null && !getActivity().isFinishing()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has deal, so app will start transport page!");
                        }
                        Intent intent = new Intent();
                        intent.putExtra("param_start", 4);
                        QPublicFragmentActivity.startForResult(getActivity(), intent, (Class<? extends QPublicBaseFragment>) MsgBackupTransportFragment.class, 1000);
                        return;
                    }
                    return;
                }
                QLog.d("MsgBackup.MsgBackupQRFragment", 1, "processQueryStateRsp: has been started link page!");
                return;
            }
            if (gVar.c() != 1 && gVar.c() != 3) {
                gVar.c();
            }
        }
    }

    public Bitmap Rh(d dVar) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bitmap) iPatchRedirector.redirect((short) 14, (Object) this, (Object) dVar);
        }
        if (dVar == null) {
            str = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=1";
        } else {
            str = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=" + dVar.c();
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put(EncodeHintType.MARGIN, 0);
        hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        try {
            int dip2px = ViewUtils.dip2px(200.0f);
            BitMatrix encode = new QRCodeWriter().encode(str, dip2px, dip2px, hashtable);
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[width * height];
            for (int i3 = 0; i3 < height; i3++) {
                for (int i16 = 0; i16 < width; i16++) {
                    if (encode.get(i16, i3)) {
                        iArr[(i3 * width) + i16] = -16777216;
                    }
                }
            }
            if (this.f251234p0 == null) {
                this.f251234p0 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            }
            Object[] objArr = new Object[1];
            if (this.f251234p0 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            f.B("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", objArr);
            this.f251234p0.setPixels(iArr, 0, width, 0, 0, width, height);
            return this.f251234p0;
        } catch (Exception e16) {
            QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click KEYCODE_BACK");
            }
            MsgBackupManager.x().I();
            onBackEvent();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 10013) {
            if (i3 != 10015) {
                boolean z17 = true;
                switch (i3) {
                    case 10004:
                        if (message.arg1 == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            ImageView imageView = this.N;
                            if (imageView != null) {
                                imageView.setImageBitmap((Bitmap) message.obj);
                                ProgressBar progressBar = this.P;
                                if (progressBar != null) {
                                    progressBar.setVisibility(8);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("MsgBackup.MsgBackupQRFragment", 2, "handleMessage: what = MSG_WHAT_QR_SOURCE");
                                }
                                MsgBackupManager.x().H();
                                com.tencent.mobileqq.msgbackup.util.d.f("0X800A239", 1);
                                break;
                            }
                        } else {
                            Sh();
                            f.B("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
                            break;
                        }
                        break;
                    case 10005:
                        if (message.arg1 != 1) {
                            z17 = false;
                        }
                        if (z17) {
                            ViewUtils.setViewVisibility(this.Q, 0);
                            ViewUtils.setViewVisibility(this.R, 8);
                            break;
                        } else {
                            ViewUtils.setViewVisibility(this.Q, 8);
                            this.R.setText(BaseApplication.getContext().getResources().getString(R.string.ilc));
                            this.R.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.skin_black));
                            ViewUtils.setViewVisibility(this.R, 0);
                            break;
                        }
                    case 10006:
                        BitmapDrawable bitmapDrawable = new BitmapDrawable((Bitmap) message.obj);
                        bitmapDrawable.setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
                        ImageView imageView2 = this.N;
                        if (imageView2 != null) {
                            imageView2.setImageDrawable(bitmapDrawable);
                            ProgressBar progressBar2 = this.P;
                            if (progressBar2 != null && !this.f251240v0) {
                                progressBar2.setVisibility(8);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("MsgBackup.MsgBackupQRFragment", 2, "handleMessage: what = MSG_WHAT_UPDATE_QR_PAGE_ERROR");
                            }
                            MsgBackupManager.x().H();
                        }
                        com.tencent.mobileqq.msgbackup.util.d.f("0X800A239", 2);
                        break;
                }
            } else {
                ViewUtils.setViewVisibility(this.Q, 8);
                this.R.setText(BaseApplication.getContext().getResources().getString(R.string.ild));
                this.R.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.amk));
                ViewUtils.setViewVisibility(this.R, 0);
            }
        } else {
            ViewUtils.setVisible(this.P, 0);
        }
        return super.handleMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void initListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.initListener();
            this.f211174vg.setOnItemSelectListener(new a());
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else if (view.getId() == R.id.m39) {
            this.f251240v0 = true;
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupQRFragment", 2, "qr_code_src request qr onclick, isWaitingQrRsp = " + this.f251240v0);
            }
            this.W.sendMessage(this.W.obtainMessage(10013));
            this.X.post(new Runnable() { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupQRFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MsgBackupManager.x().y().g(false);
                    }
                }
            });
            com.tencent.mobileqq.msgbackup.util.d.e("0X800A23C");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.f251238t0 = false;
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onDestroyView();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupQRFragment", 2, "onDestroyView");
        }
        if (this.f251171c0 != null) {
            ((BaseQQAppInterface) getQBaseActivity().getAppRuntime()).removeObserver(this.f251171c0);
        }
        this.X.removeCallbacks(this.f251241w0);
        this.X.removeCallbacks(this.f251233o0);
        MsgBackupManager.x().G();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onPause();
            MsgBackupManager.x().O(getActivity());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onResume();
        MsgBackupManager.x().D(getActivity());
        MsgBackupManager.Q = false;
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            Dh();
            super.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void qh() {
        int i3;
        long j3;
        long j16;
        boolean z16;
        boolean z17;
        boolean z18;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.qh();
        f.C("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
        if (this.f251171c0 != null) {
            getQBaseActivity().removeObserver(this.f251171c0);
        }
        HashSet<j> hashSet = new HashSet<>(MsgBackupManager.x().f251037a.size());
        hashSet.addAll(MsgBackupManager.x().f251037a);
        MsgBackupManager.K = MsgBackupManager.x().f251037a.size();
        com.tencent.mobileqq.msgbackup.util.d.b();
        com.tencent.mobileqq.msgbackup.util.d.f251402a.f251377g = MsgBackupManager.K;
        i iVar = new i();
        f.C("MsgBackup.MsgBackupQRFragment-loadData ..start toPage TO_QRCODE dataSize = %d", Integer.valueOf(hashSet.size()));
        iVar.f251073a = hashSet;
        iVar.f251074b = 0;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            j3 = intent.getLongExtra("session_start_time", 0L);
            j16 = intent.getLongExtra("session_end_time", 0L);
            i3 = intent.getIntExtra("session_content_type", 1);
            this.f251237s0 = intent.getBooleanExtra("session_net_status", true);
        } else {
            i3 = 1;
            j3 = 0;
            j16 = 0;
        }
        f.B("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Boolean.valueOf(this.f251237s0));
        if (j3 != 0 && j16 != 0 && j3 < j16) {
            iVar.f251075c = j3;
            iVar.f251076d = j16;
            if (i3 == 2) {
                z18 = true;
            } else {
                z18 = false;
            }
            iVar.f251077e = z18;
        } else {
            iVar.f251075c = 0L;
            iVar.f251076d = Long.MAX_VALUE;
            if (i3 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            iVar.f251077e = z16;
        }
        getQBaseActivity().addObserver(this.f251171c0);
        QLog.d("MsgBackup.MsgBackupQRFragment", 1, "MsgBackup startServerProxy lastNetEnable = " + this.f251237s0);
        if (this.f251237s0) {
            MsgBackupManager.x().b0(false);
            QLog.d("MsgBackup.MsgBackupQRFragment", 1, "get QrCode TYPE_TO_OTHER_DEVICE isNetEnable = " + this.f251237s0);
        }
        MsgBackupManager.x().P();
        MsgBackupManager.x().U(iVar);
        if (NetworkUtil.getSystemNetwork(getActivity()) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("MsgBackup.MsgBackupQRFragment", 1, "MsgBackup startServerProxy nowNetEnable = " + z17);
        if (!this.f251237s0 && z17) {
            MsgBackupManager.x().b0(false);
            this.f251238t0 = true;
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
            }
        }
        this.f251235q0 = z17;
        f.B("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", Boolean.valueOf(z17));
        if (!z17) {
            Vh(z17, false);
        }
        d A = MsgBackupManager.x().A();
        this.f251236r0 = A;
        if (A != null && z17) {
            f.B("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
            this.f251240v0 = false;
            Uh(this.f251236r0);
        }
        this.X.post(this.f251233o0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.rh();
        if (AppSetting.f99565y) {
            this.N.setContentDescription(HardCodeUtil.qqStr(R.string.o_i));
        }
        this.R.setText(getResources().getString(R.string.ilc));
        this.R.setTextColor(getResources().getColor(R.color.skin_black));
        this.E.setVisibility(0);
        this.P.setVisibility(0);
        this.N.setOnClickListener(this);
        this.f251233o0 = new Runnable() { // from class: com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupQRFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (NetworkUtil.getSystemNetwork(MsgBackupQRFragment.this.getActivity()) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 != MsgBackupQRFragment.this.f251235q0) {
                    MsgBackupQRFragment.this.f251235q0 = z16;
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "mMigrateQrNetStateRunnable: enable = " + z16);
                    }
                    if (!z16) {
                        MsgBackupQRFragment.this.Vh(false, false);
                    } else {
                        if (!MsgBackupQRFragment.this.f251237s0 && !MsgBackupQRFragment.this.f251238t0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MsgBackup.MsgBackupQRFragment", 2, "mMigrateQrNetStateRunnable startServerProxy is not called! current wifi is connected so called it");
                            }
                            MsgBackupManager.x().b0(false);
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("MsgBackup.MsgBackupQRFragment", 2, "mMigrateQrNetStateRunnable startServerProxy is called!");
                            }
                            MsgBackupManager.x().y().g(false);
                        }
                        MsgBackupQRFragment.this.W.sendMessage(MsgBackupQRFragment.this.W.obtainMessage(10013));
                        MsgBackupQRFragment.this.f251240v0 = true;
                    }
                }
                MsgBackupQRFragment.this.X.postDelayed(this, 500L);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.xh();
            setTitle(getActivity().getString(R.string.ijj));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void zh(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) num);
            return;
        }
        super.zh(num);
        this.f251240v0 = false;
        Vh(false, true);
    }
}
