package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import android.content.Context;
import android.view.View;
import com.tencent.aio.api.list.o;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.SkeletonImpl$businessCallBack$2;
import com.tencent.aio.widget.bounce.AIORefreshLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0012\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\r\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/SkeletonImpl;", "Lcom/tencent/aio/api/list/o;", "Lcom/tencent/aio/api/list/o$a;", "holder", "", "I", "o", "r", "f", "", "d", "Z", "isShowing", "e", "isHiding", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/SkeletonViewHolder;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/SkeletonViewHolder;", "skeletonViewHolder", "com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/SkeletonImpl$businessCallBack$2$a", h.F, "Lkotlin/Lazy;", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/SkeletonImpl$businessCallBack$2$a;", "businessCallBack", "Lcom/tencent/aio/widget/bounce/AIORefreshLayout;", "i", "Lcom/tencent/aio/widget/bounce/AIORefreshLayout;", "bounceLayout", "<init>", "(Lcom/tencent/aio/widget/bounce/AIORefreshLayout;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class SkeletonImpl implements o {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isShowing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isHiding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SkeletonViewHolder skeletonViewHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy businessCallBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final AIORefreshLayout bounceLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/SkeletonImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.SkeletonImpl$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SkeletonImpl(@NotNull AIORefreshLayout bounceLayout) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(bounceLayout, "bounceLayout");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bounceLayout);
            return;
        }
        this.bounceLayout = bounceLayout;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SkeletonImpl$businessCallBack$2.a>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.SkeletonImpl$businessCallBack$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/SkeletonImpl$businessCallBack$2$a", "Lcom/tencent/aio/api/list/o;", "", "o", "r", "sdk_debug"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes3.dex */
            public static final class a implements o {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) SkeletonImpl$businessCallBack$2.this);
                    }
                }

                @Override // com.tencent.aio.api.list.o
                public void o() {
                    AIORefreshLayout aIORefreshLayout;
                    AIORefreshLayout aIORefreshLayout2;
                    SkeletonViewHolder skeletonViewHolder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.aio.base.log.a.f69187b.d("SkeletonImpl", "real hideSkeleton");
                    aIORefreshLayout = SkeletonImpl.this.bounceLayout;
                    aIORefreshLayout.setIsAllowOverScroll(true);
                    aIORefreshLayout2 = SkeletonImpl.this.bounceLayout;
                    skeletonViewHolder = SkeletonImpl.this.skeletonViewHolder;
                    Intrinsics.checkNotNull(skeletonViewHolder);
                    aIORefreshLayout2.K(skeletonViewHolder.d());
                }

                @Override // com.tencent.aio.api.list.o
                public void r() {
                    boolean z16;
                    AIORefreshLayout aIORefreshLayout;
                    AIORefreshLayout aIORefreshLayout2;
                    SkeletonViewHolder skeletonViewHolder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    com.tencent.aio.base.log.a.f69187b.d("SkeletonImpl", "real showSkeleton");
                    z16 = SkeletonImpl.this.isHiding;
                    if (!z16) {
                        aIORefreshLayout = SkeletonImpl.this.bounceLayout;
                        aIORefreshLayout.setIsAllowOverScroll(false);
                        aIORefreshLayout2 = SkeletonImpl.this.bounceLayout;
                        skeletonViewHolder = SkeletonImpl.this.skeletonViewHolder;
                        Intrinsics.checkNotNull(skeletonViewHolder);
                        aIORefreshLayout2.J(skeletonViewHolder.d());
                        SkeletonImpl.this.isShowing = true;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) SkeletonImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? new a() : (a) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.businessCallBack = lazy;
    }

    private final SkeletonImpl$businessCallBack$2.a e() {
        return (SkeletonImpl$businessCallBack$2.a) this.businessCallBack.getValue();
    }

    @Override // com.tencent.aio.api.list.o
    public void I(@NotNull o.a holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.aio.base.log.a.f69187b.d("SkeletonImpl", "setSkeleton " + holder + TokenParser.SP);
        Context context = this.bounceLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "bounceLayout.context");
        this.skeletonViewHolder = new SkeletonViewHolder(holder, context);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.isShowing = false;
        this.isHiding = false;
        SkeletonViewHolder skeletonViewHolder = this.skeletonViewHolder;
        if (skeletonViewHolder != null) {
            skeletonViewHolder.a();
            this.bounceLayout.K(skeletonViewHolder.d());
        }
        com.tencent.aio.base.log.a.f69187b.d("SkeletonImpl", "resetSkeleton isShowing " + this.isShowing + "  isHiding " + this.isHiding + TokenParser.SP);
    }

    @Override // com.tencent.aio.api.list.o
    public void o() {
        View d16;
        SkeletonViewHolder skeletonViewHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.isShowing) {
            com.tencent.aio.base.log.a.f69187b.d("SkeletonImpl", "hideSkeleton");
            SkeletonViewHolder skeletonViewHolder2 = this.skeletonViewHolder;
            if (skeletonViewHolder2 != null && (d16 = skeletonViewHolder2.d()) != null && (skeletonViewHolder = this.skeletonViewHolder) != null) {
                skeletonViewHolder.b(d16, e());
            }
        }
        this.isHiding = true;
    }

    @Override // com.tencent.aio.api.list.o
    public void r() {
        View d16;
        SkeletonViewHolder skeletonViewHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.isHiding) {
            com.tencent.aio.base.log.a.f69187b.d("SkeletonImpl", "showSkeleton");
            SkeletonViewHolder skeletonViewHolder2 = this.skeletonViewHolder;
            if (skeletonViewHolder2 != null && (d16 = skeletonViewHolder2.d()) != null && (skeletonViewHolder = this.skeletonViewHolder) != null) {
                skeletonViewHolder.c(d16, e());
            }
        }
    }
}
