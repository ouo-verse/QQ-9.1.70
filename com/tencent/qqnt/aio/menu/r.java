package com.tencent.qqnt.aio.menu;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.robot.menu.RobotMsgMenuItemConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004R*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\t8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u0012\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/menu/r;", "", "", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/menu/q;", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getMMenuConfigList$annotations", "()V", "mMenuConfigList", "<init>", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f351470a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/AIO/menu/aio_msg_menu_config_inject.yml", version = 1)
    @NotNull
    private static final ArrayList<q> mMenuConfigList;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f351472c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46657);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f351472c = arrayList;
        arrayList.add(com.tencent.mobileqq.aio.menu.a.class);
        f351472c.add(com.tencent.mobileqq.aio.gamemsg.c.class);
        f351472c.add(RobotMsgMenuItemConfig.class);
        r rVar = new r();
        f351470a = rVar;
        ArrayList<q> arrayList2 = new ArrayList<>();
        mMenuConfigList = arrayList2;
        rVar.a();
        QLog.i("MenuItemConfigInject", 2, "[init] count: " + arrayList2.size());
    }

    r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @QAutoInitMethod
    private final void a() {
        com.tencent.mobileqq.qroute.utils.b.c(f351472c, mMenuConfigList);
    }

    @Nullable
    public final q b(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (q) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        for (q qVar : mMenuConfigList) {
            if (qVar.l(msgItem)) {
                return qVar;
            }
        }
        return null;
    }
}
