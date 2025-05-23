package com.tencent.kuikly.core.views;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.event.ClickParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J)\u0010\r\u001a\u00020\u00052!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001aR0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010)\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b8\u0000@@X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/kuikly/core/views/bg;", "Lcom/tencent/kuikly/core/views/ae;", "", "width", "height", "", "i", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/layout/d;", "Lkotlin/ParameterName;", "name", AIInput.KEY_FRAME, "handler", "k", "", "f", "", "", "", "g", "Lcom/tencent/kuikly/core/base/event/c;", "clickParams", "c", "a", "d", "Lcom/tencent/kuikly/core/base/w;", "Lcom/tencent/kuikly/core/base/w;", "placeholderSize", "b", "Lkotlin/jvm/functions/Function1;", tl.h.F, "()Lkotlin/jvm/functions/Function1;", "setSpanFrameDidChangedHandlerFn$core_release", "(Lkotlin/jvm/functions/Function1;)V", "spanFrameDidChangedHandlerFn", "value", "Lcom/tencent/kuikly/core/layout/d;", "getSpanFrame$core_release", "()Lcom/tencent/kuikly/core/layout/d;", "j", "(Lcom/tencent/kuikly/core/layout/d;)V", "spanFrame", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class bg implements ae {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super com.tencent.kuikly.core.layout.d, Unit> spanFrameDidChangedHandlerFn;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.w placeholderSize = new com.tencent.kuikly.core.base.w(0.0f, 0.0f);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.layout.d spanFrame = com.tencent.kuikly.core.layout.d.INSTANCE.a();

    @Override // com.tencent.kuikly.core.views.ae
    public boolean a() {
        return false;
    }

    @Override // com.tencent.kuikly.core.views.ae
    public boolean c(ClickParams clickParams) {
        Intrinsics.checkNotNullParameter(clickParams, "clickParams");
        return false;
    }

    @Override // com.tencent.kuikly.core.views.ae
    public boolean f() {
        if (this.placeholderSize.getWidth() == 0.0f) {
            if (this.placeholderSize.getHeight() == 0.0f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.views.ae
    public Map<String, Object> g() {
        HashMap hashMap = new HashMap();
        hashMap.put("placeholderWidth", Float.valueOf(this.placeholderSize.getWidth()));
        hashMap.put("placeholderHeight", Float.valueOf(this.placeholderSize.getHeight()));
        hashMap.put("text", " ");
        return hashMap;
    }

    public final Function1<com.tencent.kuikly.core.layout.d, Unit> h() {
        return this.spanFrameDidChangedHandlerFn;
    }

    public final void i(float width, float height) {
        this.placeholderSize = new com.tencent.kuikly.core.base.w(width, height);
    }

    public final void j(com.tencent.kuikly.core.layout.d value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.spanFrame.f() || !value.equals(this.spanFrame)) {
            this.spanFrame = value;
            Function1<? super com.tencent.kuikly.core.layout.d, Unit> function1 = this.spanFrameDidChangedHandlerFn;
            if (function1 != null) {
                function1.invoke(value);
            }
        }
    }

    public final void k(Function1<? super com.tencent.kuikly.core.layout.d, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.spanFrameDidChangedHandlerFn = handler;
    }

    @Override // com.tencent.kuikly.core.views.ae
    public void d() {
    }
}
