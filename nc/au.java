package nc;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonFamilyAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonLoverAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonShareAlbumMeta;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumResult;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumType;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxEditTextInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxEditAlbumEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteAlbumRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAEditAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PAEditAlbumRsp;
import com.tencent.qqnt.kernel.nativeinterface.PersonalAlbumModifyType;
import com.tencent.qqnt.kernel.nativeinterface.QzoneAlbumModifyDesc;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J \u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020$R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lnc/au;", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "Lcom/tencent/qqnt/kernel/nativeinterface/QzoneAlbumModifyDesc;", "modifyMask", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "albumInfo", "", "u2", "Lkotlin/Pair;", "k2", "", "j2", "m2", "l2", "r2", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", QZoneOptAlbumRequest.FIELD_CMD_EDIT, "deleteAlbum", ICustomDataEditor.NUMBER_PARAM_2, "W1", "U1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "Z1", "X1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "q2", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "B2", "albumType", "x2", "autoJoin", "y2", "", "loveTime", NowProxyConstants.AccountInfoKey.A2, "babyBirth", "z2", "Landroidx/lifecycle/MutableLiveData;", "I", "Landroidx/lifecycle/MutableLiveData;", "_cancelState", "Landroidx/lifecycle/LiveData;", "J", "Landroidx/lifecycle/LiveData;", "p2", "()Landroidx/lifecycle/LiveData;", "cancelState", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class au extends com.qzone.reborn.albumx.common.viewmodel.c {

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _cancelState;

    /* renamed from: J, reason: from kotlin metadata */
    private final LiveData<Integer> cancelState;

    public au() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._cancelState = mutableLiveData;
        this.cancelState = mutableLiveData;
    }

    private final boolean j2(QzoneAlbumModifyDesc modifyMask, AlbumInfo albumInfo) {
        return m2(albumInfo) && l2(albumInfo);
    }

    private final Pair<QzoneAlbumModifyDesc, AlbumInfo> k2() {
        CommonAlbumEditInitBean value = Q1().getValue();
        RFWLog.i("QZAlbumxEditAlbumViewModel", RFWLog.DEV, "checkEdited, initBean:" + O1() + ", currentValue:" + value);
        if (value == null || Intrinsics.areEqual(O1(), value)) {
            return null;
        }
        QzoneAlbumModifyDesc qzoneAlbumModifyDesc = new QzoneAlbumModifyDesc();
        ArrayList arrayList = new ArrayList();
        CommonAlbumInfo albumInfo = value.getAlbumInfo();
        if (!Intrinsics.areEqual(O1().getAlbumName(), value.getAlbumName())) {
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPENAME.ordinal()));
            albumInfo.m0(value.getAlbumName());
        }
        if (!Intrinsics.areEqual(O1().getAlbumDesc(), value.getAlbumDesc())) {
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPEDESC.ordinal()));
            albumInfo.g0(value.getAlbumDesc());
        }
        if (!Intrinsics.areEqual(k9.a.e(O1().getAlbumCover(), 0, 1, null), k9.a.e(value.getAlbumCover(), 0, 1, null))) {
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPECOVER.ordinal()));
            albumInfo.b0(value.getAlbumCover());
        }
        if (O1().isStickTop() != value.isStickTop()) {
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPETOPFLAG.ordinal()));
            albumInfo.w0(value.isStickTop() ? 1L : 0L);
        }
        if (!Intrinsics.areEqual(O1().getAlbumInfo().getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String(), value.getAlbumInfo().getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String())) {
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPEPRIV.ordinal()));
        }
        if (O1().getAlbumInfo().getQzAlbumType() != value.getAlbumInfo().getQzAlbumType()) {
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPEALBUMTYPE.ordinal()));
        }
        if (O1().getAlbumInfo().getShareAlbum().getAutoJoin() != value.getAlbumInfo().getShareAlbum().getAutoJoin()) {
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPEAUTOJOIN.ordinal()));
        }
        if (!Intrinsics.areEqual(O1().getAlbumInfo().getLoverAlbum().getFallInLoveTime(), value.getAlbumInfo().getLoverAlbum().getFallInLoveTime())) {
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPELOVETIME.ordinal()));
        }
        if (!Intrinsics.areEqual(O1().getAlbumInfo().getFamilyAlbum().getBirthTime(), value.getAlbumInfo().getFamilyAlbum().getBirthTime())) {
            arrayList.add(Integer.valueOf(PersonalAlbumModifyType.KPERSONALALBUMMODIFYTYPEBABYBIRTHEVENT.ordinal()));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        AlbumInfo b16 = xh.a.b(albumInfo);
        qzoneAlbumModifyDesc.modifyTypes.addAll(arrayList);
        return new Pair<>(qzoneAlbumModifyDesc, b16);
    }

    private final boolean l2(AlbumInfo albumInfo) {
        if (albumInfo.qzAlbumType == 8) {
            String str = albumInfo.familyAlbum.birthTime;
            if ((str == null || str.length() == 0) || Intrinsics.areEqual(albumInfo.familyAlbum.birthTime, "0") || Intrinsics.areEqual(albumInfo.familyAlbum.birthTime, " ")) {
                QQToastUtil.showQQToastInUiThread(4, com.qzone.util.l.a(R.string.gxi));
                return false;
            }
        }
        return true;
    }

    private final boolean m2(AlbumInfo albumInfo) {
        if (albumInfo.qzAlbumType == 11) {
            String str = albumInfo.loverAlbum.fallInLoveTime;
            if ((str == null || str.length() == 0) || Intrinsics.areEqual(albumInfo.loverAlbum.fallInLoveTime, "0") || Intrinsics.areEqual(albumInfo.loverAlbum.fallInLoveTime, " ")) {
                QQToastUtil.showQQToastInUiThread(4, com.qzone.util.l.a(R.string.je5));
                return false;
            }
        }
        return true;
    }

    private final void n2(CommonAlbumInfo editAlbum, CommonAlbumInfo deleteAlbum) {
        SimpleEventBus.getInstance().dispatchEvent(new QZAlbumxEditAlbumEvent(O1().getBizId(), deleteAlbum, editAlbum, null, 8, null));
    }

    private final void r2() {
        RFWLog.i("QZAlbumxEditAlbumViewModel", RFWLog.USR, "sendDeleteAlbumReq ");
        if (O1().getAlbumInfo() == null) {
            RFWLog.e("QZAlbumxEditAlbumViewModel", RFWLog.USR, "initBean albumInfo = null ");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        PADeleteAlbumReq pADeleteAlbumReq = new PADeleteAlbumReq();
        pADeleteAlbumReq.album = xh.a.b(O1().getAlbumInfo());
        RequestTimelineInfo requestTimelineInfo = new RequestTimelineInfo();
        pADeleteAlbumReq.requestTimeLine = requestTimelineInfo;
        requestTimelineInfo.requestInvokeTime = currentTimeMillis;
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.deleteAlbum(pADeleteAlbumReq, new IPersonalAlbumServiceDeleteAlbumCallback() { // from class: nc.as
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteAlbumCallback
                public final void onDeleteAlbum(PADeleteAlbumRsp pADeleteAlbumRsp) {
                    au.s2(au.this, currentTimeMillis, pADeleteAlbumRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(final au this$0, long j3, final PADeleteAlbumRsp pADeleteAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.getTAG(), 1, "sendDeleteAlbumReq seq: " + pADeleteAlbumRsp.seq + " | result: " + pADeleteAlbumRsp.result + " | errMsg:" + pADeleteAlbumRsp.errMs);
        mc.c.f416541a.e("deleteAlbum", System.currentTimeMillis() - j3, pADeleteAlbumRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.at
            @Override // java.lang.Runnable
            public final void run() {
                au.t2(au.this, pADeleteAlbumRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(au this$0, PADeleteAlbumRsp pADeleteAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S1().postValue(Boolean.FALSE);
        if (pADeleteAlbumRsp.result == 0) {
            this$0.R1().postValue(new EditAlbumResult(true, EditAlbumType.DELETE, this$0.O1().getAlbumInfo(), null, 8, null));
            o2(this$0, null, this$0.O1().getAlbumInfo(), 1, null);
        } else {
            this$0.R1().postValue(new EditAlbumResult(false, EditAlbumType.DELETE, this$0.O1().getAlbumInfo(), null, 8, null));
        }
    }

    private final void u2(QzoneAlbumModifyDesc modifyMask, final AlbumInfo albumInfo) {
        final long currentTimeMillis = System.currentTimeMillis();
        PAEditAlbumReq pAEditAlbumReq = new PAEditAlbumReq();
        pAEditAlbumReq.album = albumInfo;
        pAEditAlbumReq.modifyDesc = modifyMask;
        RequestTimelineInfo requestTimelineInfo = new RequestTimelineInfo();
        pAEditAlbumReq.requestTimeLine = requestTimelineInfo;
        requestTimelineInfo.requestInvokeTime = currentTimeMillis;
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.editAlbum(pAEditAlbumReq, new IPersonalAlbumServiceEditAlbumCallback() { // from class: nc.aq
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditAlbumCallback
                public final void onEditAlbum(PAEditAlbumRsp pAEditAlbumRsp) {
                    au.v2(currentTimeMillis, this, albumInfo, pAEditAlbumRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(long j3, final au this$0, final AlbumInfo albumInfo, final PAEditAlbumRsp pAEditAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(albumInfo, "$albumInfo");
        RFWLog.i("QZAlbumxEditAlbumViewModel", RFWLog.USR, "sendEditAlbumReq, onReceive, traceID:" + pAEditAlbumRsp.traceId + ",result:" + pAEditAlbumRsp.result + " errMs:" + pAEditAlbumRsp.errMs);
        mc.c.f416541a.e(QZoneOptAlbumRequest.FIELD_CMD_EDIT, System.currentTimeMillis() - j3, pAEditAlbumRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.ar
            @Override // java.lang.Runnable
            public final void run() {
                au.w2(au.this, pAEditAlbumRsp, albumInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(au this$0, PAEditAlbumRsp pAEditAlbumRsp, AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(albumInfo, "$albumInfo");
        this$0.S1().postValue(Boolean.FALSE);
        if (pAEditAlbumRsp.result == 0) {
            this$0.R1().postValue(new EditAlbumResult(true, EditAlbumType.EDIT, xh.a.a(albumInfo), null, 8, null));
            o2(this$0, xh.a.a(albumInfo), null, 2, null);
            return;
        }
        MutableLiveData<EditAlbumResult> R1 = this$0.R1();
        EditAlbumType editAlbumType = EditAlbumType.EDIT;
        CommonAlbumInfo a16 = xh.a.a(albumInfo);
        String str = pAEditAlbumRsp.errMs;
        Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
        R1.postValue(new EditAlbumResult(false, editAlbumType, a16, str));
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public boolean U1() {
        Integer value;
        if (k2() == null) {
            return false;
        }
        if (this.cancelState.getValue() == null) {
            value = 0;
        } else {
            value = this.cancelState.getValue();
        }
        MutableLiveData<Integer> mutableLiveData = this._cancelState;
        Intrinsics.checkNotNull(value);
        mutableLiveData.postValue(Integer.valueOf(value.intValue() + 1));
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public boolean W1() {
        Pair<QzoneAlbumModifyDesc, AlbumInfo> k26 = k2();
        if (k26 == null) {
            return false;
        }
        if (j2(k26.getFirst(), k26.getSecond())) {
            S1().postValue(Boolean.TRUE);
            u2(k26.getFirst(), k26.getSecond());
        }
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public void a2(Activity activity, int requestCode) {
        CommonAlbumInfo albumInfo;
        String albumId;
        Intrinsics.checkNotNullParameter(activity, "activity");
        vb.b x16 = ho.i.x();
        String bizId = O1().getBizId();
        String str = "";
        if (bizId == null) {
            bizId = "";
        }
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(bizId);
        CommonAlbumEditInitBean value = M1().getValue();
        if (value != null && (albumId = value.getAlbumId()) != null) {
            str = albumId;
        }
        qZAlbumxAlbumDetailInitBean.setAlbumId(str);
        CommonAlbumEditInitBean value2 = M1().getValue();
        qZAlbumxAlbumDetailInitBean.setSortType((value2 == null || (albumInfo = value2.getAlbumInfo()) == null) ? null : Integer.valueOf(albumInfo.getSortType()));
        Unit unit = Unit.INSTANCE;
        x16.c(activity, requestCode, qZAlbumxAlbumDetailInitBean);
    }

    public final LiveData<Integer> p2() {
        return this.cancelState;
    }

    public final void q2() {
        S1().postValue(Boolean.TRUE);
        r2();
    }

    public final void x2(int albumType) {
        CommonAlbumInfo albumInfo;
        CommonAlbumInfo a16;
        CommonAlbumEditInitBean commonAlbumEditInitBean;
        MutableLiveData<CommonAlbumEditInitBean> Q1 = Q1();
        CommonAlbumEditInitBean value = Q1().getValue();
        if (value == null || (albumInfo = value.getAlbumInfo()) == null || (a16 = albumInfo.a()) == null) {
            return;
        }
        a16.q0(albumType);
        CommonAlbumEditInitBean value2 = Q1.getValue();
        if (value2 != null) {
            Intrinsics.checkNotNullExpressionValue(value2, "value");
            commonAlbumEditInitBean = value2.copy((r22 & 1) != 0 ? value2.bizId : null, (r22 & 2) != 0 ? value2.albumId : null, (r22 & 4) != 0 ? value2.albumName : null, (r22 & 8) != 0 ? value2.albumDesc : null, (r22 & 16) != 0 ? value2.albumCover : null, (r22 & 32) != 0 ? value2.isStickTop : false, (r22 & 64) != 0 ? value2.albumInfo : a16, (r22 & 128) != 0 ? value2.hasTopRight : false, (r22 & 256) != 0 ? value2.hasDeleteRight : false, (r22 & 512) != 0 ? value2.isEmptyAlbum : false);
        } else {
            commonAlbumEditInitBean = null;
        }
        Q1.postValue(commonAlbumEditInitBean);
    }

    public final void y2(boolean autoJoin) {
        CommonAlbumInfo albumInfo;
        CommonAlbumInfo a16;
        CommonAlbumEditInitBean commonAlbumEditInitBean;
        MutableLiveData<CommonAlbumEditInitBean> Q1 = Q1();
        CommonAlbumEditInitBean value = Q1().getValue();
        if (value == null || (albumInfo = value.getAlbumInfo()) == null || (a16 = albumInfo.a()) == null) {
            return;
        }
        CommonShareAlbumMeta commonShareAlbumMeta = new CommonShareAlbumMeta();
        commonShareAlbumMeta.g(a16.getShareAlbum().getOwner());
        commonShareAlbumMeta.j(a16.getShareAlbum().getShareNums());
        commonShareAlbumMeta.k(a16.getShareAlbum().e());
        commonShareAlbumMeta.f(autoJoin);
        a16.r0(commonShareAlbumMeta);
        CommonAlbumEditInitBean value2 = Q1.getValue();
        if (value2 != null) {
            Intrinsics.checkNotNullExpressionValue(value2, "value");
            commonAlbumEditInitBean = value2.copy((r22 & 1) != 0 ? value2.bizId : null, (r22 & 2) != 0 ? value2.albumId : null, (r22 & 4) != 0 ? value2.albumName : null, (r22 & 8) != 0 ? value2.albumDesc : null, (r22 & 16) != 0 ? value2.albumCover : null, (r22 & 32) != 0 ? value2.isStickTop : false, (r22 & 64) != 0 ? value2.albumInfo : a16, (r22 & 128) != 0 ? value2.hasTopRight : false, (r22 & 256) != 0 ? value2.hasDeleteRight : false, (r22 & 512) != 0 ? value2.isEmptyAlbum : false);
        } else {
            commonAlbumEditInitBean = null;
        }
        Q1.postValue(commonAlbumEditInitBean);
    }

    public final void A2(String loveTime) {
        CommonAlbumInfo albumInfo;
        CommonAlbumInfo a16;
        CommonAlbumEditInitBean commonAlbumEditInitBean;
        Intrinsics.checkNotNullParameter(loveTime, "loveTime");
        MutableLiveData<CommonAlbumEditInitBean> Q1 = Q1();
        CommonAlbumEditInitBean value = Q1().getValue();
        if (value == null || (albumInfo = value.getAlbumInfo()) == null || (a16 = albumInfo.a()) == null) {
            return;
        }
        CommonLoverAlbumMeta commonLoverAlbumMeta = new CommonLoverAlbumMeta();
        commonLoverAlbumMeta.e(loveTime);
        commonLoverAlbumMeta.f(a16.getLoverAlbum().getLoveValue());
        commonLoverAlbumMeta.g(a16.getLoverAlbum().c());
        a16.j0(commonLoverAlbumMeta);
        CommonAlbumEditInitBean value2 = Q1.getValue();
        if (value2 != null) {
            Intrinsics.checkNotNullExpressionValue(value2, "value");
            commonAlbumEditInitBean = value2.copy((r22 & 1) != 0 ? value2.bizId : null, (r22 & 2) != 0 ? value2.albumId : null, (r22 & 4) != 0 ? value2.albumName : null, (r22 & 8) != 0 ? value2.albumDesc : null, (r22 & 16) != 0 ? value2.albumCover : null, (r22 & 32) != 0 ? value2.isStickTop : false, (r22 & 64) != 0 ? value2.albumInfo : a16, (r22 & 128) != 0 ? value2.hasTopRight : false, (r22 & 256) != 0 ? value2.hasDeleteRight : false, (r22 & 512) != 0 ? value2.isEmptyAlbum : false);
        } else {
            commonAlbumEditInitBean = null;
        }
        Q1.postValue(commonAlbumEditInitBean);
    }

    public final void B2(CommonAlbumAccessPermission permission) {
        CommonAlbumInfo albumInfo;
        CommonAlbumInfo a16;
        CommonAlbumEditInitBean commonAlbumEditInitBean;
        Intrinsics.checkNotNullParameter(permission, "permission");
        MutableLiveData<CommonAlbumEditInitBean> Q1 = Q1();
        CommonAlbumEditInitBean value = Q1().getValue();
        if (value == null || (albumInfo = value.getAlbumInfo()) == null || (a16 = albumInfo.a()) == null) {
            return;
        }
        a16.p0(permission);
        CommonAlbumEditInitBean value2 = Q1.getValue();
        if (value2 != null) {
            Intrinsics.checkNotNullExpressionValue(value2, "value");
            commonAlbumEditInitBean = value2.copy((r22 & 1) != 0 ? value2.bizId : null, (r22 & 2) != 0 ? value2.albumId : null, (r22 & 4) != 0 ? value2.albumName : null, (r22 & 8) != 0 ? value2.albumDesc : null, (r22 & 16) != 0 ? value2.albumCover : null, (r22 & 32) != 0 ? value2.isStickTop : false, (r22 & 64) != 0 ? value2.albumInfo : a16, (r22 & 128) != 0 ? value2.hasTopRight : false, (r22 & 256) != 0 ? value2.hasDeleteRight : false, (r22 & 512) != 0 ? value2.isEmptyAlbum : false);
        } else {
            commonAlbumEditInitBean = null;
        }
        Q1.postValue(commonAlbumEditInitBean);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public void X1(Activity activity, int requestCode) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        vb.b x16 = ho.i.x();
        String bizId = O1().getBizId();
        String a16 = com.qzone.util.l.a(R.string.f133957i);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_albumx_album_desc_text)");
        CommonAlbumEditInitBean value = M1().getValue();
        if (value == null || (str = value.getAlbumDesc()) == null) {
            str = "";
        }
        String a17 = com.qzone.util.l.a(R.string.f133947h);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_albumx_album_desc_hint)");
        x16.e(activity, requestCode, new QZAlbumxEditTextInitBean(bizId, a16, str, 50, a17, true, true, "pg_qz_album_description_edit", false, 256, null));
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public void Z1(Activity activity, int requestCode) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        vb.b x16 = ho.i.x();
        String bizId = O1().getBizId();
        CommonAlbumEditInitBean value = M1().getValue();
        if (value == null || (str = value.getAlbumName()) == null) {
            str = "";
        }
        x16.e(activity, requestCode, new QZAlbumxEditTextInitBean(bizId, "\u76f8\u518c\u540d", str, 15, "\u8f93\u5165\u76f8\u518c\u540d", false, false, "pg_qz_album_name_edit", true, 96, null));
    }

    public final void z2(String babyBirth) {
        CommonAlbumInfo albumInfo;
        CommonAlbumInfo a16;
        CommonAlbumEditInitBean commonAlbumEditInitBean;
        Intrinsics.checkNotNullParameter(babyBirth, "babyBirth");
        MutableLiveData<CommonAlbumEditInitBean> Q1 = Q1();
        CommonAlbumEditInitBean value = Q1().getValue();
        if (value == null || (albumInfo = value.getAlbumInfo()) == null || (a16 = albumInfo.a()) == null) {
            return;
        }
        CommonFamilyAlbumMeta commonFamilyAlbumMeta = new CommonFamilyAlbumMeta();
        commonFamilyAlbumMeta.b(babyBirth);
        a16.h0(commonFamilyAlbumMeta);
        CommonAlbumEditInitBean value2 = Q1.getValue();
        if (value2 != null) {
            Intrinsics.checkNotNullExpressionValue(value2, "value");
            commonAlbumEditInitBean = value2.copy((r22 & 1) != 0 ? value2.bizId : null, (r22 & 2) != 0 ? value2.albumId : null, (r22 & 4) != 0 ? value2.albumName : null, (r22 & 8) != 0 ? value2.albumDesc : null, (r22 & 16) != 0 ? value2.albumCover : null, (r22 & 32) != 0 ? value2.isStickTop : false, (r22 & 64) != 0 ? value2.albumInfo : a16, (r22 & 128) != 0 ? value2.hasTopRight : false, (r22 & 256) != 0 ? value2.hasDeleteRight : false, (r22 & 512) != 0 ? value2.isEmptyAlbum : false);
        } else {
            commonAlbumEditInitBean = null;
        }
        Q1.postValue(commonAlbumEditInitBean);
    }

    static /* synthetic */ void o2(au auVar, CommonAlbumInfo commonAlbumInfo, CommonAlbumInfo commonAlbumInfo2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            commonAlbumInfo = null;
        }
        if ((i3 & 2) != 0) {
            commonAlbumInfo2 = null;
        }
        auVar.n2(commonAlbumInfo, commonAlbumInfo2);
    }
}
