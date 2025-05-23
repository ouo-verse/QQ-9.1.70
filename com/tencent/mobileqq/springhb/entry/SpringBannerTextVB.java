package com.tencent.mobileqq.springhb.entry;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.springhb.entry.ui.BannerTextCountdownView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0002R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/SpringBannerTextVB;", "", "", "c", "Landroid/view/View;", "bannerContainer", "Lcom/tencent/mobileqq/springhb/entry/model/MsgTabBannerData;", "msgTabBannerData", "e", "d", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "a", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "getSpringApi", "()Lcom/tencent/mobileqq/springhb/entry/worker/d;", "springApi", "Lcom/tencent/mobileqq/springhb/entry/ui/BannerTextCountdownView;", "b", "Lcom/tencent/mobileqq/springhb/entry/ui/BannerTextCountdownView;", "bannerTextView", "Lcom/tencent/mobileqq/springhb/entry/model/MsgTabBannerData;", "bannerData", "Lcom/tencent/mobileqq/springhb/entry/g;", "Lcom/tencent/mobileqq/springhb/entry/g;", "viewMode", "", "Z", "bDestroy", "<init>", "(Lcom/tencent/mobileqq/springhb/entry/worker/d;)V", "f", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringBannerTextVB {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.entry.worker.d springApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BannerTextCountdownView bannerTextView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private MsgTabBannerData bannerData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g viewMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean bDestroy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/SpringBannerTextVB$a;", "", "", "BANNER_DEFAULT_TEXT", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.SpringBannerTextVB$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/springhb/entry/SpringBannerTextVB$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringBannerTextVB.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View view) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                return;
            }
            if (view != null) {
                view.removeOnAttachStateChangeListener(this);
            }
            if (view != null) {
                num = Integer.valueOf(view.hashCode());
            } else {
                num = null;
            }
            QLog.i("SpringHb_SpringBannerTextVB", 1, "onViewDetachedFromWindow bannerTextView:" + num);
            SpringBannerTextVB.this.d();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60609);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SpringBannerTextVB(@NotNull com.tencent.mobileqq.springhb.entry.worker.d springApi) {
        Intrinsics.checkNotNullParameter(springApi, "springApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) springApi);
        } else {
            this.springApi = springApi;
        }
    }

    private final void c() {
        BannerTextCountdownView bannerTextCountdownView = this.bannerTextView;
        if (bannerTextCountdownView != null) {
            bannerTextCountdownView.addOnAttachStateChangeListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void d() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        boolean z16 = this.bDestroy;
        BannerTextCountdownView bannerTextCountdownView = this.bannerTextView;
        if (bannerTextCountdownView != null) {
            num = Integer.valueOf(bannerTextCountdownView.hashCode());
        } else {
            num = null;
        }
        QLog.i("SpringHb_SpringBannerTextVB", 1, "onDestroy bDestroy:" + z16 + " bannerTextView:" + num);
        if (!this.bDestroy) {
            this.bDestroy = true;
            BannerTextCountdownView bannerTextCountdownView2 = this.bannerTextView;
            if (bannerTextCountdownView2 != null) {
                BannerTextCountdownView.g(bannerTextCountdownView2, false, 1, null);
            }
            this.bannerTextView = null;
            g gVar = this.viewMode;
            if (gVar != null) {
                gVar.r();
            }
            this.viewMode = null;
        }
    }

    public final void e(@NotNull View bannerContainer, @NotNull MsgTabBannerData msgTabBannerData) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bannerContainer, (Object) msgTabBannerData);
            return;
        }
        Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
        Intrinsics.checkNotNullParameter(msgTabBannerData, "msgTabBannerData");
        this.bannerData = msgTabBannerData;
        BannerTextCountdownView bannerTextCountdownView = (BannerTextCountdownView) bannerContainer.findViewById(R.id.f87574uq);
        this.bannerTextView = bannerTextCountdownView;
        if (bannerTextCountdownView != null) {
            boolean z16 = false;
            if (bannerTextCountdownView != null) {
                i3 = bannerTextCountdownView.hashCode();
            } else {
                i3 = 0;
            }
            QLog.i("SpringHb_SpringBannerTextVB", 1, "onInit bannerTextView:" + i3);
            g gVar = new g(this.springApi);
            gVar.q(msgTabBannerData);
            MutableLiveData<a> n3 = gVar.n();
            final Function1<a, Unit> function1 = new Function1<a, Unit>() { // from class: com.tencent.mobileqq.springhb.entry.SpringBannerTextVB$onInit$1$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SpringBannerTextVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(a aVar) {
                    BannerTextCountdownView bannerTextCountdownView2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                        return;
                    }
                    bannerTextCountdownView2 = SpringBannerTextVB.this.bannerTextView;
                    if (bannerTextCountdownView2 != null) {
                        int c16 = aVar.c();
                        if (c16 == 1) {
                            bannerTextCountdownView2.setCountDownPreText(aVar.b());
                            bannerTextCountdownView2.e(aVar.a());
                        } else if (c16 == 2) {
                            bannerTextCountdownView2.f(true);
                        } else {
                            if (c16 != 3) {
                                return;
                            }
                            BannerTextCountdownView.g(bannerTextCountdownView2, false, 1, null);
                        }
                    }
                }
            };
            n3.observeForever(new Observer() { // from class: com.tencent.mobileqq.springhb.entry.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SpringBannerTextVB.f(Function1.this, obj);
                }
            });
            this.viewMode = gVar;
            String str2 = msgTabBannerData.text;
            if (str2 == null || str2.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                str = msgTabBannerData.text;
                Intrinsics.checkNotNullExpressionValue(str, "msgTabBannerData.text");
            } else {
                str = "\u65b0\u6625\u7ea2\u5305\u6d3e\u53d1\u4e2d\u2026";
            }
            bannerTextCountdownView.setDefaultText(str);
            bannerTextCountdownView.setText(bannerTextCountdownView.c());
            FontSettingManager.resetViewSize2Normal(this.springApi.i().a(), this.bannerTextView);
            c();
        }
    }
}
