package com.tencent.mobileqq.reminder.chats.notifycard.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0010\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0010\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/f;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/NotifyGuestCardViewBase;", "", "nick", "title", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "root", DomainData.DOMAIN_NAME, "(Landroid/view/View;)V", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/b;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/reminder/chats/notifycard/model/b;)V", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "mHeadBg", "G", "mHeadPendant", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "H", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "mAvatarView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mUserSubTitle", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;", IndividuationUrlHelper.UrlId.CARD_HOME, "<init>", "(Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;)V", "J", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends NotifyGuestCardViewBase {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView mHeadBg;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView mHeadPendant;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QQProAvatarView mAvatarView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView mUserSubTitle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.view.f$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull a card) {
        super(card);
        Intrinsics.checkNotNullParameter(card, "card");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) card);
        }
    }

    private final void q(final String nick, final String title) {
        final TextView h16 = h();
        if (h16 == null) {
            return;
        }
        h16.post(new Runnable() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.e
            @Override // java.lang.Runnable
            public final void run() {
                f.r(h16, title, nick);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(TextView titleTv, String title, String nick) {
        Intrinsics.checkNotNullParameter(titleTv, "$titleTv");
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(nick, "$nick");
        String subQQTextString = TextUtils.subQQTextString(nick, titleTv.getPaint(), 3, 16, titleTv.getWidth() - ((int) titleTv.getPaint().measureText("\u2026" + title)), true);
        Intrinsics.checkNotNullExpressionValue(subQQTextString, "subQQTextString(\n       \u2026       true\n            )");
        String str = subQQTextString + title;
        QLog.d("NotifyGuestCardSingleView", 1, "set title final: " + str);
        titleTv.setText(str);
    }

    private final void s() {
        final ViewGroup.LayoutParams layoutParams;
        final TextView h16;
        View d16;
        b e16 = e();
        if (e16 != null && (d16 = e16.d()) != null) {
            layoutParams = d16.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams == null || (h16 = h()) == null) {
            return;
        }
        h16.post(new Runnable() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.d
            @Override // java.lang.Runnable
            public final void run() {
                f.t(h16, layoutParams, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(TextView titleTv, ViewGroup.LayoutParams buttonLp, f this$0) {
        View view;
        Intrinsics.checkNotNullParameter(titleTv, "$titleTv");
        Intrinsics.checkNotNullParameter(buttonLp, "$buttonLp");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int dimensionPixelSize = titleTv.getResources().getDimensionPixelSize(R.dimen.cx_);
        boolean z16 = true;
        if (titleTv.getWidth() >= buttonLp.width && titleTv.getWidth() >= dimensionPixelSize) {
            if (buttonLp.width != dimensionPixelSize) {
                buttonLp.width = dimensionPixelSize;
            }
            z16 = false;
        } else {
            if (buttonLp.width != titleTv.getWidth()) {
                buttonLp.width = titleTv.getWidth();
            }
            z16 = false;
        }
        if (z16) {
            b e16 = this$0.e();
            if (e16 != null) {
                view = e16.d();
            } else {
                view = null;
            }
            if (view != null) {
                view.setLayoutParams(buttonLp);
            }
        }
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyGuestCardViewBase
    public void m(@NotNull com.tencent.mobileqq.reminder.chats.notifycard.model.b data) {
        List<com.tencent.mobileqq.reminder.chats.notifycard.model.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.C().isEmpty()) {
            QLog.e("NotifyGuestCardSingleView", 1, "Invalid data! User list is empty!");
            return;
        }
        com.tencent.mobileqq.reminder.chats.notifycard.model.d dVar = data.C().get(0);
        Intrinsics.checkNotNullExpressionValue(dVar, "data.userList[0]");
        com.tencent.mobileqq.reminder.chats.notifycard.model.d dVar2 = dVar;
        dVar2.e(true);
        com.tencent.mobileqq.reminder.chats.notifycard.manager.b g16 = g();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(dVar2);
        g16.c(listOf);
        b e16 = e();
        if (e16 != null) {
            e16.f(true);
        }
        String b16 = dVar2.b();
        String l3 = data.l();
        if (l3 == null) {
            l3 = "";
        }
        q(b16, l3);
        TextView textView = this.mUserSubTitle;
        if (textView != null) {
            textView.setText(dVar2.a());
        }
        QQProAvatarView qQProAvatarView = this.mAvatarView;
        if (qQProAvatarView != null) {
            qQProAvatarView.w(1, String.valueOf(dVar2.c()));
        }
        ImageView imageView = this.mHeadBg;
        if (imageView != null) {
            com.tencent.mobileqq.reminder.util.e.c(imageView, data.y(), null, i(), 2, null);
        }
        ImageView imageView2 = this.mHeadPendant;
        if (imageView2 != null) {
            com.tencent.mobileqq.reminder.util.e.c(imageView2, data.z(), null, i(), 2, null);
        }
        s();
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyGuestCardViewBase
    public void n(@Nullable View root) {
        ImageView imageView;
        ImageView imageView2;
        QQProAvatarView qQProAvatarView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) root);
            return;
        }
        TextView textView = null;
        if (root != null) {
            imageView = (ImageView) root.findViewById(R.id.zu7);
        } else {
            imageView = null;
        }
        this.mHeadBg = imageView;
        if (root != null) {
            imageView2 = (ImageView) root.findViewById(R.id.zu8);
        } else {
            imageView2 = null;
        }
        this.mHeadPendant = imageView2;
        if (root != null) {
            qQProAvatarView = (QQProAvatarView) root.findViewById(R.id.zty);
        } else {
            qQProAvatarView = null;
        }
        this.mAvatarView = qQProAvatarView;
        if (root != null) {
            textView = (TextView) root.findViewById(R.id.zug);
        }
        this.mUserSubTitle = textView;
        if (root != null) {
            com.tencent.mobileqq.reminder.util.a aVar = com.tencent.mobileqq.reminder.util.a.f281112a;
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            aVar.a(context, root);
        }
    }
}
