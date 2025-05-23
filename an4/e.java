package an4;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B#\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lan4/e;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "d", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "headerImg", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "resId", "Lan4/e$a;", "listener", "<init>", "(Landroid/view/ViewGroup;ILan4/e$a;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e extends BaseViewHolder<CommonOuterClass$QQUserId> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarRoundImageView headerImg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lan4/e$a;", "", "", "userId", "", "onItemClick", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void onItemClick(long userId);
    }

    public e(@Nullable ViewGroup viewGroup, int i3, @Nullable final a aVar) {
        super(viewGroup, i3);
        this.headerImg = (AvatarRoundImageView) getView(R.id.f114906ul);
        this.itemView.setOnClickListener(new View.OnClickListener(aVar) { // from class: an4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.c(null, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (aVar != null) {
            aVar.onItemClick(0L);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void d(@NotNull CommonOuterClass$QQUserId userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        AvatarRoundImageView avatarRoundImageView = this.headerImg;
        if (avatarRoundImageView != null) {
            avatarRoundImageView.setUserId(userId);
        }
    }
}
