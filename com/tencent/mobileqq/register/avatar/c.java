package com.tencent.mobileqq.register.avatar;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.proavatar.bean.ZPlanOutboundAvatarInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J)\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/c;", "Lcom/tencent/mobileqq/proavatar/b;", "Lcom/tencent/mobileqq/proavatar/bean/ZPlanOutboundAvatarInfo;", "avatarInfo", "", "", "", "d", "Landroid/net/Uri;", "avatarUri", "c", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "", "b", "", "a", "(Lcom/tencent/qqnt/avatar/meta/a;)[Ljava/util/Map;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c implements com.tencent.mobileqq.proavatar.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.avatar.c$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26529);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, Object> c(Uri avatarUri) {
        HashMap hashMap = new HashMap();
        hashMap.put("avatar_info_uri", avatarUri);
        return hashMap;
    }

    private final Map<String, Object> d(ZPlanOutboundAvatarInfo avatarInfo) {
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
        d dVar = d.f280340a;
        ZPlanAvatarInfo c16 = dVar.c();
        if (c16 != null) {
            return new Map[]{d(new ZPlanOutboundAvatarInfo(c16.a(), c16.c(), c16.f(), 0, 0, 24, null))};
        }
        Uri a16 = dVar.a();
        if (a16 != null) {
            c(a16);
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
        String c16 = avatarBean.c();
        d dVar = d.f280340a;
        if (TextUtils.equals(c16, dVar.b())) {
            return dVar.e();
        }
        return false;
    }
}
