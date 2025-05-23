package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class ForwardFileBaseOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;
    protected static String C;

    /* renamed from: d, reason: collision with root package name */
    ForwardFileInfo f210624d;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<ForwardFileInfo> f210625e;

    /* renamed from: f, reason: collision with root package name */
    UriParserPathHelper f210626f;

    /* renamed from: h, reason: collision with root package name */
    protected String f210627h;

    /* renamed from: i, reason: collision with root package name */
    protected long f210628i;

    /* renamed from: m, reason: collision with root package name */
    protected String f210629m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.forward.ForwardFileBaseOption$3, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f210631d;

        AnonymousClass3(Uri uri) {
            this.f210631d = uri;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileBaseOption.this, (Object) uri);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ForwardFileBaseOption.this.t(this.f210631d, true, new UriParserPathHelper.GetPathFromUriCallback() { // from class: com.tencent.mobileqq.forward.ForwardFileBaseOption.3.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.haoliyou.UriParserPathHelper.GetPathFromUriCallback
                    public void onFinish(@Nullable String str) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                        } else {
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable(str) { // from class: com.tencent.mobileqq.forward.ForwardFileBaseOption.3.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f210633d;

                                {
                                    this.f210633d = str;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) str);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        ForwardFileBaseOption.this.o(anonymousClass3.f210631d, this.f210633d);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileBaseOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ForwardFileBaseOption.this.mActivity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements UriParserPathHelper.IOnFileCopyFinishListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileBaseOption.this);
            }
        }

        @Override // com.tencent.mobileqq.haoliyou.UriParserPathHelper.IOnFileCopyFinishListener
        public void onFaild(Uri uri) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uri);
            }
        }

        @Override // com.tencent.mobileqq.haoliyou.UriParserPathHelper.IOnFileCopyFinishListener
        public void onFinish(String str, String str2, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3));
            } else {
                ForwardFileBaseOption forwardFileBaseOption = ForwardFileBaseOption.this;
                forwardFileBaseOption.mForwardText = forwardFileBaseOption.s(str2, j3);
            }
        }
    }

    public ForwardFileBaseOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210625e = new ArrayList<>();
        this.f210627h = "";
        this.f210628i = 0L;
        this.f210629m = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(Uri uri, String str) {
        boolean z16;
        boolean z17;
        if (TextUtils.isEmpty(str)) {
            if (this.f210626f != null) {
                C = UriParserPathHelper.f236761msg;
            }
            y(p());
            return false;
        }
        File file = new File(str);
        long length = file.length();
        UriParserPathHelper uriParserPathHelper = this.f210626f;
        if (uriParserPathHelper != null && uriParserPathHelper.isCopying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        UriParserPathHelper uriParserPathHelper2 = this.f210626f;
        if (uriParserPathHelper2 != null) {
            z17 = uriParserPathHelper2.waiting;
        } else {
            z17 = false;
        }
        if (!z16 && !z17 && length == 0) {
            if (uri.toString().contains("mms/part")) {
                y(this.mAppContext.getString(R.string.b8k));
            } else {
                y(this.mAppContext.getString(R.string.b85));
            }
            return false;
        }
        if (true == this.mExtraData.getBoolean(AppConstants.Key.FORWARD_IS_FROMJUMP) && true == this.mExtraData.getBoolean("isFromShare") && v(str)) {
            y(this.mAppContext.getString(R.string.b87));
            return false;
        }
        String name = file.getName();
        boolean canRead = file.canRead();
        if (!z16 && !z17 && !canRead) {
            this.mForwardText = this.mExtraData.getString("android.intent.extra.TEXT");
            this.mExtraData.putInt("forward_type", -1);
            return false;
        }
        this.mExtraData.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        w(str);
        this.mForwardText = s(name, length);
        this.f210629m = name;
        this.f210627h = str;
        this.f210628i = length;
        return true;
    }

    private boolean q(Uri uri) {
        String stringExtra = this.mIntent.getStringExtra("path_for_file_scheme");
        QLog.d("ForwardOption.ForwardFileBaseOption", 1, "getFileInfo fileScheme = " + stringExtra);
        if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(uri.getPath())) {
            uri = Uri.parse("file://" + stringExtra);
        }
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("get_forward_file_uri_switch", true)) {
            ThreadManagerV2.excute(new AnonymousClass3(uri), 64, null, true);
        } else {
            o(uri, t(uri, false, null));
        }
        return true;
    }

    public static String r(Context context, Uri uri) {
        return FileProvider7Helper.getRealPathFromContentURI(context, uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s(String str, long j3) {
        String str2;
        if (j3 < 1024) {
            str2 = j3 + " bytes";
        } else if (j3 < 1048576) {
            str2 = (j3 / 1024) + " KB";
        } else {
            str2 = new DecimalFormat("##0.00").format(j3 / 1048576.0d) + " MB";
        }
        return this.mAppContext.getString(R.string.b8g) + str + "\n" + this.mAppContext.getString(R.string.b8s) + str2;
    }

    public static boolean v(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("/data/data/com.tencent.mobileqq/")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str) {
        Activity activity;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            activity = QBaseActivity.sTopActivity;
        } else {
            activity = this.mActivity;
        }
        if (activity == null) {
            QLog.e("ForwardOption.ForwardFileBaseOption", 1, "showErrorMsg is error, activity is null!");
            return;
        }
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(this.mAppContext.getString(R.string.f173206i10));
        qQCustomDialog.setMessage(str);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setNegativeButton(this.mAppContext.getString(R.string.button_back), new a());
        try {
            if (activity.isFinishing()) {
                QLog.e("ForwardOption.ForwardFileBaseOption", 1, "showErrorMsg is error, activity is invalid!");
            } else {
                qQCustomDialog.show();
            }
        } catch (Exception unused) {
            QLog.e("ForwardOption.ForwardFileBaseOption", 1, "showErrorMsg is error, show exception!");
        }
    }

    private void y(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            x(str);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(str) { // from class: com.tencent.mobileqq.forward.ForwardFileBaseOption.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f210630d;

                {
                    this.f210630d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileBaseOption.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ForwardFileBaseOption.this.x(this.f210630d);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.adjustDialogProperty();
        this.mConfirmDialog.adjustMessageBottomMargin(17.0f);
        this.mConfirmDialog.setMessageTextColor(R.color.f157116k8);
        this.mConfirmDialog.setMessageTextSize(14.0f);
    }

    protected String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = C;
        if (str == null) {
            return this.mAppContext.getString(R.string.hiy);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        C = null;
        Uri data = this.mIntent.getData();
        if (data != null && TextUtils.isEmpty(this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH))) {
            q(data);
        }
        this.f210624d = (ForwardFileInfo) this.mIntent.getParcelableExtra("fileinfo");
        this.f210625e = this.mIntent.getParcelableArrayListExtra("fileinfo_array");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        Intent m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.mExtraData.getInt("uintype") == 1008) {
            m3 = new Intent(this.mActivity, (Class<?>) ChatActivity.class);
            m3.putExtra("chat_subType", ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass(this.mExtraData.getString("uin"), this.app));
        } else {
            m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
        }
        if (this.mIntent.getBooleanExtra("sendMultiple", false)) {
            this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mox));
            m3.addFlags(268435456);
            m3.addFlags(67108864);
            m3.putExtras(this.mExtraData);
            boolean handleForwardFromFavorite = handleForwardFromFavorite(m3);
            if (this.isFormJump) {
                this.mActivity.startActivity(m3);
            } else if (!handleForwardFromFavorite) {
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
            }
        }
        m3.putExtras(this.mExtraData);
        this.mActivity.setResult(-1, m3);
        this.mActivity.finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String t(Uri uri, boolean z16, UriParserPathHelper.GetPathFromUriCallback getPathFromUriCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, uri, Boolean.valueOf(z16), getPathFromUriCallback);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardFileBaseOption", 2, "getPathFromUri uri= " + uri);
        }
        if (this.f210626f == null) {
            this.f210626f = new UriParserPathHelper(this.mActivity, true, new b());
        }
        if (z16) {
            this.f210626f.asyncGetPathFromUri(uri, getPathFromUriCallback);
            return "";
        }
        return this.f210626f.getPathFromUri(uri);
    }

    public long u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.f210628i;
    }

    protected void w(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }
}
