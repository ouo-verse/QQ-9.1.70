package com.tencent.mobileqq.gamecenter.api.impl;

import androidx.annotation.WorkerThread;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameAioLittleTailApi;
import com.tencent.mobileqq.gamecenter.api.impl.GameAioLittleTailApiImpl;
import com.tencent.mobileqq.gamecenter.protocols.a;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQGameAioLittleTail$GetShareTailsRequest;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQGameAioLittleTail$GetShareTailsResponse;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQGameAioLittleTail$ShareTail;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u0011\u0012B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/impl/GameAioLittleTailApiImpl;", "Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi;", "", "isMainProcess", "isStudyMode", "", "preloadLittleTailConfig", "", "appId", "", "appType", "msgTimestamp", "Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi$a;", "queryGamePicLittleTailInfo", "<init>", "()V", "Companion", "a", "b", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameAioLittleTailApiImpl implements IGameAioLittleTailApi {

    @NotNull
    private static final String TAG = "GameAioLittleTailApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0003J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0004R0\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/impl/GameAioLittleTailApiImpl$b;", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/QQGameAioLittleTail$GetShareTailsResponse;", "", "e", "rspData", "", "k", "i", "rsp", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "key", "d", "f", "appId", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/QQGameAioLittleTail$ShareTail;", tl.h.F, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "gameIdToLittleTailInfoMap", "Lcom/tencent/mobileqq/gamecenter/protocols/a;", "c", "Lcom/tencent/mobileqq/gamecenter/protocols/a;", "reqSender", "", "I", "reqIntervalSecond", "J", "lastReqTimestamp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasPreloaded", "", "g", "Z", "isNetRequesting", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static int reqIntervalSecond;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static long lastReqTimestamp;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private static boolean isNetRequesting;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f211839a = new b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final HashMap<Long, QQGameAioLittleTail$ShareTail> gameIdToLittleTailInfoMap = new HashMap<>();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final com.tencent.mobileqq.gamecenter.protocols.a reqSender = new com.tencent.mobileqq.gamecenter.protocols.a();

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final AtomicBoolean hasPreloaded = new AtomicBoolean(false);

        b() {
        }

        private final String d(String key) {
            String str;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = "";
            }
            return str + "_" + key;
        }

        private final Pair<QQGameAioLittleTail$GetShareTailsResponse, Long> e() {
            long decodeLong = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeLong(d("gamecenter_aio_little_tail_timestamp"), 0L);
            byte[] decodeBytes = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeBytes(d("gamecenter_aio_little_tail_config"), null);
            if (decodeBytes != null) {
                QQGameAioLittleTail$GetShareTailsResponse qQGameAioLittleTail$GetShareTailsResponse = new QQGameAioLittleTail$GetShareTailsResponse();
                try {
                    qQGameAioLittleTail$GetShareTailsResponse.mergeFrom(decodeBytes);
                    if (System.currentTimeMillis() - decodeLong < TimeUnit.SECONDS.toMillis(qQGameAioLittleTail$GetShareTailsResponse.refresh_interval.get())) {
                        return new Pair<>(qQGameAioLittleTail$GetShareTailsResponse, Long.valueOf(decodeLong));
                    }
                } catch (Exception e16) {
                    QLog.e(GameAioLittleTailApiImpl.TAG, 1, "loadLocalLittleTailData parse error", e16);
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g() {
            f211839a.i();
        }

        @WorkerThread
        private final void i() {
            if (isNetRequesting) {
                return;
            }
            QLog.d(GameAioLittleTailApiImpl.TAG, 1, "reqNetLittleTailData");
            isNetRequesting = true;
            lastReqTimestamp = System.currentTimeMillis();
            reqSender.d("/v1/1349", new MessageMicro<QQGameAioLittleTail$GetShareTailsRequest>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.QQGameAioLittleTail$GetShareTailsRequest
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQGameAioLittleTail$GetShareTailsRequest.class);
            }, new a.b() { // from class: com.tencent.mobileqq.gamecenter.api.impl.c
                @Override // com.tencent.mobileqq.gamecenter.protocols.a.b
                public final void a(long j3, String str, byte[] bArr) {
                    GameAioLittleTailApiImpl.b.j(j3, str, bArr);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(long j3, String str, byte[] bArr) {
            isNetRequesting = false;
            if (j3 == 0 && bArr != null) {
                QQGameAioLittleTail$GetShareTailsResponse qQGameAioLittleTail$GetShareTailsResponse = new QQGameAioLittleTail$GetShareTailsResponse();
                try {
                    qQGameAioLittleTail$GetShareTailsResponse.mergeFrom(bArr);
                    int i3 = qQGameAioLittleTail$GetShareTailsResponse.refresh_interval.get();
                    if (i3 < 60 || i3 > 259200) {
                        qQGameAioLittleTail$GetShareTailsResponse.refresh_interval.set(60);
                    }
                    b bVar = f211839a;
                    bVar.k(qQGameAioLittleTail$GetShareTailsResponse);
                    bVar.l(qQGameAioLittleTail$GetShareTailsResponse);
                    return;
                } catch (Exception e16) {
                    QLog.e(GameAioLittleTailApiImpl.TAG, 1, "reqNetLittleTailData parse error", e16);
                    return;
                }
            }
            QLog.e(GameAioLittleTailApiImpl.TAG, 1, "reqNetLittleTailData error, ret=" + j3 + ", errMsg=" + str);
        }

        private final void k(QQGameAioLittleTail$GetShareTailsResponse rspData) {
            byte[] byteArray = rspData.toByteArray();
            QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeLong(d("gamecenter_aio_little_tail_timestamp"), lastReqTimestamp);
            QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeBytes(d("gamecenter_aio_little_tail_config"), byteArray);
        }

        private final void l(QQGameAioLittleTail$GetShareTailsResponse rsp) {
            reqIntervalSecond = rsp.refresh_interval.get();
            List<QQGameAioLittleTail$ShareTail> tailInfoList = rsp.tails.get();
            synchronized (this) {
                gameIdToLittleTailInfoMap.clear();
                Intrinsics.checkNotNullExpressionValue(tailInfoList, "tailInfoList");
                for (QQGameAioLittleTail$ShareTail it : tailInfoList) {
                    HashMap<Long, QQGameAioLittleTail$ShareTail> hashMap = gameIdToLittleTailInfoMap;
                    Long valueOf = Long.valueOf(it.appid.get());
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    hashMap.put(valueOf, it);
                }
                Unit unit = Unit.INSTANCE;
            }
            QLog.i(GameAioLittleTailApiImpl.TAG, 1, "setLittleTailRspData intervalSec=" + reqIntervalSecond + ", dataSize=" + rsp.tails.size());
            if (QLog.isColorLevel()) {
                for (QQGameAioLittleTail$ShareTail qQGameAioLittleTail$ShareTail : tailInfoList) {
                    QLog.d(GameAioLittleTailApiImpl.TAG, 2, "setLittleTailRspData app=" + qQGameAioLittleTail$ShareTail.appid.get() + APLogFileUtil.SEPARATOR_LOG + qQGameAioLittleTail$ShareTail.game_name.get() + APLogFileUtil.SEPARATOR_LOG + qQGameAioLittleTail$ShareTail.title.get() + APLogFileUtil.SEPARATOR_LOG + qQGameAioLittleTail$ShareTail.start_time.get() + APLogFileUtil.SEPARATOR_LOG + qQGameAioLittleTail$ShareTail.end_time.get());
                }
            }
        }

        private final void m() {
            if (hasPreloaded.compareAndSet(false, true)) {
                f();
            } else if (System.currentTimeMillis() - lastReqTimestamp > TimeUnit.SECONDS.toMillis(reqIntervalSecond)) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameAioLittleTailApiImpl.b.n();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n() {
            f211839a.i();
        }

        public final void f() {
            hasPreloaded.set(true);
            Pair<QQGameAioLittleTail$GetShareTailsResponse, Long> e16 = e();
            if (e16 != null) {
                QLog.i(GameAioLittleTailApiImpl.TAG, 1, "preloadLittleTailData use local data");
                lastReqTimestamp = e16.getSecond().longValue();
                l(e16.getFirst());
                return;
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    GameAioLittleTailApiImpl.b.g();
                }
            });
        }

        @Nullable
        public final QQGameAioLittleTail$ShareTail h(long appId) {
            QQGameAioLittleTail$ShareTail qQGameAioLittleTail$ShareTail;
            m();
            synchronized (this) {
                qQGameAioLittleTail$ShareTail = gameIdToLittleTailInfoMap.get(Long.valueOf(appId));
                Unit unit = Unit.INSTANCE;
            }
            QQGameAioLittleTail$ShareTail qQGameAioLittleTail$ShareTail2 = qQGameAioLittleTail$ShareTail;
            if (qQGameAioLittleTail$ShareTail2 != null) {
                long j3 = qQGameAioLittleTail$ShareTail2.start_time.get();
                long j16 = qQGameAioLittleTail$ShareTail2.end_time.get();
                long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                boolean z16 = false;
                if (j3 <= seconds && seconds <= j16) {
                    z16 = true;
                }
                if (z16) {
                    return qQGameAioLittleTail$ShareTail2;
                }
                return null;
            }
            return null;
        }
    }

    private final boolean isMainProcess() {
        return Intrinsics.areEqual(MobileQQ.processName, BaseApplication.getContext().getPackageName());
    }

    private final boolean isStudyMode() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameAioLittleTailApi
    public void preloadLittleTailConfig() {
        if (!isMainProcess()) {
            return;
        }
        QLog.i(TAG, 1, "preloadLittleTailInfo");
        b.f211839a.f();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameAioLittleTailApi
    @Nullable
    public IGameAioLittleTailApi.LittleTailInfo queryGamePicLittleTailInfo(long appId, int appType, long msgTimestamp) {
        QQGameAioLittleTail$ShareTail h16;
        IGameAioLittleTailApi.JumpType jumpType;
        String str;
        String str2;
        if (!isMainProcess()) {
            QLog.e(TAG, 1, "queryGamePicLittleTailInfo at other process");
            return null;
        }
        if (isStudyMode() || (h16 = b.f211839a.h(appId)) == null) {
            return null;
        }
        if (h16.android_url.type.get() == 1) {
            jumpType = IGameAioLittleTailApi.JumpType.HTTP;
        } else {
            jumpType = IGameAioLittleTailApi.JumpType.SCHEMA;
        }
        IGameAioLittleTailApi.JumpType jumpType2 = jumpType;
        if (h16.tail_style.get() == 0) {
            str = "#21000000";
        } else {
            str = "#1AFFB300";
        }
        String str3 = str;
        if (h16.tail_style.get() == 0) {
            str2 = "#FFFFFFFF";
        } else {
            str2 = "#FFFFB300";
        }
        String str4 = str2;
        long j3 = h16.appid.get();
        String str5 = h16.game_name.get();
        Intrinsics.checkNotNullExpressionValue(str5, "it.game_name.get()");
        String str6 = h16.title.get();
        Intrinsics.checkNotNullExpressionValue(str6, "it.title.get()");
        String str7 = h16.game_icon.get();
        Intrinsics.checkNotNullExpressionValue(str7, "it.game_icon.get()");
        String str8 = h16.android_url.url.get();
        Intrinsics.checkNotNullExpressionValue(str8, "it.android_url.url.get()");
        return new IGameAioLittleTailApi.LittleTailInfo(j3, str5, str6, str7, str8, jumpType2, str3, str4);
    }
}
