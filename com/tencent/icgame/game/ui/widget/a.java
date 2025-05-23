package com.tencent.icgame.game.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cy0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/icgame/game/ui/widget/a;", "Lcom/tencent/icgame/game/ui/widget/h;", "", "U", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "show", "dismiss", "", "I", "Z", "mIsAnimatingDismiss", "J", "mNeedDismissAni", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class a extends h {

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsAnimatingDismiss;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mNeedDismissAni;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/ui/widget/a$a", "Lcy0/a$d;", "Landroid/view/View;", "view", "", "onAnimationStart", "", "percent", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.ui.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5846a implements a.d {
        C5846a() {
        }

        @Override // cy0.a.d
        public void a(@NotNull View view, float percent) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // cy0.a.d
        public void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            a.this.U();
            a.this.mIsAnimatingDismiss = false;
        }

        @Override // cy0.a.d
        public void onAnimationStart(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context) {
        super(context, R.style.au5);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mNeedDismissAni = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        try {
            super.dismiss();
        } catch (Exception e16) {
            com.tencent.icgame.game.utils.g.e("CommonDialog", "onAnimationFinish dismiss error", e16);
        }
    }

    @NotNull
    public abstract View R();

    @NotNull
    public abstract View S();

    @Override // com.tencent.icgame.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mIsAnimatingDismiss) {
            return;
        }
        if (!this.mNeedDismissAni) {
            U();
            return;
        }
        this.mIsAnimatingDismiss = true;
        cy0.a.c(R());
        cy0.a.b(S(), new C5846a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.icgame.game.ui.widget.h, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setStatusBarColor(Color.parseColor("#4C000000"));
        }
    }

    @Override // com.tencent.icgame.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        cy0.a.d(S());
        cy0.a.e(R());
    }
}
