package com.tencent.mobileqq.troop.teamup.detail.part;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditView;
import com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import com.tencent.util.LoadingUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/part/TroopTeamUpDetailContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "timeSec", "", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "d", "Lkotlin/Lazy;", "I9", "()Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "detailVM", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditView;", "e", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditView;", "mediaView", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "endTimeContainer", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "endTimeText", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "errorContainer", "Landroid/app/Dialog;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Dialog;", "loadingDialog", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpDetailContentPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy detailVM;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HWMediaEditView mediaView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup endTimeContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView endTimeText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout errorContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    public TroopTeamUpDetailContentPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopTeamUpDetailVM>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailContentPart$detailVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailContentPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopTeamUpDetailVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopTeamUpDetailVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TroopTeamUpDetailVM.Companion companion = TroopTeamUpDetailVM.INSTANCE;
                    Fragment hostFragment = TroopTeamUpDetailContentPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.detailVM = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopTeamUpDetailVM I9() {
        return (TroopTeamUpDetailVM) this.detailVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String J9(long timeSec) {
        String date = new SimpleDateFormat("\u622a\u6b62\u65f6\u95f4\uff1ayyyy\u5e74MM\u6708dd\u65e5 HH:mm", Locale.CHINA).format(new Date(timeSec * 1000));
        Intrinsics.checkNotNullExpressionValue(date, "date");
        return date;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f93675a8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026eam_up_detail_media_view)");
        this.mediaView = (HWMediaEditView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f93655a6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026p_detail_error_container)");
        this.errorContainer = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f93635a4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026.team_up_detail_end_time)");
        this.endTimeText = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f93645a5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026etail_end_time_container)");
        this.endTimeContainer = (ViewGroup) findViewById4;
        HWMediaEditView hWMediaEditView = this.mediaView;
        if (hWMediaEditView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaView");
            hWMediaEditView = null;
        }
        com.tencent.mobileqq.troop.teamup.detail.vm.b e26 = I9().e2();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "partHost.hostLifecycleOwner");
        hWMediaEditView.setMediaEditManager(e26, hostLifecycleOwner);
        if (I9().a2().getValue() == null) {
            Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getContext(), null, false);
            this.loadingDialog = showLoadingDialog;
            if (showLoadingDialog != null) {
                showLoadingDialog.show();
            }
        }
        LiveData<TeamUpTeamDetail> a26 = I9().a2();
        LifecycleOwner hostLifecycleOwner2 = getPartHost().getHostLifecycleOwner();
        final Function1<TeamUpTeamDetail, Unit> function1 = new Function1<TeamUpTeamDetail, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailContentPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailContentPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TeamUpTeamDetail teamUpTeamDetail) {
                invoke2(teamUpTeamDetail);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TeamUpTeamDetail teamUpTeamDetail) {
                Dialog dialog;
                ViewGroup viewGroup;
                TextView textView;
                String J9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) teamUpTeamDetail);
                    return;
                }
                dialog = TroopTeamUpDetailContentPart.this.loadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (teamUpTeamDetail.endTime > 0) {
                    viewGroup = TroopTeamUpDetailContentPart.this.endTimeContainer;
                    TextView textView2 = null;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("endTimeContainer");
                        viewGroup = null;
                    }
                    viewGroup.setVisibility(0);
                    textView = TroopTeamUpDetailContentPart.this.endTimeText;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("endTimeText");
                    } else {
                        textView2 = textView;
                    }
                    J9 = TroopTeamUpDetailContentPart.this.J9(teamUpTeamDetail.endTime);
                    textView2.setText(J9);
                }
            }
        };
        a26.observe(hostLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailContentPart.K9(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.b> c26 = I9().c2();
        LifecycleOwner hostLifecycleOwner3 = getPartHost().getHostLifecycleOwner();
        final TroopTeamUpDetailContentPart$onInitView$2 troopTeamUpDetailContentPart$onInitView$2 = new TroopTeamUpDetailContentPart$onInitView$2(this);
        c26.observe(hostLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailContentPart.L9(Function1.this, obj);
            }
        });
        LiveData<String> b26 = I9().b2();
        LifecycleOwner hostLifecycleOwner4 = getPartHost().getHostLifecycleOwner();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailContentPart$onInitView$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailContentPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQToast.makeText(TroopTeamUpDetailContentPart.this.getContext(), 1, str, 0).show();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                }
            }
        };
        b26.observe(hostLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailContentPart.M9(Function1.this, obj);
            }
        });
    }
}
