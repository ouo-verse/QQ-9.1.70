package com.tencent.mobileqq.wink.api;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStoreOwner;
import camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.wink.listener.IRedPacketCategoryListener;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import java.io.File;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkEditorResourceAPI extends QRouteApi {
    public static final String QZONE_A_KEY_LOCALMEDIAINFOS = "qzone_a_key_localmediainfos";
    public static final String RECOMMEND_METAMATERIALS = "recommend_metamaterials";

    void clearData();

    void downLoadOneResDirect(MetaMaterial metaMaterial, ResDownLoadListener resDownLoadListener);

    void fetchEditorResource();

    void fetchQZoneRecommendTemplateList(f fVar);

    void fetchTemplateLibraryResource();

    void fetchUserPublishInfo();

    String getDownloadBasePath();

    String getDownloadFolder(MetaMaterial metaMaterial);

    MutableLiveData<String> getQQLogoPathLiveData();

    MutableLiveData<List<MetaCategory>> getQZoneRecommendTemplateMetaLiveData();

    ta3.a getRedDotImageSpan(Drawable drawable, int i3);

    void getRedPacketMaterialCategory(IRedPacketCategoryListener iRedPacketCategoryListener);

    MutableLiveData<CircleTemplateInfo> getTemplateInfoLiveData();

    LiveData<List<MetaCategory>> getTemplateLibraryCategoriesLiveData(@NonNull ViewModelStoreOwner viewModelStoreOwner);

    MetaMaterial getTemplateLibraryMaterial(String str);

    boolean isApngFile(File file);

    boolean isCheckAIFace();

    boolean isResExist(MetaMaterial metaMaterial);

    boolean isShowDynamicAvatar();

    boolean isTemplateLibraryConfigReady();

    boolean isTemplateMaterialReady(String str);

    void launcherPersonalCoverFeedPageScheme(String str, String str2, int i3);

    void preDownloadMaterialResource(String str, ResDownLoadListener resDownLoadListener);

    boolean queryAB(String str, String str2, boolean z16);

    void requestTemplateUserInfo();

    void unRegisterRecommendCallback();

    void updateDiyOnlineStatus(AppRuntime.Status status, long j3, DiyStatusEmoInfo diyStatusEmoInfo);
}
