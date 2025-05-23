package com.tencent.mobileqq.nearbypro.map.avatar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
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
import com.tencent.mobileqq.zplan.avatar.edit.e;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.zplan.meme.Priority;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mp4.f;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR&\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00060!j\b\u0012\u0004\u0012\u00020\u0006`\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/avatar/MapAvatarUtils;", "", "", "k", "", h.F, "", "id", "", "path", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "i", "avatarNormalPath", "f", "composeImagePath", "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "editAvatarData", "g", "Lmp4/f;", "headConfig", "Lmp4/a;", "backgroundConfig", "l", "b", "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "Lcom/tencent/mobileqq/zplan/avatar/fragment/a;", "c", "Lcom/tencent/mobileqq/zplan/avatar/fragment/a;", "mResourceManager", "d", "Ljava/lang/String;", "mCurAppearanceKey", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mActionIdList", "", "J", "mLoadingTime", "Lcom/tencent/mobileqq/zplan/avatar/a;", "Lcom/tencent/mobileqq/zplan/avatar/a;", "onAvatarRecordListener", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MapAvatarUtils {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static d editAvatarData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.zplan.avatar.fragment.a mResourceManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long mLoadingTime;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MapAvatarUtils f253394a = new MapAvatarUtils();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCurAppearanceKey = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<Integer> mActionIdList = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.zplan.avatar.a onAvatarRecordListener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/map/avatar/MapAvatarUtils$a", "Lcom/tencent/mobileqq/zplan/avatar/a;", "Lcom/tencent/mobileqq/zplan/avatar/c;", "result", "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.zplan.avatar.a {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.a
        public void a(@NotNull RecordResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (MapAvatarUtils.mResourceManager == null) {
                j.c().d("MapAvatarUtils", "recordEditAvatar onRecordDone mResourceManager is empty");
                return;
            }
            boolean isSuccess = result.getIsSuccess();
            int actionId = result.getActionId();
            String recordPath = result.getRecordPath();
            if (isSuccess && !TextUtils.isEmpty(recordPath) && actionId != -1) {
                MapAvatarUtils mapAvatarUtils = MapAvatarUtils.f253394a;
                Intrinsics.checkNotNull(recordPath);
                mapAvatarUtils.m(actionId, recordPath);
                j.c().e("MapAvatarUtils", "recordEditAvatar onRecordDone success id:" + actionId + " recordPath\uff1a" + recordPath);
                return;
            }
            ga2.a c16 = j.c();
            c16.d("MapAvatarUtils", "[onRecordDone]" + ("\u5f55\u5236id" + actionId + "\u5931\u8d25"));
            com.tencent.mobileqq.zplan.avatar.fragment.a aVar = MapAvatarUtils.mResourceManager;
            if (aVar != null) {
                aVar.a(actionId, -1, "");
            }
        }
    }

    MapAvatarUtils() {
    }

    private final void f(String avatarNormalPath) {
        if (!r.a(avatarNormalPath)) {
            j.c().d("MapAvatarUtils", "composeAndUploadAvartarImage fail, avatarNormalPath is not exit");
            return;
        }
        IZPlanEditAvatarApi iZPlanEditAvatarApi = (IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class);
        d dVar = editAvatarData;
        Intrinsics.checkNotNull(dVar);
        iZPlanEditAvatarApi.composeAvatar(dVar, avatarNormalPath, "lplan/avatars", new e() { // from class: com.tencent.mobileqq.nearbypro.map.avatar.MapAvatarUtils$composeAndUploadAvartarImage$1
            @Override // com.tencent.mobileqq.zplan.avatar.edit.e
            public void a(boolean isSuccess, @NotNull d avatarData1, @Nullable String filePath) {
                d dVar2;
                String g16;
                Intrinsics.checkNotNullParameter(avatarData1, "avatarData1");
                if (isSuccess && !TextUtils.isEmpty(filePath)) {
                    Intrinsics.checkNotNull(filePath);
                    if (!r.a(filePath)) {
                        j.c().d("MapAvatarUtils", "composeAndUploadAvartarImage fail, filePath is not exit");
                        return;
                    }
                    MapAvatarUtils mapAvatarUtils = MapAvatarUtils.f253394a;
                    dVar2 = MapAvatarUtils.editAvatarData;
                    Intrinsics.checkNotNull(dVar2);
                    g16 = mapAvatarUtils.g(filePath, dVar2);
                    CorountineFunKt.e(fa2.a.c(), "uploadAvatarImage", null, null, null, new MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1(g16, null), 14, null);
                    return;
                }
                j.c().d("MapAvatarUtils", "composeAvatar fail, isSuccess: " + isSuccess + ", filePath: " + filePath);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(String composeImagePath, d editAvatarData2) {
        String str;
        Bitmap decodeFile = BitmapFactory.decodeFile(composeImagePath);
        int avatarSize = editAvatarData2.getAvatarSize();
        Bitmap roundedCornerBitmap2 = BaseImageUtil.getRoundedCornerBitmap2(decodeFile, avatarSize / 2, avatarSize, avatarSize);
        File file = new File(BaseApplication.getContext().getCacheDir(), "lplan/avatars/");
        int actionId = editAvatarData2.getActionId();
        BackgroundInfo backgroundInfo = editAvatarData2.getBackgroundInfo();
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
                        j.c().d("MapAvatarUtils", "cropComposeAvatarImageRounded out close failed, exception: " + e16);
                    }
                    return absolutePath;
                } catch (Exception e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    j.c().d("MapAvatarUtils", "cropComposeAvatarImageRounded failed, exception: " + e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            j.c().d("MapAvatarUtils", "cropComposeAvatarImageRounded out close failed, exception: " + e18);
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
                            j.c().d("MapAvatarUtils", "cropComposeAvatarImageRounded out close failed, exception: " + e19);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }

    private final void h() {
        final String str;
        j.c().e("MapAvatarUtils", "[fillDefaultAppearanceAvatarActionInfo]");
        if (mResourceManager == null) {
            j.c().d("MapAvatarUtils", "[fillDefaultAppearanceAvatarActionInfo] mResourceManager empty");
            return;
        }
        d dVar = editAvatarData;
        if (dVar == null || (str = dVar.getDefaultUrl()) == null) {
            str = "";
        }
        if (editAvatarData != null && !TextUtils.isEmpty(str)) {
            ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).downloadShpImagePackage(str, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.avatar.MapAvatarUtils$fillDefaultAppearanceAvatarActionInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                    invoke2(bool, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Boolean bool, @Nullable String str2) {
                    d dVar2;
                    Intrinsics.checkNotNull(bool);
                    if (!bool.booleanValue() || TextUtils.isEmpty(str2)) {
                        return;
                    }
                    j.c().e("MapAvatarUtils", "[fillDefaultAppearanceAvatarActionInfo] downloadShpImagePackage url:" + str);
                    MapAvatarUtils mapAvatarUtils = MapAvatarUtils.f253394a;
                    dVar2 = MapAvatarUtils.editAvatarData;
                    Intrinsics.checkNotNull(dVar2);
                    int actionId = dVar2.getActionId();
                    Intrinsics.checkNotNull(str2);
                    mapAvatarUtils.m(actionId, str2);
                }
            });
        } else {
            j.c().e("MapAvatarUtils", "[fillDefaultAppearanceAvatarActionInfo] actionDefaultPicUrl empty");
        }
    }

    private final Runnable i(final int id5, final String path) {
        return new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.avatar.a
            @Override // java.lang.Runnable
            public final void run() {
                MapAvatarUtils.j(id5, path);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3, String path) {
        Intrinsics.checkNotNullParameter(path, "$path");
        if (mResourceManager == null) {
            j.c().d("MapAvatarUtils", "setActionPicPathByActionId mResourceManager is null");
            return;
        }
        String avatarPathV2 = ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).getAvatarPathV2(i3, path, editAvatarData, mCurAppearanceKey, 0, "lplan/avatar/png_normal/");
        if (TextUtils.isEmpty(avatarPathV2)) {
            j.c().d("MapAvatarUtils", "crop normal avatar failed.");
            return;
        }
        j.c().e("MapAvatarUtils", "crop done, id: " + i3 + ", inBoundsPath: " + avatarPathV2);
        j.c().e("MapAvatarUtils", "setActionPicPathByActionId id:" + i3 + " path:" + path);
        com.tencent.mobileqq.zplan.avatar.fragment.a aVar = mResourceManager;
        if (aVar != null) {
            aVar.a(i3, 1, path);
        }
        j.c().e("MapAvatarUtils", "\u5f55\u5236\u5b8c\u6210\u7528\u65f6" + (System.currentTimeMillis() - mLoadingTime) + "ms");
        f253394a.f(avatarPathV2);
    }

    private final boolean k() {
        if (TextUtils.isEmpty(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin())) {
            return false;
        }
        if (!TextUtils.isEmpty(mCurAppearanceKey) && !Intrinsics.areEqual("zplan_default_appearance_key", mCurAppearanceKey)) {
            return false;
        }
        j.c().e("MapAvatarUtils", "[getIsZplanHasDefaultAppearance] zplan has default appearanceKey");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int id5, String path) {
        Runnable i3 = i(id5, path);
        if (((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableAvatarTimeCostOptimization()) {
            ThreadManagerV2.excute(i3, 64, null, true);
        } else {
            ThreadManager.getFileThreadHandler().post(i3);
        }
    }

    public final void l(@NotNull f headConfig, @NotNull mp4.a backgroundConfig) {
        ArrayList arrayListOf;
        ArrayList<Integer> arrayListOf2;
        Intrinsics.checkNotNullParameter(headConfig, "headConfig");
        Intrinsics.checkNotNullParameter(backgroundConfig, "backgroundConfig");
        j.c().e("MapAvatarUtils", "recordEditAvatar start");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        IZPlanDataHelper iZPlanDataHelper = (IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class);
        Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
        mCurAppearanceKey = iZPlanDataHelper.getUserZPlanInfo(currentUin).appearanceKey;
        int i3 = headConfig.f417153a;
        String str = headConfig.f417154b;
        String str2 = headConfig.f417156d;
        BackgroundInfo backgroundInfo = new BackgroundInfo(Integer.valueOf(backgroundConfig.f417136a), backgroundConfig.f417137b);
        String str3 = mCurAppearanceKey;
        double d16 = headConfig.f417157e;
        mp4.b bVar = headConfig.f417158f;
        ClipperInfo clipperInfo = new ClipperInfo(bVar.f417139a, bVar.f417140b, bVar.f417141c, bVar.f417142d);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf((int) headConfig.f417160h.f417143a));
        editAvatarData = new d(currentUin, i3, str, str2, backgroundInfo, 640, str3, d16, clipperInfo, null, arrayListOf, null);
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(headConfig.f417153a));
        mActionIdList = arrayListOf2;
        mLoadingTime = System.currentTimeMillis();
        if (TextUtils.isEmpty(currentUin)) {
            j.c().f("MapAvatarUtils", "recordEditAvatar currentUin null!!");
            return;
        }
        com.tencent.mobileqq.zplan.avatar.fragment.a create = ((IZPlanAvatarEditResourceManagerFactory) QRoute.api(IZPlanAvatarEditResourceManagerFactory.class)).create(mActionIdList, currentUin);
        mResourceManager = create;
        if (create != null) {
            create.prepare();
        }
        if (k()) {
            j.c().e("MapAvatarUtils", "[recordAction] default appearanceKey no need to record");
            h();
        } else {
            ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).recordBatchEditAvatar(d.INSTANCE.b(mActionIdList, currentUin, mCurAppearanceKey), Priority.MIDDLE, 0, onAvatarRecordListener, 1);
        }
    }
}
