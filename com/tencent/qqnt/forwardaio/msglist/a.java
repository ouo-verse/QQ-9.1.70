package com.tencent.qqnt.forwardaio.msglist;

import android.graphics.Color;
import android.view.View;
import androidx.recyclerview.widget.AIORecycleView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/forwardaio/msglist/a;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "T0", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends AIOMsgListVB {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVB, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, createViewParams, childView, uiHelper);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        View T0 = super.T0(createViewParams, childView, uiHelper);
        AIORecycleView M2 = M2();
        if (QQTheme.isNowThemeIsNight()) {
            M2.setBackgroundColor(Color.parseColor("#ff1a1a1a"));
        } else {
            M2.setBackground(null);
        }
        return T0;
    }
}
