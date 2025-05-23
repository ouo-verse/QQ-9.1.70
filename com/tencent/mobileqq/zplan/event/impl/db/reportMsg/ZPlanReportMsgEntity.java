package com.tencent.mobileqq.zplan.event.impl.db.reportMsg;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.sqshow.zootopia.database.base.BaseZplanEntity;
import kotlin.Metadata;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "msgId")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/event/impl/db/reportMsg/ZPlanReportMsgEntity;", "Lcom/tencent/sqshow/zootopia/database/base/BaseZplanEntity;", "()V", "msgBody", "", "msgId", "", QQBrowserActivity.KEY_MSG_TYPE, "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanReportMsgEntity extends BaseZplanEntity {
    public byte[] msgBody;
    public long msgId;
    public int msgType;
}
