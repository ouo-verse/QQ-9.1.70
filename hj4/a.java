package hj4;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nr4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\b\t*\u0002\u001c \u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%Jj\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2-\b\u0002\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\rJ\u0006\u0010\u0010\u001a\u00020\tJ\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R;\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R;\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lhj4/a;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "roomId", "Lkotlin/Function1;", "Lnr4/f;", "Lkotlin/ParameterName;", "name", "msg", "", "Lcom/tencent/timi/game/liveroom/impl/room/fans/FansGroupReceiver;", "fansReceiver", "Lnr4/h;", "Lcom/tencent/timi/game/liveroom/impl/room/fans/DiamondGroupReceiver;", "diamondReceiver", "c", "e", "Lfp4/c;", "msgInfo", "onPush", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoomMessage;", "d", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoomMessage;", "liveRoomMessage", "Lkotlin/jvm/functions/Function1;", "f", h.F, "J", "hj4/a$c", "i", "Lhj4/a$c;", "fansGroupNotifyCallback", "hj4/a$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lhj4/a$b;", "diamondGroupNotifyCallback", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ILiveRoomMessage liveRoomMessage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super f, Unit> fansReceiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super nr4.h, Unit> diamondReceiver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c fansGroupNotifyCallback = new c();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b diamondGroupNotifyCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"hj4/a$b", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IQQCmdPushCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.e("Audience|FansGroupPushMgr", "onFail", "errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            if (data == null) {
                AegisLogger.INSTANCE.w("Audience|FansGroupPushMgr", "onReceive", "invalid data");
                return;
            }
            try {
                nr4.h c16 = nr4.h.c(data);
                AegisLogger.INSTANCE.i("Audience|FansGroupPushMgr", "onReceive", "anchorUid=" + c16.f421238a);
                Function1 function1 = a.this.diamondReceiver;
                if (function1 != null) {
                    function1.invoke(c16);
                }
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Audience|FansGroupPushMgr", "onReceive", "error, ", e16);
                Function1 function12 = a.this.diamondReceiver;
                if (function12 != null) {
                    function12.invoke(null);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"hj4/a$c", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IQQCmdPushCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.e("Audience|FansGroupPushMgr", "onFail", "errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            if (data == null) {
                AegisLogger.INSTANCE.w("Audience|FansGroupPushMgr", "onReceive", "invalid data");
                return;
            }
            try {
                f c16 = f.c(data);
                AegisLogger.INSTANCE.i("Audience|FansGroupPushMgr", "onReceive", "groupName=" + c16.f421235i);
                Function1 function1 = a.this.fansReceiver;
                if (function1 != null) {
                    function1.invoke(c16);
                }
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Audience|FansGroupPushMgr", "onReceive", "error, ", e16);
                Function1 function12 = a.this.fansReceiver;
                if (function12 != null) {
                    function12.invoke(null);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(a aVar, long j3, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function12 = null;
        }
        aVar.c(j3, function1, function12);
    }

    public final void c(long roomId, @Nullable Function1<? super f, Unit> fansReceiver, @Nullable Function1<? super nr4.h, Unit> diamondReceiver) {
        ILiveRoomMessage iLiveRoomMessage;
        this.fansReceiver = fansReceiver;
        this.diamondReceiver = diamondReceiver;
        this.roomId = roomId;
        com.tencent.mobileqq.qqlive.sail.room.f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null);
        if (z16 != null) {
            z16.p(167, this);
            z16.p(235, this);
            return;
        }
        ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(roomId);
        this.liveRoomMessage = k3;
        if (fansReceiver != null && k3 != null) {
            k3.registerHighPriorityListener(21, this.fansGroupNotifyCallback);
        }
        if (diamondReceiver != null && (iLiveRoomMessage = this.liveRoomMessage) != null) {
            iLiveRoomMessage.registerHighPriorityListener(109, this.diamondGroupNotifyCallback);
        }
    }

    public final void e() {
        this.fansReceiver = null;
        this.diamondReceiver = null;
        com.tencent.mobileqq.qqlive.sail.room.f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
        if (z16 != null) {
            z16.e(this);
        }
        ILiveRoomMessage iLiveRoomMessage = this.liveRoomMessage;
        if (iLiveRoomMessage != null) {
            iLiveRoomMessage.unRegisterHighPriorityListener(21, this.fansGroupNotifyCallback);
        }
        ILiveRoomMessage iLiveRoomMessage2 = this.liveRoomMessage;
        if (iLiveRoomMessage2 != null) {
            iLiveRoomMessage2.unRegisterHighPriorityListener(109, this.diamondGroupNotifyCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        f h16 = com.tencent.mobileqq.qqlive.sail.push.a.h(msgInfo);
        if (h16 != null) {
            AegisLogger.INSTANCE.i("Audience|FansGroupPushMgr", "onPush", "groupName=" + h16.f421235i);
            Function1<? super f, Unit> function1 = this.fansReceiver;
            if (function1 != null) {
                function1.invoke(h16);
            }
        }
        nr4.h e16 = com.tencent.mobileqq.qqlive.sail.push.a.e(msgInfo);
        if (e16 != null) {
            AegisLogger.INSTANCE.i("Audience|FansGroupPushMgr", "onPush", "anchorUid=" + e16.f421238a);
            Function1<? super nr4.h, Unit> function12 = this.diamondReceiver;
            if (function12 != null) {
                function12.invoke(e16);
            }
        }
    }
}
