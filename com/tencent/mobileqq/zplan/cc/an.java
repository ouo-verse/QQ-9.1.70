package com.tencent.mobileqq.zplan.cc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.activity.PeakHostActivity;
import com.tencent.mobileqq.zplan.cc.an;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import com.tencent.tmediacodec.util.ThreadManager;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/an;", "", "", "isFilament", "", "g", "e", "Landroid/content/Context;", "context", "", "gender", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "avatarCharacter", tl.h.F, "Lcom/tencent/aelight/camera/download/a;", "downloadCallback", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    public static final an f332478a = new an();

    an() {
    }

    private final void e() {
        ThreadManager.execute(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.al
            @Override // java.lang.Runnable
            public final void run() {
                an.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundleHighPriority(AEResInfo.LIGHT_RES_FILAMENT.agentType);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundleHighPriority(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundleHighPriority(AEResInfo.LIGHT_RES_PAG.agentType);
    }

    private final void g(boolean isFilament) {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_FACE.agentType);
        IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_3DMM;
        if (!iAEResUtil.isAEResExist(aEResInfo)) {
            ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(aEResInfo, null, false);
        }
        if (isFilament) {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_ACE3D.agentType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Ref.LongRef launchTimeBegin, Context context, int i3, boolean z16, ZootopiaSource zootopiaSource, long j3, String avatarCharacter) {
        Intrinsics.checkNotNullParameter(launchTimeBegin, "$launchTimeBegin");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(avatarCharacter, "$avatarCharacter");
        launchTimeBegin.element = eg3.b.INSTANCE.a();
        PeakHostActivity.Companion companion = PeakHostActivity.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt("gender_key", i3);
        bundle.putBoolean("default_check_no_ask", z16);
        bundle.putString(SquareReportConst.Key.KEY_SOURCE, zootopiaSource != null ? com.tencent.sqshow.zootopia.utils.ah.b(zootopiaSource) : null);
        bundle.putLong("filament_face_entrance_click_time_ms", j3);
        bundle.putLong("filament_face_entrance_launch_time_ms", launchTimeBegin.element);
        bundle.putString("avatar_character", avatarCharacter);
        Unit unit = Unit.INSTANCE;
        companion.a(context, m.class, bundle, 536870912);
    }

    public final void d(com.tencent.aelight.camera.download.a downloadCallback) {
        if (com.tencent.mobileqq.zplan.cc.util.e.f332557a.g()) {
            return;
        }
        ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).startDownloadFilamentFaceRes(BaseApplicationImpl.getApplication().getRuntime(), downloadCallback);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/cc/an$a", "Lcom/tencent/aelight/camera/download/a;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "info", "", "isUsable", "", "resCode", "", "onDownloadFinish", "progress", "onProgressUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.aelight.camera.download.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<h> f332479d;

        a(WeakReference<h> weakReference) {
            this.f332479d = weakReference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void b(WeakReference downloadDialogWeakRef) {
            Intrinsics.checkNotNullParameter(downloadDialogWeakRef, "$downloadDialogWeakRef");
            h hVar = (h) downloadDialogWeakRef.get();
            boolean z16 = false;
            if (hVar != null && hVar.isShowing()) {
                z16 = true;
            }
            if (z16) {
                hVar.cancel();
                QQToastUtil.showQQToast(1, R.string.xir);
            }
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData info, boolean isUsable, int resCode) {
            if (isUsable) {
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WeakReference<h> weakReference = this.f332479d;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.am
                @Override // java.lang.Runnable
                public final void run() {
                    an.a.b(WeakReference.this);
                }
            });
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData info, int progress) {
        }
    }

    public final void h(final Context context, final int gender, final ZootopiaSource source, final String avatarCharacter) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "start launch FilamentCamera gender = " + gender);
        ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).refreshFilamentAiFaceMaterialList();
        final long a16 = eg3.b.INSTANCE.a();
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = a16;
        if (((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
            str = "ready";
        } else {
            str = "NOT ready";
        }
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "camera res is " + str);
        final boolean isCheckAIFace = ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).isCheckAIFace();
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.aj
            @Override // java.lang.Runnable
            public final void run() {
                an.i(Ref.LongRef.this, context, gender, isCheckAIFace, source, a16, avatarCharacter);
            }
        };
        if (com.tencent.mobileqq.zplan.cc.util.e.f332557a.d(2)) {
            runnable.run();
            return;
        }
        if (NetworkUtil.isNetSupport(context)) {
            QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
            Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
            h hVar = new h(sTopActivity, false, false, 2, 6, null);
            hVar.j(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.ak
                @Override // java.lang.Runnable
                public final void run() {
                    an.j();
                }
            });
            hVar.k(runnable);
            WeakReference weakReference = new WeakReference(hVar);
            e();
            g(true);
            d(new a(weakReference));
            hVar.show();
            return;
        }
        QQToastUtil.showQQToast(R.string.xlb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
    }
}
