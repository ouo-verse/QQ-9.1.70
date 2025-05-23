package com.tencent.qqnt.chats.data.processor;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.en;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.c;
import com.tencent.qqnt.chats.data.converter.e;
import com.tencent.qqnt.chats.data.processor.part.SummaryConvertProcessor;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/data/processor/b;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "d", "a", "c", "e", "b", "", QZoneImageUtils.KEY_MATCH, "update", "Lcom/tencent/qqnt/chats/data/processor/part/SummaryConvertProcessor;", "Lcom/tencent/qqnt/chats/data/processor/part/SummaryConvertProcessor;", "summaryProcessor", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SummaryConvertProcessor summaryProcessor;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.summaryProcessor = new SummaryConvertProcessor(true);
        }
    }

    private final void a(g item, c params) {
        item.g().n(2);
        item.g().l(Integer.valueOf(R.drawable.icon_recent_troop_assistant));
    }

    private final void b(g item, c params) {
        ArrayList arrayList = new ArrayList();
        if (item.H()) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.d());
        } else {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.q());
        }
        arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.g());
        item.O(arrayList);
    }

    private final void c(g item, c params) {
        this.summaryProcessor.update(item, params);
        item.x().e(1);
        item.x().d(0L);
        item.P(2);
    }

    private final void d(g item, c params) {
        if (item.s().msgTime != 0) {
            String s16 = en.s(new StringBuffer(25), item.s().msgTime * 1000, true, "", true, true);
            Intrinsics.checkNotNullExpressionValue(s16, "getRecentMessageDateTime\u202600, true, \"\", true, true)");
            item.Q(s16);
            return;
        }
        item.Q("");
    }

    private final void e(g item, c params) {
        g.f w3 = item.w();
        String string = params.b().getString(R.string.i59);
        Intrinsics.checkNotNullExpressionValue(string, "params.context.getString\u2026R.string.troop_assistant)");
        w3.i(string);
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(@NotNull g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.n() == 7) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(@NotNull g item, @NotNull c params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        a(item, params);
        c(item, params);
        e(item, params);
        b(item, params);
        d(item, params);
    }
}
