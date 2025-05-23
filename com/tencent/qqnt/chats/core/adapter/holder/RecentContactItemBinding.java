package com.tencent.qqnt.chats.core.adapter.holder;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.chats.view.widget.RoundFrameLayout;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010)\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020$\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00102\u001a\u00020\f\u0012\u0006\u00103\u001a\u00020,\u0012\u0006\u00107\u001a\u000204\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\bR\u0010SJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0007\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010+\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b\u0018\u0010(R\u0017\u0010/\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b'\u0010-\u001a\u0004\b\r\u0010.R\u0017\u00102\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u000e\u001a\u0004\b1\u0010\u0010R\u0017\u00103\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b*\u0010.R\u0017\u00107\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u00105\u001a\u0004\b\u0013\u00106R\u0019\u00108\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b0\u0010\u001dR\u0019\u0010=\u001a\u0004\u0018\u0001098\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010A\u001a\u00020>8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010?\u001a\u0004\b%\u0010@R$\u0010I\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010KR\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bC\u0010O\"\u0004\bM\u0010P\u00a8\u0006T"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "", "", "needCreate", "Landroid/view/View;", "e", "Lcom/tencent/qqnt/chats/view/RollingTextView;", "a", "Lcom/tencent/qqnt/chats/view/RollingTextView;", "o", "()Lcom/tencent/qqnt/chats/view/RollingTextView;", "unread", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "summaryRightView", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "c", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "title", "d", DomainData.DOMAIN_NAME, "titleLeftIcon", "Landroid/view/View;", "k", "()Landroid/view/View;", "summary", "Lnw3/a;", "f", "Lnw3/a;", "()Lnw3/a;", "avatar", "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "g", "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "i", "()Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "root", tl.h.F, "chatSwipeLayout", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "()Landroid/widget/RelativeLayout;", "chatContent", "j", "getDiyMsgBg", "diyMsgBg", "rightLayout", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "()Landroidx/appcompat/widget/LinearLayoutCompat;", "chatMenu", "selectArrow", "Lcom/tencent/qqnt/chats/view/widget/RoundFrameLayout;", "Lcom/tencent/qqnt/chats/view/widget/RoundFrameLayout;", "getAvatarShadowLayout", "()Lcom/tencent/qqnt/chats/view/widget/RoundFrameLayout;", "avatarShadowLayout", "Lcom/tencent/qqnt/chats/core/adapter/holder/d;", "Lkotlin/Lazy;", "()Lcom/tencent/qqnt/chats/core/adapter/holder/d;", "partContentView", "Landroid/widget/FrameLayout;", "p", "Landroid/widget/FrameLayout;", "getRightExtLayout", "()Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/widget/FrameLayout;)V", "rightExtLayout", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "viewsMap", "r", "Z", "()Z", "(Z)V", "isTopStyle", "<init>", "(Lcom/tencent/qqnt/chats/view/RollingTextView;Landroid/widget/ImageView;Lcom/tencent/qqnt/classadapter/SingleLineTextView;Landroid/widget/ImageView;Landroid/view/View;Lnw3/a;Lcom/tencent/qqnt/widget/SwipeMenuLayout;Lcom/tencent/qqnt/widget/SwipeMenuLayout;Landroid/widget/RelativeLayout;Landroid/widget/ImageView;Landroid/widget/RelativeLayout;Landroidx/appcompat/widget/LinearLayoutCompat;Landroid/view/View;Lcom/tencent/qqnt/chats/view/widget/RoundFrameLayout;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RecentContactItemBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RollingTextView unread;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView summaryRightView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SingleLineTextView title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ImageView titleLeftIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View summary;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nw3.a avatar;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SwipeMenuLayout root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SwipeMenuLayout chatSwipeLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout chatContent;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView diyMsgBg;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout rightLayout;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayoutCompat chatMenu;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View selectArrow;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RoundFrameLayout avatarShadowLayout;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy partContentView;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout rightExtLayout;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<View> viewsMap;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean isTopStyle;

    public RecentContactItemBinding(@NotNull RollingTextView unread, @NotNull ImageView summaryRightView, @NotNull SingleLineTextView title, @Nullable ImageView imageView, @NotNull View summary, @NotNull nw3.a avatar, @NotNull SwipeMenuLayout root, @NotNull SwipeMenuLayout chatSwipeLayout, @NotNull RelativeLayout chatContent, @NotNull ImageView diyMsgBg, @NotNull RelativeLayout rightLayout, @NotNull LinearLayoutCompat chatMenu, @Nullable View view, @Nullable RoundFrameLayout roundFrameLayout) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(unread, "unread");
        Intrinsics.checkNotNullParameter(summaryRightView, "summaryRightView");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(chatSwipeLayout, "chatSwipeLayout");
        Intrinsics.checkNotNullParameter(chatContent, "chatContent");
        Intrinsics.checkNotNullParameter(diyMsgBg, "diyMsgBg");
        Intrinsics.checkNotNullParameter(rightLayout, "rightLayout");
        Intrinsics.checkNotNullParameter(chatMenu, "chatMenu");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, unread, summaryRightView, title, imageView, summary, avatar, root, chatSwipeLayout, chatContent, diyMsgBg, rightLayout, chatMenu, view, roundFrameLayout);
            return;
        }
        this.unread = unread;
        this.summaryRightView = summaryRightView;
        this.title = title;
        this.titleLeftIcon = imageView;
        this.summary = summary;
        this.avatar = avatar;
        this.root = root;
        this.chatSwipeLayout = chatSwipeLayout;
        this.chatContent = chatContent;
        this.diyMsgBg = diyMsgBg;
        this.rightLayout = rightLayout;
        this.chatMenu = chatMenu;
        this.selectArrow = view;
        this.avatarShadowLayout = roundFrameLayout;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding$partContentView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactItemBinding.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new d(RecentContactItemBinding.this.b()) : (d) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.partContentView = lazy;
        this.viewsMap = new SparseArray<>(2);
    }

    public static /* synthetic */ View f(RecentContactItemBinding recentContactItemBinding, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return recentContactItemBinding.e(z16);
    }

    @NotNull
    public final nw3.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (nw3.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.avatar;
    }

    @NotNull
    public final RelativeLayout b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.chatContent;
    }

    @NotNull
    public final LinearLayoutCompat c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LinearLayoutCompat) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.chatMenu;
    }

    @NotNull
    public final SwipeMenuLayout d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SwipeMenuLayout) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.chatSwipeLayout;
    }

    @Nullable
    public final View e(boolean needCreate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this, needCreate);
        }
        FrameLayout frameLayout = this.rightExtLayout;
        if (frameLayout == null) {
            return null;
        }
        View view = this.viewsMap.get(R.id.f1186074l);
        if (view == null && needCreate) {
            Context context = this.root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "root.context");
            View root = new com.tencent.qqnt.chats.biz.main.lightbusiness.interaction.a(context).getRoot();
            this.viewsMap.put(R.id.f1186074l, root);
            frameLayout.addView(root);
            return root;
        }
        return view;
    }

    @NotNull
    public final d g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (d) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return (d) this.partContentView.getValue();
    }

    @NotNull
    public final RelativeLayout h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.rightLayout;
    }

    @NotNull
    public final SwipeMenuLayout i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SwipeMenuLayout) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.root;
    }

    @Nullable
    public final View j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.selectArrow;
    }

    @NotNull
    public final View k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.summary;
    }

    @NotNull
    public final ImageView l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.summaryRightView;
    }

    @NotNull
    public final SingleLineTextView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SingleLineTextView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.title;
    }

    @Nullable
    public final ImageView n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ImageView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.titleLeftIcon;
    }

    @NotNull
    public final RollingTextView o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RollingTextView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.unread;
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.isTopStyle;
    }

    public final void q(@Nullable FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) frameLayout);
        } else {
            this.rightExtLayout = frameLayout;
        }
    }

    public final void r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.isTopStyle = z16;
        }
    }

    public /* synthetic */ RecentContactItemBinding(RollingTextView rollingTextView, ImageView imageView, SingleLineTextView singleLineTextView, ImageView imageView2, View view, nw3.a aVar, SwipeMenuLayout swipeMenuLayout, SwipeMenuLayout swipeMenuLayout2, RelativeLayout relativeLayout, ImageView imageView3, RelativeLayout relativeLayout2, LinearLayoutCompat linearLayoutCompat, View view2, RoundFrameLayout roundFrameLayout, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(rollingTextView, imageView, singleLineTextView, imageView2, view, aVar, swipeMenuLayout, swipeMenuLayout2, relativeLayout, imageView3, relativeLayout2, linearLayoutCompat, (i3 & 4096) != 0 ? null : view2, (i3 & 8192) != 0 ? null : roundFrameLayout);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, rollingTextView, imageView, singleLineTextView, imageView2, view, aVar, swipeMenuLayout, swipeMenuLayout2, relativeLayout, imageView3, relativeLayout2, linearLayoutCompat, view2, roundFrameLayout, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
