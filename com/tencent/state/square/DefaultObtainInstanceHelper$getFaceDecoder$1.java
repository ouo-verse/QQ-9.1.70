package com.tencent.state.square;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"com/tencent/state/square/DefaultObtainInstanceHelper$getFaceDecoder$1", "Lcom/tencent/state/square/api/IFaceDecoder;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "destroy", "", "getBitmapFromCache", "Landroid/graphics/Bitmap;", "uin", "", "isTroop", "", "requestDecodeFace", "setDecodeTaskCompletionListener", "listener", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultObtainInstanceHelper$getFaceDecoder$1 implements IFaceDecoder {
    private final CopyOnWriteArraySet<IDecodeTaskCompletionListener> listeners = new CopyOnWriteArraySet<>();

    @Override // com.tencent.state.square.api.IFaceDecoder
    public void destroy() {
        this.listeners.clear();
    }

    @Override // com.tencent.state.square.api.IFaceDecoder
    @Nullable
    public Bitmap getBitmapFromCache(@NotNull String uin, boolean isTroop) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return null;
    }

    @Override // com.tencent.state.square.api.IFaceDecoder
    public boolean requestDecodeFace(@NotNull final String uin, boolean isTroop) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.DefaultObtainInstanceHelper$getFaceDecoder$1$requestDecodeFace$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                final Bitmap createBitmap = Bitmap.createBitmap(20, 20, Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap).drawColor(-7829368);
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.DefaultObtainInstanceHelper$getFaceDecoder$1$requestDecodeFace$1.2
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
                        CopyOnWriteArraySet copyOnWriteArraySet;
                        copyOnWriteArraySet = DefaultObtainInstanceHelper$getFaceDecoder$1.this.listeners;
                        Iterator it = copyOnWriteArraySet.iterator();
                        while (it.hasNext()) {
                            ((IDecodeTaskCompletionListener) it.next()).onDecodeTaskCompleted(-1, -1, uin, createBitmap);
                        }
                    }
                });
            }
        });
        return false;
    }

    @Override // com.tencent.state.square.api.IFaceDecoder
    public void setDecodeTaskCompletionListener(@NotNull IDecodeTaskCompletionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }
}
