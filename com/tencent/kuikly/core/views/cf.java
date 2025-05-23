package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.ClickParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003J\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0006\u0010\u0014\u001a\u00020\bR\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/kuikly/core/views/cf;", "Lcom/tencent/kuikly/core/views/ce;", "Lcom/tencent/kuikly/core/views/ae;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/event/c;", "", "handler", "click", "", "text", "value", "", "a", "clickParams", "c", "f", "", "", "g", "d", tl.h.F, "Ljava/lang/String;", "getText$core_release", "()Ljava/lang/String;", "setText$core_release", "(Ljava/lang/String;)V", "b", "Lkotlin/jvm/functions/Function1;", "clickHandlerFn", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class cf extends ce implements ae {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String text = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ClickParams, Unit> clickHandlerFn;

    @Override // com.tencent.kuikly.core.views.ae
    public boolean a() {
        return this.clickHandlerFn != null;
    }

    @Override // com.tencent.kuikly.core.views.ae
    public boolean c(ClickParams clickParams) {
        Intrinsics.checkNotNullParameter(clickParams, "clickParams");
        Function1<? super ClickParams, Unit> function1 = this.clickHandlerFn;
        if (function1 != null) {
            function1.invoke(clickParams);
        }
        return this.clickHandlerFn != null;
    }

    public final void click(Function1<? super ClickParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.clickHandlerFn = handler;
    }

    @Override // com.tencent.kuikly.core.views.ae
    public boolean f() {
        return this.text.length() == 0;
    }

    @Override // com.tencent.kuikly.core.views.ae
    public Map<String, Object> g() {
        return copyPropsMap();
    }

    /* renamed from: h, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @Override // com.tencent.kuikly.core.views.ce
    public ce text(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        return super.text(text);
    }

    @Override // com.tencent.kuikly.core.views.ce
    public ce value(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.text = value;
        return super.value(value);
    }

    @Override // com.tencent.kuikly.core.views.ae
    public void d() {
    }
}
