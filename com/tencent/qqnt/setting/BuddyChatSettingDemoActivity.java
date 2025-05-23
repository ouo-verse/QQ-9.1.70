package com.tencent.qqnt.setting;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqnt.base.BaseActivity;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.chathistory.api.IHistoryForwardApi;
import com.tencent.qqnt.kernel.nativeinterface.RelationFlag;
import com.tencent.qqnt.setting.buddy.a;
import com.tencent.qqnt.setting.buddy.b;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0012\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010\"\u001a\u00020\u0002H\u0014R\u0016\u0010%\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/setting/BuddyChatSettingDemoActivity;", "Lcom/tencent/qqnt/base/BaseActivity;", "", "U2", "", "isDelRoamMsg", "h3", "p3", "isChecked", "x3", "w3", "t3", "u3", "Landroid/widget/CheckBox;", "checkBox", "isEnabled", "v3", "Lcom/tencent/qqnt/setting/buddy/b;", "intent", ICustomDataEditor.STRING_PARAM_3, "Lcom/tencent/qqnt/setting/buddy/a;", "state", "l3", "Lcom/tencent/qqnt/setting/buddy/a$b;", "j3", "Lcom/tencent/qqnt/setting/buddy/a$a;", "i3", "", "tab", "r3", "initViewModel", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "b0", "I", "mChatType", "", "c0", "Ljava/lang/String;", "mPeerId", "d0", "mNick", "Lw71/z;", "e0", "Lw71/z;", "binding", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "f0", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "viewModel", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class BuddyChatSettingDemoActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int mChatType;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mPeerId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mNick;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private z binding;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseViewModel<com.tencent.qqnt.setting.buddy.a, com.tencent.qqnt.setting.buddy.b> viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/setting/BuddyChatSettingDemoActivity$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f362127a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BuddyChatSettingDemoActivity f362128b;

        a(String str, BuddyChatSettingDemoActivity buddyChatSettingDemoActivity) {
            this.f362127a = str;
            this.f362128b = buddyChatSettingDemoActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) buddyChatSettingDemoActivity);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new com.tencent.qqnt.setting.buddy.k(this.f362127a, this.f362128b.mChatType);
        }
    }

    public BuddyChatSettingDemoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mChatType = 1;
        }
    }

    private final void U2() {
        z zVar = this.binding;
        z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar = null;
        }
        zVar.f444937b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.Y2(BuddyChatSettingDemoActivity.this, view);
            }
        });
        z zVar3 = this.binding;
        if (zVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar3 = null;
        }
        zVar3.f444946k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.Z2(BuddyChatSettingDemoActivity.this, view);
            }
        });
        z zVar4 = this.binding;
        if (zVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar4 = null;
        }
        zVar4.f444944i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.b3(BuddyChatSettingDemoActivity.this, view);
            }
        });
        z zVar5 = this.binding;
        if (zVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar5 = null;
        }
        zVar5.f444945j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.c3(BuddyChatSettingDemoActivity.this, view);
            }
        });
        z zVar6 = this.binding;
        if (zVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar6 = null;
        }
        zVar6.f444938c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.d3(BuddyChatSettingDemoActivity.this, view);
            }
        });
        z zVar7 = this.binding;
        if (zVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar7 = null;
        }
        zVar7.f444943h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.e3(BuddyChatSettingDemoActivity.this, view);
            }
        });
        z zVar8 = this.binding;
        if (zVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar8 = null;
        }
        zVar8.f444939d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.f3(BuddyChatSettingDemoActivity.this, view);
            }
        });
        z zVar9 = this.binding;
        if (zVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar9 = null;
        }
        zVar9.f444942g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.g3(BuddyChatSettingDemoActivity.this, view);
            }
        });
        z zVar10 = this.binding;
        if (zVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar10 = null;
        }
        zVar10.f444941f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.V2(BuddyChatSettingDemoActivity.this, view);
            }
        });
        z zVar11 = this.binding;
        if (zVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            zVar2 = zVar11;
        }
        zVar2.f444940e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.setting.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BuddyChatSettingDemoActivity.W2(BuddyChatSettingDemoActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r3(4);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r3(5);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p3();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z2(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z zVar = this$0.binding;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar = null;
        }
        this$0.x3(zVar.f444946k.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b3(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z zVar = this$0.binding;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar = null;
        }
        this$0.t3(zVar.f444944i.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c3(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z zVar = this$0.binding;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar = null;
        }
        this$0.w3(zVar.f444945j.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d3(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h3(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e3(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r3(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f3(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r3(2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(BuddyChatSettingDemoActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r3(3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h3(boolean isDelRoamMsg) {
        s3(new b.a(isDelRoamMsg));
    }

    private final void i3(a.C9696a state) {
        if (state.a()) {
            Toast.makeText(this, "\u5220\u9664\u6210\u529f", 0).show();
        } else {
            Toast.makeText(this, "\u5220\u9664\u5931\u8d25", 0).show();
        }
    }

    private final void j3(a.b state) {
        boolean z16;
        RelationFlag relationFlag = state.a().relationFlags;
        if (relationFlag != null) {
            z zVar = this.binding;
            z zVar2 = null;
            if (zVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                zVar = null;
            }
            CheckBox checkBox = zVar.f444946k;
            if (relationFlag.topTime > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            checkBox.setChecked(z16);
            z zVar3 = this.binding;
            if (zVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                zVar3 = null;
            }
            zVar3.f444944i.setChecked(relationFlag.isBlock);
            z zVar4 = this.binding;
            if (zVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                zVar2 = zVar4;
            }
            zVar2.f444945j.setChecked(relationFlag.isMsgDisturb);
            u3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l3(com.tencent.qqnt.setting.buddy.a state) {
        if (state instanceof a.b) {
            j3((a.b) state);
        } else if (state instanceof a.C9696a) {
            i3((a.C9696a) state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void p3() {
        if (this.mPeerId != null && this.mChatType != 0) {
            Navigator createNavigator = QRoute.createNavigator(this, "/base/chathistory/main");
            int i3 = 1;
            if (this.mChatType != 1) {
                i3 = 2;
            }
            createNavigator.withInt("nt_chat_history_chatType", i3).withString("nt_chat_history_peerId", String.valueOf(this.mPeerId)).request();
            return;
        }
        Toast.makeText(this, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, 0).show();
    }

    private final void r3(int tab) {
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

    private final void s3(com.tencent.qqnt.setting.buddy.b intent) {
        if (this.viewModel != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BuddyChatSettingDemoActivity$sendIntent$1(this, intent, null), 3, null);
        } else {
            Toast.makeText(this, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, 0).show();
        }
    }

    private final void t3(boolean isChecked) {
        s3(new b.f(isChecked));
        u3();
    }

    private final void u3() {
        z zVar = this.binding;
        z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zVar = null;
        }
        CheckBox checkBox = zVar.f444945j;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.cbDisturb");
        z zVar3 = this.binding;
        if (zVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            zVar2 = zVar3;
        }
        v3(checkBox, !zVar2.f444944i.isChecked());
    }

    private final void v3(CheckBox checkBox, boolean isEnabled) {
        String str;
        if (isEnabled) {
            str = "#FF000000";
        } else {
            str = "#FF999999";
        }
        checkBox.setTextColor(Color.parseColor(str));
        checkBox.setEnabled(isEnabled);
    }

    private final void w3(boolean isChecked) {
        s3(new b.g(isChecked));
    }

    private final void x3(boolean isChecked) {
        s3(new b.i(isChecked));
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
        MutableLiveData<com.tencent.qqnt.setting.buddy.a> obtainUiState;
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
            BaseViewModel<com.tencent.qqnt.setting.buddy.a, com.tencent.qqnt.setting.buddy.b> baseViewModel = (BaseViewModel) new ViewModelProvider(this, new a(str, this)).get(com.tencent.qqnt.setting.buddy.k.class);
            this.viewModel = baseViewModel;
            if (baseViewModel != null && (obtainUiState = baseViewModel.obtainUiState()) != null) {
                final Function1<com.tencent.qqnt.setting.buddy.a, Unit> function1 = new Function1<com.tencent.qqnt.setting.buddy.a, Unit>() { // from class: com.tencent.qqnt.setting.BuddyChatSettingDemoActivity$initViewModel$1$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyChatSettingDemoActivity.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.setting.buddy.a aVar) {
                        invoke2(aVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.qqnt.setting.buddy.a it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        BuddyChatSettingDemoActivity buddyChatSettingDemoActivity = BuddyChatSettingDemoActivity.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        buddyChatSettingDemoActivity.l3(it);
                    }
                };
                obtainUiState.observe(this, new Observer() { // from class: com.tencent.qqnt.setting.a
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BuddyChatSettingDemoActivity.n3(Function1.this, obj);
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
        z g16 = z.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        setContentView(g16.getRoot());
        U2();
        s3(b.d.f362145a);
        s3(b.C9697b.f362143a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
            s3(b.e.f362146a);
        }
    }
}
