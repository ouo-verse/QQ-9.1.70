package com.tencent.mobileqq.mini.qbox;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0016J!\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0006\u0010\u0016\u001a\u00020\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/mini/qbox/QBoxConfProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lcom/tencent/mobileqq/mini/qbox/QBoxConfBean;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "onParsed", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/mini/qbox/QBoxConfBean;", "newConf", "", "onUpdate", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "migrateOldOrDefaultContent", "", "isNeedCompressed", "isNeedStoreLargeFile", "loadConfig", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QBoxConfProcessor extends l<QBoxConfBean> {
    private static final String TAG = "QBoxConfProcessor";
    public static final int TASK_TYPE_ID = 875;

    @Override // com.tencent.mobileqq.config.l
    public Class<QBoxConfBean> clazz() {
        return QBoxConfBean.class;
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
        return TASK_TYPE_ID;
    }

    public final void loadConfig() {
        am.s().M(new int[]{TASK_TYPE_ID});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.config.l
    public QBoxConfBean migrateOldOrDefaultContent(int type) {
        return new QBoxConfBean();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.config.l
    public QBoxConfBean onParsed(ai[] confFiles) {
        QLog.d(TAG, 2, "onParsed");
        if (confFiles != null) {
            if (!(confFiles.length == 0)) {
                return new QBoxConfBean().parse(confFiles);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int failCode) {
        QLog.d(TAG, 1, "onReqFailed");
    }

    @Override // com.tencent.mobileqq.config.l
    public void onUpdate(QBoxConfBean newConf) {
        QLog.d(TAG, 2, "onUpdate");
    }
}
