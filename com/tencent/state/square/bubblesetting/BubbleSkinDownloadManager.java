package com.tencent.state.square.bubblesetting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.DefaultDownloadListener;
import com.tencent.state.square.IHttpDownloader;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.zplan.common.utils.d;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J$\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/bubblesetting/BubbleSkinDownloadManager;", "", "()V", "TAG", "", "downloadBubbleSkin", "", "url", "callback", "Lcom/tencent/state/service/ResultCallback;", "Ljava/io/File;", "getBubbleSkinBitmap", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "loadBubbleNinePatchDrawable", "context", "Landroid/content/Context;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BubbleSkinDownloadManager {
    public static final BubbleSkinDownloadManager INSTANCE = new BubbleSkinDownloadManager();
    private static final String TAG = "BubbleSkinDownloadManager";

    BubbleSkinDownloadManager() {
    }

    public final void getBubbleSkinBitmap(String url, Function1<? super Bitmap, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "find new bubble skin url:" + url);
        SquareBaseKt.getSquareThread().postOnFileThread(new BubbleSkinDownloadManager$getBubbleSkinBitmap$1(url, callback));
    }

    public final void loadBubbleNinePatchDrawable(final Context context, final Function1<? super Bitmap, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager$loadBubbleNinePatchDrawable$1
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
                Resources resources = context.getResources();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                Unit unit = Unit.INSTANCE;
                final Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.i8y, options);
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager$loadBubbleNinePatchDrawable$1.1
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
                        Function1 function1 = callback;
                        Bitmap bitmap = decodeResource;
                        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                        function1.invoke(bitmap);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadBubbleSkin(String url, final ResultCallback<File> callback) {
        if (url == null || url.length() == 0) {
            callback.onResultFailure(-1, "link is not valid URL");
            return;
        }
        SquareBase squareBase = SquareBase.INSTANCE;
        File file = new File(squareBase.getConfig().getRootCacheDir(), "bubble");
        if (!file.exists()) {
            file.mkdir();
        }
        final String str = d.c(url) + ".jpg";
        File file2 = new File(file, str);
        if (file2.exists()) {
            SquareBaseKt.getSquareLog().i(TAG, str + " exists");
            callback.onResultSuccess(file2);
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "startDownload " + str);
        String absolutePath = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "bubbleFile.absolutePath");
        squareBase.getConfig().getDownloader().download(new IHttpDownloader.Task(url, absolutePath), new DefaultDownloadListener() { // from class: com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager$downloadBubbleSkin$1
            @Override // com.tencent.state.square.DefaultDownloadListener, com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().i("BubbleSkinDownloadManager", "onTaskFailed " + str + TokenParser.SP + errorCode + TokenParser.SP + errorMessage);
                callback.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.state.square.DefaultDownloadListener, com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                SquareBaseKt.getSquareLog().i("BubbleSkinDownloadManager", "onTaskSuccess " + str);
                callback.onResultSuccess(resultFile);
            }
        });
    }
}
