package com.tencent.icgame.game.ui.widget;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/icgame/game/ui/widget/i;", "Lcom/tencent/icgame/game/ui/widget/o;", "", "show", "dismiss", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class i extends o {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.icgame.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Y();
    }

    @Override // com.tencent.icgame.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        e0();
    }
}
