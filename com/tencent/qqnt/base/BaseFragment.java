package com.tencent.qqnt.base;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqnt.base.lifecycle.a;
import com.tencent.qqnt.base.lifecycle.c;
import com.tencent.qqnt.base.lifecycle.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "", "initViewModel", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Lcom/tencent/qqnt/base/lifecycle/c;", "qh", "Lcom/tencent/qqnt/base/lifecycle/a;", "ph", "Lcom/tencent/qqnt/base/BaseActivity;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/base/BaseActivity;", "mActivity", "Lcom/tencent/qqnt/base/lifecycle/f;", "D", "Lcom/tencent/qqnt/base/lifecycle/f;", "lifecycleHelper", "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BaseFragment extends ReportAndroidXFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private BaseActivity mActivity;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private f lifecycleHelper;

    public BaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.lifecycleHelper == null) {
            this.lifecycleHelper = new f();
        }
        f fVar = this.lifecycleHelper;
        Intrinsics.checkNotNull(fVar);
        Lifecycle lifecycle = super.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "super.getLifecycle()");
        return fVar.a(this, lifecycle, qh(), ph());
    }

    public abstract void initViewModel();

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            initViewModel();
        }
    }

    @NotNull
    public a ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return a.INSTANCE.a();
    }

    @NotNull
    public c qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (c) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return c.INSTANCE.a();
    }
}
