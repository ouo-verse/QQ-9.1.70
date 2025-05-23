package com.tencent.qqnt.aio.nick.api.impl;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.nick.api.IAIONickBlockApi;
import com.tencent.qqnt.aio.nick.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/nick/api/impl/AIONickBlockApiNtImpl;", "Lcom/tencent/qqnt/aio/nick/api/IAIONickBlockApi;", "", "memberUin", "", "gradeLevel", "gameCardId", "gameCardSwitch", "Landroid/graphics/drawable/Drawable;", "getGradeLevelDrawable", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/nick/f;", "getMemberLevelInfo", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIONickBlockApiNtImpl implements IAIONickBlockApi {
    static IPatchRedirector $redirector_;

    public AIONickBlockApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.nick.api.IAIONickBlockApi
    @NotNull
    public Drawable getGradeLevelDrawable(@NotNull String memberUin, int gradeLevel, int gameCardId, int gameCardSwitch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, this, memberUin, Integer.valueOf(gradeLevel), Integer.valueOf(gameCardId), Integer.valueOf(gameCardSwitch));
        }
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        return new ColorDrawable(-7829368);
    }

    @Override // com.tencent.qqnt.aio.nick.api.IAIONickBlockApi
    @NotNull
    public f getMemberLevelInfo(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return new f(10315, 17, "\u7fa4\u4e3b", new int[]{-14786, -8395}, new int[]{-5985086, -5063986}, true, true, -1, -1, null);
    }
}
