package com.tencent.mobileqq.reminder.chats.notifycard.view;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cardcontainer.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001\u0012B\u000f\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/NotifyGuestCardView;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;", "Lcom/tencent/mobileqq/cardcontainer/d;", "Landroid/view/View;", "root", "", tl.h.F, "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/b;", "data", "f", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lcom/tencent/mobileqq/cardcontainer/e;", "host", "d", "getView", "", "needReport", "c", "a", "b", "Landroid/view/View;", "mRootView", "e", "mCloseBtn", "Lcom/tencent/mobileqq/cardcontainer/e;", "mCardHost", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mBgImageView", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/CardCloseDelayTask;", "i", "Lkotlin/Lazy;", "g", "()Lcom/tencent/mobileqq/reminder/chats/notifycard/view/CardCloseDelayTask;", "mCloseRunnable", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/c;", "mMultiView", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/f;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/f;", "mSingleView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "D", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NotifyGuestCardView implements a, com.tencent.mobileqq.cardcontainer.d {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final f mSingleView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mCloseBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.cardcontainer.e mCardHost;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mBgImageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mCloseRunnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mMultiView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/NotifyGuestCardView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyGuestCardView$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NotifyGuestCardView(@NotNull ViewGroup parent) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(parent, "parent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parent);
            return;
        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fp8, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026card_view, parent, false)");
        this.mRootView = inflate;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CardCloseDelayTask>() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyGuestCardView$mCloseRunnable$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NotifyGuestCardView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardCloseDelayTask invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new CardCloseDelayTask(NotifyGuestCardView.this) : (CardCloseDelayTask) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mCloseRunnable = lazy;
        this.mMultiView = new c(this);
        this.mSingleView = new f(this);
        h(inflate);
    }

    private final void f(com.tencent.mobileqq.reminder.chats.notifycard.model.b data) {
        if (data.C().isEmpty()) {
            QLog.e("NotifyGuestCardView", 1, "Invalid data! User list is empty!");
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        ThreadManager.getUIHandler().removeCallbacks(g());
        if (serverTimeMillis >= data.x()) {
            QLog.i("NotifyGuestCardView", 1, "onBindData, data is expired now: " + serverTimeMillis + " expired: " + data.x());
            c(true);
            return;
        }
        ImageView imageView = this.mBgImageView;
        if (imageView != null) {
            com.tencent.mobileqq.reminder.util.e.c(imageView, data.j(), null, new ColorDrawable(0), 2, null);
        }
        if (data.C().size() > 1) {
            View j3 = this.mMultiView.j();
            if (j3 != null) {
                j3.setVisibility(0);
            }
            View j16 = this.mSingleView.j();
            if (j16 != null) {
                j16.setVisibility(8);
            }
            this.mMultiView.d(data);
        } else {
            View j17 = this.mMultiView.j();
            if (j17 != null) {
                j17.setVisibility(8);
            }
            View j18 = this.mSingleView.j();
            if (j18 != null) {
                j18.setVisibility(0);
            }
            this.mSingleView.d(data);
        }
        long x16 = data.x() - serverTimeMillis;
        QLog.i("NotifyGuestCardView", 1, "close card after " + x16 + "ms");
        ThreadManager.getUIHandler().postDelayed(g(), x16);
    }

    private final CardCloseDelayTask g() {
        return (CardCloseDelayTask) this.mCloseRunnable.getValue();
    }

    private final void h(View root) {
        this.mCloseBtn = root.findViewById(R.id.f166433zu1);
        ImageView imageView = (ImageView) root.findViewById(R.id.f166432zu0);
        this.mBgImageView = imageView;
        if (imageView != null) {
            imageView.setClipToOutline(true);
        }
        this.mMultiView.k(root.findViewById(R.id.zus));
        this.mSingleView.k(root.findViewById(R.id.zut));
        View view = this.mCloseBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NotifyGuestCardView.i(NotifyGuestCardView.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(NotifyGuestCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.view.a
    @Nullable
    public com.tencent.mobileqq.cardcontainer.e a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.cardcontainer.e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mCardHost;
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ThreadManager.getUIHandler().removeCallbacks(g());
        }
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.view.a
    public void c(boolean needReport) {
        boolean z16;
        com.tencent.mobileqq.cardcontainer.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, needReport);
            return;
        }
        if (this.mCardHost == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("NotifyGuestCardView", 1, "closeCard needReport: " + needReport + " host is null: " + z16);
        com.tencent.mobileqq.cardcontainer.e eVar2 = this.mCardHost;
        if (eVar2 != null) {
            eVar2.F8();
        }
        if (needReport && (eVar = this.mCardHost) != null) {
            e.a.c(eVar, null, 1, null);
        }
        ThreadManager.getUIHandler().removeCallbacks(g());
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    public void d(@NotNull com.tencent.mobileqq.cardcontainer.data.a data, @NotNull com.tencent.mobileqq.cardcontainer.e host) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, (Object) host);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(host, "host");
        this.mCardHost = host;
        if (data instanceof com.tencent.mobileqq.reminder.chats.notifycard.model.b) {
            f((com.tencent.mobileqq.reminder.chats.notifycard.model.b) data);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    @NotNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mRootView;
    }
}
