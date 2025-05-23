package com.tencent.mobileqq.activity.qcircle.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\u0004\u0018\u00010\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ+\u0010\r\u001a\u0004\u0018\u00010\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/utils/QCircleDrawableUtil;", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "drawableHost", "", PhotoCategorySummaryInfo.AVATAR_URL, "uin", "Landroid/graphics/drawable/Drawable;", "a", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QCircleDrawableUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QCircleDrawableUtil f184596a = new QCircleDrawableUtil();

    QCircleDrawableUtil() {
    }

    @Nullable
    public final Object a(@NotNull WeakReference<View> weakReference, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super Drawable> continuation) {
        boolean z16;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return c(weakReference, str, continuation);
        }
        return b(weakReference, str2, continuation);
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.tencent.mobileqq.app.face.FaceDrawable, T] */
    @Nullable
    public final Object b(@NotNull WeakReference<View> weakReference, @NotNull String str, @NotNull Continuation<? super Drawable> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.i("QCircleTabRedPoint-DrawableUtil", 1, "getAvatarDrawableByUin, uin = " + str);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = FaceDrawable.getFaceDrawable(c.c(), 1, 4, str, new FaceDrawable.OnLoadingStateChangeListener() { // from class: com.tencent.mobileqq.activity.qcircle.utils.QCircleDrawableUtil$getAvatarDrawableByUin$2$1
            @Override // com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener
            public final void onLoadingStateChanged(int i3, int i16) {
                QLog.i("QCircleTabRedPoint-DrawableUtil", 1, "getAvatarDrawableByUin stateChange, curState=" + i16 + ", oldState=" + i3 + ", hasResume=" + Ref.BooleanRef.this.element);
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                if (booleanRef2.element) {
                    return;
                }
                if (i16 != 1) {
                    if (i16 == 2) {
                        booleanRef2.element = true;
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
                        return;
                    }
                    return;
                }
                booleanRef2.element = true;
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Ref.ObjectRef<FaceDrawable> objectRef2 = objectRef;
                final CancellableContinuation<Drawable> cancellableContinuation = cancellableContinuationImpl;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.utils.QCircleDrawableUtil$getAvatarDrawableByUin$2$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Bitmap bitmap;
                        FaceDrawable faceDrawable = objectRef2.element;
                        if (faceDrawable != null) {
                            bitmap = faceDrawable.getLoadedBitmap();
                        } else {
                            bitmap = null;
                        }
                        if (bitmap == null) {
                            QLog.e("QCircleTabRedPoint-DrawableUtil", 1, "getAvatarDrawableByUin, loadedBitmap == null");
                        }
                        CancellableContinuation<Drawable> cancellableContinuation2 = cancellableContinuation;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m476constructorimpl(objectRef2.element));
                    }
                });
            }
        });
        View view = weakReference.get();
        if (view != null) {
            view.setTag(R.id.f32250t9, objectRef.element);
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object c(@NotNull WeakReference<View> weakReference, @NotNull final String str, @NotNull Continuation<? super Drawable> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.i("QCircleTabRedPoint-DrawableUtil", 1, "getDrawable, url = " + str);
        final URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
        if (drawable.getStatus() == 1) {
            QLog.i("QCircleTabRedPoint-DrawableUtil", 1, "getDrawable, memoryCache, url = " + str);
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(drawable.getCurrDrawable()));
        } else {
            drawable.setURLDrawableListener(new a(str, drawable, cancellableContinuationImpl));
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.utils.QCircleDrawableUtil$getDrawable$2$2
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.i("QCircleTabRedPoint-DrawableUtil", 1, "getDrawable, startDownload by urlDrawable, url = " + str);
                    drawable.downloadImediatly();
                }
            }, 16, null, false);
            View view = weakReference.get();
            if (view != null) {
                view.setTag(R.id.f32250t9, drawable);
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/activity/qcircle/utils/QCircleDrawableUtil$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "progress", "", "onLoadProgressed", "onLoadSuccessed", "onLoadCanceled", "", "throwable", "onLoadFialed", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f184597d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f184598e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Drawable> f184599f;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, URLDrawable uRLDrawable, CancellableContinuation<? super Drawable> cancellableContinuation) {
            this.f184597d = str;
            this.f184598e = uRLDrawable;
            this.f184599f = cancellableContinuation;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            QLog.e("QCircleTabRedPoint-DrawableUtil", 1, "getDrawable, onLoadCanceled, url = " + this.f184597d);
            this.f184598e.setURLDrawableListener(null);
            this.f184599f.resumeWith(Result.m476constructorimpl(null));
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable throwable) {
            QLog.e("QCircleTabRedPoint-DrawableUtil", 1, throwable, "getDrawable,  onLoadFailed, url = " + this.f184597d);
            this.f184598e.setURLDrawableListener(null);
            this.f184599f.resumeWith(Result.m476constructorimpl(null));
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            QLog.i("QCircleTabRedPoint-DrawableUtil", 1, "getDrawable,  onLoadSuccessed, url = " + this.f184597d);
            this.f184598e.setURLDrawableListener(null);
            CancellableContinuation<Drawable> cancellableContinuation = this.f184599f;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(this.f184598e.getCurrDrawable()));
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
        }
    }
}
