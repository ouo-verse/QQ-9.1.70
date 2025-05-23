package bb;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsAreaList;
import com.qzone.reborn.albumx.common.convert.bean.CommonPageEndMsg;
import com.qzone.reborn.albumx.common.convert.bean.CommonRecommendMedia;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u00103R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lbb/b;", "Lcom/qzone/reborn/albumx/common/bean/b;", "Lbb/d;", "k", "Lbb/d;", "u", "()Lbb/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lbb/d;)V", "layerListBean", "", "l", "I", "getRequestType", "()I", "E", "(I)V", "requestType", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", "w", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;)V", "pageEndMsg", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", DomainData.DOMAIN_NAME, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "v", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "B", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;)V", "mediaLbsAreaList", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonRecommendMedia;", "o", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonRecommendMedia;", HippyTKDListViewAdapter.X, "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonRecommendMedia;", "D", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonRecommendMedia;)V", "recommendMedia", "", "p", "Z", "y", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Z)V", "isFromCache", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends com.qzone.reborn.albumx.common.bean.b {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private d layerListBean = new d();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int requestType = 1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private CommonPageEndMsg pageEndMsg = new CommonPageEndMsg();

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private CommonMediaLbsAreaList mediaLbsAreaList;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private CommonRecommendMedia recommendMedia;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isFromCache;

    public final void A(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.layerListBean = dVar;
    }

    public final void B(CommonMediaLbsAreaList commonMediaLbsAreaList) {
        this.mediaLbsAreaList = commonMediaLbsAreaList;
    }

    public final void C(CommonPageEndMsg commonPageEndMsg) {
        Intrinsics.checkNotNullParameter(commonPageEndMsg, "<set-?>");
        this.pageEndMsg = commonPageEndMsg;
    }

    public final void D(CommonRecommendMedia commonRecommendMedia) {
        this.recommendMedia = commonRecommendMedia;
    }

    public final void E(int i3) {
        this.requestType = i3;
    }

    /* renamed from: u, reason: from getter */
    public final d getLayerListBean() {
        return this.layerListBean;
    }

    /* renamed from: v, reason: from getter */
    public final CommonMediaLbsAreaList getMediaLbsAreaList() {
        return this.mediaLbsAreaList;
    }

    /* renamed from: w, reason: from getter */
    public final CommonPageEndMsg getPageEndMsg() {
        return this.pageEndMsg;
    }

    /* renamed from: x, reason: from getter */
    public final CommonRecommendMedia getRecommendMedia() {
        return this.recommendMedia;
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsFromCache() {
        return this.isFromCache;
    }

    public final void z(boolean z16) {
        this.isFromCache = z16;
    }
}
