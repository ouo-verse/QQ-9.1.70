package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00016B\u001d\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\b3\u00104J\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR*\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditFoldView;", "Landroid/widget/FrameLayout;", "", "percent", "g", "", "text", "", "setMediaExpandButtonText", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "manager", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "setMediaEditManager", "setMediaContentClose", "setMediaContentExpand", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "setRecyclerViewPool", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditView;", "<set-?>", "d", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditView;", "getMediaEditView", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditView;", "mediaEditView", "Landroid/view/View;", "e", "Landroid/view/View;", "mediaBottomView", "f", "mediaBottomMaskView", "Lkotlin/Function0;", h.F, "Lkotlin/jvm/functions/Function0;", "getOnClickExpand", "()Lkotlin/jvm/functions/Function0;", "setOnClickExpand", "(Lkotlin/jvm/functions/Function0;)V", "onClickExpand", "i", "I", "getContentCloseHeight", "()I", "setContentCloseHeight", "(I)V", "contentCloseHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWMediaEditFoldView extends FrameLayout {
    static IPatchRedirector $redirector_;

    @JvmField
    public static final int C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HWMediaEditView mediaEditView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mediaBottomView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mediaBottomMaskView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onClickExpand;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int contentCloseHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditFoldView$a;", "", "", "defaultContentCloseHeight", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditFoldView$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49649);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
            C = ViewUtils.dip2px(248.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWMediaEditFoldView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(HWMediaEditFoldView this$0, View view) {
        Unit unit;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onClickExpand;
        if (function0 != null) {
            function0.invoke();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.setMediaContentExpand();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(HWMediaEditFoldView this$0, View view) {
        Unit unit;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onClickExpand;
        if (function0 != null) {
            function0.invoke();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.setMediaContentExpand();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int g(int i3, int i16) {
        return (i3 & 16777215) | (((int) ((i16 / 100.0f) * 255)) << 24);
    }

    public final void setContentCloseHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.contentCloseHeight = i3;
        }
    }

    public final void setMediaContentClose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mediaEditView.setVisibility(0);
        this.mediaEditView.setNestedScrollingEnabled(false);
        this.mediaBottomView.setVisibility(0);
        this.mediaBottomMaskView.setVisibility(0);
        View view = this.mediaBottomMaskView;
        GradientDrawable gradientDrawable = new GradientDrawable();
        int color = getContext().getResources().getColor(R.color.qui_common_bg_bottom_light);
        gradientDrawable.setColors(new int[]{g(color, 0), color});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        view.setBackground(gradientDrawable);
        getLayoutParams().height = this.contentCloseHeight;
        requestLayout();
    }

    public final void setMediaContentExpand() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mediaEditView.setVisibility(0);
        this.mediaEditView.setNestedScrollingEnabled(true);
        this.mediaBottomView.setVisibility(8);
        this.mediaBottomMaskView.setVisibility(8);
        getLayoutParams().height = -2;
        requestLayout();
    }

    public final void setMediaEditManager(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f manager, @NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) manager, (Object) lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.mediaEditView.setMediaEditManager(manager, lifecycleOwner);
    }

    public final void setMediaExpandButtonText(@NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) text);
        } else {
            Intrinsics.checkNotNullParameter(text, "text");
            ((TextView) getRootView().findViewById(R.id.yzq)).setText(text);
        }
    }

    public final void setOnClickExpand(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function0);
        } else {
            this.onClickExpand = function0;
        }
    }

    public final void setRecyclerViewPool(@NotNull RecyclerView.RecycledViewPool recycledViewPool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) recycledViewPool);
        } else {
            Intrinsics.checkNotNullParameter(recycledViewPool, "recycledViewPool");
            this.mediaEditView.setRecycledViewPool(recycledViewPool);
        }
    }

    public /* synthetic */ HWMediaEditFoldView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWMediaEditFoldView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.contentCloseHeight = C;
        LayoutInflater.from(context).inflate(R.layout.g0f, this);
        setVisibility(0);
        View findViewById = findViewById(R.id.yzx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.media_edit_view)");
        HWMediaEditView hWMediaEditView = (HWMediaEditView) findViewById;
        this.mediaEditView = hWMediaEditView;
        hWMediaEditView.setVisibility(4);
        View findViewById2 = getRootView().findViewById(R.id.yzr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.media_bottom_view)");
        this.mediaBottomView = findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.yzp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.media_bottom_mask)");
        this.mediaBottomMaskView = findViewById3;
        this.mediaBottomView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWMediaEditFoldView.d(view);
            }
        });
        getRootView().findViewById(R.id.yzq).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWMediaEditFoldView.e(HWMediaEditFoldView.this, view);
            }
        });
        getRootView().findViewById(R.id.yzo).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWMediaEditFoldView.f(HWMediaEditFoldView.this, view);
            }
        });
    }
}
