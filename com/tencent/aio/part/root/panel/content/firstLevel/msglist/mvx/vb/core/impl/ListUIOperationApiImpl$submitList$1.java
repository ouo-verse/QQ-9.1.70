package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import com.tencent.aio.api.list.g;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/ListUIOperationApiImpl$submitList$1", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/e;", "", "add", "", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ListUIOperationApiImpl$submitList$1 extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ListUIOperationApiImpl f69606c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g.b f69607d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListUIOperationApiImpl$submitList$1(ListUIOperationApiImpl listUIOperationApiImpl, g.b bVar, g.a aVar) {
        super(aVar);
        this.f69606c = listUIOperationApiImpl;
        this.f69607d = bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, listUIOperationApiImpl, bVar, aVar);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.e
    public void b(boolean add) {
        AbsMsgListVB absMsgListVB;
        AbsMsgListVB absMsgListVB2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            absMsgListVB = this.f69606c.absListVB;
            absMsgListVB.q1().setTag(R.id.f792949d, Boolean.valueOf(add));
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.a.f69187b.d("ListUIOperationApiImpl", "afterFastOperation " + add + TokenParser.SP);
            }
            if (add) {
                absMsgListVB2 = this.f69606c.absListVB;
                absMsgListVB2.q1().post(new Runnable() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListUIOperationApiImpl$submitList$1$afterFastOperation$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ListUIOperationApiImpl$submitList$1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this);
                        } else {
                            ListUIOperationApiImpl$submitList$1.this.f69606c.o();
                            ListUIOperationApiImpl$submitList$1.this.f69606c.M(0);
                        }
                    }
                });
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, add);
    }
}
