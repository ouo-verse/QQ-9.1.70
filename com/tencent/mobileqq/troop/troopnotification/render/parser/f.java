package com.tencent.mobileqq.troop.troopnotification.render.parser;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0012H\u0016J6\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J6\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0010\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0016R\u001a\u0010\u001f\u001a\u00020\u000b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/f;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "", "j", "Lcom/tencent/qqnt/notification/f;", "msg", "", "wildcardValue", "", "", "data", "", "g", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "d", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "b", "c", "a", "Lcom/tencent/qqnt/notification/b;", "i", "Landroid/content/Context;", "context", "avatarInfo", "f", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f300753a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String key;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59338);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f300753a = new f();
            key = "avatar";
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean g(final com.tencent.qqnt.notification.f msg2, Object wildcardValue, Map<String, ? extends Object> data, QQProAvatarView avatar) {
        final com.tencent.qqnt.notification.b i3 = i(wildcardValue);
        msg2.l(i3);
        if (i3 != null) {
            avatar.x(i3.d(), i3.c(), null);
            avatar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.h(com.tencent.qqnt.notification.f.this, i3, view);
                }
            });
            int b16 = i3.b();
            if (b16 != 1) {
                if (b16 != 2) {
                    avatar.setContentDescription("\u5934\u50cf");
                } else {
                    avatar.setContentDescription("\u7fa4\u5934\u50cf");
                }
            } else {
                avatar.setContentDescription("\u7528\u6237\u5934\u50cf");
            }
        }
        if (i3 != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(com.tencent.qqnt.notification.f msg2, com.tencent.qqnt.notification.b info, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(info, "$info");
        f fVar = f300753a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        fVar.f(context, msg2, info);
        com.tencent.mobileqq.troop.troopnotification.report.d.f300921a.j(msg2);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j(QQProAvatarView avatar) {
        avatar.setImageDrawable(null);
        avatar.setOnClickListener(null);
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean a(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return g(msg2, wildcardValue, data, viewHolder.e());
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            j(viewHolder.e());
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean c(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return g(msg2, wildcardValue, data, viewHolder.l());
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void d(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            j(viewHolder.l());
        }
    }

    public final boolean f(@NotNull Context context, @NotNull com.tencent.qqnt.notification.f msg2, @NotNull com.tencent.qqnt.notification.b avatarInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, context, msg2, avatarInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        int b16 = avatarInfo.b();
        if (b16 != 1) {
            if (b16 != 2) {
                QLog.e("TroopNotificationAvatarParser", 1, "invokeClick: avatar type error, avatarInfo=" + avatarInfo);
                return false;
            }
            com.tencent.mobileqq.troop.troopnotification.utils.d.f300927a.c(context, avatarInfo.c(), msg2);
            return true;
        }
        Object obj = avatarInfo.a().get(VipFunCallConstants.KEY_GROUP);
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        com.tencent.mobileqq.troop.troopnotification.utils.d.f300927a.f(context, str, avatarInfo.c(), msg2);
        return true;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    @NotNull
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return key;
    }

    @Nullable
    public final com.tencent.qqnt.notification.b i(@Nullable Object wildcardValue) {
        Map map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.notification.b) iPatchRedirector.redirect((short) 7, (Object) this, wildcardValue);
        }
        if (wildcardValue instanceof Map) {
            map = (Map) wildcardValue;
        } else {
            map = null;
        }
        if (map == null) {
            QLog.e("TroopNotificationAvatarParser", 1, "parse: not find avatarData, wildcardValue=" + wildcardValue);
            return null;
        }
        Object obj = map.get("type");
        String valueOf = String.valueOf(map.get("uin"));
        if (Intrinsics.areEqual(obj, (Object) 1)) {
            return new com.tencent.qqnt.notification.b(1, 1, valueOf, map);
        }
        if (Intrinsics.areEqual(obj, (Object) 2)) {
            return new com.tencent.qqnt.notification.b(2, 4, valueOf, map);
        }
        QLog.e("TroopNotificationAvatarParser", 1, "parse: type error, type=" + obj);
        return null;
    }
}
