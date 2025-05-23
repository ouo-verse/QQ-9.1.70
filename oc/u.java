package oc;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLike;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.base.n;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDoLikeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceUnLikeCallback;
import com.tencent.qqnt.kernel.nativeinterface.PADoLikeReq;
import com.tencent.qqnt.kernel.nativeinterface.PADoLikeRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAUnLikeReq;
import com.tencent.qqnt.kernel.nativeinterface.PAUnLikeRsp;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005J\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Loc/u;", "Lq9/b;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "Lbb/f;", "requestBean", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "dataCallback", "", "P1", "S1", "Landroidx/lifecycle/MutableLiveData;", "Lbb/c;", "i", "Landroidx/lifecycle/MutableLiveData;", "getCommentInfo", "()Landroidx/lifecycle/MutableLiveData;", "setCommentInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "commentInfo", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class u extends q9.b<QZAlbumxLayerExtraInfoBean> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<bb.c> commentInfo = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(long j3, final n.a dataCallback, final PADoLikeRsp pADoLikeRsp) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        mc.c.f416541a.e("doLike", System.currentTimeMillis() - j3, pADoLikeRsp != null ? pADoLikeRsp.result : -1);
        QLog.i("QZAlbumxLayerOperateViewModel", 2, "doPraiseRequest result: " + (pADoLikeRsp != null ? Integer.valueOf(pADoLikeRsp.result) : null) + ", error msg: " + (pADoLikeRsp != null ? pADoLikeRsp.errMs : null) + ", trace id:" + (pADoLikeRsp != null ? pADoLikeRsp.traceId : null));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: oc.s
            @Override // java.lang.Runnable
            public final void run() {
                u.R1(PADoLikeRsp.this, dataCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(PADoLikeRsp pADoLikeRsp, n.a dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        boolean z16 = false;
        if (pADoLikeRsp != null && pADoLikeRsp.result == 0) {
            z16 = true;
        }
        if (z16) {
            dataCallback.onSuccess(null, pADoLikeRsp.result, "", true);
        } else {
            dataCallback.onFailure(pADoLikeRsp != null ? pADoLikeRsp.result : -1L, pADoLikeRsp != null ? pADoLikeRsp.errMs : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(long j3, final n.a dataCallback, final PAUnLikeRsp pAUnLikeRsp) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        mc.c.f416541a.e("unLike", System.currentTimeMillis() - j3, pAUnLikeRsp != null ? pAUnLikeRsp.result : -1);
        QLog.i("QZAlbumxLayerOperateViewModel", 2, "doUnPraiseRequest result: " + (pAUnLikeRsp != null ? Integer.valueOf(pAUnLikeRsp.result) : null) + ", error msg: " + (pAUnLikeRsp != null ? pAUnLikeRsp.errMs : null) + ", trace id:" + (pAUnLikeRsp != null ? pAUnLikeRsp.traceId : null));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: oc.t
            @Override // java.lang.Runnable
            public final void run() {
                u.U1(PAUnLikeRsp.this, dataCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(PAUnLikeRsp pAUnLikeRsp, n.a dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        boolean z16 = false;
        if (pAUnLikeRsp != null && pAUnLikeRsp.result == 0) {
            z16 = true;
        }
        if (z16) {
            dataCallback.onSuccess(null, pAUnLikeRsp.result, "", true);
        } else {
            dataCallback.onFailure(pAUnLikeRsp != null ? pAUnLikeRsp.result : -1L, pAUnLikeRsp != null ? pAUnLikeRsp.errMs : null);
        }
    }

    public final void P1(bb.f requestBean, final n.a<CommonStLike> dataCallback) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        PADoLikeReq pADoLikeReq = new PADoLikeReq();
        pADoLikeReq.albumId = requestBean.getAlbumId();
        pADoLikeReq.mediaId = requestBean.getLLoc();
        pADoLikeReq.albumOwner.uin = requestBean.getQzoneId();
        final long currentTimeMillis = System.currentTimeMillis();
        z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.doLike(pADoLikeReq, new IPersonalAlbumServiceDoLikeCallback() { // from class: oc.r
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDoLikeCallback
                public final void onDoLike(PADoLikeRsp pADoLikeRsp) {
                    u.Q1(currentTimeMillis, dataCallback, pADoLikeRsp);
                }
            });
        }
    }

    public final void S1(bb.f requestBean, final n.a<CommonStLike> dataCallback) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        PAUnLikeReq pAUnLikeReq = new PAUnLikeReq();
        pAUnLikeReq.albumId = requestBean.getAlbumId();
        pAUnLikeReq.mediaId = requestBean.getLLoc();
        pAUnLikeReq.albumOwner.uin = requestBean.getQzoneId();
        final long currentTimeMillis = System.currentTimeMillis();
        z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.unLike(pAUnLikeReq, new IPersonalAlbumServiceUnLikeCallback() { // from class: oc.q
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceUnLikeCallback
                public final void onUnLike(PAUnLikeRsp pAUnLikeRsp) {
                    u.T1(currentTimeMillis, dataCallback, pAUnLikeRsp);
                }
            });
        }
    }
}
