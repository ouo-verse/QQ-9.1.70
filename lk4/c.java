package lk4;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.sso.request.QQLiveGetChatStatusSvrRequest;
import com.tencent.timi.game.sso.request.QQLiveIsRoomAdminSvrRequest;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00020#B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J$\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0007J0\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u001b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J(\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\tR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Llk4/c;", "", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "method", "", "f", "", "g", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "liveMessageData", "j", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "fromCache", "", VasLiveIPCModule.KEY_ANCHOR_UIN, "uin", "roomId", "Llk4/c$b;", "callback", "l", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "msg", "o", "selfUid", "anchorUid", "Llk4/c$a;", h.F, "k", DomainData.DOMAIN_NAME, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "b", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "Lhp4/d;", "c", "Lhp4/d;", "mCacheIsRoomAdminRsp", "Lhp4/e;", "d", "Lhp4/e;", "mCacheSelfDisableInfo", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f414972a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAegisLogApi mAegisLog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static hp4.d mCacheIsRoomAdminRsp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static hp4.e mCacheSelfDisableInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Llk4/c$a;", "", "", "isForbidden", "", "onResult", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void onResult(boolean isForbidden);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Llk4/c$b;", "", "", "isAdmin", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(boolean isAdmin);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"lk4/c$c", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lhp4/b;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: lk4.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10730c implements ILiveNetRequest.Callback<hp4.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f414976a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f414977b;

        C10730c(a aVar, long j3) {
            this.f414976a = aVar;
            this.f414977b = j3;
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<hp4.b> response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (c.f414972a.f(response, "isRoomAdmin")) {
                a aVar = this.f414976a;
                if (aVar != null) {
                    aVar.onResult(false);
                    return;
                }
                return;
            }
            hp4.b rsp = response.getRsp();
            if (rsp == null) {
                c.mAegisLog.w("RoomAdminProxy", "[getSelfChatStatus] rsp is null!");
                c.mCacheSelfDisableInfo = null;
                a aVar2 = this.f414976a;
                if (aVar2 != null) {
                    aVar2.onResult(false);
                    return;
                }
                return;
            }
            c.mAegisLog.i("RoomAdminProxy", "[getSelfChatStatus] success");
            hp4.e[] eVarArr = rsp.f405851d;
            if (eVarArr != null) {
                Intrinsics.checkNotNullExpressionValue(eVarArr, "rsp.chatDisableUsers");
                for (hp4.e eVar : eVarArr) {
                    Intrinsics.checkNotNullExpressionValue(eVar, "rsp.chatDisableUsers");
                    if (eVar.f405863e == this.f414977b) {
                        c.mCacheSelfDisableInfo = eVar;
                        a aVar3 = this.f414976a;
                        if (aVar3 != null) {
                            aVar3.onResult(true);
                        }
                        c.mAegisLog.i("RoomAdminProxy", "[getSelfChatStatus] " + this.f414977b + " is chat forbidden");
                        return;
                    }
                }
            }
            c.mCacheSelfDisableInfo = null;
            a aVar4 = this.f414976a;
            if (aVar4 != null) {
                aVar4.onResult(false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"lk4/c$d", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lhp4/d;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements ILiveNetRequest.Callback<hp4.d> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f414978a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f414979b;

        d(b bVar, long j3) {
            this.f414978a = bVar;
            this.f414979b = j3;
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<hp4.d> response) {
            Intrinsics.checkNotNullParameter(response, "response");
            boolean z16 = false;
            if (c.f414972a.f(response, "isRoomAdmin")) {
                b bVar = this.f414978a;
                if (bVar != null) {
                    bVar.a(false);
                    return;
                }
                return;
            }
            hp4.d rsp = response.getRsp();
            if (rsp == null) {
                c.mAegisLog.e("RoomAdminProxy", "[isRoomAdmin] rsp is null!");
                b bVar2 = this.f414978a;
                if (bVar2 != null) {
                    bVar2.a(false);
                    return;
                }
                return;
            }
            if (rsp.f405855a != 0) {
                c.mAegisLog.e("RoomAdminProxy", "[isRoomAdmin] rsp failed, retCode=" + rsp.f405855a);
                b bVar3 = this.f414978a;
                if (bVar3 != null) {
                    bVar3.a(false);
                    return;
                }
                return;
            }
            c.mAegisLog.i("RoomAdminProxy", "[isRoomAdmin] success, isAdmin=" + rsp.f405857c);
            if (this.f414979b == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                c.mCacheIsRoomAdminRsp = rsp;
            }
            b bVar4 = this.f414978a;
            if (bVar4 != null) {
                if (rsp.f405857c > 0) {
                    z16 = true;
                }
                bVar4.a(z16);
            }
        }
    }

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        mAegisLog = (IAegisLogApi) api;
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> boolean f(QQLiveResponse<T> response, String method) {
        T rsp = response.getRsp();
        if (rsp == null) {
            rsp = null;
        }
        if (!response.isFailed() && response.getRetCode() == 0 && rsp != null) {
            return false;
        }
        mAegisLog.w("RoomAdminProxy", method + "response failed, errCode=" + response.getRetCode() + ", errMsg=" + response.getErrMsg());
        return true;
    }

    public final void g() {
        mCacheIsRoomAdminRsp = null;
        mCacheSelfDisableInfo = null;
    }

    public final void h(long selfUid, long anchorUid, long roomId, @Nullable a callback) {
        mAegisLog.i("RoomAdminProxy", "[getSelfChatStatus] anchorUid=" + anchorUid + ",roomId=" + roomId);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetChatStatusSvrRequest(roomId, anchorUid, selfUid), new C10730c(callback, selfUid));
    }

    public final boolean i(@NotNull LiveMessageData liveMessageData) {
        Intrinsics.checkNotNullParameter(liveMessageData, "liveMessageData");
        LiveMessageData.MsgContent msgContent = liveMessageData.msgContent;
        if (msgContent == null) {
            return false;
        }
        Iterator<LiveMessageData.ExtData> it = msgContent.mExtDatas.iterator();
        while (it.hasNext()) {
            if (100020 == it.next().mId) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(@NotNull LiveMessageData liveMessageData) {
        Intrinsics.checkNotNullParameter(liveMessageData, "liveMessageData");
        LiveMessageData.SpeakerInfo speakerInfo = liveMessageData.mSpeakerInfo;
        if (speakerInfo == null) {
            return false;
        }
        long j3 = speakerInfo.mSpeakId;
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        if (j3 != com.tencent.mobileqq.qqlive.sail.c.l(cVar, cVar.p(), 0, 2, null)) {
            return false;
        }
        return true;
    }

    public final boolean k() {
        if (mCacheSelfDisableInfo == null) {
            mAegisLog.i("RoomAdminProxy", "[isChatDisable] mCacheSelfDisableInfo is null");
        }
        hp4.e eVar = mCacheSelfDisableInfo;
        if (eVar != null) {
            mAegisLog.i("RoomAdminProxy", "[isChatDisable] forbidForever:" + eVar.f405866h + ", opTime:" + eVar.f405862d);
            if (!eVar.f405866h && eVar.f405862d <= System.currentTimeMillis() / 1000) {
                return false;
            }
            return true;
        }
        mAegisLog.i("RoomAdminProxy", "[isChatDisable] forbidForever");
        return false;
    }

    public final void l(boolean fromCache, long anchorUin, long uin, long roomId, @Nullable b callback) {
        hp4.d dVar;
        boolean z16;
        mAegisLog.i("RoomAdminProxy", "[isRoomAdmin] anchorUin=" + anchorUin + ",uin=" + uin + ",roomId=" + roomId + ", fromCache=" + fromCache);
        if (fromCache && (dVar = mCacheIsRoomAdminRsp) != null) {
            if (callback != null) {
                Intrinsics.checkNotNull(dVar);
                if (dVar.f405857c > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                callback.a(z16);
                return;
            }
            return;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveIsRoomAdminSvrRequest(anchorUin, uin, roomId), new d(callback, uin));
    }

    public final boolean m() {
        hp4.d dVar = mCacheIsRoomAdminRsp;
        if (dVar == null || dVar.f405857c <= 0) {
            return false;
        }
        return true;
    }

    public final void n() {
        hp4.e eVar = mCacheSelfDisableInfo;
        if (eVar != null) {
            long currentTimeMillis = eVar.f405862d - (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= 0) {
                if (eVar.f405866h) {
                    gt3.a a16 = gt3.a.INSTANCE.a();
                    String string = BaseApplication.getContext().getString(R.string.z6l);
                    Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ence_banned_chat_forever)");
                    gt3.a.b(a16, string, 0, null, 6, null);
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = BaseApplication.getContext().getString(R.string.z6m);
                Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026ience_banner_remain_time)");
                String format = String.format(string2, Arrays.copyOf(new Object[]{Long.valueOf(currentTimeMillis / 60)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                gt3.a.b(gt3.a.INSTANCE.a(), format, 0, null, 6, null);
            }
        }
    }

    public final void o(@Nullable Activity activity, @Nullable String msg2) {
        if (activity == null) {
            return;
        }
        DialogUtil.createCustomDialog(activity, 230, (String) null, msg2, activity.getString(R.string.zgi), (String) null, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: lk4.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.p(dialogInterface, i3);
            }
        }).show();
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long p16 = cVar.p();
        l(false, cVar.k(p16, 1), cVar.G(), p16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DialogInterface dialogInterface, int i3) {
    }
}
