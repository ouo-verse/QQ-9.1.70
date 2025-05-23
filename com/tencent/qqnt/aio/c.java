package com.tencent.qqnt.aio;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.localactivity.AIOLocalActivity;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010+\u001a\u00020'\u00a2\u0006\u0004\b0\u00101J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\"\u0010&\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016R\u0017\u0010+\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/aio/c;", "Lcom/tencent/qqnt/aio/activity/j;", "Landroid/app/LocalActivityManager;", "j", "Landroid/view/Window;", "window", "", "k", "i", "Landroid/view/View;", "show", "hide", "", "e", "getAIORootView", "", "state", "d", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "a", "", "actionCode", "Lcom/tencent/aio/runtime/message/b;", "action", tl.h.F, "g", "c", "Lcom/tencent/aio/data/AIOContact;", "getAIOContact", "isEnable", "b", "f", "clearAIOCache", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/qqnt/aio/e;", "Lcom/tencent/qqnt/aio/e;", "getMAioContainer", "()Lcom/tencent/qqnt/aio/e;", "mAioContainer", "Landroid/app/LocalActivityManager;", "mLocalActivityManager", "Landroid/view/View;", "mTargetDecorView", "<init>", "(Lcom/tencent/qqnt/aio/e;)V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c implements com.tencent.qqnt.aio.activity.j {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mAioContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LocalActivityManager mLocalActivityManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mTargetDecorView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/c$a;", "", "", "AIO_LOCAL_ACTIVITY_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.c$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull e mAioContainer) {
        Intrinsics.checkNotNullParameter(mAioContainer, "mAioContainer");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mAioContainer);
        } else {
            this.mAioContainer = mAioContainer;
        }
    }

    private final com.tencent.qqnt.aio.activity.j i() {
        Activity activity;
        AIOLocalActivity aIOLocalActivity;
        LocalActivityManager j3 = j();
        if (j3 != null) {
            activity = j3.getActivity("aioLocalActivity");
        } else {
            activity = null;
        }
        if (activity instanceof AIOLocalActivity) {
            aIOLocalActivity = (AIOLocalActivity) activity;
        } else {
            aIOLocalActivity = null;
        }
        if (aIOLocalActivity == null) {
            return null;
        }
        return aIOLocalActivity.I2();
    }

    private final LocalActivityManager j() {
        Activity activity;
        Context context = this.mAioContainer.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            return null;
        }
        if (this.mLocalActivityManager == null) {
            LocalActivityManager localActivityManager = new LocalActivityManager(activity, true);
            this.mLocalActivityManager = localActivityManager;
            localActivityManager.dispatchCreate(null);
            LocalActivityManager localActivityManager2 = this.mLocalActivityManager;
            if (localActivityManager2 != null) {
                localActivityManager2.dispatchResume();
            }
        }
        return this.mLocalActivityManager;
    }

    private final void k(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            int i3 = attributes.softInputMode;
            if ((i3 & 255) != 18) {
                window.setSoftInputMode((i3 & (-256)) | 18);
            }
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void a(@NotNull MsgIntent intent) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        LocalActivityManager j3 = j();
        AIOLocalActivity aIOLocalActivity = null;
        if (j3 != null) {
            activity = j3.getActivity("aioLocalActivity");
        } else {
            activity = null;
        }
        if (activity instanceof AIOLocalActivity) {
            aIOLocalActivity = (AIOLocalActivity) activity;
        }
        if (aIOLocalActivity == null) {
            return;
        }
        aIOLocalActivity.sendMessage(intent);
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void b(boolean isEnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, isEnable);
            return;
        }
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 != null) {
            i3.b(isEnable);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 != null) {
            return i3.c();
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void clearAIOCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 != null) {
            i3.clearAIOCache();
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void d(int state) {
        QBaseActivity qBaseActivity;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
            return;
        }
        if (this.mTargetDecorView == null) {
            QLog.d("AIOLocalActivityProxy", 1, "[dispatchLifeCycleState]:" + state + "\uff0cmTargetDecorView is empty," + hashCode());
            return;
        }
        try {
            Context context = this.mAioContainer.getContext();
            if (context instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) context;
            } else {
                qBaseActivity = null;
            }
            LocalActivityManager j3 = j();
            if (j3 == null) {
                QLog.i("AIOLocalActivityProxy", 1, "[dispatchLifeCycleState]: localActivity is null");
                return;
            }
            if (state != 2) {
                if (state != 3) {
                    if (state != 4) {
                        if (state == 5) {
                            j3.dispatchDestroy(true);
                            return;
                        }
                        return;
                    }
                    j3.dispatchStop();
                    return;
                }
                if (qBaseActivity != null && qBaseActivity.isFinishing()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                j3.dispatchPause(z16);
                return;
            }
            j3.dispatchResume();
        } catch (Exception e16) {
            QLog.e("AIOLocalActivityProxy", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 != null) {
            return i3.e();
        }
        QLog.i("AIOLocalActivityProxy", 1, "[isAIOShow]: aioProxy is null");
        return false;
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 != null) {
            return i3.f();
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void g(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, state);
            return;
        }
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 != null) {
            i3.g(state);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    @NotNull
    public AIOContact getAIOContact() {
        AIOContact aIOContact;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AIOContact) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 == null || (aIOContact = i3.getAIOContact()) == null) {
            return new AIOContact(0, "", "", null, 8, null);
        }
        return aIOContact;
    }

    @Override // com.tencent.qqnt.aio.activity.j
    @NotNull
    public View getAIORootView() {
        View aIORootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 == null || (aIORootView = i3.getAIORootView()) == null) {
            return new View(this.mAioContainer.getContext());
        }
        return aIORootView;
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void h(@NotNull String actionCode, @NotNull com.tencent.aio.runtime.message.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 != null) {
            i3.h(actionCode, action);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("AIOLocalActivityProxy", 1, "[hide]");
        d(3);
        d(4);
        com.tencent.qqnt.aio.activity.j i3 = i();
        if (i3 != null) {
            i3.hide();
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        LocalActivityManager j3 = j();
        AIOLocalActivity aIOLocalActivity = null;
        if (j3 != null) {
            activity = j3.getActivity("aioLocalActivity");
        } else {
            activity = null;
        }
        if (activity instanceof AIOLocalActivity) {
            aIOLocalActivity = (AIOLocalActivity) activity;
        }
        if (aIOLocalActivity != null) {
            aIOLocalActivity.dispatchOnActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    @NotNull
    public View show() {
        Window window;
        View view;
        QBaseActivity qBaseActivity;
        Activity activity;
        AIOLocalActivity aIOLocalActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Intent intent = new Intent(this.mAioContainer.getContext(), (Class<?>) AIOLocalActivity.class);
        intent.putExtras(this.mAioContainer.getIntent());
        QLog.i("AIOLocalActivityProxy", 1, "[startAIO]: data is " + com.tencent.qqnt.aio.utils.b.a(intent.getExtras()));
        LocalActivityManager j3 = j();
        Window window2 = null;
        if (j3 != null) {
            window = j3.startActivity("aioLocalActivity", intent);
        } else {
            window = null;
        }
        if (window != null && (view = window.getDecorView()) != null) {
            view.requestFocus();
        } else {
            view = null;
        }
        this.mTargetDecorView = view;
        Context context = this.mAioContainer.getContext();
        if (context instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) context;
        } else {
            qBaseActivity = null;
        }
        LocalActivityManager j16 = j();
        if (j16 != null) {
            activity = j16.getActivity("aioLocalActivity");
        } else {
            activity = null;
        }
        if (activity instanceof AIOLocalActivity) {
            aIOLocalActivity = (AIOLocalActivity) activity;
        } else {
            aIOLocalActivity = null;
        }
        if (aIOLocalActivity != null) {
            aIOLocalActivity.K2(qBaseActivity);
        }
        if (window != null) {
            k(window);
        }
        if (qBaseActivity != null) {
            window2 = qBaseActivity.getWindow();
        }
        if (window2 != null) {
            k(window2);
        }
        d(2);
        View view2 = this.mTargetDecorView;
        Intrinsics.checkNotNull(view2);
        return view2;
    }
}
