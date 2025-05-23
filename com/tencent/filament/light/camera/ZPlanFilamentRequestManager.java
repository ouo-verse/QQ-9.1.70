package com.tencent.filament.light.camera;

import cl0.c;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.filament.light.data.FilamentRequestStatus;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.AvatarSlot;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.filament.zplanservice.verify.ResourceCheckAlgorithmSelect;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rk0.b;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0003J4\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0010H\u0003J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0003J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0002J\f\u0010\u001e\u001a\u00020\u000b*\u00020\u000bH\u0002J=\u0010!\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0010H\u0082 J=\u0010#\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\"\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0010H\u0082 J\u001f\u0010%\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J\u001b\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u0004\u0018\u00010:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010?\u001a\n >*\u0004\u0018\u00010=0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006C"}, d2 = {"Lcom/tencent/filament/light/camera/ZPlanFilamentRequestManager;", "", "Lrk0/a;", QDLog.TAG_DOWNLOAD, "", "useCppDownloader", "", "Light3DFilamentRegisterDownloadImpl", "filamentGetUins", "", "requestID", "", "qquin", IndividuationUrlHelper.UrlId.SUIT_HOME, "FilamentGetAvatarAsset", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "slotURLs", "FilamentRequestResourceAsset", "FilamentDownloadDidCancel", "showSurroundSlot", "Lorg/json/JSONObject;", "avatarPbJson", "", "getMeshAnimationPaths", "", "slotId", "itemId", "effectSlotItemsString", "checkIsEffectSlot", "toMeshAnimPath", "status", "avatarInfos", "nRequestAvatarAssetsCallback", "paths", "nRequestRequestResourceAssetCallback", "animationBpPath", "filamentFetchMeshAction", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "avatarInfo", "fetchParticle", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "mRequester", "Lrk0/a;", "getMRequester", "()Lrk0/a;", "setMRequester", "(Lrk0/a;)V", "mUseCppDownloader", "Z", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "Lcl0/c;", "cppDownloadConfig", "Lcl0/c;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "avatarService", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "CLASS_PATTERN", "Ljava/util/regex/Pattern;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ZPlanFilamentRequestManager {
    private static final Pattern CLASS_PATTERN;

    @NotNull
    public static final ZPlanFilamentRequestManager INSTANCE = new ZPlanFilamentRequestManager();
    private static String TAG = "ZPlanFilamentRequestManager";
    private static final ZPlanAvatarService avatarService;
    private static final c cppDownloadConfig;

    @Nullable
    private static rk0.a mRequester;
    private static boolean mUseCppDownloader;
    private static final FilamentUrlTemplate urlTemplate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062F\u0010\u0003\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "avatarInfos", "Lcom/tencent/filament/light/data/FilamentRequestStatus;", "status", "", "a", "(Ljava/util/HashMap;Lcom/tencent/filament/light/data/FilamentRequestStatus;)V"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes2.dex */
    static final class a implements b {

        /* renamed from: a */
        final /* synthetic */ int f105568a;

        a(int i3) {
            this.f105568a = i3;
        }

        @Override // rk0.b
        public final void a(HashMap<String, String> avatarInfos, FilamentRequestStatus filamentRequestStatus) {
            ZPlanFilamentRequestManager zPlanFilamentRequestManager = ZPlanFilamentRequestManager.INSTANCE;
            int i3 = this.f105568a;
            int ordinal = filamentRequestStatus.ordinal();
            Intrinsics.checkNotNullExpressionValue(avatarInfos, "avatarInfos");
            zPlanFilamentRequestManager.nRequestAvatarAssetsCallback(i3, ordinal, avatarInfos);
        }
    }

    static {
        FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
        FilamentUrlTemplate F = filamentFeatureUtil.F();
        urlTemplate = F;
        c o16 = filamentFeatureUtil.o();
        FLog.INSTANCE.i(TAG, "cppDownloadConfig:" + o16);
        cppDownloadConfig = o16;
        avatarService = new ZPlanAvatarService(new com.tencent.filament.zplanservice.download.a(F.toString(), o16.getEnableCheck(), ResourceCheckAlgorithmSelect.INSTANCE.a(o16.getCheckSelect())));
        CLASS_PATTERN = Pattern.compile("Class'(.*)\\.(.*)'");
    }

    ZPlanFilamentRequestManager() {
    }

    @JvmStatic
    private static final void FilamentDownloadDidCancel(int requestID) {
        if (mRequester == null) {
            return;
        }
        com.tencent.filament.light.data.b bVar = new com.tencent.filament.light.data.b();
        bVar.f105572a = requestID;
        rk0.a aVar = mRequester;
        Intrinsics.checkNotNull(aVar);
        aVar.a(bVar);
    }

    @JvmStatic
    private static final void FilamentGetAvatarAsset(int requestID, String qquin, int r36) {
        if (mRequester == null) {
            INSTANCE.nRequestAvatarAssetsCallback(requestID, -10000, new HashMap<>());
            return;
        }
        com.tencent.filament.light.data.a aVar = new com.tencent.filament.light.data.a();
        aVar.f105569a = requestID;
        aVar.f105571c = qquin;
        aVar.f105570b = r36;
        rk0.a aVar2 = mRequester;
        Intrinsics.checkNotNull(aVar2);
        aVar2.b(aVar, new a(requestID));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [org.json.JSONObject, T] */
    @JvmStatic
    private static final void FilamentRequestResourceAsset(int requestID, HashMap<String, String> slotURLs) {
        T t16;
        boolean z16;
        FLog fLog = FLog.INSTANCE;
        fLog.i(TAG, "FilamentRequestResourceAsset params: " + requestID);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            String str = slotURLs.get("avatarInfo");
            JSONObject jSONObject = null;
            if (str != null) {
                t16 = new JSONObject(str);
            } else {
                t16 = 0;
            }
            objectRef.element = t16;
            String str2 = slotURLs.get("faceJson");
            if (str2 != null) {
                jSONObject = new JSONObject(str2);
            }
            String str3 = slotURLs.get("showOnlyHead");
            boolean z17 = false;
            if (str3 != null) {
                z16 = Intrinsics.areEqual(str3, "true");
            } else {
                z16 = false;
            }
            String str4 = slotURLs.get("showSurroundSlot");
            if (str4 != null) {
                z17 = Intrinsics.areEqual(str4, "true");
            }
            ZPlanFilamentRequestManager zPlanFilamentRequestManager = INSTANCE;
            List<String> meshAnimationPaths = zPlanFilamentRequestManager.getMeshAnimationPaths(z17, (JSONObject) objectRef.element);
            T t17 = objectRef.element;
            if (((JSONObject) t17) == null) {
                fLog.e(TAG, "FilamentRequestResourceAsset avatarJson is null");
                zPlanFilamentRequestManager.nRequestRequestResourceAssetCallback(requestID, FilamentRequestStatus.BAD_PARAMETER.ordinal(), new HashMap<>());
            } else {
                if (jSONObject != null) {
                    objectRef.element = ZPlanAvatarResourceHelper.f105660o.t((JSONObject) t17, jSONObject);
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3(objectRef, requestID, z16, meshAnimationPaths, null), 3, null);
            }
        } catch (JSONException unused) {
            FLog.INSTANCE.e(TAG, "FilamentRequestResourceAsset avatarJson or faceJson is invalidavatarJson: " + slotURLs.get("avatarInfo") + "; faceJson: " + slotURLs.get("faceJson"));
            INSTANCE.nRequestRequestResourceAssetCallback(requestID, FilamentRequestStatus.BAD_PARAMETER.ordinal(), new HashMap<>());
        }
    }

    @JvmStatic
    public static final void Light3DFilamentRegisterDownloadImpl(@Nullable rk0.a r06, boolean useCppDownloader) {
        mRequester = r06;
        mUseCppDownloader = useCppDownloader;
    }

    public static /* synthetic */ void Light3DFilamentRegisterDownloadImpl$default(rk0.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        Light3DFilamentRegisterDownloadImpl(aVar, z16);
    }

    private final boolean checkIsEffectSlot(long slotId, long itemId, JSONObject effectSlotItemsString) {
        if (effectSlotItemsString != null && !effectSlotItemsString.isNull("slot_items")) {
            JSONArray optJSONArray = effectSlotItemsString.optJSONArray("slot_items");
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    long optLong = optJSONObject.optLong(MiniAppReportManager2.KEY_SLOT_ID);
                    if (slotId != optLong) {
                        continue;
                    } else {
                        if (slotId == optLong && optJSONObject.isNull("items")) {
                            return true;
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                        int length2 = optJSONArray2.length();
                        for (int i16 = 0; i16 < length2; i16++) {
                            if (itemId == optJSONArray2.optLong(i16)) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        if (slotId != AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EARRINGS.getValue()) {
            return false;
        }
        return true;
    }

    private final List<String> getMeshAnimationPaths(boolean showSurroundSlot, JSONObject avatarPbJson) {
        JSONArray jSONArray;
        List<String> emptyList;
        JSONObject optJSONObject;
        if (avatarPbJson != null && (optJSONObject = avatarPbJson.optJSONObject("avatar_info")) != null) {
            jSONArray = optJSONObject.optJSONArray("slot_arr");
        } else {
            jSONArray = null;
        }
        if (jSONArray == null || jSONArray.length() <= 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject t16 = FilamentFeatureUtil.f106409g.t();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i3);
            if (optJSONObject2 != null) {
                long optLong = optJSONObject2.optLong(MiniAppReportManager2.KEY_SLOT_ID);
                if (checkIsEffectSlot(optLong, optJSONObject2.optLong("item_id"), t16) && !showSurroundSlot) {
                    jSONArray.remove(i3);
                } else {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("item_data");
                    if (optJSONObject3 != null) {
                        String actionPath = optJSONObject3.optString("animation_bp");
                        Intrinsics.checkNotNullExpressionValue(actionPath, "actionPath");
                        arrayList.add(actionPath);
                        FLog.INSTANCE.i(TAG, "filamentFetchAction target slot " + optLong + " actionPath is " + actionPath);
                    }
                }
            }
        }
        return arrayList;
    }

    public final native void nRequestAvatarAssetsCallback(int requestID, int status, HashMap<String, String> avatarInfos);

    public final native void nRequestRequestResourceAssetCallback(int requestID, int status, HashMap<String, String> paths);

    public final String toMeshAnimPath(String str) {
        boolean startsWith$default;
        String result = "";
        Matcher matcher = CLASS_PATTERN.matcher(str);
        try {
            if (matcher.find()) {
                result = matcher.group(1);
            }
        } catch (Exception unused) {
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(result, "/Game/", false, 2, null);
        if (startsWith$default) {
            result = result.substring(6);
            Intrinsics.checkNotNullExpressionValue(result, "(this as java.lang.String).substring(startIndex)");
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    public final /* synthetic */ Object fetchParticle(JSONObject jSONObject, Continuation<? super String> continuation) {
        return CoroutineScopeKt.coroutineScope(new ZPlanFilamentRequestManager$fetchParticle$2(jSONObject, null), continuation);
    }

    public final /* synthetic */ Object filamentFetchMeshAction(String str, Continuation<? super String> continuation) {
        return CoroutineScopeKt.coroutineScope(new ZPlanFilamentRequestManager$filamentFetchMeshAction$2(str, null), continuation);
    }

    @Nullable
    public final rk0.a getMRequester() {
        return mRequester;
    }

    public final void setMRequester(@Nullable rk0.a aVar) {
        mRequester = aVar;
    }

    private final void filamentGetUins() {
    }
}
