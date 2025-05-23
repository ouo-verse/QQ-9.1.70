package com.tencent.qqnt.qbasealbum.ktx;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001a,\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"T", "", "", "fromIndex", "toIndex", "a", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ListExKt {
    @NotNull
    public static final <T> List<T> a(@NotNull List<? extends T> list, int i3, int i16) {
        final int coerceIn;
        final int coerceIn2;
        List<T> emptyList;
        List<T> emptyList2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(i3, 0, list.size() - 1);
        coerceIn2 = RangesKt___RangesKt.coerceIn(i16, coerceIn, list.size());
        ox3.a.b("QBaseAlbum.safeSubList", new Function0<String>(coerceIn, coerceIn2) { // from class: com.tencent.qqnt.qbasealbum.ktx.ListExKt$safeSubList$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $safeFromIndex;
            final /* synthetic */ int $safeToIndex;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$safeFromIndex = coerceIn;
                this.$safeToIndex = coerceIn2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(coerceIn), Integer.valueOf(coerceIn2));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "safeSubList safeFromIndex: " + this.$safeFromIndex + " safeToIndex: " + this.$safeToIndex;
            }
        });
        if (coerceIn >= coerceIn2) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list.subList(coerceIn, coerceIn2);
    }
}
