package com.tencent.mobileqq.activity.home.chats.troophelper;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.ItemClickUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J!\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\rH\u0096\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/troophelper/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/ItemClickUseCase;", "Landroid/content/Context;", "context", "", "groupId", "title", "", h.F, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "view", "Lcom/tencent/qqnt/chats/core/a;", "g", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends ItemClickUseCase {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void h(Context context, String groupId, String title) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        activityURIRequest.extra().putString("key_from", "17");
        activityURIRequest.extra().putString("uinname", title);
        activityURIRequest.extra().putString("uin", groupId);
        activityURIRequest.extra().putInt("uintype", 1);
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.ItemClickUseCase
    public void g(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item, @NotNull View view, @NotNull com.tencent.qqnt.chats.core.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, item, view, context);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        if (item instanceof g) {
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            g gVar = (g) item;
            h(context2, gVar.k(), gVar.w().e());
        }
    }
}
