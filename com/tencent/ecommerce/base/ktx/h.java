package com.tencent.ecommerce.base.ktx;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/base/ktx/h;", "Landroid/text/InputFilter$LengthFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "d", "I", "maxLength", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "action", "<init>", "(ILkotlin/jvm/functions/Function0;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class h extends InputFilter.LengthFilter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int maxLength;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> action;

    public h(int i3, Function0<Unit> function0) {
        super(i3);
        this.maxLength = i3;
        this.action = function0;
    }

    @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if (this.maxLength - (dest.length() - (dend - dstart)) <= 0) {
            this.action.invoke();
        }
        return super.filter(source, start, end, dest, dstart, dend);
    }
}
