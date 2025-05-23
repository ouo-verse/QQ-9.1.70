package com.tencent.mobileqq.cardcontainer.api;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.cardcontainer.g;
import com.tencent.mobileqq.cardcontainer.h;
import com.tencent.mobileqq.cardcontainer.i;
import com.tencent.mobileqq.cardcontainer.j;
import com.tencent.mobileqq.cardcontainer.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017J:\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/cardcontainer/g;", "viewModel", "Lcom/tencent/mobileqq/cardcontainer/j;", "daTongReportDelegate", "Lcom/tencent/mobileqq/cardcontainer/k;", "parentScrollHelper", "Lcom/tencent/mobileqq/cardcontainer/h;", "listener", "Lcom/tencent/mobileqq/cardcontainer/i;", "createCardContainerView", "Landroidx/lifecycle/ViewModelStoreOwner;", "store", "getViewModel", "", "preloadCardContainerData", "startDemoActivity", "Companion", "a", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface ICardContainerApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final int CARD_CONTAINER_VIEW_HEIGHT_DP = 168;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerApi$a;", "", "<init>", "()V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.api.ICardContainerApi$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f201033a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36167);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f201033a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(36169), (Class<?>) ICardContainerApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f201033a;
        }
    }

    @NotNull
    i createCardContainerView(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull g viewModel, @NotNull j daTongReportDelegate, @Nullable k parentScrollHelper, @NotNull h listener);

    @NotNull
    g getViewModel(@NotNull ViewModelStoreOwner store);

    void preloadCardContainerData();

    void startDemoActivity(@NotNull Context context);
}
