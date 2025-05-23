package com.tencent.mobileqq.aio.msglist.holder.component.mix;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.image.URLImageView;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.f;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.e;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ak;
import com.tencent.qqnt.aio.menu.ao;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.d;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.n;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.menu.ui.c;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.util.b;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u000f\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00132\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J \u0010$\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0016R\u001b\u0010)\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/mix/AIOMixContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/base/BaseMixContentComponent;", "Lcom/tencent/mobileqq/aio/msg/o;", "Lcom/tencent/qqnt/aio/menu/ui/c;", "y2", "", NowProxyConstants.AccountInfoKey.A2, "msgItem", "", "", "payloads", "z2", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "x2", "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "b1", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleSkin", "r2", "h1", ExifInterface.LATITUDE_SOUTH, "j1", "Landroid/view/View;", "c1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/mix/a;", "u2", "Landroid/graphics/drawable/Drawable;", "drawable", "backgroundMinWidth", "backgroundMinHeight", "i2", "L", "Lkotlin/Lazy;", "v2", "()Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "mContent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "M", "w2", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mContentWithForeground", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "N", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMixContentComponent extends BaseMixContentComponent<o> {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContent;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContentWithForeground;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/mix/AIOMixContentComponent$a;", "", "", "NEW_LINE", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.mix.AIOMixContentComponent$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61860);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMixContentComponent(@NotNull final Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<SelectableLinearLayout>(context, this) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.mix.AIOMixContentComponent$mContent$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ AIOMixContentComponent this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SelectableLinearLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (SelectableLinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    SelectableLinearLayout selectableLinearLayout = new SelectableLinearLayout(this.$context);
                    AIOMixContentComponent aIOMixContentComponent = this.this$0;
                    selectableLinearLayout.setOrientation(1);
                    selectableLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    com.tencent.mobileqq.aio.msglist.holder.component.text.util.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a;
                    aVar.g(selectableLinearLayout, aIOMixContentComponent);
                    aVar.f(selectableLinearLayout, aIOMixContentComponent);
                    return selectableLinearLayout;
                }
            });
            this.mContent = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>(context, this) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.mix.AIOMixContentComponent$mContentWithForeground$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ AIOMixContentComponent this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ConstraintLayout invoke() {
                    SelectableLinearLayout v26;
                    View Y1;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ConstraintLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ConstraintLayout constraintLayout = new ConstraintLayout(this.$context);
                    AIOMixContentComponent aIOMixContentComponent = this.this$0;
                    constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    v26 = aIOMixContentComponent.v2();
                    constraintLayout.addView(v26);
                    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
                    layoutParams.startToStart = 0;
                    layoutParams.endToEnd = 0;
                    layoutParams.topToTop = 0;
                    layoutParams.bottomToBottom = 0;
                    layoutParams.leftToLeft = 0;
                    layoutParams.rightToRight = 0;
                    layoutParams.matchConstraintPercentWidth = 1.0f;
                    layoutParams.matchConstraintPercentHeight = 1.0f;
                    Y1 = aIOMixContentComponent.Y1();
                    constraintLayout.addView(Y1, layoutParams);
                    return constraintLayout;
                }
            });
            this.mContentWithForeground = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private final boolean A2() {
        TextView textView;
        View g16 = c2().get(0).g();
        CharSequence charSequence = null;
        if (g16 instanceof TextView) {
            textView = (TextView) g16;
        } else {
            textView = null;
        }
        if (textView != null) {
            charSequence = textView.getText();
        }
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectableLinearLayout v2() {
        return (SelectableLinearLayout) this.mContent.getValue();
    }

    private final ConstraintLayout w2() {
        return (ConstraintLayout) this.mContentWithForeground.getValue();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    private final c y2() {
        c cVar = new c();
        d dVar = new d(getMContext(), q1());
        dVar.l(v2());
        cVar.a(dVar);
        i iVar = new i(getMContext(), q1());
        iVar.i(v2());
        cVar.a(iVar);
        cVar.a(new k(getMContext(), q1(), this, v2()));
        cVar.a(new ak(getMContext(), q1(), this));
        if (com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a.INSTANCE.b()) {
            cVar.a(new com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a(getMContext(), q1(), v2()));
        }
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean z2(o msgItem, List<Object> payloads) {
        com.tencent.mobileqq.aio.msglist.holder.skin.a t06;
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.BUBBLE_REFRESH_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOMixContentComponent", 4, "[handelBubblePayLoad]: msgId is " + msgItem.getMsgId());
                    }
                    p2(msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.SHOOT_BUBBLE_PAYLOAD) != null && (t06 = ((o) q1()).t0()) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOMixContentComponent", 4, "[handleShotBubblePayload]: msgId is " + ((o) q1()).getMsgId() + ", qqtext is " + ((o) q1()).p2());
                    }
                    d2().f(t06);
                    t06.c(false);
                }
                if (map.get(AIOMsgItemPayloadType.VAS_FONT_PAYLOAD) != null && msgItem.n2() != null) {
                    HashMap<Integer, Drawable> n26 = msgItem.n2();
                    Intrinsics.checkNotNull(n26);
                    q2(n26);
                }
                if (map.get(AIOMsgItemPayloadType.LOAD_AVATAR_PENDANT_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOMixContentComponent", 4, "[handlePayloadData] do shoot bubble, msgId is " + ((o) q1()).getMsgId() + ", qqtext is " + ((o) q1()).p2());
                    }
                    d2().e();
                }
                if (map.get(AIOMsgItemPayloadType.THEME_CHANGE_PAYLOAD) != null) {
                    p2(msgItem);
                }
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return v2().q();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (!z2((o) msgItem, payloads) && z1()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.i("AIOMixContentComponent", 1, "[bind] no need bind, msgItem=" + msgItem);
            return;
        }
        if (x1()) {
            QLog.i("AIOMixContentComponent", 1, "[bind] same data, msgItem=" + msgItem);
            return;
        }
        List<o.b> o26 = ((o) q1()).o2();
        if (c2().isEmpty() && a2().isEmpty() && Z1().isEmpty()) {
            for (o.b bVar : o26) {
                if (bVar.e()) {
                    V1();
                } else if (bVar.d()) {
                    U1();
                } else {
                    W1();
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("AIOMixContentComponent", 2, "[bind] not create view, textViewSize=" + c2().size() + ", picViewSize=" + a2().size() + ", marketFaceViewSize=" + Z1().size());
        }
        v2().removeAllViews();
        int size = o26.size();
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i16 < size) {
            o.b bVar2 = o26.get(i16);
            if (i16 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (i16 == o26.size() - 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (bVar2.b() != null) {
                i3 = i16;
                BaseMixContentComponent.O1(this, (o) q1(), bVar2.b(), v2(), i18, z17, z18, null, 64, null);
                i18++;
            } else {
                i3 = i16;
                if (bVar2.a() != null) {
                    BaseMixContentComponent.L1(this, (o) q1(), bVar2.a(), v2(), i19, z17, z18, null, 64, null);
                    i19++;
                } else if (bVar2.c() != null) {
                    R1(q1(), v2(), i17, z17, z18, true);
                    i17++;
                }
            }
            i16 = i3 + 1;
        }
        p2((o) q1());
        h2(new f(q1(), this, getContext(), w2()));
        f d26 = d2();
        if (d26 != null) {
            d26.e();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return w2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void h1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        d.p pVar = new d.p(false, 1, null);
        sendIntent(pVar);
        if (!b.f362976b.enableTalkBack() && !pVar.a()) {
            v2().u(((o) q1()).isSelf());
            sendIntent(new d.ao(v2(), u1(), y2()));
        } else {
            super.h1();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent
    public void i2(@NotNull Drawable drawable, int backgroundMinWidth, int backgroundMinHeight) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, drawable, Integer.valueOf(backgroundMinWidth), Integer.valueOf(backgroundMinHeight));
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        SelectableLinearLayout v26 = v2();
        Integer valueOf = Integer.valueOf(backgroundMinWidth);
        int intValue = valueOf.intValue();
        v2();
        if (intValue != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Integer num = null;
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            i3 = valueOf.intValue();
        } else {
            v2();
            i3 = 0;
        }
        v26.setMinimumWidth(i3);
        SelectableLinearLayout v27 = v2();
        Integer valueOf2 = Integer.valueOf(backgroundMinHeight);
        int intValue2 = valueOf2.intValue();
        v2();
        if (intValue2 == 0) {
            z17 = false;
        }
        if (z17) {
            num = valueOf2;
        }
        if (num != null) {
            i16 = num.intValue();
        } else {
            v2();
        }
        v27.setMinimumHeight(i16);
        AIOUtil.f194084a.F(v2(), drawable);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void j1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (v2().q()) {
            sendIntent(d.f.f192343d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent
    public void r2(@NotNull AIOBubbleSkinInfo bubbleSkin) {
        int i3;
        int i16;
        ArrayList arrayList;
        int i17;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        int i18;
        ViewGroup.LayoutParams layoutParams4;
        int i19;
        ViewGroup.LayoutParams layoutParams5;
        ViewGroup.LayoutParams layoutParams6;
        ViewGroup.LayoutParams layoutParams7;
        ViewGroup.LayoutParams layoutParams8;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bubbleSkin);
            return;
        }
        Intrinsics.checkNotNullParameter(bubbleSkin, "bubbleSkin");
        super.r2(bubbleSkin);
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = bubbleSkin.b();
        e eVar = b16 instanceof e ? (e) b16 : null;
        if (eVar != null) {
            List<o.b> o26 = ((o) q1()).o2();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = o26.iterator();
            while (true) {
                i3 = 1;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                o.b bVar = (o.b) next;
                if (bVar.b() == null && bVar.c() == null && bVar.a() == null) {
                    i3 = 0;
                }
                if (i3 != 0) {
                    arrayList2.add(next);
                }
            }
            int size = arrayList2.size();
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            while (i26 < size) {
                o.b bVar2 = (o.b) arrayList2.get(i26);
                int i36 = i26 == 0 ? i3 : 0;
                int i37 = i26 == arrayList2.size() - i3 ? i3 : 0;
                if (bVar2.b() != null) {
                    if (i27 >= a2().size()) {
                        QLog.e("AIOMixContentComponent", 1, "[updateSkinBubbleInfo] picViewIndex IndexOutOfBoundsException.", "picViewIndex=" + i27 + ", picViewSize=" + a2().size());
                        i16 = size;
                        arrayList = arrayList2;
                        i17 = i26;
                        i18 = 1;
                        i26 = i17 + 1;
                        i3 = i18;
                        size = i16;
                        arrayList2 = arrayList;
                    } else {
                        RoundBubbleImageView roundBubbleImageView = a2().get(i27);
                        int e16 = i36 != 0 ? eVar.e() : eVar.j();
                        if (i26 == 1 && ((o.b) arrayList2.get(0)).c() != null && A2()) {
                            e16 = 2 * eVar.e();
                        }
                        int b17 = i37 != 0 ? eVar.b() : 0;
                        int c16 = eVar.c();
                        int d16 = eVar.d();
                        i16 = size;
                        ViewGroup.LayoutParams layoutParams9 = roundBubbleImageView.getLayoutParams();
                        if (!(layoutParams9 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams9 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams9;
                        if ((marginLayoutParams != null ? marginLayoutParams.leftMargin : 0) == c16) {
                            ViewGroup.LayoutParams layoutParams10 = roundBubbleImageView.getLayoutParams();
                            if (!(layoutParams10 instanceof ViewGroup.MarginLayoutParams)) {
                                layoutParams10 = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams10;
                            if ((marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0) == d16) {
                                ViewGroup.LayoutParams layoutParams11 = roundBubbleImageView.getLayoutParams();
                                if (!(layoutParams11 instanceof ViewGroup.MarginLayoutParams)) {
                                    layoutParams11 = null;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams11;
                                if ((marginLayoutParams3 != null ? marginLayoutParams3.topMargin : 0) == e16) {
                                    ViewGroup.LayoutParams layoutParams12 = roundBubbleImageView.getLayoutParams();
                                    if (!(layoutParams12 instanceof ViewGroup.MarginLayoutParams)) {
                                        layoutParams12 = null;
                                    }
                                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams12;
                                    if ((marginLayoutParams4 != null ? marginLayoutParams4.bottomMargin : 0) == b17) {
                                        arrayList = arrayList2;
                                        i17 = i26;
                                        Unit unit = Unit.INSTANCE;
                                        i27++;
                                        i18 = 1;
                                        i26 = i17 + 1;
                                        i3 = i18;
                                        size = i16;
                                        arrayList2 = arrayList;
                                    }
                                }
                            }
                        }
                        ViewGroup.LayoutParams layoutParams13 = roundBubbleImageView.getLayoutParams();
                        if (!(layoutParams13 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams13 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams13;
                        if (marginLayoutParams5 != null) {
                            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams5, c16);
                            arrayList = arrayList2;
                            i17 = i26;
                            layoutParams5 = marginLayoutParams5;
                        } else {
                            ViewGroup.LayoutParams layoutParams14 = roundBubbleImageView.getLayoutParams();
                            int i38 = layoutParams14 != null ? layoutParams14.width : 0;
                            ViewGroup.LayoutParams layoutParams15 = roundBubbleImageView.getLayoutParams();
                            if (layoutParams15 != null) {
                                i19 = layoutParams15.height;
                                arrayList = arrayList2;
                            } else {
                                arrayList = arrayList2;
                                i19 = 0;
                            }
                            Object[] objArr = {new ViewGroup.LayoutParams(i38, i19)};
                            ArrayList arrayList3 = new ArrayList(1);
                            arrayList3.add(objArr[0].getClass());
                            i17 = i26;
                            Object[] array = arrayList3.toArray(new Class[0]);
                            if (array != null) {
                                Class[] clsArr = (Class[]) array;
                                Constructor it5 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                it5.setAccessible(true);
                                Object newInstance = it5.newInstance(Arrays.copyOf(objArr, 1));
                                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance, c16);
                                layoutParams5 = (ViewGroup.LayoutParams) newInstance;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        roundBubbleImageView.setLayoutParams(layoutParams5);
                        ViewGroup.LayoutParams layoutParams16 = roundBubbleImageView.getLayoutParams();
                        if (!(layoutParams16 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams16 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams16;
                        if (marginLayoutParams6 != null) {
                            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams6, d16);
                            layoutParams6 = marginLayoutParams6;
                        } else {
                            ViewGroup.LayoutParams layoutParams17 = roundBubbleImageView.getLayoutParams();
                            int i39 = layoutParams17 != null ? layoutParams17.width : 0;
                            ViewGroup.LayoutParams layoutParams18 = roundBubbleImageView.getLayoutParams();
                            Object[] objArr2 = {new ViewGroup.LayoutParams(i39, layoutParams18 != null ? layoutParams18.height : 0)};
                            ArrayList arrayList4 = new ArrayList(1);
                            arrayList4.add(objArr2[0].getClass());
                            Object[] array2 = arrayList4.toArray(new Class[0]);
                            if (array2 != null) {
                                Class[] clsArr2 = (Class[]) array2;
                                Constructor it6 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                                Intrinsics.checkNotNullExpressionValue(it6, "it");
                                it6.setAccessible(true);
                                Object newInstance2 = it6.newInstance(Arrays.copyOf(objArr2, 1));
                                MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance2, d16);
                                layoutParams6 = (ViewGroup.LayoutParams) newInstance2;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        roundBubbleImageView.setLayoutParams(layoutParams6);
                        ViewGroup.LayoutParams layoutParams19 = roundBubbleImageView.getLayoutParams();
                        if (!(layoutParams19 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams19 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams19;
                        if (marginLayoutParams7 != null) {
                            marginLayoutParams7.topMargin = e16;
                            layoutParams7 = marginLayoutParams7;
                        } else {
                            ViewGroup.LayoutParams layoutParams20 = roundBubbleImageView.getLayoutParams();
                            int i46 = layoutParams20 != null ? layoutParams20.width : 0;
                            ViewGroup.LayoutParams layoutParams21 = roundBubbleImageView.getLayoutParams();
                            Object[] objArr3 = {new ViewGroup.LayoutParams(i46, layoutParams21 != null ? layoutParams21.height : 0)};
                            ArrayList arrayList5 = new ArrayList(1);
                            arrayList5.add(objArr3[0].getClass());
                            Object[] array3 = arrayList5.toArray(new Class[0]);
                            if (array3 != null) {
                                Class[] clsArr3 = (Class[]) array3;
                                Constructor it7 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr3, clsArr3.length));
                                Intrinsics.checkNotNullExpressionValue(it7, "it");
                                it7.setAccessible(true);
                                Object newInstance3 = it7.newInstance(Arrays.copyOf(objArr3, 1));
                                ((ViewGroup.MarginLayoutParams) newInstance3).topMargin = e16;
                                layoutParams7 = (ViewGroup.LayoutParams) newInstance3;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        roundBubbleImageView.setLayoutParams(layoutParams7);
                        ViewGroup.LayoutParams layoutParams22 = roundBubbleImageView.getLayoutParams();
                        if (!(layoutParams22 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams22 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams22;
                        if (marginLayoutParams8 != null) {
                            marginLayoutParams8.bottomMargin = b17;
                            layoutParams8 = marginLayoutParams8;
                        } else {
                            ViewGroup.LayoutParams layoutParams23 = roundBubbleImageView.getLayoutParams();
                            int i47 = layoutParams23 != null ? layoutParams23.width : 0;
                            ViewGroup.LayoutParams layoutParams24 = roundBubbleImageView.getLayoutParams();
                            Object[] objArr4 = {new ViewGroup.LayoutParams(i47, layoutParams24 != null ? layoutParams24.height : 0)};
                            ArrayList arrayList6 = new ArrayList(1);
                            arrayList6.add(objArr4[0].getClass());
                            Object[] array4 = arrayList6.toArray(new Class[0]);
                            if (array4 != null) {
                                Class[] clsArr4 = (Class[]) array4;
                                Constructor it8 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr4, clsArr4.length));
                                Intrinsics.checkNotNullExpressionValue(it8, "it");
                                it8.setAccessible(true);
                                Object newInstance4 = it8.newInstance(Arrays.copyOf(objArr4, 1));
                                ((ViewGroup.MarginLayoutParams) newInstance4).bottomMargin = b17;
                                layoutParams8 = (ViewGroup.LayoutParams) newInstance4;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        roundBubbleImageView.setLayoutParams(layoutParams8);
                        Unit unit2 = Unit.INSTANCE;
                        i27++;
                        i18 = 1;
                        i26 = i17 + 1;
                        i3 = i18;
                        size = i16;
                        arrayList2 = arrayList;
                    }
                } else {
                    i16 = size;
                    arrayList = arrayList2;
                    i17 = i26;
                    if (bVar2.c() != null) {
                        if (i28 >= c2().size()) {
                            i18 = 1;
                            QLog.e("AIOMixContentComponent", 1, "[updateSkinBubbleInfo] textViewIndex IndexOutOfBoundsException.", "textViewIndex=" + i28 + ", textViewSize=" + c2().size());
                            i26 = i17 + 1;
                            i3 = i18;
                            size = i16;
                            arrayList2 = arrayList;
                        } else {
                            com.tencent.fastertextview.wrapper.a aVar = c2().get(i28);
                            int e17 = i36 != 0 ? eVar.e() : eVar.j();
                            int b18 = i37 != 0 ? eVar.b() : 0;
                            int c17 = eVar.c();
                            int d17 = eVar.d();
                            if (aVar.d() != c17 || aVar.e() != d17 || aVar.f() != e17 || aVar.c() != b18) {
                                aVar.l(c17, e17, d17, b18);
                            }
                            Unit unit3 = Unit.INSTANCE;
                            i28++;
                            i18 = 1;
                            i26 = i17 + 1;
                            i3 = i18;
                            size = i16;
                            arrayList2 = arrayList;
                        }
                    } else {
                        if (bVar2.a() != null) {
                            if (i29 >= Z1().size()) {
                                i18 = 1;
                                QLog.e("AIOMixContentComponent", 1, "[updateSkinBubbleInfo] marketFaceViewIndex IndexOutOfBoundsException.", "marketFaceViewIndex=" + i29 + ", marketFaceViewSize=" + Z1().size());
                                i26 = i17 + 1;
                                i3 = i18;
                                size = i16;
                                arrayList2 = arrayList;
                            } else {
                                URLImageView uRLImageView = Z1().get(i29);
                                int e18 = i36 != 0 ? eVar.e() : eVar.j();
                                int b19 = i37 != 0 ? eVar.b() : 0;
                                int c18 = eVar.c();
                                int d18 = eVar.d();
                                ViewGroup.LayoutParams layoutParams25 = uRLImageView.getLayoutParams();
                                if (!(layoutParams25 instanceof ViewGroup.MarginLayoutParams)) {
                                    layoutParams25 = null;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams9 = (ViewGroup.MarginLayoutParams) layoutParams25;
                                if ((marginLayoutParams9 != null ? marginLayoutParams9.leftMargin : 0) == c18) {
                                    ViewGroup.LayoutParams layoutParams26 = uRLImageView.getLayoutParams();
                                    if (!(layoutParams26 instanceof ViewGroup.MarginLayoutParams)) {
                                        layoutParams26 = null;
                                    }
                                    ViewGroup.MarginLayoutParams marginLayoutParams10 = (ViewGroup.MarginLayoutParams) layoutParams26;
                                    if ((marginLayoutParams10 != null ? marginLayoutParams10.rightMargin : 0) == d18) {
                                        ViewGroup.LayoutParams layoutParams27 = uRLImageView.getLayoutParams();
                                        if (!(layoutParams27 instanceof ViewGroup.MarginLayoutParams)) {
                                            layoutParams27 = null;
                                        }
                                        ViewGroup.MarginLayoutParams marginLayoutParams11 = (ViewGroup.MarginLayoutParams) layoutParams27;
                                        if ((marginLayoutParams11 != null ? marginLayoutParams11.topMargin : 0) == e18) {
                                            ViewGroup.LayoutParams layoutParams28 = uRLImageView.getLayoutParams();
                                            if (!(layoutParams28 instanceof ViewGroup.MarginLayoutParams)) {
                                                layoutParams28 = null;
                                            }
                                            ViewGroup.MarginLayoutParams marginLayoutParams12 = (ViewGroup.MarginLayoutParams) layoutParams28;
                                            if ((marginLayoutParams12 != null ? marginLayoutParams12.bottomMargin : 0) == b19) {
                                                i18 = 1;
                                                Unit unit4 = Unit.INSTANCE;
                                                i29++;
                                                i26 = i17 + 1;
                                                i3 = i18;
                                                size = i16;
                                                arrayList2 = arrayList;
                                            }
                                        }
                                    }
                                }
                                ViewGroup.LayoutParams layoutParams29 = uRLImageView.getLayoutParams();
                                if (!(layoutParams29 instanceof ViewGroup.MarginLayoutParams)) {
                                    layoutParams29 = null;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams13 = (ViewGroup.MarginLayoutParams) layoutParams29;
                                if (marginLayoutParams13 != null) {
                                    MarginLayoutParamsCompat.setMarginStart(marginLayoutParams13, c18);
                                    layoutParams = marginLayoutParams13;
                                } else {
                                    ViewGroup.LayoutParams layoutParams30 = uRLImageView.getLayoutParams();
                                    int i48 = layoutParams30 != null ? layoutParams30.width : 0;
                                    ViewGroup.LayoutParams layoutParams31 = uRLImageView.getLayoutParams();
                                    Object[] objArr5 = {new ViewGroup.LayoutParams(i48, layoutParams31 != null ? layoutParams31.height : 0)};
                                    ArrayList arrayList7 = new ArrayList(1);
                                    arrayList7.add(objArr5[0].getClass());
                                    Object[] array5 = arrayList7.toArray(new Class[0]);
                                    if (array5 != null) {
                                        Class[] clsArr5 = (Class[]) array5;
                                        Constructor it9 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr5, clsArr5.length));
                                        Intrinsics.checkNotNullExpressionValue(it9, "it");
                                        it9.setAccessible(true);
                                        Object newInstance5 = it9.newInstance(Arrays.copyOf(objArr5, 1));
                                        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance5, c18);
                                        layoutParams = (ViewGroup.LayoutParams) newInstance5;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                    }
                                }
                                uRLImageView.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams32 = uRLImageView.getLayoutParams();
                                if (!(layoutParams32 instanceof ViewGroup.MarginLayoutParams)) {
                                    layoutParams32 = null;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams14 = (ViewGroup.MarginLayoutParams) layoutParams32;
                                if (marginLayoutParams14 != null) {
                                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams14, d18);
                                    layoutParams2 = marginLayoutParams14;
                                } else {
                                    ViewGroup.LayoutParams layoutParams33 = uRLImageView.getLayoutParams();
                                    int i49 = layoutParams33 != null ? layoutParams33.width : 0;
                                    ViewGroup.LayoutParams layoutParams34 = uRLImageView.getLayoutParams();
                                    Object[] objArr6 = {new ViewGroup.LayoutParams(i49, layoutParams34 != null ? layoutParams34.height : 0)};
                                    ArrayList arrayList8 = new ArrayList(1);
                                    arrayList8.add(objArr6[0].getClass());
                                    Object[] array6 = arrayList8.toArray(new Class[0]);
                                    if (array6 != null) {
                                        Class[] clsArr6 = (Class[]) array6;
                                        Constructor it10 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr6, clsArr6.length));
                                        Intrinsics.checkNotNullExpressionValue(it10, "it");
                                        it10.setAccessible(true);
                                        Object newInstance6 = it10.newInstance(Arrays.copyOf(objArr6, 1));
                                        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance6, d18);
                                        layoutParams2 = (ViewGroup.LayoutParams) newInstance6;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                    }
                                }
                                uRLImageView.setLayoutParams(layoutParams2);
                                ViewGroup.LayoutParams layoutParams35 = uRLImageView.getLayoutParams();
                                if (!(layoutParams35 instanceof ViewGroup.MarginLayoutParams)) {
                                    layoutParams35 = null;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams15 = (ViewGroup.MarginLayoutParams) layoutParams35;
                                if (marginLayoutParams15 != null) {
                                    marginLayoutParams15.topMargin = e18;
                                    layoutParams3 = marginLayoutParams15;
                                } else {
                                    ViewGroup.LayoutParams layoutParams36 = uRLImageView.getLayoutParams();
                                    int i56 = layoutParams36 != null ? layoutParams36.width : 0;
                                    ViewGroup.LayoutParams layoutParams37 = uRLImageView.getLayoutParams();
                                    Object[] objArr7 = {new ViewGroup.LayoutParams(i56, layoutParams37 != null ? layoutParams37.height : 0)};
                                    ArrayList arrayList9 = new ArrayList(1);
                                    arrayList9.add(objArr7[0].getClass());
                                    Object[] array7 = arrayList9.toArray(new Class[0]);
                                    if (array7 != null) {
                                        Class[] clsArr7 = (Class[]) array7;
                                        Constructor it11 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr7, clsArr7.length));
                                        Intrinsics.checkNotNullExpressionValue(it11, "it");
                                        it11.setAccessible(true);
                                        Object newInstance7 = it11.newInstance(Arrays.copyOf(objArr7, 1));
                                        ((ViewGroup.MarginLayoutParams) newInstance7).topMargin = e18;
                                        layoutParams3 = (ViewGroup.LayoutParams) newInstance7;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                    }
                                }
                                uRLImageView.setLayoutParams(layoutParams3);
                                ViewGroup.LayoutParams layoutParams38 = uRLImageView.getLayoutParams();
                                if (!(layoutParams38 instanceof ViewGroup.MarginLayoutParams)) {
                                    layoutParams38 = null;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams16 = (ViewGroup.MarginLayoutParams) layoutParams38;
                                if (marginLayoutParams16 != null) {
                                    marginLayoutParams16.bottomMargin = b19;
                                    layoutParams4 = marginLayoutParams16;
                                    i18 = 1;
                                } else {
                                    ViewGroup.LayoutParams layoutParams39 = uRLImageView.getLayoutParams();
                                    int i57 = layoutParams39 != null ? layoutParams39.width : 0;
                                    ViewGroup.LayoutParams layoutParams40 = uRLImageView.getLayoutParams();
                                    Object[] objArr8 = {new ViewGroup.LayoutParams(i57, layoutParams40 != null ? layoutParams40.height : 0)};
                                    ArrayList arrayList10 = new ArrayList(1);
                                    arrayList10.add(objArr8[0].getClass());
                                    Object[] array8 = arrayList10.toArray(new Class[0]);
                                    if (array8 != null) {
                                        Class[] clsArr8 = (Class[]) array8;
                                        Constructor it12 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr8, clsArr8.length));
                                        Intrinsics.checkNotNullExpressionValue(it12, "it");
                                        i18 = 1;
                                        it12.setAccessible(true);
                                        Object newInstance8 = it12.newInstance(Arrays.copyOf(objArr8, 1));
                                        ((ViewGroup.MarginLayoutParams) newInstance8).bottomMargin = b19;
                                        layoutParams4 = (ViewGroup.LayoutParams) newInstance8;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                    }
                                }
                                uRLImageView.setLayoutParams(layoutParams4);
                                Unit unit42 = Unit.INSTANCE;
                                i29++;
                                i26 = i17 + 1;
                                i3 = i18;
                                size = i16;
                                arrayList2 = arrayList;
                            }
                        }
                        i18 = 1;
                        i26 = i17 + 1;
                        i3 = i18;
                        size = i16;
                        arrayList2 = arrayList;
                    }
                }
            }
            Unit unit5 = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a] */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a] */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        ArrayList arrayListOf;
        boolean z16;
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        boolean z17 = false;
        if (((o) q1()).v2()) {
            com.tencent.qqnt.aio.menu.e eVar = new com.tencent.qqnt.aio.menu.e(getMContext(), q1());
            eVar.l(v2());
            Unit unit = Unit.INSTANCE;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{eVar, new k(getMContext(), q1(), this, null, 8, null), new af(getMContext(), q1(), this), new h(getMContext(), q1(), this)});
            return listOf;
        }
        com.tencent.qqnt.aio.menu.e eVar2 = new com.tencent.qqnt.aio.menu.e(getMContext(), q1());
        eVar2.l(v2());
        Unit unit2 = Unit.INSTANCE;
        i iVar = new i(getMContext(), q1());
        iVar.i(v2());
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(eVar2, new k(getMContext(), q1(), this, null, 8, null), iVar, new af(getMContext(), q1(), this), new h(getMContext(), q1(), this), new u(getMContext(), q1(), this), new ad(getMContext(), q1(), this), new ap(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.a(getMContext(), q1(), this), new ao(getMContext(), q1()), new ag(getMContext(), q1()));
        arrayList.addAll(arrayListOf);
        if (com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a.INSTANCE.b()) {
            arrayList.add(new com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a(getMContext(), q1(), v2()));
        }
        arrayList.add(new aj(getMContext(), q1(), this));
        if (((o) q1()).getMsgRecord().chatType == 2 || ((o) q1()).getMsgRecord().chatType == 1) {
            String b16 = m.f194167a.b(q1());
            if (b16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !Intrinsics.areEqual(b16, "0")) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(new n(getMContext(), q1(), this));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: u2, reason: merged with bridge method [inline-methods] */
    public a createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new a();
    }

    @NotNull
    public final SelectableLinearLayout x2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SelectableLinearLayout) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return v2();
    }
}
