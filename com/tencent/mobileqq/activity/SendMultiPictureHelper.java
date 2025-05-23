package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class SendMultiPictureHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected BaseActivity f177014a;

    /* renamed from: b, reason: collision with root package name */
    protected QQAppInterface f177015b;

    /* renamed from: c, reason: collision with root package name */
    protected QQCustomDialog f177016c;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<f> f177017d;

    /* renamed from: e, reason: collision with root package name */
    protected int f177018e;

    /* renamed from: f, reason: collision with root package name */
    protected int f177019f;

    /* renamed from: g, reason: collision with root package name */
    protected f f177020g;

    /* renamed from: h, reason: collision with root package name */
    protected String f177021h;

    /* renamed from: i, reason: collision with root package name */
    protected String f177022i;

    /* renamed from: j, reason: collision with root package name */
    protected String f177023j;

    /* renamed from: k, reason: collision with root package name */
    protected int f177024k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f177025l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f177026m;

    /* renamed from: n, reason: collision with root package name */
    protected Bundle f177027n;

    /* renamed from: o, reason: collision with root package name */
    protected String f177028o;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f177029p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f177030q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f177031r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f177032s;

    /* renamed from: t, reason: collision with root package name */
    INetEventHandler f177033t;

    /* renamed from: u, reason: collision with root package name */
    private TransProcessorHandler f177034u;

    /* renamed from: v, reason: collision with root package name */
    List<FileManagerEntity> f177035v;

    /* renamed from: w, reason: collision with root package name */
    FMObserver f177036w;

    /* renamed from: x, reason: collision with root package name */
    DialogInterface.OnClickListener f177037x;

    /* renamed from: y, reason: collision with root package name */
    DialogInterface.OnClickListener f177038y;

    /* renamed from: z, reason: collision with root package name */
    DialogInterface.OnClickListener f177039z;

    /* loaded from: classes9.dex */
    class a extends TransProcessorHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SendMultiPictureHelper.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i16 = message.what;
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SendMultiPictureHelper", 2, "file is null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SendMultiPictureHelper", 2, "transferListener status: " + i16);
            }
            IHttpCommunicatorListener findProcessor = ((ITransFileController) SendMultiPictureHelper.this.f177015b.getRuntimeService(ITransFileController.class)).findProcessor(fileMsg.mUin + fileMsg.uniseq);
            if (findProcessor instanceof BaseTransProcessor) {
                i3 = ((BaseTransProcessor) findProcessor).getProgress();
            } else {
                i3 = 0;
            }
            SendMultiPictureHelper sendMultiPictureHelper = SendMultiPictureHelper.this;
            if (sendMultiPictureHelper.f177032s) {
                return;
            }
            if (sendMultiPictureHelper.f177026m) {
                int i17 = fileMsg.status;
                if (i17 == 1005) {
                    sendMultiPictureHelper.f177031r = true;
                    return;
                } else if (i17 != 1003) {
                    sendMultiPictureHelper.l(sendMultiPictureHelper.f177024k, sendMultiPictureHelper.f177021h, fileMsg.uniseq);
                    return;
                } else {
                    sendMultiPictureHelper.o();
                    return;
                }
            }
            int i18 = fileMsg.status;
            if (i18 == 1003) {
                QQCustomDialog qQCustomDialog = sendMultiPictureHelper.f177016c;
                if (qQCustomDialog != null) {
                    qQCustomDialog.setMessage(String.format(sendMultiPictureHelper.f177028o, Integer.valueOf(sendMultiPictureHelper.f177018e + 1), Integer.valueOf(SendMultiPictureHelper.this.f177019f), 100));
                }
                SendMultiPictureHelper.this.o();
                return;
            }
            if (i18 == 1005) {
                sendMultiPictureHelper.o();
                return;
            }
            QQCustomDialog qQCustomDialog2 = sendMultiPictureHelper.f177016c;
            if (qQCustomDialog2 != null) {
                qQCustomDialog2.setMessage(String.format(sendMultiPictureHelper.f177028o, Integer.valueOf(sendMultiPictureHelper.f177018e + 1), Integer.valueOf(SendMultiPictureHelper.this.f177019f), Integer.valueOf(i3)));
            }
        }
    }

    /* loaded from: classes9.dex */
    class b extends FMObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SendMultiPictureHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
                return;
            }
            QLog.w("SendMultiPictureHelper", 2, "OnFileTransferEnd");
            SendMultiPictureHelper sendMultiPictureHelper = SendMultiPictureHelper.this;
            if (!sendMultiPictureHelper.f177026m) {
                synchronized (sendMultiPictureHelper.f177017d) {
                    SendMultiPictureHelper.this.o();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void T(boolean z16, long j3, long j16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3));
                return;
            }
            QLog.w("SendMultiPictureHelper", 2, "OnFileTransferProgress");
            SendMultiPictureHelper sendMultiPictureHelper = SendMultiPictureHelper.this;
            if (sendMultiPictureHelper.f177035v != null) {
                int i16 = 0;
                while (true) {
                    if (i16 < SendMultiPictureHelper.this.f177017d.size()) {
                        if (SendMultiPictureHelper.this.f177017d.get(i16).f177050b == j3) {
                            break;
                        } else {
                            i16++;
                        }
                    } else {
                        i16 = -1;
                        break;
                    }
                }
                if (i16 != -1) {
                    for (int i17 = 0; i17 < SendMultiPictureHelper.this.f177035v.size(); i17++) {
                        FileManagerEntity fileManagerEntity = SendMultiPictureHelper.this.f177035v.get(i17);
                        if (fileManagerEntity.uniseq == j3) {
                            SendMultiPictureHelper sendMultiPictureHelper2 = SendMultiPictureHelper.this;
                            QQCustomDialog qQCustomDialog = sendMultiPictureHelper2.f177016c;
                            if (qQCustomDialog != null) {
                                qQCustomDialog.setMessage(String.format(sendMultiPictureHelper2.f177028o, Integer.valueOf(sendMultiPictureHelper2.f177018e + 1), Integer.valueOf(SendMultiPictureHelper.this.f177019f), Integer.valueOf((int) (fileManagerEntity.fProgress * 100.0f))));
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            sendMultiPictureHelper.f177035v = sendMultiPictureHelper.f177015b.getFileManagerProxy().r();
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void U(long j3, long j16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3));
                return;
            }
            QLog.w("SendMultiPictureHelper", 2, "OnFileTransferStart");
            SendMultiPictureHelper sendMultiPictureHelper = SendMultiPictureHelper.this;
            QQCustomDialog qQCustomDialog = sendMultiPictureHelper.f177016c;
            if (qQCustomDialog != null) {
                qQCustomDialog.setMessage(String.format(sendMultiPictureHelper.f177028o, Integer.valueOf(sendMultiPictureHelper.f177018e + 1), Integer.valueOf(SendMultiPictureHelper.this.f177019f), 0));
            }
            SendMultiPictureHelper sendMultiPictureHelper2 = SendMultiPictureHelper.this;
            sendMultiPictureHelper2.f177035v = sendMultiPictureHelper2.f177015b.getFileManagerProxy().r();
        }
    }

    /* loaded from: classes9.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SendMultiPictureHelper.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            SendMultiPictureHelper sendMultiPictureHelper = SendMultiPictureHelper.this;
            if (!sendMultiPictureHelper.f177025l) {
                sendMultiPictureHelper.f177016c.cancel();
                SendMultiPictureHelper sendMultiPictureHelper2 = SendMultiPictureHelper.this;
                sendMultiPictureHelper2.f177026m = true;
                sendMultiPictureHelper2.k();
                SendMultiPictureHelper.this.p();
            }
        }
    }

    /* loaded from: classes9.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SendMultiPictureHelper.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            SendMultiPictureHelper sendMultiPictureHelper = SendMultiPictureHelper.this;
            sendMultiPictureHelper.f177026m = true;
            sendMultiPictureHelper.f();
            SendMultiPictureHelper.this.f177014a.setResult(-1);
            SendMultiPictureHelper.this.f177014a.finish();
        }
    }

    /* loaded from: classes9.dex */
    class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SendMultiPictureHelper.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            SendMultiPictureHelper.this.f177016c.show();
            SendMultiPictureHelper sendMultiPictureHelper = SendMultiPictureHelper.this;
            sendMultiPictureHelper.f177026m = false;
            sendMultiPictureHelper.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f177049a;

        /* renamed from: b, reason: collision with root package name */
        public volatile long f177050b;

        protected f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SendMultiPictureHelper.this);
            }
        }
    }

    public SendMultiPictureHelper(BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseActivity);
            return;
        }
        this.f177018e = 0;
        this.f177019f = 0;
        this.f177025l = false;
        this.f177026m = false;
        this.f177030q = true;
        this.f177031r = false;
        this.f177032s = false;
        this.f177033t = null;
        this.f177034u = new a();
        this.f177035v = null;
        this.f177036w = new b();
        this.f177037x = new c();
        this.f177038y = new d();
        this.f177039z = new e();
        this.f177014a = baseActivity;
        this.f177015b = (QQAppInterface) baseActivity.getAppRuntime();
        this.f177028o = this.f177014a.getString(R.string.hey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f177020g.f177050b == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("SendMultiPictureHelper", 2, "uniseq -1");
                return;
            }
            return;
        }
        BaseTransProcessor baseTransProcessor = (BaseTransProcessor) ((ITransFileController) this.f177015b.getRuntimeService(ITransFileController.class)).findProcessor(this.f177021h + this.f177020g.f177050b);
        if (baseTransProcessor != null) {
            baseTransProcessor.stop();
            ((ITransFileController) this.f177015b.getRuntimeService(ITransFileController.class)).removeProcessor(this.f177021h + this.f177020g.f177050b);
            if (QLog.isColorLevel()) {
                QLog.d("SendMultiPictureHelper", 2, "stop send " + this.f177021h + this.f177020g.f177050b);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SendMultiPictureHelper", 2, "processor null");
        }
    }

    private long g(String str, String str2, String str3, int i3) {
        if (str == null) {
            return 0L;
        }
        MessageForPic q16 = com.tencent.mobileqq.service.message.q.q(this.f177015b, str3, str2, i3);
        q16.path = str;
        q16.size = 0L;
        q16.type = 1;
        q16.isRead = true;
        q16.localUUID = com.tencent.mobileqq.pic.p.i();
        q16.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(q16.path));
        q16.serial();
        this.f177015b.getMessageFacade().c(q16, this.f177015b.getCurrentAccountUin());
        return q16.uniseq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long j(String str, int i3, String str2, String str3) {
        if (!FileUtils.fileExists(str)) {
            return 0L;
        }
        if (i3 == 1 || i3 == 0 || i3 == 1001 || i3 == 10002 || i3 == 3000) {
            com.tencent.mobileqq.utils.aw.m(-1L, i3, true, "compress_start", "SendMultiPictureHelper.doSendPictues");
            String j3 = com.tencent.mobileqq.utils.aw.j(this.f177014a, str, i3);
            ImageInfo imageInfo = new ImageInfo();
            com.tencent.mobileqq.utils.aw.c(4, this.f177014a, str, j3, true, imageInfo, i3);
            str = imageInfo.f184139m;
        }
        if (!com.tencent.mobileqq.utils.aw.q(null, str, 1, null, "SendMultiPictureHelper.doSendPictues")) {
            return 0L;
        }
        long g16 = g(str, str2, str3, i3);
        com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
        fVar.l(fVar.c(i3, str3, str3), str);
        if (QLog.isColorLevel()) {
            QLog.d(BuddyTransfileProcessor.TAG, 2, "ChatActivity.handleForwardData uploadImage,uniseq:" + g16 + ",filePath:" + str + ",curType:" + i3);
        }
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3, String str, long j3) {
        IHttpCommunicatorListener findProcessor = ((ITransFileController) this.f177015b.getRuntimeService(ITransFileController.class)).findProcessor(str + j3);
        if (findProcessor instanceof BaseTransProcessor) {
            ((BaseTransProcessor) findProcessor).pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        BaseTransProcessor baseTransProcessor = (BaseTransProcessor) ((ITransFileController) this.f177015b.getRuntimeService(ITransFileController.class)).findProcessor(this.f177021h + this.f177020g.f177050b);
        if (baseTransProcessor != null) {
            if (this.f177031r) {
                this.f177031r = false;
                QLog.w("SendMultiPictureHelper", 2, this.f177021h + this.f177020g.f177050b + "has error");
                baseTransProcessor.stop();
                o();
            } else {
                baseTransProcessor.resume();
            }
            QLog.w("SendMultiPictureHelper", 2, "continue send " + this.f177021h + this.f177020g.f177050b);
            return;
        }
        QLog.w("SendMultiPictureHelper", 2, "processor null");
        if (this.f177031r) {
            o();
        }
        this.f177031r = false;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ((ITransFileController) this.f177015b.getRuntimeService(ITransFileController.class)).removeHandle(this.f177034u);
        this.f177015b.getFileManagerNotifyCenter().deleteObserver(this.f177036w);
        try {
            this.f177016c.dismiss();
        } catch (Exception unused) {
        }
        this.f177016c = null;
        INetEventHandler iNetEventHandler = this.f177033t;
        if (iNetEventHandler != null) {
            AppNetConnInfo.unregisterNetEventHandler(iNetEventHandler);
        }
        ArrayList<f> arrayList = this.f177017d;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    void i(f fVar, int i3, String str, String str2) {
        ThreadManager.getFileThreadHandler().post(new Runnable(fVar, i3, str, str2) { // from class: com.tencent.mobileqq.activity.SendMultiPictureHelper.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ f f177040d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f177041e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f177042f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f177043h;

            {
                this.f177040d = fVar;
                this.f177041e = i3;
                this.f177042f = str;
                this.f177043h = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SendMultiPictureHelper.this, fVar, Integer.valueOf(i3), str, str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    f fVar2 = this.f177040d;
                    fVar2.f177050b = SendMultiPictureHelper.this.j(fVar2.f177049a, this.f177041e, this.f177042f, this.f177043h);
                }
            }
        });
    }

    public void n(String str, String str2, int i3, String str3, Bundle bundle, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), str3, bundle, arrayList);
            return;
        }
        this.f177021h = str2;
        this.f177022i = str;
        this.f177024k = i3;
        this.f177023j = str3;
        this.f177027n = bundle;
        this.f177029p = bundle.getBoolean("sendMultiple", false);
        ((ITransFileController) this.f177015b.getRuntimeService(ITransFileController.class)).addHandle(this.f177034u);
        this.f177034u.addFilter(BuddyTransfileProcessor.class, ((IPicTransFile) this.f177015b.getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPicTransFile) this.f177015b.getRuntimeService(IPicTransFile.class)).getGroupUploadProClass(), ForwardImageProcessor.class);
        BaseActivity baseActivity = this.f177014a;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(baseActivity, 230, this.f177023j, baseActivity.getString(R.string.a8u), null, this.f177037x);
        this.f177016c = createCustomDialog;
        createCustomDialog.setCanceledOnTouchOutside(false);
        this.f177016c.setCancelable(false);
        this.f177016c.show();
        this.f177017d = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            f fVar = new f();
            fVar.f177049a = next;
            fVar.f177050b = -1L;
            this.f177017d.add(fVar);
        }
        String str4 = this.f177017d.get(0).f177049a;
        this.f177019f = this.f177017d.size();
        this.f177020g = this.f177017d.get(0);
        this.f177018e = 0;
        if (!NetworkUtil.isNetSupport(this.f177014a)) {
            this.f177032s = true;
            this.f177015b.getFileManagerNotifyCenter().deleteObserver(this.f177036w);
            int i16 = 0;
            while (i16 < this.f177017d.size()) {
                int i17 = i16 + 1;
                this.f177016c.setMessage(String.format(this.f177028o, Integer.valueOf(i17), Integer.valueOf(this.f177019f), 0));
                i(this.f177017d.get(i16), this.f177024k, this.f177022i, this.f177021h);
                i16 = i17;
            }
            s();
            return;
        }
        int i18 = 0;
        while (i18 < this.f177017d.size()) {
            int i19 = i18 + 1;
            this.f177016c.setMessage(String.format(this.f177028o, Integer.valueOf(i19), Integer.valueOf(this.f177019f), 0));
            i(this.f177017d.get(i18), this.f177024k, this.f177022i, this.f177021h);
            s();
            i18 = i19;
        }
    }

    void o() {
        synchronized (this.f177017d) {
            if (this.f177017d.size() > 0) {
                this.f177017d.remove(0);
            }
            if (QLog.isColorLevel()) {
                QLog.e("SendMultiPictureHelper", 2, "sendNext " + (this.f177018e + 1));
            }
            this.f177018e++;
            if (this.f177017d.size() > 0) {
                f fVar = this.f177017d.get(0);
                String str = fVar.f177049a;
                this.f177020g = fVar;
                File file = new File(str);
                if (!file.exists()) {
                    this.f177031r = true;
                    r(file.getName() + HardCodeUtil.qqStr(R.string.f172683tb3));
                    if (!this.f177026m) {
                        o();
                    }
                    return;
                }
                if (file.length() == 0) {
                    if (this.f177024k == 0) {
                        q(R.string.b85);
                    } else {
                        q(R.string.cvv);
                    }
                }
                i(fVar, this.f177024k, this.f177022i, this.f177021h);
            } else {
                QQCustomDialog qQCustomDialog = this.f177016c;
                if (qQCustomDialog != null) {
                    qQCustomDialog.cancel();
                }
                s();
            }
        }
    }

    void p() {
        String string = this.f177014a.getString(R.string.a8w);
        BaseActivity baseActivity = this.f177014a;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(baseActivity, 230, baseActivity.getString(R.string.f173206i10), string, R.string.bjz, R.string.f171142no, this.f177039z, this.f177038y);
        createCustomDialog.setCancelable(false);
        createCustomDialog.show();
    }

    void q(int i3) {
        QQToast.makeText(BaseApplicationImpl.getApplication(), this.f177014a.getString(i3), 0).show();
    }

    void r(String str) {
        QQToast.makeText(BaseApplicationImpl.getApplication(), str, 0).show();
    }

    void s() {
        if (this.f177029p && !this.f177030q) {
            return;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.f177014a), new int[]{2});
        m3.putExtra("isFromShare", true);
        m3.putExtras(this.f177027n);
        if (this.f177029p) {
            m3.putExtra("open_chatfragment", false);
            if (m3.getBooleanExtra("is_need_show_toast", true)) {
                ForwardUtils.s0(this.f177015b, 500L);
            }
            this.f177030q = false;
        }
        this.f177014a.startActivity(m3);
        this.f177014a.setResult(-1);
        this.f177014a.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
    }
}
