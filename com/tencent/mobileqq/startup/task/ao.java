package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.basic.a;
import com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy;
import com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy;
import com.tencent.mobileqq.imcore.proxy.msg.MsgProxyUtilsProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.OGAbstractDao;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/startup/task/ao;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "f", "e", "d", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "Lcom/tencent/mobileqq/imcore/proxy/db/OGEntityDaoManagerProxy$Proxy;", "Lcom/tencent/mobileqq/imcore/proxy/db/OGEntityDaoManagerProxy$Proxy;", "ogEntityDaoManagerProxy", "Lcom/tencent/mobileqq/imcore/proxy/msg/MsgProxyUtilsProxy$Proxy;", "Lcom/tencent/mobileqq/imcore/proxy/msg/MsgProxyUtilsProxy$Proxy;", "msgProxyUtilsProxy", "Lcom/tencent/mobileqq/imcore/proxy/basic/a$a;", "Lcom/tencent/mobileqq/imcore/proxy/basic/a$a;", "exceptionTrackerProxy", "Lcom/tencent/mobileqq/imcore/proxy/db/TableBuilderProxy$Proxy;", tl.h.F, "Lcom/tencent/mobileqq/imcore/proxy/db/TableBuilderProxy$Proxy;", "tableBuildProxy", "<init>", "()V", "i", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ao extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f289802m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OGEntityDaoManagerProxy.Proxy ogEntityDaoManagerProxy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgProxyUtilsProxy.Proxy msgProxyUtilsProxy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.InterfaceC7933a exceptionTrackerProxy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TableBuilderProxy.Proxy tableBuildProxy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/startup/task/ao$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.ao$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001d\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/startup/task/ao$b", "Lcom/tencent/mobileqq/imcore/proxy/db/TableBuilderProxy$Proxy;", "Lcom/tencent/mobileqq/persistence/Entity;", "entity", "", "createIndexSQLStatement", "", "Ljava/lang/Class;", "getNeedPrivateFieldsClass", "()[Ljava/lang/Class;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements TableBuilderProxy.Proxy {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy.Proxy
        @Nullable
        public String createIndexSQLStatement(@NotNull Entity entity) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entity);
            }
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (entity instanceof MessageRecord) {
                MessageRecord messageRecord = (MessageRecord) entity;
                String tableName = messageRecord.getTableName();
                StringBuilder sb5 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
                sb5.append(tableName);
                sb5.append("_idx");
                sb5.append(" ON ");
                sb5.append(tableName);
                int i3 = messageRecord.istroop;
                if (i3 != 1 && i3 != 3000 && i3 != 10014) {
                    str = "time";
                } else {
                    str = AppConstants.Key.COLUMN_SHMSG_SEQ;
                }
                sb5.append("(");
                sb5.append(str);
                sb5.append(", _id)");
                return sb5.toString();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy.Proxy
        @Nullable
        public Class<?>[] getNeedPrivateFieldsClass() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Class[]) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new Class[]{RecentUser.class};
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61471);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ao() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.ogEntityDaoManagerProxy = new OGEntityDaoManagerProxy.Proxy() { // from class: com.tencent.mobileqq.startup.task.ak
            @Override // com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy.Proxy
            public final OGAbstractDao getEntityDao(Class cls) {
                OGAbstractDao h16;
                h16 = ao.h(cls);
                return h16;
            }
        };
        this.msgProxyUtilsProxy = new MsgProxyUtilsProxy.Proxy() { // from class: com.tencent.mobileqq.startup.task.al
            @Override // com.tencent.mobileqq.imcore.proxy.msg.MsgProxyUtilsProxy.Proxy
            public final boolean isSaveConversation(String str, String str2, int i3, int i16) {
                boolean g16;
                g16 = ao.g(str, str2, i3, i16);
                return g16;
            }
        };
        this.exceptionTrackerProxy = new a.InterfaceC7933a() { // from class: com.tencent.mobileqq.startup.task.am
        };
        this.tableBuildProxy = new b();
    }

    private final void d() {
        com.tencent.mobileqq.imcore.proxy.b.f238019a = 10;
        com.tencent.mobileqq.imcore.proxy.a.f238018a = 99;
    }

    private final void e() {
        com.tencent.mobileqq.imcore.proxy.d.f238032a = R.drawable.bwe;
        com.tencent.mobileqq.imcore.proxy.d.f238033b = R.drawable.bwf;
        com.tencent.mobileqq.imcore.proxy.c.f238030a = R.color.ag5;
        com.tencent.mobileqq.imcore.proxy.c.f238031b = R.color.skin_gray2_theme_version2;
        com.tencent.mobileqq.imcore.proxy.e.f238034a = R.string.i5o;
        com.tencent.mobileqq.imcore.proxy.e.f238035b = R.string.i5c;
        com.tencent.mobileqq.imcore.proxy.e.f238036c = R.string.i59;
    }

    private final void f() {
        if (QLog.isColorLevel()) {
            QLog.d("LoadModuleTask", 2, "initModuleProxyImport Start, process=", MobileQQ.processName);
        }
        OGEntityDaoManagerProxy.registerProxy(this.ogEntityDaoManagerProxy);
        TableBuilderProxy.registerProxy(this.tableBuildProxy);
        MsgProxyUtilsProxy.registerProxy(this.msgProxyUtilsProxy);
        com.tencent.mobileqq.imcore.proxy.basic.a.a(this.exceptionTrackerProxy);
        if (QLog.isColorLevel()) {
            QLog.d("LoadModuleTask", 2, "initModuleProxyNotImport finish, process=", MobileQQ.processName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(String str, String str2, int i3, int i16) {
        return com.tencent.imcore.message.ao.E(str, str2, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OGAbstractDao h(Class cls) {
        return com.tencent.mobileqq.persistence.j.b().a(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        com.tencent.mobileqq.imcore.a.a();
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (QLog.isColorLevel()) {
            if (f289802m) {
                QLog.d("LoadModuleTask", 2, "IMCoreModule Init Start, process=", MobileQQ.processName, " repeat! InitInfo=", new RuntimeException(""));
            } else {
                QLog.d("LoadModuleTask", 2, "IMCoreModule Init Start, process=", MobileQQ.processName, " InitInfo=", Boolean.valueOf(f289802m));
            }
        }
        if (f289802m) {
            return;
        }
        f289802m = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        f();
        e();
        d();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.startup.task.an
            @Override // java.lang.Runnable
            public final void run() {
                ao.i();
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d("LoadModuleTask", 2, "IMCoreModule Init Finish, cost=", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
        }
    }
}
