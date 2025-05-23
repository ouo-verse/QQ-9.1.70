package com.tencent.mobileqq.troop.selectmember.part;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.troop.selectmember.event.TroopSelectMemberRightClickEvent;
import com.tencent.mobileqq.troop.troopsetting.part.i;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/TroopSelectMemberTitlePart;", "Lcom/tencent/mobileqq/troop/selectmember/part/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "I9", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "titleBar", "H9", "K9", "J9", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", DownloadInfo.spKey_Config, "F9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "f", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "title", "<init>", "()V", h.F, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberTitlePart extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar title;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/TroopSelectMemberTitlePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberTitlePart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54912);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectMemberTitlePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void F9(final QUISecNavBar titleBar, TroopSelectMemberConfig config) {
        LifecycleOwner a16;
        final String b16 = com.tencent.mobileqq.troop.selectmember.config.a.b(config);
        boolean z16 = true;
        QLog.i("TroopSelectMemberFrag.TitlePart", 1, "[configDefaultRightText] rightText:" + b16);
        titleBar.setRightText(b16);
        if (b16.length() != 0) {
            z16 = false;
        }
        if (!z16 && (a16 = i.a(this)) != null) {
            LiveData<List<com.tencent.mobileqq.troop.selectmember.bean.c>> P = z9().P();
            final Function1<List<? extends com.tencent.mobileqq.troop.selectmember.bean.c>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.troop.selectmember.bean.c>, Unit>(b16) { // from class: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberTitlePart$configDefaultRightText$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $rightText;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$rightText = b16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUISecNavBar.this, (Object) b16);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.troop.selectmember.bean.c> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends com.tencent.mobileqq.troop.selectmember.bean.c> it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (!it.isEmpty()) {
                        QUISecNavBar.this.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
                        QUISecNavBar.this.setRightText(this.$rightText + "(" + it.size() + ")");
                        return;
                    }
                    QUISecNavBar.this.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, false);
                    QUISecNavBar.this.setRightText(this.$rightText);
                }
            };
            P.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberTitlePart.G9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void H9(QUISecNavBar titleBar) {
        boolean z16;
        com.tencent.mobileqq.troop.selectmember.inject.d c16 = z9().T0().c();
        if (c16 != null) {
            c16.g(A9(), titleBar, z9());
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopSelectMemberFrag.TitlePart", 2, "[initTitle] consumed:" + z16);
        }
        if (!z16) {
            K9(titleBar);
        }
    }

    private final void I9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f66453ao);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qui_title_bar)");
        this.title = (QUISecNavBar) findViewById;
        QUISecNavBar qUISecNavBar = null;
        if (com.tencent.mobileqq.troop.selectmember.config.a.j(x9())) {
            QUISecNavBar qUISecNavBar2 = this.title;
            if (qUISecNavBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                qUISecNavBar2 = null;
            }
            H9(qUISecNavBar2);
            QUISecNavBar qUISecNavBar3 = this.title;
            if (qUISecNavBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
            } else {
                qUISecNavBar = qUISecNavBar3;
            }
            qUISecNavBar.setVisibility(0);
            return;
        }
        QUISecNavBar qUISecNavBar4 = this.title;
        if (qUISecNavBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        } else {
            qUISecNavBar = qUISecNavBar4;
        }
        qUISecNavBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9() {
        boolean z16;
        boolean z17 = false;
        if (com.tencent.mobileqq.troop.selectmember.config.a.b(x9()).length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("TroopSelectMemberFrag.TitlePart", 1, "[onClickRightText] text is null");
            return;
        }
        ArrayList<com.tencent.mobileqq.troop.selectmember.bean.c> arrayList = new ArrayList<>();
        List<com.tencent.mobileqq.troop.selectmember.bean.c> value = z9().P().getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        com.tencent.mobileqq.troop.selectmember.inject.e f16 = z9().T0().f();
        if (f16 != null) {
            f16.a(A9(), z9(), arrayList);
            z17 = true;
        }
        if (!z17) {
            SimpleEventBus.getInstance().dispatchEvent(new TroopSelectMemberRightClickEvent(x9(), arrayList));
            getActivity().finish();
        }
    }

    private final void K9(QUISecNavBar titleBar) {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        titleBar.R(activity);
        titleBar.setCenterText(com.tencent.mobileqq.troop.selectmember.config.a.a(x9()));
        F9(titleBar, x9());
        titleBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberTitlePart$showDefaultTitle$1
            static IPatchRedirector $redirector_;

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes19.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f298378a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54906);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[BaseAction.values().length];
                    try {
                        iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f298378a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSelectMemberTitlePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull BaseAction baseAction) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
                    return;
                }
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(baseAction, "baseAction");
                int i3 = a.f298378a[baseAction.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        return;
                    }
                    TroopSelectMemberTitlePart.this.J9();
                } else {
                    Activity activity2 = TroopSelectMemberTitlePart.this.getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        I9(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.troop.selectmember.inject.d c16 = z9().T0().c();
        if (c16 != null) {
            c16.f();
        }
    }
}
