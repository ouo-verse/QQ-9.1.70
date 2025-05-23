package com.tencent.mobileqq.sharepanel.multiSelect.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import com.tencent.qqnt.aio.forward.ForwardMiniAIODelegate;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0003\\]^B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0007J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R*\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010C\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010=R$\u0010L\u001a\u0012\u0012\u0004\u0012\u00020H0Gj\b\u0012\u0004\u0012\u00020H`I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010=R\u0016\u0010P\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010=R\u0016\u0010R\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u00102R\u001b\u0010X\u001a\u00020S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tencent/mobileqq/sharepanel/fragment/a;", "", "initData", "Mh", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "floatingView", "Jh", "Landroid/view/View;", "Nh", OcrConfig.CHINESE, "Fh", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "dismiss", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isToAIO", "Ah", "isForceCancel", "Nd", "Landroid/widget/HorizontalScrollView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/HorizontalScrollView;", "animationContentView", "D", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "Lcom/tencent/qqnt/aio/forward/ForwardMiniAIODelegate;", "E", "Lcom/tencent/qqnt/aio/forward/ForwardMiniAIODelegate;", "aioPreview", UserInfo.SEX_FEMALE, "Landroid/view/View;", "userListView", "G", "Z", "needAnimation", "Lkotlin/Function0;", "H", "Lkotlin/jvm/functions/Function0;", "getOnDismissListener", "()Lkotlin/jvm/functions/Function0;", "Kh", "(Lkotlin/jvm/functions/Function0;)V", "onDismissListener", "Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$b;", "I", "Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$b;", "Gh", "()Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$b;", "Lh", "(Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$b;)V", "reportListener", "", "J", "panelHeight", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "Lkotlin/collections/ArrayList;", "K", "Ljava/util/ArrayList;", "selectedList", "L", "aioHeight", "M", "panelWidth", "N", "isInAIO", "Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/h;", "P", "Lkotlin/Lazy;", "Hh", "()Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/h;", "selectedListAdapter", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "c", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SelectedContactFragment extends ReportAndroidXDialogFragment implements com.tencent.mobileqq.sharepanel.fragment.a {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private HorizontalScrollView animationContentView;

    /* renamed from: D, reason: from kotlin metadata */
    private QUSHalfScreenImmersiveFloatingView floatingView;

    /* renamed from: E, reason: from kotlin metadata */
    private ForwardMiniAIODelegate aioPreview;

    /* renamed from: F, reason: from kotlin metadata */
    private View userListView;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean needAnimation;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onDismissListener;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private b reportListener;

    /* renamed from: J, reason: from kotlin metadata */
    private int panelHeight;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<SharePanelContactItem> selectedList;

    /* renamed from: L, reason: from kotlin metadata */
    private final int aioHeight;

    /* renamed from: M, reason: from kotlin metadata */
    private int panelWidth;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isInAIO;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedListAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$a;", "", "", "KEY_PANEL_HEIGHT", "Ljava/lang/String;", "KEY_SELECTED_CONTACT_LIST", "KEY_TITLE", "TAG", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$b;", "", "", "c", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "e", "Z", "b", "d", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        void Z(@NotNull SharePanelContactItem item);

        void a(@NotNull SharePanelContactItem item);

        void b();

        void c();

        void d();

        void e(@NotNull SharePanelContactItem item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$c;", "Landroid/widget/HorizontalScrollView;", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "", "velocityX", "", "fling", "d", "Z", "startScroll", "", "e", UserInfo.SEX_FEMALE, "startX", "f", "startY", tl.h.F, "lastX", "i", "isFirstAction", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment;Landroid/content/Context;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class c extends HorizontalScrollView {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean startScroll;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float startX;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float startY;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private float lastX;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean isFirstAction;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ SelectedContactFragment f287463m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull SelectedContactFragment selectedContactFragment, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f287463m = selectedContactFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) selectedContactFragment, (Object) context);
            } else {
                this.isFirstAction = true;
            }
        }

        @Override // android.widget.HorizontalScrollView
        public void fling(int velocityX) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, velocityX);
            }
        }

        @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ev5)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(ev5, "ev");
            if (!this.f287463m.isInAIO) {
                return false;
            }
            int action = ev5.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && this.startScroll) {
                        return super.onInterceptTouchEvent(ev5);
                    }
                } else {
                    this.isFirstAction = true;
                    if (this.startScroll) {
                        this.startScroll = false;
                        this.startX = 0.0f;
                        this.lastX = 0.0f;
                        return super.onInterceptTouchEvent(ev5);
                    }
                }
            } else if (ev5.getX() <= ViewUtils.dpToPx(getWidth() / 9)) {
                this.startScroll = true;
                this.startX = ev5.getX();
                this.startY = ev5.getY();
                QLog.d("SelectedContactFragment", 2, "ACTION_DOWN can handle");
                return super.onInterceptTouchEvent(ev5);
            }
            return false;
        }

        @Override // android.widget.HorizontalScrollView, android.view.View
        public boolean onTouchEvent(@NotNull MotionEvent ev5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) ev5)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(ev5, "ev");
            if (!this.f287463m.isInAIO) {
                return false;
            }
            int action = ev5.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.lastX = this.startX;
                        this.startX = ev5.getX();
                        return super.onTouchEvent(ev5);
                    }
                } else {
                    if (ev5.getX() - this.lastX > 0.0f) {
                        this.f287463m.Ah(false);
                    } else {
                        this.f287463m.Ah(true);
                    }
                    return super.onTouchEvent(ev5);
                }
            } else if (ev5.getX() <= ViewUtils.dpToPx(getHeight())) {
                this.startScroll = true;
                this.startX = ev5.getX();
                this.startY = ev5.getY();
                QLog.d("SelectedContactFragment", 2, "ACTION_DOWN can handle");
                return super.onTouchEvent(ev5);
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$d", "Lav3/a;", "Landroid/view/View;", "view", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements av3.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedContactFragment.this);
            }
        }

        @Override // av3.a
        public boolean a(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(view, "view");
            SelectedContactFragment.this.Ah(false);
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedContactFragment.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                SelectedContactFragment.this.isInAIO = true;
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SelectedContactFragment.this.isInAIO = true;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$f", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedContactFragment.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                SelectedContactFragment.this.isInAIO = false;
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SelectedContactFragment.this.isInAIO = false;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment$g", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class g extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectedContactFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF57179d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                HorizontalScrollView horizontalScrollView = SelectedContactFragment.this.animationContentView;
                if (horizontalScrollView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                    return null;
                }
                return horizontalScrollView;
            }
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39657);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SelectedContactFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.needAnimation = Build.VERSION.SDK_INT >= 26;
        this.panelHeight = DisplayUtil.getScreenHeight() / 2;
        this.selectedList = new ArrayList<>();
        this.aioHeight = (int) (ScreenUtil.SCREEN_HIGHT * 0.86d);
        this.panelWidth = ScreenUtil.SCREEN_WIDTH;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.multiSelect.adapter.h>() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment$selectedListAdapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectedContactFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.sharepanel.multiSelect.adapter.h invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new com.tencent.mobileqq.sharepanel.multiSelect.adapter.h(new Function1<SharePanelContactItem, Unit>() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment$selectedListAdapter$2.1
                    static IPatchRedirector $redirector_;

                    {
                        super(1);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) SelectedContactFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SharePanelContactItem sharePanelContactItem) {
                        invoke2(sharePanelContactItem);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull SharePanelContactItem it) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        SelectedContactFragment.b Gh = SelectedContactFragment.this.Gh();
                        if (Gh != null) {
                            Gh.e(it);
                        }
                    }
                }, new Function1<SharePanelContactItem, Unit>() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment$selectedListAdapter$2.2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "success", "Lcom/tencent/nt/adapter/session/e;", "sessionWithUid", "", "invoke", "(ZLcom/tencent/nt/adapter/session/e;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment$selectedListAdapter$2$2$1, reason: invalid class name */
                    /* loaded from: classes18.dex */
                    public static final class AnonymousClass1 extends Lambda implements Function2<Boolean, com.tencent.nt.adapter.session.e, Unit> {
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ SharePanelContactItem $it;
                        final /* synthetic */ SelectedContactFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(SelectedContactFragment selectedContactFragment, SharePanelContactItem sharePanelContactItem) {
                            super(2);
                            this.this$0 = selectedContactFragment;
                            this.$it = sharePanelContactItem;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) selectedContactFragment, (Object) sharePanelContactItem);
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void c(final SelectedContactFragment this$0, com.tencent.nt.adapter.session.e eVar, final SharePanelContactItem it) {
                            ForwardMiniAIODelegate forwardMiniAIODelegate;
                            Intrinsics.checkNotNullParameter(this$0, "this$0");
                            Intrinsics.checkNotNullParameter(it, "$it");
                            forwardMiniAIODelegate = this$0.aioPreview;
                            if (forwardMiniAIODelegate == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("aioPreview");
                                forwardMiniAIODelegate = null;
                            }
                            FragmentManager childFragmentManager = this$0.getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                            Intrinsics.checkNotNull(eVar);
                            ForwardMiniAIODelegate.e(forwardMiniAIODelegate, childFragmentManager, eVar.a(), eVar.b(), it.b(), null, 16, null);
                            ThreadManager.getUIHandler().postDelayed(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: INVOKE 
                                  (wrap:mqq.os.MqqHandler:0x003a: INVOKE  STATIC call: com.tencent.mobileqq.app.ThreadManager.getUIHandler():mqq.os.MqqHandler A[MD:():mqq.os.MqqHandler (m), WRAPPED] (LINE:59))
                                  (wrap:java.lang.Runnable:0x0040: CONSTRUCTOR 
                                  (r9v0 'this$0' com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment A[DONT_INLINE])
                                  (r11v0 'it' com.tencent.mobileqq.sharepanel.model.SharePanelContactItem A[DONT_INLINE])
                                 A[MD:(com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment, com.tencent.mobileqq.sharepanel.model.SharePanelContactItem):void (m), WRAPPED] (LINE:65) call: com.tencent.mobileqq.sharepanel.multiSelect.dialog.h.<init>(com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment, com.tencent.mobileqq.sharepanel.model.SharePanelContactItem):void type: CONSTRUCTOR)
                                  (100 long)
                                 VIRTUAL call: mqq.os.MqqHandler.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (m)] (LINE:70) in method: com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment.selectedListAdapter.2.2.1.c(com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment, com.tencent.nt.adapter.session.e, com.tencent.mobileqq.sharepanel.model.SharePanelContactItem):void, file: classes18.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.h, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 15 more
                                */
                            /*
                                java.lang.String r0 = "this$0"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                                java.lang.String r0 = "$it"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                                com.tencent.qqnt.aio.forward.ForwardMiniAIODelegate r0 = com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment.vh(r9)
                                if (r0 != 0) goto L19
                                java.lang.String r0 = "aioPreview"
                                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                                r0 = 0
                            L19:
                                r1 = r0
                                androidx.fragment.app.FragmentManager r2 = r9.getChildFragmentManager()
                                java.lang.String r0 = "childFragmentManager"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
                                int r3 = r10.a()
                                java.lang.String r4 = r10.b()
                                java.lang.String r5 = r11.b()
                                r6 = 0
                                r7 = 16
                                r8 = 0
                                com.tencent.qqnt.aio.forward.ForwardMiniAIODelegate.e(r1, r2, r3, r4, r5, r6, r7, r8)
                                mqq.os.MqqHandler r10 = com.tencent.mobileqq.app.ThreadManager.getUIHandler()
                                com.tencent.mobileqq.sharepanel.multiSelect.dialog.h r0 = new com.tencent.mobileqq.sharepanel.multiSelect.dialog.h
                                r0.<init>(r9, r11)
                                r1 = 100
                                r10.postDelayed(r0, r1)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment$selectedListAdapter$2.AnonymousClass2.AnonymousClass1.c(com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment, com.tencent.nt.adapter.session.e, com.tencent.mobileqq.sharepanel.model.SharePanelContactItem):void");
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void d(SelectedContactFragment this$0, SharePanelContactItem it) {
                            Intrinsics.checkNotNullParameter(this$0, "this$0");
                            Intrinsics.checkNotNullParameter(it, "$it");
                            this$0.Ah(true);
                            SelectedContactFragment.b Gh = this$0.Gh();
                            if (Gh != null) {
                                Gh.a(it);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, com.tencent.nt.adapter.session.e eVar) {
                            invoke(bool.booleanValue(), eVar);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16, @Nullable final com.tencent.nt.adapter.session.e eVar) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), eVar);
                                return;
                            }
                            if (z16) {
                                MqqHandler uIHandler = ThreadManager.getUIHandler();
                                final SelectedContactFragment selectedContactFragment = this.this$0;
                                final SharePanelContactItem sharePanelContactItem = this.$it;
                                uIHandler.post(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: INVOKE 
                                      (r6v2 'uIHandler' mqq.os.MqqHandler)
                                      (wrap:java.lang.Runnable:0x002a: CONSTRUCTOR 
                                      (r0v1 'selectedContactFragment' com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment A[DONT_INLINE])
                                      (r7v0 'eVar' com.tencent.nt.adapter.session.e A[DONT_INLINE])
                                      (r1v1 'sharePanelContactItem' com.tencent.mobileqq.sharepanel.model.SharePanelContactItem A[DONT_INLINE])
                                     A[MD:(com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment, com.tencent.nt.adapter.session.e, com.tencent.mobileqq.sharepanel.model.SharePanelContactItem):void (m), WRAPPED] call: com.tencent.mobileqq.sharepanel.multiSelect.dialog.g.<init>(com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment, com.tencent.nt.adapter.session.e, com.tencent.mobileqq.sharepanel.model.SharePanelContactItem):void type: CONSTRUCTOR)
                                     VIRTUAL call: mqq.os.MqqHandler.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (m)] in method: com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment.selectedListAdapter.2.2.1.invoke(boolean, com.tencent.nt.adapter.session.e):void, file: classes18.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.g, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 27 more
                                    */
                                /*
                                    this = this;
                                    com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment$selectedListAdapter$2.AnonymousClass2.AnonymousClass1.$redirector_
                                    r1 = 1
                                    if (r0 == 0) goto L1e
                                    r2 = 2
                                    boolean r3 = r0.hasPatch(r2)
                                    if (r3 == 0) goto L1e
                                    r3 = 3
                                    java.lang.Object[] r3 = new java.lang.Object[r3]
                                    r4 = 0
                                    r3[r4] = r5
                                    java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
                                    r3[r1] = r6
                                    r3[r2] = r7
                                    r0.redirect(r2, r3)
                                    return
                                L1e:
                                    if (r6 == 0) goto L31
                                    mqq.os.MqqHandler r6 = com.tencent.mobileqq.app.ThreadManager.getUIHandler()
                                    com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment r0 = r5.this$0
                                    com.tencent.mobileqq.sharepanel.model.SharePanelContactItem r1 = r5.$it
                                    com.tencent.mobileqq.sharepanel.multiSelect.dialog.g r2 = new com.tencent.mobileqq.sharepanel.multiSelect.dialog.g
                                    r2.<init>(r0, r7, r1)
                                    r6.post(r2)
                                    goto L3a
                                L31:
                                    java.lang.String r6 = "SelectedContactFragment"
                                    java.lang.String r7 = "uid get failed !!!"
                                    com.tencent.qphone.base.util.QLog.e(r6, r1, r7)
                                L3a:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment$selectedListAdapter$2.AnonymousClass2.AnonymousClass1.invoke(boolean, com.tencent.nt.adapter.session.e):void");
                            }
                        }

                        {
                            super(1);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) SelectedContactFragment.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SharePanelContactItem sharePanelContactItem) {
                            invoke2(sharePanelContactItem);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull SharePanelContactItem it) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) it);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(it, "it");
                            SelectedContactFragment.b Gh = SelectedContactFragment.this.Gh();
                            if (Gh != null) {
                                Gh.Z(it);
                            }
                            com.tencent.nt.adapter.session.c.j(it.e(), it.f(), new AnonymousClass1(SelectedContactFragment.this, it));
                        }
                    }) : (com.tencent.mobileqq.sharepanel.multiSelect.adapter.h) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.selectedListAdapter = lazy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void Bh(SelectedContactFragment this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            HorizontalScrollView horizontalScrollView = this$0.animationContentView;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                horizontalScrollView = null;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            horizontalScrollView.setScrollX(((Integer) animatedValue).intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void Ch(SelectedContactFragment this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            HorizontalScrollView horizontalScrollView = this$0.animationContentView;
            HorizontalScrollView horizontalScrollView2 = null;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                horizontalScrollView = null;
            }
            ViewGroup.LayoutParams layoutParams = horizontalScrollView.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "animationContentView.getLayoutParams()");
            layoutParams.height = (int) floatValue;
            HorizontalScrollView horizontalScrollView3 = this$0.animationContentView;
            if (horizontalScrollView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
            } else {
                horizontalScrollView2 = horizontalScrollView3;
            }
            horizontalScrollView2.setLayoutParams(layoutParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void Dh(SelectedContactFragment this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            HorizontalScrollView horizontalScrollView = this$0.animationContentView;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                horizontalScrollView = null;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            horizontalScrollView.setScrollX(((Integer) animatedValue).intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void Eh(SelectedContactFragment this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            HorizontalScrollView horizontalScrollView = this$0.animationContentView;
            HorizontalScrollView horizontalScrollView2 = null;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                horizontalScrollView = null;
            }
            ViewGroup.LayoutParams layoutParams = horizontalScrollView.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "animationContentView.getLayoutParams()");
            layoutParams.height = (int) floatValue;
            HorizontalScrollView horizontalScrollView3 = this$0.animationContentView;
            if (horizontalScrollView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
            } else {
                horizontalScrollView2 = horizontalScrollView3;
            }
            horizontalScrollView2.setLayoutParams(layoutParams);
        }

        private final void Fh() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            c cVar = new c(this, requireContext);
            if (this.needAnimation) {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(this.panelWidth, this.panelHeight);
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(this.panelWidth, this.aioHeight);
            }
            cVar.setLayoutParams(marginLayoutParams);
            LinearLayout linearLayout = new LinearLayout(requireContext());
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
            View Nh = Nh();
            this.userListView = Nh;
            if (Nh == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userListView");
                Nh = null;
            }
            linearLayout.addView(Nh);
            linearLayout.addView(zh());
            linearLayout.setBackground(linearLayout.getContext().getResources().getDrawable(R.drawable.qui_common_bg_middle_standard_bg, null));
            cVar.addView(linearLayout);
            this.animationContentView = cVar;
            cVar.setHorizontalScrollBarEnabled(false);
        }

        private final com.tencent.mobileqq.sharepanel.multiSelect.adapter.h Hh() {
            return (com.tencent.mobileqq.sharepanel.multiSelect.adapter.h) this.selectedListAdapter.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void Ih(SelectedContactFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function0<Unit> function0 = this$0.onDismissListener;
            if (function0 != null) {
                function0.invoke();
            }
            try {
                this$0.Mh();
            } catch (Exception e16) {
                QLog.e("SelectedContactFragment", 1, "dismiss error: ", e16);
            }
        }

        private final void Jh(QUSHalfScreenImmersiveFloatingView floatingView) {
            if (BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels > ViewUtils.dpToPx(500.0f)) {
                this.panelWidth = ViewUtils.dpToPx(500.0f);
                floatingView.setMaxWidthDp(500);
            } else {
                this.panelWidth = ScreenUtil.SCREEN_WIDTH;
                floatingView.setMaxWidthDp(0);
            }
            HorizontalScrollView horizontalScrollView = this.animationContentView;
            ForwardMiniAIODelegate forwardMiniAIODelegate = null;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                horizontalScrollView = null;
            }
            ViewGroup.LayoutParams layoutParams = horizontalScrollView.getLayoutParams();
            layoutParams.width = this.panelWidth;
            horizontalScrollView.setLayoutParams(layoutParams);
            View view = this.userListView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userListView");
                view = null;
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            layoutParams2.width = this.panelWidth;
            view.setLayoutParams(layoutParams2);
            ForwardMiniAIODelegate forwardMiniAIODelegate2 = this.aioPreview;
            if (forwardMiniAIODelegate2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioPreview");
            } else {
                forwardMiniAIODelegate = forwardMiniAIODelegate2;
            }
            ViewGroup.LayoutParams layoutParams3 = forwardMiniAIODelegate.getLayoutParams();
            layoutParams3.width = this.panelWidth;
            forwardMiniAIODelegate.setLayoutParams(layoutParams3);
        }

        private final void Mh() {
            super.dismiss();
        }

        private final View Nh() {
            ViewGroup.LayoutParams marginLayoutParams;
            String title;
            boolean z16;
            TextView textView;
            LinearLayout linearLayout = new LinearLayout(requireContext());
            linearLayout.setGravity(1);
            linearLayout.setOrientation(1);
            if (!this.needAnimation) {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(this.panelWidth, this.aioHeight);
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(this.panelWidth, this.panelHeight);
            }
            linearLayout.setLayoutParams(marginLayoutParams);
            View inflate = LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.hqc, (ViewGroup) linearLayout, false);
            Bundle arguments = getArguments();
            if (arguments != null && (title = arguments.getString("title")) != null) {
                Intrinsics.checkNotNullExpressionValue(title, "title");
                if (title.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (textView = (TextView) inflate.findViewById(R.id.title)) != null) {
                    textView.setText(title);
                }
            }
            View findViewById = inflate.findViewById(R.id.a47);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SelectedContactFragment.Oh(SelectedContactFragment.this, view);
                    }
                });
            }
            b bVar = this.reportListener;
            if (bVar != null) {
                bVar.b();
            }
            linearLayout.addView(inflate);
            RecyclerView recyclerView = new RecyclerView(linearLayout.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = ViewUtils.dpToPx(2.0f);
            layoutParams.bottomMargin = ViewUtils.dpToPx(16.0f);
            recyclerView.setLayoutParams(layoutParams);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            com.tencent.mobileqq.sharepanel.multiSelect.adapter.h Hh = Hh();
            Hh.setData(this.selectedList);
            recyclerView.setAdapter(Hh);
            recyclerView.setBackgroundColor(0);
            linearLayout.addView(recyclerView);
            return linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void Oh(SelectedContactFragment this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            b bVar = this$0.reportListener;
            if (bVar != null) {
                bVar.d();
            }
            this$0.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void initData() {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.panelHeight = arguments.getInt("panel_height");
                this.selectedList.clear();
                ArrayList parcelableArrayList = arguments.getParcelableArrayList("selected_contact_list");
                if (parcelableArrayList != null) {
                    this.selectedList.addAll(parcelableArrayList);
                }
            }
        }

        private final View zh() {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ForwardMiniAIODelegate forwardMiniAIODelegate = new ForwardMiniAIODelegate(requireContext, null, 0, 6, null);
            forwardMiniAIODelegate.setLayoutParams(new ViewGroup.MarginLayoutParams(this.panelWidth, this.aioHeight));
            this.aioPreview = forwardMiniAIODelegate;
            forwardMiniAIODelegate.setOnBackListener(new d());
            ForwardMiniAIODelegate forwardMiniAIODelegate2 = this.aioPreview;
            if (forwardMiniAIODelegate2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioPreview");
                return null;
            }
            return forwardMiniAIODelegate2;
        }

        @SuppressLint({"ObjectAnimatorBinding"})
        public final void Ah(boolean isToAIO) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, isToAIO);
                return;
            }
            QLog.d("SelectedContactFragment", 2, "animationToAIO is to aio: " + isToAIO);
            HorizontalScrollView horizontalScrollView = null;
            if (isToAIO) {
                HorizontalScrollView horizontalScrollView2 = this.animationContentView;
                if (horizontalScrollView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                    horizontalScrollView2 = null;
                }
                int[] iArr = new int[2];
                HorizontalScrollView horizontalScrollView3 = this.animationContentView;
                if (horizontalScrollView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                    horizontalScrollView3 = null;
                }
                iArr[0] = horizontalScrollView3.getScrollX();
                iArr[1] = this.panelWidth;
                ObjectAnimator ofInt = ObjectAnimator.ofInt(horizontalScrollView2, "scrollX", iArr);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.c
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SelectedContactFragment.Bh(SelectedContactFragment.this, valueAnimator);
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                if (this.needAnimation) {
                    HorizontalScrollView horizontalScrollView4 = this.animationContentView;
                    if (horizontalScrollView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                        horizontalScrollView4 = null;
                    }
                    float[] fArr = new float[2];
                    HorizontalScrollView horizontalScrollView5 = this.animationContentView;
                    if (horizontalScrollView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                    } else {
                        horizontalScrollView = horizontalScrollView5;
                    }
                    fArr[0] = horizontalScrollView.getHeight();
                    fArr[1] = this.aioHeight;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(horizontalScrollView4, "height", fArr);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.d
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SelectedContactFragment.Ch(SelectedContactFragment.this, valueAnimator);
                        }
                    });
                    animatorSet.playTogether(ofInt, ofFloat);
                } else {
                    animatorSet.playTogether(ofInt);
                }
                animatorSet.setDuration(200L);
                animatorSet.addListener(new e());
                animatorSet.start();
                return;
            }
            HorizontalScrollView horizontalScrollView6 = this.animationContentView;
            if (horizontalScrollView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                horizontalScrollView6 = null;
            }
            int[] iArr2 = new int[2];
            HorizontalScrollView horizontalScrollView7 = this.animationContentView;
            if (horizontalScrollView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                horizontalScrollView7 = null;
            }
            iArr2[0] = horizontalScrollView7.getScrollX();
            iArr2[1] = 0;
            ObjectAnimator ofInt2 = ObjectAnimator.ofInt(horizontalScrollView6, "scrollX", iArr2);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SelectedContactFragment.Dh(SelectedContactFragment.this, valueAnimator);
                }
            });
            AnimatorSet animatorSet2 = new AnimatorSet();
            if (this.needAnimation) {
                HorizontalScrollView horizontalScrollView8 = this.animationContentView;
                if (horizontalScrollView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                    horizontalScrollView8 = null;
                }
                float[] fArr2 = new float[2];
                HorizontalScrollView horizontalScrollView9 = this.animationContentView;
                if (horizontalScrollView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animationContentView");
                } else {
                    horizontalScrollView = horizontalScrollView9;
                }
                fArr2[0] = horizontalScrollView.getHeight();
                fArr2[1] = this.panelHeight;
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(horizontalScrollView8, "height", fArr2);
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.f
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SelectedContactFragment.Eh(SelectedContactFragment.this, valueAnimator);
                    }
                });
                animatorSet2.playTogether(ofInt2, ofFloat2);
            } else {
                animatorSet2.playTogether(ofInt2);
            }
            animatorSet2.setDuration(200L);
            animatorSet2.addListener(new f());
            animatorSet2.start();
        }

        @Nullable
        public final b Gh() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.reportListener;
        }

        public final void Kh(@Nullable Function0<Unit> function0) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) function0);
            } else {
                this.onDismissListener = function0;
            }
        }

        public final void Lh(@Nullable b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
            } else {
                this.reportListener = bVar;
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.fragment.a
        public boolean Nd(boolean isForceCancel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, isForceCancel)).booleanValue();
            }
            dismiss();
            return true;
        }

        @Override // androidx.fragment.app.DialogFragment
        public void dismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
                return;
            }
            QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.floatingView;
            if (qUSHalfScreenImmersiveFloatingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingView");
                qUSHalfScreenImmersiveFloatingView = null;
            }
            qUSHalfScreenImmersiveFloatingView.t();
        }

        @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(@NotNull Configuration newConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) newConfig);
                return;
            }
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(newConfig);
            QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.floatingView;
            if (qUSHalfScreenImmersiveFloatingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingView");
                qUSHalfScreenImmersiveFloatingView = null;
            }
            Jh(qUSHalfScreenImmersiveFloatingView);
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(@Nullable Bundle savedInstanceState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) savedInstanceState);
                return;
            }
            super.onCreate(savedInstanceState);
            if (this.onDismissListener == null) {
                QLog.e("SelectedContactFragment", 1, "onDismissListener is null.");
                Mh();
            }
            initData();
        }

        @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
        @NotNull
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Dialog) iPatchRedirector.redirect((short) 10, (Object) this, (Object) savedInstanceState);
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            com.tencent.mobileqq.sharepanel.fragment.b bVar = new com.tencent.mobileqq.sharepanel.fragment.b(requireContext, R.style.a9g);
            bVar.P(this);
            Window window = bVar.getWindow();
            if (window != null) {
                com.tencent.mobileqq.sharepanel.util.b.f287600a.d(window);
                window.setNavigationBarColor(ContextCompat.getColor(requireContext(), R.color.qui_common_bg_middle_standard));
            }
            bVar.setCanceledOnTouchOutside(true);
            com.tencent.mobileqq.sharepanel.util.b.f287600a.b(bVar);
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v5, types: [android.view.View] */
        @Override // androidx.fragment.app.Fragment
        @NotNull
        public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                qUSHalfScreenImmersiveFloatingView = (View) iPatchRedirector.redirect((short) 8, this, inflater, container, savedInstanceState);
            } else {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                b bVar = this.reportListener;
                if (bVar != null) {
                    bVar.c();
                }
                Fh();
                QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = new QUSHalfScreenImmersiveFloatingView(requireContext());
                qUSHalfScreenImmersiveFloatingView2.J();
                qUSHalfScreenImmersiveFloatingView2.setCornerRadius(ViewUtils.dpToPx(20.0f));
                qUSHalfScreenImmersiveFloatingView2.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
                qUSHalfScreenImmersiveFloatingView2.setQUSDragFloatController(new g());
                qUSHalfScreenImmersiveFloatingView2.x().setBackgroundColor(0);
                qUSHalfScreenImmersiveFloatingView2.setIsHeightWrapContent(true);
                Jh(qUSHalfScreenImmersiveFloatingView2);
                qUSHalfScreenImmersiveFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.dialog.a
                    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                    public final void onDismiss() {
                        SelectedContactFragment.Ih(SelectedContactFragment.this);
                    }
                });
                this.floatingView = qUSHalfScreenImmersiveFloatingView2;
                qUSHalfScreenImmersiveFloatingView2.setDraggable(false);
                QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView3 = this.floatingView;
                QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView4 = null;
                if (qUSHalfScreenImmersiveFloatingView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("floatingView");
                    qUSHalfScreenImmersiveFloatingView3 = null;
                }
                qUSHalfScreenImmersiveFloatingView3.r();
                QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView5 = this.floatingView;
                if (qUSHalfScreenImmersiveFloatingView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("floatingView");
                } else {
                    qUSHalfScreenImmersiveFloatingView4 = qUSHalfScreenImmersiveFloatingView5;
                }
                qUSHalfScreenImmersiveFloatingView4.J();
                qUSHalfScreenImmersiveFloatingView = qUSHalfScreenImmersiveFloatingView2;
            }
            AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, qUSHalfScreenImmersiveFloatingView);
            return qUSHalfScreenImmersiveFloatingView;
        }

        @Override // androidx.fragment.app.Fragment
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this);
                return;
            }
            super.onDestroy();
            ForwardMiniAIODelegate forwardMiniAIODelegate = this.aioPreview;
            if (forwardMiniAIODelegate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioPreview");
                forwardMiniAIODelegate = null;
            }
            forwardMiniAIODelegate.c();
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public void onDismiss(@NotNull DialogInterface dialog) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) dialog);
                return;
            }
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.floatingView;
            if (qUSHalfScreenImmersiveFloatingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingView");
                qUSHalfScreenImmersiveFloatingView = null;
            }
            qUSHalfScreenImmersiveFloatingView.t();
        }
    }
