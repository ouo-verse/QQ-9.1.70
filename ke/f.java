package ke;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.reborn.base.n;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004J\"\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fR \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lke/f;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/qzone/reborn/layer/recommendphoto/QZoneFeedxLayerRecommendPhotoBean;", "S1", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "R1", "albumId", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "albumOwner", "", "refer", "", "T1", "X1", "U1", "i", "Landroidx/lifecycle/MutableLiveData;", "recommendPhotoData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "advData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "D", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "getAlbumOwner", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "setAlbumOwner", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;)V", "E", "I", "getRefer", "()I", "setRefer", "(I)V", "", UserInfo.SEX_FEMALE, "Z", "isLoadedData", "G", "isLoadingData", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "H", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "mAdvCallback", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends n {

    /* renamed from: D, reason: from kotlin metadata */
    private CommonUser albumOwner;

    /* renamed from: E, reason: from kotlin metadata */
    private int refer;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLoadedData;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isLoadingData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> recommendPhotoData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<AlumBasicData>> advData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private String albumId = "";

    /* renamed from: H, reason: from kotlin metadata */
    private final VasAdMetaCallback mAdvCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"ke/f$b", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "retCode", "", "retMsg", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "albumBasicData", "", "onGetAdInfoResponse", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements VasAdMetaCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback
        public void onGetAdInfoResponse(VasAdvServiceCode retCode, String retMsg, AlumBasicData albumBasicData) {
            Intrinsics.checkNotNullParameter(retCode, "retCode");
            if (albumBasicData == null) {
                return;
            }
            albumBasicData.retCode = retCode;
            albumBasicData.sourceFrom = 1;
            f.this.advData.postValue(UIStateData.obtainSuccess(true).setMsg(retMsg).setDataList(albumBasicData));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"ke/f$c", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/layer/recommendphoto/QZoneFeedxLayerRecommendPhotoBean;", "data", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements n.a<QZoneFeedxLayerRecommendPhotoBean> {
        c() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZoneFeedxLayerRecommendPhotoBean data, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            f.this.isLoadedData = true;
            f.this.recommendPhotoData.postValue(UIStateData.obtainSuccess(true).setDataList(data));
            f.this.isLoadingData = false;
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e("QzoneFeedProLayerRecommendViewModel", 1, "requestRecommendAlbumInfo fail, error code is " + errorCode + ", error msg is " + errorMsg);
            f.this.isLoadingData = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(long j3, int i3, f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vac_adv_get.QzoneBusiMsg qzoneBusiMsg = new vac_adv_get.QzoneBusiMsg();
        qzoneBusiMsg.device_info.set(QZoneRequest.getDeiviceInfoDetail(true));
        ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).requestAdvAsync(new VasAdMetaParam(j3, i3, qzoneBusiMsg, this$0.refer), this$0.mAdvCallback);
    }

    public final MutableLiveData<UIStateData<AlumBasicData>> R1() {
        return this.advData;
    }

    public final MutableLiveData<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> S1() {
        return this.recommendPhotoData;
    }

    public final void U1() {
        final long uin = LoginData.getInstance().getUin();
        final int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.i("QzoneFeedProLayerRecommendViewModel", 2, "getGdtInfoRequest uin= " + uin + "advType = 2");
        }
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: ke.e
            @Override // java.lang.Runnable
            public final void run() {
                f.W1(uin, i3, this);
            }
        });
    }

    public final void X1() {
        if (this.isLoadedData || this.isLoadingData) {
            return;
        }
        CommonUser commonUser = this.albumOwner;
        if (commonUser == null) {
            QLog.e("QzoneFeedProLayerRecommendViewModel", 1, "album owner is null");
            return;
        }
        this.isLoadingData = true;
        he.a aVar = he.a.f404779a;
        String str = this.albumId;
        Intrinsics.checkNotNull(commonUser);
        aVar.a(str, commonUser, new c());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProLayerRecommendViewModel";
    }

    public final void T1(String albumId, CommonUser albumOwner, int refer) {
        if (albumId == null) {
            albumId = "";
        }
        this.albumId = albumId;
        this.albumOwner = albumOwner;
        this.refer = refer;
    }
}
