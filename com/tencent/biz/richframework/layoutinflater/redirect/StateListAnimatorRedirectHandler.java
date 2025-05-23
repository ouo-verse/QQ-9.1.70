package com.tencent.biz.richframework.layoutinflater.redirect;

import android.os.Build;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/redirect/StateListAnimatorRedirectHandler;", "Lcom/tencent/biz/richframework/layoutinflater/redirect/AttrRedirectHandler;", "()V", "getCheckAttrName", "", "isTargetVersion", "", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class StateListAnimatorRedirectHandler extends AttrRedirectHandler {
    @Override // com.tencent.biz.richframework.layoutinflater.redirect.AttrRedirectHandler
    @NotNull
    public String getCheckAttrName() {
        return "stateListAnimator";
    }

    @Override // com.tencent.biz.richframework.layoutinflater.redirect.AttrRedirectHandler
    public boolean isTargetVersion() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 25 && i3 != 24) {
            return false;
        }
        return true;
    }
}
