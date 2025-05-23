package com.tencent.mobileqq.wink.magicstudio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.view.ImageCreateJumpPart;
import com.tencent.mobileqq.wink.magicstudio.view.MagicNextButton;
import com.tencent.mobileqq.wink.magicstudio.view.StyleAdapter;
import com.tencent.mobileqq.wink.magicstudio.view.TagAdapter;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 u2\u00020\u0001:\u0001vB\u0007\u00a2\u0006\u0004\bs\u0010tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002R\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010!\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010!\u001a\u0004\b3\u0010#R\u001b\u00107\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010!\u001a\u0004\b6\u00100R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010!\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010!\u001a\u0004\b?\u0010@R\u001b\u0010E\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010!\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010!\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010!\u001a\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010!\u001a\u0004\bR\u0010SR\u001b\u0010W\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010!\u001a\u0004\bV\u0010#R\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u001b\u0010d\u001a\u00020`8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010!\u001a\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bf\u0010!\u001a\u0004\bg\u0010hR5\u0010r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010k\u00a2\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020\u00040jj\u0002`o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010q\u00a8\u0006w"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/TextCreationFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "contentView", "ai", "Th", "initView", "Xh", UIJsPlugin.EVENT_SHOW_LOADING, "ci", "bi", "Dh", "Uh", "Wh", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Nh", "()Landroid/widget/TextView;", "promptTitle", "D", "Mh", "promptLimit", "Landroid/widget/EditText;", "E", "Lh", "()Landroid/widget/EditText;", "promptDesc", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Rh", "()Landroidx/recyclerview/widget/RecyclerView;", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "G", "Ph", "styleTitle", "H", "Oh", "styleList", "Landroid/widget/ImageView;", "I", "Qh", "()Landroid/widget/ImageView;", "switchGradient", "Lcom/tencent/mobileqq/wink/magicstudio/view/MagicNextButton;", "J", "Kh", "()Lcom/tencent/mobileqq/wink/magicstudio/view/MagicNextButton;", "nextBtnArea", "K", "Hh", "()Landroid/view/View;", ToastView.ICON_LOADING, "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "L", "Ih", "()Lcom/tencent/mobileqq/vas/ui/VasPagView;", "loadingIcon", "Landroid/widget/LinearLayout;", "M", "Eh", "()Landroid/widget/LinearLayout;", GlobalUtil.DEF_STRING, "Landroid/widget/FrameLayout;", "N", "Gh", "()Landroid/widget/FrameLayout;", "emptyImg", "P", "Fh", "emptyBtn", "Lcom/tencent/mobileqq/wink/magicstudio/view/TagAdapter;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/magicstudio/view/TagAdapter;", "tagAdapter", "Lcom/tencent/mobileqq/wink/magicstudio/view/StyleAdapter;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/magicstudio/view/StyleAdapter;", "styleAdapter", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", ExifInterface.LATITUDE_SOUTH, "Sh", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "vm", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "T", "Jh", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "magicStudioVm", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/magicstudio/ab;", "Lkotlin/ParameterName;", "name", "info", "Lcom/tencent/mobileqq/wink/magicstudio/PageInfoCallback;", "U", "Lkotlin/jvm/functions/Function1;", "pageInfoCallbackInfo", "<init>", "()V", "V", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TextCreationFragment extends ImmersivePartFragment {

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy promptTitle;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy promptLimit;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy promptDesc;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy tags;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy styleTitle;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy styleList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy switchGradient;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy nextBtnArea;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy loading;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingIcon;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy empty;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyImg;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private TagAdapter tagAdapter;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private StyleAdapter styleAdapter;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicStudioVm;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Function1<PageInfoCallbackInfo, Unit> pageInfoCallbackInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/TextCreationFragment$a;", "", "", "a", "()I", "styleSpan", "DESC_LIMIT", "I", "", QQWinkTempConstants.FROM_MAGIC_STUDIO, "Ljava/lang/String;", "MAGIC_STUDIO_COVER_INDEX", "MAGIC_STUDIO_IMAGE_ID", "MAGIC_STUDIO_PROMPT", QQWinkTempConstants.MAGIC_STUDIO_STYLE_NAME, "MAGIC_STUDIO_TASK_ID", "MAIGC_STUDIO_PUBLISH_TRANS", "MAIGC_STUDIO_RECOMMEND", "MAIGC_STUDIO_RECOMMEND_WORDS", "MAIGC_STUDIO_REPORT_SESSION_ID", "MAX_STYLE_COUNT", "TAG", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            if (Resources.getSystem().getDisplayMetrics().widthPixels / Resources.getSystem().getDisplayMetrics().heightPixels > 0.5625f) {
                return 8;
            }
            return 4;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/TextCreationFragment$b", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "canScrollVertically", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends GridLayoutManager {
        b(Context context, int i3) {
            super(context, i3, 0, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/TextCreationFragment$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = ViewExKt.d(10);
            outRect.bottom = ViewExKt.d(10);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/TextCreationFragment$e", "Lcom/tencent/biz/richframework/part/block/base/SafeStaggeredGridLayoutManager;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends SafeStaggeredGridLayoutManager {
        e() {
            super(2, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/TextCreationFragment$f", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends RecyclerView.ItemDecoration {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex() < 1) {
                outRect.bottom = ViewExKt.d(5);
            } else {
                outRect.top = ViewExKt.d(5);
            }
            outRect.right = ViewExKt.d(6);
        }
    }

    public TextCreationFragment() {
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
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$promptTitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) TextCreationFragment.this.requireView().findViewById(R.id.f28710jo);
            }
        });
        this.promptTitle = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$promptLimit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) TextCreationFragment.this.requireView().findViewById(R.id.f28700jn);
            }
        });
        this.promptLimit = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$promptDesc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                return (EditText) TextCreationFragment.this.requireView().findViewById(R.id.f28680jl);
            }
        });
        this.promptDesc = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$tags$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) TextCreationFragment.this.requireView().findViewById(R.id.f9250582);
            }
        });
        this.tags = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$styleTitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) TextCreationFragment.this.requireView().findViewById(R.id.f898050r);
            }
        });
        this.styleTitle = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$styleList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) TextCreationFragment.this.requireView().findViewById(R.id.f897750o);
            }
        });
        this.styleList = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$switchGradient$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) TextCreationFragment.this.requireView().findViewById(R.id.f911754g);
            }
        });
        this.switchGradient = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<MagicNextButton>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$nextBtnArea$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MagicNextButton invoke() {
                return (MagicNextButton) TextCreationFragment.this.requireView().findViewById(R.id.zqh);
            }
        });
        this.nextBtnArea = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$loading$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return TextCreationFragment.this.requireView().findViewById(R.id.loading);
            }
        });
        this.loading = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<VasPagView>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$loadingIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VasPagView invoke() {
                return (VasPagView) TextCreationFragment.this.requireView().findViewById(R.id.ys6);
            }
        });
        this.loadingIcon = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$empty$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) TextCreationFragment.this.requireView().findViewById(R.id.f165084bw1);
            }
        });
        this.empty = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$emptyImg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) TextCreationFragment.this.requireView().findViewById(R.id.f165085uu0);
            }
        });
        this.emptyImg = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$emptyBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) TextCreationFragment.this.requireView().findViewById(R.id.utx);
            }
        });
        this.emptyBtn = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioCreationViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicStudioCreationViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(TextCreationFragment.this).get(MagicStudioCreationViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026ionViewModel::class.java)");
                return (MagicStudioCreationViewModel) viewModel;
            }
        });
        this.vm = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$magicStudioVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicStudioViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(TextCreationFragment.this.requireActivity()).get(MagicStudioViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026dioViewModel::class.java)");
                return (MagicStudioViewModel) viewModel;
            }
        });
        this.magicStudioVm = lazy15;
        this.pageInfoCallbackInfo = new Function1<PageInfoCallbackInfo, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$pageInfoCallbackInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PageInfoCallbackInfo pageInfoCallbackInfo) {
                invoke2(pageInfoCallbackInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable PageInfoCallbackInfo pageInfoCallbackInfo) {
                if (TextCreationFragment.this.getView() == null) {
                    w53.b.c("TextCreationFragment", "pageInfoCallbackInfo: view == null");
                    return;
                }
                if (pageInfoCallbackInfo == null) {
                    TextCreationFragment.this.ci();
                    return;
                }
                TextCreationFragment.this.bi();
                TextCreationFragment.this.Sh().e3(pageInfoCallbackInfo.a(), pageInfoCallbackInfo.b(), pageInfoCallbackInfo.c());
            }
        };
    }

    private final void Dh() {
        Gh().addView(new QUIEmptyState.Builder(getContext()).setImageType(5).setBackgroundColorType(0).setHalfScreenState(true).build());
        Jh().a2(this.pageInfoCallbackInfo);
        Qh().setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0, requireContext().getResources().getColor(R.color.qui_common_bg_bottom_light)}));
    }

    private final LinearLayout Eh() {
        Object value = this.empty.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-empty>(...)");
        return (LinearLayout) value;
    }

    private final TextView Fh() {
        Object value = this.emptyBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-emptyBtn>(...)");
        return (TextView) value;
    }

    private final FrameLayout Gh() {
        Object value = this.emptyImg.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-emptyImg>(...)");
        return (FrameLayout) value;
    }

    private final View Hh() {
        Object value = this.loading.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loading>(...)");
        return (View) value;
    }

    private final VasPagView Ih() {
        Object value = this.loadingIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingIcon>(...)");
        return (VasPagView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioViewModel Jh() {
        return (MagicStudioViewModel) this.magicStudioVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicNextButton Kh() {
        Object value = this.nextBtnArea.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-nextBtnArea>(...)");
        return (MagicNextButton) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText Lh() {
        Object value = this.promptDesc.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-promptDesc>(...)");
        return (EditText) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Mh() {
        Object value = this.promptLimit.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-promptLimit>(...)");
        return (TextView) value;
    }

    private final TextView Nh() {
        Object value = this.promptTitle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-promptTitle>(...)");
        return (TextView) value;
    }

    private final RecyclerView Oh() {
        Object value = this.styleList.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-styleList>(...)");
        return (RecyclerView) value;
    }

    private final TextView Ph() {
        Object value = this.styleTitle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-styleTitle>(...)");
        return (TextView) value;
    }

    private final ImageView Qh() {
        Object value = this.switchGradient.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-switchGradient>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView Rh() {
        Object value = this.tags.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tags>(...)");
        return (RecyclerView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioCreationViewModel Sh() {
        return (MagicStudioCreationViewModel) this.vm.getValue();
    }

    private final void Uh() {
        Jh().X1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TextCreationFragment.Vh(TextCreationFragment.this, (MagicStudioActivityResult) obj);
            }
        });
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new TextCreationFragment$initObserver$2(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new TextCreationFragment$initObserver$3(this, null));
        Sh().o3();
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new TextCreationFragment$initObserver$4(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new TextCreationFragment$initObserver$5(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new TextCreationFragment$initObserver$6(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(TextCreationFragment this$0, MagicStudioActivityResult magicStudioActivityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (52129 == magicStudioActivityResult.getRequestCode() && magicStudioActivityResult.getResultCode() == -1) {
            this$0.Jh().T1(2);
        }
    }

    private final void Wh() {
        Serializable serializable;
        Intent intent;
        FragmentActivity activity = getActivity();
        Map map = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_attrs");
        } else {
            serializable = null;
        }
        if (serializable instanceof Map) {
            map = (Map) serializable;
        }
        if (map != null) {
            if (map.containsKey("magic_studio_prompt")) {
                Sh().w3((String) map.get("magic_studio_prompt"));
                w53.b.a("TextCreationFragment", "scheme prompt is: " + map.get("magic_studio_prompt"));
            }
            if (map.containsKey("magic_studio_style")) {
                Sh().x3((String) map.get("magic_studio_style"));
                w53.b.a("TextCreationFragment", "scheme style is: " + map.get("magic_studio_style"));
            }
        }
    }

    private final void Xh() {
        int i3;
        int g16 = com.tencent.videocut.utils.o.g();
        com.tencent.videocut.utils.o oVar = com.tencent.videocut.utils.o.f384257a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        int f16 = oVar.f(requireContext);
        RecyclerView Oh = Oh();
        Context context = getContext();
        if (g16 * 16 > f16 * 9) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        Oh.setLayoutManager(new b(context, i3));
        Companion companion = INSTANCE;
        Oh().getLayoutParams().height = (((int) ((g16 - ViewExKt.d(((companion.a() - 1) * 10) + 16)) / (companion.a() - 0.75d))) * (8 / companion.a())) + (ViewExKt.d(10) * ((8 / companion.a()) - 1));
        Oh().setOverScrollMode(2);
        if (Oh().getItemDecorationCount() > 0) {
            Oh().removeItemDecorationAt(0);
        }
        Oh().addItemDecoration(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(TextCreationFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (NetworkUtil.isNetworkAvailable()) {
            this$0.Jh().a2(this$0.pageInfoCallbackInfo);
            this$0.Sh().o3();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(TextCreationFragment this$0, View view) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Lh().hasFocus()) {
            this$0.Lh().clearFocus();
            Context context = this$0.getContext();
            InputMethodManager inputMethodManager = null;
            if (context != null) {
                obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            } else {
                obj = null;
            }
            if (obj instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) obj;
            }
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this$0.Lh().getWindowToken(), 0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ai(View contentView) {
        if (getActivity() != null && r93.h.f430993a.g()) {
            HashMap hashMap = new HashMap();
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_QZ_TEXT_TO_PIC_DETAIL);
            Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE);
            Intrinsics.checkNotNullExpressionValue(obj, "get(WinkDaTongReportCons\u2026J_IS_FROM_WHICH_ENTRANCE)");
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, obj);
            VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(hashMap, WinkContext.INSTANCE.d().getDtParams().c()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi() {
        Hh().setVisibility(8);
        Eh().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci() {
        Hh().setVisibility(8);
        Eh().setVisibility(0);
    }

    private final void initView() {
        Th();
        Ih().api().build();
        showLoading();
        Kh().setClick(new Function1<MagicStudioButtonInfo, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$initView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MagicStudioButtonInfo magicStudioButtonInfo) {
                invoke2(magicStudioButtonInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MagicStudioButtonInfo magicStudioButtonInfo) {
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToast.makeText(BaseApplication.getContext(), "\u9b54\u6cd5\u5931\u7075\u5566\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\uff5e", 0).show();
                } else {
                    w53.b.f("TextCreationFragment", "text nextBtnArea prepareEditorData");
                    TextCreationFragment.this.Sh().r3();
                }
            }
        });
        Kh().setShareCallBack(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$initView$2
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
                MagicStudioViewModel Jh;
                Jh = TextCreationFragment.this.Jh();
                Jh.T1(2);
            }
        });
        VideoReport.setElementId(Kh(), QCircleDaTongConstant.ElementId.EM_XSJ_TASK_OPERATION_BUTTON);
        Kh().setReportCallBack(new Function1<HashMap<String, Object>, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$initView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
                invoke2(hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HashMap<String, Object> it) {
                Object orNull;
                String str;
                EditText Lh;
                MagicNextButton Kh;
                Intrinsics.checkNotNullParameter(it, "it");
                orNull = CollectionsKt___CollectionsKt.getOrNull(TextCreationFragment.this.Sh().V2().getValue(), 0);
                com.tencent.mobileqq.wink.magicstudio.model.f fVar = (com.tencent.mobileqq.wink.magicstudio.model.f) orNull;
                if (fVar == null || (str = fVar.getStyleName()) == null) {
                    str = "";
                }
                it.put(QCircleDaTongConstant.ElementParamKey.XSJ_STYLE, str);
                Lh = TextCreationFragment.this.Lh();
                it.put("xsj_text_content", Lh.getText().toString());
                it.put("xsj_if_picture", "0");
                Kh = TextCreationFragment.this.Kh();
                VideoReport.reportEvent("dt_clck", Kh, it);
            }
        });
        Mh().setText("0/100");
        Nh().setTextColor(requireContext().getColor(R.color.qui_common_text_primary));
        Ph().setTextColor(requireContext().getColor(R.color.qui_common_text_primary));
        EditText Lh = Lh();
        Lh.setTextColor(requireContext().getColor(R.color.qui_common_text_primary));
        Lh.setHintTextColor(requireContext().getColor(R.color.qui_common_text_secondary));
        Lh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        Lh().addTextChangedListener(new d());
        Rh().setLayoutManager(new e());
        RecyclerView Rh = Rh();
        TagAdapter tagAdapter = new TagAdapter(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$initView$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void invoke(int i3) {
                TextCreationFragment.this.Sh().i3(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        });
        this.tagAdapter = tagAdapter;
        Rh.setAdapter(tagAdapter);
        Rh().addItemDecoration(new f());
        Xh();
        RecyclerView Oh = Oh();
        StyleAdapter styleAdapter = new StyleAdapter(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$initView$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void invoke(int i3) {
                TextCreationFragment.this.Sh().g3(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        });
        this.styleAdapter = styleAdapter;
        Oh.setAdapter(styleAdapter);
        Fh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextCreationFragment.Yh(TextCreationFragment.this, view);
            }
        });
        requireView().findViewById(R.id.ub9).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextCreationFragment.Zh(TextCreationFragment.this, view);
            }
        });
        Dh();
    }

    private final void showLoading() {
        Hh().setVisibility(0);
        Eh().setVisibility(8);
        Ih().api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$showLoading$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView pagView) {
                Intrinsics.checkNotNullParameter(pagView, "pagView");
                PAGFile Load = PagViewMonitor.Load(TextCreationFragment.this.requireActivity().getAssets(), "wink/pag/editor_loading_img_wezone.pag");
                Intrinsics.checkNotNullExpressionValue(Load, "Load(requireActivity().a\u2026onLoadingDialog.PAG_PATH)");
                pagView.setComposition(Load);
                pagView.setRepeatCount(0);
                pagView.play();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ImageCreateJumpPart(Sh()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dtv;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        com.tencent.mobileqq.wink.l.f();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Xh();
        Oh().setAdapter(this.styleAdapter);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Wh();
        initView();
        Uh();
        ai(view);
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new TextCreationFragment$onViewCreated$1(this, null));
    }

    private final void Th() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/TextCreationFragment$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            int i3;
            TextView Mh = TextCreationFragment.this.Mh();
            if (s16 != null) {
                i3 = s16.length();
            } else {
                i3 = 0;
            }
            Mh.setText(i3 + "/100");
            TextCreationFragment.this.Sh().d3(String.valueOf(s16));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
