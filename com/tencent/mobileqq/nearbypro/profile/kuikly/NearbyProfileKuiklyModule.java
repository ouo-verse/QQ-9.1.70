package com.tencent.mobileqq.nearbypro.profile.kuikly;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.utils.r;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.zplan.avatar.RecordResult;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarEditResourceManagerFactory;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi;
import com.tencent.mobileqq.zplan.avatar.edit.BackgroundInfo;
import com.tencent.mobileqq.zplan.avatar.edit.ClipperInfo;
import com.tencent.mobileqq.zplan.avatar.edit.d;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.zplan.meme.Priority;
import i01.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002JI\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017j\u0004\u0018\u0001`\u001cH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R&\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00040'j\b\u0012\u0004\u0012\u00020\u0004`(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R;\u0010>\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/kuikly/NearbyProfileKuiklyModule;", "Li01/e;", "Lcom/tencent/zplan/meme/Priority;", "priority", "", "reqFrom", "", "p", "j", "", "o", "id", "", "path", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/Runnable;", "l", "composeImagePath", "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "editAvatarData", "i", "method", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Lcom/tencent/mobileqq/zplan/avatar/fragment/a;", "d", "Lcom/tencent/mobileqq/zplan/avatar/fragment/a;", "mResourceManager", "Lorg/json/JSONArray;", "e", "Lorg/json/JSONArray;", "mAvatarActionInfos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "mActionIdList", h.F, "Ljava/lang/String;", "mCurAppearanceKey", "I", "mPreRecNum", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "mLoadingTime", BdhLogUtil.LogTag.Tag_Conn, "Z", "mFinishFirstBatch", "Ljava/util/concurrent/ConcurrentHashMap;", "D", "Ljava/util/concurrent/ConcurrentHashMap;", "idToAvatarDataMap", "E", "Lkotlin/jvm/functions/Function1;", "recordActionCallback", "Lcom/tencent/mobileqq/zplan/avatar/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zplan/avatar/a;", "onAvatarRecordListener", "<init>", "()V", "G", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProfileKuiklyModule extends e {

    @NotNull
    private static final byte[] H;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mFinishFirstBatch;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> recordActionCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.zplan.avatar.fragment.a mResourceManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mPreRecNum;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long mLoadingTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private JSONArray mAvatarActionInfos = new JSONArray();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Integer> mActionIdList = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurAppearanceKey = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, d> idToAvatarDataMap = new ConcurrentHashMap<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.zplan.avatar.a onAvatarRecordListener = new c();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/nearbypro/profile/kuikly/NearbyProfileKuiklyModule$b", "Lcom/tencent/mobileqq/zplan/avatar/edit/e;", "", "isSuccess", "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "avatarData1", "", "filePath", "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements com.tencent.mobileqq.zplan.avatar.edit.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f253755b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f253756c;

        b(d dVar, Function1<Object, Unit> function1) {
            this.f253755b = dVar;
            this.f253756c = function1;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.edit.e
        public void a(boolean isSuccess, @NotNull d avatarData1, @Nullable String filePath) {
            Intrinsics.checkNotNullParameter(avatarData1, "avatarData1");
            if (isSuccess && !TextUtils.isEmpty(filePath)) {
                Intrinsics.checkNotNull(filePath);
                if (r.a(filePath)) {
                    String i3 = NearbyProfileKuiklyModule.this.i(filePath, this.f253755b);
                    Function1<Object, Unit> function1 = this.f253756c;
                    if (function1 != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("isSuccess", true);
                        jSONObject.put("composeAvatarPath", i3);
                        function1.invoke(jSONObject);
                        return;
                    }
                    return;
                }
                j.c().d("NearbyProfileKuiklyModule", "composeAvatarImage fail, filePath is not exit");
                return;
            }
            j.c().d("NearbyProfileKuiklyModule", "composeAvatarImage fail, isSuccess: " + isSuccess + ", filePath: " + filePath);
            Function1<Object, Unit> function12 = this.f253756c;
            if (function12 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isSuccess", isSuccess);
                jSONObject2.put("composeAvatarPath", filePath);
                function12.invoke(jSONObject2);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/profile/kuikly/NearbyProfileKuiklyModule$c", "Lcom/tencent/mobileqq/zplan/avatar/a;", "Lcom/tencent/mobileqq/zplan/avatar/c;", "result", "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements com.tencent.mobileqq.zplan.avatar.a {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.a
        public void a(@NotNull RecordResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (NearbyProfileKuiklyModule.this.mResourceManager == null) {
                j.c().d("NearbyProfileKuiklyModule", "recordEditAvatar onRecordDone mResourceManager is empty");
                return;
            }
            boolean isSuccess = result.getIsSuccess();
            int actionId = result.getActionId();
            String recordPath = result.getRecordPath();
            if (isSuccess && !TextUtils.isEmpty(recordPath) && actionId != -1) {
                NearbyProfileKuiklyModule nearbyProfileKuiklyModule = NearbyProfileKuiklyModule.this;
                Intrinsics.checkNotNull(recordPath);
                nearbyProfileKuiklyModule.q(actionId, recordPath);
                j.c().e("NearbyProfileKuiklyModule", "recordEditAvatar onRecordDone success id:" + actionId + " recordPath\uff1a" + recordPath);
                return;
            }
            ga2.a c16 = j.c();
            c16.d("NearbyProfileKuiklyModule", "[onRecordDone]" + ("\u5f55\u5236id" + actionId + "\u5931\u8d25"));
            com.tencent.mobileqq.zplan.avatar.fragment.a aVar = NearbyProfileKuiklyModule.this.mResourceManager;
            if (aVar != null) {
                aVar.a(actionId, -1, "");
            }
        }
    }

    static {
        byte[] byteArray;
        ArrayList arrayList = new ArrayList("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".length());
        for (int i3 = 0; i3 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".length(); i3++) {
            arrayList.add(Byte.valueOf((byte) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(i3)));
        }
        byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
        H = byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(String composeImagePath, d editAvatarData) {
        String str;
        Bitmap decodeFile = BitmapFactory.decodeFile(composeImagePath);
        int min = Math.min(editAvatarData.getAvatarSize(), 150);
        Bitmap roundedCornerBitmap2 = BaseImageUtil.getRoundedCornerBitmap2(decodeFile, min / 2, min, min);
        File file = new File(BaseApplication.getContext().getCacheDir(), "lplan/avatars/");
        int actionId = editAvatarData.getActionId();
        BackgroundInfo backgroundInfo = editAvatarData.getBackgroundInfo();
        if (backgroundInfo == null || (str = backgroundInfo.getUrl()) == null) {
            str = "";
        }
        File file2 = new File(file, "avatar_" + actionId + "_" + MD5Utils.toMD5(str) + ".png");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    roundedCornerBitmap2.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    String absolutePath = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e16) {
                        j.c().d("NearbyProfileKuiklyModule", "cropComposeAvatarImageRounded out close failed, exception: " + e16);
                    }
                    return absolutePath;
                } catch (Exception e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    j.c().d("NearbyProfileKuiklyModule", "cropComposeAvatarImageRounded failed, exception: " + e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            j.c().d("NearbyProfileKuiklyModule", "cropComposeAvatarImageRounded out close failed, exception: " + e18);
                        }
                    }
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            j.c().d("NearbyProfileKuiklyModule", "cropComposeAvatarImageRounded out close failed, exception: " + e19);
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private final void j() {
        j.c().e("NearbyProfileKuiklyModule", "[fillDefaultAppearanceAvatarActionInfo]");
        if (this.mAvatarActionInfos.length() == 0) {
            j.c().d("NearbyProfileKuiklyModule", "[fillDefaultAppearanceAvatarActionInfo] mAvatarActionInfos empty");
            return;
        }
        if (this.mResourceManager == null) {
            j.c().d("NearbyProfileKuiklyModule", "[fillDefaultAppearanceAvatarActionInfo] mResourceManager empty");
            return;
        }
        int length = this.mAvatarActionInfos.length();
        for (int i3 = 0; i3 < length; i3++) {
            final JSONObject jSONObject = this.mAvatarActionInfos.getJSONObject(i3);
            final String defaultUrl = jSONObject.optString("defaultUrl");
            if (TextUtils.isEmpty(defaultUrl)) {
                j.c().e("NearbyProfileKuiklyModule", "[fillDefaultAppearanceAvatarActionInfo] actionDefaultPicUrl empty");
            } else {
                IZPlanEditAvatarApi iZPlanEditAvatarApi = (IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class);
                Intrinsics.checkNotNullExpressionValue(defaultUrl, "defaultUrl");
                iZPlanEditAvatarApi.downloadShpImagePackage(defaultUrl, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.profile.kuikly.NearbyProfileKuiklyModule$fillDefaultAppearanceAvatarActionInfo$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                        invoke2(bool, str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Boolean bool, @Nullable String str) {
                        Intrinsics.checkNotNull(bool);
                        if (!bool.booleanValue() || TextUtils.isEmpty(str)) {
                            return;
                        }
                        j.c().e("NearbyProfileKuiklyModule", "[fillDefaultAppearanceAvatarActionInfo] downloadShpImagePackage url:" + defaultUrl);
                        NearbyProfileKuiklyModule nearbyProfileKuiklyModule = this;
                        int optInt = jSONObject.optInt("actionId");
                        Intrinsics.checkNotNull(str);
                        nearbyProfileKuiklyModule.q(optInt, str);
                    }
                });
            }
        }
    }

    private final Runnable l(final int id5, final String path) {
        return new Runnable() { // from class: com.tencent.mobileqq.nearbypro.profile.kuikly.a
            @Override // java.lang.Runnable
            public final void run() {
                NearbyProfileKuiklyModule.m(NearbyProfileKuiklyModule.this, id5, path);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(NearbyProfileKuiklyModule this$0, int i3, String path) {
        d dVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        if (this$0.mAvatarActionInfos.length() == 0) {
            j.c().d("NearbyProfileKuiklyModule", "setActionPicPathByActionId mAvatarActionInfos is empty");
            return;
        }
        if (this$0.mResourceManager == null) {
            j.c().d("NearbyProfileKuiklyModule", "setActionPicPathByActionId mResourceManager is null");
            return;
        }
        ConcurrentHashMap<Integer, d> concurrentHashMap = this$0.idToAvatarDataMap;
        List<Integer> list = null;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            dVar = this$0.idToAvatarDataMap.get(Integer.valueOf(i3));
        } else {
            dVar = null;
        }
        String avatarPathV2 = ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).getAvatarPathV2(i3, path, dVar, this$0.mCurAppearanceKey, 0, "lplan/avatar/png_normal/");
        if (TextUtils.isEmpty(avatarPathV2)) {
            j.c().d("NearbyProfileKuiklyModule", "crop normal avatar failed.");
            return;
        }
        j.c().e("NearbyProfileKuiklyModule", "crop done, id: " + i3 + ", inBoundsPath: " + avatarPathV2);
        int length = this$0.mAvatarActionInfos.length();
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                break;
            }
            JSONObject jSONObject = this$0.mAvatarActionInfos.getJSONObject(i16);
            if (jSONObject.optInt("actionId") == i3) {
                jSONObject.put("avatarNormalPath", avatarPathV2);
                break;
            }
            i16++;
        }
        j.c().e("NearbyProfileKuiklyModule", "setActionPicPathByActionId id:" + i3 + " path:" + path);
        com.tencent.mobileqq.zplan.avatar.fragment.a aVar = this$0.mResourceManager;
        if (aVar != null) {
            aVar.a(i3, 1, path);
        }
        com.tencent.mobileqq.zplan.avatar.fragment.a aVar2 = this$0.mResourceManager;
        if (aVar2 != null) {
            list = aVar2.c(this$0.mActionIdList, this$0.mPreRecNum);
        }
        if (list != null) {
            if (!this$0.mFinishFirstBatch) {
                j.c().e("NearbyProfileKuiklyModule", "\u5f55\u5236\u5b8c\u6210\u7528\u65f6" + (System.currentTimeMillis() - this$0.mLoadingTime) + "ms");
            }
            this$0.mFinishFirstBatch = true;
            Function1<Object, Unit> function1 = this$0.recordActionCallback;
            if (function1 != null) {
                JSONArray jSONArray = new JSONArray();
                int length2 = this$0.mAvatarActionInfos.length();
                for (int i17 = 0; i17 < length2; i17++) {
                    JSONObject jSONObject2 = this$0.mAvatarActionInfos.getJSONObject(i17);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("actionId", jSONObject2.optInt("actionId"));
                    jSONObject3.put("avatarNormalPath", jSONObject2.optString("avatarNormalPath"));
                    jSONArray.mo162put(jSONObject3);
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("headActionDataList", jSONArray);
                function1.invoke(jSONObject4);
                return;
            }
            return;
        }
        com.tencent.mobileqq.zplan.avatar.fragment.a aVar3 = this$0.mResourceManager;
        if (aVar3 != null) {
            aVar3.b(this$0.mActionIdList, this$0.mPreRecNum);
        }
    }

    private final boolean o() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            return false;
        }
        if (TextUtils.isEmpty(this.mCurAppearanceKey)) {
            IZPlanDataHelper iZPlanDataHelper = (IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class);
            Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
            this.mCurAppearanceKey = iZPlanDataHelper.getUserZPlanInfo(currentUin).appearanceKey;
        }
        if (!TextUtils.isEmpty(this.mCurAppearanceKey) && !Intrinsics.areEqual("zplan_default_appearance_key", this.mCurAppearanceKey)) {
            return false;
        }
        j.c().e("NearbyProfileKuiklyModule", "[getIsZplanHasDefaultAppearance] zplan has default appearanceKey");
        return true;
    }

    private final void p(Priority priority, int reqFrom) {
        j.c().e("NearbyProfileKuiklyModule", "recordEditAvatar-recordAction start");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            j.c().f("NearbyProfileKuiklyModule", "recordEditAvatar-recordAction currentUin null!!");
            return;
        }
        IZPlanAvatarEditResourceManagerFactory iZPlanAvatarEditResourceManagerFactory = (IZPlanAvatarEditResourceManagerFactory) QRoute.api(IZPlanAvatarEditResourceManagerFactory.class);
        ArrayList<Integer> arrayList = this.mActionIdList;
        Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
        com.tencent.mobileqq.zplan.avatar.fragment.a create = iZPlanAvatarEditResourceManagerFactory.create(arrayList, currentUin);
        this.mResourceManager = create;
        if (create != null) {
            create.prepare();
        }
        if (o()) {
            j.c().e("NearbyProfileKuiklyModule", "[recordAction] default appearanceKey no need to record");
            j();
        } else {
            this.mFinishFirstBatch = false;
            ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).recordBatchEditAvatar(d.INSTANCE.b(this.mActionIdList, currentUin, this.mCurAppearanceKey), priority, reqFrom, this.onAvatarRecordListener, Integer.valueOf(this.mPreRecNum));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int id5, String path) {
        if (this.mAvatarActionInfos.length() == 0) {
            j.c().d("NearbyProfileKuiklyModule", "setActionPicPathByActionId mAvatarActionInfos is empty");
            return;
        }
        Runnable l3 = l(id5, path);
        if (((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableAvatarTimeCostOptimization()) {
            ThreadManagerV2.excute(l3, 64, null, true);
        } else {
            ThreadManager.getFileThreadHandler().post(l3);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0025. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Map mapOf;
        ClipperInfo clipperInfo;
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -654391482:
                if (method.equals("getZPlanUserInfo")) {
                    String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
                    IZPlanDataHelper iZPlanDataHelper = (IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class);
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uin", uin), TuplesKt.to("appearanceKey", iZPlanDataHelper.getUserZPlanInfo(uin).appearanceKey), TuplesKt.to("gender", Integer.valueOf(((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).gender)));
                    return mapOf;
                }
                return super.call(method, params, callback);
            case -265892208:
                if (method.equals("composeAvatarImage")) {
                    JSONObject jSONObject = new JSONObject(params);
                    String avatarNormalPath = jSONObject.optString("avatarNormalPath");
                    Intrinsics.checkNotNullExpressionValue(avatarNormalPath, "avatarNormalPath");
                    if (!r.a(avatarNormalPath)) {
                        j.c().d("NearbyProfileKuiklyModule", "composeAvatarImage fail, avatarNormalPath is not exit");
                        if (callback != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("isSuccess", false);
                            jSONObject2.put("composeAvatarPath", "");
                            callback.invoke(jSONObject2);
                        }
                        return null;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("headActionData");
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("backgroudData");
                    BackgroundInfo backgroundInfo = new BackgroundInfo(Integer.valueOf(optJSONObject2.optInt("id")), optJSONObject2.optString("url"));
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("eventTags");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            arrayList.add(Integer.valueOf(optJSONArray.optInt(i3)));
                        }
                    }
                    String optString = optJSONObject.optString("uin");
                    Intrinsics.checkNotNullExpressionValue(optString, "headActionDataJsonObject.optString(\"uin\")");
                    int optInt = optJSONObject.optInt("actionId");
                    String optString2 = optJSONObject.optString("defaultUrl");
                    String optString3 = optJSONObject.optString("appearanceKey");
                    Intrinsics.checkNotNullExpressionValue(optString3, "headActionDataJsonObject\u2026ptString(\"appearanceKey\")");
                    d dVar = new d(optString, optInt, "", optString2, backgroundInfo, 640, optString3, optJSONObject.optDouble("maskRate"), null, null, arrayList, null);
                    ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).composeAvatar(dVar, avatarNormalPath, "lplan/avatars", new b(dVar, callback));
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1075275457:
                if (method.equals("uploadAvatarImage")) {
                    JSONObject jSONObject3 = new JSONObject(params);
                    String avatarNormalPath2 = jSONObject3.optString("avatarNormalPath");
                    int optInt2 = jSONObject3.optInt("appId");
                    Intrinsics.checkNotNullExpressionValue(avatarNormalPath2, "avatarNormalPath");
                    if (r.a(avatarNormalPath2)) {
                        return CorountineFunKt.e(fa2.a.c(), "uploadAvatarImage", null, null, null, new NearbyProfileKuiklyModule$call$5(optInt2, avatarNormalPath2, callback, null), 14, null);
                    }
                    j.c().d("NearbyProfileKuiklyModule", "uploadAvatarImage, avatarNormalPath is not exit");
                    if (callback == null) {
                        return null;
                    }
                    callback.invoke(null);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1311938023:
                if (method.equals("recordAction")) {
                    JSONObject jSONObject4 = new JSONObject(params);
                    String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
                    IZPlanDataHelper iZPlanDataHelper2 = (IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class);
                    Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
                    this.mCurAppearanceKey = iZPlanDataHelper2.getUserZPlanInfo(currentUin).appearanceKey;
                    this.mPreRecNum = jSONObject4.optInt("preRecNum");
                    JSONArray optJSONArray2 = jSONObject4.optJSONArray("headActionDataList");
                    Intrinsics.checkNotNullExpressionValue(optJSONArray2, "paramJSON.optJSONArray(\"headActionDataList\")");
                    this.mAvatarActionInfos = optJSONArray2;
                    int length2 = optJSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        JSONObject jSONObject5 = this.mAvatarActionInfos.getJSONObject(i16);
                        int optInt3 = jSONObject5.optInt("actionId");
                        this.mActionIdList.add(Integer.valueOf(optInt3));
                        JSONObject optJSONObject3 = jSONObject5.optJSONObject("boundsClipperInfo");
                        if (optJSONObject3 != null) {
                            clipperInfo = new ClipperInfo(optJSONObject3.optDouble(HippyTKDListViewAdapter.X), optJSONObject3.optDouble("y"), optJSONObject3.optDouble("width"), optJSONObject3.optDouble("height"));
                        } else {
                            clipperInfo = null;
                        }
                        this.idToAvatarDataMap.put(Integer.valueOf(optInt3), new d(currentUin, optInt3, null, null, null, 0, this.mCurAppearanceKey, 0.0d, clipperInfo, null, null, null, 3772, null));
                    }
                    this.mLoadingTime = System.currentTimeMillis();
                    this.recordActionCallback = callback;
                    p(Priority.MIDDLE, 0);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
