package com.tencent.sqshow.zootopia.recommend.main.tab;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.o;
import com.tencent.sqshow.zootopia.utils.q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u0000 D2\u00020\u0001:\u0001\u0016B\u0097\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\"\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0011\u0012\b\b\u0002\u00100\u001a\u00020\u0011\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0011\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u0012\b\b\u0002\u0010;\u001a\u000208\u0012\b\b\u0002\u0010<\u001a\u000208\u0012\b\b\u0002\u0010A\u001a\u00020=\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nJ\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u001a\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010&\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u0016\u0010%R\u0017\u0010)\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\u001dR\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b*\u0010\u001dR\u0017\u0010.\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u0019R\u0017\u00100\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b/\u0010\u0019R\u0017\u00102\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b1\u0010\u001dR\u0017\u00104\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b3\u0010\u001dR\u0017\u00106\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b5\u0010\u0019R\u0017\u00107\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b,\u0010\u001dR\u0017\u0010;\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b\u000f\u00109\u001a\u0004\b#\u0010:R\u0017\u0010<\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b\u000e\u00109\u001a\u0004\b'\u0010:R\u0017\u0010A\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b\u001f\u0010@\u00a8\u0006E"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/f;", "", "", "pageType", "b", "f", "", "k", "Lcom/tencent/image/URLImageView;", "igv", "Lcom/tencent/sqshow/widget/pag/ZPlanPAGView;", "pagView", "needAnimation", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "toString", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "title", "I", h.F, "()I", "tabId", "c", "i", "tabType", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", "d", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", "()Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", "contentUrlInfo", "e", "getSelectedResId", "selectedResId", "getNormalResId", "normalResId", "g", "getSelectedResUrl", "selectedResUrl", "getNormalResUrl", "normalResUrl", "getSelectedTxtColor", "selectedTxtColor", "getNormalTxtColor", "normalTxtColor", "getTransitionUrl", "transitionUrl", "studyModeSwitch", "Lpu4/g;", "Lpu4/g;", "()Lpu4/g;", "sTabNormalRes", "sTabSelectedRes", "", "o", "J", "()J", "sTabEndTime", "<init>", "(Ljava/lang/String;IILcom/tencent/sqshow/zootopia/recommend/main/tab/e;IILjava/lang/String;Ljava/lang/String;IILjava/lang/String;ILpu4/g;Lpu4/g;J)V", "p", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.recommend.main.tab.f, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanTabData {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int tabId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int tabType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanTabContentUrl contentUrlInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectedResId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int normalResId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final String selectedResUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String normalResUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectedTxtColor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int normalTxtColor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final String transitionUrl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final int studyModeSwitch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final pu4.g sTabNormalRes;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final pu4.g sTabSelectedRes;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final long sTabEndTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/f$a;", "", "", "pageType", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.recommend.main.tab.f$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(int pageType) {
            if (pageType == 1 || pageType == 4 || pageType == 5 || pageType == 6) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    public ZPlanTabData(String title, int i3, int i16, ZPlanTabContentUrl contentUrlInfo, int i17, int i18, String selectedResUrl, String normalResUrl, int i19, int i26, String transitionUrl, int i27, pu4.g sTabNormalRes, pu4.g sTabSelectedRes, long j3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentUrlInfo, "contentUrlInfo");
        Intrinsics.checkNotNullParameter(selectedResUrl, "selectedResUrl");
        Intrinsics.checkNotNullParameter(normalResUrl, "normalResUrl");
        Intrinsics.checkNotNullParameter(transitionUrl, "transitionUrl");
        Intrinsics.checkNotNullParameter(sTabNormalRes, "sTabNormalRes");
        Intrinsics.checkNotNullParameter(sTabSelectedRes, "sTabSelectedRes");
        this.title = title;
        this.tabId = i3;
        this.tabType = i16;
        this.contentUrlInfo = contentUrlInfo;
        this.selectedResId = i17;
        this.normalResId = i18;
        this.selectedResUrl = selectedResUrl;
        this.normalResUrl = normalResUrl;
        this.selectedTxtColor = i19;
        this.normalTxtColor = i26;
        this.transitionUrl = transitionUrl;
        this.studyModeSwitch = i27;
        this.sTabNormalRes = sTabNormalRes;
        this.sTabSelectedRes = sTabSelectedRes;
        this.sTabEndTime = j3;
        o.j(sTabNormalRes);
        o.j(sTabSelectedRes);
    }

    private final int b(int pageType) {
        if (pageType == 1) {
            return R.drawable.igh;
        }
        return R.drawable.gym;
    }

    private final int f(int pageType) {
        if (pageType == 1) {
            return R.drawable.igi;
        }
        return R.drawable.gym;
    }

    /* renamed from: a, reason: from getter */
    public final ZPlanTabContentUrl getContentUrlInfo() {
        return this.contentUrlInfo;
    }

    /* renamed from: c, reason: from getter */
    public final long getSTabEndTime() {
        return this.sTabEndTime;
    }

    /* renamed from: d, reason: from getter */
    public final pu4.g getSTabNormalRes() {
        return this.sTabNormalRes;
    }

    /* renamed from: e, reason: from getter */
    public final pu4.g getSTabSelectedRes() {
        return this.sTabSelectedRes;
    }

    /* renamed from: g, reason: from getter */
    public final int getStudyModeSwitch() {
        return this.studyModeSwitch;
    }

    /* renamed from: h, reason: from getter */
    public final int getTabId() {
        return this.tabId;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.title.hashCode() * 31) + this.tabId) * 31) + this.tabType) * 31) + this.contentUrlInfo.hashCode()) * 31) + this.selectedResId) * 31) + this.normalResId) * 31) + this.selectedResUrl.hashCode()) * 31) + this.normalResUrl.hashCode()) * 31) + this.selectedTxtColor) * 31) + this.normalTxtColor) * 31) + this.transitionUrl.hashCode()) * 31) + this.studyModeSwitch) * 31) + this.sTabNormalRes.hashCode()) * 31) + this.sTabSelectedRes.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.sTabEndTime);
    }

    /* renamed from: i, reason: from getter */
    public final int getTabType() {
        return this.tabType;
    }

    /* renamed from: j, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final boolean k() {
        return this.tabType == 1;
    }

    public final void l(ZPlanPAGView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        if (TextUtils.isEmpty(this.transitionUrl)) {
            return;
        }
        pagView.setVisibility(4);
        pu4.g gVar = new pu4.g();
        gVar.f427435b = "pag";
        gVar.f427434a = this.transitionUrl;
        gVar.f427436c = "local_image";
        pagView.setRepeatCount(1);
        pagView.setProgress(0.0d);
        QLog.i("ZPlanTabData_", 1, "preloadAnimationFile - " + this.title + ", transitionUrl= " + this.transitionUrl);
        t74.f.f435541a.d(pagView, gVar, new b());
    }

    public final void m(URLImageView igv) {
        Intrinsics.checkNotNullParameter(igv, "igv");
        QLog.i("ZPlanTabData_", 1, "showNormalRes " + this);
        int i3 = this.normalResId;
        if (i3 == -1) {
            Context context = igv.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "igv.context");
            String str = this.normalResUrl;
            Drawable b16 = q.b(b(this.contentUrlInfo.getPageType()));
            Intrinsics.checkNotNullExpressionValue(b16, "getDrawable(getNormalDef\u2026contentUrlInfo.pageType))");
            CommonExKt.y(igv, context, str, R.color.qui_common_icon_tabbar_primary, b16);
            return;
        }
        igv.setImageResource(i3);
    }

    public final void n(URLImageView igv, ZPlanPAGView pagView, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(igv, "igv");
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        QLog.i("ZPlanTabData_", 1, "showSelectedRes needAnimation:" + needAnimation + ", " + this);
        int i3 = this.selectedResId;
        if (i3 == -1) {
            igv.setURLDrawableDownListener(null);
            CommonExKt.w(igv, this.selectedResUrl, q.b(f(this.contentUrlInfo.getPageType())), null, 4, null);
        } else {
            igv.setImageResource(i3);
        }
        boolean z16 = needAnimation && !TextUtils.isEmpty(this.transitionUrl);
        if (z16) {
            int i16 = this.selectedResId;
            if (i16 > 0) {
                Drawable b16 = q.b(i16);
                Intrinsics.checkNotNullExpressionValue(b16, "getDrawable(selectedResId)");
                pagView.setLoadingDrawable(b16);
            }
            pu4.g gVar = new pu4.g();
            gVar.f427435b = "pag";
            gVar.f427434a = this.transitionUrl;
            gVar.f427436c = "local_image";
            pagView.setRepeatCount(1);
            pagView.setProgress(0.0d);
            pagView.setSolidColor(pagView.getResources().getColor(R.color.qui_common_icon_tabbar_primary));
            t74.f.f435541a.d(pagView, gVar, null);
        }
        if (z16 && pagView.getIsLoaded()) {
            igv.setVisibility(4);
            pagView.setVisibility(0);
            return;
        }
        QLog.i("ZPlanTabData_", 1, "showSelectedRes pag not loaded - " + this.title + ", transitionUrl= " + this.transitionUrl);
        igv.setVisibility(0);
        pagView.setVisibility(4);
    }

    public String toString() {
        return "ZPlanTabData(title=" + this.title + ", tabId=" + this.tabId + ", tabType=" + this.tabType + ", contentUrlInfo=" + this.contentUrlInfo + ", selectedResId=" + this.selectedResId + ", normalResId=" + this.normalResId + ", selectedResUrl=" + this.selectedResUrl + ", normalResUrl=" + this.normalResUrl + ", selectedTxtColor=" + this.selectedTxtColor + ", normalTxtColor=" + this.normalTxtColor + ", transitionUrl=" + this.transitionUrl + ", studyModeSwitch=" + this.studyModeSwitch + ", sTabNormalRes=" + this.sTabNormalRes + ", sTabSelectedRes=" + this.sTabSelectedRes + ", sTabEndTime=" + this.sTabEndTime + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanTabData)) {
            return false;
        }
        ZPlanTabData zPlanTabData = (ZPlanTabData) other;
        return Intrinsics.areEqual(this.title, zPlanTabData.title) && this.tabId == zPlanTabData.tabId && this.tabType == zPlanTabData.tabType && Intrinsics.areEqual(this.contentUrlInfo, zPlanTabData.contentUrlInfo) && this.selectedResId == zPlanTabData.selectedResId && this.normalResId == zPlanTabData.normalResId && Intrinsics.areEqual(this.selectedResUrl, zPlanTabData.selectedResUrl) && Intrinsics.areEqual(this.normalResUrl, zPlanTabData.normalResUrl) && this.selectedTxtColor == zPlanTabData.selectedTxtColor && this.normalTxtColor == zPlanTabData.normalTxtColor && Intrinsics.areEqual(this.transitionUrl, zPlanTabData.transitionUrl) && this.studyModeSwitch == zPlanTabData.studyModeSwitch && Intrinsics.areEqual(this.sTabNormalRes, zPlanTabData.sTabNormalRes) && Intrinsics.areEqual(this.sTabSelectedRes, zPlanTabData.sTabSelectedRes) && this.sTabEndTime == zPlanTabData.sTabEndTime;
    }

    public /* synthetic */ ZPlanTabData(String str, int i3, int i16, ZPlanTabContentUrl zPlanTabContentUrl, int i17, int i18, String str2, String str3, int i19, int i26, String str4, int i27, pu4.g gVar, pu4.g gVar2, long j3, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i28 & 4) != 0 ? 0 : i16, zPlanTabContentUrl, (i28 & 16) != 0 ? -1 : i17, (i28 & 32) != 0 ? -1 : i18, (i28 & 64) != 0 ? "" : str2, (i28 & 128) != 0 ? "" : str3, (i28 & 256) != 0 ? Color.parseColor("#292929") : i19, (i28 & 512) != 0 ? Color.parseColor("#B4B5BB") : i26, (i28 & 1024) != 0 ? "" : str4, (i28 & 2048) != 0 ? 0 : i27, (i28 & 4096) != 0 ? new pu4.g() : gVar, (i28 & 8192) != 0 ? new pu4.g() : gVar2, (i28 & 16384) != 0 ? 0L : j3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/tab/f$b", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.recommend.main.tab.f$b */
    /* loaded from: classes34.dex */
    public static final class b implements PAGView.PAGViewListener {
        b() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView p06) {
            QLog.i("ZPlanTabData_", 1, "preloadAnimationFile - " + ZPlanTabData.this.getTitle() + ", onAnimationEnd");
            if (p06 != null) {
                p06.removeListener(this);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView p06) {
            QLog.i("ZPlanTabData_", 1, "preloadAnimationFile - " + ZPlanTabData.this.getTitle() + ", onAnimationStart");
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView p06) {
        }
    }
}
