package nc;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceAddAlbumPermissionsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceForwardAlbumToQzoneCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetShareInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAAddAlbumPermissionsReq;
import com.tencent.qqnt.kernel.nativeinterface.PAAddAlbumPermissionsRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAForwardAlbumToQzoneReq;
import com.tencent.qqnt.kernel.nativeinterface.PAForwardAlbumToQzoneRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAGetShareInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetShareInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.ShareScene;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StShare;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J$\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015J.\u0010\u001a\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010+\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lnc/u;", "Lcom/qzone/reborn/base/n;", "", "errorMsg", "", "d2", "Lcom/tencent/qqnt/kernel/nativeinterface/StShare;", "share", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "albumInfo", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "Lkotlin/collections/ArrayList;", "medias", "b2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "getLogTag", "albumId", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "albumOwner", "W1", "", "addUsers", "e2", "coverUrl", "reason", "R1", "", "i", "Z", "c2", "()Z", "setLoadingFinish", "(Z)V", "isLoadingFinish", "Landroidx/lifecycle/MutableLiveData;", "Lxa/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "setRspData", "(Landroidx/lifecycle/MutableLiveData;)V", "rspData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class u extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadingFinish;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<xa.c> rspData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(long j3, final u this$0, final PAForwardAlbumToQzoneRsp pAForwardAlbumToQzoneRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.i("QZAlbumxAlbumDetailShareViewModel", RFWLog.USR, "forwardAlbumToQzone result: " + pAForwardAlbumToQzoneRsp.result + " error msg is " + pAForwardAlbumToQzoneRsp.errMs + ", error traceId is " + pAForwardAlbumToQzoneRsp.traceId);
        mc.c.f416541a.e("forwardAlbumToQzone", System.currentTimeMillis() - j3, pAForwardAlbumToQzoneRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.r
            @Override // java.lang.Runnable
            public final void run() {
                u.T1(PAForwardAlbumToQzoneRsp.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(PAForwardAlbumToQzoneRsp pAForwardAlbumToQzoneRsp, u this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pAForwardAlbumToQzoneRsp.result == 0) {
            this$0.a2();
        } else {
            this$0.d2(com.qzone.util.l.a(R.string.f169515ca0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(long j3, final u this$0, final PAGetShareInfoRsp pAGetShareInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mc.c.f416541a.e("getShareInfo", System.currentTimeMillis() - j3, pAGetShareInfoRsp.result);
        RFWLog.e("QZAlbumxAlbumDetailShareViewModel", RFWLog.USR, "get share info result: " + pAGetShareInfoRsp.result + " error msg is " + pAGetShareInfoRsp.errMs + ", error traceId is " + pAGetShareInfoRsp.traceId);
        this$0.isLoadingFinish = true;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.t
            @Override // java.lang.Runnable
            public final void run() {
                u.Z1(PAGetShareInfoRsp.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(PAGetShareInfoRsp pAGetShareInfoRsp, u this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pAGetShareInfoRsp.result == 0) {
            StShare stShare = pAGetShareInfoRsp.share;
            Intrinsics.checkNotNullExpressionValue(stShare, "response.share");
            AlbumInfo albumInfo = pAGetShareInfoRsp.album;
            Intrinsics.checkNotNullExpressionValue(albumInfo, "response.album");
            ArrayList<StMedia> arrayList = pAGetShareInfoRsp.medias;
            Intrinsics.checkNotNullExpressionValue(arrayList, "response.medias");
            this$0.b2(stShare, albumInfo, arrayList);
            return;
        }
        this$0.d2(pAGetShareInfoRsp.errMs);
        MutableLiveData<xa.c> mutableLiveData = this$0.rspData;
        xa.c cVar = new xa.c();
        cVar.f(pAGetShareInfoRsp.result);
        mutableLiveData.setValue(cVar);
    }

    private final void b2(StShare share, AlbumInfo albumInfo, ArrayList<StMedia> medias) {
        xa.c cVar = new xa.c();
        cVar.g(fb.a.s(share));
        cVar.e(xh.a.a(albumInfo));
        Iterator<T> it = medias.iterator();
        while (it.hasNext()) {
            cVar.b().add(xh.h.b((StMedia) it.next()));
        }
        this.rspData.postValue(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(PAAddAlbumPermissionsRsp pAAddAlbumPermissionsRsp) {
        RFWLog.e("QZAlbumxAlbumDetailShareViewModel", RFWLog.USR, "permissionBreak result: " + pAAddAlbumPermissionsRsp.result + " error msg is " + pAAddAlbumPermissionsRsp.errMs + ", error traceId is " + pAAddAlbumPermissionsRsp.traceId);
    }

    public final MutableLiveData<xa.c> U1() {
        return this.rspData;
    }

    public final void W1(String albumId, CommonStUser albumOwner) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(albumOwner, "albumOwner");
        if (!NetworkUtil.isNetworkAvailable()) {
            d2("\u65e0\u7f51\u7edc");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        PAGetShareInfoReq pAGetShareInfoReq = new PAGetShareInfoReq();
        pAGetShareInfoReq.scene = ShareScene.KSHARESCENEALBUM.ordinal();
        pAGetShareInfoReq.albumId = albumId;
        pAGetShareInfoReq.owner = xh.i.b(albumOwner);
        pAGetShareInfoReq.requestTimeLine.requestInvokeTime = currentTimeMillis;
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.getShareInfo(pAGetShareInfoReq, new IPersonalAlbumServiceGetShareInfoCallback() { // from class: nc.s
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetShareInfoCallback
                public final void onGetShareInfo(PAGetShareInfoRsp pAGetShareInfoRsp) {
                    u.X1(currentTimeMillis, this, pAGetShareInfoRsp);
                }
            });
        }
    }

    /* renamed from: c2, reason: from getter */
    public final boolean getIsLoadingFinish() {
        return this.isLoadingFinish;
    }

    public final void e2(String albumId, CommonStUser albumOwner, List<CommonStUser> addUsers) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(albumOwner, "albumOwner");
        Intrinsics.checkNotNullParameter(addUsers, "addUsers");
        if (!NetworkUtil.isNetworkAvailable()) {
            d2("\u65e0\u7f51\u7edc");
            return;
        }
        PAAddAlbumPermissionsReq pAAddAlbumPermissionsReq = new PAAddAlbumPermissionsReq();
        pAAddAlbumPermissionsReq.albumId = albumId;
        pAAddAlbumPermissionsReq.albumOwner = xh.i.b(albumOwner);
        Iterator<T> it = addUsers.iterator();
        while (it.hasNext()) {
            pAAddAlbumPermissionsReq.addUsers.add(xh.i.b((CommonStUser) it.next()));
        }
        pAAddAlbumPermissionsReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.addAlbumPermissions(pAAddAlbumPermissionsReq, new IPersonalAlbumServiceAddAlbumPermissionsCallback() { // from class: nc.p
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceAddAlbumPermissionsCallback
                public final void onAddAlbumPermissions(PAAddAlbumPermissionsRsp pAAddAlbumPermissionsRsp) {
                    u.f2(pAAddAlbumPermissionsRsp);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailShareViewModel";
    }

    private final void d2(String errorMsg) {
        QQToastUtil.showQQToastInUiThread(4, errorMsg);
    }

    private final void a2() {
        QQToastUtil.showQQToastInUiThread(5, com.qzone.util.l.a(R.string.d6j));
    }

    public final void R1(String albumId, CommonStUser albumOwner, String coverUrl, String reason) {
        if (!(albumId == null || albumId.length() == 0) && albumOwner != null) {
            String uin = albumOwner.getUin();
            if (!(uin == null || uin.length() == 0)) {
                final long currentTimeMillis = System.currentTimeMillis();
                PAForwardAlbumToQzoneReq pAForwardAlbumToQzoneReq = new PAForwardAlbumToQzoneReq();
                pAForwardAlbumToQzoneReq.albumId = albumId;
                pAForwardAlbumToQzoneReq.albumOwner = xh.i.b(albumOwner);
                if (coverUrl == null) {
                    coverUrl = "";
                }
                pAForwardAlbumToQzoneReq.coverUrl = coverUrl;
                if (reason == null) {
                    reason = "";
                }
                pAForwardAlbumToQzoneReq.reason = reason;
                pAForwardAlbumToQzoneReq.requestTimeLine.requestInvokeTime = currentTimeMillis;
                com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
                if (b16 != null) {
                    b16.forwardAlbumToQzone(pAForwardAlbumToQzoneReq, new IPersonalAlbumServiceForwardAlbumToQzoneCallback() { // from class: nc.q
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceForwardAlbumToQzoneCallback
                        public final void onForwardAlbumToQzone(PAForwardAlbumToQzoneRsp pAForwardAlbumToQzoneRsp) {
                            u.S1(currentTimeMillis, this, pAForwardAlbumToQzoneRsp);
                        }
                    });
                    return;
                }
                return;
            }
        }
        RFWLog.e("QZAlbumxAlbumDetailShareViewModel", RFWLog.USR, "forwardAlbumToQzone albumid or albumOwner error");
    }
}
