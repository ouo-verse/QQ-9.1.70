package com.tencent.qqnt.chathistory.ui.dialog;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.util.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J$\u0010\u000e\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/a;", "Landroid/widget/TextView$OnEditorActionListener;", "Landroid/view/View$OnKeyListener;", "Landroid/view/View;", "paramView", "", "paramInt", "Landroid/view/KeyEvent;", "event", "", "onKey", "Landroid/widget/TextView;", "v", "actionId", "onEditorAction", "Lkotlin/Function0;", "", "d", "Lkotlin/jvm/functions/Function0;", "getAction", "()Lkotlin/jvm/functions/Function0;", "action", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements TextView.OnEditorActionListener, View.OnKeyListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> action;

    public a(@NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) action);
        } else {
            this.action = action;
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(@Nullable TextView v3, int actionId, @Nullable KeyEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 4, this, v3, Integer.valueOf(actionId), event)).booleanValue();
        } else if (actionId == 3) {
            this.action.invoke();
            if (v3 != null) {
                l.f354063a.g(v3);
            }
        } else {
            z16 = false;
        }
        EventCollector.getInstance().onEditorAction(v3, actionId, event);
        return z16;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(@Nullable View paramView, int paramInt, @NotNull KeyEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, paramView, Integer.valueOf(paramInt), event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getKeyCode() != 66 && event.getKeyCode() != 84) {
            return false;
        }
        if (event.getAction() == 1) {
            this.action.invoke();
            if (paramView != null) {
                l.f354063a.g(paramView);
            }
        }
        return true;
    }
}
