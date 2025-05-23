package com.tencent.qqnt.chats.kit.x2k;

import android.content.Context;
import android.os.Trace;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.aio.view_dsl.dsl.f;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemRightLayout;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.chats.view.SingeLineSummaryView;
import com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper;
import com.tencent.qqnt.chats.view.widget.SummaryLayout;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 >2\u00020\u0001:\u0001\u0007B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`\u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010@\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b=\u0010\u0014\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R\"\u0010G\u001a\u00020A8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010Q\u001a\u00020H8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bK\u0010J\u001a\u0004\b.\u0010L\"\u0004\bP\u0010NR\"\u0010W\u001a\u00020R8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010S\u001a\u0004\b6\u0010T\"\u0004\bU\u0010VR\"\u0010Y\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b=\u0010\u000e\"\u0004\bX\u0010\u0010R\"\u0010_\u001a\u00020Z8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bC\u0010[\u001a\u0004\bI\u0010\\\"\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/qqnt/chats/kit/x2k/ChatRecentContactItemLayout;", "Landroidx/viewbinding/ViewBinding;", "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", DomainData.DOMAIN_NAME, "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "t", "()Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "I", "(Lcom/tencent/qqnt/widget/SwipeMenuLayout;)V", "_root", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "j", "()Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/widget/ImageView;)V", "diyMsgBg", "Lcom/tencent/qqnt/chats/view/widget/RecentAvatarViewWrapper;", "d", "Lcom/tencent/qqnt/chats/view/widget/RecentAvatarViewWrapper;", "f", "()Lcom/tencent/qqnt/chats/view/widget/RecentAvatarViewWrapper;", "u", "(Lcom/tencent/qqnt/chats/view/widget/RecentAvatarViewWrapper;)V", "avatar", "e", "r", "G", "titleLeftIcon", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "E", "(Lcom/tencent/qqnt/classadapter/SingleLineTextView;)V", "title", "Landroid/widget/LinearLayout;", "g", "Landroid/widget/LinearLayout;", "getTitleLayout", "()Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "(Landroid/widget/LinearLayout;)V", "titleLayout", "Lcom/tencent/qqnt/chats/view/RollingTextView;", h.F, "Lcom/tencent/qqnt/chats/view/RollingTextView;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/qqnt/chats/view/RollingTextView;", "H", "(Lcom/tencent/qqnt/chats/view/RollingTextView;)V", "unread", "i", "p", "D", "summaryRightView", "Landroid/view/View;", "Landroid/view/View;", "o", "()Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "(Landroid/view/View;)V", "summary", "Landroid/widget/RelativeLayout;", "k", "Landroid/widget/RelativeLayout;", "l", "()Landroid/widget/RelativeLayout;", "B", "(Landroid/widget/RelativeLayout;)V", "rightLayout", "v", "chatContent", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "()Landroidx/appcompat/widget/LinearLayoutCompat;", "w", "(Landroidx/appcompat/widget/LinearLayoutCompat;)V", "chatMenu", "y", "chatSwipeLayout", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "()Landroid/widget/FrameLayout;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/widget/FrameLayout;)V", "rightExt", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatRecentContactItemLayout implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f355162q;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public SwipeMenuLayout _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public ImageView diyMsgBg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public RecentAvatarViewWrapper avatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ImageView titleLeftIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public SingleLineTextView title;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public LinearLayout titleLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public RollingTextView unread;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public ImageView summaryRightView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public View summary;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout rightLayout;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout chatContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public LinearLayoutCompat chatMenu;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public SwipeMenuLayout chatSwipeLayout;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public FrameLayout rightExt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/kit/x2k/ChatRecentContactItemLayout$a;", "", "", "summarySwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "summarySwitch", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.kit.x2k.ChatRecentContactItemLayout$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) ChatRecentContactItemLayout.f355162q.getValue()).booleanValue();
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
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45778);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(ChatRecentContactItemLayout$Companion$summarySwitch$2.INSTANCE);
        f355162q = lazy;
    }

    public ChatRecentContactItemLayout(@NotNull Context context, @Nullable Integer num) {
        SwipeMenuLayout n3;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
            return;
        }
        this.context = context;
        if (num != null) {
            n3 = n(new ContextThemeWrapper(context, num.intValue()));
        } else {
            n3 = n(context);
        }
        I(n3);
    }

    public final void A(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.rightExt = frameLayout;
        }
    }

    public final void B(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.rightLayout = relativeLayout;
        }
    }

    public final void C(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.summary = view;
        }
    }

    public final void D(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.summaryRightView = imageView;
        }
    }

    public final void E(@NotNull SingleLineTextView singleLineTextView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) singleLineTextView);
        } else {
            Intrinsics.checkNotNullParameter(singleLineTextView, "<set-?>");
            this.title = singleLineTextView;
        }
    }

    public final void F(@NotNull LinearLayout linearLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) linearLayout);
        } else {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.titleLayout = linearLayout;
        }
    }

    public final void G(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.titleLeftIcon = imageView;
        }
    }

    public final void H(@NotNull RollingTextView rollingTextView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) rollingTextView);
        } else {
            Intrinsics.checkNotNullParameter(rollingTextView, "<set-?>");
            this.unread = rollingTextView;
        }
    }

    public final void I(@NotNull SwipeMenuLayout swipeMenuLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) swipeMenuLayout);
        } else {
            Intrinsics.checkNotNullParameter(swipeMenuLayout, "<set-?>");
            this._root = swipeMenuLayout;
        }
    }

    @NotNull
    public final RecentAvatarViewWrapper f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RecentAvatarViewWrapper) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        RecentAvatarViewWrapper recentAvatarViewWrapper = this.avatar;
        if (recentAvatarViewWrapper != null) {
            return recentAvatarViewWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("avatar");
        return null;
    }

    @NotNull
    public final RelativeLayout g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        RelativeLayout relativeLayout = this.chatContent;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chatContent");
        return null;
    }

    @NotNull
    public final LinearLayoutCompat h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (LinearLayoutCompat) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        LinearLayoutCompat linearLayoutCompat = this.chatMenu;
        if (linearLayoutCompat != null) {
            return linearLayoutCompat;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chatMenu");
        return null;
    }

    @NotNull
    public final SwipeMenuLayout i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (SwipeMenuLayout) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        SwipeMenuLayout swipeMenuLayout = this.chatSwipeLayout;
        if (swipeMenuLayout != null) {
            return swipeMenuLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chatSwipeLayout");
        return null;
    }

    @NotNull
    public final ImageView j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ImageView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ImageView imageView = this.diyMsgBg;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("diyMsgBg");
        return null;
    }

    @NotNull
    public final FrameLayout k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        FrameLayout frameLayout = this.rightExt;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rightExt");
        return null;
    }

    @NotNull
    public final RelativeLayout l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        RelativeLayout relativeLayout = this.rightLayout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public SwipeMenuLayout getMContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (SwipeMenuLayout) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v68, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r14v13, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r15v11, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r15v24, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.lang.Object, com.tencent.qqnt.chats.kit.x2k.ChatRecentContactItemLayout] */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemRightLayout, android.view.View, android.widget.RelativeLayout, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View, java.lang.Object, android.view.ViewGroup, com.tencent.qqnt.widget.SwipeMenuLayout] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.widget.RelativeLayout, android.view.View, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r6v58, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v16, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r7v42, types: [android.view.ViewGroup$LayoutParams] */
    @NotNull
    public final SwipeMenuLayout n(@NotNull Context context) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i3;
        ViewGroup.LayoutParams layoutParams;
        boolean z16;
        ViewGroup.LayoutParams layoutParams2;
        boolean z17;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int i16;
        String str;
        boolean z18;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        int i17;
        ViewGroup.LayoutParams layoutParams5;
        boolean z19;
        ViewGroup.LayoutParams layoutParams6;
        int i18;
        ViewGroup.LayoutParams layoutParams7;
        int i19;
        ViewGroup.LayoutParams layoutParams8;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (SwipeMenuLayout) iPatchRedirector.redirect((short) 33, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ?? swipeMenuLayout = new SwipeMenuLayout(context);
        int l3 = com.tencent.aio.view_dsl.dsl.b.l();
        if (swipeMenuLayout.getLayoutParams() == null) {
            swipeMenuLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            swipeMenuLayout.getLayoutParams().width = l3;
        }
        swipeMenuLayout.setId(R.id.tu6);
        int dimension = (int) context.getResources().getDimension(R.dimen.f159540au0);
        if (swipeMenuLayout.getLayoutParams() == null) {
            swipeMenuLayout.setLayoutParams(new ViewGroup.LayoutParams(0, dimension));
        } else {
            swipeMenuLayout.getLayoutParams().height = dimension;
        }
        swipeMenuLayout.setClipChildren(false);
        swipeMenuLayout.setClipToPadding(false);
        Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
        ?? relativeLayout = new RelativeLayout(swipeMenuLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(swipeMenuLayout, new Object[0]);
        if (invoke != null) {
            relativeLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l16 = com.tencent.aio.view_dsl.dsl.b.l();
            if (relativeLayout.getLayoutParams() == null) {
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
            } else {
                relativeLayout.getLayoutParams().width = l16;
            }
            relativeLayout.setId(R.id.aua);
            int l17 = com.tencent.aio.view_dsl.dsl.b.l();
            if (relativeLayout.getLayoutParams() == null) {
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l17));
            } else {
                relativeLayout.getLayoutParams().height = l17;
            }
            ViewGroup.LayoutParams layoutParams9 = relativeLayout.getLayoutParams();
            if (!(layoutParams9 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams9 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams9;
            boolean z26 = true;
            if (marginLayoutParams4 != null) {
                MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams4, 0);
                marginLayoutParams = marginLayoutParams4;
            } else {
                ViewGroup.LayoutParams layoutParams10 = relativeLayout.getLayoutParams();
                int i26 = layoutParams10 != null ? layoutParams10.width : 0;
                ViewGroup.LayoutParams layoutParams11 = relativeLayout.getLayoutParams();
                Object[] objArr = {new ViewGroup.LayoutParams(i26, layoutParams11 != null ? layoutParams11.height : 0)};
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(objArr[0].getClass());
                Object[] array = arrayList.toArray(new Class[0]);
                if (array != null) {
                    Class[] clsArr = (Class[]) array;
                    Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    it.setAccessible(true);
                    Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                    MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance, 0);
                    marginLayoutParams = (ViewGroup.LayoutParams) newInstance;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            relativeLayout.setLayoutParams(marginLayoutParams);
            relativeLayout.setClipChildren(false);
            relativeLayout.setClipToPadding(false);
            Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
            ImageView imageView = new ImageView(relativeLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
            if (invoke2 != null) {
                imageView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int l18 = com.tencent.aio.view_dsl.dsl.b.l();
                if (imageView.getLayoutParams() == null) {
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(l18, 0));
                } else {
                    imageView.getLayoutParams().width = l18;
                }
                imageView.setId(R.id.f165003uk2);
                int l19 = com.tencent.aio.view_dsl.dsl.b.l();
                if (imageView.getLayoutParams() == null) {
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(0, l19));
                } else {
                    imageView.getLayoutParams().height = l19;
                }
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setVisibility(8);
                z(imageView);
                relativeLayout.addView(imageView);
                Trace.endSection();
                FrameLayout frameLayout = new FrameLayout(relativeLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                if (invoke3 != null) {
                    frameLayout.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int dimension2 = (int) context.getResources().getDimension(R.dimen.dbq);
                    if (frameLayout.getLayoutParams() == null) {
                        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(dimension2, 0));
                    } else {
                        frameLayout.getLayoutParams().width = dimension2;
                    }
                    frameLayout.setId(R.id.f164548a32);
                    int dimension3 = (int) context.getResources().getDimension(R.dimen.dbq);
                    if (frameLayout.getLayoutParams() == null) {
                        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, dimension3));
                    } else {
                        frameLayout.getLayoutParams().height = dimension3;
                    }
                    int dimension4 = (int) context.getResources().getDimension(R.dimen.f158727nh);
                    ViewGroup.LayoutParams layoutParams12 = frameLayout.getLayoutParams();
                    if (!(layoutParams12 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams12 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams12;
                    if (marginLayoutParams5 != null) {
                        MarginLayoutParamsCompat.setMarginStart(marginLayoutParams5, dimension4);
                        marginLayoutParams2 = marginLayoutParams5;
                    } else {
                        ViewGroup.LayoutParams layoutParams13 = frameLayout.getLayoutParams();
                        int i27 = layoutParams13 != null ? layoutParams13.width : 0;
                        ViewGroup.LayoutParams layoutParams14 = frameLayout.getLayoutParams();
                        Object[] objArr2 = {new ViewGroup.LayoutParams(i27, layoutParams14 != null ? layoutParams14.height : 0)};
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(objArr2[0].getClass());
                        Object[] array2 = arrayList2.toArray(new Class[0]);
                        if (array2 != null) {
                            Class[] clsArr2 = (Class[]) array2;
                            Constructor it5 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                            Intrinsics.checkNotNullExpressionValue(it5, "it");
                            z26 = true;
                            it5.setAccessible(true);
                            Object newInstance2 = it5.newInstance(Arrays.copyOf(objArr2, 1));
                            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance2, dimension4);
                            marginLayoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    frameLayout.setLayoutParams(marginLayoutParams2);
                    frameLayout.setLayerType(2, null);
                    f.o(frameLayout, z26);
                    Context context2 = frameLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    RecentAvatarViewWrapper recentAvatarViewWrapper = new RecentAvatarViewWrapper(context2);
                    frameLayout.addView(recentAvatarViewWrapper);
                    int dimension5 = (int) context.getResources().getDimension(R.dimen.b96);
                    if (recentAvatarViewWrapper.getLayoutParams() == null) {
                        recentAvatarViewWrapper.setLayoutParams(new ViewGroup.LayoutParams(dimension5, 0));
                    } else {
                        recentAvatarViewWrapper.getLayoutParams().width = dimension5;
                    }
                    recentAvatarViewWrapper.setId(R.id.a2o);
                    int dimension6 = (int) context.getResources().getDimension(R.dimen.b96);
                    if (recentAvatarViewWrapper.getLayoutParams() == null) {
                        recentAvatarViewWrapper.setLayoutParams(new ViewGroup.LayoutParams(0, dimension6));
                    } else {
                        recentAvatarViewWrapper.getLayoutParams().height = dimension6;
                    }
                    f.p(recentAvatarViewWrapper, com.tencent.aio.view_dsl.dsl.b.e());
                    recentAvatarViewWrapper.setImportantForAccessibility(2);
                    u(recentAvatarViewWrapper);
                    RollingTextView rollingTextView = new RollingTextView(new ContextThemeWrapper(frameLayout.getContext(), R.style.f173404cg));
                    frameLayout.addView(rollingTextView);
                    rollingTextView.setId(R.id.f114236ss);
                    int p16 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (rollingTextView.getLayoutParams() == null) {
                        i3 = 0;
                        rollingTextView.setLayoutParams(new ViewGroup.LayoutParams(p16, 0));
                    } else {
                        i3 = 0;
                        rollingTextView.getLayoutParams().width = p16;
                    }
                    int p17 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (rollingTextView.getLayoutParams() == null) {
                        rollingTextView.setLayoutParams(new ViewGroup.LayoutParams(i3, p17));
                    } else {
                        rollingTextView.getLayoutParams().height = p17;
                    }
                    int intValue = ((Number) a.a(Integer.valueOf(i3))).intValue();
                    rollingTextView.setPadding(intValue, intValue, intValue, intValue);
                    f.p(rollingTextView, com.tencent.aio.view_dsl.dsl.b.k() | com.tencent.aio.view_dsl.dsl.b.h());
                    int intValue2 = ((Number) a.a(2)).intValue();
                    ViewGroup.LayoutParams layoutParams15 = rollingTextView.getLayoutParams();
                    if (!(layoutParams15 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams15 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams15;
                    if (marginLayoutParams6 != null) {
                        marginLayoutParams6.topMargin = intValue2;
                        layoutParams = marginLayoutParams6;
                    } else {
                        ViewGroup.LayoutParams layoutParams16 = rollingTextView.getLayoutParams();
                        int i28 = layoutParams16 != null ? layoutParams16.width : 0;
                        ViewGroup.LayoutParams layoutParams17 = rollingTextView.getLayoutParams();
                        Object[] objArr3 = {new ViewGroup.LayoutParams(i28, layoutParams17 != null ? layoutParams17.height : 0)};
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(objArr3[0].getClass());
                        Object[] array3 = arrayList3.toArray(new Class[0]);
                        if (array3 != null) {
                            Class[] clsArr3 = (Class[]) array3;
                            Constructor it6 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr3, clsArr3.length));
                            Intrinsics.checkNotNullExpressionValue(it6, "it");
                            it6.setAccessible(true);
                            Object newInstance3 = it6.newInstance(Arrays.copyOf(objArr3, 1));
                            ((ViewGroup.MarginLayoutParams) newInstance3).topMargin = intValue2;
                            layoutParams = (ViewGroup.LayoutParams) newInstance3;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    rollingTextView.setLayoutParams(layoutParams);
                    int intValue3 = ((Number) a.a(2)).intValue();
                    ViewGroup.LayoutParams layoutParams18 = rollingTextView.getLayoutParams();
                    if (!(layoutParams18 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams18 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams18;
                    if (marginLayoutParams7 != null) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams7, intValue3);
                        z16 = true;
                        layoutParams2 = marginLayoutParams7;
                    } else {
                        ViewGroup.LayoutParams layoutParams19 = rollingTextView.getLayoutParams();
                        int i29 = layoutParams19 != null ? layoutParams19.width : 0;
                        ViewGroup.LayoutParams layoutParams20 = rollingTextView.getLayoutParams();
                        Object[] objArr4 = {new ViewGroup.LayoutParams(i29, layoutParams20 != null ? layoutParams20.height : 0)};
                        ArrayList arrayList4 = new ArrayList(1);
                        arrayList4.add(objArr4[0].getClass());
                        Object[] array4 = arrayList4.toArray(new Class[0]);
                        if (array4 != null) {
                            Class[] clsArr4 = (Class[]) array4;
                            Constructor it7 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr4, clsArr4.length));
                            Intrinsics.checkNotNullExpressionValue(it7, "it");
                            z16 = true;
                            it7.setAccessible(true);
                            Object newInstance4 = it7.newInstance(Arrays.copyOf(objArr4, 1));
                            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance4, intValue3);
                            layoutParams2 = (ViewGroup.LayoutParams) newInstance4;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    rollingTextView.setLayoutParams(layoutParams2);
                    rollingTextView.setDuplicateParentStateEnabled(z16);
                    H(rollingTextView);
                    relativeLayout.addView(frameLayout);
                    ?? recentContactItemRightLayout = new RecentContactItemRightLayout(relativeLayout.getContext());
                    relativeLayout.addView(recentContactItemRightLayout);
                    int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (recentContactItemRightLayout.getLayoutParams() == null) {
                        recentContactItemRightLayout.setLayoutParams(new ViewGroup.LayoutParams(p18, 0));
                    } else {
                        recentContactItemRightLayout.getLayoutParams().width = p18;
                    }
                    recentContactItemRightLayout.setId(R.id.iag);
                    int p19 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (recentContactItemRightLayout.getLayoutParams() == null) {
                        recentContactItemRightLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p19));
                    } else {
                        recentContactItemRightLayout.getLayoutParams().height = p19;
                    }
                    int intValue4 = ((Number) a.a(1)).intValue();
                    ViewGroup.LayoutParams layoutParams21 = recentContactItemRightLayout.getLayoutParams();
                    if (!(layoutParams21 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams21 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams21;
                    if (marginLayoutParams8 != null) {
                        MarginLayoutParamsCompat.setMarginStart(marginLayoutParams8, intValue4);
                        z17 = true;
                        marginLayoutParams3 = marginLayoutParams8;
                    } else {
                        ViewGroup.LayoutParams layoutParams22 = recentContactItemRightLayout.getLayoutParams();
                        int i36 = layoutParams22 != null ? layoutParams22.width : 0;
                        ViewGroup.LayoutParams layoutParams23 = recentContactItemRightLayout.getLayoutParams();
                        Object[] objArr5 = {new ViewGroup.LayoutParams(i36, layoutParams23 != null ? layoutParams23.height : 0)};
                        ArrayList arrayList5 = new ArrayList(1);
                        arrayList5.add(objArr5[0].getClass());
                        Object[] array5 = arrayList5.toArray(new Class[0]);
                        if (array5 != null) {
                            Class[] clsArr5 = (Class[]) array5;
                            Constructor it8 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr5, clsArr5.length));
                            Intrinsics.checkNotNullExpressionValue(it8, "it");
                            z17 = true;
                            it8.setAccessible(true);
                            Object newInstance5 = it8.newInstance(Arrays.copyOf(objArr5, 1));
                            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance5, intValue4);
                            marginLayoutParams3 = (ViewGroup.LayoutParams) newInstance5;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    recentContactItemRightLayout.setLayoutParams(marginLayoutParams3);
                    f.q(recentContactItemRightLayout, R.id.f164548a32);
                    f.t(recentContactItemRightLayout, R.id.f164785tu1);
                    f.o(recentContactItemRightLayout, z17);
                    LinearLayout linearLayout = new LinearLayout(recentContactItemRightLayout.getContext());
                    Object invoke4 = LayoutBuilderKt.b().invoke(recentContactItemRightLayout, new Object[0]);
                    if (invoke4 != null) {
                        linearLayout.setLayoutParams((ViewGroup.LayoutParams) invoke4);
                        int p26 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (linearLayout.getLayoutParams() == null) {
                            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(p26, 0));
                        } else {
                            linearLayout.getLayoutParams().width = p26;
                        }
                        linearLayout.setId(R.id.jp7);
                        int p27 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (linearLayout.getLayoutParams() == null) {
                            i16 = 0;
                            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p27));
                        } else {
                            i16 = 0;
                            linearLayout.getLayoutParams().height = p27;
                        }
                        f.d(linearLayout, true);
                        f.h(linearLayout, true);
                        linearLayout.setOrientation(i16);
                        f.g(linearLayout, true);
                        Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                        ImageView imageView2 = new ImageView(linearLayout.getContext());
                        Object invoke5 = LayoutBuilderKt.b().invoke(linearLayout, new Object[i16]);
                        if (invoke5 != null) {
                            imageView2.setLayoutParams((ViewGroup.LayoutParams) invoke5);
                            int intValue5 = ((Number) a.a(18)).intValue();
                            if (imageView2.getLayoutParams() == null) {
                                imageView2.setLayoutParams(new ViewGroup.LayoutParams(intValue5, 0));
                            } else {
                                imageView2.getLayoutParams().width = intValue5;
                            }
                            imageView2.setId(R.id.f98685nr);
                            int intValue6 = ((Number) a.a(18)).intValue();
                            if (imageView2.getLayoutParams() == null) {
                                imageView2.setLayoutParams(new ViewGroup.LayoutParams(0, intValue6));
                            } else {
                                imageView2.getLayoutParams().height = intValue6;
                            }
                            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                            f.p(imageView2, com.tencent.aio.view_dsl.dsl.b.g());
                            imageView2.setVisibility(8);
                            G(imageView2);
                            linearLayout.addView(imageView2);
                            Trace.endSection();
                            SingleLineTextView singleLineTextView = new SingleLineTextView(linearLayout.getContext());
                            linearLayout.addView(singleLineTextView);
                            int l26 = com.tencent.aio.view_dsl.dsl.b.l();
                            if (singleLineTextView.getLayoutParams() == null) {
                                singleLineTextView.setLayoutParams(new ViewGroup.LayoutParams(l26, 0));
                            } else {
                                singleLineTextView.getLayoutParams().width = l26;
                            }
                            singleLineTextView.setId(R.id.title);
                            int p28 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (singleLineTextView.getLayoutParams() == null) {
                                singleLineTextView.setLayoutParams(new ViewGroup.LayoutParams(0, p28));
                            } else {
                                singleLineTextView.getLayoutParams().height = p28;
                            }
                            singleLineTextView.setPadding(singleLineTextView.getPaddingLeft(), singleLineTextView.getPaddingTop(), ((Number) a.a(8)).intValue(), singleLineTextView.getPaddingBottom());
                            d.b(singleLineTextView, 17.0f);
                            f.p(singleLineTextView, com.tencent.aio.view_dsl.dsl.b.g());
                            int intValue7 = ((Number) a.a(2)).intValue();
                            ViewGroup.LayoutParams layoutParams24 = singleLineTextView.getLayoutParams();
                            if (!(layoutParams24 instanceof ViewGroup.MarginLayoutParams)) {
                                layoutParams24 = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams9 = (ViewGroup.MarginLayoutParams) layoutParams24;
                            if (marginLayoutParams9 != null) {
                                marginLayoutParams9.bottomMargin = intValue7;
                                str = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams";
                                layoutParams3 = marginLayoutParams9;
                                z18 = true;
                            } else {
                                ViewGroup.LayoutParams layoutParams25 = singleLineTextView.getLayoutParams();
                                int i37 = layoutParams25 != null ? layoutParams25.width : 0;
                                ViewGroup.LayoutParams layoutParams26 = singleLineTextView.getLayoutParams();
                                Object[] objArr6 = {new ViewGroup.LayoutParams(i37, layoutParams26 != null ? layoutParams26.height : 0)};
                                ArrayList arrayList6 = new ArrayList(1);
                                arrayList6.add(objArr6[0].getClass());
                                str = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams";
                                Object[] array6 = arrayList6.toArray(new Class[0]);
                                if (array6 != null) {
                                    Class[] clsArr6 = (Class[]) array6;
                                    Constructor it9 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr6, clsArr6.length));
                                    Intrinsics.checkNotNullExpressionValue(it9, "it");
                                    z18 = true;
                                    it9.setAccessible(true);
                                    Object newInstance6 = it9.newInstance(Arrays.copyOf(objArr6, 1));
                                    ((ViewGroup.MarginLayoutParams) newInstance6).bottomMargin = intValue7;
                                    layoutParams3 = (ViewGroup.LayoutParams) newInstance6;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            singleLineTextView.setLayoutParams(layoutParams3);
                            singleLineTextView.setDuplicateParentStateEnabled(z18);
                            d.a(singleLineTextView, R.color.qui_common_text_primary);
                            E(singleLineTextView);
                            F(linearLayout);
                            recentContactItemRightLayout.addView(linearLayout);
                            Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                            ImageView imageView3 = new ImageView(recentContactItemRightLayout.getContext());
                            Object invoke6 = LayoutBuilderKt.b().invoke(recentContactItemRightLayout, new Object[0]);
                            if (invoke6 != null) {
                                imageView3.setLayoutParams((ViewGroup.LayoutParams) invoke6);
                                imageView3.setId(R.id.f907853e);
                                int intValue8 = ((Number) a.a(18)).intValue();
                                if (imageView3.getLayoutParams() == null) {
                                    imageView3.setLayoutParams(new ViewGroup.LayoutParams(intValue8, 0));
                                } else {
                                    imageView3.getLayoutParams().width = intValue8;
                                }
                                int intValue9 = ((Number) a.a(18)).intValue();
                                if (imageView3.getLayoutParams() == null) {
                                    imageView3.setLayoutParams(new ViewGroup.LayoutParams(0, intValue9));
                                } else {
                                    imageView3.getLayoutParams().height = intValue9;
                                }
                                f.m(imageView3, R.id.jp7);
                                f.d(imageView3, true);
                                imageView3.setDuplicateParentStateEnabled(true);
                                int intValue10 = ((Number) a.a(2)).intValue();
                                imageView3.setPadding(intValue10, intValue10, intValue10, intValue10);
                                int intValue11 = ((Number) a.a(6)).intValue();
                                ViewGroup.LayoutParams layoutParams27 = imageView3.getLayoutParams();
                                if (!(layoutParams27 instanceof ViewGroup.MarginLayoutParams)) {
                                    layoutParams27 = null;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams10 = (ViewGroup.MarginLayoutParams) layoutParams27;
                                if (marginLayoutParams10 != null) {
                                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams10, intValue11);
                                    layoutParams4 = marginLayoutParams10;
                                } else {
                                    ViewGroup.LayoutParams layoutParams28 = imageView3.getLayoutParams();
                                    int i38 = layoutParams28 != null ? layoutParams28.width : 0;
                                    ViewGroup.LayoutParams layoutParams29 = imageView3.getLayoutParams();
                                    Object[] objArr7 = {new ViewGroup.LayoutParams(i38, layoutParams29 != null ? layoutParams29.height : 0)};
                                    ArrayList arrayList7 = new ArrayList(1);
                                    arrayList7.add(objArr7[0].getClass());
                                    Object[] array7 = arrayList7.toArray(new Class[0]);
                                    if (array7 != null) {
                                        Class[] clsArr7 = (Class[]) array7;
                                        Constructor it10 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr7, clsArr7.length));
                                        Intrinsics.checkNotNullExpressionValue(it10, "it");
                                        it10.setAccessible(true);
                                        Object newInstance7 = it10.newInstance(Arrays.copyOf(objArr7, 1));
                                        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance7, intValue11);
                                        layoutParams4 = (ViewGroup.LayoutParams) newInstance7;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                    }
                                }
                                imageView3.setLayoutParams(layoutParams4);
                                imageView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                D(imageView3);
                                recentContactItemRightLayout.addView(imageView3);
                                Trace.endSection();
                                if (INSTANCE.b()) {
                                    Context context3 = recentContactItemRightLayout.getContext();
                                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                                    SummaryLayout summaryLayout = new SummaryLayout(context3);
                                    recentContactItemRightLayout.addView(summaryLayout);
                                    int p29 = com.tencent.aio.view_dsl.dsl.b.p();
                                    if (summaryLayout.getLayoutParams() == null) {
                                        i19 = 0;
                                        summaryLayout.setLayoutParams(new ViewGroup.LayoutParams(p29, 0));
                                    } else {
                                        i19 = 0;
                                        summaryLayout.getLayoutParams().width = p29;
                                    }
                                    summaryLayout.setId(R.id.j8_);
                                    int p36 = com.tencent.aio.view_dsl.dsl.b.p();
                                    if (summaryLayout.getLayoutParams() == null) {
                                        summaryLayout.setLayoutParams(new ViewGroup.LayoutParams(i19, p36));
                                    } else {
                                        summaryLayout.getLayoutParams().height = p36;
                                    }
                                    summaryLayout.setPadding(summaryLayout.getPaddingLeft(), summaryLayout.getPaddingTop(), ((Number) a.a(10)).intValue(), summaryLayout.getPaddingBottom());
                                    f.m(summaryLayout, R.id.jp7);
                                    summaryLayout.setDuplicateParentStateEnabled(true);
                                    f.j(summaryLayout, R.id.jp7);
                                    int intValue12 = ((Number) a.a(12)).intValue();
                                    ViewGroup.LayoutParams layoutParams30 = summaryLayout.getLayoutParams();
                                    if (!(layoutParams30 instanceof ViewGroup.MarginLayoutParams)) {
                                        layoutParams30 = null;
                                    }
                                    ViewGroup.MarginLayoutParams marginLayoutParams11 = (ViewGroup.MarginLayoutParams) layoutParams30;
                                    if (marginLayoutParams11 != null) {
                                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams11, intValue12);
                                        layoutParams8 = marginLayoutParams11;
                                    } else {
                                        ViewGroup.LayoutParams layoutParams31 = summaryLayout.getLayoutParams();
                                        int i39 = layoutParams31 != null ? layoutParams31.width : 0;
                                        ViewGroup.LayoutParams layoutParams32 = summaryLayout.getLayoutParams();
                                        Object[] objArr8 = {new ViewGroup.LayoutParams(i39, layoutParams32 != null ? layoutParams32.height : 0)};
                                        ArrayList arrayList8 = new ArrayList(1);
                                        arrayList8.add(objArr8[0].getClass());
                                        Object[] array8 = arrayList8.toArray(new Class[0]);
                                        if (array8 != null) {
                                            Class[] clsArr8 = (Class[]) array8;
                                            Constructor it11 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr8, clsArr8.length));
                                            Intrinsics.checkNotNullExpressionValue(it11, "it");
                                            it11.setAccessible(true);
                                            Object newInstance8 = it11.newInstance(Arrays.copyOf(objArr8, 1));
                                            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance8, intValue12);
                                            layoutParams8 = (ViewGroup.LayoutParams) newInstance8;
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                    }
                                    summaryLayout.setLayoutParams(layoutParams8);
                                    f.t(summaryLayout, R.id.f907853e);
                                    C(summaryLayout);
                                } else {
                                    Context context4 = recentContactItemRightLayout.getContext();
                                    Intrinsics.checkNotNullExpressionValue(context4, "context");
                                    SingeLineSummaryView singeLineSummaryView = new SingeLineSummaryView(context4);
                                    recentContactItemRightLayout.addView(singeLineSummaryView);
                                    int p37 = com.tencent.aio.view_dsl.dsl.b.p();
                                    if (singeLineSummaryView.getLayoutParams() == null) {
                                        i17 = 0;
                                        singeLineSummaryView.setLayoutParams(new ViewGroup.LayoutParams(p37, 0));
                                    } else {
                                        i17 = 0;
                                        singeLineSummaryView.getLayoutParams().width = p37;
                                    }
                                    singeLineSummaryView.setId(R.id.j8_);
                                    int p38 = com.tencent.aio.view_dsl.dsl.b.p();
                                    if (singeLineSummaryView.getLayoutParams() == null) {
                                        singeLineSummaryView.setLayoutParams(new ViewGroup.LayoutParams(i17, p38));
                                    } else {
                                        singeLineSummaryView.getLayoutParams().height = p38;
                                    }
                                    singeLineSummaryView.setPadding(singeLineSummaryView.getPaddingLeft(), singeLineSummaryView.getPaddingTop(), ((Number) a.a(10)).intValue(), singeLineSummaryView.getPaddingBottom());
                                    d.b(singeLineSummaryView, 14.0f);
                                    f.m(singeLineSummaryView, R.id.jp7);
                                    singeLineSummaryView.setDuplicateParentStateEnabled(true);
                                    f.j(singeLineSummaryView, R.id.jp7);
                                    int intValue13 = ((Number) a.a(12)).intValue();
                                    ViewGroup.LayoutParams layoutParams33 = singeLineSummaryView.getLayoutParams();
                                    if (!(layoutParams33 instanceof ViewGroup.MarginLayoutParams)) {
                                        layoutParams33 = null;
                                    }
                                    ViewGroup.MarginLayoutParams marginLayoutParams12 = (ViewGroup.MarginLayoutParams) layoutParams33;
                                    if (marginLayoutParams12 != null) {
                                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams12, intValue13);
                                        layoutParams5 = marginLayoutParams12;
                                    } else {
                                        ViewGroup.LayoutParams layoutParams34 = singeLineSummaryView.getLayoutParams();
                                        int i46 = layoutParams34 != null ? layoutParams34.width : 0;
                                        ViewGroup.LayoutParams layoutParams35 = singeLineSummaryView.getLayoutParams();
                                        Object[] objArr9 = {new ViewGroup.LayoutParams(i46, layoutParams35 != null ? layoutParams35.height : 0)};
                                        ArrayList arrayList9 = new ArrayList(1);
                                        arrayList9.add(objArr9[0].getClass());
                                        Object[] array9 = arrayList9.toArray(new Class[0]);
                                        if (array9 != null) {
                                            Class[] clsArr9 = (Class[]) array9;
                                            Constructor it12 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr9, clsArr9.length));
                                            Intrinsics.checkNotNullExpressionValue(it12, "it");
                                            it12.setAccessible(true);
                                            Object newInstance9 = it12.newInstance(Arrays.copyOf(objArr9, 1));
                                            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance9, intValue13);
                                            layoutParams5 = (ViewGroup.LayoutParams) newInstance9;
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                    }
                                    singeLineSummaryView.setLayoutParams(layoutParams5);
                                    d.a(singeLineSummaryView, R.color.qui_common_text_secondary);
                                    f.t(singeLineSummaryView, R.id.f907853e);
                                    C(singeLineSummaryView);
                                }
                                B(recentContactItemRightLayout);
                                FrameLayout frameLayout2 = new FrameLayout(relativeLayout.getContext());
                                Object invoke7 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                                if (invoke7 != null) {
                                    frameLayout2.setLayoutParams((ViewGroup.LayoutParams) invoke7);
                                    frameLayout2.setId(R.id.f164785tu1);
                                    int p39 = com.tencent.aio.view_dsl.dsl.b.p();
                                    if (frameLayout2.getLayoutParams() == null) {
                                        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(p39, 0));
                                    } else {
                                        frameLayout2.getLayoutParams().width = p39;
                                    }
                                    int p46 = com.tencent.aio.view_dsl.dsl.b.p();
                                    if (frameLayout2.getLayoutParams() == null) {
                                        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(0, p46));
                                    } else {
                                        frameLayout2.getLayoutParams().height = p46;
                                    }
                                    int intValue14 = ((Number) a.a(8)).intValue();
                                    ViewGroup.LayoutParams layoutParams36 = frameLayout2.getLayoutParams();
                                    if (!(layoutParams36 instanceof ViewGroup.MarginLayoutParams)) {
                                        layoutParams36 = null;
                                    }
                                    ViewGroup.MarginLayoutParams marginLayoutParams13 = (ViewGroup.MarginLayoutParams) layoutParams36;
                                    if (marginLayoutParams13 != null) {
                                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams13, intValue14);
                                        z19 = true;
                                        layoutParams6 = marginLayoutParams13;
                                    } else {
                                        ViewGroup.LayoutParams layoutParams37 = frameLayout2.getLayoutParams();
                                        int i47 = layoutParams37 != null ? layoutParams37.width : 0;
                                        ViewGroup.LayoutParams layoutParams38 = frameLayout2.getLayoutParams();
                                        Object[] objArr10 = {new ViewGroup.LayoutParams(i47, layoutParams38 != null ? layoutParams38.height : 0)};
                                        ArrayList arrayList10 = new ArrayList(1);
                                        arrayList10.add(objArr10[0].getClass());
                                        Object[] array10 = arrayList10.toArray(new Class[0]);
                                        if (array10 != null) {
                                            Class[] clsArr10 = (Class[]) array10;
                                            Constructor it13 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr10, clsArr10.length));
                                            Intrinsics.checkNotNullExpressionValue(it13, "it");
                                            z19 = true;
                                            it13.setAccessible(true);
                                            Object newInstance10 = it13.newInstance(Arrays.copyOf(objArr10, 1));
                                            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance10, intValue14);
                                            layoutParams6 = (ViewGroup.LayoutParams) newInstance10;
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                    }
                                    frameLayout2.setLayoutParams(layoutParams6);
                                    f.d(frameLayout2, z19);
                                    f.o(frameLayout2, z19);
                                    A(frameLayout2);
                                    relativeLayout.addView(frameLayout2);
                                    v(relativeLayout);
                                    swipeMenuLayout.addView(relativeLayout);
                                    Trace.endSection();
                                    LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(swipeMenuLayout.getContext());
                                    swipeMenuLayout.addView(linearLayoutCompat);
                                    int p47 = com.tencent.aio.view_dsl.dsl.b.p();
                                    if (linearLayoutCompat.getLayoutParams() == null) {
                                        linearLayoutCompat.setLayoutParams(new ViewGroup.LayoutParams(p47, 0));
                                    } else {
                                        linearLayoutCompat.getLayoutParams().width = p47;
                                    }
                                    linearLayoutCompat.setId(R.id.ttm);
                                    int l27 = com.tencent.aio.view_dsl.dsl.b.l();
                                    if (linearLayoutCompat.getLayoutParams() == null) {
                                        linearLayoutCompat.setLayoutParams(new ViewGroup.LayoutParams(0, l27));
                                    } else {
                                        linearLayoutCompat.getLayoutParams().height = l27;
                                    }
                                    ViewGroup.LayoutParams layoutParams39 = linearLayoutCompat.getLayoutParams();
                                    ViewGroup.MarginLayoutParams marginLayoutParams14 = (ViewGroup.MarginLayoutParams) (!(layoutParams39 instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams39);
                                    if (marginLayoutParams14 != null) {
                                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams14, 0);
                                        i18 = 0;
                                        layoutParams7 = marginLayoutParams14;
                                    } else {
                                        ViewGroup.LayoutParams layoutParams40 = linearLayoutCompat.getLayoutParams();
                                        int i48 = layoutParams40 != null ? layoutParams40.width : 0;
                                        ViewGroup.LayoutParams layoutParams41 = linearLayoutCompat.getLayoutParams();
                                        Object[] objArr11 = {new ViewGroup.LayoutParams(i48, layoutParams41 != null ? layoutParams41.height : 0)};
                                        ArrayList arrayList11 = new ArrayList(1);
                                        arrayList11.add(objArr11[0].getClass());
                                        Object[] array11 = arrayList11.toArray(new Class[0]);
                                        if (array11 != null) {
                                            Class[] clsArr11 = (Class[]) array11;
                                            Constructor it14 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr11, clsArr11.length));
                                            Intrinsics.checkNotNullExpressionValue(it14, "it");
                                            it14.setAccessible(true);
                                            Object newInstance11 = it14.newInstance(Arrays.copyOf(objArr11, 1));
                                            i18 = 0;
                                            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance11, 0);
                                            layoutParams7 = (ViewGroup.LayoutParams) newInstance11;
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                    }
                                    linearLayoutCompat.setLayoutParams(layoutParams7);
                                    linearLayoutCompat.setGravity(com.tencent.aio.view_dsl.dsl.b.g());
                                    linearLayoutCompat.setOrientation(i18);
                                    w(linearLayoutCompat);
                                    y(swipeMenuLayout);
                                    return swipeMenuLayout;
                                }
                                throw new NullPointerException(str);
                            }
                            throw new NullPointerException(str);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @NotNull
    public final View o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (View) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        View view = this.summary;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("summary");
        return null;
    }

    @NotNull
    public final ImageView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ImageView) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        ImageView imageView = this.summaryRightView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("summaryRightView");
        return null;
    }

    @NotNull
    public final SingleLineTextView q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SingleLineTextView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        SingleLineTextView singleLineTextView = this.title;
        if (singleLineTextView != null) {
            return singleLineTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("title");
        return null;
    }

    @NotNull
    public final ImageView r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ImageView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ImageView imageView = this.titleLeftIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleLeftIcon");
        return null;
    }

    @NotNull
    public final RollingTextView s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (RollingTextView) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        RollingTextView rollingTextView = this.unread;
        if (rollingTextView != null) {
            return rollingTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("unread");
        return null;
    }

    @NotNull
    public final SwipeMenuLayout t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SwipeMenuLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        SwipeMenuLayout swipeMenuLayout = this._root;
        if (swipeMenuLayout != null) {
            return swipeMenuLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_root");
        return null;
    }

    public final void u(@NotNull RecentAvatarViewWrapper recentAvatarViewWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) recentAvatarViewWrapper);
        } else {
            Intrinsics.checkNotNullParameter(recentAvatarViewWrapper, "<set-?>");
            this.avatar = recentAvatarViewWrapper;
        }
    }

    public final void v(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.chatContent = relativeLayout;
        }
    }

    public final void w(@NotNull LinearLayoutCompat linearLayoutCompat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) linearLayoutCompat);
        } else {
            Intrinsics.checkNotNullParameter(linearLayoutCompat, "<set-?>");
            this.chatMenu = linearLayoutCompat;
        }
    }

    public final void y(@NotNull SwipeMenuLayout swipeMenuLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) swipeMenuLayout);
        } else {
            Intrinsics.checkNotNullParameter(swipeMenuLayout, "<set-?>");
            this.chatSwipeLayout = swipeMenuLayout;
        }
    }

    public final void z(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.diyMsgBg = imageView;
        }
    }

    public /* synthetic */ ChatRecentContactItemLayout(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
