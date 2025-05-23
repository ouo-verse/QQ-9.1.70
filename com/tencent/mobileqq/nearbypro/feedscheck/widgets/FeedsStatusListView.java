package com.tencent.mobileqq.nearbypro.feedscheck.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.feedscheck.basepart.StatusFeedData;
import com.tencent.mobileqq.nearbypro.feedscheck.widgets.FeedsStatusListView;
import com.tencent.mobileqq.nearbypro.part.a;
import com.tencent.mobileqq.nearbypro.utils.FormatUtils;
import com.tencent.mobileqq.nearbypro.utils.PicLoadUtilsKt;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import op4.f;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xp4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0003\u000f\u0010\u0011B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedsStatusListView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "b", "c", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FeedsStatusListView extends RecyclerView {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001c\u0010\u000f\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bH\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000b0!j\b\u0012\u0004\u0012\u00020\u000b`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedsStatusListView$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedsStatusListView$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "l0", "Landroidx/lifecycle/LiveData;", "", "n0", "", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/h;", "feedsList", "", "selectFeedId", "s0", "Lxp4/h;", "person", "r0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "position", "getItemViewType", "getItemCount", "o0", "Lcom/tencent/mobileqq/nearbypro/part/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/nearbypro/part/a;", "m0", "()Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "statusFeedsList", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "selectedPosition", "E", "Lxp4/h;", "<init>", "(Lcom/tencent/mobileqq/nearbypro/part/a;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends RecyclerView.Adapter<c> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final ArrayList<StatusFeedData> statusFeedsList;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private MutableLiveData<Integer> selectedPosition;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private h person;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a host;

        public b(@NotNull a host) {
            Intrinsics.checkNotNullParameter(host, "host");
            this.host = host;
            this.statusFeedsList = new ArrayList<>();
            this.selectedPosition = new MutableLiveData<>(-1);
            this.person = new h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l0(RecyclerView.ViewHolder holder) {
            Integer value = this.selectedPosition.getValue();
            int adapterPosition = holder.getAdapterPosition();
            if (value == null || value.intValue() != adapterPosition) {
                Integer value2 = this.selectedPosition.getValue();
                this.selectedPosition.setValue(Integer.valueOf(holder.getAdapterPosition()));
                Intrinsics.checkNotNull(value2);
                notifyItemChanged(value2.intValue());
                Integer value3 = this.selectedPosition.getValue();
                Intrinsics.checkNotNull(value3);
                notifyItemChanged(value3.intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p0(StatusFeedData itemData, b this$0, c holder, View view) {
            op4.h hVar;
            f gps;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(itemData, "$itemData");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            if (!GuildUIUtils.f235378a.C()) {
                if (!NetworkUtil.isNetworkAvailable()) {
                    BaseApplication baseApplication = BaseApplication.context;
                    QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
                } else {
                    int statusFeedType = itemData.getStatusFeedType();
                    if (statusFeedType == 1) {
                        this$0.l0(holder);
                        if (com.tencent.filament.zplan.scene.square.b.e(this$0.person.f448325a)) {
                            String qqStr = HardCodeUtil.qqStr(R.string.f170252kj);
                            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.nearbypro_get_sig_error)");
                            s.c(qqStr);
                        } else {
                            this$0.getHost().t5("MSG_LOCATION_ACTION", new LatLng(this$0.person.f448326b.f429215a, this$0.person.f448326b.f429216b));
                        }
                    } else if (statusFeedType == 2) {
                        this$0.l0(holder);
                        i statusFeed = itemData.getStatusFeed();
                        if (statusFeed != null && (hVar = statusFeed.f423357g) != null && (gps = hVar.f423336g) != null) {
                            Intrinsics.checkNotNullExpressionValue(gps, "gps");
                            double d16 = 1000000;
                            this$0.getHost().t5("MSG_LOCATION_ACTION", new LatLng(gps.f423324a / d16, gps.f423325b / d16, gps.f423327d / d16));
                        }
                    } else if (statusFeedType == 3) {
                        this$0.getHost().t5("CLICK_MORE_POS", null);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.statusFeedsList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position > this.statusFeedsList.size()) {
                return super.getItemViewType(position);
            }
            return this.statusFeedsList.get(position).getStatusFeedType();
        }

        @NotNull
        /* renamed from: m0, reason: from getter */
        public final a getHost() {
            return this.host;
        }

        @NotNull
        public final LiveData<Integer> n0() {
            return this.selectedPosition;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull final c holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (position > this.statusFeedsList.size()) {
                j.c().c("NBP.FeedsCheckPart.FeedsStatusListView", "onBindViewHolder illegal position");
                return;
            }
            Integer value = this.selectedPosition.getValue();
            if (value != null && value.intValue() == -1) {
                this.selectedPosition.setValue(Integer.valueOf(position));
            }
            StatusFeedData statusFeedData = this.statusFeedsList.get(position);
            Intrinsics.checkNotNullExpressionValue(statusFeedData, "statusFeedsList[position]");
            final StatusFeedData statusFeedData2 = statusFeedData;
            holder.itemView.setTag(statusFeedData2);
            int itemViewType = getItemViewType(position);
            boolean z16 = false;
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    if (itemViewType == 3) {
                        holder.n(statusFeedData2);
                    }
                } else {
                    Integer value2 = this.selectedPosition.getValue();
                    if (value2 != null && value2.intValue() == position) {
                        z16 = true;
                    }
                    holder.m(z16, statusFeedData2);
                }
            } else {
                Integer value3 = this.selectedPosition.getValue();
                if (value3 != null && value3.intValue() == position) {
                    z16 = true;
                }
                holder.l(z16);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ta2.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedsStatusListView.b.p0(StatusFeedData.this, this, holder, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fna, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026status_vh, parent, false)");
            return new c(inflate);
        }

        public final void r0(@NotNull h person) {
            Intrinsics.checkNotNullParameter(person, "person");
            this.person = person;
        }

        public final void s0(@NotNull List<StatusFeedData> feedsList, @NotNull String selectFeedId) {
            Object obj;
            int indexOf;
            Intrinsics.checkNotNullParameter(feedsList, "feedsList");
            Intrinsics.checkNotNullParameter(selectFeedId, "selectFeedId");
            this.statusFeedsList.clear();
            this.statusFeedsList.addAll(feedsList);
            if (!StringUtil.isEmpty(selectFeedId)) {
                Iterator<T> it = feedsList.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    i statusFeed = ((StatusFeedData) next).getStatusFeed();
                    if (statusFeed != null) {
                        obj = statusFeed.f423351a;
                    }
                    if (Intrinsics.areEqual(obj, selectFeedId)) {
                        obj = next;
                        break;
                    }
                }
                StatusFeedData statusFeedData = (StatusFeedData) obj;
                if (statusFeedData == null) {
                    String qqStr = HardCodeUtil.qqStr(R.string.f170202ke);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.nearbypro_feeds_not_exit)");
                    s.b(qqStr);
                }
                MutableLiveData<Integer> mutableLiveData = this.selectedPosition;
                indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends StatusFeedData>) ((List<? extends Object>) feedsList), statusFeedData);
                mutableLiveData.setValue(Integer.valueOf(indexOf));
            } else {
                int size = feedsList.size();
                Integer value = this.selectedPosition.getValue();
                Intrinsics.checkNotNull(value);
                if (size > value.intValue()) {
                    MutableLiveData<Integer> mutableLiveData2 = this.selectedPosition;
                    mutableLiveData2.setValue(mutableLiveData2.getValue());
                } else {
                    this.selectedPosition.setValue(-1);
                }
            }
            j.c().c("NBP.FeedsCheckPart.FeedsStatusListView", "setFeedsList " + this.selectedPosition.getValue());
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u001c\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \f*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\n \f*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedsStatusListView$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "", "isSelected", "l", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/h;", "feedData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Landroid/view/View;", "kotlin.jvm.PlatformType", "E", "Landroid/view/View;", "feedsContainer", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "feedsStatusIv", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "feedsStatusTv", "H", "feedsPublishTime", "itemView", "<init>", "(Landroid/view/View;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final View feedsContainer;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView feedsStatusIv;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView feedsStatusTv;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView feedsPublishTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.feedsContainer = itemView.findViewById(R.id.v4m);
            this.feedsStatusIv = (ImageView) itemView.findViewById(R.id.v4j);
            this.feedsStatusTv = (TextView) itemView.findViewById(R.id.v4n);
            this.feedsPublishTime = (TextView) itemView.findViewById(R.id.v4i);
        }

        private final void o() {
            this.feedsContainer.getLayoutParams().width = ViewUtils.dpToPx(80.0f);
            this.feedsContainer.getLayoutParams().height = ViewUtils.dpToPx(80.0f);
        }

        @SuppressLint({"UseCompatLoadingForDrawables"})
        public final void l(boolean isSelected) {
            Drawable drawable;
            this.feedsPublishTime.setText("");
            this.feedsStatusIv.setImageResource(R.drawable.k3a);
            this.feedsStatusTv.setText(HardCodeUtil.qqStr(R.string.f170072k2));
            o();
            View view = this.feedsContainer;
            if (isSelected) {
                drawable = this.itemView.getResources().getDrawable(R.drawable.k2s);
            } else {
                drawable = this.itemView.getResources().getDrawable(R.drawable.k2o);
            }
            view.setBackground(drawable);
        }

        @SuppressLint({"UseCompatLoadingForDrawables"})
        public final void m(boolean isSelected, @NotNull StatusFeedData feedData) {
            Drawable drawable;
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            if (feedData.getStatusFeed() == null) {
                j.c().e("NBP.FeedsCheckPart.FeedsStatusListView", "bindFeedsData statusFeed is null");
                return;
            }
            String str = feedData.getStatusFeed().f423353c.f431882e;
            Intrinsics.checkNotNullExpressionValue(str, "feedData.statusFeed.statusInfo.bigIcon");
            ImageView feedsStatusIv = this.feedsStatusIv;
            Intrinsics.checkNotNullExpressionValue(feedsStatusIv, "feedsStatusIv");
            PicLoadUtilsKt.c(str, feedsStatusIv);
            this.feedsStatusTv.setText(feedData.getStatusFeed().f423353c.f431880c);
            this.feedsPublishTime.setText(FormatUtils.f253930a.b(feedData.getStatusFeed().f423358h * 1000));
            this.feedsPublishTime.setVisibility(0);
            o();
            View view = this.feedsContainer;
            if (isSelected) {
                drawable = this.itemView.getResources().getDrawable(R.drawable.k2s);
            } else {
                drawable = this.itemView.getResources().getDrawable(R.drawable.k2o);
            }
            view.setBackground(drawable);
        }

        public final void n(@NotNull StatusFeedData feedData) {
            String str;
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            this.feedsPublishTime.setVisibility(0);
            TextView textView = this.feedsPublishTime;
            up4.c moreIcon = feedData.getMoreIcon();
            if (moreIcon == null || (str = moreIcon.f439774b) == null) {
                str = "";
            }
            textView.setText(str);
            this.feedsStatusTv.setText(HardCodeUtil.qqStr(R.string.f170352kt));
            o();
            this.feedsStatusIv.setImageResource(R.drawable.k2m);
            this.feedsContainer.setBackground(this.itemView.getResources().getDrawable(R.drawable.k2o));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedsStatusListView$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = ViewUtils.dpToPx(12.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FeedsStatusListView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public final void C(@NotNull a host) {
        Intrinsics.checkNotNullParameter(host, "host");
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        safeLinearLayoutManager.setOrientation(0);
        setLayoutManager(safeLinearLayoutManager);
        setAdapter(new b(host));
        addItemDecoration(new d());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FeedsStatusListView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ FeedsStatusListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FeedsStatusListView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }
}
