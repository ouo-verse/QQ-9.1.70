package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasAppBtnView extends TextView {
    private static final String TAG = "AdCanvasAppBtnView";

    @NonNull
    private Rect bounds;
    private Drawable leftBackroundDrawable;

    @NonNull
    private RectF leftBounds;
    private final int maxProgress;

    @Nullable
    private Params params;
    private volatile float progress;
    private Drawable rightBackgroundDrawable;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Params {
        public int textSize = 0;
        public int leftBackgroundColor = -16776961;
        public int leftTextColor = -1;
        public int rightBackgroundColor = -7829368;
        public int rightTextColor = -16777216;
        public int borderCornerRadius = 0;
        public int borderWidth = 0;
        public int borderColor = -16776961;
    }

    public AdCanvasAppBtnView(@NonNull Context context, Params params) {
        super(context);
        this.bounds = new Rect();
        this.leftBounds = new RectF();
        this.progress = 100.0f;
        this.maxProgress = 100;
        init(context, params);
    }

    @NonNull
    private static Drawable createBackgroundDrawable(@NonNull Params params, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i3);
        int i16 = params.borderCornerRadius;
        if (i16 > 0) {
            gradientDrawable.setCornerRadius(i16);
        }
        int i17 = params.borderWidth;
        if (i17 > 0) {
            gradientDrawable.setStroke(i17, params.borderColor);
        }
        return gradientDrawable;
    }

    @TargetApi(16)
    private void init(@NonNull Context context, @Nullable Params params) {
        if (params == null) {
            AdLog.e(TAG, "init error");
            return;
        }
        this.params = params;
        try {
            setSingleLine(false);
            setLines(1);
            setGravity(17);
            setEllipsize(TextUtils.TruncateAt.END);
            int dp2px = AdUIUtils.dp2px(5.0f, context.getResources());
            setPadding(dp2px, 0, dp2px, 0);
            int i3 = params.textSize;
            if (i3 > 0) {
                setTextSize(0, i3);
            }
            setTextColor(params.leftTextColor);
            this.leftBackroundDrawable = createBackgroundDrawable(params, params.leftBackgroundColor);
            this.rightBackgroundDrawable = createBackgroundDrawable(params, params.rightBackgroundColor);
        } catch (Exception e16) {
            AdLog.e(TAG, "init error:", e16);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        this.bounds.set(0, 0, getWidth(), getHeight());
        this.leftBounds.set(0.0f, 0.0f, getWidth() * (this.progress / 100.0f), getHeight());
        canvas.save();
        canvas.clipRect(this.leftBounds);
        this.leftBackroundDrawable.setBounds(this.bounds);
        this.leftBackroundDrawable.draw(canvas);
        setTextColor(this.params.leftTextColor);
        super.onDraw(canvas);
        canvas.restore();
        if (this.progress < 100.0f) {
            canvas.save();
            canvas.clipRect(this.leftBounds, Region.Op.DIFFERENCE);
            this.rightBackgroundDrawable.setBounds(this.bounds);
            this.rightBackgroundDrawable.draw(canvas);
            setTextColor(this.params.rightTextColor);
            super.onDraw(canvas);
            canvas.restore();
        }
    }

    public void setProgress(int i3) {
        float min = Math.min(Math.max(0, i3), 100);
        if (min != this.progress) {
            this.progress = min;
            invalidate();
        }
    }
}
