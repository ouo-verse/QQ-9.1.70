package com.tencent.timi.game.liveroom.impl.room.dynamicbg;

import android.graphics.Bitmap;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bottomBitmap", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class RoomDynamicBgViewModel$downloadBackgroundBitmap$2$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ RoomDynamicBgViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomDynamicBgViewModel$downloadBackgroundBitmap$2$1(RoomDynamicBgViewModel roomDynamicBgViewModel, Function1<? super Boolean, Unit> function1) {
        super(1);
        this.this$0 = roomDynamicBgViewModel;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RoomDynamicBgViewModel this$0, Bitmap bitmap, Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.bottomBitmap = bitmap;
        this$0.S1(callback);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final Bitmap bitmap) {
        AegisLogger.INSTANCE.d("room_info|RoomDynamicBgViewModel", "downloadBackgroundBitmap, result:" + bitmap);
        final RoomDynamicBgViewModel roomDynamicBgViewModel = this.this$0;
        final Function1<Boolean, Unit> function1 = this.$callback;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.dynamicbg.d
            @Override // java.lang.Runnable
            public final void run() {
                RoomDynamicBgViewModel$downloadBackgroundBitmap$2$1.b(RoomDynamicBgViewModel.this, bitmap, function1);
            }
        });
    }
}
