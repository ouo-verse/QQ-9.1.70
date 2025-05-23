package com.tencent.qqnt.aio.assistedchat.adapter;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.d;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J6\u0010\u000e\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&J<\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0017\u001a\u00020\fH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatSwitchAdapterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "isSwitchOn", "", "getSwitchValue", "", "switchList", "switchValue", "Lkotlin/Function1;", "", "callback", "reqSetSwitch", "", "uin", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", "reqGetSwitch", "Lwu3/a;", "listener", "addSwitchChangedListener", "removeSwitchChangedListener", "preRequestSwitch", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAssistedChatSwitchAdapterApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IAssistedChatSwitchAdapterApi iAssistedChatSwitchAdapterApi, List list, int i3, Function1 function1, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    function1 = null;
                }
                iAssistedChatSwitchAdapterApi.reqSetSwitch(list, i3, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reqSetSwitch");
        }
    }

    void addSwitchChangedListener(@NotNull wu3.a listener);

    int getSwitchValue(@NotNull AssistedChatSwitch r16);

    boolean isSwitchOn(@NotNull AssistedChatSwitch r16);

    void preRequestSwitch();

    void removeSwitchChangedListener(@NotNull wu3.a listener);

    void reqGetSwitch(@NotNull String uin, @NotNull List<AssistedChatSwitch> switchList, @Nullable Function1<? super List<d>, Unit> callback);

    void reqSetSwitch(@NotNull List<AssistedChatSwitch> switchList, int switchValue, @Nullable Function1<? super Boolean, Unit> callback);
}
