package com.tencent.aelight.camera.ae.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: classes32.dex */
public class AEAlbumPreviewMaskLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f62003d;

    /* loaded from: classes32.dex */
    public interface a {
        void c();
    }

    public AEAlbumPreviewMaskLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return true;
        }
        a aVar = this.f62003d;
        if (aVar != null) {
            aVar.c();
        }
        ms.a.a("AEAlbumPreviewMaskLayout", "[onTouchEvent], action=ACTION_DOWN");
        return true;
    }

    public void setOnTouchCallback(a aVar) {
        this.f62003d = aVar;
    }

    public AEAlbumPreviewMaskLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AEAlbumPreviewMaskLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
