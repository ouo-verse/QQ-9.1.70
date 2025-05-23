package jj4;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.audience.event.FansGroupConfigEvent;
import com.tencent.timi.game.sso.request.QQLiveFansGroupConfigRequest;
import com.tencent.timi.game.sso.request.QQLiveFansGroupInfoRequest;
import com.tencent.timi.game.sso.request.QQLiveModifyFansGroupNameRequest;
import com.tencent.trpcprotocol.qlive.TrpcFansGroupOuterClass$ModifyGroupNameRsp;
import trpc.qlive.trpc_room_global_config.TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f410285e = false;

    /* renamed from: f, reason: collision with root package name */
    private static int f410286f;

    /* renamed from: b, reason: collision with root package name */
    private long f410288b;

    /* renamed from: d, reason: collision with root package name */
    private nr4.d f410290d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f410287a = false;

    /* renamed from: c, reason: collision with root package name */
    private IAegisLogApi f410289c = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    public static boolean g() {
        return f410285e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(zi4.a aVar, QQLiveResponse qQLiveResponse) {
        if (!this.f410287a) {
            return;
        }
        TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp = (TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp != null) {
            if (trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp.retcode.get() == 0) {
                f410285e = trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp.fans_switch.get();
                f410286f = trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp.fans_min_level.get();
                SimpleEventBus.getInstance().dispatchEvent(new FansGroupConfigEvent(this.f410288b));
                aVar.success(trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp);
                this.f410289c.i("FansGroupModel", "[getFansGroupConfig] isCurRoomShowFansGroup " + f410285e + ", minShowFansLevel=" + f410286f);
                return;
            }
            this.f410289c.i("FansGroupModel", "[getFansGroupConfig] retcode=" + trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp.retcode + ", msg=" + trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp.errmsg);
            aVar.fail(trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp.retcode.get(), "");
            return;
        }
        this.f410289c.e("FansGroupModel", "[getFansGroupConfig] failed, errCode: " + qQLiveResponse.getRetCode() + ", errMsg: " + qQLiveResponse.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(zi4.a aVar, QQLiveResponse qQLiveResponse) {
        if (!this.f410287a) {
            return;
        }
        nr4.d dVar = (nr4.d) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && dVar != null) {
            this.f410290d = dVar;
            this.f410289c.i("FansGroupModel", "[getFansGroupInfo] retcode: " + dVar.f421214a + ", errMsg=" + dVar.f421215b);
            if (aVar == null) {
                return;
            }
            int i3 = dVar.f421214a;
            if (i3 == 0) {
                aVar.success(dVar);
                return;
            } else {
                aVar.fail(i3, "");
                return;
            }
        }
        this.f410289c.e("FansGroupModel", "[getFansGroupInfo] failed, errCode: " + qQLiveResponse.getRetCode() + ", errMsg: " + qQLiveResponse.getErrMsg());
        if (aVar != null) {
            aVar.fail((int) qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(zi4.a aVar, QQLiveResponse qQLiveResponse) {
        if (!this.f410287a) {
            return;
        }
        TrpcFansGroupOuterClass$ModifyGroupNameRsp trpcFansGroupOuterClass$ModifyGroupNameRsp = (TrpcFansGroupOuterClass$ModifyGroupNameRsp) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && trpcFansGroupOuterClass$ModifyGroupNameRsp != null) {
            if (trpcFansGroupOuterClass$ModifyGroupNameRsp.retcode.get() == 0) {
                aVar.success(trpcFansGroupOuterClass$ModifyGroupNameRsp);
                return;
            }
            this.f410289c.i("FansGroupModel", "[modifyGroupName] retcode: " + trpcFansGroupOuterClass$ModifyGroupNameRsp.retcode.get() + ",errmsg=" + trpcFansGroupOuterClass$ModifyGroupNameRsp.errmsg.get());
            aVar.fail(trpcFansGroupOuterClass$ModifyGroupNameRsp.retcode.get(), trpcFansGroupOuterClass$ModifyGroupNameRsp.errmsg.get());
            return;
        }
        this.f410289c.e("FansGroupModel", "[modifyGroupName] failed, errCode: " + qQLiveResponse.getRetCode() + ", errMsg: " + qQLiveResponse.getErrMsg());
        aVar.fail((int) qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg());
    }

    public void d(long j3, int i3, long j16, final zi4.a<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> aVar) {
        this.f410289c.i("FansGroupModel", "[getFansGroupConfig] anchorId=" + j3 + ",roomId=" + j16 + ",roomType=" + i3);
        this.f410288b = j16;
        if (!this.f410287a) {
            this.f410289c.e("FansGroupModel", "[getFansGroupConfig] error, not in room");
            return;
        }
        f410285e = false;
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveFansGroupConfigRequest(j3, i3), new ILiveNetRequest.Callback() { // from class: jj4.b
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                d.this.h(aVar, qQLiveResponse);
            }
        });
    }

    public void e(long j3, final zi4.a<nr4.d> aVar) {
        this.f410289c.i("FansGroupModel", "[getFansGroupInfo] anchorId: " + j3);
        if (!this.f410287a) {
            this.f410289c.e("FansGroupModel", "[getFansGroupInfo] error, not in room");
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveFansGroupInfoRequest(j3), new ILiveNetRequest.Callback() { // from class: jj4.a
                @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
                public final void onResponse(QQLiveResponse qQLiveResponse) {
                    d.this.i(aVar, qQLiveResponse);
                }
            });
        }
    }

    public void f(long j3, boolean z16, zi4.a<nr4.d> aVar) {
        nr4.d dVar = this.f410290d;
        if (dVar != null && z16) {
            if (aVar != null) {
                aVar.success(dVar);
                return;
            }
            return;
        }
        e(j3, aVar);
    }

    public void k(String str, final zi4.a<TrpcFansGroupOuterClass$ModifyGroupNameRsp> aVar) {
        this.f410289c.i("FansGroupModel", "[modifyGroupName] fansGroupName: " + str + ", isInRoom: " + this.f410287a);
        if (!this.f410287a) {
            this.f410289c.e("FansGroupModel", "[modifyGroupName] error, not in room");
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveModifyFansGroupNameRequest(str), new ILiveNetRequest.Callback() { // from class: jj4.c
                @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
                public final void onResponse(QQLiveResponse qQLiveResponse) {
                    d.this.j(aVar, qQLiveResponse);
                }
            });
        }
    }

    public void l() {
        this.f410287a = false;
    }

    public void m(IQQLiveSsoProxyModule iQQLiveSsoProxyModule) {
        this.f410287a = true;
    }
}
