package com.tencent.mobileqq.qqpermission.multiscene;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static List<d> f274304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqpermission.multiscene.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class ViewOnClickListenerC8423a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f274305d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f274306e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f274307f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQPermission.BasePermissionsListener f274308h;

        ViewOnClickListenerC8423a(Context context, String str, String str2, QQPermission.BasePermissionsListener basePermissionsListener) {
            this.f274305d = context;
            this.f274306e = str;
            this.f274307f = str2;
            this.f274308h = basePermissionsListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, str, str2, basePermissionsListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a.e(this.f274305d, this.f274306e, this.f274307f, true);
                QQPermission.BasePermissionsListener basePermissionsListener = this.f274308h;
                if (basePermissionsListener != null) {
                    basePermissionsListener.onAllGranted();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQPermission.BasePermissionsListener f274309d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f274310e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f274311f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f274312h;

        b(QQPermission.BasePermissionsListener basePermissionsListener, Context context, String str, String str2) {
            this.f274309d = basePermissionsListener;
            this.f274310e = context;
            this.f274311f = str;
            this.f274312h = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, basePermissionsListener, context, str, str2);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQPermission.BasePermissionsListener basePermissionsListener = this.f274309d;
                if (basePermissionsListener != null) {
                    basePermissionsListener.onMultiSceneDialogDenied();
                }
                a.e(this.f274310e, this.f274311f, this.f274312h, false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final ArrayMap<String, Integer> f274313a;

        /* renamed from: b, reason: collision with root package name */
        private static final ArrayMap<String, String> f274314b;

        /* renamed from: c, reason: collision with root package name */
        private static final int f274315c;

        /* renamed from: d, reason: collision with root package name */
        private static final int f274316d;

        /* renamed from: e, reason: collision with root package name */
        private static final int f274317e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32010);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f274315c = R.string.f202854ym;
            f274316d = R.string.f202844yl;
            f274317e = R.string.f202834yk;
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
            f274313a = arrayMap;
            ArrayMap<String, String> arrayMap2 = new ArrayMap<>();
            f274314b = arrayMap2;
            arrayMap.put("android.permission-group.LOCATION", Integer.valueOf(R.string.f202884yp));
            arrayMap.put("android.permission-group.CONTACTS", Integer.valueOf(R.string.f202594xx));
            arrayMap.put("android.permission-group.STORAGE", Integer.valueOf(R.string.f202784yf));
            arrayMap.put("android.permission-group.CAMERA", Integer.valueOf(R.string.f202574xv));
            arrayMap.put("android.permission-group.MICROPHONE", Integer.valueOf(R.string.f202764yd));
            arrayMap.put("android.permission-group.SMS", Integer.valueOf(R.string.f202744yb));
            arrayMap.put("android.permission-group.CALENDAR", Integer.valueOf(R.string.f202554xt));
            arrayMap.put(QQPermissionConstants.Permission.GET_INSTALLED_APPS, Integer.valueOf(R.string.f202684y6));
            arrayMap.put("android.permission-group.ACTIVITY_RECOGNITION", Integer.valueOf(R.string.f202514xp));
            arrayMap2.put("android.permission-group.LOCATION", "location");
            arrayMap2.put("android.permission-group.CONTACTS", "contacts");
            arrayMap2.put("android.permission-group.STORAGE", QQPermissionConstants.Permission.STORAGE_GROUP);
            arrayMap2.put("android.permission-group.CAMERA", "camera");
            arrayMap2.put("android.permission-group.MICROPHONE", QQPermissionConstants.Permission.AUIDO_GROUP);
            arrayMap2.put("android.permission-group.ACTIVITY_RECOGNITION", QQPermissionConstants.Permission.ACTIVITY_RECOGNITION_GROUP);
            arrayMap2.put("android.permission-group.CALENDAR", QQPermissionConstants.Permission.CALENDAR_GROUP);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String d(Context context, String str, String str2) {
            return String.format(context.getString(R.string.f202864yn), e(context, str, str2));
        }

        private static String e(Context context, String str, String str2) {
            Integer num;
            int intValue;
            String str3 = f274314b.get(str2);
            if (str3 != null && str != null) {
                num = QQPermissionConstants.Module.f274295b.get(PermissionUtil.getHashKey(str, str3));
            } else {
                num = null;
            }
            if (num == null) {
                intValue = f274317e;
            } else {
                intValue = num.intValue();
            }
            return context.getString(intValue);
        }

        private static String f(Context context, String str) {
            int intValue;
            Integer num = QQPermissionConstants.Module.f274294a.get(str);
            if (num == null) {
                intValue = f274316d;
            } else {
                intValue = num.intValue();
            }
            return context.getString(intValue);
        }

        private static String g(Context context, String str) {
            int intValue;
            Integer num = f274313a.get(str);
            if (num == null) {
                intValue = f274315c;
            } else {
                intValue = num.intValue();
            }
            return context.getString(intValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String h(String str) {
            return QQPermissionConstants.Permission.PMONITOR_PERMISSION_GROUP.get(f274314b.get(str));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String i(Context context, String str, String str2) {
            return String.format(context.getString(R.string.f202874yo), f(context, str), g(context, str2));
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static abstract class d {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(String str, String str2, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16));
                return;
            }
            QLog.d("MultiSceneAuthorizationManager", 1, "onAuthStateChanged moduleId: " + str + " authState: " + z16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32014);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f274304a = new ArrayList();
        }
    }

    private static com.tencent.mobileqq.qqpermission.view.a a(Context context, String str, String str2, QQPermission.BasePermissionsListener basePermissionsListener) {
        String i3 = c.i(context, str, str2);
        String d16 = c.d(context, str, str2);
        com.tencent.mobileqq.qqpermission.view.a aVar = new com.tencent.mobileqq.qqpermission.view.a(context, R.style.f243861y);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(true);
        aVar.setTitle(i3);
        aVar.Q(d16);
        aVar.setAllowClickListener(new ViewOnClickListenerC8423a(context, str, str2, basePermissionsListener));
        aVar.setRefuseClickListener(new b(basePermissionsListener, context, str, str2));
        return aVar;
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, String> map = QQPermissionConstants.BUSINESS_MODULE_MAP;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        QLog.e("MultiSceneAuthorizationManager", 1, "not find ModuleId. check businessId: " + str);
        return "";
    }

    private static boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101332", false);
    }

    public static boolean d(Context context, String str, String str2) {
        if (context != null) {
            MMKVOptionEntity from = QMMKV.from(context, QMMKVFile.FILE_PANDORA_PERMISSION);
            if (str != null && str2 != null && from.containsKey(PermissionUtil.getHashKey(str, str2))) {
                return from.decodeBool(PermissionUtil.getHashKey(str, str2), true);
            }
        }
        if (!c()) {
            return true;
        }
        return false;
    }

    public static void e(Context context, String str, String str2, boolean z16) {
        if (str != null && str2 != null) {
            QMMKV.from(context, QMMKVFile.FILE_PANDORA_PERMISSION).encodeBool(PermissionUtil.getHashKey(str, str2), z16);
            String h16 = c.h(str2);
            if (h16 != null) {
                QLog.d("MultiSceneAuthorizationManager", 1, "moduleId: " + str + " pmonitorPermission: " + h16 + " permissionGroup:" + str2);
                if (z16) {
                    com.tencent.qmethod.monitor.a.q().d(str).j(h16);
                } else {
                    com.tencent.qmethod.monitor.a.q().d(str).m(h16);
                }
            }
            List<d> list = f274304a;
            if (list != null) {
                Iterator<d> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(str, str2, z16);
                }
            }
        }
    }

    public static void f(Context context, String str, String str2, QQPermission.BasePermissionsListener basePermissionsListener) {
        QLog.d("MultiSceneAuthorizationManager", 1, "show MultiSceneAuthorizationDialog");
        com.tencent.mobileqq.qqpermission.view.a a16 = a(context, str, str2, basePermissionsListener);
        if (basePermissionsListener != null) {
            basePermissionsListener.onMultiSceneDialogShow(a16);
        }
        try {
            a16.show();
        } catch (WindowManager.BadTokenException e16) {
            QLog.e("MultiSceneAuthorizationManager", 1, "toShowDialog e " + e16.getMessage());
        }
    }
}
