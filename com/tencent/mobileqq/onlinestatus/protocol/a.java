package com.tencent.mobileqq.onlinestatus.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.model.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0002\u000f\u0017B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016JX\u0010\u000f\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022B\u0010\u000e\u001a>\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/a;", "", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mobileqq/onlinestatus/model/f;", "switchMap", "", "callback", "a", "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001BD\u0012\u0006\u0010\u000f\u001a\u00020\n\u00123\u0010\u001c\u001a/\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015\u0012\u0004\u0012\u00020\b0\u0010\u00a2\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eRD\u0010\u001c\u001a/\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015\u0012\u0004\u0012\u00020\b0\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/a$b;", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "d", "Ljava/lang/String;", "getCmd", "()Ljava/lang/String;", "cmd", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "", "", "Lcom/tencent/mobileqq/onlinestatus/model/f;", "e", "Lkotlin/jvm/functions/Function2;", "getCallback", "()Lkotlin/jvm/functions/Function2;", "callback", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/protocol/a;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    private final class b extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String cmd;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function2<Boolean, Map<Long, f>, Unit> callback;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f256145f;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull a aVar, @NotNull String cmd, Function2<? super Boolean, ? super Map<Long, f>, Unit> callback) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f256145f = aVar;
            this.cmd = cmd;
            this.callback = callback;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            HashMap hashMap = new HashMap();
            if (errorCode == 0 && data != null) {
                try {
                    oidb_0x5eb$RspBody mergeFrom = new oidb_0x5eb$RspBody().mergeFrom(data);
                    if (!mergeFrom.rpt_msg_uin_data.has()) {
                        QLog.w("OnlineStatusAvatar.SwitchHandler", 1, "[onResult] uin data list is empty, cmd=" + this.cmd);
                        this.callback.invoke(Boolean.FALSE, hashMap);
                        return;
                    }
                    int size = mergeFrom.rpt_msg_uin_data.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = mergeFrom.rpt_msg_uin_data.get(i3);
                        if (!oidb_0x5eb_udcuindata.uint64_uin.has()) {
                            QLog.w("OnlineStatusAvatar.SwitchHandler", 1, "[onResult] uin not exist in uin data, ignore, cmd=" + this.cmd);
                        } else {
                            hashMap.put(Long.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get()), new f(oidb_0x5eb_udcuindata.uint32_online_status_avatar_switch.get()));
                        }
                    }
                    QLog.w("OnlineStatusAvatar.SwitchHandler", 1, "[onResult] success, cmd=" + this.cmd + ", dataCount=" + hashMap.size());
                    this.callback.invoke(Boolean.TRUE, hashMap);
                    return;
                } catch (Exception e16) {
                    QLog.w("OnlineStatusAvatar.SwitchHandler", 1, "[onResult] exception, cmd=" + this.cmd + ", exc=" + e16);
                    this.callback.invoke(Boolean.FALSE, hashMap);
                    return;
                }
            }
            QLog.w("OnlineStatusAvatar.SwitchHandler", 1, "[onResult] fail, cmd=" + this.cmd + ", error=" + errorCode);
            this.callback.invoke(Boolean.FALSE, hashMap);
        }
    }

    public a(@NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
    }

    public final void a(@NotNull List<Long> uinList, @NotNull Function2<? super Boolean, ? super Map<Long, f>, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!uinList.isEmpty() && uinList.size() <= 200) {
            if (QLog.isColorLevel()) {
                QLog.i("OnlineStatusAvatar.SwitchHandler", 1, "[getSwitch] uin count is " + uinList.size());
            }
            AppInterface appInterface = this.app;
            b bVar = new b(this, "OidbSvc.0x5eb_common", callback);
            oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
            oidb_0x5eb_reqbody.rpt_uint64_uins.set(uinList);
            oidb_0x5eb_reqbody.uint32_online_status_avatar_switch.set(1);
            Unit unit = Unit.INSTANCE;
            ProtoUtils.a(appInterface, bVar, oidb_0x5eb_reqbody.toByteArray(), "OidbSvc.0x5eb_common", 1515, 22);
            return;
        }
        QLog.i("OnlineStatusAvatar.SwitchHandler", 1, "[getSwitch] invalid uin list size, size=" + uinList.size());
        Boolean bool = Boolean.FALSE;
        emptyMap = MapsKt__MapsKt.emptyMap();
        callback.invoke(bool, emptyMap);
    }
}
