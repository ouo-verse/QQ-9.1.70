package com.tencent.mobileqq.config.business.vas.zplan;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wa1.a;
import xa1.d;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J#\u0010\n\u001a\u0004\u0018\u00010\u00022\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/config/business/vas/zplan/VasZplanConfigProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lxa1/d;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "b", "([Lcom/tencent/mobileqq/config/ai;)Lxa1/d;", "newConf", "", "c", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "a", "", "isAccountRelated", "isNeedCompressed", "isNeedStoreLargeFile", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class VasZplanConfigProcessor extends l<d> {
    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d migrateOldOrDefaultContent(int type) {
        return new d();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d onParsed(@Nullable ai[] confFiles) {
        if (QLog.isColorLevel()) {
            QLog.d("VasZplanConfigProcessor", 2, "onParsed");
        }
        return a.f445122a.a(confFiles);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(@Nullable d newConf) {
        if (QLog.isColorLevel()) {
            QLog.d("VasZplanConfigProcessor", 2, "onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    public Class<d> clazz() {
        return d.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return true;
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
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int failCode) {
        if (QLog.isColorLevel()) {
            QLog.d("VasZplanConfigProcessor", 2, "onReqFailed failCode: " + failCode);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 854;
    }
}
