package com.tencent.mobileqq.zplan.emoticon.detail;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.c;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.model.GeneralRecordSwitches;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import tl.h;
import wk3.f;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001fR\u0016\u0010#\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/detail/ZPlanEmoticonDetailManager;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "uin", "Lcom/tencent/zplan/record/model/c;", "recordSwitches", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "k", "Lwk3/f;", "j", "Lcom/tencent/zplan/meme/EngineType;", "targetEngineType", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "f", "path", "Landroid/graphics/drawable/Drawable;", "i", "", h.F, "url", "l", "Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonApi$b;", "zPlanEmoticonDetailRequestListener", "r", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zplan/emoticon/detail/ZPlanEmoticonDetailExpGroup;", "g", "", "p", "b", "I", "isInPackageFromMemory", "Ljava/lang/ref/WeakReference;", "c", "Ljava/lang/ref/WeakReference;", "zPlanEmoticonDetailRequestListenerRef", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonDetailManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanEmoticonDetailManager f333107a = new ZPlanEmoticonDetailManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int isInPackageFromMemory = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<IZPlanEmoticonApi.b> zPlanEmoticonDetailRequestListenerRef;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333110a;

        static {
            int[] iArr = new int[ZPlanEmoticonDetailExpGroup.values().length];
            try {
                iArr[ZPlanEmoticonDetailExpGroup.GROUP_AVATAR_JUMP_TO_EMOTICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZPlanEmoticonDetailExpGroup.GROUP_AVATAR_JUMP_TO_CREATE_ROLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f333110a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/detail/ZPlanEmoticonDetailManager$b", "Lcom/tencent/mobileqq/zplan/persistent/api/IZPlanDataHelper$a;", "", "isInPackage", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IZPlanDataHelper.a {
        b() {
        }

        @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper.a
        public void onResult(int isInPackage) {
            QLog.i("ZPlanEmoticonDetailUtil", 1, "getIsInAlreadyCreatedRolePackage, onResult isInPackage:" + isInPackage);
            ZPlanEmoticonDetailManager.isInPackageFromMemory = isInPackage;
            WeakReference weakReference = ZPlanEmoticonDetailManager.zPlanEmoticonDetailRequestListenerRef;
            IZPlanEmoticonApi.b bVar = weakReference != null ? (IZPlanEmoticonApi.b) weakReference.get() : null;
            if (bVar == null) {
                QLog.e("ZPlanEmoticonDetailUtil", 1, "getIsInAlreadyCreatedRolePackage, onResult listener empty");
                return;
            }
            ZPlanEmoticonDetailManager zPlanEmoticonDetailManager = ZPlanEmoticonDetailManager.f333107a;
            bVar.a(zPlanEmoticonDetailManager.n(), zPlanEmoticonDetailManager.m(), zPlanEmoticonDetailManager.o());
            if (isInPackage == 1) {
                zPlanEmoticonDetailManager.q();
            }
        }
    }

    ZPlanEmoticonDetailManager() {
    }

    private final int h() {
        bb bbVar = bb.f335811a;
        String e16 = bbVar.e();
        if (p()) {
            return bbVar.k(e16);
        }
        return bbVar.o(e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable i(String path) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        if (c.f385288a.h(path)) {
            return URLDrawable.getFileDrawable(path, obtain);
        }
        return null;
    }

    private final f j() {
        return ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getZPlanEmoticonDetailConfig();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.tencent.image.URLDrawable] */
    private final Drawable l(String url) {
        Drawable fileDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        boolean z16 = false;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        if (HttpUtil.isValidUrl(url)) {
            fileDrawable = URLDrawable.getDrawable(url, obtain);
            if (fileDrawable != 0 && fileDrawable.getStatus() == 2) {
                z16 = true;
            }
            if (z16) {
                fileDrawable.restartDownload();
            }
        } else {
            fileDrawable = c.f385288a.h(url) ? URLDrawable.getFileDrawable(url, obtain) : 0;
        }
        if (fileDrawable == 0) {
            fileDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.ofb);
        }
        Intrinsics.checkNotNull(fileDrawable);
        return fileDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        QLog.i("ZPlanEmoticonDetailUtil", 1, "recordAndReplaceIcon");
        String e16 = bb.f335811a.e();
        if (!(e16 == null || e16.length() == 0)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanEmoticonDetailManager$recordAndReplaceIcon$1(e16, null), 3, null);
        } else {
            QLog.e("ZPlanEmoticonDetailUtil", 1, "setZPlanEmoticonDetailIcon invalid uin");
        }
    }

    public final ZPlanEmoticonDetailExpGroup g() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_1505_zplan_emote_nocj_induct");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026_ZPLAN_EMOTE_NOCJ_INDUCT)");
        expEntity.reportExpExposure();
        if (expEntity.isExperiment("exp_1505_zplan_emote_nocj_induct_B")) {
            return ZPlanEmoticonDetailExpGroup.GROUP_AVATAR_JUMP_TO_EMOTICON;
        }
        if (expEntity.isExperiment("exp_1505_zplan_emote_nocj_induct_C")) {
            return ZPlanEmoticonDetailExpGroup.GROUP_AVATAR_JUMP_TO_CREATE_ROLE;
        }
        return ZPlanEmoticonDetailExpGroup.GROUP_REGULAR;
    }

    public final String m() {
        f j3 = j();
        if (!p()) {
            return j3.getText1();
        }
        int i3 = a.f333110a[g().ordinal()];
        if (i3 == 1) {
            return j3.getText2();
        }
        if (i3 != 2) {
            String string = BaseApplication.getContext().getResources().getString(R.string.f242987w2);
            Intrinsics.checkNotNullExpressionValue(string, "{BaseApplicationImpl.get\u2026ing.zplan_emoticon_name)}");
            return string;
        }
        if (ZPlanQQMC.INSTANCE.enableCreateRoleFromEmoticon()) {
            return j3.getText3();
        }
        QLog.i("ZPlanEmoticonDetailUtil", 1, "getZPlanEmoticonDetailButtonText, enableCreateRoleFromEmoticon false.");
        return j3.getText2();
    }

    public final Drawable n() {
        String femaleDefaultPicUrl;
        f j3 = j();
        int h16 = h();
        ZPlanEmoticonDetailExpGroup g16 = g();
        if (p() && g16 == ZPlanEmoticonDetailExpGroup.GROUP_REGULAR) {
            femaleDefaultPicUrl = "";
        } else if (h16 == 1) {
            femaleDefaultPicUrl = j3.getMaleDefaultPicUrl();
        } else {
            femaleDefaultPicUrl = j3.getFemaleDefaultPicUrl();
        }
        QLog.i("ZPlanEmoticonDetailUtil", 1, "getZPlanEmoticonDetailIconDrawable url:" + femaleDefaultPicUrl);
        return l(femaleDefaultPicUrl);
    }

    public final String o() {
        f j3 = j();
        if (p() && g() == ZPlanEmoticonDetailExpGroup.GROUP_AVATAR_JUMP_TO_CREATE_ROLE && ZPlanQQMC.INSTANCE.enableCreateRoleFromEmoticon()) {
            return j3.getText5();
        }
        return j3.getText4();
    }

    public final boolean p() {
        return isInPackageFromMemory != 1;
    }

    public final void r(IZPlanEmoticonApi.b zPlanEmoticonDetailRequestListener) {
        Intrinsics.checkNotNullParameter(zPlanEmoticonDetailRequestListener, "zPlanEmoticonDetailRequestListener");
        zPlanEmoticonDetailRequestListenerRef = new WeakReference<>(zPlanEmoticonDetailRequestListener);
        ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getIsInAlreadyCreatedRolePackage(new b());
    }

    private final BusinessConfig f(EngineType targetEngineType) {
        boolean enableCancelGlassesMetallic = ZPlanQQMC.INSTANCE.enableCancelGlassesMetallic();
        BusinessConfig businessConfig = new BusinessConfig(0, false, false, false, BusinessConfig.FrameType.PNG, 0, null, null, null, null, null, null, null, false, null, 0, null, 131054, null);
        businessConfig.G(targetEngineType);
        if (targetEngineType instanceof EngineType.Filament) {
            businessConfig.A(Boolean.TRUE);
        }
        businessConfig.z(Boolean.valueOf(enableCancelGlassesMetallic));
        return businessConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SingleRecordRequestParams k(String uin, GeneralRecordSwitches recordSwitches) {
        f j3 = j();
        ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
        EngineType h06 = zPlanEmoticonUtil.h0(recordSwitches.getRenderSwitches());
        return new SingleRecordRequestParams(j3.getActionId(), uin, null, j3.getWidth(), j3.getWidth(), MODE.FRAME, f(h06), j3.getUploadScene(), AppTheme.DAY, Priority.HIGH, zPlanEmoticonUtil.g0(recordSwitches.getCloudSwitches()), null, 0, false, null, 0 == true ? 1 : 0, 63488, null);
    }
}
