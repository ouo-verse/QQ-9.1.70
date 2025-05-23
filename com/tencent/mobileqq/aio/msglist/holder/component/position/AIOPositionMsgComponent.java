package com.tencent.mobileqq.aio.msglist.holder.component.position;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.PositionMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.aio.adapter.api.IAIOReport;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J&\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0004\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/position/AIOPositionMsgComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/PositionMsgItem;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "O1", "", "J1", "L1", "", "", "payloads", "", "M1", "position", "N1", "templateMsgItem", "", "I1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "c1", "Lcom/tencent/aio/api/runtime/a;", "H1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "K1", "()Landroid/widget/FrameLayout;", "<init>", "(Landroid/content/Context;)V", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPositionMsgComponent extends BaseContentComponent<PositionMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int E;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/position/AIOPositionMsgComponent$a;", "", "", "COMPONENT_TARGET_WIDTH", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.position.AIOPositionMsgComponent$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62831);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            E = ViewUtils.dip2px(263.0f);
        }
    }

    public AIOPositionMsgComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.position.AIOPositionMsgComponent$rootView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPositionMsgComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AIOPositionMsgHelper aIOPositionMsgHelper = AIOPositionMsgHelper.f191690a;
                context2 = AIOPositionMsgComponent.this.context;
                return AIOPositionMsgHelper.v(aIOPositionMsgHelper, context2, false, 2, null);
            }
        });
        this.rootView = lazy;
    }

    private final String I1(PositionMsgItem templateMsgItem) {
        MsgRecord msgRecord = templateMsgItem.getMsgRecord();
        String f16 = templateMsgItem.j2().f();
        if (f16 == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        if (MsgExtKt.S(msgRecord)) {
            sb5.append("\u53d1\u51fa");
        } else {
            sb5.append("\u53d1\u6765");
        }
        sb5.append(f16);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "contentDesc.toString()");
        return sb6;
    }

    private final int J1() {
        return a.C7329a.f192417a.f(true);
    }

    private final FrameLayout K1() {
        return (FrameLayout) this.rootView.getValue();
    }

    private final int L1() {
        return Math.min(J1(), E);
    }

    private final boolean M1(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = true;
            }
        }
        return z16;
    }

    private final void N1(int position) {
        Integer num;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a H1 = H1();
        if (H1 != null && (g16 = H1.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            num = Integer.valueOf(c16.e());
        } else {
            num = null;
        }
        ((IAIOReport) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOReport.class)).reportArkExpo(position, num, q1().getMsgRecord());
    }

    private final void O1(View rootView) {
        float f16 = 10;
        rootView.setPadding((int) this.context.getResources().getDimension(R.dimen.f158247b9), (int) (this.context.getResources().getDisplayMetrics().density * f16), (int) this.context.getResources().getDimension(R.dimen.b_), (int) (this.context.getResources().getDisplayMetrics().density * f16));
    }

    @Nullable
    public final com.tencent.aio.api.runtime.a H1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        d.e eVar = new d.e(null, 1, null);
        sendIntent(new d.h(eVar));
        return eVar.a();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (M1(payloads)) {
            return;
        }
        FrameLayout K1 = K1();
        ViewGroup.LayoutParams layoutParams = K1().getLayoutParams();
        layoutParams.width = L1();
        K1.setLayoutParams(layoutParams);
        AIOPositionMsgHelper.f191690a.k(this.context, K1(), q1().j2());
        K1().setContentDescription(I1(q1()));
        O1(K1());
        N1(position);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return K1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new k(this.context, q1(), this, null, 8, null), new i(this.context, q1()), new ap(this.context, q1(), this), new af(this.context, q1(), this), new h(this.context, q1(), this), new u(this.context, q1(), this), new ad(this.context, q1(), this), new ag(this.context, q1()), new aj(this.context, q1(), this)});
        arrayList.addAll(listOf);
        return arrayList;
    }
}
