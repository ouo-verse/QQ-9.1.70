package com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper;
import com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.c;
import com.tencent.mobileqq.aio.utils.p;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOConfig;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J&\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010)\u001a\u0004\b5\u00106R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00101\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/leftswipearea/AIOLeftSwipeAreaComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/leftswipearea/AIOContentLeftSwipeHelper$b;", "", "dx", "", ICustomDataEditor.STRING_PARAM_1, "p1", "u1", "", "o1", "Landroid/view/View;", "c1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "d1", "X", "O0", "scrollX", "Z0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "k", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "f", "Lkotlin/Lazy;", "r1", "()Landroid/widget/ImageView;", "replyIcon", h.F, "Lcom/tencent/aio/data/msglist/a;", "curMsgItem", "i", "Z", "hasShowReply", "Landroid/animation/AnimatorSet;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "q1", "()Landroid/animation/AnimatorSet;", "replyAppearAnimator", BdhLogUtil.LogTag.Tag_Conn, "hasVibrate", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOLeftSwipeAreaComponent extends com.tencent.mobileqq.aio.msglist.holder.component.c implements AIOContentLeftSwipeHelper.b {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasVibrate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy replyIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.data.msglist.a curMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasShowReply;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy replyAppearAnimator;

    public AIOLeftSwipeAreaComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOLeftSwipeAreaComponent$replyIcon$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOLeftSwipeAreaComponent.this);
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
                ImageView imageView = new ImageView(AIOLeftSwipeAreaComponent.this.getContext());
                imageView.setImageResource(R.drawable.j7h);
                int dimensionPixelSize = imageView.getContext().getResources().getDimensionPixelSize(R.dimen.f158232y7);
                int dimensionPixelSize2 = imageView.getContext().getResources().getDimensionPixelSize(R.dimen.f158231y6);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.leftMargin = dimensionPixelSize2;
                layoutParams.rightMargin = dimensionPixelSize2;
                layoutParams.gravity = 16;
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(8);
                return imageView;
            }
        });
        this.replyIcon = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AnimatorSet>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOLeftSwipeAreaComponent$replyAppearAnimator$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOLeftSwipeAreaComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnimatorSet invoke() {
                ImageView r16;
                ImageView r17;
                ImageView r18;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AnimatorSet) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AnimatorSet animatorSet = new AnimatorSet();
                AIOLeftSwipeAreaComponent aIOLeftSwipeAreaComponent = AIOLeftSwipeAreaComponent.this;
                r16 = aIOLeftSwipeAreaComponent.r1();
                r17 = aIOLeftSwipeAreaComponent.r1();
                r18 = aIOLeftSwipeAreaComponent.r1();
                animatorSet.playTogether(ObjectAnimator.ofFloat(r16, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f), ObjectAnimator.ofFloat(r17, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(r18, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f));
                animatorSet.setDuration(150L);
                return animatorSet;
            }
        });
        this.replyAppearAnimator = lazy2;
    }

    private final boolean o1() {
        return !((IAIOConfig) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOConfig.class)).canSwipeReplyVibrate(this.context);
    }

    private final void p1(int dx5) {
        if (dx5 > LeftSwipeConstants.f190932a.c()) {
            if (!this.hasVibrate) {
                this.hasVibrate = true;
                if (o1()) {
                    return;
                }
                Object systemService = this.context.getSystemService("vibrator");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                ((Vibrator) systemService).vibrate(100L);
                return;
            }
            return;
        }
        this.hasVibrate = false;
    }

    private final AnimatorSet q1() {
        return (AnimatorSet) this.replyAppearAnimator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView r1() {
        return (ImageView) this.replyIcon.getValue();
    }

    private final void s1(int dx5) {
        if (!this.hasShowReply) {
            if (dx5 > LeftSwipeConstants.f190932a.c()) {
                q1().start();
                r1().setVisibility(0);
                this.hasShowReply = true;
                return;
            }
            return;
        }
        if (q1().isRunning()) {
            return;
        }
        u1(dx5);
    }

    private final void u1(int dx5) {
        float coerceIn;
        int i3 = r1().getLayoutParams().width;
        ViewGroup.LayoutParams layoutParams = r1().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int i16 = i3 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
        ImageView r16 = r1();
        coerceIn = RangesKt___RangesKt.coerceIn((dx5 - i16) / p.c(20), 0.0f, 1.0f);
        r16.setAlpha(coerceIn);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void O0(int dx5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, dx5);
        } else {
            s1(dx5);
            p1(dx5);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            f1().setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void Z0(int scrollX) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, scrollX);
            return;
        }
        if (q1().isRunning()) {
            q1().cancel();
            r1().setVisibility(8);
        }
        if (scrollX > LeftSwipeConstants.f190932a.c()) {
            com.tencent.aio.data.msglist.a aVar = this.curMsgItem;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curMsgItem");
                aVar = null;
            }
            sendIntent(new c.a((AIOMsgItem) aVar, 2));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void a1(int scrollX) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, scrollX);
        } else if (this.hasShowReply) {
            u1(scrollX);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curMsgItem = msgItem;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return r1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new b();
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.hasShowReply = false;
            r1().setVisibility(8);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View f16 = f1();
        Intrinsics.checkNotNull(f16);
        return f16;
    }
}
