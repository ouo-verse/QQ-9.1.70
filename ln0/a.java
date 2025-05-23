package ln0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.article.title.GuildArticleAIOTitleUIState;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mvi.api.ability.d;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ln0.c;
import mn0.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn0.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001 \u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J&\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00010\r2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00140\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lln0/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "", "f1", "Landroid/os/Bundle;", "d1", "Lcom/tencent/mvi/api/help/a;", "params", "Landroid/view/View;", "onCreateView", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "c1", "bindViewAndData", "Ljava/lang/Class;", "getObserverStates", "state", "e1", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lvn0/q;", "d", "Lvn0/q;", "mBinding", "ln0/a$b", "e", "Lln0/a$b;", "mThemeChangedCallback", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.base.mvvm.a<com.tencent.guild.aio.title.c, TitleUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private q mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mThemeChangedCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"ln0/a$b", "Lor0/a;", "", "onThemeChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements or0.a {
        b() {
        }

        @Override // or0.a
        public void onThemeChanged() {
            a.this.f1();
        }
    }

    private final Bundle d1() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[2];
        q qVar = this.mBinding;
        q qVar2 = null;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        qVar.getRoot().getLocationOnScreen(iArr);
        int i3 = iArr[1];
        q qVar3 = this.mBinding;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            qVar2 = qVar3;
        }
        bundle.putInt("title_bar_bottom_screen_position", i3 + qVar2.getRoot().getHeight());
        bundle.putInt("status_bar_bottom_screen_position", ImmersiveUtils.getStatusBarHeight(getMContext()));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1() {
        sq0.a aVar = sq0.a.f434200a;
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        RelativeLayout root = qVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        aVar.b(root);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        f1();
        QQGuildThemeManager.c(this.mThemeChangedCallback);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.title.c, TitleUIState> getViewModel() {
        return new ln0.b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull TitleUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        boolean z16 = state instanceof GuildArticleAIOTitleUIState.TitleAlphaUIState;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof c.a) {
            return d1();
        }
        return null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends TitleUIState>> getObserverStates() {
        List<Class<? extends TitleUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildArticleAIOTitleUIState.TitleAlphaUIState.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new e(), new on0.c(), new nn0.c()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        q g16 = q.g(LayoutInflater.from(params.a()), params.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, params.parent, false)");
        this.mBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        RelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        QQGuildThemeManager.d(this.mThemeChangedCallback);
    }
}
