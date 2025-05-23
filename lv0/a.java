package lv0;

import android.content.Context;
import android.content.DialogInterface;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.RoomAdminPush$PushMsg_KickOutSomebody;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.RoomAdminPush$PushMsg_PersonalMessage;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.RoomAdminPush$PushMsg_SetAdmin;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.DialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lv0.a;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw0.k;
import qw0.m;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0003\u0011\u0015\u0018\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\r\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Llv0/a;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "k", "i", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "e", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Lfu0/c;", "kotlin.jvm.PlatformType", "f", "Lfu0/c;", "liveRoomService", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "lv0/a$b", h.F, "Llv0/a$b;", "mKickOutCallback", "lv0/a$d", "Llv0/a$d;", "mSetAdminCallback", "lv0/a$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Llv0/a$c;", "mPersonalMsgCallback", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final fu0.c liveRoomService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mKickOutCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mSetAdminCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mPersonalMsgCallback;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"lv0/a$b", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements IQQCmdPushCallback {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f32.a f415614e;

        b(f32.a aVar) {
            this.f415614e = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(a this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            h22.a aVar = this$0.qqLiveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            aVar.b(true);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            a.this.mAegisLog.e("ICGameAdminOperationComponent", "PushMsg_SetAdmin onFail errCode =" + errCode + ",errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            try {
                RoomAdminPush$PushMsg_KickOutSomebody mergeFrom = new RoomAdminPush$PushMsg_KickOutSomebody().mergeFrom(data);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "PushMsg_KickOutSomebody().mergeFrom(data)");
                String stringUtf8 = mergeFrom.f116238msg.get().toStringUtf8();
                a.this.mAegisLog.i("ICGameAdminOperationComponent", "PushMsg_KickOutSomebody onRecv msg=" + stringUtf8);
                Context context = this.f415614e.getContext();
                String string = this.f415614e.getContext().getString(R.string.zgi);
                final a aVar = a.this;
                DialogUtil.createCustomDialog(context, 230, (String) null, stringUtf8, string, (String) null, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: lv0.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        a.b.b(a.this, dialogInterface, i3);
                    }
                }).show();
            } catch (InvalidProtocolBufferNanoException e16) {
                a.this.mAegisLog.e("ICGameAdminOperationComponent", "PushMsg_KickOutSomebody parse e =" + e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"lv0/a$c", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements IQQCmdPushCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            a.this.mAegisLog.e("ICGameAdminOperationComponent", "PushMsg_PersonalMessage onFail errCode =" + errCode + ",errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            Long l3;
            try {
                RoomAdminPush$PushMsg_PersonalMessage mergeFrom = new RoomAdminPush$PushMsg_PersonalMessage().mergeFrom(data);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "PushMsg_PersonalMessage().mergeFrom(data)");
                RoomAdminPush$PushMsg_PersonalMessage roomAdminPush$PushMsg_PersonalMessage = mergeFrom;
                PBUInt64Field pBUInt64Field = roomAdminPush$PushMsg_PersonalMessage.uid;
                if (pBUInt64Field != null) {
                    l3 = Long.valueOf(pBUInt64Field.get());
                } else {
                    l3 = null;
                }
                if (!Intrinsics.areEqual(l3, a.this.liveRoomService.K())) {
                    return;
                }
                String stringUtf8 = roomAdminPush$PushMsg_PersonalMessage.f116239msg.get().toStringUtf8();
                a.this.mAegisLog.i("ICGameAdminOperationComponent", "PushMsg_PersonalMessage onRecv msg=" + stringUtf8 + ",msgType=" + roomAdminPush$PushMsg_PersonalMessage.msg_type.get());
                m.e(stringUtf8, false);
            } catch (InvalidProtocolBufferNanoException e16) {
                a.this.mAegisLog.e("ICGameAdminOperationComponent", "PushMsg_PersonalMessage parse e =" + e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"lv0/a$d", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d implements IQQCmdPushCallback {
        d() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            a.this.mAegisLog.e("ICGameAdminOperationComponent", "RoomAdminPush onReceive onFail errCode =" + errCode + ",errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            try {
                RoomAdminPush$PushMsg_SetAdmin mergeFrom = new RoomAdminPush$PushMsg_SetAdmin().mergeFrom(data);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "PushMsg_SetAdmin().mergeFrom(data)");
                RoomAdminPush$PushMsg_SetAdmin roomAdminPush$PushMsg_SetAdmin = mergeFrom;
                String stringUtf8 = roomAdminPush$PushMsg_SetAdmin.f116240msg.get().toStringUtf8();
                a.this.mAegisLog.i("ICGameAdminOperationComponent", "RoomAdminPush onReceive onRecv msg=" + stringUtf8 + ",setAdmin=" + roomAdminPush$PushMsg_SetAdmin.set_admin.get());
                k.D(Foreground.getTopActivity(), stringUtf8);
            } catch (InvalidProtocolBufferNanoException e16) {
                a.this.mAegisLog.e("ICGameAdminOperationComponent", "RoomAdminPush onReceive parse e =" + e16);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.liveRoomService = (fu0.c) qx0.a.b(fu0.c.class);
        this.mKickOutCallback = new b(componentContext);
        this.mSetAdminCallback = new d();
        this.mPersonalMsgCallback = new c();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        this.mAegisLog.i("ICGameAdminOperationComponent", "unInitComponent");
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        this.mAegisLog.i("ICGameAdminOperationComponent", "initComponent");
    }
}
