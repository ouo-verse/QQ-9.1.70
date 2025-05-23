package com.tencent.mobileqq.troop.homework.clockin.detail.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditFoldView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "position", "", "getItemId", "holder", "", "onBindViewHolder", "", QCircleDaTongConstant.ElementParamValue.PYMK_FOLD, "i0", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "manager", "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditFoldView;", "D", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditFoldView;", "mediaEditFoldView", "<init>", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;Landroidx/lifecycle/LifecycleOwner;)V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: D, reason: from kotlin metadata */
    private HWMediaEditFoldView mediaEditFoldView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f manager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/adapter/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.adapter.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/detail/adapter/b$b", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8705b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        C8705b(HWMediaEditFoldView hWMediaEditFoldView) {
            super(hWMediaEditFoldView);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWMediaEditFoldView);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41600);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull f manager, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) manager, (Object) lifecycleOwner);
        } else {
            this.manager = manager;
            this.lifecycleOwner = lifecycleOwner;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, position)).longValue();
        }
        return position;
    }

    public final void i0(boolean fold) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, fold);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("HW.ClockIn.DETAIL.HWClockInDetailAdapter", 4, "updateFoldState, fold:" + fold);
        }
        HWMediaEditFoldView hWMediaEditFoldView = null;
        if (fold) {
            HWMediaEditFoldView hWMediaEditFoldView2 = this.mediaEditFoldView;
            if (hWMediaEditFoldView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaEditFoldView");
            } else {
                hWMediaEditFoldView = hWMediaEditFoldView2;
            }
            hWMediaEditFoldView.setMediaContentClose();
            return;
        }
        HWMediaEditFoldView hWMediaEditFoldView3 = this.mediaEditFoldView;
        if (hWMediaEditFoldView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaEditFoldView");
        } else {
            hWMediaEditFoldView = hWMediaEditFoldView3;
        }
        hWMediaEditFoldView.setMediaContentExpand();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (QLog.isDebugVersion()) {
            QLog.d("HW.ClockIn.DETAIL.HWClockInDetailAdapter", 4, "onBindViewHolder, position:" + position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (QLog.isDebugVersion()) {
            QLog.d("HW.ClockIn.DETAIL.HWClockInDetailAdapter", 4, "onCreateViewHolder, create HWMediaEditFoldView.");
        }
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        HWMediaEditFoldView hWMediaEditFoldView = null;
        HWMediaEditFoldView hWMediaEditFoldView2 = new HWMediaEditFoldView(context, null, 2, null);
        this.mediaEditFoldView = hWMediaEditFoldView2;
        hWMediaEditFoldView2.setMediaEditManager(this.manager, this.lifecycleOwner);
        HWMediaEditFoldView hWMediaEditFoldView3 = this.mediaEditFoldView;
        if (hWMediaEditFoldView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaEditFoldView");
            hWMediaEditFoldView3 = null;
        }
        hWMediaEditFoldView3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        HWMediaEditFoldView hWMediaEditFoldView4 = this.mediaEditFoldView;
        if (hWMediaEditFoldView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaEditFoldView");
        } else {
            hWMediaEditFoldView = hWMediaEditFoldView4;
        }
        return new C8705b(hWMediaEditFoldView);
    }
}
