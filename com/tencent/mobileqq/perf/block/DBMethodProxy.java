package com.tencent.mobileqq.perf.block;

import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007JC\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\f2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u000e\"\u0004\u0018\u00010\bH\u0007\u00a2\u0006\u0002\u0010\u000fJ.\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J0\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0007JG\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000eH\u0007\u00a2\u0006\u0002\u0010\u0014JO\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000eH\u0007\u00a2\u0006\u0002\u0010\u0017Jc\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000eH\u0007\u00a2\u0006\u0002\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/perf/block/DBMethodProxy;", "", "()V", SQLiteDatabase.OPERATE_TYPE_EXEC_SQL, "", "em", "Lcom/tencent/mobileqq/persistence/EntityManager;", "sql", "", "find", "Lcom/tencent/mobileqq/persistence/Entity;", "clazz", "Ljava/lang/Class;", "unique", "", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;", "_id", "", "selection", "selectionArgs", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;", SQLiteDatabase.OPERATE_TYPE_RAW_QUERY, "", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "table", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class DBMethodProxy {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final DBMethodProxy INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28768);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new DBMethodProxy();
        }
    }

    DBMethodProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean execSQL(@NotNull EntityManager em5, @Nullable String sql) {
        Intrinsics.checkNotNullParameter(em5, "em");
        MainBlockMethodMonitor.onMethodStart();
        boolean execSQL = em5.execSQL(sql);
        MainBlockMethodMonitor.onMethodEnd();
        return execSQL;
    }

    @JvmStatic
    @Nullable
    public static final Entity find(@NotNull EntityManager em5, @Nullable Class<? extends Entity> clazz, @Nullable String unique) {
        Intrinsics.checkNotNullParameter(em5, "em");
        MainBlockMethodMonitor.onMethodStart();
        Entity find = em5.find(clazz, unique);
        MainBlockMethodMonitor.onMethodEnd();
        return find;
    }

    @JvmStatic
    @Nullable
    public static final List<Entity> rawQuery(@NotNull EntityManager em5, @Nullable Class<? extends Entity> clazz, @Nullable String sql, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(em5, "em");
        MainBlockMethodMonitor.onMethodStart();
        List rawQuery = em5.rawQuery(clazz, sql, selectionArgs);
        MainBlockMethodMonitor.onMethodEnd();
        return rawQuery;
    }

    @JvmStatic
    @Nullable
    public static final Entity find(@NotNull EntityManager em5, @Nullable Class<? extends Entity> clazz, @NotNull String... unique) {
        Intrinsics.checkNotNullParameter(em5, "em");
        Intrinsics.checkNotNullParameter(unique, "unique");
        MainBlockMethodMonitor.onMethodStart();
        Entity find = em5.find(clazz, (String[]) Arrays.copyOf(unique, unique.length));
        MainBlockMethodMonitor.onMethodEnd();
        return find;
    }

    @JvmStatic
    @Nullable
    public static final List<Entity> rawQuery(@NotNull EntityManager em5, @Nullable Class<? extends Entity> clazz, @Nullable String sql, @Nullable String table, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(em5, "em");
        MainBlockMethodMonitor.onMethodStart();
        List rawQuery = em5.rawQuery(clazz, sql, table, selection, selectionArgs);
        MainBlockMethodMonitor.onMethodEnd();
        return rawQuery;
    }

    @JvmStatic
    @Nullable
    public static final Entity find(@NotNull EntityManager em5, @Nullable Class<? extends Entity> clazz, long _id) {
        Intrinsics.checkNotNullParameter(em5, "em");
        MainBlockMethodMonitor.onMethodStart();
        Entity find = em5.find(clazz, _id);
        MainBlockMethodMonitor.onMethodEnd();
        return find;
    }

    @JvmStatic
    @Nullable
    public static final Entity find(@NotNull EntityManager em5, @Nullable Class<? extends Entity> clazz, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(em5, "em");
        MainBlockMethodMonitor.onMethodStart();
        Entity find = em5.find(clazz, selection, selectionArgs);
        MainBlockMethodMonitor.onMethodEnd();
        return find;
    }
}
