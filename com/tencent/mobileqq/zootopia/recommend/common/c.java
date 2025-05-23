package com.tencent.mobileqq.zootopia.recommend.common;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import fd3.a;
import java.util.ArrayList;
import java.util.List;
import k84.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 /2\u00020\u0001:\u00010BA\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0018\b\u0002\u0010(\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%\u00a2\u0006\u0004\b-\u0010.J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zootopia/recommend/common/c;", "Lfd3/a;", "", "Lcom/tencent/sqshow/zootopia/data/c;", "cardDatas", "", "fillList", "", "getItemCount", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Lfd3/a$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "p", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Loa4/a;", "e", "Loa4/a;", "mapResViewModel", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "recommendList", "Lid3/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lid3/d;", "reportHelper", "<init>", "(Landroid/content/Context;Loa4/a;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/util/ArrayList;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class c extends fd3.a {
    private static final int D = ViewUtils.dpToPx(16.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mapResViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Object> recommendList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final id3.d reportHelper;

    public /* synthetic */ c(Context context, oa4.a aVar, LifecycleOwner lifecycleOwner, ZootopiaSource zootopiaSource, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, aVar, lifecycleOwner, zootopiaSource, (i3 & 16) != 0 ? new ArrayList() : arrayList);
    }

    public boolean fillList(List<ZootopiaCardData> cardDatas) {
        Intrinsics.checkNotNullParameter(cardDatas, "cardDatas");
        boolean z16 = false;
        if ((!this.recommendList.isEmpty()) && (!cardDatas.isEmpty())) {
            b.Companion companion = k84.b.INSTANCE;
            Object obj = this.recommendList.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "recommendList[0]");
            if (companion.b(obj) == companion.b(cardDatas.get(0))) {
                Object obj2 = this.recommendList.get(0);
                Intrinsics.checkNotNullExpressionValue(obj2, "recommendList[0]");
                if (companion.b(obj2) == 9) {
                    z16 = true;
                }
            }
        }
        int size = this.recommendList.size();
        this.recommendList.clear();
        this.recommendList.addAll(cardDatas);
        int size2 = this.recommendList.size();
        if (!z16) {
            notifyDataSetChanged();
        } else if (size == size2) {
            notifyItemRangeChanged(1, this.recommendList.size() - 1);
        } else if (size > size2) {
            notifyItemRangeChanged(1, size2 - 1);
            notifyItemRangeRemoved(size2 + 1, size - 1);
        } else if (size < size2) {
            notifyItemRangeChanged(1, size - 1);
            notifyItemRangeInserted(size + 1, size2 - 1);
        }
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.recommendList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        b.Companion companion = k84.b.INSTANCE;
        Object obj = this.recommendList.get(position);
        Intrinsics.checkNotNullExpressionValue(obj, "recommendList[position]");
        return companion.b(obj);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a.C10305a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object obj = this.recommendList.get(position);
        Intrinsics.checkNotNullExpressionValue(obj, "recommendList[position]");
        if (obj instanceof ZootopiaCardData) {
            long currentTimeMillis = System.currentTimeMillis();
            View view = holder.itemView;
            if (view instanceof ZootopiaBaseCard) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard");
                ((ZootopiaBaseCard) view).j((ZootopiaCardData) obj, position, getItemCount());
            }
            Object obj2 = holder.itemView;
            if (obj2 instanceof l84.a) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.base.IZootopiaCard");
                ((l84.a) obj2).f((ZootopiaCardData) obj, position, getItemCount());
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                KeyEvent.Callback callback = holder.itemView;
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.base.IZootopiaCard");
                QLog.i("ZplanCardFeedsListAdapter", 1, "onBindViewHolder: index = " + position + ", cardType = " + ((l84.a) callback).getSelfItemType() + ", costTime = " + currentTimeMillis2);
                return;
            }
            QLog.e("ZplanCardFeedsListAdapter", 1, "onBindViewHolder " + position + "  error not IZootopiaCard- " + obj2 + " - " + obj);
            return;
        }
        QLog.e("ZplanCardFeedsListAdapter", 1, "onBindViewHolder " + position + "  error not ZootopiaCardData- " + holder.itemView + " - " + obj);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a.C10305a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new a.C10305a(((nf3.a) vb3.a.f441346a.a(nf3.a.class)).b0(viewType, this.context, this.owner, this.mapResViewModel, this.sourceCurrent));
    }

    public c(Context context, oa4.a mapResViewModel, LifecycleOwner owner, ZootopiaSource sourceCurrent, ArrayList<Object> recommendList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Intrinsics.checkNotNullParameter(recommendList, "recommendList");
        this.context = context;
        this.mapResViewModel = mapResViewModel;
        this.owner = owner;
        this.sourceCurrent = sourceCurrent;
        this.recommendList = recommendList;
        this.reportHelper = new id3.d(null, 1, null);
    }
}
