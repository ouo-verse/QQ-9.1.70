package com.qq.e.comm.plugin.tangramsplash.e;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.am;
import com.qq.e.comm.plugin.k.ba;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    Paint f39892a;

    /* renamed from: b, reason: collision with root package name */
    RectF f39893b;

    /* renamed from: c, reason: collision with root package name */
    int f39894c;

    /* renamed from: d, reason: collision with root package name */
    boolean f39895d;

    /* renamed from: e, reason: collision with root package name */
    private Context f39896e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f39897f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f39898g;

    /* renamed from: h, reason: collision with root package name */
    private String f39899h;

    /* renamed from: i, reason: collision with root package name */
    private String f39900i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f39901j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f39902k;

    public c(Context context, boolean z16) {
        super(context);
        this.f39899h = "\u70b9\u51fb\u8fd9\u91cc\uff0c\u8df3\u8f6c\u8be6\u60c5\u9875\u9762";
        this.f39900i = "\u8df3\u8f6c\u7b2c\u4e09\u65b9\u9875\u9762/\u5e94\u7528";
        this.f39896e = context;
        this.f39895d = z16;
        this.f39892a = new Paint();
        this.f39893b = new RectF();
        this.f39894c = ak.a(this.f39896e, 2);
        setWillNotDraw(false);
        b();
    }

    private void b() {
        TextView textView = new TextView(this.f39896e);
        this.f39898g = textView;
        textView.setText(this.f39899h);
        this.f39898g.setTextSize(18.0f);
        this.f39898g.setMaxLines(1);
        this.f39898g.setMaxEms(13);
        this.f39898g.setEllipsize(TextUtils.TruncateAt.END);
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_activated}, new int[]{R.attr.state_checkable}, new int[0]}, new int[]{-1, -1, -1, -1, -1});
        this.f39898g.setTextColor(colorStateList);
        this.f39897f = new LinearLayout(this.f39896e);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f39897f.addView(this.f39898g, layoutParams);
        if (this.f39895d) {
            TextView textView2 = new TextView(this.f39896e);
            this.f39901j = textView2;
            textView2.setText(this.f39900i);
            this.f39901j.setTextSize(12.0f);
            this.f39901j.setMaxLines(1);
            this.f39901j.setEllipsize(TextUtils.TruncateAt.END);
            this.f39901j.setTextColor(colorStateList);
            this.f39901j.setAlpha(0.6f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = ak.a(getContext(), 3);
            layoutParams2.gravity = 1;
            this.f39897f.addView(this.f39901j, layoutParams2);
        }
        this.f39897f.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        addView(this.f39897f, layoutParams3);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f39899h = str;
        this.f39898g.setText(str);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f39892a.setColor(-1);
        this.f39892a.setAlpha(30);
        this.f39892a.setStrokeWidth(this.f39894c);
        this.f39892a.setStyle(Paint.Style.STROKE);
        this.f39892a.setAntiAlias(true);
        RectF rectF = this.f39893b;
        float f16 = this.f39894c * 0.5f;
        rectF.top = f16;
        rectF.left = f16;
        rectF.right = getMeasuredWidth() - (this.f39894c * 0.5f);
        this.f39893b.bottom = getMeasuredHeight() - (this.f39894c * 0.5f);
        canvas.drawRoundRect(this.f39893b, 90.0f, 90.0f, this.f39892a);
        this.f39892a.setStyle(Paint.Style.FILL);
        this.f39892a.setStrokeWidth(this.f39894c);
        this.f39892a.setColor(Color.parseColor("#B3303030"));
        this.f39892a.setAntiAlias(true);
        RectF rectF2 = this.f39893b;
        float f17 = this.f39894c;
        rectF2.top = f17;
        rectF2.left = f17;
        rectF2.right = getMeasuredWidth() - this.f39894c;
        this.f39893b.bottom = getMeasuredHeight() - this.f39894c;
        canvas.drawRoundRect(this.f39893b, 90.0f, 90.0f, this.f39892a);
    }

    public void a() {
        LinearLayout linearLayout = this.f39897f;
        if (linearLayout == null) {
            GDTLogger.e("DynamicFloatView[setFinger] mTextLayout is null");
            return;
        }
        ba.a(linearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.f39897f.setLayoutParams(layoutParams);
        this.f39902k = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ak.a(getContext(), 54), ak.a(getContext(), 54));
        layoutParams2.leftMargin = ak.a(getContext(), 4);
        layoutParams2.gravity = 16;
        this.f39902k.setImageBitmap(am.a("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"));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.addView(this.f39897f, layoutParams);
        linearLayout2.addView(this.f39902k, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        addView(linearLayout2, layoutParams3);
    }
}
