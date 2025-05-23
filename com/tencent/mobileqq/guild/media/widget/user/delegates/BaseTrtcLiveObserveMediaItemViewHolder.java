package com.tencent.mobileqq.guild.media.widget.user.delegates;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseMediaItemDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseTrtcLiveObserveMediaItemViewHolder;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate$BaseMediaViewHolder;", "", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroidx/lifecycle/Observer;", "", "trtcNetQualityObserve", "Landroidx/lifecycle/Observer;", "", "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "trtcVolumeInfoObserve", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class BaseTrtcLiveObserveMediaItemViewHolder extends BaseMediaItemDelegate.BaseMediaViewHolder {

    @NotNull
    private final Observer<Integer> trtcNetQualityObserve;

    @NotNull
    private final Observer<Map<String, p>> trtcVolumeInfoObserve;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTrtcLiveObserveMediaItemViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.trtcNetQualityObserve = new Observer() { // from class: com.tencent.mobileqq.guild.media.widget.user.delegates.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseTrtcLiveObserveMediaItemViewHolder.trtcNetQualityObserve$lambda$0(BaseTrtcLiveObserveMediaItemViewHolder.this, (Integer) obj);
            }
        };
        this.trtcVolumeInfoObserve = new Observer() { // from class: com.tencent.mobileqq.guild.media.widget.user.delegates.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseTrtcLiveObserveMediaItemViewHolder.trtcVolumeInfoObserve$lambda$1(BaseTrtcLiveObserveMediaItemViewHolder.this, (Map) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trtcNetQualityObserve$lambda$0(BaseTrtcLiveObserveMediaItemViewHolder this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        r rVar = new r();
        rVar.f228125a.add(j.c().getSelfUserInfo());
        this$0.setNetworkStatus(rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trtcVolumeInfoObserve$lambda$1(BaseTrtcLiveObserveMediaItemViewHolder this$0, Map it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.setVolume(it);
    }

    public void onViewAttachedToWindow() {
        j.c().getSelfUserInfo().N.observeForever(this.trtcNetQualityObserve);
        j.c().a0().observeForever(this.trtcVolumeInfoObserve);
    }

    public void onViewDetachedFromWindow() {
        j.c().getSelfUserInfo().N.removeObserver(this.trtcNetQualityObserve);
        j.c().a0().removeObserver(this.trtcVolumeInfoObserve);
    }

    public abstract /* synthetic */ void setNetworkStatus(@NotNull r rVar);

    public abstract /* synthetic */ void setVolume(@NotNull Map<String, ? extends p> map);
}
