package com.tencent.mobileqq.vas.hippy.api.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.sqshow.zootopia.database.base.BaseZplanEntity;
import kotlin.Metadata;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "cacheKey")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/api/data/ZPlanParadiseHippyCacheEntity;", "Lcom/tencent/sqshow/zootopia/database/base/BaseZplanEntity;", "()V", "cacheData", "", "cacheKey", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanParadiseHippyCacheEntity extends BaseZplanEntity {
    public String cacheKey = "";
    public String cacheData = "";
}
