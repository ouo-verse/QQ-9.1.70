package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/timi/game/ui/widget/i;", "Lcom/tencent/timi/game/ui/widget/a;", "Lcom/tencent/timi/game/ui/widget/k;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "U", ExifInterface.LATITUDE_SOUTH, "onBackPressed", "", "text", "K", "hideLoadingView", "Landroid/view/View;", "bgView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "L", "Landroidx/constraintlayout/widget/ConstraintLayout;", "contentView", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "M", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "loadingView", "", "N", "Z", "backPressEnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class i extends a implements k {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private View bgView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private ConstraintLayout contentView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private TimiGamePageLoadingView loadingView;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean backPressEnable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setContentView(View.inflate(context, R.layout.hxp, null));
        View findViewById = findViewById(R.id.t67);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.bgView)");
        this.bgView = findViewById;
        View findViewById2 = findViewById(R.id.b9r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.contentView)");
        this.contentView = (ConstraintLayout) findViewById2;
        View findViewById3 = findViewById(R.id.ef6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.loadingView)");
        this.loadingView = (TimiGamePageLoadingView) findViewById3;
        this.contentView.setVisibility(8);
        this.bgView.setVisibility(8);
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
        this.loadingView.setHintText(text);
        this.loadingView.d();
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    /* renamed from: S, reason: from getter */
    public View getBgView() {
        return this.bgView;
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    public View U() {
        return this.contentView;
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void hideLoadingView() {
        TimiGamePageLoadingView timiGamePageLoadingView = this.loadingView;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.c();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.backPressEnable) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.a, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.tencent.timi.game.utils.u.e(getWindow());
    }
}
