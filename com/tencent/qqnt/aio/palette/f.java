package com.tencent.qqnt.aio.palette;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR0\u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/palette/f;", "", "", "isFromCreate", "", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/qui/profileskin/c;", "b", "", "c", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/Map;", "tokenMap", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f351749a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Map<String, Pair<com.tencent.mobileqq.qui.profileskin.c, com.tencent.mobileqq.qui.profileskin.c>> tokenMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27895);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f351749a = new f();
            lock = new Object();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        f351749a.b(false);
    }

    @NotNull
    public final Map<String, Pair<com.tencent.mobileqq.qui.profileskin.c, com.tencent.mobileqq.qui.profileskin.c>> b(boolean isFromCreate) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this, isFromCreate);
        }
        if (tokenMap == null) {
            if (!isFromCreate) {
                QLog.i("TokenMapTool", 1, "from preload");
            }
            synchronized (lock) {
                if (tokenMap == null) {
                    tokenMap = com.tencent.mobileqq.qui.util.a.f276940a.a("robot_token_mapping_config.json");
                    if (isFromCreate) {
                        str = "from create";
                    } else {
                        str = "from preload";
                    }
                    QLog.i("TokenMapTool", 1, "load tokenMap, load success " + str);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Map<String, Pair<com.tencent.mobileqq.qui.profileskin.c, com.tencent.mobileqq.qui.profileskin.c>> map = tokenMap;
        Intrinsics.checkNotNull(map);
        return map;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.palette.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.d();
                }
            }, 64, null, false);
        }
    }
}
