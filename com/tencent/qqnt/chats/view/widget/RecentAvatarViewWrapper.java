package com.tencent.qqnt.chats.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.chats.inject.avatar.b;
import com.tencent.qqnt.chats.view.RecentRollingTextView;
import com.tencent.qqnt.chats.view.api.IRecentAvatarApi;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nw3.a;
import nw3.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010i\u001a\u00020h\u00a2\u0006\u0004\bj\u0010kB\u001b\b\u0016\u0012\u0006\u0010i\u001a\u00020h\u0012\b\u0010m\u001a\u0004\u0018\u00010l\u00a2\u0006\u0004\bj\u0010nB#\b\u0016\u0012\u0006\u0010i\u001a\u00020h\u0012\b\u0010m\u001a\u0004\u0018\u00010l\u0012\u0006\u0010o\u001a\u00020#\u00a2\u0006\u0004\bj\u0010pB+\b\u0016\u0012\u0006\u0010i\u001a\u00020h\u0012\b\u0010m\u001a\u0004\u0018\u00010l\u0012\u0006\u0010o\u001a\u00020#\u0012\u0006\u0010q\u001a\u00020#\u00a2\u0006\u0004\bj\u0010rJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J5\u0010\"\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2#\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001dH\u0016J\u0019\u0010%\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010#H\u0016\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'H\u0016J \u0010-\u001a\u00020\u00032\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0014H\u0016J\u0012\u00100\u001a\u00020\u00142\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u00020\u0014H\u0016R\"\u00107\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0017\u0010<\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b\u0018\u00109\u001a\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010=R\u0014\u0010@\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010?R\u001b\u0010D\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010H\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010A\u001a\u0004\bF\u0010GR$\u0010P\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010U\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010?\u001a\u0004\bR\u0010C\"\u0004\bS\u0010TR$\u0010Y\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010?\u001a\u0004\bW\u0010C\"\u0004\bX\u0010TR$\u0010`\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R?\u0010g\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f\u00a8\u0006t"}, d2 = {"Lcom/tencent/qqnt/chats/view/widget/RecentAvatarViewWrapper;", "Landroid/widget/FrameLayout;", "Lnw3/c;", "", "j", "k", "l", h.F, "i", "Lnw3/a;", "avatar", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "Landroid/view/View;", "getAvatarLayout", "Landroid/widget/ImageView;", "getPendantView", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "getAvatarUnread", "d", "", "f", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "e", "b", "g", "", "tag", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "listenerCb", "a", "", "resId", "setBottomRightIconRes", "(Ljava/lang/Integer;)V", "", "pading", "setBottomRightIconPadding", "redPointWidth", "redPointHeight", "isNumPoint", "setTopRightHole", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "performClick", "Z", "getUseAnimCtrl", "()Z", "setUseAnimCtrl", "(Z)V", "useAnimCtrl", "Lcom/tencent/qqnt/chats/view/widget/HollowOutAvatarFrameLayout;", "Lcom/tencent/qqnt/chats/view/widget/HollowOutAvatarFrameLayout;", "getHollowLayout", "()Lcom/tencent/qqnt/chats/view/widget/HollowOutAvatarFrameLayout;", "hollowLayout", "Lnw3/a;", "avatarView", "Landroid/widget/ImageView;", "pendantLayout", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Landroid/widget/ImageView;", "overlayView", "Landroid/widget/FrameLayout$LayoutParams;", "o", "()Landroid/widget/FrameLayout$LayoutParams;", "overlayViewLp", "Lcom/tencent/qqnt/chats/view/RecentRollingTextView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chats/view/RecentRollingTextView;", "getUnreadView", "()Lcom/tencent/qqnt/chats/view/RecentRollingTextView;", "setUnreadView", "(Lcom/tencent/qqnt/chats/view/RecentRollingTextView;)V", "unreadView", "D", "getRightBottomView", "setRightBottomView", "(Landroid/widget/ImageView;)V", "rightBottomView", "E", "getRevealRingView", "setRevealRingView", "revealRingView", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "getCurChatItem", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "setCurChatItem", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;)V", "curChatItem", "G", "Lkotlin/jvm/functions/Function1;", "getCustomClickListener", "()Lkotlin/jvm/functions/Function1;", "setCustomClickListener", "(Lkotlin/jvm/functions/Function1;)V", "customClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "H", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RecentAvatarViewWrapper extends FrameLayout implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int I;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_AvatarProgress.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<b>> J;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RecentRollingTextView unreadView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView rightBottomView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView revealRingView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.adapter.itemdata.b curChatItem;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> customClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean useAnimCtrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HollowOutAvatarFrameLayout hollowLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a avatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView pendantLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy overlayView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy overlayViewLp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/view/widget/RecentAvatarViewWrapper$a;", "", "", "ITEM_SHRINK_ANIMATION_DURATION", "J", "", "STATE_ICON_OFFSET", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
            return;
        }
        INSTANCE = new Companion(null);
        I = ViewUtils.dip2px(16.0f);
        ArrayList<Class<b>> arrayList = new ArrayList<>();
        J = arrayList;
        arrayList.add(com.tencent.qqnt.chats.biz.guild.b.class);
        arrayList.add(com.tencent.qqnt.chats.biz.guild.a.class);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecentAvatarViewWrapper(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }

    private final void h() {
        if (Intrinsics.areEqual(this.hollowLayout.getParent(), this)) {
            return;
        }
        int a16 = com.tencent.qqnt.util.view.b.f362999a.a(58.0f);
        View view = this.hollowLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a16, a16);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(view, 0, layoutParams);
    }

    private final void i() {
        if (Intrinsics.areEqual(this.pendantLayout.getParent(), this)) {
            return;
        }
        int a16 = com.tencent.qqnt.util.view.b.f362999a.a(72.0f);
        View view = this.pendantLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a16, a16);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(view, layoutParams);
    }

    private final void j() {
        ViewParent viewParent;
        ImageView imageView = this.revealRingView;
        if (imageView != null) {
            viewParent = imageView.getParent();
        } else {
            viewParent = null;
        }
        if (Intrinsics.areEqual(viewParent, this)) {
            return;
        }
        QUIShimmerImageView qUIShimmerImageView = new QUIShimmerImageView(getContext());
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        int a16 = bVar.a(58.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a16, a16);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(qUIShimmerImageView, 0, layoutParams);
        qUIShimmerImageView.setVisibility(8);
        int b16 = bVar.b(1);
        qUIShimmerImageView.setPadding(b16, b16, b16, b16);
        this.revealRingView = qUIShimmerImageView;
    }

    private final void k() {
        ViewParent viewParent;
        ImageView imageView = this.rightBottomView;
        if (imageView != null) {
            viewParent = imageView.getParent();
        } else {
            viewParent = null;
        }
        if (Intrinsics.areEqual(viewParent, this)) {
            return;
        }
        QUIShimmerImageView qUIShimmerImageView = new QUIShimmerImageView(getContext());
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        int b16 = bVar.b(20);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b16, b16);
        layoutParams.gravity = 8388693;
        Unit unit = Unit.INSTANCE;
        addView(qUIShimmerImageView, layoutParams);
        qUIShimmerImageView.setVisibility(8);
        int b17 = bVar.b(2);
        qUIShimmerImageView.setPadding(b17, b17, b17, b17);
        this.rightBottomView = qUIShimmerImageView;
    }

    private final void l() {
        ViewParent viewParent;
        RecentRollingTextView recentRollingTextView = this.unreadView;
        if (recentRollingTextView != null) {
            viewParent = recentRollingTextView.getParent();
        } else {
            viewParent = null;
        }
        if (!Intrinsics.areEqual(viewParent, this) && this.useAnimCtrl) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            RecentRollingTextView recentRollingTextView2 = new RecentRollingTextView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388661;
            Unit unit = Unit.INSTANCE;
            addView(recentRollingTextView2, layoutParams);
            recentRollingTextView2.setVisibility(8);
            this.unreadView = recentRollingTextView2;
        }
    }

    private final ImageView n() {
        return (ImageView) this.overlayView.getValue();
    }

    private final FrameLayout.LayoutParams o() {
        return (FrameLayout.LayoutParams) this.overlayViewLp.getValue();
    }

    @Override // nw3.c
    public void a(@NotNull String tag, @Nullable Function1<? super View, Unit> listenerCb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) tag, (Object) listenerCb);
        } else {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.customClickListener = listenerCb;
        }
    }

    @Override // nw3.c
    @Nullable
    public ImageView b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ImageView) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        if (this.revealRingView == null) {
            j();
        }
        return this.revealRingView;
    }

    @Override // nw3.c
    @NotNull
    public a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (a) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        a aVar = this.avatarView;
        if (aVar != null) {
            return aVar;
        }
        throw new RuntimeException("not call bindActualAvatarView before!");
    }

    @Override // nw3.c
    @Nullable
    public ImageView d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ImageView) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (this.rightBottomView == null) {
            k();
        }
        return this.rightBottomView;
    }

    @Override // nw3.c
    public void e(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            this.curChatItem = item;
        }
    }

    @Override // nw3.c
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        if (this.rightBottomView != null) {
            return true;
        }
        return false;
    }

    @Override // nw3.c
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        if (this.revealRingView != null) {
            return true;
        }
        return false;
    }

    @Override // nw3.a
    @NotNull
    public View getAvatarLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (View) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this;
    }

    @Override // nw3.a
    @Nullable
    public QUIBadge getAvatarUnread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (QUIBadge) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (this.unreadView == null) {
            l();
        }
        return this.unreadView;
    }

    @Override // nw3.a
    @NotNull
    public ImageView getAvatarView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (ImageView) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return c.a.a(this);
    }

    @Override // nw3.c
    @NotNull
    public ImageView getPendantView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ImageView) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.pendantLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(@NotNull a avatar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) avatar);
            return;
        }
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        this.avatarView = avatar;
        if (this.hollowLayout.getChildCount() > 0) {
            this.hollowLayout.removeAllViews();
        }
        IRecentAvatarApi iRecentAvatarApi = (IRecentAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRecentAvatarApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int recentAvatarSize = iRecentAvatarApi.getRecentAvatarSize(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(recentAvatarSize, recentAvatarSize);
        layoutParams.gravity = 17;
        if (avatar instanceof View) {
            this.hollowLayout.addView((View) avatar, layoutParams);
        } else {
            this.hollowLayout.addView(avatar.getAvatarView(), layoutParams);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) event)).booleanValue();
        }
        if (event == null) {
            return super.onTouchEvent(event);
        }
        if (this.customClickListener != null) {
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    this.hollowLayout.removeView(n());
                }
            } else {
                this.hollowLayout.addView(n(), o());
            }
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        Function1<? super View, Unit> function1 = this.customClickListener;
        if (function1 != null) {
            if (function1 != null) {
                function1.invoke(this);
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    public void setBottomRightIconPadding(float pading) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Float.valueOf(pading));
            return;
        }
        ImageView imageView = this.rightBottomView;
        int a16 = com.tencent.qqnt.util.view.b.f362999a.a(pading);
        if (imageView != null) {
            imageView.setPadding(a16, a16, a16, a16);
        }
    }

    public void setBottomRightIconRes(@Nullable Integer resId) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) resId);
            return;
        }
        ImageView imageView = this.rightBottomView;
        if (imageView != null) {
            if (resId != null) {
                this.hollowLayout.setStateIconRoundRadius(8);
                this.hollowLayout.setStateIconOffset(-4, -4);
                this.hollowLayout.setBottomRightHole();
                imageView.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int i3 = I;
                layoutParams.width = i3;
                imageView.getLayoutParams().height = i3;
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                } else {
                    marginLayoutParams = null;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.setMargins(0, 0, ViewUtils.dip2px(Math.abs(-4)), ViewUtils.dip2px(Math.abs(-4)));
                }
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.setImageResource(resId.intValue());
                return;
            }
            this.hollowLayout.a();
            imageView.setVisibility(8);
        }
    }

    public final void setCurChatItem(@Nullable com.tencent.qqnt.chats.core.adapter.itemdata.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
        } else {
            this.curChatItem = bVar;
        }
    }

    public final void setCustomClickListener(@Nullable Function1<? super View, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) function1);
        } else {
            this.customClickListener = function1;
        }
    }

    public final void setRevealRingView(@Nullable ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) imageView);
        } else {
            this.revealRingView = imageView;
        }
    }

    public final void setRightBottomView(@Nullable ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) imageView);
        } else {
            this.rightBottomView = imageView;
        }
    }

    @Override // nw3.a
    public void setTopRightHole(float redPointWidth, float redPointHeight, boolean isNumPoint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Float.valueOf(redPointWidth), Float.valueOf(redPointHeight), Boolean.valueOf(isNumPoint));
        } else {
            this.hollowLayout.setTopRightHole(redPointWidth, redPointHeight, isNumPoint);
        }
    }

    public final void setUnreadView(@Nullable RecentRollingTextView recentRollingTextView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) recentRollingTextView);
        } else {
            this.unreadView = recentRollingTextView;
        }
    }

    public final void setUseAnimCtrl(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.useAnimCtrl = z16;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecentAvatarViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecentAvatarViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentAvatarViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.useAnimCtrl = true;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        HollowOutAvatarFrameLayout hollowOutAvatarFrameLayout = new HollowOutAvatarFrameLayout(context2);
        hollowOutAvatarFrameLayout.setBackgroundResource(R.color.ajr);
        this.hollowLayout = hollowOutAvatarFrameLayout;
        this.pendantLayout = new ImageView(getContext());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper$overlayView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentAvatarViewWrapper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ImageView imageView = new ImageView(RecentAvatarViewWrapper.this.getContext());
                imageView.setImageResource(R.drawable.qui_common_overlay_standard_secondary_oval_bg);
                return imageView;
            }
        });
        this.overlayView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout.LayoutParams>() { // from class: com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper$overlayViewLp$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentAvatarViewWrapper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout.LayoutParams invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (FrameLayout.LayoutParams) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IRecentAvatarApi iRecentAvatarApi = (IRecentAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRecentAvatarApi.class);
                Context context3 = RecentAvatarViewWrapper.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                int recentAvatarSize = iRecentAvatarApi.getRecentAvatarSize(context3);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(recentAvatarSize, recentAvatarSize);
                layoutParams.gravity = 17;
                return layoutParams;
            }
        });
        this.overlayViewLp = lazy2;
        h();
        j();
        i();
        l();
        k();
    }
}
