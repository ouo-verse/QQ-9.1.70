package com.tencent.mobileqq.tvideo.net.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import cooperation.qzone.PlatformInfor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0003R\u001b\u0010\u0012\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u000e\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010 \u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u001fR\u001c\u0010$\u001a\n \u001e*\u0004\u0018\u00010!0!8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/tvideo/net/utils/TVideoConfig;", "", "", "", "e", "k", "", "f", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "l", DomainData.DOMAIN_NAME, "", "b", "Lkotlin/Lazy;", "o", "()Z", "isPad", "c", "getVersionCode", "()I", "versionCode", "()Ljava/lang/String;", "channelId", h.F, "platform", "j", "platformVersion", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "()Landroid/content/Context;", "context", "Lcooperation/qzone/PlatformInfor;", "i", "()Lcooperation/qzone/PlatformInfor;", "platformInfor", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TVideoConfig {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TVideoConfig f304492a = new TVideoConfig();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isPad;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy versionCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy channelId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy platform;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy platformVersion;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.tvideo.net.utils.TVideoConfig$isPad$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Context c16;
                c16 = TVideoConfig.f304492a.c();
                return Boolean.valueOf(PadUtil.a(c16) == DeviceType.TABLET);
            }
        });
        isPad = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.tvideo.net.utils.TVideoConfig$versionCode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                Context c16;
                Context c17;
                TVideoConfig tVideoConfig = TVideoConfig.f304492a;
                c16 = tVideoConfig.c();
                PackageManager packageManager = c16.getPackageManager();
                c17 = tVideoConfig.c();
                return Integer.valueOf(InstalledAppListMonitor.getPackageInfo(packageManager, c17.getPackageName(), 0).versionCode);
            }
        });
        versionCode = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.tvideo.net.utils.TVideoConfig$channelId$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return AppSetting.h();
            }
        });
        channelId = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.tvideo.net.utils.TVideoConfig$platform$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(TVideoConfig.f304492a.o() ? 6 : 3);
            }
        });
        platform = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.tvideo.net.utils.TVideoConfig$platformVersion$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return DeviceInfoMonitor.getModel() + "," + Build.VERSION.SDK_INT + "," + Build.VERSION.RELEASE;
            }
        });
        platformVersion = lazy5;
    }

    TVideoConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context c() {
        return BaseApplication.getContext();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000f, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, new java.lang.String[]{com.huawei.hms.framework.common.ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<String, String> e() {
        List split$default;
        List split$default2;
        HashMap hashMap = new HashMap();
        String deviceInfor = i().getDeviceInfor();
        if (deviceInfor != null && split$default != null) {
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() >= 2) {
                    hashMap.put(split$default2.get(0), split$default2.get(1));
                }
            }
        }
        return hashMap;
    }

    private final PlatformInfor i() {
        return PlatformInfor.g();
    }

    @NotNull
    public final String b() {
        Object value = channelId.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-channelId>(...)");
        return (String) value;
    }

    public final int d() {
        return (int) ViewUtils.getDensityDpi();
    }

    public final int f() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET) {
            return 2;
        }
        return 1;
    }

    @NotNull
    public final String g() {
        return "";
    }

    public final int h() {
        return ((Number) platform.getValue()).intValue();
    }

    @NotNull
    public final String j() {
        return (String) platformVersion.getValue();
    }

    @NotNull
    public final String k() {
        String str = e().get("qimei36");
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0010, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{"*"}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int l() {
        List split$default;
        String str = e().get("p");
        if (str != null && split$default != null && split$default.size() >= 2) {
            return Integer.parseInt((String) split$default.get(1));
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0011, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{"*"}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m() {
        List split$default;
        String str = e().get("p");
        if (str == null || split$default == null || split$default.size() < 2) {
            return 0;
        }
        return Integer.parseInt((String) split$default.get(0));
    }

    @NotNull
    public final String n() {
        String versionName = PlatformInfor.g().getVersionName();
        Intrinsics.checkNotNullExpressionValue(versionName, "g().versionName");
        return versionName;
    }

    public final boolean o() {
        return ((Boolean) isPad.getValue()).booleanValue();
    }
}
