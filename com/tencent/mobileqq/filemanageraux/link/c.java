package com.tencent.mobileqq.filemanageraux.link;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.link.a;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadManager;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
final class c implements View.OnClickListener, DialogInterface.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_;
    private final TextView C;
    private final TextView D;
    private final View E;
    private final TextView F;
    private QQCustomDialog G;
    private final MqqHandler H;
    private final MqqHandler I;
    private final MqqHandler J;
    private volatile boolean K;
    private volatile com.tencent.mobileqq.filemanageraux.core.d L;
    private volatile FileManagerEntity M;
    private volatile String N;
    private volatile boolean P;
    private long Q;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.filemanageraux.link.a f209629d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f209630e;

    /* renamed from: f, reason: collision with root package name */
    private final View f209631f;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f209632h;

    /* renamed from: i, reason: collision with root package name */
    private final View f209633i;

    /* renamed from: m, reason: collision with root package name */
    private final View f209634m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static final class a implements com.tencent.mobileqq.weiyun.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f209635a;

        /* renamed from: b, reason: collision with root package name */
        private final int f209636b;

        /* renamed from: c, reason: collision with root package name */
        private final String f209637c;

        /* renamed from: d, reason: collision with root package name */
        private final String f209638d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f209639e;

        a(c cVar, int i3, String str, String str2, boolean z16) {
            WeakReference<c> weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cVar, Integer.valueOf(i3), str, str2, Boolean.valueOf(z16));
                return;
            }
            if (cVar == null) {
                weakReference = null;
            } else {
                weakReference = new WeakReference<>(cVar);
            }
            this.f209635a = weakReference;
            this.f209636b = i3;
            this.f209637c = str;
            this.f209638d = str2;
            this.f209639e = z16;
        }

        @Override // com.tencent.mobileqq.weiyun.a
        public void onError(int i3, String str) {
            c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            WeakReference<c> weakReference = this.f209635a;
            if (weakReference == null) {
                cVar = null;
            } else {
                cVar = weakReference.get();
            }
            if (cVar != null && !cVar.P) {
                if (!((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(i3) && !TextUtils.isEmpty(this.f209638d) && cVar.M == null) {
                    QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "GetShareLink errorCode=" + i3 + ", errorMsg=" + str);
                    cVar.B(this.f209638d);
                    return;
                }
                Message message = new Message();
                message.what = 6;
                message.obj = new Object[]{Integer.valueOf(i3), str};
                cVar.H.sendMessage(message);
            }
        }

        @Override // com.tencent.mobileqq.weiyun.a
        public void onSuccess(Object obj) {
            c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            WeakReference<c> weakReference = this.f209635a;
            if (weakReference == null) {
                cVar = null;
            } else {
                cVar = weakReference.get();
            }
            if (obj != null && cVar != null && !cVar.P) {
                String str = (String) obj;
                if (this.f209639e && !str.contains("?weiyun_qr_code=1")) {
                    str = str + "?weiyun_qr_code=1";
                }
                Message message = new Message();
                message.what = 5;
                message.obj = new Object[]{str, Integer.valueOf(this.f209636b), this.f209637c};
                cVar.H.sendMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static final class b implements UploadManager.IUploadStatusListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f209640a;

        /* renamed from: b, reason: collision with root package name */
        private final String f209641b;

        b(c cVar, String str) {
            WeakReference<c> weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) str);
                return;
            }
            if (cVar == null) {
                weakReference = null;
            } else {
                weakReference = new WeakReference<>(cVar);
            }
            this.f209640a = weakReference;
            this.f209641b = str;
        }

        @Override // com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener
        public void onUploadJobAdded(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener
        public void onUploadStatusChanged(String str, long j3, UploadJobContext.StatusInfo statusInfo, boolean z16) {
            c cVar;
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), statusInfo, Boolean.valueOf(z16));
                return;
            }
            WeakReference<c> weakReference = this.f209640a;
            Message message = null;
            if (weakReference == null) {
                cVar = null;
            } else {
                cVar = weakReference.get();
            }
            if (cVar == null || cVar.P || cVar.L == null) {
                return;
            }
            if (z16) {
                int i3 = statusInfo.state;
                if (i3 != 5) {
                    if (i3 == 6) {
                        if (statusInfo.errorCode == 1810002) {
                            if (QLog.isColorLevel()) {
                                QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "upload is canceled, for file:" + this.f209641b);
                            }
                        } else {
                            message = new Message();
                            message.what = 3;
                            message.obj = new Object[]{Integer.valueOf(statusInfo.errorCode), statusInfo.errorMsg};
                        }
                    }
                } else {
                    message = new Message();
                    message.what = 2;
                    message.obj = new Object[]{statusInfo, this.f209641b};
                }
            } else {
                long j16 = statusInfo.totalSize;
                if (j16 <= 0) {
                    f16 = 0.0f;
                } else {
                    f16 = ((float) statusInfo.currSize) / ((float) j16);
                }
                Message message2 = new Message();
                message2.what = 4;
                message2.obj = new Object[]{Float.valueOf(f16)};
                message = message2;
            }
            if (message != null) {
                cVar.H.sendMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.tencent.mobileqq.filemanageraux.link.a aVar, View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, view, Boolean.valueOf(z16));
            return;
        }
        this.Q = 0L;
        this.f209629d = aVar;
        this.f209630e = z16;
        this.f209631f = view.findViewById(R.id.cfj);
        this.f209632h = (TextView) view.findViewById(R.id.cd_);
        this.f209633i = view.findViewById(R.id.f166542cc2);
        this.f209634m = view.findViewById(R.id.ccc);
        this.C = (TextView) view.findViewById(R.id.ccb);
        this.D = (TextView) view.findViewById(R.id.cci);
        view.findViewById(R.id.h99).setOnClickListener(this);
        this.E = view.findViewById(R.id.bjt);
        this.F = (TextView) view.findViewById(R.id.f166059bk2);
        view.findViewById(R.id.bju).setOnClickListener(this);
        view.findViewById(R.id.ggj).setOnClickListener(this);
        this.H = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.I = new MqqWeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), this, false);
        this.J = new MqqWeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this, false);
        C();
    }

    private void A(FileManagerEntity fileManagerEntity, String str) {
        AppInterface appInterface = this.f209629d.getBaseActivity().getAppInterface();
        if (appInterface instanceof QQAppInterface) {
            Message message = new Message();
            message.what = 9;
            message.obj = new Object[]{(QQAppInterface) appInterface, fileManagerEntity, this.f209629d.A7(), Boolean.valueOf(this.f209630e), str};
            this.J.sendMessage(message);
            return;
        }
        throw new IllegalStateException("processCloudFile: need QQAppInterface, must run in main process.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str) {
        FileManagerEntity fileManagerEntity = this.M;
        if (fileManagerEntity != null) {
            A(fileManagerEntity, null);
            return;
        }
        AppInterface appInterface = this.f209629d.getBaseActivity().getAppInterface();
        if (appInterface instanceof QQAppInterface) {
            Message message = new Message();
            message.what = 8;
            message.obj = new Object[]{(QQAppInterface) appInterface, str};
            this.I.sendMessage(message);
            return;
        }
        throw new IllegalStateException("processLocalFile: need QQAppInterface, must run in main process.");
    }

    private void D() {
        if (!TextUtils.isEmpty(j())) {
            com.tencent.mobileqq.filemanageraux.link.b.i("0X800A9D9", null, null);
            this.f209629d.s9(null);
        }
    }

    private void E() {
        int i3;
        if (this.G == null) {
            QQCustomDialog qQCustomDialog = new QQCustomDialog(this.f209629d.getBaseActivity(), R.style.qZoneInputDialog);
            this.G = qQCustomDialog;
            qQCustomDialog.setContentView(R.layout.f167856jn);
            this.G.setTitle(R.string.vux);
            QQCustomDialog qQCustomDialog2 = this.G;
            if (this.f209630e) {
                i3 = R.string.w3y;
            } else {
                i3 = R.string.vuy;
            }
            qQCustomDialog2.setMessage(i3);
            this.G.setNegativeButton(R.string.cancel, this);
            this.G.setPositiveButton(R.string.vuz, this);
            this.G.setCancelable(true);
            this.G.setCanceledOnTouchOutside(false);
        }
        if (!this.G.isShowing()) {
            this.G.show();
        }
    }

    private void F() {
        String str;
        String f16;
        FileManagerEntity W = this.f209629d.W();
        String filePath = this.f209629d.getFilePath();
        if (W == null && TextUtils.isEmpty(filePath)) {
            QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "startProcess: fileEntity and filePath are invalid");
            return;
        }
        if (this.K) {
            return;
        }
        this.K = true;
        this.f209629d.O9();
        a.C7594a A7 = this.f209629d.A7();
        if (this.f209630e) {
            str = "0X800A9D7";
        } else {
            str = "0X800A9D6";
        }
        String d16 = com.tencent.mobileqq.filemanageraux.link.b.d(A7.f209625a);
        if (this.f209630e) {
            f16 = null;
        } else {
            f16 = com.tencent.mobileqq.filemanageraux.link.b.f(A7.f209626b);
        }
        com.tencent.mobileqq.filemanageraux.link.b.i(str, d16, f16);
        if (com.tencent.mobileqq.filemanageraux.link.b.h(W, false)) {
            A(W, filePath);
        } else {
            B(filePath);
        }
        x();
    }

    private void g() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Q < 1200) {
            return;
        }
        this.Q = currentTimeMillis;
        String j3 = j();
        if (!TextUtils.isEmpty(j3)) {
            com.tencent.mobileqq.filemanageraux.link.b.i("0X800A9D8", null, null);
            ClipboardMonitor.setText((ClipboardManager) BaseApplicationImpl.sApplication.getSystemService("clipboard"), j3);
            com.tencent.mobileqq.filemanageraux.link.b.j(2, R.string.vul, true);
        }
    }

    private String j() {
        String charSequence = this.F.getText().toString();
        if (!TextUtils.isEmpty(charSequence)) {
            Object tag = this.F.getTag();
            if ((tag instanceof String) && !TextUtils.isEmpty((String) tag)) {
                return charSequence + " " + BaseApplicationImpl.sApplication.getString(R.string.vv9) + ":" + tag;
            }
            return charSequence;
        }
        return null;
    }

    private void k(Object[] objArr) {
        if (objArr != null && objArr.length >= 2) {
            w(((Integer) objArr[0]).intValue(), (String) objArr[1]);
            return;
        }
        throw new IllegalArgumentException("handleError: args are invalid");
    }

    private void l(Object[] objArr) {
        Bitmap bitmap;
        if (objArr != null && objArr.length >= 3) {
            String str = (String) objArr[0];
            int intValue = ((Integer) objArr[1]).intValue();
            String str2 = (String) objArr[2];
            try {
                bitmap = com.tencent.mobileqq.filemanageraux.link.b.b(str, ViewUtils.dip2px(184.0f));
            } catch (Throwable th5) {
                QLog.e("WeiyunShareProcessController<FileAssistant>", 2, "GetQrTask error", th5);
                bitmap = null;
            }
            Message message = new Message();
            message.what = 7;
            message.obj = new Object[]{bitmap, Integer.valueOf(intValue), str2};
            this.H.sendMessage(message);
            return;
        }
        throw new IllegalArgumentException("handleGetQr: args are invalid");
    }

    private void m(Bitmap bitmap, int i3, String str) {
        if (bitmap == null) {
            w(-1, null);
        } else {
            this.f209629d.J4(bitmap, i3, str);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        C();
    }

    private void n(Object[] objArr) {
        if (objArr != null && objArr.length >= 3) {
            m((Bitmap) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2]);
            return;
        }
        throw new IllegalArgumentException("handleQrRelay: args are invalid");
    }

    private void o(Object[] objArr) {
        int i3;
        String str;
        String str2;
        String str3;
        if (objArr != null && objArr.length >= 5) {
            QQAppInterface qQAppInterface = (QQAppInterface) objArr[0];
            FileManagerEntity fileManagerEntity = (FileManagerEntity) objArr[1];
            a.C7594a c7594a = (a.C7594a) objArr[2];
            boolean booleanValue = ((Boolean) objArr[3]).booleanValue();
            String str4 = (String) objArr[4];
            if (NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication)) {
                long a16 = com.tencent.mobileqq.filemanageraux.link.b.a(c7594a.f209625a);
                if (q.f(str4)) {
                    str = str4;
                } else {
                    str = null;
                }
                com.tencent.mobileqq.filemanageraux.core.b Y = qQAppInterface.getFileManagerEngine().Y();
                boolean z16 = c7594a.f209626b;
                if (z16) {
                    str2 = c7594a.f209627c;
                } else {
                    str2 = null;
                }
                boolean z17 = c7594a.f209628d;
                int i16 = c7594a.f209625a;
                if (z16) {
                    str3 = c7594a.f209627c;
                } else {
                    str3 = null;
                }
                Y.r(fileManagerEntity, a16, str2, z17, booleanValue, new a(this, i16, str3, str, booleanValue));
                i3 = 0;
            } else {
                i3 = 2;
            }
            if (i3 != 0) {
                Message message = new Message();
                message.what = 1;
                message.obj = new Object[]{Integer.valueOf(i3), null};
                this.H.sendMessage(message);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("handleRequest: args are invalid");
    }

    private void p(Object[] objArr) {
        if (objArr != null && objArr.length >= 3) {
            z((String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2]);
            return;
        }
        throw new IllegalArgumentException("handleRequestSucceed: args are invalid");
    }

    private void q(Object[] objArr) {
        int i3;
        if (objArr != null && objArr.length >= 2) {
            QQAppInterface qQAppInterface = (QQAppInterface) objArr[0];
            String str = (String) objArr[1];
            if (NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication)) {
                com.tencent.mobileqq.filemanageraux.core.d I = qQAppInterface.getFileManagerEngine().Y().I(str, null, new b(this, str));
                if (I == null) {
                    i3 = -3;
                } else {
                    this.L = I;
                    i3 = 0;
                }
            } else {
                i3 = 2;
            }
            if (i3 != 0) {
                Message message = new Message();
                message.what = 1;
                message.obj = new Object[]{Integer.valueOf(i3), null};
                this.H.sendMessage(message);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("handleUpload: args are invalid");
    }

    private void r(Object[] objArr) {
        if (objArr != null && objArr.length >= 1) {
            y(((Float) objArr[0]).floatValue());
            return;
        }
        throw new IllegalArgumentException("handleUploadProgress: args are invalid");
    }

    private void s(Object[] objArr) {
        String str;
        if (objArr != null && objArr.length >= 2) {
            UploadJobContext.StatusInfo statusInfo = (UploadJobContext.StatusInfo) objArr[0];
            String str2 = (String) objArr[1];
            if (QLog.isColorLevel()) {
                QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "upload is succeed, for file:" + str2);
            }
            y(1.0f);
            this.L = null;
            FileManagerEntity fileManagerEntity = new FileManagerEntity();
            fileManagerEntity.setCloudType(2);
            fileManagerEntity.WeiYunFileId = statusInfo.fileId;
            UploadJobContext uploadJobContext = statusInfo.jobContext;
            if (uploadJobContext != null) {
                str = uploadJobContext.file().pDirKey;
            } else {
                str = null;
            }
            fileManagerEntity.WeiYunDirKey = str;
            this.M = fileManagerEntity;
            A(fileManagerEntity, null);
            return;
        }
        throw new IllegalArgumentException("handleUploadSucceed: args are invalid");
    }

    private void w(int i3, String str) {
        int i16;
        C();
        if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(i3)) {
            E();
            return;
        }
        if (i3 == 2) {
            str = BaseApplicationImpl.sApplication.getResources().getString(R.string.f171139ci4);
        }
        if (TextUtils.isEmpty(str)) {
            Resources resources = BaseApplicationImpl.sApplication.getResources();
            if (this.f209630e) {
                i16 = R.string.vuv;
            } else {
                i16 = R.string.vuw;
            }
            str = resources.getString(i16, Integer.valueOf(i3));
        }
        com.tencent.mobileqq.filemanageraux.link.b.k(1, str, true);
    }

    private void x() {
        int i3;
        this.f209634m.setVisibility(0);
        TextView textView = this.C;
        if (this.f209630e) {
            i3 = R.string.vun;
        } else {
            i3 = R.string.vup;
        }
        textView.setText(i3);
        this.D.setText("");
    }

    private void y(float f16) {
        int floor = (int) Math.floor(f16 * 100.0f);
        this.D.setText(floor + "%");
        this.D.setVisibility(0);
    }

    private void z(String str, int i3, String str2) {
        this.N = str;
        if (this.f209630e) {
            Message message = new Message();
            message.what = 10;
            message.obj = new Object[]{str, Integer.valueOf(i3), str2};
            this.J.sendMessage(message);
            return;
        }
        this.f209632h.setText(R.string.vus);
        this.f209633i.setVisibility(8);
        this.E.setVisibility(0);
        this.F.setText(str);
        this.F.setTag(str2);
        boolean z16 = this.K;
        this.K = false;
        if (z16) {
            this.f209629d.O9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        int i3;
        int i16;
        this.f209631f.setVisibility(0);
        this.f209632h.setVisibility(0);
        TextView textView = this.f209632h;
        if (this.f209630e) {
            i3 = R.string.vuq;
        } else {
            i3 = R.string.vur;
        }
        textView.setText(i3);
        this.f209633i.setVisibility(0);
        this.f209634m.setVisibility(8);
        TextView textView2 = this.C;
        if (this.f209630e) {
            i16 = R.string.vum;
        } else {
            i16 = R.string.vuo;
        }
        textView2.setText(i16);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.F.setText("");
        this.F.setTag(null);
        boolean z16 = this.K;
        this.K = false;
        if (z16) {
            this.f209629d.O9();
        }
        this.N = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (actionSheetItem == null) {
            return;
        }
        int i3 = actionSheetItem.action;
        BaseActivity baseActivity = this.f209629d.getBaseActivity();
        if (baseActivity != null && !baseActivity.isFinishing()) {
            int i16 = 0;
            if (!NetworkUtil.isNetSupport(baseActivity)) {
                com.tencent.mobileqq.filemanageraux.link.b.j(0, R.string.b3j, false);
                if (QLog.isColorLevel()) {
                    QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "toShare: net is not supported");
                    return;
                }
                return;
            }
            if (i3 == 2 || i3 == 3 || i3 == 9 || i3 == 10 || i3 == 72) {
                String j3 = j();
                if (TextUtils.isEmpty(j3)) {
                    return;
                }
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 9 && i3 != 10) {
                            if (i3 == 72) {
                                Bundle bundle = new Bundle();
                                bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                                bundle.putInt("key_direct_show_uin_type", actionSheetItem.uinType);
                                bundle.putString("key_direct_show_uin", actionSheetItem.uin);
                                Intent intent = new Intent();
                                intent.putExtra("isFromShare", true);
                                intent.putExtra("forward_type", -1);
                                intent.putExtra(AppConstants.Key.FORWARD_TEXT, j3);
                                intent.putExtras(bundle);
                                ForwardBaseOption.startForwardActivityForResult(baseActivity, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 1, -1, "");
                                return;
                            }
                            return;
                        }
                        String Ce = this.f209629d.Ce();
                        WXShareHelper b06 = WXShareHelper.b0();
                        if (i3 != 9) {
                            i16 = 1;
                        }
                        b06.H0(j3, i16, Ce);
                        return;
                    }
                    QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                    AppInterface appInterface = baseActivity.getAppInterface();
                    userInfo.qzone_uin = appInterface.getAccount();
                    if (appInterface instanceof VideoAppInterface) {
                        userInfo.nickname = ((VideoAppInterface) appInterface).G(0, appInterface.getCurrentAccountUin(), null);
                    } else {
                        userInfo.nickname = null;
                    }
                    QZoneHelper.forwardToPublishMood(baseActivity, userInfo, "", baseActivity.getString(R.string.b1o), j3, 2);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("isFromShare", true);
                intent2.putExtra("forward_type", -1);
                intent2.putExtra(AppConstants.Key.FORWARD_TEXT, j3);
                ForwardBaseOption.startForwardActivityForResult(baseActivity, intent2, 1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        com.tencent.mobileqq.filemanageraux.core.d dVar = this.L;
        this.L = null;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ShareActionSheetBuilder.ActionSheetItem> h(Context context) {
        return new ArrayList();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (this.P) {
            return false;
        }
        switch (message.what) {
            case 1:
            case 3:
            case 6:
                k((Object[]) message.obj);
                return true;
            case 2:
                s((Object[]) message.obj);
                return true;
            case 4:
                r((Object[]) message.obj);
                return true;
            case 5:
                p((Object[]) message.obj);
                return true;
            case 7:
                n((Object[]) message.obj);
                return true;
            case 8:
                q((Object[]) message.obj);
                return true;
            case 9:
                o((Object[]) message.obj);
                return true;
            case 10:
                l((Object[]) message.obj);
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ShareActionSheetBuilder.ActionSheetItem> i(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            int id5 = view.getId();
            if (id5 == R.id.h99) {
                F();
            } else if (id5 == R.id.bju) {
                g();
            } else if (id5 == R.id.ggj) {
                D();
            }
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        if (this.L != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.P = true;
        QQCustomDialog qQCustomDialog = this.G;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.G = null;
        }
        f();
        this.H.removeCallbacksAndMessages(null);
        this.I.removeCallbacksAndMessages(null);
        this.J.removeCallbacksAndMessages(null);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dialogInterface, i3);
        } else if (dialogInterface.equals(this.G) && i3 == 1) {
            ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).startOpenWeiyunVipCompareH5(this.f209629d.getBaseActivity(), this.f209630e ? "an_qq_qrcode_overcapacity" : "an_qq_link_overcapacity", false);
        }
    }
}
