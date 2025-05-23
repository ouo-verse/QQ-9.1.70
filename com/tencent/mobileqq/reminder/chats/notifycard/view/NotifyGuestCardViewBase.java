package com.tencent.mobileqq.reminder.chats.notifycard.view;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.cardcontainer.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b4\u00105J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H \u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0010\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\u00020\r8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010 R\u001b\u00100\u001a\u00020-8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u0014\u001a\u0004\b&\u0010/R\u0013\u00103\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/NotifyGuestCardViewBase;", "", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/b;", "data", "", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/reminder/chats/notifycard/model/b;)V", "Landroid/view/View;", "root", "k", DomainData.DOMAIN_NAME, "(Landroid/view/View;)V", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;", "f", "()Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;", "mCard", "Lcom/tencent/mobileqq/reminder/chats/notifycard/manager/b;", "e", "Lkotlin/Lazy;", "g", "()Lcom/tencent/mobileqq/reminder/chats/notifycard/manager/b;", "mManager", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b;", "()Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b;", "setMActionBtn$qqreminder_impl_release", "(Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b;)V", "mActionBtn", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "setMTitleTv$qqreminder_impl_release", "(Landroid/widget/TextView;)V", "mTitleTv", "", "i", "Z", "mIsRequesting", "Landroid/view/View;", "mRootView", BdhLogUtil.LogTag.Tag_Conn, "mSubTitleTv", "Landroid/graphics/drawable/ColorDrawable;", "D", "()Landroid/graphics/drawable/ColorDrawable;", "mTransparentDrawable", "j", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;)V", "E", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class NotifyGuestCardViewBase {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mSubTitleTv;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTransparentDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mCard;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mActionBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTitleTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRequesting;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/NotifyGuestCardViewBase$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyGuestCardViewBase$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22278);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NotifyGuestCardViewBase(@NotNull a mCard) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mCard, "mCard");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mCard);
            return;
        }
        this.mCard = mCard;
        lazy = LazyKt__LazyJVMKt.lazy(NotifyGuestCardViewBase$mManager$2.INSTANCE);
        this.mManager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(NotifyGuestCardViewBase$mTransparentDrawable$2.INSTANCE);
        this.mTransparentDrawable = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final NotifyGuestCardViewBase this$0, final View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.g().a()) {
            com.tencent.mobileqq.cardcontainer.e a16 = this$0.mCard.a();
            String str = null;
            if (a16 != null) {
                e.a.b(a16, null, 1, null);
            }
            Object tag = view.getTag(R.id.dzz);
            if (tag instanceof String) {
                str = (String) tag;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QQReminderUtil.D(view.getContext(), str);
            } else if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(view.getContext(), 1, "\u53d1\u9001\u5931\u8d25", 0).show();
            } else {
                b bVar = this$0.mActionBtn;
                if (bVar != null) {
                    bVar.f(false);
                }
                this$0.mIsRequesting = true;
                this$0.g().d(new Function3<Boolean, Integer, String, Unit>(view) { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyGuestCardViewBase$initView$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View $it;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                        this.$it = view;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyGuestCardViewBase.this, (Object) view);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str2) {
                        invoke(bool.booleanValue(), num.intValue(), str2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17, int i3, @Nullable String str2) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z17), Integer.valueOf(i3), str2);
                            return;
                        }
                        QLog.d("NotifyGuestCardViewBase", 1, "after send time message success: " + z17);
                        NotifyGuestCardViewBase.this.mIsRequesting = false;
                        if (z17) {
                            NotifyGuestCardViewBase.this.f().c(false);
                            QQToast.makeText(this.$it.getContext(), 2, "\u795d\u798f\u4f1a\u5728\u751f\u65e5\u5f53\u5929\u9001\u8fbe", 1).show();
                            return;
                        }
                        QQToast.makeText(this.$it.getContext(), 1, "\u53d1\u9001\u5931\u8d25", 0).show();
                        b e16 = NotifyGuestCardViewBase.this.e();
                        if (e16 == null) {
                            return;
                        }
                        e16.f(!NotifyGuestCardViewBase.this.g().a());
                    }
                });
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void d(@NotNull com.tencent.mobileqq.reminder.chats.notifycard.model.b data) {
        ImageView c16;
        View d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        b bVar = this.mActionBtn;
        if (bVar != null && (d16 = bVar.d()) != null) {
            d16.setTag(R.id.dzz, data.A());
        }
        b bVar2 = this.mActionBtn;
        if (bVar2 != null) {
            bVar2.e(data.v());
        }
        b bVar3 = this.mActionBtn;
        if (bVar3 != null && (c16 = bVar3.c()) != null) {
            com.tencent.mobileqq.reminder.util.e.c(c16, data.u(), null, i(), 2, null);
        }
        TextView textView = this.mSubTitleTv;
        if (textView != null) {
            textView.setText(data.B());
        }
        m(data);
    }

    @Nullable
    public final b e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mActionBtn;
    }

    @NotNull
    public final a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mCard;
    }

    @NotNull
    public final com.tencent.mobileqq.reminder.chats.notifycard.manager.b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.reminder.chats.notifycard.manager.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (com.tencent.mobileqq.reminder.chats.notifycard.manager.b) this.mManager.getValue();
    }

    @Nullable
    public final TextView h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mTitleTv;
    }

    @NotNull
    public final ColorDrawable i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ColorDrawable) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (ColorDrawable) this.mTransparentDrawable.getValue();
    }

    @Nullable
    public final View j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mRootView;
    }

    public final void k(@Nullable View root) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) root);
            return;
        }
        this.mRootView = root;
        if (root != null) {
            b a16 = b.INSTANCE.a(root, R.id.f166436zu4);
            this.mActionBtn = a16;
            if (a16 != null) {
                a16.b(R.id.zu6);
            }
            b bVar = this.mActionBtn;
            if (bVar != null) {
                bVar.a(R.id.zu5);
            }
        }
        TextView textView2 = null;
        if (root != null) {
            textView = (TextView) root.findViewById(R.id.f166435zu3);
        } else {
            textView = null;
        }
        this.mTitleTv = textView;
        if (root != null) {
            textView2 = (TextView) root.findViewById(R.id.f166434zu2);
        }
        this.mSubTitleTv = textView2;
        n(root);
        b bVar2 = this.mActionBtn;
        if (bVar2 != null) {
            bVar2.f(false);
        }
        b bVar3 = this.mActionBtn;
        if (bVar3 != null) {
            b.h(bVar3, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotifyGuestCardViewBase.l(NotifyGuestCardViewBase.this, view);
                }
            }, 1, null);
        }
    }

    public abstract void m(@NotNull com.tencent.mobileqq.reminder.chats.notifycard.model.b data);

    public abstract void n(@Nullable View root);
}
