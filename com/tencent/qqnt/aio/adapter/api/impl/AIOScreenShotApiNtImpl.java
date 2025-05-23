package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.adapter.api.IAIOScreenShotApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOScreenShotApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi;", "()V", "aioScreenShotOperation", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "peerUin", "", "path", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "operationCode", "Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi$OperationCode;", "exitShot", "Lkotlin/Function0;", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi$OperationCode;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOScreenShotApiNtImpl implements IAIOScreenShotApi {
    static IPatchRedirector $redirector_;

    public AIOScreenShotApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOScreenShotApi
    @Nullable
    public Object aioScreenShotOperation(@NotNull Activity activity, @NotNull String str, @NotNull String str2, @NotNull Bitmap bitmap, @NotNull IAIOScreenShotApi.OperationCode operationCode, @NotNull Function0<Unit> function0, @NotNull Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, activity, str, str2, bitmap, operationCode, function0, continuation);
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOScreenShotApi
    public void showLongShotGuide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            IAIOScreenShotApi.a.a(this, z16);
        }
    }
}
