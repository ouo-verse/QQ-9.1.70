package com.tencent.state.square.avatar.filament;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.state.square.avatar.PlayerSourceHelper;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.view.CommonDialog;
import com.tencent.state.view.CommonDialogData;
import com.tencent.state.view.ContentStyle;
import com.tencent.state.view.ResStyle;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAvatarFilamentView$renderFailTips$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SquareAvatarFilamentView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAvatarFilamentView$renderFailTips$1(SquareAvatarFilamentView squareAvatarFilamentView) {
        super(0);
        this.this$0 = squareAvatarFilamentView;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WeakReference weakReference;
        WeakReference weakReference2;
        MapPlayableSource mapPlayableSource;
        weakReference = this.this$0.weakContext;
        Context ctx = (Context) weakReference.get();
        if (ctx != null) {
            weakReference2 = this.this$0.weakImageView;
            SquareImageView image = (SquareImageView) weakReference2.get();
            if (image != null) {
                PlayerSourceHelper playerSourceHelper = PlayerSourceHelper.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(image, "image");
                mapPlayableSource = this.this$0.currentSource;
                playerSourceHelper.setStaticImage(image, mapPlayableSource, "");
            }
            Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
            CommonDialog commonDialog = new CommonDialog(ctx, new CommonDialogData(new ResStyle(null, null, null, 0, 0, null, null, null, Integer.valueOf(R.drawable.f159800gs0), 254, null), "\u5f62\u8c61\u52a0\u8f7d\u5931\u8d25", "\u53d6\u6d88", "\u91cd\u8bd5", null, new ContentStyle("\u51fa\u4e86\u70b9\u95ee\u9898\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff5e", 0.0f, 0, false, 17, null, null, 110, null), null, false, null, false, 960, null));
            commonDialog.show();
            commonDialog.setDismissCallback(new SquareAvatarFilamentView$renderFailTips$1$$special$$inlined$let$lambda$1(this));
        }
    }
}
