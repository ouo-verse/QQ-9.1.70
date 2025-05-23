package com.tencent.mobileqq.aio.msglist.holder.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.refresher.ar;
import com.tencent.qqnt.aio.refresher.as;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u000eB+\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001c\u0010\u001dJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/f;", "", "", "bubbleId", "", "locW", "locH", "", "d", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/a;", "shootBubbleInfo", "f", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", HippyQQConstants.URL_COMPONENT_NAME, "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "Landroid/view/View;", "Landroid/view/View;", "foregroundView", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;Landroid/content/Context;Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOMsgItem msgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseContentComponent<?> component;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View foregroundView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.f$a, reason: from kotlin metadata */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/f$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f190772d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f190773e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f190774f;

        b(View view, f fVar, String str) {
            this.f190772d = view;
            this.f190773e = fVar;
            this.f190774f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, view, fVar, str);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int[] iArr = new int[2];
            int width = this.f190772d.getWidth();
            int height = this.f190772d.getHeight();
            this.f190772d.getLocationInWindow(iArr);
            int i3 = iArr[0] + (width / 2);
            int i16 = iArr[1] - height;
            if (QLog.isDevelopLevel()) {
                QLog.i("ShootBubbleContent", 2, "[tryGetShootBubbleInfo]: shootBubble locW " + i3 + " locH " + i16 + " msgWidth " + width + " msgHeight " + height + ", content is " + this.f190772d.hashCode() + ", viewTreeOvserver is " + this.f190772d.getViewTreeObserver().hashCode() + " msgId is " + this.f190773e.msgItem.getMsgId());
            }
            this.f190773e.d(this.f190774f, i3, i16);
            ViewTreeObserver viewTreeObserver = this.f190772d.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/f$c", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "", "onEnd", "onStart", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements d.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f190775a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f190776b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f190777c;

        c(int i3, Drawable drawable, f fVar) {
            this.f190775a = i3;
            this.f190776b = drawable;
            this.f190777c = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), drawable, fVar);
            }
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
        public void onEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ShootBubbleContent", 4, "shoot anim end! " + this.f190775a);
            }
            ((c03.a) this.f190776b).destroy();
            this.f190777c.component.sendIntent(new d.aj(4));
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(BaseConstants.ERR_SVR_COMM_INVALID_RES);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(@NotNull AIOMsgItem msgItem, @NotNull BaseContentComponent<?> component, @NotNull Context context, @NotNull View foregroundView) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(foregroundView, "foregroundView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgItem, component, context, foregroundView);
            return;
        }
        this.msgItem = msgItem;
        this.component = component;
        this.context = context;
        this.foregroundView = foregroundView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String bubbleId, int locW, int locH) {
        CharSequence charSequence;
        ar arVar = new ar(this.msgItem.getMsgId(), String.valueOf(this.msgItem.getMsgRecord().senderUin), this.msgItem.isSelf(), bubbleId, locW, locH, null, 64, null);
        this.component.sendIntent(new d.ah(arVar));
        as e16 = arVar.e();
        if (e16 != null) {
            if (QLog.isDevelopLevel()) {
                AIOMsgItem aIOMsgItem = this.msgItem;
                if ((aIOMsgItem instanceof o) && !((o) aIOMsgItem).p2().isEmpty()) {
                    charSequence = String.valueOf(((o) this.msgItem).p2().get(0));
                } else {
                    AIOMsgItem aIOMsgItem2 = this.msgItem;
                    if (aIOMsgItem2 instanceof ae) {
                        charSequence = ((ae) aIOMsgItem2).u2();
                    } else {
                        charSequence = "";
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("ShootBubbleContent", 4, "[sendAIOShootBubbleRequest]: resp, text " + ((Object) charSequence));
                }
            }
            f(e16.a());
            this.msgItem.E1(false);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.msgItem.J() && this.msgItem.R0()) {
            if (!this.msgItem.Y()) {
                return;
            }
            String s16 = this.msgItem.s();
            View view = this.foregroundView;
            QLog.i("ShootBubbleContent", 1, "[tryGetShootBubbleInfo]: addLayoutListener content is " + view.hashCode() + ", viewTreeOvserver is " + view.getViewTreeObserver().hashCode() + " msgId is " + this.msgItem.getMsgId());
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new b(view, this, s16));
                return;
            }
            return;
        }
        this.msgItem.E1(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(@NotNull com.tencent.mobileqq.aio.msglist.holder.skin.a shootBubbleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shootBubbleInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(shootBubbleInfo, "shootBubbleInfo");
        Drawable b16 = shootBubbleInfo.b();
        if (b16 != 0) {
            ImageView imageView = new ImageView(this.context);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            imageView.setImageDrawable(b16);
            int hashCode = imageView.hashCode();
            if (QLog.isDevelopLevel()) {
                QLog.i("ShootBubbleContent", 4, "shoot anim start! " + hashCode);
            }
            this.component.sendIntent(new d.a(4, imageView));
            ((c03.a) b16).d(new c(hashCode, b16, this));
        }
    }
}
