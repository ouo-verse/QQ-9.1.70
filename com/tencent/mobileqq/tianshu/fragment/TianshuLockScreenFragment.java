package com.tencent.mobileqq.tianshu.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.bean.TianshuLockScreenBean;
import com.tencent.mobileqq.tianshu.part.TianshuLockScreenContentPart;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0014J\b\u0010\f\u001a\u00020\u0006H\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/tianshu/fragment/TianshuLockScreenFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "getDuration", "", "uh", "", "th", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getContentLayoutId", "getStatusBarColor", "", "needSupportFullScreen", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onCreate", "Lcom/tencent/mobileqq/tianshu/bean/TianshuLockScreenBean;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "sh", "()Lcom/tencent/mobileqq/tianshu/bean/TianshuLockScreenBean;", "initBean", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "dismissRunnable", "<init>", "()V", "E", "a", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TianshuLockScreenFragment extends ImmersivePartFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy initBean;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Runnable dismissRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/tianshu/fragment/TianshuLockScreenFragment$a;", "", "", "KEY_INIT_BEAN", "Ljava/lang/String;", "", "MAX_HOLDLOCK_TIME", "I", "TAG", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianshu.fragment.TianshuLockScreenFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22315);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TianshuLockScreenFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TianshuLockScreenBean>() { // from class: com.tencent.mobileqq.tianshu.fragment.TianshuLockScreenFragment$initBean$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TianshuLockScreenFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final TianshuLockScreenBean invoke() {
                    Intent intent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TianshuLockScreenBean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FragmentActivity activity = TianshuLockScreenFragment.this.getActivity();
                    TianshuLockScreenBean tianshuLockScreenBean = (activity == null || (intent = activity.getIntent()) == null) ? null : (TianshuLockScreenBean) intent.getParcelableExtra("init_bean");
                    if (tianshuLockScreenBean instanceof TianshuLockScreenBean) {
                        return tianshuLockScreenBean;
                    }
                    return null;
                }
            });
            this.initBean = lazy;
            this.dismissRunnable = new Runnable() { // from class: com.tencent.mobileqq.tianshu.fragment.a
                @Override // java.lang.Runnable
                public final void run() {
                    TianshuLockScreenFragment.rh(TianshuLockScreenFragment.this);
                }
            };
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final long getDuration() {
        long j3;
        TianshuLockScreenBean sh5 = sh();
        if (sh5 != null) {
            j3 = sh5.g();
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            return 30L;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(TianshuLockScreenFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            activity.finish();
        }
    }

    private final TianshuLockScreenBean sh() {
        return (TianshuLockScreenBean) this.initBean.getValue();
    }

    private final int th() {
        int i3;
        ContentResolver contentResolver;
        try {
            Context context = getContext();
            if (context != null) {
                contentResolver = context.getContentResolver();
            } else {
                contentResolver = null;
            }
            i3 = Settings.System.getInt(contentResolver, "screen_off_timeout");
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TianshuLockScreenFragment", 4, "getScreenOffTime e=" + e16.getMessage());
            }
            i3 = 10000;
        }
        QLog.d("TianshuLockScreenFragment", 4, "getScreenOffTime " + i3);
        if (i3 > 30000) {
            return 30000;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh() {
        Object obj;
        Context context = getContext();
        PowerManager.WakeLock wakeLock = null;
        String str = null;
        if (context != null) {
            obj = context.getSystemService("power");
        } else {
            obj = null;
        }
        PowerManager powerManager = (PowerManager) obj;
        if (powerManager != null) {
            StringBuilder sb5 = new StringBuilder();
            Context context2 = getContext();
            if (context2 != null) {
                str = context2.getPackageName();
            }
            sb5.append(str);
            sb5.append(":TianshuLockScreenFragment");
            wakeLock = powerManager.newWakeLock(268435462, sb5.toString());
        }
        if (wakeLock != null) {
            wakeLock.acquire(th());
        }
        if (wakeLock != null) {
            wakeLock.release();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TianshuLockScreenContentPart());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.hxi;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        if (window != null) {
            window.addFlags(524288);
        }
        if (window != null) {
            window.addFlags(128);
        }
        if (window != null) {
            window.addFlags(4194304);
        }
        if (window != null) {
            window.addFlags(2097152);
        }
        com.tencent.mobileqq.qui.b.f276860a.l(window);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tianshu.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                TianshuLockScreenFragment.this.uh();
            }
        }, 100L);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            RFWThreadManager.getUIHandler().removeCallbacks(this.dismissRunnable);
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RFWThreadManager.getUIHandler().postDelayed(this.dismissRunnable, getDuration() * 1000);
    }
}
