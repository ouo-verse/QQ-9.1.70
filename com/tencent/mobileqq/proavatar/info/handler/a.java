package com.tencent.mobileqq.proavatar.info.handler;

import com.tencent.mobileqq.proavatar.b;
import com.tencent.mobileqq.proavatar.bean.ZPlanOutboundAvatarInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J)\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\f2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/proavatar/info/handler/a;", "Lcom/tencent/mobileqq/proavatar/b;", "Lcom/tencent/mobileqq/proavatar/bean/ZPlanOutboundAvatarInfo;", "avatarInfo", "", "", "", "c", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "", "b", "", "a", "(Lcom/tencent/qqnt/avatar/meta/a;)[Ljava/util/Map;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, Object> c(ZPlanOutboundAvatarInfo avatarInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_outbound_avatar_info", avatarInfo);
        return hashMap;
    }

    @Override // com.tencent.mobileqq.proavatar.b
    @NotNull
    public Map<String, Object>[] a(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) avatarBean);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Object obj = avatarBean.g().get("key_zplan_outbound_avatar_info");
        if (obj instanceof ZPlanOutboundAvatarInfo) {
            return new Map[]{c((ZPlanOutboundAvatarInfo) obj)};
        }
        return new Map[0];
    }

    @Override // com.tencent.mobileqq.proavatar.b
    public boolean b(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarBean)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        if (avatarBean.g().get("key_zplan_outbound_avatar_info") instanceof ZPlanOutboundAvatarInfo) {
            return true;
        }
        return false;
    }
}
