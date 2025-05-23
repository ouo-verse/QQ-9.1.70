package com.tencent.sqshow.zootopia.card.view.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.card.view.banner.ZPlanBaseBannerCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.portal.home.banner.Banner;
import com.tencent.sqshow.zootopia.portal.home.banner.c;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001@\b&\u0018\u0000 M2\u00020\u0001:\u0004NOPQB/\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010J\u001a\u00020\u000b\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bR\u00020\u00000\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J \u0010\u001e\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bR\u00020\u00000\u0006H&J \u0010\u001f\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bR\u00020\u00000\u0006H&J\b\u0010!\u001a\u00020 H\u0016R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010#R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010%R(\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bR\u00020\u0000\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R\u001c\u0010+\u001a\b\u0018\u00010\bR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010-R\u0014\u00100\u001a\u00020,8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b/\u0010-R2\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u001601j\b\u0012\u0004\u0012\u00020\u0016`28\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006R"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "Landroid/view/ViewGroup;", "rootContainer", "", "M", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "Lpv4/s;", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$d;", "bannerView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "position", ExifInterface.LATITUDE_SOUTH, "dstPosition", "T", "Landroid/view/View;", "itemView", "itemPos", "N", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "O", "viewParent", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "totalCount", "f", "V", BdhLogUtil.LogTag.Tag_Req, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/card/report/a;", "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "I", "cardPos", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "banner", "U", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$d;", "bannerAdapter", "", "Z", "needBannerInfiniteLoop", "W", "needFakeBanners", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a0", "Ljava/util/ArrayList;", "P", "()Ljava/util/ArrayList;", "setFakeBannerViews", "(Ljava/util/ArrayList;)V", "fakeBannerViews", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$c;", "b0", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$c;", "firstFakeBannerItemView", "c0", "lastFakeBannerItemView", "com/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$e", "d0", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$e;", "bannerClickListener", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "e0", "a", "b", "c", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class ZPlanBaseBannerCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.card.report.a reportHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private int cardPos;

    /* renamed from: T, reason: from kotlin metadata */
    private Banner<s, d> banner;

    /* renamed from: U, reason: from kotlin metadata */
    private d bannerAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private final boolean needBannerInfiniteLoop;

    /* renamed from: W, reason: from kotlin metadata */
    private final boolean needFakeBanners;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ZPlanMediaView> fakeBannerViews;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private FakeBannerItem firstFakeBannerItemView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private FakeBannerItem lastFakeBannerItemView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final e bannerClickListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "E", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "l", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "mediaView", "<init>", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ZPlanMediaView mediaView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ZPlanMediaView mediaView) {
            super(mediaView);
            Intrinsics.checkNotNullParameter(mediaView, "mediaView");
            this.mediaView = mediaView;
        }

        /* renamed from: l, reason: from getter */
        public final ZPlanMediaView getMediaView() {
            return this.mediaView;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$d;", "Lqa4/b;", "Lpv4/s;", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "q0", "holder", "data", "position", "size", "", "p0", "Landroid/content/Context;", "context", "", "bannerDataList", "<init>", "(Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard;Landroid/content/Context;Ljava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class d extends qa4.b<s, a> {
        final /* synthetic */ ZPlanBaseBannerCard H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ZPlanBaseBannerCard zPlanBaseBannerCard, Context context, List<s> bannerDataList) {
            super(context, bannerDataList);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bannerDataList, "bannerDataList");
            this.H = zPlanBaseBannerCard;
        }

        @Override // qa4.c
        /* renamed from: p0, reason: merged with bridge method [inline-methods] */
        public void d0(a holder, s data, int position, int size) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(data, "data");
            pu4.g gVar = data.f427681b;
            if (gVar != null) {
                this.H.y("onBindView: " + position + " -- " + gVar, false);
                ZPlanMediaView mediaView = holder.getMediaView();
                pu4.g gVar2 = data.f427681b;
                Intrinsics.checkNotNullExpressionValue(gVar2, "data.material");
                mediaView.J(gVar2);
            }
        }

        @Override // qa4.c
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public a u(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ZPlanBaseBannerCard zPlanBaseBannerCard = this.H;
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            ZPlanMediaView O = zPlanBaseBannerCard.O(context);
            O.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            return new a(O);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$g", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$a;", "", "dstPosition", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements Banner.a {
        g() {
        }

        @Override // com.tencent.sqshow.zootopia.portal.home.banner.Banner.a
        public void a(int dstPosition) {
            if (ZPlanBaseBannerCard.this.needFakeBanners) {
                ZPlanBaseBannerCard.this.T(dstPosition);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanBaseBannerCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.reportHelper = new com.tencent.sqshow.zootopia.card.report.a();
        this.needBannerInfiniteLoop = true;
        this.fakeBannerViews = new ArrayList<>();
        this.firstFakeBannerItemView = new FakeBannerItem(null, null);
        this.lastFakeBannerItemView = new FakeBannerItem(null, null);
        this.bannerClickListener = new e();
    }

    private final void M(ViewGroup rootContainer) {
        if (this.needBannerInfiniteLoop && this.needFakeBanners) {
            ArrayList<ZPlanMediaView> arrayList = new ArrayList<>();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            arrayList.add(O(context));
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            arrayList.add(O(context2));
            for (ZPlanMediaView zPlanMediaView : arrayList) {
                zPlanMediaView.setVisibility(4);
                rootContainer.addView(zPlanMediaView);
            }
            this.fakeBannerViews = arrayList;
            this.firstFakeBannerItemView.c(arrayList.get(0));
            this.lastFakeBannerItemView.c(this.fakeBannerViews.get(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZPlanMediaView O(Context context) {
        ZPlanMediaView zPlanMediaView = new ZPlanMediaView(context);
        zPlanMediaView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        zPlanMediaView.setRadius(6);
        ZootopiaPlayerView n3 = zPlanMediaView.n();
        ImageView n16 = n3 != null ? n3.n() : null;
        if (n16 != null) {
            n16.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        return zPlanMediaView;
    }

    private final void Q(Banner<s, d> bannerView) {
        R(bannerView);
        bannerView.t(o());
        bannerView.v(new f(bannerView));
        bannerView.u(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(int position) {
        FakeBannerItem fakeBannerItem;
        List<s> c16;
        s sVar;
        List<s> c17;
        ZootopiaCardData cardData = getCardData();
        int size = (cardData == null || (c17 = cardData.c()) == null) ? 0 : c17.size();
        if (size > 1) {
            if (position == 0 || position == size - 1) {
                int i3 = position == 0 ? size - 1 : 0;
                ZootopiaCardData cardData2 = getCardData();
                pu4.g gVar = (cardData2 == null || (c16 = cardData2.c()) == null || (sVar = c16.get(i3)) == null) ? null : sVar.f427681b;
                if (i3 == 0) {
                    fakeBannerItem = this.firstFakeBannerItemView;
                } else {
                    fakeBannerItem = this.lastFakeBannerItemView;
                }
                fakeBannerItem.b(gVar);
                if (gVar != null) {
                    y("preloadFakeBanner position = " + position + " -- " + gVar + " --" + fakeBannerItem.getMediaView() + " ", false);
                    ZPlanMediaView mediaView = fakeBannerItem.getMediaView();
                    if (mediaView != null) {
                        mediaView.setVisibility(4);
                    }
                    ZPlanMediaView mediaView2 = fakeBannerItem.getMediaView();
                    if (mediaView2 != null) {
                        mediaView2.e(gVar);
                    }
                    ZPlanMediaView mediaView3 = fakeBannerItem.getMediaView();
                    if (mediaView3 != null) {
                        mediaView3.setProgress(0.0d);
                    }
                    ZPlanMediaView mediaView4 = fakeBannerItem.getMediaView();
                    if (mediaView4 != null) {
                        mediaView4.stop();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(int dstPosition) {
        FakeBannerItem fakeBannerItem;
        final ZPlanMediaView mediaView;
        List<s> c16;
        s sVar;
        List<s> c17;
        ZootopiaCardData cardData = getCardData();
        if (dstPosition < ((cardData == null || (c17 = cardData.c()) == null) ? 0 : c17.size())) {
            ZootopiaCardData cardData2 = getCardData();
            pu4.g gVar = (cardData2 == null || (c16 = cardData2.c()) == null || (sVar = c16.get(dstPosition)) == null) ? null : sVar.f427681b;
            if (dstPosition == 0) {
                fakeBannerItem = this.firstFakeBannerItemView;
            } else {
                fakeBannerItem = this.lastFakeBannerItemView;
            }
            fakeBannerItem.b(gVar);
            if (gVar == null || (mediaView = fakeBannerItem.getMediaView()) == null) {
                return;
            }
            y("showFakeBannerWhenLoop, dstPosition= " + dstPosition + " -- " + gVar + "  -- " + mediaView, false);
            mediaView.e(gVar);
            mediaView.setProgress(0.0d);
            mediaView.setVisibility(0);
            mediaView.postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.card.view.banner.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBaseBannerCard.U(ZPlanMediaView.this);
                }
            }, 250L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ZPlanMediaView it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.setVisibility(4);
        it.stop();
    }

    public final ArrayList<ZPlanMediaView> P() {
        return this.fakeBannerViews;
    }

    public abstract void R(Banner<s, d> bannerView);

    public abstract void V(Banner<s, d> bannerView);

    @Override // l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        y(getSelfItemType() + " - bindItemInfo, position=" + position + ", totalCount=" + totalCount + ", bannerAutoTurnInterval = " + dataInfo.getAutoTurnInterval(), false);
        this.cardPos = position;
        Banner<s, d> banner = this.banner;
        if (banner != null) {
            V(banner);
            banner.setInfiniteLoop(this.needBannerInfiniteLoop);
            if (dataInfo.getAutoTurnInterval() <= 0) {
                banner.setAutoLoop(false);
            } else {
                banner.setMLoopTime(dataInfo.getAutoTurnInterval() * 1000);
                banner.setAutoLoop(true);
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        List<s> c16 = dataInfo.c();
        if (c16 == null) {
            c16 = new ArrayList<>();
        }
        d dVar = new d(this, context, c16);
        this.bannerAdapter = dVar;
        dVar.o0(this.bannerClickListener);
        Banner<s, d> banner2 = this.banner;
        if (banner2 != null) {
            d dVar2 = this.bannerAdapter;
            Intrinsics.checkNotNull(dVar2);
            banner2.setAdapter(dVar2);
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        View inflate = LayoutInflater.from(context).inflate(R.layout.dcw, viewParent, true);
        Banner<s, d> banner = new Banner<>(context);
        Q(banner);
        this.banner = banner;
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        viewGroup.addView(this.banner);
        M(viewGroup);
        return inflate;
    }

    public final void setFakeBannerViews(ArrayList<ZPlanMediaView> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.fakeBannerViews = arrayList;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZPlanBaseBannerCard";
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0011\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "a", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "c", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "mediaView", "Lpu4/g;", "b", "Lpu4/g;", "getMaterial", "()Lpu4/g;", "(Lpu4/g;)V", WadlProxyConsts.KEY_MATERIAL, "<init>", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;Lpu4/g;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.card.view.banner.ZPlanBaseBannerCard$c, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class FakeBannerItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private ZPlanMediaView mediaView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private pu4.g material;

        public FakeBannerItem(ZPlanMediaView zPlanMediaView, pu4.g gVar) {
            this.mediaView = zPlanMediaView;
            this.material = gVar;
        }

        /* renamed from: a, reason: from getter */
        public final ZPlanMediaView getMediaView() {
            return this.mediaView;
        }

        public final void b(pu4.g gVar) {
            this.material = gVar;
        }

        public final void c(ZPlanMediaView zPlanMediaView) {
            this.mediaView = zPlanMediaView;
        }

        public int hashCode() {
            ZPlanMediaView zPlanMediaView = this.mediaView;
            int hashCode = (zPlanMediaView == null ? 0 : zPlanMediaView.hashCode()) * 31;
            pu4.g gVar = this.material;
            return hashCode + (gVar != null ? gVar.hashCode() : 0);
        }

        public String toString() {
            return "FakeBannerItem(mediaView=" + this.mediaView + ", material=" + this.material + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FakeBannerItem)) {
                return false;
            }
            FakeBannerItem fakeBannerItem = (FakeBannerItem) other;
            return Intrinsics.areEqual(this.mediaView, fakeBannerItem.mediaView) && Intrinsics.areEqual(this.material, fakeBannerItem.material);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$e", "Lqa4/d;", "Lpv4/s;", "Landroid/view/View;", "view", "data", "", "position", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements qa4.d<s> {
        e() {
        }

        @Override // qa4.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(View view, s data, int position) {
            Intrinsics.checkNotNullParameter(view, "view");
            ZPlanBaseBannerCard.this.y("clickBanner - " + position + " - " + (data != null ? data.f427683d : null), false);
            if (ZPlanBaseBannerCard.this.getCardData() != null && data != null) {
                com.tencent.sqshow.zootopia.card.report.a aVar = ZPlanBaseBannerCard.this.reportHelper;
                int i3 = ZPlanBaseBannerCard.this.cardPos;
                String g16 = a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, data.f427681b, null, 2, null);
                ZootopiaCardData cardData = ZPlanBaseBannerCard.this.getCardData();
                Intrinsics.checkNotNull(cardData);
                aVar.a(view, i3, position, g16, cardData, data, (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : null);
            }
            ZootopiaBaseCard.w(ZPlanBaseBannerCard.this, data != null ? data.f427682c : null, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(View itemView, int itemPos) {
        List<s> c16;
        List<s> c17;
        if (itemView != null) {
            ZootopiaCardData cardData = getCardData();
            if (((cardData == null || (c17 = cardData.c()) == null) ? 0 : c17.size()) > itemPos) {
                ZootopiaCardData cardData2 = getCardData();
                s sVar = (cardData2 == null || (c16 = cardData2.c()) == null) ? null : c16.get(itemPos);
                Intrinsics.checkNotNull(sVar);
                com.tencent.sqshow.zootopia.card.report.a aVar = this.reportHelper;
                int i3 = this.cardPos;
                String g16 = a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, sVar.f427681b, null, 2, null);
                ZootopiaCardData cardData3 = getCardData();
                Intrinsics.checkNotNull(cardData3);
                aVar.c(itemView, i3, itemPos, g16, cardData3, sVar, (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$f", "Lcom/tencent/sqshow/zootopia/portal/home/banner/c;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "", "isFakeEdgeItem", "c", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Banner<s, d> f370201e;

        f(Banner<s, d> banner) {
            this.f370201e = banner;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(RecyclerView recyclerView, int i3, ZPlanBaseBannerCard this$0, boolean z16, int i16) {
            List<s> c16;
            s sVar;
            List<s> c17;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            pu4.g gVar = null;
            View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(i3) : null;
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            this$0.y("onPageSelected: virtualPos- " + i3 + " itemView- " + findViewByPosition + ProgressTracer.SEPARATOR + (layoutManager2 != null ? Integer.valueOf(layoutManager2.getChildCount()) : null), true);
            RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
            int i17 = 0;
            int childCount = layoutManager3 != null ? layoutManager3.getChildCount() : 0;
            for (int i18 = 0; i18 < childCount; i18++) {
                RecyclerView.LayoutManager layoutManager4 = recyclerView.getLayoutManager();
                View childAt = layoutManager4 != null ? layoutManager4.getChildAt(i18) : null;
                ZPlanMediaView zPlanMediaView = childAt instanceof ZPlanMediaView ? (ZPlanMediaView) childAt : null;
                if (zPlanMediaView != null && !Intrinsics.areEqual(zPlanMediaView, findViewByPosition)) {
                    zPlanMediaView.setProgress(0.0d);
                    zPlanMediaView.stop();
                }
            }
            ZPlanMediaView zPlanMediaView2 = findViewByPosition instanceof ZPlanMediaView ? (ZPlanMediaView) findViewByPosition : null;
            if (zPlanMediaView2 != null) {
                ZootopiaCardData cardData = this$0.getCardData();
                if (cardData != null && (c17 = cardData.c()) != null) {
                    i17 = c17.size();
                }
                if (i17 > i16) {
                    ZootopiaCardData cardData2 = this$0.getCardData();
                    if (cardData2 != null && (c16 = cardData2.c()) != null && (sVar = c16.get(i16)) != null) {
                        gVar = sVar.f427681b;
                    }
                    if (gVar != null) {
                        zPlanMediaView2.e(gVar);
                    }
                }
            }
            if (!z16 && this$0.needBannerInfiniteLoop && this$0.needFakeBanners) {
                this$0.S(i16);
            }
            this$0.N(findViewByPosition, i16);
        }

        @Override // com.tencent.sqshow.zootopia.portal.home.banner.c
        public void c(final int position, final boolean isFakeEdgeItem) {
            ZPlanBaseBannerCard.this.y("onPageSelected: onPageSelected " + position + ", isFakeEdgeItem = " + isFakeEdgeItem, true);
            View childAt = this.f370201e.E().getChildAt(0);
            RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
            final int c16 = sa4.a.f433598a.c(this.f370201e.getIsInfiniteLooper(), position);
            if (recyclerView != null) {
                final ZPlanBaseBannerCard zPlanBaseBannerCard = ZPlanBaseBannerCard.this;
                final RecyclerView recyclerView2 = recyclerView;
                recyclerView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.card.view.banner.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanBaseBannerCard.f.f(RecyclerView.this, c16, zPlanBaseBannerCard, isFakeEdgeItem, position);
                    }
                });
            }
        }

        @Override // com.tencent.sqshow.zootopia.portal.home.banner.c
        public void onPageScrollStateChanged(int state) {
        }

        @Override // com.tencent.sqshow.zootopia.portal.home.banner.c
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
