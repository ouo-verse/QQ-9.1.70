package com.tencent.ecommerce.biz.comment;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.ecommerce.base.ktx.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r0\f\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J8\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016R&\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/e;", "Landroid/text/InputFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "", "Lkotlin/Pair;", "d", "Ljava/util/List;", "normalCharactersUnicodeRange", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "illegalCharacterCallback", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e implements InputFilter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<Pair<Integer, Integer>> normalCharactersUnicodeRange;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> illegalCharacterCallback;

    public e(List<Pair<Integer, Integer>> list, Function0<Unit> function0) {
        this.normalCharactersUnicodeRange = list;
        this.illegalCharacterCallback = function0;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Function0<Unit> function0;
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        int i3 = start;
        int i16 = i3;
        boolean z17 = false;
        while (start < end) {
            List<Pair<Integer, Integer>> list = this.normalCharactersUnicodeRange;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    int intValue = ((Number) pair.component1()).intValue();
                    int intValue2 = ((Number) pair.component2()).intValue();
                    char charAt = source.charAt(start);
                    if (intValue <= charAt && intValue2 >= charAt) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                sb5.append(source.subSequence(i3, i16));
                i3 = start + 1;
                z17 = true;
            }
            i16 = start + 1;
            start = i16;
        }
        sb5.append(source.subSequence(i3, i16));
        if (z17 && (function0 = this.illegalCharacterCallback) != null) {
            function0.invoke();
        }
        return sb5.toString();
    }

    public /* synthetic */ e(List list, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? j.a() : list, (i3 & 2) != 0 ? null : function0);
    }
}
