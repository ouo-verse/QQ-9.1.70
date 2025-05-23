package com.tencent.guild.aio.halfpop;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.halfpop.menu.n;
import com.tencent.guild.aio.halfpop.menu.s;
import com.tencent.guild.aio.util.ex.g;
import com.tencent.guild.aio.util.flowbus.FlowEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn0.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001jB\t\b\u0016\u00a2\u0006\u0004\bh\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0016\u0010\u001d\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016R.\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00109\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u00103R*\u0010B\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b:\u0010;\u0012\u0004\b@\u0010A\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010Q\u001a\u00020K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010_\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010f\u00a8\u0006k"}, d2 = {"Lcom/tencent/guild/aio/halfpop/BaseBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/tencent/guild/aio/halfpop/b;", "", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onResume", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/Context;", "context", "rh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onCreate", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "o8", "Lkotlin/Function0;", "listener", "Xg", "getHostContext", "", "Lcom/tencent/guild/aio/halfpop/menu/n;", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "yh", "(Ljava/util/List;)V", "items", "", "D", UserInfo.SEX_FEMALE, "getDimAmount", "()F", "uh", "(F)V", "dimAmount", "", "E", "I", "getBackgroundRes", "()I", "th", "(I)V", "backgroundRes", "topDragViewBgRes", "G", "Ljava/lang/Integer;", "getThemeId", "()Ljava/lang/Integer;", OcrConfig.CHINESE, "(Ljava/lang/Integer;)V", "getThemeId$annotations", "()V", "themeId", "Lcom/tencent/guild/aio/halfpop/menu/s;", "H", "Lcom/tencent/guild/aio/halfpop/menu/s;", "getItemUiAttr", "()Lcom/tencent/guild/aio/halfpop/menu/s;", "xh", "(Lcom/tencent/guild/aio/halfpop/menu/s;)V", "itemUiAttr", "", "Z", "getHideDragIcon", "()Z", "vh", "(Z)V", "hideDragIcon", "J", "Lkotlin/jvm/functions/Function0;", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "dismissCallback", "K", "Landroid/view/View;", "getItemLongClick", "()Landroid/view/View;", "wh", "(Landroid/view/View;)V", "itemLongClick", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "L", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "eventReceiver", "Lvn0/f;", "M", "Lvn0/f;", "binding", "<init>", "N", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class BaseBottomSheetDialog extends BottomSheetDialogFragment implements b {

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Integer themeId;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private s itemUiAttr;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean hideDragIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> dismissCallback;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View itemLongClick;

    /* renamed from: M, reason: from kotlin metadata */
    private f binding;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<? extends n<Object>> items = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private float dimAmount = 0.5f;

    /* renamed from: E, reason: from kotlin metadata */
    private int backgroundRes = R.drawable.guild_aio_pop_menu_shape;

    /* renamed from: F, reason: from kotlin metadata */
    private int topDragViewBgRes = R.drawable.qui_halfscreen_default_header_drag_icon;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final FlowEventReceiver eventReceiver = new FlowEventReceiver(null, 1, null);

    private final void qh() {
        f fVar = this.binding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        Object parent = fVar.getRoot().getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getBackground() != null && view.getId() == R.id.ugk) {
                view.setBackground(null);
                return;
            }
            parent = view.getParent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(DialogInterface dialogInterface) {
        QLog.i("BaseBottomSheetDialog", 4, "onDismiss");
    }

    @Override // com.tencent.guild.aio.halfpop.b
    public void Xg(@NotNull Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dismissCallback = listener;
        dismissAllowingStateLoss();
    }

    @Override // com.tencent.guild.aio.halfpop.b
    @NotNull
    public Context getHostContext() {
        f fVar = this.binding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        Context context = fVar.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        return context;
    }

    @Override // com.tencent.guild.aio.halfpop.b
    public void o8() {
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.i("BaseBottomSheetDialog", 4, "onCreate");
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            long currentTimeMillis = System.currentTimeMillis();
            nVar.c(this);
            QLog.i("BaseBottomSheetDialog", 4, "menuItem==onCreate==" + nVar.getClass().getSimpleName() + " costMill=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setDimAmount(this.dimAmount);
            window.setBackgroundDrawableResource(R.drawable.lvj);
        }
        onCreateDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.guild.aio.halfpop.a
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BaseBottomSheetDialog.sh(dialogInterface);
            }
        });
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        f fVar = null;
        f g16 = f.g(inflater, null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, false)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        g16.getRoot().setBackgroundResource(this.backgroundRes);
        if (this.themeId != null) {
            ie0.a f16 = ie0.a.f();
            Context context = getContext();
            int i3 = this.topDragViewBgRes;
            Integer num = this.themeId;
            Intrinsics.checkNotNull(num);
            Drawable o16 = f16.o(context, i3, R.color.qui_common_icon_tertiary, num.intValue());
            f fVar2 = this.binding;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar2 = null;
            }
            fVar2.f441951c.setBackground(o16);
        } else {
            f fVar3 = this.binding;
            if (fVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar3 = null;
            }
            fVar3.f441951c.setBackgroundResource(this.topDragViewBgRes);
        }
        f fVar4 = this.binding;
        if (fVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar4 = null;
        }
        ImageView imageView = fVar4.f441951c;
        Boolean valueOf = Boolean.valueOf(this.hideDragIcon);
        imageView.setVisibility(8);
        if (((View) g.a(valueOf, imageView)) == null) {
            imageView.setVisibility(0);
        }
        this.eventReceiver.c(yn0.a.class, true, new BaseBottomSheetDialog$onCreateView$1(this, null));
        f fVar5 = this.binding;
        if (fVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fVar = fVar5;
        }
        RoundAngleLinearLayout root = fVar.getRoot();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eventReceiver.d();
        QLog.i("BaseBottomSheetDialog", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        View view = this.itemLongClick;
        if (view != null) {
            view.setSelected(false);
        }
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            long currentTimeMillis = System.currentTimeMillis();
            nVar.onDestroy();
            QLog.i("BaseBottomSheetDialog", 4, "menuItem==onDestroy==" + nVar.getClass().getSimpleName() + " costMill=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.dismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        qh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LayoutInflater from = LayoutInflater.from(getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        f fVar = this.binding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        RoundAngleLinearLayout roundAngleLinearLayout = fVar.f441950b;
        Intrinsics.checkNotNullExpressionValue(roundAngleLinearLayout, "binding.contentLayout");
        rh(from, requireContext, roundAngleLinearLayout);
    }

    protected void rh(@NotNull LayoutInflater inflater, @NotNull Context context, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        QLog.i("BaseBottomSheetDialog", 4, "initItem itemSize=" + this.items.size());
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            final n nVar = (n) it.next();
            final View f16 = nVar.f(inflater, context, container);
            nVar.d(this.itemUiAttr);
            final long j3 = 200;
            f16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.halfpop.BaseBottomSheetDialog$initItem$lambda$3$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it5) {
                    EventCollector.getInstance().onViewClickedBefore(it5);
                    f16.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    n nVar2 = nVar;
                    nVar2.b(it5, nVar2.g());
                    final View view = f16;
                    view.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.halfpop.BaseBottomSheetDialog$initItem$lambda$3$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it5);
                }
            });
            f fVar = this.binding;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar = null;
            }
            fVar.f441950b.addView(f16);
        }
    }

    public final void th(int i3) {
        this.backgroundRes = i3;
    }

    public final void uh(float f16) {
        this.dimAmount = f16;
    }

    public final void vh(boolean z16) {
        this.hideDragIcon = z16;
    }

    public final void wh(@Nullable View view) {
        this.itemLongClick = view;
    }

    public final void xh(@Nullable s sVar) {
        this.itemUiAttr = sVar;
    }

    public final void yh(@NotNull List<? extends n<Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public final void zh(@Nullable Integer num) {
        this.themeId = num;
    }
}
