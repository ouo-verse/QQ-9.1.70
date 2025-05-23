package com.tencent.mobileqq.qqshop.message.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Database(entities = {a.class}, exportSchema = false, version = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/db/QQShopMsgDatabase;", "Landroidx/room/RoomDatabase;", "Lcom/tencent/mobileqq/qqshop/message/db/b;", "c", "<init>", "()V", "a", "b", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class QQShopMsgDatabase extends RoomDatabase {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/db/QQShopMsgDatabase$a;", "", "Lcom/tencent/mobileqq/qqshop/message/db/QQShopMsgDatabase;", "a", "", "QQ_SHOP_MSG_DATABASE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.message.db.QQShopMsgDatabase$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final QQShopMsgDatabase a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQShopMsgDatabase) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return b.f274481a.a();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/db/QQShopMsgDatabase$b;", "", "Lcom/tencent/mobileqq/qqshop/message/db/QQShopMsgDatabase;", "b", "Lcom/tencent/mobileqq/qqshop/message/db/QQShopMsgDatabase;", "a", "()Lcom/tencent/mobileqq/qqshop/message/db/QQShopMsgDatabase;", "INSTANCE", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f274481a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final QQShopMsgDatabase INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30081);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            f274481a = new b();
            RoomDatabase build = Room.databaseBuilder(MobileQQ.sMobileQQ, QQShopMsgDatabase.class, "qq_shop").fallbackToDestructiveMigration().build();
            Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(\n       \u2026uctiveMigration().build()");
            INSTANCE = (QQShopMsgDatabase) build;
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final QQShopMsgDatabase a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQShopMsgDatabase) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return INSTANCE;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQShopMsgDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public abstract com.tencent.mobileqq.qqshop.message.db.b c();
}
