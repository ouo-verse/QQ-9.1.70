package com.tencent.mobileqq.troop.troopnotification.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.render.TroopNotificationRender;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qzone.QzoneIPCModule;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationDetailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/qqnt/notification/f;", "msg", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "xh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationDetailVM;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "th", "()Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationDetailVM;", "vm", "Lts2/b;", "D", "Lts2/b;", "viewbinding", "E", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navBar", "G", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "viewHolder", "<init>", "()V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationDetailFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: D, reason: from kotlin metadata */
    private ts2.b viewbinding;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: F, reason: from kotlin metadata */
    private QUISecNavBar navBar;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationDetailFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/notification/f;", "msg", "", "a", "", "KEY_CATEGORY", "Ljava/lang/String;", "KEY_SEQ", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull Context context, @NotNull com.tencent.qqnt.notification.f msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intent intent = new Intent(context, (Class<?>) TroopNotificationDetailFragment.class);
            intent.putExtra("KEY_SEQ", msg2.j().seq);
            intent.putExtra("KEY_CATEGORY", msg2.c());
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, TroopNotificationDetailFragment.class);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58653);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopNotificationDetailFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopNotificationDetailVM>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationDetailFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationDetailFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopNotificationDetailVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopNotificationDetailVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TroopNotificationDetailVM.Companion companion = TroopNotificationDetailVM.INSTANCE;
                    FragmentActivity requireActivity = TroopNotificationDetailFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    return companion.a(requireActivity);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final TroopNotificationDetailVM th() {
        return (TroopNotificationDetailVM) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(TroopNotificationDetailFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a xh(com.tencent.qqnt.notification.f msg2) {
        com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a aVar = this.viewHolder;
        if (aVar != null) {
            TroopNotificationRender.f300720a.x(aVar, msg2);
        } else {
            com.tencent.mobileqq.troop.troopnotification.render.a aVar2 = com.tencent.mobileqq.troop.troopnotification.render.a.f300732a;
            int b16 = aVar2.b(msg2);
            ViewGroup viewGroup = this.rootView;
            ViewGroup viewGroup2 = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                viewGroup = null;
            }
            aVar = aVar2.a(b16, viewGroup);
            ViewGroup viewGroup3 = this.rootView;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                viewGroup3 = null;
            }
            viewGroup3.addView(aVar.o(), -1, -1);
            this.viewHolder = aVar;
            TroopNotificationRender.f300720a.x(aVar, msg2);
            com.tencent.mobileqq.troop.troopnotification.report.a aVar3 = com.tencent.mobileqq.troop.troopnotification.report.a.f300918a;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewGroup viewGroup4 = this.rootView;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            } else {
                viewGroup2 = viewGroup4;
            }
            aVar3.e(requireActivity, viewGroup2, msg2);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            th().j2(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        th().c2(this, arguments);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            view = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            ts2.b g16 = ts2.b.g(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
            this.viewbinding = g16;
            if (g16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewbinding");
                g16 = null;
            }
            LinearLayout linearLayout = g16.f437335c;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "viewbinding.root");
            this.rootView = linearLayout;
            ts2.b bVar = this.viewbinding;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewbinding");
                bVar = null;
            }
            QUISecNavBar qUISecNavBar = bVar.f437334b;
            Intrinsics.checkNotNullExpressionValue(qUISecNavBar, "viewbinding.rlTitleBar");
            qUISecNavBar.setLeftType(2);
            qUISecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_navigation_02_selector);
            qUISecNavBar.setRightType(1);
            qUISecNavBar.setCenterType(1);
            qUISecNavBar.setCenterText(qUISecNavBar.getResources().getString(R.string.f1788537s));
            qUISecNavBar.S(this);
            qUISecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TroopNotificationDetailFragment.uh(TroopNotificationDetailFragment.this, view2);
                }
            });
            this.navBar = qUISecNavBar;
            MutableLiveData<com.tencent.qqnt.notification.f> W1 = th().W1();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<com.tencent.qqnt.notification.f, Unit> function1 = new Function1<com.tencent.qqnt.notification.f, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationDetailFragment$onCreateView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationDetailFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.notification.f fVar) {
                    invoke2(fVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable com.tencent.qqnt.notification.f fVar) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) fVar);
                    } else if (fVar != null) {
                        TroopNotificationDetailFragment.this.xh(fVar);
                    }
                }
            };
            W1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopNotificationDetailFragment.vh(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> Z1 = th().Z1();
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationDetailFragment$onCreateView$3
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationDetailFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    FragmentActivity activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (!it.booleanValue() || (activity = TroopNotificationDetailFragment.this.getActivity()) == null) {
                        return;
                    }
                    activity.finish();
                }
            };
            Z1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopNotificationDetailFragment.wh(Function1.this, obj);
                }
            });
            view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            th().destroy();
        }
    }
}
