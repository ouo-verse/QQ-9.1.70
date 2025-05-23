package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.TopicHashtagTool;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006J:\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00110\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0006R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/TopicHashtagTool;", "", "", "", "start", "end", "", "shouldHighlightSingleChar", "", tl.h.F, "Landroid/text/Editable;", "editable", "index", "k", "j", "shouldHighlightSingleCharAtLast", "", "Lkotlin/Pair;", "i", "", "a", "Ljava/lang/String;", "logTag", "b", "I", "maxTopicWordLength", "<init>", "(Ljava/lang/String;I)V", "c", "Companion", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicHashtagTool {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final yn1.b f221938d = new yn1.b(0, 0, 2, null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final ClosedRange<Integer>[] f221939e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Comparator<ClosedRange<Integer>> f221940f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final a f221941g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int maxTopicWordLength;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001-\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\n*\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u001a\u0010\u0017\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004R\u001b\u0010\u001a\u001a\u00060\u0018j\u0002`\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010%R \u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040!0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/TopicHashtagTool$Companion;", "", "Landroid/text/Spanned;", "text", "", "f", "code", "", "d", "ch", "", tl.h.F, "", "index", "j", "Landroid/text/Editable;", "doHighLight", "", "b", "k", "start", "end", "i", "e", "Lyn1/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/topic/panel/EditorTopicSpan;", "SINGLE_HASHTAG", "Lyn1/b;", "g", "()Lyn1/b;", "DEBUG", "Z", "", "Lkotlin/ranges/ClosedRange;", "ILLEGAL_UNICODE_RANGES", "[Lkotlin/ranges/ClosedRange;", "INVALID_INDEX", "I", "RESULT_INVALID_INPUT", "RESULT_OK", "RESULT_OVER_TOPIC_LENGTH", "RESULT_UNKNOWN", "Ljava/util/Comparator;", "comparator", "Ljava/util/Comparator;", "com/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/TopicHashtagTool$a", "tempRange", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/TopicHashtagTool$a;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, Editable editable, int i3, boolean z16, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                z16 = false;
            }
            companion.b(editable, i3, z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float d(int code) {
            if (code > 128) {
                return 1.0f;
            }
            return 0.5f;
        }

        private final int f(Spanned text) {
            return text.getSpanStart(g());
        }

        public final void b(@NotNull Editable text, int index, boolean doHighLight) {
            boolean z16;
            Intrinsics.checkNotNullParameter(text, "text");
            int f16 = f(text);
            boolean z17 = true;
            if (f16 != index) {
                if (f16 >= 0 && f16 < text.length()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    text.removeSpan(g());
                }
            }
            if (doHighLight) {
                if (index < 0 || index >= text.length()) {
                    z17 = false;
                }
                if (z17) {
                    text.setSpan(g(), index, index + 1, 33);
                }
            }
        }

        public final float e(@NotNull CharSequence charSequence, int i3, int i16) {
            Intrinsics.checkNotNullParameter(charSequence, "<this>");
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            yl1.i.f450608a.c(charSequence, i3, i16, new Function3<Integer, Integer, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.TopicHashtagTool$Companion$countTextByCodePoints$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3) {
                    invoke(num.intValue(), num2.intValue(), num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i17, int i18, int i19) {
                    float d16;
                    Ref.FloatRef floatRef2 = Ref.FloatRef.this;
                    float f16 = floatRef2.element;
                    d16 = TopicHashtagTool.INSTANCE.d(i18);
                    floatRef2.element = f16 + d16;
                }
            });
            return floatRef.element;
        }

        @NotNull
        public final yn1.b g() {
            return TopicHashtagTool.f221938d;
        }

        public final boolean h(int ch5) {
            if (ch5 != 35 && ch5 != 65283) {
                return false;
            }
            return true;
        }

        public final boolean i(@NotNull CharSequence text, int start, int end) {
            boolean z16;
            Intrinsics.checkNotNullParameter(text, "text");
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (end - start > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            booleanRef.element = z16;
            yl1.i.f450608a.c(text, start, end, new Function3<Integer, Integer, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.TopicHashtagTool$Companion$isLegalTopicContent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3) {
                    invoke(num.intValue(), num2.intValue(), num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, int i16, int i17) {
                    if (TopicHashtagTool.INSTANCE.k(i16)) {
                        return;
                    }
                    Ref.BooleanRef.this.element = false;
                }
            });
            return booleanRef.element;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean j(@NotNull CharSequence charSequence, int i3) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(charSequence, "<this>");
            if (!h(charSequence.charAt(i3)) || !(charSequence instanceof Spanned)) {
                return false;
            }
            Object[] spans = ((Spanned) charSequence).getSpans(i3, i3 + 1, ReplacementSpan.class);
            if (spans != null) {
                if (spans.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    z16 = false;
                    if (z16) {
                        return false;
                    }
                    return true;
                }
            }
            z16 = true;
            if (z16) {
            }
        }

        public final boolean k(int ch5) {
            int binarySearch$default;
            TopicHashtagTool.f221941g.d(ch5);
            if (!Character.isWhitespace(ch5) && !h(ch5)) {
                binarySearch$default = ArraysKt___ArraysJvmKt.binarySearch$default(TopicHashtagTool.f221939e, TopicHashtagTool.f221941g, TopicHashtagTool.f221940f, 0, 0, 12, null);
                if (binarySearch$default < 0) {
                    return true;
                }
            }
            return false;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0003\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/TopicHashtagTool$a", "Lkotlin/ranges/ClosedRange;", "", "d", "I", "c", "()Ljava/lang/Integer;", "(I)V", "start", "b", "endInclusive", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements ClosedRange<Integer> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int start;

        a() {
        }

        public boolean a(int i3) {
            return ClosedRange.DefaultImpls.contains(this, Integer.valueOf(i3));
        }

        @Override // kotlin.ranges.ClosedRange
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer getEndInclusive() {
            return getStart();
        }

        @Override // kotlin.ranges.ClosedRange
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer getStart() {
            return Integer.valueOf(this.start);
        }

        @Override // kotlin.ranges.ClosedRange
        public /* bridge */ /* synthetic */ boolean contains(Integer num) {
            return a(num.intValue());
        }

        public void d(int i3) {
            this.start = i3;
        }

        @Override // kotlin.ranges.ClosedRange
        public boolean isEmpty() {
            return ClosedRange.DefaultImpls.isEmpty(this);
        }
    }

    static {
        IntRange until;
        IntRange until2;
        IntRange until3;
        IntRange until4;
        IntRange until5;
        IntRange until6;
        until = RangesKt___RangesKt.until(0, 48);
        until2 = RangesKt___RangesKt.until(58, 65);
        until3 = RangesKt___RangesKt.until(91, 97);
        until4 = RangesKt___RangesKt.until(65280, 65296);
        until5 = RangesKt___RangesKt.until(65306, 65313);
        until6 = RangesKt___RangesKt.until(65339, 65345);
        f221939e = new ClosedRange[]{until, until2, until3, new IntRange(123, 127), new IntRange(128, 255), new IntRange(8192, 8303), new IntRange(8528, 8591), new IntRange(8592, 8703), new IntRange(AppConstants.RichMediaErrorCode.ERROR_STREAM_PTT_FRIEND_BLOCK, 9471), new IntRange(11904, 12031), new IntRange(12288, 12351), new IntRange(12352, 12447), new IntRange(12448, 12543), new IntRange(12736, 12783), new IntRange(65072, 65103), new IntRange(65104, 65135), until4, until5, until6, new IntRange(65371, 65519), new IntRange(127744, 128511), new IntRange(128512, 128591), new IntRange(128640, 128767), new IntRange(129280, 129535), new IntRange(129648, 129791)};
        f221940f = new Comparator() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int g16;
                g16 = TopicHashtagTool.g((ClosedRange) obj, (ClosedRange) obj2);
                return g16;
            }
        };
        f221941g = new a();
    }

    public TopicHashtagTool(@NotNull String logTag, int i3) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        this.logTag = logTag;
        this.maxTopicWordLength = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(ClosedRange closedRange, ClosedRange closedRange2) {
        if (((Number) closedRange.getEndInclusive()).intValue() < ((Number) closedRange2.getStart()).intValue()) {
            return -1;
        }
        if (((Number) closedRange.getStart()).intValue() > ((Number) closedRange2.getEndInclusive()).intValue()) {
            return 1;
        }
        return 0;
    }

    private final void h(CharSequence charSequence, int i3, int i16, boolean z16) {
        String str;
        boolean z17 = false;
        if (i3 >= 0 && i3 <= i16) {
            z17 = true;
        }
        if (z17 && i16 <= charSequence.length()) {
            str = charSequence.subSequence(i3, i16).toString();
        } else {
            str = "indexOutOfBound";
        }
        QLog.d(this.logTag, 4, "tryHighLightATopicSpan|start=" + i3 + ", end=" + i16 + ", shouldHighlightSingleChar=" + z16 + " substring=" + str);
    }

    @NotNull
    public final List<Pair<Integer, Integer>> i(@NotNull final Editable editable, int start, final int end, boolean shouldHighlightSingleCharAtLast) {
        boolean z16;
        List<Pair<Integer, Integer>> emptyList;
        Intrinsics.checkNotNullParameter(editable, "editable");
        h(editable, start, end, shouldHighlightSingleCharAtLast);
        if (editable.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || start < 0 || end > editable.length() || start >= end) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        final LinkedList linkedList = new LinkedList();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        yl1.i.f450608a.c(editable, start, end, new Function3<Integer, Integer, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.TopicHashtagTool$dryRunHighLightABatchOfTopicSpan$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3) {
                invoke(num.intValue(), num2.intValue(), num3.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, int i16, int i17) {
                float d16;
                int i18;
                if (Ref.IntRef.this.element >= 0) {
                    Ref.FloatRef floatRef2 = floatRef;
                    float f16 = floatRef2.element;
                    TopicHashtagTool.Companion companion = TopicHashtagTool.INSTANCE;
                    d16 = companion.d(i16);
                    floatRef2.element = f16 + d16;
                    boolean z17 = i3 == end - 1;
                    float f17 = floatRef.element;
                    i18 = this.maxTopicWordLength;
                    boolean z18 = f17 > ((float) i18) || !companion.k(i16);
                    if (z17 || z18) {
                        int i19 = z18 ? i3 - i17 : i3;
                        int i26 = Ref.IntRef.this.element;
                        if (i19 - i26 > 0) {
                            linkedList.add(TuplesKt.to(Integer.valueOf(i26), Integer.valueOf(i19 + 1)));
                        }
                        floatRef.element = 0.0f;
                        Ref.IntRef.this.element = -1;
                    }
                }
                if (i17 == 1 && TopicHashtagTool.INSTANCE.j(editable, i3)) {
                    Ref.IntRef.this.element = i3;
                }
            }
        });
        if (shouldHighlightSingleCharAtLast) {
            int i3 = end - 1;
            if (k(editable, i3)) {
                linkedList.add(TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(end)));
            }
        }
        return linkedList;
    }

    public final int j(@NotNull Editable editable, int start, int end, boolean shouldHighlightSingleChar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(editable, "editable");
        h(editable, start, end, shouldHighlightSingleChar);
        if (editable.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || start < 0 || end > editable.length() || start >= end) {
            return 3;
        }
        int i3 = end - start;
        if (i3 > (this.maxTopicWordLength * 2) + 1) {
            return 2;
        }
        if (i3 == 1) {
            if (shouldHighlightSingleChar && k(editable, start)) {
                return 0;
            }
            return 4;
        }
        Companion companion = INSTANCE;
        int i16 = start + 1;
        if (companion.e(editable, i16, end) > this.maxTopicWordLength) {
            return 2;
        }
        if (companion.j(editable, start) && companion.i(editable, i16, end)) {
            return 0;
        }
        return 3;
    }

    public final boolean k(@NotNull Editable editable, int index) {
        boolean z16;
        Intrinsics.checkNotNullParameter(editable, "editable");
        if (index >= 0 && index < editable.length()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && INSTANCE.j(editable, index) && Selection.getSelectionStart(editable) == index + 1) {
            return true;
        }
        return false;
    }
}
