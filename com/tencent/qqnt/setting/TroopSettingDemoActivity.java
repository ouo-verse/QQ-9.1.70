package com.tencent.qqnt.setting;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqnt.base.BaseActivity;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.chathistory.api.IHistoryForwardApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.setting.troop.a;
import com.tencent.qqnt.setting.troop.b;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.ai;
import w71.aj;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0012\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010\"\u001a\u00020\u0002H\u0014R\u0016\u0010%\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R$\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/setting/TroopSettingDemoActivity;", "Lcom/tencent/qqnt/base/BaseActivity;", "", "Y2", "l3", "u3", "", "isChecked", "z3", "x3", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "mark", "y3", "Lcom/tencent/qqnt/setting/troop/b;", "intent", "w3", "Lcom/tencent/qqnt/setting/troop/a;", "state", ICustomDataEditor.STRING_PARAM_3, "Lcom/tencent/qqnt/setting/troop/a$b;", "r3", "E3", "", ICustomDataEditor.NUMBER_PARAM_3, "A3", "Lcom/tencent/qqnt/setting/troop/a$a;", "p3", "", "tab", "v3", "initViewModel", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "b0", "I", "mChatType", "c0", "Ljava/lang/String;", "mPeerId", "d0", "mNick", "Lw71/ai;", "e0", "Lw71/ai;", "binding", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "f0", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "viewModel", "<init>", "()V", "g0", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopSettingDemoActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int mChatType;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mPeerId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mNick;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ai binding;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseViewModel<com.tencent.qqnt.setting.troop.a, com.tencent.qqnt.setting.troop.b> viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/setting/TroopSettingDemoActivity$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.setting.TroopSettingDemoActivity$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f362135a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65846);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GroupMsgMask.values().length];
            try {
                iArr[GroupMsgMask.ASSISTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GroupMsgMask.SHIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GroupMsgMask.RECEIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f362135a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/setting/TroopSettingDemoActivity$c", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f362136a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TroopSettingDemoActivity f362137b;

        c(String str, TroopSettingDemoActivity troopSettingDemoActivity) {
            this.f362136a = str;
            this.f362137b = troopSettingDemoActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) troopSettingDemoActivity);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new com.tencent.qqnt.setting.troop.g(this.f362136a, this.f362137b.mChatType);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65850);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingDemoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mChatType = 1;
        }
    }

    private final void A3() {
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this);
        aj g16 = aj.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        g16.f444769b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.B3(TroopSettingDemoActivity.this, aVar, view);
            }
        });
        g16.f444771d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.C3(TroopSettingDemoActivity.this, aVar, view);
            }
        });
        g16.f444770c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.D3(TroopSettingDemoActivity.this, aVar, view);
            }
        });
        aVar.setContentView(g16.getRoot());
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B3(TroopSettingDemoActivity this$0, com.google.android.material.bottomsheet.a dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.y3(GroupMsgMask.ASSISTANT);
        dialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C3(TroopSettingDemoActivity this$0, com.google.android.material.bottomsheet.a dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.y3(GroupMsgMask.SHIELD);
        dialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D3(TroopSettingDemoActivity this$0, com.google.android.material.bottomsheet.a dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.y3(GroupMsgMask.RECEIVE);
        dialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void E3(GroupMsgMask mark) {
        ai aiVar = null;
        if (mark != GroupMsgMask.NOTIFY && mark != GroupMsgMask.UNSPECIFIED) {
            ai aiVar2 = this.binding;
            if (aiVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aiVar2 = null;
            }
            aiVar2.f444764i.setChecked(true);
            ai aiVar3 = this.binding;
            if (aiVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aiVar3 = null;
            }
            aiVar3.f444766k.setVisibility(0);
            ai aiVar4 = this.binding;
            if (aiVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aiVar = aiVar4;
            }
            aiVar.f444767l.setText(n3(mark));
            return;
        }
        ai aiVar5 = this.binding;
        if (aiVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar5 = null;
        }
        aiVar5.f444764i.setChecked(false);
        ai aiVar6 = this.binding;
        if (aiVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aiVar = aiVar6;
        }
        aiVar.f444766k.setVisibility(8);
    }

    private final void Y2() {
        ai aiVar = this.binding;
        ai aiVar2 = null;
        if (aiVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar = null;
        }
        aiVar.f444757b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.c3(TroopSettingDemoActivity.this, view);
            }
        });
        ai aiVar3 = this.binding;
        if (aiVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar3 = null;
        }
        aiVar3.f444765j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.d3(TroopSettingDemoActivity.this, view);
            }
        });
        ai aiVar4 = this.binding;
        if (aiVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar4 = null;
        }
        aiVar4.f444764i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.e3(TroopSettingDemoActivity.this, view);
            }
        });
        ai aiVar5 = this.binding;
        if (aiVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar5 = null;
        }
        aiVar5.f444766k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.f3(TroopSettingDemoActivity.this, view);
            }
        });
        ai aiVar6 = this.binding;
        if (aiVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar6 = null;
        }
        aiVar6.f444758c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.g3(TroopSettingDemoActivity.this, view);
            }
        });
        ai aiVar7 = this.binding;
        if (aiVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar7 = null;
        }
        aiVar7.f444763h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.h3(TroopSettingDemoActivity.this, view);
            }
        });
        ai aiVar8 = this.binding;
        if (aiVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar8 = null;
        }
        aiVar8.f444759d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.i3(TroopSettingDemoActivity.this, view);
            }
        });
        ai aiVar9 = this.binding;
        if (aiVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar9 = null;
        }
        aiVar9.f444762g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.j3(TroopSettingDemoActivity.this, view);
            }
        });
        ai aiVar10 = this.binding;
        if (aiVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar10 = null;
        }
        aiVar10.f444761f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.Z2(TroopSettingDemoActivity.this, view);
            }
        });
        ai aiVar11 = this.binding;
        if (aiVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aiVar2 = aiVar11;
        }
        aiVar2.f444760e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingDemoActivity.b3(TroopSettingDemoActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z2(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v3(4);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b3(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v3(5);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c3(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u3();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d3(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ai aiVar = this$0.binding;
        if (aiVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar = null;
        }
        this$0.z3(aiVar.f444765j.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e3(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ai aiVar = this$0.binding;
        if (aiVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar = null;
        }
        this$0.x3(aiVar.f444764i.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f3(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A3();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l3();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v3(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i3(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v3(2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j3(TroopSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v3(3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l3() {
        w3(b.a.f362183a);
    }

    private final String n3(GroupMsgMask mark) {
        int i3 = b.f362135a[mark.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "";
                }
                return "\u63a5\u6536\u6d88\u606f\u4f46\u4e0d\u63d0\u9192";
            }
            return "\u5c4f\u853d\u7fa4\u6d88\u606f";
        }
        return "\u6536\u8fdb\u7fa4\u52a9\u624b\u4e14\u4e0d\u63d0\u9192";
    }

    private final void p3(a.C9698a state) {
        if (state.a()) {
            Toast.makeText(this, "\u5220\u9664\u6210\u529f", 0).show();
        } else {
            Toast.makeText(this, "\u5220\u9664\u5931\u8d25", 0).show();
        }
    }

    private final void r3(a.b state) {
        GroupDetailInfo a16 = state.a();
        ai aiVar = this.binding;
        if (aiVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aiVar = null;
        }
        aiVar.f444765j.setChecked(a16.isTop);
        GroupMsgMask groupMsgMask = a16.cmdUinMsgMask;
        Intrinsics.checkNotNullExpressionValue(groupMsgMask, "groupInfo.cmdUinMsgMask");
        E3(groupMsgMask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s3(com.tencent.qqnt.setting.troop.a state) {
        if (state instanceof a.b) {
            r3((a.b) state);
        } else if (state instanceof a.C9698a) {
            p3((a.C9698a) state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void u3() {
        if (this.mPeerId != null && this.mChatType != 0) {
            IChatHistoryApi iChatHistoryApi = (IChatHistoryApi) QRoute.api(IChatHistoryApi.class);
            int i3 = 1;
            if (this.mChatType != 1) {
                i3 = 2;
            }
            iChatHistoryApi.jumpChatHistoryActivity(this, new com.tencent.qqnt.chathistory.api.a(i3, String.valueOf(this.mPeerId), null, 0, 12, null));
            return;
        }
        Toast.makeText(this, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, 0).show();
    }

    private final void v3(int tab) {
        QRouteApi api = QRoute.api(IChatHistoryApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IChatHistoryApi::class.java)");
        IHistoryForwardApi iHistoryForwardApi = (IHistoryForwardApi) api;
        int i3 = this.mChatType;
        String str = this.mPeerId;
        if (str != null) {
            IHistoryForwardApi.a.a(iHistoryForwardApi, this, new com.tencent.qqnt.chathistory.api.a(i3, str, null, 0, 12, null), tab, null, 8, null);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void w3(com.tencent.qqnt.setting.troop.b intent) {
        if (this.viewModel != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopSettingDemoActivity$sendIntent$1(this, intent, null), 3, null);
        } else {
            Toast.makeText(this, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, 0).show();
        }
    }

    private final void x3(boolean isChecked) {
        GroupMsgMask groupMsgMask;
        if (isChecked) {
            groupMsgMask = GroupMsgMask.RECEIVE;
        } else {
            groupMsgMask = GroupMsgMask.NOTIFY;
        }
        y3(groupMsgMask);
    }

    private final void y3(GroupMsgMask mark) {
        w3(new b.f(mark));
        E3(mark);
    }

    private final void z3(boolean isChecked) {
        w3(new b.g(isChecked));
    }

    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.qqnt.base.BaseActivity
    public void initViewModel() {
        MutableLiveData<com.tencent.qqnt.setting.troop.a> obtainUiState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mChatType = getIntent().getIntExtra("key_chat_type", 1);
        this.mPeerId = getIntent().getStringExtra("key_peerId");
        this.mNick = getIntent().getStringExtra("key_chat_name");
        String str = this.mPeerId;
        if (str != null) {
            BaseViewModel<com.tencent.qqnt.setting.troop.a, com.tencent.qqnt.setting.troop.b> baseViewModel = (BaseViewModel) new ViewModelProvider(this, new c(str, this)).get(com.tencent.qqnt.setting.troop.g.class);
            this.viewModel = baseViewModel;
            if (baseViewModel != null && (obtainUiState = baseViewModel.obtainUiState()) != null) {
                final Function1<com.tencent.qqnt.setting.troop.a, Unit> function1 = new Function1<com.tencent.qqnt.setting.troop.a, Unit>() { // from class: com.tencent.qqnt.setting.TroopSettingDemoActivity$initViewModel$1$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSettingDemoActivity.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.setting.troop.a aVar) {
                        invoke2(aVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.qqnt.setting.troop.a it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        TroopSettingDemoActivity troopSettingDemoActivity = TroopSettingDemoActivity.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        troopSettingDemoActivity.s3(it);
                    }
                };
                obtainUiState.observe(this, new Observer() { // from class: com.tencent.qqnt.setting.m
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TroopSettingDemoActivity.t3(Function1.this, obj);
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        ai g16 = ai.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        setContentView(g16.getRoot());
        Y2();
        w3(b.d.f362186a);
        w3(b.C9699b.f362184a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
            w3(b.e.f362187a);
        }
    }
}
