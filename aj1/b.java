package aj1;

import aj1.b;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\"#B\u001d\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b \u0010!J\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001e\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u0005H\u0016J\u0017\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Laj1/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Laj1/b$b;", "Landroid/view/ViewGroup;", "p0", "", "p1", "l0", "holder", "position", "", "j0", "", "channelId", "m0", "(Ljava/lang/Long;)V", "getItemCount", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "Laj1/b$a;", BdhLogUtil.LogTag.Tag_Conn, "Laj1/b$a;", "listener", "", "D", "selectedItems", "E", "J", "selectedChannelId", "<init>", "(Ljava/util/List;Laj1/b$a;)V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends RecyclerView.Adapter<C0040b> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a listener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<IGProChannel> selectedItems;

    /* renamed from: E, reason: from kotlin metadata */
    private long selectedChannelId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProChannel> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Laj1/b$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "I8", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void I8(@Nullable IGProChannel item);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Laj1/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "E", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getCheckBox", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "checkBox", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "sectionName", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "tick", "Landroid/widget/RelativeLayout;", "H", "Landroid/widget/RelativeLayout;", "l", "()Landroid/widget/RelativeLayout;", "itemLayout", "Landroid/view/View;", "itemView", "<init>", "(Laj1/b;Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aj1.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public final class C0040b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QUICheckBox checkBox;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView sectionName;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView tick;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final RelativeLayout itemLayout;
        final /* synthetic */ b I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0040b(@NotNull b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.I = bVar;
            View findViewById = itemView.findViewById(R.id.awt);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.checkBox)");
            this.checkBox = (QUICheckBox) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f81744f0);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.sectionName)");
            this.sectionName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.y9w);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_tick)");
            this.tick = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.dq8);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.item_layout)");
            this.itemLayout = (RelativeLayout) findViewById4;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final RelativeLayout getItemLayout() {
            return this.itemLayout;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getSectionName() {
            return this.sectionName;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final ImageView getTick() {
            return this.tick;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull List<? extends IGProChannel> dataList, @NotNull a listener) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dataList = dataList;
        this.listener = listener;
        this.selectedItems = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(C0040b holder, b this$0, IGProChannel item, View view) {
        boolean z16;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        ImageView tick = holder.getTick();
        boolean z17 = true;
        if (holder.getTick().getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        tick.setVisibility(i3);
        if (holder.getTick().getVisibility() != 0) {
            z17 = false;
        }
        if (z17) {
            this$0.selectedItems.add(item);
            this$0.listener.I8(item);
            this$0.m0(Long.valueOf(item.getChannelId()));
        } else {
            this$0.selectedItems.remove(item);
            this$0.listener.I8(null);
            this$0.m0(0L);
        }
        this$0.notifyDataSetChanged();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final C0040b holder, @SuppressLint({"RecyclerView"}) int position) {
        boolean z16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final IGProChannel iGProChannel = this.dataList.get(position);
        holder.getSectionName().setText(iGProChannel.getChannelName());
        ImageView tick = holder.getTick();
        int i3 = 0;
        if (this.selectedChannelId == iGProChannel.getChannelId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        tick.setVisibility(i3);
        holder.getItemLayout().setOnClickListener(new View.OnClickListener() { // from class: aj1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.k0(b.C0040b.this, this, iGProChannel, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C0040b onCreateViewHolder(@NotNull ViewGroup p06, int p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        View view = LayoutInflater.from(p06.getContext()).inflate(R.layout.emr, p06, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new C0040b(this, view);
    }

    public final void m0(@Nullable Long channelId) {
        if (channelId == null) {
            return;
        }
        this.selectedChannelId = channelId.longValue();
    }
}
