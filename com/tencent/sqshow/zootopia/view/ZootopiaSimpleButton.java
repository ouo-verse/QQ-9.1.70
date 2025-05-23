package com.tencent.sqshow.zootopia.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.utils.i;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0001\u0003B\u0011\b\u0016\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106B\u001b\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b5\u00109B#\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b5\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010,\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0014R\u0018\u0010/\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006>"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaSimpleButton;", "Landroid/widget/Button;", "", "a", "", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "draw", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "status", "setButtonStatus", "", "text", "setFinishedText", "d", UserInfo.SEX_FEMALE, "currentProgress", "e", "maxProgress", "f", "minProgress", "Landroid/graphics/drawable/GradientDrawable;", h.F, "Landroid/graphics/drawable/GradientDrawable;", "buttonDrawable", "i", "progressDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "invalidDrawable", "Landroid/graphics/RectF;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/RectF;", "roundRect", "Landroid/graphics/Paint;", "D", "Landroid/graphics/Paint;", "desPaint", "E", "srcPaint", "radius", "G", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "H", "Ljava/lang/String;", "finishedText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "I", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaSimpleButton extends Button {

    /* renamed from: C, reason: from kotlin metadata */
    private final RectF roundRect;

    /* renamed from: D, reason: from kotlin metadata */
    private final Paint desPaint;

    /* renamed from: E, reason: from kotlin metadata */
    private final Paint srcPaint;

    /* renamed from: F, reason: from kotlin metadata */
    private final float radius;

    /* renamed from: G, reason: from kotlin metadata */
    private ButtonStatus buttonStatus;

    /* renamed from: H, reason: from kotlin metadata */
    private String finishedText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float currentProgress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float maxProgress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float minProgress;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GradientDrawable buttonDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GradientDrawable progressDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GradientDrawable invalidDrawable;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f373337a;

        static {
            int[] iArr = new int[ButtonStatus.values().length];
            try {
                iArr[ButtonStatus.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStatus.WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStatus.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStatus.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ButtonStatus.MAINTENANCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ButtonStatus.UPDATE_SYSTEM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ButtonStatus.INVALID.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f373337a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaSimpleButton(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxProgress = 1.0f;
        this.buttonDrawable = new GradientDrawable();
        this.progressDrawable = new GradientDrawable();
        this.invalidDrawable = new GradientDrawable();
        this.roundRect = new RectF();
        Paint paint = new Paint();
        this.desPaint = paint;
        Paint paint2 = new Paint();
        this.srcPaint = paint2;
        this.radius = i.a(8.32f);
        this.buttonStatus = ButtonStatus.INIT;
        String string = getResources().getString(R.string.xas);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.button_loaded)");
        this.finishedText = string;
        this.invalidDrawable.setColor(getResources().getColor(R.color.f8256g));
        GradientDrawable gradientDrawable = this.buttonDrawable;
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(2, Color.parseColor("#EBEBEB"));
        this.progressDrawable.setColor(getResources().getColor(R.color.b9l));
        setBackgroundDrawable(this.buttonDrawable);
        setGravity(17);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint2.setAntiAlias(true);
        b();
    }

    private final boolean a() {
        ButtonStatus buttonStatus = this.buttonStatus;
        return buttonStatus == ButtonStatus.LOADING || buttonStatus == ButtonStatus.PAUSE;
    }

    private final void b() {
        ButtonStatus buttonStatus = this.buttonStatus;
        switch (buttonStatus == null ? -1 : b.f373337a[buttonStatus.ordinal()]) {
            case 1:
                setText(getResources().getString(R.string.xar));
                setTextColor(-16777216);
                setBackgroundDrawable(this.buttonDrawable);
                return;
            case 2:
                setText(getResources().getString(R.string.f169735xb0));
                setTextColor(-1);
                setBackgroundDrawable(this.progressDrawable);
                return;
            case 3:
                setText(this.finishedText);
                setTextColor(-1);
                setBackgroundDrawable(this.progressDrawable);
                return;
            case 4:
                setText(getResources().getString(R.string.xay));
                setTextColor(-1);
                setBackgroundDrawable(this.progressDrawable);
                return;
            case 5:
                setText(getResources().getString(R.string.xau));
                setTextColor(getResources().getColor(R.color.f8246f));
                setBackgroundDrawable(this.invalidDrawable);
                return;
            case 6:
                setText(getResources().getString(R.string.xaz));
                setTextColor(-1);
                setBackgroundDrawable(this.progressDrawable);
                return;
            case 7:
                setText(getResources().getString(R.string.xau));
                setTextColor(getResources().getColor(R.color.f8246f));
                setBackgroundDrawable(this.invalidDrawable);
                return;
            default:
                return;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (a()) {
            float f16 = this.minProgress + 0.01f;
            float f17 = this.maxProgress;
            float f18 = this.currentProgress;
            if (f16 <= f18 && f18 <= f17) {
                float measuredWidth = getMeasuredWidth();
                float f19 = this.currentProgress;
                float f26 = this.minProgress;
                this.progressDrawable.setBounds(0, 0, (int) (measuredWidth * (((f19 - f26) / this.maxProgress) - f26)), getMeasuredHeight());
                this.progressDrawable.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public final void setButtonStatus(ButtonStatus status, float progress) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.buttonStatus = status;
        b();
        if (!a()) {
            this.currentProgress = this.minProgress;
        } else {
            setProgress(progress, status);
        }
    }

    public final void setFinishedText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.finishedText = text;
    }

    public final void setProgress(float progress) {
        String format;
        int color;
        if (a()) {
            int i3 = (int) (100 * progress);
            if (this.buttonStatus == ButtonStatus.LOADING) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getResources().getString(R.string.xat);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.button_loading)");
                format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string2 = getResources().getString(R.string.xaw);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.button_pause)");
                format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            setText(format);
            if (this.buttonStatus == ButtonStatus.PAUSE) {
                color = -16777216;
            } else {
                color = i3 < 60 ? getResources().getColor(R.color.f8276i) : -1;
            }
            setBackgroundDrawable(this.buttonDrawable);
            setTextColor(color);
            this.currentProgress = progress;
            invalidate();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (canvas == null) {
                super.draw(canvas);
                return;
            }
            try {
                this.roundRect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                canvas.saveLayer(this.roundRect, this.srcPaint, 31);
                RectF rectF = this.roundRect;
                float f16 = rectF.left;
                float f17 = rectF.top;
                canvas.drawRect(f16, f17, rectF.right, (rectF.bottom + f17) / 2, this.srcPaint);
                RectF rectF2 = this.roundRect;
                float f18 = this.radius;
                canvas.drawRoundRect(rectF2, f18, f18, this.srcPaint);
                canvas.saveLayer(this.roundRect, this.desPaint, 31);
            } catch (Exception e16) {
                QLog.e("ZootopiaSimpleButton", 1, "draw throw e:" + e16.getMessage());
            }
        } finally {
            super.draw(canvas);
            canvas.restore();
        }
    }

    public static /* synthetic */ void setButtonStatus$default(ZootopiaSimpleButton zootopiaSimpleButton, ButtonStatus buttonStatus, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = zootopiaSimpleButton.currentProgress;
        }
        zootopiaSimpleButton.setButtonStatus(buttonStatus, f16);
    }

    public final void setProgress(float progress, ButtonStatus status) {
        String format;
        int color;
        Intrinsics.checkNotNullParameter(status, "status");
        if (a()) {
            int i3 = (int) (100 * progress);
            if (status == ButtonStatus.LOADING) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getResources().getString(R.string.xat);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.button_loading)");
                format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string2 = getResources().getString(R.string.xaw);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.button_pause)");
                format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            setText(format);
            if (this.buttonStatus == ButtonStatus.PAUSE) {
                color = -16777216;
            } else {
                color = i3 < 60 ? getResources().getColor(R.color.f8276i) : -1;
            }
            setBackgroundDrawable(this.buttonDrawable);
            setTextColor(color);
            this.currentProgress = progress;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaSimpleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxProgress = 1.0f;
        this.buttonDrawable = new GradientDrawable();
        this.progressDrawable = new GradientDrawable();
        this.invalidDrawable = new GradientDrawable();
        this.roundRect = new RectF();
        Paint paint = new Paint();
        this.desPaint = paint;
        Paint paint2 = new Paint();
        this.srcPaint = paint2;
        this.radius = i.a(8.32f);
        this.buttonStatus = ButtonStatus.INIT;
        String string = getResources().getString(R.string.xas);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.button_loaded)");
        this.finishedText = string;
        this.invalidDrawable.setColor(getResources().getColor(R.color.f8256g));
        GradientDrawable gradientDrawable = this.buttonDrawable;
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(2, Color.parseColor("#EBEBEB"));
        this.progressDrawable.setColor(getResources().getColor(R.color.b9l));
        setBackgroundDrawable(this.buttonDrawable);
        setGravity(17);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint2.setAntiAlias(true);
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaSimpleButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxProgress = 1.0f;
        this.buttonDrawable = new GradientDrawable();
        this.progressDrawable = new GradientDrawable();
        this.invalidDrawable = new GradientDrawable();
        this.roundRect = new RectF();
        Paint paint = new Paint();
        this.desPaint = paint;
        Paint paint2 = new Paint();
        this.srcPaint = paint2;
        this.radius = i.a(8.32f);
        this.buttonStatus = ButtonStatus.INIT;
        String string = getResources().getString(R.string.xas);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.button_loaded)");
        this.finishedText = string;
        this.invalidDrawable.setColor(getResources().getColor(R.color.f8256g));
        GradientDrawable gradientDrawable = this.buttonDrawable;
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(2, Color.parseColor("#EBEBEB"));
        this.progressDrawable.setColor(getResources().getColor(R.color.b9l));
        setBackgroundDrawable(this.buttonDrawable);
        setGravity(17);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint2.setAntiAlias(true);
        b();
    }
}
