package com.tencent.ams.dynamicwidget.landingpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import com.tencent.ams.dynamicwidget.data.AdInfo;
import com.tencent.ams.dynamicwidget.utils.d;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ams/dynamicwidget/landingpage/LandingPageDialog;", "Lcom/tencent/ams/dynamicwidget/landingpage/c;", "d", "a", "TransmitLandingPageView", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public class LandingPageDialog implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0013\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006 "}, d2 = {"Lcom/tencent/ams/dynamicwidget/landingpage/LandingPageDialog$TransmitLandingPageView;", "Lcom/tencent/ams/dynamicwidget/landingpage/LandingPageView;", "", "downX", "downY", "Lorg/json/JSONObject;", "params", "", "d", "", "clickArea", "c", "g", "", "moduleId", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "ad", "a", "errorMsg", "b", "f", h.F, "exposureArea", "e", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "Lcom/tencent/ams/dynamicwidget/landingpage/c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ams/dynamicwidget/landingpage/c;", "transmitEvent", "lib_release"}, k = 1, mv = {1, 4, 0})
    @SuppressLint({"ViewConstructor"})
    /* loaded from: classes3.dex */
    public static final class TransmitLandingPageView extends LandingPageView {
        static IPatchRedirector $redirector_;

        /* renamed from: Q, reason: from kotlin metadata */
        private final c transmitEvent;

        @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dynamicwidget.e
        public void a(@Nullable String moduleId, @Nullable AdInfo ad5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) moduleId, (Object) ad5);
                return;
            }
            super.a(moduleId, ad5);
            c cVar = this.transmitEvent;
            if (cVar != null) {
                cVar.a(moduleId, ad5);
            }
        }

        @Override // com.tencent.ams.dynamicwidget.landingpage.LandingPageView, com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dynamicwidget.e
        public void b(@Nullable String moduleId, @Nullable AdInfo ad5, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, moduleId, ad5, errorMsg);
                return;
            }
            super.b(moduleId, ad5, errorMsg);
            c cVar = this.transmitEvent;
            if (cVar != null) {
                cVar.b(moduleId, ad5, errorMsg);
            }
        }

        @Override // com.tencent.ams.dynamicwidget.landingpage.LandingPageView, com.tencent.ams.dynamicwidget.landingpage.c
        public void c(float downX, float downY, int clickArea) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(downX), Float.valueOf(downY), Integer.valueOf(clickArea));
                return;
            }
            super.c(downX, downY, clickArea);
            c cVar = this.transmitEvent;
            if (cVar != null) {
                cVar.c(downX, downY, clickArea);
            }
        }

        @Override // com.tencent.ams.dynamicwidget.landingpage.LandingPageView, com.tencent.ams.dynamicwidget.landingpage.c
        public void d(float downX, float downY, @Nullable JSONObject params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(downX), Float.valueOf(downY), params);
                return;
            }
            super.d(downX, downY, params);
            c cVar = this.transmitEvent;
            if (cVar != null) {
                cVar.d(downX, downY, params);
            }
        }

        @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dynamicwidget.e
        public void e(int exposureArea) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, exposureArea);
                return;
            }
            super.e(exposureArea);
            c cVar = this.transmitEvent;
            if (cVar != null) {
                cVar.e(exposureArea);
            }
        }

        @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dynamicwidget.e
        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
                return;
            }
            super.f();
            c cVar = this.transmitEvent;
            if (cVar != null) {
                cVar.f();
            }
        }

        @Override // com.tencent.ams.dynamicwidget.landingpage.LandingPageView, com.tencent.ams.dynamicwidget.landingpage.c
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            super.g();
            c cVar = this.transmitEvent;
            if (cVar != null) {
                cVar.g();
            }
        }

        @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dynamicwidget.e
        public void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this);
                return;
            }
            super.h();
            c cVar = this.transmitEvent;
            if (cVar != null) {
                cVar.h();
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(@Nullable MotionEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) event)).booleanValue();
            }
            if (event != null && event.getY() > getHeight() - getPaddingBottom()) {
                MotionEvent obtain = MotionEvent.obtain(event.getDownTime(), event.getEventTime(), event.getAction(), event.getRawX(), event.getRawY(), event.getPressure(), event.getSize(), event.getMetaState(), event.getXPrecision(), event.getYPrecision(), event.getDeviceId(), event.getEdgeFlags());
                d dVar = d.f70220a;
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                Activity b16 = dVar.b(context);
                if (b16 != null) {
                    return b16.dispatchTouchEvent(obtain);
                }
                return false;
            }
            return super.onTouchEvent(event);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ams/dynamicwidget/landingpage/LandingPageDialog$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.ams.dynamicwidget.landingpage.LandingPageDialog$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17861);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public static final /* synthetic */ LandingPageView i(LandingPageDialog landingPageDialog) {
        throw null;
    }

    public static final /* synthetic */ boolean j(LandingPageDialog landingPageDialog) {
        throw null;
    }
}
