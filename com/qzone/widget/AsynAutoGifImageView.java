package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AsynAutoGifImageView extends AsyncImageView implements AutoGifDrawable.AutoGifCallback {

    /* renamed from: h, reason: collision with root package name */
    static int f60154h = (int) (ViewUtils.getDensity() * 75.0f);

    /* renamed from: d, reason: collision with root package name */
    private AutoGifDrawable f60155d;

    /* renamed from: e, reason: collision with root package name */
    private a f60156e;

    /* renamed from: f, reason: collision with root package name */
    public String f60157f;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        boolean isListViewScrollIdle();
    }

    public AsynAutoGifImageView(Context context) {
        super(context);
    }

    public AutoGifDrawable f() {
        return this.f60155d;
    }

    public void g() {
        AutoGifDrawable autoGifDrawable = this.f60155d;
        if (autoGifDrawable != null) {
            autoGifDrawable.recycled();
            this.f60155d = null;
            this.f60156e = null;
        }
    }

    public void h() {
        AutoGifDrawable autoGifDrawable = this.f60155d;
        if (autoGifDrawable != null) {
            autoGifDrawable.start();
        }
    }

    public void i() {
        AutoGifDrawable autoGifDrawable = this.f60155d;
        if (autoGifDrawable != null) {
            autoGifDrawable.stop();
        }
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public void invalidateGifView() {
        invalidate();
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public boolean isListViewScrollIdle() {
        a aVar = this.f60156e;
        return aVar != null && aVar.isListViewScrollIdle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        AutoGifDrawable autoGifDrawable = this.f60155d;
        if (autoGifDrawable == null || !autoGifDrawable.draw(canvas, getWidth(), getHeight())) {
            super.onDraw(canvas);
        }
    }

    public void setAsynGifImage(String str, a aVar, AutoGifDrawable.GifDownloadCallBackListener gifDownloadCallBackListener) {
        if (str == null) {
            g();
            return;
        }
        String str2 = this.f60157f;
        if (str2 == null || !str2.equals(str) || this.f60155d == null) {
            this.f60157f = str;
            this.f60156e = aVar;
            this.f60155d = AutoGifDrawable.newAutoGifDrawable();
            this.f60155d.init(str, getImageOption(), getContext(), this, gifDownloadCallBackListener);
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
            g();
            return;
        }
        String str2 = this.f60157f;
        if (str2 == null || !str2.equals(str) || this.f60155d == null) {
            this.f60157f = str;
            this.f60156e = aVar;
            this.f60155d = AutoGifDrawable.newAutoGifDrawable();
            this.f60155d.init(str, getImageOption(), getContext(), this);
        }
    }
}
