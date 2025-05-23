package com.tencent.robot.adelie.homepage.ugc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.BotGender;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.robot.adelie.AdelieFragmentActivity;
import com.tencent.robot.adelie.album.AdeliePreviewCustomization;
import com.tencent.robot.adelie.homepage.download.AdelieAvatarResourceManager;
import com.tencent.robot.adelie.homepage.ugc.AdelieAvatarUgcTemplateFragment;
import com.tencent.robot.adelie.homepage.ugc.ad;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarEditTextView;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarUgcTemplateMaterial;
import com.tencent.robot.adelie.homepage.ugc.view.EmptyPreviewCustomization;
import com.tencent.robot.adelie.homepage.ugc.view.Item;
import cooperation.qzone.QzoneIPCModule;
import d24.AdelieAvatarInfo;
import d24.AdelieAvatarResult;
import d24.GenerateRequestExtra;
import d24.UgcAdelieAvatarTemplateData;
import d24.UgcBasicConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 g2\u00020\u0001:\u0002hiB\u0007\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J&\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\"\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u0011H\u0002J\b\u0010-\u001a\u00020\u0011H\u0003R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0018\u00109\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010<R\u0018\u0010D\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00104R\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010VR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006j"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "useQUISecNavBar", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "secNavBarNeedImmersive", "needImmersive", "needStatusTrans", "isWrapContent", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "", "Ih", "path", "Zh", "initTitleBar", "Jh", "Yh", "Vh", "Kh", "Nh", "Sh", "Landroid/widget/RadioGroup;", "radioGroup", "Oh", "Ph", "Hh", "Gh", "Th", "Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarEditTextView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarEditTextView;", "avatarTextView", "Landroid/widget/RelativeLayout;", "D", "Landroid/widget/RelativeLayout;", "initialState", "E", "uploadedState", UserInfo.SEX_FEMALE, "addImage", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "addImageIcon", "H", "Landroid/widget/RadioGroup;", "styleRadioGroup", "I", "uploadedImage", "J", "removeImage", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "K", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "generationButton", "Landroid/view/View;", "L", "Landroid/view/View;", "buttomBar", "Lcom/tencent/robot/adelie/homepage/ugc/view/d;", "M", "Lcom/tencent/robot/adelie/homepage/ugc/view/d;", "adapter", "Lcom/tencent/qqnt/kernel/nativeinterface/BotGender;", "N", "Lcom/tencent/qqnt/kernel/nativeinterface/BotGender;", "gender", "P", "Ljava/lang/String;", "characterDescription", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "pickImagePath", "Ld24/m;", BdhLogUtil.LogTag.Tag_Req, "Ld24/m;", "ugcBasicConfig", ExifInterface.LATITUDE_SOUTH, "Z", "buttonEnable", "Lcom/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager;", "T", "Lcom/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager;", "resourceManager", "<init>", "()V", "U", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarFragment extends QIphoneTitleBarFragment {

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AdelieAvatarEditTextView avatarTextView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout initialState;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout uploadedState;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout addImage;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView addImageIcon;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RadioGroup styleRadioGroup;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView uploadedImage;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout removeImage;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QUIButton generationButton;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View buttomBar;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.robot.adelie.homepage.ugc.view.d adapter;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private UgcBasicConfig ugcBasicConfig;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean buttonEnable;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private BotGender gender = BotGender.KMALE;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private String characterDescription = "";

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String pickImagePath = "";

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final AdelieAvatarResourceManager resourceManager = new AdelieAvatarResourceManager();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarFragment$a;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "position", "", "smoothScrollToPosition", "Landroid/content/Context;", "context", "orientation", "", "reverseLayout", "<init>", "(Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarFragment;Landroid/content/Context;IZ)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class a extends LinearLayoutManager {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AdelieAvatarFragment f366497d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarFragment$a$a", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroid/view/View;", "view", "", "snapPreference", "calculateDxToMakeVisible", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9757a extends LinearSmoothScroller {
            C9757a(Context context) {
                super(context);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDxToMakeVisible(@Nullable View view, int snapPreference) {
                return (super.calculateDxToMakeVisible(view, -1) + super.calculateDxToMakeVisible(view, 1)) / 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull AdelieAvatarFragment adelieAvatarFragment, Context context, int i3, boolean z16) {
            super(context, i3, z16);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f366497d = adelieAvatarFragment;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(@Nullable RecyclerView recyclerView, @Nullable RecyclerView.State state, int position) {
            Context context;
            if (recyclerView != null) {
                context = recyclerView.getContext();
            } else {
                context = null;
            }
            C9757a c9757a = new C9757a(context);
            c9757a.setTargetPosition(position);
            startSmoothScroll(c9757a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarFragment$b;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "code", "", "a", "", "CHARACTER_DESCRIPTION", "Ljava/lang/String;", "CHARACTER_GENDER", "PICK_IMAGE_REQUEST", "I", "REFER_AVATAR_ICON", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarFragment$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Intent intent, int code) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            AdelieFragmentActivity.INSTANCE.b(context, intent, AdelieAvatarFragment.class, code);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarFragment$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            AdelieAvatarFragment.this.Vh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Fh(AdelieAvatarFragment this$0, View view) {
        String str;
        String str2;
        int i3;
        int i16;
        AdelieAvatarEditTextView adelieAvatarEditTextView;
        String str3;
        com.tencent.robot.adelie.homepage.ugc.view.d dVar;
        AdelieAvatarEditTextView adelieAvatarEditTextView2;
        String str4;
        RadioGroup radioGroup;
        AdelieAvatarUgcTemplateMaterial a16;
        Map mapOf;
        Item j06;
        String str5;
        String str6;
        Item j07;
        UgcAdelieAvatarTemplateData data;
        UgcAdelieAvatarTemplateData data2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i17 = 0;
        if (!this$0.buttonEnable) {
            QQToast.makeText(this$0.getContext(), 0, "\u8bf7\u586b\u5199\u5f62\u8c61\u63cf\u8ff0!", 0).show();
        } else {
            Context context = this$0.getContext();
            if (context != null) {
                Intent intent = new Intent();
                intent.putExtra(ISchemeApi.KEY_REFERER, "main_tab");
                intent.putExtra("adelie_avatar_info", this$0.Hh());
                if (this$0.ugcBasicConfig != null) {
                    intent.putExtra(LightConstants.BeautyConfigKey.KEY_BASIC_CONFIG, new Gson().toJson(this$0.ugcBasicConfig));
                }
                AdelieAvatarUgcTemplateFragment.Companion companion = AdelieAvatarUgcTemplateFragment.INSTANCE;
                AdelieAvatarUgcTemplateMaterial a17 = companion.a();
                String str7 = null;
                if (a17 != null && (data2 = a17.getData()) != null) {
                    str = data2.getPrompt();
                } else {
                    str = null;
                }
                AdelieAvatarEditTextView adelieAvatarEditTextView3 = this$0.avatarTextView;
                if (adelieAvatarEditTextView3 != null) {
                    str2 = adelieAvatarEditTextView3.s();
                } else {
                    str2 = null;
                }
                if (Intrinsics.areEqual(str, str2)) {
                    AdelieAvatarUgcTemplateMaterial a18 = companion.a();
                    if (a18 != null && (data = a18.getData()) != null) {
                        str5 = data.getStyle();
                    } else {
                        str5 = null;
                    }
                    com.tencent.robot.adelie.homepage.ugc.view.d dVar2 = this$0.adapter;
                    if (dVar2 != null && (j07 = dVar2.j0()) != null) {
                        str6 = j07.getStyleId();
                    } else {
                        str6 = null;
                    }
                    if (Intrinsics.areEqual(str5, str6)) {
                        i3 = 1;
                        Pair[] pairArr = new Pair[7];
                        if (this$0.pickImagePath.length() != 0) {
                            i16 = 1;
                        } else {
                            i16 = 0;
                        }
                        pairArr[0] = TuplesKt.to("is_pad", Integer.valueOf(i16));
                        adelieAvatarEditTextView = this$0.avatarTextView;
                        if (adelieAvatarEditTextView == null) {
                            str3 = adelieAvatarEditTextView.s();
                        } else {
                            str3 = null;
                        }
                        pairArr[1] = TuplesKt.to("image_description", str3);
                        dVar = this$0.adapter;
                        if (dVar != null || (j06 = dVar.j0()) == null || (r8 = j06.getStyleId()) == null) {
                            String str8 = "";
                        }
                        pairArr[2] = TuplesKt.to("pattern", str8);
                        adelieAvatarEditTextView2 = this$0.avatarTextView;
                        if (adelieAvatarEditTextView2 == null) {
                            str4 = adelieAvatarEditTextView2.z();
                        } else {
                            str4 = null;
                        }
                        pairArr[3] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, str4);
                        radioGroup = this$0.styleRadioGroup;
                        if (radioGroup != null) {
                            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                            if (checkedRadioButtonId == R.id.f165151v13) {
                                i17 = 1;
                            } else if (checkedRadioButtonId == R.id.f898250t) {
                                i17 = 2;
                            } else if (checkedRadioButtonId == R.id.slp) {
                                i17 = 3;
                            }
                        }
                        pairArr[4] = TuplesKt.to("reference_type", Integer.valueOf(i17));
                        a16 = companion.a();
                        if (a16 != null) {
                            str7 = a16.getModelId();
                        }
                        pairArr[5] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, str7);
                        pairArr[6] = TuplesKt.to("is_use_inspiration_templates", Integer.valueOf(i3));
                        mapOf = MapsKt__MapsKt.mapOf(pairArr);
                        VideoReport.reportEvent("clck", view, mapOf);
                        AdelieAvatarGenerateFragment.INSTANCE.a(context, intent, 133);
                    }
                }
                i3 = 0;
                Pair[] pairArr2 = new Pair[7];
                if (this$0.pickImagePath.length() != 0) {
                }
                pairArr2[0] = TuplesKt.to("is_pad", Integer.valueOf(i16));
                adelieAvatarEditTextView = this$0.avatarTextView;
                if (adelieAvatarEditTextView == null) {
                }
                pairArr2[1] = TuplesKt.to("image_description", str3);
                dVar = this$0.adapter;
                if (dVar != null) {
                }
                String str82 = "";
                pairArr2[2] = TuplesKt.to("pattern", str82);
                adelieAvatarEditTextView2 = this$0.avatarTextView;
                if (adelieAvatarEditTextView2 == null) {
                }
                pairArr2[3] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, str4);
                radioGroup = this$0.styleRadioGroup;
                if (radioGroup != null) {
                }
                pairArr2[4] = TuplesKt.to("reference_type", Integer.valueOf(i17));
                a16 = companion.a();
                if (a16 != null) {
                }
                pairArr2[5] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, str7);
                pairArr2[6] = TuplesKt.to("is_use_inspiration_templates", Integer.valueOf(i3));
                mapOf = MapsKt__MapsKt.mapOf(pairArr2);
                VideoReport.reportEvent("clck", view, mapOf);
                AdelieAvatarGenerateFragment.INSTANCE.a(context, intent, 133);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Gh() {
        this.resourceManager.j(this, this.gender, new AdelieAvatarResourceManager.b() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarFragment$downloadRes$1
            @Override // com.tencent.robot.adelie.homepage.download.AdelieAvatarResourceManager.b
            public void a(@NotNull List<MetaMaterial> materials) {
                Intrinsics.checkNotNullParameter(materials, "materials");
                ad.Companion companion = ad.INSTANCE;
                companion.b().clear();
                companion.b().addAll(materials);
            }

            @Override // com.tencent.robot.adelie.homepage.download.AdelieAvatarResourceManager.b
            public void b(@NotNull final List<Item> styleItemList) {
                Intrinsics.checkNotNullParameter(styleItemList, "styleItemList");
                final AdelieAvatarFragment adelieAvatarFragment = AdelieAvatarFragment.this;
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarFragment$downloadRes$1$onStyleConfigReady$1
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
                        com.tencent.robot.adelie.homepage.ugc.view.d dVar;
                        com.tencent.robot.adelie.homepage.ugc.view.d dVar2;
                        com.tencent.robot.adelie.homepage.ugc.view.d dVar3;
                        dVar = AdelieAvatarFragment.this.adapter;
                        if (dVar != null) {
                            dVar.n0(styleItemList);
                        }
                        dVar2 = AdelieAvatarFragment.this.adapter;
                        if (dVar2 != null) {
                            dVar2.l0();
                        }
                        dVar3 = AdelieAvatarFragment.this.adapter;
                        if (dVar3 != null) {
                            dVar3.notifyDataSetChanged();
                        }
                    }
                });
            }

            @Override // com.tencent.robot.adelie.homepage.download.AdelieAvatarResourceManager.b
            public void c(@NotNull UgcBasicConfig config) {
                Intrinsics.checkNotNullParameter(config, "config");
                AdelieAvatarFragment.this.ugcBasicConfig = config;
            }

            @Override // com.tencent.robot.adelie.homepage.download.AdelieAvatarResourceManager.b
            public void d(@NotNull final AdelieAvatarResourceManager.TagConfig config) {
                AdelieAvatarEditTextView adelieAvatarEditTextView;
                Intrinsics.checkNotNullParameter(config, "config");
                adelieAvatarEditTextView = AdelieAvatarFragment.this.avatarTextView;
                if (adelieAvatarEditTextView != null) {
                    adelieAvatarEditTextView.A(config.a(), config.b());
                }
                final AdelieAvatarFragment adelieAvatarFragment = AdelieAvatarFragment.this;
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarFragment$downloadRes$1$onTagConfigReady$1
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
                        AdelieAvatarEditTextView adelieAvatarEditTextView2;
                        adelieAvatarEditTextView2 = AdelieAvatarFragment.this.avatarTextView;
                        if (adelieAvatarEditTextView2 != null) {
                            adelieAvatarEditTextView2.w(config.c());
                        }
                    }
                });
            }
        });
    }

    private final String Hh() {
        String str;
        String str2;
        boolean z16;
        RadioGroup radioGroup;
        boolean Oh;
        RadioGroup radioGroup2;
        String s16;
        Item j06;
        String styleId;
        com.tencent.robot.adelie.homepage.ugc.view.d dVar = this.adapter;
        if (dVar == null || (j06 = dVar.j0()) == null || (styleId = j06.getStyleId()) == null) {
            str = "";
        } else {
            str = styleId;
        }
        AdelieAvatarEditTextView adelieAvatarEditTextView = this.avatarTextView;
        if (adelieAvatarEditTextView == null || (s16 = adelieAvatarEditTextView.s()) == null) {
            str2 = "";
        } else {
            str2 = s16;
        }
        boolean z17 = true;
        boolean z18 = false;
        if (this.pickImagePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (radioGroup = this.styleRadioGroup) == null) {
            Oh = false;
        } else {
            Oh = Oh(radioGroup);
        }
        if (this.pickImagePath.length() != 0) {
            z17 = false;
        }
        if (!z17 && (radioGroup2 = this.styleRadioGroup) != null) {
            z18 = Ph(radioGroup2);
        }
        String json = new Gson().toJson(new AdelieAvatarInfo(new GenerateRequestExtra(0, str, str2, Oh, z18, false, 33, null), this.pickImagePath, null, 4, null));
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(avatarInfo)");
        return json;
    }

    private final String Ih() {
        return "\u751f\u6210\u5f62\u8c61";
    }

    private final void Jh() {
        Map mapOf;
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.setPageId(view, "pg_smart_image_creation");
            VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
        }
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null) {
            View g16 = qUISecNavBar.g(BaseAction.ACTION_LEFT_BUTTON);
            com.tencent.robot.adelie.homepage.utils.h hVar = com.tencent.robot.adelie.homepage.utils.h.f366661a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("dt_pgid", "pg_smart_image_creation"));
            com.tencent.robot.adelie.homepage.utils.h.b(hVar, g16, "em_bas_cancel", mapOf, null, null, null, null, 120, null);
            VideoReport.reportEvent("imp", g16, null);
        }
        RelativeLayout relativeLayout = this.addImage;
        if (relativeLayout != null) {
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, relativeLayout, WinkDaTongReportConstant.ElementId.EM_BAS_UPLOAD_BUTTON, null, null, null, null, null, 124, null);
            VideoReport.reportEvent("imp", relativeLayout, null);
        }
        RelativeLayout relativeLayout2 = this.removeImage;
        if (relativeLayout2 != null) {
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, relativeLayout2, "em_bas_delete", null, null, null, null, null, 124, null);
        }
        QUIButton qUIButton = this.generationButton;
        if (qUIButton != null) {
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, qUIButton, "em_bas_generate_image", null, null, null, null, null, 124, null);
            VideoReport.reportEvent("imp", qUIButton, null);
        }
    }

    private final void Kh() {
        View view;
        View view2 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view2 != null) {
            this.initialState = (RelativeLayout) view2.findViewById(R.id.xo7);
            this.uploadedState = (RelativeLayout) view2.findViewById(R.id.f114676tz);
            this.addImage = (RelativeLayout) view2.findViewById(R.id.sda);
            this.addImageIcon = (ImageView) view2.findViewById(R.id.sdb);
            this.uploadedImage = (ImageView) view2.findViewById(R.id.f114666ty);
            this.removeImage = (RelativeLayout) view2.findViewById(R.id.f72893s3);
            this.styleRadioGroup = (RadioGroup) view2.findViewById(R.id.f70023kb);
            this.buttomBar = view2.findViewById(R.id.t_4);
            if (je0.a.a(BaseApplication.getContext()) && (view = this.buttomBar) != null) {
                view.setBackgroundResource(R.drawable.j3j);
            }
            RelativeLayout relativeLayout = this.addImage;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        AdelieAvatarFragment.Lh(AdelieAvatarFragment.this, view3);
                    }
                });
            }
            RelativeLayout relativeLayout2 = this.removeImage;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        AdelieAvatarFragment.Mh(AdelieAvatarFragment.this, view3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(AdelieAvatarFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            view.requestFocus();
            this$0.Yh();
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(AdelieAvatarFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pickImagePath = "";
        RelativeLayout relativeLayout = this$0.initialState;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        RelativeLayout relativeLayout2 = this$0.uploadedState;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        VideoReport.reportEvent("clck", view, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Nh() {
        View view;
        Context context = getContext();
        if (context != null && (view = ((QIphoneTitleBarFragment) this).mContentView) != null) {
            View findViewById = view.findViewById(R.id.i4l);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.recyclerView)");
            final RecyclerView recyclerView = (RecyclerView) findViewById;
            recyclerView.setLayoutManager(new a(this, context, 0, false));
            com.tencent.robot.adelie.homepage.ugc.view.d dVar = new com.tencent.robot.adelie.homepage.ugc.view.d(new ArrayList(), new Function2<View, Integer, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarFragment$initStyleView$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view2, Integer num) {
                    invoke(view2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull View view2, int i3) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    RecyclerView.this.smoothScrollToPosition(i3);
                }
            });
            this.adapter = dVar;
            recyclerView.setAdapter(dVar);
        }
    }

    private final boolean Oh(RadioGroup radioGroup) {
        if (radioGroup.getCheckedRadioButtonId() != R.id.f165151v13 && radioGroup.getCheckedRadioButtonId() != R.id.slp) {
            return false;
        }
        return true;
    }

    private final boolean Ph(RadioGroup radioGroup) {
        if (radioGroup.getCheckedRadioButtonId() != R.id.f898250t && radioGroup.getCheckedRadioButtonId() != R.id.slp) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(AdelieAvatarFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void Sh() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gender = BotGender.values()[arguments.getInt("character.gender", 0)];
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("character.description", com.tencent.ttpic.openapi.filter.LightConstants.MALE);
            } else {
                str = null;
            }
            if (str == null) {
                return;
            }
            this.characterDescription = str;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void Th() {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.q
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieAvatarFragment.Uh(AdelieAvatarFragment.this);
                }
            });
        }
        if (!QQTheme.isNowThemeIsNight() && getContext() != null) {
            int color = requireContext().getColor(R.color.qui_common_text_primary);
            View view2 = ((QIphoneTitleBarFragment) this).mContentView;
            if (view2 != null && (textView3 = (TextView) view2.findViewById(R.id.title)) != null) {
                textView3.setTextColor(color);
            }
            View view3 = ((QIphoneTitleBarFragment) this).mContentView;
            if (view3 != null && (textView2 = (TextView) view3.findViewById(R.id.f98845o7)) != null) {
                textView2.setTextColor(color);
            }
            int color2 = requireContext().getColor(R.color.qui_common_text_secondary);
            View view4 = ((QIphoneTitleBarFragment) this).mContentView;
            if (view4 != null && (textView = (TextView) view4.findViewById(R.id.f72153q3)) != null) {
                textView.setTextColor(color2);
            }
            ImageView imageView2 = this.addImageIcon;
            if (imageView2 != null) {
                Drawable k3 = ie0.a.f().k(getContext(), R.color.qui_common_fill_light_primary, c24.a.a(4), 1001);
                k3.setAlpha(128);
                imageView2.setBackground(k3);
            }
            View view5 = ((QIphoneTitleBarFragment) this).mContentView;
            if (view5 != null && (imageView = (ImageView) view5.findViewById(R.id.f72903s4)) != null) {
                imageView.setImageDrawable(ie0.a.f().p(getContext(), R.drawable.qui_close_filled, R.color.qui_common_fill_allblack_strong, 1001));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(AdelieAvatarFragment this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getContext() != null) {
            Drawable o16 = ie0.a.f().o(this$0.getContext(), R.drawable.jet, R.color.qui_common_icon_secondary, 1001);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = o16;
            URLDrawable drawable = URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/QQAgentAigc/gy_ibot_refer_avatar.png", obtain);
            if (!je0.a.a(BaseApplication.getContext())) {
                i3 = 76;
            } else {
                i3 = 51;
            }
            drawable.setAlpha(i3);
            ImageView imageView = this$0.addImageIcon;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.t
            @Override // java.lang.Runnable
            public final void run() {
                AdelieAvatarFragment.Wh(FragmentActivity.this, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(FragmentActivity context, final AdelieAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.g(1);
        aVar2.f(TabType.TAB_IMAGE);
        aVar2.j(true);
        aVar2.q(true);
        aVar2.m(false);
        Unit unit = Unit.INSTANCE;
        final Intent e16 = com.tencent.qqnt.qbasealbum.a.e(aVar, context, aVar2.a(), null, AdeliePreviewCustomization.class, EmptyPreviewCustomization.class, 4, null);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.u
            @Override // java.lang.Runnable
            public final void run() {
                AdelieAvatarFragment.Xh(AdelieAvatarFragment.this, e16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(AdelieAvatarFragment this$0, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        this$0.startActivityForResult(intent, 100001);
    }

    private final void Yh() {
        boolean z16;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.AVATAR_PTOTO));
        Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026O\n            )\n        )");
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c());
        } else {
            Vh();
        }
    }

    private final void Zh(String path) {
        boolean z16;
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        try {
            this.pickImagePath = path;
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(path, obtain);
            ImageView imageView = this.uploadedImage;
            if (imageView != null) {
                imageView.setImageDrawable(fileDrawable);
            }
            RelativeLayout relativeLayout = this.removeImage;
            if (relativeLayout != null) {
                VideoReport.reportEvent("imp", relativeLayout, null);
            }
            ((QIphoneTitleBarFragment) this).mContentView.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.m
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieAvatarFragment.ai(AdelieAvatarFragment.this);
                }
            });
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        QLog.i("AdelieAvatarFragment", 1, "path=" + path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(AdelieAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.initialState;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this$0.uploadedState;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
    }

    private final void initTitleBar() {
        QUISecNavBar qUISecNavBar;
        if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setCenterText(Ih());
            this.quiSecNavBar.setAutoAdaptTransparent(true);
            this.quiSecNavBar.setTitleAlpha(0.0f);
            this.quiSecNavBar.setLeftIconWithCircle(true);
            this.quiSecNavBar.setLeftImageRes(R.drawable.qui_close_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int parseColor;
        Intent intent;
        float f16;
        super.doOnCreateView(inflater, container, savedInstanceState);
        Sh();
        initTitleBar();
        Kh();
        Nh();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            QUIButton qUIButton = (QUIButton) view.findViewById(R.id.ubb);
            this.generationButton = qUIButton;
            if (qUIButton != null) {
                if (this.buttonEnable) {
                    f16 = 1.0f;
                } else {
                    f16 = 0.3f;
                }
                qUIButton.setAlpha(f16);
            }
            QUIButton qUIButton2 = this.generationButton;
            if (qUIButton2 != null) {
                qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AdelieAvatarFragment.Fh(AdelieAvatarFragment.this, view2);
                    }
                });
            }
            com.tencent.robot.adelie.homepage.ugc.view.q.f366599a.a(getContext(), this.generationButton);
            AdelieAvatarEditTextView adelieAvatarEditTextView = (AdelieAvatarEditTextView) view.findViewById(R.id.f83694k9);
            com.tencent.robot.adelie.homepage.ugc.view.y yVar = new com.tencent.robot.adelie.homepage.ugc.view.y() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarFragment$doOnCreateView$1$2$1
                @Override // com.tencent.robot.adelie.homepage.ugc.view.y
                public void a(@NotNull Editable s16) {
                    boolean z16;
                    Intrinsics.checkNotNullParameter(s16, "s");
                    AdelieAvatarFragment adelieAvatarFragment = AdelieAvatarFragment.this;
                    if (s16.toString().length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    adelieAvatarFragment.buttonEnable = z16;
                    final AdelieAvatarFragment adelieAvatarFragment2 = AdelieAvatarFragment.this;
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarFragment$doOnCreateView$1$2$1$onTextChange$1
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            QUIButton qUIButton3;
                            boolean z17;
                            qUIButton3 = AdelieAvatarFragment.this.generationButton;
                            if (qUIButton3 == null) {
                                return;
                            }
                            z17 = AdelieAvatarFragment.this.buttonEnable;
                            qUIButton3.setAlpha(z17 ? 1.0f : 0.3f);
                        }
                    });
                }
            };
            FragmentActivity activity = getActivity();
            if (activity != null) {
                intent = activity.getIntent();
            } else {
                intent = null;
            }
            adelieAvatarEditTextView.o("\u5f62\u8c61\u63cf\u8ff0", "\u4f8b\u5982:\u5728\u56fe\u4e66\u9986\u91cc\uff0c\u4e00\u4f4d\u7a7f\u7740\u6d01\u767d\u8fde\u8863\u88d9\u7684\u5973\u751f\u6b63\u5750\u5728\u6905\u5b50\u4e0a\u770b\u4e66\uff0c\u5979\u5e26\u7740\u4e00\u526f\u773c\u955c\uff0c\u957f\u957f\u7684\u9ed1\u53d1\u5782\u5728\u80f8\u524d\uff0c\u8868\u60c5\u8ba4\u771f\u3001\u6c89\u6d78\u3002\u6696\u6696\u7684\u9633\u5149\u900f\u8fc7\u7a97\u6237\u7167\u5728\u5979\u8eab\u4e0a\uff0c\u663e\u5f97\u975e\u5e38\u6e29\u548c\u3002", 150, yVar, intent);
            this.avatarTextView = adelieAvatarEditTextView;
        }
        if (je0.a.a(BaseApplication.getContext())) {
            parseColor = Color.parseColor("#14181F");
        } else {
            parseColor = Color.parseColor("#CFEAFF");
        }
        this.titleRoot.setBackgroundColor(parseColor);
        Th();
        ad.INSTANCE.c(new AdelieAvatarResult(null, null, null, 7, null));
        Jh();
        Gh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167575dt2;
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

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0099, code lost:
    
        if (r4 != true) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0098  */
    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        AdelieAvatarUgcTemplateMaterial a16;
        boolean z16;
        boolean z17;
        UgcAdelieAvatarTemplateData data2;
        RecyclerView recyclerView;
        String style;
        boolean z18;
        AdelieAvatarEditTextView adelieAvatarEditTextView;
        String prompt;
        boolean z19;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100001 && resultCode == -1 && data != null) {
            Zh(data.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"));
            return;
        }
        if (requestCode == 133 && resultCode == -1) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, data);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        if (requestCode == 134 && resultCode == -1 && (a16 = AdelieAvatarUgcTemplateFragment.INSTANCE.a()) != null) {
            boolean z26 = true;
            int i3 = 0;
            if (a16.getReferImageUrl().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Zh(a16.getReferImageUrl());
            }
            UgcAdelieAvatarTemplateData data3 = a16.getData();
            if (data3 != null && (prompt = data3.getPrompt()) != null) {
                if (prompt.length() > 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    z17 = true;
                    if (z17 && (adelieAvatarEditTextView = this.avatarTextView) != null) {
                        adelieAvatarEditTextView.B(a16.getData().getPrompt());
                    }
                    data2 = a16.getData();
                    if (data2 != null && (style = data2.getStyle()) != null) {
                        if (style.length() <= 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                    }
                    z26 = false;
                    if (!z26) {
                        com.tencent.robot.adelie.homepage.ugc.view.d dVar = this.adapter;
                        if (dVar != null) {
                            i3 = dVar.m0(a16.getData().getStyle());
                        }
                        View view = ((QIphoneTitleBarFragment) this).mContentView;
                        if (view != null && (recyclerView = (RecyclerView) view.findViewById(R.id.i4l)) != null) {
                            recyclerView.scrollToPosition(i3);
                            return;
                        }
                        return;
                    }
                    com.tencent.robot.adelie.homepage.ugc.view.d dVar2 = this.adapter;
                    if (dVar2 != null) {
                        dVar2.l0();
                        return;
                    }
                    return;
                }
            }
            z17 = false;
            if (z17) {
                adelieAvatarEditTextView.B(a16.getData().getPrompt());
            }
            data2 = a16.getData();
            if (data2 != null) {
                if (style.length() <= 0) {
                }
            }
            z26 = false;
            if (!z26) {
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        String s16;
        View g16;
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null && (g16 = qUISecNavBar.g(BaseAction.ACTION_LEFT_BUTTON)) != null) {
            VideoReport.reportEvent("clck", g16, null);
        }
        AdelieAvatarEditTextView adelieAvatarEditTextView = this.avatarTextView;
        boolean z16 = false;
        if (adelieAvatarEditTextView != null && (s16 = adelieAvatarEditTextView.s()) != null && s16.length() > 0) {
            z16 = true;
        }
        if (z16) {
            DialogUtil.createNoTitleDialog(getActivity(), getString(R.string.zp8), R.string.zpc, R.string.zp7, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AdelieAvatarFragment.Qh(AdelieAvatarFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AdelieAvatarFragment.Rh(dialogInterface, i3);
                }
            }).show();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AdelieAvatarUgcTemplateFragment.INSTANCE.b(null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.reportPgOut(view);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.reportPgIn(view, false);
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
}
