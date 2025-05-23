package com.tencent.mobileqq.onlinestatus.protocol;

import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.model.f;
import com.tencent.mobileqq.onlinestatus.protocol.OnlineStatusAvatarSwitchProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00052\u00020\u0001:\u0005 #\u0005\u001e+B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0016\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor;", "Lcom/tencent/mobileqq/profilecommon/processor/AbsProfileCommonProcessor;", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData;", "udcUinData", "", "c", "getProcessorKey", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$ReqBody;", "reqBody", "", "onGetProfileDetailRequestForLogin", "Landroid/os/Bundle;", Const.BUNDLE_KEY_REQUEST, "success", "", "onGetProfileDetailResponse", "", "uin", "onProcessProfileModifyPushBegin", "onProcessProfileModifyPushEnd", "", "type", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "bytesValue", "onProcessProfileModifyPush", "onSetProfileDetailResponse", "Lcom/tencent/mobileqq/onlinestatus/model/f;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$c;", "callback", "d", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "app", "b", "J", "profileModifyUin", "Lcom/tencent/mobileqq/onlinestatus/protocol/c;", "()Lcom/tencent/mobileqq/onlinestatus/protocol/c;", "repo", "<init>", "(Lmqq/app/AppRuntime;)V", "e", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusAvatarSwitchProcessor extends AbsProfileCommonProcessor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long profileModifyUin;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0004R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00048\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$a;", "", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "()Ljava/util/concurrent/ConcurrentHashMap;", "contextMap", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextCallbackId", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ConcurrentHashMap<Integer, Object> contextMap = new ConcurrentHashMap<>();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicInteger nextCallbackId = new AtomicInteger(1);

        protected final int a() {
            return this.nextCallbackId.getAndIncrement();
        }

        @NotNull
        protected final ConcurrentHashMap<Integer, Object> b() {
            return this.contextMap;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$c;", "", "", "success", "Lcom/tencent/mobileqq/onlinestatus/model/f;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface c {
        void a(boolean success, @NotNull f r26);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$d;", "Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$a;", "", "uin", "Lcom/tencent/mobileqq/onlinestatus/model/f;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$c;", "callback", "", "c", "callbackId", "", "success", "", "d", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    private static final class d extends a {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final d f256137c = new d();

        d() {
        }

        public final int c(@NotNull String uin, @NotNull f r65, @NotNull c callback) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(r65, "switch");
            Intrinsics.checkNotNullParameter(callback, "callback");
            int a16 = a();
            b().put(Integer.valueOf(a16), new SetSwitchContext(uin, r65, callback));
            return a16;
        }

        public final void d(int callbackId, boolean success) {
            SetSwitchContext setSwitchContext;
            Object remove = b().remove(Integer.valueOf(callbackId));
            if (remove instanceof SetSwitchContext) {
                setSwitchContext = (SetSwitchContext) remove;
            } else {
                setSwitchContext = null;
            }
            if (setSwitchContext == null) {
                QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[doCallback] callback id not found, id=" + callbackId);
                return;
            }
            setSwitchContext.getCallback().a(success, setSwitchContext.getSwitch());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "Lcom/tencent/mobileqq/onlinestatus/model/f;", "b", "Lcom/tencent/mobileqq/onlinestatus/model/f;", "()Lcom/tencent/mobileqq/onlinestatus/model/f;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$c;", "c", "Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$c;", "()Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$c;", "callback", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/onlinestatus/model/f;Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$c;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.protocol.OnlineStatusAvatarSwitchProcessor$e, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class SetSwitchContext {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final f switch;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final c callback;

        public SetSwitchContext(@NotNull String uin, @NotNull f fVar, @NotNull c callback) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(fVar, "switch");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.uin = uin;
            this.switch = fVar;
            this.callback = callback;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final c getCallback() {
            return this.callback;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final f getSwitch() {
            return this.switch;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetSwitchContext)) {
                return false;
            }
            SetSwitchContext setSwitchContext = (SetSwitchContext) other;
            if (Intrinsics.areEqual(this.uin, setSwitchContext.uin) && Intrinsics.areEqual(this.switch, setSwitchContext.switch) && Intrinsics.areEqual(this.callback, setSwitchContext.callback)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.uin.hashCode() * 31) + this.switch.hashCode()) * 31) + this.callback.hashCode();
        }

        @NotNull
        public String toString() {
            return "SetSwitchContext(uin=" + this.uin + ", switch=" + this.switch + ", callback=" + this.callback + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusAvatarSwitchProcessor(@NotNull AppRuntime app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
    }

    private final com.tencent.mobileqq.onlinestatus.protocol.c b() {
        return com.tencent.mobileqq.onlinestatus.protocol.c.INSTANCE.a();
    }

    private final String c(oidb_0x5eb$UdcUinData udcUinData) {
        if (udcUinData.uint64_uin.has()) {
            return String.valueOf(udcUinData.uint64_uin.get());
        }
        return this.app.getCurrentUin().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c callback, f fVar) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(fVar, "$switch");
        callback.a(false, fVar);
    }

    public final void d(@NotNull final f r65, @NotNull final c callback) {
        Intrinsics.checkNotNullParameter(r65, "switch");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[setSwitch] switch=" + r65);
        if (this.appRuntime == null) {
            QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[setSwitch] app runtime is null");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.protocol.b
                @Override // java.lang.Runnable
                public final void run() {
                    OnlineStatusAvatarSwitchProcessor.e(OnlineStatusAvatarSwitchProcessor.c.this, r65);
                }
            });
            return;
        }
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        oidb_0x587_reqbody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
        oidb_0x587_reqbody.uint32_online_status_avatar_switch.set(r65.b());
        Bundle bundle = new Bundle();
        d dVar = d.f256137c;
        String currentAccountUin = this.appRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        bundle.putInt("KEY_CALLBACK_ID", dVar.c(currentAccountUin, r65, callback));
        Unit unit = Unit.INSTANCE;
        setProfileDetail(oidb_0x587_reqbody, bundle);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    @NotNull
    public String getProcessorKey() {
        return "OnlineStatusAvatarSwitchProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(@Nullable oidb_0x5eb$ReqBody reqBody) {
        PBUInt32Field pBUInt32Field;
        if (reqBody != null && (pBUInt32Field = reqBody.uint32_online_status_avatar_switch) != null) {
            pBUInt32Field.set(1);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(@Nullable Bundle request, boolean success, @Nullable oidb_0x5eb$UdcUinData udcUinData) {
        if (success && udcUinData != null) {
            String c16 = c(udcUinData);
            if (!udcUinData.uint32_online_status_avatar_switch.has()) {
                QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[onGetProfileDetailResponse] switch not exist, uin=" + c16);
                return;
            }
            f fVar = new f(udcUinData.uint32_online_status_avatar_switch.get());
            QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[onGetProfileDetailResponse] updated, uin=" + c16 + ", switch=" + fVar);
            b().q(c16, fVar);
            return;
        }
        QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[onGetProfileDetailResponse] fail, success=" + success);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int type, @NotNull ByteStringMicro bytesValue) {
        Intrinsics.checkNotNullParameter(bytesValue, "bytesValue");
        String valueOf = String.valueOf(this.profileModifyUin);
        if (type == 47171) {
            try {
                f fVar = new f(ByteBuffer.wrap(bytesValue.toByteArray()).asIntBuffer().get());
                QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[onProcessProfileModifyPush] update, uin=" + valueOf + " switch=" + fVar);
                b().q(valueOf, fVar);
            } catch (Exception e16) {
                QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[onProcessProfileModifyPush] exception=" + e16 + ", uin=" + valueOf + " type=" + type);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPushBegin(long uin) {
        if (QLog.isColorLevel()) {
            QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[onProcessProfileModifyPushBegin], uin=" + uin);
        }
        this.profileModifyUin = uin;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPushEnd() {
        if (QLog.isColorLevel()) {
            QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[onProcessProfileModifyPushEnd], uin=" + this.profileModifyUin);
        }
        this.profileModifyUin = 0L;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onSetProfileDetailResponse(@Nullable Bundle request, boolean success) {
        Integer num;
        QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[onSetProfileDetailResponse] success=" + success);
        if (request != null) {
            num = Integer.valueOf(request.getInt("KEY_CALLBACK_ID"));
        } else {
            num = null;
        }
        if (num != null && num.intValue() != 0) {
            d.f256137c.d(num.intValue(), success);
        } else {
            QLog.i("OnlineStatusAvatar.SwitchProcessor", 1, "[onSetProfileDetailResponse] callback id is null");
        }
    }
}
