package com.tencent.mobileqq.bizParts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.dh;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.utils.fa;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u000278B\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\"\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u0014R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeChangeAccountPart;", "Lcom/tencent/mobileqq/part/a;", "", "M9", "Q9", "Landroid/view/View;", "N9", "O9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "A9", "z9", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPostThemeChanged", "onPartDestroy", "", "f", "Z", "isV9", "Landroid/view/ViewStub;", tl.h.F, "Landroid/view/ViewStub;", "vsChangeAccount", "i", "Landroid/view/View;", "llChangeAccount", "Lcom/tencent/mobileqq/account/widget/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/account/widget/b;", "accountSelectHelper", "", "Lcom/tencent/mobileqq/login/account/a;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "accountList", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "accountListLiveData", "E", "isOpened", "", UserInfo.SEX_FEMALE, "I", "lastRightWidth", "Lcom/tencent/mobileqq/bizParts/QQSettingMeChangeAccountPart$b;", "G", "Lcom/tencent/mobileqq/bizParts/QQSettingMeChangeAccountPart$b;", "globalLayoutListener", "<init>", "(Z)V", "H", "a", "b", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQSettingMeChangeAccountPart extends com.tencent.mobileqq.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static int I;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.login.account.a> accountList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<com.tencent.mobileqq.login.account.a>> accountListLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isOpened;

    /* renamed from: F, reason: from kotlin metadata */
    private int lastRightWidth;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b globalLayoutListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isV9;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewStub vsChangeAccount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View llChangeAccount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.account.widget.b accountSelectHelper;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeChangeAccountPart$a;", "", "", "TAG", "Ljava/lang/String;", "", "lastContainerWidth", "I", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.bizParts.QQSettingMeChangeAccountPart$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeChangeAccountPart$b;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lcom/tencent/mobileqq/bizParts/QQSettingMeChangeAccountPart;", "d", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "partRef", "part", "<init>", "(Lcom/tencent/mobileqq/bizParts/QQSettingMeChangeAccountPart;)V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.avatar.meta.refresh.c<QQSettingMeChangeAccountPart> partRef;

        public b(@NotNull QQSettingMeChangeAccountPart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            } else {
                this.partRef = new com.tencent.qqnt.avatar.meta.refresh.c<>(part);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQSettingMeChangeAccountPart qQSettingMeChangeAccountPart = this.partRef.get();
            if (qQSettingMeChangeAccountPart != null && (view = qQSettingMeChangeAccountPart.llChangeAccount) != null && view.getWidth() != QQSettingMeChangeAccountPart.I) {
                QQSettingMeChangeAccountPart.I = view.getWidth();
                QQSettingMeChangeAccountPart qQSettingMeChangeAccountPart2 = this.partRef.get();
                if (qQSettingMeChangeAccountPart2 != null) {
                    qQSettingMeChangeAccountPart2.O9();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25307);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeChangeAccountPart() {
        this(false, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this);
    }

    private final void M9() {
        ViewStub viewStub;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            viewStub = (ViewStub) partRootView.findViewById(R.id.f1204079g);
        } else {
            viewStub = null;
        }
        this.vsChangeAccount = viewStub;
        this.accountListLiveData.postValue(((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getLoginAccountList());
    }

    private final void N9(View view) {
        String str;
        VideoReport.setElementId(view, "em_bas_switch_account");
        if (this.isV9) {
            str = "1";
        } else {
            str = "2";
        }
        VideoReport.setElementParam(view, "new_or_old_page", str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        int d16;
        fa a16 = dh.f307632a.a();
        if (this.accountList.size() <= 1) {
            QLog.i("QQSettingMeChangeAccountPart", 2, "updateChangeAccountView gone");
            if (a16 != null) {
                a16.b0(0);
                return;
            }
            return;
        }
        if (this.llChangeAccount != null) {
            int i3 = I;
            if (this.isV9) {
                d16 = ex.d(Double.valueOf(40.5d));
            } else {
                d16 = ex.d(29);
            }
            int i16 = i3 - d16;
            if (i16 != this.lastRightWidth) {
                this.lastRightWidth = i16;
                QLog.i("QQSettingMeChangeAccountPart", 2, "updateChangeAccountView visible " + i16);
                if (a16 != null) {
                    a16.b0(i16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void Q9() {
        View view;
        if (this.accountList.size() <= 1) {
            View view2 = this.llChangeAccount;
            if (view2 != null && view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.llChangeAccount;
        if (view3 == null) {
            QLog.i("QQSettingMeChangeAccountPart", 1, "updateChangeAccountView inflate");
            ViewStub viewStub = this.vsChangeAccount;
            if (viewStub != null && (view = viewStub.inflate()) != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.bizParts.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        QQSettingMeChangeAccountPart.R9(QQSettingMeChangeAccountPart.this, view4);
                    }
                });
                int d16 = ex.d(7);
                view.setPadding(d16, d16, d16, d16);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = -d16;
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.bizParts.d
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view4, MotionEvent motionEvent) {
                        boolean S9;
                        S9 = QQSettingMeChangeAccountPart.S9(QQSettingMeChangeAccountPart.this, view4, motionEvent);
                        return S9;
                    }
                });
                ((TextView) view.findViewById(R.id.f10657693)).setTextColor(ex.b(R.color.qui_common_text_primary));
                ImageView imageView = (ImageView) view.findViewById(R.id.y1b);
                if (this.isV9) {
                    imageView.setImageDrawable(ex.c(R.drawable.qui_chevron_down));
                } else {
                    imageView.setImageDrawable(cn.f(ex.c(R.drawable.qui_chevron_down)));
                }
                N9(view);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.globalLayoutListener);
                }
            } else {
                view = null;
            }
            this.llChangeAccount = view;
            return;
        }
        if (view3 != null) {
            view3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QQSettingMeChangeAccountPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSettingMeChangeAccountPart")) {
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            com.tencent.mobileqq.account.widget.b bVar = new com.tencent.mobileqq.account.widget.b(activity, this$0.accountList, this$0.isV9, false);
            this$0.accountSelectHelper = bVar;
            bVar.k("");
            com.tencent.mobileqq.account.widget.b bVar2 = this$0.accountSelectHelper;
            if (bVar2 != null) {
                View findViewById = view.findViewById(R.id.y1b);
                Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<ImageV\u2026>(R.id.iv_change_account)");
                bVar2.l(findViewById);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S9(QQSettingMeChangeAccountPart this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class)).c2(view, motionEvent);
        return false;
    }

    @Override // com.tencent.mobileqq.part.a
    public void A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.A9();
            this.isOpened = true;
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.B9();
        if (!this.isOpened) {
            this.accountListLiveData.setValue(((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getLoginAccountList());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        M9();
        MutableLiveData<List<com.tencent.mobileqq.login.account.a>> mutableLiveData = this.accountListLiveData;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.login.account.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.login.account.a>, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeChangeAccountPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeChangeAccountPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.login.account.a> list) {
                invoke2((List<com.tencent.mobileqq.login.account.a>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.tencent.mobileqq.login.account.a> it) {
                List list;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                list = QQSettingMeChangeAccountPart.this.accountList;
                if (Intrinsics.areEqual(list, it)) {
                    return;
                }
                QQSettingMeChangeAccountPart qQSettingMeChangeAccountPart = QQSettingMeChangeAccountPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeChangeAccountPart.accountList = it;
                QQSettingMeChangeAccountPart.this.Q9();
                QQSettingMeChangeAccountPart.this.O9();
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeChangeAccountPart.P9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        ViewTreeObserver viewTreeObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        View view = this.llChangeAccount;
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.globalLayoutListener);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            this.accountListLiveData.setValue(((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getLoginAccountList());
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        com.tencent.mobileqq.account.widget.b bVar = this.accountSelectHelper;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.z9();
        com.tencent.mobileqq.account.widget.b bVar = this.accountSelectHelper;
        if (bVar != null) {
            bVar.f();
        }
        this.accountSelectHelper = null;
        this.isOpened = false;
    }

    public QQSettingMeChangeAccountPart(boolean z16) {
        List<com.tencent.mobileqq.login.account.a> emptyList;
        List emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.isV9 = z16;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.accountList = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.accountListLiveData = new MutableLiveData<>(emptyList2);
        this.globalLayoutListener = new b(this);
    }

    public /* synthetic */ QQSettingMeChangeAccountPart(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
