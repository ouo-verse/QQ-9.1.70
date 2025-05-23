package com.tencent.mobileqq.aio.panel.emoticon;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.aio.panel.emoticon.EmotionUIState;
import com.tencent.mobileqq.aio.panel.emoticon.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi;
import com.tencent.qqnt.aio.api.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/emoticon/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/panel/emoticon/b;", "Lcom/tencent/mobileqq/aio/panel/emoticon/EmotionUIState;", "Lpz0/b;", "Lcom/tencent/mobileqq/aio/panel/emoticon/EmotionUIState$SetOperationVisibility;", "state", "", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "b1", "bindViewAndData", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "c1", "", "isInMultiWindowMode", "", "Y", "(Z)Ljava/lang/Integer;", "Lcom/tencent/qqnt/aio/api/e;", "d", "Lcom/tencent/qqnt/aio/api/e;", "panelProvider", "<init>", "()V", "e", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends com.tencent.aio.base.mvvm.a<b, EmotionUIState> implements pz0.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private e panelProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/emoticon/c$a;", "", "", "EMO_PANEL_HEIGHT_SCALE", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.emoticon.c$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64453);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // pz0.b
    @Nullable
    public Integer Y(boolean isInMultiWindowMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Integer) iPatchRedirector.redirect((short) 7, (Object) this, isInMultiWindowMode);
        }
        if (QQTheme.isNowSimpleUI()) {
            return Integer.valueOf((int) (getMContext().getResources().getDisplayMetrics().heightPixels * 0.455f));
        }
        return null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<b, EmotionUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.bindViewAndData();
        e eVar = this.panelProvider;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelProvider");
            eVar = null;
        }
        sendIntent(new b.d(eVar));
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull EmotionUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof EmotionUIState.SetOperationVisibility) {
            d1((EmotionUIState.SetOperationVisibility) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        this.panelProvider = ((IAIOEmoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoPanelApi.class)).getPanelProvider(createViewParams.a());
        e eVar = null;
        if (QLog.isColorLevel()) {
            e eVar2 = this.panelProvider;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelProvider");
                eVar2 = null;
            }
            QLog.d("EmotionPanelVB", 2, "[onCreateView] panelProvider=" + eVar2.hashCode());
        }
        e eVar3 = this.panelProvider;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelProvider");
        } else {
            eVar = eVar3;
        }
        return eVar.createView();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        e eVar = this.panelProvider;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelProvider");
            eVar = null;
        }
        sendIntent(new b.d(eVar));
    }

    private final void d1(EmotionUIState.SetOperationVisibility state) {
    }
}
