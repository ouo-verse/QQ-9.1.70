package com.tencent.mobileqq.fragment.BottomTabSetting;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment;
import com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingVM;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.logic.TabDataHandler;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J.\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019H\u0002J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\"\u0010.\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0004R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/fragment/BottomTabSetting/NewBottomTabSettingFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "", "initUI", "Yh", "", "ei", "li", "ki", "", "Xh", "selectedName", "ni", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Wh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/widget/listitem/a;", "ai", "Sh", "fi", "Lcom/tencent/mobileqq/fragment/BottomTabSetting/NewBottomTabSettingVM$SettingItemType;", "type", "isChecked", "Oh", "Lkotlin/Function1;", "callback", "Ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "needImmersive", "tabKey", "isFromClick", "oi", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "mPreviewLinearLayout", "Lcom/tencent/mobileqq/fragment/BottomTabSetting/NewBottomTabSettingVM;", "K", "Lkotlin/Lazy;", "Zh", "()Lcom/tencent/mobileqq/fragment/BottomTabSetting/NewBottomTabSettingVM;", "viewModel", "<init>", "()V", "L", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NewBottomTabSettingFragment extends BaseSettingFragment {

    /* renamed from: L, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout mPreviewLinearLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/fragment/BottomTabSetting/NewBottomTabSettingFragment$a;", "", "", "isChecked", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
            if (z17 && j3 == 0) {
                QLog.w("NewBottomTabSettingVM", 1, "toggleQCircleTab sendRequest success: [isChecked: " + z16 + "]");
                if (z16) {
                    return;
                }
                com.tencent.mobileqq.activity.qcircle.utils.c.f().clearPedPoint();
                QLog.w("NewBottomTabSettingVM", 1, "toggleQCircleTab sendRequest success clearPedPoint");
                return;
            }
            QLog.w("NewBottomTabSettingVM", 1, "toggleQCircleTab sendRequest fail: [retcode= " + j3 + "]");
        }

        public final void b(final boolean isChecked) {
            String str;
            String str2;
            if (StudyModeManager.t()) {
                str = QzoneConfig.SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_MAIN_TAB_CHILDREN_MODE;
            } else {
                str = QzoneConfig.SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_MAIN_TAB;
            }
            String str3 = "1";
            if (isChecked) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            QCircleSetCircleSwitchRequest qCircleSetCircleSwitchRequest = new QCircleSetCircleSwitchRequest("qqcircle", str, str2);
            QzoneConfig qzoneConfig = QzoneConfig.getInstance();
            if (!isChecked) {
                str3 = "0";
            }
            qzoneConfig.updateOneConfig("qqcircle", str, str3);
            QLog.w("NewBottomTabSettingVM", 1, "toggleQCircleTab: [isChecked: " + isChecked + "]");
            VSNetworkHelper.getInstance().sendRequest(qCircleSetCircleSwitchRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.m
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str4, Object obj) {
                    NewBottomTabSettingFragment.Companion.c(isChecked, baseRequest, z16, j3, str4, obj);
                }
            });
        }

        Companion() {
        }
    }

    public NewBottomTabSettingFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NewBottomTabSettingVM>() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NewBottomTabSettingVM invoke() {
                NewBottomTabSettingVM newBottomTabSettingVM = (NewBottomTabSettingVM) NewBottomTabSettingFragment.this.getViewModel(NewBottomTabSettingVM.class);
                newBottomTabSettingVM.r2(NewBottomTabSettingFragment.this.getContext());
                return newBottomTabSettingVM;
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(final NewBottomTabSettingVM.SettingItemType type, boolean isChecked) {
        Ph(type, isChecked, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment$cellRightSwitchClick$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes33.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f211111a;

                static {
                    int[] iArr = new int[NewBottomTabSettingVM.SettingItemType.values().length];
                    try {
                        iArr[NewBottomTabSettingVM.SettingItemType.Guild.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[NewBottomTabSettingVM.SettingItemType.Circle.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[NewBottomTabSettingVM.SettingItemType.MetaDream.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f211111a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                int i3 = a.f211111a[NewBottomTabSettingVM.SettingItemType.this.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        return;
                    }
                    NewBottomTabSettingFragment.INSTANCE.b(z16);
                } else {
                    QCircleFrameEvent qCircleFrameEvent = new QCircleFrameEvent();
                    qCircleFrameEvent.mAddTab = true;
                    SimpleEventBus.getInstance().dispatchEvent(qCircleFrameEvent);
                }
            }
        });
    }

    private final void Ph(final NewBottomTabSettingVM.SettingItemType type, final boolean isChecked, Function1<? super Boolean, Unit> callback) {
        final QQAppInterface L1 = Zh().L1();
        if (L1 == null) {
            return;
        }
        if (isChecked && Zh().k2()) {
            Zh().p2(type, false);
            QQToast.makeText(L1.getApplicationContext(), R.string.f132262y, 0).show();
            return;
        }
        final String tabKey = type.getTabKey();
        if (isChecked && Zh().M1(tabKey)) {
            Zh().p2(type, false);
            QQToast.makeText(L1.getApplicationContext(), 0, R.string.f132252x, 0).show();
            return;
        }
        Zh().o2(type, false);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.b
            @Override // java.lang.Runnable
            public final void run() {
                NewBottomTabSettingFragment.Qh(tabKey, isChecked, L1);
            }
        }, 160, null, true);
        oi(tabKey, isChecked, true);
        if (callback != null) {
            callback.invoke(Boolean.valueOf(isChecked));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(tabKey, Integer.valueOf(isChecked ? 2 : 3));
        TabDataHelper.updateTabLocalSwitch(BaseApplication.getContext(), L1.getCurrentAccountUin(), hashMap);
        HashMap<String, Integer> e26 = Zh().e2();
        if (e26 != null) {
            e26.put(tabKey, Integer.valueOf(isChecked ? 2 : 3));
        }
        com.tencent.mobileqq.fragment.bottomtab.b mPreviewHelper = Zh().getMPreviewHelper();
        if (mPreviewHelper != null) {
            mPreviewHelper.f();
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.c
            @Override // java.lang.Runnable
            public final void run() {
                NewBottomTabSettingFragment.Rh(NewBottomTabSettingFragment.this, type);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(String tabKey, boolean z16, QQAppInterface app) {
        Intrinsics.checkNotNullParameter(tabKey, "$tabKey");
        Intrinsics.checkNotNullParameter(app, "$app");
        HashMap hashMap = new HashMap();
        hashMap.put(tabKey, Boolean.valueOf(z16));
        BusinessHandler businessHandler = app.getBusinessHandler(TabDataHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.logic.TabDataHandler");
        ((TabDataHandler) businessHandler).M2(hashMap, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(NewBottomTabSettingFragment this$0, NewBottomTabSettingVM.SettingItemType type) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        this$0.Zh().o2(type, true);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Sh() {
        final NewBottomTabSettingVM.SettingItemType settingItemType = NewBottomTabSettingVM.SettingItemType.Circle;
        if (!Zh().Q1(settingItemType)) {
            return null;
        }
        boolean P1 = Zh().P1(settingItemType);
        oi(settingItemType.getTabKey(), P1, false);
        final x xVar = new x(new x.b.d(Zh().O1(settingItemType)), new x.c.f(P1, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NewBottomTabSettingFragment.Vh(NewBottomTabSettingFragment.this, settingItemType, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> S1 = Zh().S1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment$circleConfig$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                if (Intrinsics.areEqual(Boolean.valueOf(xVar.O().getIsChecked()), it)) {
                    return;
                }
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
                this.Oh(settingItemType, xVar.O().getIsChecked());
            }
        };
        S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewBottomTabSettingFragment.Th(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> R1 = Zh().R1();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment$circleConfig$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.g(it.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
            }
        };
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewBottomTabSettingFragment.Uh(Function1.this, obj);
            }
        });
        Boolean j26 = Zh().j2(settingItemType.getTabKey());
        if (TabDataHelper.isAutoEnable() && j26 != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = Bundle.EMPTY;
            }
            int i3 = arguments.getInt("KEY_ENABLE_TAB_ID", -1);
            if (!j26.booleanValue() && i3 == TabDataHelper.getTabId(settingItemType.getTabKey()) && !Zh().k2() && !((x.c.f) xVar.O()).getIsChecked()) {
                ((x.c.f) xVar.O()).f(true);
                Oh(settingItemType, ((x.c.f) xVar.O()).getIsChecked());
            }
        }
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(NewBottomTabSettingFragment this$0, NewBottomTabSettingVM.SettingItemType type, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        this$0.Oh(type, z16);
    }

    private final String Xh() {
        Intent intent;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            String str = null;
            if ((activity != null ? activity.getIntent() : null) != null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (intent = activity2.getIntent()) != null) {
                    str = intent.getStringExtra("KEY_ENTRANCE");
                }
                QLog.d("NewBottomTabSettingVM", 1, "getEntranceReportValue: [entrance: " + str + "]");
                if (Intrinsics.areEqual("VALUE_QQ_SETTING", str)) {
                    return "1";
                }
                if (Intrinsics.areEqual("VALUE_QQ_ASSISTANT_SETTING", str)) {
                    return "2";
                }
                return "";
            }
            return "";
        }
        return "";
    }

    private final void Yh() {
        QQAppInterface L1 = Zh().L1();
        if (L1 == null) {
            return;
        }
        Zh().q2(TabDataHelper.getTabRuleList(L1.getApplicationContext(), L1.getCurrentUin(), TabDataHelper.getModelType()));
        Zh().y2(TabDataHelper.getTabSwitch(L1.getApplicationContext(), L1.getCurrentUin(), TabDataHelper.SCENE_BOTTOM_TAB_SETTING));
        if (QLog.isColorLevel()) {
            QLog.d("NewBottomTabSettingVM", 2, "getLocalTabCache: [allTabListCacheString: " + Zh().getAllTabListCacheString() + ", tabSwitchMap: " + Zh().f2() + "]");
        }
    }

    private final NewBottomTabSettingVM Zh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (NewBottomTabSettingVM) value;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ai() {
        final NewBottomTabSettingVM.SettingItemType settingItemType = NewBottomTabSettingVM.SettingItemType.Guild;
        if (!Zh().Q1(settingItemType)) {
            return null;
        }
        boolean P1 = Zh().P1(settingItemType);
        oi(settingItemType.getTabKey(), P1, false);
        final x xVar = new x(new x.b.d(Zh().O1(settingItemType)), new x.c.f(P1, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NewBottomTabSettingFragment.bi(NewBottomTabSettingFragment.this, settingItemType, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> W1 = Zh().W1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment$guildConfig$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewBottomTabSettingFragment.ci(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> U1 = Zh().U1();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment$guildConfig$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.g(it.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
            }
        };
        U1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewBottomTabSettingFragment.di(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(NewBottomTabSettingFragment this$0, NewBottomTabSettingVM.SettingItemType type, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        this$0.Oh(type, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean ei() {
        boolean li5;
        if (Zh().f2() == null || TextUtils.isEmpty(Zh().getAllTabListCacheString())) {
            QQToast.makeText(getQBaseActivity(), 1, R.string.f132242w, 2000).show();
            li5 = li();
        } else {
            li5 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewBottomTabSettingVM", 2, "isGetTabSwitchCache 1: [tabSwitchMapIsNull:  " + (Zh().f2() == null));
            if (Zh().f2() != null) {
                Map<String, Integer> f26 = Zh().f2();
                Boolean valueOf = f26 != null ? Boolean.valueOf(f26.isEmpty()) : null;
                QLog.d("NewBottomTabSettingVM", 2, "isGetTabSwitchCache 2: [tabSwitchMapIsEmpty: " + valueOf + ", allTabListCacheStringIsEmpty: " + TextUtils.isEmpty(Zh().getAllTabListCacheString()));
            }
        }
        return li5;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> fi() {
        Boolean j26;
        final NewBottomTabSettingVM.SettingItemType settingItemType = NewBottomTabSettingVM.SettingItemType.MetaDream;
        if (!Zh().Q1(settingItemType)) {
            ji(this, settingItemType);
            return null;
        }
        boolean P1 = Zh().P1(settingItemType);
        oi(settingItemType.getTabKey(), P1, false);
        final x xVar = new x(new x.b.d(Zh().O1(settingItemType)), new x.c.f(P1, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NewBottomTabSettingFragment.gi(NewBottomTabSettingFragment.this, settingItemType, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> c26 = Zh().c2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment$metaDreamConfig$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                if (Intrinsics.areEqual(Boolean.valueOf(xVar.O().getIsChecked()), it)) {
                    return;
                }
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
                this.Oh(settingItemType, xVar.O().getIsChecked());
            }
        };
        c26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewBottomTabSettingFragment.hi(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> b26 = Zh().b2();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment$metaDreamConfig$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.g(it.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
            }
        };
        b26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewBottomTabSettingFragment.ii(Function1.this, obj);
            }
        });
        if (ji(this, settingItemType) && (j26 = Zh().j2(settingItemType.getTabKey())) != null) {
            if (TabDataHelper.isAutoEnable()) {
                Bundle arguments = getArguments();
                if (arguments == null) {
                    arguments = Bundle.EMPTY;
                }
                int i3 = arguments.getInt("KEY_ENABLE_TAB_ID", -1);
                if (!j26.booleanValue() && i3 == TabDataHelper.getTabId(settingItemType.getTabKey()) && !Zh().k2() && !((x.c.f) xVar.O()).getIsChecked()) {
                    ((x.c.f) xVar.O()).f(true);
                    Oh(settingItemType, ((x.c.f) xVar.O()).getIsChecked());
                }
            }
            if (j26.booleanValue() && Zh().l2() && ((x.c.f) xVar.O()).getIsChecked()) {
                ((x.c.f) xVar.O()).f(false);
                Oh(settingItemType, ((x.c.f) xVar.O()).getIsChecked());
            }
        }
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(NewBottomTabSettingFragment this$0, NewBottomTabSettingVM.SettingItemType type, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        this$0.Oh(type, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initUI() {
        QQAppInterface L1 = Zh().L1();
        if (L1 == null) {
            return;
        }
        if (Zh().h2()) {
            if (Zh().j2(TabDataHelper.TAB_RIJ) == null) {
                Zh().w2(Zh().getMTabKandian());
                Zh().v2(-100);
            }
            Zh().g2();
            Zh().u2(Zh().T1(new NewBottomTabSettingFragment$initUI$1(this)));
            Zh().s2(Zh().getMSelectedPosition());
            Zh().t2(new com.tencent.mobileqq.fragment.bottomtab.b(this.mPreviewLinearLayout, L1));
        }
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] Wh = Wh();
            th5.t0((Group[]) Arrays.copyOf(Wh, Wh.length));
        }
    }

    private static final boolean ji(NewBottomTabSettingFragment newBottomTabSettingFragment, NewBottomTabSettingVM.SettingItemType settingItemType) {
        HashMap<String, Integer> e26;
        int modelType = TabDataHelper.getModelType();
        boolean z16 = modelType == 3 || modelType == 4;
        if (z16 && (e26 = newBottomTabSettingFragment.Zh().e2()) != null && e26.containsKey(settingItemType.getTabKey())) {
            e26.remove(settingItemType.getTabKey());
        }
        return !z16;
    }

    private final void ki() {
        Yh();
        if (Zh().f2() == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NewBottomTabSettingVM", 2, "openTabTips return, tabSwitchMap == null");
            }
        } else {
            Map<String, Integer> f26 = Zh().f2();
            Integer num = f26 != null ? f26.get(TabDataHelper.TAB_NEW_WORLD) : null;
            if (Zh().f2() == null || num == null) {
                return;
            }
            TextUtils.isEmpty(Zh().getAllTabListCacheString());
        }
    }

    private final boolean li() {
        final QQAppInterface L1 = Zh().L1();
        if (L1 == null) {
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.BottomTabSetting.l
            @Override // java.lang.Runnable
            public final void run() {
                NewBottomTabSettingFragment.mi(QQAppInterface.this);
            }
        }, 160, null, true);
        if (Zh().f2() != null) {
            Map<String, Integer> f26 = Zh().f2();
            Intrinsics.checkNotNull(f26);
            if (!f26.isEmpty() && !TextUtils.isEmpty(Zh().getAllTabListCacheString())) {
                return true;
            }
        }
        QQToast.makeText(getQBaseActivity(), 1, R.string.f132232v, 2000).show();
        if (QLog.isColorLevel()) {
            QLog.d("NewBottomTabSettingVM", 2, "refreshTabListNet 1: [tabSwitchMapIsNull: " + (Zh().f2() == null));
            if (Zh().f2() != null) {
                Map<String, Integer> f27 = Zh().f2();
                Boolean valueOf = f27 != null ? Boolean.valueOf(f27.isEmpty()) : null;
                QLog.d("NewBottomTabSettingVM", 2, "refreshTabListNet 2: [tabSwitchMapIsEmpty: " + valueOf + ", allTabListCacheStringIsEmpty: " + TextUtils.isEmpty(Zh().getAllTabListCacheString()));
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(QQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "$app");
        BusinessHandler businessHandler = app.getBusinessHandler(TabDataHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.logic.TabDataHandler");
        ((TabDataHandler) businessHandler).D2(false);
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    protected final void oi(String tabKey, boolean isChecked, boolean isFromClick) {
        String r16;
        com.tencent.mobileqq.activity.home.impl.c frameInfoByKey = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByKey(tabKey);
        if (isFromClick) {
            r16 = frameInfoByKey.q();
        } else {
            r16 = frameInfoByKey.r();
        }
        String str = r16;
        ReportController.o(null, "dc00898", "", "", str, str, !isChecked ? 1 : 2, 0, Xh(), "", "", "");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        com.tencent.mobileqq.fragment.bottomtab.b mPreviewHelper = Zh().getMPreviewHelper();
        if (mPreviewHelper != null) {
            mPreviewHelper.e(newConfig);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QQAppInterface L1 = Zh().L1();
        boolean z16 = false;
        if (L1 != null && L1.isLogin()) {
            z16 = true;
        }
        if (!z16) {
            Intent intent = new Intent();
            intent.addFlags(262144);
            RouteUtils.startActivity(getQBaseActivity(), intent, RouterConstants.UI_ROUTER_LOGIN);
            getQBaseActivity().finish();
        }
        Yh();
        Zh().x2(Zh().z2());
        if (!ei() || Zh().e2() == null) {
            onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f159490d94);
        SettingOverScrollRecyclerView wh5 = wh();
        if (wh5 != null) {
            ViewGroup.LayoutParams layoutParams = wh5.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, dimensionPixelSize);
                wh5.setLayoutParams(marginLayoutParams);
            }
        }
        View inflate = inflater.inflate(R.layout.f167253de, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026ottom_preview_view, null)");
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 80;
        FrameLayout frameLayout = onCreateView instanceof FrameLayout ? (FrameLayout) onCreateView : null;
        if (frameLayout != null) {
            frameLayout.addView(inflate, layoutParams2);
        }
        this.mPreviewLinearLayout = (LinearLayout) inflate.findViewById(R.id.f17941n);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QQAppInterface L1;
        super.onDestroy();
        ki();
        if (!Zh().n2() || (L1 = Zh().L1()) == null) {
            return;
        }
        ((ILebaHelperService) L1.getRuntimeService(ILebaHelperService.class, "")).reloadLebaItems(L1);
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        CharSequence text = getResources().getText(R.string.f1311801);
        Intrinsics.checkNotNullExpressionValue(text, "getResources().getText(R\u2026bottom_tab_setting_title)");
        setTitle(text);
        initUI();
        ReportController.o(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "page_exp", 0, 0, "1", "", "", "");
        ReportController.o(null, "dc00898", "", "", TabDataHelper.VALUE_SETTING_BOTTOM_TAB, TabDataHelper.VALUE_SETTING_BOTTOM_TAB, 0, 0, Xh(), "", "", "");
    }

    private final Group[] Wh() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(ai(), Sh(), fi());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni(String selectedName) {
        ReportController.o(null, "dc00898", "", "", TabDataHelper.VALUE_SETTING_NONE_REPORT, TabDataHelper.VALUE_SETTING_NONE_REPORT, Intrinsics.areEqual(selectedName, "none") ? 1 : 2, 0, Xh(), "", "", "");
        ReportController.o(null, "dc00898", "", "", TabDataHelper.VALUE_SETTING_NEW_WORLD_REPORT, TabDataHelper.VALUE_SETTING_NEW_WORLD_REPORT, Intrinsics.areEqual(selectedName, TabDataHelper.TAB_NEW_WORLD) ? 1 : 2, 0, Xh(), "", "", "");
        ReportController.o(null, "dc00898", "", "", TabDataHelper.VALUE_SETTING_RIJ_REPORT, TabDataHelper.VALUE_SETTING_RIJ_REPORT, Intrinsics.areEqual(selectedName, TabDataHelper.TAB_RIJ) ? 1 : 2, 0, Xh(), "", "", "");
    }
}
