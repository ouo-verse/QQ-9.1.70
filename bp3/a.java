package bp3;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0005\u001fB?\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\u00150\u0014\u00a2\u0006\u0004\b\"\u0010#J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\u00150\u00148\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010!\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lbp3/a;", "", "", "index", "", "a", "startIndex", "endIndex", "d", "", "other", "", "equals", "hashCode", "", "toString", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "", "Lbp3/a$b;", "Lbp3/j;", "e", "Ljava/util/List;", "c", "()Ljava/util/List;", "spanStyles", "f", "getAnnotations$ntcompose_release", "annotations", "b", "()I", "length", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements CharSequence {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<Range<j>> spanStyles;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<Range<? extends Object>> annotations;

    /* JADX WARN: Multi-variable type inference failed */
    public a(String text, List<Range<j>> spanStyles, List<? extends Range<? extends Object>> annotations) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        this.text = text;
        this.spanStyles = spanStyles;
        this.annotations = annotations;
    }

    public char a(int index) {
        return this.text.charAt(index);
    }

    public int b() {
        return this.text.length();
    }

    public final List<Range<j>> c() {
        return this.spanStyles;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i3) {
        return a(i3);
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.spanStyles.hashCode()) * 31) + this.annotations.hashCode();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return b();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\u0010R\u0018\u0010\u0003\u001a\u00060\u0012j\u0002`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lbp3/a$a;", "", "", "text", "", "a", "Lbp3/j;", "style", "", "e", "tag", "annotation", "d", "b", "index", "c", "Lbp3/a;", "f", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "", "Lbp3/a$a$a;", "Ljava/util/List;", "spanStyles", "annotations", "styleStack", "capacity", "<init>", "(I)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bp3.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0144a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final StringBuilder text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final List<MutableRange<j>> spanStyles;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final List<MutableRange<? extends Object>> annotations;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final List<MutableRange<? extends Object>> styleStack;

        public C0144a(int i3) {
            this.text = new StringBuilder(i3);
            this.spanStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        public final void a(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text.append(text);
        }

        public final void b() {
            if (!this.styleStack.isEmpty()) {
                this.styleStack.remove(r0.size() - 1).a(this.text.length());
                return;
            }
            throw new IllegalStateException("Nothing to pop.".toString());
        }

        public final void c(int index) {
            if (index < this.styleStack.size()) {
                while (this.styleStack.size() - 1 >= index) {
                    b();
                }
            } else {
                throw new IllegalStateException((index + " should be less than " + this.styleStack.size()).toString());
            }
        }

        public final int d(String tag, String annotation) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            MutableRange<? extends Object> mutableRange = new MutableRange<>(annotation, this.text.length(), 0, tag, 4, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int e(j style) {
            Intrinsics.checkNotNullParameter(style, "style");
            MutableRange<j> mutableRange = new MutableRange<>(style, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.spanStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final a f() {
            String sb5 = this.text.toString();
            Intrinsics.checkNotNullExpressionValue(sb5, "text.toString()");
            List<MutableRange<j>> list = this.spanStyles;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(list.get(i3).b(this.text.length()));
            }
            List<MutableRange<? extends Object>> list2 = this.annotations;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i16 = 0; i16 < size2; i16++) {
                arrayList2.add(list2.get(i16).b(this.text.length()));
            }
            return new a(sb5, arrayList, arrayList2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\u0006\u0010\u0011\u001a\u00028\u0000\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\r\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lbp3/a$a$a;", "T", "", "", "defaultEnd", "Lbp3/a$b;", "b", "", "toString", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "getItem", "()Ljava/lang/Object;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "I", "getStart", "()I", "start", "c", "getEnd", "(I)V", "end", "d", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: bp3.a$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes39.dex */
        public static final /* data */ class MutableRange<T> {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final T item;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final int start;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private int end;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            private final String tag;

            public MutableRange(T t16, int i3, int i16, String tag) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                this.item = t16;
                this.start = i3;
                this.end = i16;
                this.tag = tag;
            }

            public final void a(int i3) {
                this.end = i3;
            }

            public final Range<T> b(int defaultEnd) {
                int i3 = this.end;
                if (i3 != Integer.MIN_VALUE) {
                    defaultEnd = i3;
                }
                if (defaultEnd != Integer.MIN_VALUE) {
                    return new Range<>(this.item, this.start, defaultEnd, this.tag);
                }
                throw new IllegalStateException("Item.end should be set first".toString());
            }

            public int hashCode() {
                T t16 = this.item;
                return ((((((t16 == null ? 0 : t16.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
            }

            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) other;
                return Intrinsics.areEqual(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual(this.tag, mutableRange.tag);
            }

            public /* synthetic */ MutableRange(Object obj, int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i3, (i17 & 4) != 0 ? Integer.MIN_VALUE : i16, (i17 & 8) != 0 ? "" : str);
            }
        }

        public /* synthetic */ C0144a(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 16 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lbp3/a$b;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "I", "c", "()I", "start", "end", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "tag", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bp3.a$b, reason: from toString */
    /* loaded from: classes39.dex */
    public static final /* data */ class Range<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final T item;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int start;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int end;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String tag;

        public Range(T t16, int i3, int i16, String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.item = t16;
            this.start = i3;
            this.end = i16;
            this.tag = tag;
            if (!(i3 <= i16)) {
                throw new IllegalArgumentException("Reversed range is not supported".toString());
            }
        }

        /* renamed from: a, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        public final T b() {
            return this.item;
        }

        /* renamed from: c, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: d, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            T t16 = this.item;
            return ((((((t16 == null ? 0 : t16.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
        }

        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Range)) {
                return false;
            }
            Range range = (Range) other;
            return Intrinsics.areEqual(this.item, range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual(this.tag, range.tag);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (!Intrinsics.areEqual(this.text, aVar.text) || !Intrinsics.areEqual(this.spanStyles, aVar.spanStyles) || this.spanStyles.size() != aVar.spanStyles.size()) {
            return false;
        }
        int i3 = 0;
        for (Range<j> range : this.spanStyles) {
            Range<j> range2 = aVar.spanStyles.get(i3);
            if (range.getStart() != range2.getStart() || range.getEnd() != range2.getEnd() || !range.b().equals(range2.b())) {
                return false;
            }
            i3++;
        }
        if (this.annotations.size() != aVar.annotations.size()) {
            return false;
        }
        int i16 = 0;
        for (Range<? extends Object> range3 : this.annotations) {
            Range<? extends Object> range4 = aVar.annotations.get(i16);
            if (range3.getStart() != range4.getStart() || range3.getEnd() != range4.getEnd() || !range3.b().equals(range4.b())) {
                return false;
            }
            i16++;
        }
        return true;
    }

    @Override // java.lang.CharSequence
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a subSequence(int startIndex, int endIndex) {
        List d16;
        List d17;
        if (startIndex <= endIndex) {
            if (startIndex == 0 && endIndex == this.text.length()) {
                return this;
            }
            String substring = this.text.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            d16 = b.d(this.spanStyles, startIndex, endIndex);
            d17 = b.d(this.annotations, startIndex, endIndex);
            return new a(substring, d16, d17);
        }
        throw new IllegalArgumentException(("start (" + startIndex + ") should be less or equal to end (" + endIndex + ')').toString());
    }
}
