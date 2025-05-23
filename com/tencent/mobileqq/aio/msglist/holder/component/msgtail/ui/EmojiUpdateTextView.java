package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.Checkable;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Marker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00016B\u000f\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0014J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0003J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u001b\u0010\u001d\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010#R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010#R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/EmojiUpdateTextView;", "Landroid/view/View;", "Landroid/widget/Checkable;", "", "isChecked", "", h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "text", IECSearchBar.METHOD_SET_TEXT, "newText", "bClicked", "setTextWithAnim", "checked", "setChecked", "toggle", "d", "Lkotlin/Lazy;", "f", "()I", "defaultTextColor", "e", "i", "selectedTextColor", "Ljava/lang/String;", "oldText", "I", NodeProps.MAX_WIDTH, NodeProps.MAX_HEIGHT, "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "newNumHeight", "D", "oldNumHeight", "E", "Z", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "G", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class EmojiUpdateTextView extends View implements Checkable {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int H;

    @NotNull
    private static final Lazy<Paint> I;

    @NotNull
    private static final Lazy<Integer> J;

    /* renamed from: C, reason: from kotlin metadata */
    private float newNumHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private float oldNumHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isChecked;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy defaultTextColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectedTextColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String oldText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String text;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int maxWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int maxHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000f\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/EmojiUpdateTextView$a;", "", "", ReportConstant.COSTREPORT_PREFIX, "", "d", "Landroid/graphics/Paint;", "PAINT$delegate", "Lkotlin/Lazy;", "f", "()Landroid/graphics/Paint;", "PAINT", "NUM_MAX_WIDTH$delegate", "e", "()I", "NUM_MAX_WIDTH", "ANIMATOR_HEIGHT", "I", "PATCH", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.EmojiUpdateTextView$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<Paint> lazy;
        Lazy<Integer> lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62340);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        H = x.a(16.0f);
        lazy = LazyKt__LazyJVMKt.lazy(EmojiUpdateTextView$Companion$PAINT$2.INSTANCE);
        I = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(EmojiUpdateTextView$Companion$NUM_MAX_WIDTH$2.INSTANCE);
        J = lazy2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiUpdateTextView(@NotNull Context mContext) {
        super(mContext);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.EmojiUpdateTextView$defaultTextColor$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmojiUpdateTextView.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(ResourcesCompat.getColor(EmojiUpdateTextView.this.getResources(), R.color.qui_common_text_secondary, EmojiUpdateTextView.this.getContext().getTheme())) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.defaultTextColor = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.EmojiUpdateTextView$selectedTextColor$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmojiUpdateTextView.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(ResourcesCompat.getColor(EmojiUpdateTextView.this.getResources(), R.color.qui_common_text_link, EmojiUpdateTextView.this.getContext().getTheme())) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.selectedTextColor = lazy2;
            this.oldText = "11";
            this.text = "11";
            this.paint = new Paint(INSTANCE.f());
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext);
    }

    private final int f() {
        return ((Number) this.defaultTextColor.getValue()).intValue();
    }

    private final int g() {
        boolean contains$default;
        int length = this.text.length();
        int i3 = 0;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.text, (CharSequence) Marker.ANY_NON_NULL_MARKER, false, 2, (Object) null);
        if (contains$default) {
            i3 = 0 + INSTANCE.d(Marker.ANY_NON_NULL_MARKER);
            length--;
        }
        return i3 + (length * (INSTANCE.e() + 2)) + 4;
    }

    private final int h(boolean isChecked) {
        if (isChecked) {
            return i();
        }
        return f();
    }

    private final int i() {
        return ((Number) this.selectedTextColor.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(EmojiUpdateTextView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.newNumHeight = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(EmojiUpdateTextView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setAlpha(((Float) animatedValue).floatValue());
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(EmojiUpdateTextView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.oldNumHeight = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    private final void m() {
        int coerceAtLeast;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Paint paint = this.paint;
        String str = this.oldText;
        paint.getTextBounds(str, 0, str.length(), rect);
        Paint paint2 = this.paint;
        String str2 = this.text;
        paint2.getTextBounds(str2, 0, str2.length(), rect2);
        this.maxWidth = g();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(rect.height(), rect2.height());
        this.maxHeight = coerceAtLeast;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isChecked;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        m();
        if (Intrinsics.areEqual(this.oldText, this.text)) {
            this.paint.setColor(h(this.isChecked));
            this.paint.setAlpha(255);
            canvas.drawText(this.oldText, 2.0f, (getHeight() / 2) + (this.maxHeight / 2), this.paint);
            return;
        }
        this.paint.setColor(h(!this.isChecked));
        float f16 = 255;
        this.paint.setAlpha((int) ((1 - getAlpha()) * f16));
        canvas.drawText(this.oldText, 2.0f, this.oldNumHeight + (getHeight() / 2) + (this.maxHeight / 2), this.paint);
        this.paint.setColor(h(this.isChecked));
        this.paint.setAlpha((int) (f16 * getAlpha()));
        canvas.drawText(this.text, 2.0f, this.newNumHeight + (getHeight() / 2) + (this.maxHeight / 2), this.paint);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
        } else {
            m();
            setMeasuredDimension(this.maxWidth, View.MeasureSpec.getSize(heightMeasureSpec));
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, checked);
        } else {
            this.isChecked = checked;
        }
    }

    public final void setText(@NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.oldText = text;
        int i3 = this.maxWidth;
        m();
        if (i3 != this.maxWidth) {
            requestLayout();
        }
        invalidate();
    }

    public final void setTextWithAnim(@NotNull String newText, boolean bClicked) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, newText, Boolean.valueOf(bClicked));
            return;
        }
        Intrinsics.checkNotNullParameter(newText, "newText");
        this.oldText = this.text;
        this.text = newText;
        m();
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = new float[2];
        int i16 = H;
        if (!bClicked) {
            i16 = -i16;
        }
        fArr[0] = i16;
        fArr[1] = 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EmojiUpdateTextView.j(EmojiUpdateTextView.this, valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EmojiUpdateTextView.k(EmojiUpdateTextView.this, valueAnimator);
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
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EmojiUpdateTextView.l(EmojiUpdateTextView.this, valueAnimator);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.isChecked = !this.isChecked;
        }
    }
}
