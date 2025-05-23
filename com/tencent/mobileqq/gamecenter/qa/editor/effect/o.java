package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Spannable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0004\u001a\u00020\u0003J$\u0010\n\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00052\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ\u001c\u0010\u000e\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fR0\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/o;", "V", "", "", "b", "", "Lzd1/e;", "spans", "Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Paragraph;", "paragraph", "e", TtmlNode.TAG_SPAN, "d", "Lzd1/d;", "a", "Landroid/text/Spannable;", "str", "c", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/o$a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mParagraphSpans", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class o<V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a<V>> mParagraphSpans = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B'\b\u0000\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0004\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/o$a;", "V", "", "Lzd1/d;", "a", "Lzd1/d;", "c", "()Lzd1/d;", "mSpan", "Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Paragraph;", "b", "Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Paragraph;", "()Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Paragraph;", "mParagraph", "", "Z", "()Z", "mRemove", "<init>", "(Lzd1/d;Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Paragraph;Z)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a<V> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final zd1.d<V> mSpan;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Paragraph mParagraph;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean mRemove;

        public a(@NotNull zd1.d<V> mSpan, @NotNull Paragraph mParagraph, boolean z16) {
            Intrinsics.checkNotNullParameter(mSpan, "mSpan");
            Intrinsics.checkNotNullParameter(mParagraph, "mParagraph");
            this.mSpan = mSpan;
            this.mParagraph = mParagraph;
            this.mRemove = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Paragraph getMParagraph() {
            return this.mParagraph;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getMRemove() {
            return this.mRemove;
        }

        @NotNull
        public final zd1.d<V> c() {
            return this.mSpan;
        }
    }

    public final synchronized void a(@NotNull zd1.d<V> span, @NotNull Paragraph paragraph) {
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        this.mParagraphSpans.add(new a<>(span, paragraph, false));
    }

    public final synchronized void b() {
        this.mParagraphSpans.clear();
    }

    public final synchronized void c(@NotNull Spannable str) {
        Intrinsics.checkNotNullParameter(str, "str");
        try {
            Object clone = this.mParagraphSpans.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.gamecenter.qa.editor.effect.ParagraphSpanProcessor.ParagraphSpan<V of com.tencent.mobileqq.gamecenter.qa.editor.effect.ParagraphSpanProcessor>>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.gamecenter.qa.editor.effect.ParagraphSpanProcessor.ParagraphSpan<V of com.tencent.mobileqq.gamecenter.qa.editor.effect.ParagraphSpanProcessor>> }");
            Iterator it = ((ArrayList) clone).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                zd1.d<V> c16 = aVar.c();
                int mStart = aVar.getMParagraph().getMStart();
                int i3 = 34;
                if (aVar.getMRemove()) {
                    int spanStart = str.getSpanStart(c16);
                    if (spanStart > -1 && spanStart < mStart) {
                        str.setSpan(c16.a(), spanStart, mStart, 34);
                    }
                    str.removeSpan(c16);
                } else {
                    Paragraph mParagraph = aVar.getMParagraph();
                    int mEnd = aVar.getMParagraph().getMEnd();
                    if ((!mParagraph.getIsLast() || !mParagraph.isEmpty()) && (!mParagraph.getIsLast() || !mParagraph.getIsFirst())) {
                        if (!mParagraph.getIsLast()) {
                            i3 = 33;
                        }
                        str.setSpan(c16, mStart, mEnd, i3);
                    }
                    i3 = 18;
                    str.setSpan(c16, mStart, mEnd, i3);
                }
            }
        } catch (Exception e16) {
            QLog.e("ParagraphSpanProcessor", 1, e16, new Object[0]);
        }
    }

    public final synchronized void d(@Nullable zd1.e<V> span, @NotNull Paragraph paragraph) {
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        if (span instanceof zd1.d) {
            this.mParagraphSpans.add(new a<>((zd1.d) span, paragraph, true));
        }
    }

    public final void e(@NotNull List<? extends zd1.e<V>> spans, @NotNull Paragraph paragraph) {
        Intrinsics.checkNotNullParameter(spans, "spans");
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        Iterator<? extends zd1.e<V>> it = spans.iterator();
        while (it.hasNext()) {
            d(it.next(), paragraph);
        }
    }
}
