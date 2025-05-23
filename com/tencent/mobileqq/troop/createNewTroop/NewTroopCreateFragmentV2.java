package com.tencent.mobileqq.troop.createNewTroop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateFragmentV2$createEventReceiver$2;
import com.tencent.mobileqq.troop.troopcreate.event.TroopCreateDoneEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u00013\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u001dH\u0016R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/troop/createNewTroop/NewTroopCreateFragmentV2;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/f;", "", "initData", "initView", "initTitleBar", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onCreate", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "qOnBackPressed", "qOnNewIntent", "onBackEvent", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D", "Ljava/lang/String;", "titleString", "E", "I", "exitAnimationVal", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "contentContainer", "Lcom/tencent/mobileqq/troop/createNewTroop/NewTroopContactView;", "G", "Lcom/tencent/mobileqq/troop/createNewTroop/NewTroopContactView;", "troopContactsView", "com/tencent/mobileqq/troop/createNewTroop/NewTroopCreateFragmentV2$createEventReceiver$2$a", "H", "Lkotlin/Lazy;", "ph", "()Lcom/tencent/mobileqq/troop/createNewTroop/NewTroopCreateFragmentV2$createEventReceiver$2$a;", "createEventReceiver", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class NewTroopCreateFragmentV2 extends QPublicBaseFragment implements com.tencent.mobileqq.pad.f {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String titleString;

    /* renamed from: E, reason: from kotlin metadata */
    private int exitAnimationVal;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout contentContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private NewTroopContactView troopContactsView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy createEventReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/createNewTroop/NewTroopCreateFragmentV2$a;", "", "", "PARAM_TITLE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateFragmentV2$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28406);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NewTroopCreateFragmentV2() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.titleString = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NewTroopCreateFragmentV2$createEventReceiver$2.a>() { // from class: com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateFragmentV2$createEventReceiver$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/createNewTroop/NewTroopCreateFragmentV2$createEventReceiver$2$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopcreate/event/TroopCreateDoneEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes19.dex */
            public static final class a implements SimpleEventReceiver<TroopCreateDoneEvent> {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ NewTroopCreateFragmentV2 f294735d;

                a(NewTroopCreateFragmentV2 newTroopCreateFragmentV2) {
                    this.f294735d = newTroopCreateFragmentV2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) newTroopCreateFragmentV2);
                    }
                }

                @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                @NotNull
                public ArrayList<Class<TroopCreateDoneEvent>> getEventClass() {
                    ArrayList<Class<TroopCreateDoneEvent>> arrayListOf;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopCreateDoneEvent.class);
                        return arrayListOf;
                    }
                    return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
                }

                @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                        return;
                    }
                    if (event instanceof TroopCreateDoneEvent) {
                    }
                    FragmentActivity activity = this.f294735d.getActivity();
                    if (activity != null) {
                        Intent intent = new Intent(activity.getIntent());
                        intent.setFlags(603979776);
                        activity.startActivity(intent);
                        activity.finish();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewTroopCreateFragmentV2.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(NewTroopCreateFragmentV2.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.createEventReceiver = lazy;
    }

    private final void initData() {
        boolean z16;
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        String string = arguments.getString(ISelectMemberActivityConstants.PARAM_TITLE);
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            string = getString(R.string.conversation_options_multichat);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            getString(\u2026ions_multichat)\n        }");
        }
        this.titleString = string;
        this.exitAnimationVal = arguments.getInt(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 0);
    }

    private final void initTitleBar() {
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_bar)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        BaseAction baseAction = BaseAction.ACTION_LEFT_BUTTON;
        String qqStr = HardCodeUtil.qqStr(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobileqq.qqui.R.string.cancel)");
        qUISecNavBar.setBaseViewDescription(baseAction, qqStr);
        qUISecNavBar.S(this);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateFragmentV2$initTitleBar$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTroopCreateFragmentV2.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, BaseAction baseAction2) {
                invoke2(view2, baseAction2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2, @Nullable BaseAction baseAction2) {
                FragmentActivity activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2, (Object) baseAction2);
                } else {
                    if (baseAction2 != BaseAction.ACTION_LEFT_TEXT || (activity = NewTroopCreateFragmentV2.this.getActivity()) == null) {
                        return;
                    }
                    activity.onBackPressed();
                }
            }
        });
    }

    private final void initView() {
        QBaseActivity qBaseActivity;
        initTitleBar();
        View view = this.rootView;
        NewTroopContactView newTroopContactView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.k1r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026roop_type_view_container)");
        this.contentContainer = (FrameLayout) findViewById;
        FragmentActivity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            QLog.e("NewTroopCreateFragmentV2", 1, "host activity is not a QBaseActivity.");
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.onBackPressed();
                return;
            }
            return;
        }
        NewTroopContactView newTroopContactView2 = new NewTroopContactView(qBaseActivity, new com.tencent.mobileqq.troop.troopcreate.ui.a(true));
        newTroopContactView2.b(qBaseActivity);
        this.troopContactsView = newTroopContactView2;
        FrameLayout frameLayout = this.contentContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            frameLayout = null;
        }
        NewTroopContactView newTroopContactView3 = this.troopContactsView;
        if (newTroopContactView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopContactsView");
        } else {
            newTroopContactView = newTroopContactView3;
        }
        frameLayout.addView(newTroopContactView);
    }

    private final NewTroopCreateFragmentV2$createEventReceiver$2.a ph() {
        return (NewTroopCreateFragmentV2$createEventReceiver$2.a) this.createEventReceiver.getValue();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        NewTroopContactView newTroopContactView = this.troopContactsView;
        if (newTroopContactView != null) {
            if (newTroopContactView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopContactsView");
                newTroopContactView = null;
            }
            newTroopContactView.E(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        NewTroopContactView newTroopContactView = this.troopContactsView;
        if (newTroopContactView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopContactsView");
            newTroopContactView = null;
        }
        return newTroopContactView.a();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(ph());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.fop, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
            this.rootView = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                inflate = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        NewTroopContactView newTroopContactView = this.troopContactsView;
        if (newTroopContactView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopContactsView");
            newTroopContactView = null;
        }
        newTroopContactView.F();
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopCreateInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        ((ITroopCreateInfoService) runtimeService).clearTroopCreateInfo();
        SimpleEventBus.getInstance().unRegisterReceiver(ph());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onPause();
        NewTroopContactView newTroopContactView = this.troopContactsView;
        if (newTroopContactView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopContactsView");
            newTroopContactView = null;
        }
        newTroopContactView.c();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        NewTroopContactView newTroopContactView = this.troopContactsView;
        if (newTroopContactView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopContactsView");
            newTroopContactView = null;
        }
        newTroopContactView.d();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onStart();
        NewTroopContactView newTroopContactView = this.troopContactsView;
        if (newTroopContactView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopContactsView");
            newTroopContactView = null;
        }
        newTroopContactView.e();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onStop();
        NewTroopContactView newTroopContactView = this.troopContactsView;
        if (newTroopContactView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopContactsView");
            newTroopContactView = null;
        }
        newTroopContactView.f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
        VideoReport.addToDetectionWhitelist(getActivity());
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        VideoReport.setPageId(view2, "pg_group_create_chat");
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }
}
