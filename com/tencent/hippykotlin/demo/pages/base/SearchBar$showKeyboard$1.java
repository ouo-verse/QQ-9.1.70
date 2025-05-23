package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.RenderView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SearchBar$showKeyboard$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SearchBar this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBar$showKeyboard$1(SearchBar searchBar) {
        super(0);
        this.this$0 = searchBar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        RenderView renderView = this.this$0.getRenderView();
        if (renderView != null) {
            RenderView.b(renderView, "showKeyboard", "", null, 4, null);
        }
        return Unit.INSTANCE;
    }
}
