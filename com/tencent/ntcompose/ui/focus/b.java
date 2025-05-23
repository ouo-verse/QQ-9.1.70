package com.tencent.ntcompose.ui.focus;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.TextAreaView;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0001\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0000H\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00022\u0010\u0010\u0001\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0000H\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "", "b", "a", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {
    public static final boolean a(DeclarativeBaseView<?, ?> declarativeBaseView) {
        if (declarativeBaseView == null) {
            return false;
        }
        if (declarativeBaseView instanceof ViewContainer) {
            Iterator<DeclarativeBaseView<?, ?>> it = VirtualViewKt.a((ViewContainer) declarativeBaseView).iterator();
            while (it.hasNext()) {
                if (a(it.next())) {
                    return true;
                }
            }
        } else {
            if (declarativeBaseView instanceof InputView) {
                ((InputView) declarativeBaseView).h();
                return true;
            }
            if (declarativeBaseView instanceof TextAreaView) {
                ((TextAreaView) declarativeBaseView).h();
                return true;
            }
        }
        return false;
    }

    public static final boolean b(DeclarativeBaseView<?, ?> declarativeBaseView) {
        if (declarativeBaseView == null) {
            return false;
        }
        if (declarativeBaseView instanceof ViewContainer) {
            Iterator<DeclarativeBaseView<?, ?>> it = VirtualViewKt.a((ViewContainer) declarativeBaseView).iterator();
            while (it.hasNext()) {
                if (b(it.next())) {
                    return true;
                }
            }
        } else {
            if (declarativeBaseView instanceof InputView) {
                ((InputView) declarativeBaseView).k();
                return true;
            }
            if (declarativeBaseView instanceof TextAreaView) {
                ((TextAreaView) declarativeBaseView).l();
                return true;
            }
        }
        return false;
    }
}
