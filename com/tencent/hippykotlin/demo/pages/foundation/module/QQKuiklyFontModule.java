package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyFontModule;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.TextView;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQKuiklyFontModule extends Module {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
        public final void innerRefreshText(DeclarativeBaseView<?, ?> declarativeBaseView) {
            if ((declarativeBaseView instanceof RichTextView) || (declarativeBaseView instanceof TextView)) {
                ?? viewAttr = declarativeBaseView.getViewAttr();
                int i3 = QQKuiklyFontModuleKt.gFontMarkDirtyIncrease;
                QQKuiklyFontModuleKt.gFontMarkDirtyIncrease = i3 + 1;
                viewAttr.setProp("refresh_key", String.valueOf(i3));
            }
            if (declarativeBaseView instanceof ViewContainer) {
                Iterator<T> it = ((ViewContainer) declarativeBaseView).getSubviews().iterator();
                while (it.hasNext()) {
                    QQKuiklyFontModule.Companion.innerRefreshText((DeclarativeBaseView) it.next());
                }
            }
        }
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQKuiklyFontModule";
    }

    public final void registerFont(String str, final boolean z16, final Function1<? super e, Unit> function1) {
        e eVar = new e();
        eVar.v("fontSrc", str);
        toNative(false, "registerFont", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyFontModule$registerFont$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                Function1<e, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(eVar3);
                }
                if (z16) {
                    QQKuiklyFontModule.Companion companion = QQKuiklyFontModule.Companion;
                    b g16 = c.f117352a.g();
                    Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.kuikly.core.pager.Pager");
                    companion.innerRefreshText((Pager) g16);
                }
                return Unit.INSTANCE;
            }
        }, false);
    }
}
