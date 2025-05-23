package com.tencent.mobileqq.setting.main.processor;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.cx;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;
import com.tencent.mobileqq.studymode.ab;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\u0002R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/setting/main/processor/v;", "Lcom/tencent/mobileqq/setting/processor/c;", "", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o", "r", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/app/cx;", "g", "Lcom/tencent/mobileqq/app/cx;", "secSvcObserver", "Lgq2/d;", "y", "()Lgq2/d;", "studyModeConfig", tl.h.F, "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class v extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final cx secSvcObserver;

    private final void A() {
        AppInterface f16 = f();
        BusinessHandler businessHandler = f16 != null ? f16.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER) : null;
        SecSvcHandler secSvcHandler = businessHandler instanceof SecSvcHandler ? (SecSvcHandler) businessHandler : null;
        if (secSvcHandler != null) {
            secSvcHandler.G2(3);
        }
        AppInterface f17 = f();
        QQAppInterface qQAppInterface = f17 instanceof QQAppInterface ? (QQAppInterface) f17 : null;
        if (qQAppInterface != null) {
            KidModeServlet.n(qQAppInterface);
        }
    }

    private final void w() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.setting.main.processor.u
            @Override // java.lang.Runnable
            public final void run() {
                v.x(v.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(v this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ab.p(this$0.f()) || ModeChoiceViewContainer.I(this$0.f())) {
            this$0.A();
        }
    }

    private final gq2.d y() {
        com.tencent.mobileqq.widget.listitem.a<?> g16 = g();
        if (g16 instanceof gq2.d) {
            return (gq2.d) g16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        super.o();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.addObserver(this.secSvcObserver);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        super.onCreate();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.addObserver(this.secSvcObserver);
        }
        w();
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onDestroy() {
        super.onDestroy();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.removeObserver(this.secSvcObserver);
        }
        gq2.d y16 = y();
        if (y16 != null) {
            y16.M();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        gq2.d y16 = y();
        if (y16 != null) {
            boolean p16 = ab.p(f());
            if (y16.getIsVisible() != p16) {
                y16.p(p16);
                l();
            }
            y16.O();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void p(int requestCode, int resultCode, Intent data) {
        super.p(requestCode, resultCode, data);
        gq2.d y16 = y();
        if (y16 != null) {
            y16.K(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        gq2.d dVar = new gq2.d();
        dVar.p(ab.p(f()));
        return dVar;
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void r() {
        super.r();
        gq2.d y16 = y();
        if (y16 != null) {
            y16.N();
        }
    }

    public final void z() {
        gq2.d y16 = y();
        if (y16 != null) {
            y16.P();
        }
    }
}
