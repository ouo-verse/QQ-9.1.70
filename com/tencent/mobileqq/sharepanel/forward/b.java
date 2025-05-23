package com.tencent.mobileqq.sharepanel.forward;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/b;", "Lcom/tencent/mobileqq/sharepanel/forward/g;", "", "show", "dismiss", "Lcom/tencent/mobileqq/sharepanel/forward/a;", "eventListener", "b", "Lcom/tencent/mobileqq/sharepanel/forward/e;", "reportDelegate", "a", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "activityRef", "Lcom/tencent/mobileqq/sharepanel/forward/c;", "Lcom/tencent/mobileqq/sharepanel/forward/c;", "launcher", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "c", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/forward/f;", "uiControl", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/ArrayList;Lcom/tencent/mobileqq/sharepanel/forward/f;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FragmentActivity> activityRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c launcher;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d param;

    public b(@NotNull FragmentActivity activity, @NotNull ArrayList<SharePanelContactItem> targetList, @NotNull f uiControl) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(uiControl, "uiControl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, targetList, uiControl);
        } else {
            this.activityRef = new WeakReference<>(activity);
            this.param = new d(targetList, uiControl);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.g
    @NotNull
    public g a(@NotNull e reportDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (g) iPatchRedirector.redirect((short) 5, (Object) this, (Object) reportDelegate);
        }
        Intrinsics.checkNotNullParameter(reportDelegate, "reportDelegate");
        this.param.f(reportDelegate);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.g
    @NotNull
    public g b(@NotNull a eventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (g) iPatchRedirector.redirect((short) 4, (Object) this, (Object) eventListener);
        }
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.param.e(eventListener);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.g
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        c cVar = this.launcher;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.g
    public void show() {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.launcher == null) {
            this.launcher = new c();
        }
        FragmentActivity fragmentActivity = this.activityRef.get();
        if (fragmentActivity != null && (cVar = this.launcher) != null) {
            cVar.c(fragmentActivity, this.param);
        }
    }
}
