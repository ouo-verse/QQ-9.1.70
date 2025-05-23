package com.qzone.reborn.albumx.common.bean;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bF\u0010GR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b/\u00101\"\u0004\b2\u00103R\"\u00108\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010(\u001a\u0004\b6\u0010*\"\u0004\b7\u0010,R\"\u0010>\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010:\u001a\u0004\b5\u0010;\"\u0004\b<\u0010=R6\u0010E\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u00010?j\n\u0012\u0004\u0012\u000209\u0018\u0001`@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010A\u001a\u0004\b'\u0010B\"\u0004\bC\u0010D\u00a8\u0006H"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/b;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "c", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;)V", "commData", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "b", "Ljava/util/List;", "()Ljava/util/List;", "l", "(Ljava/util/List;)V", "allBatch", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "k", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "albumInfoData", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "d", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", DomainData.DOMAIN_NAME, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;)V", "commonExt", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "errMsg", "", "f", "Z", "j", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "g", "J", "()J", ReportConstant.COSTREPORT_PREFIX, "(J)V", "retCode", tl.h.F, "i", "p", "isInformLayerOnly", "", "I", "()I", "t", "(I)V", "rightBoundIndex", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "r", "(Ljava/util/ArrayList;)V", "opmask", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumCommData commData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumInfo albumInfoData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonStCommonExt commonExt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadMore;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long retCode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isInformLayerOnly;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int rightBoundIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Integer> opmask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<a> allBatch = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String errMsg = "";

    /* renamed from: a, reason: from getter */
    public final CommonAlbumInfo getAlbumInfoData() {
        return this.albumInfoData;
    }

    public final List<a> b() {
        return this.allBatch;
    }

    /* renamed from: c, reason: from getter */
    public final CommonAlbumCommData getCommData() {
        return this.commData;
    }

    /* renamed from: d, reason: from getter */
    public final CommonStCommonExt getCommonExt() {
        return this.commonExt;
    }

    /* renamed from: e, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    public final ArrayList<Integer> f() {
        return this.opmask;
    }

    /* renamed from: g, reason: from getter */
    public final long getRetCode() {
        return this.retCode;
    }

    /* renamed from: h, reason: from getter */
    public final int getRightBoundIndex() {
        return this.rightBoundIndex;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsInformLayerOnly() {
        return this.isInformLayerOnly;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsLoadMore() {
        return this.isLoadMore;
    }

    public final void k(CommonAlbumInfo commonAlbumInfo) {
        this.albumInfoData = commonAlbumInfo;
    }

    public final void l(List<a> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.allBatch = list;
    }

    public final void m(CommonAlbumCommData commonAlbumCommData) {
        this.commData = commonAlbumCommData;
    }

    public final void n(CommonStCommonExt commonStCommonExt) {
        this.commonExt = commonStCommonExt;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    public final void p(boolean z16) {
        this.isInformLayerOnly = z16;
    }

    public final void q(boolean z16) {
        this.isLoadMore = z16;
    }

    public final void r(ArrayList<Integer> arrayList) {
        this.opmask = arrayList;
    }

    public final void s(long j3) {
        this.retCode = j3;
    }

    public final void t(int i3) {
        this.rightBoundIndex = i3;
    }
}
