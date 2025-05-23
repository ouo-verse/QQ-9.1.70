package com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsUIState;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "SetRevokeText", "Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsUIState$SetRevokeText;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class RevokeGrayTipsUIState implements IMsgItemMviUIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsUIState$SetRevokeText;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsUIState;", "", "d", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "nickBy", "e", "textFirst", "f", "c", "nickOf", tl.h.F, "textTail", "", "i", "Z", "a", "()Z", "canEdit", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class SetRevokeText extends RevokeGrayTipsUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence nickBy;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence textFirst;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence nickOf;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence textTail;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final boolean canEdit;

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.canEdit;
        }

        @NotNull
        public final CharSequence b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.nickBy;
        }

        @NotNull
        public final CharSequence c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.nickOf;
        }

        @NotNull
        public final CharSequence d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.textFirst;
        }

        @NotNull
        public final CharSequence e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.textTail;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
