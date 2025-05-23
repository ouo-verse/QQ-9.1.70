package com.tencent.mobileqq.selectfriend.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectfriend.callback.IConfirmDialogCancelClickCallback;
import com.tencent.mobileqq.selectfriend.callback.IConfirmDialogConfirmClickCallback;
import com.tencent.mobileqq.selectfriend.callback.IForwardFriendSelectCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/model/b;", "", "Lcom/tencent/mobileqq/selectfriend/callback/IForwardFriendSelectCallback;", "c", "Lcom/tencent/mobileqq/selectfriend/callback/IConfirmDialogConfirmClickCallback;", "b", "Lcom/tencent/mobileqq/selectfriend/callback/IConfirmDialogCancelClickCallback;", "a", "Lcom/tencent/mobileqq/selectfriend/callback/IForwardFriendSelectCallback;", "mForwardFriendSelectCallback", "Lcom/tencent/mobileqq/selectfriend/callback/IConfirmDialogConfirmClickCallback;", "mConfirmDialogConfirmClickCallback", "Lcom/tencent/mobileqq/selectfriend/callback/IConfirmDialogCancelClickCallback;", "mConfirmDialogCancelClickCallback", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IForwardFriendSelectCallback mForwardFriendSelectCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IConfirmDialogConfirmClickCallback mConfirmDialogConfirmClickCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IConfirmDialogCancelClickCallback mConfirmDialogCancelClickCallback;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final IConfirmDialogCancelClickCallback a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IConfirmDialogCancelClickCallback) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mConfirmDialogCancelClickCallback;
    }

    @Nullable
    public final IConfirmDialogConfirmClickCallback b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IConfirmDialogConfirmClickCallback) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mConfirmDialogConfirmClickCallback;
    }

    @Nullable
    public final IForwardFriendSelectCallback c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IForwardFriendSelectCallback) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mForwardFriendSelectCallback;
    }
}
