package oc;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetShareInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAGetShareInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetShareInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.ShareScene;
import com.tencent.qqnt.kernel.nativeinterface.StShare;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ub.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Loc/e;", "Loc/a;", "Lbb/d;", "", "f2", "g2", "removeListener", "Lbb/g;", "requestBean", "U1", "", "lloc", "", "commentNum", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "bean", SemanticAttributes.DbSystemValues.H2, "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "J", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "e2", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "l2", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;)V", "initBean", "Lub/k;", "K", "Lub/k;", "d2", "()Lub/k;", "k2", "(Lub/k;)V", "dataRepo", "Lub/k$b;", "L", "Lub/k$b;", "getListener", "()Lub/k$b;", "listener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends oc.a<bb.d> {

    /* renamed from: J, reason: from kotlin metadata */
    public QZAlbumxAlbumDetailInitBean initBean;

    /* renamed from: K, reason: from kotlin metadata */
    private ub.k dataRepo;

    /* renamed from: L, reason: from kotlin metadata */
    private final k.b listener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"oc/e$a", "Lub/k$b;", "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements k.b {
        a() {
        }

        @Override // ub.k.b
        public void a(com.qzone.reborn.albumx.common.bean.b repoBean) {
            ArrayList<Integer> c16;
            Intrinsics.checkNotNullParameter(repoBean, "repoBean");
            if (repoBean instanceof bb.b) {
                e.this.T1().clear();
                CommonAlbumCommData commData = repoBean.getCommData();
                if (commData != null && (c16 = commData.c()) != null) {
                    e.this.T1().addAll(c16);
                }
                e.this.M1().postValue(UIStateData.obtainSuccess(false).setDataList(((bb.b) repoBean).getLayerListBean()));
            }
        }
    }

    private final void f2() {
        ub.k kVar = this.dataRepo;
        if (kVar != null) {
            kVar.z(e2());
        }
        g2();
    }

    private final void g2() {
        ub.k kVar = this.dataRepo;
        if (kVar != null) {
            kVar.I(e2().getAlbumId(), this.listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(long j3, final QZAlbumxLayerExtraInfoBean bean, final PAGetShareInfoRsp pAGetShareInfoRsp) {
        Intrinsics.checkNotNullParameter(bean, "$bean");
        mc.c.f416541a.e("getShareInfo", System.currentTimeMillis() - j3, pAGetShareInfoRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: oc.d
            @Override // java.lang.Runnable
            public final void run() {
                e.j2(PAGetShareInfoRsp.this, bean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(PAGetShareInfoRsp pAGetShareInfoRsp, QZAlbumxLayerExtraInfoBean bean) {
        Intrinsics.checkNotNullParameter(bean, "$bean");
        int i3 = pAGetShareInfoRsp.result;
        if (i3 == 0) {
            StShare stShare = pAGetShareInfoRsp.share;
            Intrinsics.checkNotNullExpressionValue(stShare, "it.share");
            bean.a0(fb.a.s(stShare));
            return;
        }
        QLog.d("QZAlbumxBaseLayerDataViewModel", 1, "requestShareInfo result:" + i3 + ", errMsg:" + pAGetShareInfoRsp.errMs);
    }

    @Override // oc.a
    public void U1(bb.g requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (getLoadInfo().getCurrentState() != 4) {
            return;
        }
        f2();
        ub.k kVar = this.dataRepo;
        if (kVar != null) {
            kVar.R(requestBean);
        }
    }

    @Override // oc.a
    public void a2(String lloc, int commentNum) {
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        ub.k kVar = this.dataRepo;
        if (kVar != null) {
            Iterator<T> it = kVar.s().iterator();
            while (it.hasNext()) {
                for (CommonStMedia commonStMedia : ((com.qzone.reborn.albumx.common.bean.a) it.next()).getBatchInfo().j()) {
                    if (Intrinsics.areEqual(commonStMedia.k(), lloc)) {
                        commonStMedia.getComment().b(commentNum);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: d2, reason: from getter */
    public final ub.k getDataRepo() {
        return this.dataRepo;
    }

    public final QZAlbumxAlbumDetailInitBean e2() {
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        if (qZAlbumxAlbumDetailInitBean != null) {
            return qZAlbumxAlbumDetailInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final void h2(final QZAlbumxLayerExtraInfoBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        PAGetShareInfoReq pAGetShareInfoReq = new PAGetShareInfoReq();
        if (bean.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            pAGetShareInfoReq.vid = bean.getVideoId();
            pAGetShareInfoReq.scene = ShareScene.KSHARESCENEVIDEO.ordinal();
        } else {
            pAGetShareInfoReq.scene = ShareScene.KSHARESCENEPIC.ordinal();
        }
        pAGetShareInfoReq.lloc = bean.getLLoc();
        pAGetShareInfoReq.albumId = bean.getAlbumId();
        pAGetShareInfoReq.owner.uin = bean.getUploadUid();
        final long currentTimeMillis = System.currentTimeMillis();
        z Q1 = Q1();
        if (Q1 != null) {
            Q1.getShareInfo(pAGetShareInfoReq, new IPersonalAlbumServiceGetShareInfoCallback() { // from class: oc.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetShareInfoCallback
                public final void onGetShareInfo(PAGetShareInfoRsp pAGetShareInfoRsp) {
                    e.i2(currentTimeMillis, bean, pAGetShareInfoRsp);
                }
            });
        }
    }

    public final void k2(ub.k kVar) {
        this.dataRepo = kVar;
    }

    public final void l2(QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean) {
        Intrinsics.checkNotNullParameter(qZAlbumxAlbumDetailInitBean, "<set-?>");
        this.initBean = qZAlbumxAlbumDetailInitBean;
    }

    public final void removeListener() {
        ub.k kVar = this.dataRepo;
        if (kVar != null) {
            kVar.V(e2().getAlbumId(), this.listener);
        }
    }
}
