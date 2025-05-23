package com.tencent.mobileqq.msf;

import android.content.Context;
import com.tencent.mobileqq.msf.core.startup.MSFServiceStartupStage;
import com.tencent.mobileqq.msf.core.startup.MSFStartupListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.NtStartup;
import com.tencent.qqnt.startup.e;
import com.tencent.qqnt.startup.parse.a;
import com.tencent.qqnt.startup.parse.c;
import com.tencent.qqnt.startup.parse.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/msf/MSFStartupDirector;", "", "Landroid/content/Context;", "context", "", "stageName", "Lcom/tencent/qqnt/startup/d;", "listener", "", "startStageReal", "", "Lcom/tencent/qqnt/startup/parse/a;", "getStageList", "Lcom/tencent/qqnt/startup/parse/c;", "getConfigReader", "Lcom/tencent/mobileqq/msf/core/startup/MSFStartupListener;", "onServiceInit", "mStageList", "Ljava/util/List;", "<init>", "()V", "Companion", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MSFStartupDirector {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "MSFStartupDirector";

    @NotNull
    private static final Lazy<MSFStartupDirector> ntDirector$delegate;

    @Nullable
    private List<a> mStageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/msf/MSFStartupDirector$Companion;", "", "()V", "TAG", "", "ntDirector", "Lcom/tencent/mobileqq/msf/MSFStartupDirector;", "getNtDirector$annotations", "getNtDirector", "()Lcom/tencent/mobileqq/msf/MSFStartupDirector;", "ntDirector$delegate", "Lkotlin/Lazy;", "startup_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final MSFStartupDirector getNtDirector() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MSFStartupDirector) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (MSFStartupDirector) MSFStartupDirector.ntDirector$delegate.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @JvmStatic
        public static /* synthetic */ void getNtDirector$annotations() {
        }
    }

    static {
        Lazy<MSFStartupDirector> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23675);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(MSFStartupDirector$Companion$ntDirector$2.INSTANCE);
        ntDirector$delegate = lazy;
    }

    public MSFStartupDirector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final c getConfigReader() {
        return new MSFStartupConfigReader();
    }

    @NotNull
    public static final MSFStartupDirector getNtDirector() {
        return INSTANCE.getNtDirector();
    }

    private final List<a> getStageList() {
        List<a> list = this.mStageList;
        if (list != null) {
            return list;
        }
        List<a> a16 = d.a(getConfigReader());
        this.mStageList = a16;
        return a16;
    }

    private final void startStageReal(Context context, String stageName, com.tencent.qqnt.startup.d listener) {
        Object obj;
        QLog.d(TAG, 1, "startStageReal, stageName:" + stageName + ", listener: " + listener);
        Iterator<T> it = getStageList().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((a) obj).b(), stageName)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        a aVar = (a) obj;
        if (aVar != null) {
            new NtStartup.a().c(new e(aVar, MSFStartupTaskAdapterFactory.INSTANCE)).a(listener).b(context).c();
        }
    }

    public final void onServiceInit(@NotNull Context context, @NotNull final MSFStartupListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        startStageReal(context, MSFServiceStartupStage.MSFServiceInit.name(), new com.tencent.qqnt.startup.d() { // from class: com.tencent.mobileqq.msf.MSFStartupDirector$onServiceInit$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MSFStartupListener.this);
                }
            }

            @Override // com.tencent.qqnt.startup.d
            public void onTasksComplete() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QLog.d("MSFStartupDirector", 1, "onTasksComplete");
                    MSFStartupListener.this.onTasksComplete();
                }
            }
        });
    }
}
