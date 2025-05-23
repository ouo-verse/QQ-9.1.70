package com.qzone.proxy.feedcomponent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.image.view.AsyncImageView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AsynAutoGifImageView extends AsyncImageView implements AutoGifDrawable.AutoGifCallback {

    /* renamed from: d, reason: collision with root package name */
    AutoGifDrawable f50913d;

    /* renamed from: e, reason: collision with root package name */
    a f50914e;

    /* renamed from: f, reason: collision with root package name */
    String f50915f;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        boolean isListViewScrollIdle();
    }

    public AsynAutoGifImageView(Context context) {
        super(context);
    }

    public void b() {
        AutoGifDrawable autoGifDrawable = this.f50913d;
        if (autoGifDrawable != null) {
            autoGifDrawable.recycled();
            this.f50913d = null;
            this.f50914e = null;
        }
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public void invalidateGifView() {
        invalidate();
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public boolean isListViewScrollIdle() {
        a aVar = this.f50914e;
        return aVar != null && aVar.isListViewScrollIdle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        AutoGifDrawable autoGifDrawable = this.f50913d;
        if (autoGifDrawable == null || !autoGifDrawable.draw(canvas, getWidth(), getHeight())) {
            super.onDraw(canvas);
        }
    }

    public void onStateIdle() {
        AutoGifDrawable autoGifDrawable = this.f50913d;
        if (autoGifDrawable != null) {
            autoGifDrawable.start();
        }
    }

    public AsynAutoGifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AsynAutoGifImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void setAsynGifImage(String str, a aVar) {
        if (str == null) {
            b();
            return;
        }
        String str2 = this.f50915f;
        if (str2 == null || !str2.equals(str) || this.f50913d == null) {
            this.f50915f = str;
            this.f50914e = aVar;
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            getAsyncOptions().fillOptions(obtain);
            AutoGifDrawable autoGifDrawable = this.f50913d;
            if (autoGifDrawable != null) {
                autoGifDrawable.recycled();
            }
            AutoGifDrawable newAutoGifDrawable = AutoGifDrawable.newAutoGifDrawable();
            this.f50913d = newAutoGifDrawable;
            newAutoGifDrawable.init(str, obtain, getContext(), this);
        }
    }
}
