package com.tencent.mobileqq.qqsettingme.argus;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQSettingMeRelativeLayout;
import com.tencent.richframework.argus.node.ArgusNodeCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqsettingme/argus/b;", "Lcom/tencent/richframework/argus/node/ArgusNodeCreator;", "Lcom/tencent/mobileqq/qqsettingme/argus/a;", "Landroid/view/View;", "currentView", "", ParseCommon.CONTAINER, "", "canHandle", "nodeView", "a", "<init>", "()V", "drawer-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b implements ArgusNodeCreator<a> {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a createNode(@NotNull View nodeView, @Nullable Object container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) nodeView, container);
        }
        Intrinsics.checkNotNullParameter(nodeView, "nodeView");
        return new a(nodeView, (QQSettingMeRelativeLayout) nodeView);
    }

    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    public boolean canHandle(@NotNull View currentView, @Nullable Object container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) currentView, container)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        return currentView instanceof QQSettingMeRelativeLayout;
    }
}
