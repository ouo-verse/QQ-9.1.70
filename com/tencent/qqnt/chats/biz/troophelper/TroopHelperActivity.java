package com.tencent.qqnt.chats.biz.troophelper;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.base.BaseActivity;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;
import pw3.j;

/* compiled from: P */
@RoutePage(desc = "\u7fa4\u52a9\u624b\u9875\u9762", path = "/base/main/troop_helper")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/chats/biz/troophelper/TroopHelperActivity;", "Lcom/tencent/qqnt/base/BaseActivity;", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "", "setEnterAnim", "setExitAnim", "initViewModel", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "finish", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "mChatsVM", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lpw3/j;", "_binding", "Lpw3/j;", "Lcom/tencent/qqnt/chats/biz/troophelper/c;", "mChatsVB", "Lcom/tencent/qqnt/chats/biz/troophelper/c;", "getMBinding", "()Lpw3/j;", "mBinding", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TroopHelperActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    @Nullable
    private j _binding;
    private c mChatsVB;
    private com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mChatsVM;

    public TroopHelperActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final View createView() {
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar;
        this._binding = j.g(getLayoutInflater());
        QUIBadgeDragLayout root = getMBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar2 = null;
        }
        c cVar = new c(aVar2, new d());
        this.mChatsVB = cVar;
        SkinnableRecycleView skinnableRecycleView = getMBinding().f427856b;
        Intrinsics.checkNotNullExpressionValue(skinnableRecycleView, "mBinding.chatsList");
        QUIBadgeDragLayout qUIBadgeDragLayout = getMBinding().f427857c;
        Intrinsics.checkNotNullExpressionValue(qUIBadgeDragLayout, "mBinding.dragArea");
        cVar.d0(new ChatsListVB.b(skinnableRecycleView, qUIBadgeDragLayout, null, this, null, null, null, null, 240, null));
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar3 = this.mChatsVM;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar3 = null;
        }
        c cVar2 = this.mChatsVB;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            cVar2 = null;
        }
        aVar3.d(cVar2);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar4 = this.mChatsVM;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        } else {
            aVar = aVar4;
        }
        aVar.o(b.c.f355083a);
        return root;
    }

    private final j getMBinding() {
        j jVar = this._binding;
        Intrinsics.checkNotNull(jVar);
        return jVar;
    }

    private final void setEnterAnim() {
        overridePendingTransition(R.anim.f154472lo, 0);
    }

    private final void setExitAnim() {
        overridePendingTransition(0, R.anim.f154473lp);
    }

    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.finish();
            setExitAnim();
        }
    }

    @Override // com.tencent.qqnt.base.BaseActivity
    public void initViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IChatsViewModelCreator.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IChatsViewModelCreator::class.java)");
        this.mChatsVM = (com.tencent.qqnt.chats.core.mvi.a) IChatsViewModelCreator.a.c((IChatsViewModelCreator) api, LifecycleOwnerKt.getLifecycleScope(this), this, null, null, 8, null);
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
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        createView();
        setEnterAnim();
        j jVar = this._binding;
        Intrinsics.checkNotNull(jVar);
        setContentView(jVar.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        c cVar = this.mChatsVB;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            cVar = null;
        }
        cVar.e0();
        super.onDestroy();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.d.f355084a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar2 = null;
        }
        c cVar3 = this.mChatsVB;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            cVar2 = cVar3;
        }
        aVar2.m(cVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.h.f355088a);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.i.f355089a);
    }
}
