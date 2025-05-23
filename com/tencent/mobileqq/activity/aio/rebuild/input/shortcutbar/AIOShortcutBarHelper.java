package com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.troop.shortcutbar.adapter.TroopShortcutBarEvent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class AIOShortcutBarHelper implements h, c, com.tencent.aio.api.help.b, g {

    /* renamed from: d, reason: collision with root package name */
    private View f179838d;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f179840f;

    /* renamed from: h, reason: collision with root package name */
    private AIOShortcutBarLogic f179841h;

    /* renamed from: e, reason: collision with root package name */
    private int f179839e = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f179842i = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f179843m = false;
    private volatile boolean C = false;
    private final Handler D = new Handler(Looper.getMainLooper());
    private com.tencent.mvi.base.route.a E = new a();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NonNull MsgIntent msgIntent) {
            if (AIOShortcutBarHelper.this.C) {
                return;
            }
            if (msgIntent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
                if (AIOShortcutBarHelper.this.e() == 3) {
                    AIOShortcutBarHelper.this.f179841h.o(((InputEditTextMsgIntent.EditTextChangedMsgIntent) msgIntent).c());
                    return;
                }
                return;
            }
            if (msgIntent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
                QLog.i("AIOShortcutBarHelper", 1, "OnPanelStateChangedMsgIntent isPanelShow = " + AIOShortcutBarHelper.this.f179842i + " isKeyboardShow = " + AIOShortcutBarHelper.this.f179843m);
                AIOShortcutBarHelper.this.f179842i = ((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msgIntent).b();
                AIOShortcutBarHelper.this.F();
                return;
            }
            if (msgIntent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
                QLog.i("AIOShortcutBarHelper", 1, "OnKeyboardStateChanged isPanelShow = " + AIOShortcutBarHelper.this.f179842i + " isKeyboardShow = " + AIOShortcutBarHelper.this.f179843m);
                AIOShortcutBarHelper.this.f179843m = ((KeyboardMsgIntent.OnKeyboardStateChanged) msgIntent).b();
                AIOShortcutBarHelper.this.F();
                return;
            }
            if (msgIntent instanceof AIOMsgListEvent.InputToolBarChanged) {
                AIOShortcutBarHelper.this.G(((AIOMsgListEvent.InputToolBarChanged) msgIntent).a());
                return;
            }
            if (msgIntent instanceof MsgNavigationEvent.ClickNavigationEvent) {
                AIOShortcutBarHelper.this.E();
                return;
            }
            if (msgIntent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
                AIOShortcutBarHelper.this.D(((AIOMsgListEvent.MultiSelectModeChangeEvent) msgIntent).b());
            } else if (msgIntent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
                AIOShortcutBarHelper.this.D(((AIOMsgListEvent.LongShotModeChangeEvent) msgIntent).b());
            } else if (msgIntent instanceof MsgItemExternalRefreshEvent.EnterAIOAnimationEnd) {
                AIOShortcutBarHelper.this.C();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void onVisibilityChanged(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        y(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSelectMode", z16);
        z(28, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        y(29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        QLog.i("AIOShortcutBarHelper", 1, "onPanelChanged isPanelShow = " + this.f179842i + " isKeyboardShow = " + this.f179843m);
        Bundle bundle = new Bundle();
        if (!this.f179842i && !this.f179843m) {
            bundle.putBoolean("InputJump", false);
            z(12, bundle);
        } else {
            bundle.putBoolean("InputJump", true);
            z(11, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(boolean z16) {
        QLog.i("AIOShortcutBarHelper", 1, "onShortCutBarChanged needHide = " + z16);
        Bundle bundle = new Bundle();
        if (z16) {
            bundle.putBoolean("InputJump", true);
            z(11, bundle);
        } else {
            bundle.putBoolean("InputJump", false);
            z(12, bundle);
        }
    }

    private void I() {
        H(this.f179838d);
        this.f179838d = null;
        this.f179839e = 0;
    }

    public int A() {
        return this.f179839e;
    }

    public int B() {
        View view = this.f179838d;
        if (view == null) {
            return 8;
        }
        return view.getVisibility();
    }

    public void H(View view) {
        com.tencent.aio.api.runtime.a aVar;
        if (view != null && (aVar = this.f179840f) != null) {
            aVar.e().h(new TroopShortcutBarEvent.RemoveShortcutView(view));
        }
    }

    public void L(int i3, View view, ViewGroup.LayoutParams layoutParams) {
        com.tencent.aio.api.runtime.a aVar;
        this.f179838d = view;
        this.f179839e = i3;
        if (view != null && (aVar = this.f179840f) != null) {
            aVar.e().h(new TroopShortcutBarEvent.SetShortcutView(i3, view, layoutParams));
        }
    }

    public void M(int i3) {
        View view = this.f179838d;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.c
    public com.tencent.aio.api.runtime.a a() {
        return this.f179840f;
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.c
    public boolean b() {
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.c
    public int e() {
        com.tencent.aio.api.runtime.a aVar = this.f179840f;
        if (aVar == null) {
            return 0;
        }
        int e16 = aVar.g().r().c().e();
        if (e16 == 1) {
            return 1;
        }
        if (e16 != 2) {
            return 0;
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.c
    public Activity getActivity() {
        com.tencent.aio.api.runtime.a aVar = this.f179840f;
        if (aVar == null) {
            return null;
        }
        return aVar.c().getActivity();
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.c
    public AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.c
    public Context getContext() {
        if (getActivity() == null) {
            return BaseApplication.getContext();
        }
        return getActivity();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350649l;
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.c
    public SessionInfo getSessionInfo() {
        return null;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendBeforeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendAfterEvent");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.EnterAIOAnimationEnd");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.InputToolBarChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.MsgNavigationEvent.ClickNavigationEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NonNull
    public String getTag() {
        return "AIOShortcutBarHelper";
    }

    @Override // com.tencent.aio.api.help.b
    public void h(@NonNull com.tencent.aio.main.businesshelper.b bVar) {
        this.D.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (AIOShortcutBarHelper.this.f179840f == null) {
                    QLog.e("AIOShortcutBarHelper", 1, "onCreateAsync: mAIOContext is null");
                } else {
                    if (AIOShortcutBarHelper.this.f179840f.e() == null) {
                        QLog.e("AIOShortcutBarHelper", 1, "onCreateAsync: messenger is null");
                        return;
                    }
                    j e16 = AIOShortcutBarHelper.this.f179840f.e();
                    AIOShortcutBarHelper aIOShortcutBarHelper = AIOShortcutBarHelper.this;
                    e16.f(aIOShortcutBarHelper, aIOShortcutBarHelper.E);
                }
            }
        });
    }

    @Override // com.tencent.aio.api.help.b
    public void i() {
        this.D.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (AIOShortcutBarHelper.this.f179840f == null) {
                    QLog.e("AIOShortcutBarHelper", 1, "onDestroyAsync: mAIOContext is null");
                    return;
                }
                if (AIOShortcutBarHelper.this.f179840f.e() == null) {
                    QLog.e("AIOShortcutBarHelper", 1, "onDestroyAsync: messenger is null");
                    return;
                }
                j e16 = AIOShortcutBarHelper.this.f179840f.e();
                AIOShortcutBarHelper aIOShortcutBarHelper = AIOShortcutBarHelper.this;
                e16.i(aIOShortcutBarHelper, aIOShortcutBarHelper.E);
                AIOShortcutBarHelper.this.f179840f = null;
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3, 11, 12, 8};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NonNull com.tencent.aio.main.businesshelper.b bVar) {
        this.C = false;
        this.f179840f = bVar.a();
        this.f179841h = new AIOShortcutBarLogic(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        this.C = true;
        y(4);
        y(5);
        I();
        this.f179841h = null;
        this.f179842i = false;
        this.f179843m = false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int i3) {
        if (this.f179841h == null) {
            return;
        }
        if (i3 != 3) {
            if (i3 == 8) {
                y(30);
                return;
            }
            return;
        }
        y(3);
    }

    public void y(int i3) {
        z(i3, new Bundle());
    }

    protected void z(int i3, Bundle bundle) {
        AIOShortcutBarLogic aIOShortcutBarLogic = this.f179841h;
        if (aIOShortcutBarLogic == null) {
            return;
        }
        aIOShortcutBarLogic.f(i3, bundle);
    }

    public void J() {
    }

    public void K() {
    }

    public void N() {
    }

    public void O() {
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.c
    public void c() {
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.c
    public void g() {
    }
}
