package com.tencent.mobileqq.matchfriend.reborn.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerRuntimeService;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.QQStrangerRecentContactHelper;
import com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginPart;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.notification.modularize.QQStrangerNTPushCenter;
import com.tencent.xweb.internal.ConstValue;
import kotlin.Metadata;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/api/impl/QQStrangerRuntimeServiceImpl;", "Lcom/tencent/mobileqq/matchfriend/reborn/api/IQQStrangerRuntimeService;", "()V", "qqStrangerNTPushCenter", "Lcom/tencent/mobileqq/notification/modularize/QQStrangerNTPushCenter;", ConstValue.EXTEND_CONFIG_KEY_HAS_LOGIN, "", "hasRegister", "onCreate", "", "appRuntime", "Lmqq/app/AppRuntime;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerRuntimeServiceImpl implements IQQStrangerRuntimeService {
    private QQStrangerNTPushCenter qqStrangerNTPushCenter;

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerRuntimeService
    public boolean hasLogin() {
        return QQStrangerLoginPart.INSTANCE.a().get();
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerRuntimeService
    public boolean hasRegister() {
        return QQStrangerGuestHelper.f245363a.c();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (this.qqStrangerNTPushCenter == null && (appRuntime instanceof QQAppInterface)) {
            this.qqStrangerNTPushCenter = new QQStrangerNTPushCenter((QQAppInterface) appRuntime);
        }
        QQStrangerNTPushCenter qQStrangerNTPushCenter = this.qqStrangerNTPushCenter;
        if (qQStrangerNTPushCenter != null) {
            qQStrangerNTPushCenter.i();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QQStrangerRecentContactHelper.f244865a.e();
        QQStrangerNTPushCenter qQStrangerNTPushCenter = this.qqStrangerNTPushCenter;
        if (qQStrangerNTPushCenter != null) {
            qQStrangerNTPushCenter.g();
        }
        this.qqStrangerNTPushCenter = null;
    }
}
