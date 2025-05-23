package com.tencent.state.square.avatar;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.download.DownloadCallback;
import com.tencent.state.square.download.Source;
import com.tencent.state.square.download.TaskProgress;
import com.tencent.state.square.download.TaskResponse;
import com.tencent.state.square.media.MediaSource;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u00030\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/avatar/StaticSourceDownloadCallback;", "Lcom/tencent/state/square/download/DownloadCallback;", "view", "Landroid/widget/ImageView;", "source", "Lcom/tencent/state/square/media/MediaSource;", "failedDrawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/widget/ImageView;Lcom/tencent/state/square/media/MediaSource;Landroid/graphics/drawable/Drawable;)V", "weakRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onTaskFailed", "", "src", "Lcom/tencent/state/square/download/Source;", "response", "Lcom/tencent/state/square/download/TaskResponse;", "onTaskSuccess", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class StaticSourceDownloadCallback implements DownloadCallback {
    private static final String TAG = "StaticSourceDownloadCallback";
    private final Drawable failedDrawable;
    private final MediaSource source;
    private final WeakReference<ImageView> weakRef;

    public StaticSourceDownloadCallback(ImageView view, MediaSource source, Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.failedDrawable = drawable;
        this.weakRef = new WeakReference<>(view);
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskFailed(Source src, TaskResponse response) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(response, "response");
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "onTaskFailed Static: src:" + src + ", source" + this.source, null, 4, null);
        if (this.failedDrawable != null) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.StaticSourceDownloadCallback$onTaskFailed$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    WeakReference weakReference;
                    Drawable drawable;
                    weakReference = StaticSourceDownloadCallback.this.weakRef;
                    ImageView imageView = (ImageView) weakReference.get();
                    if (imageView != null) {
                        drawable = StaticSourceDownloadCallback.this.failedDrawable;
                        imageView.setImageDrawable(drawable);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskProgress(Source source, TaskResponse response, TaskProgress progress) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(progress, "progress");
        DownloadCallback.DefaultImpls.onTaskProgress(this, source, response, progress);
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskStart(Source source, TaskResponse response) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        DownloadCallback.DefaultImpls.onTaskStart(this, source, response);
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskSuccess(final Source src, TaskResponse response) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(response, "response");
        SquareBaseKt.getSquareLog().i(TAG, "download Static success: src:" + src + ", source" + this.source);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.StaticSourceDownloadCallback$onTaskSuccess$1
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
                WeakReference weakReference;
                weakReference = StaticSourceDownloadCallback.this.weakRef;
                ImageView imageView = (ImageView) weakReference.get();
                if (imageView != null) {
                    imageView.setImageDrawable(URLDrawable.getFileDrawable(src.getCachePath(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
                }
            }
        });
    }
}
