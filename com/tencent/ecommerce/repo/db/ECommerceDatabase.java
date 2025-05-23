package com.tencent.ecommerce.repo.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/repo/db/ECommerceDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "b", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECommerceDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ECommerceDatabase f105066a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/repo/db/ECommerceDatabase$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/repo/db/ECommerceDatabase;", "a", "", "DB_NAME", "Ljava/lang/String;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/ecommerce/repo/db/ECommerceDatabase;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.db.ECommerceDatabase$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        public final ECommerceDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            ECommerceDatabase eCommerceDatabase = ECommerceDatabase.f105066a;
            if (eCommerceDatabase == null) {
                synchronized (this) {
                    eCommerceDatabase = ECommerceDatabase.f105066a;
                    if (eCommerceDatabase == null) {
                        RoomDatabase build = Room.databaseBuilder(applicationContext, ECommerceDatabase.class, "ecommerce.db").fallbackToDestructiveMigration().enableMultiInstanceInvalidation().build();
                        ECommerceDatabase.f105066a = (ECommerceDatabase) build;
                        eCommerceDatabase = (ECommerceDatabase) build;
                    }
                }
            }
            return eCommerceDatabase;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
