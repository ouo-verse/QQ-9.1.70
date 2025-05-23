package com.tencent.qqnt.avatar.meta.info;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.cache.AvatarInfoCache;
import com.tencent.qqnt.avatar.meta.refresh.RefreshMapping;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J,\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/info/AvatarInfoCheck;", "", "", "avatarType", "", "id", "", "b", "fetchType", "reason", "c", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfo", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "a", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AvatarInfoCheck {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AvatarInfoCheck f352915a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f352915a = new AvatarInfoCheck();
        }
    }

    AvatarInfoCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b(int avatarType, @Nullable String id5) {
        c(avatarType, id5, 0, "");
    }

    @JvmStatic
    public static final void c(final int avatarType, @Nullable final String id5, int fetchType, @Nullable final String reason) {
        com.tencent.qqnt.avatar.util.d.f352991a.a("AvatarInfoCheck", new Function0<String>(avatarType, id5, reason) { // from class: com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck$notifyRefresh$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $avatarType;
            final /* synthetic */ String $id;
            final /* synthetic */ String $reason;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$avatarType = avatarType;
                this.$id = id5;
                this.$reason = reason;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(avatarType), id5, reason);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "notifyRefresh: [" + this.$avatarType + "_" + this.$id + "] " + this.$reason;
            }
        });
        AvatarInfoCache.f352688a.g(avatarType, id5);
        com.tencent.qqnt.avatar.meta.cache.b a16 = com.tencent.qqnt.avatar.meta.cache.a.f352913a.a();
        if (a16 != null) {
            a16.b(avatarType, id5);
        }
        com.tencent.qqnt.avatar.meta.refresh.a.f352938a.a(new com.tencent.qqnt.avatar.meta.refresh.bean.a(id5, avatarType, fetchType, reason));
        ArrayList arrayList = new ArrayList();
        Set<com.tencent.qqnt.avatar.meta.refresh.bean.a> d16 = RefreshMapping.f352936a.d(avatarType, id5);
        if (d16 != null) {
            for (com.tencent.qqnt.avatar.meta.refresh.bean.a aVar : d16) {
                AvatarInfoCache.f352688a.g(aVar.a(), aVar.b());
                com.tencent.qqnt.avatar.meta.cache.b a17 = com.tencent.qqnt.avatar.meta.cache.a.f352913a.a();
                if (a17 != null) {
                    a17.b(aVar.a(), aVar.b());
                }
                arrayList.add(aVar);
                com.tencent.qqnt.avatar.util.d.f352991a.e("AvatarInfoCheck", "notifyRefresh id:" + aVar.b());
            }
        }
        RefreshMapping.f352936a.e(avatarType, id5);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.avatar.meta.refresh.a.f352938a.a((com.tencent.qqnt.avatar.meta.refresh.bean.a) it.next());
        }
    }

    public final void a(@NotNull a avatarInfo, @NotNull com.tencent.qqnt.avatar.meta.a avatarBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarInfo, (Object) avatarBean);
            return;
        }
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new AvatarInfoCheck$infoCheck$1(avatarBean, avatarInfo, null), 3, null);
    }
}
