package com.qzone.reborn.part.publish.common.selectalbum;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateUploadAlbumInitBean;
import com.qzone.reborn.intimate.request.QZIntimateGetAlbumInfoRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetAlbumInfoRsp;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\b\u0010\u0010\u001a\u00020\u000fH\u0016R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u001f\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001a8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/part/publish/common/selectalbum/c;", "Lql/a;", "", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "rememberAlbumInfo", "", "T1", "albumInfo", "U1", "", "getLogTag", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateUploadAlbumInitBean;", "initBean", "S1", "W1", "", "M1", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateUploadAlbumInitBean;", "Q1", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateUploadAlbumInitBean;", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_notShowBar", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "notShowBar", "E", "_albumInfo", UserInfo.SEX_FEMALE, "P1", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends ql.a<Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _notShowBar;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<Boolean> notShowBar;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<QZoneBaseAlbumMeta$AlbumInfo> _albumInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<QZoneBaseAlbumMeta$AlbumInfo> albumInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateUploadAlbumInitBean initBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/part/publish/common/selectalbum/c$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZIntimateSpaceAlbum$GetAlbumInfoRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceAlbum$GetAlbumInfoRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QZoneBaseAlbumMeta$AlbumInfo f58615b;

        b(QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo) {
            this.f58615b = qZoneBaseAlbumMeta$AlbumInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest request, boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceAlbum$GetAlbumInfoRsp rsp) {
            PBStringField pBStringField;
            RFWLog.i("QZoneSelectAlbumBarViewModel", RFWLog.USR, "refreshRememberAlbum, onReceive, traceId:" + (request != null ? request.getTraceId() : null) + ", isSuccess:" + isSuccess + ", retCode:" + retCode + ", errMsg:" + errMsg + ", rsp:" + rsp);
            if (isSuccess && retCode == 0 && rsp != null) {
                QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo = (QZoneBaseAlbumMeta$AlbumInfo) c.this._albumInfo.getValue();
                if (Intrinsics.areEqual((qZoneBaseAlbumMeta$AlbumInfo == null || (pBStringField = qZoneBaseAlbumMeta$AlbumInfo.album_id) == null) ? null : pBStringField.get(), this.f58615b.album_id.get())) {
                    boolean has = rsp.album_info.has();
                    RFWLog.i("QZoneSelectAlbumBarViewModel", RFWLog.USR, "refreshRememberAlbum, hasAlbumInfo:" + has);
                    if (has) {
                        QZoneBaseAlbumMeta$AlbumInfo freshAlbumInfo = rsp.album_info.get();
                        a aVar = a.f58610a;
                        String spaceId = c.this.Q1().getSpaceId();
                        Intrinsics.checkNotNullExpressionValue(freshAlbumInfo, "freshAlbumInfo");
                        aVar.d(spaceId, freshAlbumInfo);
                        c.this._albumInfo.postValue(freshAlbumInfo);
                        return;
                    }
                    a.f58610a.a(c.this.Q1().getSpaceId());
                    c.this._albumInfo.postValue(null);
                }
            }
        }
    }

    public c() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._notShowBar = mutableLiveData;
        this.notShowBar = mutableLiveData;
        MutableLiveData<QZoneBaseAlbumMeta$AlbumInfo> mutableLiveData2 = new MutableLiveData<>(null);
        this._albumInfo = mutableLiveData2;
        this.albumInfo = mutableLiveData2;
    }

    private final void T1(QZoneBaseAlbumMeta$AlbumInfo rememberAlbumInfo) {
        VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
        String spaceId = Q1().getSpaceId();
        String str = rememberAlbumInfo.album_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "rememberAlbumInfo.album_id.get()");
        vSNetworkHelper.sendRequest(new QZIntimateGetAlbumInfoRequest(spaceId, str), new b(rememberAlbumInfo));
    }

    private final void U1(QZoneBaseAlbumMeta$AlbumInfo albumInfo) {
        a.f58610a.d(Q1().getSpaceId(), albumInfo);
    }

    @Override // ql.a
    public boolean M1() {
        return this._albumInfo.getValue() != null;
    }

    public final LiveData<QZoneBaseAlbumMeta$AlbumInfo> P1() {
        return this.albumInfo;
    }

    public final QZoneIntimateUploadAlbumInitBean Q1() {
        QZoneIntimateUploadAlbumInitBean qZoneIntimateUploadAlbumInitBean = this.initBean;
        if (qZoneIntimateUploadAlbumInitBean != null) {
            return qZoneIntimateUploadAlbumInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final LiveData<Boolean> R1() {
        return this.notShowBar;
    }

    public final void S1(QZoneIntimateUploadAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        QZoneBaseAlbumMeta$AlbumInfo albumInfo = initBean.getAlbumInfo();
        if (albumInfo != null) {
            this._notShowBar.setValue(Boolean.TRUE);
            this._albumInfo.setValue(albumInfo);
            U1(albumInfo);
        } else {
            QZoneBaseAlbumMeta$AlbumInfo c16 = a.f58610a.c(initBean.getSpaceId());
            if (c16 != null) {
                this._albumInfo.setValue(c16);
                T1(c16);
            }
        }
    }

    public final void W1(QZoneBaseAlbumMeta$AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this._albumInfo.postValue(albumInfo);
        U1(albumInfo);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneSelectAlbumBarViewModel";
    }
}
