package com.tencent.mobileqq.qwallet.jump;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \f2\u00020\u0001:\u0001\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jump/IWXQrcodePayApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "qrcodeUrl", "", WadlProxyConsts.CHANNEL, "token", "", "launchQrcodePay", "Landroid/content/Intent;", "intent", "handleWXEntryIntent", "Companion", "a", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IWXQrcodePayApi extends QRouteApi {
    public static final int CHANNEL_FROM_CAMERA = 1;
    public static final int CHANNEL_FROM_NATIVE_FILE = 2;
    public static final int CHANNEL_FROM_PIC_QR_DECODE = 3;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f278575a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jump/IWXQrcodePayApi$a;", "", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.jump.IWXQrcodePayApi$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f278575a = new Companion();

        Companion() {
        }
    }

    void handleWXEntryIntent(@Nullable Intent intent);

    void launchQrcodePay(@NotNull String qrcodeUrl, int channel, @NotNull String token);
}
