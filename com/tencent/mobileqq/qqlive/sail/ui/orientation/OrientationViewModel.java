package com.tencent.mobileqq.qqlive.sail.ui.orientation;

import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.util.SingleLiveEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/OrientationViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/OrientationViewModel$RequestedOrientation;", "requested", "", "L1", "Lcom/tencent/mobileqq/qqlive/sail/util/SingleLiveEvent;", "i", "Lcom/tencent/mobileqq/qqlive/sail/util/SingleLiveEvent;", "_changeOrientation", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "changeOrientationLiveData", "<init>", "()V", "RequestedOrientation", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class OrientationViewModel extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SingleLiveEvent<RequestedOrientation> _changeOrientation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<RequestedOrientation> changeOrientationLiveData;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/OrientationViewModel$RequestedOrientation;", "", "(Ljava/lang/String;I)V", "LANDSCAPE", "PORTRAIT", "OPPOSITE", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class RequestedOrientation {
        private static final /* synthetic */ RequestedOrientation[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RequestedOrientation LANDSCAPE;
        public static final RequestedOrientation OPPOSITE;
        public static final RequestedOrientation PORTRAIT;

        private static final /* synthetic */ RequestedOrientation[] $values() {
            return new RequestedOrientation[]{LANDSCAPE, PORTRAIT, OPPOSITE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52638);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            LANDSCAPE = new RequestedOrientation("LANDSCAPE", 0);
            PORTRAIT = new RequestedOrientation("PORTRAIT", 1);
            OPPOSITE = new RequestedOrientation("OPPOSITE", 2);
            $VALUES = $values();
        }

        RequestedOrientation(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static RequestedOrientation valueOf(String str) {
            return (RequestedOrientation) Enum.valueOf(RequestedOrientation.class, str);
        }

        public static RequestedOrientation[] values() {
            return (RequestedOrientation[]) $VALUES.clone();
        }
    }

    public OrientationViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        SingleLiveEvent<RequestedOrientation> singleLiveEvent = new SingleLiveEvent<>();
        this._changeOrientation = singleLiveEvent;
        this.changeOrientationLiveData = singleLiveEvent;
    }

    public final void L1(@NotNull RequestedOrientation requested) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) requested);
        } else {
            Intrinsics.checkNotNullParameter(requested, "requested");
            this._changeOrientation.postValue(requested);
        }
    }

    @NotNull
    public final LiveData<RequestedOrientation> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.changeOrientationLiveData;
    }
}
