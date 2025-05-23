package com.tencent.mobileqq.guild.media.widget.user.adapter;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.widget.user.adapter.e;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt1.GameNormalItem;
import rt1.MediaInviteItem;
import rt1.MediaPlayerRobotUserItem;
import rt1.MediaPlayerUserItem;
import rt1.MediaViewerRobotItem;
import rt1.MediaViewerUserItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/adapter/e;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lrt1/a;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "<init>", "()V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class e extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<rt1.a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/adapter/e$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lrt1/a;", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "oldItem", "newItem", "", "d", "b", "a", "", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private static final class a extends DiffUtil.ItemCallback<rt1.a> {
        private final boolean d(p oldItem, p newItem) {
            if (oldItem.f228101i == newItem.f228101i && oldItem.f228112t == newItem.f228112t && TextUtils.equals(oldItem.f228095c, newItem.f228095c) && TextUtils.equals(oldItem.f228094b, newItem.f228094b) && oldItem.f228103k == newItem.f228103k && oldItem.f228110r == newItem.f228110r && oldItem.f228113u == newItem.f228113u && oldItem.B == newItem.B && TextUtils.equals(oldItem.f228096d, newItem.f228096d) && oldItem.C.equals(newItem.C) && Intrinsics.areEqual(oldItem.K, newItem.K)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull rt1.a oldItem, @NotNull rt1.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if ((oldItem instanceof MediaPlayerUserItem) && (newItem instanceof MediaPlayerUserItem)) {
                return d(((MediaPlayerUserItem) oldItem).getUserInfo(), ((MediaPlayerUserItem) newItem).getUserInfo());
            }
            if ((oldItem instanceof MediaPlayerRobotUserItem) && (newItem instanceof MediaPlayerRobotUserItem)) {
                return d(((MediaPlayerRobotUserItem) oldItem).getUserInfo(), ((MediaPlayerRobotUserItem) newItem).getUserInfo());
            }
            if ((oldItem instanceof MediaViewerUserItem) && (newItem instanceof MediaViewerUserItem)) {
                return d(((MediaViewerUserItem) oldItem).getUserInfo(), ((MediaViewerUserItem) newItem).getUserInfo());
            }
            if ((oldItem instanceof MediaViewerRobotItem) && (newItem instanceof MediaViewerRobotItem)) {
                return d(((MediaViewerRobotItem) oldItem).getUserInfo(), ((MediaViewerRobotItem) newItem).getUserInfo());
            }
            if ((oldItem instanceof GameNormalItem) && (newItem instanceof GameNormalItem)) {
                return d(((GameNormalItem) oldItem).getUserInfo(), ((GameNormalItem) newItem).getUserInfo());
            }
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull rt1.a oldItem, @NotNull rt1.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if ((oldItem instanceof MediaPlayerUserItem) && (newItem instanceof MediaPlayerUserItem)) {
                return Intrinsics.areEqual(((MediaPlayerUserItem) oldItem).getUserInfo().f228093a, ((MediaPlayerUserItem) newItem).getUserInfo().f228093a);
            }
            if ((oldItem instanceof MediaPlayerRobotUserItem) && (newItem instanceof MediaPlayerRobotUserItem)) {
                return Intrinsics.areEqual(((MediaPlayerRobotUserItem) oldItem).getUserInfo().f228093a, ((MediaPlayerRobotUserItem) newItem).getUserInfo().f228093a);
            }
            if ((oldItem instanceof MediaViewerUserItem) && (newItem instanceof MediaViewerUserItem)) {
                return Intrinsics.areEqual(((MediaViewerUserItem) oldItem).getUserInfo().f228093a, ((MediaViewerUserItem) newItem).getUserInfo().f228093a);
            }
            if ((oldItem instanceof MediaViewerRobotItem) && (newItem instanceof MediaViewerRobotItem)) {
                return Intrinsics.areEqual(((MediaViewerRobotItem) oldItem).getUserInfo().f228093a, ((MediaViewerRobotItem) newItem).getUserInfo().f228093a);
            }
            if ((oldItem instanceof GameNormalItem) && (newItem instanceof GameNormalItem)) {
                return Intrinsics.areEqual(((GameNormalItem) oldItem).getUserInfo().f228093a, ((GameNormalItem) newItem).getUserInfo().f228093a);
            }
            if ((oldItem instanceof MediaInviteItem) && (newItem instanceof MediaInviteItem)) {
                if (((MediaInviteItem) oldItem).getColumn() == ((MediaInviteItem) newItem).getColumn()) {
                    return true;
                }
                return false;
            }
            return TextUtils.equals(oldItem.getItemId(), newItem.getItemId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull rt1.a oldItem, @NotNull rt1.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return newItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/adapter/e$b;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "Lmqq/util/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Lmqq/util/WeakReference;", "getRecyclerView", "()Lmqq/util/WeakReference;", "recyclerView", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "<init>", "(Lmqq/util/WeakReference;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Executor {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<RecyclerView> recyclerView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Handler mHandler;

        public b(@NotNull WeakReference<RecyclerView> recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.recyclerView = recyclerView;
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(final b this$0, final Runnable command) {
            RecyclerView recyclerView;
            RecyclerView recyclerView2;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(command, "$command");
            WeakReference<RecyclerView> weakReference = this$0.recyclerView;
            boolean z16 = false;
            if (weakReference != null && (recyclerView2 = weakReference.get()) != null && !recyclerView2.isComputingLayout()) {
                z16 = true;
            }
            if (z16) {
                command.run();
                return;
            }
            WeakReference<RecyclerView> weakReference2 = this$0.recyclerView;
            if (weakReference2 != null) {
                recyclerView = weakReference2.get();
            } else {
                recyclerView = null;
            }
            if (recyclerView != null) {
                this$0.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.user.adapter.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.b.e(e.b.this, command);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(b this$0, Runnable command) {
            RecyclerView recyclerView;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(command, "$command");
            WeakReference<RecyclerView> weakReference = this$0.recyclerView;
            boolean z16 = false;
            if (weakReference != null && (recyclerView = weakReference.get()) != null && !recyclerView.isComputingLayout()) {
                z16 = true;
            }
            if (z16) {
                command.run();
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NotNull final Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.user.adapter.f
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.c(e.b.this, command);
                }
            });
        }
    }

    public e() {
        super(new a());
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        try {
            int i3 = AsyncListDiffer.f26481a;
            Field[] declaredFields = AsyncListDiffer.class.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "clz.declaredFields");
            for (Field field : declaredFields) {
                if (Intrinsics.areEqual(field.getName(), "mMainThreadExecutor")) {
                    field.setAccessible(true);
                    field.set(this.C, new b(new WeakReference(recyclerView)));
                    return;
                }
            }
        } catch (Exception e16) {
            QLog.e("SafeAsyncListDifferDelegationAdapter", 1, "hack AsyncListDiffer failed: " + e16);
        }
    }
}
