package com.tencent.mobileqq.qqvideoedit.zplan.preview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.mini.servlet.GetMaterialRelevantAppServlet;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqvideoedit.zplan.preview.ZootopiaGifPreviewFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.IZootopiaReportApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import ik2.GifFileInfo;
import ik2.g;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kj2.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 42\u00020\u0001:\u0002FGB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R2\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b08j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`98\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010C\u001a\u00020=8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/preview/ZootopiaGifPreviewFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Bundle;", "args", "", "Rh", "Landroid/view/View;", "root", "initView", "registerDaTongReportPageId", "Ah", "", "getPageId", "Jh", "Uh", "Vh", "Fh", "Landroid/app/Dialog;", ToastView.ICON_LOADING, "Ch", "path", "Eh", "Th", "Sh", "Bh", "Qh", OcrConfig.CHINESE, "Landroid/content/Context;", "Ih", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "isWrapContent", "needImmersive", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDestroyView", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mGifFilePath", "D", "mCompressPath", "", "E", "I", "mGifWidth", UserInfo.SEX_FEMALE, "mGifHeight", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "G", "Ljava/util/HashMap;", "mExtraInfo", "Lkj2/a;", "H", "Lkj2/a;", "_binding", "Hh", "()Lkj2/a;", "mBinding", "<init>", "()V", "a", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ZootopiaGifPreviewFragment extends QPublicBaseFragment {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    private int mGifWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private int mGifHeight;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private a _binding;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mGifFilePath = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mCompressPath = "";

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, String> mExtraInfo = new HashMap<>();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012JB\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/preview/ZootopiaGifPreviewFragment$a;", "", "Landroid/content/Context;", "ctx", "Lik2/e;", HippyTKDGifImageViewController.PROPS_GIFINFO, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extraInfo", "", "a", "KEY_GIF_FILE_PATH", "Ljava/lang/String;", "KEY_GIF_HEIGHT", "KEY_GIF_WIDTH", "TAG", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.zplan.preview.ZootopiaGifPreviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context ctx, @NotNull GifFileInfo gifInfo, @Nullable HashMap<String, String> extraInfo) {
            Intrinsics.checkNotNullParameter(gifInfo, "gifInfo");
            if (ctx == null) {
                ctx = BaseApplication.context;
            }
            Intent intent = new Intent();
            if (!(ctx instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("key_gif_file_path", gifInfo.getPath());
            intent.putExtra("key_gif_width", gifInfo.getWidth());
            intent.putExtra("key_gif_height", gifInfo.getHeight());
            intent.putExtra(GetMaterialRelevantAppServlet.KEY_EXTRA_INFO, extraInfo);
            QPublicFragmentActivity.b.b(ctx, intent, QPublicTransFragmentActivity.class, ZootopiaGifPreviewFragment.class);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/preview/ZootopiaGifPreviewFragment$b;", "Lcom/tencent/mobileqq/emosm/api/IFavroamingManagerService$AddCustomEmotionsCallback;", "", "b", "", "progress", "", "", "addEmotionsResults", "onProgressChanged", "onUploadFinish", "Lmqq/util/WeakReference;", "Landroid/app/Dialog;", "a", "Lmqq/util/WeakReference;", "loadingDialog", "dialog", "<init>", "(Landroid/app/Dialog;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IFavroamingManagerService.AddCustomEmotionsCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<Dialog> loadingDialog;

        public b(@NotNull Dialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            this.loadingDialog = new WeakReference<>(dialog);
        }

        private final void b() {
            QLog.i("ZootopiaGifPreviewFragment_", 2, "favSyncRoaming ");
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFavroamingManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026nstant.MAIN\n            )");
            ((IFavroamingManagerService) runtimeService).syncLocalDel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, int i3) {
            Dialog dialog;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WeakReference<Dialog> weakReference = this$0.loadingDialog;
            if (weakReference != null && (dialog = weakReference.get()) != null) {
                kk2.a.f412601a.b(dialog);
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        QQToast.makeText(BaseApplication.context, 1, "\u6dfb\u52a0\u5931\u8d25", 0).show();
                        return;
                    }
                    return;
                }
                QQToast.makeText(BaseApplication.context, 0, "\u5df2\u6dfb\u52a0\u8fc7\u8be5\u8868\u60c5", 0).show();
                return;
            }
            QQToast.makeText(BaseApplication.context, 2, "\u6dfb\u52a0\u6210\u529f", 0).show();
            this$0.b();
        }

        @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback
        public void onProgressChanged(float progress, @Nullable List<Integer> addEmotionsResults) {
            QLog.i("ZootopiaGifPreviewFragment_", 2, "onProgressChanged " + progress);
        }

        @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback
        public void onUploadFinish(@Nullable List<Integer> addEmotionsResults) {
            final int i3;
            QLog.i("ZootopiaGifPreviewFragment_", 2, "onUploadFinish addEmotionsResults:" + addEmotionsResults);
            if (addEmotionsResults != null) {
                i3 = addEmotionsResults.get(0).intValue();
            } else {
                i3 = -1;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jk2.j
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaGifPreviewFragment.b.c(ZootopiaGifPreviewFragment.b.this, i3);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqvideoedit/zplan/preview/ZootopiaGifPreviewFragment$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("ZootopiaGifPreviewFragment_", 1, "User requestPermissions grant...");
            ZootopiaGifPreviewFragment.this.Th();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            QLog.d("ZootopiaGifPreviewFragment_", 1, "User requestPermissions denied...");
            QQToast.makeText(ZootopiaGifPreviewFragment.this.Ih(), 1, "\u6ca1\u6709\u5b58\u50a8\u6743\u9650\uff0c\u4fdd\u5b58\u5931\u8d25", 0).show();
        }
    }

    private final void Ah(View root) {
        IZootopiaReportApi iZootopiaReportApi = (IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class);
        LinearLayout linearLayout = Hh().f412564i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.sendToFriendArea");
        iZootopiaReportApi.setElementInfo(linearLayout, "em_zplan_makegif_share_send", new LinkedHashMap());
        IZootopiaReportApi iZootopiaReportApi2 = (IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class);
        LinearLayout linearLayout2 = Hh().f412561f;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "mBinding.doFavoriteArea");
        iZootopiaReportApi2.setElementInfo(linearLayout2, "em_zplan_makegif_share_mark", new LinkedHashMap());
        IZootopiaReportApi iZootopiaReportApi3 = (IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class);
        LinearLayout linearLayout3 = Hh().f412563h;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "mBinding.saveToLocalArea");
        iZootopiaReportApi3.setElementInfo(linearLayout3, "em_zplan_makegif_share_save", new LinkedHashMap());
    }

    private final void Bh() {
        boolean z16;
        if (this.mGifFilePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Qh();
        }
        if (!new File(this.mGifFilePath).exists()) {
            Qh();
        }
    }

    private final void Ch(final Dialog loading) {
        boolean z16;
        String absolutePath;
        String substringBeforeLast$default;
        String str = this.mGifFilePath;
        String str2 = this.mCompressPath;
        boolean z17 = true;
        if (str2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Eh(str2, loading);
            return;
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile == null || (absolutePath = parentFile.getAbsolutePath()) == null) {
            absolutePath = BaseApplication.context.getFilesDir().getAbsolutePath();
        }
        String str3 = File.separator;
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "originFile.name");
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
        String e16 = g.f407918a.e(str, absolutePath + str3 + substringBeforeLast$default + "_more_compress.gif", 30);
        if (e16.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            this.mCompressPath = e16;
            Eh(e16, loading);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jk2.i
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaGifPreviewFragment.Dh(ZootopiaGifPreviewFragment.this, loading);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(ZootopiaGifPreviewFragment this$0, Dialog loading) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(loading, "$loading");
        QQToast.makeText(this$0.Ih(), 1, "\u6dfb\u52a0\u5931\u8d25", 0).show();
        kk2.a.f412601a.b(loading);
    }

    private final void Eh(String path, Dialog loading) {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFavroamingManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ssConstant.MAIN\n        )");
        ArrayList arrayList = new ArrayList();
        arrayList.add(path);
        ((IFavroamingManagerService) runtimeService).addCustomEmotions(arrayList, new b(loading));
    }

    private final void Fh() {
        final Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getContext(), "\u8bf7\u7a0d\u7b49...", false);
        showLoadingDialog.show();
        ThreadManagerV2.excute(new Runnable() { // from class: jk2.h
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaGifPreviewFragment.Gh(ZootopiaGifPreviewFragment.this, showLoadingDialog);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(ZootopiaGifPreviewFragment this$0, Dialog loading) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(loading, "loading");
        this$0.Ch(loading);
    }

    private final a Hh() {
        a aVar = this._binding;
        Intrinsics.checkNotNull(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context Ih() {
        Context context = getContext();
        if (context == null) {
            BaseApplication context2 = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            return context2;
        }
        return context;
    }

    private final String Jh() {
        String str = this.mExtraInfo.get(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID);
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(ZootopiaGifPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(ZootopiaGifPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Uh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(ZootopiaGifPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Vh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(ZootopiaGifPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(ZootopiaGifPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(ZootopiaGifPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileUtils.deleteFile(this$0.mCompressPath);
        FileUtils.deleteFile(this$0.mGifFilePath);
    }

    private final void Qh() {
        QQToast.makeText(Ih(), 1, "\u56fe\u7247\u8def\u5f84\u65e0\u6548", 0).show();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void Rh(Bundle args) {
        HashMap hashMap;
        String string = args.getString("key_gif_file_path", "");
        Intrinsics.checkNotNullExpressionValue(string, "args.getString(KEY_GIF_FILE_PATH, \"\")");
        this.mGifFilePath = string;
        this.mGifWidth = args.getInt("key_gif_width", 0);
        this.mGifHeight = args.getInt("key_gif_height", 0);
        Bh();
        Serializable serializable = args.getSerializable(GetMaterialRelevantAppServlet.KEY_EXTRA_INFO);
        if (serializable instanceof HashMap) {
            hashMap = (HashMap) serializable;
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            this.mExtraInfo.putAll(hashMap);
        }
    }

    private final void Sh() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ZPLAN, QQPermissionConstants.Business.SCENE.VIDEO_EDITOR_SAVE_PIC));
        if (qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c());
        } else {
            Th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th() {
        ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(Ih(), this.mGifFilePath);
    }

    private final void Uh() {
        Intent intent = new Intent();
        intent.addFlags(603979776);
        RouteUtils.startActivity(getContext(), intent, RouterConstants.UI_ROUTER_SPLASH);
    }

    private final void Vh() {
        jk2.a.a(getActivity(), Uri.parse("file://" + this.mGifFilePath));
    }

    private final String getPageId() {
        return "pg_zplan_makegif_share";
    }

    private final void initView(View root) {
        Hh().f412557b.setOnClickListener(new View.OnClickListener() { // from class: jk2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaGifPreviewFragment.Kh(ZootopiaGifPreviewFragment.this, view);
            }
        });
        Hh().f412558c.setOnClickListener(new View.OnClickListener() { // from class: jk2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaGifPreviewFragment.Lh(ZootopiaGifPreviewFragment.this, view);
            }
        });
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        Hh().f412562g.setImageDrawable(URLDrawable.getFileDrawable(this.mGifFilePath, obtain));
        Hh().f412564i.setOnClickListener(new View.OnClickListener() { // from class: jk2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaGifPreviewFragment.Mh(ZootopiaGifPreviewFragment.this, view);
            }
        });
        Hh().f412561f.setOnClickListener(new View.OnClickListener() { // from class: jk2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaGifPreviewFragment.Nh(ZootopiaGifPreviewFragment.this, view);
            }
        });
        Hh().f412563h.setOnClickListener(new View.OnClickListener() { // from class: jk2.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaGifPreviewFragment.Oh(ZootopiaGifPreviewFragment.this, view);
            }
        });
        registerDaTongReportPageId(root);
        Ah(root);
    }

    private final void registerDaTongReportPageId(View root) {
        Map<String, Object> mutableMapOf;
        IZootopiaReportApi iZootopiaReportApi = (IZootopiaReportApi) QRoute.api(IZootopiaReportApi.class);
        RelativeLayout relativeLayout = Hh().f412560e;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.contentView");
        String pageId = getPageId();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_makegif"), new Pair(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Jh()));
        iZootopiaReportApi.setPageInfo(this, relativeLayout, pageId, mutableMapOf);
    }

    private final void zh() {
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
        QLog.i("ZootopiaGifPreviewFragment_", 4, "setStatusBarToLightStatus statusBarHeight:" + statusBarHeight);
        ViewGroup.LayoutParams layoutParams = Hh().f412565j.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        QLog.i("ZootopiaGifPreviewFragment_", 4, "setStatusBarToLightStatus lp.topMargin before:" + layoutParams2.topMargin);
        layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin + statusBarHeight, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        Hh().f412565j.setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Rh(arguments);
        }
        Bh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = a.g(inflater, container, false);
        RelativeLayout root = Hh().getRoot();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ThreadManagerV2.excute(new Runnable() { // from class: jk2.g
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaGifPreviewFragment.Ph(ZootopiaGifPreviewFragment.this);
            }
        }, 64, null, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AbstractGifImage.pauseAll();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AbstractGifImage.resumeAll();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        zh();
        initView(view);
    }
}
