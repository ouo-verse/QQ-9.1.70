package com.tencent.av.ManageConfig;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.av.ui.f;
import com.tencent.av.utils.af;
import com.tencent.av.utils.ah;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.cp;
import com.tencent.qphone.base.util.QLog;
import vv.d;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes3.dex */
public class QAVConfig extends QAVConfigBase<xt.a> {
    public QAVConfig(int i3) {
        super(i3);
    }

    public static int d(int i3) {
        return am.s().g(i3, ((AppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin());
    }

    public static xt.a e(int i3) {
        return (xt.a) am.s().x(i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<xt.a> clazz() {
        return xt.a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public xt.a migrateOldOrDefaultContent(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f72815a, 1, "migrateOldOrDefaultContent, type[" + i3 + "]");
        }
        return new xt.a();
    }

    @Override // com.tencent.av.ManageConfig.QAVConfigBase, com.tencent.mobileqq.config.l
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onUpdate(xt.a aVar) {
        super.onUpdate(aVar);
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (!(appInterface instanceof QQAppInterface) || aVar == null) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        int type = type();
        if (type != 132) {
            if (type != 192) {
                if (type != 276) {
                    if (type != 287) {
                        if (type != 367 && type != 382) {
                            if (type != 735) {
                                if (type != 759) {
                                    if (type == 841) {
                                        f.f(aVar.f448490b);
                                        return;
                                    }
                                    return;
                                }
                                d.c(qQAppInterface.getApp(), aVar.f448490b);
                                return;
                            }
                            ah.b(aVar.f448490b, appInterface.getCurrentAccountUin());
                            return;
                        }
                        BusinessCommonConfig.getInstance(qQAppInterface).decodeConfig(qQAppInterface, type(), aVar.f448490b);
                        return;
                    }
                    af.L(aVar.f448490b);
                    return;
                }
                cp.q(aVar.f448490b);
                return;
            }
            com.tencent.av.ui.a.a().b(aVar.f448490b);
            return;
        }
        com.tencent.av.business.manager.a.k(this.f72815a, qQAppInterface.getApp(), 1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ManageConfig.QAVConfigBase
    @Nullable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public xt.a parsed(ai[] aiVarArr) {
        xt.a aVar = new xt.a();
        ai b16 = QAVConfigBase.b(this.f72815a, type(), aiVarArr);
        if (b16 != null) {
            aVar.a(b16.f202267a, b16.f202268b);
        }
        return aVar;
    }

    @Override // com.tencent.av.ManageConfig.QAVConfigBase, com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        int type = type();
        if (type != 192 && type != 249 && type != 263 && type != 382 && type != 591 && type != 623 && type != 735) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onProcessorConstructed(int i3) {
        this.f72816b = i3;
        this.f72815a = "QAVConfig_" + this.f72816b;
    }

    @Override // com.tencent.av.ManageConfig.QAVConfigBase, com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        super.onReqFailed(i3);
    }

    @Override // com.tencent.av.ManageConfig.QAVConfigBase, com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        super.onReqNoReceive();
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        int type = type();
        if (type == 367 || type == 382) {
            BusinessCommonConfig.getInstance(qQAppInterface).handleResp_Config_NoResp(qQAppInterface, type());
        }
    }

    public QAVConfig() {
    }
}
