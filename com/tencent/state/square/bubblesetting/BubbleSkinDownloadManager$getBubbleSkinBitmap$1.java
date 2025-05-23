package com.tencent.state.square.bubblesetting;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BubbleSkinDownloadManager$getBubbleSkinBitmap$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ String $url;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/state/square/bubblesetting/BubbleSkinDownloadManager$getBubbleSkinBitmap$1$1", "Lcom/tencent/state/service/ResultCallback;", "Ljava/io/File;", "onResultSuccess", "", "result", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager$getBubbleSkinBitmap$1$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass1 implements ResultCallback<File> {
        AnonymousClass1() {
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int i3, String str) {
            ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int i3, String str, String str2) {
            ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultSuccess(final File result) {
            Intrinsics.checkNotNullParameter(result, "result");
            SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager$getBubbleSkinBitmap$1$1$onResultSuccess$1
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
                    final Bitmap bitmap;
                    try {
                        String absolutePath = result.getAbsolutePath();
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inScaled = false;
                        Unit unit = Unit.INSTANCE;
                        bitmap = BitmapFactory.decodeFile(absolutePath, options);
                    } catch (Exception e16) {
                        SquareBaseKt.getSquareLog().e("BubbleSkinDownloadManager", "decodeFile error " + result.getAbsolutePath(), e16);
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "BubbleSkinDownloadManager", "decodeFile error, bitmap is null " + result.getAbsolutePath(), null, 4, null);
                        return;
                    }
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager$getBubbleSkinBitmap$1$1$onResultSuccess$1.1
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
                            BubbleSkinDownloadManager$getBubbleSkinBitmap$1.this.$callback.invoke(bitmap);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleSkinDownloadManager$getBubbleSkinBitmap$1(String str, Function1 function1) {
        super(0);
        this.$url = str;
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BubbleSkinDownloadManager.INSTANCE.downloadBubbleSkin(this.$url, new AnonymousClass1());
    }
}
