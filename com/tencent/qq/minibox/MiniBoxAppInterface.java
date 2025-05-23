package com.tencent.qq.minibox;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseMiniBoxAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.MiniBoxAppInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u001b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u0004\u0018\u00010\tR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qq/minibox/MiniBoxAppInterface;", "Lcom/tencent/common/app/business/BaseMiniBoxAppInterface;", "", h.F, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/qphone/base/util/BaseApplication;", "getApp", "", "getCurrentAccountUin", "", "highPriorityWhenBackground", "", "getAppid", "g", "d", "Ljava/lang/String;", "dexVersion", "Lmqq/app/MobileQQ;", "app", "processName", "<init>", "(Lmqq/app/MobileQQ;Ljava/lang/String;)V", "e", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxAppInterface extends BaseMiniBoxAppInterface {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile String dexVersion;

    public MiniBoxAppInterface(@Nullable MobileQQ mobileQQ, @Nullable String str) {
        super(mobileQQ, str);
    }

    private final void h() {
        ThreadManagerV2.excute(new Runnable() { // from class: as3.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxAppInterface.i(MiniBoxAppInterface.this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MiniBoxAppInterface this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context applicationContext = this$0.getApplicationContext();
        if (applicationContext != null) {
            synchronized (this$0) {
                this$0.dexVersion = MiniBoxSDK.getDexVersion(applicationContext);
                Unit unit = Unit.INSTANCE;
            }
            QLog.d("MiniBoxAppInterface", 4, "queryDexVersion dexVersion:" + this$0.dexVersion + ", processName:" + this$0.processName);
        }
    }

    @Nullable
    public final String g() {
        String str;
        synchronized (this) {
            str = this.dexVersion;
        }
        return str;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    @NotNull
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
    @Nullable
    public String getCurrentAccountUin() {
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        QLog.i("MiniBoxAppInterface", 1, "highPriorityWhenBackground true");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.i("MiniBoxAppInterface", 4, "onCreate processName=" + this.processName);
        h();
    }
}
