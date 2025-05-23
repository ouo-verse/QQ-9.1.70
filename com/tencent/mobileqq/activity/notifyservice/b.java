package com.tencent.mobileqq.activity.notifyservice;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0017\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/activity/notifyservice/b;", "Lcom/tencent/qqnt/chats/inject/avatar/c;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "Landroid/widget/ImageView;", "view", "", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends com.tencent.qqnt.chats.inject.avatar.c {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    public boolean b(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.n() == 201) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void c(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull ImageView view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!TextUtils.isEmpty(item.g().d())) {
            try {
                ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage(view, item.g().d(), view.getResources().getDrawable(R.drawable.f160830com), view.getResources().getDrawable(R.drawable.f160830com), null, true);
                return;
            } catch (Exception unused) {
                QLog.e("GameBoxChatAvatarProvider", 1, "setAvatar is error, item.avatarInfo.path is " + item.g().d());
                view.setImageResource(R.drawable.f160830com);
                return;
            }
        }
        view.setImageResource(R.drawable.f160830com);
    }
}
