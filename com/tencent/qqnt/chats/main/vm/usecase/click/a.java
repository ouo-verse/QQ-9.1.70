package com.tencent.qqnt.chats.main.vm.usecase.click;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsBaseCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0011\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0096\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/click/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/a;", "context", "Landroid/os/Bundle;", "a", "", "listType", "", "b", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "needUnifiedAnim", "invoke", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Bundle a(g item, com.tencent.qqnt.chats.core.a context) {
        long j3;
        LIAActionItem lIAActionItem;
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_isblock", item.s().isBlock);
        bundle.putLong("key_peerUin", item.s().peerUin);
        bundle.putString("key_from", b(context.b()));
        bundle.putInt("key_from_chat_listtype", context.b());
        if (item.x().c() == 1) {
            j3 = item.x().b();
        } else {
            j3 = 0;
        }
        bundle.putLong("key_enter_unread_cnt", j3);
        if (item.z() && (lIAActionItem = (LIAActionItem) item.h(LiteBusinessType.KLITEACTION)) != null) {
            bundle.putParcelable("KEY_ACTION_ITEM", lIAActionItem);
        }
        com.tencent.qqnt.chats.api.b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(item.o());
        if (chatsListReport != null) {
            b.d v3 = chatsListReport.v();
            bundle.putString(WSStatisticsBaseCollector.KEY_REF_PAGE_ID, v3.a());
            bundle.putInt("key_page_stp", v3.b());
        }
        return bundle;
    }

    private final String b(int listType) {
        if (listType != 1) {
            if (listType != 2) {
                if (listType != 5) {
                    if (listType != 7) {
                        if (listType != 13) {
                            return "14";
                        }
                        return "19";
                    }
                    return "18";
                }
                return "16";
            }
            return "17";
        }
        return "0";
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        return params.b() instanceof g;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        View c16 = params.c();
        if (b16 instanceof g) {
            com.tencent.aio.pref.a.f69788j.n();
            g gVar = (g) b16;
            com.tencent.qqnt.trace.a.f362326a.g("ITEM_CLICK", "chat_type", Integer.valueOf(gVar.n()));
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
            Context context = c16.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            iAIOStarterApi.navigateToAIO(context, gVar.n(), gVar.k(), gVar.w().e(), gVar.l(), a(gVar, params.a()));
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        return false;
    }
}
