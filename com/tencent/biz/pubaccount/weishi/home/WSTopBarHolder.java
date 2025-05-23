package com.tencent.biz.pubaccount.weishi.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.home.guide.i;
import com.tencent.biz.pubaccount.weishi.home.view.WSColorTransitionPagerTitleView;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.view.nav.WSNavigationBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import vy.WSNavigationBarInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001\u0012B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J(\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0007R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u00101\u001a\u00020\u00038\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b%\u0010.\"\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006>"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/WSTopBarHolder;", "Lcom/tencent/biz/pubaccount/weishi/view/nav/WSNavigationBar$d;", "Le00/a;", "Lvy/a;", "info", "", "position", "", "r", "o", "barId", "", "isSelected", ReportConstant.COSTREPORT_PREFIX, "l", "index", "totalCount", "c", "a", "", "leavePercent", "leftToRight", "d", "enterPercent", "b", "", DomainData.DOMAIN_NAME, "p", "Lcom/tencent/biz/pubaccount/weishi/home/d;", h.F, "Lcom/tencent/biz/pubaccount/weishi/home/d;", "adapter", "Lcom/tencent/biz/pubaccount/weishi/home/view/WSColorTransitionPagerTitleView;", "i", "Lcom/tencent/biz/pubaccount/weishi/home/view/WSColorTransitionPagerTitleView;", "tvBarName", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "tvMsgNum", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "ivRedDot", "D", "Lvy/a;", "()Lvy/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lvy/a;)V", "barInfo", "Lcom/tencent/biz/pubaccount/weishi/home/guide/a;", "E", "Lcom/tencent/biz/pubaccount/weishi/home/guide/a;", "topBarGuideController", UserInfo.SEX_FEMALE, "I", "mBarIconType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Lcom/tencent/biz/pubaccount/weishi/home/d;Landroid/view/ViewGroup;)V", "G", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSTopBarHolder extends WSNavigationBar.d implements e00.a {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView ivRedDot;

    /* renamed from: D, reason: from kotlin metadata */
    public WSNavigationBarInfo barInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.home.guide.a topBarGuideController;

    /* renamed from: F, reason: from kotlin metadata */
    private int mBarIconType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final d adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private WSColorTransitionPagerTitleView tvBarName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tvMsgNum;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WSTopBarHolder(d adapter, ViewGroup parent) {
        super(r5);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.d1l, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026_bar_view, parent, false)");
        this.adapter = adapter;
        this.tvBarName = (WSColorTransitionPagerTitleView) e(R.id.p6y);
        this.tvMsgNum = (TextView) e(R.id.p9_);
        this.ivRedDot = (ImageView) e(R.id.p95);
        this.mBarIconType = 1;
        getBarView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.home.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSTopBarHolder.j(WSTopBarHolder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(WSTopBarHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adapter.s(this$0);
    }

    private final void o(WSNavigationBarInfo info, int position) {
        WSColorTransitionPagerTitleView wSColorTransitionPagerTitleView = this.tvBarName;
        if (wSColorTransitionPagerTitleView != null) {
            wSColorTransitionPagerTitleView.setSelected(info.f());
        }
        WSColorTransitionPagerTitleView wSColorTransitionPagerTitleView2 = this.tvBarName;
        if (wSColorTransitionPagerTitleView2 != null) {
            wSColorTransitionPagerTitleView2.setText(info.getBarName());
        }
        s(info.getBarType(), info.f());
        x.f("WSTopBarHolder", "position:" + position + ", isSelected:" + info.f());
        if (info.getRedNum() > 0) {
            TextView textView = this.tvMsgNum;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.tvMsgNum;
            if (textView2 != null) {
                textView2.setText(String.valueOf(info.getRedNum()));
            }
            ImageView imageView = this.ivRedDot;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        TextView textView3 = this.tvMsgNum;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        ImageView imageView2 = this.ivRedDot;
        if (imageView2 == null) {
            return;
        }
        imageView2.setVisibility(info.getIsShowRedDot() ? 0 : 8);
    }

    private final void r(WSNavigationBarInfo info, int position) {
        if (this.topBarGuideController == null) {
            com.tencent.biz.pubaccount.weishi.home.guide.a a16 = i.f80847a.a(info.getBarId());
            if (a16 != null) {
                a16.c(new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.home.WSTopBarHolder$updateTopBarGuide$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        d dVar;
                        dVar = WSTopBarHolder.this.adapter;
                        dVar.s(WSTopBarHolder.this);
                    }
                });
            } else {
                a16 = null;
            }
            this.topBarGuideController = a16;
        }
        com.tencent.biz.pubaccount.weishi.home.guide.a aVar = this.topBarGuideController;
        if (aVar != null) {
            aVar.b(position, this);
        }
    }

    @Override // e00.a
    public void a(int index, int totalCount) {
        x.f("WSTopBarHolder", "onDeselected index:" + index);
        WSColorTransitionPagerTitleView wSColorTransitionPagerTitleView = this.tvBarName;
        if (wSColorTransitionPagerTitleView != null) {
            wSColorTransitionPagerTitleView.a(index, totalCount);
        }
        e.f80814a.p(m().getBarId());
    }

    @Override // e00.a
    public void b(int index, int totalCount, float enterPercent, boolean leftToRight) {
        x.f("WSTopBarHolder", "onEnter index:" + index);
        WSColorTransitionPagerTitleView wSColorTransitionPagerTitleView = this.tvBarName;
        if (wSColorTransitionPagerTitleView != null) {
            wSColorTransitionPagerTitleView.b(index, totalCount, enterPercent, leftToRight);
        }
    }

    @Override // e00.a
    public void c(int index, int totalCount) {
        x.f("WSTopBarHolder", "onSelected index:" + index);
        WSColorTransitionPagerTitleView wSColorTransitionPagerTitleView = this.tvBarName;
        if (wSColorTransitionPagerTitleView != null) {
            wSColorTransitionPagerTitleView.c(index, totalCount);
        }
        e eVar = e.f80814a;
        eVar.n(m().getBarId());
        eVar.o(index);
        ImageView imageView = this.ivRedDot;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        com.tencent.biz.pubaccount.weishi.home.guide.a aVar = this.topBarGuideController;
        if (aVar != null) {
            aVar.a(index, totalCount, this);
        }
    }

    @Override // e00.a
    public void d(int index, int totalCount, float leavePercent, boolean leftToRight) {
        x.f("WSTopBarHolder", "onLeave index:" + index);
        WSColorTransitionPagerTitleView wSColorTransitionPagerTitleView = this.tvBarName;
        if (wSColorTransitionPagerTitleView != null) {
            wSColorTransitionPagerTitleView.d(index, totalCount, leavePercent, leftToRight);
        }
    }

    public final void l(WSNavigationBarInfo info, int position) {
        Intrinsics.checkNotNullParameter(info, "info");
        x.j("WSTopBarHolder", "[AbsWSBottomBarHolder.java][bindData] position:" + position);
        q(info);
        r(info, position);
        o(info, position);
    }

    public final WSNavigationBarInfo m() {
        WSNavigationBarInfo wSNavigationBarInfo = this.barInfo;
        if (wSNavigationBarInfo != null) {
            return wSNavigationBarInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("barInfo");
        return null;
    }

    public final String n() {
        return this.adapter.r();
    }

    public final void p() {
        com.tencent.biz.pubaccount.weishi.home.guide.a aVar = this.topBarGuideController;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    public final void q(WSNavigationBarInfo wSNavigationBarInfo) {
        Intrinsics.checkNotNullParameter(wSNavigationBarInfo, "<set-?>");
        this.barInfo = wSNavigationBarInfo;
    }

    private final void s(int barId, boolean isSelected) {
        int normalColor;
        int normalColor2;
        if (barId == 2) {
            WSColorTransitionPagerTitleView wSColorTransitionPagerTitleView = this.tvBarName;
            if (wSColorTransitionPagerTitleView != null) {
                wSColorTransitionPagerTitleView.setNormalColor(-7829368);
                wSColorTransitionPagerTitleView.setSelectedColor(-1);
                if (isSelected) {
                    normalColor2 = wSColorTransitionPagerTitleView.getSelectedColor();
                } else {
                    normalColor2 = wSColorTransitionPagerTitleView.getNormalColor();
                }
                wSColorTransitionPagerTitleView.setTextColor(normalColor2);
                x.f("WSTopBarHolder", "updateUIByBarStyle barId:" + barId);
                return;
            }
            return;
        }
        WSColorTransitionPagerTitleView wSColorTransitionPagerTitleView2 = this.tvBarName;
        if (wSColorTransitionPagerTitleView2 != null) {
            wSColorTransitionPagerTitleView2.setNormalColor(-7829368);
            wSColorTransitionPagerTitleView2.setSelectedColor(-16777216);
            if (isSelected) {
                normalColor = wSColorTransitionPagerTitleView2.getSelectedColor();
            } else {
                normalColor = wSColorTransitionPagerTitleView2.getNormalColor();
            }
            wSColorTransitionPagerTitleView2.setTextColor(normalColor);
            x.f("WSTopBarHolder", "updateUIByBarStyle isSelected:" + barId);
        }
    }
}
