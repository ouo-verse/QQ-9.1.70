package com.tencent.mobileqq.widget.inputview;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import h53.AsciiHalfCharacterCounter;
import h53.CharacterCountInfo;
import h53.QUIInputCountCalculateStrategy;
import h53.QUIInputViewWordCountInfo;
import h53.SpanPair;
import h53.k;
import h53.l;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001D\b\u0007\u0018\u00002\u00020\u0001:\u0001PB1\b\u0007\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u0012\b\b\u0002\u0010L\u001a\u00020\u0004\u0012\b\b\u0002\u0010M\u001a\u00020\u0004\u00a2\u0006\u0004\bN\u0010OJ \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 J\u0018\u0010%\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0014J(\u0010*\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0014R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010,R\u0016\u0010;\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010,R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010,R\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010,R\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "Landroid/widget/EditText;", "", "text", "", "start", "", "charLimit", "o", "", "u", "", "t", ReportConstant.COSTREPORT_PREFIX, "p", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "count", "setLimitCount", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lh53/k;", "watcher", "setInputViewWatcher", "Lh53/l;", "calculator", "setInputViewWordCountCalculator", "Lh53/e;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "setCalculateStrategy", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText$b;", "listener", "setScrollChangedListener", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "horiz", "vert", "oldHoriz", "oldVert", "onScrollChanged", "d", "I", "characterLimitCount", "e", "Lh53/k;", "inputViewWatcher", "f", "Lh53/l;", "wordCountCalculator", h.F, "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText$b;", "onScrollChangedListener", "i", "currentCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lh53/e;", "calculateStrategy", BdhLogUtil.LogTag.Tag_Conn, "offsetHeight", "D", UserInfo.SEX_FEMALE, "scrollBeginY", "E", "scrollVert", "lineCountTmp", "com/tencent/mobileqq/widget/inputview/CharacterCountEditText$c", "G", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText$c;", "characterCounterWatcher", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "b", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes20.dex */
public final class CharacterCountEditText extends EditText {

    /* renamed from: C, reason: from kotlin metadata */
    private int offsetHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private float scrollBeginY;

    /* renamed from: E, reason: from kotlin metadata */
    private int scrollVert;

    /* renamed from: F, reason: from kotlin metadata */
    private int lineCountTmp;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final c characterCounterWatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int characterLimitCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k inputViewWatcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private l wordCountCalculator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b onScrollChangedListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QUIInputCountCalculateStrategy calculateStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/widget/inputview/CharacterCountEditText$a", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends Editable.Factory {
        a() {
        }

        @Override // android.text.Editable.Factory
        @NotNull
        public Editable newEditable(@Nullable CharSequence source) {
            if (source instanceof h53.b) {
                return (Editable) source;
            }
            return new h53.b(source, 2, 20);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText$b;", "", "", "horiz", "vert", "oldHoriz", "oldVert", "", "onScrollChanged", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/widget/inputview/CharacterCountEditText$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "", "d", "Z", "shouldLimitText", "e", "I", "removeStart", "f", "removeEnd", "", h.F, "Ljava/lang/String;", "resultText", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements TextWatcher {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean shouldLimitText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int removeStart;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int removeEnd;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String resultText;

        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (this.shouldLimitText) {
                Intrinsics.checkNotNull(s16);
                s16.replace(this.removeStart, this.removeEnd, "");
                this.shouldLimitText = false;
            }
            k kVar = CharacterCountEditText.this.inputViewWatcher;
            if (kVar != null) {
                kVar.afterTextChanged(s16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            k kVar = CharacterCountEditText.this.inputViewWatcher;
            if (kVar != null) {
                kVar.beforeTextChanged(s16, start, count, after);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            k kVar = CharacterCountEditText.this.inputViewWatcher;
            if (kVar != null) {
                kVar.onTextChanged(s16, start, before, count);
            }
            int lineCount = CharacterCountEditText.this.getLineCount();
            if (CharacterCountEditText.this.lineCountTmp != lineCount) {
                CharacterCountEditText.this.lineCountTmp = lineCount;
                CharacterCountEditText.this.p();
            }
            l lVar = CharacterCountEditText.this.wordCountCalculator;
            if (lVar != null) {
                CharacterCountEditText characterCountEditText = CharacterCountEditText.this;
                QUIInputViewWordCountInfo a16 = lVar.a(s16, start, before, count);
                characterCountEditText.currentCount = a16.getLength();
                if (characterCountEditText.currentCount <= characterCountEditText.characterLimitCount) {
                    this.shouldLimitText = false;
                    return;
                } else {
                    this.resultText = a16.getResultText();
                    return;
                }
            }
            CharacterCountInfo a17 = h53.c.a(s16, CharacterCountEditText.this.calculateStrategy);
            CharacterCountEditText characterCountEditText2 = CharacterCountEditText.this;
            characterCountEditText2.currentCount = a17.c(characterCountEditText2.calculateStrategy);
            if (CharacterCountEditText.this.currentCount <= CharacterCountEditText.this.characterLimitCount) {
                this.shouldLimitText = false;
                return;
            }
            Intrinsics.checkNotNull(s16);
            int i3 = count + start;
            float c16 = CharacterCountEditText.this.characterLimitCount - (a17.c(CharacterCountEditText.this.calculateStrategy) - h53.c.a(s16.subSequence(start, i3), CharacterCountEditText.this.calculateStrategy).c(CharacterCountEditText.this.calculateStrategy));
            if (c16 >= 0.0f) {
                this.removeStart = CharacterCountEditText.this.o(s16, start, c16);
                this.removeEnd = i3;
            } else {
                this.removeStart = CharacterCountEditText.this.o(s16, 0, r6.characterLimitCount);
                this.removeEnd = s16.length();
            }
            this.shouldLimitText = true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/widget/inputview/CharacterCountEditText$d", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() == 0) {
                CharacterCountEditText.this.scrollBeginY = event.getY();
                CharacterCountEditText.this.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
            if (CharacterCountEditText.this.canScrollVertically(1)) {
                if (CharacterCountEditText.this.t() && event.getY() >= CharacterCountEditText.this.scrollBeginY) {
                    CharacterCountEditText.this.getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    CharacterCountEditText.this.getParent().requestDisallowInterceptTouchEvent(true);
                }
            } else if (CharacterCountEditText.this.canScrollVertically(-1)) {
                if (CharacterCountEditText.this.s() && event.getY() <= CharacterCountEditText.this.scrollBeginY) {
                    CharacterCountEditText.this.getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    CharacterCountEditText.this.getParent().requestDisallowInterceptTouchEvent(true);
                }
            } else {
                CharacterCountEditText.this.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CharacterCountEditText(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int o(CharSequence text, int start, float charLimit) {
        int length;
        int g16;
        SparseArray<SpanPair> c16 = h53.c.f404346a.c(new QQText(text, 3), text);
        AsciiHalfCharacterCounter asciiHalfCharacterCounter = new AsciiHalfCharacterCounter(0, 0, 0, 0, false, this.calculateStrategy, 31, null);
        float i3 = charLimit - asciiHalfCharacterCounter.i();
        while (start < text.length() && !asciiHalfCharacterCounter.getIsLimit() && i3 > 0.0f) {
            int indexOfKey = c16.indexOfKey(start);
            if (indexOfKey >= 0) {
                SpanPair valueAt = c16.valueAt(indexOfKey);
                Intrinsics.checkNotNullExpressionValue(valueAt, "lookups.valueAt(spanIndex)");
                g16 = asciiHalfCharacterCounter.f(valueAt, i3);
            } else {
                int i16 = (-indexOfKey) - 1;
                if (i16 < c16.size()) {
                    length = c16.valueAt(i16).getStart();
                } else {
                    length = text.length();
                }
                g16 = asciiHalfCharacterCounter.g(text, start, length, i3);
            }
            float i17 = charLimit - asciiHalfCharacterCounter.i();
            if (i17 >= 0.0f) {
                start += g16;
            }
            i3 = i17;
        }
        return start;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        this.offsetHeight = getLayout().getHeight() - ((getMeasuredHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s() {
        if (this.scrollVert == this.offsetHeight) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t() {
        if (this.scrollVert == 0) {
            return true;
        }
        return false;
    }

    private final void u() {
        setOnTouchListener(new d());
    }

    @Override // android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@Nullable EditorInfo outAttrs) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(outAttrs);
        if (onCreateInputConnection != null && outAttrs != null && getImeOptions() != 0) {
            outAttrs.imeOptions &= -1073741825;
        }
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        p();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        b bVar = this.onScrollChangedListener;
        if (bVar != null) {
            bVar.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        }
        this.scrollVert = vert;
        if (vert == this.offsetHeight || vert == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    /* renamed from: q, reason: from getter */
    public final int getCurrentCount() {
        return this.currentCount;
    }

    /* renamed from: r, reason: from getter */
    public final int getCharacterLimitCount() {
        return this.characterLimitCount;
    }

    public final void setCalculateStrategy(@NotNull QUIInputCountCalculateStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.calculateStrategy = strategy;
    }

    public final void setInputViewWatcher(@NotNull k watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        this.inputViewWatcher = watcher;
    }

    public final void setInputViewWordCountCalculator(@NotNull l calculator) {
        Intrinsics.checkNotNullParameter(calculator, "calculator");
        this.wordCountCalculator = calculator;
    }

    public final void setLimitCount(int count) {
        this.characterLimitCount = count;
    }

    public final void setScrollChangedListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onScrollChangedListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CharacterCountEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CharacterCountEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CharacterCountEditText(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? R.attr.editTextStyle : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CharacterCountEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.characterLimitCount = Integer.MAX_VALUE;
        this.calculateStrategy = new QUIInputCountCalculateStrategy(0.0d, 0.0d, 0.0d, 0.0d, 15, null);
        c cVar = new c();
        this.characterCounterWatcher = cVar;
        setEditableFactory(new a());
        addTextChangedListener(cVar);
        u();
    }
}
