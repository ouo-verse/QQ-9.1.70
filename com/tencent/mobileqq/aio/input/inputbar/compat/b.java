package com.tencent.mobileqq.aio.input.inputbar.compat;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.AIOInputUtil;
import com.tencent.mobileqq.aio.input.inputbar.compat.AIOInputBarCompatUIState;
import com.tencent.mobileqq.aio.input.inputbar.compat.a;
import com.tencent.mobileqq.aio.input.inputbar.compat.c;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001\u001bB\u000f\u0012\u0006\u0010&\u001a\u00020\u0004\u00a2\u0006\u0004\b*\u0010%J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0016\u0018\u00010\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\"\u0010&\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010'R\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010)R\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010)\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/compat/b;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", "g", "", "isFullScreenMode", "isRobotAIO", "e", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/AIOInputBarCompatUIState$RefreshSendBtn;", "state", "j", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "isImmersive", DomainData.DOMAIN_NAME, "binding", "i", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "a", h.F, "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "f", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "mBinding", "Z", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.adorn.e> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.adorn.e mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isTransparent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isImmersive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/compat/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.inputbar.compat.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55703);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
        }
    }

    private final void e(boolean isFullScreenMode, boolean isRobotAIO) {
        if (isFullScreenMode) {
            com.tencent.mobileqq.aio.input.adorn.e eVar = this.mBinding;
            com.tencent.mobileqq.aio.input.adorn.e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar = null;
            }
            eVar.getMContainer().setBackgroundColor(0);
            if (isRobotAIO) {
                com.tencent.mobileqq.aio.input.adorn.e eVar3 = this.mBinding;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    eVar2 = eVar3;
                }
                eVar2.a().setBackgroundResource(R.drawable.qui_aio_input_full_screen_bg);
                return;
            }
            com.tencent.mobileqq.aio.input.adorn.e eVar4 = this.mBinding;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                eVar2 = eVar4;
            }
            eVar2.a().setBackgroundResource(R.drawable.j7d);
        }
    }

    private final void g() {
        com.tencent.mobileqq.aio.input.adorn.e eVar = this.mBinding;
        com.tencent.mobileqq.aio.input.adorn.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        EditText a16 = eVar.a();
        com.tencent.mobileqq.aio.input.themecompat.a aVar = com.tencent.mobileqq.aio.input.themecompat.a.f189924a;
        com.tencent.mobileqq.aio.input.adorn.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        Context context = eVar2.getMContainer().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        a16.setTextColor(aVar.d(context, this.isImmersive));
        n(this.isTransparent, this.isImmersive);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        if (r7 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(AIOInputBarCompatUIState.RefreshSendBtn state) {
        boolean z16;
        try {
            boolean z17 = false;
            com.tencent.mobileqq.aio.input.adorn.e eVar = null;
            if (state.a() == AIOInputBarCompatUIState.RefreshSendBtn.RefreshFlag.FLAG_IMPLICIT) {
                com.tencent.mobileqq.aio.input.adorn.e eVar2 = this.mBinding;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar2 = null;
                }
                View d16 = eVar2.d();
                if (state.b() <= 0) {
                    com.tencent.mobileqq.aio.input.adorn.e eVar3 = this.mBinding;
                    if (eVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        eVar = eVar3;
                    }
                    Editable text = eVar.a().getText();
                    if (text != null && text.length() != 0) {
                        z16 = false;
                    }
                    z16 = true;
                }
                z17 = true;
                d16.setEnabled(z17);
                return;
            }
            com.tencent.mobileqq.aio.input.adorn.e eVar4 = this.mBinding;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                eVar = eVar4;
            }
            View d17 = eVar.d();
            if (state.a() == AIOInputBarCompatUIState.RefreshSendBtn.RefreshFlag.FLAG_FORCE_ENABLE) {
                z17 = true;
            }
            d17.setEnabled(z17);
        } catch (Exception e16) {
            QLog.i("AIOInputStyleVBDelegate", 1, "[refreshSendBtnEnableState]: ", e16);
        }
    }

    private final void n(boolean isTransparent, boolean isImmersive) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        com.tencent.mobileqq.aio.input.adorn.e eVar = this.mBinding;
        com.tencent.mobileqq.aio.input.adorn.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.getMContainer().setBackground(null);
        com.tencent.mobileqq.aio.input.adorn.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        eVar3.a().setBackground(null);
        this.isTransparent = isTransparent;
        this.isImmersive = isImmersive;
        if (!isTransparent) {
            if (AIOInputUtil.f189159a.l()) {
                com.tencent.mobileqq.aio.input.adorn.e eVar4 = this.mBinding;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar4 = null;
                }
                Drawable drawable = eVar4.getMContainer().getContext().getResources().getDrawable(com.tencent.mobileqq.aio.input.themecompat.a.f189924a.c());
                Rect rect = new Rect();
                drawable.getPadding(rect);
                com.tencent.mobileqq.aio.input.adorn.e eVar5 = this.mBinding;
                if (eVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar5 = null;
                }
                ViewGroup.LayoutParams layoutParams = eVar5.a().getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams2 = null;
                }
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.topMargin = rect.top;
                }
            } else {
                com.tencent.mobileqq.aio.input.adorn.e eVar6 = this.mBinding;
                if (eVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar6 = null;
                }
                ViewGroup.LayoutParams layoutParams2 = eVar6.a().getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                } else {
                    marginLayoutParams = null;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = 0;
                }
            }
        }
        AIOUtil aIOUtil = AIOUtil.f194084a;
        com.tencent.mobileqq.aio.input.adorn.e eVar7 = this.mBinding;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar7 = null;
        }
        EditText a16 = eVar7.a();
        com.tencent.mobileqq.aio.input.themecompat.a aVar = com.tencent.mobileqq.aio.input.themecompat.a.f189924a;
        aIOUtil.G(a16, aVar.a(isImmersive));
        com.tencent.mobileqq.aio.input.adorn.e eVar8 = this.mBinding;
        if (eVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar8 = null;
        }
        EditText a17 = eVar8.a();
        com.tencent.mobileqq.aio.input.adorn.e eVar9 = this.mBinding;
        if (eVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar9;
        }
        Context context = eVar2.getMContainer().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        a17.setTextColor(aVar.d(context, isImmersive));
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            l(a.C7272a.f189712d);
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) reuseParam);
        } else {
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
            g();
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bundle) iPatchRedirector.redirect((short) 9, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof c.a) {
            c.a aVar = (c.a) stateCmd;
            com.tencent.mobileqq.aio.input.adorn.e eVar = this.mBinding;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar = null;
            }
            ViewGroup.LayoutParams layoutParams = eVar.a().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                i3 = marginLayoutParams.topMargin;
            } else {
                i3 = 0;
            }
            aVar.b(i3);
        }
        return null;
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{AIOInputBarCompatUIState.SetBackgroundTransparent.class, AIOInputBarCompatUIState.RefreshSendBtn.class, AIOInputBarCompatUIState.ChangeStyleForFullScreenMode.class, AIOInputBarCompatUIState.PostThemeChanged.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOInputBarCompatUIState.SetBackgroundTransparent) {
            AIOInputBarCompatUIState.SetBackgroundTransparent setBackgroundTransparent = (AIOInputBarCompatUIState.SetBackgroundTransparent) state;
            n(setBackgroundTransparent.b(), setBackgroundTransparent.a());
        } else {
            if (state instanceof AIOInputBarCompatUIState.RefreshSendBtn) {
                j((AIOInputBarCompatUIState.RefreshSendBtn) state);
                return;
            }
            if (state instanceof AIOInputBarCompatUIState.ChangeStyleForFullScreenMode) {
                AIOInputBarCompatUIState.ChangeStyleForFullScreenMode changeStyleForFullScreenMode = (AIOInputBarCompatUIState.ChangeStyleForFullScreenMode) state;
                e(changeStyleForFullScreenMode.a(), changeStyleForFullScreenMode.b());
            } else if (state instanceof AIOInputBarCompatUIState.PostThemeChanged) {
                g();
            }
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.adorn.e binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            binding = null;
        }
        EditText a16 = binding.a();
        com.tencent.mobileqq.aio.input.themecompat.a aVar = com.tencent.mobileqq.aio.input.themecompat.a.f189924a;
        com.tencent.mobileqq.aio.input.adorn.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        Context context = eVar.getMContainer().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        a16.setTextColor(com.tencent.mobileqq.aio.input.themecompat.a.e(aVar, context, false, 2, null));
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            c.a.d(this);
        }
    }
}
