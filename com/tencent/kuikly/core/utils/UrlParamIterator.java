package com.tencent.kuikly.core.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u00112\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0002J\u0019\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0096\u0002R\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/utils/UrlParamIterator;", "", "Lkotlin/Pair;", "", "Lcom/tencent/kuikly/core/utils/UrlParamEntry;", "", "hasNext", "b", "d", "Ljava/lang/String;", "urlParamStr", "e", "Ljava/util/Iterator;", "iterator", "url", "<init>", "(Ljava/lang/String;)V", "f", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class UrlParamIterator implements Iterator<Pair<? extends String, ? extends String>>, KMappedMarker {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Pair<String, String> f118263h = new Pair<>("", "");

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy<Iterator<String>> f118264i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String urlParamStr;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Iterator<String> iterator;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/utils/UrlParamIterator$a;", "", "", "", "EMPTY_ITERATOR$delegate", "Lkotlin/Lazy;", "b", "()Ljava/util/Iterator;", "EMPTY_ITERATOR", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.utils.UrlParamIterator$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Iterator<String> b() {
            return (Iterator) UrlParamIterator.f118264i.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Iterator<String>> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Iterator<? extends String>>() { // from class: com.tencent.kuikly.core.utils.UrlParamIterator$Companion$EMPTY_ITERATOR$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.kuikly.core.utils.UrlParamIterator$Companion$EMPTY_ITERATOR$2$1", f = "URLUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.kuikly.core.utils.UrlParamIterator$Companion$EMPTY_ITERATOR$2$1, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
                int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator<? extends String> invoke() {
                Iterator<? extends String> it;
                it = SequencesKt__SequenceBuilderKt.iterator(new AnonymousClass1(null));
                return it;
            }
        });
        f118264i = lazy;
    }

    public UrlParamIterator(String url) {
        String substringAfter$default;
        String substringBefore$default;
        boolean contains$default;
        Sequence splitToSequence$default;
        Iterator<String> it;
        Intrinsics.checkNotNullParameter(url, "url");
        substringAfter$default = StringsKt__StringsKt.substringAfter$default(url, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, (String) null, 2, (Object) null);
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(substringAfter$default, "#", (String) null, 2, (Object) null);
        this.urlParamStr = substringBefore$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) substringBefore$default, (CharSequence) ContainerUtils.KEY_VALUE_DELIMITER, false, 2, (Object) null);
        if (!contains$default) {
            it = INSTANCE.b();
        } else {
            splitToSequence$default = StringsKt__StringsKt.splitToSequence$default((CharSequence) substringBefore$default, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            it = splitToSequence$default.iterator();
        }
        this.iterator = it;
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Pair<String, String> next() {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) this.iterator.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            return TuplesKt.to(split$default.get(0), split$default.get(1));
        }
        return f118263h;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
