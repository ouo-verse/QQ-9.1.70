package com.tencent.sqshow.zootopia.recommend.main.dress;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.google.protobuf.nano.MessageNano;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.card.view.refresh.RefreshFootView;
import com.tencent.sqshow.zootopia.card.view.refresh.RefreshHeaderView;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.player.preload.VideoPlayerPreLoadManager;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanDressDetailRefreshItemEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailHeaderView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.widget.immersive.ImmersiveUtils;
import db4.a;
import db4.e;
import fb4.b;
import java.util.ArrayList;
import jb4.p;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import n74.ay;
import pu4.n;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 W2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001XB\u0007\u00a2\u0006\u0004\bU\u0010VJ\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001aj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b`\u001cH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020 H\u0014J\b\u0010#\u001a\u00020\"H\u0016J\u0012\u0010%\u001a\u00020\"2\b\u0010\u0018\u001a\u0004\u0018\u00010$H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\nH\u0002J\u001a\u0010*\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\nH\u0002J\u0018\u00101\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0014H\u0002J\u0018\u00102\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0014H\u0002J\u0010\u00104\u001a\u00020\n2\u0006\u00103\u001a\u00020\"H\u0002R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010T\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006Y"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ZPlanDressDetailFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/zootopia/api/c;", "Ldb4/a;", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView$b;", "Ljb4/p;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getPosition", "status", "I4", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onResume", DKHippyEvent.EVENT_STOP, "", "getSubSource", "", "onBackPressedEvent", "Landroid/view/KeyEvent;", "J5", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "dismiss", "Th", "Qh", "Oh", "Ph", "initViewModel", "initListener", "position", "dataSize", "Nh", "Rh", "isRefresh", "Sh", "Lfb4/b;", "N", "Lfb4/b;", "viewModel", "Ldb4/e;", "P", "Ldb4/e;", "viewBinder", "Lhb4/b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lhb4/b;", "adapter", "Ln74/ay;", BdhLogUtil.LogTag.Tag_Req, "Ln74/ay;", "binding", "Landroidx/viewpager2/widget/ViewPager2;", ExifInterface.LATITUDE_SOUTH, "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Lcom/tencent/sqshow/zootopia/data/g;", "T", "Lcom/tencent/sqshow/zootopia/data/g;", "firstData", "U", "I", "loadMorePreloadNum", "V", "currentPos", "W", "Z", "isPreloadMore", "<init>", "()V", "X", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanDressDetailFragment extends ZootopiaBaseFragment implements SimpleEventReceiver<SimpleBaseEvent>, com.tencent.mobileqq.zootopia.api.c, a, DressSquareDetailHeaderView.b, p {

    /* renamed from: X, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String Y = "ZPlanDressDetailFragment";
    private static final ISPBandwidthPredictor Z;

    /* renamed from: N, reason: from kotlin metadata */
    private fb4.b viewModel;

    /* renamed from: P, reason: from kotlin metadata */
    private e viewBinder;

    /* renamed from: Q, reason: from kotlin metadata */
    private hb4.b adapter;

    /* renamed from: R, reason: from kotlin metadata */
    private ay binding;

    /* renamed from: S, reason: from kotlin metadata */
    private ViewPager2 viewPager2;

    /* renamed from: T, reason: from kotlin metadata */
    private ZootopiaDetailFeedsCardData firstData;

    /* renamed from: U, reason: from kotlin metadata */
    private final int loadMorePreloadNum = 2;

    /* renamed from: V, reason: from kotlin metadata */
    private int currentPos = -1;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isPreloadMore;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J<\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ZPlanDressDetailFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "params", "", "a", "", "workId", "feedId", "Lcom/google/protobuf/nano/MessageNano;", "initData", "uin", "b", "DRESS_DETAIL_FEED_ID", "Ljava/lang/String;", "DRESS_DETAIL_HANDLER", "DRESS_DETAIL_INIT_DATA", "DRESS_DETAIL_INIT_POSITION", "DRESS_DETAIL_WORK_ID", "DRESS_OUTER_UIN", "DRESS_PAGE_ID", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.recommend.main.dress.ZPlanDressDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, ZootopiaSource source, Bundle params) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(source, "source");
            String string = params != null ? params.getString("id", "") : null;
            if (string == null || string.length() == 0) {
                QLog.d(ZPlanDressDetailFragment.Y, 1, "id is null, return");
                return;
            }
            String string2 = params.getString("uin", "");
            QLog.d(ZPlanDressDetailFragment.Y, 1, "id " + string + ", uin: " + string2);
            b(context, source, string, "", null, string2);
        }

        public final void b(Context context, ZootopiaSource source, String workId, String feedId, MessageNano initData, String uin) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(workId, "workId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Bundle bundle = new Bundle();
            bundle.putString("dress_detail_work_id", workId);
            bundle.putString("dress_detail_feed_id", feedId);
            bundle.putString("uin", uin);
            if (initData != null) {
                bundle.putByteArray("dress_detail_init_data", MessageNano.toByteArray(initData));
            }
            ZootopiaActivity.Companion.c(ZootopiaActivity.INSTANCE, context, ZPlanDressDetailFragment.class, source, bundle, false, 16, null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/ZPlanDressDetailFragment$b", "Lcom/tencent/biz/qqcircle/immersive/refresh/QFSPullRefreshLayout$f;", "Lcom/tencent/biz/qqcircle/immersive/refresh/QFSPullRefreshLayout;", "qfsPullRefreshLayout", "", "triggerType", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements QFSPullRefreshLayout.f {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.f
        public void a(QFSPullRefreshLayout qfsPullRefreshLayout, int triggerType) {
            Intrinsics.checkNotNullParameter(qfsPullRefreshLayout, "qfsPullRefreshLayout");
            ZPlanDressDetailFragment.this.Sh(true);
        }

        @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.f
        public void b(QFSPullRefreshLayout qfsPullRefreshLayout) {
            Intrinsics.checkNotNullParameter(qfsPullRefreshLayout, "qfsPullRefreshLayout");
            ZPlanDressDetailFragment.this.Sh(false);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/ZPlanDressDetailFragment$d", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            hb4.b bVar = ZPlanDressDetailFragment.this.adapter;
            if (bVar != null) {
                bVar.onFeedPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            hb4.b bVar;
            ArrayList<ZootopiaDetailFeedsCardData> i06;
            QLog.d("ZPlanDressDetailViewBinder", 1, "onPageSelected, position:" + position);
            super.onPageSelected(position);
            ZPlanDressDetailFragment zPlanDressDetailFragment = ZPlanDressDetailFragment.this;
            hb4.b bVar2 = zPlanDressDetailFragment.adapter;
            zPlanDressDetailFragment.Nh(position, (bVar2 == null || (i06 = bVar2.i0()) == null) ? 0 : i06.size());
            if (ZPlanDressDetailFragment.this.currentPos != -1 && ZPlanDressDetailFragment.this.currentPos != position && (bVar = ZPlanDressDetailFragment.this.adapter) != null) {
                bVar.S(new q84.b(ZPlanDressDetailFragment.this.currentPos, position));
            }
            ZPlanDressDetailFragment.this.currentPos = position;
            hb4.b bVar3 = ZPlanDressDetailFragment.this.adapter;
            if (bVar3 != null) {
                bVar3.l(new q84.b(ZPlanDressDetailFragment.this.currentPos));
            }
            ZPlanDressDetailFragment zPlanDressDetailFragment2 = ZPlanDressDetailFragment.this;
            hb4.b bVar4 = zPlanDressDetailFragment2.adapter;
            zPlanDressDetailFragment2.Rh(position, bVar4 != null ? bVar4.getItemCount() : 0);
        }
    }

    static {
        ISPBandwidthPredictor createBandwidthPredictor = SuperPlayerFactory.createBandwidthPredictor(BaseApplication.context);
        Intrinsics.checkNotNullExpressionValue(createBandwidthPredictor, "createBandwidthPredictor\u2026ication.context\n        )");
        Z = createBandwidthPredictor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(int position, int dataSize) {
        int i3;
        if (this.isPreloadMore || position == 0 || (i3 = this.loadMorePreloadNum) < 0 || position < (dataSize - 1) - i3) {
            return;
        }
        QLog.d(Y, 1, "checkNeedTriggerPreloadLoadMore  preload loadMore, current position: " + position + " | data size: " + dataSize + " , | preloadNum: " + i3);
        Sh(false);
        this.isPreloadMore = true;
    }

    private final void Oh() {
        hb4.b bVar;
        ArrayList arrayListOf;
        Intent intent;
        Bundle extras;
        Context context = getContext();
        byte[] bArr = null;
        if (context != null) {
            ay ayVar = this.binding;
            if (ayVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar = null;
            }
            DressSquareDetailHeaderView dressSquareDetailHeaderView = ayVar.f418771c;
            Intrinsics.checkNotNullExpressionValue(dressSquareDetailHeaderView, "binding.headerTitle");
            bVar = new hb4.b(context, dressSquareDetailHeaderView, this, Ch());
        } else {
            bVar = null;
        }
        this.adapter = bVar;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            bArr = extras.getByteArray("dress_detail_init_data");
        }
        if (bArr != null) {
            ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = new ZootopiaDetailFeedsCardData(0, n.c(bArr), 0, 4, null);
            this.firstData = zootopiaDetailFeedsCardData;
            I4(4);
            hb4.b bVar2 = this.adapter;
            if (bVar2 != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(zootopiaDetailFeedsCardData);
                hb4.b.q0(bVar2, arrayListOf, false, false, null, 12, null);
            }
        }
    }

    private final void Ph() {
        ay ayVar = this.binding;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar = null;
        }
        QFSPullRefreshLayout qFSPullRefreshLayout = ayVar.f418773e;
        Intrinsics.checkNotNullExpressionValue(qFSPullRefreshLayout, "binding.prlRefreshLayout");
        qFSPullRefreshLayout.setAutoLoadEnable(true);
        qFSPullRefreshLayout.setRefreshEnable(true);
        qFSPullRefreshLayout.setLoadMoreEnable(true);
        c cVar = new c();
        Context context = getContext();
        qFSPullRefreshLayout.setHeaderView(context != null ? new RefreshHeaderView(context, cVar) : null, 3);
        qFSPullRefreshLayout.setHeaderViewMarginTop(ImmersiveUtils.getStatusBarHeight(getContext()));
        Context context2 = getContext();
        qFSPullRefreshLayout.setFooterView(context2 != null ? new RefreshFootView(context2, cVar) : null, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(int position, int dataSize) {
        ay ayVar = this.binding;
        ay ayVar2 = null;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar = null;
        }
        if (ayVar.f418773e.S()) {
            ay ayVar3 = this.binding;
            if (ayVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar3 = null;
            }
            if (ayVar3.f418773e.P()) {
                if (position < dataSize - 1 || dataSize == 1) {
                    QLog.d(Y, 1, "[checkLoadMoreFinishState] position: " + position + " | dataSize: " + dataSize);
                    ay ayVar4 = this.binding;
                    if (ayVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        ayVar4 = null;
                    }
                    ayVar4.f418773e.L();
                    ay ayVar5 = this.binding;
                    if (ayVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        ayVar5 = null;
                    }
                    boolean K = ayVar5.f418773e.K();
                    ay ayVar6 = this.binding;
                    if (ayVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        ayVar2 = ayVar6;
                    }
                    ayVar2.f418773e.F(K);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh(boolean isRefresh) {
        String str;
        Intent intent;
        Bundle extras;
        e eVar = this.viewBinder;
        String str2 = null;
        byte[] q16 = eVar != null ? eVar.q() : null;
        String str3 = Y;
        QLog.d(str3, 1, "pageInfo:" + q16);
        ay ayVar = this.binding;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar = null;
        }
        if (!ayVar.f418773e.K() && !isRefresh) {
            QLog.d(str3, 1, "no more data, return");
            return;
        }
        if (isRefresh) {
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null) {
                str2 = extras.getString("uin");
            }
            fb4.b bVar = this.viewModel;
            if (bVar != null) {
                e eVar2 = this.viewBinder;
                if (eVar2 == null || (str = eVar2.r()) == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                bVar.O1(str, "", str2, true);
                return;
            }
            return;
        }
        fb4.b bVar2 = this.viewModel;
        if (bVar2 != null) {
            bVar2.P1(q16, isRefresh);
        }
    }

    private final void Th() {
        Intent intent;
        Bundle extras;
        Intent intent2;
        Bundle extras2;
        Intent intent3;
        Bundle extras3;
        FragmentActivity activity = getActivity();
        String str = null;
        String string = (activity == null || (intent3 = activity.getIntent()) == null || (extras3 = intent3.getExtras()) == null) ? null : extras3.getString("dress_detail_work_id");
        FragmentActivity activity2 = getActivity();
        String string2 = (activity2 == null || (intent2 = activity2.getIntent()) == null || (extras2 = intent2.getExtras()) == null) ? null : extras2.getString("dress_detail_feed_id");
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null && (extras = intent.getExtras()) != null) {
            str = extras.getString("uin");
        }
        if (string == null || string.length() == 0) {
            if (string2 == null || string2.length() == 0) {
                QLog.d(Y, 1, "workId or feedId is null, finish");
                xh();
                return;
            }
        }
        fb4.b bVar = this.viewModel;
        if (bVar != null) {
            if (string == null) {
                string = "";
            }
            if (string2 == null) {
                string2 = "";
            }
            if (str == null) {
                str = "";
            }
            bVar.O1(string, string2, str, false);
        }
    }

    private final void initListener() {
        ay ayVar = this.binding;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar = null;
        }
        ayVar.f418773e.setOnRefreshListener(new b());
    }

    private final void initViewModel() {
        Intent intent;
        Bundle extras;
        this.viewModel = (fb4.b) new ViewModelProvider(this, new b.C10298b(ZootopiaSource.INSTANCE.g())).get(fb4.b.class);
        FragmentActivity activity = getActivity();
        ViewPager2 viewPager2 = null;
        this.viewBinder = activity != null ? new e(this, activity, this.viewModel, this) : null;
        FragmentActivity activity2 = getActivity();
        String string = (activity2 == null || (intent = activity2.getIntent()) == null || (extras = intent.getExtras()) == null) ? null : extras.getString("dress_detail_feed_id");
        e eVar = this.viewBinder;
        if (eVar != null) {
            ViewPager2 viewPager22 = this.viewPager2;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            } else {
                viewPager2 = viewPager22;
            }
            eVar.j(viewPager2, this.adapter, this.firstData, string);
        }
    }

    @Override // db4.a
    public void I4(int status) {
        String str = Y;
        QLog.i(str, 1, "updateCardListStatus, status = " + status);
        if (status == 1) {
            ay ayVar = this.binding;
            if (ayVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar = null;
            }
            ayVar.f418772d.getRoot().setVisibility(0);
            ay ayVar2 = this.binding;
            if (ayVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar2 = null;
            }
            ayVar2.f418776h.setVisibility(4);
            ay ayVar3 = this.binding;
            if (ayVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar3 = null;
            }
            ayVar3.f418771c.getBinding().f418763d.setVisibility(4);
            ay ayVar4 = this.binding;
            if (ayVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar4 = null;
            }
            ayVar4.f418770b.getRoot().setVisibility(4);
        } else if (status == 2 || status == 3) {
            ay ayVar5 = this.binding;
            if (ayVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar5 = null;
            }
            ayVar5.f418772d.getRoot().setVisibility(4);
            ay ayVar6 = this.binding;
            if (ayVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar6 = null;
            }
            ayVar6.f418776h.setVisibility(4);
            ay ayVar7 = this.binding;
            if (ayVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar7 = null;
            }
            ayVar7.f418771c.getBinding().f418763d.setVisibility(4);
            ay ayVar8 = this.binding;
            if (ayVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar8 = null;
            }
            ayVar8.f418770b.getRoot().setVisibility(0);
            ay ayVar9 = this.binding;
            if (ayVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar9 = null;
            }
            TextView textView = ayVar9.f418770b.f418759c;
            Context context = getContext();
            textView.setText(context != null ? context.getString(R.string.xnr) : null);
        } else if (status != 4) {
            QLog.i(str, 1, "updateCardListStatus else branch, status = " + status);
        } else {
            ay ayVar10 = this.binding;
            if (ayVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar10 = null;
            }
            ayVar10.f418772d.getRoot().setVisibility(4);
            ay ayVar11 = this.binding;
            if (ayVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar11 = null;
            }
            ayVar11.f418776h.setVisibility(0);
            ay ayVar12 = this.binding;
            if (ayVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar12 = null;
            }
            ayVar12.f418771c.getBinding().f418763d.setVisibility(0);
            ay ayVar13 = this.binding;
            if (ayVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ayVar13 = null;
            }
            ayVar13.f418770b.getRoot().setVisibility(4);
        }
        ay ayVar14 = this.binding;
        if (ayVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar14 = null;
        }
        QFSPullRefreshLayout qFSPullRefreshLayout = ayVar14.f418773e;
        e eVar = this.viewBinder;
        qFSPullRefreshLayout.F(eVar != null && e.o(eVar, 0, 1, null));
        ay ayVar15 = this.binding;
        if (ayVar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar15 = null;
        }
        QFSPullRefreshLayout qFSPullRefreshLayout2 = ayVar15.f418773e;
        e eVar2 = this.viewBinder;
        qFSPullRefreshLayout2.G(eVar2 != null && e.o(eVar2, 0, 1, null));
        this.isPreloadMore = false;
    }

    @Override // com.tencent.mobileqq.zootopia.api.c
    public boolean J5(KeyEvent event) {
        QLog.d(Y, 1, "onKeyDown, KEYCODE_BACK");
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailHeaderView.b
    public void dismiss() {
        QLog.d(Y, 1, "click left icon, finish");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // jb4.p
    /* renamed from: getPosition, reason: from getter */
    public int getCurrentPos() {
        return this.currentPos;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return "";
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Qh(inflater, container);
        Oh();
        initViewModel();
        ay ayVar = this.binding;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar = null;
        }
        RelativeLayout root = ayVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        hb4.b bVar = this.adapter;
        if (bVar != null) {
            bVar.onDestroy();
        }
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).clearCache("dress_detail_handler");
        VideoPlayerPreLoadManager.INSTANCE.a().l();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (getActivity() != null) {
            Z.stop(getActivity());
        }
        hb4.b bVar = this.adapter;
        if (bVar != null) {
            bVar.F(new q84.b(this.currentPos));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        e eVar;
        if (!(event instanceof ZplanDressDetailRefreshItemEvent) || (eVar = this.viewBinder) == null) {
            return;
        }
        ZplanDressDetailRefreshItemEvent zplanDressDetailRefreshItemEvent = (ZplanDressDetailRefreshItemEvent) event;
        eVar.p(zplanDressDetailRefreshItemEvent.getId(), this.adapter, zplanDressDetailRefreshItemEvent.getType());
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            Z.start(getActivity());
        }
        hb4.b bVar = this.adapter;
        if (bVar != null) {
            bVar.w(new q84.b(this.currentPos));
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        hb4.b bVar = this.adapter;
        if (bVar != null) {
            bVar.H(new q84.b(this.currentPos));
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Th();
        initListener();
    }

    private final void Qh(LayoutInflater inflater, ViewGroup container) {
        ay g16 = ay.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        I4(1);
        Ph();
        ay ayVar = this.binding;
        ViewPager2 viewPager2 = null;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar = null;
        }
        ayVar.f418771c.setDismissListener(this);
        ay ayVar2 = this.binding;
        if (ayVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ayVar2 = null;
        }
        ViewPager2 viewPager22 = ayVar2.f418776h;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "binding.viewPager");
        this.viewPager2 = viewPager22;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager22 = null;
        }
        viewPager22.setOffscreenPageLimit(this.loadMorePreloadNum);
        ViewPager2 viewPager23 = this.viewPager2;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager23 = null;
        }
        aa.g(viewPager23, false);
        ViewPager2 viewPager24 = this.viewPager2;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager24 = null;
        }
        viewPager24.setOrientation(1);
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).saveCache("dress_detail_handler", ZplanCacheComponentType.PARENT_PAGE_HANDLER, this);
        ViewPager2 viewPager25 = this.viewPager2;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        } else {
            viewPager2 = viewPager25;
        }
        viewPager2.registerOnPageChangeCallback(new d());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ZplanDressDetailRefreshItemEvent.class);
        return arrayListOf;
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/ZPlanDressDetailFragment$c", "Lo84/a;", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "a", "onComplete", "", "percent", "c", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements o84.a {
        c() {
        }

        @Override // o84.a
        public void a(boolean isLoadMore) {
        }

        @Override // o84.a
        public void b(boolean isLoadMore) {
        }

        @Override // o84.a
        public void onComplete(boolean isLoadMore) {
        }

        @Override // o84.a
        public void c(boolean isLoadMore, float percent) {
        }
    }
}
