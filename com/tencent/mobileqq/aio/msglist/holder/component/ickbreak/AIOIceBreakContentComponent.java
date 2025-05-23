package com.tencent.mobileqq.aio.msglist.holder.component.ickbreak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ickbreak.c;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.iceBreak.IIceBreakManager;
import com.tencent.mobileqq.vas.iceBreak.IceBreakData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.ui.d;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgIceBreak;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J&\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ickbreak/AIOIceBreakContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/ae;", "", "M1", "", "id", "S1", "P1", "", "", "payloads", "", "R1", "K1", "J1", "T1", "V1", "U1", "", "N1", "Landroid/view/View;", "c1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lw71/c;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "O1", "()Lw71/c;", "mBinding", "Lcom/tencent/mobileqq/vas/iceBreak/IIceBreakManager;", "D", "Q1", "()Lcom/tencent/mobileqq/vas/iceBreak/IIceBreakManager;", "vipManager", "Lcom/tencent/mobileqq/vas/iceBreak/c;", "E", "Lcom/tencent/mobileqq/vas/iceBreak/c;", "vipClickListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "preloadWelcomeWordingFinishedMark", "<init>", "(Landroid/content/Context;)V", "G", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOIceBreakContentComponent extends BaseContentComponent<ae> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mBinding;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy vipManager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.vas.iceBreak.c vipClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean preloadWelcomeWordingFinishedMark;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ickbreak/AIOIceBreakContentComponent$a;", "", "", "EXTRA_WIDTH_DP", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.ickbreak.AIOIceBreakContentComponent$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ickbreak/AIOIceBreakContentComponent$b", "Lcom/tencent/mobileqq/vas/iceBreak/c;", "Landroid/view/View;", "view", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mobileqq.vas.iceBreak.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOIceBreakContentComponent.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.iceBreak.c
        public void a(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intrinsics.checkNotNullParameter(view, "view");
                AIOIceBreakContentComponent.this.T1();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60934);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOIceBreakContentComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<w71.c>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ickbreak.AIOIceBreakContentComponent$mBinding$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOIceBreakContentComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final w71.c invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (w71.c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOIceBreakContentComponent.this.context;
                w71.c g16 = w71.c.g(LayoutInflater.from(context2));
                LinearLayout itemRootLayout = g16.f444778d;
                Intrinsics.checkNotNullExpressionValue(itemRootLayout, "itemRootLayout");
                ViewGroup.LayoutParams layoutParams = itemRootLayout.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    com.tencent.mobileqq.aio.msglist.holder.c cVar = com.tencent.mobileqq.aio.msglist.holder.c.f190651a;
                    marginLayoutParams.leftMargin = cVar.b();
                    marginLayoutParams.topMargin = cVar.d();
                    marginLayoutParams.rightMargin = cVar.c();
                    marginLayoutParams.bottomMargin = cVar.a();
                    marginLayoutParams.width = a.C7329a.f192417a.b() - com.tencent.qqnt.util.view.b.f362999a.b(24);
                    itemRootLayout.setLayoutParams(marginLayoutParams);
                    FrameLayout vipLayoutContainer = g16.f444779e;
                    Intrinsics.checkNotNullExpressionValue(vipLayoutContainer, "vipLayoutContainer");
                    ViewGroup.LayoutParams layoutParams2 = vipLayoutContainer.getLayoutParams();
                    if (layoutParams2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        marginLayoutParams2.leftMargin = cVar.b();
                        marginLayoutParams2.topMargin = cVar.d();
                        marginLayoutParams2.rightMargin = cVar.c();
                        marginLayoutParams2.bottomMargin = cVar.a();
                        vipLayoutContainer.setLayoutParams(marginLayoutParams2);
                        return g16;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        });
        this.mBinding = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOIceBreakContentComponent$vipManager$2.INSTANCE);
        this.vipManager = lazy2;
        this.vipClickListener = new b();
        this.preloadWelcomeWordingFinishedMark = new AtomicBoolean(false);
    }

    private final void J1() {
        CharSequence N1 = N1();
        if (N1 != null) {
            O1().f444781g.setText(N1, TextView.BufferType.SPANNABLE);
        }
    }

    private final void K1() {
        if (MsgExtKt.S(q1().getMsgRecord())) {
            O1().f444780f.setVisibility(8);
            O1().f444780f.setOnClickListener(null);
        } else {
            O1().f444780f.setVisibility(0);
            O1().f444780f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ickbreak.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIOIceBreakContentComponent.L1(AIOIceBreakContentComponent.this, view);
                }
            });
        }
        if (q1().isSelf()) {
            O1().f444781g.setTextColor(this.context.getResources().getColorStateList(R.color.qui_common_bubble_host_text_primary));
            O1().f444778d.setBackgroundResource(R.drawable.j7b);
        } else {
            O1().f444781g.setTextColor(this.context.getResources().getColorStateList(R.color.qui_common_bubble_guest_text_primary));
            O1().f444778d.setBackgroundResource(R.drawable.j7_);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(AIOIceBreakContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void M1() {
        LinearLayout.LayoutParams layoutParams;
        O1().f444779e.removeAllViews();
        int P1 = P1();
        if (Q1().canShowVipStyle(P1)) {
            ViewGroup.LayoutParams layoutParams2 = O1().getRoot().getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.width = -2;
            }
            S1(P1);
            return;
        }
        O1().f444778d.setVisibility(0);
        O1().f444776b.setVisibility(0);
        O1().f444779e.setVisibility(8);
    }

    private final CharSequence N1() {
        List filterNotNull;
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = q1().getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), com.tencent.mobileqq.aio.msglist.holder.component.text.c.f191997a.a(arrayList).toString(), 13, com.tencent.qqnt.emotion.constant.b.b(), null, null, 24, null);
    }

    private final w71.c O1() {
        return (w71.c) this.mBinding.getValue();
    }

    private final int P1() {
        Integer num;
        MsgAttributeInfo msgAttributeInfo;
        VASMsgElement vASMsgElement;
        VASMsgIceBreak vASMsgIceBreak;
        HashMap<Integer, MsgAttributeInfo> hashMap = q1().getMsgRecord().msgAttrs;
        if (hashMap != null && (msgAttributeInfo = hashMap.get(0)) != null && (vASMsgElement = msgAttributeInfo.vasMsgInfo) != null && (vASMsgIceBreak = vASMsgElement.iceBreakInfo) != null) {
            num = vASMsgIceBreak.templateID;
        } else {
            num = null;
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private final IIceBreakManager Q1() {
        return (IIceBreakManager) this.vipManager.getValue();
    }

    private final boolean R1(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = false;
            }
        }
        return z16;
    }

    private final void S1(int id5) {
        com.tencent.mobileqq.vas.iceBreak.a vipIceBreakView = Q1().getVipIceBreakView(this.context, id5);
        if (vipIceBreakView != null) {
            CharSequence N1 = N1();
            if (N1 == null) {
                N1 = "";
            }
            vipIceBreakView.a(new IceBreakData(N1, id5, q1().getMsgRecord().msgId, MsgExtKt.S(q1().getMsgRecord()), this.vipClickListener));
            O1().f444779e.addView(vipIceBreakView.getView(), -2, -2);
            O1().f444778d.setVisibility(8);
            O1().f444776b.setVisibility(8);
            O1().f444779e.setVisibility(0);
            return;
        }
        O1().f444778d.setVisibility(0);
        O1().f444776b.setVisibility(0);
        O1().f444779e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1() {
        String str = q1().getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "mCurrentMsgItem.msgRecord.senderUid");
        String valueOf = String.valueOf(q1().getMsgRecord().senderUin);
        String str2 = q1().getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "mCurrentMsgItem.msgRecord.peerUid");
        sendIntent(new c.b(str, valueOf, str2));
        U1();
    }

    private final void U1() {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("value_module_id", String.valueOf(P1())), TuplesKt.to("touin", String.valueOf(q1().getMsgRecord().senderUin)));
        com.tencent.mobileqq.aio.utils.b.l("em_group_self_intro_card", mapOf);
    }

    private final void V1() {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("value_module_id", String.valueOf(P1())), TuplesKt.to("touin", String.valueOf(q1().getMsgRecord().senderUin)));
        com.tencent.mobileqq.aio.utils.b.q("em_group_self_intro_card", mapOf);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (!R1(payloads)) {
            return;
        }
        if (this.preloadWelcomeWordingFinishedMark.compareAndSet(false, true)) {
            sendIntent(c.a.f190908d);
        }
        K1();
        J1();
        M1();
        V1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ConstraintLayout root = O1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.mobileqq.aio.msglist.holder.component.ickbreak.b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<d> s1() {
        List<d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new d[]{new ad(getMContext(), q1(), this), new h(getMContext(), q1(), this)});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
