package l61;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.poke.NTPokeAndEmoPanel;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ll61/f;", "Lcom/tencent/qqnt/pluspanel/ui/b;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/aio/api/runtime/a;", "a", "", "b", "Landroid/content/Context;", "context", "Landroid/view/View;", "c", "Lcom/tencent/mobileqq/poke/NTPokeAndEmoPanel;", "Lcom/tencent/mobileqq/poke/NTPokeAndEmoPanel;", "mPanel", "Ll61/g;", "Ll61/g;", "mViewModel", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f implements com.tencent.qqnt.pluspanel.ui.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private NTPokeAndEmoPanel mPanel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private g mViewModel;

    @Override // com.tencent.qqnt.pluspanel.ui.b
    @NotNull
    public BaseVM<ol3.b, MviUIState, com.tencent.aio.api.runtime.a> a() {
        NTPokeAndEmoPanel nTPokeAndEmoPanel = this.mPanel;
        if (nTPokeAndEmoPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanel");
            nTPokeAndEmoPanel = null;
        }
        g gVar = new g(nTPokeAndEmoPanel);
        this.mViewModel = gVar;
        return gVar;
    }

    @Override // com.tencent.qqnt.pluspanel.ui.b
    @NotNull
    public View c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.dvz, null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.poke.NTPokeAndEmoPanel");
        NTPokeAndEmoPanel nTPokeAndEmoPanel = (NTPokeAndEmoPanel) inflate;
        this.mPanel = nTPokeAndEmoPanel;
        if (nTPokeAndEmoPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanel");
            return null;
        }
        return nTPokeAndEmoPanel;
    }

    @Override // com.tencent.qqnt.pluspanel.ui.b
    public void b() {
    }
}
