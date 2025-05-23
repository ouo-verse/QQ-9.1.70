package com.tencent.qqnt.camera.api.impl;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.nt.adapter.session.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import dov.com.qq.im.ae.current.SessionWrap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "success", "Lcom/tencent/nt/adapter/session/f;", SessionDbHelper.SESSION_ID, "", "invoke", "(ZLcom/tencent/nt/adapter/session/f;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes34.dex */
final class CameraBusinessAPIImpl$startCameraAndCallback$1 extends Lambda implements Function2<Boolean, f, Unit> {
    final /* synthetic */ String $business;
    final /* synthetic */ AIOContact $contact;
    final /* synthetic */ com.tencent.aio.api.runtime.a $context;
    final /* synthetic */ boolean $isForbidVideoAbility;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ CameraBusinessAPIImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraBusinessAPIImpl$startCameraAndCallback$1(CameraBusinessAPIImpl cameraBusinessAPIImpl, AIOContact aIOContact, com.tencent.aio.api.runtime.a aVar, int i3, String str, boolean z16) {
        super(2);
        this.this$0 = cameraBusinessAPIImpl;
        this.$contact = aIOContact;
        this.$context = aVar;
        this.$requestCode = i3;
        this.$business = str;
        this.$isForbidVideoAbility = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(boolean z16, f fVar, CameraBusinessAPIImpl this$0, AIOContact contact, com.tencent.aio.api.runtime.a context, int i3, String business, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(business, "$business");
        if (z16 && fVar != null) {
            String a16 = fVar.a();
            SessionWrap sessionWrap = new SessionWrap(a16, contact.g(), fVar.b(), a16);
            FragmentActivity requireActivity = context.c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
            this$0.startCamera(sessionWrap, requireActivity, context, i3, business, z17);
            return;
        }
        QLog.e(CameraAPIImpl.TAG, 1, "startCamera Failed: uid2Uin failed");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, f fVar) {
        invoke(bool.booleanValue(), fVar);
        return Unit.INSTANCE;
    }

    public final void invoke(final boolean z16, final f fVar) {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final CameraBusinessAPIImpl cameraBusinessAPIImpl = this.this$0;
        final AIOContact aIOContact = this.$contact;
        final com.tencent.aio.api.runtime.a aVar = this.$context;
        final int i3 = this.$requestCode;
        final String str = this.$business;
        final boolean z17 = this.$isForbidVideoAbility;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.camera.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                CameraBusinessAPIImpl$startCameraAndCallback$1.b(z16, fVar, cameraBusinessAPIImpl, aIOContact, aVar, i3, str, z17);
            }
        });
    }
}
