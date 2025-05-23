package com.tencent.mobileqq.activity.qcircle.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.manager.d;
import com.tencent.biz.qqcircle.immersive.utils.p;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qcircle.utils.c;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.List;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;
import y91.a;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QCircleAvatarListView extends ViewGroup {
    private int C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private int H;

    /* renamed from: d, reason: collision with root package name */
    private int f184624d;

    /* renamed from: e, reason: collision with root package name */
    private float f184625e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f184626f;

    /* renamed from: h, reason: collision with root package name */
    private int f184627h;

    /* renamed from: i, reason: collision with root package name */
    private int f184628i;

    /* renamed from: m, reason: collision with root package name */
    private int f184629m;

    public QCircleAvatarListView(Context context) {
        this(context, null);
    }

    private void a(@NonNull QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo, @NonNull FrameLayout frameLayout) {
        QLog.i("QCircleAvatarListView", 1, "addAuthIconView" + qQCircleCounterMsg$RedDisplayInfo.bitTypeCertification.get());
        if (qQCircleCounterMsg$RedDisplayInfo.bitTypeCertification.get() != 0) {
            SquareImageView squareImageView = new SquareImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f184629m, this.C);
            layoutParams.gravity = 8388693;
            layoutParams.rightMargin = this.D;
            layoutParams.bottomMargin = this.E;
            squareImageView.setLayoutParams(layoutParams);
            squareImageView.setRoundRect(90);
            frameLayout.addView(squareImageView);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(p.g(qQCircleCounterMsg$RedDisplayInfo.bitTypeCertification.get())).setRequestWidth(this.f184627h).setRequestHeight(this.f184628i).setTargetView(squareImageView));
        }
    }

    private void b(QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo, String str) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        int i3 = this.f184627h;
        int i16 = this.F;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(i3 + (i16 * 2), this.f184628i + (i16 * 2)));
        if (!TextUtils.isEmpty(str)) {
            SquareImageView squareImageView = new SquareImageView(getContext());
            int i17 = this.f184627h;
            int i18 = this.F;
            squareImageView.setLayoutParams(new FrameLayout.LayoutParams(i17 + (i18 * 2), this.f184628i + (i18 * 2), 17));
            squareImageView.setColorFilter(getContext().getResources().getColor(R.color.qvideo_skin_color_bg_default));
            frameLayout.addView(squareImageView);
            QCircleFeedPicLoader.g().loadImage(new Option().setTargetView(squareImageView).setRequestHeight(this.f184627h + (this.F * 2)).setRequestWidth(this.f184628i + (this.F * 2)).setUrl(str));
        } else if (this.G) {
            SquareImageView squareImageView2 = new SquareImageView(getContext());
            int i19 = this.f184627h;
            int i26 = this.F;
            squareImageView2.setLayoutParams(new FrameLayout.LayoutParams(i19 + (i26 * 2), this.f184628i + (i26 * 2), 17));
            squareImageView2.setRoundRect(this.f184624d);
            squareImageView2.setBackgroundColor(getContext().getResources().getColor(this.H));
            frameLayout.addView(squareImageView2);
        }
        SquareImageView squareImageView3 = new SquareImageView(getContext());
        squareImageView3.setLayoutParams(new FrameLayout.LayoutParams(this.f184627h, this.f184628i, 17));
        squareImageView3.setRoundRect(this.f184624d);
        frameLayout.addView(squareImageView3);
        if (!TextUtils.isEmpty(qQCircleCounterMsg$RedDisplayInfo.avatarURL.get())) {
            QCircleFeedPicLoader.g().loadImage(new Option().setTargetView(squareImageView3).setUrl(qQCircleCounterMsg$RedDisplayInfo.avatarURL.get()).setRequestWidth(this.f184627h).setRequestHeight(this.f184628i).setLoadingDrawable(d.c().d(R.drawable.ntp)).setFailDrawable(d.c().d(R.drawable.ntp)));
        } else {
            squareImageView3.setImageDrawable(FaceDrawable.getFaceDrawable(c.c(), 1, 4, qQCircleCounterMsg$RedDisplayInfo.headImg.get()));
        }
        a(qQCircleCounterMsg$RedDisplayInfo, frameLayout);
        addView(frameLayout);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QCircleAvatarListView);
        if (obtainStyledAttributes != null) {
            this.f184624d = obtainStyledAttributes.getInteger(R.styleable.QCircleAvatarListView_avatarRadius, 90);
            this.f184625e = obtainStyledAttributes.getFloat(R.styleable.QCircleAvatarListView_space, 0.8f);
            this.f184627h = (int) obtainStyledAttributes.getDimension(R.styleable.QCircleAvatarListView_avatarWidth, 30.0f);
            this.f184628i = (int) obtainStyledAttributes.getDimension(R.styleable.QCircleAvatarListView_avatarHeight, 30.0f);
            this.f184626f = obtainStyledAttributes.getBoolean(R.styleable.QCircleAvatarListView_reverseOrder, false);
            this.F = (int) obtainStyledAttributes.getDimension(R.styleable.QCircleAvatarListView_circleBackgroundPadding, 0.0f);
            this.G = obtainStyledAttributes.getBoolean(a.U4, false);
            this.H = obtainStyledAttributes.getResourceId(a.Q4, 0);
            this.f184629m = (int) obtainStyledAttributes.getDimension(a.K4, ViewUtils.dip2px(10.0f));
            this.C = (int) obtainStyledAttributes.getDimension(a.H4, ViewUtils.dip2px(10.0f));
            this.D = (int) obtainStyledAttributes.getDimension(a.J4, 0.0f);
            this.E = (int) obtainStyledAttributes.getDimension(a.I4, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        if (this.f184626f) {
            int i19 = i17 - i3;
            int i26 = childCount - 1;
            int i27 = i19;
            for (int i28 = i26; i28 >= 0; i28--) {
                View childAt = getChildAt(i26 - i28);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i28 == i26) {
                    i19 -= measuredWidth;
                } else {
                    i19 = (int) (i19 - (measuredWidth * this.f184625e));
                }
                childAt.layout(i19, 0, i27, measuredHeight);
                i27 = (int) (i27 - (measuredWidth * this.f184625e));
            }
            return;
        }
        int i29 = 0;
        int i36 = 0;
        for (int i37 = 0; i37 < childCount; i37++) {
            View childAt2 = getChildAt(i37);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            if (i37 == 0) {
                i29 += measuredWidth2;
            } else {
                i29 = (int) (i29 + (measuredWidth2 * this.f184625e));
            }
            childAt2.layout(i36, 0, i29, measuredHeight2);
            i36 = (int) (i36 + (measuredWidth2 * this.f184625e));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i16);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int childCount = getChildCount();
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            measureChild(childAt, i3, i16);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i19 == 0) {
                i17 += measuredWidth;
            } else {
                i17 = (int) (i17 + (measuredWidth * this.f184625e));
            }
            i18 = Math.max(i18, measuredHeight);
        }
        if (mode2 != 1073741824) {
            size2 = i17;
        }
        if (mode != 1073741824) {
            size = i18;
        }
        setMeasuredDimension(size2, size);
    }

    public void setBackgroundRes(int i3) {
        this.H = i3;
    }

    public void setData(List<QQCircleCounterMsg$RedDisplayInfo> list) {
        setData(list, null);
    }

    public QCircleAvatarListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setData(List<QQCircleCounterMsg$RedDisplayInfo> list, List<String> list2) {
        if (list != null && list.size() != 0) {
            int i3 = 0;
            setVisibility(0);
            removeAllViews();
            int size = list.size();
            if (!this.f184626f) {
                while (i3 < size) {
                    b(list.get(i3), (list2 == null || list2.size() < i3) ? "" : list2.get(i3));
                    i3++;
                }
                return;
            } else {
                int i16 = size - 1;
                while (i16 >= 0) {
                    b(list.get(i16), (list2 == null || list2.size() < i16) ? "" : list2.get(i16));
                    i16--;
                }
                return;
            }
        }
        setVisibility(8);
    }

    public QCircleAvatarListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c(context, attributeSet);
    }
}
