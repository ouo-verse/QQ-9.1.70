package com.tencent.sqshow.zootopia.brand.list.data.db;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.database.base.BaseZplanEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.p;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "generateId")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/brand/list/data/db/ZplanBrandStoreEntity;", "Lcom/tencent/sqshow/zootopia/database/base/BaseZplanEntity;", "", "generateId", "Ljava/lang/String;", "", "getBrandMallRspBytes", "[B", "<init>", "()V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanBrandStoreEntity extends BaseZplanEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public String generateId = "";
    public byte[] getBrandMallRspBytes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/brand/list/data/db/ZplanBrandStoreEntity$a;", "", "Luv4/p;", "brandMallInfoRsp", "Lcom/tencent/sqshow/zootopia/brand/list/data/db/ZplanBrandStoreEntity;", "a", "entity", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.brand.list.data.db.ZplanBrandStoreEntity$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZplanBrandStoreEntity a(p brandMallInfoRsp) {
            Intrinsics.checkNotNullParameter(brandMallInfoRsp, "brandMallInfoRsp");
            try {
                ZplanBrandStoreEntity zplanBrandStoreEntity = new ZplanBrandStoreEntity();
                zplanBrandStoreEntity.generateId = String.valueOf(System.currentTimeMillis());
                zplanBrandStoreEntity.getBrandMallRspBytes = MessageNano.toByteArray(brandMallInfoRsp);
                return zplanBrandStoreEntity;
            } catch (Exception e16) {
                QLog.e("ZplanBrandStoreEntity", 1, "convertDataToEntity error - " + brandMallInfoRsp, e16);
                return null;
            }
        }

        public final p b(ZplanBrandStoreEntity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            byte[] bArr = entity.getBrandMallRspBytes;
            if (bArr == null) {
                return null;
            }
            try {
                return p.c(bArr);
            } catch (Exception e16) {
                QLog.e("ZplanBrandStoreEntity", 1, "convertEntityToData error", e16);
                return null;
            }
        }

        Companion() {
        }
    }
}
