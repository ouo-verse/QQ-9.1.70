package com.tencent.mobileqq.reminder.chats.notifycard.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.cardcontainer.d;
import com.tencent.mobileqq.cardcontainer.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.chats.notifycard.view.b;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.mobileqq.reminder.util.c;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0016B\u000f\u0012\u0006\u0010B\u001a\u00020A\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010$R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010$R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u001c\u00107\u001a\b\u0012\u0004\u0012\u000204038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/NotifyMainCardView;", "Lcom/tencent/mobileqq/cardcontainer/d;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;", "Lcom/tencent/mobileqq/reminder/multishare/listener/a;", "Landroid/view/View;", "root", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/c;", "data", "k", "view", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lcom/tencent/mobileqq/cardcontainer/e;", "host", "d", "getView", "needReport", "c", "a", "e", "f", "Lcom/tencent/mobileqq/cardcontainer/e;", "mCardViewHost", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b;", "mMainActionBtn", tl.h.F, "mSubActionBtn", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mHeadBg", "mHeadPendant", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/AvatarLoopView;", "mAvatarLoop", "D", "mCardBg", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mTitle", UserInfo.SEX_FEMALE, "mSubTitle", "", "", "G", "Ljava/util/List;", "mUserUinList", "H", "Ljava/lang/String;", "mMsgHint", "Landroid/graphics/drawable/ColorDrawable;", "I", "Lkotlin/Lazy;", "l", "()Landroid/graphics/drawable/ColorDrawable;", "mTransparentDrawable", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "J", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NotifyMainCardView implements com.tencent.mobileqq.cardcontainer.d, a, com.tencent.mobileqq.reminder.multishare.listener.a {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AvatarLoopView mAvatarLoop;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView mCardBg;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView mTitle;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mSubTitle;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<String> mUserUinList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String mMsgHint;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTransparentDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.cardcontainer.e mCardViewHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mMainActionBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mSubActionBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mHeadBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mHeadPendant;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/NotifyMainCardView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyMainCardView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22285);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NotifyMainCardView(@NotNull ViewGroup parent) {
        List<String> emptyList;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(parent, "parent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parent);
            return;
        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fp9, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026card_view, parent, false)");
        this.mRootView = inflate;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mUserUinList = emptyList;
        this.mMsgHint = "";
        lazy = LazyKt__LazyJVMKt.lazy(NotifyMainCardView$mTransparentDrawable$2.INSTANCE);
        this.mTransparentDrawable = lazy;
        m(inflate);
    }

    private final void k(com.tencent.mobileqq.reminder.chats.notifycard.model.c data) {
        View d16;
        View d17;
        b bVar = this.mMainActionBtn;
        if (bVar != null) {
            bVar.e(data.y().b());
        }
        b bVar2 = this.mMainActionBtn;
        if (bVar2 != null && (d17 = bVar2.d()) != null) {
            d17.setTag(R.id.dzz, data.y().a());
        }
        com.tencent.mobileqq.reminder.chats.notifycard.model.a A = data.A();
        if (A != null) {
            b bVar3 = this.mSubActionBtn;
            if (bVar3 != null) {
                bVar3.e(A.b());
            }
            b bVar4 = this.mSubActionBtn;
            if (bVar4 != null && (d16 = bVar4.d()) != null) {
                d16.setTag(R.id.dzz, A.a());
            }
            b bVar5 = this.mSubActionBtn;
            if (bVar5 != null) {
                bVar5.i(8);
            }
        } else {
            b bVar6 = this.mSubActionBtn;
            if (bVar6 != null) {
                bVar6.i(8);
            }
        }
        ImageView imageView = this.mHeadBg;
        if (imageView != null) {
            com.tencent.mobileqq.reminder.util.e.c(imageView, data.w(), null, l(), 2, null);
        }
        ImageView imageView2 = this.mHeadPendant;
        if (imageView2 != null) {
            com.tencent.mobileqq.reminder.util.e.c(imageView2, data.x(), null, l(), 2, null);
        }
        ImageView imageView3 = this.mCardBg;
        if (imageView3 != null) {
            com.tencent.mobileqq.reminder.util.e.c(imageView3, data.j(), null, l(), 2, null);
        }
        TextView textView = this.mSubTitle;
        if (textView != null) {
            textView.setText(data.k());
        }
        r(data);
        AvatarLoopView avatarLoopView = this.mAvatarLoop;
        if (avatarLoopView != null) {
            avatarLoopView.E(data.B());
        }
        this.mUserUinList = data.B();
        this.mMsgHint = data.v();
    }

    private final ColorDrawable l() {
        return (ColorDrawable) this.mTransparentDrawable.getValue();
    }

    private final void m(View root) {
        String str;
        b.Companion companion = b.INSTANCE;
        b a16 = companion.a(root, R.id.zu9);
        this.mMainActionBtn = a16;
        if (a16 != null) {
            a16.b(R.id.zu_);
        }
        b a17 = companion.a(root, R.id.zua);
        this.mSubActionBtn = a17;
        if (a17 != null) {
            a17.b(R.id.zub);
        }
        this.mCardBg = (ImageView) root.findViewById(R.id.f166432zu0);
        this.mHeadBg = (ImageView) root.findViewById(R.id.zu7);
        this.mHeadPendant = (ImageView) root.findViewById(R.id.zu8);
        this.mAvatarLoop = (AvatarLoopView) root.findViewById(R.id.ztz);
        this.mTitle = (TextView) root.findViewById(R.id.f166435zu3);
        this.mSubTitle = (TextView) root.findViewById(R.id.f166434zu2);
        ImageView imageView = this.mCardBg;
        if (imageView != null) {
            imageView.setClipToOutline(true);
        }
        root.findViewById(R.id.f166433zu1).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotifyMainCardView.n(NotifyMainCardView.this, view);
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        ((QQProAvatarView) root.findViewById(R.id.zty)).w(1, str);
        b bVar = this.mMainActionBtn;
        if (bVar != null) {
            bVar.g(500L, new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotifyMainCardView.o(NotifyMainCardView.this, view);
                }
            });
        }
        b bVar2 = this.mSubActionBtn;
        if (bVar2 != null) {
            bVar2.g(500L, new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotifyMainCardView.p(NotifyMainCardView.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(NotifyMainCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(NotifyMainCardView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.cardcontainer.e eVar = this$0.mCardViewHost;
        if (eVar != null) {
            e.a.b(eVar, null, 1, null);
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!this$0.q(it) && !this$0.mUserUinList.isEmpty()) {
            com.tencent.mobileqq.reminder.multishare.config.a aVar = new com.tencent.mobileqq.reminder.multishare.config.a(this$0.mUserUinList, this$0.mMsgHint, false, this$0, 4, null);
            c.Companion companion = com.tencent.mobileqq.reminder.util.c.INSTANCE;
            Context context = it.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            companion.e(context, aVar);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(NotifyMainCardView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.q(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final boolean q(View view) {
        String str;
        boolean z16;
        Object tag = view.getTag(R.id.dzz);
        if (tag instanceof String) {
            str = (String) tag;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        QQReminderUtil.D(view.getContext(), str);
        return true;
    }

    private final void r(final com.tencent.mobileqq.reminder.chats.notifycard.model.c data) {
        final TextView textView = this.mTitle;
        if (textView == null) {
            return;
        }
        textView.post(new Runnable() { // from class: com.tencent.mobileqq.reminder.chats.notifycard.view.l
            @Override // java.lang.Runnable
            public final void run() {
                NotifyMainCardView.s(textView, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(TextView titleTv, com.tencent.mobileqq.reminder.chats.notifycard.model.c data) {
        Intrinsics.checkNotNullParameter(titleTv, "$titleTv");
        Intrinsics.checkNotNullParameter(data, "$data");
        String subQQTextString = TextUtils.subQQTextString(data.z(), titleTv.getPaint(), 3, 16, titleTv.getWidth() - ((int) titleTv.getPaint().measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX + data.l())), true);
        Intrinsics.checkNotNullExpressionValue(subQQTextString, "subQQTextString(\n       \u2026       true\n            )");
        titleTv.setText(subQQTextString + data.l());
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.view.a
    @Nullable
    public com.tencent.mobileqq.cardcontainer.e a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.cardcontainer.e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mCardViewHost;
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            d.a.a(this);
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
        if (this.mCardViewHost == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("NotifyMainCardView", 1, "closeCard needReport: " + needReport + " host is null: " + z16);
        com.tencent.mobileqq.cardcontainer.e eVar2 = this.mCardViewHost;
        if (eVar2 != null) {
            eVar2.F8();
        }
        if (needReport && (eVar = this.mCardViewHost) != null) {
            e.a.c(eVar, null, 1, null);
        }
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
        this.mCardViewHost = host;
        if (data instanceof com.tencent.mobileqq.reminder.chats.notifycard.model.c) {
            k((com.tencent.mobileqq.reminder.chats.notifycard.model.c) data);
        }
    }

    @Override // com.tencent.mobileqq.reminder.multishare.listener.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QQToast.makeText(this.mRootView.getContext(), 0, "\u5b57\u6570\u5df2\u8fbe\u4e0a\u9650", 0).show();
        }
    }

    @Override // com.tencent.mobileqq.reminder.multishare.listener.a
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            QQToast.makeText(this.mRootView.getContext(), "\u53d1\u9001\u6210\u529f", 0).show();
            c(false);
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
