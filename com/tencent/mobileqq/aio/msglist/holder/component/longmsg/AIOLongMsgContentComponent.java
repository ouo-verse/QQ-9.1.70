package com.tencent.mobileqq.aio.msglist.holder.component.longmsg;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.aio.msg.m;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.longmsg.a;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.j;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.ui.d;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\"\u0010#J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J&\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00162\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/longmsg/AIOLongMsgContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/m;", "msgItem", "", "", "payloads", "", "H1", "", "I1", "J1", Constants.APK_CERTIFICATE, "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "Landroid/view/View;", "c1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/fastertextview/wrapper/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/fastertextview/wrapper/a;", "mContentView", "<init>", "(Landroid/content/Context;)V", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOLongMsgContentComponent extends BaseContentComponent<m> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.fastertextview.wrapper.a mContentView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/longmsg/AIOLongMsgContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.longmsg.AIOLongMsgContentComponent$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61029);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOLongMsgContentComponent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
            this.mContentView = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a.a(context, a.C7329a.f192417a.b(), null);
        }
    }

    private final void G1(m msgItem) {
        if (msgItem.i2() == -1) {
            msgItem.k2(1);
            sendIntent(new a.C7301a(msgItem.getMsgId()));
        }
    }

    private final boolean H1(m msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if ((obj instanceof HashMap) && ((Map) obj).get(AIOMsgItemPayloadType.LONGMSG_FETCH_FAIL) != null) {
                QLog.i("AIOLongMsgContentComponent", 1, "[handlePayLoads]: fetchFlag is " + msgItem.i2() + ", msgId is " + q1().getMsgId());
                I1();
            }
        }
        return false;
    }

    private final void I1() {
        View g16 = this.mContentView.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) g16).setText(q1().j2());
    }

    private final void J1(m msgItem) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        AIOBubbleSkinInfo.c e16;
        AIOBubbleSkinInfo.BackgroundImageInfo a16;
        Drawable a17;
        boolean z16;
        int minWidth;
        int minHeight;
        View g16 = this.mContentView.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) g16;
        AIOBubbleSkinInfo x06 = msgItem.x0();
        j jVar = null;
        if (x06 != null && (a16 = x06.a()) != null && (a17 = a16.a()) != null) {
            Integer valueOf = Integer.valueOf(a16.g());
            boolean z17 = true;
            if (valueOf.intValue() != textView.getMinWidth()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!Boolean.valueOf(z16).booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                minWidth = valueOf.intValue();
            } else {
                minWidth = textView.getMinWidth();
            }
            textView.setMinWidth(minWidth);
            Integer valueOf2 = Integer.valueOf(a16.f());
            if (valueOf2.intValue() == textView.getMinHeight()) {
                z17 = false;
            }
            if (!Boolean.valueOf(z17).booleanValue()) {
                valueOf2 = null;
            }
            if (valueOf2 != null) {
                minHeight = valueOf2.intValue();
            } else {
                minHeight = textView.getMinHeight();
            }
            textView.setMinHeight(minHeight);
            textView.setBackground(a17);
        }
        AIOBubbleSkinInfo x07 = msgItem.x0();
        if (x07 != null) {
            aVar = x07.b();
        } else {
            aVar = null;
        }
        if (aVar instanceof j) {
            jVar = (j) aVar;
        }
        if (jVar != null && (textView.getPaddingLeft() != jVar.c() || textView.getPaddingRight() != jVar.d() || textView.getPaddingTop() != jVar.e() || textView.getPaddingBottom() != jVar.b())) {
            textView.setPadding(jVar.c(), jVar.e(), jVar.d(), jVar.b());
        }
        AIOBubbleSkinInfo x08 = msgItem.x0();
        if (x08 != null && (e16 = x08.e()) != null) {
            Integer a18 = e16.a();
            if (a18 != null) {
                textView.setTextColor(a18.intValue());
            }
            ColorStateList b16 = e16.b();
            if (b16 != null) {
                textView.setTextColor(b16);
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (!H1(q1(), payloads)) {
            return;
        }
        QLog.i("AIOLongMsgContentComponent", 1, "[bind]: fetchFlag is " + q1().i2() + ", msgId is " + q1().getMsgId());
        J1(q1());
        I1();
        G1(q1());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        View g16 = this.mContentView.g();
        Intrinsics.checkNotNull(g16);
        return g16;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<d> s1() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new h(this.context, q1(), this));
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
