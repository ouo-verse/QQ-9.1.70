package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.R;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cn;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/e;", "Lcom/tencent/qqnt/chats/inject/background/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "context", "", "d", "Landroid/graphics/drawable/Drawable;", "c", "b", "Landroid/view/View;", "view", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends com.tencent.qqnt.chats.inject.background.a {
    private final Drawable b() {
        com.tencent.mobileqq.matchfriend.reborn.utils.o oVar = com.tencent.mobileqq.matchfriend.reborn.utils.o.f245489a;
        int c16 = oVar.c();
        int a16 = com.tencent.biz.qui.quicommon.a.a(c16, oVar.e());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(a16));
        stateListDrawable.addState(new int[]{R.attr.state_selected}, new ColorDrawable(a16));
        stateListDrawable.addState(new int[0], new ColorDrawable(c16));
        return stateListDrawable;
    }

    private final Drawable c() {
        com.tencent.mobileqq.matchfriend.reborn.utils.o oVar = com.tencent.mobileqq.matchfriend.reborn.utils.o.f245489a;
        int a16 = com.tencent.biz.qui.quicommon.a.a(oVar.c(), oVar.d());
        int a17 = com.tencent.biz.qui.quicommon.a.a(a16, oVar.e());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(a17));
        stateListDrawable.addState(new int[]{R.attr.state_selected}, new ColorDrawable(a17));
        stateListDrawable.addState(new int[0], new ColorDrawable(a16));
        return stateListDrawable;
    }

    private final void d(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context) {
        com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(context);
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        dVar.c("pg_kl_new_chat_list", hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_kl_top_button");
        dVar.b(arrayList);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("to_uin", item.k());
        dVar.g("em_kl_top_button", hashMap2);
    }

    @Override // com.tencent.qqnt.chats.inject.background.a
    public void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, View view) {
        Drawable b16;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() != 104) {
            return;
        }
        if (item.H()) {
            b16 = c();
        } else {
            b16 = b();
        }
        view.setBackground(cn.f(b16));
        if (item.H()) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            d(item, context);
        }
    }
}
