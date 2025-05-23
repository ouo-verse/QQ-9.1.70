package com.tencent.sqshow.zootopia.card.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaCardGroupData;
import com.tencent.sqshow.zootopia.data.ZootopiaCardTitleData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pv4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\u00020\u0001:\u0001HB#\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u0012\u0006\u0010B\u001a\u00020\u0004\u00a2\u0006\u0004\bC\u0010DB\u0011\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\bC\u0010EB\u001b\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u00a2\u0006\u0004\bC\u0010FJ\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J,\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0002J)\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010*\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010#\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010#\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010#\u001a\u0004\b2\u00103R\u001b\u00107\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010#\u001a\u0004\b6\u0010%R\u001b\u0010:\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010#\u001a\u0004\b9\u0010.R\u001b\u0010=\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010#\u001a\u0004\b<\u00103\u00a8\u0006I"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaCardTitleView;", "Landroid/widget/RelativeLayout;", "", "netColorString", "", "defaultColorInt", "i", "schemeUrl", "", tl.h.F, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "jumpScheme", "cardPos", "", "", "g", "fullData", "", "isGroupTitle", "c", "(ILcom/tencent/sqshow/zootopia/data/c;Ljava/lang/Boolean;)V", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "iconDefaultDrawable", "e", "I", "mDefaultTitleColor", "f", "mDefaultMoreColor", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mDataReporter", "Landroid/widget/LinearLayout;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/LinearLayout;", "mZplanRecommendVgTitleContainer", "Landroid/widget/ImageView;", DomainData.DOMAIN_NAME, "()Landroid/widget/ImageView;", "mZplanRecommendVgTitleIcon", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", BdhLogUtil.LogTag.Tag_Conn, "p", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "mZplanTitleNetIcon", "Landroid/widget/TextView;", "D", "o", "()Landroid/widget/TextView;", "mZplanRecommendVgTitleTv", "E", "j", "mZplanRecommendVgMoreContainer", UserInfo.SEX_FEMALE, "k", "mZplanRecommendVgMoreNetIcon", "G", "l", "mZplanRecommendVgMoreTv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaCardTitleView extends RelativeLayout {

    /* renamed from: C */
    private final Lazy mZplanTitleNetIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy mZplanRecommendVgTitleTv;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy mZplanRecommendVgMoreContainer;

    /* renamed from: F */
    private final Lazy mZplanRecommendVgMoreNetIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy mZplanRecommendVgMoreTv;

    /* renamed from: d, reason: from kotlin metadata */
    private Drawable iconDefaultDrawable;

    /* renamed from: e, reason: from kotlin metadata */
    private final int mDefaultTitleColor;

    /* renamed from: f, reason: from kotlin metadata */
    private final int mDefaultMoreColor;

    /* renamed from: h */
    private final ZplanViewReportHelper mDataReporter;

    /* renamed from: i, reason: from kotlin metadata */
    private final Lazy mZplanRecommendVgTitleContainer;

    /* renamed from: m */
    private final Lazy mZplanRecommendVgTitleIcon;

    public ZootopiaCardTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        LayoutInflater.from(context).inflate(R.layout.daq, (ViewGroup) this, true);
        this.iconDefaultDrawable = q.b(R.drawable.ha8);
        this.mDefaultTitleColor = Color.parseColor("#FF302F2F");
        this.mDefaultMoreColor = Color.parseColor("#FF0179FF");
        this.mDataReporter = new ZplanViewReportHelper();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaCardTitleView$mZplanRecommendVgTitleContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) ZootopiaCardTitleView.this.findViewById(R.id.r7d);
            }
        });
        this.mZplanRecommendVgTitleContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaCardTitleView$mZplanRecommendVgTitleIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) ZootopiaCardTitleView.this.findViewById(R.id.r7e);
            }
        });
        this.mZplanRecommendVgTitleIcon = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMediaView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaCardTitleView$mZplanTitleNetIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanMediaView invoke() {
                return (ZPlanMediaView) ZootopiaCardTitleView.this.findViewById(R.id.r7f);
            }
        });
        this.mZplanTitleNetIcon = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaCardTitleView$mZplanRecommendVgTitleTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) ZootopiaCardTitleView.this.findViewById(R.id.r7g);
            }
        });
        this.mZplanRecommendVgTitleTv = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaCardTitleView$mZplanRecommendVgMoreContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) ZootopiaCardTitleView.this.findViewById(R.id.r7a);
            }
        });
        this.mZplanRecommendVgMoreContainer = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMediaView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaCardTitleView$mZplanRecommendVgMoreNetIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanMediaView invoke() {
                return (ZPlanMediaView) ZootopiaCardTitleView.this.findViewById(R.id.r7b);
            }
        });
        this.mZplanRecommendVgMoreNetIcon = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.ZootopiaCardTitleView$mZplanRecommendVgMoreTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) ZootopiaCardTitleView.this.findViewById(R.id.r7c);
            }
        });
        this.mZplanRecommendVgMoreTv = lazy7;
    }

    public static final void e(ZootopiaCardTitleData finalTitleData, ZootopiaCardTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(finalTitleData, "$finalTitleData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        u title = finalTitleData.getTitle();
        QLog.i("ZootopiaCardTitleView", 1, "Title Jump url:" + (title != null ? title.f427703b : null));
        u title2 = finalTitleData.getTitle();
        this$0.h(title2 != null ? title2.f427703b : null);
    }

    public static final void f(String str, ZootopiaCardTitleView this$0, Map reportParam, int i3, ZootopiaCardData fullData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportParam, "$reportParam");
        Intrinsics.checkNotNullParameter(fullData, "$fullData");
        QLog.i("ZootopiaCardTitleView", 1, "More Jump url:" + str);
        this$0.mDataReporter.e(this$0.j(), SquareReportConst.ElementId.ELEMENT_ID_SETTING, reportParam);
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        String str2 = pageInfo != null ? pageInfo.pageId : null;
        if (str2 == null) {
            str2 = "pg_zplan_paradise";
        }
        this$0.h(str != null ? CommonExKt.c(str, "ReportData", com.tencent.sqshow.zootopia.card.report.a.INSTANCE.c(i3, 0, "", fullData, null, str2, SquareReportConst.ElementId.ELEMENT_ID_SETTING)) : null);
    }

    private final Map<String, Object> g(ZootopiaCardData dataInfo, String jumpScheme, int cardPos) {
        Map<String, Object> a16;
        a16 = com.tencent.sqshow.zootopia.card.report.a.INSTANCE.a(cardPos, 0, "", dataInfo, jumpScheme, null, (r17 & 64) != 0 ? new HashMap() : null);
        return a16;
    }

    private final void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (str == null) {
            str = "";
        }
        iSchemeApi.launchScheme(context, str);
    }

    private final int i(String netColorString, int defaultColorInt) {
        if (TextUtils.isEmpty(netColorString)) {
            return defaultColorInt;
        }
        try {
            return Color.parseColor(netColorString);
        } catch (Exception e16) {
            QLog.e("ZootopiaCardTitleView", 1, "getFinalTxtColor error netColorString = " + netColorString, e16);
            return defaultColorInt;
        }
    }

    private final LinearLayout j() {
        Object value = this.mZplanRecommendVgMoreContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mZplanRecommendVgMoreContainer>(...)");
        return (LinearLayout) value;
    }

    private final ZPlanMediaView k() {
        Object value = this.mZplanRecommendVgMoreNetIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mZplanRecommendVgMoreNetIcon>(...)");
        return (ZPlanMediaView) value;
    }

    private final TextView l() {
        Object value = this.mZplanRecommendVgMoreTv.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mZplanRecommendVgMoreTv>(...)");
        return (TextView) value;
    }

    private final LinearLayout m() {
        Object value = this.mZplanRecommendVgTitleContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mZplanRecommendVgTitleContainer>(...)");
        return (LinearLayout) value;
    }

    private final ImageView n() {
        Object value = this.mZplanRecommendVgTitleIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mZplanRecommendVgTitleIcon>(...)");
        return (ImageView) value;
    }

    private final TextView o() {
        Object value = this.mZplanRecommendVgTitleTv.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mZplanRecommendVgTitleTv>(...)");
        return (TextView) value;
    }

    private final ZPlanMediaView p() {
        Object value = this.mZplanTitleNetIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mZplanTitleNetIcon>(...)");
        return (ZPlanMediaView) value;
    }

    public static /* synthetic */ void d(ZootopiaCardTitleView zootopiaCardTitleView, int i3, ZootopiaCardData zootopiaCardData, Boolean bool, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        zootopiaCardTitleView.c(i3, zootopiaCardData, bool);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0165, code lost:
    
        if ((r0.length() > 0) == true) goto L140;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(final int cardPos, final ZootopiaCardData fullData, Boolean isGroupTitle) {
        ZootopiaCardTitleData titleData;
        int dimensionPixelSize;
        pu4.g gVar;
        Intrinsics.checkNotNullParameter(fullData, "fullData");
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isGroupTitle, bool) && fullData.getGroupData() != null) {
            ZootopiaCardGroupData groupData = fullData.getGroupData();
            Intrinsics.checkNotNull(groupData);
            titleData = groupData.getTitleData();
        } else {
            titleData = fullData.getTitleData();
        }
        final ZootopiaCardTitleData zootopiaCardTitleData = titleData;
        aa.d(m(), new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.card.view.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaCardTitleView.e(ZootopiaCardTitleData.this, this, view);
            }
        });
        u moreInfo = zootopiaCardTitleData.getMoreInfo();
        final String str = moreInfo != null ? moreInfo.f427703b : null;
        final Map<String, Object> g16 = g(fullData, str == null ? "" : str, cardPos);
        aa.d(j(), new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.card.view.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaCardTitleView.f(str, this, g16, cardPos, fullData, view);
            }
        });
        this.mDataReporter.g(j(), SquareReportConst.ElementId.ELEMENT_ID_SETTING, (r16 & 4) != 0 ? null : g16, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        u title = zootopiaCardTitleData.getTitle();
        if (TextUtils.isEmpty((title == null || (gVar = title.f427705d) == null) ? null : gVar.f427434a)) {
            p().setVisibility(8);
            n().setVisibility(8);
        } else {
            p().setVisibility(0);
            n().setVisibility(8);
            p().setScaleType(ImageView.ScaleType.FIT_CENTER);
            p().setDefaultDrawable(this.iconDefaultDrawable);
            ZPlanMediaView p16 = p();
            u title2 = zootopiaCardTitleData.getTitle();
            pu4.g gVar2 = title2 != null ? title2.f427705d : null;
            if (gVar2 == null) {
                gVar2 = new pu4.g();
            }
            p16.e(gVar2);
        }
        TextView o16 = o();
        u title3 = zootopiaCardTitleData.getTitle();
        String str2 = title3 != null ? title3.f427702a : null;
        if (str2 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str2, "finalTitleData.title?.title ?: \"\"");
        }
        o16.setText(str2);
        boolean z16 = true;
        if (str2.length() == 0) {
            m().setVisibility(8);
        } else {
            m().setVisibility(0);
            u title4 = zootopiaCardTitleData.getTitle();
            int i3 = i(title4 != null ? title4.f427704c : null, this.mDefaultTitleColor);
            o16.setTextColor(i3);
            n().setColorFilter(i3);
        }
        if (Intrinsics.areEqual(isGroupTitle, bool)) {
            dimensionPixelSize = o16.getContext().getResources().getDimensionPixelSize(R.dimen.f11865x);
        } else {
            dimensionPixelSize = o16.getContext().getResources().getDimensionPixelSize(R.dimen.f12016b);
        }
        o16.setTextSize(0, dimensionPixelSize);
        u moreInfo2 = zootopiaCardTitleData.getMoreInfo();
        if (moreInfo2 != null && (r0 = moreInfo2.f427702a) != null) {
        }
        z16 = false;
        if (z16) {
            j().setVisibility(0);
        } else {
            j().setVisibility(8);
        }
        l84.b.a(l(), zootopiaCardTitleData.getMoreInfo(), this.mDefaultMoreColor);
        k().setDefaultDrawable(getResources().getDrawable(R.drawable.if5));
        ZPlanMediaView k3 = k();
        u moreInfo3 = zootopiaCardTitleData.getMoreInfo();
        pu4.g gVar3 = moreInfo3 != null ? moreInfo3.f427705d : null;
        if (gVar3 == null) {
            gVar3 = new pu4.g();
            gVar3.f427435b = "png";
            gVar3.f427434a = "";
        }
        k3.e(gVar3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaCardTitleView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaCardTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
