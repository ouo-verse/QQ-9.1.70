package com.tencent.mobileqq.guild.media.widget.user.delegates.game;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.media.core.viewpool.ViewPoolEngine;
import com.tencent.mobileqq.guild.media.game.memberlist.MemberRvGamingItemViewHolder;
import com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt1.GameNormalItem;
import rt1.a;
import tl.h;
import vs1.e;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/game/GamingPlayerUserItemDelegate;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/game/BaseGamePlayerUserItemDelegate;", "Lrt1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "u", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvGamingItemViewHolder;", "v", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "adapter", "<init>", "(Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;)V", h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GamingPlayerUserItemDelegate extends BaseGamePlayerUserItemDelegate {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamingPlayerUserItemDelegate(@NotNull BaseMediaUserDelegateAdapter adapter) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull a item, @NotNull List<a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item instanceof GameNormalItem) {
            GameNormalItem gameNormalItem = (GameNormalItem) item;
            if (gameNormalItem.getUserInfo().f228098f == 0 && gameNormalItem.getUserInfo().C.getUserInfoInGame().getGameIdentity() != 0 && gameNormalItem.getUserInfo().C.getUserInfoInGame().getGameStatus() == 3) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public MemberRvGamingItemViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewPoolEngine viewPoolEngine = ViewPoolEngine.f228744a;
        e.b bVar = e.b.f443290a;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        View i3 = viewPoolEngine.i(bVar, context);
        i3.setTag(8);
        return new MemberRvGamingItemViewHolder(i3);
    }
}
