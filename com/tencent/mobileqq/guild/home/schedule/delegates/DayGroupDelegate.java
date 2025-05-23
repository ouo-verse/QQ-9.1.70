package com.tencent.mobileqq.guild.home.schedule.delegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.s;
import com.tencent.mobileqq.guild.home.schedule.models.DayGroupItem;
import com.tencent.mobileqq.guild.home.schedule.models.d;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \f2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u0017\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0014J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0014J4\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/DayGroupDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "items", "", "position", "", "j", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "g", h.F, "", "", "payloads", "k", "<init>", "()V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DayGroupDelegate extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends d>> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/DayGroupDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "itemTitle", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView itemTitle;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/DayGroupDelegate$b$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.schedule.delegates.DayGroupDelegate$b$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final View b(ViewGroup parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.f7g, parent, false);
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ViewGroup parent) {
            super(INSTANCE.b(parent));
            Intrinsics.checkNotNullParameter(parent, "parent");
            View findViewById = this.itemView.findViewById(R.id.f165615wz0);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026uild_schedule_item_title)");
            this.itemTitle = (TextView) findViewById;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getItemTitle() {
            return this.itemTitle;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b(parent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.g(holder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends d> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        return items.get(position) instanceof DayGroupItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends d> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder instanceof b) {
            d dVar = items.get(position);
            Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.home.schedule.models.DayGroupItem");
            DayGroupItem dayGroupItem = (DayGroupItem) dVar;
            b bVar = (b) holder;
            bVar.getItemTitle().setText(dayGroupItem.getText());
            if (dayGroupItem.getIsToday()) {
                s.a(bVar.getItemTitle(), 600, 1);
                return;
            } else {
                s.a(bVar.getItemTitle(), 400, 0);
                return;
            }
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
