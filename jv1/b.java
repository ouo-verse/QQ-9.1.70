package jv1;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.GuildChatUtils;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Ljv1/b;", "Lcom/tencent/qqnt/chats/inject/avatar/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lnw3/a;", "view", "", "a", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends com.tencent.qqnt.chats.inject.avatar.a {
    @Override // com.tencent.qqnt.chats.inject.avatar.a
    public void a(@NotNull g item, @NotNull nw3.a view) {
        RoundRectImageView roundRectImageView;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if ((view instanceof nw3.c) && item.n() == 16) {
            ImageView avatarView = view.getAvatarView();
            Drawable drawable = null;
            if (avatarView instanceof RoundRectImageView) {
                roundRectImageView = (RoundRectImageView) avatarView;
            } else {
                roundRectImageView = null;
            }
            if (roundRectImageView != null) {
                roundRectImageView.setCornerRadiusAndMode(GuildLayoutManager.f354256a.k(), 1);
            }
            String d16 = item.g().d();
            GuildChatUtils guildChatUtils = GuildChatUtils.f213838a;
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IQQGuildAvatarApi.class, "");
            } else {
                iRuntimeService = null;
            }
            IQQGuildAvatarApi iQQGuildAvatarApi = (IQQGuildAvatarApi) iRuntimeService;
            if (iQQGuildAvatarApi != null) {
                drawable = iQQGuildAvatarApi.getDefaultFaceDrawable(true);
            }
            e.a().e(new Option().setUrl(d16).setTargetView(view.getAvatarView()).setNeedFilterUrl(false).setLoadingDrawable(drawable));
        }
    }
}
