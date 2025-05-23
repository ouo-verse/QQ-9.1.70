package hb4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.player.preload.VideoPlayerPreLoadManager;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressDetailVideoChildView;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailHeaderView;
import com.tencent.sqshow.zootopia.utils.ah;
import java.util.ArrayList;
import jb4.p;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q84.c;
import q84.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002STB'\u0012\u0006\u00102\u001a\u00020-\u0012\u0006\u00108\u001a\u000203\u0012\u0006\u0010>\u001a\u000209\u0012\u0006\u0010D\u001a\u00020?\u00a2\u0006\u0004\bP\u0010QJ$\u0010\t\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002JB\u0010\u0010\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0012H\u0017J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020\bH\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0016J \u0010,\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0012H\u0016R\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010>\u001a\u0002098\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010D\u001a\u00020?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010FR*\u0010J\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010KR\u0014\u0010N\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010MR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010M\u00a8\u0006U"}, d2 = {"Lhb4/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lhb4/b$b;", "Lq84/c;", "Ljava/util/ArrayList;", "Lcom/tencent/sqshow/zootopia/data/g;", "Lkotlin/collections/ArrayList;", "data", "", "j0", "o0", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "forceRefresh", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "p0", "i0", "", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "holder", "position", "k0", "m0", "n0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "Lq84/b;", "selectInfo", "w", UserInfo.SEX_FEMALE, "H", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "l", ExifInterface.LATITUDE_SOUTH, "", "positionOffset", "positionOffsetPixels", "onFeedPageScrolled", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView;", "getHeaderView", "()Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView;", "headerView", "Ljb4/p;", "D", "Ljb4/p;", "getFeedIoc", "()Ljb4/p;", "feedIoc", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "E", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSourceCurrent", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Lq84/d;", "Lq84/d;", "statusManager", "G", "Ljava/util/ArrayList;", "dataList", "I", "oldSize", "Ljava/lang/String;", "sourceId", "J", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailHeaderView;Ljb4/p;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "K", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends RecyclerView.Adapter<C10430b> implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private final DressSquareDetailHeaderView headerView;

    /* renamed from: D, reason: from kotlin metadata */
    private final p feedIoc;

    /* renamed from: E, reason: from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: F, reason: from kotlin metadata */
    private d statusManager;

    /* renamed from: G, reason: from kotlin metadata */
    private ArrayList<ZootopiaDetailFeedsCardData> dataList;

    /* renamed from: H, reason: from kotlin metadata */
    private int oldSize;

    /* renamed from: I, reason: from kotlin metadata */
    private final String sourceId;

    /* renamed from: J, reason: from kotlin metadata */
    private String requestId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lhb4/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/sqshow/zootopia/data/g;", "data", "", "position", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "l", "Landroid/view/View;", "E", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hb4.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10430b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final View rootView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10430b(View rootView) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.rootView = rootView;
        }

        public final void l(ZootopiaDetailFeedsCardData data, int position, String requestId) {
            Intrinsics.checkNotNullParameter(data, "data");
            View view = this.itemView;
            if (!(view instanceof DressDetailVideoChildView)) {
                QLog.d("DressSquareDetailViewVerticalPageAdapter", 1, "bindData, position: " + position + ", data:" + data);
                return;
            }
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressDetailVideoChildView");
            ((DressDetailVideoChildView) view).d(data, position, requestId);
        }
    }

    public b(Context context, DressSquareDetailHeaderView headerView, p feedIoc, ZootopiaSource sourceCurrent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(headerView, "headerView");
        Intrinsics.checkNotNullParameter(feedIoc, "feedIoc");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.context = context;
        this.headerView = headerView;
        this.feedIoc = feedIoc;
        this.sourceCurrent = sourceCurrent;
        this.sourceId = ah.b(sourceCurrent);
        this.requestId = "";
    }

    private final void j0(ArrayList<ZootopiaDetailFeedsCardData> data) {
        VideoPlayerPreLoadManager.INSTANCE.a().p(data);
        this.headerView.i(data, this.sourceId);
    }

    private final void o0() {
        d dVar = new d(this.feedIoc);
        this.statusManager = dVar;
        dVar.a(this.headerView);
        d dVar2 = this.statusManager;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar2 = null;
        }
        dVar2.b(new com.tencent.sqshow.zootopia.player.preload.a(this));
    }

    @Override // q84.c
    public void F(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.F(selectInfo);
        QLog.d("DressSquareDetailViewVerticalPageAdapter", 1, "onPaused");
    }

    @Override // q84.c
    public void H(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.H(selectInfo);
        QLog.d("DressSquareDetailViewVerticalPageAdapter", 1, DKHippyEvent.EVENT_STOP);
    }

    @Override // q84.c
    public void S(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.S(selectInfo);
        QLog.d("DressSquareDetailViewVerticalPageAdapter", 1, "onFeedUnSelected");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<ZootopiaDetailFeedsCardData> arrayList = this.dataList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final ArrayList<ZootopiaDetailFeedsCardData> i0() {
        return this.dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C10430b holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ArrayList<ZootopiaDetailFeedsCardData> arrayList = this.dataList;
        if (arrayList != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, position);
            ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = (ZootopiaDetailFeedsCardData) orNull;
            if (zootopiaDetailFeedsCardData == null) {
                return;
            }
            holder.l(zootopiaDetailFeedsCardData, position, this.requestId);
            d dVar = this.statusManager;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusManager");
                dVar = null;
            }
            dVar.d(holder);
        }
    }

    @Override // q84.c
    public void l(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.l(selectInfo);
        QLog.d("DressSquareDetailViewVerticalPageAdapter", 1, "onFeedSelected");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C10430b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DressDetailVideoChildView dressDetailVideoChildView = new DressDetailVideoChildView(parent.getContext(), this.sourceCurrent);
        dressDetailVideoChildView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return new C10430b(dressDetailVideoChildView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(C10430b holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.c(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(C10430b holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.h(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        o0();
    }

    @Override // q84.c
    public void onDestroy() {
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.onDestroy();
        QLog.d("DressSquareDetailViewVerticalPageAdapter", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.onDestroy();
    }

    public final void p0(ArrayList<ZootopiaDetailFeedsCardData> data, boolean isLoadMore, boolean forceRefresh, String requestId) {
        j0(data);
        this.dataList = data;
        this.requestId = requestId;
        int size = data != null ? data.size() : 0;
        if (!isLoadMore) {
            this.oldSize = size;
            notifyDataSetChanged();
            return;
        }
        int i3 = this.oldSize;
        if (i3 == size) {
            notifyItemRangeChanged(0, i3);
        } else if (i3 < size) {
            if (i3 != 1 || forceRefresh) {
                notifyItemRangeChanged(0, i3);
            }
            int i16 = this.oldSize;
            notifyItemRangeInserted(i16, size - i16);
        } else if (i3 > size) {
            notifyItemRangeChanged(0, size);
            notifyItemRangeRemoved(size, this.oldSize - size);
        }
        this.oldSize = size;
    }

    @Override // q84.c
    public void w(q84.b selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.w(selectInfo);
        QLog.d("DressSquareDetailViewVerticalPageAdapter", 1, "onResumed");
    }

    public void onFeedPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        QLog.d("DressSquareDetailViewVerticalPageAdapter", 1, "onFeedPageScrolled");
        d dVar = this.statusManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusManager");
            dVar = null;
        }
        dVar.g(position, positionOffset, positionOffsetPixels);
    }

    public static /* synthetic */ void q0(b bVar, ArrayList arrayList, boolean z16, boolean z17, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        if ((i3 & 8) != 0) {
            str = "";
        }
        bVar.p0(arrayList, z16, z17, str);
    }
}
