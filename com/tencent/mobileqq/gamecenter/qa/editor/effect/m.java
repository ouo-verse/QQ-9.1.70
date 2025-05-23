package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Spannable;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import zd1.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class m<V, C extends zd1.e<V>> extends g<V, C> {
    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.g
    public final void a(GameStrategyEditTextView gameStrategyEditTextView, V v3) {
        g(gameStrategyEditTextView, c(gameStrategyEditTextView), v3);
        h.b(gameStrategyEditTextView, this);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.g
    protected final Selection c(GameStrategyEditTextView gameStrategyEditTextView) {
        return gameStrategyEditTextView.S();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.g
    protected final p<V> e(Class<? extends zd1.e<V>> cls) {
        return new n(cls);
    }

    public abstract void g(GameStrategyEditTextView gameStrategyEditTextView, Selection selection, V v3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Spannable spannable, Paragraph paragraph, o<V> oVar) {
        oVar.e(d(spannable, paragraph, SpanCollectMode.EXACT), paragraph);
    }
}
