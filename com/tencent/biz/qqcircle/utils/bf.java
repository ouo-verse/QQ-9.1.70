package com.tencent.biz.qqcircle.utils;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0003\tB\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\u0015R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010 R\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020%0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/qqcircle/utils/bf;", "", "", "a", "g", "i", "j", tl.h.F, "f", "b", "o", "p", "c", "", "codePoint", "", "k", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "d", "", "e", "Ljava/lang/CharSequence;", "getInput", "()Ljava/lang/CharSequence;", "input", "I", "getCountLimit", "()I", "countLimit", "", "Ljava/util/Set;", "emojiModifier", "currState", "currIndex", "currCodePoint", "Lcom/tencent/biz/qqcircle/utils/bf$b;", "Lcom/tencent/biz/qqcircle/utils/bf$b;", "currCharNode", "", "Ljava/util/List;", "nodeList", "<init>", "(Ljava/lang/CharSequence;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class bf {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final IntRange f92685j = new IntRange(917536, 917631);

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final Set<Integer> f92686k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence input;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int countLimit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<Integer> emojiModifier;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currCodePoint;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Node currCharNode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Node> nodeList;

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{127995, 127996, 127997, 127998, 127999});
        f92686k = of5;
    }

    public bf(@NotNull CharSequence input, int i3) {
        Set of5;
        Set plus;
        Set<Integer> plus2;
        Intrinsics.checkNotNullParameter(input, "input");
        this.input = input;
        this.countLimit = i3;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{65038, 65039, 8419});
        plus = SetsKt___SetsKt.plus(of5, (Iterable) f92685j);
        plus2 = SetsKt___SetsKt.plus(plus, (Iterable) f92686k);
        this.emojiModifier = plus2;
        this.currCharNode = new Node(0, false, null, 6, null);
        this.nodeList = new ArrayList();
        a();
    }

    private final void a() {
        while (this.currIndex < this.input.length()) {
            this.currCodePoint = Character.codePointAt(this.input, this.currIndex);
            int i3 = this.currState;
            if (i3 == 65536) {
                g();
            } else if (i3 == 257) {
                i();
            } else if (i3 == 16) {
                j();
            } else if ((i3 & 1) != 0) {
                h();
            } else {
                f();
            }
            if (d() >= this.countLimit) {
                break;
            }
        }
        int i16 = this.currState;
        if (i16 != 0) {
            if ((i16 & 1) != 0) {
                b();
            }
            c();
        }
    }

    private final void b() {
        this.currCharNode.b(true);
    }

    private final void c() {
        this.currState = 0;
        if (!this.currCharNode.a().isEmpty()) {
            this.nodeList.add(this.currCharNode);
            this.currCharNode = new Node(this.currIndex, false, null, 6, null);
        }
    }

    private final void f() {
        if (m(this.currCodePoint)) {
            this.currState = 257;
            o();
        } else if (n(this.currCodePoint)) {
            this.currState = 16;
            o();
        } else if (k(this.currCodePoint)) {
            this.currState = 1;
            o();
        } else {
            o();
            c();
        }
    }

    private final void g() {
        if (k(this.currCodePoint)) {
            this.currState = 1;
            o();
        } else {
            p();
            c();
        }
    }

    private final void h() {
        int i3 = this.currCodePoint;
        if (i3 == 8205) {
            this.currState = 65536;
            o();
        } else if (this.emojiModifier.contains(Integer.valueOf(i3))) {
            this.currState = 4097;
            o();
        } else {
            b();
            c();
        }
    }

    private final void i() {
        if (m(this.currCodePoint)) {
            o();
        }
        b();
        c();
    }

    private final void j() {
        if (this.emojiModifier.contains(Integer.valueOf(this.currCodePoint))) {
            this.currState = 4097;
            o();
        } else {
            c();
        }
    }

    private final boolean k(int codePoint) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (127488 <= codePoint && codePoint < 131072) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (8986 <= codePoint && codePoint < 9216) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        if (9312 <= codePoint && codePoint < 9472) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return true;
        }
        if (9472 <= codePoint && codePoint < 12288) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            return true;
        }
        if (12800 <= codePoint && codePoint < 13056) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            return true;
        }
        return false;
    }

    private final boolean m(int codePoint) {
        if (126976 > codePoint || codePoint >= 127488) {
            return false;
        }
        return true;
    }

    private final boolean n(int codePoint) {
        boolean z16;
        boolean z17;
        if (codePoint >= 0 && codePoint < 58) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (8592 <= codePoint && codePoint < 8704) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    private final void o() {
        this.currCharNode.a().add(Integer.valueOf(this.currCodePoint));
        this.currIndex += Character.charCount(this.currCodePoint);
    }

    private final void p() {
        int lastIndex;
        List<Integer> a16 = this.currCharNode.a();
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.currCharNode.a());
        this.currIndex -= Character.charCount(a16.remove(lastIndex).intValue());
    }

    public final int d() {
        return this.nodeList.size();
    }

    @NotNull
    public final CharSequence e() {
        return this.input.subSequence(0, this.currIndex);
    }

    public final boolean l() {
        QLog.d("QFSEmojiReader", 1, "[isInputLengthOverLimit] input.length: " + this.input.length() + ", currIndex: " + this.currIndex);
        if (this.input.length() > this.currIndex) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u000e\u0010\u0012R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/utils/bf$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getStartIndex", "()I", "startIndex", "b", "Z", "isEmoji", "()Z", "(Z)V", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "codePoints", "<init>", "(IZLjava/util/List;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.utils.bf$b, reason: from toString */
    /* loaded from: classes5.dex */
    public static final /* data */ class Node {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int startIndex;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isEmoji;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Integer> codePoints;

        public Node(int i3, boolean z16, @NotNull List<Integer> codePoints) {
            Intrinsics.checkNotNullParameter(codePoints, "codePoints");
            this.startIndex = i3;
            this.isEmoji = z16;
            this.codePoints = codePoints;
        }

        @NotNull
        public final List<Integer> a() {
            return this.codePoints;
        }

        public final void b(boolean z16) {
            this.isEmoji = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            if (this.startIndex == node.startIndex && this.isEmoji == node.isEmoji && Intrinsics.areEqual(this.codePoints, node.codePoints)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.startIndex * 31;
            boolean z16 = this.isEmoji;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return ((i3 + i16) * 31) + this.codePoints.hashCode();
        }

        @NotNull
        public String toString() {
            return "Node(startIndex=" + this.startIndex + ", isEmoji=" + this.isEmoji + ", codePoints=" + this.codePoints + ")";
        }

        public /* synthetic */ Node(int i3, boolean z16, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? new ArrayList() : list);
        }
    }
}
