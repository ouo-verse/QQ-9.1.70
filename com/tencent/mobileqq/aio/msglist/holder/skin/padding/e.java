package com.tencent.mobileqq.aio.msglist.holder.skin.padding;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/e;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/j;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "a", "", "e", "I", "j", "()I", "setInnerTextItemIntervalSpace", "(I)V", "innerTextItemIntervalSpace", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e extends j {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int innerTextItemIntervalSpace;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/e$a;", "", "", "b", "I", "a", "()I", "AIO_MIX_TEXT_ITEM_INTERVAL_SPACE", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f192439a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final int AIO_MIX_TEXT_ITEM_INTERVAL_SPACE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48983);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f192439a = new a();
                AIO_MIX_TEXT_ITEM_INTERVAL_SPACE = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.bzo);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return AIO_MIX_TEXT_ITEM_INTERVAL_SPACE;
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.skin.padding.j, com.tencent.mobileqq.aio.msglist.holder.skin.padding.a
    @NotNull
    public com.tencent.mobileqq.aio.msglist.holder.skin.padding.a a(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.skin.padding.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        super.a(msgItem);
        this.innerTextItemIntervalSpace = a.f192439a.a();
        return this;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.innerTextItemIntervalSpace;
    }
}
