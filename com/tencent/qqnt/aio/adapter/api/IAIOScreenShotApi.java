package com.tencent.qqnt.aio.adapter.api;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0013JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "aioScreenShotOperation", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "peerUin", "", "path", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "operationCode", "Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi$OperationCode;", "exitShot", "Lkotlin/Function0;", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi$OperationCode;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showLongShotGuide", "isRobotAIO", "", "OperationCode", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOScreenShotApi extends QRouteApi {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi$OperationCode;", "", "(Ljava/lang/String;I)V", "EDIT", "COMPLETE", "PREVIEW", "MULTISELCT_SHARE", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class OperationCode {
        private static final /* synthetic */ OperationCode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final OperationCode COMPLETE;
        public static final OperationCode EDIT;
        public static final OperationCode MULTISELCT_SHARE;
        public static final OperationCode PREVIEW;

        private static final /* synthetic */ OperationCode[] $values() {
            return new OperationCode[]{EDIT, COMPLETE, PREVIEW, MULTISELCT_SHARE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30161);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EDIT = new OperationCode("EDIT", 0);
            COMPLETE = new OperationCode("COMPLETE", 1);
            PREVIEW = new OperationCode("PREVIEW", 2);
            MULTISELCT_SHARE = new OperationCode("MULTISELCT_SHARE", 3);
            $VALUES = $values();
        }

        OperationCode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static OperationCode valueOf(String str) {
            return (OperationCode) Enum.valueOf(OperationCode.class, str);
        }

        public static OperationCode[] values() {
            return (OperationCode[]) $VALUES.clone();
        }
    }

    @Nullable
    Object aioScreenShotOperation(@NotNull Activity activity, @NotNull String str, @NotNull String str2, @NotNull Bitmap bitmap, @NotNull OperationCode operationCode, @NotNull Function0<Unit> function0, @NotNull Continuation<? super Unit> continuation);

    void showLongShotGuide(boolean isRobotAIO);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static void a(@NotNull IAIOScreenShotApi iAIOScreenShotApi, boolean z16) {
        }
    }
}
