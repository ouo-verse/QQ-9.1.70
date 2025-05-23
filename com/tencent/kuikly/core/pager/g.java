package com.tencent.kuikly.core.pager;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.n;
import com.tencent.kuikly.core.utils.UrlParamIterator;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 72\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J'\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015R+\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR$\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001cR+\u0010*\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR+\u0010.\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR$\u00102\u001a\u00020/2\u0006\u0010\u0018\u001a\u00020/8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b(\u00100\u001a\u0004\b'\u00101R$\u00104\u001a\u00020/2\u0006\u0010\u0018\u001a\u00020/8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b,\u00100\u001a\u0004\b3\u00101R$\u00109\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R$\u0010<\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00106\u001a\u0004\b>\u00108\"\u0004\b?\u0010@R$\u0010C\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b!\u00106\u001a\u0004\bB\u00108R$\u0010D\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b:\u0010\u001cR$\u0010I\u001a\u00020E2\u0006\u0010\u0018\u001a\u00020E8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\b5\u0010HR+\u0010K\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b3\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\bJ\u0010\u001eR+\u0010N\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bL\u0010\u001a\u001a\u0004\b\u0019\u0010\u001c\"\u0004\bM\u0010\u001eR$\u0010R\u001a\u00020O2\u0006\u0010\u0018\u001a\u00020O8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b%\u0010P\u001a\u0004\bL\u0010QR$\u0010S\u001a\u00020/2\u0006\u0010\u0018\u001a\u00020/8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b=\u00101R$\u0010U\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bT\u00106\u001a\u0004\bT\u00108R$\u0010V\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b;\u0010\u001d\u001a\u0004\b$\u0010\u001cR(\u0010Y\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010W\u001a\u0004\b+\u0010XR\u0011\u0010[\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\bF\u0010Z\u00a8\u0006^"}, d2 = {"Lcom/tencent/kuikly/core/pager/g;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", HippyTKDListViewAdapter.X, "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", ISchemeApi.KEY_PAGE_DATA, "r", "u", "data", "", "width", "height", "G", "(Lcom/tencent/kuikly/core/nvi/serialization/json/e;DD)V", "T", "init", "Lkotlin/properties/ReadWriteProperty;", "a", "(Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "rawPageData", "", "<set-?>", "b", "Lkotlin/properties/ReadWriteProperty;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()F", UserInfo.SEX_FEMALE, "(F)V", "pageViewWidth", "c", "l", "E", "pageViewHeight", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "statusBarHeight", "e", "g", BdhLogUtil.LogTag.Tag_Conn, "deviceHeight", "f", tl.h.F, "D", "deviceWidth", "", "Ljava/lang/String;", "()Ljava/lang/String;", "appVersion", "o", "platform", "i", "Z", "v", "()Z", "isIOS", "j", "t", "isAndroid", "k", "y", "setOhOs", "(Z)V", "isOhOs", "w", "isIphoneX", "navigationBarHeight", "", DomainData.DOMAIN_NAME, "I", "()I", "nativeBuild", "B", "activityWidth", "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "activityHeight", "Lcom/tencent/kuikly/core/base/n;", "Lcom/tencent/kuikly/core/base/n;", "()Lcom/tencent/kuikly/core/base/n;", "safeAreaInsets", "osVersion", ReportConstant.COSTREPORT_PREFIX, "isAccessibilityRunning", "androidBottomBavBarHeight", "Ljava/lang/Float;", "()Ljava/lang/Float;", "density", "()Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "params", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.nvi.serialization.json.e rawPageData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty pageViewWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty pageViewHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float statusBarHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty deviceHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty deviceWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String appVersion;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String platform;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isIOS;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isAndroid;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isOhOs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isIphoneX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float navigationBarHeight;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int nativeBuild;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty activityWidth;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty activityHeight;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private n safeAreaInsets;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String osVersion;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isAccessibilityRunning;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private float androidBottomBavBarHeight;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private Float density;

    /* renamed from: w, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f117436w = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "pageViewWidth", "getPageViewWidth()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "pageViewHeight", "getPageViewHeight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "deviceHeight", "getDeviceHeight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "deviceWidth", "getDeviceWidth()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "activityWidth", "getActivityWidth()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "activityHeight", "getActivityHeight()F", 0))};

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/kuikly/core/pager/g$a;", "", "", "ACCESSIBILITY_RUNNING", "Ljava/lang/String;", "ACTIVITY_HEIGHT", "ACTIVITY_WIDTH", "ANDROID_BOTTOM_NAV_BAR_HEIGHT", IGuildMainFrameApi.APP_VERSION, "DENSITY", "DEVICE_HEIGHT", "DEVICE_WIDTH", "KEY_PARAM", "NATIVE_BUILD", "OS_VERSION", "PLATFORM", "PLATFORM_ANDROID", "PLATFORM_IOS", "PLATFORM_OHOS", "ROOT_VIEW_HEIGHT", "ROOT_VIEW_WIDTH", "SAFE_AREA_INSETS", "STATUS_BAR_HEIGHT", Global.TRACKING_URL, "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.pager.g$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public g() {
        Float valueOf = Float.valueOf(0.0f);
        this.pageViewWidth = a(valueOf);
        this.pageViewHeight = a(valueOf);
        this.deviceHeight = a(valueOf);
        this.deviceWidth = a(valueOf);
        this.appVersion = "";
        this.platform = "";
        this.activityWidth = a(valueOf);
        this.activityHeight = a(valueOf);
        this.safeAreaInsets = n.INSTANCE.b();
        this.osVersion = "";
    }

    private final void C(float f16) {
        this.deviceHeight.setValue(this, f117436w[2], Float.valueOf(f16));
    }

    private final void D(float f16) {
        this.deviceWidth.setValue(this, f117436w[3], Float.valueOf(f16));
    }

    private final boolean x() {
        return this.nativeBuild >= 8;
    }

    private final void z() {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = this.rawPageData;
        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rawPageData");
            eVar = null;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e m3 = eVar.m("param");
        if (m3 == null) {
            m3 = new com.tencent.kuikly.core.nvi.serialization.json.e();
            com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = this.rawPageData;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rawPageData");
                eVar3 = null;
            }
            eVar3.v("param", m3);
        }
        com.tencent.kuikly.core.nvi.serialization.json.e eVar4 = this.rawPageData;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rawPageData");
        } else {
            eVar2 = eVar4;
        }
        String p16 = eVar2.p("url");
        if (!StringsKt.isBlank(p16)) {
            UrlParamIterator urlParamIterator = new UrlParamIterator(p16);
            while (urlParamIterator.hasNext()) {
                Pair<? extends String, ? extends String> next = urlParamIterator.next();
                m3.v(next.component1(), next.component2());
            }
        }
    }

    public final void A(float f16) {
        this.activityHeight.setValue(this, f117436w[5], Float.valueOf(f16));
    }

    public final void B(float f16) {
        this.activityWidth.setValue(this, f117436w[4], Float.valueOf(f16));
    }

    public final void E(float f16) {
        this.pageViewHeight.setValue(this, f117436w[1], Float.valueOf(f16));
    }

    public final void F(float f16) {
        this.pageViewWidth.setValue(this, f117436w[0], Float.valueOf(f16));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        if ((r5 == g()) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G(com.tencent.kuikly.core.nvi.serialization.json.e data, double width, double height) {
        Intrinsics.checkNotNullParameter(data, "data");
        F((float) width);
        E((float) height);
        if (data.a("deviceWidth") && data.a("deviceHeight")) {
            float h16 = (float) data.h("deviceWidth");
            float h17 = (float) data.h("deviceHeight");
            if (h16 == h()) {
            }
            D(h16);
            C(h17);
        }
        if (data.a("activityWidth") && data.a("activityHeight")) {
            float h18 = (float) data.h("activityWidth");
            float h19 = (float) data.h("activityHeight");
            if (h18 == c()) {
                if (h19 == b()) {
                    return;
                }
            }
            B(h18);
            A(h19);
            return;
        }
        if (x()) {
            if (!(c() == h())) {
                B(h());
            }
            if (b() == g()) {
                return;
            }
            A(g());
        }
    }

    public <T> ReadWriteProperty<Object, T> a(T init) {
        return c01.c.a(init);
    }

    public final float b() {
        return ((Number) this.activityHeight.getValue(this, f117436w[5])).floatValue();
    }

    public final float c() {
        return ((Number) this.activityWidth.getValue(this, f117436w[4])).floatValue();
    }

    /* renamed from: d, reason: from getter */
    public final float getAndroidBottomBavBarHeight() {
        return this.androidBottomBavBarHeight;
    }

    /* renamed from: e, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: f, reason: from getter */
    public final Float getDensity() {
        return this.density;
    }

    public final float g() {
        return ((Number) this.deviceHeight.getValue(this, f117436w[2])).floatValue();
    }

    public final float h() {
        return ((Number) this.deviceWidth.getValue(this, f117436w[3])).floatValue();
    }

    /* renamed from: i, reason: from getter */
    public final int getNativeBuild() {
        return this.nativeBuild;
    }

    /* renamed from: j, reason: from getter */
    public final float getNavigationBarHeight() {
        return this.navigationBarHeight;
    }

    /* renamed from: k, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    public final float l() {
        return ((Number) this.pageViewHeight.getValue(this, f117436w[1])).floatValue();
    }

    public final float m() {
        return ((Number) this.pageViewWidth.getValue(this, f117436w[0])).floatValue();
    }

    public final com.tencent.kuikly.core.nvi.serialization.json.e n() {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = this.rawPageData;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rawPageData");
            eVar = null;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e m3 = eVar.m("param");
        return m3 == null ? new com.tencent.kuikly.core.nvi.serialization.json.e() : m3;
    }

    /* renamed from: o, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: p, reason: from getter */
    public final n getSafeAreaInsets() {
        return this.safeAreaInsets;
    }

    /* renamed from: q, reason: from getter */
    public final float getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public final void r(com.tencent.kuikly.core.nvi.serialization.json.e pageData) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        this.rawPageData = pageData;
        F((float) pageData.h("rootViewWidth"));
        E((float) pageData.h("rootViewHeight"));
        this.statusBarHeight = (float) pageData.h("statusBarHeight");
        C((float) pageData.h("deviceHeight"));
        D((float) pageData.h("deviceWidth"));
        this.appVersion = pageData.q("appVersion", "");
        this.platform = pageData.q("platform", "");
        this.nativeBuild = pageData.k("nativeBuild", 0);
        this.isIOS = Intrinsics.areEqual(this.platform, "iOS");
        this.isAndroid = Intrinsics.areEqual(this.platform, "android");
        this.isOhOs = Intrinsics.areEqual(this.platform, "ohos");
        float f16 = this.statusBarHeight;
        this.navigationBarHeight = 44 + f16;
        this.isIphoneX = this.isIOS && f16 > 30.0f;
        B((float) pageData.i("activityWidth", x() ? h() : 0.0d));
        A((float) pageData.i("activityHeight", x() ? g() : 0.0d));
        this.isAccessibilityRunning = com.tencent.kuikly.core.base.d.a(pageData.k("isAccessibilityRunning", 0));
        String q16 = pageData.q("safeAreaInsets", "");
        if (q16.length() > 0) {
            this.safeAreaInsets = n.INSTANCE.a(q16);
        }
        this.osVersion = pageData.p("osVersion");
        this.androidBottomBavBarHeight = (float) pageData.i("androidBottomNavBarHeight", 0.0d);
        double i3 = pageData.i("density", 0.0d);
        if (!(i3 == 0.0d)) {
            this.density = Float.valueOf((float) i3);
        }
        z();
    }

    /* renamed from: s, reason: from getter */
    public final boolean getIsAccessibilityRunning() {
        return this.isAccessibilityRunning;
    }

    /* renamed from: t, reason: from getter */
    public final boolean getIsAndroid() {
        return this.isAndroid;
    }

    public final boolean u() {
        return n().g("isDebug", false);
    }

    /* renamed from: v, reason: from getter */
    public final boolean getIsIOS() {
        return this.isIOS;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getIsIphoneX() {
        return this.isIphoneX;
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsOhOs() {
        return this.isOhOs;
    }
}
