package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.imsdk.BuildConfig;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.pay.newcustomer.b;
import com.tencent.mobileqq.vas.pay.page.bean.RenewalPageToggleConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/j;", "", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<String, Integer> f310415b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, String> f310416c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u001f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rR#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001dR\u0014\u0010%\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0019R\u0014\u0010(\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0019R\u0014\u0010)\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0019R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0019R\u0014\u0010,\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0019R\u0014\u0010-\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\u001d\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/j$a;", "", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig;", "e", "", "k", "l", "a", "d", "b", "c", "j", "i", "Landroid/content/Context;", "context", "", tl.h.F, "", "InfoTypeStringMap", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "typeToStringMap", "g", "DEF_PREFERENTIAL_ITEM_BG_NORMAL", "Ljava/lang/String;", "DEF_PREFERENTIAL_ITEM_BG_NORMAL_NIGHT", "DEF_PREFERENTIAL_ITEM_BG_SELECTED", "DEF_SVIP_BUSINESS_TYPE", "I", "DIN_ALTERNATE_BOLD_FONT_PATH", "HIPPY_BUNDLE_DOMAIN", "HIPPY_BUNDLE_NAME", "HIPPY_HEIGHT", "HIPPY_TRACE_DETAIL", "ITEM_TYPE_QQ", "ITEM_TYPE_WEIXIN", "KEY_AID", "KEY_BUSINESS_TYPE", "KEY_ENTERANCE_ID", "KEY_HIPPY_TRACE", "KEY_POLICY_ID", "RED_FLAG_URL", "REQUEST_AID", "REQUEST_POLICY_ID", "SUPPORT_BUSINESS_TYPE", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.pay.page.j$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return e().getAutoRenewalProtocol();
        }

        @NotNull
        public final String b() {
            return "https://tianquan.gtimg.cn/shoal/vaclient/a17f3cc1-211a-4605-81ff-b2eb8458c7e8.png";
        }

        @NotNull
        public final String c() {
            return "https://tianquan.gtimg.cn/shoal/vaclient/59187a4b-522d-4ee4-b182-2b5fdf33382e.png";
        }

        @NotNull
        public final String d() {
            return "https://tianquan.gtimg.cn/shoal/vaclient/d7d975c9-5e5c-4b22-aa19-e0b7c5d84f4c.png";
        }

        @NotNull
        public final RenewalPageToggleConfig e() {
            Object bean = VasToggle.FEATURE_VAS_RENEWAL_PAGE.getBean(RenewalPageToggleConfig.class, new RenewalPageToggleConfig(null, null, null, null, null, null, null, null, 255, null));
            Intrinsics.checkNotNullExpressionValue(bean, "FEATURE_VAS_RENEWAL_PAGE\u2026enewalPageToggleConfig())");
            return (RenewalPageToggleConfig) bean;
        }

        @NotNull
        public final Map<String, Integer> f() {
            return j.f310415b;
        }

        @NotNull
        public final Map<Integer, String> g() {
            return j.f310416c;
        }

        public final int h(@NotNull Context context) {
            int i3;
            Intrinsics.checkNotNullParameter(context, "context");
            b.Companion companion = com.tencent.mobileqq.vas.pay.newcustomer.b.INSTANCE;
            RenewalPageToggleConfig.Hippy hippy = e().getHippy();
            if (hippy != null) {
                i3 = hippy.getHippyHeight();
            } else {
                i3 = 700;
            }
            return companion.a(context, i3);
        }

        @NotNull
        public final String i() {
            return "vip.qq.com";
        }

        @NotNull
        public final String j() {
            return HippyQQConstants.ModuleName.QQ_VIP_SSR;
        }

        @NotNull
        public final String k() {
            return "https://tianquan.gtimg.cn/shoal/vaclient/3462079a-25a1-4b06-8850-2c059f026c3d.png";
        }

        @NotNull
        public final String l() {
            return e().getVipProtocol();
        }

        Companion() {
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("default", 0);
        linkedHashMap.put(BuildConfig.FLAVOR, 1);
        linkedHashMap.put("vip", 2);
        linkedHashMap.put("svip", 3);
        linkedHashMap.put("bigvip", 4);
        linkedHashMap.put("shvip", 5);
        linkedHashMap.put("muvip", 6);
        linkedHashMap.put("star", 7);
        f310415b = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put(0, "default");
        linkedHashMap2.put(1, BuildConfig.FLAVOR);
        linkedHashMap2.put(2, "vip");
        linkedHashMap2.put(3, "svip");
        linkedHashMap2.put(4, "bigvip");
        linkedHashMap2.put(5, "shvip");
        linkedHashMap2.put(6, "muvip");
        linkedHashMap2.put(7, "star");
        f310416c = linkedHashMap2;
    }
}
