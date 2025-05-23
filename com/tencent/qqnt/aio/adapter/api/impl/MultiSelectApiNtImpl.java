package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.aio.data.AIOContact;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IMultiSelectApi;
import com.tencent.qqnt.aio.adapter.widget.g;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/MultiSelectApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IMultiSelectApi;", "Landroid/content/Context;", "context", "", "forwardType", "Lcom/tencent/aio/data/AIOContact;", "contact", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/mvi/base/route/j;", "messenger", "", "multiForwardSelect", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MultiSelectApiNtImpl implements IMultiSelectApi {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/MultiSelectApiNtImpl$a", "Lcom/tencent/qqnt/aio/adapter/widget/g$a;", "", "onConfirm", "onCancel", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements g.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIOContact f348574a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mvi.base.route.j f348575b;

        a(AIOContact aIOContact, com.tencent.mvi.base.route.j jVar) {
            this.f348574a = aIOContact;
            this.f348575b = jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOContact, (Object) jVar);
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.widget.g.a
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f348575b.h(new MsgForwardEvent.MultiForwardSelectResult(false, null, null, null, false, 28, null));
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.widget.g.a
        public void onConfirm() {
            ArrayList arrayListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Contact(this.f348574a.e(), this.f348574a.j(), ""));
                this.f348575b.h(new MsgForwardEvent.MultiForwardSelectResult(true, arrayListOf, null, null, false, 28, null));
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public MultiSelectApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMultiSelectApi
    public void multiForwardSelect(@NotNull Context context, int forwardType, @NotNull AIOContact contact, @NotNull List<? extends AIOMsgItem> msgList, @NotNull com.tencent.mvi.base.route.j messenger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(forwardType), contact, msgList, messenger);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        com.tencent.qqnt.aio.adapter.widget.g gVar = new com.tencent.qqnt.aio.adapter.widget.g(context);
        gVar.W(contact.g());
        gVar.U(new a(contact, messenger));
        gVar.show();
    }
}
