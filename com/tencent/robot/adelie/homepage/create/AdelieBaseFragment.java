package com.tencent.robot.adelie.homepage.create;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.robot.adelie.AdelieFragmentActivity;
import com.tencent.robot.adelie.constant.AdelieConstant;
import com.tencent.robot.adelie.homepage.create.view.AdelieHeadIconView;
import com.tencent.robot.adelie.homepage.create.view.AdeliePolarLightBkgView;
import com.tencent.robot.adelie.homepage.create.view.ImageCategory;
import com.tencent.robot.adelie.homepage.create.viewmodel.AdelieCreateOrEditPageViewModel;
import com.tencent.robot.adelie.homepage.ugc.ad;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.util.WnsError;
import java.io.File;
import java.util.List;
import kotlin.C11736d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.Charsets;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 ]2\u00020\u0001:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u001c\u0010\u001e\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u001f\u001a\u00020\u0012H&J\n\u0010!\u001a\u0004\u0018\u00010 H&J\n\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J&\u0010-\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0014J\u0012\u0010.\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004J\u0018\u00100\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0012H\u0004J\u0012\u00101\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u00105\u001a\u00020\u00042\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0012H\u0004J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0015H\u0004J\"\u0010:\u001a\u00020\u00042\u0006\u00108\u001a\u0002022\u0006\u00109\u001a\u0002022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010>\u001a\u0004\u0018\u00010\u00122\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u0012J\u001e\u0010B\u001a\u00020;2\u0006\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u0002022\u0006\u0010A\u001a\u000202R\u0017\u0010G\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\"\u0010N\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010T\u001a\u00020O8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001b\u0010Z\u001a\u00020U8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\u00a8\u0006_"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/AdelieBaseFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/content/Context;", "context", "", "Zh", "Landroid/view/View;", "view", "Vh", "Lcom/tencent/widget/ActionSheet;", "dialog", "Th", "gi", "di", "Landroid/content/Intent;", "data", "Sh", "Ph", "", "extraInfo", "Eh", "", "useQUISecNavBar", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "secNavBarNeedImmersive", "needImmersive", "needStatusTrans", "isWrapContent", "avatarPath", "bgPath", "Oh", "Kh", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieHeadIconView;", "Dh", "Bh", "Lcom/tencent/robot/adelie/homepage/create/view/AdeliePolarLightBkgView;", "Ih", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Gh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Mh", "elementId", "Nh", "yh", "", "errCode", "errMsg", "ci", "enable", "Yh", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, WadlProxyConsts.PARAM_FILENAME, "Uh", "originalBitmap", NodeProps.MAX_WIDTH, NodeProps.MAX_HEIGHT, "Jh", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "Hh", "()Ljava/lang/String;", "pageUuid", "D", "I", "Fh", "()I", "Xh", "(I)V", "imageResource", "Lcom/tencent/robot/qqmc/model/a;", "E", "Lcom/tencent/robot/qqmc/model/a;", "Ch", "()Lcom/tencent/robot/qqmc/model/a;", "aiGenerateConfig", "Lcom/tencent/robot/adelie/homepage/create/viewmodel/AdelieCreateOrEditPageViewModel;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Lh", "()Lcom/tencent/robot/adelie/homepage/create/viewmodel/AdelieCreateOrEditPageViewModel;", "viewModel", "<init>", "()V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class AdelieBaseFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String pageUuid = String.valueOf(System.currentTimeMillis());

    /* renamed from: D, reason: from kotlin metadata */
    private int imageResource = AdelieConstant.ImageSource.NO_CHANGE.getValue();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.robot.qqmc.model.a aiGenerateConfig = RobotQQMC.INSTANCE.getAiGenerateConfig();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieBaseFragment$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f366072b;

        b(Context context) {
            this.f366072b = context;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            AdelieBaseFragment.this.di(this.f366072b);
        }
    }

    public AdelieBaseFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieCreateOrEditPageViewModel>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieBaseFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdelieCreateOrEditPageViewModel invoke() {
                return (AdelieCreateOrEditPageViewModel) AdelieBaseFragment.this.getViewModel(AdelieCreateOrEditPageViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(AdelieBaseFragment this$0, AdelieHeadIconView this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.Mh(this_apply.getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String Eh(String extraInfo) {
        if (extraInfo == null) {
            return "";
        }
        return KRCSSViewExtensionKt.k0(extraInfo).getString("prompt");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x007f, code lost:
    
        if (r4 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ph(Intent data) {
        byte[] bArr;
        boolean booleanExtra = data.getBooleanExtra("isFromAlbum", false);
        ad.Companion companion = com.tencent.robot.adelie.homepage.ugc.ad.INSTANCE;
        String extraInfo = companion.a().getExtraInfo();
        final Bitmap avatar = companion.a().getAvatar();
        final Bitmap cover = companion.a().getCover();
        QLog.i("AdelieBaseFragment", 1, "AVATAR_REQUEST_ID result. extraInfo = " + extraInfo + " and avatarImage = " + avatar + " and coverImage = " + cover);
        if (extraInfo != null) {
            this.imageResource = AdelieConstant.ImageSource.AI_GENERATED.getValue();
        }
        if (booleanExtra) {
            this.imageResource = AdelieConstant.ImageSource.ALBUM_UPLOADED.getValue();
        }
        MyBotInfo value = Lh().h2().getValue();
        if (value != null) {
            if (extraInfo != null) {
                bArr = extraInfo.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
            }
            bArr = new byte[0];
            value.imgInfo = bArr;
            String Eh = Eh(extraInfo);
            if (Eh == null) {
                Eh = "";
            }
            value.imgDesc = Eh;
        }
        if (avatar != null) {
            AdelieHeadIconView Dh = Dh();
            if (Dh != null) {
                Dh.i(true);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.c
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieBaseFragment.Qh(AdelieBaseFragment.this, avatar);
                }
            }, 64, null, true);
        }
        if (cover != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.d
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieBaseFragment.Rh(AdelieBaseFragment.this, cover);
                }
            }, 64, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(final AdelieBaseFragment this$0, Bitmap avatar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(avatar, "$avatar");
        final Bitmap Jh = this$0.Jh(avatar, 640, 640);
        final String Uh = this$0.Uh(Jh, "adelie_album_avatar" + System.currentTimeMillis());
        if (Uh == null) {
            return;
        }
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieBaseFragment$processAIGeneratePicture$2$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AdelieHeadIconView Dh = AdelieBaseFragment.this.Dh();
                if (Dh != null) {
                    Dh.i(false);
                }
                AdelieHeadIconView Dh2 = AdelieBaseFragment.this.Dh();
                if (Dh2 != null) {
                    Dh2.setBitmap(Jh);
                }
                AdelieBaseFragment.this.Oh(Uh, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(final AdelieBaseFragment this$0, Bitmap bg5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bg5, "$bg");
        final String Uh = this$0.Uh(this$0.Jh(bg5, gdt_analysis_event.EVENT_MOTIVE_HIPPY_WEB_VIEW_DISPLAYED, WnsError.WNS_CODE_DIS_STAT_BEGIN), "adelie_album_avatar" + System.currentTimeMillis());
        if (Uh == null) {
            return;
        }
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieBaseFragment$processAIGeneratePicture$3$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AdelieBaseFragment.this.Oh(null, Uh);
            }
        });
    }

    private final void Sh(Intent data) {
        List<LocalMediaInfo> e16;
        AlbumResult albumResult = (AlbumResult) data.getParcelableExtra("ALBUM_RESULT");
        if (albumResult == null || (e16 = albumResult.e()) == null || e16.isEmpty()) {
            return;
        }
        boolean z16 = false;
        String path = e16.get(0).getPath();
        if (path == null) {
            return;
        }
        if (path.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Context context = getContext();
        if (context != null) {
            com.tencent.robot.adelie.homepage.ugc.ac.f366521a.b(context, path, 2);
        }
        this.imageResource = AdelieConstant.ImageSource.ALBUM_UPLOADED.getValue();
        com.tencent.robot.adelie.homepage.ugc.ad.INSTANCE.a().f(null);
        QLog.i("AdelieBaseFragment", 1, "path=" + path);
    }

    private final void Th(ActionSheet dialog) {
        ViewGroup rootView = dialog.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
        Nh(rootView, "em_bas_album_selection_popup");
        VideoReport.reportEvent("imp", dialog.getRootView(), null);
    }

    private final void Vh(Context context, View view) {
        gi(context);
        if (view != null) {
            Nh(view, "em_bas_album_selection");
            VideoReport.reportEvent("clck", view, null);
        }
        AdelieHeadIconView Dh = Dh();
        if (Dh != null) {
            Dh.setImageCategory(ImageCategory.ALBUM);
        }
    }

    static /* synthetic */ void Wh(AdelieBaseFragment adelieBaseFragment, Context context, View view, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                view = null;
            }
            adelieBaseFragment.Vh(context, view);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectAlbum");
    }

    private final void Zh(final Context context) {
        final ActionSheet actionSheet = null;
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        if (createDialog instanceof ActionSheet) {
            actionSheet = (ActionSheet) createDialog;
        }
        if (actionSheet == null) {
            return;
        }
        if (context != null) {
            actionSheet.addButtonWithLeftIcon("\u667a\u80fd\u751f\u6210", context.getDrawable(R.drawable.mhw), 9, "#AB8EFF", R.id.ub_);
        }
        actionSheet.addButtonWithLeftIcon("\u76f8\u518c\u9009\u53d6", ie0.a.f().o(context, R.drawable.qui_image_aio_oversized, R.color.qui_common_icon_primary, 1000), 0, "", R.id.uba);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.robot.adelie.homepage.create.e
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                AdelieBaseFragment.ai(ActionSheet.this, this, context, view, i3);
            }
        });
        actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.robot.adelie.homepage.create.f
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public final void onDismiss() {
                AdelieBaseFragment.bi(ActionSheet.this, this);
            }
        });
        actionSheet.addCancelButton(R.string.zp6);
        actionSheet.show();
        Th(actionSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(ActionSheet actionSheet, AdelieBaseFragment this$0, Context context, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int id5 = view.getId();
        if (id5 == R.id.ub_) {
            actionSheet.dismiss();
            this$0.yh(context);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            this$0.Nh(view, "em_bas_intelligent_generation");
            VideoReport.reportEvent("clck", view, null);
            AdelieHeadIconView Dh = this$0.Dh();
            if (Dh != null) {
                Dh.setImageCategory(ImageCategory.AI_GENERATE);
                return;
            }
            return;
        }
        if (id5 == R.id.uba) {
            actionSheet.dismiss();
            this$0.Vh(context, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(ActionSheet actionSheet, AdelieBaseFragment this$0) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            View view = actionSheet.getRootView().findViewById(R.id.action_sheet_btnCancel);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            this$0.Nh(view, "em_bas_Cancel");
            VideoReport.reportEvent("clck", view, null);
        } catch (Exception e16) {
            QLog.i("AdelieCreationFragment", 1, "setOnDismissListener error = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di(final Context context) {
        if (context == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.g
            @Override // java.lang.Runnable
            public final void run() {
                AdelieBaseFragment.ei(context);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(final Context context) {
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.g(1);
        aVar2.f(TabType.TAB_IMAGE);
        aVar2.j(true);
        aVar2.q(true);
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
        PickerInitBean.a aVar3 = new PickerInitBean.a();
        aVar3.b("\u786e\u5b9a");
        final Intent e16 = com.tencent.qqnt.qbasealbum.a.e(aVar, context, a16, aVar3.a(), null, null, 24, null);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.h
            @Override // java.lang.Runnable
            public final void run() {
                AdelieBaseFragment.fi(context, e16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.robot.adelie.AdelieFragmentActivity");
        ((AdelieFragmentActivity) context).getFragment().startActivityForResult(intent, 100001);
    }

    private final void gi(Context context) {
        boolean z16;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.AVATAR_PTOTO));
        Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026O\n            )\n        )");
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(context));
        } else {
            di(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004e, code lost:
    
        if (r1 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void zh(AdelieHeadIconView this_apply, AdelieBaseFragment this$0, View view) {
        Context context;
        boolean z16;
        boolean z17;
        boolean z18;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g() && (context = this_apply.getContext()) != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String d26 = this$0.Lh().d2();
            String e26 = this$0.Lh().e2();
            boolean z19 = true;
            if (e26.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (d26.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
            }
            if (e26 != null && e26.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                e26 = d26;
            }
            if (d26 != null && d26.length() != 0) {
                z19 = false;
            }
            if (z19) {
                d26 = e26;
            }
            com.tencent.robot.adelie.homepage.ugc.ac.f366521a.c(context, 3, d26, e26);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    public View Bh() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: Ch, reason: from getter */
    public final com.tencent.robot.qqmc.model.a getAiGenerateConfig() {
        return this.aiGenerateConfig;
    }

    @Nullable
    public abstract AdelieHeadIconView Dh();

    /* renamed from: Fh, reason: from getter */
    public final int getImageResource() {
        return this.imageResource;
    }

    @Nullable
    public com.tencent.biz.qui.quisecnavbar.a Gh() {
        return null;
    }

    @NotNull
    /* renamed from: Hh, reason: from getter */
    public final String getPageUuid() {
        return this.pageUuid;
    }

    @Nullable
    public AdeliePolarLightBkgView Ih() {
        return null;
    }

    @NotNull
    public final Bitmap Jh(@NotNull Bitmap originalBitmap, int maxWidth, int maxHeight) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(originalBitmap, "originalBitmap");
        float width = originalBitmap.getWidth();
        float height = originalBitmap.getHeight();
        float min = Math.min(maxWidth / width, maxHeight / height);
        roundToInt = MathKt__MathJVMKt.roundToInt(width * min);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(min * height);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(originalBitmap, roundToInt, roundToInt2, true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(origi\u2026ewWidth, newHeight, true)");
        return createScaledBitmap;
    }

    @NotNull
    public abstract String Kh();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AdelieCreateOrEditPageViewModel Lh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (AdelieCreateOrEditPageViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Mh(@Nullable Context context) {
        if (!u64.g.f438512a.g()) {
            if (this.aiGenerateConfig.a()) {
                Zh(context);
            } else {
                Wh(this, context, null, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Nh(@NotNull View view, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, view, elementId, null, null, null, null, null, 124, null);
        View view2 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view2 != null) {
            VideoReport.setLogicParent(view, view2);
        }
    }

    public abstract void Oh(@Nullable String avatarPath, @Nullable String bgPath);

    @Nullable
    public final String Uh(@NotNull Bitmap bitmap, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context context = getContext();
        if (context != null && context.getExternalFilesDir(null) != null) {
            try {
                File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "adelie_avatar").getAbsolutePath()), fileName + ".jpg");
                BaseImageUtil.saveBitmapFileAsJPEG(bitmap, 70, file);
                return file.getAbsolutePath();
            } catch (Throwable th5) {
                QLog.e("AdelieBaseFragment", 1, "saveBitmapToLocal failed t:" + th5);
            }
        }
        return null;
    }

    public final void Xh(int i3) {
        this.imageResource = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Yh(boolean enable) {
        QUISecNavBar qUISecNavBar;
        com.tencent.biz.qui.quisecnavbar.a Gh = Gh();
        if (Gh != null && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setRightIconEnabled(Gh, enable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ci(int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (errCode <= 10000) {
            errMsg = "\u5f53\u524d\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
        }
        QQToastUtil.showQQToastInUiThread(1, errMsg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int parseColor;
        QUISecNavBar qUISecNavBar;
        super.doOnCreateView(inflater, container, savedInstanceState);
        final AdelieHeadIconView Dh = Dh();
        if (Dh != null) {
            Dh.d(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieBaseFragment.zh(AdelieHeadIconView.this, this, view);
                }
            }, new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieBaseFragment.Ah(AdelieBaseFragment.this, Dh, view);
                }
            });
            Dh.setRotation(2.0f);
        }
        if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setCenterText(Kh());
            this.quiSecNavBar.setAutoAdaptTransparent(true);
            this.quiSecNavBar.setTitleAlpha(0.0f);
            this.quiSecNavBar.setLeftIconWithCircle(true);
            this.quiSecNavBar.setLeftImageRes(R.drawable.qui_close_icon);
            this.quiSecNavBar.setLeftImageResInTransParent(R.drawable.qui_close_icon_white);
            com.tencent.biz.qui.quisecnavbar.a Gh = Gh();
            if (Gh != null) {
                this.quiSecNavBar.d(Gh);
                this.quiSecNavBar.setRightIconWithCircle(true);
            }
            View Bh = Bh();
            if (Bh != null) {
                int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, c24.a.a(28));
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = c24.a.a(16);
                layoutParams.topMargin = statusBarHeight + c24.a.a(11);
                this.quiSecNavBar.addView(Bh, layoutParams);
            }
        }
        if (je0.a.a(BaseApplication.getContext())) {
            parseColor = Color.parseColor("#14181F");
        } else {
            parseColor = Color.parseColor("#CFEAFF");
        }
        this.titleRoot.setBackgroundColor(parseColor);
        AdeliePolarLightBkgView Ih = Ih();
        if (Ih != null) {
            Ih.a();
        }
        if (Ih != null) {
            Ih.setBackgroundVisibility(8);
        }
        this.titleRoot.addView(Ih, 0, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    protected boolean isTransparent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && data != null) {
            if (requestCode != 133) {
                if (requestCode == 100001) {
                    Sh(data);
                    return;
                }
                return;
            }
            Ph(data);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean secNavBarNeedImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    public void yh(@Nullable Context context) {
    }
}
