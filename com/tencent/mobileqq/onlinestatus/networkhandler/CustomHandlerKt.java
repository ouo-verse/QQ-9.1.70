package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.onlinestatus.OnlineStatusShareInfo$GetShareInfoRsp;
import tencent.im.onlinestatus.OnlineStatusShareInfo$SetShareInfoRsp;
import tencent.im.onlinestatus.OnlineStatusShareInfo$ShareInfoItem;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a$\u0010\t\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a$\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0002*>\u0010\u0010\"\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00010\u000f2\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/networkhandler/CustomHandler;", "", "e", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "d", "c", "Lkotlin/Function0;", "block", "", "f", "Lkotlin/Function3;", "RspHandleFunc", "qqonlinestatus-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CustomHandlerKt {
    public static final void c(@NotNull CustomHandler customHandler, @NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object obj) {
        int i3;
        byte[] bArr;
        boolean z16;
        Intrinsics.checkNotNullParameter(customHandler, "<this>");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        Boolean isSelfRequest = (Boolean) req.getAttribute("key_is_get_self_info", Boolean.FALSE);
        final CustomHandler.a<com.tencent.mobileqq.onlinestatus.observer.a<OnlineStatusShareInfo$ShareInfoItem>> D2 = customHandler.D2((String) req.getAttribute("key_callback", ""));
        Intrinsics.checkNotNullExpressionValue(isSelfRequest, "isSelfRequest");
        if (isSelfRequest.booleanValue()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        final com.tencent.mobileqq.onlinestatus.observer.a aVar = new com.tencent.mobileqq.onlinestatus.observer.a(req, res, null, 4, null);
        OnlineStatusShareInfo$ShareInfoItem onlineStatusShareInfo$ShareInfoItem = null;
        if (obj instanceof byte[]) {
            bArr = (byte[]) obj;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            QLog.e("CustomHandler", 1, "handleGetShareInfo null data");
            if (D2 != null) {
                f(new Function0<Unit>() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandlerKt$handleGetShareInfo$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        D2.a(aVar);
                    }
                });
                return;
            } else {
                customHandler.notifyUI(i3, false, aVar);
                return;
            }
        }
        try {
            final boolean isSuccess = res.isSuccess();
            OnlineStatusShareInfo$GetShareInfoRsp onlineStatusShareInfo$GetShareInfoRsp = new OnlineStatusShareInfo$GetShareInfoRsp();
            onlineStatusShareInfo$GetShareInfoRsp.mergeFrom(bArr);
            final int i16 = onlineStatusShareInfo$GetShareInfoRsp.err_code.get();
            String stringUtf8 = onlineStatusShareInfo$GetShareInfoRsp.err_msg.get().toStringUtf8();
            if (onlineStatusShareInfo$GetShareInfoRsp.items.size() > 0) {
                onlineStatusShareInfo$ShareInfoItem = onlineStatusShareInfo$GetShareInfoRsp.items.get(0);
            }
            aVar.c(onlineStatusShareInfo$ShareInfoItem);
            QLog.d("CustomHandler", 1, "handleGetShareInfo errorCode: " + i16 + " errorMsg: " + stringUtf8);
            if (D2 != null) {
                f(new Function0<Unit>() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandlerKt$handleGetShareInfo$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (isSuccess && i16 == 0) {
                            D2.onSuccess(aVar);
                        } else {
                            D2.a(aVar);
                        }
                    }
                });
                return;
            }
            if (isSuccess && i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            customHandler.notifyUI(i3, z16, aVar);
        } catch (Exception e16) {
            QLog.e("CustomHandler", 1, "handleGetShareInfo error\n", e16);
            if (D2 != null) {
                f(new Function0<Unit>() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandlerKt$handleGetShareInfo$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        D2.a(aVar);
                    }
                });
            } else {
                customHandler.notifyUI(i3, false, aVar);
            }
        }
    }

    public static final void d(@NotNull CustomHandler customHandler, @NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object obj) {
        byte[] bArr;
        boolean z16;
        Intrinsics.checkNotNullParameter(customHandler, "<this>");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        com.tencent.mobileqq.onlinestatus.observer.a aVar = new com.tencent.mobileqq.onlinestatus.observer.a(req, res, null, 4, null);
        CustomShareInfo customShareInfo = null;
        if (obj instanceof byte[]) {
            bArr = (byte[]) obj;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            QLog.e("CustomHandler", 1, "handleSetShareInfo null data");
            customHandler.notifyUI(0, false, aVar);
            return;
        }
        try {
            boolean isSuccess = res.isSuccess();
            OnlineStatusShareInfo$SetShareInfoRsp onlineStatusShareInfo$SetShareInfoRsp = new OnlineStatusShareInfo$SetShareInfoRsp();
            onlineStatusShareInfo$SetShareInfoRsp.mergeFrom(bArr);
            int i3 = onlineStatusShareInfo$SetShareInfoRsp.err_code.get();
            String stringUtf8 = onlineStatusShareInfo$SetShareInfoRsp.err_msg.get().toStringUtf8();
            Object attribute = req.getAttribute(IOnlineStatusService.KEY_CUSTOM_SHARE_INFO);
            if (attribute instanceof CustomShareInfo) {
                customShareInfo = (CustomShareInfo) attribute;
            }
            aVar.c(customShareInfo);
            QLog.d("CustomHandler", 1, "handleSetShareInfo errorCode: " + i3 + " errorMsg: " + stringUtf8);
            if (isSuccess && i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            customHandler.notifyUI(0, z16, aVar);
        } catch (Exception e16) {
            QLog.e("CustomHandler", 1, "handleSetShareInfo error\n", e16);
            customHandler.notifyUI(0, false, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CustomHandler customHandler) {
        customHandler.K2("trpc.QQService.CommonLogic.StatusService.SsoSetShareInfo", new CustomHandlerKt$registerAllHandle$1(customHandler));
        customHandler.K2("trpc.QQService.CommonLogic.StatusService.SsoGetShareInfo", new CustomHandlerKt$registerAllHandle$2(customHandler));
    }

    private static final boolean f(final Function0<Unit> function0) {
        return ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.c
            @Override // java.lang.Runnable
            public final void run() {
                CustomHandlerKt.g(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
