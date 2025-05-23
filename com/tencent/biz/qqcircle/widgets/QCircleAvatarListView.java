package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleAvatarListView extends ViewGroup {
    private boolean C;
    private int D;
    private int E;
    private int F;
    private List<String> G;
    private List<String> H;

    /* renamed from: d, reason: collision with root package name */
    private int f92899d;

    /* renamed from: e, reason: collision with root package name */
    private float f92900e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f92901f;

    /* renamed from: h, reason: collision with root package name */
    private int f92902h;

    /* renamed from: i, reason: collision with root package name */
    private int f92903i;

    /* renamed from: m, reason: collision with root package name */
    private int f92904m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private FrameLayout f92905a;

        /* renamed from: b, reason: collision with root package name */
        private QCircleRoundImageView f92906b;

        /* renamed from: c, reason: collision with root package name */
        private QCircleRoundImageView f92907c;

        /* renamed from: d, reason: collision with root package name */
        private View f92908d;

        public a(Context context, int i3, int i16, int i17, int i18, boolean z16, int i19) {
            this.f92905a = new FrameLayout(context);
            int i26 = i17 * 2;
            this.f92905a.setLayoutParams(new ViewGroup.LayoutParams(i3 + i26 + 2, i26 + i16 + 2));
            c(context, i3, i16, i17, i18, z16, i19);
            b(context, i3, i16, i18);
            a(context);
            this.f92905a.setVisibility(8);
        }

        private void a(Context context) {
            this.f92908d = new View(context);
            this.f92908d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
            this.f92905a.addView(this.f92908d);
        }

        private void b(Context context, int i3, int i16, int i17) {
            this.f92907c = new QCircleRoundImageView(context);
            this.f92907c.setLayoutParams(new FrameLayout.LayoutParams(i3, i16, 17));
            this.f92907c.setRoundRect(i17);
            this.f92905a.addView(this.f92907c);
        }

        private void c(Context context, int i3, int i16, int i17, int i18, boolean z16, int i19) {
            this.f92906b = new QCircleRoundImageView(context);
            int i26 = i17 * 2;
            this.f92906b.setLayoutParams(new FrameLayout.LayoutParams(i3 + i26, i16 + i26, 17));
            if (z16) {
                this.f92906b.setRoundRect(i18);
                this.f92906b.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(i19));
            } else {
                this.f92906b.setColorFilter(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default));
            }
            this.f92905a.addView(this.f92906b);
        }

        public FrameLayout d() {
            return this.f92905a;
        }
    }

    public QCircleAvatarListView(Context context) {
        this(context, null);
    }

    private void a(int i3) {
        int childCount = getChildCount();
        QLog.i("QCircleAvatarListView", 1, "addOrHideIconHolder  childCount = " + childCount + " , size = " + i3);
        if (childCount >= i3) {
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.setVisibility(8);
                }
                i3++;
            }
            return;
        }
        while (childCount < i3) {
            addView(b().d());
            childCount++;
        }
    }

    private a b() {
        return new a(getContext(), this.f92902h, this.f92903i, this.f92904m, this.f92899d, this.C, this.D);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.G4);
        if (obtainStyledAttributes != null) {
            this.f92899d = obtainStyledAttributes.getInteger(y91.a.M4, 90);
            this.f92900e = obtainStyledAttributes.getFloat(y91.a.T4, 0.8f);
            this.f92902h = (int) obtainStyledAttributes.getDimension(y91.a.N4, 30.0f);
            this.f92903i = (int) obtainStyledAttributes.getDimension(y91.a.L4, 30.0f);
            this.f92901f = obtainStyledAttributes.getBoolean(y91.a.S4, false);
            this.f92904m = (int) obtainStyledAttributes.getDimension(y91.a.R4, 0.0f);
            this.C = obtainStyledAttributes.getBoolean(y91.a.U4, false);
            this.D = obtainStyledAttributes.getResourceId(y91.a.Q4, 0);
            this.E = obtainStyledAttributes.getColor(y91.a.O4, 0);
            this.F = (int) obtainStyledAttributes.getDimension(y91.a.P4, 0.0f);
            obtainStyledAttributes.recycle();
        }
        d();
    }

    private void d() {
        for (int i3 = 0; i3 < 3; i3++) {
            addView(b().d());
        }
    }

    private void e(@NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() < 3) {
            return;
        }
        View childAt = frameLayout.getChildAt(2);
        if (this.F == 0) {
            childAt.setBackground(null);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(this.F, this.E);
        childAt.setBackground(gradientDrawable);
    }

    private void f(String str, String str2, int i3) {
        FrameLayout frameLayout;
        QLog.i("QCircleAvatarListView", 1, "setIconHolderData  i = " + i3 + " , picUrl = " + str + " , bgPicUrl = " + str2);
        if (getChildAt(i3) instanceof FrameLayout) {
            frameLayout = (FrameLayout) getChildAt(i3);
        } else {
            frameLayout = null;
        }
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(0);
        if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof QCircleRoundImageView)) {
            QCircleRoundImageView qCircleRoundImageView = (QCircleRoundImageView) frameLayout.getChildAt(0);
            if (this.C) {
                qCircleRoundImageView.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(this.D));
            } else if (!TextUtils.isEmpty(str2)) {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(qCircleRoundImageView).setRequestWidth(this.f92902h + (this.f92904m * 2)).setRequestHeight(this.f92903i + (this.f92904m * 2)).setUrl(str2));
                qCircleRoundImageView.setColorFilter(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default));
            }
        }
        if (frameLayout.getChildCount() > 1 && (frameLayout.getChildAt(1) instanceof QCircleRoundImageView)) {
            QCircleRoundImageView qCircleRoundImageView2 = (QCircleRoundImageView) frameLayout.getChildAt(1);
            if (str.startsWith("http")) {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(qCircleRoundImageView2).setUrl(str).setRequestWidth(this.f92902h).setRequestHeight(this.f92903i).setLoadingDrawable(com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.ntp)).setFailDrawable(com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.ntp)));
                qCircleRoundImageView2.setTag(HostUIHelper.getInstance().getHostResourceId("id", "qcircle_avatar_tag_id"), str);
            } else {
                com.tencent.biz.qqcircle.utils.al.a(qCircleRoundImageView2, str, new Size(this.f92902h, this.f92903i));
            }
        }
        e(frameLayout);
    }

    private void g(List<String> list, List<String> list2) {
        String str;
        if (list != null && list.size() != 0) {
            setVisibility(0);
            int size = list.size();
            a(size);
            for (int i3 = 0; i3 < size; i3++) {
                String str2 = "";
                if (list.size() <= i3) {
                    str = "";
                } else {
                    str = list.get(i3);
                }
                if (list2 != null && list2.size() > i3) {
                    str2 = list2.get(i3);
                }
                if (this.f92901f) {
                    f(str, str2, (size - 1) - i3);
                } else {
                    f(str, str2, i3);
                }
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        if (this.f92901f) {
            int i19 = i17 - i3;
            int i26 = childCount - 1;
            int i27 = i19;
            for (int i28 = i26; i28 >= 0; i28--) {
                View childAt = getChildAt(i26 - i28);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (i28 == i26) {
                        i19 -= measuredWidth;
                    } else {
                        i19 = (int) (i19 - (measuredWidth * this.f92900e));
                    }
                    childAt.layout(i19, 0, i27, measuredHeight);
                    i27 = (int) (i27 - (measuredWidth * this.f92900e));
                }
            }
            return;
        }
        int i29 = 0;
        int i36 = 0;
        for (int i37 = 0; i37 < childCount; i37++) {
            View childAt2 = getChildAt(i37);
            if (childAt2.getVisibility() != 8) {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                if (i37 == 0) {
                    i29 += measuredWidth2;
                } else {
                    i29 = (int) (i29 + (measuredWidth2 * this.f92900e));
                }
                childAt2.layout(i36, 0, i29, measuredHeight2);
                i36 = (int) (i36 + (measuredWidth2 * this.f92900e));
            }
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
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i16);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i19 == 0) {
                    i17 += measuredWidth;
                } else {
                    i17 = (int) (i17 + (measuredWidth * this.f92900e));
                }
                i18 = Math.max(i18, measuredHeight);
            }
        }
        if (mode2 != 1073741824) {
            size2 = i17;
        }
        if (mode != 1073741824) {
            size = i18;
        }
        setMeasuredDimension(size2, size);
    }

    public void setData(List<String> list) {
        setData(list, null);
    }

    public void setStroke(int i3, @ColorInt int i16) {
        this.F = i3;
        this.E = i16;
    }

    public QCircleAvatarListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setData(List<String> list, List<String> list2) {
        if (list != null && list.size() != 0) {
            this.G.clear();
            this.G.addAll(list);
        }
        if (list2 != null && list2.size() != 0) {
            this.H.clear();
            this.H.addAll(list2);
        }
        g(list, list2);
    }

    public QCircleAvatarListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = new ArrayList();
        this.H = new ArrayList();
        c(context, attributeSet);
    }
}
