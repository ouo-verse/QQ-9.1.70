package com.tencent.mobileqq.config.business.zootopia;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yb3.c;
import yb3.d;

@Deprecated(message = "\u5df2\u8fc1\u79fb\u5230qqmc")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/config/business/zootopia/ZootopiaConfigProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lyb3/c;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "b", "([Lcom/tencent/mobileqq/config/ai;)Lyb3/c;", "newConf", "", "c", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "a", "", "isAccountRelated", "isNeedCompressed", "isNeedStoreLargeFile", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ZootopiaConfigProcessor extends l<c> {
    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c migrateOldOrDefaultContent(int type) {
        return new c();
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c onParsed(@NotNull ai[] confFiles) {
        Intrinsics.checkNotNullParameter(confFiles, "confFiles");
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaConfigProcessor", 2, "onParsed");
        }
        return d.f450028a.b(confFiles);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(@NotNull c newConf) {
        Intrinsics.checkNotNullParameter(newConf, "newConf");
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaConfigProcessor", 2, "onUpdate " + newConf);
        }
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).notifyAllConfigListener();
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    public Class<c> clazz() {
        return c.class;
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
            QLog.d("ZootopiaConfigProcessor", 2, "onReqFailed failCode: " + failCode);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 809;
    }
}
