package com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.component;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.component.d;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004R\u001f\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/d;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "payloads", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/b;", "Lmqq/util/WeakReference;", "b", "()Lmqq/util/WeakReference;", "weak", "self", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/b;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<b> weak;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/d$a", "Lcom/tencent/qqnt/aio/adapter/api/IAIONickIconServiceApi$b;", "", "fetchedFromLruCache", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "nickIconData", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements IAIONickIconServiceApi.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOMsgItem f191392b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Object> f191393c;

        a(AIOMsgItem aIOMsgItem, List<Object> list) {
            this.f191392b = aIOMsgItem;
            this.f191393c = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, aIOMsgItem, list);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(d this$0, AIOMsgItem msgItem, List payloads, List nickIconData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
            Intrinsics.checkNotNullParameter(payloads, "$payloads");
            Intrinsics.checkNotNullParameter(nickIconData, "$nickIconData");
            b bVar = this$0.b().get();
            if (bVar != null) {
                bVar.d(msgItem, payloads, nickIconData);
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi.b
        public void a(boolean fetchedFromLruCache, @NotNull final List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> nickIconData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(fetchedFromLruCache), nickIconData);
                return;
            }
            Intrinsics.checkNotNullParameter(nickIconData, "nickIconData");
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                b bVar = d.this.b().get();
                if (bVar != null) {
                    bVar.d(this.f191392b, this.f191393c, nickIconData);
                    return;
                }
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final d dVar = d.this;
            final AIOMsgItem aIOMsgItem = this.f191392b;
            final List<Object> list = this.f191393c;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.component.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.c(d.this, aIOMsgItem, list, nickIconData);
                }
            });
        }
    }

    public d(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.weak = new WeakReference<>(bVar);
        }
    }

    public final void a(@NotNull AIOMsgItem msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem, (Object) payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ((IAIONickIconServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIONickIconServiceApi.class)).getTmInfoIconDataAsync(String.valueOf(msgItem.getMsgRecord().peerUin), String.valueOf(msgItem.getMsgRecord().senderUin), new a(msgItem, payloads));
    }

    @NotNull
    public final WeakReference<b> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.weak;
    }
}
