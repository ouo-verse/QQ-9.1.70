package com.tencent.mobileqq.reminder.db.real.engine;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerExtKt;
import com.tencent.mobileqq.persistence.d;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.db.b;
import com.tencent.mobileqq.reminder.db.entity.ReminderRecord;
import com.tencent.mobileqq.reminder.db.entity.ReminderRecordKtKt;
import com.tencent.mobileqq.reminder.db.entity.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0013\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R#\u0010\u001f\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b \u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/real/engine/DbDataEngine;", "Lcom/tencent/mobileqq/reminder/db/real/engine/a;", "", "activateFriendsUin", "", "uinTypeActivateFriends", "", "Lcom/tencent/mobileqq/reminder/db/b;", "getMsgList", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "", "uniseq", "", "removeMsgByUniseq", "(Ljava/lang/String;Ljava/lang/Integer;J)V", "list", "account", "", "isBackgroundStop", "addMessage", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "getLastMessage", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/mobileqq/reminder/db/entity/b;", "setReaded", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Lcom/tencent/mobileqq/persistence/EntityManager;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/persistence/EntityManager;", "mEntityManager", "f", "Ljava/lang/String;", "operationTableName", h.F, "()Ljava/lang/String;", "querySql", "<init>", "()V", "i", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class DbDataEngine extends com.tencent.mobileqq.reminder.db.real.engine.a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f281046i;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mEntityManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String operationTableName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy querySql;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/real/engine/DbDataEngine$a;", "", "", "TABLE_COL_ISREAD", "Ljava/lang/String;", "TABLE_COL_MSGTYPE", "TABLE_COL_UNISEQ", "TAG", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/reminder/db/real/engine/DbDataEngine$b", "Lcom/tencent/mobileqq/persistence/d;", "Landroid/database/Cursor;", "cursor", "Lcom/tencent/mobileqq/persistence/Entity;", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.persistence.d
        @Nullable
        public Entity a(@NotNull Cursor cursor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Entity) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
            }
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            int columnIndex = cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_TYPE);
            if (columnIndex <= 0) {
                return null;
            }
            return c.b(c.f281040a, cursor.getInt(columnIndex), null, 2, null);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28742);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f281046i = new a(null);
        }
    }

    public DbDataEngine() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(DbDataEngine$mEntityManager$2.INSTANCE);
            this.mEntityManager = lazy;
            this.operationTableName = ReminderRecordKtKt.a();
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.reminder.db.real.engine.DbDataEngine$querySql$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DbDataEngine.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    String str;
                    String str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    str = DbDataEngine.this.operationTableName;
                    str2 = DbDataEngine.this.operationTableName;
                    String str3 = "select * from  " + str + "  where _id in (select _id from " + str2 + " order by time desc)  order by time desc, _id desc";
                    com.tencent.mobileqq.reminder.db.a.b("DbDataEngine", "qureySql->  " + str3, null, 4, null);
                    return str3;
                }
            });
            this.querySql = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EntityManager e() {
        return (EntityManager) this.mEntityManager.getValue();
    }

    private final String f() {
        return (String) this.querySql.getValue();
    }

    @Override // cm2.a
    public void addMessage(@NotNull final List<? extends com.tencent.mobileqq.reminder.db.b> list, @Nullable String account, @Nullable Boolean isBackgroundStop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, account, isBackgroundStop);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            com.tencent.mobileqq.reminder.db.a.i("DbDataEngine", "addMessage is Empty return", null, 4, null);
        } else {
            ThreadManagerV2.excute(new Runnable(list) { // from class: com.tencent.mobileqq.reminder.db.real.engine.DbDataEngine$addMessage$$inlined$wrapDbThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f281050d;

                {
                    this.f281050d = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DbDataEngine.this, (Object) list);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    EntityManager e16;
                    int collectionSizeOrDefault;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        e16 = DbDataEngine.this.e();
                        if (e16 != null) {
                            List<b> list2 = this.f281050d;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            for (b bVar : list2) {
                                Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mobileqq.reminder.db.entity.ReminderRecord");
                                arrayList.add(new PersistTransaction((ReminderRecord) bVar));
                            }
                            boolean booleanValue = Boolean.valueOf(e16.doMultiDBOperateByTransaction(arrayList)).booleanValue();
                            com.tencent.mobileqq.reminder.db.a.i("DbDataEngine", "addMessage -> size " + this.f281050d.size() + " result -> " + booleanValue, null, 4, null);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 32, null, false);
        }
    }

    @Override // cm2.a
    @Nullable
    public com.tencent.mobileqq.reminder.db.entity.b getLastMessage(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.reminder.db.entity.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        }
        List<com.tencent.mobileqq.reminder.db.b> msgList = getMsgList(activateFriendsUin, uinTypeActivateFriends);
        if (!msgList.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgList);
            return com.tencent.mobileqq.reminder.db.a.g((com.tencent.mobileqq.reminder.db.b) first);
        }
        return null;
    }

    @Override // cm2.a
    @NotNull
    public List<com.tencent.mobileqq.reminder.db.b> getMsgList(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        List<com.tencent.mobileqq.reminder.db.b> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        }
        EntityManager mEntityManager = e();
        Intrinsics.checkNotNullExpressionValue(mEntityManager, "mEntityManager");
        List rawQueryWithEntityCreate$default = EntityManagerExtKt.rawQueryWithEntityCreate$default(mEntityManager, f(), new b(), null, 4, null);
        if (rawQueryWithEntityCreate$default != null) {
            list = CollectionsKt___CollectionsKt.filterNotNull(rawQueryWithEntityCreate$default);
        } else {
            list = null;
        }
        if (!(list instanceof List)) {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        com.tencent.mobileqq.reminder.db.a.b("DbDataEngine", "getMsgList " + list.size(), null, 4, null);
        return list;
    }

    @Override // cm2.a
    public void removeMsgByUniseq(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends, final long uniseq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activateFriendsUin, uinTypeActivateFriends, Long.valueOf(uniseq));
        } else {
            ThreadManagerV2.excute(new Runnable(uniseq) { // from class: com.tencent.mobileqq.reminder.db.real.engine.DbDataEngine$removeMsgByUniseq$$inlined$wrapDbThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f281052d;

                {
                    this.f281052d = uniseq;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DbDataEngine.this, Long.valueOf(uniseq));
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    EntityManager e16;
                    Integer num;
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        e16 = DbDataEngine.this.e();
                        if (e16 != null) {
                            str = DbDataEngine.this.operationTableName;
                            num = Integer.valueOf(e16.delete(str, "uniseq=?", new String[]{String.valueOf(this.f281052d)}));
                        } else {
                            num = null;
                        }
                        com.tencent.mobileqq.reminder.db.a.i("DbDataEngine", "removeMsgByUniseq uniseq -> " + this.f281052d + " result -> " + num, null, 4, null);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 32, null, false);
        }
    }

    @Override // cm2.a
    public void setReaded(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activateFriendsUin, (Object) uinTypeActivateFriends);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.reminder.db.real.engine.DbDataEngine$setReaded$$inlined$wrapDbThread$1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DbDataEngine.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    EntityManager e16;
                    Boolean bool;
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        e16 = DbDataEngine.this.e();
                        if (e16 != null) {
                            str = DbDataEngine.this.operationTableName;
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(AppConstants.Key.COLUMN_IS_READ, Boolean.TRUE);
                            Unit unit = Unit.INSTANCE;
                            bool = Boolean.valueOf(e16.update(str, contentValues, null, null));
                        } else {
                            bool = null;
                        }
                        com.tencent.mobileqq.reminder.db.a.i("DbDataEngine", "setReaded result-> " + bool, null, 4, null);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 32, null, false);
        }
    }
}
