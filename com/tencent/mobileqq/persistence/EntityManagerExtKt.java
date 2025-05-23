package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u00a2\u0006\u0004\b\t\u0010\n\u001a2\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/persistence/EntityManager;", "", "sql", "Lcom/tencent/mobileqq/persistence/d;", "createApi", "", "selectionArgs", "", "Lcom/tencent/mobileqq/persistence/Entity;", "rawQueryWithEntityCreate", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/String;Lcom/tencent/mobileqq/persistence/d;[Ljava/lang/String;)Ljava/util/List;", ReportPlugin.KEY_TABLE_NAME, "Landroid/database/Cursor;", "cursor", "cursor2ListExt", "mqq_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class EntityManagerExtKt {
    private static final List<Entity> cursor2ListExt(EntityManager entityManager, d dVar, String str, Cursor cursor) {
        ArrayList arrayList = null;
        if (cursor == null) {
            return null;
        }
        try {
            if (!cursor.moveToFirst()) {
                return null;
            }
            int count = cursor.getCount();
            ArrayList arrayList2 = null;
            do {
                try {
                    Entity innerCreateEntity = entityManager.innerCreateEntity(dVar, str, cursor, null);
                    if (innerCreateEntity != null) {
                        if (arrayList2 == null) {
                            try {
                                arrayList2 = new ArrayList(count);
                            } catch (Throwable unused) {
                            }
                        }
                        arrayList2.add(innerCreateEntity);
                    }
                } catch (Exception e16) {
                    e = e16;
                    arrayList = arrayList2;
                    QLog.e("EntityManager", 1, MsfSdkUtils.getStackTraceString(e));
                    return arrayList;
                }
            } while (cursor.moveToNext());
            return arrayList2;
        } catch (Exception e17) {
            e = e17;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        if (r5 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0032, code lost:
    
        if (r5 != null) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<Entity> rawQueryWithEntityCreate(@NotNull EntityManager entityManager, @NotNull String sql, @NotNull d createApi, @Nullable String[] strArr) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(entityManager, "<this>");
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(createApi, "createApi");
        ?? r26 = 0;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        List<Entity> list = null;
        try {
            try {
                cursor = entityManager.dbHelper.getReadableDatabase().rawQuery(sql, strArr);
                if (cursor != null) {
                    try {
                        list = cursor2ListExt(entityManager, createApi, null, new a(cursor));
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e("EntityManager", 1, MsfSdkUtils.getStackTraceString(e));
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        QLog.e("EntityManager", 1, MsfSdkUtils.getStackTraceString(e));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return list;
                    }
                }
            } catch (Exception e18) {
                e = e18;
                cursor = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r26 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r26 = sql;
            if (r26 != 0) {
                r26.close();
            }
            throw th;
        }
    }

    public static /* synthetic */ List rawQueryWithEntityCreate$default(EntityManager entityManager, String str, d dVar, String[] strArr, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            strArr = null;
        }
        return rawQueryWithEntityCreate(entityManager, str, dVar, strArr);
    }
}
