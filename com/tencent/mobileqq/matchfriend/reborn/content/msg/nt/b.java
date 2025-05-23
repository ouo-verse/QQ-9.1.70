package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qqnt.chats.view.widget.DefaultRecentAvatarView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/b;", "Lcom/tencent/qqnt/chats/inject/avatar/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lnw3/a;", "view", "", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends com.tencent.qqnt.chats.inject.avatar.a {
    @Override // com.tencent.qqnt.chats.inject.avatar.a
    public void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, nw3.a view) {
        ImageView h16;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() != 104) {
            return;
        }
        if (view instanceof nw3.c) {
            h16 = ((nw3.c) view).d();
        } else {
            h16 = view instanceof DefaultRecentAvatarView ? ((DefaultRecentAvatarView) view).h() : null;
        }
        if (h16 != null) {
            Integer f16 = item.g().f();
            if (f16 != null) {
                h16.setImageResource(f16.intValue());
                ViewGroup.LayoutParams layoutParams = h16.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = BaseAIOUtils.f(14.0f, h16.getResources());
                layoutParams2.height = BaseAIOUtils.f(14.0f, h16.getResources());
                layoutParams2.gravity = 8388693;
                layoutParams2.rightMargin = BaseAIOUtils.f(4.0f, h16.getResources());
                layoutParams2.bottomMargin = BaseAIOUtils.f(4.0f, h16.getResources());
                h16.setVisibility(0);
                return;
            }
            h16.setVisibility(8);
        }
    }
}
