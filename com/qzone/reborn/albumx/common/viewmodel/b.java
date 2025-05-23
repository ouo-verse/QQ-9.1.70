package com.qzone.reborn.albumx.common.viewmodel;

import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.kernel.nativeinterface.QunMediaRightEnum;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0014\u001a\u0004\u0018\u00010\bJ\b\u0010\u0015\u001a\u00020\u0004H\u0016J8\u0010 \u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0018H&R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R)\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160!0(0'8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0'8\u0006\u00a2\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0'8\u0006\u00a2\u0006\f\n\u0004\b:\u0010*\u001a\u0004\b;\u0010,R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0'8\u0006\u00a2\u0006\f\n\u0004\b=\u0010*\u001a\u0004\b>\u0010,R-\u0010D\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180@j\b\u0012\u0004\u0012\u00020\u0018`A0'8\u0006\u00a2\u0006\f\n\u0004\bB\u0010*\u001a\u0004\bC\u0010,\u00a8\u0006G"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/b;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", "", "e2", "g2", "d2", "", "getLogTag", "U1", "", "W1", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "S1", SemanticAttributes.DbSystemValues.H2, "f2", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "b2", "Q1", "R1", "c2", "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "", "batchPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "transCreatorKey", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "i", "Ljava/util/List;", "N1", "()Ljava/util/List;", "allBatch", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "batchListData", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", BdhLogUtil.LogTag.Tag_Conn, "M1", "albumInfoData", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "D", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "P1", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "setCommonExt", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;)V", "commonExt", "E", "X1", "isMemberData", UserInfo.SEX_FEMALE, "Z1", "isNormalUpload", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "G", "T1", "rightListChange", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class b extends com.qzone.reborn.base.n {

    /* renamed from: D, reason: from kotlin metadata */
    private CommonStCommonExt commonExt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<com.qzone.reborn.albumx.common.bean.a> allBatch = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>> batchListData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<CommonAlbumInfo> albumInfoData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isMemberData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isNormalUpload = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<ArrayList<Integer>> rightListChange = new MutableLiveData<>();

    private final void d2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        if (repoBean.getAlbumInfoData() == null) {
            return;
        }
        this.albumInfoData.setValue(repoBean.getAlbumInfoData());
    }

    private final void e2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        this.allBatch.clear();
        this.allBatch.addAll(repoBean.b());
        if (bl.b(repoBean.b())) {
            this.batchListData.setValue(UIStateData.obtainEmpty().setRetCode(repoBean.getRetCode()).setLoadMore(repoBean.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()));
        } else {
            this.batchListData.setValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(repoBean.getErrMsg())).setData(repoBean.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), repoBean.b()).setFinish(S1().isFinish()).setUpTurning(S1().canPageUp()));
        }
    }

    private final void g2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        CommonAlbumCommData commData = repoBean.getCommData();
        if (commData != null) {
            this.isMemberData.setValue(Boolean.valueOf(commData.getIsMember()));
        }
    }

    public final MutableLiveData<CommonAlbumInfo> M1() {
        return this.albumInfoData;
    }

    public final List<com.qzone.reborn.albumx.common.bean.a> N1() {
        return this.allBatch;
    }

    public final MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>> O1() {
        return this.batchListData;
    }

    /* renamed from: P1, reason: from getter */
    public final CommonStCommonExt getCommonExt() {
        return this.commonExt;
    }

    public String Q1() {
        ArrayList<Integer> value = this.rightListChange.getValue();
        if (!(value == null || value.isEmpty())) {
            ArrayList<Integer> value2 = this.rightListChange.getValue();
            Intrinsics.checkNotNull(value2);
            if (value2.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMUPLOADMEDIA.ordinal()))) {
                return com.qzone.util.l.a(R.string.f132974v);
            }
        }
        return com.qzone.util.l.a(R.string.f132964u);
    }

    public abstract LoadInfo S1();

    public final MutableLiveData<ArrayList<Integer>> T1() {
        return this.rightListChange;
    }

    public final void U1(com.qzone.reborn.albumx.common.bean.b repoBean) {
        Intrinsics.checkNotNullParameter(repoBean, "repoBean");
        if (repoBean.getIsInformLayerOnly()) {
            return;
        }
        f2(repoBean);
        h2(repoBean);
        e2(repoBean);
        d2(repoBean);
        this.commonExt = repoBean.getCommonExt();
        g2(repoBean);
    }

    public final boolean W1() {
        return this.allBatch.isEmpty();
    }

    public final MutableLiveData<Boolean> X1() {
        return this.isMemberData;
    }

    public final MutableLiveData<Boolean> Z1() {
        return this.isNormalUpload;
    }

    public abstract void a2(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view, int transCreatorKey);

    public abstract void b2(boolean isLoadMore);

    protected final void f2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        Intrinsics.checkNotNullParameter(repoBean, "repoBean");
        CommonAlbumCommData commData = repoBean.getCommData();
        if (commData != null) {
            this.rightListChange.setValue(commData.c());
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "CommonAlbumDetailViewModel";
    }

    protected final void h2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        Intrinsics.checkNotNullParameter(repoBean, "repoBean");
        CommonAlbumCommData commData = repoBean.getCommData();
        if (commData != null) {
            this.isNormalUpload.setValue(Boolean.valueOf(commData.getNormalUpLoad()));
        }
    }

    public final String R1() {
        return com.qzone.util.l.a(R.string.f133596j);
    }

    public void c2() {
    }
}
