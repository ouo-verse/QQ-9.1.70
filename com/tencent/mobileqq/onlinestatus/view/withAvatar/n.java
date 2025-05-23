package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.repository.OnlineStatusLikeRepository;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\bE\u0010FJ\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0006\u0010\u0012\u001a\u00020\fJ\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\"R<\u0010-\u001a\u001c\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103R2\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R0\u0010D\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020A0@j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020A`B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/n;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "Lkotlin/Function1;", "callback", "m0", "l0", "k0", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "newState", "D", "newIndex", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/onlinestatus/repository/OnlineStatusLikeRepository;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/onlinestatus/repository/OnlineStatusLikeRepository;", "repository", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/l;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/l;", "extParam", "Lcom/tencent/mobileqq/onlinestatus/manager/a;", "Lcom/tencent/mobileqq/onlinestatus/manager/a;", "shareInfoCacheManager", "Lkotlin/Function3;", "Landroid/view/View;", "Lcom/tencent/mobileqq/onlinestatus/model/d;", "E", "Lkotlin/jvm/functions/Function3;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function3;", "n0", "(Lkotlin/jvm/functions/Function3;)V", "onItemClickListener", UserInfo.SEX_FEMALE, "I", "getSelectedIndex", "()I", "o0", "(I)V", "selectedIndex", "G", "getCurState", "setCurState", "curState", "H", "Lkotlin/jvm/functions/Function1;", "getHolderGetCallback", "()Lkotlin/jvm/functions/Function1;", "setHolderGetCallback", "(Lkotlin/jvm/functions/Function1;)V", "holderGetCallback", "Ljava/util/HashSet;", "Lmqq/util/WeakReference;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "holderCacheSet", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/repository/OnlineStatusLikeRepository;Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/l;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class n extends RecyclerView.Adapter<OnlineStatusLikeWithAvatarViewHolder> implements a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final OnlineStatusLikeWithAvatarExtParam extParam;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.onlinestatus.manager.a shareInfoCacheManager;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function3<? super View, ? super com.tencent.mobileqq.onlinestatus.model.d, ? super Integer, Unit> onItemClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    private int selectedIndex;

    /* renamed from: G, reason: from kotlin metadata */
    private int curState;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Integer, OnlineStatusLikeWithAvatarViewHolder> holderGetCallback;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final HashSet<WeakReference<OnlineStatusLikeWithAvatarViewHolder>> holderCacheSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private OnlineStatusLikeRepository repository;

    public n(@NotNull OnlineStatusLikeRepository repository, @NotNull OnlineStatusLikeWithAvatarExtParam extParam) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        this.repository = repository;
        this.extParam = extParam;
        this.shareInfoCacheManager = new com.tencent.mobileqq.onlinestatus.manager.a();
        this.selectedIndex = -1;
        this.curState = -1;
        this.holderCacheSet = new HashSet<>();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.withAvatar.a
    public void A(@NotNull RecyclerView rv5, int newIndex) {
        Intrinsics.checkNotNullParameter(rv5, "rv");
        int i3 = this.selectedIndex;
        if (i3 == newIndex) {
            return;
        }
        this.selectedIndex = newIndex;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = rv5.findViewHolderForAdapterPosition(newIndex);
        if (findViewHolderForAdapterPosition instanceof OnlineStatusLikeWithAvatarViewHolder) {
            ((OnlineStatusLikeWithAvatarViewHolder) findViewHolderForAdapterPosition).H0(i3, newIndex);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.withAvatar.a
    public void D(@NotNull RecyclerView rv5, int newState) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        Intrinsics.checkNotNullParameter(rv5, "rv");
        int i3 = this.curState;
        if (i3 == newState) {
            return;
        }
        this.curState = newState;
        int i16 = this.selectedIndex;
        if (i16 >= 0) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = rv5.findViewHolderForAdapterPosition(i16);
            if (findViewHolderForAdapterPosition2 instanceof OnlineStatusLikeWithAvatarViewHolder) {
                ((OnlineStatusLikeWithAvatarViewHolder) findViewHolderForAdapterPosition2).I0(i3, newState);
            }
            int i17 = this.selectedIndex;
            RecyclerView.ViewHolder viewHolder = null;
            if (i17 <= 0) {
                findViewHolderForAdapterPosition = null;
            } else {
                findViewHolderForAdapterPosition = rv5.findViewHolderForAdapterPosition(i17 - 1);
            }
            if (findViewHolderForAdapterPosition instanceof OnlineStatusLikeWithAvatarViewHolder) {
                ((OnlineStatusLikeWithAvatarViewHolder) findViewHolderForAdapterPosition).J0(i3, newState);
            }
            if (this.selectedIndex < getNUM_BACKGOURND_ICON()) {
                viewHolder = rv5.findViewHolderForAdapterPosition(this.selectedIndex + 1);
            }
            if (viewHolder instanceof OnlineStatusLikeWithAvatarViewHolder) {
                ((OnlineStatusLikeWithAvatarViewHolder) viewHolder).J0(i3, newState);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.repository.p().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull OnlineStatusLikeWithAvatarViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.y0(this.onItemClickListener);
        holder.H0(-1, this.selectedIndex);
        holder.I0(-1, this.curState);
        holder.B(this.repository.n(position));
        WeakReference<OnlineStatusLikeWithAvatarViewHolder> weakReference = new WeakReference<>(holder);
        if (!this.holderCacheSet.contains(weakReference)) {
            this.holderCacheSet.add(weakReference);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public OnlineStatusLikeWithAvatarViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return OnlineStatusLikeWithAvatarViewHolder.INSTANCE.a(parent, this.shareInfoCacheManager, this.extParam);
    }

    public final void k0() {
        Iterator<WeakReference<OnlineStatusLikeWithAvatarViewHolder>> it = this.holderCacheSet.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "holderCacheSet.iterator()");
        while (it.hasNext()) {
            OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder = it.next().get();
            if (onlineStatusLikeWithAvatarViewHolder != null) {
                onlineStatusLikeWithAvatarViewHolder.E();
                it.remove();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull OnlineStatusLikeWithAvatarViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        holder.E();
        this.holderCacheSet.remove(new WeakReference(holder));
    }

    public final void m0(@NotNull Function1<? super Integer, OnlineStatusLikeWithAvatarViewHolder> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.holderGetCallback = callback;
    }

    public final void n0(@Nullable Function3<? super View, ? super com.tencent.mobileqq.onlinestatus.model.d, ? super Integer, Unit> function3) {
        this.onItemClickListener = function3;
    }

    public final void o0(int i3) {
        this.selectedIndex = i3;
    }
}
