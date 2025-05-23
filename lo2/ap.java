package lo2;

import com.tencent.qqnt.kernel.nativeinterface.UfsLabel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import unify.search.UnifySearchUniteMore$Label;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00a8\u0006\t"}, d2 = {"Llo2/ap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsLabel;", "Lunify/search/UnifySearchUniteMore$Label;", "label", "", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ap f415182a = new ap();

    ap() {
    }

    @JvmStatic
    public static final void a(@NotNull UfsLabel ufsLabel, @NotNull UnifySearchUniteMore$Label label) {
        Intrinsics.checkNotNullParameter(ufsLabel, "<this>");
        Intrinsics.checkNotNullParameter(label, "label");
        ufsLabel.enumType = label.enum_type.get();
        ufsLabel.name = label.name.get();
        ufsLabel.type = label.type.get();
        ufsLabel.attr = label.attr.get();
        ufsLabel.textColor.f359232r = label.text_color.get().f439295r.get();
        ufsLabel.textColor.f359231g = label.text_color.get().f439294g.get();
        ufsLabel.textColor.f359230b = label.text_color.get().f439293b.get();
        ufsLabel.edgingColor.f359232r = label.edging_color.get().f439295r.get();
        ufsLabel.edgingColor.f359231g = label.edging_color.get().f439294g.get();
        ufsLabel.edgingColor.f359230b = label.edging_color.get().f439293b.get();
    }
}
