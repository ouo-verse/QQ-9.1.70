package com.tencent.qqnt.aio.helper;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AvatarEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0014R\u0016\u0010\u0016\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/helper/x;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mobileqq/avatar/observer/a;", "", "getId", "", "getTag", "", "interestedIn", "state", "", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isSuccess", "uin", "onUpdateCustomHead", "d", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "<init>", "()V", "e", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class x extends com.tencent.mobileqq.avatar.observer.a implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350692z0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "AvatarObserverHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mHelperParam = param;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((QQAppInterface) peekAppRuntime).addObserver(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((QQAppInterface) peekAppRuntime).removeObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.avatar.observer.a
    public void onUpdateCustomHead(boolean isSuccess, String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (QLog.isDevelopLevel()) {
            QLog.i("AvatarObserverHelper", 4, "[onUpdateCustomHead]: success is " + isSuccess + ", uin is " + uin);
        }
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().h(new AvatarEvent.AvatarChange(uin));
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
