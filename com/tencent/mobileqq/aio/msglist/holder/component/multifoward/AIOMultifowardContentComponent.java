package com.tencent.mobileqq.aio.msglist.holder.component.multifoward;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.p;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.i;
import com.tencent.mobileqq.aio.utils.ay;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.utils.af;
import com.tencent.qqnt.structmsg.element.d;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001QB\u000f\u0012\u0006\u0010.\u001a\u00020)\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u0016\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J&\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0016H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00106\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00100\u001a\u0004\b5\u00102R\u001b\u00109\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00100\u001a\u0004\b8\u00102R\u001b\u0010<\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00100\u001a\u0004\b;\u00102R\u001b\u0010?\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00100\u001a\u0004\b>\u00102R\u001b\u0010B\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u00100\u001a\u0004\bA\u00102R\u001b\u0010E\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u00100\u001a\u0004\bD\u00102R\u001b\u0010H\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u00100\u001a\u0004\bG\u00102R\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u00100\u001a\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/multifoward/AIOMultifowardContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/p;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleSkin", "", "d2", "Landroid/view/ViewGroup;", "itemRoot", "Landroid/widget/TextView;", "tailView", "O1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "M1", "L1", "view", "", "remainLines", "textViewWidth", "c2", "Landroid/view/View;", "Z1", "index", "U1", "", "", "payloads", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "position", "b1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/multifoward/a;", "N1", "c1", "v", NodeProps.ON_CLICK, "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "S1", "()I", "bubblePaddingTop", "D", "P1", "bubblePaddingBottom", "E", "Q1", "bubblePaddingLeft", UserInfo.SEX_FEMALE, "R1", "bubblePaddingRight", "G", "Y1", "itemPaddingTop", "H", "V1", "itemPaddingBottom", "I", "W1", "itemPaddingLeft", "J", "X1", "itemPaddingRight", "Landroid/widget/FrameLayout;", "K", "T1", "()Landroid/widget/FrameLayout;", "content", "<init>", "(Landroid/content/Context;)V", "L", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMultifowardContentComponent extends BaseContentComponent<p> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<Boolean> M;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingTop;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingBottom;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingLeft;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingRight;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemPaddingTop;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemPaddingBottom;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemPaddingLeft;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemPaddingRight;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy content;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/multifoward/AIOMultifowardContentComponent$a;", "", "", "elementSizeCheckSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "elementSizeCheckSwitch", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.multifoward.AIOMultifowardContentComponent$a, reason: from kotlin metadata */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) AIOMultifowardContentComponent.M.getValue()).booleanValue();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62489);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOMultifowardContentComponent$Companion$elementSizeCheckSwitch$2.INSTANCE);
        M = lazy;
    }

    public AIOMultifowardContentComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(AIOMultifowardContentComponent$bubblePaddingTop$2.INSTANCE);
        this.bubblePaddingTop = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOMultifowardContentComponent$bubblePaddingBottom$2.INSTANCE);
        this.bubblePaddingBottom = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AIOMultifowardContentComponent$bubblePaddingLeft$2.INSTANCE);
        this.bubblePaddingLeft = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AIOMultifowardContentComponent$bubblePaddingRight$2.INSTANCE);
        this.bubblePaddingRight = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(AIOMultifowardContentComponent$itemPaddingTop$2.INSTANCE);
        this.itemPaddingTop = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(AIOMultifowardContentComponent$itemPaddingBottom$2.INSTANCE);
        this.itemPaddingBottom = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(AIOMultifowardContentComponent$itemPaddingLeft$2.INSTANCE);
        this.itemPaddingLeft = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(AIOMultifowardContentComponent$itemPaddingRight$2.INSTANCE);
        this.itemPaddingRight = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multifoward.AIOMultifowardContentComponent$content$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMultifowardContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                int Q1;
                int S1;
                int R1;
                int P1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                FrameLayout frameLayout = new FrameLayout(AIOMultifowardContentComponent.this.getContext());
                AIOMultifowardContentComponent aIOMultifowardContentComponent = AIOMultifowardContentComponent.this;
                frameLayout.setBackground(af.a(frameLayout.getContext().getResources().getDrawable(R.drawable.skin_aio_friend_bubble_nor_simple)));
                Q1 = aIOMultifowardContentComponent.Q1();
                S1 = aIOMultifowardContentComponent.S1();
                R1 = aIOMultifowardContentComponent.R1();
                P1 = aIOMultifowardContentComponent.P1();
                frameLayout.setPadding(Q1, S1, R1, P1);
                frameLayout.setOnClickListener(aIOMultifowardContentComponent);
                return frameLayout;
            }
        });
        this.content = lazy9;
    }

    private final void L1(p msgItem) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        i iVar;
        int i3;
        View view;
        LinearLayout linearLayout;
        Object last;
        ArrayList<com.tencent.qqnt.structmsg.element.a> i26 = msgItem.i2();
        if (i26.isEmpty() && INSTANCE.b()) {
            T1().removeAllViews();
            QLog.e("AIOMultifowardContentComponent", 1, "[bindInnerView]: element is empty, msgid=" + msgItem.getMsgId());
            return;
        }
        AIOBubbleSkinInfo x06 = ((p) q1()).x0();
        if (x06 != null) {
            aVar = x06.b();
        } else {
            aVar = null;
        }
        if (aVar instanceof i) {
            iVar = (i) aVar;
        } else {
            iVar = null;
        }
        int i16 = 0;
        if (iVar != null) {
            i3 = (((iVar.k() - Q1()) - W1()) - R1()) - X1();
        } else {
            i3 = 0;
        }
        View childAt = T1().getChildAt(0);
        int i17 = 4;
        if (childAt == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOMultifowardContentComponent", 1, "new innerView");
            }
            LinearLayout linearLayout2 = new LinearLayout(this.context);
            linearLayout2.setOrientation(1);
            linearLayout = new LinearLayout(this.context);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setPadding(W1(), Y1(), X1(), V1());
            int size = i26.size();
            while (i16 < size) {
                com.tencent.qqnt.structmsg.element.a aVar2 = i26.get(i16);
                Intrinsics.checkNotNullExpressionValue(aVar2, "elements.get(index)");
                com.tencent.qqnt.structmsg.element.a aVar3 = aVar2;
                if (aVar3 instanceof d) {
                    View a16 = aVar3.a(this.context, null, null);
                    a16.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    if (i16 > 0) {
                        ViewGroup.LayoutParams layoutParams = a16.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = U1(i16);
                    }
                    if (i16 > 0 && (a16 instanceof TextView)) {
                        i17 = c2((TextView) a16, i17, i3);
                    }
                    linearLayout.addView(a16);
                }
                i16++;
            }
            view = Z1(msgItem);
            linearLayout2.addView(linearLayout);
            linearLayout2.addView(view);
            T1().addView(linearLayout2);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AIOMultifowardContentComponent", 1, "innerView use recycled");
            }
            ViewGroup viewGroup = (ViewGroup) childAt;
            View childAt2 = viewGroup.getChildAt(0);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout3 = (LinearLayout) childAt2;
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() && linearLayout3.getChildCount() != i26.size() - 1) {
                throw new Throwable("itemRoot childCount must be equal to itemSize, childCount is " + linearLayout3.getChildCount() + ", elementSize is " + (i26.size() - 1));
            }
            View childAt3 = viewGroup.getChildAt(1);
            int size2 = i26.size();
            while (i16 < size2) {
                com.tencent.qqnt.structmsg.element.a aVar4 = i26.get(i16);
                Intrinsics.checkNotNullExpressionValue(aVar4, "elements.get(index)");
                com.tencent.qqnt.structmsg.element.a aVar5 = aVar4;
                if (aVar5 instanceof d) {
                    View a17 = aVar5.a(this.context, ViewGroupKt.get(linearLayout3, i16), null);
                    a17.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    if (i16 > 0) {
                        ViewGroup.LayoutParams layoutParams2 = a17.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = U1(i16);
                    }
                    if (i16 > 0 && (a17 instanceof TextView)) {
                        i17 = c2((TextView) a17, i17, i3);
                    }
                }
                i16++;
            }
            if (!i26.isEmpty()) {
                Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.widget.TextView");
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) i26);
                ((TextView) childAt3).setText(((com.tencent.qqnt.structmsg.element.a) last).c().c());
            }
            view = childAt3;
            linearLayout = linearLayout3;
        }
        O1(linearLayout, (TextView) view);
    }

    private final void M1(com.tencent.aio.data.msglist.a msgItem) {
        if (msgItem instanceof p) {
            L1((p) msgItem);
        }
    }

    private final void O1(ViewGroup itemRoot, TextView tailView) {
        FrameLayout T1 = T1();
        T1().getBackground().setColorFilter(new LightingColorFilter(0, T1.getContext().getResources().getColor(R.color.qui_common_bubble_guest)));
        T1.setPadding(Q1(), S1(), R1(), P1());
        if (itemRoot != null) {
            int childCount = itemRoot.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View view = ViewGroupKt.get(itemRoot, i3);
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) view;
                if (i3 == 0) {
                    textView.setTextColor(textView.getContext().getResources().getColorStateList(R.color.qui_common_bubble_guest_text_primary));
                } else {
                    textView.setTextColor(textView.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary));
                }
            }
        }
        if (tailView != null) {
            tailView.getBackground().setColorFilter(new LightingColorFilter(0, tailView.getContext().getResources().getColor(R.color.qui_common_bubble_guest)));
            tailView.setPadding(W1(), 0, 0, 0);
            tailView.setTextColor(tailView.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P1() {
        return ((Number) this.bubblePaddingBottom.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Q1() {
        return ((Number) this.bubblePaddingLeft.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R1() {
        return ((Number) this.bubblePaddingRight.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S1() {
        return ((Number) this.bubblePaddingTop.getValue()).intValue();
    }

    private final FrameLayout T1() {
        return (FrameLayout) this.content.getValue();
    }

    private final int U1(int index) {
        float f16 = 4.0f;
        if (index == 1) {
            f16 = 4.0f + 3;
        }
        return x.c(this.context, f16);
    }

    private final int V1() {
        return ((Number) this.itemPaddingBottom.getValue()).intValue();
    }

    private final int W1() {
        return ((Number) this.itemPaddingLeft.getValue()).intValue();
    }

    private final int X1() {
        return ((Number) this.itemPaddingRight.getValue()).intValue();
    }

    private final int Y1() {
        return ((Number) this.itemPaddingTop.getValue()).intValue();
    }

    private final View Z1(p msgItem) {
        Object last;
        String c16;
        TextView textView = new TextView(this.context);
        if (!msgItem.i2().isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) msgItem.i2());
            c16 = ((com.tencent.qqnt.structmsg.element.a) last).c().c();
        } else {
            c16 = "";
        }
        textView.setText(c16);
        textView.setSingleLine(true);
        textView.setGravity(16);
        textView.setTextSize(13.0f);
        textView.setTextColor(Color.parseColor("#878B99"));
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, x.c(textView.getContext(), 30.0f)));
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = x.c(textView.getContext(), 2.0f);
        textView.setBackgroundDrawable(af.a(textView.getContext().getDrawable(R.drawable.structmsg_multi_tail)));
        textView.setPadding(W1(), 0, 0, 0);
        return textView;
    }

    private final boolean a2(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = false;
            }
        }
        return z16;
    }

    private final int c2(TextView view, int remainLines, int textViewWidth) {
        if (remainLines <= 0) {
            view.setVisibility(8);
            return 0;
        }
        view.setVisibility(0);
        int max = Math.max(ay.b(view, textViewWidth), 1);
        if (remainLines < max) {
            view.setMaxLines(remainLines);
        }
        return Math.max(remainLines - max, 0);
    }

    private final void d2(AIOBubbleSkinInfo bubbleSkin) {
        i iVar;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = bubbleSkin.b();
        if (b16 instanceof i) {
            iVar = (i) b16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            ViewGroup.LayoutParams layoutParams = T1().getLayoutParams();
            if (layoutParams.width != iVar.k() || layoutParams.height != -2) {
                layoutParams.width = iVar.k();
                layoutParams.height = -2;
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public a createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        AIOBubbleSkinInfo x06 = q1().x0();
        Intrinsics.checkNotNull(x06);
        d2(x06);
        if (a2(payloads)) {
            M1(msgItem);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return T1();
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            C1();
            sendIntent(new d.ab(getMContext(), q1(), q1().getTitle()));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new k(getMContext(), q1(), this, null, 8, null), new com.tencent.qqnt.aio.menu.i(getMContext(), q1()), new ap(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.af(getMContext(), q1(), this), new h(getMContext(), q1(), this), new u(getMContext(), q1(), this), new ad(getMContext(), q1(), this), new aj(getMContext(), q1(), this)});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 7, (Object) this);
    }
}
