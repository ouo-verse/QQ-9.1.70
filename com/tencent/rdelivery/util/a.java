package com.tencent.rdelivery.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.common.labels.VersionLabelWrapper;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.rdelivery.RDeliverySetting;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u001c\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001f\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bJ[\u0010&\u001a\u0004\u0018\u00010\u00012\n\u0010!\u001a\u0006\u0012\u0002\b\u00030 2\u0006\u0010\"\u001a\u00020\u00042\u0016\b\u0002\u0010$\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010 \u0018\u00010#2\u0012\b\u0002\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010#2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010)R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/rdelivery/util/a;", "", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "", "c", "Lcom/tencent/rdelivery/util/c;", "logger", "", "doPrintLog", "f", "Lorg/json/JSONArray;", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "e", "tagString", "l", "", "i", "jsonArray", "str", "b", "Landroid/content/Context;", "ctx", h.F, "g", "hitSubTaskTags", "k", "extraTag", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "oldTags", "newTags", "a", "Ljava/lang/Class;", "clazz", "methodName", "", "parameterTypes", "parameters", "j", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;Lcom/tencent/rdelivery/util/c;)Ljava/lang/Object;", "d", "Ljava/lang/Class;", "crashReportClsObj", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "lastHitSubTaskTagsMap", "Lcom/tencent/raft/standard/storage/IRStorage;", "Lcom/tencent/raft/standard/storage/IRStorage;", "commonStorage", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Class<?> crashReportClsObj;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static IRStorage commonStorage;

    /* renamed from: d, reason: collision with root package name */
    public static final a f364654d = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, JSONArray> lastHitSubTaskTagsMap = new ConcurrentHashMap<>();

    a() {
    }

    private final boolean b(JSONArray jsonArray, String str) {
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (Intrinsics.areEqual(jsonArray.get(i3), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final String c(RDeliverySetting setting) {
        return "HitSubTaskTagKey_" + setting.c();
    }

    private final String e(JSONArray tags) {
        if (tags != null) {
            StringBuilder sb5 = new StringBuilder();
            int length = tags.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = tags.get(i3);
                if (obj != null) {
                    sb5.append((String) obj);
                    sb5.append("|");
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
            }
            String sb6 = sb5.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb6, "sb.toString()");
            return sb6;
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String f(c logger, boolean doPrintLog) {
        String[] allKeys;
        String str;
        boolean z16;
        boolean startsWith$default;
        IRStorage iRStorage = commonStorage;
        String str2 = "";
        if (iRStorage != null && (allKeys = iRStorage.allKeys()) != null) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str3 : allKeys) {
                if (str3 != null) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str3, "HitSubTaskTagKey", false, 2, null);
                    if (startsWith$default) {
                        z16 = true;
                        if (!z16) {
                            arrayList.add(str3);
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            String str4 = "";
            for (String str5 : arrayList) {
                if (str5 != null) {
                    str = iRStorage.getString(str5, "");
                } else {
                    str = null;
                }
                if (logger != null) {
                    logger.a("RDelivery_BuglyHelper", "getTotalTags key = " + str5 + ", value = " + str, doPrintLog);
                }
                str4 = str4 + str;
            }
            str2 = str4;
        }
        if (logger != null) {
            logger.a("RDelivery_BuglyHelper", "getTotalTags result = " + str2, doPrintLog);
        }
        return str2;
    }

    private final void h(Context ctx, c logger) {
        SharedPreferences.Editor edit = ctx.getSharedPreferences("BuglySdkInfos", 0).edit();
        if (logger != null) {
            c.b(logger, "RDelivery_BuglyHelper", "initBuglyReport sdkAppID = b1af97d391,sdkVersion = 1.3.36-RC01", false, 4, null);
        }
        edit.putString("b1af97d391", "1.3.36-RC01");
        edit.apply();
    }

    private final void i(RDeliverySetting setting) {
        String string;
        String c16 = c(setting);
        IRStorage commonStorage2 = setting.getCommonStorage();
        String str = "";
        if (commonStorage2 != null && (string = commonStorage2.getString(c16, "")) != null) {
            str = string;
        }
        ConcurrentHashMap<String, JSONArray> concurrentHashMap = lastHitSubTaskTagsMap;
        concurrentHashMap.put(c16, l(str));
        c logger = setting.getLogger();
        if (logger != null) {
            logger.a(d.a("RDelivery_BuglyHelper", setting.getRdInstanceIdentifier()), "initHitSubTaskTagsOfInstance savedTag = " + str + ",lastHitSubTaskTagsMap[hitSubTaskTagKey] = " + concurrentHashMap.get(c16), setting.getEnableDetailLog());
        }
    }

    private final JSONArray l(String tagString) {
        List split$default;
        boolean z16;
        JSONArray jSONArray = new JSONArray();
        if (tagString != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) tagString, new String[]{"|"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : split$default) {
                if (((String) obj).length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put((String) it.next());
            }
        }
        return jSONArray;
    }

    public final boolean a(@Nullable JSONArray oldTags, @Nullable JSONArray newTags) {
        boolean z16 = false;
        if (oldTags == null && newTags == null) {
            return false;
        }
        if (oldTags == null && newTags != null) {
            return true;
        }
        if (oldTags != null && newTags == null) {
            return true;
        }
        if (newTags == null) {
            Intrinsics.throwNpe();
        }
        int length = newTags.length();
        boolean z17 = true;
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = newTags.get(i3);
            if (obj != null) {
                if (!b(oldTags, (String) obj)) {
                    z17 = false;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (z17) {
            if (oldTags == null) {
                Intrinsics.throwNpe();
            }
            if (oldTags.length() == newTags.length()) {
                z16 = true;
            }
        }
        return !z16;
    }

    @NotNull
    public final String d(@NotNull RDeliverySetting setting) {
        String string;
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        IRStorage iRStorage = commonStorage;
        if (iRStorage == null || (string = iRStorage.getString(c(setting), "")) == null) {
            return "";
        }
        return string;
    }

    public final synchronized void g(@NotNull Context ctx, @NotNull RDeliverySetting setting) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        try {
            Result.Companion companion = Result.INSTANCE;
            f364654d.i(setting);
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (commonStorage != null) {
            c logger = setting.getLogger();
            if (logger != null) {
                logger.a(d.a("RDelivery_BuglyHelper", setting.getRdInstanceIdentifier()), "init return for already initialed", setting.getEnableDetailLog());
            }
            return;
        }
        if (setting.getEnableBuglyQQCrashReport()) {
            h(ctx, setting.getLogger());
        }
        c logger2 = setting.getLogger();
        if (logger2 != null) {
            c.b(logger2, d.a("RDelivery_BuglyHelper", setting.getRdInstanceIdentifier()), "init", false, 4, null);
        }
        try {
            crashReportClsObj = CrashReport.class;
        } catch (ClassNotFoundException unused) {
            c logger3 = setting.getLogger();
            if (logger3 != null) {
                c.b(logger3, d.a("RDelivery_BuglyHelper", setting.getRdInstanceIdentifier()), "init error", false, 4, null);
            }
        }
        commonStorage = setting.getCommonStorage();
    }

    @Nullable
    public final Object j(@NotNull Class<?> clazz, @NotNull String methodName, @Nullable Class<?>[] parameterTypes, @Nullable Object[] parameters, @Nullable c logger) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        Intrinsics.checkParameterIsNotNull(methodName, "methodName");
        try {
        } catch (IllegalAccessException e16) {
            if (logger != null) {
                logger.c("RDelivery_BuglyHelper", "invokeStaticMethod " + e16);
            }
        } catch (IllegalArgumentException e17) {
            if (logger != null) {
                logger.c("RDelivery_BuglyHelper", "invokeStaticMethod " + e17);
            }
        } catch (InvocationTargetException e18) {
            if (logger != null) {
                logger.c("RDelivery_BuglyHelper", "invokeStaticMethod " + e18);
            }
        } catch (Exception e19) {
            if (logger != null) {
                logger.c("RDelivery_BuglyHelper", "invokeStaticMethod " + e19);
            }
        }
        if (parameterTypes == null && parameters == null) {
            Method declaredMethod = clazz.getDeclaredMethod(methodName, new Class[0]);
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "clazz.getDeclaredMethod(methodName)");
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, new Object[0]);
        }
        if (parameterTypes != null && parameters != null) {
            Method declaredMethod2 = clazz.getDeclaredMethod(methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod2, "clazz.getDeclaredMethod(\u2026hodName, *parameterTypes)");
            declaredMethod2.setAccessible(true);
            return declaredMethod2.invoke(null, Arrays.copyOf(parameters, parameters.length));
        }
        return null;
    }

    public final void k(@NotNull JSONArray hitSubTaskTags, @NotNull RDeliverySetting setting) {
        Intrinsics.checkParameterIsNotNull(hitSubTaskTags, "hitSubTaskTags");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        String c16 = c(setting);
        ConcurrentHashMap<String, JSONArray> concurrentHashMap = lastHitSubTaskTagsMap;
        JSONArray jSONArray = concurrentHashMap.get(c16);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        c logger = setting.getLogger();
        if (logger != null) {
            logger.a(d.a("RDelivery_BuglyHelper", setting.getRdInstanceIdentifier()), "saveHitSubTaskTags tags = " + hitSubTaskTags + ", oldTags = " + jSONArray + ",obj = " + crashReportClsObj, setting.getEnableDetailLog());
        }
        if ((crashReportClsObj != null || RightlyHelper.f364646c.h()) && a(jSONArray, hitSubTaskTags)) {
            String e16 = e(hitSubTaskTags);
            IRStorage iRStorage = commonStorage;
            if (iRStorage != null) {
                iRStorage.putString(c16, e16);
            }
            String f16 = f(setting.getLogger(), setting.getEnableDetailLog());
            concurrentHashMap.put(c16, hitSubTaskTags);
            Class<?> cls = crashReportClsObj;
            if (cls != null) {
                f364654d.j(cls, "putReservedRequestData", new Class[]{String.class, String.class}, new Object[]{VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, f16}, setting.getLogger());
            }
            if (setting.getForbidBuglyConnectReport()) {
                c logger2 = setting.getLogger();
                if (logger2 != null) {
                    logger2.a(d.a("RDelivery_BuglyHelper", setting.getRdInstanceIdentifier()), "saveHitSubTaskTags return for forbidBuglyConnectReport", setting.getEnableDetailLog());
                    return;
                }
                return;
            }
            m(setting.getLogger(), setting.getRdInstanceIdentifier());
        }
    }

    public final void m(@Nullable c logger, @Nullable String extraTag) {
        if (logger != null) {
            c.b(logger, d.a("RDelivery_BuglyHelper", extraTag), "triggerBuglyConnectReport obj = " + crashReportClsObj, false, 4, null);
        }
        Class<?> cls = crashReportClsObj;
        if (cls != null) {
            f364654d.j(cls, "triggerUserInfoUpload", null, null, logger);
        }
    }
}
