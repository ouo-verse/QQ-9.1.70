package com.tencent.kuikly.core.views;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.event.ClickParams;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u000bJ\u001e\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0006H\u0010\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0004J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0012R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/kuikly/core/views/RichTextAttr;", "Lcom/tencent/kuikly/core/views/ce;", "Ljava/util/ArrayList;", "Lcom/tencent/kuikly/core/views/ae;", "Lkotlin/collections/ArrayList;", "spans", "", "", "getSpans", "()[Lcom/tencent/kuikly/core/views/ae;", "resetSpans$core_release", "()V", "resetSpans", "viewDidRemove", "", "hasSpans", TtmlNode.TAG_SPAN, "addSpan$core_release", "(Lcom/tencent/kuikly/core/views/ae;)V", "addSpan", "addSpanClickIfNeed$core_release", "addSpanClickIfNeed", "Ljava/util/ArrayList;", "getSpans$core_release", "()Ljava/util/ArrayList;", "setSpans$core_release", "(Ljava/util/ArrayList;)V", "<init>", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class RichTextAttr extends ce {
    private ArrayList<ae> spans = new ArrayList<>();

    public final void addSpan$core_release(ae span) {
        Intrinsics.checkNotNullParameter(span, "span");
        if (span.f()) {
            return;
        }
        this.spans.add(span);
        addSpanClickIfNeed$core_release(span);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addSpanClickIfNeed$core_release(ae span) {
        Intrinsics.checkNotNullParameter(span, "span");
        if (span.a()) {
            AbstractBaseView<?, ?> view = view();
            RichTextView richTextView = view instanceof RichTextView ? (RichTextView) view : null;
            RichTextEvent richTextEvent = richTextView != null ? (RichTextEvent) richTextView.getViewEvent() : null;
            boolean z16 = false;
            if (richTextEvent != null && richTextEvent.hasInterceptClick$core_release()) {
                z16 = true;
            }
            if (z16 || richTextEvent == null) {
                return;
            }
            richTextEvent.interceptClick$core_release(new Function1<ClickParams, Boolean>() { // from class: com.tencent.kuikly.core.views.RichTextAttr$addSpanClickIfNeed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ClickParams clickParams) {
                    Intrinsics.checkNotNullParameter(clickParams, "clickParams");
                    Object params = clickParams.getParams();
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = params instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? (com.tencent.kuikly.core.nvi.serialization.json.e) params : null;
                    Integer valueOf = eVar != null ? Integer.valueOf(eVar.j("index")) : null;
                    if (valueOf != null && RichTextAttr.this.getSpans$core_release().size() > valueOf.intValue() && valueOf.intValue() >= 0) {
                        return Boolean.valueOf(RichTextAttr.this.getSpans$core_release().get(valueOf.intValue()).c(clickParams));
                    }
                    return Boolean.FALSE;
                }
            });
        }
    }

    public final ae[] getSpans() {
        Object[] array = this.spans.toArray(new ae[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (ae[]) array;
    }

    public final ArrayList<ae> getSpans$core_release() {
        return this.spans;
    }

    protected final boolean hasSpans() {
        return !this.spans.isEmpty();
    }

    public void resetSpans$core_release() {
        Iterator<T> it = this.spans.iterator();
        while (it.hasNext()) {
            ((ae) it.next()).d();
        }
        this.spans = new ArrayList<>();
    }

    public final void setSpans$core_release(ArrayList<ae> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.spans = arrayList;
    }

    public final void spans(ArrayList<ae> spans) {
        Intrinsics.checkNotNullParameter(spans, "spans");
        this.spans = spans;
        Iterator<T> it = spans.iterator();
        while (it.hasNext()) {
            addSpanClickIfNeed$core_release((ae) it.next());
        }
        setNeedLayout();
    }

    @Override // com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props
    public void viewDidRemove() {
        super.viewDidRemove();
        resetSpans$core_release();
    }
}
