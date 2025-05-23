package com.tencent.state.square.avatar.filament;

import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.IAvatarAnimView;
import com.tencent.state.square.media.MapPlayableSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "btnId", "", "invoke", "com/tencent/state/square/avatar/filament/SquareAvatarFilamentView$renderFailTips$1$1$2"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAvatarFilamentView$renderFailTips$1$$special$$inlined$let$lambda$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ SquareAvatarFilamentView$renderFailTips$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAvatarFilamentView$renderFailTips$1$$special$$inlined$let$lambda$1(SquareAvatarFilamentView$renderFailTips$1 squareAvatarFilamentView$renderFailTips$1) {
        super(1);
        this.this$0 = squareAvatarFilamentView$renderFailTips$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r4 = r3.this$0.this$0.currentSource;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(int i3) {
        final MapPlayableSource mapPlayableSource;
        if (i3 != 2 || mapPlayableSource == null) {
            return;
        }
        FilamentZipFileUtils.INSTANCE.deleteCacheFile(mapPlayableSource.getRemoteUrl(), new Function0<Unit>() { // from class: com.tencent.state.square.avatar.filament.SquareAvatarFilamentView$renderFailTips$1$$special$$inlined$let$lambda$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.filament.SquareAvatarFilamentView$renderFailTips$1$$special$.inlined.let.lambda.1.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        IAvatarAnimView.DefaultImpls.setAnimSource$default(this.this$0.this$0, MapPlayableSource.this, null, false, 4, null);
                    }
                });
            }
        });
    }
}
