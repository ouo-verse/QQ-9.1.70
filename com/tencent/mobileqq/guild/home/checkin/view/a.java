package com.tencent.mobileqq.guild.home.checkin.view;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/home/checkin/view/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lvo1/a;", "<init>", "()V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class a extends d<vo1.a> {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/home/checkin/view/a$a;", "", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lvo1/a;", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.checkin.view.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/checkin/view/a$a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lvo1/a;", "oldItem", "newItem", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.checkin.view.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7790a extends DiffUtil.ItemCallback<vo1.a> {
            C7790a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            @SuppressLint({"DiffUtilEquals"})
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull vo1.a oldItem, @NotNull vo1.a newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                if (oldItem.getClass().isInstance(newItem) && Intrinsics.areEqual(oldItem, newItem)) {
                    return true;
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull vo1.a oldItem, @NotNull vo1.a newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getClass().isInstance(newItem);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DiffUtil.ItemCallback<vo1.a> b() {
            return new C7790a();
        }

        Companion() {
        }
    }

    public a() {
        super(INSTANCE.b());
        this.f236209m.c(new DayAdapterDelegate()).c(new ConnectingLineAdapterDelegate());
    }
}
