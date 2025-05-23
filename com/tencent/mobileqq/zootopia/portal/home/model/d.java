package com.tencent.mobileqq.zootopia.portal.home.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaListMapListView;
import com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaMapItemView;
import com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaSameStyleView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.portal.home.banner.Banner;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.CircleIndicator;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t74.u;
import zb3.ZootopiaBannerItem;
import zb3.ZootopiaMapListData;
import zb3.ZootopiaSameStyleData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002]^BA\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010?\u001a\u00020<\u0012\u0018\b\u0002\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\"0@j\b\u0012\u0004\u0012\u00020\"`A\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u0014\u001a\u00060\u0002R\u00020\u0000H\u0002J\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00162\n\u0010\u0014\u001a\u00060\u0002R\u00020\u0000H\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u001c\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u001a2\n\u0010\u0014\u001a\u00060\u0002R\u00020\u0000H\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u001c\u0010 \u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u000e\u0010$\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u001aJ\u000e\u0010'\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u001c\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\tH\u0016J\u0010\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0016J\u001c\u0010.\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010,\u001a\u00020\tH\u0016J\b\u0010/\u001a\u00020\tH\u0016R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R$\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\"0@j\b\u0012\u0004\u0012\u00020\"`A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010S\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010UR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020X0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010Y\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/model/d;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zootopia/portal/home/model/d$b;", "Lzb3/i;", "mapData", "", "D", "Landroid/view/View;", "view", "", "dstWidth", "dstHeight", "dstHorizonMargin", "", "K", "Landroid/content/Context;", "context", "B", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "info", "holder", "u", "Lzb3/n;", "y", "Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaSameStyleView;", HippyTKDListViewAdapter.X, "Lzb3/c;", "t", "", "url", "H", "data", "w", "", "", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "banner", "E", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "G", "position", "getItemViewType", UserInfo.SEX_FEMALE, "getItemCount", "Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaListMapListView;", "d", "Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaListMapListView;", "listView", "Loa4/a;", "e", "Loa4/a;", "mapResViewModel", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", tl.h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "mapDataList", "Lcom/tencent/mobileqq/zootopia/portal/home/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zootopia/portal/home/a;", "getMapClickListener", "()Lcom/tencent/mobileqq/zootopia/portal/home/a;", "I", "(Lcom/tencent/mobileqq/zootopia/portal/home/a;)V", "mapClickListener", "Lcom/tencent/mobileqq/zootopia/portal/home/b;", "Lcom/tencent/mobileqq/zootopia/portal/home/b;", "getSameStyleClickListener", "()Lcom/tencent/mobileqq/zootopia/portal/home/b;", "J", "(Lcom/tencent/mobileqq/zootopia/portal/home/b;)V", "sameStyleClickListener", "Lid3/d;", "Lid3/d;", "reportHelper", "Lqa4/d;", "Lzb3/d;", "Lqa4/d;", "onBannerListener", "<init>", "(Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaListMapListView;Loa4/a;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/util/ArrayList;)V", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends RecyclerView.Adapter<b> {
    private static final int G = ViewUtils.dpToPx(16.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.zootopia.portal.home.b sameStyleClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    private final id3.d reportHelper;

    /* renamed from: E, reason: from kotlin metadata */
    private final qa4.d<ZootopiaBannerItem> onBannerListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaListMapListView listView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mapResViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Object> mapDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zootopia.portal.home.a mapClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/model/d$b;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/zootopia/portal/home/model/d;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f328888d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f328888d = dVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/model/d$c", "Lyc3/a;", "Lzb3/d;", "Lyc3/b;", "holder", "data", "", "position", "size", "", "q0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends yc3.a<ZootopiaBannerItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, ArrayList<ZootopiaBannerItem> arrayList) {
            super(context, arrayList);
            Intrinsics.checkNotNullExpressionValue(context, "context");
        }

        @Override // qa4.c
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public void d0(yc3.b holder, ZootopiaBannerItem data, int position, int size) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(data, "data");
            View view = holder.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.player.ZootopiaPlayerView");
            ZootopiaPlayerView zootopiaPlayerView = (ZootopiaPlayerView) view;
            int screenWidth = ScreenUtils.getScreenWidth(zootopiaPlayerView.getContext()) - ViewUtils.dpToPx(32.0f);
            int dpToPx = ViewUtils.dpToPx(90.0f);
            if (data.getPicUrl().length() == 0) {
                zootopiaPlayerView.setDefaultBackground();
            } else if (data.getIsApng()) {
                ZootopiaPlayerView.setApngBackgroundUrl$default(zootopiaPlayerView, data.getPicUrl(), screenWidth, dpToPx, false, null, 24, null);
            } else {
                ZootopiaPlayerView.setCoverUrl$default(zootopiaPlayerView, data.getPicUrl(), screenWidth, dpToPx, null, 8, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/model/d$d", "Lqa4/d;", "Lzb3/d;", "Landroid/view/View;", "view", "data", "", "position", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.portal.home.model.d$d, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9118d implements qa4.d<ZootopiaBannerItem> {
        C9118d() {
        }

        @Override // qa4.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(View view, ZootopiaBannerItem data, int position) {
            String jumpUrl;
            Intrinsics.checkNotNullParameter(view, "view");
            if (data == null || (jumpUrl = data.getJumpUrl()) == null) {
                return;
            }
            d.this.H(jumpUrl);
            ub3.d.f438772a.f(data.getIAdId(), 102, data.getTriggerInfo());
            id3.e.f407552a.g(view, data.getIAdId());
        }
    }

    public /* synthetic */ d(ZootopiaListMapListView zootopiaListMapListView, oa4.a aVar, LifecycleOwner lifecycleOwner, ZootopiaSource zootopiaSource, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(zootopiaListMapListView, aVar, lifecycleOwner, zootopiaSource, (i3 & 16) != 0 ? new ArrayList() : arrayList);
    }

    private final int B(Context context) {
        return u.INSTANCE.c(context) - (G * 2);
    }

    private final boolean D(ZootopiaMapListData mapData) {
        if (mapData.getSameStyleData() == null) {
            return this.mapDataList.addAll(mapData.a());
        }
        if (mapData.a().isEmpty()) {
            ZootopiaSameStyleData sameStyleData = mapData.getSameStyleData();
            if (sameStyleData != null) {
                return this.mapDataList.add(sameStyleData);
            }
            return false;
        }
        boolean addAll = this.mapDataList.addAll(mapData.a());
        ZootopiaSameStyleData sameStyleData2 = mapData.getSameStyleData();
        int order = sameStyleData2 != null ? sameStyleData2.getOrder() : 1;
        if (this.mapDataList.get(0) instanceof zb3.c) {
            order++;
        }
        ZootopiaSameStyleData sameStyleData3 = mapData.getSameStyleData();
        if (sameStyleData3 != null) {
            this.mapDataList.add(order, sameStyleData3);
        }
        return addAll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(String url) {
        Intent intent = new Intent(this.listView.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", url);
        Context context = this.listView.getContext();
        if (context != null) {
            context.startActivity(intent);
        }
    }

    private final void K(View view, int dstWidth, int dstHeight, int dstHorizonMargin) {
        if (view.getLayoutParams() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dstWidth, dstHeight);
            layoutParams.setMargins(dstHorizonMargin, 0, dstHorizonMargin, 0);
            view.setLayoutParams(layoutParams);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
        if (layoutParams3 == null) {
            layoutParams3 = new FrameLayout.LayoutParams(dstWidth, dstHeight);
        }
        if (layoutParams3.width == dstWidth && layoutParams3.height == dstHeight && layoutParams3.leftMargin == dstHorizonMargin && layoutParams3.rightMargin == dstHorizonMargin) {
            return;
        }
        layoutParams3.width = dstWidth;
        layoutParams3.height = dstHeight;
        layoutParams3.setMargins(dstHorizonMargin, 0, dstHorizonMargin, 0);
        view.setLayoutParams(layoutParams3);
    }

    private final void t(zb3.c info, b holder) {
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.portal.home.banner.Banner<com.tencent.mobileqq.zootopia.data.ZootopiaBannerItem, com.tencent.mobileqq.zootopia.portal.home.banner.adapter.BannerVideoBaseAdapter<com.tencent.mobileqq.zootopia.data.ZootopiaBannerItem>>");
        Banner banner = (Banner) view;
        Context context = banner.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        K(banner, B(context), ViewUtils.dpToPx(90.0f), G);
        id3.e.f407552a.a(banner);
        if (!info.b().isEmpty()) {
            Context context2 = this.listView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "listView.context");
            banner.setIndicator(new CircleIndicator(context2));
            banner.setIndicatorMargin(new com.tencent.sqshow.zootopia.portal.home.banner.indicator.c(ViewUtils.dpToPx(20.0f), 0, 0, ViewUtils.dpToPx(12.0f)));
            banner.setIndicatorGravity(Direction.LEFT);
            banner.t(this.owner);
            banner.setAdapter(new c(this.listView.getContext(), info.b()));
            banner.setOnBannerListener(this.onBannerListener);
        }
    }

    private final void u(final ZootopiaMapSimpleInfo info, b holder) {
        w(holder, info);
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaMapItemView");
        final ZootopiaMapItemView zootopiaMapItemView = (ZootopiaMapItemView) view;
        Context context = zootopiaMapItemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int B = B(context);
        K(zootopiaMapItemView, B, (int) (B * 1.28d), G);
        ZootopiaMapItemView.j(zootopiaMapItemView, info, this.sourceCurrent, false, null, 12, null);
        zootopiaMapItemView.D(info);
        zootopiaMapItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.v(d.this, zootopiaMapItemView, info, view2);
            }
        });
        zootopiaMapItemView.setMapClickListener(this.mapClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(d this$0, ZootopiaMapItemView view, ZootopiaMapSimpleInfo info, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(info, "$info");
        com.tencent.mobileqq.zootopia.portal.home.a aVar = this$0.mapClickListener;
        if (aVar != null) {
            aVar.r6(new zb3.e(view, info, view.o(), view.n()));
        }
    }

    private final void w(b holder, ZootopiaMapSimpleInfo data) {
        id3.d dVar = this.reportHelper;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        id3.d.h(dVar, view, "em_zplan_playground_gallery_infocard", C(data), false, false, null, 56, null);
    }

    private final void x(ZootopiaSameStyleView view, ZootopiaSameStyleData info) {
        id3.e eVar = id3.e.f407552a;
        eVar.c(view, info.getOrder());
        TextView visitAllText = view.getVisitAllText();
        if (visitAllText != null) {
            eVar.b(visitAllText);
        }
    }

    private final void y(ZootopiaSameStyleData info, b holder) {
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaSameStyleView");
        ZootopiaSameStyleView zootopiaSameStyleView = (ZootopiaSameStyleView) view;
        TextView visitAllText = zootopiaSameStyleView.getVisitAllText();
        if (visitAllText != null) {
            visitAllText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d.z(d.this, view2);
                }
            });
        }
        zootopiaSameStyleView.setSameStyleClickListener(this.sameStyleClickListener);
        zootopiaSameStyleView.c(info);
        x(zootopiaSameStyleView, info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(d this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.zootopia.portal.home.b bVar = this$0.sameStyleClickListener;
        if (bVar != null) {
            bVar.G3();
        }
        id3.e eVar = id3.e.f407552a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        eVar.h(it);
    }

    public final boolean A(ZootopiaMapListData mapData) {
        Intrinsics.checkNotNullParameter(mapData, "mapData");
        int size = this.mapDataList.size();
        boolean z16 = !this.mapDataList.isEmpty();
        if (z16 && (this.mapDataList.get(0) instanceof zb3.c)) {
            if (this.mapDataList.size() > 1) {
                ArrayList<Object> arrayList = this.mapDataList;
                List<Object> subList = arrayList.subList(1, arrayList.size());
                Intrinsics.checkNotNullExpressionValue(subList, "mapDataList.subList(1, mapDataList.size)");
                arrayList.removeAll(subList);
            }
        } else {
            this.mapDataList.clear();
        }
        boolean D = D(mapData) | z16;
        if (D) {
            int size2 = this.mapDataList.size();
            if (size == size2) {
                notifyItemRangeChanged(0, size2);
            } else {
                notifyDataSetChanged();
            }
        }
        return D;
    }

    public final void E(zb3.c banner) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        if ((!this.mapDataList.isEmpty()) && (this.mapDataList.get(0) instanceof zb3.c)) {
            this.mapDataList.set(0, banner);
            notifyItemChanged(0);
        } else {
            this.mapDataList.add(0, banner);
            notifyItemInserted(0);
            notifyItemRangeChanged(1, this.mapDataList.size() - 1);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object obj = this.mapDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(obj, "mapDataList[position]");
        if (obj instanceof ZootopiaMapSimpleInfo) {
            u((ZootopiaMapSimpleInfo) obj, holder);
        } else if (obj instanceof ZootopiaSameStyleData) {
            y((ZootopiaSameStyleData) obj, holder);
        } else if (obj instanceof zb3.c) {
            t((zb3.c) obj, holder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        View view2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            Context context = this.listView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "listView.context");
            View zootopiaMapItemView = new ZootopiaMapItemView(context, this.owner, this.mapResViewModel);
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            int B = B(context2);
            K(zootopiaMapItemView, B, (int) (B * 1.28d), G);
            view = zootopiaMapItemView;
        } else if (viewType == 2) {
            Context context3 = this.listView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "listView.context");
            Banner banner = new Banner(context3);
            Context context4 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
            int B2 = B(context4);
            int dpToPx = ViewUtils.dpToPx(90.0f);
            int i3 = G;
            K(banner, B2, dpToPx, i3);
            banner.setBackgroundRadius(i3);
            view = banner;
        } else {
            if (viewType != 3) {
                Context context5 = this.listView.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "listView.context");
                view2 = new ZootopiaMapItemView(context5, this.owner, this.mapResViewModel);
            } else {
                Context context6 = this.listView.getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "listView.context");
                view2 = new ZootopiaSameStyleView(context6, null, 0, 6, null);
                view2.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewUtils.dpToPx(260.0f)));
            }
            return new b(this, view2);
        }
        view2 = view;
        return new b(this, view2);
    }

    public final void I(com.tencent.mobileqq.zootopia.portal.home.a aVar) {
        this.mapClickListener = aVar;
    }

    public final void J(com.tencent.mobileqq.zootopia.portal.home.b bVar) {
        this.sameStyleClickListener = bVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mapDataList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Object obj = this.mapDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(obj, "mapDataList[position]");
        return g.a(obj);
    }

    public final boolean s(ZootopiaMapListData mapData) {
        Intrinsics.checkNotNullParameter(mapData, "mapData");
        boolean D = D(mapData);
        if (D) {
            notifyItemRangeInserted(this.mapDataList.size() - mapData.a().size(), mapData.a().size());
        }
        return D;
    }

    private final Map<String, Object> C(ZootopiaMapSimpleInfo data) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_map_id", Integer.valueOf(data.getMapID())), new Pair("zplan_module_id", "em_zplan_playground_gallery_infocard"));
        return mutableMapOf;
    }

    public d(ZootopiaListMapListView listView, oa4.a mapResViewModel, LifecycleOwner owner, ZootopiaSource sourceCurrent, ArrayList<Object> mapDataList) {
        Intrinsics.checkNotNullParameter(listView, "listView");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Intrinsics.checkNotNullParameter(mapDataList, "mapDataList");
        this.listView = listView;
        this.mapResViewModel = mapResViewModel;
        this.owner = owner;
        this.sourceCurrent = sourceCurrent;
        this.mapDataList = mapDataList;
        this.reportHelper = new id3.d(null, 1, null);
        this.onBannerListener = new C9118d();
    }
}
