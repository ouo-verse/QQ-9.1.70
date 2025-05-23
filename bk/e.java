package bk;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.intimate.event.QZoneIntimateDeleteMediaEvent;
import com.qzone.reborn.intimate.request.QZoneIntimateDeleteMediaRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$DeleteMediasRsp;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ0\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J2\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J0\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000bJ\u001e\u0010\u001a\u001a\u00020\u00072\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0002j\b\u0012\u0004\u0012\u00020\u0019`\u0004J\u001e\u0010\u001b\u001a\u00020\u00072\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0002j\b\u0012\u0004\u0012\u00020\u0019`\u0004J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u001f"}, d2 = {"Lbk/e;", "", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "b", "", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/QZIntimateSpaceAlbum$DeleteMediasRsp;", "rsp", "Lsj/e;", "requestBean", "", "c", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "req", "g", "uid", "f", "Lqzone/QZoneBaseMeta$StMedia;", "e", "d", tl.h.F, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f28497a = new e();

    e() {
    }

    private final void g(String msg2, boolean isSuccess, BaseRequest req, long retCode, String errMsg) {
        QLog.i("QZIntimateAlbumDetailRepo", 1, msg2 + " responseLog onReceive, isSuccess: " + isSuccess + " | traceId: " + req.getTraceId() + " | seqId:" + req.getCurrentSeq() + " | cmdName:" + req.getCmdName() + " | retCode:" + retCode + " | retMessage:" + errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(sj.e requestBean, BaseRequest request, boolean z16, long j3, String errMsg, QZIntimateSpaceAlbum$DeleteMediasRsp qZIntimateSpaceAlbum$DeleteMediasRsp) {
        Intrinsics.checkNotNullParameter(requestBean, "$requestBean");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        e eVar = f28497a;
        eVar.g("[GetMediasListByOneReq]", z16, request, j3, errMsg);
        eVar.c(z16, j3, errMsg, qZIntimateSpaceAlbum$DeleteMediasRsp, requestBean);
    }

    public final boolean d(ArrayList<QZoneBaseMeta$StMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<QZoneBaseMeta$StMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            String str = it.next().uploader.get();
            Intrinsics.checkNotNullExpressionValue(str, "media.uploader.get()");
            if (f(str)) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(ArrayList<QZoneBaseMeta$StMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<QZoneBaseMeta$StMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            String str = it.next().uploader.get();
            Intrinsics.checkNotNullExpressionValue(str, "media.uploader.get()");
            if (!f(str)) {
                return false;
            }
        }
        return true;
    }

    public final boolean f(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        return TextUtils.equals(uid, LoginData.getInstance().getUid());
    }

    public final void h(final sj.e requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        requestBean.g(b(requestBean.c()));
        VSNetworkHelper.getInstance().sendRequest(new QZoneIntimateDeleteMediaRequest(requestBean), new VSDispatchObserver.OnVSRspCallBack() { // from class: bk.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                e.i(sj.e.this, baseRequest, z16, j3, str, (QZIntimateSpaceAlbum$DeleteMediasRsp) obj);
            }
        });
    }

    private final ArrayList<CommonStMedia> b(ArrayList<CommonStMedia> mediaList) {
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return mediaList;
        }
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia next = it.next();
            String str = next.getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String();
            if (str == null) {
                str = "";
            }
            if (f(str)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private final void c(boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceAlbum$DeleteMediasRsp rsp, sj.e requestBean) {
        if (isSuccess && rsp != null && retCode == 0) {
            if (requestBean.getScene() == 1) {
                SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateDeleteMediaEvent(requestBean));
            } else {
                vj.c dataRepo = requestBean.getDataRepo();
                if (dataRepo != null) {
                    ArrayList<QZoneBaseMeta$StMedia> g16 = xh.e.g(requestBean.c());
                    String spaceId = requestBean.getSpaceId();
                    if (spaceId == null) {
                        spaceId = "";
                    }
                    dataRepo.r(g16, spaceId);
                }
            }
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f1334162, 0).show();
            return;
        }
        RFWLog.e("QZoneIntimateDeleteMediaRepo", RFWLog.USR, "handleDeleteMediaResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1334061, 0).show();
    }
}
