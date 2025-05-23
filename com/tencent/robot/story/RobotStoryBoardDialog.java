package com.tencent.robot.story;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.OptID;
import com.tencent.qqnt.kernel.nativeinterface.StoryAction;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001]B\u001f\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010*R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00100R\u0018\u0010E\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010\u001aR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\t0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00190J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010LR \u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0P0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010LR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006^"}, d2 = {"Lcom/tencent/robot/story/RobotStoryBoardDialog;", "Landroid/app/Dialog;", "Lo64/d;", "", "initWindow", "Landroid/view/View;", "i0", "l0", "o0", "Lcom/tencent/robot/story/PageState;", "state", "g0", "show", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;", "cardNode", "", "position", "D", "Lcom/tencent/aio/api/runtime/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "Ljava/lang/String;", "from", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "E", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "qusHalfScreenFloatingView", "Lo64/b;", UserInfo.SEX_FEMALE, "Lo64/b;", "storyAdapter", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "G", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "loadingView", "Landroid/widget/FrameLayout;", "H", "Landroid/widget/FrameLayout;", "errorContainer", "I", "Landroid/view/View;", "contentContainer", "Landroidx/recyclerview/widget/RecyclerView;", "J", "Landroidx/recyclerview/widget/RecyclerView;", "storyCardList", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "title", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "L", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "mEmptyState", "M", "rootLayout", "Lcom/tencent/robot/story/RobotStoryBoardViewModel;", "N", "Lcom/tencent/robot/story/RobotStoryBoardViewModel;", "viewModel", "", "P", QQWinkConstants.STORY_ID, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "storyName", "", BdhLogUtil.LogTag.Tag_Req, "Z", "firstAppear", "Landroidx/lifecycle/Observer;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/Observer;", "stateObserver", "T", "titleObserver", "", "Lp64/a;", "U", "cardListObserver", "Lcom/tencent/mobileqq/widget/qus/d;", "V", "Lcom/tencent/mobileqq/widget/qus/d;", "halfScreenFloatingController", "Landroid/content/Context;", "baseContext", "<init>", "(Landroid/content/Context;Lcom/tencent/aio/api/runtime/a;Ljava/lang/String;)V", "W", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotStoryBoardDialog extends ReportDialog implements o64.d {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String from;

    /* renamed from: E, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView qusHalfScreenFloatingView;

    /* renamed from: F, reason: from kotlin metadata */
    private o64.b storyAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private ScanningLightView loadingView;

    /* renamed from: H, reason: from kotlin metadata */
    private FrameLayout errorContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private View contentContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private RecyclerView storyCardList;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView title;

    /* renamed from: L, reason: from kotlin metadata */
    private QUIEmptyState mEmptyState;

    /* renamed from: M, reason: from kotlin metadata */
    private FrameLayout rootLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private RobotStoryBoardViewModel viewModel;

    /* renamed from: P, reason: from kotlin metadata */
    private long storyId;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String storyName;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean firstAppear;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Observer<PageState> stateObserver;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Observer<String> titleObserver;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<p64.a>> cardListObserver;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.widget.qus.d halfScreenFloatingController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/story/RobotStoryBoardDialog$a;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "from", "", "a", "", "CARD_ITEM_MARGIN", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.story.RobotStoryBoardDialog$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String from) {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(from, "from");
            Context context = aioContext.c().getContext();
            if (context == null) {
                return;
            }
            new RobotStoryBoardDialog(context, aioContext, from).show();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f368559a;

        static {
            int[] iArr = new int[PageState.values().length];
            try {
                iArr[PageState.Loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageState.Success.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PageState.Empty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PageState.Error.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f368559a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/robot/story/RobotStoryBoardDialog$c", "Lcom/tencent/mobileqq/widget/qus/e;", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", "Landroid/view/View;", "createContentView", "", "initState", "showMode", "defaultHeight", NodeProps.MIN_HEIGHT, NodeProps.MAX_HEIGHT, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            RecyclerView recyclerView = RobotStoryBoardDialog.this.storyCardList;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storyCardList");
                recyclerView = null;
            }
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            Log.d("RobotStoryBoardDialog", "canScrollDown: " + canScrollVertically);
            return canScrollVertically;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            RecyclerView recyclerView = RobotStoryBoardDialog.this.storyCardList;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storyCardList");
                recyclerView = null;
            }
            boolean canScrollVertically = recyclerView.canScrollVertically(1);
            Log.d("RobotStoryBoardDialog", "canScrollUp: " + canScrollVertically);
            return canScrollVertically;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF57179d() {
            return RobotStoryBoardDialog.this.i0();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int defaultHeight() {
            return ViewUtils.dip2px(533.0f);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return ViewUtils.dip2px(533.0f);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int minHeight() {
            return ViewUtils.dip2px(533.0f);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/robot/story/RobotStoryBoardDialog$d", "Lcom/tencent/mobileqq/widget/qus/a;", "", "onShowDefaultStart", "onShowDefault", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends com.tencent.mobileqq.widget.qus.a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/story/RobotStoryBoardDialog$d$a", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RobotStoryBoardDialog f368562d;

            a(RobotStoryBoardDialog robotStoryBoardDialog) {
                this.f368562d = robotStoryBoardDialog;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                Window window = this.f368562d.getWindow();
                QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.f368562d.qusHalfScreenFloatingView;
                QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
                if (qUSHalfScreenFloatingView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
                    qUSHalfScreenFloatingView = null;
                }
                QUIImmersiveHelper.t(window, false, null, true, qUSHalfScreenFloatingView.x());
                QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.f368562d.qusHalfScreenFloatingView;
                if (qUSHalfScreenFloatingView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
                } else {
                    qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView3;
                }
                ViewTreeObserver viewTreeObserver = qUSHalfScreenFloatingView2.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                }
                return true;
            }
        }

        d() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
            if (!RobotStoryBoardDialog.this.firstAppear) {
                return;
            }
            QLog.i("RobotStoryBoardDialog", 1, "onShowDefault");
            RobotStoryBoardViewModel robotStoryBoardViewModel = RobotStoryBoardDialog.this.viewModel;
            if (robotStoryBoardViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                robotStoryBoardViewModel = null;
            }
            robotStoryBoardViewModel.h(RobotStoryBoardDialog.this.aioContext.g().r().c().j(), OptID.KSTORY.ordinal(), "", false, Long.valueOf(RobotStoryBoardDialog.this.storyId));
            RobotStoryBoardDialog.this.firstAppear = false;
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefaultStart() {
            if (RobotStoryBoardDialog.this.firstAppear) {
                QUSHalfScreenFloatingView qUSHalfScreenFloatingView = RobotStoryBoardDialog.this.qusHalfScreenFloatingView;
                if (qUSHalfScreenFloatingView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
                    qUSHalfScreenFloatingView = null;
                }
                ViewTreeObserver viewTreeObserver = qUSHalfScreenFloatingView.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnPreDrawListener(new a(RobotStoryBoardDialog.this));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotStoryBoardDialog(@NotNull Context baseContext, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String from) {
        super(baseContext, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(from, "from");
        this.aioContext = aioContext;
        this.from = from;
        this.firstAppear = true;
        this.stateObserver = new Observer() { // from class: com.tencent.robot.story.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotStoryBoardDialog.p0(RobotStoryBoardDialog.this, (PageState) obj);
            }
        };
        this.titleObserver = new Observer() { // from class: com.tencent.robot.story.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotStoryBoardDialog.q0(RobotStoryBoardDialog.this, (String) obj);
            }
        };
        this.cardListObserver = new Observer() { // from class: com.tencent.robot.story.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotStoryBoardDialog.f0(RobotStoryBoardDialog.this, (List) obj);
            }
        };
        this.halfScreenFloatingController = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(RobotStoryBoardDialog this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotStoryBoardDialog", 1, "observeViewModel cardListLiveData: " + list);
        o64.b bVar = this$0.storyAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyAdapter");
            bVar = null;
        }
        bVar.submitList(new ArrayList(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v14, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r9v7, types: [android.view.View] */
    private final void g0(PageState state) {
        int i3 = b.f368559a[state.ordinal()];
        QUIEmptyState qUIEmptyState = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        ScanningLightView scanningLightView = this.loadingView;
                        if (scanningLightView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                            scanningLightView = null;
                        }
                        scanningLightView.setVisibility(8);
                        View view = this.contentContainer;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                            view = null;
                        }
                        view.setVisibility(8);
                        FrameLayout frameLayout = this.errorContainer;
                        if (frameLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
                            frameLayout = null;
                        }
                        frameLayout.setVisibility(0);
                        QUIEmptyState qUIEmptyState2 = this.mEmptyState;
                        if (qUIEmptyState2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
                        } else {
                            qUIEmptyState = qUIEmptyState2;
                        }
                        String qqStr = HardCodeUtil.qqStr(R.string.f223526gg);
                        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.robot_story_board_load_error)");
                        qUIEmptyState.setTitle(qqStr);
                        return;
                    }
                    return;
                }
                ScanningLightView scanningLightView2 = this.loadingView;
                if (scanningLightView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                    scanningLightView2 = null;
                }
                scanningLightView2.setVisibility(8);
                View view2 = this.contentContainer;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                    view2 = null;
                }
                view2.setVisibility(0);
                RecyclerView recyclerView = this.storyCardList;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storyCardList");
                    recyclerView = null;
                }
                recyclerView.setVisibility(8);
                FrameLayout frameLayout2 = this.errorContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
                    frameLayout2 = null;
                }
                frameLayout2.setVisibility(0);
                QUIEmptyState qUIEmptyState3 = this.mEmptyState;
                if (qUIEmptyState3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
                } else {
                    qUIEmptyState = qUIEmptyState3;
                }
                String qqStr2 = HardCodeUtil.qqStr(R.string.f223516gf);
                Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.robot_story_board_load_empty)");
                qUIEmptyState.setTitle(qqStr2);
                return;
            }
            FrameLayout frameLayout3 = this.errorContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
                frameLayout3 = null;
            }
            frameLayout3.setVisibility(8);
            ScanningLightView scanningLightView3 = this.loadingView;
            if (scanningLightView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                scanningLightView3 = null;
            }
            scanningLightView3.setVisibility(8);
            ?? r95 = this.contentContainer;
            if (r95 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            } else {
                qUIEmptyState = r95;
            }
            qUIEmptyState.setVisibility(0);
            return;
        }
        ScanningLightView scanningLightView4 = this.loadingView;
        if (scanningLightView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            scanningLightView4 = null;
        }
        scanningLightView4.setVisibility(0);
        FrameLayout frameLayout4 = this.errorContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
            frameLayout4 = null;
        }
        frameLayout4.setVisibility(8);
        ?? r96 = this.contentContainer;
        if (r96 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        } else {
            qUIEmptyState = r96;
        }
        qUIEmptyState.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View i0() {
        final boolean z16;
        QUIEmptyState qUIEmptyState = null;
        View root = LayoutInflater.from(getContext()).inflate(R.layout.hpe, (ViewGroup) null, false);
        View findViewById = root.findViewById(R.id.efs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.loading_view)");
        this.loadingView = (ScanningLightView) findViewById;
        View findViewById2 = root.findViewById(R.id.b_1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.content_root)");
        this.contentContainer = findViewById2;
        View findViewById3 = root.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.title)");
        this.title = (TextView) findViewById3;
        View findViewById4 = root.findViewById(R.id.to5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.card_list)");
        this.storyCardList = (RecyclerView) findViewById4;
        View findViewById5 = root.findViewById(R.id.by9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.error_container)");
        this.errorContainer = (FrameLayout) findViewById5;
        ScanningLightView scanningLightView = this.loadingView;
        if (scanningLightView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            scanningLightView = null;
        }
        scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_secondary);
        ScanningLightView scanningLightView2 = this.loadingView;
        if (scanningLightView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            scanningLightView2 = null;
        }
        scanningLightView2.post(new Runnable() { // from class: com.tencent.robot.story.f
            @Override // java.lang.Runnable
            public final void run() {
                RobotStoryBoardDialog.k0(RobotStoryBoardDialog.this);
            }
        });
        this.storyAdapter = new o64.b(this);
        RecyclerView recyclerView = this.storyCardList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyCardList");
            recyclerView = null;
        }
        o64.b bVar = this.storyAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyAdapter");
            bVar = null;
        }
        recyclerView.setAdapter(bVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        recyclerView.addItemDecoration(new o64.e(cVar.b(9)));
        recyclerView.setItemAnimator(null);
        recyclerView.setOverScrollMode(2);
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setBackgroundColorType(0).setHalfScreenState(true).build();
        this.mEmptyState = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
            build = null;
        }
        build.setImageView(0, 14, true);
        FrameLayout frameLayout = this.errorContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
            frameLayout = null;
        }
        QUIEmptyState qUIEmptyState2 = this.mEmptyState;
        if (qUIEmptyState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        } else {
            qUIEmptyState = qUIEmptyState2;
        }
        frameLayout.addView(qUIEmptyState, 0);
        if (this.storyId != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        View findViewById6 = root.findViewById(R.id.a48);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(getContext(), R.color.ajr));
        gradientDrawable.setStroke(cVar.b(1), ContextCompat.getColor(getContext(), R.color.qui_common_brand_light));
        gradientDrawable.setCornerRadius(cVar.b(8));
        findViewById6.setBackground(gradientDrawable);
        if (z16) {
            HashMap hashMap = new HashMap();
            hashMap.put("plot_id", String.valueOf(this.storyId));
            com.tencent.mobileqq.aio.utils.b.q("em_bas_back_the_beginning", hashMap);
            findViewById6.setVisibility(0);
        } else {
            findViewById6.setVisibility(8);
        }
        findViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.story.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotStoryBoardDialog.j0(RobotStoryBoardDialog.this, z16, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(root, "root");
        return root;
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        try {
            ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        } catch (Exception e16) {
            QLog.e("RobotStoryBoardDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(final RobotStoryBoardDialog this$0, boolean z16, final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotStoryBoardDialog", 1, "backAIO nick=" + this$0.aioContext.g().r().c().g() + ", from=" + this$0.storyName);
        HashMap hashMap = new HashMap();
        hashMap.put("plot_id", String.valueOf(this$0.storyId));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_back_the_beginning", hashMap);
        if (z16) {
            AIOParam g16 = this$0.aioContext.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            long a16 = su3.c.a(g16);
            String string = this$0.aioContext.g().l().getString("key_robot_story_data");
            StoryUtils storyUtils = StoryUtils.f366640a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            storyUtils.F(context, a16, string, StoryAction.QUITSTORY, true, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.robot.story.RobotStoryBoardDialog$initFloatView$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                    invoke(bool.booleanValue(), num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, int i3) {
                    if (z17) {
                        StoryUtils storyUtils2 = StoryUtils.f366640a;
                        storyUtils2.D(RobotStoryBoardDialog.this.aioContext.g().r().c().j(), true);
                        storyUtils2.l(RobotStoryBoardDialog.this.aioContext);
                        RobotStoryBoardDialog.this.dismiss();
                        return;
                    }
                    QQToast.makeText(view.getContext(), 1, i3, 1).show();
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(RobotStoryBoardDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScanningLightView scanningLightView = this$0.loadingView;
        ScanningLightView scanningLightView2 = null;
        if (scanningLightView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            scanningLightView = null;
        }
        Drawable drawable = scanningLightView.getDrawable();
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        ScanningLightView scanningLightView3 = this$0.loadingView;
        if (scanningLightView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            scanningLightView3 = null;
        }
        int width = scanningLightView3.getWidth();
        if (intrinsicWidth != 0 && width != 0) {
            float f16 = width / intrinsicWidth;
            Matrix matrix = new Matrix();
            matrix.setScale(f16, f16);
            ScanningLightView scanningLightView4 = this$0.loadingView;
            if (scanningLightView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                scanningLightView4 = null;
            }
            scanningLightView4.setImageMatrix(matrix);
            ScanningLightView scanningLightView5 = this$0.loadingView;
            if (scanningLightView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                scanningLightView2 = scanningLightView5;
            }
            scanningLightView2.setVisibility(0);
        }
    }

    private final void l0() {
        RobotStoryBoardViewModel robotStoryBoardViewModel = this.viewModel;
        RobotStoryBoardViewModel robotStoryBoardViewModel2 = null;
        if (robotStoryBoardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotStoryBoardViewModel = null;
        }
        robotStoryBoardViewModel.l().observeForever(this.stateObserver);
        RobotStoryBoardViewModel robotStoryBoardViewModel3 = this.viewModel;
        if (robotStoryBoardViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotStoryBoardViewModel3 = null;
        }
        robotStoryBoardViewModel3.m().observeForever(this.titleObserver);
        RobotStoryBoardViewModel robotStoryBoardViewModel4 = this.viewModel;
        if (robotStoryBoardViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            robotStoryBoardViewModel2 = robotStoryBoardViewModel4;
        }
        robotStoryBoardViewModel2.k().observeForever(this.cardListObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(RobotStoryBoardDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotStoryBoardDialog", 1, "qusHalfScreenFloatingView dismiss Listener");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(RobotStoryBoardDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotStoryBoardDialog", 1, "dialog dismiss Listener");
        this$0.o0();
    }

    private final void o0() {
        RobotStoryBoardViewModel robotStoryBoardViewModel = this.viewModel;
        RobotStoryBoardViewModel robotStoryBoardViewModel2 = null;
        if (robotStoryBoardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotStoryBoardViewModel = null;
        }
        robotStoryBoardViewModel.l().removeObserver(this.stateObserver);
        RobotStoryBoardViewModel robotStoryBoardViewModel3 = this.viewModel;
        if (robotStoryBoardViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotStoryBoardViewModel3 = null;
        }
        robotStoryBoardViewModel3.m().removeObserver(this.titleObserver);
        RobotStoryBoardViewModel robotStoryBoardViewModel4 = this.viewModel;
        if (robotStoryBoardViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            robotStoryBoardViewModel2 = robotStoryBoardViewModel4;
        }
        robotStoryBoardViewModel2.k().removeObserver(this.cardListObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(RobotStoryBoardDialog this$0, PageState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotStoryBoardDialog", 1, "observeViewModel pageStateLiveData: " + state);
        Intrinsics.checkNotNullExpressionValue(state, "state");
        this$0.g0(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(RobotStoryBoardDialog this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotStoryBoardDialog", 1, "observeViewModel titleLiveData: " + str);
        TextView textView = this$0.title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(str);
    }

    @Override // o64.d
    public void D(@NotNull HalfViewCardNode cardNode, int position) {
        Intrinsics.checkNotNullParameter(cardNode, "cardNode");
        RobotStoryBoardViewModel robotStoryBoardViewModel = this.viewModel;
        if (robotStoryBoardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotStoryBoardViewModel = null;
        }
        robotStoryBoardViewModel.g(this.aioContext, cardNode, new RobotStoryBoardDialog$onStoryCardClick$1(this));
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.storyId = this.aioContext.g().l().getLong("key_robot_story_id");
        this.storyName = this.aioContext.g().l().getString("key_robot_story_name");
        initWindow();
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.rootLayout = frameLayout;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = new QUSHalfScreenFloatingView(getContext());
        qUSHalfScreenFloatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.qusHalfScreenFloatingView = qUSHalfScreenFloatingView;
        FrameLayout frameLayout2 = this.rootLayout;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            frameLayout2 = null;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        frameLayout2.addView(qUSHalfScreenFloatingView3);
        FrameLayout frameLayout3 = this.rootLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            frameLayout3 = null;
        }
        setContentView(frameLayout3);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.setQUSDragFloatController(this.halfScreenFloatingController);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            qUSHalfScreenFloatingView5 = null;
        }
        qUSHalfScreenFloatingView5.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.robot.story.d
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                RobotStoryBoardDialog.m0(RobotStoryBoardDialog.this);
            }
        });
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView6 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView6;
        }
        qUSHalfScreenFloatingView2.j(new d());
        this.viewModel = new RobotStoryBoardViewModel();
        l0();
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.robot.story.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RobotStoryBoardDialog.n0(RobotStoryBoardDialog.this, dialogInterface);
            }
        });
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        Long l3;
        Bundle l16;
        super.show();
        HashMap hashMap = new HashMap();
        AIOParam g16 = this.aioContext.g();
        if (g16 != null && (l16 = g16.l()) != null) {
            l3 = Long.valueOf(l16.getLong("key_robot_story_id"));
        } else {
            l3 = null;
        }
        hashMap.put("plot_id", String.valueOf(l3));
        hashMap.put("come_from", this.from);
        com.tencent.mobileqq.aio.utils.b.q("em_bas_agent_half_selection", hashMap);
    }
}
