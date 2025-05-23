package com.tencent.kuikly.core.views;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.kuikly.core.base.Attr;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u0013\u001a\u00020\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/kuikly/core/views/PAGViewAttr;", "Lcom/tencent/kuikly/core/base/Attr;", "", "src", "", "Lcom/tencent/kuikly/core/base/attr/e;", LayoutAttrDefine.CLICK_URI, "l", "", "repeatCount", "", "play", "autoPlay", "a", "Z", "i", "()Z", "k", "(Z)V", "didInit", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", tl.h.F, "()Lkotlin/jvm/functions/Function0;", "j", "(Lkotlin/jvm/functions/Function0;)V", "attrDidInitBlock", "<init>", "()V", "c", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PAGViewAttr extends Attr {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean didInit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> attrDidInitBlock;

    public final void autoPlay(boolean play) {
        with("autoPlay", Integer.valueOf(com.tencent.kuikly.core.base.d.b(play)));
    }

    public final Function0<Unit> h() {
        return this.attrDidInitBlock;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getDidInit() {
        return this.didInit;
    }

    public final void j(Function0<Unit> function0) {
        this.attrDidInitBlock = function0;
    }

    public final void k(boolean z16) {
        this.didInit = z16;
    }

    public final void l(final com.tencent.kuikly.core.base.attr.e uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        PAGViewKt.c(this, new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.PAGViewAttr$src$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PAGViewAttr pAGViewAttr = PAGViewAttr.this;
                pAGViewAttr.with("src", uri.a(pAGViewAttr.getPager().getPageName()));
            }
        });
    }

    public final void repeatCount(int repeatCount) {
        with("repeatCount", Integer.valueOf(repeatCount));
    }

    public final void src(final String src) {
        Intrinsics.checkNotNullParameter(src, "src");
        PAGViewKt.c(this, new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.PAGViewAttr$src$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PAGViewAttr.this.with("src", src);
            }
        });
    }
}
