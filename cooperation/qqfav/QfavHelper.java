package cooperation.qqfav;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class QfavHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f390562a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private static SharedPreferences f390563b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements PluginManagerHelper.OnPluginManagerLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPluginInstallListener f390569a;

        c(OnPluginInstallListener onPluginInstallListener) {
            this.f390569a = onPluginInstallListener;
        }

        @Override // com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener
        public void onPluginManagerLoaded(PluginManagerClient pluginManagerClient) {
            try {
                if (!pluginManagerClient.isPluginInstalled("qqfav.apk")) {
                    OnPluginInstallListener onPluginInstallListener = this.f390569a;
                    if (onPluginInstallListener == null) {
                        pluginManagerClient.installPlugin("qqfav.apk");
                    } else {
                        pluginManagerClient.installPlugin("qqfav.apk", onPluginInstallListener);
                    }
                } else {
                    OnPluginInstallListener onPluginInstallListener2 = this.f390569a;
                    if (onPluginInstallListener2 != null) {
                        try {
                            onPluginInstallListener2.onInstallFinish("qqfav.apk");
                        } catch (RemoteException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            } catch (Exception unused) {
                OnPluginInstallListener onPluginInstallListener3 = this.f390569a;
                if (onPluginInstallListener3 != null) {
                    try {
                        onPluginInstallListener3.onInstallError("qqfav.apk", -1);
                    } catch (RemoteException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }

    public static void A(AppRuntime appRuntime) {
        if (BaseApplicationImpl.getApplication().getSharedPreferences("QfavNeedReupload", 4).getBoolean(appRuntime.getAccount() + "QfavNeedReupload", false)) {
            if (QLog.isColorLevel()) {
                QLog.i(ProcessConstant.QQFAV, 2, "reuploadQfavItems: flag=true");
            }
            Intent intent = new Intent("com.tencent.mobileqq.ACTION_QFAVIPC_BROADCAST");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("nOperation", 5);
            QfavPluginProxyReceiver.a(appRuntime, intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(ProcessConstant.QQFAV, 2, "reuploadQfavItems: flag=false");
        }
    }

    public static void B(Context context, String str, boolean z16, String str2, boolean z17) {
        C(context, str, z16, str2, z17, R.string.b3n);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x012f A[Catch: all -> 0x0166, TRY_LEAVE, TryCatch #0 {all -> 0x0166, blocks: (B:16:0x0086, B:18:0x008c, B:19:0x009b, B:21:0x00b5, B:23:0x00bb, B:26:0x00e0, B:31:0x00ed, B:32:0x0103, B:34:0x012f, B:38:0x00ca, B:39:0x00d4, B:41:0x0094), top: B:15:0x0086 }] */
    @TargetApi(9)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void C(Context context, String str, boolean z16, String str2, boolean z17, int i3) {
        String str3;
        String string;
        boolean z18;
        boolean z19;
        if (context == null) {
            return;
        }
        QQToast qQToast = new QQToast(context);
        qQToast.setDuration(2000);
        if (TextUtils.isEmpty(str)) {
            str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        } else {
            str3 = str;
        }
        if (z16) {
            qQToast.setType(2);
            qQToast.setToastIcon(QQToast.getIconRes(2));
            qQToast.setToastMsg(i3);
            boolean z26 = q(context).getBoolean("pref_first_collection_" + str3, true);
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "First collection before guide shown. Uin=" + MsfSdkUtils.getShortUin(str3) + ", flag=" + z26);
            }
            if (z26) {
                try {
                    String string2 = context.getString(R.string.b4p);
                    if (z17) {
                        string = context.getString(R.string.b4k);
                    } else {
                        string = context.getString(R.string.b4o);
                    }
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, string2, string, R.string.cancel, R.string.b4n, new a(), (DialogInterface.OnClickListener) null);
                    if (context == BaseApplication.getContext()) {
                        int i16 = Build.VERSION.SDK_INT;
                        if (i16 >= 26) {
                            createCustomDialog.getWindow().setType(2038);
                        } else if (i16 > 24) {
                            createCustomDialog.getWindow().setType(2003);
                        } else {
                            createCustomDialog.getWindow().setType(2005);
                        }
                        z18 = true;
                        if (!z18 && !Settings.canDrawOverlays(context)) {
                            z19 = false;
                        } else {
                            z19 = true;
                        }
                        if (!z18 && !z19) {
                            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                            intent.addFlags(268435456);
                            BaseApplicationImpl.getApplication().startActivity(intent);
                        } else {
                            createCustomDialog.setMessageCount(null).show();
                            q(context).edit().putBoolean("pref_first_collection_" + str3, false).apply();
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("First collection guide shown. Uin=");
                                sb5.append(MsfSdkUtils.getShortUin(str3));
                                sb5.append(", flag=");
                                sb5.append(q(context).getBoolean("pref_first_collection_" + str3, true));
                                QLog.d(ProcessConstant.QQFAV, 2, sb5.toString());
                            }
                        }
                    }
                    z18 = false;
                    if (!z18) {
                    }
                    z19 = true;
                    if (!z18) {
                    }
                    createCustomDialog.setMessageCount(null).show();
                    q(context).edit().putBoolean("pref_first_collection_" + str3, false).apply();
                    if (QLog.isColorLevel()) {
                    }
                } catch (Throwable unused) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("First collection guide error. Uin=");
                    sb6.append(MsfSdkUtils.getShortUin(str3));
                    sb6.append(", flag=");
                    sb6.append(q(context).getBoolean("pref_first_collection_" + str3, true));
                    QLog.e(ProcessConstant.QQFAV, 1, sb6.toString());
                }
            }
        } else {
            qQToast.setType(1);
            qQToast.setToastIcon(QQToast.getIconRes(1));
            if (str2 == null) {
                qQToast.setToastMsg(R.string.b3o);
            } else {
                qQToast.setToastMsg(str2);
            }
        }
        qQToast.show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) (context.getResources().getDisplayMetrics().density * 5.0f)));
    }

    public static boolean D(Activity activity, String str, Intent intent, int i3) {
        intent.setFlags(intent.getFlags() & (-67108865) & (-536870913));
        return QfavPluginProxyActivity.L2(activity, str, intent, i3);
    }

    public static void c(final Context context, final OnPluginInstallListener onPluginInstallListener) {
        try {
            ThreadManagerV2.excute(new Runnable() { // from class: cooperation.qqfav.QfavHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = context;
                    if (context2 == null) {
                        context2 = BaseApplicationImpl.getApplication();
                    }
                    QfavHelper.p(context2, onPluginInstallListener);
                }
            }, 64, null, true);
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (onPluginInstallListener != null) {
                try {
                    onPluginInstallListener.onInstallError("qqfav.apk", -1);
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public static boolean d(Activity activity, String str) {
        Intent intent = new Intent();
        intent.putExtra("nOperation", 3);
        return QfavPluginProxyActivity.L2(activity, str, intent, -1);
    }

    public static Object e(String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        try {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException unused) {
                ClassLoader l3 = l();
                if (l3 != null) {
                    cls = l3.loadClass(str);
                } else {
                    cls = null;
                }
            }
            if (cls == null) {
                QLog.i("qqfavQfavHelper#createInstance", 1, "className =" + str + ",cls == null");
                return null;
            }
            return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
        } catch (Exception e16) {
            QLog.i("qqfavQfavHelper#createInstance", 1, "Exception =" + QLog.getStackTraceString(e16));
            return null;
        }
    }

    public static AppRuntime f(BaseApplicationImpl baseApplicationImpl) {
        return (AppRuntime) e("com.qqfav.QfavAppInterface", new Class[]{BaseApplicationImpl.class, String.class}, new Object[]{baseApplicationImpl, ProcessConstant.QQFAV});
    }

    public static void g(Context context, FavFileInfo favFileInfo, int i3) {
        Bundle bundle = new Bundle();
        bundle.putLong("download_fav_id", favFileInfo.f207672d);
        bundle.putInt("thumb_format", i3);
        QfavPluginProxyService.c().d("com.tencent.qqfav", 3, bundle);
    }

    public static boolean h(Context context, String str, long j3) {
        Intent intent = new Intent();
        intent.putExtra("nOperation", 11);
        intent.putExtra("lId", j3);
        return QfavPluginProxyActivity.L2(context, str, intent, -1);
    }

    public static boolean i(Activity activity, String str, Intent intent, int i3, boolean z16) {
        Intent intent2;
        if (intent == null) {
            intent2 = new Intent();
        } else {
            intent2 = new Intent(intent);
        }
        intent2.putExtra("nOperation", 2);
        intent2.putExtra("bShowProgress", z16);
        intent2.putExtra("begin", System.currentTimeMillis());
        QfavUtil.O(str);
        if (!e.a().b()) {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "openPluginActivityForResult need pending data." + intent2.toString());
            }
            byte[] c16 = e.a().c();
            if (c16 == null && QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "openPluginActivityForResult pending data error.");
            }
            intent2.putExtra("pendingData", c16);
        }
        return QfavPluginProxyActivity.L2(activity, str, intent2, i3);
    }

    public static void j(QQAppInterface qQAppInterface, List<FavFileInfo> list, String str, String str2, int i3) {
        FavFileInfo next;
        FileManagerEntity n3;
        if (list != null && qQAppInterface != null) {
            Iterator<FavFileInfo> it = list.iterator();
            while (it.hasNext() && (n3 = n((next = it.next()), str, i3)) != null) {
                n3.strThumbPath = next.b();
                n3.strMiddleThumPath = next.H;
                n3.strLargeThumPath = next.J;
                qQAppInterface.getFileManagerEngine().C0(n3, str, str2, i3, 0);
            }
        }
    }

    public static ArrayList<byte[]> k() {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isLongVideo", true);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        byte[] bytes = jSONObject.toString().getBytes();
        if (bytes != null) {
            arrayList.add(bytes);
        }
        return arrayList;
    }

    public static ClassLoader l() {
        ClassLoader classLoader = null;
        try {
            classLoader = PluginStatic.getOrCreateClassLoader(BaseApplicationImpl.getApplication().getApplicationContext(), "qqfav.apk");
            BasicClassTypeUtil.setClassLoader(true, classLoader);
            return classLoader;
        } catch (Exception e16) {
            QLog.i("qqfavQfavHelper#getClassLoader", 1, "Exception =" + QLog.getStackTraceString(e16));
            return classLoader;
        }
    }

    public static FileManagerEntity m(Bundle bundle, String str, int i3) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(AppConstants.Key.KEY_FAV_FILE_FORWARD_CID);
        String string2 = bundle.getString(AppConstants.Key.KEY_FAV_FILE_FORWARD_UUID);
        byte[] byteArray = bundle.getByteArray(AppConstants.Key.KEY_FAV_FILE_FORWARD_MD5);
        String string3 = bundle.getString(AppConstants.Key.KEY_FAV_FILE_FORWARD_NAME);
        long j3 = bundle.getLong(AppConstants.Key.KEY_FAV_FILE_FORWARD_FILE_SIZE, 0L);
        String string4 = bundle.getString(AppConstants.Key.FORWARD_FILEPATH);
        String string5 = bundle.getString(AppConstants.Key.KEY_FAV_FILE_FORWARD_THUMB);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || byteArray == null) {
            return null;
        }
        return FileManagerUtil.newEntityByFav(string, string2, string4, string3, j3, HexUtil.bytes2HexStr(byteArray), str, i3, string5);
    }

    public static FileManagerEntity n(FavFileInfo favFileInfo, String str, int i3) {
        String str2;
        if (favFileInfo == null) {
            return null;
        }
        String str3 = favFileInfo.f207673e;
        String str4 = favFileInfo.f207674f;
        String str5 = favFileInfo.f207675h;
        long j3 = favFileInfo.f207677m;
        String str6 = favFileInfo.D;
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || (str2 = favFileInfo.Q) == null) {
            return null;
        }
        return FileManagerUtil.newEntityByFav(str3, str4, str6, str5, j3, str2, str, i3, favFileInfo.E);
    }

    public static boolean o(Context context, long j3, Boolean bool, Bundle bundle) {
        QfavPluginProxyService.d();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putLong("reqTimestamp", j3);
        bundle.putBoolean("localEnd", bool.booleanValue());
        QfavPluginProxyService.c().d("com.tencent.qqfav", 2, bundle);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(Context context, OnPluginInstallListener onPluginInstallListener) {
        PluginManagerHelper.getPluginInterface(context, new c(onPluginInstallListener));
    }

    public static synchronized SharedPreferences q(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (QfavHelper.class) {
            if (f390563b == null) {
                f390563b = context.getSharedPreferences("shared_prefs_qfav", 4);
            }
            sharedPreferences = f390563b;
        }
        return sharedPreferences;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean r(boolean z16) {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2 = f390562a;
        if (atomicBoolean2.get()) {
            return true;
        }
        Runnable runnable = new Runnable() { // from class: cooperation.qqfav.QfavHelper.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (QfavHelper.f390562a) {
                    if (QLog.isColorLevel()) {
                        QLog.i(ProcessConstant.QQFAV, 2, "notify(IS_PLUGININSTALLED) qqfav.apk");
                    }
                    QfavHelper.f390562a.notifyAll();
                }
            }
        };
        if (z16) {
            atomicBoolean = atomicBoolean2;
        } else {
            atomicBoolean = runnable;
        }
        synchronized (atomicBoolean) {
            PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new b(runnable));
            if (atomicBoolean == atomicBoolean2) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i(ProcessConstant.QQFAV, 2, "wait(IS_PLUGININSTALLED) qqfav.apk");
                    }
                    atomicBoolean2.wait(5000L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(ProcessConstant.QQFAV, 2, "qqfav.apk, IS_PLUGININSTALLED = " + f390562a);
        }
        return f390562a.get();
    }

    public static boolean s() {
        if (f390562a.get()) {
            return true;
        }
        return false;
    }

    public static boolean t(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                String str = it.next().processName;
                if (str != null && str.endsWith(":qqfav")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean u(Context context, String str, long j3) {
        Intent intent = new Intent();
        intent.putExtra("nOperation", 6);
        intent.putExtra("lId", j3);
        return QfavPluginProxyActivity.L2(context, str, intent, -1);
    }

    public static boolean v(Context context, String str, long j3, byte[] bArr) {
        Intent intent = new Intent();
        intent.putExtra("nOperation", 6);
        intent.putExtra("lId", j3);
        intent.putExtra("backUpFavData", bArr);
        return QfavPluginProxyActivity.L2(context, str, intent, -1);
    }

    public static boolean w(Context context, String str, long j3, long j16) {
        Intent intent = new Intent();
        intent.putExtra("nOperation", 9);
        intent.putExtra("lId", j3);
        intent.putExtra("custom_fav_id", j3);
        intent.putExtra("moveToGroupAction", true);
        intent.putExtra("custom_group_id", j16);
        intent.putExtra("mov_to_group", true);
        intent.putExtra("custom_without_callback", true);
        return QfavPluginProxyActivity.L2(context, str, intent, -1);
    }

    public static boolean x(Context context, String str, long j3, long[] jArr) {
        Intent intent = new Intent();
        intent.putExtra("nOperation", 6);
        intent.putExtra("imagefilepre", true);
        intent.putExtra("lId", j3);
        if (jArr != null && jArr.length > 0) {
            intent.putExtra("imagefileids", jArr);
        }
        return QfavPluginProxyActivity.L2(context, str, intent, -1);
    }

    public static boolean y(Activity activity, String str, long j3) {
        Intent intent = new Intent();
        intent.putExtra("nOperation", 7);
        return QfavPluginProxyActivity.L2(activity, str, intent, -1);
    }

    public static boolean z(Context context, Bundle bundle) {
        QfavPluginProxyService.d();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("bool_refresh_list", true);
        QfavPluginProxyService.c().d("com.tencent.qqfav", 2, bundle);
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b implements PluginManagerHelper.OnPluginManagerLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f390567a;

        b(Runnable runnable) {
            this.f390567a = runnable;
        }

        @Override // com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener
        public void onPluginManagerLoaded(PluginManagerClient pluginManagerClient) {
            if (pluginManagerClient == null) {
                try {
                    ThreadManagerV2.post(this.f390567a, 5, null, false);
                } catch (Exception unused) {
                }
            } else {
                if (pluginManagerClient.isPluginInstalled("qqfav.apk")) {
                    if (QLog.isColorLevel()) {
                        QLog.i(ProcessConstant.QQFAV, 2, "qqfav.apk already installed.");
                    }
                    QfavHelper.f390562a.set(true);
                    try {
                        ThreadManagerV2.post(this.f390567a, 5, null, false);
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i(ProcessConstant.QQFAV, 2, "installing plugin qqfav.apk");
                }
                pluginManagerClient.installPlugin("qqfav.apk", new a());
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        class a extends OnPluginInstallListener.Stub {
            a() {
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallError(String str, int i3) throws RemoteException {
                if (QLog.isColorLevel()) {
                    QLog.i(ProcessConstant.QQFAV, 2, "install plugin " + str + " error! " + i3);
                }
                try {
                    ThreadManagerV2.post(b.this.f390567a, 5, null, false);
                } catch (Exception unused) {
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallFinish(String str) throws RemoteException {
                if (QLog.isColorLevel()) {
                    QLog.i(ProcessConstant.QQFAV, 2, "install plugin " + str + " OK.");
                }
                QfavHelper.f390562a.set(true);
                try {
                    ThreadManagerV2.post(b.this.f390567a, 5, null, false);
                } catch (Exception unused) {
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallBegin(String str) throws RemoteException {
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class AsyncFavoritesProvider extends OnPluginInstallListener.Stub {

        /* renamed from: d, reason: collision with root package name */
        public Bundle f390566d;

        public AsyncFavoritesProvider(Bundle bundle) {
            this.f390566d = bundle;
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
            x(false, this.f390566d);
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.qqfav.QfavHelper.AsyncFavoritesProvider.1
                /* JADX WARN: Code restructure failed: missing block: B:41:0x0116, code lost:
                
                    if (py3.b.e(r10, android.net.Uri.parse("content://qq.favorites/biz_related/" + r2), "mBizType=? and mBizKey=?", new java.lang.String[]{"" + r8, r0}) > 0) goto L39;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:42:0x0118, code lost:
                
                    r3 = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:0x0161, code lost:
                
                    if (r10.insert(android.net.Uri.parse("content://qq.favorites/biz_related/" + r2), r7) != null) goto L39;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    String string;
                    AsyncFavoritesProvider asyncFavoritesProvider = AsyncFavoritesProvider.this;
                    Bundle bundle = asyncFavoritesProvider.f390566d;
                    boolean z16 = false;
                    if (bundle == null) {
                        asyncFavoritesProvider.x(false, bundle);
                        return;
                    }
                    long j3 = bundle.getLong("req_opt_type", -1L);
                    long j16 = AsyncFavoritesProvider.this.f390566d.getLong("req_biz_type", -1L);
                    String string2 = AsyncFavoritesProvider.this.f390566d.getString("req_biz_key");
                    String string3 = AsyncFavoritesProvider.this.f390566d.getString("req_fav_uin");
                    if (-1 != j3 && -1 != j16 && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                        ContentResolver contentResolver = BaseApplication.getContext().getContentResolver();
                        if (contentResolver == null) {
                            AsyncFavoritesProvider asyncFavoritesProvider2 = AsyncFavoritesProvider.this;
                            asyncFavoritesProvider2.x(false, asyncFavoritesProvider2.f390566d);
                            return;
                        }
                        Bundle bundle2 = new Bundle(AsyncFavoritesProvider.this.f390566d);
                        try {
                            if (1 == j3) {
                                Cursor query = ContactsMonitor.query(contentResolver, Uri.parse("content://qq.favorites/biz_related/" + string3), new String[]{"mUuid"}, "mBizType=? and mBizKey=?", new String[]{"" + j16, string2}, null);
                                if (query != null && query.moveToFirst() && (string = query.getString(query.getColumnIndex("mUuid"))) != null) {
                                    try {
                                        bundle2.putString("rsp_fav_id", SecurityUtile.decode(string));
                                        z16 = true;
                                    } catch (Exception e16) {
                                        e = e16;
                                        z16 = true;
                                        e.printStackTrace();
                                        AsyncFavoritesProvider.this.x(z16, bundle2);
                                        return;
                                    }
                                }
                                if (query != null) {
                                    query.close();
                                }
                            } else if (2 == j3) {
                            } else if (3 == j3) {
                                String string4 = AsyncFavoritesProvider.this.f390566d.getString("req_fav_id");
                                if (!TextUtils.isEmpty(string4)) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("mBizType", Long.valueOf(j16));
                                    contentValues.put("mBizKey", string2);
                                    contentValues.put("mUuid", string4);
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                        }
                        AsyncFavoritesProvider.this.x(z16, bundle2);
                        return;
                    }
                    AsyncFavoritesProvider asyncFavoritesProvider3 = AsyncFavoritesProvider.this;
                    asyncFavoritesProvider3.x(false, asyncFavoritesProvider3.f390566d);
                }
            });
        }

        public void v() {
            QfavHelper.c(BaseApplication.getContext(), this);
        }

        public abstract void x(boolean z16, Bundle bundle);

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
        }
    }
}
