package cb;

import androidx.exifinterface.media.ExifInterface;
import bb.i;
import com.qzone.reborn.albumx.common.convert.bean.CommonPageEndMsg;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.TimeLineBindingType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bV\u0010WJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0005R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR(\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00102\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R(\u00106\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010*\u001a\u0004\b4\u0010,\"\u0004\b5\u0010.R\"\u00109\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010!\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R\"\u0010<\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R\"\u0010@\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010!\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\"\u0010F\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010L\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010H\u001a\u0004\b3\u0010I\"\u0004\bJ\u0010KR\"\u0010R\u001a\u00020M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010N\u001a\u0004\b=\u0010O\"\u0004\bP\u0010QR\"\u0010U\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010A\u001a\u0004\bS\u0010C\"\u0004\bT\u0010E\u00a8\u0006X"}, d2 = {"Lcb/a;", "", "", "Lcb/b;", "curMediaList", "", ReportConstant.COSTREPORT_PREFIX, "curTitleNode", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "photoInfo", "", "o", "", "titleTime", "mediaTime", "a", "Lkotlin/Pair;", "", h.F, "c", "index", "b", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", "Ljava/lang/String;", "getQzoneId", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/String;)V", "qzoneId", "I", "k", "()I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)V", "result", "e", "t", "errMsg", "Ljava/util/List;", "g", "()Ljava/util/List;", "setMediaList", "(Ljava/util/List;)V", "mediaList", "getServerMediaList", "B", "serverMediaList", "f", "l", BdhLogUtil.LogTag.Tag_Conn, "timelineList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "videoNum", "j", "y", "photoNum", "i", "getUpdateType", "D", "updateType", "Z", DomainData.DOMAIN_NAME, "()Z", "u", "(Z)V", "isInformLayerOnly", "Lbb/i;", "Lbb/i;", "()Lbb/i;", "v", "(Lbb/i;)V", "layerListBean", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", HippyTKDListViewAdapter.X, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;)V", "pageEndMsg", "p", "w", "isNeedScrollToFirst", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int videoNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int photoNum;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isInformLayerOnly;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedScrollToFirst;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String qzoneId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int result = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String errMsg = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<b> mediaList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<CommonPhotoInfo> serverMediaList = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<CommonStTimeLineEvent> timelineList = new ArrayList();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int updateType = 1;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private i layerListBean = new i();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private CommonPageEndMsg pageEndMsg = new CommonPageEndMsg();

    private final boolean a(long titleTime, long mediaTime) {
        Pair<Integer, Integer> h16 = h(titleTime);
        Pair<Integer, Integer> h17 = h(mediaTime);
        return h16.getFirst().intValue() == h17.getFirst().intValue() && h16.getSecond().intValue() == h17.getSecond().intValue();
    }

    private final b b(CommonPhotoInfo photoInfo, int index) {
        b bVar = new b();
        bVar.k(photoInfo.getMedia().u() ? 3 : 2);
        bVar.i(photoInfo.getMedia().getUploadTime());
        bVar.m(photoInfo.getMedia().m());
        bVar.l(photoInfo);
        bVar.n(index);
        bVar.j(d(photoInfo));
        return bVar;
    }

    private final b c(CommonPhotoInfo photoInfo) {
        b bVar = new b();
        bVar.k(1);
        bVar.i(photoInfo.getMedia().getUploadTime());
        bVar.j(d(photoInfo));
        return bVar;
    }

    private final CommonStTimeLineEvent d(CommonPhotoInfo photoInfo) {
        long uploadTime = photoInfo.getMedia().getUploadTime();
        long shootTime = photoInfo.getMedia().getShootTime();
        List<CommonStTimeLineEvent> list = this.timelineList;
        CommonStTimeLineEvent commonStTimeLineEvent = null;
        if (list != null) {
            for (CommonStTimeLineEvent commonStTimeLineEvent2 : list) {
                long j3 = commonStTimeLineEvent2.getBindingType() == TimeLineBindingType.KTIMELINEBINDINGMEDIASHOOTTIME.ordinal() ? shootTime : uploadTime;
                if (commonStTimeLineEvent2.getBeginTime() <= j3 && commonStTimeLineEvent2.getEndTime() > j3) {
                    commonStTimeLineEvent = commonStTimeLineEvent2;
                }
            }
        }
        return commonStTimeLineEvent;
    }

    private final Pair<Integer, Integer> h(long titleTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(titleTime * 1000);
        return new Pair<>(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1));
    }

    private final void s(List<b> curMediaList) {
        int size = curMediaList.size();
        Iterator<T> it = curMediaList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).h(size);
        }
    }

    public final void A(int i3) {
        this.result = i3;
    }

    public final void B(List<CommonPhotoInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.serverMediaList = list;
    }

    public final void C(List<CommonStTimeLineEvent> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.timelineList = list;
    }

    public final void D(int i3) {
        this.updateType = i3;
    }

    public final void E(int i3) {
        this.videoNum = i3;
    }

    /* renamed from: e, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: f, reason: from getter */
    public final i getLayerListBean() {
        return this.layerListBean;
    }

    public final List<b> g() {
        return this.mediaList;
    }

    /* renamed from: i, reason: from getter */
    public final CommonPageEndMsg getPageEndMsg() {
        return this.pageEndMsg;
    }

    /* renamed from: j, reason: from getter */
    public final int getPhotoNum() {
        return this.photoNum;
    }

    /* renamed from: k, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    public final List<CommonStTimeLineEvent> l() {
        return this.timelineList;
    }

    /* renamed from: m, reason: from getter */
    public final int getVideoNum() {
        return this.videoNum;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsInformLayerOnly() {
        return this.isInformLayerOnly;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsNeedScrollToFirst() {
        return this.isNeedScrollToFirst;
    }

    public final boolean q() {
        return this.updateType == 1;
    }

    public final void r() {
        ArrayList arrayList = new ArrayList();
        this.mediaList.clear();
        b bVar = null;
        int i3 = 0;
        for (CommonPhotoInfo commonPhotoInfo : this.serverMediaList) {
            if (o(bVar, commonPhotoInfo)) {
                bVar = c(commonPhotoInfo);
                this.mediaList.add(bVar);
                s(arrayList);
                arrayList.clear();
                i3 = 0;
            }
            b b16 = b(commonPhotoInfo, i3);
            this.mediaList.add(b16);
            arrayList.add(b16);
            i3++;
        }
        if (arrayList.size() > 0) {
            s(arrayList);
        }
    }

    public final void t(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    public final void u(boolean z16) {
        this.isInformLayerOnly = z16;
    }

    public final void v(i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<set-?>");
        this.layerListBean = iVar;
    }

    public final void w(boolean z16) {
        this.isNeedScrollToFirst = z16;
    }

    public final void x(CommonPageEndMsg commonPageEndMsg) {
        Intrinsics.checkNotNullParameter(commonPageEndMsg, "<set-?>");
        this.pageEndMsg = commonPageEndMsg;
    }

    public final void y(int i3) {
        this.photoNum = i3;
    }

    public final void z(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qzoneId = str;
    }

    private final boolean o(b curTitleNode, CommonPhotoInfo photoInfo) {
        if (curTitleNode == null) {
            return true;
        }
        return !a(curTitleNode.getCurTimeStamp(), photoInfo.getMedia().getUploadTime());
    }
}
