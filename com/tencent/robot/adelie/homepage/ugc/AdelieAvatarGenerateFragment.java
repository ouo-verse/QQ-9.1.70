package com.tencent.robot.adelie.homepage.ugc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
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
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.robot.adelie.AdelieFragmentActivity;
import com.tencent.robot.adelie.homepage.ugc.view.AdeliePagView;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieUgcUtil;
import com.tencent.robot.adelie.homepage.ugc.view.m;
import com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel;
import com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import d24.GenerateImageItem;
import d24.UgcAdelieAvatarTemplateData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGImageView;
import org.light.LightConstants;
import qshadow.ShadowAIGCGenerate$GenerateRequest;
import qshadow.ShadowAIGCGenerate$Media;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0001|\u0018\u0000 \u0082\u00012\u00020\u0001:\u0004\u0083\u0001\u0084\u0001B\t\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0003J\u0016\u0010\u0010\u001a\u00020\u000f*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0014J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J&\u0010!\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010#\u001a\u00020\"H\u0014J\"\u0010(\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016R\u001d\u00103\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001d\u00108\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u001d\u0010=\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00100\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u00100\u001a\u0004\b@\u0010AR\u001d\u0010G\u001a\u0004\u0018\u00010C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u00100\u001a\u0004\bE\u0010FR\u001d\u0010L\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u00100\u001a\u0004\bJ\u0010KR\u001d\u0010Q\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u00100\u001a\u0004\bO\u0010PR\u001d\u0010T\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u00100\u001a\u0004\bS\u0010KR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010gR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bl\u00100\u001a\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020p8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bq\u00100\u001a\u0004\br\u0010sR\u001b\u0010w\u001a\u00020p8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bu\u00100\u001a\u0004\bv\u0010sR\u0018\u0010{\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initTitleBar", "initView", "initData", "Uh", "Jh", "Lkotlin/Function1;", "", "resultBlock", "Yh", "fi", "Landroidx/recyclerview/widget/RecyclerView;", "isReversed", "Landroidx/recyclerview/widget/LinearSnapHelper;", "di", "bi", "Landroid/graphics/drawable/Drawable;", "Ih", "needBlur", "useQUISecNavBar", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "secNavBarNeedImmersive", "needImmersive", "needStatusTrans", "isWrapContent", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "", "getContentLayoutId", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/viewpager2/widget/ViewPager2;", "D", "Ph", "()Landroidx/viewpager2/widget/ViewPager2;", "previewPager", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "E", "Sh", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "useBtn", "Lcom/tencent/robot/adelie/homepage/ugc/view/AdeliePagView;", UserInfo.SEX_FEMALE, "Mh", "()Lcom/tencent/robot/adelie/homepage/ugc/view/AdeliePagView;", "loadingPagView", "Landroid/widget/ImageView;", "G", "Lh", "()Landroid/widget/ImageView;", "loadingImage", "Landroid/widget/RelativeLayout;", "H", "Oh", "()Landroid/widget/RelativeLayout;", "loadingView", "Landroid/widget/TextView;", "I", "Nh", "()Landroid/widget/TextView;", "loadingTipsView", "J", "Kh", "loadingFailedView", "Landroid/view/View;", "K", "Landroid/view/View;", "leftButton", "Landroid/widget/CheckBox;", "L", "Landroid/widget/CheckBox;", "saveTemplate", "Landroid/widget/EditText;", "M", "Landroid/widget/EditText;", "saveTemplateName", "Ld24/l;", "N", "Ld24/l;", "templateData", "", "P", "Ljava/lang/String;", "currentPadUrl", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "currentGenerateResultUrl", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", BdhLogUtil.LogTag.Tag_Req, "Th", "()Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel;", "viewModel", "Lcom/tencent/robot/adelie/homepage/ugc/view/m;", ExifInterface.LATITUDE_SOUTH, "Qh", "()Lcom/tencent/robot/adelie/homepage/ugc/view/m;", "ugcIconAdapter", "T", "Rh", "ugcImageAdapter", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel$c;", "U", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel$c;", "mUgcImageStateListener", "com/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment$d", "V", "Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment$d;", "pageChangeCallBack", "<init>", "()V", "W", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarGenerateFragment extends QIphoneTitleBarFragment {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy recyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy previewPager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy useBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingPagView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingImage;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingTipsView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingFailedView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View leftButton;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private CheckBox saveTemplate;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private EditText saveTemplateName;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private UgcAdelieAvatarTemplateData templateData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private String currentPadUrl;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String currentGenerateResultUrl;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy ugcIconAdapter;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy ugcImageAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private AdelieUgcImageViewModel.c mUgcImageStateListener;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final d pageChangeCallBack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "code", "", "a", "", "BASIC_CONFIG", "Ljava/lang/String;", "CREATE_AVATAR_INFO", "DEFAULT_ERROR_MSG", "IS_LOADING_ERROR_MSG", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Intent intent, int code) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            AdelieFragmentActivity.INSTANCE.b(context, intent, AdelieAvatarGenerateFragment.class, code);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment$b;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "fromX", "fromY", "toX", "toY", "", "animateMove", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends DefaultItemAnimator {
        @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
        public boolean animateMove(@NotNull RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            dispatchMoveFinished(holder);
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearSnapHelper f366501d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.robot.adelie.homepage.ugc.view.k f366502e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AdelieAvatarGenerateFragment f366503f;

        c(LinearSnapHelper linearSnapHelper, com.tencent.robot.adelie.homepage.ugc.view.k kVar, AdelieAvatarGenerateFragment adelieAvatarGenerateFragment) {
            this.f366501d = linearSnapHelper;
            this.f366502e = kVar;
            this.f366503f = adelieAvatarGenerateFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            View findSnapView;
            boolean z16;
            ViewPager2 Ph;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0 && (findSnapView = this.f366501d.findSnapView(this.f366502e)) != null) {
                int position = this.f366502e.getPosition(findSnapView);
                GenerateImageItem k06 = this.f366503f.Qh().k0(position);
                this.f366503f.Th().w2(position, k06);
                boolean z17 = true;
                if (position < this.f366503f.Rh().getNUM_BACKGOURND_ICON()) {
                    ViewPager2 Ph2 = this.f366503f.Ph();
                    if (Ph2 != null && Ph2.getCurrentItem() == position) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 && (Ph = this.f366503f.Ph()) != null) {
                        Ph.setCurrentItem(position, false);
                    }
                }
                if (k06 != null) {
                    String value = k06.c().getValue();
                    if (value != null && value.length() != 0) {
                        z17 = false;
                    }
                    if (!z17) {
                        return;
                    }
                }
                this.f366503f.Jh();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment$d", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (AdelieAvatarGenerateFragment.this.Th().getSelectedPosition() != position && position < AdelieAvatarGenerateFragment.this.Qh().getNUM_BACKGOURND_ICON()) {
                RecyclerView recyclerView = AdelieAvatarGenerateFragment.this.getRecyclerView();
                Intrinsics.checkNotNull(recyclerView);
                recyclerView.smoothScrollToPosition(position);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment$e", "Landroidx/recyclerview/widget/LinearSnapHelper;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "Landroid/view/View;", "findSnapView", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e extends LinearSnapHelper {
        e() {
        }

        @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(@Nullable RecyclerView.LayoutManager layoutManager) {
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            int itemCount = linearLayoutManager.getItemCount() - 1;
            if (findFirstCompletelyVisibleItemPosition == 0) {
                return linearLayoutManager.findViewByPosition(findFirstCompletelyVisibleItemPosition);
            }
            if (itemCount == findLastCompletelyVisibleItemPosition) {
                return linearLayoutManager.findViewByPosition(findLastCompletelyVisibleItemPosition);
            }
            return super.findSnapView(layoutManager);
        }
    }

    public AdelieAvatarGenerateFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final RecyclerView invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) AdelieAvatarGenerateFragment.this)).mContentView;
                if (view != null) {
                    return (RecyclerView) view.findViewById(R.id.xes);
                }
                return null;
            }
        });
        this.recyclerView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ViewPager2>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$previewPager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ViewPager2 invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) AdelieAvatarGenerateFragment.this)).mContentView;
                if (view != null) {
                    return (ViewPager2) view.findViewById(R.id.f27340fz);
                }
                return null;
            }
        });
        this.previewPager = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QUIButton>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$useBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QUIButton invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) AdelieAvatarGenerateFragment.this)).mContentView;
                if (view != null) {
                    return (QUIButton) view.findViewById(R.id.thq);
                }
                return null;
            }
        });
        this.useBtn = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<AdeliePagView>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$loadingPagView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final AdeliePagView invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) AdelieAvatarGenerateFragment.this)).mContentView;
                if (view != null) {
                    return (AdeliePagView) view.findViewById(R.id.f166133yt0);
                }
                return null;
            }
        });
        this.loadingPagView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$loadingImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ImageView invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) AdelieAvatarGenerateFragment.this)).mContentView;
                if (view != null) {
                    return (ImageView) view.findViewById(R.id.eff);
                }
                return null;
            }
        });
        this.loadingImage = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$loadingView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final RelativeLayout invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) AdelieAvatarGenerateFragment.this)).mContentView;
                if (view != null) {
                    return (RelativeLayout) view.findViewById(R.id.f113856rr);
                }
                return null;
            }
        });
        this.loadingView = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$loadingTipsView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TextView invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) AdelieAvatarGenerateFragment.this)).mContentView;
                if (view != null) {
                    return (TextView) view.findViewById(R.id.yt_);
                }
                return null;
            }
        });
        this.loadingTipsView = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$loadingFailedView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final RelativeLayout invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) AdelieAvatarGenerateFragment.this)).mContentView;
                if (view != null) {
                    return (RelativeLayout) view.findViewById(R.id.yss);
                }
                return null;
            }
        });
        this.loadingFailedView = lazy8;
        this.currentPadUrl = "";
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<AdelieUgcImageViewModel>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AdelieUgcImageViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(AdelieAvatarGenerateFragment.this.requireActivity()).get(AdelieUgcImageViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026ageViewModel::class.java)");
                return (AdelieUgcImageViewModel) viewModel;
            }
        });
        this.viewModel = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.robot.adelie.homepage.ugc.view.m>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$ugcIconAdapter$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment$ugcIconAdapter$2$a", "Lcom/tencent/robot/adelie/homepage/ugc/view/m$e;", "", "position", "", "onItemClick", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements m.e {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AdelieAvatarGenerateFragment f366508a;

                a(AdelieAvatarGenerateFragment adelieAvatarGenerateFragment) {
                    this.f366508a = adelieAvatarGenerateFragment;
                }

                @Override // com.tencent.robot.adelie.homepage.ugc.view.m.e
                public void onItemClick(int position) {
                    RecyclerView recyclerView;
                    if (position < this.f366508a.Qh().getNUM_BACKGOURND_ICON() && (recyclerView = this.f366508a.getRecyclerView()) != null) {
                        recyclerView.smoothScrollToPosition(position);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.robot.adelie.homepage.ugc.view.m invoke() {
                return new com.tencent.robot.adelie.homepage.ugc.view.m(new ArrayList(), AdelieAvatarGenerateFragment.this.Th(), 0, new a(AdelieAvatarGenerateFragment.this));
            }
        });
        this.ugcIconAdapter = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.robot.adelie.homepage.ugc.view.m>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$ugcImageAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.robot.adelie.homepage.ugc.view.m invoke() {
                return new com.tencent.robot.adelie.homepage.ugc.view.m(new ArrayList(), AdelieAvatarGenerateFragment.this.Th(), 1, null);
            }
        });
        this.ugcImageAdapter = lazy11;
        this.pageChangeCallBack = new d();
    }

    private final Drawable Ih() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(c24.a.a(4));
        Context context = getContext();
        if (context != null) {
            gradientDrawable.setStroke(c24.a.a(2), context.getColor(R.color.qui_common_brand_standard));
        }
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh() {
        if (Th().o2()) {
            return;
        }
        QLog.i("AdelieUgcImagePreviewFragment", 1, "generateNewImageItems");
        com.tencent.qqnt.adelie.homepage.utils.b.f348409a.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$generateNewImageItems$1
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
                AdelieAvatarGenerateFragment.this.Qh().j0(0);
                AdelieAvatarGenerateFragment.this.Rh().j0(0);
            }
        });
        Th().i2(new Function2<Boolean, GenerateImageItem, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$generateNewImageItems$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, GenerateImageItem generateImageItem) {
                invoke(bool.booleanValue(), generateImageItem);
                return Unit.INSTANCE;
            }

            public final void invoke(final boolean z16, @Nullable final GenerateImageItem generateImageItem) {
                if (AdelieAvatarGenerateFragment.this.isAdded()) {
                    com.tencent.qqnt.adelie.homepage.utils.b bVar = com.tencent.qqnt.adelie.homepage.utils.b.f348409a;
                    final AdelieAvatarGenerateFragment adelieAvatarGenerateFragment = AdelieAvatarGenerateFragment.this;
                    bVar.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$generateNewImageItems$2.1
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
                            RecyclerView recyclerView;
                            List<GenerateImageItem> listOf;
                            List<GenerateImageItem> listOf2;
                            RecyclerView recyclerView2;
                            GenerateImageItem generateImageItem2 = GenerateImageItem.this;
                            if (generateImageItem2 != null) {
                                AdelieAvatarGenerateFragment adelieAvatarGenerateFragment2 = adelieAvatarGenerateFragment;
                                com.tencent.robot.adelie.homepage.ugc.view.m Qh = adelieAvatarGenerateFragment2.Qh();
                                listOf = CollectionsKt__CollectionsJVMKt.listOf(generateImageItem2);
                                Qh.n0(listOf);
                                if (adelieAvatarGenerateFragment2.Qh().getNUM_BACKGOURND_ICON() == 2 && (recyclerView2 = adelieAvatarGenerateFragment2.getRecyclerView()) != null) {
                                    recyclerView2.smoothScrollToPosition(0);
                                }
                                com.tencent.robot.adelie.homepage.ugc.view.m Rh = adelieAvatarGenerateFragment2.Rh();
                                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(generateImageItem2);
                                Rh.n0(listOf2);
                            }
                            if (adelieAvatarGenerateFragment.Th().b2()) {
                                if (adelieAvatarGenerateFragment.Qh().getNUM_BACKGOURND_ICON() - 2 > 0 && adelieAvatarGenerateFragment.Th().getSelectedPosition() == adelieAvatarGenerateFragment.Qh().getNUM_BACKGOURND_ICON() - 1 && (recyclerView = adelieAvatarGenerateFragment.getRecyclerView()) != null) {
                                    recyclerView.smoothScrollToPosition(adelieAvatarGenerateFragment.Qh().getNUM_BACKGOURND_ICON() - 2);
                                }
                                adelieAvatarGenerateFragment.Qh().m0();
                                adelieAvatarGenerateFragment.Rh().m0();
                            }
                            if (!z16 || adelieAvatarGenerateFragment.Th().c2(adelieAvatarGenerateFragment.getContext())) {
                                adelieAvatarGenerateFragment.Qh().j0(2);
                                adelieAvatarGenerateFragment.Rh().j0(2);
                            }
                            if (z16) {
                                return;
                            }
                            adelieAvatarGenerateFragment.Th().y2(adelieAvatarGenerateFragment.getContext());
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout Kh() {
        return (RelativeLayout) this.loadingFailedView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Lh() {
        return (ImageView) this.loadingImage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdeliePagView Mh() {
        return (AdeliePagView) this.loadingPagView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Nh() {
        return (TextView) this.loadingTipsView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout Oh() {
        return (RelativeLayout) this.loadingView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewPager2 Ph() {
        return (ViewPager2) this.previewPager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.robot.adelie.homepage.ugc.view.m Qh() {
        return (com.tencent.robot.adelie.homepage.ugc.view.m) this.ugcIconAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.robot.adelie.homepage.ugc.view.m Rh() {
        return (com.tencent.robot.adelie.homepage.ugc.view.m) this.ugcImageAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIButton Sh() {
        return (QUIButton) this.useBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdelieUgcImageViewModel Th() {
        return (AdelieUgcImageViewModel) this.viewModel.getValue();
    }

    private final void Uh() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_select_image");
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(AdelieAvatarGenerateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Jh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(AdelieAvatarGenerateFragment this$0, CompoundButton compoundButton, boolean z16) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIButton Sh = this$0.Sh();
        if (Sh != null) {
            if (z16) {
                EditText editText = this$0.saveTemplateName;
                if (editText != null) {
                    editText.setVisibility(0);
                }
                str = "\u88c1\u526a\u5e76\u53d1\u9001";
            } else {
                EditText editText2 = this$0.saveTemplateName;
                if (editText2 != null) {
                    editText2.setVisibility(4);
                }
                str = "\u4f7f\u7528";
            }
            Sh.setText(str);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(AdelieAvatarGenerateFragment this$0, View view) {
        int i3;
        boolean z16;
        Map mapOf;
        String str;
        PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField;
        PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            int selectedPosition = this$0.Th().getSelectedPosition();
            GenerateImageItem k06 = this$0.Qh().k0(selectedPosition);
            boolean z17 = true;
            if (k06 != null && k06.c().getValue() != null) {
                ShadowAIGCGenerate$GenerateRequest generateRequest = k06.getGenerateRequest();
                if (generateRequest != null && (pBRepeatMessageField2 = generateRequest.medias) != null) {
                    i3 = pBRepeatMessageField2.size();
                } else {
                    i3 = 0;
                }
                Editable editable = null;
                if (i3 > 0) {
                    ShadowAIGCGenerate$GenerateRequest generateRequest2 = k06.getGenerateRequest();
                    if (generateRequest2 != null) {
                        pBRepeatMessageField = generateRequest2.medias;
                    } else {
                        pBRepeatMessageField = null;
                    }
                    Intrinsics.checkNotNull(pBRepeatMessageField);
                    String str2 = pBRepeatMessageField.get(0).string_data.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "item.generateRequest?.me\u2026as!![0].string_data.get()");
                    this$0.currentPadUrl = str2;
                }
                CheckBox checkBox = this$0.saveTemplate;
                if (checkBox != null && checkBox.isChecked()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && k06.c().getValue() != null) {
                    EditText editText = this$0.saveTemplateName;
                    if (editText != null) {
                        editable = editText.getText();
                    }
                    String valueOf = String.valueOf(editable);
                    if (this$0.currentPadUrl.length() != 0) {
                        z17 = false;
                    }
                    if (z17) {
                        str = "";
                    } else {
                        str = "pad.png";
                    }
                    this$0.templateData = new UgcAdelieAvatarTemplateData(0, valueOf, str, this$0.Th().getMAvatarOriginPrompt(), k06.getExtraInfo().getStyle(), 1, null);
                    this$0.currentGenerateResultUrl = k06.c().getValue();
                    FragmentActivity it12 = this$0.getActivity();
                    if (it12 != null) {
                        AdelieCroppingUtil adelieCroppingUtil = AdelieCroppingUtil.f366635a;
                        Intrinsics.checkNotNullExpressionValue(it12, "it1");
                        adelieCroppingUtil.k(it12, k06.c().getValue());
                    }
                } else {
                    QUIButton Sh = this$0.Sh();
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("pic_id", k06.getExtraInfo().getWorkflow_id()), TuplesKt.to("display_position", String.valueOf(selectedPosition)), TuplesKt.to("pad_url", this$0.currentPadUrl), TuplesKt.to("generated_url", k06.c().getValue()), TuplesKt.to("extra_data_str", this$0.Th().k2()));
                    VideoReport.reportEvent("clck", Sh, mapOf);
                    ad.INSTANCE.a().f(new Gson().toJson(k06.getExtraInfo()));
                    ac.f366521a.b(context, k06.c().getValue(), 1);
                }
            } else {
                QQToastUtil.showQQToastInUiThread(1, "\u8bf7\u9009\u62e9\u5408\u6cd5\u7684\u56fe\u7247");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Yh(final Function1<? super Boolean, Unit> resultBlock) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.w
            @Override // java.lang.Runnable
            public final void run() {
                AdelieAvatarGenerateFragment.Zh(Function1.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(Function1 resultBlock) {
        Intrinsics.checkNotNullParameter(resultBlock, "$resultBlock");
        ((IVasTempApi) QRoute.api(IVasTempApi.class)).requestPagDownload(new AdelieAvatarGenerateFragment$loadPagSoAsync$1$1(resultBlock));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(AdelieAvatarGenerateFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UgcAdelieAvatarTemplateData ugcAdelieAvatarTemplateData = this$0.templateData;
        if (ugcAdelieAvatarTemplateData != null) {
            AdelieUgcUtil.f366571a.f(this$0.requireContext(), this$0.currentPadUrl, this$0.currentGenerateResultUrl, str, ugcAdelieAvatarTemplateData, "adelie_avatar_ugc_template", new Function1<String, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$onActivityResult$2$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.qqnt.adelie.homepage.utils.b.f348409a.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$onActivityResult$2$1$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            QQToastUtil.showQQToastInUiThread(2, "\u4fdd\u5b58\u6210\u529f\uff0c\u8bf7\u5230\u4f01\u5fae\u7fa4\u67e5\u770b\u7ed3\u679c");
                        }
                    });
                }
            });
        }
    }

    private final void bi() {
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.aa
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieAvatarGenerateFragment.ci(AdelieAvatarGenerateFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(AdelieAvatarGenerateFragment this$0) {
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getContext() != null) {
            View view2 = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view2 != null) {
                view = view2.findViewById(R.id.f82254gd);
            } else {
                view = null;
            }
            if (view != null) {
                view.setBackground(this$0.Ih());
            }
        }
    }

    private final LinearSnapHelper di(RecyclerView recyclerView, boolean z16) {
        e eVar = new e();
        eVar.attachToRecyclerView(recyclerView);
        return eVar;
    }

    static /* synthetic */ LinearSnapHelper ei(AdelieAvatarGenerateFragment adelieAvatarGenerateFragment, RecyclerView recyclerView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return adelieAvatarGenerateFragment.di(recyclerView, z16);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void fi() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2 = getRecyclerView();
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecorationAt(0);
            recyclerView2.addItemDecoration(new com.tencent.robot.adelie.homepage.ugc.view.p());
            Qh().notifyDataSetChanged();
            int selectedPosition = Th().getSelectedPosition();
            if (Qh().getNUM_BACKGOURND_ICON() > 0 && selectedPosition < Qh().getNUM_BACKGOURND_ICON() && selectedPosition > 0 && (recyclerView = getRecyclerView()) != null) {
                recyclerView.smoothScrollToPosition(selectedPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getRecyclerView() {
        return (RecyclerView) this.recyclerView.getValue();
    }

    private final void initData() {
        String str;
        Yh(new Function1<Boolean, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
            
                r5 = r4.this$0.Mh();
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(boolean z16) {
                AdeliePagView Mh;
                if (AdelieAvatarGenerateFragment.this.getView() == null || Mh == null) {
                    return;
                }
                AssetManager assets = AdelieAvatarGenerateFragment.this.requireActivity().getAssets();
                Intrinsics.checkNotNullExpressionValue(assets, "requireActivity().assets");
                Mh.f(assets, "adelie_avatar_generate_loading.pag", true, new a(AdelieAvatarGenerateFragment.this));
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateFragment$initData$1$a", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "Lorg/libpag/PAGImageView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements PAGImageView.PAGImageViewListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AdelieAvatarGenerateFragment f366505d;

                a(AdelieAvatarGenerateFragment adelieAvatarGenerateFragment) {
                    this.f366505d = adelieAvatarGenerateFragment;
                }

                @Override // org.libpag.PAGImageView.PAGImageViewListener
                public void onAnimationStart(@Nullable PAGImageView p06) {
                    AdeliePagView Mh;
                    ImageView Lh;
                    Mh = this.f366505d.Mh();
                    if (Mh != null) {
                        Mh.setVisibility(0);
                    }
                    Lh = this.f366505d.Lh();
                    if (Lh != null) {
                        Lh.setVisibility(8);
                    }
                }

                @Override // org.libpag.PAGImageView.PAGImageViewListener
                public void onAnimationCancel(@Nullable PAGImageView p06) {
                }

                @Override // org.libpag.PAGImageView.PAGImageViewListener
                public void onAnimationEnd(@Nullable PAGImageView p06) {
                }

                @Override // org.libpag.PAGImageView.PAGImageViewListener
                public void onAnimationRepeat(@Nullable PAGImageView p06) {
                }

                @Override // org.libpag.PAGImageView.PAGImageViewListener
                public void onAnimationUpdate(@Nullable PAGImageView p06) {
                }
            }
        });
        this.mUgcImageStateListener = new AdelieUgcImageViewModel.c() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$initData$2
            @Override // com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel.c
            @SuppressLint({"SetTextI18n"})
            public void a(@Nullable GenerateImageItem item, @Nullable Integer loadingProgress) {
                if (item != null) {
                    final int state = item.getState();
                    com.tencent.qqnt.adelie.homepage.utils.b bVar = com.tencent.qqnt.adelie.homepage.utils.b.f348409a;
                    final AdelieAvatarGenerateFragment adelieAvatarGenerateFragment = AdelieAvatarGenerateFragment.this;
                    bVar.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$initData$2$onSelectedUgcImageStateChanged$1
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
                            RelativeLayout Oh;
                            RelativeLayout Kh;
                            QUIButton Sh;
                            QUIButton Sh2;
                            RelativeLayout Oh2;
                            RelativeLayout Kh2;
                            QUIButton Sh3;
                            QUIButton Sh4;
                            RelativeLayout Oh3;
                            RelativeLayout Kh3;
                            QUIButton Sh5;
                            QUIButton Sh6;
                            int i3 = state;
                            if (i3 == 0) {
                                Oh = adelieAvatarGenerateFragment.Oh();
                                if (Oh != null) {
                                    Oh.setVisibility(0);
                                }
                                Kh = adelieAvatarGenerateFragment.Kh();
                                if (Kh != null) {
                                    Kh.setVisibility(4);
                                }
                                Sh = adelieAvatarGenerateFragment.Sh();
                                if (Sh != null) {
                                    Sh.setClickable(false);
                                }
                                Sh2 = adelieAvatarGenerateFragment.Sh();
                                if (Sh2 == null) {
                                    return;
                                }
                                Sh2.setEnabled(false);
                                return;
                            }
                            if (i3 == 1) {
                                Oh2 = adelieAvatarGenerateFragment.Oh();
                                if (Oh2 != null) {
                                    Oh2.setVisibility(4);
                                }
                                Kh2 = adelieAvatarGenerateFragment.Kh();
                                if (Kh2 != null) {
                                    Kh2.setVisibility(4);
                                }
                                Sh3 = adelieAvatarGenerateFragment.Sh();
                                if (Sh3 != null) {
                                    Sh3.setClickable(true);
                                }
                                Sh4 = adelieAvatarGenerateFragment.Sh();
                                if (Sh4 == null) {
                                    return;
                                }
                                Sh4.setEnabled(true);
                                return;
                            }
                            if (i3 != 2) {
                                return;
                            }
                            Oh3 = adelieAvatarGenerateFragment.Oh();
                            if (Oh3 != null) {
                                Oh3.setVisibility(4);
                            }
                            Kh3 = adelieAvatarGenerateFragment.Kh();
                            if (Kh3 != null) {
                                Kh3.setVisibility(0);
                            }
                            Sh5 = adelieAvatarGenerateFragment.Sh();
                            if (Sh5 != null) {
                                Sh5.setClickable(false);
                            }
                            Sh6 = adelieAvatarGenerateFragment.Sh();
                            if (Sh6 == null) {
                                return;
                            }
                            Sh6.setEnabled(false);
                        }
                    });
                }
            }

            @Override // com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel.c
            @SuppressLint({"SetTextI18n"})
            public void b(final int progress, @NotNull final String progressTip) {
                Intrinsics.checkNotNullParameter(progressTip, "progressTip");
                com.tencent.qqnt.adelie.homepage.utils.b bVar = com.tencent.qqnt.adelie.homepage.utils.b.f348409a;
                final AdelieAvatarGenerateFragment adelieAvatarGenerateFragment = AdelieAvatarGenerateFragment.this;
                bVar.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$initData$2$onLoadingProgressChanged$1
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

                    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
                    
                        r0 = r2.Nh();
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2() {
                        TextView Nh;
                        if ((progressTip.length() > 0) && Nh != null) {
                            Nh.setText(progressTip);
                        }
                        if (progress == 100) {
                            GenerateImageItem k06 = adelieAvatarGenerateFragment.Qh().k0(adelieAvatarGenerateFragment.Th().getSelectedPosition());
                            if (k06 == null) {
                                return;
                            }
                            if (k06.getState() == 1) {
                                adelieAvatarGenerateFragment.Qh().j0(3);
                                adelieAvatarGenerateFragment.Rh().j0(3);
                            } else if (k06.getState() == 0) {
                                adelieAvatarGenerateFragment.Jh();
                            }
                        }
                    }
                });
            }
        };
        Th().x2(new WeakReference<>(this.mUgcImageStateListener));
        Th().w2(0, Qh().k0(0));
        Bundle arguments = getArguments();
        String str2 = null;
        if (arguments != null) {
            str = arguments.getString(LightConstants.BeautyConfigKey.KEY_BASIC_CONFIG);
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("adelie_avatar_info");
        }
        Th().t2(str, str2, new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$initData$3
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
                AdelieAvatarGenerateFragment.this.Jh();
            }
        });
    }

    private final void initTitleBar() {
        QUISecNavBar qUISecNavBar;
        if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setAutoAdaptTransparent(true);
            this.quiSecNavBar.setTitleAlpha(0.0f);
            this.quiSecNavBar.setLeftIconWithCircle(true);
            this.quiSecNavBar.setLeftImageRes(R.drawable.qui_close_icon);
            this.quiSecNavBar.setLeftImageResInTransParent(R.drawable.qui_close_icon);
            this.quiSecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$initTitleBar$1

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes25.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f366507a;

                    static {
                        int[] iArr = new int[BaseAction.values().length];
                        try {
                            iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        f366507a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view, @NotNull BaseAction action) {
                    Map mapOf;
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (a.f366507a[action.ordinal()] == 1) {
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("dt_pgid", "pg_bas_select_image"));
                        VideoReport.reportEvent("clck", view, mapOf);
                        AdelieAvatarGenerateFragment.this.requireActivity().finish();
                    }
                }
            });
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initView() {
        List<GenerateImageItem> listOf;
        List<GenerateImageItem> listOf2;
        QUISecNavBar qUISecNavBar;
        CheckBox checkBox = this.saveTemplate;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.robot.adelie.homepage.ugc.x
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    AdelieAvatarGenerateFragment.Wh(AdelieAvatarGenerateFragment.this, compoundButton, z16);
                }
            });
        }
        if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setAutoAdaptTransparent(true);
            this.quiSecNavBar.setTitleAlpha(0.0f);
            this.quiSecNavBar.setLeftIconWithCircle(true);
            this.quiSecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_allwhite_primary);
            this.quiSecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left_icon_allwhite_primary);
        }
        RecyclerView recyclerView = getRecyclerView();
        LinearLayout linearLayout = null;
        if (recyclerView != null) {
            com.tencent.robot.adelie.homepage.ugc.view.k kVar = new com.tencent.robot.adelie.homepage.ugc.view.k(recyclerView.getContext(), 0, false);
            recyclerView.setLayoutManager(kVar);
            recyclerView.setItemAnimator(new b());
            GenerateImageItem generateImageItem = new GenerateImageItem(0, null, null, null, 0, null, 63, null);
            com.tencent.robot.adelie.homepage.ugc.view.m Qh = Qh();
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(generateImageItem);
            Qh.setData(listOf2);
            recyclerView.setAdapter(Qh());
            recyclerView.addItemDecoration(new com.tencent.robot.adelie.homepage.ugc.view.p());
            recyclerView.addOnScrollListener(new c(ei(this, recyclerView, false, 1, null), kVar, this));
        }
        ViewPager2 Ph = Ph();
        if (Ph != null) {
            GenerateImageItem generateImageItem2 = new GenerateImageItem(0, null, null, null, 0, null, 63, null);
            com.tencent.robot.adelie.homepage.ugc.view.m Rh = Rh();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(generateImageItem2);
            Rh.setData(listOf);
            Ph.setAdapter(Rh());
            Ph.registerOnPageChangeCallback(this.pageChangeCallBack);
        }
        QUIButton Sh = Sh();
        if (Sh != null) {
            Sh.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieAvatarGenerateFragment.Xh(AdelieAvatarGenerateFragment.this, view);
                }
            });
        }
        QUIButton Sh2 = Sh();
        if (Sh2 != null) {
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, Sh2, "em_bas_use", null, null, null, null, null, 124, null);
        }
        RelativeLayout Kh = Kh();
        if (Kh != null) {
            Kh.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieAvatarGenerateFragment.Vh(AdelieAvatarGenerateFragment.this, view);
                }
            });
        }
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            linearLayout = (LinearLayout) view.findViewById(R.id.ahq);
        }
        com.tencent.robot.adelie.homepage.ugc.view.q.f366599a.a(getContext(), linearLayout);
        bi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map mapOf;
        super.doOnCreateView(inflater, container, savedInstanceState);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            view.setBackground(URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/QQAgentAigc/gy_ibot_generate_image_bg.png", obtain));
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(1, "\u5f53\u524d\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            return;
        }
        initTitleBar();
        initView();
        initData();
        Uh();
        View g16 = this.quiSecNavBar.g(BaseAction.ACTION_LEFT_BUTTON);
        this.leftButton = g16;
        if (g16 != null) {
            com.tencent.robot.adelie.homepage.utils.h hVar = com.tencent.robot.adelie.homepage.utils.h.f366661a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("dt_pgid", "pg_bas_select_image"));
            com.tencent.robot.adelie.homepage.utils.h.b(hVar, g16, "em_bas_cancel", mapOf, null, null, null, null, 120, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167576dt3;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    protected boolean isTransparent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean needBlur() {
        return true;
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
    public void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data) {
        final String str;
        ox3.a.g("AdelieUgcImagePreviewFragment", new Function0<String>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateFragment$onActivityResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "onActivityResult requestCode:" + requestCode + " resultCode:" + resultCode + " " + (data != null);
            }
        });
        if (requestCode == 133 && resultCode == -1) {
            ad.INSTANCE.a().f(Th().k2());
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
        if (requestCode == 135 && resultCode == -1) {
            if (data != null) {
                str = data.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            } else {
                str = null;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.v
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieAvatarGenerateFragment.ai(AdelieAvatarGenerateFragment.this, str);
                }
            }, 64, null, false);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        fi();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Th().onDestroy();
        ViewPager2 Ph = Ph();
        if (Ph != null) {
            Ph.unregisterOnPageChangeCallback(this.pageChangeCallBack);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Map mapOf;
        super.onPause();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            View view2 = this.leftButton;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("dt_pgid", "pg_bas_select_image"));
            VideoReport.reportEvent("imp_end", view2, mapOf);
            VideoReport.reportEvent("imp_end", Sh(), null);
            VideoReport.reportPgOut(view);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Map mapOf;
        super.onResume();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.reportPgIn(view, false);
            View view2 = this.leftButton;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("dt_pgid", "pg_bas_select_image"));
            VideoReport.reportEvent("imp", view2, mapOf);
            VideoReport.reportEvent("imp", Sh(), null);
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
