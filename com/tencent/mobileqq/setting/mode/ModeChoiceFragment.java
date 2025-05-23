package com.tencent.mobileqq.setting.mode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ElderModeFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.ColorListDialogFragment;
import com.tencent.mobileqq.studymode.urlfilter.api.IStudyModeUrlFilter;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0013H\u0002J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00190\u0013H\u0002J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001b0\u0013H\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001b0\u0013H\u0002J\u001a\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\"\u0010(\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0016R\u001a\u00102\u001a\u00020-8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/setting/mode/ModeChoiceFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "Lcom/tencent/mobileqq/setting/mode/d;", "", "oi", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "ni", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "Lcom/tencent/mobileqq/widget/listitem/c$b$d;", WidgetCacheLunarData.JI, "Qi", "Ui", "pi", "", "targetMode", "Ji", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Ki", "Lcom/tencent/mobileqq/widget/listitem/x$c$d;", "Yi", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Fi", "Lcom/tencent/mobileqq/widget/listitem/x$c$i;", "vi", "Ai", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onPostThemeChanged", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "oldMode", "targetType", "o6", "", "J", "Ljava/lang/String;", SensorJsPlugin.SENSOR_INTERVAL_UI, "()Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/setting/mode/ModeChoiceViewModel;", "K", "Lcom/tencent/mobileqq/setting/mode/ModeChoiceViewModel;", "modeChangeViewModel", "Lcom/tencent/mobileqq/setting/mode/am;", "L", "Lcom/tencent/mobileqq/setting/mode/am;", "youthModeHandler", "Lcom/tencent/mobileqq/setting/mode/c;", "M", "Lcom/tencent/mobileqq/setting/mode/c;", "elderModeHandler", "N", "Lkotlin/Lazy;", "ti", "()Lcom/tencent/mobileqq/widget/listitem/Group;", "nightModeGroup", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ModeChoiceFragment extends BaseSettingFragment implements d {

    /* renamed from: J, reason: from kotlin metadata */
    private final String TAG = "ModeChoiceFragment";

    /* renamed from: K, reason: from kotlin metadata */
    private final ModeChoiceViewModel modeChangeViewModel = new ModeChoiceViewModel();

    /* renamed from: L, reason: from kotlin metadata */
    private am youthModeHandler;

    /* renamed from: M, reason: from kotlin metadata */
    private c elderModeHandler;

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy nightModeGroup;

    public ModeChoiceFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Group>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$nightModeGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Group invoke() {
                com.tencent.mobileqq.widget.listitem.x Fi;
                com.tencent.mobileqq.widget.listitem.x vi5;
                com.tencent.mobileqq.widget.listitem.x Ai;
                List mutableListOf;
                Fi = ModeChoiceFragment.this.Fi();
                vi5 = ModeChoiceFragment.this.vi();
                Ai = ModeChoiceFragment.this.Ai();
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Fi, vi5, Ai);
                Object[] array = mutableListOf.toArray(new com.tencent.mobileqq.widget.listitem.x[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                com.tencent.mobileqq.widget.listitem.x[] xVarArr = (com.tencent.mobileqq.widget.listitem.x[]) array;
                return new Group("\u591c\u95f4\u6a21\u5f0f", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length));
            }
        });
        this.nightModeGroup = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> Ai() {
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d("\u591c\u95f4\u6a21\u5f0f"), new x.c.i(false, null));
        xVar.p(false);
        MutableLiveData<Boolean> X1 = this.modeChangeViewModel.X1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$nightMode$1$1
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
            public final void invoke2(Boolean bool) {
                QUIListItemAdapter th5;
                if (!Intrinsics.areEqual(Boolean.valueOf(xVar.getIsVisible()), bool) || (th5 = this.th()) == null) {
                    return;
                }
                th5.m0(xVar, !bool.booleanValue());
            }
        };
        X1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.mode.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.Bi(Function1.this, obj);
            }
        });
        xVar.O().e(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.setting.mode.ag
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                ModeChoiceFragment.Ci(com.tencent.mobileqq.widget.listitem.x.this, this, view, z16);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.mode.ah
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ModeChoiceFragment.Di(view);
            }
        });
        MutableLiveData<Boolean> a26 = this.modeChangeViewModel.a2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$nightMode$1$4
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
                x.c.i O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
            }
        };
        a26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.setting.mode.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.Ei(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(com.tencent.mobileqq.widget.listitem.x this_apply, ModeChoiceFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        ((x.c.i) this_apply.O()).f(!z16);
        QUIListItemAdapter th5 = this$0.th();
        if (th5 != null) {
            th5.l0(this_apply);
        }
        if (!this$0.modeChangeViewModel.P1()) {
            this$0.modeChangeViewModel.h2();
        }
        com.tencent.mobileqq.setting.utils.o.g(com.tencent.mobileqq.setting.utils.o.f286768a, view, "em_bas_night_pattern", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Di(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_night_pattern", null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> Fi() {
        String string = requireContext().getString(R.string.vr7);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026dark_mode_ui_switch_text)");
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.f(true, null));
        xVar.O().h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.mode.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ModeChoiceFragment.Gi(ModeChoiceFragment.this, compoundButton, z16);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.mode.v
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ModeChoiceFragment.Hi(view);
            }
        });
        MutableLiveData<Boolean> X1 = this.modeChangeViewModel.X1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$nightModeFollowSystem$1$3
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
        X1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.mode.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.Ii(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(ModeChoiceFragment this$0, CompoundButton buttonView, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.modeChangeViewModel.M1(z16);
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        com.tencent.mobileqq.setting.utils.o.g(oVar, buttonView, "em_bas_night_mode_follow_system", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hi(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_night_mode_follow_system", null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ji(int targetMode) {
        QLog.d(this.TAG, 1, "onClickMode target: " + targetMode);
        int Q1 = this.modeChangeViewModel.Q1();
        if (com.tencent.common.config.pad.f.o()) {
            am amVar = this.youthModeHandler;
            if (amVar != null && amVar.u(Q1, targetMode)) {
                return;
            }
        }
        if (Q1 == 3) {
            c cVar = this.elderModeHandler;
            if (cVar != null) {
                cVar.d(targetMode);
                return;
            }
            return;
        }
        if (targetMode == 3) {
            c cVar2 = this.elderModeHandler;
            if (cVar2 != null) {
                cVar2.g(getActivity());
                return;
            }
            return;
        }
        if (targetMode == 2) {
            am amVar2 = this.youthModeHandler;
            if (amVar2 != null) {
                amVar2.v(Q1);
                return;
            }
            return;
        }
        if (Q1 == 2) {
            am amVar3 = this.youthModeHandler;
            if (amVar3 != null) {
                amVar3.h(targetMode);
                return;
            }
            return;
        }
        this.modeChangeViewModel.f2(targetMode);
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Ki() {
        String string = requireContext().getString(R.string.f168002eg);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026g.mode_name_simple_color)");
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("\u6781\u7b80\u767d", true, false, 4, null));
        xVar.p(this.modeChangeViewModel.Q1() == 1);
        MutableLiveData<Integer> T1 = this.modeChangeViewModel.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$simpleModeColor$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                boolean z16 = false;
                if ((num != null && num.intValue() == 1) == xVar.getIsVisible()) {
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    xVar.O().h(this.modeChangeViewModel.U1());
                }
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = xVar;
                    if (num != null && num.intValue() == 1) {
                        z16 = true;
                    }
                    th5.m0(xVar2, z16);
                }
            }
        };
        T1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.mode.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.Li(Function1.this, obj);
            }
        });
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.mode.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModeChoiceFragment.Mi(ModeChoiceFragment.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.mode.n
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ModeChoiceFragment.Oi(view);
            }
        });
        MutableLiveData<Integer> b26 = this.modeChangeViewModel.b2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$simpleModeColor$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                xVar.O().h(this.modeChangeViewModel.U1());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
            }
        };
        b26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.setting.mode.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.Pi(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mi(final ModeChoiceFragment this$0, View it) {
        LiveData<Integer> L1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Vibrator vibrator = (Vibrator) (context != null ? context.getSystemService("vibrator") : null);
        if (vibrator != null) {
            vibrator.vibrate(20L);
        }
        int W1 = this$0.modeChangeViewModel.W1();
        if (this$0.getContext() instanceof BaseActivity) {
            Context context2 = this$0.getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
            Manager manager = ((BaseActivity) context2).getAppInterface().getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.studymode.ModeSwitchManager");
            ((com.tencent.mobileqq.studymode.l) manager).w(W1);
            QLog.i(this$0.TAG, 1, "update modeSwitchManager.bPref: " + W1 + " when init ColorListDialogFragment");
        }
        ColorListDialogFragment colorListDialogFragment = new ColorListDialogFragment(W1);
        Context context3 = this$0.getContext();
        Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        colorListDialogFragment.show(((FragmentActivity) context3).getSupportFragmentManager(), "ColorListDialogFragment");
        FragmentActivity activity = this$0.getActivity();
        com.tencent.mobileqq.studymode.e eVar = activity != null ? (com.tencent.mobileqq.studymode.e) new ViewModelProvider(activity).get(com.tencent.mobileqq.studymode.e.class) : null;
        if (eVar != null) {
            eVar.M1(W1);
        }
        if (eVar != null && (L1 = eVar.L1()) != null) {
            L1.observe(colorListDialogFragment, new Observer() { // from class: com.tencent.mobileqq.setting.mode.ab
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ModeChoiceFragment.Ni(ModeChoiceFragment.this, ((Integer) obj).intValue());
                }
            });
        }
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.setting.utils.o.g(oVar, it, "em_bas_clean_mode_theme_color", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ni(ModeChoiceFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 1, "simpleModeColor change: " + i3);
        if (i3 == this$0.modeChangeViewModel.W1()) {
            QLog.e("ModeChoiceViewModel", 1, "handleSimpleColorCheck same color!!!");
            return;
        }
        String themeId = SimpleUIUtil.getThemeId(i3);
        if (this$0.getActivity() != null) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null && activity.isFinishing()) {
                return;
            }
            FragmentActivity activity2 = this$0.getActivity();
            if ((activity2 != null && activity2.isDestroyed()) || DarkModeManager.w(this$0.requireActivity(), themeId, new a(i3))) {
                return;
            }
            this$0.modeChangeViewModel.c2(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_clean_mode_theme_color", null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.d> Qi() {
        String string = requireContext().getString(R.string.wjy);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026eneral_simple_mode_title)");
        String string2 = requireContext().getString(R.string.f13795089);
        Intrinsics.checkNotNullExpressionValue(string2, "requireContext().getStri\u2026.general_simple_mode_des)");
        final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.d> cVar = new com.tencent.mobileqq.widget.listitem.c<>(new c.a.g(string, string2), new c.b.d(false, null));
        MutableLiveData<Integer> T1 = this.modeChangeViewModel.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$simpleModeConfig$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                boolean z16 = false;
                if ((num != null && num.intValue() == 1) == cVar.O().getIsSelected()) {
                    return;
                }
                QLog.d(this.getTAG(), 2, "simpleModeConfig change selected");
                c.b.d O = cVar.O();
                if (num != null && num.intValue() == 1) {
                    z16 = true;
                }
                O.e(z16);
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(cVar);
                }
            }
        };
        T1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.mode.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.Ri(Function1.this, obj);
            }
        });
        cVar.O().d(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.setting.mode.j
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                ModeChoiceFragment.Si(com.tencent.mobileqq.widget.listitem.c.this, this, view, z16);
            }
        });
        cVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.mode.k
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ModeChoiceFragment.Ti(view);
            }
        });
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Si(com.tencent.mobileqq.widget.listitem.c this_apply, ModeChoiceFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        ((c.b.d) this_apply.O()).e(!z16);
        QUIListItemAdapter th5 = this$0.th();
        if (th5 != null) {
            th5.l0(this_apply);
        }
        if (!z16 || this$0.modeChangeViewModel.Q1() == 1) {
            return;
        }
        this$0.Ji(1);
        com.tencent.mobileqq.setting.utils.o.g(com.tencent.mobileqq.setting.utils.o.f286768a, view, "em_bas_compact_mode", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ti(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.m(com.tencent.mobileqq.setting.utils.o.f286768a, it, "em_bas_compact_mode", null, false, 8, null);
    }

    private final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.d> Ui() {
        String qqStr = HardCodeUtil.qqStr(R.string.f242937vx);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.youth_und\u2026egree_popup_window_title)");
        String string = requireContext().getString(R.string.f242917vv);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026th_mode_popup_window_des)");
        final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.d> cVar = new com.tencent.mobileqq.widget.listitem.c<>(new c.a.g(qqStr, string), new c.b.d(false, null));
        MutableLiveData<Integer> T1 = this.modeChangeViewModel.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$studyModeConfig$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if ((num != null && num.intValue() == 2) == cVar.O().getIsSelected()) {
                    return;
                }
                cVar.O().e(num != null && num.intValue() == 2);
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(cVar);
                }
            }
        };
        T1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.mode.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.Vi(Function1.this, obj);
            }
        });
        cVar.O().d(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.setting.mode.y
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                ModeChoiceFragment.Wi(com.tencent.mobileqq.widget.listitem.c.this, this, view, z16);
            }
        });
        cVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.mode.z
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ModeChoiceFragment.Xi(view);
            }
        });
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(com.tencent.mobileqq.widget.listitem.c this_apply, ModeChoiceFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        ((c.b.d) this_apply.O()).e(!z16);
        QUIListItemAdapter th5 = this$0.th();
        if (th5 != null) {
            th5.l0(this_apply);
        }
        if (!z16 || this$0.modeChangeViewModel.Q1() == 2) {
            return;
        }
        this$0.Ji(2);
        ((IStudyModeUrlFilter) QRoute.api(IStudyModeUrlFilter.class)).initUrlFilterFlagFirstEnter();
        com.tencent.mobileqq.setting.utils.o.g(com.tencent.mobileqq.setting.utils.o.f286768a, view, "em_bas_adolescent_mode", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xi(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.m(com.tencent.mobileqq.setting.utils.o.f286768a, it, "em_bas_adolescent_mode", null, false, 8, null);
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d> Yi() {
        String string = requireContext().getString(R.string.f171054wm2);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026g.kidmode_addition_enter)");
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.d("", "", false, false, 12, null));
        xVar.p(this.modeChangeViewModel.Q1() == 2);
        MutableLiveData<Integer> T1 = this.modeChangeViewModel.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$youthModeColor$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                QUIListItemAdapter th5;
                if ((num != null && num.intValue() == 2) == xVar.getIsVisible() || (th5 = this.th()) == null) {
                    return;
                }
                th5.m0(xVar, num != null && num.intValue() == 2);
            }
        };
        T1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.mode.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.Zi(Function1.this, obj);
            }
        });
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.mode.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModeChoiceFragment.aj(ModeChoiceFragment.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.mode.h
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ModeChoiceFragment.bj(view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aj(ModeChoiceFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        am amVar = this$0.youthModeHandler;
        if (amVar != null) {
            amVar.p();
        }
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.setting.utils.o.g(oVar, it, "em_bas_teen_advanced_settings", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bj(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.m(com.tencent.mobileqq.setting.utils.o.f286768a, it, "em_bas_teen_advanced_settings", null, false, 8, null);
    }

    private final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.d> ji() {
        String string = requireContext().getString(R.string.f13792086);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026l_default_mode_title_new)");
        final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.d> cVar = new com.tencent.mobileqq.widget.listitem.c<>(new c.a.g(string, "\u968f\u5fc3\u4f7f\u7528\uff0c\u7545\u4eab\u88c5\u626e"), new c.b.d(false, null));
        MutableLiveData<Integer> T1 = this.modeChangeViewModel.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$commonModeConfig$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if ((num != null && num.intValue() == 0) == cVar.O().getIsSelected()) {
                    return;
                }
                QLog.d(this.getTAG(), 2, "commonModeConfig change selected");
                cVar.O().e(num != null && num.intValue() == 0);
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(cVar);
                }
            }
        };
        T1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.mode.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.ki(Function1.this, obj);
            }
        });
        cVar.O().d(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.setting.mode.ad
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                ModeChoiceFragment.li(com.tencent.mobileqq.widget.listitem.c.this, this, view, z16);
            }
        });
        cVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.mode.ae
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ModeChoiceFragment.mi(view);
            }
        });
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(com.tencent.mobileqq.widget.listitem.c this_apply, ModeChoiceFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        ((c.b.d) this_apply.O()).e(!z16);
        QUIListItemAdapter th5 = this$0.th();
        if (th5 != null) {
            th5.l0(this_apply);
        }
        if (!z16 || this$0.modeChangeViewModel.Q1() == 0) {
            return;
        }
        this$0.Ji(0);
        com.tencent.mobileqq.setting.utils.o.g(com.tencent.mobileqq.setting.utils.o.f286768a, view, "em_bas_ordinary_mode", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_ordinary_mode", null, false);
    }

    private final void oi() {
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] ni5 = ni();
            th5.t0((Group[]) Arrays.copyOf(ni5, ni5.length));
        }
    }

    private final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.d> pi() {
        String string = requireContext().getString(R.string.f167902e7);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getString(R.string.mode_elder)");
        String string2 = requireContext().getString(R.string.f167932e_);
        Intrinsics.checkNotNullExpressionValue(string2, "requireContext().getStri\u2026ring.mode_elder_new_desc)");
        final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.d> cVar = new com.tencent.mobileqq.widget.listitem.c<>(new c.a.g(string, string2), new c.b.d(false, null));
        MutableLiveData<Integer> T1 = this.modeChangeViewModel.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$elderModeConfig$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                cVar.O().e(num != null && num.intValue() == 3);
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(cVar);
                }
            }
        };
        T1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.mode.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.qi(Function1.this, obj);
            }
        });
        cVar.O().d(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.setting.mode.p
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                ModeChoiceFragment.ri(com.tencent.mobileqq.widget.listitem.c.this, this, view, z16);
            }
        });
        cVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.mode.aa
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ModeChoiceFragment.si(view);
            }
        });
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(com.tencent.mobileqq.widget.listitem.c this_apply, ModeChoiceFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        ((c.b.d) this_apply.O()).e(!z16);
        QUIListItemAdapter th5 = this$0.th();
        if (th5 != null) {
            th5.l0(this_apply);
        }
        if (z16 && this$0.modeChangeViewModel.Q1() != 3) {
            this$0.Ji(3);
            com.tencent.mobileqq.setting.utils.o.g(com.tencent.mobileqq.setting.utils.o.f286768a, view, "em_bas_caring_mode", null, 4, null);
        } else {
            ElderModeFragment.Dh(this$0.getActivity(), 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.m(com.tencent.mobileqq.setting.utils.o.f286768a, it, "em_bas_caring_mode", null, false, 8, null);
    }

    private final Group ti() {
        return (Group) this.nightModeGroup.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> vi() {
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d("\u65e5\u95f4\u6a21\u5f0f"), new x.c.i(false, null));
        xVar.p(false);
        MutableLiveData<Boolean> X1 = this.modeChangeViewModel.X1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$lightMode$1$1
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
            public final void invoke2(Boolean bool) {
                QUIListItemAdapter th5;
                if (!Intrinsics.areEqual(Boolean.valueOf(xVar.getIsVisible()), bool) || (th5 = this.th()) == null) {
                    return;
                }
                th5.m0(xVar, !bool.booleanValue());
            }
        };
        X1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.mode.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.wi(Function1.this, obj);
            }
        });
        xVar.O().e(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.setting.mode.r
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                ModeChoiceFragment.xi(com.tencent.mobileqq.widget.listitem.x.this, this, view, z16);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.mode.s
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ModeChoiceFragment.yi(view);
            }
        });
        MutableLiveData<Boolean> a26 = this.modeChangeViewModel.a2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceFragment$lightMode$1$4
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
            public final void invoke2(Boolean bool) {
                xVar.O().f(!bool.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
            }
        };
        a26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.setting.mode.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ModeChoiceFragment.zi(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(com.tencent.mobileqq.widget.listitem.x this_apply, ModeChoiceFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        ((x.c.i) this_apply.O()).f(!z16);
        QUIListItemAdapter th5 = this$0.th();
        if (th5 != null) {
            th5.l0(this_apply);
        }
        if (this$0.modeChangeViewModel.P1()) {
            this$0.modeChangeViewModel.g2();
        }
        com.tencent.mobileqq.setting.utils.o.g(com.tencent.mobileqq.setting.utils.o.f286768a, view, "em_bas_daytime_pattern", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_daytime_pattern", null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.setting.mode.d
    public void o6(int oldMode, int targetType) {
        this.modeChangeViewModel.R1(oldMode, targetType);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int Q1 = this.modeChangeViewModel.Q1();
        Integer valueOf = data != null ? Integer.valueOf(data.getIntExtra("extra_target_mode", -1)) : null;
        if (Q1 == 3) {
            QLog.d(this.TAG, 2, "commonModeConfig MODE_TYPE_ELDER");
            return;
        }
        if (Q1 == 2 || ((valueOf != null && valueOf.intValue() == 2) || requestCode == 7)) {
            QLog.d(this.TAG, 2, "commonModeConfig MODE_TYPE_STUDY");
            am amVar = this.youthModeHandler;
            if (amVar != null) {
                amVar.l(requestCode, resultCode, data);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        am amVar = this.youthModeHandler;
        if (amVar != null) {
            amVar.onDestroy();
        }
        this.modeChangeViewModel.onDestroy();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        this.modeChangeViewModel.e2();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            QUIImmersiveHelper.s(activity, true, true);
        }
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();
        if (context != null) {
            this.youthModeHandler = new am(context);
            this.elderModeHandler = new c(context);
            am amVar = this.youthModeHandler;
            if (amVar != null) {
                amVar.q();
            }
        }
        c cVar = this.elderModeHandler;
        if (cVar != null) {
            cVar.h(this);
        }
        String string = getString(R.string.wjw);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.general_mode_select_title)");
        setTitle(string);
        oi();
        this.modeChangeViewModel.d2();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            com.tencent.mobileqq.setting.utils.o.o(com.tencent.mobileqq.setting.utils.o.f286768a, activity, view, "pg_bas_mode_selection_settings", null, 8, null);
        }
    }

    /* renamed from: ui, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    private final Group[] ni() {
        List mutableListOf;
        List mutableListOf2;
        List mutableListOf3;
        String string = requireContext().getString(R.string.f226156nk);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026ring.settings_debug_mode)");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(ji(), Qi(), Ui(), pi());
        Object[] array = mutableListOf.toArray(new com.tencent.mobileqq.widget.listitem.c[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.c[] cVarArr = (com.tencent.mobileqq.widget.listitem.c[]) array;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(Ki(), Yi());
        Object[] array2 = mutableListOf2.toArray(new com.tencent.mobileqq.widget.listitem.x[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.x[] xVarArr = (com.tencent.mobileqq.widget.listitem.x[]) array2;
        mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf(new Group(string, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(cVarArr, cVarArr.length)), new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length)));
        if (DarkModeManager.k()) {
            mutableListOf3.add(ti());
        }
        Object[] array3 = mutableListOf3.toArray(new Group[0]);
        Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Group[]) array3;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/setting/mode/ModeChoiceFragment$a", "Lcom/tencent/mobileqq/theme/DarkModeManager$e;", "", "onConfirm", "onCancel", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements DarkModeManager.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f286631b;

        a(int i3) {
            this.f286631b = i3;
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            ModeChoiceFragment.this.modeChangeViewModel.i2();
            ModeChoiceFragment.this.modeChangeViewModel.c2(this.f286631b);
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
        }
    }
}
