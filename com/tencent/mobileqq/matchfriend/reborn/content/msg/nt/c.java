package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/c;", "Lcom/tencent/qqnt/chats/inject/avatar/c;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "Landroid/widget/ImageView;", "view", "", "c", "<init>", "()V", "d", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c extends com.tencent.qqnt.chats.inject.avatar.c {
    @Override // com.tencent.qqnt.chats.inject.avatar.c
    public boolean b(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.n() == 104;
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    public void c(com.tencent.qqnt.chats.core.adapter.itemdata.g item, ImageView view) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable();
        if (!TextUtils.isEmpty(item.g().d())) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QQStrangerChatAvatarProvider", 1, "[setAvatar] url=" + item.g().d());
            }
            ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage(view, item.g().d(), defaultFaceDrawable, defaultFaceDrawable, null, true);
            return;
        }
        view.setImageDrawable(defaultFaceDrawable);
    }
}
