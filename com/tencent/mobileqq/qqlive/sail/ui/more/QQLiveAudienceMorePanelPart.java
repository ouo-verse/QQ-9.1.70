package com.tencent.mobileqq.qqlive.sail.ui.more;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.room.feedback.QQLiveFeedbackFragment;
import com.tencent.mobileqq.qqlive.sail.ui.more.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.sso.request.QQLiveDoReportRequest;
import java.util.List;
import kl4.r;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0018\u0010#\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceMorePanelPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/g$b;", "", "sa", "ra", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/h;", "btn", "va", "wa", "Ca", "xa", "initView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartPause", "V9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Y6", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "dynamicBtnRecyclerView", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/g;", "f", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/g;", "dynamicBtnAdapter", tl.h.F, "localBtnRecyclerView", "i", "localBtnAdapter", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "morePanelView", "Landroid/widget/PopupWindow;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/PopupWindow;", "popupWin", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/MorePanelViewModel;", "D", "Lkotlin/Lazy;", "ua", "()Lcom/tencent/mobileqq/qqlive/sail/ui/more/MorePanelViewModel;", "moreViewModel", "<init>", "()V", "E", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceMorePanelPart extends com.tencent.mobileqq.qqlive.sail.base.c implements g.b {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private PopupWindow popupWin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy moreViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView dynamicBtnRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g dynamicBtnAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView localBtnRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g localBtnAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View morePanelView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceMorePanelPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceMorePanelPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52578);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAudienceMorePanelPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<MorePanelViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceMorePanelPart$moreViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceMorePanelPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MorePanelViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (MorePanelViewModel) QQLiveAudienceMorePanelPart.this.getViewModel(MorePanelViewModel.class) : (MorePanelViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.moreViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ca() {
        wk4.a.h(getContext(), H9(), null);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveDoReportRequest(H9(), 1), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ViewGroup viewGroup;
        RecyclerView recyclerView3 = null;
        if (this.morePanelView == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            View partRootView = getPartRootView();
            if (partRootView instanceof ViewGroup) {
                viewGroup = (ViewGroup) partRootView;
            } else {
                viewGroup = null;
            }
            this.morePanelView = from.inflate(R.layout.htm, viewGroup, false);
        }
        if (this.dynamicBtnRecyclerView == null) {
            View view = this.morePanelView;
            if (view != null && (recyclerView2 = (RecyclerView) view.findViewById(R.id.zzj)) != null) {
                g gVar = new g();
                this.dynamicBtnAdapter = gVar;
                gVar.k0(this);
                recyclerView2.setAdapter(this.dynamicBtnAdapter);
                recyclerView2.setLayoutManager(new GridLayoutManager(recyclerView2.getContext(), 4));
            } else {
                recyclerView2 = null;
            }
            this.dynamicBtnRecyclerView = recyclerView2;
        }
        if (this.localBtnRecyclerView == null) {
            View view2 = this.morePanelView;
            if (view2 != null && (recyclerView = (RecyclerView) view2.findViewById(R.id.ytd)) != null) {
                g gVar2 = new g();
                this.localBtnAdapter = gVar2;
                gVar2.k0(this);
                recyclerView.setAdapter(this.localBtnAdapter);
                recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
                recyclerView3 = recyclerView;
            }
            this.localBtnRecyclerView = recyclerView3;
        }
    }

    private final void ra() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2 = this.popupWin;
        boolean z16 = false;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            z16 = true;
        }
        if (z16 && (popupWindow = this.popupWin) != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa() {
        int i3;
        com.tencent.timi.game.liveroom.impl.room.util.h hVar = new com.tencent.timi.game.liveroom.impl.room.util.h();
        hVar.x(true);
        hVar.q(R.style.f246468z);
        hVar.v(-1);
        hVar.u(-2);
        hVar.s(-1);
        hVar.r(-2);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        PopupWindow g16 = com.tencent.timi.game.liveroom.impl.room.util.g.g(context, this.morePanelView, hVar, null, 8, null);
        this.popupWin = g16;
        if (g16 != null) {
            i3 = g16.hashCode();
        } else {
            i3 = 0;
        }
        lj4.a.c(i3, true);
        PopupWindow popupWindow = this.popupWin;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ak
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    QQLiveAudienceMorePanelPart.ta(QQLiveAudienceMorePanelPart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(QQLiveAudienceMorePanelPart this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWin;
        if (popupWindow != null) {
            i3 = popupWindow.hashCode();
        } else {
            i3 = 0;
        }
        lj4.a.c(i3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MorePanelViewModel ua() {
        Object value = this.moreViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-moreViewModel>(...)");
        return (MorePanelViewModel) value;
    }

    private final void va(h btn) {
        int i3;
        DisplayMetrics displayMetrics;
        Bundle bundle = new Bundle();
        Resources resources = getContext().getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            i3 = displayMetrics.heightPixels;
        } else {
            i3 = 0;
        }
        bundle.putInt("height_web_dialog", wi2.c.e(i3 * btn.a()));
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(getContext(), btn.d(), bundle);
    }

    private final void wa(h btn) {
        int f16 = btn.f();
        if (f16 == R.string.zfu) {
            Ca();
        } else if (f16 == R.string.zfp) {
            ((com.tencent.mobileqq.qqlive.sail.ui.definition.a) getViewModel(com.tencent.mobileqq.qqlive.sail.ui.definition.a.class)).X1(true);
        } else if (f16 == R.string.zfo) {
            xa();
        } else if (f16 == R.string.zfr) {
            kl4.s.INSTANCE.e(Long.valueOf(tk4.d.f436481a.i()));
        } else if (f16 == R.string.zfl) {
            kl4.s.INSTANCE.b("em_qqlive_dress_center");
        } else if (f16 == R.string.zft) {
            r.Companion companion = kl4.r.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.b(context);
        } else if (f16 == R.string.zfq) {
            kl4.s.INSTANCE.f(H9());
        } else if (f16 == R.string.zfm) {
            ((com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) getViewModel(com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a.class)).M1(true);
        } else if (f16 == R.string.zfn) {
            ((com.tencent.mobileqq.qqlive.sail.ui.debug.a) getViewModel(com.tencent.mobileqq.qqlive.sail.ui.debug.a.class)).L1().postValue(Boolean.TRUE);
        }
        ra();
    }

    private final void xa() {
        String c16 = com.tencent.mobileqq.qqlive.room.feedback.a.c(getContext(), ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", c16);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("fragment_class", QQLiveFeedbackFragment.class.getCanonicalName());
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.V9();
            ra();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.ui.more.g.b
    public void Y6(@Nullable h btn) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) btn);
            return;
        }
        if (btn != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(btn.d());
            if (!isBlank) {
                va(btn);
            } else {
                wa(btn);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            ra();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<Boolean> X1 = ua().X1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceMorePanelPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceMorePanelPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                MorePanelViewModel ua5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveAudienceMorePanelPart", "showPanelChanged", "roomId=" + QQLiveAudienceMorePanelPart.this.H9() + ", show=" + it);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    QQLiveAudienceMorePanelPart.this.initView();
                    ua5 = QQLiveAudienceMorePanelPart.this.ua();
                    ua5.T1(QQLiveAudienceMorePanelPart.this.H9(), QQLiveAudienceMorePanelPart.this.C9(), QQLiveAudienceMorePanelPart.this.M9());
                }
            }
        };
        X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceMorePanelPart.za(Function1.this, obj);
            }
        });
        LiveData<List<h>> W1 = ua().W1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends h>, Unit> function12 = new Function1<List<? extends h>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceMorePanelPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceMorePanelPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends h> list) {
                invoke2((List<h>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<h> it) {
                g gVar;
                MorePanelViewModel ua5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveAudienceMorePanelPart", "localBtnChanged", "roomId=" + QQLiveAudienceMorePanelPart.this.H9() + ", btn size=" + it.size());
                gVar = QQLiveAudienceMorePanelPart.this.localBtnAdapter;
                if (gVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    gVar.setData(it);
                }
                QQLiveAudienceMorePanelPart.this.sa();
                ua5 = QQLiveAudienceMorePanelPart.this.ua();
                ua5.S1(QQLiveAudienceMorePanelPart.this.H9(), QQLiveAudienceMorePanelPart.this.J9());
            }
        };
        W1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceMorePanelPart.Aa(Function1.this, obj);
            }
        });
        LiveData<List<h>> U1 = ua().U1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<List<h>, Unit> function13 = new Function1<List<h>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceMorePanelPart$onPartCreate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceMorePanelPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<h> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<h> it) {
                g gVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveAudienceMorePanelPart", "dynamicBtnChanged", "roomId=" + QQLiveAudienceMorePanelPart.this.H9() + ", btn size=" + it.size());
                gVar = QQLiveAudienceMorePanelPart.this.dynamicBtnAdapter;
                if (gVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    gVar.setData(it);
                }
            }
        };
        U1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceMorePanelPart.Ba(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartPause(activity);
            ra();
        }
    }
}
