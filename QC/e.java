package qc;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.utils.i;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceQueryAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAQueryAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PAQueryAlbumRsp;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R\u001f\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\u00a8\u0006)"}, d2 = {"Lqc/e;", "Lql/a;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "rememberAlbumInfo", "", "U1", "albumInfo", "Z1", "", "getLogTag", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "initBean", "T1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "M1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "R1", "()Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "b2", "(Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;)V", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_notShowBar", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "notShowBar", "E", "_albumInfo", UserInfo.SEX_FEMALE, "Q1", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends ql.a<Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _notShowBar;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<Boolean> notShowBar;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<CommonAlbumInfo> _albumInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<CommonAlbumInfo> albumInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public QZAlbumxUploadAlbumInitBean initBean;

    public e() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._notShowBar = mutableLiveData;
        this.notShowBar = mutableLiveData;
        MutableLiveData<CommonAlbumInfo> mutableLiveData2 = new MutableLiveData<>(null);
        this._albumInfo = mutableLiveData2;
        this.albumInfo = mutableLiveData2;
    }

    private final void U1(final CommonAlbumInfo rememberAlbumInfo) {
        RequestTimelineInfo requestTimelineInfo = new RequestTimelineInfo();
        requestTimelineInfo.requestInvokeTime = System.currentTimeMillis();
        PAQueryAlbumReq pAQueryAlbumReq = new PAQueryAlbumReq();
        pAQueryAlbumReq.albumId = rememberAlbumInfo.getAlbumId();
        pAQueryAlbumReq.reqType = 2;
        pAQueryAlbumReq.owner.uin = R1().getUin();
        pAQueryAlbumReq.requestTimeLine = requestTimelineInfo;
        z b16 = i.b();
        if (b16 != null) {
            b16.queryAlbum(pAQueryAlbumReq, new IPersonalAlbumServiceQueryAlbumCallback() { // from class: qc.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceQueryAlbumCallback
                public final void onQueryAlbum(PAQueryAlbumRsp pAQueryAlbumRsp) {
                    e.W1(e.this, rememberAlbumInfo, pAQueryAlbumRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(final e this$0, final CommonAlbumInfo rememberAlbumInfo, final PAQueryAlbumRsp pAQueryAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rememberAlbumInfo, "$rememberAlbumInfo");
        RFWLog.i("QZAlbumxUploadSelectAlbumBarViewModel", RFWLog.USR, "refreshRememberAlbum, traceId:" + pAQueryAlbumRsp.traceId + ", result:" + pAQueryAlbumRsp.result + ", errMs:" + pAQueryAlbumRsp.errMs + ", albumInfo:" + pAQueryAlbumRsp.album);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: qc.d
            @Override // java.lang.Runnable
            public final void run() {
                e.X1(PAQueryAlbumRsp.this, this$0, rememberAlbumInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(PAQueryAlbumRsp pAQueryAlbumRsp, e this$0, CommonAlbumInfo rememberAlbumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rememberAlbumInfo, "$rememberAlbumInfo");
        if (pAQueryAlbumRsp.result == 0) {
            CommonAlbumInfo value = this$0._albumInfo.getValue();
            if (Intrinsics.areEqual(value != null ? value.getAlbumId() : null, rememberAlbumInfo.getAlbumId())) {
                AlbumInfo albumInfo = pAQueryAlbumRsp.album;
                if (albumInfo != null) {
                    Intrinsics.checkNotNullExpressionValue(albumInfo, "response.album");
                    CommonAlbumInfo a16 = xh.a.a(albumInfo);
                    com.qzone.reborn.part.publish.common.selectalbum.d.f58616a.d("qzone_albumx_selected_album_info", this$0.R1().getUin(), a16);
                    this$0._albumInfo.setValue(a16);
                    return;
                }
                com.qzone.reborn.part.publish.common.selectalbum.d.f58616a.a("qzone_albumx_selected_album_info", this$0.R1().getUin());
                this$0._albumInfo.setValue(null);
            }
        }
    }

    private final void Z1(CommonAlbumInfo albumInfo) {
        com.qzone.reborn.part.publish.common.selectalbum.d.f58616a.d("qzone_albumx_selected_album_info", R1().getUin(), albumInfo);
    }

    @Override // ql.a
    public boolean M1() {
        return this._albumInfo.getValue() != null;
    }

    public final LiveData<CommonAlbumInfo> Q1() {
        return this.albumInfo;
    }

    public final QZAlbumxUploadAlbumInitBean R1() {
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = this.initBean;
        if (qZAlbumxUploadAlbumInitBean != null) {
            return qZAlbumxUploadAlbumInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final LiveData<Boolean> S1() {
        return this.notShowBar;
    }

    public final void T1(QZAlbumxUploadAlbumInitBean initBean) {
        CommonAlbumInfo albumInfo;
        CommonStPicUrl f16;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        b2(initBean);
        CommonAlbumInfo albumInfo2 = initBean.getAlbumInfo();
        if (albumInfo2 != null) {
            this._notShowBar.setValue(Boolean.valueOf(initBean.getFromType() != 6));
            this._albumInfo.setValue(albumInfo2);
            Z1(albumInfo2);
        } else {
            CommonAlbumInfo c16 = com.qzone.reborn.part.publish.common.selectalbum.d.f58616a.c("qzone_albumx_selected_album_info", initBean.getUin());
            if (c16 != null) {
                this._albumInfo.setValue(c16);
                U1(c16);
            }
        }
        CommonAlbumInfo albumInfo3 = initBean.getAlbumInfo();
        String str = null;
        if (TextUtils.isEmpty(albumInfo3 != null ? albumInfo3.getAlbumId() : null)) {
            return;
        }
        CommonAlbumInfo albumInfo4 = initBean.getAlbumInfo();
        if (albumInfo4 != null && (f16 = k9.a.f(albumInfo4)) != null) {
            str = f16.getUrl();
        }
        if (!TextUtils.isEmpty(str) || (albumInfo = initBean.getAlbumInfo()) == null) {
            return;
        }
        U1(albumInfo);
    }

    public final void a2(CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this._albumInfo.postValue(albumInfo);
        Z1(albumInfo);
    }

    public final void b2(QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean) {
        Intrinsics.checkNotNullParameter(qZAlbumxUploadAlbumInitBean, "<set-?>");
        this.initBean = qZAlbumxUploadAlbumInitBean;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZAlbumxUploadSelectAlbumBarViewModel";
    }
}
