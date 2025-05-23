package com.tencent.mobileqq.onlinestatus.processor;

import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/processor/c;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/onlinestatus/processor/URLColorThemeProcessor;", "d", "Lmqq/util/WeakReference;", "mRef", "a", "()Lcom/tencent/mobileqq/onlinestatus/processor/URLColorThemeProcessor;", "processor", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/processor/URLColorThemeProcessor;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements URLDrawable.URLDrawableListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<URLColorThemeProcessor> mRef;

    public c(@NotNull URLColorThemeProcessor processor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        this.mRef = new WeakReference<>(processor);
    }

    private final URLColorThemeProcessor a() {
        return this.mRef.get();
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(@Nullable URLDrawable drawable) {
        URL url;
        if (drawable != null) {
            url = drawable.getURL();
        } else {
            url = null;
        }
        QLog.d("URLColorThemeProcessor", 1, "onLoadCanceled url: " + url + "\n");
        URLColorThemeProcessor a16 = a();
        if (a16 != null) {
            a16.k();
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable throwable) {
        URL url;
        if (drawable != null) {
            url = drawable.getURL();
        } else {
            url = null;
        }
        QLog.e("URLColorThemeProcessor", 1, "onLoadFailed url: " + url + "\n", throwable);
        URLColorThemeProcessor a16 = a();
        if (a16 != null) {
            a16.k();
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(@Nullable URLDrawable drawable) {
        if (drawable == null) {
            QLog.e("URLColorThemeProcessor", 1, "Load success but no drawable!!");
            return;
        }
        URLColorThemeProcessor a16 = a();
        if (a16 != null) {
            a16.l(drawable);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
    }
}
