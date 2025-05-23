package com.tencent.mobileqq.config.business;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u001f\u0010\n\u001a\u0004\u0018\u00010\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/config/business/BrowserOpenConfProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lcom/tencent/mobileqq/config/business/d;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "b", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/config/business/d;", "newConf", "", "c", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "a", "", "isNeedCompressed", "isNeedStoreLargeFile", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class BrowserOpenConfProcessor extends com.tencent.mobileqq.config.l<BrowserOpenBean> {
    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BrowserOpenBean migrateOldOrDefaultContent(int type) {
        return new BrowserOpenBean();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BrowserOpenBean onParsed(@NotNull com.tencent.mobileqq.config.ai[] confFiles) {
        com.tencent.mobileqq.config.ai aiVar;
        BrowserOpenBean c16;
        Intrinsics.checkNotNullParameter(confFiles, "confFiles");
        if (confFiles.length > 0 && (aiVar = confFiles[0]) != null) {
            c16 = e.c(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("[BrowserOpt] H5BrowserOpenConfProcessor", 2, "onParsed " + confFiles[0].f202268b);
            }
            return c16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[BrowserOpt] H5BrowserOpenConfProcessor", 2, "onParsed is null");
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(@NotNull BrowserOpenBean newConf) {
        Intrinsics.checkNotNullParameter(newConf, "newConf");
        if (QLog.isColorLevel()) {
            QLog.d("[BrowserOpt] H5BrowserOpenConfProcessor", 2, "onUpdate " + newConf);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    public Class<BrowserOpenBean> clazz() {
        return BrowserOpenBean.class;
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
    public int type() {
        return 627;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int failCode) {
    }
}
