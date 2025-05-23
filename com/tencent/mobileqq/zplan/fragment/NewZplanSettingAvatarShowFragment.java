package com.tencent.mobileqq.zplan.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.zplan.aio.a;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.fragment.NewZplanSettingAvatarShowVM;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.setting.SwitchSetting;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/zplan/fragment/NewZplanSettingAvatarShowFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "ri", "Li", "fi", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "bi", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/zplan/fragment/NewZplanSettingAvatarShowVM$SettingItemType;", "type", "", "isChecked", "ai", ViewStickEventHelper.IS_SHOW, "Mi", "Ni", "", "scene", "Oi", "qi", "", "resID", "iconType", "Ji", "zi", "Di", "Gi", "ti", "wi", "Lcom/tencent/mobileqq/widget/listitem/a;", "hi", "ki", "ni", "Xh", "ci", "Lcom/tencent/mobileqq/zplan/fragment/NewZplanSettingAvatarShowVM;", "J", "Lkotlin/Lazy;", "gi", "()Lcom/tencent/mobileqq/zplan/fragment/NewZplanSettingAvatarShowVM;", "viewModel", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "K", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "spListener", "<init>", "()V", "L", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NewZplanSettingAvatarShowFragment extends BaseSettingFragment {
    private static final a L = new a(null);

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private SharedPreferences.OnSharedPreferenceChangeListener spListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/fragment/NewZplanSettingAvatarShowFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333454a;

        static {
            int[] iArr = new int[NewZplanSettingAvatarShowVM.SettingItemType.values().length];
            try {
                iArr[NewZplanSettingAvatarShowVM.SettingItemType.MasterSwitch.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NewZplanSettingAvatarShowVM.SettingItemType.ProfileCardSwitch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NewZplanSettingAvatarShowVM.SettingItemType.QzoneSwitch.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NewZplanSettingAvatarShowVM.SettingItemType.AioAvatarSwitch.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NewZplanSettingAvatarShowVM.SettingItemType.DrawerSwitch.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f333454a = iArr;
        }
    }

    public NewZplanSettingAvatarShowFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NewZplanSettingAvatarShowVM>() { // from class: com.tencent.mobileqq.zplan.fragment.NewZplanSettingAvatarShowFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NewZplanSettingAvatarShowVM invoke() {
                return (NewZplanSettingAvatarShowVM) NewZplanSettingAvatarShowFragment.this.getViewModel(NewZplanSettingAvatarShowVM.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ai(final boolean z16, final NewZplanSettingAvatarShowFragment this$0, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("NewZplanSettingAvatarShowFragment", 1, "setMasterSwitch setSettingSwitches: [isSuccess: " + z17 + ", isChecked: " + z16 + "]");
        if (!z17) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.n
                @Override // java.lang.Runnable
                public final void run() {
                    NewZplanSettingAvatarShowFragment.Bi(NewZplanSettingAvatarShowFragment.this, z16);
                }
            });
            return;
        }
        com.tencent.mobileqq.zplan.setting.c.n(z16);
        if (!z16) {
            com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.PROFILE_CARD_SETTING, z16);
            com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DYNAMIC_SETTING, z16);
            com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.AIO_AVATAR_SETTING, z16);
            com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DRAWER_SETTING, z16);
            ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
            zplanDataRepository.p(1006L, z16);
            zplanDataRepository.p(1004L, z16);
            com.tencent.mobileqq.zplan.utils.y.h(z16);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.o
            @Override // java.lang.Runnable
            public final void run() {
                NewZplanSettingAvatarShowFragment.Ci(NewZplanSettingAvatarShowFragment.this, z16);
            }
        });
        this$0.Ni(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(NewZplanSettingAvatarShowFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ji(R.string.xtm, 1);
        this$0.gi().i2(NewZplanSettingAvatarShowVM.SettingItemType.MasterSwitch, !z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(NewZplanSettingAvatarShowFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Mi(z16);
        this$0.qi();
    }

    private final void Di(final boolean isChecked) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.PROFILE_CARD_SETTING, isChecked, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.d
            @Override // nk3.a
            public final void onResult(boolean z16) {
                NewZplanSettingAvatarShowFragment.Ei(isChecked, this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(final boolean z16, final NewZplanSettingAvatarShowFragment this$0, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("NewZplanSettingAvatarShowFragment", 1, "setProfileCardSwitch setSettingSwitch: [isSuccess: " + z17 + ", isChecked: " + z16 + "]");
        if (!z17) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.i
                @Override // java.lang.Runnable
                public final void run() {
                    NewZplanSettingAvatarShowFragment.Fi(NewZplanSettingAvatarShowFragment.this, z16);
                }
            });
            return;
        }
        com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.PROFILE_CARD_SETTING, z16);
        this$0.Oi(z16, 1004L);
        ZplanDataRepository.f334898a.p(1004L, !z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(NewZplanSettingAvatarShowFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ji(R.string.xtm, 1);
        this$0.gi().i2(NewZplanSettingAvatarShowVM.SettingItemType.ProfileCardSwitch, !z16);
    }

    private final void Gi(final boolean isChecked) {
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.DYNAMIC_SETTING, isChecked, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.c
            @Override // nk3.a
            public final void onResult(boolean z16) {
                NewZplanSettingAvatarShowFragment.Hi(isChecked, this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hi(final boolean z16, final NewZplanSettingAvatarShowFragment this$0, boolean z17) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("NewZplanSettingAvatarShowFragment", 1, "setQzoneSwitch setSettingSwitch: [isSuccess: " + z17 + ", isChecked: " + z16 + "]");
        if (!z17) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.k
                @Override // java.lang.Runnable
                public final void run() {
                    NewZplanSettingAvatarShowFragment.Ii(NewZplanSettingAvatarShowFragment.this, z16);
                }
            });
            return;
        }
        com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DYNAMIC_SETTING, z16);
        this$0.Oi(z16, Constant.FROM_ID_UNINSTALL_PLUGIN);
        String mPageCode = this$0.gi().getMPageCode();
        if (z16) {
            str = "open";
        } else {
            str = "close";
        }
        t74.r.c(mPageCode, "feeds", str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(NewZplanSettingAvatarShowFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ji(R.string.xtm, 1);
        this$0.gi().i2(NewZplanSettingAvatarShowVM.SettingItemType.QzoneSwitch, !z16);
    }

    private final void Ji(final int resID, final int iconType) {
        if (getActivity() == null) {
            QLog.d("NewZplanSettingAvatarShowFragment", 1, "showToast return, activity == null");
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.f
                @Override // java.lang.Runnable
                public final void run() {
                    NewZplanSettingAvatarShowFragment.Ki(NewZplanSettingAvatarShowFragment.this, iconType, resID);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(NewZplanSettingAvatarShowFragment this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getActivity(), i3, i16, 0).show();
    }

    private final void Li() {
        QQAppInterface M1 = gi().M1();
        if (M1 == null) {
            return;
        }
        SharedPreferences sharedPreferences = M1.getApplication().getSharedPreferences("zplan_setting_sp_config_" + M1.getCurrentAccountUin(), 4);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "app.application.getShare\u2026ivity.MODE_MULTI_PROCESS)");
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.spListener;
        if (onSharedPreferenceChangeListener != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
        this.spListener = null;
    }

    private final void Mi(boolean isShow) {
        Group otherSwitchGroup = gi().getOtherSwitchGroup();
        if (otherSwitchGroup != null) {
            QUIListItemAdapter th5 = th();
            if (th5 != null) {
                th5.n0(otherSwitchGroup, isShow);
            }
            gi().g2(isShow);
        }
    }

    private final void Oi(boolean isChecked, long scene) {
        AccessibleDetail zplanAccessibleDetail;
        QQAppInterface M1 = gi().M1();
        if (M1 == null || (zplanAccessibleDetail = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanAccessibleDetail(scene, M1.getLongAccountUin())) == null) {
            return;
        }
        zplanAccessibleDetail.settingPass = isChecked ? 1 : 0;
        ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).updateCache(zplanAccessibleDetail);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Xh() {
        NewZplanSettingAvatarShowVM gi5 = gi();
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.AioAvatarSwitch;
        if (!gi5.Q1(settingItemType)) {
            return null;
        }
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(gi().O1(settingItemType)), new x.c.f(gi().P1(settingItemType), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.zplan.fragment.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NewZplanSettingAvatarShowFragment.Yh(NewZplanSettingAvatarShowFragment.this, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> N1 = gi().N1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.fragment.NewZplanSettingAvatarShowFragment$aioAvatarSwitchConfig$2$1
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
            }
        };
        N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.fragment.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewZplanSettingAvatarShowFragment.Zh(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(NewZplanSettingAvatarShowFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ai(NewZplanSettingAvatarShowVM.SettingItemType.AioAvatarSwitch, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ai(NewZplanSettingAvatarShowVM.SettingItemType type, boolean isChecked) {
        if (getActivity() == null) {
            QLog.d("NewZplanSettingAvatarShowFragment", 1, "cellRightSwitchClick return, activity == null: [type: " + type + ", isChecked: " + isChecked + "]");
            return;
        }
        if (!NetworkUtil.isNetSupport(getActivity())) {
            Ji(R.string.b3j, 1);
            gi().i2(type, !isChecked);
            QLog.d("NewZplanSettingAvatarShowFragment", 1, "checkNetworkAndToast return, no network: [type: " + type + ", isChecked: " + isChecked + "]");
            return;
        }
        QLog.d("NewZplanSettingAvatarShowFragment", 4, "cellRightSwitchClick: [type: " + type + ", isChecked: " + isChecked + "]");
        int i3 = b.f333454a[type.ordinal()];
        if (i3 == 1) {
            zi(isChecked);
            return;
        }
        if (i3 == 2) {
            Di(isChecked);
            return;
        }
        if (i3 == 3) {
            Gi(isChecked);
        } else if (i3 == 4) {
            ti(isChecked);
        } else {
            if (i3 != 5) {
                return;
            }
            wi(isChecked);
        }
    }

    private final Group[] bi() {
        List mutableListOf;
        List filterNotNull;
        List mutableListOf2;
        List filterNotNull2;
        NewZplanSettingAvatarShowVM gi5 = gi();
        com.tencent.mobileqq.widget.listitem.a<?> hi5 = hi();
        gi5.e2(hi5 instanceof com.tencent.mobileqq.widget.listitem.x ? (com.tencent.mobileqq.widget.listitem.x) hi5 : null);
        gi().h2((com.tencent.mobileqq.widget.listitem.x) ni());
        String string = getString(R.string.xuj);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.zplan_setting_scene_desc)");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(ki(), gi().c2(), Xh(), ci());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        Group group = new Group(string, "", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
        gi().f2(group);
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(gi().W1());
        filterNotNull2 = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf2);
        Object[] array2 = filterNotNull2.toArray(new com.tencent.mobileqq.widget.listitem.x[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.x[] xVarArr = (com.tencent.mobileqq.widget.listitem.x[]) array2;
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length)), group};
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ci() {
        NewZplanSettingAvatarShowVM gi5 = gi();
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.DrawerSwitch;
        if (!gi5.Q1(settingItemType)) {
            return null;
        }
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(gi().O1(settingItemType)), new x.c.f(gi().P1(settingItemType), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.zplan.fragment.w
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NewZplanSettingAvatarShowFragment.di(NewZplanSettingAvatarShowFragment.this, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> R1 = gi().R1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.fragment.NewZplanSettingAvatarShowFragment$drawerSwitchConfig$2$1
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
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewZplanSettingAvatarShowFragment.ei(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(NewZplanSettingAvatarShowFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ai(NewZplanSettingAvatarShowVM.SettingItemType.DrawerSwitch, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void fi() {
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent == null) {
            return;
        }
        if (Intrinsics.areEqual(IZPlanApi.FROM_QQ_SETTING, intent.getStringExtra("FROM"))) {
            gi().d2("qqsetting");
        } else {
            gi().d2("setting");
        }
    }

    private final NewZplanSettingAvatarShowVM gi() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (NewZplanSettingAvatarShowVM) value;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> hi() {
        NewZplanSettingAvatarShowVM gi5 = gi();
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.MasterSwitch;
        if (!gi5.Q1(settingItemType)) {
            return null;
        }
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(gi().O1(settingItemType)), new x.c.f(gi().P1(settingItemType), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.zplan.fragment.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NewZplanSettingAvatarShowFragment.ii(NewZplanSettingAvatarShowFragment.this, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> U1 = gi().U1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.fragment.NewZplanSettingAvatarShowFragment$masterSwitchConfig$2$1
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
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.fragment.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewZplanSettingAvatarShowFragment.ji(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(NewZplanSettingAvatarShowFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ai(NewZplanSettingAvatarShowVM.SettingItemType.MasterSwitch, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ki() {
        NewZplanSettingAvatarShowVM gi5 = gi();
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.ProfileCardSwitch;
        if (!gi5.Q1(settingItemType)) {
            return null;
        }
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(gi().O1(settingItemType)), new x.c.f(gi().P1(settingItemType), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.zplan.fragment.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NewZplanSettingAvatarShowFragment.li(NewZplanSettingAvatarShowFragment.this, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> a26 = gi().a2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.fragment.NewZplanSettingAvatarShowFragment$profileCardSwitchConfig$2$1
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
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.fragment.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewZplanSettingAvatarShowFragment.mi(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(NewZplanSettingAvatarShowFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ai(NewZplanSettingAvatarShowVM.SettingItemType.ProfileCardSwitch, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ni() {
        NewZplanSettingAvatarShowVM gi5 = gi();
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.QzoneSwitch;
        if (!gi5.Q1(settingItemType)) {
            return null;
        }
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(gi().O1(settingItemType)), new x.c.f(gi().P1(settingItemType), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.zplan.fragment.s
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NewZplanSettingAvatarShowFragment.oi(NewZplanSettingAvatarShowFragment.this, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> b26 = gi().b2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.fragment.NewZplanSettingAvatarShowFragment$qzoneSwitchConfig$2$1
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
            }
        };
        b26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.fragment.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewZplanSettingAvatarShowFragment.pi(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(NewZplanSettingAvatarShowFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ai(NewZplanSettingAvatarShowVM.SettingItemType.QzoneSwitch, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void qi() {
        NewZplanSettingAvatarShowVM gi5 = gi();
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.ProfileCardSwitch;
        gi().i2(settingItemType, gi5.P1(settingItemType));
        NewZplanSettingAvatarShowVM gi6 = gi();
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType2 = NewZplanSettingAvatarShowVM.SettingItemType.QzoneSwitch;
        gi().i2(settingItemType2, gi6.P1(settingItemType2));
        NewZplanSettingAvatarShowVM gi7 = gi();
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType3 = NewZplanSettingAvatarShowVM.SettingItemType.AioAvatarSwitch;
        gi().i2(settingItemType3, gi7.P1(settingItemType3));
        NewZplanSettingAvatarShowVM gi8 = gi();
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType4 = NewZplanSettingAvatarShowVM.SettingItemType.DrawerSwitch;
        gi().i2(settingItemType4, gi8.P1(settingItemType4));
    }

    private final void ri() {
        QQAppInterface M1 = gi().M1();
        if (M1 == null) {
            return;
        }
        SharedPreferences sharedPreferences = M1.getApplication().getSharedPreferences("zplan_setting_sp_config_" + M1.getCurrentAccountUin(), 4);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "app.application.getShare\u2026ivity.MODE_MULTI_PROCESS)");
        if (this.spListener != null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(gi());
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.tencent.mobileqq.zplan.fragment.r
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                NewZplanSettingAvatarShowFragment.si(WeakReference.this, sharedPreferences2, str);
            }
        };
        this.spListener = onSharedPreferenceChangeListener;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void si(WeakReference weakViewModel, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(weakViewModel, "$weakViewModel");
        NewZplanSettingAvatarShowVM.SettingItemType settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.MasterSwitch;
        if (!Objects.equals(str, SwitchSetting.MASTER_SETTING.getKey())) {
            if (Objects.equals(str, SwitchSetting.PROFILE_CARD_SETTING.getKey())) {
                settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.ProfileCardSwitch;
            } else if (Objects.equals(str, SwitchSetting.DYNAMIC_SETTING.getKey())) {
                settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.QzoneSwitch;
            } else if (Objects.equals(str, SwitchSetting.AIO_AVATAR_SETTING.getKey())) {
                settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.AioAvatarSwitch;
            } else if (Objects.equals(str, SwitchSetting.DRAWER_SETTING.getKey())) {
                settingItemType = NewZplanSettingAvatarShowVM.SettingItemType.DrawerSwitch;
            }
        }
        NewZplanSettingAvatarShowVM newZplanSettingAvatarShowVM = (NewZplanSettingAvatarShowVM) weakViewModel.get();
        if (newZplanSettingAvatarShowVM != null) {
            newZplanSettingAvatarShowVM.i2(settingItemType, newZplanSettingAvatarShowVM.P1(settingItemType));
        }
    }

    private final void ti(final boolean isChecked) {
        a.c.e(isChecked, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.e
            @Override // nk3.a
            public final void onResult(boolean z16) {
                NewZplanSettingAvatarShowFragment.ui(isChecked, this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(final boolean z16, final NewZplanSettingAvatarShowFragment this$0, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("NewZplanSettingAvatarShowFragment", 1, "setAioAvatarSwitch setStatus: [isSuccess: " + z17 + ", isChecked: " + z16 + "]");
        if (z17) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.m
            @Override // java.lang.Runnable
            public final void run() {
                NewZplanSettingAvatarShowFragment.vi(NewZplanSettingAvatarShowFragment.this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(NewZplanSettingAvatarShowFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ji(R.string.xtm, 1);
        this$0.gi().i2(NewZplanSettingAvatarShowVM.SettingItemType.AioAvatarSwitch, !z16);
    }

    private final void wi(final boolean isChecked) {
        ZplanDataRepository.f334898a.p(1006L, isChecked);
        com.tencent.mobileqq.zplan.setting.e.f335451a.f(SwitchSetting.DRAWER_SETTING, isChecked, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.h
            @Override // nk3.a
            public final void onResult(boolean z16) {
                NewZplanSettingAvatarShowFragment.xi(isChecked, this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(final boolean z16, final NewZplanSettingAvatarShowFragment this$0, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("NewZplanSettingAvatarShowFragment", 1, "setDrawerSwitch setSettingSwitch: [isSuccess: " + z17 + ", isChecked: " + z16 + "]");
        if (!z17) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.j
                @Override // java.lang.Runnable
                public final void run() {
                    NewZplanSettingAvatarShowFragment.yi(NewZplanSettingAvatarShowFragment.this, z16);
                }
            });
        } else {
            com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DRAWER_SETTING, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(NewZplanSettingAvatarShowFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ji(R.string.xtm, 1);
        this$0.gi().i2(NewZplanSettingAvatarShowVM.SettingItemType.DrawerSwitch, !z16);
        ZplanDataRepository.f334898a.p(1006L, !z16);
    }

    private final void zi(final boolean isChecked) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(SwitchSetting.MASTER_SETTING, Boolean.valueOf(isChecked)));
        if (!isChecked) {
            SwitchSetting switchSetting = SwitchSetting.PROFILE_CARD_SETTING;
            Boolean bool = Boolean.FALSE;
            arrayList.add(new Pair(switchSetting, bool));
            arrayList.add(new Pair(SwitchSetting.DYNAMIC_SETTING, bool));
            arrayList.add(new Pair(SwitchSetting.AIO_AVATAR_SETTING, bool));
            arrayList.add(new Pair(SwitchSetting.DRAWER_SETTING, bool));
        }
        com.tencent.mobileqq.zplan.setting.e.f335451a.g(arrayList, new nk3.a() { // from class: com.tencent.mobileqq.zplan.fragment.g
            @Override // nk3.a
            public final void onResult(boolean z16) {
                NewZplanSettingAvatarShowFragment.Ai(isChecked, this, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        x.c.f O;
        x.c.f O2;
        super.onDestroyView();
        if (gi().getOtherSwitchGroupIsVisible() && gi().c2() != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> W1 = gi().W1();
            boolean isChecked = (W1 == null || (O2 = W1.O()) == null) ? false : O2.getIsChecked();
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> c26 = gi().c2();
            ZplanDataRepository.f334898a.q(isChecked && ((c26 == null || (O = c26.O()) == null) ? false : O.getIsChecked()));
        }
        Li();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = getString(R.string.xth);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.zplan_setting_avatar_show_new)");
        setTitle(string);
        gi();
        fi();
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] bi5 = bi();
            th5.t0((Group[]) Arrays.copyOf(bi5, bi5.length));
        }
        if (!gi().P1(NewZplanSettingAvatarShowVM.SettingItemType.MasterSwitch)) {
            Mi(false);
        } else {
            gi().g2(true);
        }
        ri();
    }

    private final void Ni(boolean isChecked) {
        if (!isChecked) {
            Oi(false, 1004L);
            Oi(false, Constant.FROM_ID_UNINSTALL_PLUGIN);
        } else {
            Oi(com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.PROFILE_CARD_SETTING), 1004L);
            Oi(com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.DYNAMIC_SETTING), Constant.FROM_ID_UNINSTALL_PLUGIN);
        }
    }
}
