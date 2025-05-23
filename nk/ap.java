package nk;

import android.app.Activity;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumResult;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumType;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateEditTextInitBean;
import com.qzone.reborn.intimate.event.QZoneIntimateEditAlbumEvent;
import com.qzone.reborn.intimate.request.QZoneIntimateDeleteAlbumRequest;
import com.qzone.reborn.intimate.request.QZoneIntimateModifyAlbumRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0006\u0010\u0019\u001a\u00020\u0007\u00a8\u0006\u001e"}, d2 = {"Lnk/ap;", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "", "", "maskList", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "albumInfo", "", ICustomDataEditor.NUMBER_PARAM_2, QZoneOptAlbumRequest.FIELD_CMD_EDIT, "deleteAlbum", "i2", "Lkotlin/Pair;", SemanticAttributes.DbSystemValues.H2, "l2", "", "getLogTag", "", "W1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "Z1", "X1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "k2", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ap extends com.qzone.reborn.albumx.common.viewmodel.c {
    private final Pair<List<Integer>, QZoneBaseAlbumMeta$AlbumInfo> h2() {
        CommonAlbumEditInitBean value = Q1().getValue();
        RFWLog.i("QZoneIntimateEditAlbumViewModel", RFWLog.DEV, "checkEdited, initBean:" + O1() + ", currentValue:" + value);
        if (value == null || Intrinsics.areEqual(O1(), value)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CommonAlbumInfo albumInfo = value.getAlbumInfo();
        if (!Intrinsics.areEqual(O1().getAlbumName(), value.getAlbumName())) {
            arrayList.add(1);
            albumInfo.m0(value.getAlbumName());
        }
        if (!Intrinsics.areEqual(O1().getAlbumDesc(), value.getAlbumDesc())) {
            arrayList.add(2);
            albumInfo.g0(value.getAlbumDesc());
        }
        if (!Intrinsics.areEqual(k9.a.e(O1().getAlbumCover(), 0, 1, null), k9.a.e(value.getAlbumCover(), 0, 1, null))) {
            arrayList.add(3);
            albumInfo.b0(value.getAlbumCover());
        }
        if (O1().isStickTop() != value.isStickTop()) {
            arrayList.add(4);
            albumInfo.w0(value.isStickTop() ? 1L : 0L);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Pair<>(arrayList, xh.e.f(albumInfo));
    }

    private final void i2(QZoneBaseAlbumMeta$AlbumInfo editAlbum, QZoneBaseAlbumMeta$AlbumInfo deleteAlbum) {
        SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateEditAlbumEvent(O1().getBizId(), deleteAlbum, editAlbum, null, 8, null));
    }

    private final void l2() {
        RFWLog.i("QZoneIntimateEditAlbumViewModel", RFWLog.USR, "sendDeleteAlbumReq ");
        VSNetworkHelper.getInstance().sendRequest(new QZoneIntimateDeleteAlbumRequest(O1().getBizId(), O1().getAlbumId()), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.ao
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                ap.m2(ap.this, baseRequest, z16, j3, str, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(ap this$0, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.i("QZoneIntimateEditAlbumViewModel", RFWLog.USR, "sendDeleteAlbumReq, onReceive, traceId:" + (baseRequest != null ? baseRequest.getTraceId() : null) + ", isSuccess:" + z16 + ", retCode:" + j3 + ", errMsg:" + str + ", rsp:" + obj);
        this$0.S1().postValue(Boolean.FALSE);
        if (z16 && j3 == 0 && obj != null) {
            this$0.R1().postValue(new EditAlbumResult(true, EditAlbumType.DELETE, this$0.O1().getAlbumInfo(), null, 8, null));
            j2(this$0, null, xh.e.f(this$0.O1().getAlbumInfo()), 1, null);
        } else {
            this$0.R1().postValue(new EditAlbumResult(false, EditAlbumType.DELETE, this$0.O1().getAlbumInfo(), null, 8, null));
        }
    }

    private final void n2(List<Integer> maskList, final QZoneBaseAlbumMeta$AlbumInfo albumInfo) {
        RFWLog.i("QZoneIntimateEditAlbumViewModel", RFWLog.USR, "sendEditAlbumReq, maskList:" + maskList);
        VSNetworkHelper.getInstance().sendRequest(new QZoneIntimateModifyAlbumRequest(albumInfo, maskList), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.an
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                ap.o2(ap.this, albumInfo, baseRequest, z16, j3, str, obj);
            }
        });
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public boolean W1() {
        Pair<List<Integer>, QZoneBaseAlbumMeta$AlbumInfo> h26 = h2();
        if (h26 == null) {
            return false;
        }
        S1().postValue(Boolean.TRUE);
        n2(h26.getFirst(), h26.getSecond());
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public void X1(Activity activity, int requestCode) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        ck.c o16 = ho.i.o();
        String a16 = com.qzone.util.l.a(R.string.f133957i);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_albumx_album_desc_text)");
        CommonAlbumEditInitBean value = M1().getValue();
        if (value == null || (str = value.getAlbumDesc()) == null) {
            str = "";
        }
        String a17 = com.qzone.util.l.a(R.string.f133947h);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_albumx_album_desc_hint)");
        o16.o(activity, requestCode, new QZoneIntimateEditTextInitBean(a16, str, 50, a17, true, true, "pg_qz_album_description_edit"));
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public void Z1(Activity activity, int requestCode) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        ck.c o16 = ho.i.o();
        CommonAlbumEditInitBean value = M1().getValue();
        if (value == null || (str = value.getAlbumName()) == null) {
            str = "";
        }
        o16.o(activity, requestCode, new QZoneIntimateEditTextInitBean("\u76f8\u518c\u540d", str, 15, "\u8f93\u5165\u76f8\u518c\u540d", false, false, "pg_qz_album_name_edit", 48, null));
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public void a2(Activity activity, int requestCode) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        ck.c o16 = ho.i.o();
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
        qZoneIntimateAlbumDetailInitBean.setSpaceId(O1().getBizId());
        CommonAlbumEditInitBean value = M1().getValue();
        if (value == null || (str = value.getAlbumId()) == null) {
            str = "";
        }
        qZoneIntimateAlbumDetailInitBean.setAlbumId(str);
        Unit unit = Unit.INSTANCE;
        o16.k(activity, requestCode, qZoneIntimateAlbumDetailInitBean);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c, com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneIntimateEditAlbumViewModel";
    }

    public final void k2() {
        S1().postValue(Boolean.TRUE);
        l2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(ap this$0, QZoneBaseAlbumMeta$AlbumInfo albumInfo, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(albumInfo, "$albumInfo");
        RFWLog.i("QZoneIntimateEditAlbumViewModel", RFWLog.USR, "sendEditAlbumReq, onReceive, traceId:" + (baseRequest != null ? baseRequest.getTraceId() : null) + ", isSuccess:" + z16 + ", retCode:" + j3 + ", errMsg:" + str + ", rsp:" + obj);
        this$0.S1().postValue(Boolean.FALSE);
        if (z16 && j3 == 0 && obj != null) {
            this$0.R1().postValue(new EditAlbumResult(true, EditAlbumType.EDIT, mj.a.b(albumInfo), null, 8, null));
            j2(this$0, albumInfo, null, 2, null);
        } else {
            this$0.R1().postValue(new EditAlbumResult(false, EditAlbumType.EDIT, mj.a.b(albumInfo), null, 8, null));
        }
    }

    static /* synthetic */ void j2(ap apVar, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            qZoneBaseAlbumMeta$AlbumInfo = null;
        }
        if ((i3 & 2) != 0) {
            qZoneBaseAlbumMeta$AlbumInfo2 = null;
        }
        apVar.i2(qZoneBaseAlbumMeta$AlbumInfo, qZoneBaseAlbumMeta$AlbumInfo2);
    }
}
