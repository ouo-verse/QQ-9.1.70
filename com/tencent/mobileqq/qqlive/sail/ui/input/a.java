package com.tencent.mobileqq.qqlive.sail.ui.input;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\nR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "", "show", "", "O1", "Q1", "P1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_showKeyboard", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "L1", "()Landroidx/lifecycle/LiveData;", "showKeyboard", BdhLogUtil.LogTag.Tag_Conn, "_showPortraitInput", "D", "N1", "showPortraitInput", "E", "_showLandscapeInput", UserInfo.SEX_FEMALE, "M1", "showLandscapeInput", "<init>", "()V", "G", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showPortraitInput;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showPortraitInput;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showLandscapeInput;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showLandscapeInput;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showKeyboard;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showKeyboard;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/input/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.input.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52189);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._showKeyboard = mutableLiveData;
        this.showKeyboard = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._showPortraitInput = mutableLiveData2;
        this.showPortraitInput = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._showLandscapeInput = mutableLiveData3;
        this.showLandscapeInput = mutableLiveData3;
    }

    @NotNull
    public final LiveData<Boolean> L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.showKeyboard;
    }

    @NotNull
    public final LiveData<Boolean> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.showLandscapeInput;
    }

    @NotNull
    public final LiveData<Boolean> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.showPortraitInput;
    }

    public final void O1(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, show);
            return;
        }
        lk4.c cVar = lk4.c.f414972a;
        if (cVar.k()) {
            AegisLogger.INSTANCE.w("Input|InputViewModel", "showKeyboard", "chat disable!");
            cVar.n();
        } else {
            if (Intrinsics.areEqual(Boolean.valueOf(show), this._showKeyboard.getValue())) {
                return;
            }
            this._showKeyboard.postValue(Boolean.valueOf(show));
        }
    }

    public final void P1(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, show);
        } else {
            this._showLandscapeInput.postValue(Boolean.valueOf(show));
        }
    }

    public final void Q1(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, show);
        } else {
            this._showPortraitInput.postValue(Boolean.valueOf(show));
        }
    }
}
