package com.tencent.mobileqq.vas.adv.base.support;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvInterfaceBinder;
import com.tencent.mobileqq.vas.adv.base.support.app.c;
import com.tencent.mobileqq.vas.adv.base.support.app.d;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.vivo.push.PushClientConstants;
import dz2.b;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010K\u001a\u00020\u0001\u0012\u0006\u0010M\u001a\u00020\u0002\u00a2\u0006\u0004\bN\u0010OJ\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J%\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0096\u0001J\t\u0010\u000e\u001a\u00020\fH\u0096\u0001J\u001b\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0003H\u0096\u0001J)\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0001J*\u0010!\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010 \u001a\u00028\u0000H\u0096\u0001\u00a2\u0006\u0004\b!\u0010\"J1\u0010)\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0'H\u0096\u0001J-\u0010-\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00102\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010,\u001a\u00020+H\u0096\u0001J\u000b\u0010/\u001a\u0004\u0018\u00010.H\u0096\u0001J\u000b\u00100\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u0013\u00102\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\"\u00104\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001032\b\u00101\u001a\u0004\u0018\u00010\u0010H\u0096\u0001\u00a2\u0006\u0004\b4\u00105J\u001b\u00107\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001062\b\u0010&\u001a\u0004\u0018\u00010%H\u0096\u0001J\u0015\u00108\u001a\u0004\u0018\u00010\u00102\b\u00101\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J3\u0010@\u001a\u00020\f2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020%2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010?\u001a\u00020\u0010H\u0096\u0001J9\u0010D\u001a\u00020\f2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020%2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020B0A2\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010?\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010G\u001a\u00020\f2\u0006\u0010:\u001a\u0002092\u0006\u0010F\u001a\u00020EH\u0096\u0001J\t\u0010H\u001a\u00020\u0010H\u0096\u0001J\u0006\u0010I\u001a\u00020\fR\u0014\u0010K\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010JR\u0014\u0010M\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010L\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvSupport;", "Lcom/tencent/mobileqq/vas/adv/base/support/app/c;", "Ldz2/b;", "", "i", "Landroid/content/Context;", "f", "Ljava/lang/Runnable;", "runnable", "", "networkJob", "autoRetrieve", "", "a", "initTbsEnvironment", "context", "", PushClientConstants.TAG_PKG_NAME, "isAppInstalled", "Landroid/view/View;", "g", "delay", "d", "cmd", "cmdKey", "", "reqBytes", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "callback", "c", "Lcom/tencent/mobileqq/pb/PBField;", "T", "pbField", "convertPbToJson", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "exposureUrl", "adView", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "pbAdInfo", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "resultCallback", "doExposure", "jsonGdtAdInfo", "", "position", "doOriginalExposure", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "getDeviceInfo", "getDeviceInfoAsJson", "gdtTangramAdJson", "getGdtCountdownTime", "", "getGdtDanmakuStrContents", "(Ljava/lang/String;)[Ljava/lang/String;", "", "getIndustryLabels", "getMarketPendantImgUrl", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "adInfo", "Lsz2/a;", "profitableCallback", "rewardText", ark.APP_SPECIFIC_BIZSRC, h.F, "Ljava/lang/ref/WeakReference;", "Ltz2/a;", "profitableCallbackRef", "e", "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "params", "toLandingPage", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/vas/adv/base/support/app/c;", "app", "Ldz2/b;", "gdt", "<init>", "(Lcom/tencent/mobileqq/vas/adv/base/support/app/c;Ldz2/b;)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdvSupport implements c, b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<VasAdvSupport> f307998d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b gdt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvSupport$a;", "", "Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvSupport;", "a", "instance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvSupport;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final VasAdvSupport b() {
            return (VasAdvSupport) VasAdvSupport.f307998d.getValue();
        }

        @JvmStatic
        @NotNull
        public final VasAdvSupport a() {
            return b();
        }

        Companion() {
        }
    }

    static {
        Lazy<VasAdvSupport> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<VasAdvSupport>() { // from class: com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VasAdvSupport invoke() {
                VasAdvInterfaceBinder.Companion companion = VasAdvInterfaceBinder.INSTANCE;
                return new VasAdvSupport(companion.b(), companion.c(), null);
            }
        });
        f307998d = lazy;
    }

    public /* synthetic */ VasAdvSupport(c cVar, b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, bVar);
    }

    @JvmStatic
    @NotNull
    public static final VasAdvSupport l() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(VasAdvSupport this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gdt.getDeviceInfo();
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public void a(@NotNull Runnable runnable, boolean networkJob, boolean autoRetrieve) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.app.a(runnable, networkJob, autoRetrieve);
    }

    @Override // dz2.b
    @NotNull
    public String b() {
        return this.gdt.b();
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public void c(@NotNull String cmd, @NotNull String cmdKey, @NotNull byte[] reqBytes, @NotNull d callback) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(cmdKey, "cmdKey");
        Intrinsics.checkNotNullParameter(reqBytes, "reqBytes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.app.c(cmd, cmdKey, reqBytes, callback);
    }

    @Override // dz2.b
    @Nullable
    public <T extends PBField<T>> String convertPbToJson(@NotNull T pbField) {
        Intrinsics.checkNotNullParameter(pbField, "pbField");
        return this.gdt.convertPbToJson(pbField);
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public void d(@NotNull Runnable runnable, long delay) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.app.d(runnable, delay);
    }

    @Override // dz2.b
    public void doExposure(@NotNull String exposureUrl, @NotNull View adView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, @NotNull VasResultCallback<Boolean> resultCallback) {
        Intrinsics.checkNotNullParameter(exposureUrl, "exposureUrl");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        this.gdt.doExposure(exposureUrl, adView, pbAdInfo, resultCallback);
    }

    @Override // dz2.b
    public boolean doOriginalExposure(@NotNull Context context, @Nullable String jsonGdtAdInfo, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, int position) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.gdt.doOriginalExposure(context, jsonGdtAdInfo, pbAdInfo, position);
    }

    @Override // dz2.b
    public void e(@NotNull Activity activity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull WeakReference<tz2.a> profitableCallbackRef, @Nullable String rewardText, @NotNull String bizSrc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(profitableCallbackRef, "profitableCallbackRef");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        this.gdt.e(activity, adInfo, profitableCallbackRef, rewardText, bizSrc);
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    @NotNull
    public Context f() {
        return this.app.f();
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    @Nullable
    public View g() {
        return this.app.g();
    }

    @Override // dz2.b
    @Nullable
    public qq_ad_get.QQAdGet.DeviceInfo getDeviceInfo() {
        return this.gdt.getDeviceInfo();
    }

    @Override // dz2.b
    @Nullable
    public String getDeviceInfoAsJson() {
        return this.gdt.getDeviceInfoAsJson();
    }

    @Override // dz2.b
    public int getGdtCountdownTime(@Nullable String gdtTangramAdJson) {
        return this.gdt.getGdtCountdownTime(gdtTangramAdJson);
    }

    @Override // dz2.b
    @Nullable
    public String[] getGdtDanmakuStrContents(@Nullable String gdtTangramAdJson) {
        return this.gdt.getGdtDanmakuStrContents(gdtTangramAdJson);
    }

    @Override // dz2.b
    @Nullable
    public List<String> getIndustryLabels(@Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo) {
        return this.gdt.getIndustryLabels(pbAdInfo);
    }

    @Override // dz2.b
    @Nullable
    public String getMarketPendantImgUrl(@Nullable String gdtTangramAdJson) {
        return this.gdt.getMarketPendantImgUrl(gdtTangramAdJson);
    }

    @Override // dz2.b
    public void h(@NotNull Activity activity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull sz2.a profitableCallback, @Nullable String rewardText, @NotNull String bizSrc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(profitableCallback, "profitableCallback");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        this.gdt.h(activity, adInfo, profitableCallback, rewardText, bizSrc);
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public long i() {
        return this.app.i();
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public void initTbsEnvironment() {
        this.app.initTbsEnvironment();
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public boolean isAppInstalled(@NotNull Context context, @Nullable String pkgName) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.app.isAppInstalled(context, pkgName);
    }

    public final void m() {
        c.a.a(this.app, new Runnable() { // from class: com.tencent.mobileqq.vas.adv.base.support.a
            @Override // java.lang.Runnable
            public final void run() {
                VasAdvSupport.n(VasAdvSupport.this);
            }
        }, false, false, 6, null);
    }

    @Override // dz2.b
    public void toLandingPage(@NotNull Activity activity, @NotNull LandingPageParams params) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        this.gdt.toLandingPage(activity, params);
    }

    VasAdvSupport(c cVar, b bVar) {
        this.app = cVar;
        this.gdt = bVar;
        m();
    }
}
