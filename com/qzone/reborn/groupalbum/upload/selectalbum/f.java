package com.qzone.reborn.groupalbum.upload.selectalbum;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAlbumInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTGetAlbumInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetAlbumInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import fj.r;
import fj.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\"\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R\u001f\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/groupalbum/upload/selectalbum/f;", "Lql/a;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "rememberAlbumInfo", "", "T1", "albumInfo", "W1", "", "getLogTag", "groupId", "beanAlbumInfo", "S1", "X1", "", "M1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "Q1", "()Ljava/lang/String;", "Z1", "(Ljava/lang/String;)V", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_notShowBar", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "notShowBar", "E", "_albumInfo", UserInfo.SEX_FEMALE, "P1", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends ql.a<Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _notShowBar;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<Boolean> notShowBar;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<CommonAlbumInfo> _albumInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<CommonAlbumInfo> albumInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public String groupId;

    public f() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._notShowBar = mutableLiveData;
        this.notShowBar = mutableLiveData;
        MutableLiveData<CommonAlbumInfo> mutableLiveData2 = new MutableLiveData<>(null);
        this._albumInfo = mutableLiveData2;
        this.albumInfo = mutableLiveData2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.tencent.qqnt.kernel.nativeinterface.NTGetAlbumInfoReq] */
    private final void T1(final CommonAlbumInfo rememberAlbumInfo) {
        RequestTimelineInfo requestTimelineInfo = new RequestTimelineInfo();
        requestTimelineInfo.requestInvokeTime = System.currentTimeMillis();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new NTGetAlbumInfoReq(0, requestTimelineInfo, Q1(), rememberAlbumInfo.getAlbumId());
        com.tencent.qqnt.kernel.api.g b16 = r.b();
        if (b16 != null) {
            b16.getAlbumInfo((NTGetAlbumInfoReq) objectRef.element, new IAlbumServiceGetAlbumInfoCallback() { // from class: com.qzone.reborn.groupalbum.upload.selectalbum.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAlbumInfoCallback
                public final void onGetAlbumInfo(NTGetAlbumInfoRsp nTGetAlbumInfoRsp) {
                    f.U1(Ref.ObjectRef.this, this, rememberAlbumInfo, nTGetAlbumInfoRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void U1(Ref.ObjectRef request, f this$0, CommonAlbumInfo rememberAlbumInfo, NTGetAlbumInfoRsp nTGetAlbumInfoRsp) {
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rememberAlbumInfo, "$rememberAlbumInfo");
        RFWLog.i("GroupUploadSelectAlbumBarViewModel", RFWLog.USR, "refreshRememberAlbum, traceId:" + nTGetAlbumInfoRsp.traceId + ", result:" + nTGetAlbumInfoRsp.result + ", errMs:" + nTGetAlbumInfoRsp.errMs + ", albumInfo:" + nTGetAlbumInfoRsp.albumInfo);
        int i3 = nTGetAlbumInfoRsp.result;
        v.a(i3 == 0, 3, i3, System.currentTimeMillis() - ((NTGetAlbumInfoReq) request.element).requestTimeLine.requestInvokeTime, nTGetAlbumInfoRsp.traceId);
        if (nTGetAlbumInfoRsp.result == 0) {
            CommonAlbumInfo value = this$0._albumInfo.getValue();
            if (Intrinsics.areEqual(value != null ? value.getAlbumId() : null, rememberAlbumInfo.getAlbumId())) {
                AlbumInfo albumInfo = nTGetAlbumInfoRsp.albumInfo;
                if (albumInfo != null) {
                    Intrinsics.checkNotNullExpressionValue(albumInfo, "response.albumInfo");
                    CommonAlbumInfo a16 = xh.a.a(albumInfo);
                    com.qzone.reborn.part.publish.common.selectalbum.d.f58616a.d("group_album_selected_album_info", this$0.Q1(), a16);
                    this$0._albumInfo.postValue(a16);
                    return;
                }
                com.qzone.reborn.part.publish.common.selectalbum.d.f58616a.a("group_album_selected_album_info", this$0.Q1());
                this$0._albumInfo.postValue(null);
            }
        }
    }

    private final void W1(CommonAlbumInfo albumInfo) {
        com.qzone.reborn.part.publish.common.selectalbum.d.f58616a.d("group_album_selected_album_info", Q1(), albumInfo);
    }

    @Override // ql.a
    public boolean M1() {
        return this._albumInfo.getValue() != null;
    }

    public final LiveData<CommonAlbumInfo> P1() {
        return this.albumInfo;
    }

    public final String Q1() {
        String str = this.groupId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("groupId");
        return null;
    }

    public final LiveData<Boolean> R1() {
        return this.notShowBar;
    }

    public final void S1(String groupId, CommonAlbumInfo beanAlbumInfo) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Z1(groupId);
        if (beanAlbumInfo != null) {
            this._notShowBar.setValue(Boolean.TRUE);
            this._albumInfo.setValue(beanAlbumInfo);
            W1(beanAlbumInfo);
        } else {
            CommonAlbumInfo c16 = com.qzone.reborn.part.publish.common.selectalbum.d.f58616a.c("group_album_selected_album_info", groupId);
            if (c16 != null) {
                this._albumInfo.setValue(c16);
                T1(c16);
            }
        }
    }

    public final void X1(CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this._albumInfo.postValue(albumInfo);
        W1(albumInfo);
    }

    public final void Z1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "GroupUploadSelectAlbumBarViewModel";
    }
}
