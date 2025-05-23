package com.tencent.mobileqq.zplan.maintenance;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J!\u0010\n\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/maintenance/ZPlanMaintInfoProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lcom/tencent/mobileqq/zplan/maintenance/b;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "b", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/zplan/maintenance/b;", "newConf", "", "c", ImageTaskConst.FAIL_CODE, "onReqFailed", "onReqNoReceive", "", "isNeedUpgradeReset", "migrateOldVersion", "a", "isNeedCompressed", "isNeedStoreLargeFile", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMaintInfoProcessor extends l<ZPlanManageMaintConfig> {
    @Override // com.tencent.mobileqq.config.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ZPlanManageMaintConfig migrateOldOrDefaultContent(int type) {
        return new ZPlanManageMaintConfig();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ZPlanManageMaintConfig> clazz() {
        return ZPlanManageMaintConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedUpgradeReset() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int failCode) {
        QLog.d("ZPlanMaintInfoProcessor", 1, "zplan maintenance info req failed with code " + failCode);
        ZPlanMaintInfoRepo.f333853a.f();
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 807;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        QLog.d("ZPlanMaintInfoProcessor", 1, "zplan maintenance info is not updated.");
        ZPlanMaintInfoRepo.f333853a.f();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(ZPlanManageMaintConfig newConf) {
        Map<String, ZPlanMaintInfo> a16;
        com.tencent.zplan.luabridge.a S;
        QLog.d("ZPlanMaintInfoProcessor", 1, "zplan maintenance info updated successfully, newConf: " + (newConf != null ? newConf.toString() : null));
        ZPlanMaintInfoRepo.f333853a.f();
        if (newConf == null || (a16 = newConf.a()) == null || (S = ZPlanServiceHelper.I.S()) == null) {
            return;
        }
        String json = DataConvertUtil.f329546a.a().toJson(a16);
        Intrinsics.checkNotNullExpressionValue(json, "DataConvertUtil.gson.toJson(it)");
        a.C10063a.b(S, "N2L_NotifyStopServerInfo", json, null, 4, null);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ZPlanManageMaintConfig onParsed(ai[] confFiles) {
        QLog.d("ZPlanMaintInfoProcessor", 1, "onParsed call with confFiles size: " + (confFiles != null ? confFiles.length : 0));
        try {
            ZPlanManageMaintConfig zPlanManageMaintConfig = new ZPlanManageMaintConfig();
            if (confFiles == null) {
                return zPlanManageMaintConfig;
            }
            for (ai aiVar : confFiles) {
                ZPlanManageMaintConfig curConfig = (ZPlanManageMaintConfig) DataConvertUtil.f329546a.a().fromJson(aiVar.f202268b, ZPlanManageMaintConfig.class);
                if (!curConfig.a().isEmpty()) {
                    QLog.d("ZPlanMaintInfoProcessor", 1, "parse config from taskid " + aiVar.f202267a + " and content: " + aiVar.f202268b);
                    Intrinsics.checkNotNullExpressionValue(curConfig, "curConfig");
                    zPlanManageMaintConfig = curConfig;
                }
            }
            return zPlanManageMaintConfig;
        } catch (Exception e16) {
            QLog.e("ZPlanMaintInfoProcessor", 1, "unexpected exception occurred with: " + e16);
            return new ZPlanManageMaintConfig();
        }
    }
}
