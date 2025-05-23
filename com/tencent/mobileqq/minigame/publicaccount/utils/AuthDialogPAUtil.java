package com.tencent.mobileqq.minigame.publicaccount.utils;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGameConfigProcessor;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/utils/AuthDialogPAUtil;", "", "()V", "TAG", "", "followMiniGamePA", "", "eventCallback", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/SpecialProxy$EventCallback;", "getMiniGamePASubMsg", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class AuthDialogPAUtil {
    public static final AuthDialogPAUtil INSTANCE = new AuthDialogPAUtil();
    private static final String TAG = "AuthDialogPAUtil";

    AuthDialogPAUtil() {
    }

    @JvmStatic
    public static final void followMiniGamePA(final SpecialProxy.EventCallback eventCallback) {
        Bundle bundle = new Bundle();
        bundle.putLong(PublicAccountUtil.KEY_PA_UIN, Long.parseLong(IMiniGamePublicAccountApi.UIN_MINI_GAME_PA));
        bundle.putBoolean(PublicAccountUtil.KEY_IS_FOLLOW, true);
        QIPCClientHelper.getInstance().getClient().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_PA_FOLLOW, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.publicaccount.utils.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                AuthDialogPAUtil.followMiniGamePA$lambda$2(SpecialProxy.EventCallback.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void followMiniGamePA$lambda$2(SpecialProxy.EventCallback eventCallback, EIPCResult eIPCResult) {
        int i3 = eIPCResult.code;
        if (i3 == 0) {
            if (eIPCResult.data.getBoolean(PublicAccountUtil.KEY_RESULT_CODE)) {
                i3 = 0;
            } else {
                QLog.e(TAG, 1, "[followPublicAccount] followPA error");
                i3 = -1;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[followPublicAccount] onCallback errCode" + i3);
        }
        if (eventCallback != null) {
            eventCallback.onResult(i3 == 0, null);
        }
    }

    @JvmStatic
    public static final void getMiniGamePASubMsg(final SpecialProxy.EventCallback eventCallback) {
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        if (!MiniGameConfigProcessor.INSTANCE.loadConfig().isShowSubscribe()) {
            eventCallback.onResult(false, null);
            QLog.d(TAG, 2, "isShowSubscribe false");
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong(PublicAccountUtil.KEY_PA_UIN, Long.parseLong(IMiniGamePublicAccountApi.UIN_MINI_GAME_PA));
            QIPCClientHelper.getInstance().getClient().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_PA_IS_FOLLOW, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.publicaccount.utils.b
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    AuthDialogPAUtil.getMiniGamePASubMsg$lambda$1(SpecialProxy.EventCallback.this, eIPCResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMiniGamePASubMsg$lambda$1(SpecialProxy.EventCallback eventCallback, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(eventCallback, "$eventCallback");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[isFollow] onCallback=" + eIPCResult.code);
        }
        if (!(eIPCResult.code == 0 ? eIPCResult.data.getBoolean(PublicAccountUtil.KEY_IS_FOLLOW) : false)) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(SpecialProxy.KEY_DATA, INSTANCE.getMiniGamePASubMsg());
            eventCallback.onResult(true, bundle);
            return;
        }
        eventCallback.onResult(false, null);
    }

    private final byte[] getMiniGamePASubMsg() {
        INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = new INTERFACE$StSubscribeMessage();
        iNTERFACE$StSubscribeMessage.authState.set(0);
        INTERFACE$StExampleDetail iNTERFACE$StExampleDetail = new INTERFACE$StExampleDetail();
        ArrayList arrayList = new ArrayList();
        COMM.Entry entry = new COMM.Entry();
        entry.key.set("\u901a\u77e5\u7c7b\u578b");
        entry.value.set("\u5b98\u65b9\u8ba2\u9605\u6d88\u606f");
        arrayList.add(entry);
        COMM.Entry entry2 = new COMM.Entry();
        entry2.key.set("\u6d88\u606f\u6765\u6e90");
        entry2.value.set("QQ\u5c0f\u6e38\u620f");
        arrayList.add(entry2);
        COMM.Entry entry3 = new COMM.Entry();
        entry3.key.set("\u6d88\u606f\u793a\u4f8b");
        entry3.value.set("QQ\u5c0f\u6e38\u620f\u6700\u65b0\u6d88\u606f\u3001\u6bcf\u65e5\u793c\u5305\u7b49\u798f\u5229\u5185\u5bb9\u7b49\u4f60\u67e5\u770b");
        arrayList.add(entry3);
        iNTERFACE$StExampleDetail.title.set("\u8ba2\u9605QQ\u5c0f\u6e38\u620f");
        iNTERFACE$StExampleDetail.contents.set(arrayList);
        iNTERFACE$StSubscribeMessage.example.set(iNTERFACE$StExampleDetail);
        byte[] byteArray = iNTERFACE$StSubscribeMessage.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "stSubscribeMessage.toByteArray()");
        return byteArray;
    }
}
