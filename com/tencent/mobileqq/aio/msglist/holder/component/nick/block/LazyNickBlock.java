package com.tencent.mobileqq.aio.msglist.holder.component.nick.block;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 #2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0004J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0004R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/LazyNickBlock;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", h.F, "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "Landroid/view/ViewStub;", "v", "Landroid/view/View;", DomainData.DOMAIN_NAME, "content", "Landroid/view/View$OnClickListener;", "clickListener", "", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", BdhLogUtil.LogTag.Tag_Conn, "Z", "inflated", "Landroid/widget/FrameLayout;", "D", "Landroid/widget/FrameLayout;", "inflatedContainer", "E", "Landroid/view/ViewStub;", "viewStub", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", UserInfo.SEX_FEMALE, "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class LazyNickBlock extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: F */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<Boolean> G;

    /* renamed from: C */
    private boolean inflated;

    /* renamed from: D, reason: from kotlin metadata */
    private FrameLayout inflatedContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ViewStub viewStub;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/LazyNickBlock$a;", "", "", "layoutInflaterSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "layoutInflaterSwitch", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.nick.block.LazyNickBlock$a */
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

        public final boolean b() {
            return ((Boolean) LazyNickBlock.G.getValue()).booleanValue();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyNickBlock$Companion$layoutInflaterSwitch$2.INSTANCE);
        G = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyNickBlock(@NotNull Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        com.tencent.mobileqq.aio.inflater.a aVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) rootView);
            return;
        }
        ViewStub viewStub = new ViewStub(context);
        viewStub.setLayoutResource(R.layout.f169178i42);
        if (INSTANCE.b()) {
            aVar = new com.tencent.mobileqq.aio.inflater.a(context);
        } else {
            aVar = null;
        }
        viewStub.setLayoutInflater(aVar);
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.block.c
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub2, View view) {
                LazyNickBlock.y(LazyNickBlock.this, viewStub2, view);
            }
        });
        this.viewStub = viewStub;
    }

    public static /* synthetic */ void x(LazyNickBlock lazyNickBlock, View view, View.OnClickListener onClickListener, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                onClickListener = null;
            }
            lazyNickBlock.w(view, onClickListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContent");
    }

    public static final void y(LazyNickBlock this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inflated = true;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        this$0.inflatedContainer = (FrameLayout) view;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public final boolean h(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!this.inflated) {
            return;
        }
        FrameLayout frameLayout = this.inflatedContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inflatedContainer");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    @Nullable
    public View n() {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (!u() || (frameLayout = this.inflatedContainer) == null) {
            return null;
        }
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inflatedContainer");
            return null;
        }
        return frameLayout;
    }

    public final boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.inflated;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    @NotNull
    /* renamed from: v */
    public final ViewStub j(@NotNull LinearLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewStub) iPatchRedirector.redirect((short) 3, (Object) this, (Object) layoutParams);
        }
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        return this.viewStub;
    }

    public final void w(@NotNull View content, @Nullable View.OnClickListener clickListener) {
        FrameLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) content, (Object) clickListener);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            if (!this.inflated) {
                this.viewStub.inflate();
            }
            FrameLayout frameLayout = this.inflatedContainer;
            FrameLayout frameLayout2 = null;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inflatedContainer");
                frameLayout = null;
            }
            frameLayout.removeAllViews();
            ViewGroup.LayoutParams layoutParams2 = content.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            }
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.setMargins(ViewUtils.dip2px(2.0f), 0, ViewUtils.dip2px(2.0f), 0);
            }
            content.setLayoutParams(layoutParams2);
            FrameLayout frameLayout3 = this.inflatedContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inflatedContainer");
                frameLayout3 = null;
            }
            frameLayout3.addView(content);
            if (clickListener != null) {
                FrameLayout frameLayout4 = this.inflatedContainer;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inflatedContainer");
                } else {
                    frameLayout2 = frameLayout4;
                }
                frameLayout2.setOnClickListener(clickListener);
            }
        } catch (IllegalStateException e16) {
            QLog.i("aio.nick.block", 1, "[setContent] exception = " + e16);
        }
    }
}
