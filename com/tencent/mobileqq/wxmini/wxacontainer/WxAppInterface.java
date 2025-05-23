package com.tencent.mobileqq.wxmini.wxacontainer;

import android.os.Bundle;
import com.tencent.common.app.business.BaseMiniAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u001b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wxmini/wxacontainer/WxAppInterface;", "Lcom/tencent/common/app/business/BaseMiniAppInterface;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lcom/tencent/qphone/base/util/BaseApplication;", "getApp", "", "getCurrentAccountUin", "", "getAppid", "Lmqq/app/MobileQQ;", "app", "processName", "<init>", "(Lmqq/app/MobileQQ;Ljava/lang/String;)V", "d", "a", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WxAppInterface extends BaseMiniAppInterface {
    public WxAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        MobileQQ app = this.app;
        Intrinsics.checkNotNullExpressionValue(app, "app");
        return app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        String account = getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "account");
        return account;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.i("[wxa-q]WxAppInterface", 4, "onCreate processName=" + this.processName);
    }
}
