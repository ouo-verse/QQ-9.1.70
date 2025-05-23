package com.tencent.mobileqq.wink.api;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$DoActionReply;
import qshadow.ShadowAIGCStatus$GetStatusReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 22\u00020\u0001:\u00013J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J,\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fH&J2\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u009e\u0001\u0010#\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u001e\u0010\u001e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b0\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u001fH&J:\u0010'\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u001fH&J\b\u0010(\u001a\u00020\u0004H&J\b\u0010)\u001a\u00020\u0004H&J$\u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00182\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0+H&J$\u0010/\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00182\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\b0+H&J\u0018\u00101\u001a\u00020\b2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001dH&\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IQQWinkMagicStudioApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "defaultStyleId", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategory", "", "jumpToMagicStudioFragment", "Landroid/content/Intent;", "intent", "", "schemaAttrs", "jumpToMagicStudioFragmentBySchema", "Landroidx/fragment/app/Fragment;", "fragment", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "magicStyleMaterial", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "buttonInfoResp", "handleMagicStudioStyleOnClick", "shareInfoCategory", "imagePath", "", "generateCount", "", "regenerate", "Lkotlin/Function2;", "", "successCallback", "Lkotlin/Function0;", "failedCallback", "cancelCallback", "shareCallback", "handleMagicStudioStyleClickDirectly", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityShareResult", "getMultiSelectFragmentTag", "getCaptureFragmentTag", "scene", "Lkotlin/Function1;", "respCallback", "requestMagicStudioButtonInfo", "Lqshadow/ShadowAIGCStatus$DoActionReply;", "requestMagicStudioButtonDoAction", "publishMediaPaths", "updateMagicStudioPublishHistory", "Companion", "a", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IQQWinkMagicStudioApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f317957a;

    @NotNull
    public static final String MAGIC_STUDIO_META_CATEGORY = "magic_studio_meta_category";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IQQWinkMagicStudioApi$a;", "", "<init>", "()V", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f317957a = new Companion();

        Companion() {
        }
    }

    @NotNull
    String getCaptureFragmentTag();

    @NotNull
    String getMultiSelectFragmentTag();

    void handleMagicStudioStyleClickDirectly(@NotNull Activity activity, @NotNull Fragment fragment, @NotNull MetaMaterial magicStyleMaterial, @NotNull ShadowAIGCStatus$GetStatusReply buttonInfoResp, @Nullable MetaCategory metaCategory, @Nullable MetaCategory shareInfoCategory, @NotNull String imagePath, int generateCount, boolean regenerate, @NotNull Function2<? super List<String>, ? super Boolean, Unit> successCallback, @NotNull Function0<Unit> failedCallback, @NotNull Function0<Unit> cancelCallback, @NotNull Function0<Unit> shareCallback);

    void handleMagicStudioStyleOnClick(@NotNull Activity activity, @NotNull Fragment fragment, @NotNull MetaMaterial magicStyleMaterial, @NotNull ShadowAIGCStatus$GetStatusReply buttonInfoResp, @Nullable MetaCategory metaCategory);

    void jumpToMagicStudioFragment(@NotNull Activity activity, @Nullable String defaultStyleId, @Nullable MetaCategory metaCategory);

    void jumpToMagicStudioFragmentBySchema(@NotNull Activity activity, @NotNull Intent intent, @NotNull Map<String, String> schemaAttrs);

    void onActivityShareResult(@Nullable Activity activity, int requestCode, int resultCode, @Nullable Intent data, @NotNull Function0<Unit> shareCallback);

    void requestMagicStudioButtonDoAction(int scene, @NotNull Function1<? super ShadowAIGCStatus$DoActionReply, Unit> respCallback);

    void requestMagicStudioButtonInfo(int scene, @NotNull Function1<? super ShadowAIGCStatus$GetStatusReply, Unit> respCallback);

    void updateMagicStudioPublishHistory(@Nullable List<String> publishMediaPaths);
}
