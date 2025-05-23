package com.tencent.sqshow.zootopia.card.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.view.widget.ZootopiaCardTitleView;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaCardGroupData;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l84.a;
import t74.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b$\b&\u0018\u0000 \u007f2\u00020\u00012\u00020\u0002:\u0002\u0080\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\bz\u0010{B1\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010|\u001a\u00020,\u0012\u0006\u0010+\u001a\u00020%\u0012\u0006\u0010;\u001a\u000204\u0012\u0006\u0010}\u001a\u00020\u0010\u00a2\u0006\u0004\bz\u0010~J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u0005H\u0016J\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0019\u001a\u00020\u0005J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\u001e\u001a\u00020\u0005H\u0014J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H&J\b\u0010$\u001a\u00020\bH&R\"\u0010+\u001a\u00020%8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010B\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010F\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\"\u0010\u0012\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010=\u001a\u0004\bH\u0010?\"\u0004\bI\u0010AR$\u0010N\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010J\u001a\u0004\bG\u0010K\"\u0004\bL\u0010MR\"\u0010U\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010\\\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010d\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010h\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010_\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR$\u0010l\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010P\u001a\u0004\bj\u0010R\"\u0004\bk\u0010TR\u0014\u0010m\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010=R\u0014\u0010o\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010=R\u0014\u0010q\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010=R\u0014\u0010s\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010=R\u0014\u0010u\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010=R\u0014\u0010w\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010=R\u0014\u0010y\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010=\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "Landroid/widget/FrameLayout;", "Ll84/a;", "", "B", "", "isDebugOnly", "k", "", "l", "Landroid/content/Context;", "context", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "j", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "d", WadlProxyConsts.KEY_JUMP_URL, "needErrToast", "u", "logMsg", "y", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "c", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Loa4/a;", "Loa4/a;", "p", "()Loa4/a;", "setMapResViewModel", "(Loa4/a;)V", "mapResViewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "o", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "f", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "r", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "setSourceCurrent", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "sourceCurrent", h.F, "I", "getSelfItemType", "()I", "setSelfItemType", "(I)V", "selfItemType", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setSelfPos", "selfPos", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getTotalCount", "setTotalCount", "Lcom/tencent/sqshow/zootopia/data/c;", "()Lcom/tencent/sqshow/zootopia/data/c;", "setCardData", "(Lcom/tencent/sqshow/zootopia/data/c;)V", "cardData", "D", "Landroid/view/View;", DomainData.DOMAIN_NAME, "()Landroid/view/View;", "setLayoutRootView", "(Landroid/view/View;)V", "layoutRootView", "E", "Landroid/view/ViewGroup;", "getBaseContentContainer", "()Landroid/view/ViewGroup;", "setBaseContentContainer", "(Landroid/view/ViewGroup;)V", "baseContentContainer", "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaCardTitleView;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaCardTitleView;", "getGroupTitleView", "()Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaCardTitleView;", "setGroupTitleView", "(Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaCardTitleView;)V", "groupTitleView", "G", "getModuleTitleView", "setModuleTitleView", "moduleTitleView", "H", "getBottomMarginView", "setBottomMarginView", "bottomMarginView", "cardListBgColor", "J", "itemDecorationMargin", "K", "groupTitleHeight", "L", "moduleTitleHeight", "M", "titleAreaExtraMargin", "N", "extraMarginBetweenGroupAndModule", "P", "groupWithColorBottomMargin", "<init>", "(Landroid/content/Context;)V", "owner", "itemViewType", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class ZootopiaBaseCard extends FrameLayout implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private ZootopiaCardData cardData;

    /* renamed from: D, reason: from kotlin metadata */
    public View layoutRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup baseContentContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private ZootopiaCardTitleView groupTitleView;

    /* renamed from: G, reason: from kotlin metadata */
    private ZootopiaCardTitleView moduleTitleView;

    /* renamed from: H, reason: from kotlin metadata */
    private View bottomMarginView;

    /* renamed from: I, reason: from kotlin metadata */
    private final int cardListBgColor;

    /* renamed from: J, reason: from kotlin metadata */
    private final int itemDecorationMargin;

    /* renamed from: K, reason: from kotlin metadata */
    private final int groupTitleHeight;

    /* renamed from: L, reason: from kotlin metadata */
    private final int moduleTitleHeight;

    /* renamed from: M, reason: from kotlin metadata */
    private final int titleAreaExtraMargin;

    /* renamed from: N, reason: from kotlin metadata */
    private final int extraMarginBetweenGroupAndModule;

    /* renamed from: P, reason: from kotlin metadata */
    private final int groupWithColorBottomMargin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public oa4.a mapResViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public ZootopiaSource sourceCurrent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int selfItemType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int selfPos;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int totalCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaBaseCard(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selfPos = -1;
        this.totalCount = -1;
        this.cardListBgColor = getResources().getColor(R.color.f8557_);
        this.itemDecorationMargin = getResources().getDimensionPixelSize(R.dimen.f11996_);
        this.groupTitleHeight = getResources().getDimensionPixelSize(R.dimen.f11855w);
        this.moduleTitleHeight = getResources().getDimensionPixelSize(R.dimen.f12006a);
        this.titleAreaExtraMargin = getResources().getDimensionPixelSize(R.dimen.f12026c);
        this.extraMarginBetweenGroupAndModule = getResources().getDimensionPixelSize(R.dimen.f12036d);
        this.groupWithColorBottomMargin = getResources().getDimensionPixelSize(R.dimen.f11875y);
    }

    private final void B() {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        ZootopiaCardTitleView zootopiaCardTitleView;
        ZootopiaCardTitleView zootopiaCardTitleView2;
        ZootopiaCardData zootopiaCardData = this.cardData;
        if (zootopiaCardData != null) {
            boolean z19 = C() && zootopiaCardData.getTitleData().c();
            ZootopiaCardGroupData groupData = zootopiaCardData.getGroupData();
            if (groupData != null) {
                z16 = !TextUtils.isEmpty(groupData.getBgColor());
                z17 = C() && groupData.getTitleData().c() && zootopiaCardData.getInGroupSubIndex() == 0;
                z18 = z16 && zootopiaCardData.getInGroupSubIndex() == groupData.getChildModuleCount() - 1;
            } else {
                z16 = false;
                z17 = false;
                z18 = false;
            }
            if (z16) {
                try {
                    ZootopiaCardGroupData groupData2 = zootopiaCardData.getGroupData();
                    setBackgroundColor(Color.parseColor(groupData2 != null ? groupData2.getBgColor() : null));
                } catch (Exception unused) {
                    ZootopiaCardGroupData groupData3 = zootopiaCardData.getGroupData();
                    x("renderCommonUI setBg error " + (groupData3 != null ? groupData3.getBgColor() : null), false);
                }
            } else {
                setBackgroundColor(0);
            }
            if (z17) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.groupTitleHeight);
                layoutParams.topMargin = z16 ? i.b(8) : 0;
                ZootopiaCardTitleView zootopiaCardTitleView3 = this.groupTitleView;
                if (zootopiaCardTitleView3 == null) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ZootopiaCardTitleView zootopiaCardTitleView4 = new ZootopiaCardTitleView(context);
                    this.groupTitleView = zootopiaCardTitleView4;
                    addView(zootopiaCardTitleView4, layoutParams);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = zootopiaCardTitleView3 != null ? zootopiaCardTitleView3.getLayoutParams() : null;
                    FrameLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
                    if (!(layoutParams3 != null && layoutParams3.topMargin == layoutParams.topMargin) && (zootopiaCardTitleView2 = this.groupTitleView) != null) {
                        zootopiaCardTitleView2.setLayoutParams(layoutParams);
                    }
                }
                i3 = this.groupTitleHeight + layoutParams.topMargin + 0;
                ZootopiaCardTitleView zootopiaCardTitleView5 = this.groupTitleView;
                if (zootopiaCardTitleView5 != null) {
                    zootopiaCardTitleView5.setVisibility(0);
                }
                ZootopiaCardTitleView zootopiaCardTitleView6 = this.groupTitleView;
                if (zootopiaCardTitleView6 != null) {
                    zootopiaCardTitleView6.c(this.selfPos, zootopiaCardData, Boolean.TRUE);
                }
            } else {
                ZootopiaCardTitleView zootopiaCardTitleView7 = this.groupTitleView;
                if (zootopiaCardTitleView7 != null) {
                    zootopiaCardTitleView7.setVisibility(8);
                }
                i3 = 0;
            }
            if (z19) {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, this.moduleTitleHeight);
                int i16 = z17 ? this.extraMarginBetweenGroupAndModule : 0;
                layoutParams4.topMargin = i3 + i16;
                ZootopiaCardTitleView zootopiaCardTitleView8 = this.moduleTitleView;
                if (zootopiaCardTitleView8 == null) {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    ZootopiaCardTitleView zootopiaCardTitleView9 = new ZootopiaCardTitleView(context2);
                    this.moduleTitleView = zootopiaCardTitleView9;
                    addView(zootopiaCardTitleView9, layoutParams4);
                } else {
                    ViewGroup.LayoutParams layoutParams5 = zootopiaCardTitleView8 != null ? zootopiaCardTitleView8.getLayoutParams() : null;
                    FrameLayout.LayoutParams layoutParams6 = layoutParams5 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams5 : null;
                    if (!(layoutParams6 != null && layoutParams6.topMargin == layoutParams4.topMargin) && (zootopiaCardTitleView = this.moduleTitleView) != null) {
                        zootopiaCardTitleView.setLayoutParams(layoutParams4);
                    }
                }
                int i17 = i3 + this.moduleTitleHeight + i16;
                ZootopiaCardTitleView zootopiaCardTitleView10 = this.moduleTitleView;
                if (zootopiaCardTitleView10 != null) {
                    zootopiaCardTitleView10.setVisibility(0);
                }
                ZootopiaCardTitleView zootopiaCardTitleView11 = this.moduleTitleView;
                if (zootopiaCardTitleView11 != null) {
                    ZootopiaCardTitleView.d(zootopiaCardTitleView11, this.selfPos, zootopiaCardData, null, 4, null);
                }
                i3 = i17;
            } else {
                ZootopiaCardTitleView zootopiaCardTitleView12 = this.moduleTitleView;
                if (zootopiaCardTitleView12 != null) {
                    zootopiaCardTitleView12.setVisibility(8);
                }
            }
            if (i3 > 0) {
                i3 += this.titleAreaExtraMargin;
            }
            ViewGroup viewGroup = this.baseContentContainer;
            Object layoutParams7 = viewGroup != null ? viewGroup.getLayoutParams() : null;
            FrameLayout.LayoutParams layoutParams8 = layoutParams7 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams7 : null;
            if (layoutParams8 == null) {
                layoutParams8 = new FrameLayout.LayoutParams(-1, -2);
            }
            if (layoutParams8.topMargin != i3) {
                layoutParams8.topMargin = i3;
                ViewGroup viewGroup2 = this.baseContentContainer;
                if (viewGroup2 != null) {
                    viewGroup2.setLayoutParams(layoutParams8);
                }
            }
            if (z18) {
                int i18 = this.groupWithColorBottomMargin;
                int i19 = this.itemDecorationMargin + i18;
                if (this.bottomMarginView == null) {
                    FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, i18);
                    layoutParams9.bottomMargin = -i19;
                    layoutParams9.gravity = 80;
                    View view = new View(getContext());
                    view.setBackgroundColor(this.cardListBgColor);
                    this.bottomMarginView = view;
                    addView(view, 0, layoutParams9);
                }
                setPadding(0, 0, 0, i19);
                View view2 = this.bottomMarginView;
                if (view2 == null) {
                    return;
                }
                view2.setVisibility(0);
                return;
            }
            View view3 = this.bottomMarginView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            setPadding(0, 0, 0, this.itemDecorationMargin);
        }
    }

    private final String l() {
        return "IRecommendCard_" + z();
    }

    public boolean A() {
        return true;
    }

    protected boolean C() {
        return true;
    }

    @Override // l84.a
    /* renamed from: d, reason: from getter */
    public int getSelfItemType() {
        return this.selfItemType;
    }

    public void i() {
        a.C10714a.a(this);
    }

    public final void j(ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        y("baseBindItemInfo " + position, true);
        this.selfPos = position;
        this.totalCount = totalCount;
        this.cardData = dataInfo;
        if (A()) {
            B();
        }
    }

    /* renamed from: m, reason: from getter */
    public final ZootopiaCardData getCardData() {
        return this.cardData;
    }

    public final View n() {
        View view = this.layoutRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutRootView");
        return null;
    }

    public final LifecycleOwner o() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        return null;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int selfItemType = getSelfItemType();
        u.Companion companion = u.INSTANCE;
        int c16 = companion.c(getContext());
        int b16 = companion.b(getContext());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        y(selfItemType + " - onConfigurationChanged - width:" + c16 + " height: " + b16 + " density: " + companion.a(context), false);
    }

    public final oa4.a p() {
        oa4.a aVar = this.mapResViewModel;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mapResViewModel");
        return null;
    }

    /* renamed from: q, reason: from getter */
    public final int getSelfPos() {
        return this.selfPos;
    }

    public final ZootopiaSource r() {
        ZootopiaSource zootopiaSource = this.sourceCurrent;
        if (zootopiaSource != null) {
            return zootopiaSource;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sourceCurrent");
        return null;
    }

    public abstract View s(Context context, ViewGroup viewParent);

    public final void setBaseContentContainer(ViewGroup viewGroup) {
        this.baseContentContainer = viewGroup;
    }

    public final void setBottomMarginView(View view) {
        this.bottomMarginView = view;
    }

    public final void setCardData(ZootopiaCardData zootopiaCardData) {
        this.cardData = zootopiaCardData;
    }

    public final void setGroupTitleView(ZootopiaCardTitleView zootopiaCardTitleView) {
        this.groupTitleView = zootopiaCardTitleView;
    }

    public final void setLayoutRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.layoutRootView = view;
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<set-?>");
        this.lifecycleOwner = lifecycleOwner;
    }

    public final void setMapResViewModel(oa4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mapResViewModel = aVar;
    }

    public final void setModuleTitleView(ZootopiaCardTitleView zootopiaCardTitleView) {
        this.moduleTitleView = zootopiaCardTitleView;
    }

    public final void setSelfItemType(int i3) {
        this.selfItemType = i3;
    }

    public final void setSelfPos(int i3) {
        this.selfPos = i3;
    }

    public final void setSourceCurrent(ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(zootopiaSource, "<set-?>");
        this.sourceCurrent = zootopiaSource;
    }

    public final void setTotalCount(int i3) {
        this.totalCount = i3;
    }

    public final void t(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (A()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.dap, (ViewGroup) this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026_base_layout, this, true)");
            setLayoutRootView(inflate);
            setPadding(0, 0, 0, this.itemDecorationMargin);
            setClipToPadding(false);
            setClipChildren(false);
            View findViewById = n().findViewById(R.id.r3j);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) findViewById;
            this.baseContentContainer = viewGroup;
            Intrinsics.checkNotNull(viewGroup);
            s(context, viewGroup);
            return;
        }
        setLayoutRootView(s(context, this));
    }

    public final void u(String jumpUrl, boolean needErrToast) {
        if (!TextUtils.isEmpty(jumpUrl)) {
            y("launchScheme - " + jumpUrl, false);
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Intrinsics.checkNotNull(jumpUrl);
            iSchemeApi.launchScheme(context, jumpUrl);
            return;
        }
        x("launchScheme but url is empty", false);
        if (needErrToast) {
            QQToast.makeText(getContext(), R.string.xm9, 0).show();
        }
    }

    public final void x(String logMsg, boolean isDebugOnly) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        if (k(isDebugOnly)) {
            QLog.e(l(), 1, logMsg);
        }
    }

    public final void y(String logMsg, boolean isDebugOnly) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        if (k(isDebugOnly)) {
            QLog.i(l(), 1, logMsg);
        }
    }

    public abstract String z();

    private final boolean k(boolean isDebugOnly) {
        return !isDebugOnly || QLog.isColorLevel();
    }

    public static /* synthetic */ void w(ZootopiaBaseCard zootopiaBaseCard, String str, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            zootopiaBaseCard.u(str, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchScheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaBaseCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        setMapResViewModel(mapResViewModel);
        setLifecycleOwner(owner);
        setSourceCurrent(sourceCurrent);
        this.selfItemType = i3;
    }

    public void c() {
    }
}
