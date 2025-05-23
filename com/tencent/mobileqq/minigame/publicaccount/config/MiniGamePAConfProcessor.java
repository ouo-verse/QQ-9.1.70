package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J#\u0010\n\u001a\u0004\u0018\u00010\u00022\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "onParsed", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "newConf", "", "onUpdate", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "migrateOldOrDefaultContent", "", "isNeedCompressed", "isNeedStoreLargeFile", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
@Deprecated
/* loaded from: classes33.dex */
public final class MiniGamePAConfProcessor extends l<MiniGamePAConfBean> {
    private static final int CONFIG_ID = 741;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MiniGamePAConfProcessor";

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "loadConfig", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MiniGamePAConfBean loadConfig() {
            MiniGamePAConfBean miniGamePAConfBean = (MiniGamePAConfBean) am.s().x(MiniGamePAConfProcessor.CONFIG_ID);
            return miniGamePAConfBean == null ? new MiniGamePAConfBean() : miniGamePAConfBean;
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final MiniGamePAConfBean loadConfig() {
        return INSTANCE.loadConfig();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<MiniGamePAConfBean> clazz() {
        return MiniGamePAConfBean.class;
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
        if (!QLog.isColorLevel()) {
            return 0;
        }
        QLog.d(TAG, 2, "migrateOldVersion");
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int failCode) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReqFailed " + failCode);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return CONFIG_ID;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.config.l
    public MiniGamePAConfBean migrateOldOrDefaultContent(int type) {
        return new MiniGamePAConfBean();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
    @Override // com.tencent.mobileqq.config.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MiniGamePAConfBean onParsed(ai[] confFiles) {
        boolean z16;
        if (confFiles != null) {
            if (!(confFiles.length == 0)) {
                z16 = false;
                if (!z16) {
                    QLog.i(TAG, 1, "onParsed fail, confFiles is null");
                    return null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "miniGame config onParsed = " + confFiles[0].f202268b);
                }
                MiniGamePAConfBean convertFromJSONObject = MiniGamePAConfBean.INSTANCE.convertFromJSONObject(confFiles[0].f202268b);
                if (convertFromJSONObject == null) {
                    QLog.e(TAG, 1, "miniGame config onParsed config is null!");
                }
                return convertFromJSONObject;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public void onUpdate(MiniGamePAConfBean newConf) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onUpdate " + newConf);
        }
    }
}
