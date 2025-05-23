package com.tencent.mobileqq.wink.api.impl;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.WinkPhotoListServiceHandler;
import com.tencent.mobileqq.wink.listener.IRedPacketCategoryListener;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.templatelibrary.WinkTemplateServiceHandler;
import com.tencent.mobileqq.wink.templatelibrary.viewmodel.WinkTemplateViewModel;
import com.tencent.mobileqq.wink.utils.an;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes21.dex */
public class WinkEditorResourceAPIImpl implements IWinkEditorResourceAPI {
    private static String TAG = "WinkEditorResourceAPIImpl";
    private Observer<List<MetaCategory>> materialObserver;
    WinkEditorResourceManager winkEditorResourceManager = WinkEditorResourceManager.a1();
    private final MutableLiveData<String> mQQLogoPathLiveData = new MutableLiveData<>();

    /* loaded from: classes21.dex */
    class a implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f317981a;

        a(ResDownLoadListener resDownLoadListener) {
            this.f317981a = resDownLoadListener;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            this.f317981a.onDownloadFinish(z16);
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            this.f317981a.onProgressUpdate(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements Observer<List<MetaCategory>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.api.f f317983d;

        b(com.tencent.mobileqq.wink.api.f fVar) {
            this.f317983d = fVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<MetaCategory> list) {
            if (list != null) {
                w53.b.f(WinkEditorResourceAPIImpl.TAG, "[onChanged] metaCategories~~~: " + list.size());
                if (list.size() == 0) {
                    w53.b.f(WinkEditorResourceAPIImpl.TAG, "[onChanged] do not register ");
                    return;
                } else {
                    this.f317983d.a(list);
                    return;
                }
            }
            w53.b.f(WinkEditorResourceAPIImpl.TAG, "[onChanged] metaCategories is null  ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchEditorResource$0() {
        try {
            ((WinkDataServiceHandler) com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkDataServiceHandler.class.getName())).m3("MqKuaishanEdit");
        } catch (Exception e16) {
            w53.b.d(TAG, "[fetchEditorResource] exception: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchQZoneRecommendTemplateList$1() {
        try {
            new WinkDataServiceHandler(null).m3("MqQzonePhotoEditTemplate");
        } catch (Exception e16) {
            w53.b.d(TAG, "[fetchQZoneEditTemplate] exception: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchTemplateLibraryResource$2() {
        try {
            ((WinkTemplateServiceHandler) com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkTemplateServiceHandler.class.getName())).m3("MqKuaishanTemplate");
        } catch (Exception e16) {
            w53.b.d(TAG, "[fetchTemplateLibraryResource] exception: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchUserPublishInfo$3() {
        try {
            BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkDataServiceHandler.class.getName());
            if (businessHandler instanceof WinkDataServiceHandler) {
                ((WinkDataServiceHandler) businessHandler).q3();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(TAG, 1, "fetchUserPublishInfo error:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getRedPacketMaterialCategory$5() {
        BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkDataServiceHandler.class.getName());
        if (businessHandler instanceof WinkDataServiceHandler) {
            ((WinkDataServiceHandler) businessHandler).m3("MqKuaishanRedPacket");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestTemplateUserInfo$4() {
        ((WinkPhotoListServiceHandler) com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkPhotoListServiceHandler.class.getName())).requestTemplateUserInfo();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void clearData() {
        ms.a.f(TAG, "clearData...");
        this.winkEditorResourceManager.m0();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void downLoadOneResDirect(MetaMaterial metaMaterial, ResDownLoadListener resDownLoadListener) {
        this.winkEditorResourceManager.f(metaMaterial, new a(resDownLoadListener));
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void fetchEditorResource() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceAPIImpl.lambda$fetchEditorResource$0();
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void fetchQZoneRecommendTemplateList(com.tencent.mobileqq.wink.api.f fVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceAPIImpl.lambda$fetchQZoneRecommendTemplateList$1();
            }
        }, 64, null, false);
        registerPageInfoCallback(fVar);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void fetchTemplateLibraryResource() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceAPIImpl.lambda$fetchTemplateLibraryResource$2();
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void fetchUserPublishInfo() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceAPIImpl.lambda$fetchUserPublishInfo$3();
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public String getDownloadBasePath() {
        return this.winkEditorResourceManager.l();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public String getDownloadFolder(MetaMaterial metaMaterial) {
        return this.winkEditorResourceManager.m(metaMaterial);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public MutableLiveData<String> getQQLogoPathLiveData() {
        return this.mQQLogoPathLiveData;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public MutableLiveData<List<MetaCategory>> getQZoneRecommendTemplateMetaLiveData() {
        return WinkEditorResourceManager.a1().w1();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public ta3.a getRedDotImageSpan(Drawable drawable, int i3) {
        return new ta3.a(drawable, i3);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void getRedPacketMaterialCategory(final IRedPacketCategoryListener iRedPacketCategoryListener) {
        WinkEditorResourceManager.a1().i3();
        List<MetaCategory> value = WinkEditorResourceManager.a1().G1().getValue();
        if (value != null && !value.isEmpty()) {
            if (iRedPacketCategoryListener != null) {
                iRedPacketCategoryListener.onRedPacketCategoryReady(value);
            }
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorResourceAPIImpl.lambda$getRedPacketMaterialCategory$5();
                }
            }, 128, null, false);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.WinkEditorResourceAPIImpl.3

                /* renamed from: com.tencent.mobileqq.wink.api.impl.WinkEditorResourceAPIImpl$3$a */
                /* loaded from: classes21.dex */
                class a implements Observer<List<MetaCategory>> {

                    /* renamed from: d, reason: collision with root package name */
                    private final WeakReference<IRedPacketCategoryListener> f317979d;

                    a() {
                        this.f317979d = new WeakReference<>(iRedPacketCategoryListener);
                    }

                    @Override // androidx.lifecycle.Observer
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onChanged(List<MetaCategory> list) {
                        if (list != null && !list.isEmpty()) {
                            WinkEditorResourceManager.a1().G1().removeObserver(this);
                        } else {
                            ms.a.c(WinkEditorResourceAPIImpl.TAG, "getRedPacketTemplateCategory is null or empty");
                        }
                        IRedPacketCategoryListener iRedPacketCategoryListener = this.f317979d.get();
                        if (iRedPacketCategoryListener != null) {
                            iRedPacketCategoryListener.onRedPacketCategoryReady(list);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    WinkEditorResourceManager.a1().G1().observeForever(new a());
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public MutableLiveData<CircleTemplateInfo> getTemplateInfoLiveData() {
        return WinkEditorResourceManager.a1().M1();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public LiveData<List<MetaCategory>> getTemplateLibraryCategoriesLiveData(@NonNull ViewModelStoreOwner viewModelStoreOwner) {
        return ((WinkTemplateViewModel) new ViewModelProvider(viewModelStoreOwner).get(WinkTemplateViewModel.class)).Q1();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public MetaMaterial getTemplateLibraryMaterial(String str) {
        return WinkEditorResourceManager.a1().P1(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public boolean isApngFile(File file) {
        try {
            return an.f326680a.i(file);
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public boolean isCheckAIFace() {
        return uq3.c.T4();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public boolean isResExist(MetaMaterial metaMaterial) {
        return this.winkEditorResourceManager.q(metaMaterial);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public boolean isShowDynamicAvatar() {
        return uq3.c.G6();
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public boolean isTemplateLibraryConfigReady() {
        if (WinkEditorResourceManager.a1().p2() && ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public boolean isTemplateMaterialReady(String str) {
        return WinkEditorResourceManager.a1().q2(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void launcherPersonalCoverFeedPageScheme(String str, String str2, int i3) {
        String str3;
        String str4;
        String str5;
        if (!Objects.equals(str, QCircleScheme.AttrQQPublish.OPENPERSONALCOVERFEEDPAGE_AVATAR_FROM)) {
            str3 = "";
            str4 = str3;
            str5 = str4;
        } else {
            str3 = com.dataline.util.j.d("\u4ec5\u652f\u6301\u5c06\u516c\u5f00\u7684\u5c0f\u4e16\u754c\u89c6\u9891\u4f5c\u54c1\u8bbe\u7f6e\u4e3a\u5934\u50cf");
            str4 = "QQ\u5934\u50cf\u4f1a\u52a8\u5566";
            str5 = "qq_dynamicAvatar";
        }
        ((IQCircleService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQCircleService.class, "")).enterByScheme(BaseApplication.getContext(), "mqqapi://qcircle/openpersonalcoverfeedpage?tag=" + str4 + ContainerUtils.FIELD_DELIMITER + "taskid" + ContainerUtils.KEY_VALUE_DELIMITER + str5 + ContainerUtils.FIELD_DELIMITER + QCircleScheme.AttrQQPublish.BUSINESS_EMPTY_PAGE_TEXT + ContainerUtils.KEY_VALUE_DELIMITER + str3 + ContainerUtils.FIELD_DELIMITER + QCircleScheme.AttrQQPublish.FROM_ENTRANCE + ContainerUtils.KEY_VALUE_DELIMITER + str2 + ContainerUtils.FIELD_DELIMITER + QCircleSchemeAttr.CoverFeed.PROFILE_TYPE + ContainerUtils.KEY_VALUE_DELIMITER + i3);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void preDownloadMaterialResource(String str, ResDownLoadListener resDownLoadListener) {
        WinkEditorResourceManager.a1().g0(str, resDownLoadListener);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public boolean queryAB(String str, String str2, boolean z16) {
        return com.tencent.mobileqq.wink.editor.util.h.f322638a.i(str, str2, z16);
    }

    public void registerPageInfoCallback(com.tencent.mobileqq.wink.api.f fVar) {
        this.materialObserver = new b(fVar);
        WinkEditorResourceManager.a1().w1().observeForever(this.materialObserver);
        w53.b.f(TAG, "[registerPageInfoCallback] observeForever: " + this.materialObserver);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void requestTemplateUserInfo() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceAPIImpl.lambda$requestTemplateUserInfo$4();
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void unRegisterRecommendCallback() {
        WinkEditorResourceManager.a1().w1().removeObserver(this.materialObserver);
        w53.b.f(TAG, "[unRegisterRecommendCallback] removeObserver: " + this.materialObserver);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI
    public void updateDiyOnlineStatus(AppRuntime.Status status, long j3, DiyStatusEmoInfo diyStatusEmoInfo) {
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) com.tencent.mobileqq.wink.b.a().getRuntimeService(IOnlineStatusService.class, "all");
        if (status != null) {
            iOnlineStatusService.updateDiyOnlineStatus(status, j3, diyStatusEmoInfo);
        } else {
            iOnlineStatusService.updateDiyOnlineStatus(AppRuntime.Status.online, j3, diyStatusEmoInfo);
        }
    }
}
