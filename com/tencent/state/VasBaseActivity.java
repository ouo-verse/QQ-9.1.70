package com.tencent.state;

import android.view.Window;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/VasBaseActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "()V", "isWrapContent", "", "onPostThemeChanged", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class VasBaseActivity extends QBaseActivity {
    private static final String TAG = "VasBaseActivity";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        SquareBaseKt.getSquareLog().i(TAG, "onPostThemeChanged");
        SquareBaseKt.getSquareCommon().setImmersiveStatus(this, 0);
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        window.setNavigationBarColor(-1);
    }
}
