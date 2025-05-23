package com.tencent.mobileqq.qwallet.hb.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014BE\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u001e\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00180\u0013\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b1\u00102J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R,\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00180\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001d\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/qwallet/hb/detail/CoverStoryBaseViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "hbSkinData", "", "n0", "holder", "l0", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "position", "j0", "getItemCount", "getItemViewType", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "stateLiveData", "Lkotlin/Triple;", "", BdhLogUtil.LogTag.Tag_Conn, "scrollInfoLiveData", "D", "I", "skinId", "", "E", "Ljava/lang/String;", "uniqueSkinId", "Landroidx/lifecycle/MutableLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "i0", "()Landroidx/lifecycle/MutableLiveData;", "visiblePosLiveData", "G", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "H", "Ljava/util/List;", "storyResList", "skinType", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;ILjava/lang/String;)V", "J", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends RecyclerView.Adapter<CoverStoryBaseViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Triple<Float, Float, Float>> scrollInfoLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private final int skinId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String uniqueSkinId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> visiblePosLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private HbSkinData hbSkinData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final List<HbSkinData.StoryRes> storyResList;

    /* renamed from: I, reason: from kotlin metadata */
    private int skinType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<HbSkinState> stateLiveData;

    public d(@NotNull LiveData<HbSkinState> stateLiveData, @NotNull LiveData<Triple<Float, Float, Float>> scrollInfoLiveData, int i3, @NotNull String uniqueSkinId) {
        Intrinsics.checkNotNullParameter(stateLiveData, "stateLiveData");
        Intrinsics.checkNotNullParameter(scrollInfoLiveData, "scrollInfoLiveData");
        Intrinsics.checkNotNullParameter(uniqueSkinId, "uniqueSkinId");
        this.stateLiveData = stateLiveData;
        this.scrollInfoLiveData = scrollInfoLiveData;
        this.skinId = i3;
        this.uniqueSkinId = uniqueSkinId;
        this.visiblePosLiveData = new MutableLiveData<>();
        this.storyResList = new ArrayList();
        this.skinType = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.storyResList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int resType = this.storyResList.get(position).getResType();
        if (resType == 0 || resType == 1) {
            return 1;
        }
        if (resType == 2) {
            if (!HbSkinData.INSTANCE.c(this.skinType)) {
                return 2;
            }
            return 3;
        }
        throw new IllegalArgumentException("invalid resType, " + resType);
    }

    @NotNull
    public final MutableLiveData<Integer> i0() {
        return this.visiblePosLiveData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull CoverStoryBaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        HbSkinData.StoryRes storyRes = this.storyResList.get(position);
        QLog.d("CoverStoryPagerAdapter", 2, "onBindViewHolder: position, " + position + ", item, " + storyRes);
        holder.w(this.hbSkinData, storyRes);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public CoverStoryBaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        CoverStoryBaseViewHolder coverStoryImageViewHolder;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(parent, "parent");
        QLog.d("CoverStoryPagerAdapter", 2, "onCreateViewHolder: viewType, " + viewType);
        if (viewType != 1) {
            if (viewType != 2) {
                if (viewType == 3) {
                    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hif, parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    coverStoryImageViewHolder = new QCircleVideoViewHolder(itemView, this.skinId, this.uniqueSkinId);
                } else {
                    throw new IllegalArgumentException("invalid viewType: " + viewType);
                }
            } else {
                View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.hif, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                coverStoryImageViewHolder = new CoverStoryVideoViewHolder(itemView2, this.skinId, this.uniqueSkinId);
            }
        } else {
            View itemView3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.hie, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
            coverStoryImageViewHolder = new CoverStoryImageViewHolder(itemView3, this.skinId);
        }
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(parent);
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(coverStoryImageViewHolder);
        }
        return coverStoryImageViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull CoverStoryBaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        QLog.d("CoverStoryPagerAdapter", 1, "onViewAttachedToWindow: " + holder);
        this.stateLiveData.observeForever(holder.p());
        this.scrollInfoLiveData.observeForever(holder.o());
        this.visiblePosLiveData.observeForever(holder.q());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NotNull CoverStoryBaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        QLog.d("CoverStoryPagerAdapter", 1, "onViewDetachedFromWindow: " + holder);
        this.stateLiveData.removeObserver(holder.p());
        this.scrollInfoLiveData.removeObserver(holder.o());
        this.visiblePosLiveData.removeObserver(holder.q());
    }

    public final void n0(@NotNull HbSkinData hbSkinData) {
        Intrinsics.checkNotNullParameter(hbSkinData, "hbSkinData");
        this.hbSkinData = hbSkinData;
        this.skinType = hbSkinData.getSkinType();
        int size = this.storyResList.size();
        this.storyResList.clear();
        notifyItemRangeRemoved(0, size);
        int size2 = hbSkinData.t().size();
        this.storyResList.addAll(hbSkinData.t());
        notifyItemRangeInserted(0, size2);
    }
}
