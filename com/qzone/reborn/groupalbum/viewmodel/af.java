package com.qzone.reborn.groupalbum.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\tJ\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000bR \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/af;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "groupId", "albumId", AEEditorConstants.ALBUMNAME, "", "W1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/qzone/reborn/layer/recommendphoto/QZoneFeedxLayerRecommendPhotoBean;", "U1", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "R1", "Z1", "b2", "data", "X1", "i", "Landroidx/lifecycle/MutableLiveData;", "mRecommendPhotoData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mAdvData", "Lki/ag;", BdhLogUtil.LogTag.Tag_Conn, "Lki/ag;", "mRecommendRepo", "D", "Ljava/lang/String;", "mGroupId", "E", "S1", "()Ljava/lang/String;", "setMAlbumId", "(Ljava/lang/String;)V", "mAlbumId", UserInfo.SEX_FEMALE, "T1", "setMAlbumName", "mAlbumName", "", "G", "Z", "mIsLoadedData", "H", "mIsLoadingData", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "I", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "mAdvCallback", "<init>", "()V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class af extends com.qzone.reborn.base.n {

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsLoadedData;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsLoadingData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> mRecommendPhotoData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<AlumBasicData>> mAdvData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final ki.ag mRecommendRepo = new ki.ag();

    /* renamed from: D, reason: from kotlin metadata */
    private String mGroupId = "";

    /* renamed from: E, reason: from kotlin metadata */
    private String mAlbumId = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String mAlbumName = "";

    /* renamed from: I, reason: from kotlin metadata */
    private final VasAdMetaCallback mAdvCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/af$b", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "retCode", "", "retMsg", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "albumBasicData", "", "onGetAdInfoResponse", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
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
            albumBasicData.sourceFrom = 2;
            af.this.mAdvData.postValue(UIStateData.obtainSuccess(true).setMsg(retMsg).setDataList(albumBasicData));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/af$c", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/layer/recommendphoto/QZoneFeedxLayerRecommendPhotoBean;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements n.a<QZoneFeedxLayerRecommendPhotoBean> {
        c() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZoneFeedxLayerRecommendPhotoBean t16, long retCode, String msg2, boolean isFinish) {
            long j3;
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            try {
                j3 = Long.parseLong(af.this.mGroupId);
            } catch (Exception unused) {
                j3 = 0;
            }
            t16.albumOwnerUin = j3;
            af.this.mIsLoadedData = true;
            af.this.X1(t16);
            af.this.mIsLoadingData = false;
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            RFWLog.e(af.this.getTAG(), RFWLog.USR, "requestRecommendAlbumInfo fail");
            af.this.mIsLoadingData = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(af this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).requestAdvAsync("7088010619062240", this$0.mAdvCallback);
    }

    public final MutableLiveData<UIStateData<AlumBasicData>> R1() {
        return this.mAdvData;
    }

    /* renamed from: S1, reason: from getter */
    public final String getMAlbumId() {
        return this.mAlbumId;
    }

    /* renamed from: T1, reason: from getter */
    public final String getMAlbumName() {
        return this.mAlbumName;
    }

    public final MutableLiveData<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> U1() {
        return this.mRecommendPhotoData;
    }

    public final void W1(String groupId, String albumId, String albumName) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        this.mGroupId = groupId;
        this.mAlbumId = albumId;
        this.mAlbumName = albumName;
    }

    public final void X1(QZoneFeedxLayerRecommendPhotoBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mRecommendPhotoData.postValue(UIStateData.obtainSuccess(true).setDataList(data));
    }

    public final void Z1() {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.ae
            @Override // java.lang.Runnable
            public final void run() {
                af.a2(af.this);
            }
        });
    }

    public final void b2() {
        if (this.mIsLoadedData || this.mIsLoadingData) {
            return;
        }
        this.mIsLoadingData = true;
        this.mRecommendRepo.d(this.mGroupId, this.mAlbumId, new c());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumLayerRecommendViewModel";
    }
}
