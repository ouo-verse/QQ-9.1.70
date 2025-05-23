package com.tencent.biz.qqcircle.widgets.button;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cd;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSPressEffectLinearLayout;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase$StPublisherButton;

/* loaded from: classes5.dex */
public class QCirclePolymerizationBottomButton extends QFSPressEffectLinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private final RectF f93544d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f93545e;

    /* renamed from: f, reason: collision with root package name */
    private final Path f93546f;

    /* renamed from: h, reason: collision with root package name */
    private int f93547h;

    /* loaded from: classes5.dex */
    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(QCirclePolymerizationBottomButton.this.f93545e, QCirclePolymerizationBottomButton.this.f93547h);
        }
    }

    public QCirclePolymerizationBottomButton(Context context) {
        super(context);
        this.f93544d = new RectF();
        this.f93545e = new Rect();
        this.f93546f = new Path();
        this.f93547h = cx.a(4.0f);
    }

    private void c(int i3, int i16) {
        this.f93546f.reset();
        this.f93544d.set(0.0f, 0.0f, i3, i16);
        Path path = this.f93546f;
        RectF rectF = this.f93544d;
        int i17 = this.f93547h;
        path.addRoundRect(rectF, i17, i17, Path.Direction.CW);
        this.f93545e.set(0, 0, i3, i16);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        c(i3, i16);
    }

    public void setData(QQCircleFeedBase$StPublisherButton qQCircleFeedBase$StPublisherButton) {
        if (qQCircleFeedBase$StPublisherButton == null) {
            return;
        }
        if (getChildCount() < 2) {
            QLog.e("QCirclePolymerizationBottomButton", 1, "view child < 2");
            return;
        }
        cd.c((ImageView) getChildAt(0), qQCircleFeedBase$StPublisherButton.iconURL.get());
        TextView textView = (TextView) getChildAt(1);
        textView.setText(qQCircleFeedBase$StPublisherButton.title.get());
        cd.d(textView, qQCircleFeedBase$StPublisherButton.fontColor.get());
        cd.b(this, qQCircleFeedBase$StPublisherButton.bgColor.get());
    }

    public void setRadius(int i3) {
        this.f93547h = i3;
        c(getWidth(), getHeight());
        postInvalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    public QCirclePolymerizationBottomButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93544d = new RectF();
        this.f93545e = new Rect();
        this.f93546f = new Path();
        this.f93547h = cx.a(4.0f);
        setClipToOutline(true);
        setOutlineProvider(new a());
    }
}
