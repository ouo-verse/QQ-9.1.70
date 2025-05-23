package com.tencent.mobileqq.aio.shortcurtbar.permission;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.shortcutbar.f;
import com.tencent.qqnt.aio.shortcutbar.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ=\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\r\u0010\u000eRB\u0010\u0019\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u000fj\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010`\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/shortcurtbar/permission/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "business", "", "permissions", "", "notifyType", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "listener", "", "a", "(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/String;ILcom/tencent/qqnt/aio/shortcutbar/j;)V", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/aio/shortcutbar/f;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getQqPermissionProcessor", "()Ljava/util/ArrayList;", "setQqPermissionProcessor", "(Ljava/util/ArrayList;)V", "qqPermissionProcessor", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f193758a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @ConfigInject(configPath = "AutoInjectYml/Business/AIO/shortcutbar/Inject_Shortcutbar_Permission.yml", version = 3)
    @NotNull
    private static ArrayList<Class<? extends f>> qqPermissionProcessor;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64969);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f193758a = new a();
        ArrayList<Class<? extends f>> arrayList = new ArrayList<>();
        qqPermissionProcessor = arrayList;
        arrayList.add(u61.a.class);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Activity activity, @NotNull String business, @NotNull String[] permissions, int notifyType, @Nullable j listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, business, permissions, Integer.valueOf(notifyType), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (qqPermissionProcessor.size() == 0) {
            return;
        }
        try {
            qqPermissionProcessor.get(0).newInstance().a(activity, business, permissions, notifyType, listener);
        } catch (IllegalAccessException e16) {
            throw new RuntimeException(e16);
        } catch (InstantiationException e17) {
            throw new RuntimeException(e17);
        }
    }
}
