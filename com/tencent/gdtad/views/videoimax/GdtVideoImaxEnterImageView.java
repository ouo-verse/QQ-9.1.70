package com.tencent.gdtad.views.videoimax;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.gdtad.log.GdtLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
public final class GdtVideoImaxEnterImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private Rect f109726d;

    public GdtVideoImaxEnterImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        GdtLog.d("GdtVideoImaxEnterImageView", "onDraw() called with: hashcode = " + System.identityHashCode(this));
        if (this.f109726d != null) {
            int save = canvas.save();
            canvas.clipRect(this.f109726d);
            super.onDraw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.onDraw(canvas);
    }

    public GdtVideoImaxEnterImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
