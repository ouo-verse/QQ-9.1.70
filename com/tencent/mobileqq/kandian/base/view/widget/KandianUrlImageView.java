package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.kandian.base.image.imageloader.b;

/* compiled from: P */
/* loaded from: classes15.dex */
public class KandianUrlImageView extends ResizeURLImageView {
    private boolean mIsRecyclerView;
    private a mVisibilityChangedListener;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
    }

    public KandianUrlImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (!this.mIsRecyclerView) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i3) {
        super.onVisibilityChanged(view, i3);
    }

    public void release() {
        b bVar = this.mController;
        if (bVar != null) {
            bVar.f("onKandianUrlImageView release");
        }
    }

    public void setIsRecyclerView(boolean z16) {
        this.mIsRecyclerView = z16;
    }

    public KandianUrlImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KandianUrlImageView(Context context) {
        super(context);
    }

    public void setVisibilityChangedListener(a aVar) {
    }
}
