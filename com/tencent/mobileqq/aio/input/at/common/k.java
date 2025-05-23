package com.tencent.mobileqq.aio.input.at.common;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b8\u00109J\u000f\u0010\u0005\u001a\u00020\u0004H\u0010\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0010\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0010\u00a2\u0006\u0004\b\r\u0010\nJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u000f\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\"\u0010 \u001a\u00020\u000e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00102\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00107\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u00103\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/k;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "", "f", "()Z", "isHalfDisplayMode", "", tl.h.F, "(Z)V", "g", "isMultiSelectMode", "i", "Landroid/view/View;", "a", "Landroid/content/Context;", "c", "Lcom/tencent/mobileqq/aio/input/at/common/a;", "b", "Lcom/tencent/mobileqq/aio/input/at/common/e;", "d", "e", "()Lcom/tencent/mobileqq/aio/input/at/common/c;", "Z", "mIsHalfDisplayMode", "mIsMultiSelectMode", "Landroid/view/View;", "j", "()Landroid/view/View;", "o", "(Landroid/view/View;)V", "mAnchor", "Landroid/content/Context;", "l", "()Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/content/Context;)V", "mContext", "Lcom/tencent/mobileqq/aio/input/at/common/a;", "k", "()Lcom/tencent/mobileqq/aio/input/at/common/a;", "p", "(Lcom/tencent/mobileqq/aio/input/at/common/a;)V", "mConfiguration", "Lcom/tencent/mobileqq/aio/input/at/common/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/aio/input/at/common/e;", "r", "(Lcom/tencent/mobileqq/aio/input/at/common/e;)V", "mDialogListener", "Lcom/tencent/mobileqq/aio/input/at/common/c;", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/aio/input/at/common/c;)V", "mParams", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class k<T extends c> extends j<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mIsHalfDisplayMode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMultiSelectMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public View mAnchor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public a<T> mConfiguration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public e mDialogListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public T mParams;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.j
    @NotNull
    public View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return j();
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.j
    @NotNull
    public a<T> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (a) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return k();
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.j
    @NotNull
    public Context c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Context) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return l();
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.j
    @NotNull
    public e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (e) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return m();
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.j
    @NotNull
    public T e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (T) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return n();
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.j
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mIsHalfDisplayMode;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.j
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mIsMultiSelectMode;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.j
    public void h(boolean isHalfDisplayMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, isHalfDisplayMode);
        } else {
            this.mIsHalfDisplayMode = isHalfDisplayMode;
        }
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.j
    public void i(boolean isMultiSelectMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, isMultiSelectMode);
        } else {
            this.mIsMultiSelectMode = isMultiSelectMode;
        }
    }

    @NotNull
    public final View j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        View view = this.mAnchor;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
        return null;
    }

    @NotNull
    public final a<T> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        a<T> aVar = this.mConfiguration;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mConfiguration");
        return null;
    }

    @NotNull
    public final Context l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    }

    @NotNull
    public final e m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (e) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        e eVar = this.mDialogListener;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDialogListener");
        return null;
    }

    @NotNull
    public final T n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (T) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        T t16 = this.mParams;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mParams");
        return null;
    }

    public final void o(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mAnchor = view;
        }
    }

    public final void p(@NotNull a<T> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.mConfiguration = aVar;
        }
    }

    public final void q(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.mContext = context;
        }
    }

    public final void r(@NotNull e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) eVar);
        } else {
            Intrinsics.checkNotNullParameter(eVar, "<set-?>");
            this.mDialogListener = eVar;
        }
    }

    public final void s(@NotNull T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) t16);
        } else {
            Intrinsics.checkNotNullParameter(t16, "<set-?>");
            this.mParams = t16;
        }
    }
}
