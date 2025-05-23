package os0;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u00010\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0016R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Los0/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "b1", "Lts0/a;", "d", "Lts0/a;", "liveAIOListener", "", "e", "Ljava/lang/Boolean;", "isExcellentMsgDetail", "f", "Landroid/view/View;", "mRootView", "<init>", "(Lts0/a;Ljava/lang/Boolean;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.base.mvvm.a<qq0.b, GuildReserve2UIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ts0.a liveAIOListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Boolean isExcellentMsgDetail;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    public /* synthetic */ a(ts0.a aVar, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar, (i3 & 2) != 0 ? null : bool);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<qq0.b, GuildReserve2UIState> createVM() {
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf2;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        if (Intrinsics.areEqual(this.isExcellentMsgDetail, Boolean.TRUE)) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.guildlive.aio.reserve2.navigatebutton.b());
            return listOf2;
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new com.tencent.guildlive.aio.reserve2.navigatebar.b(), new com.tencent.guildlive.aio.reserve2.navigatebutton.b()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        int i3;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        ts0.a aVar = this.liveAIOListener;
        if (aVar != null) {
            i3 = aVar.S();
        } else {
            i3 = 0;
        }
        frameLayout.setPadding(0, i3, 0, 0);
        frameLayout.setClipToPadding(false);
        this.mRootView = frameLayout;
        return frameLayout;
    }

    public a(@Nullable ts0.a aVar, @Nullable Boolean bool) {
        this.liveAIOListener = aVar;
        this.isExcellentMsgDetail = bool;
    }
}
