package com.tencent.guild.aio.msglist.reaction.ui;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.Checkable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u000f\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0003J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\"R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010.\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00104\u00a8\u0006<"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/EmojiUpdateTextView;", "Landroid/view/View;", "Landroid/widget/Checkable;", "", "isChecked", "", "g", "", "k", "f", "Landroid/content/res/ColorStateList;", "defaultColorStateList", "selectedColorStateList", "l", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "text", IECSearchBar.METHOD_SET_TEXT, "newText", "bClicked", "setTextWithAnim", "checked", "setChecked", "toggle", "d", "Ljava/lang/String;", "mOldText", "e", "mText", "I", NodeProps.MAX_WIDTH, h.F, NodeProps.MAX_HEIGHT, "", "i", UserInfo.SEX_FEMALE, "mNewNumHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mOldNumHeight", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/res/ColorStateList;", "mDefaultColorStateList", "D", "mSelectedColorStateList", "E", "Z", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "G", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class EmojiUpdateTextView extends View implements Checkable {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int H = x.a(16.0f);

    @NotNull
    private static final Lazy<Paint> I;

    @NotNull
    private static final Lazy<Integer> J;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ColorStateList mDefaultColorStateList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ColorStateList mSelectedColorStateList;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isChecked;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Paint mPaint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mOldText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int maxWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int maxHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mNewNumHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mOldNumHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000f\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/EmojiUpdateTextView$a;", "", "", ReportConstant.COSTREPORT_PREFIX, "", "d", "Landroid/graphics/Paint;", "PAINT$delegate", "Lkotlin/Lazy;", "f", "()Landroid/graphics/Paint;", "PAINT", "NUM_MAX_WIDTH$delegate", "e", "()I", "NUM_MAX_WIDTH", "ANIMATOR_HEIGHT", "I", "DEFAULT_TEXT_COLOR", "PATCH", "SELECTED_TEXT_COLOR", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.reaction.ui.EmojiUpdateTextView$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(String s16) {
            Rect rect = new Rect();
            f().getTextBounds(s16, 0, 1, rect);
            return rect.width();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int e() {
            return ((Number) EmojiUpdateTextView.J.getValue()).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Paint f() {
            return (Paint) EmojiUpdateTextView.I.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Paint> lazy;
        Lazy<Integer> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.guild.aio.msglist.reaction.ui.EmojiUpdateTextView$Companion$PAINT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint(5);
                paint.setTextSize(x.a(13.0f));
                return paint;
            }
        });
        I = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.guild.aio.msglist.reaction.ui.EmojiUpdateTextView$Companion$NUM_MAX_WIDTH$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int i3 = 0;
                for (int i16 = 0; i16 < 10; i16++) {
                    i3 = Math.max(i3, EmojiUpdateTextView.INSTANCE.d(String.valueOf(i16)));
                }
                return Integer.valueOf(i3);
            }
        });
        J = lazy2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiUpdateTextView(@NotNull Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mOldText = "11";
        this.mText = "11";
        this.mPaint = new Paint(INSTANCE.f());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int f() {
        boolean contains$default;
        int i3;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        boolean contains$default6;
        int max = Math.max(this.mOldText.length(), this.mText.length());
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.mOldText, (CharSequence) ".", false, 2, (Object) null);
        if (contains$default) {
            contains$default6 = StringsKt__StringsKt.contains$default((CharSequence) this.mText, (CharSequence) ".", false, 2, (Object) null);
            if (contains$default6) {
                i3 = INSTANCE.d(".") + 0;
                max--;
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) this.mOldText, (CharSequence) "k", false, 2, (Object) null);
                if (contains$default2) {
                    contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) this.mText, (CharSequence) "k", false, 2, (Object) null);
                    if (contains$default5) {
                        i3 += INSTANCE.d("k") + 4;
                        max--;
                    }
                }
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) this.mOldText, (CharSequence) "w", false, 2, (Object) null);
                if (contains$default3) {
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) this.mText, (CharSequence) "w", false, 2, (Object) null);
                    if (contains$default4) {
                        i3 += INSTANCE.d("w");
                        max--;
                    }
                }
                return i3 + (max * (INSTANCE.e() + 2)) + 4;
            }
        }
        i3 = 0;
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) this.mOldText, (CharSequence) "k", false, 2, (Object) null);
        if (contains$default2) {
        }
        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) this.mOldText, (CharSequence) "w", false, 2, (Object) null);
        if (contains$default3) {
        }
        return i3 + (max * (INSTANCE.e() + 2)) + 4;
    }

    private final int g(boolean isChecked) {
        if (isChecked) {
            ColorStateList colorStateList = this.mSelectedColorStateList;
            if (colorStateList != null) {
                return colorStateList.getDefaultColor();
            }
            return RichStatus.TOPIC_COLOR;
        }
        ColorStateList colorStateList2 = this.mDefaultColorStateList;
        if (colorStateList2 != null) {
            return colorStateList2.getDefaultColor();
        }
        return -6117972;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(EmojiUpdateTextView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.mNewNumHeight = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(EmojiUpdateTextView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setAlpha(((Float) animatedValue).floatValue());
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(EmojiUpdateTextView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.mOldNumHeight = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    private final void k() {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Paint paint = this.mPaint;
        String str = this.mOldText;
        paint.getTextBounds(str, 0, str.length(), rect);
        Paint paint2 = this.mPaint;
        String str2 = this.mText;
        paint2.getTextBounds(str2, 0, str2.length(), rect2);
        this.maxWidth = f();
        this.maxHeight = Math.max(rect.height(), rect2.height());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    public final void l(@NotNull ColorStateList defaultColorStateList, @NotNull ColorStateList selectedColorStateList) {
        Intrinsics.checkNotNullParameter(defaultColorStateList, "defaultColorStateList");
        Intrinsics.checkNotNullParameter(selectedColorStateList, "selectedColorStateList");
        this.mDefaultColorStateList = defaultColorStateList;
        this.mSelectedColorStateList = selectedColorStateList;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        k();
        if (Intrinsics.areEqual(this.mOldText, this.mText)) {
            this.mPaint.setColor(g(this.isChecked));
            this.mPaint.setAlpha(255);
            canvas.drawText(this.mOldText, 2.0f, (getHeight() / 2) + (this.maxHeight / 2), this.mPaint);
            return;
        }
        this.mPaint.setColor(g(!this.isChecked));
        float f16 = 255;
        this.mPaint.setAlpha((int) ((1 - getAlpha()) * f16));
        canvas.drawText(this.mOldText, 2.0f, this.mOldNumHeight + (getHeight() / 2) + (this.maxHeight / 2), this.mPaint);
        this.mPaint.setColor(g(this.isChecked));
        this.mPaint.setAlpha((int) (f16 * getAlpha()));
        canvas.drawText(this.mText, 2.0f, this.mNewNumHeight + (getHeight() / 2) + (this.maxHeight / 2), this.mPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        k();
        setMeasuredDimension(this.maxWidth, View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public final void setText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mText = text;
        this.mOldText = text;
        int i3 = this.maxWidth;
        k();
        if (i3 != this.maxWidth) {
            requestLayout();
        }
        invalidate();
    }

    public final void setTextWithAnim(@NotNull String newText, boolean bClicked) {
        int i3;
        Intrinsics.checkNotNullParameter(newText, "newText");
        this.mOldText = this.mText;
        this.mText = newText;
        k();
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = new float[2];
        int i16 = H;
        if (!bClicked) {
            i16 = -i16;
        }
        fArr[0] = i16;
        fArr[1] = 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.guild.aio.msglist.reaction.ui.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EmojiUpdateTextView.h(EmojiUpdateTextView.this, valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.guild.aio.msglist.reaction.ui.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EmojiUpdateTextView.i(EmojiUpdateTextView.this, valueAnimator);
            }
        });
        float[] fArr2 = new float[2];
        fArr2[0] = 0.0f;
        if (bClicked) {
            i3 = -H;
        } else {
            i3 = H;
        }
        fArr2[1] = i3;
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(fArr2);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.guild.aio.msglist.reaction.ui.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EmojiUpdateTextView.j(EmojiUpdateTextView.this, valueAnimator);
            }
        });
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.start();
        requestLayout();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.isChecked = !this.isChecked;
    }
}
