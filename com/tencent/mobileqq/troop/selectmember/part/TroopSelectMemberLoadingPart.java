package com.tencent.mobileqq.troop.selectmember.part;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsetting.part.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/TroopSelectMemberLoadingPart;", "Lcom/tencent/mobileqq/troop/selectmember/part/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "I9", "onInitView", "f", "Landroid/view/View;", "loadingLayout", "Landroid/widget/ProgressBar;", h.F, "Landroid/widget/ProgressBar;", "loadingProgressBar", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "loadingTv", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberLoadingPart extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View loadingLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ProgressBar loadingProgressBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView loadingTv;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/TroopSelectMemberLoadingPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberLoadingPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54900);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectMemberLoadingPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void I9(View rootView) {
        this.loadingLayout = rootView.findViewById(R.id.loading_layout);
        this.loadingProgressBar = (ProgressBar) rootView.findViewById(R.id.d7z);
        this.loadingTv = (TextView) rootView.findViewById(R.id.efr);
        LifecycleOwner a16 = i.a(this);
        if (a16 != null) {
            LiveData<Integer> l26 = z9().l2();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberLoadingPart$initLoading$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSelectMemberLoadingPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    View view;
                    ProgressBar progressBar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    view = TroopSelectMemberLoadingPart.this.loadingLayout;
                    if (view != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        view.setVisibility(it.intValue() >= 100 ? 8 : 0);
                    }
                    progressBar = TroopSelectMemberLoadingPart.this.loadingProgressBar;
                    if (progressBar == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    progressBar.setProgress(it.intValue());
                }
            };
            l26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberLoadingPart.J9(Function1.this, obj);
                }
            });
            LiveData<String> m26 = z9().m2();
            final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberLoadingPart$initLoading$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSelectMemberLoadingPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    TextView textView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                        return;
                    }
                    textView = TroopSelectMemberLoadingPart.this.loadingTv;
                    if (textView == null) {
                        return;
                    }
                    textView.setText(str);
                }
            };
            m26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberLoadingPart.K9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            I9(rootView);
        }
    }
}
