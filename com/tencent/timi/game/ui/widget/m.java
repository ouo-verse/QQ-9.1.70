package com.tencent.timi.game.ui.widget;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/ui/widget/m;", "Lcom/tencent/timi/game/ui/widget/l;", "Lcom/tencent/timi/game/ui/widget/k;", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "j0", "", "text", "", "K", "hideLoadingView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class m extends l implements k {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void K(@NotNull String text) {
        boolean z16;
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            text = this.G.getString(R.string.f23156727);
            Intrinsics.checkNotNullExpressionValue(text, "context.getString(R.stri\u2026ame_loading_hint_default)");
        }
        TimiGamePageLoadingView j06 = j0();
        if (j06 != null) {
            j06.setHintText(text);
        }
        TimiGamePageLoadingView j07 = j0();
        if (j07 != null) {
            j07.d();
        }
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void hideLoadingView() {
        TimiGamePageLoadingView j06 = j0();
        if (j06 != null) {
            j06.c();
        }
    }

    @Nullable
    public abstract TimiGamePageLoadingView j0();
}
