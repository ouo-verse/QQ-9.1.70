package com.tencent.mobileqq.register.avatar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.avatar.j;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 =2\u00020\u0001:\u0001>B%\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010:\u001a\u00020\u0018\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0015J\u0014\u0010\u0014\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010\u0015\u001a\u00020\u0007J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0006\u0010\u0017\u001a\u00020\u0007R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00101\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/h;", "Landroid/app/Dialog;", "", HippyTKDListViewAdapter.X, "y", "", "f0", "", "initWindow", "Landroid/content/Context;", "context", "Z", "X", "a0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "list", "g0", BdhLogUtil.LogTag.Tag_Req, "show", "onConfigurationChanged", "Lcom/tencent/mobileqq/register/avatar/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/register/avatar/b;", "W", "()Lcom/tencent/mobileqq/register/avatar/b;", "setMSelectorListener", "(Lcom/tencent/mobileqq/register/avatar/b;)V", "mSelectorListener", "D", "Ljava/util/List;", "mZplanAvatarList", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "E", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mQusHalfScreenFloatingView", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", ExifInterface.LATITUDE_SOUTH, "()Landroidx/recyclerview/widget/RecyclerView;", "d0", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mAvatarListView", "Landroid/view/View;", "G", "Landroid/view/View;", "U", "()Landroid/view/View;", "e0", "(Landroid/view/View;)V", "mContainer", "H", "emptyView", "avatarInfoList", "selectorListener", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mobileqq/register/avatar/b;)V", "I", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h extends ReportDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.register.avatar.b mSelectorListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<ZPlanAvatarInfo> mZplanAvatarList;

    /* renamed from: E, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView mQusHalfScreenFloatingView;

    /* renamed from: F, reason: from kotlin metadata */
    public RecyclerView mAvatarListView;

    /* renamed from: G, reason: from kotlin metadata */
    public View mContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View emptyView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.avatar.h$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/register/avatar/h$b", "Lcom/tencent/mobileqq/register/avatar/j$b;", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "avatarInfo", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements j.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.mobileqq.register.avatar.j.b
        public void a(@NotNull ZPlanAvatarInfo avatarInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarInfo);
            } else {
                Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
                h.this.W().c(avatarInfo);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/register/avatar/h$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", NodeProps.MAX_HEIGHT, "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
            }
            if (!h.this.f0((int) x16, (int) y16)) {
                return false;
            }
            RecyclerView.LayoutManager layoutManager = h.this.S().getLayoutManager();
            if (layoutManager != null) {
                view = layoutManager.getChildAt(0);
            } else {
                view = null;
            }
            if (view == null || view.getTop() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
            }
            if (!h.this.f0((int) x16, (int) y16)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57179d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return h.this.U();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return (int) FontSettingManager.revertSize2Normal(h.this.getContext(), ViewUtils.dpToPx(600.0f));
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Context context, @NotNull List<ZPlanAvatarInfo> avatarInfoList, @NotNull com.tencent.mobileqq.register.avatar.b selectorListener) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarInfoList, "avatarInfoList");
        Intrinsics.checkNotNullParameter(selectorListener, "selectorListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, avatarInfoList, selectorListener);
        } else {
            this.mSelectorListener = selectorListener;
            this.mZplanAvatarList = avatarInfoList;
        }
    }

    private final void X() {
        U().findViewById(R.id.f24850_9).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.register.avatar.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.Y(h.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mSelectorListener.b();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Z(Context context) {
        View findViewById = U().findViewById(R.id.f72553r6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContainer.findViewById<\u2026gister_zplan_avatar_list)");
        d0((RecyclerView) findViewById);
        LinearLayout linearLayout = (LinearLayout) U().findViewById(R.id.f72563r7);
        if (this.mZplanAvatarList.isEmpty()) {
            S().setVisibility(8);
            QUIEmptyState.Builder halfScreenState = new QUIEmptyState.Builder(context).setImageType(5).setBackgroundColorType(0).setHalfScreenState(true);
            String string = context.getString(R.string.f170612li);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.net_error_for_avatar)");
            this.emptyView = halfScreenState.setTitle(string).build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            View view = this.emptyView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.biz.qui.quiemptystate.QUIEmptyState");
            ((QUIEmptyState) view).setLayoutParams(layoutParams);
            linearLayout.addView(this.emptyView);
            return;
        }
        S().setLayoutManager(new GridLayoutManager(context, 3));
        S().setAdapter(new j(this.mZplanAvatarList, new b()));
        FontSettingManager.resetViewSize2Normal(context, linearLayout);
    }

    private final void a0() {
        U().findViewById(R.id.f24860__).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.register.avatar.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.b0(h.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mSelectorListener.a();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f0(int x16, int y16) {
        int[] iArr = new int[2];
        S().getLocationOnScreen(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], S().getMeasuredWidth() + i3, iArr[1] + S().getMeasuredHeight()).contains(x16, y16);
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        try {
            window.requestFeature(1);
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("RegisterAvatarSettingDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    public final void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQusHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.t();
    }

    @NotNull
    public final RecyclerView S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        RecyclerView recyclerView = this.mAvatarListView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAvatarListView");
        return null;
    }

    @NotNull
    public final View U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        View view = this.mContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.register.avatar.b W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.register.avatar.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mSelectorListener;
    }

    public final void d0(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.mAvatarListView = recyclerView;
        }
    }

    public final void e0(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mContainer = view;
        }
    }

    public final void g0(@NotNull List<ZPlanAvatarInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            QLog.e("RegisterAvatarSettingDialog", 1, "updateZplanAvatarList error : list is empty");
            return;
        }
        View view = this.emptyView;
        if (view != null) {
            ab.c(view);
        }
        RecyclerView.Adapter adapter = S().getAdapter();
        if (adapter instanceof j) {
            ((j) adapter).k0(list);
        }
    }

    public final void onConfigurationChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQusHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.L();
    }

    @Override // android.app.Dialog
    @SuppressLint({"ResourceAsColor"})
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        initWindow();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        View inflate = getLayoutInflater().inflate(R.layout.e3i, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        setContentView(R.layout.e3i);
        View inflate2 = getLayoutInflater().inflate(R.layout.hmx, (ViewGroup) inflate, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "layoutInflater.inflate(R\u2026ting_layout, root, false)");
        e0(inflate2);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Z(context);
        X();
        a0();
        View findViewById = findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = (QUSHalfScreenFloatingView) findViewById;
        this.mQusHalfScreenFloatingView = qUSHalfScreenFloatingView2;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQusHalfScreenFloatingView");
            qUSHalfScreenFloatingView2 = null;
        }
        qUSHalfScreenFloatingView2.setContentViewBackgroundResource(R.color.qui_common_bg_middle_standard);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQusHalfScreenFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setQUSDragFloatController(new c());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQusHalfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView4;
        }
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.register.avatar.e
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                h.c0(h.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.show();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQusHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.P(0);
        cb.f306645a.i("0X800C327");
    }
}
