package com.tencent.mobileqq.wink.api.impl;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.api.IQQWinkFragmentLoader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$DoActionReply;
import qshadow.ShadowAIGCStatus$GetStatusReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u009e\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u001e\u0010\u0018\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001a\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0016J2\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J,\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&H\u0016J:\u0010'\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010$2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0016J$\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00152\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070.H\u0016J$\u00100\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00152\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070.H\u0016J\u0018\u00101\u001a\u00020\u00072\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0016\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/QQWinkMagicStudioApiImpl;", "Lcom/tencent/mobileqq/wink/api/IQQWinkMagicStudioApi;", "()V", "getCaptureFragmentTag", "", "getMultiSelectFragmentTag", "handleMagicStudioStyleClickDirectly", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "magicStyleMaterial", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "buttonInfoResp", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "metaCategory", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "shareInfoCategory", "imagePath", "generateCount", "", "regenerate", "", "successCallback", "Lkotlin/Function2;", "", "failedCallback", "Lkotlin/Function0;", "cancelCallback", "shareCallback", "handleMagicStudioStyleOnClick", "jumpToMagicStudioFragment", "defaultStyleId", "jumpToMagicStudioFragmentBySchema", "activityIntent", "Landroid/content/Intent;", "schemaAttrs", "", "onActivityShareResult", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "requestMagicStudioButtonDoAction", "scene", "respCallback", "Lkotlin/Function1;", "Lqshadow/ShadowAIGCStatus$DoActionReply;", "requestMagicStudioButtonInfo", "updateMagicStudioPublishHistory", "publishMediaPaths", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QQWinkMagicStudioApiImpl implements IQQWinkMagicStudioApi {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMagicStudioPublishHistory$lambda$0(List list) {
        m83.a aVar = m83.a.f416440a;
        if (aVar.f() && aVar.b()) {
            aVar.j(list);
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    @NotNull
    public String getCaptureFragmentTag() {
        return "MAGIC_STUDIO_CAPTURE";
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    @NotNull
    public String getMultiSelectFragmentTag() {
        return "AIGCImgSelect";
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    public void handleMagicStudioStyleClickDirectly(@NotNull Activity activity, @NotNull Fragment fragment, @NotNull MetaMaterial magicStyleMaterial, @NotNull ShadowAIGCStatus$GetStatusReply buttonInfoResp, @Nullable MetaCategory metaCategory, @Nullable MetaCategory shareInfoCategory, @NotNull String imagePath, int generateCount, boolean regenerate, @NotNull Function2<? super List<String>, ? super Boolean, Unit> successCallback, @NotNull Function0<Unit> failedCallback, @NotNull Function0<Unit> cancelCallback, @NotNull Function0<Unit> shareCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(magicStyleMaterial, "magicStyleMaterial");
        Intrinsics.checkNotNullParameter(buttonInfoResp, "buttonInfoResp");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failedCallback, "failedCallback");
        Intrinsics.checkNotNullParameter(cancelCallback, "cancelCallback");
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        WinkMagicStudioLogicUtils.f323883a.m(activity, fragment, magicStyleMaterial, buttonInfoResp, metaCategory, shareInfoCategory, imagePath, generateCount, regenerate, successCallback, failedCallback, cancelCallback, shareCallback);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    public void handleMagicStudioStyleOnClick(@NotNull Activity activity, @NotNull Fragment fragment, @NotNull MetaMaterial magicStyleMaterial, @NotNull ShadowAIGCStatus$GetStatusReply buttonInfoResp, @Nullable MetaCategory metaCategory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(magicStyleMaterial, "magicStyleMaterial");
        Intrinsics.checkNotNullParameter(buttonInfoResp, "buttonInfoResp");
        WinkMagicStudioUtils.f323888a.h(activity, fragment, magicStyleMaterial, buttonInfoResp, metaCategory);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    public void jumpToMagicStudioFragment(@NotNull Activity activity, @Nullable String defaultStyleId, @Nullable MetaCategory metaCategory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = activity.getIntent();
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("magic_studio_style", defaultStyleId);
        intent.putExtra(IQQWinkMagicStudioApi.MAGIC_STUDIO_META_CATEGORY, metaCategory);
        activity.setIntent(intent);
        ((IQQWinkFragmentLoader) QRoute.api(IQQWinkFragmentLoader.class)).openMagicStudioFragment(activity);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    public void jumpToMagicStudioFragmentBySchema(@NotNull Activity activity, @NotNull Intent activityIntent, @NotNull Map<String, String> schemaAttrs) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activityIntent, "activityIntent");
        Intrinsics.checkNotNullParameter(schemaAttrs, "schemaAttrs");
        com.tencent.mobileqq.wink.schema.d.f326305a.a(schemaAttrs, activityIntent, null);
        activity.setIntent(activityIntent);
        ((IQQWinkFragmentLoader) QRoute.api(IQQWinkFragmentLoader.class)).openMagicStudioFragment(activity);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    public void onActivityShareResult(@Nullable Activity activity, int requestCode, int resultCode, @Nullable Intent data, @NotNull Function0<Unit> shareCallback) {
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        WinkMagicStudioLogicUtils.f323883a.v(activity, requestCode, resultCode, data, shareCallback);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    public void requestMagicStudioButtonDoAction(int scene, @NotNull Function1<? super ShadowAIGCStatus$DoActionReply, Unit> respCallback) {
        Intrinsics.checkNotNullParameter(respCallback, "respCallback");
        WinkMagicStudioUtils.f323888a.n(scene, respCallback);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    public void requestMagicStudioButtonInfo(int scene, @NotNull Function1<? super ShadowAIGCStatus$GetStatusReply, Unit> respCallback) {
        Intrinsics.checkNotNullParameter(respCallback, "respCallback");
        WinkMagicStudioUtils.f323888a.o(scene, respCallback);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi
    public void updateMagicStudioPublishHistory(@Nullable final List<String> publishMediaPaths) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                QQWinkMagicStudioApiImpl.updateMagicStudioPublishHistory$lambda$0(publishMediaPaths);
            }
        }, 64, null, false);
    }
}
