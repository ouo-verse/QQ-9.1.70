package com.tencent.mobileqq.pymk.api.impl;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.newfriend.ui.view.PYMKItemView;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pymk.api.IPYMKAddFrinedApi;
import com.tencent.mobileqq.pymk.g;
import com.tencent.mobileqq.pymk.repository.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/pymk/api/impl/PYMKAddFrinedApiImpl;", "Lcom/tencent/mobileqq/pymk/api/IPYMKAddFrinedApi;", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "getPYMKItemView", "view", "Lcom/tencent/mobileqq/persistence/Entity;", "entity", "", "bindData", "Landroid/view/View;", "initMediaLayout", "Lcom/tencent/mobileqq/pymk/g;", "listener", "addOnSwitchChangeListener", "removeOnSwitchChangeListener", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PYMKAddFrinedApiImpl implements IPYMKAddFrinedApi {
    static IPatchRedirector $redirector_;

    public PYMKAddFrinedApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKAddFrinedApi
    public void addOnSwitchChangeListener(@NotNull g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            a.f261485a.a(listener);
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKAddFrinedApi
    public void bindData(@NotNull LinearLayout view, @NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(entity, "entity");
        if ((view instanceof PYMKItemView) && (entity instanceof MayKnowRecommend)) {
            ((PYMKItemView) view).a((MayKnowRecommend) entity);
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKAddFrinedApi
    @NotNull
    public LinearLayout getPYMKItemView(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new PYMKItemView(context, null, 2, null);
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKAddFrinedApi
    public void initMediaLayout(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof PYMKItemView) {
            ((PYMKItemView) view).d();
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.IPYMKAddFrinedApi
    public void removeOnSwitchChangeListener(@NotNull g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            a.f261485a.b(listener);
        }
    }
}
