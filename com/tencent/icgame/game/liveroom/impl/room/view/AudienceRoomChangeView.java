package com.tencent.icgame.game.liveroom.impl.room.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.liveroom.impl.room.view.AudienceRoomChangeView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u000f\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "", "D", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$a;", "f", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$a;", "contentAdapter", "", "", tl.h.F, "Ljava/util/List;", "entryDataList", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class AudienceRoomChangeView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a contentAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Object> entryDataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "entryDataList", BdhLogUtil.LogTag.Tag_Conn, "I", "currentPosition", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;", "D", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;", "getItemClickListener", "()Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;", "setItemClickListener", "(Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;)V", "itemClickListener", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a extends RecyclerView.Adapter<c> {

        /* renamed from: C, reason: from kotlin metadata */
        private int currentPosition;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Object> entryDataList = new ArrayList();

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private b itemClickListener = new C5843a();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$a$a", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;", "", com.tencent.luggage.wxa.c8.c.G, "", "onItemClick", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.icgame.game.liveroom.impl.room.view.AudienceRoomChangeView$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C5843a implements b {
            C5843a() {
            }

            @Override // com.tencent.icgame.game.liveroom.impl.room.view.AudienceRoomChangeView.b
            public void onItemClick(int pos) {
                a.this.currentPosition = pos;
                a.this.notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.entryDataList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull c holder, int position) {
            boolean z16;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (this.currentPosition == position) {
                z16 = true;
            } else {
                z16 = false;
            }
            holder.n(z16, this.entryDataList.get(position), position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fbb, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            c cVar = new c(view);
            cVar.o(this.itemClickListener);
            return cVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;", "", "", com.tencent.luggage.wxa.c8.c.G, "", "onItemClick", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface b {
        void onItemClick(int pos);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010 J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "isCurrent", "", "data", "", com.tencent.luggage.wxa.c8.c.G, "", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "contentText", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "waitIcon", "G", "parentView", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;", "H", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;", "getItemClickListener", "()Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;", "o", "(Lcom/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$b;)V", "itemClickListener", "I", "itemPosition", "itemView", "<init>", "(Landroid/view/View;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private TextView contentText;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private View waitIcon;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private View parentView;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private b itemClickListener;

        /* renamed from: I, reason: from kotlin metadata */
        private int itemPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.contentText = (TextView) itemView.findViewById(R.id.u7y);
            this.waitIcon = itemView.findViewById(R.id.f1205479u);
            this.parentView = itemView.findViewById(R.id.f224903v);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudienceRoomChangeView.c.m(AudienceRoomChangeView.c.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(c this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            b bVar = this$0.itemClickListener;
            if (bVar != null) {
                bVar.onItemClick(this$0.itemPosition);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void n(boolean isCurrent, @NotNull Object data, int pos) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.itemPosition = pos;
            if (isCurrent) {
                View view = this.parentView;
                if (view != null) {
                    view.setBackgroundResource(R.drawable.lqk);
                    return;
                }
                return;
            }
            View view2 = this.parentView;
            if (view2 != null) {
                uu0.b.d(view2, uu0.a.b(4), Color.parseColor("#1A8A8AFF"));
            }
        }

        public final void o(@Nullable b bVar) {
            this.itemClickListener = bVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/view/AudienceRoomChangeView$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.left = uu0.a.b(5);
            outRect.right = uu0.a.b(5);
            outRect.top = uu0.a.b(16);
            outRect.bottom = uu0.a.b(16);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                outRect.left = uu0.a.b(2);
            } else if (childAdapterPosition == AudienceRoomChangeView.this.entryDataList.size() - 1) {
                outRect.right = uu0.a.b(2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceRoomChangeView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.entryDataList = new ArrayList();
        D(context);
    }

    private final void D(Context context) {
        setLayoutManager(new LinearLayoutManager(context, 0, false));
        a aVar = new a();
        this.contentAdapter = aVar;
        setAdapter(aVar);
        addItemDecoration(new d());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceRoomChangeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.entryDataList = new ArrayList();
        D(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceRoomChangeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.entryDataList = new ArrayList();
        D(context);
    }
}
