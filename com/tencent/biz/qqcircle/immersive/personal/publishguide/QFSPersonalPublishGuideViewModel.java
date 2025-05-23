package com.tencent.biz.qqcircle.immersive.personal.publishguide;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSPublishGuideBannerNegativeFeedbackReq;
import com.tencent.biz.qqcircle.utils.y;
import com.tencent.biz.qqcircle.utils.z;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudPubGuideSvr$NegativeFeedbackRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0006R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/QFSPersonalPublishGuideViewModel;", "Lcom/tencent/biz/qqcircle/viewmodels/a;", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/NegFeedbackType;", "negFeedbackType", "", "bannerId", "", "W1", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/biz/qqcircle/immersive/personal/bean/QFSPersonalInfo;", "personalInfo", "R1", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/a;", "bannerInfo", "T1", "U1", "Z1", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MediatorLiveData;", "_publishGuideData", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "publishGuideData", "", "D", "Z", "isBannerCanceled", "E", "isBannerDestroyed", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalPublishGuideViewModel extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<PublishGuideData> publishGuideData;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isBannerCanceled;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isBannerDestroyed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PublishGuideData> _publishGuideData;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/publishguide/QFSPersonalPublishGuideViewModel$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BannerInfo f88970a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f88971b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QFSPersonalPublishGuideViewModel f88972c;

        b(BannerInfo bannerInfo, Activity activity, QFSPersonalPublishGuideViewModel qFSPersonalPublishGuideViewModel) {
            this.f88970a = bannerInfo;
            this.f88971b = activity;
            this.f88972c = qFSPersonalPublishGuideViewModel;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            String jumpUrl = this.f88970a.getJumpUrl();
            com.tencent.biz.qqcircle.launcher.c.g(this.f88971b, jumpUrl + y.b(jumpUrl, 8));
            this.f88972c.U1(this.f88970a);
        }
    }

    public QFSPersonalPublishGuideViewModel() {
        MediatorLiveData<PublishGuideData> mediatorLiveData = new MediatorLiveData<>();
        this._publishGuideData = mediatorLiveData;
        this.publishGuideData = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void W1(NegFeedbackType negFeedbackType, String bannerId) {
        sendRequest(new QFSPublishGuideBannerNegativeFeedbackReq(negFeedbackType, bannerId), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.personal.publishguide.l
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSPersonalPublishGuideViewModel.X1(baseRequest, z16, j3, str, (FeedCloudPubGuideSvr$NegativeFeedbackRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudPubGuideSvr$NegativeFeedbackRsp feedCloudPubGuideSvr$NegativeFeedbackRsp) {
        String str2;
        if (baseRequest != null) {
            str2 = baseRequest.getTraceId();
        } else {
            str2 = null;
        }
        QLog.i("QFSPersonalPublishGuideViewModel", 1, "sendNegativeFeedbackReq, onReceive, traceId:" + str2 + ", isSuccess:" + z16 + ", retCode:" + j3 + ", errMsg:" + str);
    }

    @NotNull
    public final LiveData<PublishGuideData> Q1() {
        return this.publishGuideData;
    }

    public final void R1(@NotNull LiveData<QFSPersonalInfo> personalInfo) {
        Intrinsics.checkNotNullParameter(personalInfo, "personalInfo");
        QFSPersonalInfo value = personalInfo.getValue();
        boolean z16 = false;
        if (value != null && value.f88425l) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        this._publishGuideData.removeSource(personalInfo);
        MediatorLiveData<PublishGuideData> mediatorLiveData = this._publishGuideData;
        final Function1<QFSPersonalInfo, Unit> function1 = new Function1<QFSPersonalInfo, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.publishguide.QFSPersonalPublishGuideViewModel$observePersonalInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSPersonalInfo qFSPersonalInfo) {
                invoke2(qFSPersonalInfo);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QFSPersonalInfo qFSPersonalInfo) {
                boolean z17;
                MediatorLiveData mediatorLiveData2;
                MediatorLiveData mediatorLiveData3;
                int collectionSizeOrDefault;
                Set set;
                int collectionSizeOrDefault2;
                Set set2;
                List<BannerInfo> a16;
                boolean z18;
                MediatorLiveData mediatorLiveData4;
                MediatorLiveData mediatorLiveData5;
                z17 = QFSPersonalPublishGuideViewModel.this.isBannerCanceled;
                if (z17) {
                    return;
                }
                mediatorLiveData2 = QFSPersonalPublishGuideViewModel.this._publishGuideData;
                PublishGuideData publishGuideData = (PublishGuideData) mediatorLiveData2.getValue();
                PublishGuideData publishGuideData2 = qFSPersonalInfo.N;
                if (publishGuideData2 == null && publishGuideData != null) {
                    QLog.i("QFSPersonalPublishGuideViewModel", 1, "\u9700\u8981\u6e05\u7a7a\u672c\u5730\u6570\u636e, remoteData=" + publishGuideData2);
                    mediatorLiveData5 = QFSPersonalPublishGuideViewModel.this._publishGuideData;
                    mediatorLiveData5.postValue(null);
                    return;
                }
                if (publishGuideData2 == null) {
                    QLog.i("QFSPersonalPublishGuideViewModel", 1, "\u8fdc\u7a0b\u6570\u636e\u4e3a\u7a7a");
                    return;
                }
                if ((publishGuideData != null ? publishGuideData.getBannerStyle() : null) == null || publishGuideData.getBannerStyle() == publishGuideData2.getBannerStyle()) {
                    if (Intrinsics.areEqual(publishGuideData != null ? publishGuideData.a() : null, publishGuideData2.a())) {
                        z18 = QFSPersonalPublishGuideViewModel.this.isBannerDestroyed;
                        if (z18) {
                            QLog.i("QFSPersonalPublishGuideViewModel", 1, "\u672c\u5730\u6570\u636e\u548c\u8fdc\u7a0b\u6570\u636ebannerInfos\u76f8\u540c\uff0cbanner\u9500\u6bc1\u9700\u8981\u66f4\u65b0");
                            mediatorLiveData4 = QFSPersonalPublishGuideViewModel.this._publishGuideData;
                            mediatorLiveData4.postValue(publishGuideData2);
                        } else {
                            QLog.i("QFSPersonalPublishGuideViewModel", 1, "\u672c\u5730\u6570\u636e\u548c\u8fdc\u7a0b\u6570\u636ebannerInfos\u76f8\u540c\uff0c\u653e\u5f03\u6b64\u6b21\u66f4\u65b0");
                            return;
                        }
                    }
                    boolean z19 = false;
                    if (publishGuideData != null && (a16 = publishGuideData.a()) != null && a16.size() == publishGuideData2.a().size()) {
                        z19 = true;
                    }
                    if (z19) {
                        QLog.i("QFSPersonalPublishGuideViewModel", 1, "\u672c\u5730\u6570\u636e\u548c\u8fdc\u7a0b\u6570\u636ebannerInfos\u76f8\u540c\uff0c\u53ea\u662f\u987a\u5e8f\u4e0d\u540c\uff0c\u653e\u5f03\u6b64\u6b21\u66f4\u65b0");
                        List<BannerInfo> a17 = publishGuideData.a();
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a17, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it = a17.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((BannerInfo) it.next()).getId());
                        }
                        set = CollectionsKt___CollectionsKt.toSet(arrayList);
                        List<BannerInfo> a18 = publishGuideData2.a();
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(a18, 10);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                        Iterator<T> it5 = a18.iterator();
                        while (it5.hasNext()) {
                            arrayList2.add(((BannerInfo) it5.next()).getId());
                        }
                        set2 = CollectionsKt___CollectionsKt.toSet(arrayList2);
                        if (Intrinsics.areEqual(set, set2)) {
                            return;
                        }
                    }
                    mediatorLiveData3 = QFSPersonalPublishGuideViewModel.this._publishGuideData;
                    mediatorLiveData3.postValue(publishGuideData2);
                    return;
                }
                QLog.i("QFSPersonalPublishGuideViewModel", 1, "\u672c\u5730\u6570\u636e\u548c\u8fdc\u7a0b\u6570\u636estyle\u4e0d\u540c\uff0c\uff0c\u653e\u5f03\u6b64\u6b21\u66f4\u65b0");
            }
        };
        mediatorLiveData.addSource(personalInfo, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.publishguide.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalPublishGuideViewModel.S1(Function1.this, obj);
            }
        });
    }

    public final void T1(@NotNull Activity activity, @NotNull BannerInfo bannerInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        z.b(activity, 2, new b(bannerInfo, activity, this), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_MATERIAL_GUILD), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    public final void U1(@NotNull BannerInfo bannerInfo) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        PublishGuideData value = this._publishGuideData.getValue();
        if (value != null && value.a().remove(bannerInfo)) {
            W1(NegFeedbackType.SINGLE_CLOSE, bannerInfo.getId());
            this._publishGuideData.setValue(value);
            if (value.a().isEmpty()) {
                this.isBannerCanceled = true;
            }
        }
    }

    public final void Z1() {
        this.isBannerDestroyed = true;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalPublishGuideViewModel";
    }
}
