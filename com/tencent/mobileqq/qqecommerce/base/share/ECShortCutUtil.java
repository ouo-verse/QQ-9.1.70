package com.tencent.mobileqq.qqecommerce.base.share;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.utils.ba;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.ecommerce.base.share.api.IECAddShortCutCallback;
import com.tencent.ecommerce.base.share.api.ShortCutInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ec;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.ToastUtil;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/share/ECShortCutUtil;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/ecommerce/base/share/api/h;", "shortCutInfo", "Lcom/tencent/ecommerce/base/share/api/IECAddShortCutCallback;", "callback", "", "e", "f", "", "title", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "", "g", tl.h.F, "i", "j", "k", "l", "d", "id", "Landroid/content/pm/ShortcutManager;", "shortcutManager", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECShortCutUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ECShortCutUtil f262463a = new ECShortCutUtil();

    ECShortCutUtil() {
    }

    private final void e(Activity activity, ShortCutInfo shortCutInfo, IECAddShortCutCallback callback) {
        Object systemService = activity.getSystemService("shortcut");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.pm.ShortcutManager");
        ShortcutManager shortcutManager = (ShortcutManager) systemService;
        if (!m(shortCutInfo.getId(), shortcutManager)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ECShortCutUtil$addShortCutForAndroidO$1(activity, shortcutManager, shortCutInfo, callback, null), 3, null);
            return;
        }
        ToastUtil.a().e(shortCutInfo.getShotLabel() + "\u5feb\u6377\u65b9\u5f0f\u5df2\u5b58\u5728");
        if (callback != null) {
            callback.onCallback(0, "have added short cut");
        }
    }

    private final int g(Context context) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        boolean contains$default6;
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = MANUFACTURER.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI, false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "xiaomi", false, 2, (Object) null);
            if (!contains$default2) {
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "oppo", false, 2, (Object) null);
                if (!contains$default3) {
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, false, 2, (Object) null);
                    if (!contains$default4) {
                        contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING, false, 2, (Object) null);
                        if (contains$default5) {
                            return 0;
                        }
                        contains$default6 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "meizu", false, 2, (Object) null);
                        return contains$default6 ? 0 : 3;
                    }
                    return k(context);
                }
                return j(context);
            }
            return i(context);
        }
        return h(context);
    }

    private final int h(Context context) {
        QLog.i("ECShortCutUtil", 1, "checkOnEMUI");
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName("com.huawei.hsm.permission.PermissionManager");
            Object invoke = cls.getDeclaredMethod("canSendBroadcast", Context.class, Intent.class).invoke(cls, context, intent);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) invoke).booleanValue();
            QLog.i("ECShortCutUtil", 1, "EMUI check permission canSendBroadcast invoke result = " + booleanValue);
            return !booleanValue ? 1 : 0;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                QLog.i("ECShortCutUtil", 1, m479exceptionOrNullimpl != null ? m479exceptionOrNullimpl.getMessage() : null);
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = 3;
            }
            return ((Number) m476constructorimpl).intValue();
        }
    }

    private final int i(Context context) {
        QLog.i("ECShortCutUtil", 1, "checkOnMIUI");
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = context.getSystemService("appops");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
            String packageName = context.getApplicationContext().getPackageName();
            int i3 = context.getApplicationInfo().uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Object invoke = cls.getDeclaredMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class).invoke((AppOpsManager) systemService, 10017, Integer.valueOf(i3), packageName);
            if (invoke == null) {
                QLog.i("ECShortCutUtil", 1, "MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result is null");
                return 3;
            }
            String obj = invoke.toString();
            Integer valueOf = Integer.valueOf(obj);
            QLog.i("ECShortCutUtil", 1, "MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result = " + obj);
            if (valueOf != null && valueOf.intValue() == 0) {
                return 0;
            }
            if (valueOf.intValue() == 1) {
                return 1;
            }
            if (valueOf != null && valueOf.intValue() == 5) {
                return 2;
            }
            return 3;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                QLog.i("ECShortCutUtil", 1, m479exceptionOrNullimpl != null ? m479exceptionOrNullimpl.getMessage() : null);
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = 3;
            }
            return ((Number) m476constructorimpl).intValue();
        }
    }

    private final int j(Context context) {
        Object obj;
        boolean contains$default;
        boolean contains$default2;
        QLog.i("ECShortCutUtil", 1, "checkOnOPPO");
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            QLog.i("ECShortCutUtil", 1, "contentResolver is null");
            return 3;
        }
        Cursor query = ContactsMonitor.query(contentResolver, Uri.parse("content://settings/secure/launcher_shortcut_permission_settings"), null, null, null, null);
        if (query == null) {
            QLog.i("ECShortCutUtil", 1, "cursor is null (Uri : content://settings/secure/launcher_shortcut_permission_settings)");
            return 3;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String packageName = context.getApplicationContext().getPackageName();
            while (query.moveToNext()) {
                String value = query.getString(query.getColumnIndexOrThrow("value"));
                QLog.i("ECShortCutUtil", 1, "permission value is " + value);
                if (!TextUtils.isEmpty(value)) {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) value, (CharSequence) (packageName + ", 1"), false, 2, (Object) null);
                    if (contains$default) {
                        return 0;
                    }
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) value, (CharSequence) (packageName + ", 0"), false, 2, (Object) null);
                    if (contains$default2) {
                        return 1;
                    }
                }
            }
            obj = Result.m476constructorimpl(r10);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        query.close();
        if (Result.m482isFailureimpl(obj)) {
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(obj);
            QLog.i("ECShortCutUtil", 1, m479exceptionOrNullimpl != null ? m479exceptionOrNullimpl.getMessage() : null);
        }
        return ((Number) (Result.m482isFailureimpl(obj) ? 3 : obj)).intValue();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x009f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int k(Context context) {
        Cursor cursor;
        boolean z16;
        int i3;
        QLog.i("ECShortCutUtil", 1, "checkOnVIVO");
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            QLog.i("ECShortCutUtil", 1, "contentResolver is null");
            return 3;
        }
        try {
            cursor = ContactsMonitor.query(contentResolver, Uri.parse("content://com.bbk.launcher2.settings/favorites"), null, null, null, null);
        } catch (Exception e16) {
            QLog.e("ECShortCutUtil", 1, "shortcutUtils query error", e16);
            cursor = null;
        }
        if (cursor == null) {
            QLog.i("ECShortCutUtil", 1, "cursor is null (Uri : content://com.bbk.launcher2.settings/favorites)");
            return 3;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                QLog.i("ECShortCutUtil", 1, "title by query is " + string);
                if (string != null && string.length() != 0) {
                    z16 = false;
                    if (!z16 && Intrinsics.areEqual(string, f262463a.l(context))) {
                        i3 = cursor.getInt(cursor.getColumnIndexOrThrow("shortcutPermission"));
                        QLog.i("ECShortCutUtil", 1, "permission value is " + i3);
                        if (i3 == 1) {
                            switch (i3) {
                                case 16:
                                    return 0;
                                case 18:
                                    return 2;
                            }
                        }
                        return 1;
                    }
                }
                z16 = true;
                if (!z16) {
                    i3 = cursor.getInt(cursor.getColumnIndexOrThrow("shortcutPermission"));
                    QLog.i("ECShortCutUtil", 1, "permission value is " + i3);
                    if (i3 == 1) {
                    }
                    return 1;
                }
            }
            return 3;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            cursor.close();
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                QLog.i("ECShortCutUtil", 1, m479exceptionOrNullimpl != null ? m479exceptionOrNullimpl.getMessage() : null);
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = 3;
            }
            return ((Number) m476constructorimpl).intValue();
        }
    }

    private final String l(Context context) {
        ApplicationInfo applicationInfo;
        CharSequence loadLabel;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getApplicationContext().getPackageName(), 0);
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (loadLabel = applicationInfo.loadLabel(packageManager)) == null) {
                return "";
            }
            String obj = loadLabel.toString();
            return obj == null ? "" : obj;
        } catch (PackageManager.NameNotFoundException e16) {
            QLog.e("ECShortCutUtil", 1, e16.getMessage());
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final Activity activity, String title) {
        final b bVar = new b(activity);
        bVar.setTitle(title);
        bVar.R(false);
        bVar.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.base.share.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ECShortCutUtil.o(b.this, dialogInterface, i3);
            }
        });
        bVar.setPositiveButton(HardCodeUtil.qqStr(R.string.tgf), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.base.share.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ECShortCutUtil.p(activity, dialogInterface, i3);
            }
        });
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(b dialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Activity activity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ba.openPermissionActivity(activity);
    }

    public final void d(Activity activity, ShortCutInfo shortCutInfo, IECAddShortCutCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shortCutInfo, "shortCutInfo");
        if (g(activity) == 1) {
            String qqStr = HardCodeUtil.qqStr(R.string.f172702tg1);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_shortcut_351ab93f)");
            n(activity, qqStr);
            if (callback != null) {
                callback.onCallback(1, "not have permission");
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            e(activity, shortCutInfo, callback);
        } else {
            f(activity, shortCutInfo, callback);
        }
    }

    public final boolean m(String id5, ShortcutManager shortcutManager) {
        List pinnedShortcuts;
        String id6;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(shortcutManager, "shortcutManager");
        pinnedShortcuts = shortcutManager.getPinnedShortcuts();
        Intrinsics.checkNotNullExpressionValue(pinnedShortcuts, "shortcutManager.pinnedShortcuts");
        List list = pinnedShortcuts;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            id6 = ((ShortcutInfo) it.next()).getId();
            if (Intrinsics.areEqual(id6, id5)) {
                return true;
            }
        }
        return false;
    }

    private final void f(Activity activity, ShortCutInfo shortCutInfo, IECAddShortCutCallback callback) {
        if (ec.k(activity, new String[]{shortCutInfo.getShotLabel()})) {
            QLog.i("ECShortCutUtil", 1, "Shortcut has created before!");
            ToastUtil.a().e(shortCutInfo.getShotLabel() + "\u5feb\u6377\u65b9\u5f0f\u5df2\u5b58\u5728");
            if (callback != null) {
                callback.onCallback(0, "have added short cut");
                return;
            }
            return;
        }
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", shortCutInfo.getShotLabel());
        intent.putExtra("duplicate", false);
        intent.putExtra("android.intent.extra.shortcut.ICON", shortCutInfo.getIcon());
        intent.putExtra("android.intent.extra.shortcut.INTENT", shortCutInfo.getIntent());
        activity.sendBroadcast(intent);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ECShortCutUtil$addShortCutForBelowO$1(activity, shortCutInfo, callback, null), 3, null);
    }
}
