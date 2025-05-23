package cj4;

import android.os.Bundle;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nJ,\u0010\u0013\u001a\u00020\b2$\u0010\u0007\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0012J:\u0010\u001b\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\bJ>\u0010#\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0018J*\u0010&\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b0$J\"\u0010*\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00022\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020(R\u0016\u0010-\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcj4/c;", "", "", "action", "Landroid/os/Bundle;", "bundle", "Leipc/EIPCResultCallback;", "callback", "", "c", "", "isECGoodsLive", "l", "isMaster", "", "roomId", "k", "j", "Lkotlin/Function4;", "e", "liveUserId", "liveRoomId", "livePlayTimeSecond", "liveProgramId", "", "live_type", "amsClickId", "g", h.F, "userId", WadlProxyConsts.CHANNEL, "openTabLevel", "title", "programId", "liveType", "i", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "eventCode", "", "params", DomainData.DOMAIN_NAME, "b", "J", "startLiveTime", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f31003a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long startLiveTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R(\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcj4/c$a;", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "result", "", "onCallback", "Lmqq/util/WeakReference;", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "d", "Lmqq/util/WeakReference;", "callbackRef", "callback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    private static final class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<Function1<QQECLiveEntryGoodsData, Unit>> callbackRef;

        public a(@Nullable Function1<? super QQECLiveEntryGoodsData, Unit> function1) {
            WeakReference<Function1<QQECLiveEntryGoodsData, Unit>> weakReference;
            if (function1 != null) {
                weakReference = new WeakReference<>(function1);
            } else {
                weakReference = null;
            }
            this.callbackRef = weakReference;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult result) {
            Bundle bundle;
            QQECLiveEntryGoodsData qQECLiveEntryGoodsData;
            WeakReference<Function1<QQECLiveEntryGoodsData, Unit>> weakReference;
            Function1<QQECLiveEntryGoodsData, Unit> function1;
            if (result != null && result.isSuccess() && (bundle = result.data) != null && (qQECLiveEntryGoodsData = (QQECLiveEntryGoodsData) bundle.getParcelable("KEY_LIVE_ENTRY_GOODS_DATA")) != null && (weakReference = this.callbackRef) != null && (function1 = weakReference.get()) != null) {
                function1.invoke(qQECLiveEntryGoodsData);
            }
        }
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String action, Bundle bundle, EIPCResultCallback eIPCResultCallback) {
        Intrinsics.checkNotNullParameter(action, "$action");
        QIPCClientHelper.getInstance().callServer("EcommerceIPCModule", action, bundle, eIPCResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function4 callback, EIPCResult eIPCResult) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (eIPCResult != null && eIPCResult.isSuccess() && (bundle = eIPCResult.data) != null) {
            long j3 = bundle.getLong("KEY_ORDER_NUM");
            long j16 = eIPCResult.data.getLong("KEY_ORDER_MONEY");
            long j17 = eIPCResult.data.getLong("KEY_PERSON_NUM");
            String formatOrderMoney = eIPCResult.data.getString("KEY_FORMAT_ORDER_MONEY", "");
            Long valueOf = Long.valueOf(j3);
            Long valueOf2 = Long.valueOf(j16);
            Long valueOf3 = Long.valueOf(j17);
            Intrinsics.checkNotNullExpressionValue(formatOrderMoney, "formatOrderMoney");
            callback.invoke(valueOf, valueOf2, valueOf3, formatOrderMoney);
        }
    }

    public final void c(@NotNull final String action, @Nullable final Bundle bundle, @Nullable final EIPCResultCallback callback) {
        Intrinsics.checkNotNullParameter(action, "action");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: cj4.a
            @Override // java.lang.Runnable
            public final void run() {
                c.d(action, bundle, callback);
            }
        });
    }

    public final void e(@NotNull final Function4<? super Long, ? super Long, ? super Long, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        c("ACTION_GET_LAST_TRANSACTION_DATA", new Bundle(), new EIPCResultCallback() { // from class: cj4.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                c.f(Function4.this, eIPCResult);
            }
        });
    }

    public final void g(@Nullable String liveUserId, long liveRoomId, long livePlayTimeSecond, @Nullable String liveProgramId, int live_type, @NotNull String amsClickId) {
        Intrinsics.checkNotNullParameter(amsClickId, "amsClickId");
        Bundle bundle = new Bundle();
        bundle.putString("KEY_URL", "mqqapi://ecommerce/open?target=19&channel=8&is_master=0&is_live_opened=1&is_trans_activity=1&is_appcompat_style=1&live_user_id=" + liveUserId + "&live_room_id=" + liveRoomId + "&live_play_time=" + livePlayTimeSecond + "&live_program_id=" + liveProgramId + "&live_type=" + live_type + "&qz_gdt=" + amsClickId);
        c("ACTION_JUMP_WITH_SCHEME", bundle, null);
    }

    public final void h() {
        Bundle bundle = new Bundle();
        bundle.putString("KEY_URL", "mqqapi://ecommerce/open?target=5&channel=8&src_type=internal&version=1");
        c("ACTION_JUMP_WITH_SCHEME", bundle, null);
    }

    public final void i(@NotNull String userId, long roomId, int channel, int openTabLevel, @NotNull String title, @NotNull String programId, int liveType) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(programId, "programId");
        Bundle bundle = new Bundle();
        bundle.putString("KEY_LIVE_USER_ID", userId);
        bundle.putLong("KEY_LIVE_ROOM_ID", roomId);
        bundle.putInt("KEY_CHANNEL", channel);
        bundle.putInt("KEY_OPENTAB_LEVEL", openTabLevel);
        bundle.putString("KEY_TITLE", title);
        bundle.putString(TraeConstants.KEY_SESSION_ID, programId);
        bundle.putInt("KEY_LIVE_TYPE", liveType);
        c("ACTION_NOTIFY_LIVE_OPEN", bundle, null);
    }

    public final void j(long roomId, boolean isECGoodsLive) {
        if (isECGoodsLive) {
            Bundle bundle = new Bundle();
            if (startLiveTime == 0) {
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE);
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE)");
                long decodeLong = from.decodeLong("KEY_LIVE_START_TIME", 0L);
                startLiveTime = decodeLong;
                QLog.e("QQLiveEcommerceHelper", 2, "onEndLive: live time drop, read live time from mmkv " + decodeLong);
            }
            long j3 = 1000;
            bundle.putInt("KEY_START_TIME", (int) (startLiveTime / j3));
            bundle.putInt("KEY_END_TIME", (int) (System.currentTimeMillis() / j3));
            bundle.putInt("KEY_CHANNEL", 8);
            bundle.putLong("KEY_LIVE_ROOM_ID", roomId);
            c("ACTION_REQUEST_TRANSACTION_DATA", bundle, null);
            c("ACTION_NOTIFY_LIVE_END", bundle, null);
            c("ACTION_CLEAR_LIVE_TAB_INFO", null, null);
        }
    }

    public final void k(boolean isMaster, long roomId, boolean isECGoodsLive) {
        if (isECGoodsLive) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("KEY_LIVE_IS_MASTER", isMaster);
            bundle.putLong("KEY_LIVE_ROOM_ID", roomId);
            if (!isMaster) {
                c("ACTION_PRELOAD_LIVE_TAB_INFO", bundle, null);
            }
        }
    }

    public final void l(boolean isECGoodsLive) {
        startLiveTime = System.currentTimeMillis();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE)");
        from.encodeLong("KEY_LIVE_START_TIME", startLiveTime);
        c("ACTION_CLEAR_LIVE_TAB_INFO", null, null);
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveEcommerceHelper", 2, "onStartLive: isECGoodsLive=" + isECGoodsLive);
        }
    }

    public final void m(long roomId, long userId, @NotNull Function1<? super QQECLiveEntryGoodsData, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Bundle bundle = new Bundle();
        bundle.putString("KEY_LIVE_USER_ID", String.valueOf(userId));
        bundle.putLong("KEY_LIVE_ROOM_ID", roomId);
        c("ACTION_REQUEST_LIVE_ENTRY_DATA", bundle, new a(callback));
    }

    public final void n(@NotNull String eventCode, @NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_EVENT_CODE", eventCode);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        c("ACTION_TERMINAL_REAL_REPORT", bundle, null);
        if (QLog.isColorLevel()) {
            QLog.i("QQLiveEcommerceHelper", 2, "terminalRealReport() eventCode=" + eventCode + ", params=" + params);
        }
    }
}
