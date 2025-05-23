package com.tencent.ecommerce.biz.comment;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/f;", "Landroid/text/InputFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "d", "I", "maxLength", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "overLengthCallback", "<init>", "(ILkotlin/jvm/functions/Function0;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f implements InputFilter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int maxLength;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> overLengthCallback;

    public f(int i3, Function0<Unit> function0) {
        this.maxLength = i3;
        this.overLengthCallback = function0;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        int length = this.maxLength - (dest.length() - (dend - dstart));
        if (length >= end - start) {
            return null;
        }
        Function0<Unit> function0 = this.overLengthCallback;
        if (function0 != null) {
            function0.invoke();
        }
        if (length <= 0) {
            return "";
        }
        int i3 = length + start;
        if (Character.isHighSurrogate(source.charAt(i3 - 1)) && i3 - 1 == start) {
            return "";
        }
        return source.subSequence(start, i3);
    }
}
