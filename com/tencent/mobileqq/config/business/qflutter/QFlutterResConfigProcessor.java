package com.tencent.mobileqq.config.business.qflutter;

import com.tencent.common.config.AppSetting;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u001f\u0010\n\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfigProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", DownloadInfo.spKey_Config, "b", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "newConf", "", "c", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "a", "", "isNeedCompressed", "isNeedStoreLargeFile", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QFlutterResConfigProcessor extends l<QFlutterResConfig> {
    public QFlutterResConfigProcessor() {
        com.tencent.mobileqq.qqexpand.utils.l lVar = com.tencent.mobileqq.qqexpand.utils.l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("QFlutterResConfigProcessor", 2, "init... branchName = " + AppSetting.f99544d + ", version = " + AppSetting.f99551k);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QFlutterResConfig migrateOldOrDefaultContent(int type) {
        return new QFlutterResConfig();
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QFlutterResConfig onParsed(@NotNull ai[] config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return QFlutterResConfig.INSTANCE.b(config);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(@NotNull QFlutterResConfig newConf) {
        Intrinsics.checkNotNullParameter(newConf, "newConf");
        com.tencent.mobileqq.qqexpand.utils.l lVar = com.tencent.mobileqq.qqexpand.utils.l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("QFlutterResConfigProcessor", 2, "Config updated to ... " + newConf);
        }
        QFlutterResConfig.f202786d = newConf;
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    public Class<QFlutterResConfig> clazz() {
        return QFlutterResConfig.class;
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
        com.tencent.mobileqq.qqexpand.utils.l lVar = com.tencent.mobileqq.qqexpand.utils.l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("QFlutterResConfigProcessor", 2, "Config update but failed: errCode = " + failCode);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 706;
    }
}
