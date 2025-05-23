package com.tencent.mobileqq.qwallet.hb.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 h2\u00020\u0001:\u0001iB\u0011\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u00a2\u0006\u0004\ba\u0010bB\u001b\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u00a2\u0006\u0004\ba\u0010eB#\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u0012\u0006\u0010f\u001a\u00020\u0011\u00a2\u0006\u0004\ba\u0010gJ\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0014\u0010\u0018\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u001c\u0010\u001e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010!\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0011H\u0016J(\u0010'\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010+R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010+R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010)R\u0016\u00101\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010+R\u0016\u00103\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010+R\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\"\u0010:\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010)\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010B\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010CR\u0016\u0010E\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010=R\u0016\u0010G\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010=R&\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR&\u0010L\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0004j\b\u0012\u0004\u0012\u00020\u0011`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010IR&\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0004j\b\u0012\u0004\u0012\u00020\r`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010IR$\u0010P\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0004j\b\u0012\u0004\u0012\u00020\u0014`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010IR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Z\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0014\u0010\\\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010WR\u0014\u0010^\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010W\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/view/RollNumberTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "j", "Landroid/graphics/Canvas;", PM.CANVAS, "", "e", "mCanvas", "", HippyTKDListViewAdapter.X, "y", "f", "", "textIndex", h.F, "", "time", "line", "i", "l", "numIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Landroid/widget/TextView$BufferType;", "type", IECSearchBar.METHOD_SET_TEXT, "Landroid/content/res/ColorStateList;", NodeProps.COLORS, "setTextColor", "color", "left", "top", "right", "bottom", "setPadding", "onDraw", "I", "textColor", UserInfo.SEX_FEMALE, "textHeight", "textTop", BdhLogUtil.LogTag.Tag_Conn, "textStart", "D", "textWidth", "E", "pointWidth", "pointIndex", "G", "getScrollType", "()I", "setScrollType", "(I)V", "scrollType", "", "H", "Z", "getNeedShowWithoutAnim", "()Z", "setNeedShowWithoutAnim", "(Z)V", "needShowWithoutAnim", "J", "startTime", "isStarting", "K", "isShowed", "L", "Ljava/util/ArrayList;", "textList", "M", "scrollSize", "N", "scrollDistance", "P", "endTime", "Landroid/view/animation/DecelerateInterpolator;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/animation/DecelerateInterpolator;", "valueAnimator", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Runnable;", "scrollEndCallback", ExifInterface.LATITUDE_SOUTH, "startTask", "T", "runTask", "U", "endTask", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "V", "a", "qqpay-ui_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class RollNumberTextView extends AppCompatTextView {

    /* renamed from: C, reason: from kotlin metadata */
    private int textStart;

    /* renamed from: D, reason: from kotlin metadata */
    private float textWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private float pointWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private int pointIndex;

    /* renamed from: G, reason: from kotlin metadata */
    private int scrollType;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean needShowWithoutAnim;

    /* renamed from: I, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isStarting;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isShowed;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Character> textList;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Integer> scrollSize;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Float> scrollDistance;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Long> endTime;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final DecelerateInterpolator valueAnimator;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Runnable scrollEndCallback;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Runnable startTask;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Runnable runTask;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Runnable endTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int textColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float textHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float textTop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RollNumberTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList textColors = getTextColors();
        this.textColor = textColors != null ? textColors.getDefaultColor() : -16777216;
        this.textHeight = getPaint().getFontMetrics().bottom - getPaint().getFontMetrics().top;
        this.textTop = ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.textHeight) / 2) + getPaddingTop();
        this.textStart = getPaddingLeft();
        this.textWidth = getPaint().measureText("9");
        this.pointWidth = getPaint().measureText(".");
        this.pointIndex = -1;
        this.scrollType = -1;
        this.startTime = SystemClock.uptimeMillis();
        this.textList = k(this, null, 1, null);
        this.scrollSize = new ArrayList<>();
        this.scrollDistance = new ArrayList<>();
        this.endTime = new ArrayList<>();
        this.valueAnimator = new DecelerateInterpolator();
        this.startTask = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.b
            @Override // java.lang.Runnable
            public final void run() {
                RollNumberTextView.n(RollNumberTextView.this);
            }
        };
        this.runTask = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.RollNumberTextView$runTask$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                z16 = RollNumberTextView.this.isStarting;
                if (z16) {
                    RollNumberTextView.this.postDelayed(this, 20L);
                    RollNumberTextView.this.invalidate();
                }
            }
        };
        this.endTask = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.c
            @Override // java.lang.Runnable
            public final void run() {
                RollNumberTextView.g(RollNumberTextView.this);
            }
        };
    }

    private final void e(Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        int size = this.textList.size();
        boolean z16 = true;
        for (int i3 = 0; i3 < size; i3++) {
            Long l3 = this.endTime.get(i3);
            Intrinsics.checkNotNullExpressionValue(l3, "endTime[textIndex]");
            if (uptimeMillis >= l3.longValue()) {
                f(canvas, String.valueOf(this.textList.get(i3).charValue()), h(i3), this.textTop);
            } else {
                Integer num = this.scrollSize.get(i3);
                Intrinsics.checkNotNullExpressionValue(num, "scrollSize[textIndex]");
                int intValue = num.intValue();
                for (int i16 = 0; i16 < intValue; i16++) {
                    float i17 = i(i3, uptimeMillis, i16);
                    if (i17 > (-this.textHeight) && i17 < getMeasuredHeight()) {
                        Character ch5 = this.textList.get(i3);
                        Intrinsics.checkNotNullExpressionValue(ch5, "textList[textIndex]");
                        f(canvas, String.valueOf(l(ch5.charValue(), i16)), h(i3), i17);
                    }
                }
                z16 = false;
            }
        }
        if (z16) {
            post(this.endTask);
        }
    }

    private final void f(Canvas mCanvas, String text, float x16, float y16) {
        mCanvas.drawText(text, x16, y16 + this.textHeight, getPaint());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(RollNumberTextView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isShowed = true;
        this$0.isStarting = false;
        this$0.invalidate();
        this$0.removeCallbacks(this$0.startTask);
        this$0.removeCallbacks(this$0.runTask);
        Runnable runnable = this$0.scrollEndCallback;
        if (runnable != null) {
            this$0.post(runnable);
            this$0.scrollEndCallback = null;
        }
    }

    private final float h(int textIndex) {
        float f16;
        int i3;
        int i16 = this.pointIndex;
        if (textIndex > i16 && i16 != -1) {
            f16 = (this.textWidth * (textIndex - 1)) + this.pointWidth;
            i3 = this.textStart;
        } else {
            f16 = this.textWidth * textIndex;
            i3 = this.textStart;
        }
        return f16 + i3;
    }

    private final float i(int textIndex, long time, int line) {
        DecelerateInterpolator decelerateInterpolator = this.valueAnimator;
        Long l3 = this.endTime.get(textIndex);
        Intrinsics.checkNotNullExpressionValue(l3, "endTime[textIndex]");
        return (this.scrollDistance.get(textIndex).floatValue() * decelerateInterpolator.getInterpolation((((float) time) * 1.0f) / l3.floatValue())) + m(textIndex, line) + this.textTop;
    }

    private final ArrayList<Character> j(String text) {
        ArrayList<Character> arrayList = new ArrayList<>();
        int length = text.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = text.charAt(i3);
            arrayList.add(Character.valueOf(charAt));
            if (charAt == '.') {
                this.pointIndex = i3;
            }
        }
        return arrayList;
    }

    static /* synthetic */ ArrayList k(RollNumberTextView rollNumberTextView, String str, int i3, Object obj) {
        CharSequence text;
        if ((i3 & 1) != 0 && ((text = rollNumberTextView.getText()) == null || (str = text.toString()) == null)) {
            str = "";
        }
        return rollNumberTextView.j(str);
    }

    private final char l(char c16, int i3) {
        if (i3 == 0) {
            return c16;
        }
        if (c16 == '.') {
            return TokenParser.SP;
        }
        if (Intrinsics.compare((int) c16, 48) >= 0 && Intrinsics.compare((int) c16, 57) <= 0) {
            return (char) (((((c16 - 48) - i3) + 100) % 10) + 48);
        }
        return c16;
    }

    private final float m(int numIndex, int line) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.scrollSize.get(numIndex).intValue() - line, 0);
        return coerceAtLeast * this.textHeight * 1.5f * this.scrollType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(RollNumberTextView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.removeCallbacks(this$0.runTask);
        this$0.textHeight = this$0.getPaint().getFontMetrics().bottom - this$0.getPaint().getFontMetrics().top;
        this$0.textTop = ((((this$0.getMeasuredHeight() - this$0.getPaddingTop()) - this$0.getPaddingBottom()) - this$0.textHeight) / 2) + this$0.getPaddingTop();
        this$0.textWidth = this$0.getPaint().measureText("9");
        this$0.pointWidth = this$0.getPaint().measureText(".");
        int i3 = this$0.textColor;
        int i16 = 16777215 & i3;
        this$0.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this$0.getMeasuredHeight(), new int[]{i16, i3, i3, i16}, new float[]{0.0f, this$0.textTop / this$0.getMeasuredHeight(), (this$0.textTop + this$0.textHeight) / this$0.getMeasuredHeight(), 1.0f}, Shader.TileMode.CLAMP));
        this$0.scrollSize.clear();
        this$0.scrollDistance.clear();
        int size = this$0.textList.size();
        for (int i17 = 0; i17 < size; i17++) {
            this$0.scrollSize.add(Integer.valueOf(Random.INSTANCE.nextInt(4) + 5));
            this$0.scrollDistance.add(Float.valueOf(-this$0.m(i17, 0)));
        }
        this$0.postDelayed(this$0.runTask, 20L);
        this$0.isStarting = true;
        this$0.invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.isStarting) {
            e(canvas);
            return;
        }
        int i3 = 0;
        if (!this.isShowed && !this.needShowWithoutAnim) {
            this.textHeight = getPaint().getFontMetrics().bottom - getPaint().getFontMetrics().top;
            this.textTop = ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.textHeight) / 2) + getPaddingTop();
            int size = this.textList.size();
            while (i3 < size) {
                f(canvas, " ", h(i3), this.textTop);
                i3++;
            }
            return;
        }
        this.textHeight = getPaint().getFontMetrics().bottom - getPaint().getFontMetrics().top;
        this.textTop = ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.textHeight) / 2) + getPaddingTop();
        int size2 = this.textList.size();
        while (i3 < size2) {
            f(canvas, String.valueOf(this.textList.get(i3).charValue()), h(i3), this.textTop);
            i3++;
        }
    }

    public final void setNeedShowWithoutAnim(boolean z16) {
        this.needShowWithoutAnim = z16;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        this.textHeight = getPaint().getFontMetrics().bottom - getPaint().getFontMetrics().top;
        this.textTop = ((((getMeasuredHeight() - top) - bottom) - this.textHeight) / 2) + top;
        this.textStart = left;
        super.setPadding(left, top, right, bottom);
    }

    public final void setScrollType(int i3) {
        this.scrollType = i3;
    }

    @Override // android.widget.TextView
    public void setText(@Nullable CharSequence text, @Nullable TextView.BufferType type) {
        String str;
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        this.textList = j(str);
        super.setText(text, type);
    }

    @Override // android.widget.TextView
    public void setTextColor(@Nullable ColorStateList colors) {
        this.textColor = colors != null ? colors.getDefaultColor() : -16777216;
        getPaint().setColor(this.textColor);
        super.setTextColor(colors);
    }

    @Override // android.widget.TextView
    public void setTextColor(int color) {
        this.textColor = color;
        getPaint().setColor(this.textColor);
        super.setTextColor(color);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RollNumberTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList textColors = getTextColors();
        this.textColor = textColors != null ? textColors.getDefaultColor() : -16777216;
        this.textHeight = getPaint().getFontMetrics().bottom - getPaint().getFontMetrics().top;
        this.textTop = ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.textHeight) / 2) + getPaddingTop();
        this.textStart = getPaddingLeft();
        this.textWidth = getPaint().measureText("9");
        this.pointWidth = getPaint().measureText(".");
        this.pointIndex = -1;
        this.scrollType = -1;
        this.startTime = SystemClock.uptimeMillis();
        this.textList = k(this, null, 1, null);
        this.scrollSize = new ArrayList<>();
        this.scrollDistance = new ArrayList<>();
        this.endTime = new ArrayList<>();
        this.valueAnimator = new DecelerateInterpolator();
        this.startTask = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.b
            @Override // java.lang.Runnable
            public final void run() {
                RollNumberTextView.n(RollNumberTextView.this);
            }
        };
        this.runTask = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.RollNumberTextView$runTask$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                z16 = RollNumberTextView.this.isStarting;
                if (z16) {
                    RollNumberTextView.this.postDelayed(this, 20L);
                    RollNumberTextView.this.invalidate();
                }
            }
        };
        this.endTask = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.c
            @Override // java.lang.Runnable
            public final void run() {
                RollNumberTextView.g(RollNumberTextView.this);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RollNumberTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList textColors = getTextColors();
        this.textColor = textColors != null ? textColors.getDefaultColor() : -16777216;
        this.textHeight = getPaint().getFontMetrics().bottom - getPaint().getFontMetrics().top;
        this.textTop = ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.textHeight) / 2) + getPaddingTop();
        this.textStart = getPaddingLeft();
        this.textWidth = getPaint().measureText("9");
        this.pointWidth = getPaint().measureText(".");
        this.pointIndex = -1;
        this.scrollType = -1;
        this.startTime = SystemClock.uptimeMillis();
        this.textList = k(this, null, 1, null);
        this.scrollSize = new ArrayList<>();
        this.scrollDistance = new ArrayList<>();
        this.endTime = new ArrayList<>();
        this.valueAnimator = new DecelerateInterpolator();
        this.startTask = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.b
            @Override // java.lang.Runnable
            public final void run() {
                RollNumberTextView.n(RollNumberTextView.this);
            }
        };
        this.runTask = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.RollNumberTextView$runTask$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                z16 = RollNumberTextView.this.isStarting;
                if (z16) {
                    RollNumberTextView.this.postDelayed(this, 20L);
                    RollNumberTextView.this.invalidate();
                }
            }
        };
        this.endTask = new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.view.c
            @Override // java.lang.Runnable
            public final void run() {
                RollNumberTextView.g(RollNumberTextView.this);
            }
        };
    }
}
