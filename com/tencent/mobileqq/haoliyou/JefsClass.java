package com.tencent.mobileqq.haoliyou;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bigbrother.JumpConfirmFragment;
import com.tencent.mobileqq.bigbrother.TeleScreenConfig;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable;
import com.tencent.mobileqq.bigbrother.a;
import com.tencent.mobileqq.bigbrother.c;
import com.tencent.mobileqq.bigbrother.d;
import com.tencent.mobileqq.haoliyou.CheckInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.vivo.push.PushClientConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JefsClass extends IATHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String ACTION_REMOVE = "com.tencent.mobileqq.telescreen.action_remove";
    private static final String ACTION_RUN = "com.tencent.mobileqq.telescreen.action_run";
    public static final String ACTION_SESSION_INSTALL = "android.content.pm.action.CONFIRM_INSTALL";
    private static final String ANDROID_QQDOWNLOADER = "com.tencent.android.qqdownloader";
    public static final String AUTHORITY_OPEN_PAY = "open_pay";
    public static final String AUTHORITY_SDK_WAKE = "sdk_wake";
    public static final String AUTHORITY_SPACECLEAN = "spaceclean";
    public static final String AUTHORITY_SSL_PTLOGIN2_QQ_COM = "ssl.ptlogin2.qq.com";
    public static final String AUTHORITY_TAUTH_QQ_COM = "tauth.qq.com";
    public static final String DOWNLOAD_MIME_TYPE = "downloadmimetype";
    public static final String DOWNLOAD_URL = "downloadurl";
    public static final String DOWNL_URL = "downl_url";
    public static final String EXTRA_KEY_DIALOG_CANCEL_TEXT = "extra_key_dialog_cancel_text";
    public static final String EXTRA_KEY_DIALOG_CONFIRM_TEXT = "extra_key_dialog_confirm_text";
    public static final String EXTRA_KEY_DIALOG_CONTENT_TEXT = "extra_key_dialog_content_text";
    public static final String EXTRA_KEY_IS_CUSTOM_DIALOG_TEXT = "extra_key_is_custom_dialog_text";
    public static final String FILE_PATH = "filepath";
    public static final String INDEX_URL = ",url=";
    public static final String INTENT_INSTALL_TYPE = "application/vnd.android.package-archive";
    public static final String KEY_ID = "key_id";
    public static final String KEY_IS_TO_DOWNLOAD = "keyIsDownLoad";
    public static final String KEY_PROCESS_ID = "key_process_id";
    public static final String LIVE_PUSH_PUSHACTIVITY = "com.live.push.PushActivity";
    public static final String MIME_TYPE = "mimetype";
    public static final String PACKAGE_NAME = "packageName";
    public static final String PATH_JUMP = "/jump";
    private static final String SCHEME_HTTP = "http://";
    private static final String SCHEME_HTTPS = "https://";
    public static final String SCHEME_HTTPS_PREFIX = "https";
    private static final String SCHEME_MTT = "mttbrowser://";
    public static final String SCHEME_QWALLET = "qwallet";
    public static final String SCHEME_TENCENT = "tencent";
    private static final String SCHEME_TENCENT_FILE = "tencentfile://";
    private static final String SCHEME_YYB = "tmast://";
    public static final String SCHEME_YYB_PREFIX = "tmast";
    private static final Set<String> SKIP_ACTION;
    private static final Set<String> SKIP_PKG;
    public static final String TAG = "TeleScreen|JefsClass";
    private static final IUriChecker[] URI_CHECKERS;
    public static final String YYB_INSTALL_URL = "yyb_install_url";
    private static final JefsClass instance;

    @Nullable
    private static IJefsClassInjectInterface sInjectInterface;
    private final ThreadLocal<Boolean> hasChecked;

    /* renamed from: id, reason: collision with root package name */
    private int f236760id;
    private String mRefID;
    private String mSourceID;
    private TeleScreenReceiver receiver;
    private final SparseArrayCompat<Runnable> todoList;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class Cancelable {
        static IPatchRedirector $redirector_;
        final CancelableRunnable runnable;

        Cancelable(CancelableRunnable cancelableRunnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancelableRunnable);
            } else {
                this.runnable = cancelableRunnable;
            }
        }

        public void setCanceled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.runnable.canceled = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class CancelableRunnable implements Runnable, IdSetter {
        static IPatchRedirector $redirector_;
        private boolean canceled;
        private final WeakOuterRefRunnable todo;

        CancelableRunnable(WeakOuterRefRunnable weakOuterRefRunnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakOuterRefRunnable);
            } else {
                this.canceled = false;
                this.todo = weakOuterRefRunnable;
            }
        }

        public Cancelable getCancelable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Cancelable) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new Cancelable(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!this.canceled) {
                JefsClass.getInstance().run(this.todo);
            } else if (QLog.isColorLevel()) {
                QLog.d("TeleScreen|JefsClass", 2, "canceled");
            }
        }

        @Override // com.tencent.mobileqq.haoliyou.JefsClass.IdSetter
        public void setId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                this.todo.setId(str);
            }
        }

        @Override // com.tencent.mobileqq.haoliyou.JefsClass.IdSetter
        public void setJumpAction(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.todo.setJumpAction(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class HttpsScheme implements IUriChecker {
        static IPatchRedirector $redirector_;

        public HttpsScheme() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.haoliyou.IUriChecker
        public boolean isSkip(@NonNull Uri uri) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uri)).booleanValue();
            }
            if ("https".equals(uri.getScheme()) && JefsClass.AUTHORITY_SSL_PTLOGIN2_QQ_COM.equals(uri.getAuthority()) && JefsClass.PATH_JUMP.equals(uri.getPath())) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IdSetter {
        void setId(String str);

        void setJumpAction(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface Interceptor {
        void checkAndDo(String str, String str2, String str3, String str4, String str5, List<ResolveInfo> list, CancelableRunnable cancelableRunnable);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class QWalletScheme implements IUriChecker {
        static IPatchRedirector $redirector_;

        public QWalletScheme() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.haoliyou.IUriChecker
        public boolean isSkip(@NonNull Uri uri) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uri)).booleanValue();
            }
            if (uri.getScheme() != null && uri.getScheme().startsWith("qwallet") && JefsClass.AUTHORITY_OPEN_PAY.equals(uri.getAuthority())) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class TeleScreenReceiver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        TeleScreenReceiver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) JefsClass.this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (!MobileQQ.processName.equals(intent.getStringExtra("key_process_id"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TeleScreen|JefsClass", 2, "is not current process");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TeleScreen|JefsClass", 2, "start");
            }
            if (JefsClass.ACTION_RUN.equals(intent.getAction())) {
                JefsClass.this.runInternal(intent.getIntExtra("key_id", 0), intent.getIntExtra("key_callback_id", 0));
            } else if (JefsClass.ACTION_REMOVE.equals(intent.getAction())) {
                JefsClass.this.removeInternal(intent.getIntExtra("key_id", 0), intent.getIntExtra("key_callback_id", 0));
            }
        }

        /* synthetic */ TeleScreenReceiver(JefsClass jefsClass, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jefsClass, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class TencentScheme implements IUriChecker {
        static IPatchRedirector $redirector_;

        public TencentScheme() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.haoliyou.IUriChecker
        public boolean isSkip(@NonNull Uri uri) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uri)).booleanValue();
            }
            if (uri.getScheme() != null && uri.getScheme().startsWith("tencent") && JefsClass.AUTHORITY_TAUTH_QQ_COM.equals(uri.getAuthority())) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class TmastScheme implements IUriChecker {
        static IPatchRedirector $redirector_;

        public TmastScheme() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.haoliyou.IUriChecker
        public boolean isSkip(@NonNull Uri uri) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uri)).booleanValue();
            }
            if (JefsClass.SCHEME_YYB_PREFIX.equals(uri.getScheme()) && (JefsClass.AUTHORITY_SDK_WAKE.equals(uri.getAuthority()) || JefsClass.AUTHORITY_SPACECLEAN.equals(uri.getAuthority()))) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43581);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        URI_CHECKERS = new IUriChecker[]{new TencentScheme(), new QWalletScheme(), new TmastScheme(), new HttpsScheme()};
        QLog.d("TeleScreen|JefsClass", 1, "JefsClassInjectUtil newInstance");
        if (JefsClassInjectUtil.sInjectInterfaceList.size() > 0) {
            sInjectInterface = JefsClassInjectUtil.sInjectInterfaceList.get(0);
        }
        ArraySet arraySet = new ArraySet();
        SKIP_ACTION = arraySet;
        arraySet.add("android.settings.ACCESSIBILITY_SETTINGS");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            arraySet.add("android.settings.APP_NOTIFICATION_SETTINGS");
        }
        if (i3 >= 24) {
            arraySet.add("android.settings.MANAGE_DEFAULT_APPS_SETTINGS");
        }
        arraySet.add("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        arraySet.add("android.settings.action.MANAGE_WRITE_SETTINGS");
        arraySet.add("android.settings.NFC_PAYMENT_SETTINGS");
        arraySet.add("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
        arraySet.add("android.settings.NFC_SETTINGS");
        arraySet.add("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
        arraySet.add("android.settings.APPLICATION_DETAILS_SETTINGS");
        arraySet.add("android.settings.BLUETOOTH_SETTINGS");
        arraySet.add("android.settings.DATA_ROAMING_SETTINGS");
        arraySet.add("android.settings.DATE_SETTINGS");
        arraySet.add("android.settings.INTERNAL_STORAGE_SETTINGS");
        arraySet.add("android.settings.MEMORY_CARD_SETTINGS");
        arraySet.add("android.settings.LOCALE_SETTINGS");
        arraySet.add("android.settings.LOCATION_SOURCE_SETTINGS");
        arraySet.add("android.settings.NFCSHARING_SETTINGS");
        arraySet.add("android.settings.SETTINGS");
        arraySet.add("android.settings.WIFI_SETTINGS");
        arraySet.add("android.settings.WIRELESS_SETTINGS");
        arraySet.add("android.media.action.IMAGE_CAPTURE");
        arraySet.add("android.intent.action.PICK");
        arraySet.add("android.intent.action.CALL");
        arraySet.add("android.intent.action.DIAL");
        arraySet.add("android.intent.action.CALL_BUTTON");
        arraySet.add("android.intent.action.SENDTO");
        arraySet.add("android.intent.action.GET_CONTENT");
        arraySet.add("android.intent.action.RINGTONE_PICKER");
        arraySet.add("android.content.pm.CONFIRM_ACCESS_APPCATONS");
        arraySet.add("com.meizu.safe.security.SHOW_APPSEC");
        arraySet.add("miui.intent.action.APP_PERM_EDITOR");
        arraySet.add("android.intent.action.INSERT_OR_EDIT");
        arraySet.add("android.intent.action.INSERT");
        arraySet.add("com.android.action.PARENTAL_CREDENTIAL_AUTHENTICATE");
        ArraySet arraySet2 = new ArraySet();
        SKIP_PKG = arraySet2;
        arraySet2.add(BaseApplication.getContext().getPackageName());
        arraySet2.add("com.android.settings");
        arraySet2.add("com.miui.securitycenter");
        arraySet2.add("com.miui.system");
        arraySet2.add("com.zui.safecenter");
        arraySet2.add("com.android.mms");
        arraySet2.add("com.sonymobile.cta");
        arraySet2.add("com.huawei.systemmanager");
        arraySet2.add("com.sec.android.app.capabilitymanager");
        arraySet2.add("com.coloros.safecenter");
        arraySet2.add("com.iqoo.secure");
        arraySet2.add(PushClientConstants.COM_ANDROID_SYSTEMUI);
        instance = new JefsClass();
    }

    public JefsClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.hasChecked = new ThreadLocal<Boolean>() { // from class: com.tencent.mobileqq.haoliyou.JefsClass.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JefsClass.this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.lang.ThreadLocal
                public Boolean initialValue() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Boolean.FALSE : (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            };
            this.todoList = new SparseArrayCompat<>();
        }
    }

    private int addTodo(Runnable runnable) {
        int i3;
        int i16;
        synchronized (this.todoList) {
            do {
                i3 = this.f236760id + 1;
                this.f236760id = i3;
            } while (this.todoList.get(i3) != null);
            i16 = this.f236760id;
            this.todoList.put(i16, runnable);
        }
        return i16;
    }

    private void checkAddCustomBundle(Intent intent, Intent intent2) {
        if (intent2 != null && intent2.getBooleanExtra(EXTRA_KEY_IS_CUSTOM_DIALOG_TEXT, false)) {
            String stringExtra = intent2.getStringExtra(EXTRA_KEY_DIALOG_CONTENT_TEXT);
            String stringExtra2 = intent2.getStringExtra(EXTRA_KEY_DIALOG_CANCEL_TEXT);
            String stringExtra3 = intent2.getStringExtra(EXTRA_KEY_DIALOG_CONFIRM_TEXT);
            intent.putExtra(EXTRA_KEY_IS_CUSTOM_DIALOG_TEXT, true);
            intent.putExtra(EXTRA_KEY_DIALOG_CONTENT_TEXT, stringExtra);
            intent.putExtra(EXTRA_KEY_DIALOG_CANCEL_TEXT, stringExtra2);
            intent.putExtra(EXTRA_KEY_DIALOG_CONFIRM_TEXT, stringExtra3);
        }
    }

    private void checkDownload(Context context, String str, String str2, String str3, String str4, Runnable runnable) {
        if (TextUtils.isEmpty(str)) {
            ReportController.o(null, "dc00898", "", "", "0X8009C58", "0X8009C58", 0, 0, "", "", context.getClass().getName(), str3 != null ? str3 : str4 == null ? "" : str4);
        }
        IJefsClassInjectInterface iJefsClassInjectInterface = sInjectInterface;
        if (iJefsClassInjectInterface == null) {
            return;
        }
        iJefsClassInjectInterface.sendCheckDownloadReq(context, str, str3, str4, str2, new a(runnable, str) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.8
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$src;
            final /* synthetic */ Runnable val$todo;

            {
                this.val$todo = runnable;
                this.val$src = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, JefsClass.this, runnable, str);
                }
            }

            @Override // com.tencent.mobileqq.bigbrother.a
            public boolean autoShowErrPage() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                if (this.val$todo != null) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.mobileqq.bigbrother.a
            public void onDownload(boolean z16, boolean z17, int i3, String str5, String str6) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), str5, str6);
                    return;
                }
                if (!z16 || (z17 && this.val$todo != null)) {
                    JefsClass.this.run(this.val$todo);
                    return;
                }
                String str7 = this.val$src;
                if (str7 == null) {
                    str7 = "";
                }
                ReportController.o(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "1", "", str7, "");
            }
        });
    }

    private void checkJump(Context context, String str, String str2, String str3, String str4, String str5, String str6, List<ResolveInfo> list, CancelableRunnable cancelableRunnable, int i3, Intent intent) {
        String str7;
        if (TextUtils.isEmpty(str)) {
            String name = context.getClass().getName();
            if (str3 != null) {
                str7 = str3;
            } else if (str5 != null) {
                str7 = str5;
            } else if (str6 != null) {
                str7 = str6;
            } else if (str4 == null) {
                str7 = "";
            } else {
                str7 = str4;
            }
            ReportController.o(null, "dc00898", "", "", "0X8009C58", "0X8009C58", 0, 0, "", "", name, str7);
        }
        WeakReference weakReference = new WeakReference(context);
        IJefsClassInjectInterface iJefsClassInjectInterface = sInjectInterface;
        if (iJefsClassInjectInterface == null) {
            return;
        }
        iJefsClassInjectInterface.thirdAppIntercept(context, str, str4, str3, str5, str6, list, str2, new c(cancelableRunnable, weakReference, i3, str, intent) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.9
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$callbackId;
            final /* synthetic */ WeakReference val$ctxRef;
            final /* synthetic */ Intent val$intent;
            final /* synthetic */ String val$src;
            final /* synthetic */ CancelableRunnable val$todo;

            {
                this.val$todo = cancelableRunnable;
                this.val$ctxRef = weakReference;
                this.val$callbackId = i3;
                this.val$src = str;
                this.val$intent = intent;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, JefsClass.this, cancelableRunnable, weakReference, Integer.valueOf(i3), str, intent);
                }
            }

            @Override // com.tencent.mobileqq.bigbrother.c
            public void onJump(boolean z16, int i16, int i17, String str8) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), str8);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TeleScreen|JefsClass", 2, String.format(Locale.CHINA, "onReceive: success: %b, jump: %d, err_code: %d, err_msg: %s", Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), str8));
                }
                if (this.val$todo == null) {
                    return;
                }
                Context context2 = (Context) this.val$ctxRef.get();
                if (context2 == null) {
                    d.b().c(this.val$callbackId, -3);
                    QLog.i("TeleScreen|JefsClass", 1, "context is null");
                    String str9 = this.val$src;
                    if (str9 == null) {
                        str9 = "";
                    }
                    ReportController.o(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "", "1", str9, "");
                    return;
                }
                if (z16 && i16 == 1) {
                    JefsClass.this.run(this.val$todo);
                } else if (!z16 || i16 == 0) {
                    JefsClass.this.confirmJump(context2, this.val$todo, this.val$callbackId, this.val$src, this.val$intent);
                } else {
                    d.b().c(this.val$callbackId, -2);
                }
            }
        });
    }

    private void chooseDownloadType(CheckInfo checkInfo, String str, String str2, CancelableRunnable cancelableRunnable, WeakReference<Context> weakReference) {
        String scheme = checkInfo.getScheme();
        if (isInstallPkg(checkInfo)) {
            installPkg(checkInfo.getIntent(), str, str2, cancelableRunnable, weakReference);
            return;
        }
        if (isOpenHttpLink(scheme)) {
            openHttpLink(checkInfo, str, str2, cancelableRunnable);
            return;
        }
        if (isDownloadMTT(scheme)) {
            downloadMTT(checkInfo, str, str2, cancelableRunnable);
            return;
        }
        if (isDownloadTFile(scheme)) {
            downloadTFile(checkInfo, str, str2, cancelableRunnable);
        } else if (isDownloadYYB(scheme)) {
            downloadYYB(checkInfo, str, str2, cancelableRunnable);
        } else {
            checkJump(checkInfo.getContext(), str, str2, checkInfo.getPackageName(), checkInfo.getUrl(), checkInfo.getScheme(), checkInfo.getAction(), checkInfo.getResolveInfos(), cancelableRunnable, checkInfo.getCallbackId(), checkInfo.getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmJump(Context context, CancelableRunnable cancelableRunnable, int i3, String str, Intent intent) {
        Activity activity;
        try {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            Activity activity2 = activity;
            if (activity2 != null && !activity2.isFinishing()) {
                setupDialog(cancelableRunnable, i3, str, activity2, intent);
            } else {
                setupFragment(cancelableRunnable, i3, str, intent);
            }
        } catch (Throwable th5) {
            QLog.e("TeleScreen|JefsClass", 1, th5, new Object[0]);
            run(cancelableRunnable);
        }
    }

    static boolean containQQ(List<ResolveInfo> list) {
        if (list == null) {
            return false;
        }
        String packageName = BaseApplication.getContext().getPackageName();
        Iterator<ResolveInfo> it = list.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && packageName.equals(activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    private void downloadMTT(CheckInfo checkInfo, String str, String str2, CancelableRunnable cancelableRunnable) {
        ArrayMap<String, String> parseParams = parseParams(checkInfo.getScheme().substring(13));
        if (URLEncoder.encode("application/vnd.android.package-archive").equals(parseParams.get(DOWNLOAD_MIME_TYPE))) {
            checkDownload(checkInfo.getContext(), str, str2, null, URLDecoder.decode(parseParams.get(DOWNLOAD_URL)), cancelableRunnable);
        } else {
            checkJump(checkInfo.getContext(), str, str2, checkInfo.getPackageName(), checkInfo.getUrl(), checkInfo.getScheme(), checkInfo.getAction(), checkInfo.getResolveInfos(), cancelableRunnable, checkInfo.getCallbackId(), null);
        }
    }

    private void downloadTFile(CheckInfo checkInfo, String str, String str2, CancelableRunnable cancelableRunnable) {
        int indexOf = checkInfo.getScheme().indexOf(INDEX_URL);
        if (indexOf >= 0) {
            ArrayMap<String, String> parseParams = parseParams(checkInfo.getScheme().substring(indexOf));
            if (URLEncoder.encode("application/vnd.android.package-archive").equals(parseParams.get(DOWNLOAD_MIME_TYPE))) {
                checkDownload(checkInfo.getContext(), str, str2, null, URLDecoder.decode(parseParams.get(DOWNLOAD_URL)), cancelableRunnable);
                return;
            } else {
                checkJump(checkInfo.getContext(), str, str2, checkInfo.getPackageName(), checkInfo.getUrl(), checkInfo.getScheme(), checkInfo.getAction(), checkInfo.getResolveInfos(), cancelableRunnable, checkInfo.getCallbackId(), null);
                return;
            }
        }
        checkJump(checkInfo.getContext(), str, str2, checkInfo.getPackageName(), checkInfo.getUrl(), checkInfo.getScheme(), checkInfo.getAction(), checkInfo.getResolveInfos(), cancelableRunnable, checkInfo.getCallbackId(), null);
    }

    private void downloadYYB(CheckInfo checkInfo, String str, String str2, CancelableRunnable cancelableRunnable) {
        String str3;
        String queryParameter;
        String stringExtra = checkInfo.getIntent().getStringExtra("packageName");
        if (stringExtra == null && (queryParameter = Uri.parse(checkInfo.getScheme()).getQueryParameter(DOWNL_URL)) != null) {
            str3 = URLDecoder.decode(queryParameter);
        } else {
            str3 = null;
        }
        checkDownload(checkInfo.getContext(), str, str2, stringExtra, str3, cancelableRunnable);
    }

    private CancelableRunnable getCancelableRunnable(CheckInfo checkInfo, String str, TeleScreenConfig.a aVar) {
        boolean z16;
        CancelableRunnable cancelableRunnable;
        if (aVar.f200364f && !aVar.h(str, checkInfo.getScheme(), checkInfo.getPackageName()) && !containQQ(checkInfo.getResolveInfos())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            cancelableRunnable = checkInfo.getTorun();
        } else {
            cancelableRunnable = null;
        }
        if (!z16) {
            QLog.i("TeleScreen|JefsClass", 1, "report async");
            run(checkInfo.getTorun());
            checkInfo.setCallbackId(0);
        }
        checkInfo.getIntent().putExtra(KEY_IS_TO_DOWNLOAD, true);
        return cancelableRunnable;
    }

    private TeleScreenConfig.a getConfig(CheckInfo checkInfo) {
        try {
            return (TeleScreenConfig.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100839");
        } catch (Throwable th5) {
            QLog.e("TeleScreen|JefsClass", 1, th5, new Object[0]);
            run(checkInfo.getTorun());
            return null;
        }
    }

    public static JefsClass getInstance() {
        return instance;
    }

    private String getRefId(Context context, Intent intent, String str) {
        String str2 = null;
        if (!AdDownloadConstants.DOWNLOAD_SOURCE_AD.equals(str)) {
            return null;
        }
        if (intent != null && intent.getStringExtra(LaunchParam.KEY_REF_ID) != null) {
            str2 = intent.getStringExtra(LaunchParam.KEY_REF_ID);
        } else if (context instanceof Activity) {
            str2 = getRefIdFromActivity((Activity) context);
        } else {
            QLog.i("TeleScreen|JefsClass", 1, "getRefId: context is not Activity " + context);
        }
        if (str2 == null) {
            return this.mRefID;
        }
        return str2;
    }

    private static String getRefIdFromActivity(Activity activity) {
        String str;
        Intent intent = activity.getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("big_brother_source_key");
            String stringExtra2 = intent.getStringExtra(LaunchParam.KEY_REF_ID);
            if (stringExtra2 != null) {
                str = stringExtra2;
            } else {
                str = stringExtra;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TeleScreen|JefsClass", 2, "getRefId() Activity Source = [" + stringExtra + "], refId = [" + stringExtra2 + "]");
            }
            return str;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ResolveInfo> getResolveInfos(Context context, Intent intent, CancelableRunnable cancelableRunnable) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities.size() == 0) {
                QLog.i("TeleScreen|JefsClass", 1, "no matching app: " + intent.getDataString());
                run(cancelableRunnable);
                return null;
            }
            if (queryIntentActivities.size() == 1 && handleActivityInfo(cancelableRunnable, queryIntentActivities)) {
                return null;
            }
            return queryIntentActivities;
        } catch (Throwable th5) {
            QLog.e("TeleScreen|JefsClass", 1, "query intent error: " + intent);
            QLog.e("TeleScreen|JefsClass", 1, th5, new Object[0]);
            run(cancelableRunnable);
            return null;
        }
    }

    private static String getSourceIdFromActivity(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            return intent.getStringExtra("big_brother_source_key");
        }
        return null;
    }

    private boolean handleActivityInfo(CancelableRunnable cancelableRunnable, List<ResolveInfo> list) {
        ActivityInfo activityInfo = list.get(0).activityInfo;
        if (activityInfo == null) {
            return false;
        }
        if (SKIP_PKG.contains(activityInfo.packageName)) {
            run(cancelableRunnable);
            return true;
        }
        if (!"com.tencent.android.qqdownloader".equals(activityInfo.packageName) || !LIVE_PUSH_PUSHACTIVITY.equals(activityInfo.name)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TeleScreen|JefsClass", 2, "wake up yyb");
        }
        run(cancelableRunnable);
        return true;
    }

    private void handleEmptySrc(Context context, String str, List<ResolveInfo> list) {
        IJefsClassInjectInterface iJefsClassInjectInterface;
        boolean z16 = false;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            QQToast.makeText(context, R.string.f213205pk, 0).show();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.haoliyou.JefsClass.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) JefsClass.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.context, R.string.f213205pk, 0).show();
                    }
                }
            });
        }
        if (str != null) {
            IJefsClassInjectInterface iJefsClassInjectInterface2 = sInjectInterface;
            if (iJefsClassInjectInterface2 != null) {
                iJefsClassInjectInterface2.openThirdApp();
                return;
            }
            return;
        }
        if (list == null) {
            return;
        }
        Iterator<ResolveInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().activityInfo != null) {
                z16 = true;
                break;
            }
        }
        if (!z16 && (iJefsClassInjectInterface = sInjectInterface) != null) {
            iJefsClassInjectInterface.openThirdApp();
        }
    }

    private void handlerEmptyPkgName(Context context) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            QQToast.makeText(context, R.string.f225256l5, 0).show();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.haoliyou.JefsClass.15
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) JefsClass.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.context, R.string.f225256l5, 0).show();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlerSessionInstall(Intent intent, WeakReference<Context> weakReference, String str, String str2, CancelableRunnable cancelableRunnable) {
        if (ACTION_SESSION_INSTALL.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("big_brother_pkg_name_key");
            if (stringExtra != null) {
                checkDownload(stringExtra, weakReference, str, str2, cancelableRunnable);
            } else {
                QLog.w("TeleScreen|JefsClass", 1, "session install: apk name is null");
                run(cancelableRunnable);
            }
            return true;
        }
        return false;
    }

    private boolean inWhiteList(CancelableRunnable cancelableRunnable, String str) {
        if (SKIP_ACTION.contains(str)) {
            run(cancelableRunnable);
            return true;
        }
        return false;
    }

    private void installPkg(Intent intent, String str, String str2, CancelableRunnable cancelableRunnable, WeakReference<Context> weakReference) {
        if (QLog.isColorLevel()) {
            QLog.d("TeleScreen|JefsClass", 2, VRReportDefine$ReportKey.INSTALL);
        }
        ThreadManagerV2.excute(new Runnable(intent, weakReference, str, str2, cancelableRunnable) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.14
            static IPatchRedirector $redirector_;
            final /* synthetic */ WeakReference val$ctxRef;
            final /* synthetic */ Intent val$intent;
            final /* synthetic */ String val$refId;
            final /* synthetic */ String val$src;
            final /* synthetic */ CancelableRunnable val$todo;

            {
                this.val$intent = intent;
                this.val$ctxRef = weakReference;
                this.val$src = str;
                this.val$refId = str2;
                this.val$todo = cancelableRunnable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, JefsClass.this, intent, weakReference, str, str2, cancelableRunnable);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String queryParameter;
                String str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (JefsClass.this.handlerSessionInstall(this.val$intent, this.val$ctxRef, this.val$src, this.val$refId, this.val$todo)) {
                        return;
                    }
                    if ("application/vnd.android.package-archive".equalsIgnoreCase(this.val$intent.getType())) {
                        queryParameter = FileProvider7Helper.getRealPathFromContentURI(BaseApplication.context, this.val$intent.getData());
                    } else {
                        queryParameter = Uri.parse(this.val$intent.getStringExtra(JefsClass.YYB_INSTALL_URL)).getQueryParameter("filepath");
                    }
                    if (queryParameter == null) {
                        QLog.w("TeleScreen|JefsClass", 1, "apk path is null");
                        JefsClass.this.run(this.val$todo);
                        return;
                    }
                    if (new File(queryParameter).exists()) {
                        PackageInfo packageArchiveInfo = BaseApplication.context.getPackageManager().getPackageArchiveInfo(queryParameter, 0);
                        if (packageArchiveInfo != null) {
                            str3 = packageArchiveInfo.packageName;
                        } else {
                            str3 = "";
                        }
                    } else {
                        str3 = null;
                    }
                    JefsClass.this.checkDownload(str3, this.val$ctxRef, this.val$src, this.val$refId, this.val$todo);
                } catch (Throwable th5) {
                    QLog.e("TeleScreen|JefsClass", 1, th5, new Object[0]);
                    JefsClass.this.run(this.val$todo);
                }
            }
        }, 64, null, true);
    }

    private void intercept(Context context, Intent intent, CancelableRunnable cancelableRunnable, Interceptor interceptor) {
        if (this.hasChecked.get().booleanValue()) {
            run(cancelableRunnable);
            return;
        }
        IJefsClassInjectInterface iJefsClassInjectInterface = sInjectInterface;
        if (iJefsClassInjectInterface != null && iJefsClassInjectInterface.isUserAllow()) {
            String sourceId = getSourceId(context, intent);
            setSourceID(null);
            String refId = getRefId(context, intent, sourceId);
            setRefID(null);
            if (skipCheckUpdate(cancelableRunnable, sourceId, refId)) {
                return;
            }
            String str = intent.getPackage();
            if (skipPackage(intent, cancelableRunnable, str)) {
                return;
            }
            String action = intent.getAction();
            if (inWhiteList(cancelableRunnable, action) || passWithoutLogin(intent, cancelableRunnable)) {
                return;
            }
            Uri data = intent.getData();
            if (data != null && data.getScheme() != null && isSkipUri(data)) {
                run(cancelableRunnable);
                return;
            } else {
                ThreadManagerV2.excute(new Runnable(context, intent, cancelableRunnable, interceptor, sourceId, refId, str, action) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.17
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$action;
                    final /* synthetic */ Context val$context;
                    final /* synthetic */ Intent val$intent;
                    final /* synthetic */ Interceptor val$interceptor;
                    final /* synthetic */ String val$packageName;
                    final /* synthetic */ String val$refId;
                    final /* synthetic */ String val$sourceId;
                    final /* synthetic */ CancelableRunnable val$todo;

                    {
                        this.val$context = context;
                        this.val$intent = intent;
                        this.val$todo = cancelableRunnable;
                        this.val$interceptor = interceptor;
                        this.val$sourceId = sourceId;
                        this.val$refId = refId;
                        this.val$packageName = str;
                        this.val$action = action;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, JefsClass.this, context, intent, cancelableRunnable, interceptor, sourceId, refId, str, action);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            List<ResolveInfo> resolveInfos = JefsClass.this.getResolveInfos(this.val$context, this.val$intent, this.val$todo);
                            if (resolveInfos == null) {
                                return;
                            }
                            this.val$interceptor.checkAndDo(this.val$sourceId, this.val$refId, this.val$packageName, this.val$intent.getDataString(), this.val$action, resolveInfos, this.val$todo);
                            return;
                        }
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }, 16, null, true);
                return;
            }
        }
        run(cancelableRunnable);
    }

    private boolean isDownloadMTT(String str) {
        if (str != null && str.startsWith(SCHEME_MTT)) {
            return true;
        }
        return false;
    }

    private boolean isDownloadTFile(String str) {
        if (str != null && str.startsWith(SCHEME_TENCENT_FILE)) {
            return true;
        }
        return false;
    }

    private boolean isDownloadYYB(String str) {
        if (str != null && str.startsWith(SCHEME_YYB)) {
            return true;
        }
        return false;
    }

    private boolean isInstallPkg(CheckInfo checkInfo) {
        if (ACTION_SESSION_INSTALL.equals(checkInfo.getAction())) {
            return true;
        }
        if (CommonConstant.ACTION.HWID_SCHEME_URL.equals(checkInfo.getAction()) && ("application/vnd.android.package-archive".equalsIgnoreCase(checkInfo.getIntent().getType()) || checkInfo.getIntent().hasExtra(YYB_INSTALL_URL))) {
            return true;
        }
        return false;
    }

    private boolean isOpenHttpLink(String str) {
        if (str != null && (str.startsWith("http://") || str.startsWith("https://"))) {
            return true;
        }
        return false;
    }

    private boolean isSkipUri(Uri uri) {
        for (IUriChecker iUriChecker : URI_CHECKERS) {
            if (iUriChecker.isSkip(uri)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSwitchOn() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106125", false);
    }

    private static boolean isWhitListContext(Context context) {
        if (!(context instanceof QBaseActivity) && !(context instanceof Application) && !"com.tencent.mobileqq.app.BaseActivity2".equals(context.getClass().getName())) {
            return false;
        }
        return true;
    }

    private void launchJumpFragment(CancelableRunnable cancelableRunnable, int i3, String str, Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("big_brother_source_key", str);
        intent2.putExtra("key_id", addTodo(cancelableRunnable));
        intent2.putExtra("key_process_id", MobileQQ.processName);
        intent2.putExtra("key_callback_id", i3);
        intent2.putExtra("public_fragment_window_feature", 1);
        checkAddCustomBundle(intent2, intent);
        QPublicFragmentActivity.b.d(intent2, QPublicTransFragmentActivity.class, JumpConfirmFragment.class);
        QLog.i("TeleScreen|JefsClass", 1, "leave QQ jump other app , act == null && act.isFinishing() == true");
    }

    private void openHttpLink(CheckInfo checkInfo, String str, String str2, CancelableRunnable cancelableRunnable) {
        if ("application/vnd.android.package-archive".equals(checkInfo.getIntent().getStringExtra("mimetype"))) {
            checkDownload(checkInfo.getContext(), str, str2, null, checkInfo.getScheme(), cancelableRunnable);
        } else {
            checkJump(checkInfo.getContext(), str, str2, checkInfo.getPackageName(), checkInfo.getUrl(), checkInfo.getScheme(), checkInfo.getAction(), checkInfo.getResolveInfos(), cancelableRunnable, checkInfo.getCallbackId(), null);
        }
    }

    private boolean passWithoutLogin(Intent intent, CancelableRunnable cancelableRunnable) {
        IJefsClassInjectInterface iJefsClassInjectInterface;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && !waitAppRuntime.isLogin()) {
            QLog.i("TeleScreen|JefsClass", 1, "haven't login ");
            run(cancelableRunnable);
            return true;
        }
        if (waitAppRuntime != null && (iJefsClassInjectInterface = sInjectInterface) != null) {
            iJefsClassInjectInterface.monitorInstallIntent(waitAppRuntime.getAccount(), intent);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeInternal(int i3, int i16) {
        boolean z16;
        TeleScreenReceiver teleScreenReceiver;
        synchronized (this.todoList) {
            if (this.todoList.indexOfKey(i3) >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.todoList.delete(i3);
            if (z16 && this.todoList.size() <= 0 && (teleScreenReceiver = this.receiver) != null) {
                try {
                    BaseApplication.context.unregisterReceiver(teleScreenReceiver);
                } catch (Throwable th5) {
                    QLog.e("TeleScreen|JefsClass", 1, th5, new Object[0]);
                }
            }
            d.b().c(i16, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.hasChecked.set(Boolean.TRUE);
        runnable.run();
        this.hasChecked.set(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runInternal(int i3, int i16) {
        synchronized (this.todoList) {
            Runnable runnable = this.todoList.get(i3);
            if (runnable == null) {
                QLog.w("TeleScreen|JefsClass", 1, "no todo");
            }
            removeInternal(i3, 0);
            run(runnable);
        }
        d.b().c(i16, 2);
    }

    private void setupDialog(CancelableRunnable cancelableRunnable, int i3, String str, Activity activity, Intent intent) {
        String str2;
        String str3;
        String str4;
        QLog.i("TeleScreen|JefsClass", 1, "leave QQ jump other app , act.isFinishing() == false");
        String string = activity.getString(R.string.f213195pj);
        String string2 = activity.getString(R.string.cancel);
        String string3 = activity.getString(R.string.igh);
        if (intent != null && intent.getBooleanExtra(EXTRA_KEY_IS_CUSTOM_DIALOG_TEXT, false)) {
            String stringExtra = intent.getStringExtra(EXTRA_KEY_DIALOG_CONTENT_TEXT);
            String stringExtra2 = intent.getStringExtra(EXTRA_KEY_DIALOG_CANCEL_TEXT);
            str3 = intent.getStringExtra(EXTRA_KEY_DIALOG_CONFIRM_TEXT);
            str4 = stringExtra;
            str2 = stringExtra2;
        } else {
            str2 = string2;
            str3 = string3;
            str4 = string;
        }
        QQCustomDialog createCenterTextDialog = DialogUtil.createCenterTextDialog(activity, 0, null, str4, str2, str3, new DialogInterface.OnClickListener(cancelableRunnable) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.10
            static IPatchRedirector $redirector_;
            final /* synthetic */ CancelableRunnable val$todo;

            {
                this.val$todo = cancelableRunnable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) JefsClass.this, (Object) cancelableRunnable);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i16);
                    return;
                }
                ((QQCustomDialog) dialogInterface).setTag("confirmed");
                this.val$todo.setJumpAction(2);
                JefsClass.this.run(this.val$todo);
            }
        }, new DialogInterface.OnClickListener(i3, str) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.11
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$callbackId;
            final /* synthetic */ String val$src;

            {
                this.val$callbackId = i3;
                this.val$src = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, JefsClass.this, Integer.valueOf(i3), str);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i16);
                    return;
                }
                ((QQCustomDialog) dialogInterface).setTag("canceled");
                d.b().c(this.val$callbackId, -1);
                String str5 = this.val$src;
                if (str5 == null) {
                    str5 = "";
                }
                ReportController.o(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "1", "", str5, "");
            }
        });
        createCenterTextDialog.setOnDismissListener(new DialogInterface.OnDismissListener(i3) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.12
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$callbackId;

            {
                this.val$callbackId = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) JefsClass.this, i3);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                String str5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                    return;
                }
                if (dialogInterface != null) {
                    str5 = (String) ((QQCustomDialog) dialogInterface).getTag();
                } else {
                    str5 = "";
                }
                if (!"confirmed".equals(str5) && !"canceled".equals(str5)) {
                    d.b().c(this.val$callbackId, -1);
                }
            }
        });
        showDialog(activity, createCenterTextDialog);
    }

    private void setupFragment(CancelableRunnable cancelableRunnable, int i3, String str, Intent intent) {
        if (MobileQQ.sProcessId != 1) {
            if (this.receiver == null) {
                this.receiver = new TeleScreenReceiver(this, null);
            }
            IntentFilter intentFilter = new IntentFilter(ACTION_RUN);
            intentFilter.addAction(ACTION_REMOVE);
            BaseApplication.context.registerReceiver(this.receiver, intentFilter);
        }
        launchJumpFragment(cancelableRunnable, i3, str, intent);
    }

    private void showDialog(Activity activity, QQCustomDialog qQCustomDialog) {
        if (activity instanceof QBaseActivity) {
            ((QBaseActivity) activity).setJumpDialog(qQCustomDialog);
        } else if (activity instanceof BasePluginActivity) {
            ((BasePluginActivity) activity).setJumpDialog(qQCustomDialog);
        }
        qQCustomDialog.show();
    }

    private void showInvalidateRefIdDialog() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.haoliyou.JefsClass.16
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) JefsClass.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                    DialogUtil.createCenterTextDialog(qBaseActivity, 0, null, HardCodeUtil.qqStr(R.string.f172120ni0), qBaseActivity.getString(R.string.cancel), qBaseActivity.getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.haoliyou.JefsClass.16.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass16.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else {
                                dialogInterface.dismiss();
                            }
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.haoliyou.JefsClass.16.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass16.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else {
                                dialogInterface.dismiss();
                            }
                        }
                    }).show();
                }
            }
        });
    }

    private boolean skipCheckUpdate(CancelableRunnable cancelableRunnable, String str, String str2) {
        return false;
    }

    private boolean skipPackage(Intent intent, CancelableRunnable cancelableRunnable, String str) {
        ComponentName component;
        Set<String> set = SKIP_PKG;
        if (set.contains(str)) {
            run(cancelableRunnable);
            return true;
        }
        if (TextUtils.isEmpty(str) && (component = intent.getComponent()) != null && set.contains(component.getPackageName())) {
            run(cancelableRunnable);
            return true;
        }
        return false;
    }

    public static void startActivity(Context context, Intent intent) {
        if (!isWhitListContext(context) && isSwitchOn()) {
            QLog.d("TeleScreen|JefsClass", 1, context);
            instance.checkAndDoSync(context, intent, new Runnable(context, intent) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context val$context;
                final /* synthetic */ Intent val$intent;

                {
                    this.val$context = context;
                    this.val$intent = intent;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) intent);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.val$context.startActivity(this.val$intent);
                    }
                }
            });
        } else {
            context.startActivity(intent);
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i3) {
        if (!isWhitListContext(activity) && isSwitchOn()) {
            instance.checkAndDoSync(activity, intent, new Runnable(activity, intent, i3) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity val$activity;
                final /* synthetic */ Intent val$intent;
                final /* synthetic */ int val$requestCode;

                {
                    this.val$activity = activity;
                    this.val$intent = intent;
                    this.val$requestCode = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, activity, intent, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.val$activity.startActivityForResult(this.val$intent, this.val$requestCode);
                    }
                }
            });
        } else {
            activity.startActivityForResult(intent, i3);
        }
    }

    public Cancelable checkAndDoAsyn(Context context, Intent intent, String str, WeakOuterRefRunnable weakOuterRefRunnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Cancelable) iPatchRedirector.redirect((short) 8, this, context, intent, str, weakOuterRefRunnable);
        }
        int intExtra = intent.getIntExtra("key_callback_id", 0);
        weakOuterRefRunnable.g(intExtra);
        CancelableRunnable cancelableRunnable = new CancelableRunnable(weakOuterRefRunnable);
        intercept(context, intent, cancelableRunnable, new Interceptor(context, intent, str, intExtra) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.7
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$callbackId;
            final /* synthetic */ Context val$context;
            final /* synthetic */ Intent val$intent;
            final /* synthetic */ String val$url;

            {
                this.val$context = context;
                this.val$intent = intent;
                this.val$url = str;
                this.val$callbackId = intExtra;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, JefsClass.this, context, intent, str, Integer.valueOf(intExtra));
                }
            }

            @Override // com.tencent.mobileqq.haoliyou.JefsClass.Interceptor
            public void checkAndDo(String str2, String str3, String str4, String str5, String str6, List<ResolveInfo> list, CancelableRunnable cancelableRunnable2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, str2, str3, str4, str5, str6, list, cancelableRunnable2);
                    return;
                }
                CheckInfo.CheckInfoBuilder checkInfoBuilder = new CheckInfo.CheckInfoBuilder();
                checkInfoBuilder.setContext(this.val$context).setIntent(this.val$intent).setSourceID(str2).setRefID(str3).setUrl(this.val$url).setPackageName(str4).setScheme(str5).setAction(str6).setResolveInfos(list).setCallbackId(this.val$callbackId).setTorun(cancelableRunnable2);
                JefsClass.this.checkAndDoAsyn(checkInfoBuilder.build());
            }
        });
        return cancelableRunnable.getCancelable();
    }

    public Cancelable checkAndDoAsync(Context context, Intent intent, String str, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Cancelable) iPatchRedirector.redirect((short) 7, this, context, intent, str, runnable);
        }
        return checkAndDoAsyn(context, intent, str, new WeakOuterRefRunnable(runnable, true));
    }

    @Override // com.tencent.mobileqq.haoliyou.IATHandler
    public void checkAndDoSync(Context context, Intent intent, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, intent, runnable);
        } else {
            checkAndDoAsyn(context, intent, null, new WeakOuterRefRunnable(runnable, true));
        }
    }

    public String getSourceId(Context context, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) intent);
        }
        if (intent.hasExtra("big_brother_source_key")) {
            str = intent.getStringExtra("big_brother_source_key");
        } else {
            str = null;
        }
        if (str == null && (context instanceof Activity)) {
            str = getSourceIdFromActivity((Activity) context);
        }
        if (str == null) {
            return this.mSourceID;
        }
        return str;
    }

    ArrayMap<String, String> parseParams(String str) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (str != null) {
            for (String str2 : str.split(",")) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    arrayMap.put(split[0], split[1]);
                }
            }
        }
        return arrayMap;
    }

    public void pluginCheckAndDoSync(Activity activity, Intent intent, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, intent, runnable);
        } else {
            getInstance().checkAndDoSync(activity, intent, runnable);
        }
    }

    @Override // com.tencent.mobileqq.haoliyou.IATHandler
    public void proxyStartActivityForResult(Activity activity, Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, intent, Integer.valueOf(i3), bundle);
        } else {
            getInstance().pluginCheckAndDoSync(activity, intent, new TeleScreenRunnable(activity, intent, i3, bundle) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity val$baseActivity;
                final /* synthetic */ Bundle val$bundle;
                final /* synthetic */ int val$i;
                final /* synthetic */ Intent val$intent;

                {
                    this.val$baseActivity = activity;
                    this.val$intent = intent;
                    this.val$i = i3;
                    this.val$bundle = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, JefsClass.this, activity, intent, Integer.valueOf(i3), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        try {
                            ((PluginProxyActivity) this.val$baseActivity).superStartActivityForResult(this.val$intent, this.val$i, this.val$bundle);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }

    public void removeTodo(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        if (MobileQQ.PACKAGE_NAME.equals(str)) {
            removeInternal(i3, i16);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(ACTION_REMOVE);
        intent.putExtra("key_id", i3);
        intent.putExtra("key_process_id", str);
        intent.putExtra("key_callback_id", i16);
        BaseApplication.context.sendBroadcast(intent);
    }

    public void runAndRemoveTodo(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        if (MobileQQ.PACKAGE_NAME.equals(str)) {
            runInternal(i3, i16);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(ACTION_RUN);
        intent.putExtra("key_id", i3);
        intent.putExtra("key_process_id", str);
        intent.putExtra("key_callback_id", i16);
        BaseApplication.context.sendBroadcast(intent);
    }

    public void setRefID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mRefID = str;
        }
    }

    public void setSourceID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mSourceID = str;
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i3, Bundle bundle) {
        if (!isWhitListContext(activity) && isSwitchOn()) {
            instance.checkAndDoSync(activity, intent, new Runnable(activity, intent, i3, bundle) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity val$activity;
                final /* synthetic */ Intent val$intent;
                final /* synthetic */ Bundle val$options;
                final /* synthetic */ int val$requestCode;

                {
                    this.val$activity = activity;
                    this.val$intent = intent;
                    this.val$requestCode = i3;
                    this.val$options = bundle;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, activity, intent, Integer.valueOf(i3), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.val$activity.startActivityForResult(this.val$intent, this.val$requestCode, this.val$options);
                    }
                }
            });
        } else {
            activity.startActivityForResult(intent, i3, bundle);
        }
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        if (!isWhitListContext(context) && isSwitchOn()) {
            instance.checkAndDoSync(context, intent, new Runnable(context, intent, bundle) { // from class: com.tencent.mobileqq.haoliyou.JefsClass.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context val$context;
                final /* synthetic */ Intent val$intent;
                final /* synthetic */ Bundle val$options;

                {
                    this.val$context = context;
                    this.val$intent = intent;
                    this.val$options = bundle;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, context, intent, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.val$context.startActivity(this.val$intent, this.val$options);
                    }
                }
            });
        } else {
            context.startActivity(intent, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndDoAsyn(CheckInfo checkInfo) {
        String sourceID = checkInfo.getSourceID();
        String refID = checkInfo.getRefID();
        checkInfo.getTorun().setId(sourceID);
        TeleScreenConfig.a config = getConfig(checkInfo);
        if (config == null) {
            return;
        }
        CancelableRunnable cancelableRunnable = getCancelableRunnable(checkInfo, sourceID, config);
        try {
            chooseDownloadType(checkInfo, sourceID, refID, cancelableRunnable, new WeakReference<>(checkInfo.getContext()));
        } catch (Throwable th5) {
            QLog.e("TeleScreen|JefsClass", 1, th5, new Object[0]);
            run(cancelableRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDownload(String str, WeakReference<Context> weakReference, String str2, String str3, CancelableRunnable cancelableRunnable) {
        Context context = weakReference.get();
        if (str != null && context != null) {
            checkDownload(context, str2, str3, str, null, cancelableRunnable);
        } else {
            QLog.i("TeleScreen|JefsClass", 1, "could not resolve apk file's package");
            run(cancelableRunnable);
        }
    }
}
