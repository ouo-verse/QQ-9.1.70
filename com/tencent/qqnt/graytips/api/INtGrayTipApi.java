package com.tencent.qqnt.graytips.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/graytips/api/INtGrayTipApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addLocalGrayTip", "", "app", "Lmqq/app/AppRuntime;", "localGrayTip", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip;", "cb", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddJsonGrayTipMsgCallback;", "graytips_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface INtGrayTipApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static /* synthetic */ void a(INtGrayTipApi iNtGrayTipApi, AppRuntime appRuntime, LocalGrayTip localGrayTip, IAddJsonGrayTipMsgCallback iAddJsonGrayTipMsgCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    iAddJsonGrayTipMsgCallback = null;
                }
                iNtGrayTipApi.addLocalGrayTip(appRuntime, localGrayTip, iAddJsonGrayTipMsgCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addLocalGrayTip");
        }
    }

    void addLocalGrayTip(@NotNull AppRuntime app, @NotNull LocalGrayTip localGrayTip, @Nullable IAddJsonGrayTipMsgCallback cb5);
}
