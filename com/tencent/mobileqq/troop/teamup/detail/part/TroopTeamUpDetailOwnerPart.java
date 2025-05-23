package com.tencent.mobileqq.troop.teamup.detail.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM;
import com.tencent.mobileqq.troop.teamup.member.fragment.TroopTeamUpMemberListFragment;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import com.tencent.qqnt.troop.TroopInfoRepo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/part/TroopTeamUpDetailOwnerPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "isSelectCreate", "", "J9", "", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "d", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "detailVM", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "actionBtn", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "appliedText", tl.h.F, "hintText", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "appliedChevron", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpDetailOwnerPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy detailVM;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Button actionBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView appliedText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView hintText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView appliedChevron;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/part/TroopTeamUpDetailOwnerPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailOwnerPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55480);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpDetailOwnerPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopTeamUpDetailVM>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailOwnerPart$detailVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailOwnerPart.this);
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
                    Fragment hostFragment = TroopTeamUpDetailOwnerPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.detailVM = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final TroopTeamUpDetailVM E9() {
        return (TroopTeamUpDetailVM) this.detailVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(TroopTeamUpDetailOwnerPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TeamUpTeamDetail value = this$0.E9().a2().getValue();
        boolean z16 = false;
        if (value != null && value.hasCreatedGroup) {
            z16 = true;
        }
        if (z16) {
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(String.valueOf(value.newGroupId));
            if (troopInfoFromCache != null) {
                QRouteApi api = QRoute.api(IAIOStarterApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IAIOStarterApi::class.java)");
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String str = troopInfoFromCache.troopuin;
                Intrinsics.checkNotNullExpressionValue(str, "it.troopuin");
                String troopDisplayName = troopInfoFromCache.getTroopDisplayName();
                Intrinsics.checkNotNullExpressionValue(troopDisplayName, "it.troopDisplayName");
                IAIOStarterApi.a.b((IAIOStarterApi) api, context, 2, str, troopDisplayName, 0L, null, 48, null);
            }
        } else {
            this$0.J9(true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(TroopTeamUpDetailOwnerPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void J9(boolean isSelectCreate) {
        TeamUpTeamDetail value = E9().a2().getValue();
        if (value != null) {
            TroopTeamUpMemberListFragment.Companion companion = TroopTeamUpMemberListFragment.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.a(context, value, isSelectCreate);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f93685a9;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Button button;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (QLog.isColorLevel()) {
            QLog.d("TroopTeamUpDetailOwnerPart", 2, "onInitView: ");
        }
        View findViewById = rootView.findViewById(R.id.f93585_z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026eam_up_detail_action_btn)");
        this.actionBtn = (Button) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f93595a0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.team_up_detail_applied)");
        this.appliedText = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f93665a7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026team_up_detail_hint_text)");
        this.hintText = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f93605a1);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026p_detail_applied_chevron)");
        this.appliedChevron = (ImageView) findViewById4;
        Button button2 = this.actionBtn;
        TextView textView = null;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
            button2 = null;
        }
        button2.setVisibility(0);
        TextView textView2 = this.hintText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintText");
            textView2 = null;
        }
        textView2.setVisibility(8);
        ImageView imageView = this.appliedChevron;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appliedChevron");
            imageView = null;
        }
        imageView.setVisibility(0);
        TextView textView3 = this.appliedText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appliedText");
            textView3 = null;
        }
        textView3.setTextColor(getContext().getColor(R.color.qui_common_text_link));
        LiveData<TeamUpTeamDetail> a26 = E9().a2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<TeamUpTeamDetail, Unit> function1 = new Function1<TeamUpTeamDetail, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailOwnerPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailOwnerPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TeamUpTeamDetail teamUpTeamDetail) {
                invoke2(teamUpTeamDetail);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TeamUpTeamDetail teamUpTeamDetail) {
                TextView textView4;
                Button button3;
                Button button4;
                Button button5;
                Button button6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) teamUpTeamDetail);
                    return;
                }
                textView4 = TroopTeamUpDetailOwnerPart.this.appliedText;
                Button button7 = null;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appliedText");
                    textView4 = null;
                }
                boolean z16 = false;
                textView4.setText(TroopTeamUpDetailOwnerPart.this.getContext().getString(R.string.f235757ci, Integer.valueOf(teamUpTeamDetail.joinedCnt), Integer.valueOf(teamUpTeamDetail.joinLimit)));
                if (teamUpTeamDetail.hasCreatedGroup) {
                    button5 = TroopTeamUpDetailOwnerPart.this.actionBtn;
                    if (button5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                        button5 = null;
                    }
                    button5.setText(TroopTeamUpDetailOwnerPart.this.getContext().getString(R.string.f236017d8));
                    button6 = TroopTeamUpDetailOwnerPart.this.actionBtn;
                    if (button6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                    } else {
                        button7 = button6;
                    }
                    button7.setEnabled(true);
                    return;
                }
                button3 = TroopTeamUpDetailOwnerPart.this.actionBtn;
                if (button3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                    button3 = null;
                }
                button3.setText(TroopTeamUpDetailOwnerPart.this.getContext().getString(R.string.f235837cq));
                button4 = TroopTeamUpDetailOwnerPart.this.actionBtn;
                if (button4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                } else {
                    button7 = button4;
                }
                if (teamUpTeamDetail.joinedCnt > 0 && teamUpTeamDetail.newGroupId == 0) {
                    z16 = true;
                }
                button7.setEnabled(z16);
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailOwnerPart.F9(Function1.this, obj);
            }
        });
        Button button3 = this.actionBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
            button = null;
        } else {
            button = button3;
        }
        TriggerRunnerKt.c(button, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpDetailOwnerPart.G9(TroopTeamUpDetailOwnerPart.this, view);
            }
        }, 1, null);
        TextView textView4 = this.appliedText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appliedText");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpDetailOwnerPart.H9(TroopTeamUpDetailOwnerPart.this, view);
            }
        });
        com.tencent.mobileqq.troop.teamup.detail.common.a aVar = com.tencent.mobileqq.troop.teamup.detail.common.a.f298875a;
        Button button4 = this.actionBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
            button4 = null;
        }
        aVar.a(button4, "one_click");
        TextView textView5 = this.appliedText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appliedText");
        } else {
            textView = textView5;
        }
        aVar.b(textView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        LiveData<Integer> g26 = E9().g2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailOwnerPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailOwnerPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                } else if (num != null && num.intValue() == 2) {
                    TroopTeamUpDetailOwnerPart.this.startInit();
                }
            }
        };
        g26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailOwnerPart.I9(Function1.this, obj);
            }
        });
    }
}
