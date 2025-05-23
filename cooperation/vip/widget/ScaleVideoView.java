package cooperation.vip.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ScaleVideoView extends TextureVideoView {

    /* renamed from: e0, reason: collision with root package name */
    private Matrix f391418e0;

    public ScaleVideoView(Context context) {
        super(context);
        this.f391418e0 = new Matrix();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.playvideo.player.TextureVideoView, android.view.View
    public void onMeasure(int i3, int i16) {
        int defaultSize = View.getDefaultSize(this.E, i3);
        int defaultSize2 = View.getDefaultSize(this.F, i16);
        setMeasuredDimension(defaultSize, defaultSize2);
        float f16 = (defaultSize * 1.0f) / this.E;
        float f17 = (defaultSize2 * 1.0f) / this.F;
        float max = Math.max(f16, f17);
        this.f391418e0.setScale(max / f16, max / f17, defaultSize / 2, defaultSize2 / 2);
        setTransform(this.f391418e0);
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f391418e0 = new Matrix();
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f391418e0 = new Matrix();
    }
}
