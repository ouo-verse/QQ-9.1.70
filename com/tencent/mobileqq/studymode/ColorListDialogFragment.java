package com.tencent.mobileqq.studymode;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.studymode.ColorListDialogFragment;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u00044567B\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R:\u0010\u001e\u001a(\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0014\u0012\u000e\b\u0001\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR:\u0010 \u001a(\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0014\u0012\u000e\b\u0001\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR:\u0010\"\u001a(\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0014\u0012\u000e\b\u0001\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010+R\u0016\u0010.\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u0017R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/studymode/ColorListDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "vh", "Lkotlin/Function0;", "onDismissListener", "wh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "onStart", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "", BdhLogUtil.LogTag.Tag_Conn, "I", "pickedColorIndex", "", "", "kotlin.jvm.PlatformType", "D", "[Ljava/lang/String;", "colorIds", "E", "colorNames", UserInfo.SEX_FEMALE, "colorCodes", "G", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/studymode/e;", "Lcom/tencent/mobileqq/studymode/e;", "viewModel", "J", "itemWidth", "K", "Lkotlin/jvm/functions/Function0;", "<init>", "(I)V", "L", "a", "b", "c", "d", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ColorListDialogFragment extends BottomSheetDialogFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int pickedColorIndex;

    /* renamed from: D, reason: from kotlin metadata */
    private final String[] colorIds;

    /* renamed from: E, reason: from kotlin metadata */
    private final String[] colorNames;

    /* renamed from: F, reason: from kotlin metadata */
    private final String[] colorCodes;

    /* renamed from: G, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: I, reason: from kotlin metadata */
    private e viewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private int itemWidth;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onDismissListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/studymode/ColorListDialogFragment$a;", "Lcom/google/android/material/bottomsheet/a;", "Landroid/content/DialogInterface$OnDismissListener;", "listener", "", "setOnDismissListener", "Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a extends com.google.android.material.bottomsheet.a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/studymode/ColorListDialogFragment$a$a;", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface;", "dialog", "", "onCancel", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "ref", "onCancelListener", "<init>", "(Landroid/content/DialogInterface$OnCancelListener;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.studymode.ColorListDialogFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        private static final class DialogInterfaceOnCancelListenerC8629a implements DialogInterface.OnCancelListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final WeakReference<DialogInterface.OnCancelListener> ref;

            public DialogInterfaceOnCancelListenerC8629a(@Nullable DialogInterface.OnCancelListener onCancelListener) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) onCancelListener);
                } else {
                    this.ref = new WeakReference<>(onCancelListener);
                }
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(@NotNull DialogInterface dialog) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialog);
                    return;
                }
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                DialogInterface.OnCancelListener onCancelListener = this.ref.get();
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialog);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/studymode/ColorListDialogFragment$a$b;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface;", "dialog", "", "onDismiss", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "ref", "onDismissListener", "<init>", "(Landroid/content/DialogInterface$OnDismissListener;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        private static final class b implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final WeakReference<DialogInterface.OnDismissListener> ref;

            public b(@Nullable DialogInterface.OnDismissListener onDismissListener) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) onDismissListener);
                } else {
                    this.ref = new WeakReference<>(onDismissListener);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(@NotNull DialogInterface dialog) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialog);
                    return;
                }
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                DialogInterface.OnDismissListener onDismissListener = this.ref.get();
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(dialog);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public a(@NotNull Context context, int i3) {
            super(context, i3);
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            }
        }

        @Override // android.app.Dialog
        public void setOnCancelListener(@Nullable DialogInterface.OnCancelListener listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            } else {
                super.setOnCancelListener(new DialogInterfaceOnCancelListenerC8629a(listener));
            }
        }

        @Override // android.app.Dialog
        public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            } else {
                super.setOnDismissListener(new b(listener));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/studymode/ColorListDialogFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/studymode/ColorListDialogFragment$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "<init>", "(Lcom/tencent/mobileqq/studymode/ColorListDialogFragment;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class b extends RecyclerView.Adapter<c> {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ColorListDialogFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l0(ColorListDialogFragment this$0, c holder, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            e eVar = this$0.viewModel;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                eVar = null;
            }
            eVar.M1(holder.getLayoutPosition());
            this$0.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return ColorListDialogFragment.this.colorIds.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull c holder, int position) {
            Resources resources;
            Context context;
            Resources resources2;
            Resources resources3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(Color.parseColor(ColorListDialogFragment.this.colorCodes[position]));
            Context context2 = ColorListDialogFragment.this.getContext();
            if (context2 != null) {
                resources = context2.getResources();
            } else {
                resources = null;
            }
            gradientDrawable.setCornerRadius(BaseAIOUtils.f(4.0f, resources));
            if ((position == 0 || position == 1) && (context = ColorListDialogFragment.this.getContext()) != null && (resources2 = context.getResources()) != null) {
                int color = resources2.getColor(R.color.qui_common_border_standard);
                Context context3 = ColorListDialogFragment.this.getContext();
                if (context3 != null) {
                    resources3 = context3.getResources();
                } else {
                    resources3 = null;
                }
                gradientDrawable.setStroke(BaseAIOUtils.f(1.0f, resources3), color);
            }
            com.tencent.mobileqq.mvvm.g.a(holder.o(), gradientDrawable);
            holder.m().setText(ColorListDialogFragment.this.colorNames[position]);
            if (ColorListDialogFragment.this.pickedColorIndex == position) {
                FrameLayout l3 = holder.l();
                Drawable mutate = l3.getResources().getDrawable(R.drawable.nhm).mutate();
                DrawableCompat.setTint(mutate, l3.getResources().getColor(R.color.qui_common_brand_standard));
                l3.setBackground(mutate);
                return;
            }
            com.tencent.mobileqq.mvvm.g.a(holder.l(), null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            final c cVar = new c(parent);
            if (ColorListDialogFragment.this.itemWidth > 0) {
                cVar.itemView.getLayoutParams().width = ColorListDialogFragment.this.itemWidth;
            }
            View view = cVar.itemView;
            final ColorListDialogFragment colorListDialogFragment = ColorListDialogFragment.this;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.studymode.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ColorListDialogFragment.b.l0(ColorListDialogFragment.this, cVar, view2);
                }
            });
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/studymode/ColorListDialogFragment$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "l", "()Landroid/widget/FrameLayout;", "flPickedStroke", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "o", "()Landroid/view/View;", "viewColor", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "tvColor", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final FrameLayout flPickedStroke;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final View viewColor;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView tvColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.h3s, parent, false));
            Intrinsics.checkNotNullParameter(parent, "parent");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) parent);
                return;
            }
            View findViewById = this.itemView.findViewById(R.id.v8g);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.fl_picked_stroke)");
            this.flPickedStroke = (FrameLayout) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.f1186274n);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.view_color)");
            this.viewColor = findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.f1068969y);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_color)");
            this.tvColor = (TextView) findViewById3;
        }

        @NotNull
        public final FrameLayout l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.flPickedStroke;
        }

        @NotNull
        public final TextView m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.tvColor;
        }

        @NotNull
        public final View o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.viewColor;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/studymode/ColorListDialogFragment$d;", "", "", "COLUMNS", "I", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.studymode.ColorListDialogFragment$d, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61789);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ColorListDialogFragment() {
        this(0, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    private final void vh() {
        View view = this.rootView;
        RecyclerView recyclerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.f7883485);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rv_color_list)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById;
        this.recyclerView = recyclerView2;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 5));
        int i3 = requireContext().getResources().getDisplayMetrics().widthPixels;
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        int paddingLeft = i3 - recyclerView3.getPaddingLeft();
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        this.itemWidth = (paddingLeft - recyclerView4.getPaddingRight()) / 5;
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView5;
        }
        recyclerView.setAdapter(new b());
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Dialog) iPatchRedirector.redirect((short) 5, (Object) this, (Object) savedInstanceState);
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new a(requireContext, getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            view = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.h3t, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026r_list, container, false)");
            this.rootView = inflate;
            ViewModel viewModel = new ViewModelProvider(requireActivity()).get(e.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026istViewModel::class.java)");
            this.viewModel = (e) viewModel;
            vh();
            view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onStart();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
    }

    public final void wh(@NotNull Function0<Unit> onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onDismissListener);
        } else {
            Intrinsics.checkNotNullParameter(onDismissListener, "onDismissListener");
            this.onDismissListener = onDismissListener;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ColorListDialogFragment(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(r0);
        int i17;
        if ((i16 & 1) != 0) {
            i17 = r.e(MobileQQ.sMobileQQ.peekAppRuntime(), g.a() == 1);
        } else {
            i17 = i3;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    public ColorListDialogFragment(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.pickedColorIndex = i3;
        this.colorIds = ThemeConstants.SIMPLE_THEME_ID_LIST;
        this.colorNames = ThemeConstants.THEME_ID_IMAGE_LIST_MAME;
        this.colorCodes = ThemeConstants.THEME_ID_COLOR_CODE_LIST;
    }
}
