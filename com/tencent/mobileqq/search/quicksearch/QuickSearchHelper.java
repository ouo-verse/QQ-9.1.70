package com.tencent.mobileqq.search.quicksearch;

import android.text.Editable;
import android.text.Spannable;
import android.widget.EditText;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.api.IHashTagSearchLinkApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import kn2.HashTagSearchLinkUniteConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b7\u00108J7\u0010\u000b\u001a\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\u0007j\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ4\u0010\u0010\u001a\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\u000ej\u0002`\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\u0007j\u0002`\nH\u0002J4\u0010\u0013\u001a\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\u0007j\u0002`\n2\u0006\u0010\u0011\u001a\u00020\b2\u0014\u0010\u0012\u001a\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\u0007j\u0002`\nH\u0002J,\u0010\u0015\u001a\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\u0007j\u0002`\n2\u0014\u0010\u0014\u001a\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\u0007j\u0002`\nH\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u001f\u001a\u00020\u00162\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016R\u0016\u0010#\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\"R \u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010$R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/search/quicksearch/QuickSearchHelper;", "Lcom/tencent/qqnt/search/api/a;", "Landroid/text/Spannable;", "text", "", "", "screenAllSpans", "Ljava/util/LinkedList;", "Lkotlin/ranges/IntRange;", "Lcom/tencent/mobileqq/search/quicksearch/SpanRange;", "Lcom/tencent/mobileqq/search/quicksearch/SpanRangeList;", "g", "(Landroid/text/Spannable;[Ljava/lang/Object;)Ljava/util/LinkedList;", "barrierSpanRanges", "", "Lcom/tencent/mobileqq/search/quicksearch/SpanRangeSet;", h.F, "mainRange", "excludeRanges", DomainData.DOMAIN_NAME, "ranges", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "f", "l", "i", "", "Ljava/lang/Class;", "barrierSpans", "Landroid/widget/EditText;", "editText", "b", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/EditText;", "edittext", "Ljava/util/List;", "Lcom/tencent/mobileqq/search/quicksearch/b;", "c", "Lcom/tencent/mobileqq/search/quicksearch/b;", "debounceExecutor", "Lkn2/a;", "d", "Lkotlin/Lazy;", "j", "()Lkn2/a;", DownloadInfo.spKey_Config, "", "e", "Z", "k", "()Z", "setEnabled", "(Z)V", NodeProps.ENABLED, "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QuickSearchHelper implements com.tencent.qqnt.search.api.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Lazy<LinkedList<IntRange>> f283680g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private EditText edittext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<? extends Class<?>> barrierSpans;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.quicksearch.b debounceExecutor = new com.tencent.mobileqq.search.quicksearch.b(50);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean enabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R)\u0010\n\u001a\u0010\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002j\u0002`\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/search/quicksearch/QuickSearchHelper$a;", "", "Ljava/util/LinkedList;", "Lkotlin/ranges/IntRange;", "Lcom/tencent/mobileqq/search/quicksearch/SpanRange;", "Lcom/tencent/mobileqq/search/quicksearch/SpanRangeList;", "EMPTY_LIST$delegate", "Lkotlin/Lazy;", "b", "()Ljava/util/LinkedList;", "EMPTY_LIST", "", "MAX_PROCESS_SPAN_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.quicksearch.QuickSearchHelper$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final LinkedList<IntRange> b() {
            return (LinkedList) QuickSearchHelper.f283680g.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            Companion companion = QuickSearchHelper.INSTANCE;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((IntRange) t16).getFirst()), Integer.valueOf(((IntRange) t17).getFirst()));
            return compareValues;
        }
    }

    static {
        Lazy<LinkedList<IntRange>> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<LinkedList<IntRange>>() { // from class: com.tencent.mobileqq.search.quicksearch.QuickSearchHelper$Companion$EMPTY_LIST$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinkedList<IntRange> invoke() {
                return new LinkedList<>();
            }
        });
        f283680g = lazy;
    }

    public QuickSearchHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashTagSearchLinkUniteConfig>() { // from class: com.tencent.mobileqq.search.quicksearch.QuickSearchHelper$config$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashTagSearchLinkUniteConfig invoke() {
                return IHashTagSearchLinkApi.f282735g.uniteConfig();
            }
        });
        this.config = lazy;
        this.enabled = j().getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH java.lang.String();
    }

    private final void f() {
        this.debounceExecutor.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.quicksearch.QuickSearchHelper$debounceIncrementalUpdateSpan$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                EditText editText;
                QuickSearchHelper quickSearchHelper = QuickSearchHelper.this;
                editText = quickSearchHelper.edittext;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("edittext");
                    editText = null;
                }
                Editable text = editText.getText();
                Intrinsics.checkNotNullExpressionValue(text, "edittext.text");
                quickSearchHelper.l(text);
            }
        });
    }

    private final LinkedList<IntRange> g(Spannable text, Object[] screenAllSpans) {
        boolean z16;
        boolean z17;
        IntRange until;
        if (screenAllSpans.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return INSTANCE.b();
        }
        LinkedList<IntRange> linkedList = new LinkedList<>();
        for (Object obj : screenAllSpans) {
            List<? extends Class<?>> list = this.barrierSpans;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barrierSpans");
                list = null;
            }
            List<? extends Class<?>> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (((Class) it.next()).isInstance(obj)) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (z17) {
                until = RangesKt___RangesKt.until(text.getSpanStart(obj), text.getSpanEnd(obj));
                linkedList.add(until);
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QuickSearchHelper", 1, "findBarrierSpanRanges: " + linkedList);
        }
        return linkedList;
    }

    private final Set<IntRange> h(Spannable text, LinkedList<IntRange> barrierSpanRanges) {
        boolean isBlank;
        IntRange until;
        IntRange until2;
        isBlank = StringsKt__StringsJVMKt.isBlank(text);
        if (isBlank) {
            return new LinkedHashSet();
        }
        Matcher matcher = IHashTagSearchLinkApi.HASHTAG_LINK_PATTERN.matcher(text);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        until = RangesKt___RangesKt.until(0, text.length());
        Iterator<T> it = n(until, barrierSpanRanges).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IntRange intRange = (IntRange) it.next();
            matcher.region(intRange.getFirst(), intRange.getLast() + 1);
            while (matcher.find()) {
                until2 = RangesKt___RangesKt.until(matcher.start(), matcher.end());
                linkedHashSet.add(until2);
                if (linkedHashSet.size() >= 100) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("QuickSearchHelper", 1, "findSpanRanges: exceed MAX_SEARCH_SPAN_COUNT(100), return as is");
                    }
                }
            }
        }
        return linkedHashSet;
    }

    private final void i(Spannable text) {
        Sequence asSequence;
        Sequence filter;
        Object[] spans = text.getSpans(0, text.length(), Object.class);
        if (spans == null) {
            spans = new Object[0];
        }
        Set<IntRange> h16 = h(text, g(text, spans));
        asSequence = ArraysKt___ArraysKt.asSequence(spans);
        filter = SequencesKt___SequencesKt.filter(asSequence, new Function1<Object, Boolean>() { // from class: com.tencent.mobileqq.search.quicksearch.QuickSearchHelper$fullVolumeUpdateSpan$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable Object obj) {
                return Boolean.valueOf(obj instanceof QuickSearchSpan);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = filter.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            text.removeSpan((QuickSearchSpan) it.next());
            i3++;
        }
        for (IntRange intRange : h16) {
            text.setSpan(new QuickSearchSpan(0, 1, null), intRange.getFirst(), intRange.getLast() + 1, 17);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QuickSearchHelper", 1, "fullVolumeUpdateSpan: allSpanSize: " + spans.length + ", screenQuickSearchSize: " + i3 + ", newSpanSize: " + h16.size());
        }
    }

    private final HashTagSearchLinkUniteConfig j() {
        return (HashTagSearchLinkUniteConfig) this.config.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Spannable text) {
        Sequence asSequence;
        Sequence<QuickSearchSpan> filter;
        IntRange until;
        Object[] spans = text.getSpans(0, text.length(), Object.class);
        if (spans == null) {
            spans = new Object[0];
        }
        Set<IntRange> h16 = h(text, g(text, spans));
        int size = h16.size();
        asSequence = ArraysKt___ArraysKt.asSequence(spans);
        filter = SequencesKt___SequencesKt.filter(asSequence, new Function1<Object, Boolean>() { // from class: com.tencent.mobileqq.search.quicksearch.QuickSearchHelper$incrementalUpdateSpan$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable Object obj) {
                return Boolean.valueOf(obj instanceof QuickSearchSpan);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        int i3 = 0;
        for (QuickSearchSpan quickSearchSpan : filter) {
            until = RangesKt___RangesKt.until(text.getSpanStart(quickSearchSpan), text.getSpanEnd(quickSearchSpan));
            if (!h16.remove(until)) {
                text.removeSpan(quickSearchSpan);
            }
            i3++;
        }
        for (IntRange intRange : h16) {
            text.setSpan(new QuickSearchSpan(0, 1, null), intRange.getFirst(), intRange.getLast() + 1, 17);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QuickSearchHelper", 1, "incrementalUpdateSpan: allSpanSize: " + spans.length + ", screenQuickSearchSize: " + i3 + ", originFoundNewSpanSize: " + size + ", actualSetSpanSize: " + h16.size() + "(skip " + (size - h16.size()) + ")");
        }
    }

    private final LinkedList<IntRange> m(LinkedList<IntRange> ranges) {
        List sortedWith;
        if (ranges.isEmpty()) {
            return INSTANCE.b();
        }
        LinkedList<IntRange> linkedList = new LinkedList<>();
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(ranges, new b());
        Iterator it = sortedWith.iterator();
        IntRange intRange = (IntRange) it.next();
        while (it.hasNext()) {
            IntRange intRange2 = (IntRange) it.next();
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int first2 = intRange2.getFirst();
            boolean z16 = false;
            if (first <= first2 && first2 <= last) {
                z16 = true;
            }
            if (z16) {
                intRange = new IntRange(intRange.getFirst(), Math.max(intRange.getLast(), intRange2.getLast()));
            } else {
                linkedList.add(intRange);
                intRange = intRange2;
            }
        }
        linkedList.add(intRange);
        return linkedList;
    }

    private final LinkedList<IntRange> n(IntRange mainRange, LinkedList<IntRange> excludeRanges) {
        IntRange until;
        if (excludeRanges.isEmpty()) {
            LinkedList<IntRange> linkedList = new LinkedList<>();
            linkedList.add(mainRange);
            return linkedList;
        }
        LinkedList<IntRange> linkedList2 = new LinkedList<>();
        LinkedList<IntRange> m3 = m(excludeRanges);
        int first = mainRange.getFirst();
        Iterator<IntRange> it = m3.iterator();
        while (it.hasNext()) {
            IntRange excludeRange = it.next();
            Intrinsics.checkNotNullExpressionValue(excludeRange, "excludeRange");
            if (first < excludeRange.getFirst()) {
                until = RangesKt___RangesKt.until(first, excludeRange.getFirst());
                linkedList2.add(until);
            }
            first = Math.max(first, excludeRange.getLast() + 1);
        }
        if (first <= mainRange.getLast()) {
            linkedList2.add(new IntRange(first, mainRange.getLast()));
        }
        return linkedList2;
    }

    @Override // com.tencent.qqnt.search.api.a
    public void a(@NotNull Spannable text) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(text, "text");
        if (getEnabled()) {
            isBlank = StringsKt__StringsJVMKt.isBlank(text);
            if (!isBlank) {
                if (this.edittext == null) {
                    QLog.e("QuickSearchHelper", 1, "edittext is not initialized");
                    return;
                }
                try {
                    int inputSpanUpdateLevel = j().getInputSpanUpdateLevel();
                    if (inputSpanUpdateLevel != 1) {
                        if (inputSpanUpdateLevel != 2) {
                            i(text);
                        } else {
                            f();
                        }
                    } else {
                        l(text);
                    }
                } catch (Exception e16) {
                    QLog.e("QuickSearchHelper", 1, "process error", e16);
                }
            }
        }
    }

    @Override // com.tencent.qqnt.search.api.a
    public void b(@NotNull List<? extends Class<?>> barrierSpans, @NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(barrierSpans, "barrierSpans");
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.barrierSpans = barrierSpans;
        this.edittext = editText;
    }

    /* renamed from: k, reason: from getter */
    public boolean getEnabled() {
        return this.enabled;
    }

    @Override // com.tencent.qqnt.search.api.a
    public void onDestroy() {
        QLog.d("QuickSearchHelper", 2, "QuickSearchHelper#onDestroy");
    }

    @Override // com.tencent.qqnt.search.api.a
    public void setEnabled(boolean z16) {
        this.enabled = z16;
    }
}
