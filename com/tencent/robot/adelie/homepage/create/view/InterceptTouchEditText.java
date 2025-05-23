package com.tencent.robot.adelie.homepage.create.view;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.util.InputMethodUtil;
import h53.QUIInputCountCalculateStrategy;
import h53.QUIInputViewWordCountInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001C\u0018\u00002\u00020\u0001:\u0003NOPB'\b\u0007\u0012\u0006\u0010H\u001a\u00020G\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010K\u001a\u00020\u0006\u00a2\u0006\u0004\bL\u0010MJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0012J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0006J\u0010\u0010#\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010!J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010(\u001a\u00020'J\u0010\u0010*\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010,\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u0006J\u0006\u0010-\u001a\u00020\u0015R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010/R\u0016\u0010:\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00109R\u001c\u0010?\u001a\n <*\u0004\u0018\u00010;0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006Q"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "text", "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "start", "", "charLimit", "l", "Landroid/text/Spannable;", "spannable", "Landroid/util/SparseArray;", "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$d;", "o", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "disallowIntercept", "", "setDisallowParentInterceptTouchEvent", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "id", "onTextContextMenuItem", "count", "setLimitCount", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lh53/k;", "watcher", "setInputViewWatcher", "Lh53/l;", "calculator", "setInputViewWordCountCalculator", "Lh53/e;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "setCalculateStrategy", DomainData.DOMAIN_NAME, "selection", "t", "r", "E", "I", "characterLimitCount", UserInfo.SEX_FEMALE, "Lh53/k;", "inputViewWatcher", "G", "Lh53/l;", "wordCountCalculator", "H", "currentCount", "Lh53/e;", "calculateStrategy", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "J", "Ljava/util/regex/Pattern;", "extraEmoji", "K", "Z", "disallowParentIntercept", "com/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$e", "L", "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$e;", "characterCounterWatcher", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class InterceptTouchEditText extends AppCompatEditText {

    /* renamed from: E, reason: from kotlin metadata */
    private int characterLimitCount;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private h53.k inputViewWatcher;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private h53.l wordCountCalculator;

    /* renamed from: H, reason: from kotlin metadata */
    private int currentCount;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private QUIInputCountCalculateStrategy calculateStrategy;

    /* renamed from: J, reason: from kotlin metadata */
    private final Pattern extraEmoji;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean disallowParentIntercept;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final e characterCounterWatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$a", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$c;", "", "Lh53/e;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", "a", "", "toString", "hashCode", "other", "", "equals", "I", "getEmojiCount", "()I", "setEmojiCount", "(I)V", "emojiCount", "b", "getEmoticonCount", "setEmoticonCount", "emoticonCount", "c", "getAsciiCount", "setAsciiCount", "asciiCount", "d", "getTextCount", "setTextCount", "textCount", "<init>", "(IIII)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.create.view.InterceptTouchEditText$c, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class CharacterCountInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int emojiCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int emoticonCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int asciiCount;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int textCount;

        public CharacterCountInfo() {
            this(0, 0, 0, 0, 15, null);
        }

        public final int a(@NotNull QUIInputCountCalculateStrategy strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            return (int) (Math.ceil(this.emojiCount * strategy.getEmojiCount()) + Math.ceil(this.emoticonCount * strategy.getEmoticonCount()) + Math.ceil(this.textCount * strategy.getTextCount()) + Math.ceil(this.asciiCount * strategy.getAsciiCount()));
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CharacterCountInfo)) {
                return false;
            }
            CharacterCountInfo characterCountInfo = (CharacterCountInfo) other;
            if (this.emojiCount == characterCountInfo.emojiCount && this.emoticonCount == characterCountInfo.emoticonCount && this.asciiCount == characterCountInfo.asciiCount && this.textCount == characterCountInfo.textCount) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.emojiCount * 31) + this.emoticonCount) * 31) + this.asciiCount) * 31) + this.textCount;
        }

        @NotNull
        public String toString() {
            return "CharacterCountInfo(emojiCount=" + this.emojiCount + ", emoticonCount=" + this.emoticonCount + ", asciiCount=" + this.asciiCount + ", textCount=" + this.textCount + ")";
        }

        public CharacterCountInfo(int i3, int i16, int i17, int i18) {
            this.emojiCount = i3;
            this.emoticonCount = i16;
            this.asciiCount = i17;
            this.textCount = i18;
        }

        public /* synthetic */ CharacterCountInfo(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB!\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "start", "end", "c", "type", "<init>", "(III)V", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.create.view.InterceptTouchEditText$d, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class SpanPair {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int start;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int end;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$d$a;", "", "Landroid/text/Spannable;", "spans", TtmlNode.TAG_SPAN, "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$d;", "a", "", "EMOJI_TYPE", "I", "OTHER_TYPE", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.adelie.homepage.create.view.InterceptTouchEditText$d$a, reason: from kotlin metadata */
        /* loaded from: classes25.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final SpanPair a(@NotNull Spannable spans, @NotNull Object span) {
                Intrinsics.checkNotNullParameter(spans, "spans");
                Intrinsics.checkNotNullParameter(span, "span");
                return new SpanPair(spans.getSpanStart(span), spans.getSpanEnd(span), 1);
            }

            Companion() {
            }
        }

        public SpanPair(int i3, int i16, int i17) {
            this.start = i3;
            this.end = i16;
            this.type = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: b, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: c, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpanPair)) {
                return false;
            }
            SpanPair spanPair = (SpanPair) other;
            if (this.start == spanPair.start && this.end == spanPair.end && this.type == spanPair.type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.start * 31) + this.end) * 31) + this.type;
        }

        @NotNull
        public String toString() {
            return "SpanPair(start=" + this.start + ", end=" + this.end + ", type=" + this.type + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"com/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$e", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "", "d", "Z", "shouldLimitText", "e", "I", "removeStart", "f", "removeEnd", "", tl.h.F, "Ljava/lang/String;", "resultText", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements TextWatcher {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean shouldLimitText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int removeStart;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int removeEnd;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String resultText;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Context f366266m;

        e(Context context) {
            this.f366266m = context;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (this.shouldLimitText) {
                QQToast.makeText(this.f366266m, 0, "\u5b57\u6570\u5df2\u8fbe\u5230\u4e0a\u9650", 0).show();
                Intrinsics.checkNotNull(s16);
                s16.replace(this.removeStart, this.removeEnd, "");
                this.shouldLimitText = false;
            }
            h53.k kVar = InterceptTouchEditText.this.inputViewWatcher;
            if (kVar != null) {
                kVar.afterTextChanged(s16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            h53.k kVar = InterceptTouchEditText.this.inputViewWatcher;
            if (kVar != null) {
                kVar.beforeTextChanged(s16, start, count, after);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            h53.k kVar = InterceptTouchEditText.this.inputViewWatcher;
            if (kVar != null) {
                kVar.onTextChanged(s16, start, before, count);
            }
            h53.l lVar = InterceptTouchEditText.this.wordCountCalculator;
            if (lVar == null) {
                CharacterCountInfo m3 = InterceptTouchEditText.this.m(s16);
                InterceptTouchEditText interceptTouchEditText = InterceptTouchEditText.this;
                interceptTouchEditText.currentCount = m3.a(interceptTouchEditText.calculateStrategy);
                if (InterceptTouchEditText.this.currentCount <= InterceptTouchEditText.this.characterLimitCount) {
                    this.shouldLimitText = false;
                    return;
                }
                InterceptTouchEditText interceptTouchEditText2 = InterceptTouchEditText.this;
                Intrinsics.checkNotNull(s16);
                int i3 = count + start;
                float a16 = InterceptTouchEditText.this.characterLimitCount - (m3.a(InterceptTouchEditText.this.calculateStrategy) - interceptTouchEditText2.m(s16.subSequence(start, i3)).a(InterceptTouchEditText.this.calculateStrategy));
                if (a16 >= 0.0f) {
                    this.removeStart = InterceptTouchEditText.this.l(s16, start, a16);
                    this.removeEnd = i3;
                } else {
                    this.removeStart = InterceptTouchEditText.this.l(s16, 0, r6.characterLimitCount);
                    this.removeEnd = s16.length();
                }
                this.shouldLimitText = true;
                return;
            }
            InterceptTouchEditText interceptTouchEditText3 = InterceptTouchEditText.this;
            QUIInputViewWordCountInfo a17 = lVar.a(s16, start, before, count);
            interceptTouchEditText3.currentCount = a17.getLength();
            if (interceptTouchEditText3.currentCount <= interceptTouchEditText3.characterLimitCount) {
                this.shouldLimitText = false;
            } else {
                this.resultText = a17.getResultText();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InterceptTouchEditText(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(InterceptTouchEditText this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h53.k kVar = this$0.inputViewWatcher;
        if (kVar != null) {
            kVar.f8(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l(CharSequence text, int start, float charLimit) {
        int length;
        int g16;
        SparseArray<SpanPair> o16 = o(new QQText(text, 3), text);
        AsciiHalfCharacterCounter asciiHalfCharacterCounter = new AsciiHalfCharacterCounter(0, 0, 0, 0, false, this.calculateStrategy, 31, null);
        float i3 = charLimit - asciiHalfCharacterCounter.i();
        while (start < text.length() && !asciiHalfCharacterCounter.getIsLimit() && i3 > 0.0f) {
            int indexOfKey = o16.indexOfKey(start);
            if (indexOfKey >= 0) {
                SpanPair valueAt = o16.valueAt(indexOfKey);
                Intrinsics.checkNotNullExpressionValue(valueAt, "lookups.valueAt(spanIndex)");
                g16 = asciiHalfCharacterCounter.f(valueAt, i3);
            } else {
                int i16 = (-indexOfKey) - 1;
                if (i16 < o16.size()) {
                    length = o16.valueAt(i16).getStart();
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
    public final CharacterCountInfo m(CharSequence text) {
        int length;
        AsciiHalfCharacterCounter asciiHalfCharacterCounter = new AsciiHalfCharacterCounter(0, 0, 0, 0, false, this.calculateStrategy, 31, null);
        if (text != null) {
            SparseArray<SpanPair> o16 = o(new QQText(text, 3), text);
            int i3 = 0;
            while (i3 < text.length()) {
                int indexOfKey = o16.indexOfKey(i3);
                if (indexOfKey >= 0) {
                    SpanPair valueAt = o16.valueAt(indexOfKey);
                    Intrinsics.checkNotNullExpressionValue(valueAt, "lookups.valueAt(spanIndex)");
                    SpanPair spanPair = valueAt;
                    i3 += spanPair.getEnd() - spanPair.getStart();
                    asciiHalfCharacterCounter.b(spanPair);
                } else {
                    int i16 = (-indexOfKey) - 1;
                    if (i16 < o16.size()) {
                        length = o16.valueAt(i16).getStart();
                    } else {
                        length = text.length();
                    }
                    asciiHalfCharacterCounter.c(text, i3, length);
                    i3 += length - i3;
                }
            }
        }
        return asciiHalfCharacterCounter.h();
    }

    private final SparseArray<SpanPair> o(Spannable spannable, CharSequence text) {
        SparseArray<SpanPair> sparseArray = new SparseArray<>();
        Object[] allSpans = spannable.getSpans(0, spannable.length(), Object.class);
        Intrinsics.checkNotNullExpressionValue(allSpans, "allSpans");
        int i3 = 0;
        for (Object obj : allSpans) {
            if (obj instanceof ReplacementSpan) {
                SpanPair a16 = SpanPair.INSTANCE.a(spannable, obj);
                sparseArray.append(a16.getStart(), a16);
                if (a16.getStart() > i3) {
                    Matcher matcher = this.extraEmoji.matcher(text.subSequence(i3, a16.getStart()));
                    while (matcher.find()) {
                        int start = matcher.start() + i3;
                        if (sparseArray.indexOfKey(start) < 0) {
                            sparseArray.append(start, new SpanPair(start, matcher.end() + i3, 0));
                        }
                    }
                }
                i3 = Math.max(i3, a16.getEnd());
            }
        }
        if (text.length() > i3) {
            Matcher matcher2 = this.extraEmoji.matcher(text.subSequence(i3, text.length()));
            while (matcher2.find()) {
                int start2 = matcher2.start() + i3;
                if (sparseArray.indexOfKey(start2) < 0) {
                    sparseArray.append(start2, new SpanPair(start2, matcher2.end() + i3, 0));
                }
            }
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(InterceptTouchEditText this$0) {
        ClipboardManager clipboardManager;
        ClipData clipData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.getContext().getSystemService("clipboard");
        if (systemService instanceof ClipboardManager) {
            clipboardManager = (ClipboardManager) systemService;
        } else {
            clipboardManager = null;
        }
        if (clipboardManager != null) {
            clipData = ClipboardMonitor.getPrimaryClip(clipboardManager);
        } else {
            clipData = null;
        }
        if (clipData != null && clipData.getItemCount() > 0) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText(null, clipData.getItemAt(0).getText().toString()));
        }
    }

    public static /* synthetic */ void u(InterceptTouchEditText interceptTouchEditText, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = -1;
        }
        interceptTouchEditText.t(i3);
    }

    public final int n(@Nullable CharSequence text) {
        return m(text).a(this.calculateStrategy);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@Nullable EditorInfo outAttrs) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(outAttrs);
        if (onCreateInputConnection != null && outAttrs != null && getImeOptions() != 0) {
            outAttrs.imeOptions &= -1073741825;
        }
        return onCreateInputConnection;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int id5) {
        switch (id5) {
            case 16908320:
            case 16908321:
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.view.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterceptTouchEditText.s(InterceptTouchEditText.this);
                    }
                }, 500L);
                break;
        }
        return super.onTextContextMenuItem(id5);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (hasFocus()) {
            getParent().requestDisallowInterceptTouchEvent(true);
            if ((event.getAction() & 255) == 1) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else if (this.disallowParentIntercept) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(event);
    }

    /* renamed from: p, reason: from getter */
    public final int getCurrentCount() {
        return this.currentCount;
    }

    /* renamed from: q, reason: from getter */
    public final int getCharacterLimitCount() {
        return this.characterLimitCount;
    }

    public final void r() {
        InputMethodUtil.hide(this);
    }

    public final void setCalculateStrategy(@NotNull QUIInputCountCalculateStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.calculateStrategy = strategy;
    }

    public final void setDisallowParentInterceptTouchEvent(boolean disallowIntercept) {
        this.disallowParentIntercept = disallowIntercept;
    }

    public final void setInputViewWatcher(@Nullable h53.k watcher) {
        this.inputViewWatcher = watcher;
    }

    public final void setInputViewWordCountCalculator(@NotNull h53.l calculator) {
        Intrinsics.checkNotNullParameter(calculator, "calculator");
        this.wordCountCalculator = calculator;
    }

    public final void setLimitCount(int count) {
        this.characterLimitCount = count;
    }

    public final void t(int selection) {
        int i3;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        if (selection != -1) {
            setSelection(selection);
        } else {
            Editable text = getText();
            if (text != null) {
                i3 = text.length();
            } else {
                i3 = 0;
            }
            setSelection(i3);
        }
        InputMethodUtil.show(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InterceptTouchEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ InterceptTouchEditText(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? R.attr.editTextStyle : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InterceptTouchEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.characterLimitCount = Integer.MAX_VALUE;
        this.calculateStrategy = new QUIInputCountCalculateStrategy(0.0d, 0.0d, 0.0d, 0.0d, 15, null);
        this.extraEmoji = Pattern.compile("[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]|[\\ud83e\\udc00-\\ud83e\\udfff]|[\\ud83f\\udc00-\\ud83f\\udfff]");
        e eVar = new e(context);
        this.characterCounterWatcher = eVar;
        setEditableFactory(new a());
        addTextChangedListener(eVar);
        setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.robot.adelie.homepage.create.view.x
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                InterceptTouchEditText.c(InterceptTouchEditText.this, view, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\b\b\u0002\u0010&\u001a\u00020\u000b\u0012\b\b\u0002\u0010)\u001a\u00020\u000b\u0012\b\b\u0002\u0010,\u001a\u00020\u000b\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u0012\u0006\u00108\u001a\u000202\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0017J\t\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010)\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\"\u0010,\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010-\u001a\u0004\b\r\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$b;", "", "", "character", "", "j", "d", "", "i", "", "str", "", ReportConstant.COSTREPORT_PREFIX, "e", "limit", "g", "", "a", "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$d;", TtmlNode.TAG_SPAN, "b", "c", "f", "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText$c;", tl.h.F, "", "toString", "hashCode", "other", "equals", "I", "getMEmojiCount", "()I", "setMEmojiCount", "(I)V", "mEmojiCount", "getMEmoticonCount", "setMEmoticonCount", "mEmoticonCount", "getMAsciiCount", "setMAsciiCount", "mAsciiCount", "getMNonAsciiCount", "setMNonAsciiCount", "mNonAsciiCount", "Z", "()Z", "setLimit", "(Z)V", "isLimit", "Lh53/e;", "Lh53/e;", "getStrategy", "()Lh53/e;", "setStrategy", "(Lh53/e;)V", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "<init>", "(IIIIZLh53/e;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.create.view.InterceptTouchEditText$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class AsciiHalfCharacterCounter {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int mEmojiCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int mEmoticonCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int mAsciiCount;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int mNonAsciiCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isLimit;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private QUIInputCountCalculateStrategy strategy;

        public AsciiHalfCharacterCounter(int i3, int i16, int i17, int i18, boolean z16, @NotNull QUIInputCountCalculateStrategy strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.mEmojiCount = i3;
            this.mEmoticonCount = i16;
            this.mAsciiCount = i17;
            this.mNonAsciiCount = i18;
            this.isLimit = z16;
            this.strategy = strategy;
        }

        private final boolean d(char character) {
            if (character >= '\u0080') {
                return true;
            }
            return false;
        }

        private final boolean j(char character) {
            if (d(character)) {
                this.isLimit = true;
                return false;
            }
            if (character < '\u0080') {
                this.mAsciiCount++;
            } else {
                this.mNonAsciiCount++;
            }
            return true;
        }

        public final void a(char character) {
            if (character < '\u0080') {
                this.mAsciiCount++;
            } else {
                this.mNonAsciiCount++;
            }
        }

        public final void b(@NotNull SpanPair span) {
            Intrinsics.checkNotNullParameter(span, "span");
            if (span.getType() == 0) {
                this.mEmojiCount++;
            } else {
                this.mEmoticonCount++;
            }
        }

        public final void c(@NotNull CharSequence str, int s16, int e16) {
            Intrinsics.checkNotNullParameter(str, "str");
            while (s16 < e16) {
                a(str.charAt(s16));
                s16++;
            }
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsLimit() {
            return this.isLimit;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AsciiHalfCharacterCounter)) {
                return false;
            }
            AsciiHalfCharacterCounter asciiHalfCharacterCounter = (AsciiHalfCharacterCounter) other;
            if (this.mEmojiCount == asciiHalfCharacterCounter.mEmojiCount && this.mEmoticonCount == asciiHalfCharacterCounter.mEmoticonCount && this.mAsciiCount == asciiHalfCharacterCounter.mAsciiCount && this.mNonAsciiCount == asciiHalfCharacterCounter.mNonAsciiCount && this.isLimit == asciiHalfCharacterCounter.isLimit && Intrinsics.areEqual(this.strategy, asciiHalfCharacterCounter.strategy)) {
                return true;
            }
            return false;
        }

        public final int f(@NotNull SpanPair span, float limit) {
            Intrinsics.checkNotNullParameter(span, "span");
            if (limit < 1.0f) {
                this.isLimit = true;
                return 0;
            }
            b(span);
            return span.getEnd() - span.getStart();
        }

        public final int g(@NotNull CharSequence str, int s16, int e16, float limit) {
            Intrinsics.checkNotNullParameter(str, "str");
            float i3 = i() + limit;
            int i16 = s16;
            while (true) {
                if (i16 >= e16 || limit <= 0.0f) {
                    break;
                }
                if (limit >= 1.0f) {
                    a(str.charAt(i16));
                    i16++;
                } else {
                    if (!j(str.charAt(i16))) {
                        this.isLimit = true;
                        break;
                    }
                    i16++;
                }
                limit = i3 - i();
            }
            if (limit <= 0.0f) {
                this.isLimit = true;
            }
            return i16 - s16;
        }

        @NotNull
        public final CharacterCountInfo h() {
            return new CharacterCountInfo(this.mEmojiCount, this.mEmoticonCount, this.mAsciiCount, this.mNonAsciiCount);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = ((((((this.mEmojiCount * 31) + this.mEmoticonCount) * 31) + this.mAsciiCount) * 31) + this.mNonAsciiCount) * 31;
            boolean z16 = this.isLimit;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return ((i3 + i16) * 31) + this.strategy.hashCode();
        }

        public final float i() {
            return (float) ((this.mEmojiCount * this.strategy.getEmojiCount()) + (this.mEmoticonCount * this.strategy.getEmoticonCount()) + (this.mNonAsciiCount * this.strategy.getTextCount()) + (this.mAsciiCount * this.strategy.getAsciiCount()));
        }

        @NotNull
        public String toString() {
            return "AsciiHalfCharacterCounter(mEmojiCount=" + this.mEmojiCount + ", mEmoticonCount=" + this.mEmoticonCount + ", mAsciiCount=" + this.mAsciiCount + ", mNonAsciiCount=" + this.mNonAsciiCount + ", isLimit=" + this.isLimit + ", strategy=" + this.strategy + ")";
        }

        public /* synthetic */ AsciiHalfCharacterCounter(int i3, int i16, int i17, int i18, boolean z16, QUIInputCountCalculateStrategy qUIInputCountCalculateStrategy, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18, (i19 & 16) != 0 ? false : z16, qUIInputCountCalculateStrategy);
        }
    }
}
