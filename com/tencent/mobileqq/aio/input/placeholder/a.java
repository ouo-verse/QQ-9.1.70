package com.tencent.mobileqq.aio.input.placeholder;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.placeholder.AIOInputPlaceholderUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.lazy.FrameLayoutLazyVB;
import com.tencent.qqnt.base.utils.c;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/input/placeholder/a;", "Lcom/tencent/qqnt/aio/lazy/FrameLayoutLazyVB;", "Lol3/b;", "Lcom/tencent/mobileqq/aio/input/placeholder/AIOInputPlaceholderUIState;", "", "k1", "Landroid/view/ViewGroup$LayoutParams;", "e1", "Lcom/tencent/aio/base/mvvm/b;", "j1", "state", "l1", "Landroid/widget/RelativeLayout;", h.F, "Landroid/widget/RelativeLayout;", "mInputPlaceHolder", "<init>", "()V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends FrameLayoutLazyVB<ol3.b, AIOInputPlaceholderUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mInputPlaceHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/input/placeholder/a$a;", "", "", "AIO_INPUT_PLACEHOLDER_ENABLE", "Ljava/lang/String;", "", "HEIGHT", UserInfo.SEX_FEMALE, "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.placeholder.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56807);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void k1() {
        RelativeLayout relativeLayout = new RelativeLayout(getMContext());
        relativeLayout.setLayoutParams(com.tencent.aio.base.tool.b.f69219a.a(getMContext(), -1, c.f353052a.a(30.0f)));
        relativeLayout.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
        relativeLayout.setVisibility(8);
        this.mInputPlaceHolder = relativeLayout;
        i1(relativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.aio.lazy.FrameLayoutLazyVB
    @NotNull
    public ViewGroup.LayoutParams e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<ol3.b, AIOInputPlaceholderUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIOInputPlaceholderUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        RelativeLayout relativeLayout = null;
        if (!FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_input_placeholder_enable_8983", true)) {
            QLog.d("AIOInputPlaceholderVB", 1, "handleUIState return isEnable = false");
            RelativeLayout relativeLayout2 = this.mInputPlaceHolder;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputPlaceHolder");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setVisibility(8);
            return;
        }
        if (state instanceof AIOInputPlaceholderUIState.SetVisibility) {
            if (this.mInputPlaceHolder == null) {
                k1();
            }
            RelativeLayout relativeLayout3 = this.mInputPlaceHolder;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputPlaceHolder");
            } else {
                relativeLayout = relativeLayout3;
            }
            relativeLayout.setVisibility(((AIOInputPlaceholderUIState.SetVisibility) state).a());
        }
    }
}
