package com.tencent.state.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquarePagFileHandler;
import com.tencent.state.square.api.ISquarePagView;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J?\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2%\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0002J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013JE\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2%\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fJE\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2%\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fJE\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2%\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/utils/SquarePagViewUtils;", "", "()V", "TAG", "", "doPlayFile", "", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "repeatCount", "", "onLoaded", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "squarePagView", InnerWebView.API_DOWNLOAD_IMAGE, "Landroid/graphics/Bitmap;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadPag", "playFile", "rawId", "path", "playUrl", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquarePagViewUtils {
    public static final SquarePagViewUtils INSTANCE = new SquarePagViewUtils();
    private static final String TAG = "SquarePagViewUtils";

    SquarePagViewUtils() {
    }

    private final void doPlayFile(ISquarePagView pagView, final int repeatCount, final Function1<? super ISquarePagView, Unit> onLoaded) {
        pagView.setPagFileHandler(new ISquarePagFileHandler() { // from class: com.tencent.state.utils.SquarePagViewUtils$doPlayFile$1
            @Override // com.tencent.state.square.api.ISquarePagFileHandler
            public void onPagFileLoaded(ISquarePagView squarePagView) {
                SquareBaseKt.getSquareLog().d("SquarePagViewUtils", "onPagFileLoaded");
                Function1 function1 = Function1.this;
                if (function1 != null) {
                }
            }
        });
        final WeakReference weakReference = new WeakReference(pagView);
        pagView.preparePagRuntime(new Function1<Boolean, Unit>() { // from class: com.tencent.state.utils.SquarePagViewUtils$doPlayFile$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ISquarePagView iSquarePagView;
                SquareBaseKt.getSquareLog().d("SquarePagViewUtils", "ready:" + z16);
                if (!z16 || (iSquarePagView = (ISquarePagView) weakReference.get()) == null) {
                    return;
                }
                iSquarePagView.playPag(repeatCount);
            }
        });
    }

    public final Object downloadImage(final String str, Continuation<? super Bitmap> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        DownloadUtils.INSTANCE.downloadFile(str, new SimpleDownloadListener() { // from class: com.tencent.state.utils.SquarePagViewUtils$downloadImage$$inlined$suspendCoroutine$lambda$1
            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().d("SquarePagViewUtils", "onTaskFailed, " + errorCode + ", " + errorMessage + ", url:" + str);
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                if (booleanRef2.element) {
                    return;
                }
                booleanRef2.element = true;
                safeContinuation.resumeWith(Result.m476constructorimpl(null));
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                Bitmap bitmap;
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                SquareBaseKt.getSquareLog().d("SquarePagViewUtils", "onTaskSuccess, " + resultFile.getAbsolutePath() + ", url: " + str);
                try {
                    bitmap = BitmapFactory.decodeFile(resultFile.getAbsolutePath());
                } catch (Exception e16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquarePagViewUtils", "decodeFile error " + e16, null, 4, null);
                    bitmap = null;
                }
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                if (booleanRef2.element) {
                    return;
                }
                booleanRef2.element = true;
                safeContinuation.resumeWith(Result.m476constructorimpl(bitmap));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object downloadPag(final String str, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        DownloadUtils.INSTANCE.downloadFile(str, new SimpleDownloadListener() { // from class: com.tencent.state.utils.SquarePagViewUtils$downloadPag$$inlined$suspendCoroutine$lambda$1
            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().d("SquarePagViewUtils", "onTaskFailed, " + errorCode + ", " + errorMessage + ", url:" + str);
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                if (booleanRef2.element) {
                    return;
                }
                booleanRef2.element = true;
                safeContinuation.resumeWith(Result.m476constructorimpl(null));
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                SquareBaseKt.getSquareLog().d("SquarePagViewUtils", "onTaskSuccess, " + resultFile.getAbsolutePath() + ", url: " + str);
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                if (booleanRef2.element) {
                    return;
                }
                booleanRef2.element = true;
                safeContinuation.resumeWith(Result.m476constructorimpl(resultFile.getAbsolutePath()));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void playFile(ISquarePagView pagView, String path, int repeatCount, Function1<? super ISquarePagView, Unit> onLoaded) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        Intrinsics.checkNotNullParameter(path, "path");
        pagView.setPagFile(path);
        doPlayFile(pagView, repeatCount, onLoaded);
    }

    public final void playUrl(ISquarePagView pagView, String url, int repeatCount, Function1<? super ISquarePagView, Unit> onLoaded) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        Intrinsics.checkNotNullParameter(url, "url");
        DownloadUtils.INSTANCE.downloadFile(url, new SquarePagViewUtils$playUrl$1(url, pagView, repeatCount, onLoaded));
    }

    public final void playFile(ISquarePagView pagView, int rawId, int repeatCount, Function1<? super ISquarePagView, Unit> onLoaded) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        pagView.setPagFile(rawId);
        doPlayFile(pagView, repeatCount, onLoaded);
    }
}
