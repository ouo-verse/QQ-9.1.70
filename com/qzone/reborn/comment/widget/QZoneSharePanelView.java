package com.qzone.reborn.comment.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.activities.base.QZoneFeedOperateLogic;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.util.d;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001BB\u0011\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=B\u001b\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\b<\u0010@J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015H\u0014J\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\fJ\u0012\u0010 \u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010,\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010.\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010#R\u0016\u00100\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00102\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010#R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/comment/widget/QZoneSharePanelView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Landroid/view/View$OnClickListener;", "", "z0", "y0", "o0", "Lxc/h;", "r0", "Landroid/view/View;", "view", "", NodeProps.VISIBLE, "B0", "enable", "A0", "u0", "v0", "x0", "w0", "", "shareType", "p0", "s0", "getLayoutId", "feedData", c.G, "n0", "q0", "isNativeAd", "setShareButtonEnable", NodeProps.ON_CLICK, "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mShareToQQLayout", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mShareToQQIcon", h.F, "mShareToWXLayout", "i", "mShareToWXIcon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mShareToMomentLayout", BdhLogUtil.LogTag.Tag_Conn, "mShareToMomentIcon", "D", "mShareToXHSLayout", "Lcom/qzone/common/activities/base/QZoneFeedOperateLogic;", "E", "Lcom/qzone/common/activities/base/QZoneFeedOperateLogic;", "mFeedOperateLogic", UserInfo.SEX_FEMALE, "Lxc/h;", "mShareReportIoc", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneSharePanelView extends QZoneBaseWidgetView<BusinessFeedData> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mShareToMomentIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout mShareToXHSLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneFeedOperateLogic mFeedOperateLogic;

    /* renamed from: F, reason: from kotlin metadata */
    private xc.h mShareReportIoc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mShareToQQLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mShareToQQIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mShareToWXLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mShareToWXIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mShareToMomentLayout;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/comment/widget/QZoneSharePanelView$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QZoneResult unpack = QZoneResult.unpack(msg2);
            QZoneFeedOperateLogic qZoneFeedOperateLogic = QZoneSharePanelView.this.mFeedOperateLogic;
            Intrinsics.checkNotNull(qZoneFeedOperateLogic);
            qZoneFeedOperateLogic.handleGetShareUrl(unpack);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneSharePanelView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        z0();
    }

    private final void o0() {
        if (getData() == null) {
            return;
        }
        boolean j3 = d.j(getData().getFeedCommInfo().operatemask, 14);
        boolean j16 = d.j(getData().getFeedCommInfo().operatemask, 13);
        boolean j17 = d.j(getData().getFeedCommInfo().operatemask3, 9);
        xc.h r06 = r0();
        LinearLayout linearLayout = null;
        if (r06 != null) {
            LinearLayout linearLayout2 = this.mShareToQQLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareToQQLayout");
                linearLayout2 = null;
            }
            r06.P8(linearLayout2, 2, j3 ? 1 : 0);
        }
        xc.h r07 = r0();
        if (r07 != null) {
            LinearLayout linearLayout3 = this.mShareToWXLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareToWXLayout");
                linearLayout3 = null;
            }
            r07.P8(linearLayout3, 3, j16 ? 1 : 0);
        }
        xc.h r08 = r0();
        if (r08 != null) {
            LinearLayout linearLayout4 = this.mShareToMomentLayout;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareToMomentLayout");
                linearLayout4 = null;
            }
            r08.P8(linearLayout4, 4, j16 ? 1 : 0);
        }
        xc.h r09 = r0();
        if (r09 != null) {
            LinearLayout linearLayout5 = this.mShareToXHSLayout;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareToXHSLayout");
            } else {
                linearLayout = linearLayout5;
            }
            r09.P8(linearLayout, 5, j17 ? 1 : 0);
        }
    }

    private final void p0(View view, int shareType) {
        xc.h r06 = r0();
        if (r06 != null) {
            r06.Y5(view, shareType);
        }
    }

    private final xc.h r0() {
        if (this.mShareReportIoc == null) {
            this.mShareReportIoc = (xc.h) getIocInterface(xc.h.class);
        }
        return this.mShareReportIoc;
    }

    private final int s0() {
        int i3;
        BusinessFeedData originalInfo;
        if (getData().getFeedCommInfo() == null || getData().getFeedCommInfo().appid != 4) {
            i3 = -1;
        } else {
            i3 = getData().isForwardFeed() ? 3 : 1;
        }
        if (getData().isForwardFeed() && getData().getPictureInfo() == null && (originalInfo = getData().getOriginalInfo()) != null && originalInfo.getFeedCommInfo() != null && originalInfo.getFeedCommInfo().appid == 4) {
            return 2;
        }
        return i3;
    }

    private final void u0() {
        QZoneFeedOperateLogic qZoneFeedOperateLogic = this.mFeedOperateLogic;
        Intrinsics.checkNotNull(qZoneFeedOperateLogic);
        qZoneFeedOperateLogic.onShareToQQ();
        if (getData().isRegisterAnniversaryFeed()) {
            LpReportInfo_pf00064.allReport(109, 3, 2);
        } else {
            LpReportInfo_pf00064.allReport(85, 2);
        }
        LinearLayout linearLayout = this.mShareToQQLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToQQLayout");
            linearLayout = null;
        }
        p0(linearLayout, 2);
    }

    private final void v0() {
        QZoneFeedOperateLogic qZoneFeedOperateLogic = this.mFeedOperateLogic;
        Intrinsics.checkNotNull(qZoneFeedOperateLogic);
        qZoneFeedOperateLogic.onShareToWeixin();
        if (getData().isRegisterAnniversaryFeed()) {
            LpReportInfo_pf00064.allReport(109, 3, 3);
        } else {
            int s06 = s0();
            if (s06 != -1) {
                LpReportInfo_pf00064.allReport(85, 3, s06);
            } else {
                LpReportInfo_pf00064.allReport(85, 3);
            }
        }
        LinearLayout linearLayout = this.mShareToWXLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToWXLayout");
            linearLayout = null;
        }
        p0(linearLayout, 3);
    }

    private final void w0() {
        QZoneFeedOperateLogic qZoneFeedOperateLogic = this.mFeedOperateLogic;
        Intrinsics.checkNotNull(qZoneFeedOperateLogic);
        qZoneFeedOperateLogic.onShareToWxMoments();
        if (getData().isRegisterAnniversaryFeed()) {
            LpReportInfo_pf00064.allReport(109, 3, 4);
        } else {
            LpReportInfo_pf00064.allReport(85, 4);
        }
        LinearLayout linearLayout = this.mShareToMomentLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToMomentLayout");
            linearLayout = null;
        }
        p0(linearLayout, 4);
    }

    private final void x0() {
        QZoneFeedOperateLogic qZoneFeedOperateLogic = this.mFeedOperateLogic;
        Intrinsics.checkNotNull(qZoneFeedOperateLogic);
        qZoneFeedOperateLogic.onShareToXHS();
    }

    private final void y0() {
        Activity c16 = i.c(this);
        if (c16 == null || getData() == null) {
            return;
        }
        QZoneFeedOperateLogic qZoneFeedOperateLogic = new QZoneFeedOperateLogic(new b(), c16, "feed");
        this.mFeedOperateLogic = qZoneFeedOperateLogic;
        Intrinsics.checkNotNull(qZoneFeedOperateLogic);
        qZoneFeedOperateLogic.setFeedData(getData());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f1295069;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData feedData, int pos) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        y0();
        o0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f18573c) {
            u0();
        } else if (valueOf != null && valueOf.intValue() == R.id.f18593e) {
            v0();
        } else if (valueOf != null && valueOf.intValue() == R.id.f18603f) {
            w0();
        } else if (valueOf != null && valueOf.intValue() == R.id.f18633i) {
            x0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final int q0() {
        if (!g.f53821a.b().p1()) {
            return (int) (ViewUtils.getScreenWidth() * 0.4456d);
        }
        if (FontSettingManager.getFontLevel() > 17.0f) {
            return (int) (ViewUtils.getScreenWidth() * 0.6366048f);
        }
        return (int) (ViewUtils.getScreenWidth() * 0.5941644562d);
    }

    public final void setShareButtonEnable(boolean isNativeAd) {
        if (getData() == null) {
            return;
        }
        boolean z16 = isNativeAd || d.j((long) getData().getFeedCommInfo().operatemask, 14);
        boolean j3 = d.j(getData().getFeedCommInfo().operatemask, 13);
        boolean j16 = d.j(getData().getFeedCommInfo().operatemask3, 9);
        LinearLayout linearLayout = this.mShareToQQLayout;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToQQLayout");
            linearLayout = null;
        }
        A0(linearLayout, z16);
        LinearLayout linearLayout3 = this.mShareToWXLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToWXLayout");
            linearLayout3 = null;
        }
        A0(linearLayout3, j3);
        LinearLayout linearLayout4 = this.mShareToMomentLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToMomentLayout");
            linearLayout4 = null;
        }
        A0(linearLayout4, j3);
        LinearLayout linearLayout5 = this.mShareToXHSLayout;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToXHSLayout");
        } else {
            linearLayout2 = linearLayout5;
        }
        A0(linearLayout2, j16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneSharePanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        z0();
    }

    private final void z0() {
        View findViewById = findViewById(R.id.f18573c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.action_panel_share_to_qq)");
        this.mShareToQQLayout = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.f18583d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.action_panel_share_to_qq_img)");
        this.mShareToQQIcon = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f18593e);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.action_panel_share_to_wx)");
        this.mShareToWXLayout = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.f18623h);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.action_panel_share_to_wx_img)");
        this.mShareToWXIcon = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f18603f);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.action_panel_share_to_wx_circle)");
        this.mShareToMomentLayout = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.f18613g);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.action\u2026l_share_to_wx_circle_img)");
        this.mShareToMomentIcon = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.f18633i);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.action_panel_share_to_xhs)");
        this.mShareToXHSLayout = (LinearLayout) findViewById7;
        LinearLayout linearLayout = this.mShareToQQLayout;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToQQLayout");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout3 = this.mShareToWXLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToWXLayout");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = this.mShareToMomentLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToMomentLayout");
            linearLayout4 = null;
        }
        linearLayout4.setOnClickListener(this);
        LinearLayout linearLayout5 = this.mShareToXHSLayout;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToXHSLayout");
            linearLayout5 = null;
        }
        linearLayout5.setOnClickListener(this);
        LinearLayout linearLayout6 = this.mShareToXHSLayout;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareToXHSLayout");
        } else {
            linearLayout2 = linearLayout6;
        }
        B0(linearLayout2, g.f53821a.b().p1());
        setLayoutParams(new ViewGroup.LayoutParams(-1, q0()));
    }

    private final void B0(View view, boolean visible) {
        view.setVisibility(visible ? 0 : 8);
    }

    private final void A0(View view, boolean enable) {
        view.setAlpha(enable ? 1.0f : 0.3f);
    }
}
