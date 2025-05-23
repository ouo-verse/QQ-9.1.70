package com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.zootopia.card.view.widget.ZootopiaDoubleClickLayout;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.player.ZPlanPlayerWithPreLoadView;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.recommend.common.event.ZplanConfigChangeEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanBanWorkItemEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanChangeShowTypeEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanDeleteWorkItemEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanDressDetailRefreshItemEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanDressDetailSettingsEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressDetailVideoChildView;
import com.tencent.sqshow.zootopia.utils.VideoUtils;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import eb4.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n74.at;
import pu4.g;
import pu4.j;
import pu4.l;
import pu4.n;
import pu4.s;
import t74.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002VWB#\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\u0006\u0010Q\u001a\u00020\n\u00a2\u0006\u0004\bR\u0010SB\u001b\b\u0016\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\u0006\u0010D\u001a\u00020B\u00a2\u0006\u0004\bR\u0010TB'\b\u0016\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\u0006\u0010D\u001a\u00020B\u00a2\u0006\u0004\bR\u0010UJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0003J\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u0012\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0014\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\"0!H\u0002J \u0010$\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0012\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J(\u0010*\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040(\u0018\u00010'j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040(\u0018\u0001`)H\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\b\u00103\u001a\u00020\u0005H\u0014J\b\u00104\u001a\u00020\u0005H\u0014R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00106R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u00108R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010CR\u0016\u0010G\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010L\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006X"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView;", "Landroid/widget/RelativeLayout;", "Lq84/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/sqshow/zootopia/data/g;", "data", "", "position", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "p", "i", "", "Lpu4/g;", "mediaList", "j", "count", "r", "f", "type", "g", "c", "xYaxis", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "status", "", DomainData.DOMAIN_NAME, "selectedPos", "o", "", "", "e", "d", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lq84/b;", "selectInfo", "w", UserInfo.SEX_FEMALE, "H", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "l", ExifInterface.LATITUDE_SOUTH, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Ln74/at;", "Ln74/at;", "binding", "Lcom/tencent/sqshow/zootopia/data/g;", "Lcom/tencent/sqshow/zootopia/player/ZPlanPlayerWithPreLoadView;", "Lcom/tencent/sqshow/zootopia/player/ZPlanPlayerWithPreLoadView;", "playerView", "Landroidx/viewpager/widget/ViewPager;", h.F, "Landroidx/viewpager/widget/ViewPager;", "viewpager", "Ljava/lang/String;", "sourceId", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", BdhLogUtil.LogTag.Tag_Conn, "I", "currentPosition", "D", "adapterPosition", "E", "Z", "shouldResumePlay", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DressDetailVideoChildView extends RelativeLayout implements q84.c, SimpleEventReceiver<SimpleBaseEvent> {
    private static final int G = ViewUtils.dpToPx(56.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private int currentPosition;

    /* renamed from: D, reason: from kotlin metadata */
    private int adapterPosition;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean shouldResumePlay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private at binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZootopiaDetailFeedsCardData data;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZPlanPlayerWithPreLoadView playerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewPager viewpager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String sourceId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource sourceCurrent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$b;", "", "Landroid/view/MotionEvent;", "event", "", "onDoubleTap", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void onDoubleTap(MotionEvent event);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$c", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$b;", "Landroid/view/MotionEvent;", "event", "", "onDoubleTap", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements b {
        c() {
        }

        @Override // com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressDetailVideoChildView.b
        public void onDoubleTap(MotionEvent event) {
            DressSquareDetailOperationView dressSquareDetailOperationView = DressDetailVideoChildView.this.binding.f418738d;
            Intrinsics.checkNotNullExpressionValue(dressSquareDetailOperationView, "binding.operateRl");
            DressSquareDetailOperationView.A(dressSquareDetailOperationView, DressDetailVideoChildView.this.binding.f418740f, event, true, false, false, 24, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$d", "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$b;", "Landroid/view/MotionEvent;", "event", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ZootopiaDoubleClickLayout.b {
        d() {
        }

        @Override // com.tencent.sqshow.zootopia.card.view.widget.ZootopiaDoubleClickLayout.b
        public void a(MotionEvent event) {
            QLog.d("DressDetailHorizontalView", 1, "onDoubleTap, event: " + event);
            if (DressDetailVideoChildView.this.binding.f418744j.getRoot().getVisibility() != 0) {
                QLog.d("DressDetailHorizontalView", 1, "view is invisible, do not action");
                return;
            }
            DressSquareDetailOperationView dressSquareDetailOperationView = DressDetailVideoChildView.this.binding.f418738d;
            Intrinsics.checkNotNullExpressionValue(dressSquareDetailOperationView, "binding.operateRl");
            DressSquareDetailOperationView.A(dressSquareDetailOperationView, DressDetailVideoChildView.this.binding.f418740f, event, true, false, false, 24, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$e", "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$d;", "Landroid/view/MotionEvent;", "event", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements ZootopiaDoubleClickLayout.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f372589a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DressDetailVideoChildView f372590b;

        e(ImageView imageView, DressDetailVideoChildView dressDetailVideoChildView) {
            this.f372589a = imageView;
            this.f372590b = dressDetailVideoChildView;
        }

        @Override // com.tencent.sqshow.zootopia.card.view.widget.ZootopiaDoubleClickLayout.d
        public void a(MotionEvent event) {
            QLog.d("DressDetailHorizontalView", 1, "onSingleTapConfirmed, event: " + event);
            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = null;
            if (this.f372589a.getVisibility() == 0) {
                ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView2 = this.f372590b.playerView;
                if (zPlanPlayerWithPreLoadView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerView");
                    zPlanPlayerWithPreLoadView2 = null;
                }
                ZootopiaPlayerView.z(zPlanPlayerWithPreLoadView2, false, false, 3, null);
                this.f372589a.setVisibility(4);
                return;
            }
            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView3 = this.f372590b.playerView;
            if (zPlanPlayerWithPreLoadView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerView");
            } else {
                zPlanPlayerWithPreLoadView = zPlanPlayerWithPreLoadView3;
            }
            zPlanPlayerWithPreLoadView.B();
            this.f372589a.setVisibility(0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressDetailVideoChildView$f", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements ViewPager.OnPageChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f372592e;

        f(int i3) {
            this.f372592e = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(DressDetailVideoChildView this$0, int i3, int i16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.binding.f418743i;
            Resources resources = this$0.getRootView().getContext().getResources();
            textView.setText(resources != null ? resources.getString(R.string.xo5, Integer.valueOf(i3 + 1), Integer.valueOf(i16)) : null);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            QLog.d("DressDetailHorizontalView", 1, "onPageSelected, state:" + state);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(final int position, float positionOffset, int positionOffsetPixels) {
            QLog.d("DressDetailHorizontalView", 1, "onPageScrolled, position:" + position);
            if (DressDetailVideoChildView.this.binding.f418743i.getVisibility() == 0) {
                final DressDetailVideoChildView dressDetailVideoChildView = DressDetailVideoChildView.this;
                final int i3 = this.f372592e;
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: jb4.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DressDetailVideoChildView.f.b(DressDetailVideoChildView.this, position, i3);
                    }
                });
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            QLog.d("DressDetailHorizontalView", 1, "onPageSelected, position:" + position);
        }
    }

    public DressDetailVideoChildView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        at g16 = at.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0129  */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.sqshow.zootopia.data.g] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void c() {
        int i3;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData;
        List<g> d16;
        int i16;
        ?? r06;
        Object firstOrNull;
        Object firstOrNull2;
        ZootopiaDetailFeedsCardData.Companion companion = ZootopiaDetailFeedsCardData.INSTANCE;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData2 = this.data;
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = null;
        if (zootopiaDetailFeedsCardData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            zootopiaDetailFeedsCardData2 = null;
        }
        List<g> d17 = companion.d(zootopiaDetailFeedsCardData2);
        if (d17 != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) d17);
            g gVar = (g) firstOrNull2;
            if (gVar != null) {
                i3 = gVar.f427439f;
                zootopiaDetailFeedsCardData = this.data;
                if (zootopiaDetailFeedsCardData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                    zootopiaDetailFeedsCardData = null;
                }
                d16 = companion.d(zootopiaDetailFeedsCardData);
                if (d16 != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) d16);
                    g gVar2 = (g) firstOrNull;
                    if (gVar2 != null) {
                        i16 = gVar2.f427440g;
                        if (i16 == 0 && i16 != 0) {
                            int screenHeight = (ScreenUtils.getScreenHeight(getContext()) + ImmersiveUtils.getStatusBarHeight(getContext())) - G;
                            QLog.d("DressDetailHorizontalView", 1, "videoWidth= " + i3 + ", videoHeight= " + i16 + ", real height= " + screenHeight);
                            VideoUtils videoUtils = VideoUtils.f373236a;
                            if (!videoUtils.s(i3, i16) && (!videoUtils.k(getContext()) || videoUtils.m(i3, i16))) {
                                if (videoUtils.r(i3, i16)) {
                                    ViewPager viewPager = this.viewpager;
                                    if (viewPager == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("viewpager");
                                        viewPager = null;
                                    }
                                    videoUtils.p(viewPager, -1, -1);
                                    ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView2 = this.playerView;
                                    if (zPlanPlayerWithPreLoadView2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("playerView");
                                        zPlanPlayerWithPreLoadView2 = null;
                                    }
                                    videoUtils.p(zPlanPlayerWithPreLoadView2.n(), -1, -1);
                                    ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView3 = this.playerView;
                                    if (zPlanPlayerWithPreLoadView3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("playerView");
                                    } else {
                                        zPlanPlayerWithPreLoadView = zPlanPlayerWithPreLoadView3;
                                    }
                                    videoUtils.p(zPlanPlayerWithPreLoadView, -1, -1);
                                    q(2);
                                    return;
                                }
                                ViewPager viewPager2 = this.viewpager;
                                if (viewPager2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewpager");
                                    viewPager2 = null;
                                }
                                videoUtils.q(screenHeight, viewPager2, i3, i16);
                                ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView4 = this.playerView;
                                if (zPlanPlayerWithPreLoadView4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("playerView");
                                    zPlanPlayerWithPreLoadView4 = null;
                                }
                                videoUtils.p(zPlanPlayerWithPreLoadView4.n(), i3, i16);
                                ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView5 = this.playerView;
                                if (zPlanPlayerWithPreLoadView5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("playerView");
                                } else {
                                    zPlanPlayerWithPreLoadView = zPlanPlayerWithPreLoadView5;
                                }
                                videoUtils.p(zPlanPlayerWithPreLoadView, i3, i16);
                                q(2);
                                return;
                            }
                            ViewPager viewPager3 = this.viewpager;
                            if (viewPager3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewpager");
                                viewPager3 = null;
                            }
                            videoUtils.q(screenHeight, viewPager3, i3, i16);
                            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView6 = this.playerView;
                            if (zPlanPlayerWithPreLoadView6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("playerView");
                                zPlanPlayerWithPreLoadView6 = null;
                            }
                            zPlanPlayerWithPreLoadView6.j(screenHeight, i3, i16);
                            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView7 = this.playerView;
                            if (zPlanPlayerWithPreLoadView7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("playerView");
                            } else {
                                zPlanPlayerWithPreLoadView = zPlanPlayerWithPreLoadView7;
                            }
                            videoUtils.p(zPlanPlayerWithPreLoadView, -1, screenHeight);
                            q(0);
                            return;
                        }
                        r06 = this.data;
                        if (r06 == 0) {
                            Intrinsics.throwUninitializedPropertyAccessException("data");
                        } else {
                            zPlanPlayerWithPreLoadView = r06;
                        }
                        QLog.d("DressDetailHorizontalView", 1, "width or height is 0, id= " + zPlanPlayerWithPreLoadView + ".outfitWorksInfo?.attributeInfo?.id");
                    }
                }
                i16 = 0;
                if (i16 == 0) {
                }
                r06 = this.data;
                if (r06 == 0) {
                }
                QLog.d("DressDetailHorizontalView", 1, "width or height is 0, id= " + zPlanPlayerWithPreLoadView + ".outfitWorksInfo?.attributeInfo?.id");
            }
        }
        i3 = 0;
        zootopiaDetailFeedsCardData = this.data;
        if (zootopiaDetailFeedsCardData == null) {
        }
        d16 = companion.d(zootopiaDetailFeedsCardData);
        if (d16 != null) {
        }
        i16 = 0;
        if (i16 == 0) {
        }
        r06 = this.data;
        if (r06 == 0) {
        }
        QLog.d("DressDetailHorizontalView", 1, "width or height is 0, id= " + zPlanPlayerWithPreLoadView + ".outfitWorksInfo?.attributeInfo?.id");
    }

    private final Map<String, Object> e() {
        a aVar = a.f396070a;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = this.data;
        if (zootopiaDetailFeedsCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            zootopiaDetailFeedsCardData = null;
        }
        return aVar.a(zootopiaDetailFeedsCardData.getOutfitWorksInfo(), this.sourceId);
    }

    private final void f() {
        j jVar;
        j jVar2;
        j jVar3;
        s sVar;
        int i3 = 1;
        QLog.d("DressDetailHorizontalView", 1, "changePrivacy");
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = this.data;
        String str = null;
        if (zootopiaDetailFeedsCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            zootopiaDetailFeedsCardData = null;
        }
        n outfitWorksInfo = zootopiaDetailFeedsCardData.getOutfitWorksInfo();
        long j3 = (outfitWorksInfo == null || (sVar = outfitWorksInfo.f427500c) == null) ? 0L : sVar.f427518a;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData2 = this.data;
        if (zootopiaDetailFeedsCardData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            zootopiaDetailFeedsCardData2 = null;
        }
        n outfitWorksInfo2 = zootopiaDetailFeedsCardData2.getOutfitWorksInfo();
        Integer valueOf = (outfitWorksInfo2 == null || (jVar3 = outfitWorksInfo2.f427498a) == null) ? null : Integer.valueOf(jVar3.f427466e);
        DressSquareDetailDesView dressSquareDetailDesView = this.binding.f418737c;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData3 = this.data;
        if (zootopiaDetailFeedsCardData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            zootopiaDetailFeedsCardData3 = null;
        }
        n outfitWorksInfo3 = zootopiaDetailFeedsCardData3.getOutfitWorksInfo();
        if (outfitWorksInfo3 != null && (jVar2 = outfitWorksInfo3.f427498a) != null) {
            i3 = jVar2.f427466e;
        }
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData4 = this.data;
        if (zootopiaDetailFeedsCardData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            zootopiaDetailFeedsCardData4 = null;
        }
        n outfitWorksInfo4 = zootopiaDetailFeedsCardData4.getOutfitWorksInfo();
        if (outfitWorksInfo4 != null && (jVar = outfitWorksInfo4.f427498a) != null) {
            str = jVar.f427462a;
        }
        dressSquareDetailDesView.n(i3, str, Long.valueOf(j3));
        if (w.f373306a.c(String.valueOf(j3)) || valueOf == null || valueOf.intValue() != 2) {
            return;
        }
        g(2);
    }

    private final void g(int type) {
        QLog.d("DressDetailHorizontalView", 1, "configureFeedVisible, type: " + type);
        if (type == 0) {
            QLog.d("DressDetailHorizontalView", 1, "configureFeedVisible, set video visible");
            this.binding.f418744j.getRoot().setVisibility(0);
            this.binding.f418745k.setVisibility(0);
            this.binding.f418742h.getRoot().setVisibility(4);
            return;
        }
        QLog.d("DressDetailHorizontalView", 1, "configureFeedVisible, set special view, privacy visible");
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = this.playerView;
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView2 = null;
        if (zPlanPlayerWithPreLoadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
            zPlanPlayerWithPreLoadView = null;
        }
        String str = "";
        zPlanPlayerWithPreLoadView.setVideoUrl("");
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView3 = this.playerView;
        if (zPlanPlayerWithPreLoadView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
            zPlanPlayerWithPreLoadView3 = null;
        }
        zPlanPlayerWithPreLoadView3.B();
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView4 = this.playerView;
        if (zPlanPlayerWithPreLoadView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
        } else {
            zPlanPlayerWithPreLoadView2 = zPlanPlayerWithPreLoadView4;
        }
        zPlanPlayerWithPreLoadView2.J();
        this.binding.f418744j.getRoot().setVisibility(4);
        this.binding.f418738d.setVisibility(4);
        this.binding.f418737c.setVisibility(4);
        this.binding.f418745k.setVisibility(4);
        this.binding.f418742h.getRoot().setVisibility(0);
        this.binding.f418742h.f418758b.setVisibility(0);
        if (type == 1) {
            str = getContext().getString(R.string.xnp);
            Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.stri\u2026dress_detail_delete_tips)");
        } else if (type == 2) {
            str = getContext().getString(R.string.xnq);
            Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.stri\u2026ss_detail_invisible_tips)");
        } else if (type == 3) {
            str = getContext().getString(R.string.xno);
            Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.stri\u2026an_dress_detail_ban_tips)");
        }
        this.binding.f418742h.f418759c.setText(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void i(ZootopiaDetailFeedsCardData data) {
        g gVar;
        String str;
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView;
        Object firstOrNull;
        Object firstOrNull2;
        Object firstOrNull3;
        n outfitWorksInfo = data.getOutfitWorksInfo();
        List<g> d16 = ZootopiaDetailFeedsCardData.INSTANCE.d(data);
        com.tencent.mobileqq.zootopia.e eVar = com.tencent.mobileqq.zootopia.e.f328302a;
        String str2 = null;
        if (d16 != null) {
            firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) d16);
            gVar = (g) firstOrNull3;
        } else {
            gVar = null;
        }
        boolean a16 = eVar.a(gVar);
        this.binding.f418737c.i(outfitWorksInfo, this.sourceCurrent);
        ZootopiaSource zootopiaSource = this.sourceCurrent;
        if (zootopiaSource != null) {
            at atVar = this.binding;
            atVar.f418738d.C(outfitWorksInfo, atVar.f418740f, zootopiaSource);
        }
        c();
        if (!a16) {
            j(d16);
            return;
        }
        r(0);
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView2 = this.binding.f418744j.f418767c;
        Intrinsics.checkNotNullExpressionValue(zPlanPlayerWithPreLoadView2, "binding.videoLayout.playerView");
        if (d16 != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) d16);
            g gVar2 = (g) firstOrNull2;
            if (gVar2 != null) {
                str = gVar2.f427436c;
                ZootopiaPlayerView.setCoverUrl$default(zPlanPlayerWithPreLoadView2, str != null ? "" : str, 0, 0, null, 14, null);
                zPlanPlayerWithPreLoadView = this.playerView;
                if (zPlanPlayerWithPreLoadView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerView");
                    zPlanPlayerWithPreLoadView = null;
                }
                if (d16 != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) d16);
                    g gVar3 = (g) firstOrNull;
                    if (gVar3 != null) {
                        str2 = gVar3.f427434a;
                    }
                }
                zPlanPlayerWithPreLoadView.setVideoUrl(str2 != null ? str2 : "");
            }
        }
        str = null;
        ZootopiaPlayerView.setCoverUrl$default(zPlanPlayerWithPreLoadView2, str != null ? "" : str, 0, 0, null, 14, null);
        zPlanPlayerWithPreLoadView = this.playerView;
        if (zPlanPlayerWithPreLoadView == null) {
        }
        if (d16 != null) {
        }
        zPlanPlayerWithPreLoadView.setVideoUrl(str2 != null ? str2 : "");
    }

    private final void j(List<g> mediaList) {
        QLog.d("DressDetailHorizontalView", 1, "handlePicData: mediaList: " + mediaList);
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = this.playerView;
        if (zPlanPlayerWithPreLoadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
            zPlanPlayerWithPreLoadView = null;
        }
        zPlanPlayerWithPreLoadView.setVisibility(8);
        hb4.a aVar = new hb4.a(new c());
        this.binding.f418745k.setAdapter(aVar);
        at atVar = this.binding;
        atVar.f418736b.setViewPager(atVar.f418745k);
        aVar.g(mediaList);
        aVar.notifyDataSetChanged();
        r(aVar.getF373114d());
    }

    private final void k() {
        ImageView imageView = this.binding.f418744j.f418768d;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.videoLayout.stopIcon");
        this.binding.f418739e.setOnDoubleClickListener(new d());
        this.binding.f418739e.setOnTapClickListener(new e(imageView, this));
    }

    private final void m() {
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = this.binding.f418744j.f418767c;
        Intrinsics.checkNotNullExpressionValue(zPlanPlayerWithPreLoadView, "binding.videoLayout.playerView");
        this.playerView = zPlanPlayerWithPreLoadView;
        ViewPager viewPager = this.binding.f418745k;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.viewPager");
        this.viewpager = viewPager;
        k();
    }

    private final boolean n(int status) {
        if (status == 0) {
            return true;
        }
        return false;
    }

    private final boolean o(int selectedPos) {
        return this.adapterPosition == selectedPos;
    }

    private final void p(ZootopiaDetailFeedsCardData data, int position, String requestId) {
        j jVar;
        QLog.d("DressDetailHorizontalView", 1, "data: " + data + ", position: " + position);
        n outfitWorksInfo = data.getOutfitWorksInfo();
        SimpleBaseEvent simpleBaseEvent = null;
        String str = (outfitWorksInfo == null || (jVar = outfitWorksInfo.f427498a) == null) ? null : jVar.f427462a;
        if (str == null) {
            str = "";
        }
        if (position == 0) {
            if (str.length() == 0) {
                if (requestId == null) {
                    requestId = "";
                }
                str = requestId;
            }
        }
        int status = data.getStatus();
        if (status == 0) {
            h(this, 0, 1, null);
            i(data);
        } else if (status == 1) {
            simpleBaseEvent = new ZplanDeleteWorkItemEvent(str);
        } else if (status == 2) {
            simpleBaseEvent = new ZplanChangeShowTypeEvent(str, 2);
        } else if (status == 3) {
            simpleBaseEvent = new ZplanBanWorkItemEvent(str);
        }
        if (simpleBaseEvent != null) {
            onReceiveEvent(simpleBaseEvent);
            SimpleEventBus.getInstance().dispatchEvent(simpleBaseEvent);
        }
    }

    private final void q(int xYaxis) {
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = this.playerView;
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView2 = null;
        if (zPlanPlayerWithPreLoadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
            zPlanPlayerWithPreLoadView = null;
        }
        zPlanPlayerWithPreLoadView.setXYaxis(xYaxis);
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView3 = this.playerView;
        if (zPlanPlayerWithPreLoadView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
            zPlanPlayerWithPreLoadView3 = null;
        }
        com.tencent.sqshow.zootopia.player.c r16 = zPlanPlayerWithPreLoadView3.r();
        if (r16 != null) {
            r16.setXYaxis(xYaxis);
            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView4 = this.playerView;
            if (zPlanPlayerWithPreLoadView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerView");
            } else {
                zPlanPlayerWithPreLoadView2 = zPlanPlayerWithPreLoadView4;
            }
            zPlanPlayerWithPreLoadView2.requestLayout();
        }
    }

    @Override // q84.c
    public void F(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        QLog.d("DressDetailHorizontalView", 1, "onPaused");
        if (o(selectInfo.getMPosition())) {
            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = this.playerView;
            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView2 = null;
            if (zPlanPlayerWithPreLoadView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerView");
                zPlanPlayerWithPreLoadView = null;
            }
            String str = zPlanPlayerWithPreLoadView.getCom.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String();
            if (str == null || str.length() == 0) {
                return;
            }
            this.shouldResumePlay = true;
            this.binding.f418744j.f418768d.setVisibility(0);
            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView3 = this.playerView;
            if (zPlanPlayerWithPreLoadView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerView");
            } else {
                zPlanPlayerWithPreLoadView2 = zPlanPlayerWithPreLoadView3;
            }
            zPlanPlayerWithPreLoadView2.I();
        }
    }

    @Override // q84.c
    public void H(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        QLog.d("DressDetailHorizontalView", 1, DKHippyEvent.EVENT_STOP);
    }

    @Override // q84.c
    public void S(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        QLog.d("DressDetailHorizontalView", 1, "onFeedUnSelected, position: " + selectInfo.getMPosition() + ", next: " + selectInfo.getMNextPosition() + ", currentPosition: " + this.currentPosition);
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = this.playerView;
        if (zPlanPlayerWithPreLoadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
            zPlanPlayerWithPreLoadView = null;
        }
        zPlanPlayerWithPreLoadView.J();
    }

    public final void d(ZootopiaDetailFeedsCardData data, int position, String requestId) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.adapterPosition = position;
        p(data, position, requestId);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZplanDeleteWorkItemEvent.class);
        arrayList.add(ZplanChangeShowTypeEvent.class);
        arrayList.add(ZplanDressDetailSettingsEvent.class);
        arrayList.add(ZplanBanWorkItemEvent.class);
        arrayList.add(ZplanConfigChangeEvent.class);
        return arrayList;
    }

    @Override // q84.c
    public void l(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        QLog.d("DressDetailHorizontalView", 1, "onFeedSelected, position:" + selectInfo + ".position, adapterPosition: " + this.adapterPosition);
        int mPosition = selectInfo.getMPosition();
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = this.data;
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = null;
        if (zootopiaDetailFeedsCardData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            zootopiaDetailFeedsCardData = null;
        }
        if (!n(zootopiaDetailFeedsCardData.getStatus())) {
            QLog.d("DressDetailHorizontalView", 1, "onFeedSelected, position:" + mPosition + ", adapterPosition: " + this.adapterPosition);
            return;
        }
        if (this.binding.f418744j.getRoot().getVisibility() != 0) {
            h(this, 0, 1, null);
        }
        if (!o(mPosition)) {
            QLog.d("DressDetailHorizontalView", 1, "not on screen, return");
            return;
        }
        c();
        this.binding.f418738d.r();
        this.currentPosition = mPosition;
        com.tencent.mobileqq.zootopia.e eVar = com.tencent.mobileqq.zootopia.e.f328302a;
        ZootopiaDetailFeedsCardData.Companion companion = ZootopiaDetailFeedsCardData.INSTANCE;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData2 = this.data;
        if (zootopiaDetailFeedsCardData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            zootopiaDetailFeedsCardData2 = null;
        }
        if (!eVar.a(companion.g(zootopiaDetailFeedsCardData2))) {
            QLog.d("DressDetailHorizontalView", 1, "is png, return");
            return;
        }
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData3 = this.data;
        if (zootopiaDetailFeedsCardData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            zootopiaDetailFeedsCardData3 = null;
        }
        com.tencent.sqshow.zootopia.player.f a16 = companion.a(zootopiaDetailFeedsCardData3);
        QLog.d("DressDetailHorizontalView", 1, "onFeedSelected, url:" + a16.f());
        this.binding.f418744j.f418768d.setVisibility(4);
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView2 = this.playerView;
        if (zPlanPlayerWithPreLoadView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
        } else {
            zPlanPlayerWithPreLoadView = zPlanPlayerWithPreLoadView2;
        }
        zPlanPlayerWithPreLoadView.M(a16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.binding.f418739e.t();
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = this.playerView;
        if (zPlanPlayerWithPreLoadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
            zPlanPlayerWithPreLoadView = null;
        }
        zPlanPlayerWithPreLoadView.J();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        Configuration configuration;
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        j jVar;
        j jVar2;
        l lVar5;
        int i3 = 1;
        QLog.d("DressDetailHorizontalView", 1, "onReceiveEvent, event: " + event);
        String str = null;
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = null;
        str = null;
        if (event instanceof ZplanDressDetailSettingsEvent) {
            String id5 = ((ZplanDressDetailSettingsEvent) event).getId();
            ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData2 = this.data;
            if (zootopiaDetailFeedsCardData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                zootopiaDetailFeedsCardData2 = null;
            }
            n outfitWorksInfo = zootopiaDetailFeedsCardData2.getOutfitWorksInfo();
            if (Intrinsics.areEqual(id5, (outfitWorksInfo == null || (lVar5 = outfitWorksInfo.f427499b) == null) ? null : lVar5.f427476a)) {
                ib4.h hVar = ib4.h.f407398a;
                Context context = getContext();
                ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData3 = this.data;
                if (zootopiaDetailFeedsCardData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                    zootopiaDetailFeedsCardData3 = null;
                }
                n outfitWorksInfo2 = zootopiaDetailFeedsCardData3.getOutfitWorksInfo();
                String str2 = (outfitWorksInfo2 == null || (jVar2 = outfitWorksInfo2.f427498a) == null) ? null : jVar2.f427462a;
                if (str2 == null) {
                    str2 = "";
                }
                ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData4 = this.data;
                if (zootopiaDetailFeedsCardData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                } else {
                    zootopiaDetailFeedsCardData = zootopiaDetailFeedsCardData4;
                }
                n outfitWorksInfo3 = zootopiaDetailFeedsCardData.getOutfitWorksInfo();
                if (outfitWorksInfo3 != null && (jVar = outfitWorksInfo3.f427498a) != null) {
                    i3 = jVar.f427466e;
                }
                Map<String, Object> e16 = e();
                e16.put("dt_pgid", "pg_zplan_outfit_detail");
                Unit unit = Unit.INSTANCE;
                hVar.u(context, str2, i3, e16);
                return;
            }
            return;
        }
        if (event instanceof ZplanDeleteWorkItemEvent) {
            ZplanDeleteWorkItemEvent zplanDeleteWorkItemEvent = (ZplanDeleteWorkItemEvent) event;
            String id6 = zplanDeleteWorkItemEvent.getId();
            ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData5 = this.data;
            if (zootopiaDetailFeedsCardData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                zootopiaDetailFeedsCardData5 = null;
            }
            n outfitWorksInfo4 = zootopiaDetailFeedsCardData5.getOutfitWorksInfo();
            if (!Intrinsics.areEqual(id6, (outfitWorksInfo4 == null || (lVar4 = outfitWorksInfo4.f427499b) == null) ? null : lVar4.f427476a)) {
                ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData6 = this.data;
                if (zootopiaDetailFeedsCardData6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                    zootopiaDetailFeedsCardData6 = null;
                }
                n outfitWorksInfo5 = zootopiaDetailFeedsCardData6.getOutfitWorksInfo();
                if (((outfitWorksInfo5 == null || (lVar3 = outfitWorksInfo5.f427499b) == null) ? null : lVar3.f427476a) != null) {
                    if ((zplanDeleteWorkItemEvent.getId().length() > 0) != false) {
                        QLog.d("DressDetailHorizontalView", 1, "id is invalid, id: " + zplanDeleteWorkItemEvent.getId());
                        return;
                    }
                }
            }
            this.binding.f418744j.f418767c.B();
            this.binding.f418744j.f418767c.J();
            SimpleEventBus.getInstance().dispatchEvent(new ZplanDressDetailRefreshItemEvent(zplanDeleteWorkItemEvent.getId(), 0, 2, null));
            return;
        }
        if (event instanceof ZplanChangeShowTypeEvent) {
            ZplanChangeShowTypeEvent zplanChangeShowTypeEvent = (ZplanChangeShowTypeEvent) event;
            String id7 = zplanChangeShowTypeEvent.getId();
            ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData7 = this.data;
            if (zootopiaDetailFeedsCardData7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                zootopiaDetailFeedsCardData7 = null;
            }
            n outfitWorksInfo6 = zootopiaDetailFeedsCardData7.getOutfitWorksInfo();
            if (Intrinsics.areEqual(id7, (outfitWorksInfo6 == null || (lVar2 = outfitWorksInfo6.f427499b) == null) ? null : lVar2.f427476a)) {
                QLog.d("DressDetailHorizontalView", 1, "update Privacy, event: " + zplanChangeShowTypeEvent.getId() + ". type: " + zplanChangeShowTypeEvent.getShowType() + " ");
                ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData8 = this.data;
                if (zootopiaDetailFeedsCardData8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                    zootopiaDetailFeedsCardData8 = null;
                }
                n outfitWorksInfo7 = zootopiaDetailFeedsCardData8.getOutfitWorksInfo();
                j jVar3 = outfitWorksInfo7 != null ? outfitWorksInfo7.f427498a : null;
                if (jVar3 != null) {
                    jVar3.f427466e = zplanChangeShowTypeEvent.getShowType();
                }
                f();
                return;
            }
            return;
        }
        if (event instanceof ZplanBanWorkItemEvent) {
            String id8 = ((ZplanBanWorkItemEvent) event).getId();
            ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData9 = this.data;
            if (zootopiaDetailFeedsCardData9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                zootopiaDetailFeedsCardData9 = null;
            }
            n outfitWorksInfo8 = zootopiaDetailFeedsCardData9.getOutfitWorksInfo();
            if (outfitWorksInfo8 != null && (lVar = outfitWorksInfo8.f427499b) != null) {
                str = lVar.f427476a;
            }
            if (Intrinsics.areEqual(id8, str)) {
                g(3);
                return;
            }
            return;
        }
        if (!(event instanceof ZplanConfigChangeEvent) || (configuration = ((ZplanConfigChangeEvent) event).getConfiguration()) == null) {
            return;
        }
        u.Companion companion = u.INSTANCE;
        QLog.d("DressDetailHorizontalView", 1, "onConfigChange, mScreenWidth:" + companion.c(getContext()) + ", mScreenHeight:" + companion.b(getContext()) + ", orientation:" + configuration + ".orientation");
        c();
    }

    @Override // q84.c
    public void w(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        QLog.d("DressDetailHorizontalView", 1, "onResumed");
        if (o(selectInfo.getMPosition()) && this.shouldResumePlay) {
            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = this.playerView;
            if (zPlanPlayerWithPreLoadView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerView");
                zPlanPlayerWithPreLoadView = null;
            }
            String str = zPlanPlayerWithPreLoadView.getCom.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String();
            if (str == null || str.length() == 0) {
                return;
            }
            this.shouldResumePlay = false;
            this.binding.f418744j.f418768d.setVisibility(4);
            c();
            ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView2 = this.playerView;
            if (zPlanPlayerWithPreLoadView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerView");
                zPlanPlayerWithPreLoadView2 = null;
            }
            ZootopiaPlayerView.z(zPlanPlayerWithPreLoadView2, false, false, 1, null);
        }
    }

    @Override // q84.c
    public void onDestroy() {
        QLog.d("DressDetailHorizontalView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = this.playerView;
        if (zPlanPlayerWithPreLoadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
            zPlanPlayerWithPreLoadView = null;
        }
        zPlanPlayerWithPreLoadView.I();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DressDetailVideoChildView(Context context, ZootopiaSource sourceCurrent) {
        this(context, (AttributeSet) null, sourceCurrent);
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DressDetailVideoChildView(Context context, AttributeSet attributeSet, ZootopiaSource sourceCurrent) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        addView(this.binding.getMRv(), -1, -1);
        this.sourceId = ah.b(sourceCurrent);
        this.sourceCurrent = sourceCurrent;
        m();
    }

    private final void r(int count) {
        if (count <= 1) {
            QLog.d("DressDetailHorizontalView", 1, "updateIndicator: count: " + count + ", hide");
            this.binding.f418736b.setVisibility(4);
            this.binding.f418743i.setVisibility(4);
            return;
        }
        this.binding.f418745k.addOnPageChangeListener(new f(count));
    }

    static /* synthetic */ void h(DressDetailVideoChildView dressDetailVideoChildView, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        dressDetailVideoChildView.g(i3);
    }
}
