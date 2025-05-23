package bw0;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.sso.request.QQLiveFansGroupInfoRequest;
import com.tencent.icgame.game.sso.request.QQLiveRecordFansGroupShow;
import com.tencent.icgame.trpc.qlive.trpc_room_global_config.TrpcRoomGlobalConfigOuterClass$RecordFansGroupRsp;
import com.tencent.icgame.trpcprotocol.qlive.TrpcFansGroupOuterClass$GetFansGroupInfoRsp;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import yv0.e;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f29292d = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f29293a = false;

    /* renamed from: b, reason: collision with root package name */
    private IAegisLogApi f29294b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: c, reason: collision with root package name */
    private TrpcFansGroupOuterClass$GetFansGroupInfoRsp f29295c;

    public static boolean d() {
        return f29292d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(e eVar, QQLiveResponse qQLiveResponse) {
        if (!this.f29293a) {
            return;
        }
        TrpcFansGroupOuterClass$GetFansGroupInfoRsp trpcFansGroupOuterClass$GetFansGroupInfoRsp = (TrpcFansGroupOuterClass$GetFansGroupInfoRsp) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && trpcFansGroupOuterClass$GetFansGroupInfoRsp != null) {
            this.f29295c = trpcFansGroupOuterClass$GetFansGroupInfoRsp;
            this.f29294b.i("ICGameFansGroupModel", "[getFansGroupInfo] retcode: " + trpcFansGroupOuterClass$GetFansGroupInfoRsp.retcode.get() + ", errMsg=" + trpcFansGroupOuterClass$GetFansGroupInfoRsp.errmsg.get());
            if (eVar == null) {
                return;
            }
            if (trpcFansGroupOuterClass$GetFansGroupInfoRsp.retcode.get() == 0) {
                eVar.success(trpcFansGroupOuterClass$GetFansGroupInfoRsp);
                return;
            } else {
                eVar.fail(trpcFansGroupOuterClass$GetFansGroupInfoRsp.retcode.get(), "");
                return;
            }
        }
        this.f29294b.e("ICGameFansGroupModel", "[getFansGroupInfo] failed, errCode: " + qQLiveResponse.getRetCode() + ", errMsg: " + qQLiveResponse.getErrMsg());
        if (eVar != null) {
            eVar.fail((int) qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(QQLiveResponse qQLiveResponse) {
        TrpcRoomGlobalConfigOuterClass$RecordFansGroupRsp trpcRoomGlobalConfigOuterClass$RecordFansGroupRsp = (TrpcRoomGlobalConfigOuterClass$RecordFansGroupRsp) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && trpcRoomGlobalConfigOuterClass$RecordFansGroupRsp != null) {
            this.f29294b.i("ICGameFansGroupModel", "[recordFansGroupShow] retcode: " + trpcRoomGlobalConfigOuterClass$RecordFansGroupRsp.retcode.get() + ",errmsg=" + trpcRoomGlobalConfigOuterClass$RecordFansGroupRsp.errmsg.get());
            return;
        }
        this.f29294b.e("ICGameFansGroupModel", "[recordFansGroupShow] failed, errCode: " + qQLiveResponse.getRetCode() + ", errMsg: " + qQLiveResponse.getErrMsg());
    }

    public void c(long j3, final e<TrpcFansGroupOuterClass$GetFansGroupInfoRsp> eVar) {
        this.f29294b.i("ICGameFansGroupModel", "[getFansGroupInfo] anchorId: " + j3);
        if (!this.f29293a) {
            this.f29294b.e("ICGameFansGroupModel", "[getFansGroupInfo] error, not in room");
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveFansGroupInfoRequest(j3), new ILiveNetRequest.Callback() { // from class: bw0.a
                @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
                public final void onResponse(QQLiveResponse qQLiveResponse) {
                    c.this.e(eVar, qQLiveResponse);
                }
            });
        }
    }

    public void g() {
        this.f29293a = false;
    }

    public void h(long j3) {
        this.f29294b.i("ICGameFansGroupModel", "recordFansGroupShow error, anchorId: " + j3 + ", isInRoom: " + this.f29293a);
        if (!this.f29293a) {
            this.f29294b.e("ICGameFansGroupModel", "[recordFansGroupShow] error, not in room");
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveRecordFansGroupShow(j3), new ILiveNetRequest.Callback() { // from class: bw0.b
                @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
                public final void onResponse(QQLiveResponse qQLiveResponse) {
                    c.this.f(qQLiveResponse);
                }
            });
        }
    }

    public void i(IQQLiveSsoProxyModule iQQLiveSsoProxyModule) {
        this.f29293a = true;
    }
}
