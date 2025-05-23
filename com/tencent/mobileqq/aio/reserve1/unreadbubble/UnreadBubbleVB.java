package com.tencent.mobileqq.aio.reserve1.unreadbubble;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadBubbleUI;
import com.tencent.mobileqq.aio.reserve1.unreadbubble.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.util.TokenResUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020\u000b\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/UnreadBubbleVB;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/a;", "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/a;", "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/UnreadBubbleUI;", "", "g1", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/base/route/MsgIntent;", "initIntent", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "b1", "state", "e1", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "", "e", "J", "mUnreadCnt", "", "f", "Z", "mNeedJumpBottom", h.F, "mShowArrow", "Landroid/widget/TextView;", "i", "Lkotlin/Lazy;", "d1", "()Landroid/widget/TextView;", "unreadText", "initMsgIntent", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class UnreadBubbleVB extends com.tencent.qqnt.aio.lazy.lazyInit.a<a, UnreadBubbleUI> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mUnreadCnt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedJumpBottom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mShowArrow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy unreadText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnreadBubbleVB(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new UnreadBubbleVB$unreadText$2(this));
            this.unreadText = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
        }
    }

    private final TextView d1() {
        return (TextView) this.unreadText.getValue();
    }

    private final void f1() {
        TextView d16 = d1();
        d16.setVisibility(0);
        d16.setText("");
        d16.setBackgroundResource(R.drawable.aio_back_bottom);
        d16.setContentDescription(HardCodeUtil.qqStr(R.string.yuf));
        if (!this.mShowArrow) {
            sendIntent(new a.b(true));
        }
        this.mShowArrow = true;
    }

    private final void g1() {
        String valueOf;
        TextView d16 = d1();
        d16.setVisibility(0);
        long j3 = this.mUnreadCnt;
        if (j3 > 99) {
            valueOf = ThemeBackground.DIY_UPLOAD_BG_ID;
        } else {
            valueOf = String.valueOf(j3);
        }
        d16.setText(valueOf);
        d16.setBackgroundResource(TokenResUtils.getDefaultRes(R.drawable.aio_unread_bg, R.drawable.mnc));
        d16.setContentDescription(HardCodeUtil.qqStr(R.string.yuf) + this.mUnreadCnt + HardCodeUtil.qqStr(R.string.yug));
        if (this.mShowArrow) {
            sendIntent(new a.b(false));
        }
        this.mShowArrow = false;
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.a
    @NotNull
    public com.tencent.qqnt.aio.lazy.lazyInit.b<a, UnreadBubbleUI> b1(@NotNull MsgIntent initIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.aio.lazy.lazyInit.b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) initIntent);
        }
        Intrinsics.checkNotNullParameter(initIntent, "initIntent");
        return new f(initIntent);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull UnreadBubbleUI state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof UnreadBubbleUI.UnreadCntChanged) {
            long a16 = ((UnreadBubbleUI.UnreadCntChanged) state).a();
            this.mUnreadCnt = a16;
            if (a16 == 0) {
                d1().setText("");
                if (this.mNeedJumpBottom) {
                    f1();
                    return;
                } else {
                    d1().setVisibility(8);
                    return;
                }
            }
            g1();
            return;
        }
        if (!(state instanceof UnreadBubbleUI.JumpBottomBtnState) || this.mUnreadCnt > 0) {
            return;
        }
        if (((UnreadBubbleUI.JumpBottomBtnState) state).a()) {
            f1();
        } else {
            d1().setVisibility(8);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        d1().setVisibility(8);
        return d1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        d1().setVisibility(8);
        d1().setText("");
    }
}
