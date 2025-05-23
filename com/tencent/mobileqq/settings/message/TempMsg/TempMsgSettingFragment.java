package com.tencent.mobileqq.settings.message.TempMsg;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingVM;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Arrays;
import java.util.List;
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
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002JH\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019\"\b\b\u0000\u0010\u0016*\u00020\u0015\"\b\b\u0001\u0010\u0018*\u00020\u0017*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00192\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0002JT\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001d2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0002J\u000e\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u000e\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001d\u0010:\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/settings/message/TempMsg/TempMsgSettingFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "bi", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Xh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/settings/message/TempMsg/TempMsgSettingVM$SettingItemType;", "type", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "Qh", "Oh", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lkotlin/Function0;", "onExpo", "li", "", "leftText", "", "leftIcon", "rightText", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "ni", "Lcom/tencent/mobileqq/widget/listitem/a;", "pi", "Uh", "Rh", WidgetCacheLunarData.JI, "gi", "ei", "ci", "ii", "ai", "Lcom/tencent/mobileqq/settings/message/TempMsg/TempMsgSettingVM;", "J", "Lkotlin/Lazy;", "Zh", "()Lcom/tencent/mobileqq/settings/message/TempMsg/TempMsgSettingVM;", "viewModel", "Landroid/view/inputmethod/InputMethodManager;", "K", "Yh", "()Landroid/view/inputmethod/InputMethodManager;", "mInputManager", "<init>", "()V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TempMsgSettingFragment extends BaseSettingFragment {
    private static final a L = new a(null);

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy mInputManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/settings/message/TempMsg/TempMsgSettingFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f287001a;

        static {
            int[] iArr = new int[TempMsgSettingVM.SettingItemType.values().length];
            try {
                iArr[TempMsgSettingVM.SettingItemType.Troop.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TempMsgSettingVM.SettingItemType.Contact.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TempMsgSettingVM.SettingItemType.Consult.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TempMsgSettingVM.SettingItemType.NewTroop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TempMsgSettingVM.SettingItemType.NewContact.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TempMsgSettingVM.SettingItemType.NewConsult.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TempMsgSettingVM.SettingItemType.NewCompanyQQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TempMsgSettingVM.SettingItemType.NewGameCenter.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f287001a = iArr;
        }
    }

    public TempMsgSettingFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TempMsgSettingVM>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TempMsgSettingVM invoke() {
                return (TempMsgSettingVM) TempMsgSettingFragment.this.getViewModel(TempMsgSettingVM.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<InputMethodManager>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$mInputManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InputMethodManager invoke() {
                FragmentActivity activity = TempMsgSettingFragment.this.getActivity();
                Object systemService = activity != null ? activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
                if (systemService instanceof InputMethodManager) {
                    return (InputMethodManager) systemService;
                }
                return null;
            }
        });
        this.mInputManager = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(TempMsgSettingFragment this$0, int i3, TempMsgManager tempMsgManager, short s16, TempMsgSettingVM.SettingItemType type, ActionSheet actionSheet, View view, int i16) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        QQAppInterface L1 = this$0.Zh().L1();
        if (L1 != null) {
            String B = tempMsgManager != null ? tempMsgManager.B(i16) : null;
            if (B == null) {
                B = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(B, "msgManager?.getNewReport\u2026SwitchResult(which) ?: \"\"");
            }
            String B2 = tempMsgManager != null ? tempMsgManager.B(i16) : null;
            if (B2 == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(B2, "msgManager?.getNewReport\u2026SwitchResult(which) ?: \"\"");
                str = B2;
            }
            ReportController.o(L1, "dc00898", "", "", B, str, tempMsgManager != null ? tempMsgManager.A(s16) : 0, 0, "", "", "", "");
        }
        if (i16 != i3) {
            if (tempMsgManager != null) {
                tempMsgManager.o(s16, i16, i3, true);
            }
            String str2 = this$0.Zh().S1().get(Integer.valueOf(i16));
            String str3 = str2 != null ? str2 : "";
            int i17 = b.f287001a[type.ordinal()];
            if (i17 == 4) {
                this$0.Zh().Z1().postValue(str3);
            } else if (i17 == 5) {
                this$0.Zh().X1().postValue(str3);
            } else if (i17 == 6) {
                this$0.Zh().W1().postValue(str3);
            } else if (i17 == 7) {
                this$0.Zh().U1().postValue(str3);
            }
        }
        actionSheet.dismiss();
    }

    private final void Qh(TempMsgSettingVM.SettingItemType type, boolean isOpen) {
        int i3;
        Short fieldTempConversationBlockType = type.fieldTempConversationBlockType();
        int i16 = b.f287001a[type.ordinal()];
        if (i16 != 1) {
            i3 = i16 != 2 ? i16 != 3 ? 0 : 5 : 4;
        } else {
            i3 = 1;
        }
        int i17 = i3;
        if (fieldTempConversationBlockType != null) {
            short shortValue = fieldTempConversationBlockType.shortValue();
            TempMsgManager e26 = Zh().e2();
            if (e26 != null) {
                e26.n(shortValue, isOpen, true);
            }
        }
        QQAppInterface L1 = Zh().L1();
        if (L1 != null) {
            ReportController.o(L1, "dc00898", "", "", "0X8009976", "0X8009976", i3, i17, "", "", "", "");
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Rh() {
        TempMsgSettingVM Zh = Zh();
        TempMsgSettingVM.SettingItemType settingItemType = TempMsgSettingVM.SettingItemType.Consult;
        if (!Zh.P1(settingItemType)) {
            return null;
        }
        final x xVar = new x(new x.b.d(Zh().M1(settingItemType)), new x.c.f(Zh().N1(settingItemType), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.message.TempMsg.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TempMsgSettingFragment.Sh(TempMsgSettingFragment.this, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> Q1 = Zh().Q1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$consultConfig$2$1
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
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.message.TempMsg.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TempMsgSettingFragment.Th(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(TempMsgSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qh(TempMsgSettingVM.SettingItemType.Consult, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Uh() {
        TempMsgSettingVM Zh = Zh();
        TempMsgSettingVM.SettingItemType settingItemType = TempMsgSettingVM.SettingItemType.Contact;
        if (!Zh.P1(settingItemType)) {
            return null;
        }
        final x xVar = new x(new x.b.d(Zh().M1(settingItemType)), new x.c.f(Zh().N1(settingItemType), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.message.TempMsg.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TempMsgSettingFragment.Vh(TempMsgSettingFragment.this, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> R1 = Zh().R1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$contactConfig$2$1
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
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.message.TempMsg.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TempMsgSettingFragment.Wh(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(TempMsgSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qh(TempMsgSettingVM.SettingItemType.Contact, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final InputMethodManager Yh() {
        return (InputMethodManager) this.mInputManager.getValue();
    }

    private final TempMsgSettingVM Zh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (TempMsgSettingVM) value;
    }

    private final void ai() {
        InputMethodManager Yh;
        FragmentActivity activity = getActivity();
        if (activity == null || (Yh = Yh()) == null) {
            return;
        }
        Yh.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    private final void bi() {
        ITempMsgBoxManager iTempMsgBoxManager;
        TempMsgSettingVM.SettingItemType settingItemType;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if ((activity != null ? activity.getIntent() : null) == null) {
                return;
            }
            FragmentActivity activity2 = getActivity();
            Intent intent = activity2 != null ? activity2.getIntent() : null;
            if (intent != null) {
                int intExtra = intent.getIntExtra("uinType", 0);
                QQAppInterface L1 = Zh().L1();
                if (L1 == null || (iTempMsgBoxManager = (ITempMsgBoxManager) L1.getRuntimeService(ITempMsgBoxManager.class, "")) == null || !Zh().T1().containsKey(Integer.valueOf(intExtra)) || !iTempMsgBoxManager.configContains(intExtra) || (settingItemType = Zh().T1().get(Integer.valueOf(intExtra))) == null) {
                    return;
                }
                Oh(settingItemType);
            }
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ci() {
        TempMsgSettingVM Zh = Zh();
        TempMsgSettingVM.SettingItemType settingItemType = TempMsgSettingVM.SettingItemType.NewCompanyQQ;
        if (!Zh.P1(settingItemType)) {
            return null;
        }
        final x<x.b.d, x.c.g> ni5 = ni(Zh().M1(settingItemType), 0, Zh().O1(settingItemType), new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newCompanyQQConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TempMsgSettingFragment.this.Oh(TempMsgSettingVM.SettingItemType.NewCompanyQQ);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newCompanyQQConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        MutableLiveData<String> U1 = Zh().U1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newCompanyQQConfig$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                x.c.g O = ni5.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(ni5);
                }
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.message.TempMsg.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TempMsgSettingFragment.di(Function1.this, obj);
            }
        });
        return ni5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ei() {
        TempMsgSettingVM Zh = Zh();
        TempMsgSettingVM.SettingItemType settingItemType = TempMsgSettingVM.SettingItemType.NewConsult;
        if (!Zh.P1(settingItemType)) {
            return null;
        }
        final x<x.b.d, x.c.g> ni5 = ni(Zh().M1(settingItemType), 0, Zh().O1(settingItemType), new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newConsultConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TempMsgSettingFragment.this.Oh(TempMsgSettingVM.SettingItemType.NewConsult);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newConsultConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        MutableLiveData<String> W1 = Zh().W1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newConsultConfig$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                x.c.g O = ni5.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(ni5);
                }
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.message.TempMsg.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TempMsgSettingFragment.fi(Function1.this, obj);
            }
        });
        return ni5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> gi() {
        TempMsgSettingVM Zh = Zh();
        TempMsgSettingVM.SettingItemType settingItemType = TempMsgSettingVM.SettingItemType.NewContact;
        if (!Zh.P1(settingItemType)) {
            return null;
        }
        final x<x.b.d, x.c.g> ni5 = ni(Zh().M1(settingItemType), 0, Zh().O1(settingItemType), new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newContactConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TempMsgSettingFragment.this.Oh(TempMsgSettingVM.SettingItemType.NewContact);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newContactConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        MutableLiveData<String> X1 = Zh().X1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newContactConfig$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                x.c.g O = ni5.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(ni5);
                }
            }
        };
        X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.message.TempMsg.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TempMsgSettingFragment.hi(Function1.this, obj);
            }
        });
        return ni5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ii() {
        TempMsgSettingVM Zh = Zh();
        TempMsgSettingVM.SettingItemType settingItemType = TempMsgSettingVM.SettingItemType.NewGameCenter;
        if (Zh.P1(settingItemType)) {
            return ni(Zh().M1(settingItemType), 0, Zh().O1(settingItemType), new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newGameCenterConfig$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TempMsgSettingFragment.this.Oh(TempMsgSettingVM.SettingItemType.NewGameCenter);
                }
            }, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newGameCenterConfig$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
        }
        return null;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ji() {
        TempMsgSettingVM Zh = Zh();
        TempMsgSettingVM.SettingItemType settingItemType = TempMsgSettingVM.SettingItemType.NewTroop;
        if (!Zh.P1(settingItemType)) {
            return null;
        }
        final x<x.b.d, x.c.g> ni5 = ni(Zh().M1(settingItemType), 0, Zh().O1(settingItemType), new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newTroopConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TempMsgSettingFragment.this.Oh(TempMsgSettingVM.SettingItemType.NewTroop);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newTroopConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        MutableLiveData<String> Z1 = Zh().Z1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$newTroopConfig$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                x.c.g O = ni5.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(ni5);
                }
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.message.TempMsg.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TempMsgSettingFragment.ki(Function1.this, obj);
            }
        });
        return ni5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final <L extends x.b, R extends x.c> x<L, R> li(x<L, R> xVar, final Function0<Unit> function0) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.message.TempMsg.d
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TempMsgSettingFragment.mi(Ref.BooleanRef.this, function0, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(Ref.BooleanRef firstExpo, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(firstExpo, "$firstExpo");
        Intrinsics.checkNotNullParameter(it, "it");
        if (firstExpo.element) {
            firstExpo.element = false;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private final x<x.b.d, x.c.g> ni(CharSequence leftText, int leftIcon, CharSequence rightText, final Function0<Unit> onClick, final Function0<Unit> onExpo) {
        x.b dVar;
        if (leftIcon != 0) {
            dVar = new x.b.C8996b(leftText, leftIcon);
        } else {
            dVar = new x.b.d(leftText);
        }
        x<x.b.d, x.c.g> xVar = new x<>(dVar, new x.c.g(rightText, true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.TempMsg.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TempMsgSettingFragment.oi(Function0.this, view);
            }
        });
        li(xVar, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$singleLineConfig$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0<Unit> function0 = onExpo;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        return xVar;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> pi() {
        TempMsgSettingVM Zh = Zh();
        TempMsgSettingVM.SettingItemType settingItemType = TempMsgSettingVM.SettingItemType.Troop;
        if (!Zh.P1(settingItemType)) {
            return null;
        }
        final x xVar = new x(new x.b.d(Zh().M1(settingItemType)), new x.c.f(Zh().N1(settingItemType), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.message.TempMsg.k
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TempMsgSettingFragment.qi(TempMsgSettingFragment.this, compoundButton, z16);
            }
        }));
        MutableLiveData<Boolean> b26 = Zh().b2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment$troopConfig$2$1
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
        b26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.settings.message.TempMsg.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TempMsgSettingFragment.ri(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(TempMsgSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qh(TempMsgSettingVM.SettingItemType.Troop, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = getString(R.string.f23077702);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.temp_msg_setting_title)");
        setTitle(string);
        Zh();
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] Xh = Xh();
            th5.t0((Group[]) Arrays.copyOf(Xh, Xh.length));
        }
        bi();
        ai();
    }

    private final Group[] Xh() {
        List mutableListOf;
        List filterNotNull;
        String string = getString(R.string.f230676zs);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.temp_msg_setting_description)");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(pi(), ji(), Uh(), gi(), Rh(), ei(), ci(), ii());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group[]{new Group("", string, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(final TempMsgSettingVM.SettingItemType type) {
        switch (b.f287001a[type.ordinal()]) {
            case 4:
            case 5:
            case 6:
            case 7:
                Short fieldTempConversationBlockType = type.fieldTempConversationBlockType();
                if (fieldTempConversationBlockType != null) {
                    final short shortValue = fieldTempConversationBlockType.shortValue();
                    Dialog createDialog = ActionSheetHelper.createDialog(getContext(), null);
                    final ActionSheet actionSheet = createDialog instanceof ActionSheet ? (ActionSheet) createDialog : null;
                    String string = getString(R.string.f230686zt, Zh().a2(shortValue));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.temp_\u2026getSheetTitle(blockType))");
                    if (actionSheet != null) {
                        actionSheet.setMainTitle(string);
                    }
                    if (actionSheet != null) {
                        actionSheet.addRadioButton((CharSequence) getString(R.string.f230716zw), false);
                    }
                    if (actionSheet != null) {
                        actionSheet.addRadioButton((CharSequence) getString(R.string.f230706zv), false);
                    }
                    if (actionSheet != null) {
                        actionSheet.addRadioButton((CharSequence) getString(R.string.f230726zx), false);
                    }
                    final TempMsgManager e26 = Zh().e2();
                    final int tempSettingStatus = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getTempSettingStatus(e26 != null ? e26.F(shortValue) : false, e26 != null ? e26.K(shortValue) : false);
                    if (Zh().S1().containsKey(Integer.valueOf(tempSettingStatus))) {
                        if (actionSheet != null) {
                            actionSheet.setRadioButtonChecked(tempSettingStatus);
                        }
                        if (actionSheet != null) {
                            actionSheet.addCancelButton(R.string.cancel);
                        }
                        if (actionSheet != null) {
                            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.settings.message.TempMsg.e
                                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                                public final void onClick(View view, int i3) {
                                    TempMsgSettingFragment.Ph(TempMsgSettingFragment.this, tempSettingStatus, e26, shortValue, type, actionSheet, view, i3);
                                }
                            });
                        }
                        QQAppInterface L1 = Zh().L1();
                        if (L1 != null) {
                            ReportController.o(L1, "dc00898", "", "", "0X800BB8A", "0X800BB8A", e26 != null ? e26.A(shortValue) : 0, 0, "", "", "", "");
                        }
                        if (actionSheet != null) {
                            actionSheet.show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 8:
                QQAppInterface L12 = Zh().L1();
                if (L12 != null) {
                    ReportController.o(L12, "dc00898", "", "", "0X800BB8E", "0X800BB8E", 0, 0, "", "", "", "");
                }
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).openGameMsgSettingPage(getContext(), "NewTempMsgSettingFragment");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }
}
