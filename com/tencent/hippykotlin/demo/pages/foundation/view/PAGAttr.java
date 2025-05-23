package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes31.dex */
public final class PAGAttr extends Attr {
    public Function0<Unit> attrDidInitBlock;
    public boolean didInit;

    public final void autoPlay(boolean z16) {
        with("autoPlay", Integer.valueOf(d.b(z16)));
    }

    public final void repeatCount(int i3) {
        with("repeatCount", Integer.valueOf(i3));
    }

    public final void src(final String str) {
        if (this.didInit) {
            with("src", str);
        } else {
            this.attrDidInitBlock = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr$src$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    PAGAttr.this.with("src", str);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
