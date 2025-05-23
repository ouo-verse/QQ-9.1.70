package com.tencent.mobileqq.aio.msglist.holder.component.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.ArkAppLoadLayout;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.TemplateMsgConfigManager;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.b;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.c;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.d;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.k;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.m;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOReport;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ao;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.rich.j;
import com.tencent.qqnt.rich.n;
import com.tencent.qqnt.rich.p;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0015\u001a\u00020\fH\u0016J \u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0014\u0010\u001d\u001a\u00020\u00112\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010'\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0016\u0010)\u001a\u00020(2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\n\u0010*\u001a\u0004\u0018\u00010\u0019H\u0002J\n\u0010,\u001a\u0004\u0018\u00010+H\u0002J\u0018\u0010.\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010-\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u00101\u001a\u00020\fH\u0002J\u0010\u00103\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u0002H\u0002J\b\u00104\u001a\u00020\fH\u0002R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010\u001e\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001d\u0010B\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010<\u001a\u0004\bD\u0010ER\u001b\u0010I\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010<\u001a\u0004\bH\u0010ER\u0016\u0010L\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/AIOTemplateMsgComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/d;", "", "R1", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/view/View;", "c1", "Lcom/tencent/aio/api/runtime/a;", "L1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "appName", "bizName", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/b;", DownloadInfo.spKey_Config, "L", "msg", "S1", MosaicConstants$JsProperty.PROP_ROOT_VIEW, ICustomDataEditor.STRING_ARRAY_PARAM_2, "V1", "Z1", "Landroid/content/Context;", "context", "Landroidx/constraintlayout/widget/ConstraintLayout;", "parentView", "targetWidth", "e2", "", "W1", "M1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "J1", "canRetry", "d2", "X1", "Y1", "c2", "templateMsgItem", "N1", "K1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "Lcom/tencent/qqnt/rich/n;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/rich/n;", "richRender", "D", "Lkotlin/Lazy;", "U1", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "E", "O1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "loadingView", UserInfo.SEX_FEMALE, "Q1", "()I", "loadingViewWidth", "G", "P1", "loadingViewHeight", "H", "I", "currentPosition", "<init>", "(Landroid/content/Context;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOTemplateMsgComponent extends BaseContentComponent<TemplateMsgItem> implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<Integer> J;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private n richRender;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingViewWidth;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingViewHeight;

    /* renamed from: H, reason: from kotlin metadata */
    private int currentPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/AIOTemplateMsgComponent$a;", "", "", "COMPONENT_TARGET_WIDTH$delegate", "Lkotlin/Lazy;", "b", "()I", "COMPONENT_TARGET_WIDTH", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.AIOTemplateMsgComponent$a, reason: from kotlin metadata */
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
        public final int b() {
            return ((Number) AIOTemplateMsgComponent.J.getValue()).intValue();
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
        Lazy<Integer> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOTemplateMsgComponent$Companion$COMPONENT_TARGET_WIDTH$2.INSTANCE);
        J = lazy;
    }

    public AIOTemplateMsgComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.template.AIOTemplateMsgComponent$rootView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTemplateMsgComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConstraintLayout invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ConstraintLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOTemplateMsgComponent.this.context;
                ConstraintLayout constraintLayout = new ConstraintLayout(context2);
                AIOTemplateMsgComponent aIOTemplateMsgComponent = AIOTemplateMsgComponent.this;
                constraintLayout.setId(R.id.f30610ot);
                constraintLayout.addView(AIOTemplateMsgComponent.T1(aIOTemplateMsgComponent, null, 1, null), -1, -2);
                return constraintLayout;
            }
        });
        this.rootView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ArkAppLoadLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.template.AIOTemplateMsgComponent$loadingView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTemplateMsgComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ArkAppLoadLayout invoke() {
                ArkAppLoadLayout J1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArkAppLoadLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                J1 = AIOTemplateMsgComponent.this.J1();
                return J1;
            }
        });
        this.loadingView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AIOTemplateMsgComponent$loadingViewWidth$2.INSTANCE);
        this.loadingViewWidth = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AIOTemplateMsgComponent$loadingViewHeight$2.INSTANCE);
        this.loadingViewHeight = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArkAppLoadLayout J1() {
        View findViewById = LayoutInflater.from(this.context).inflate(R.layout.dz8, U1()).findViewById(R.id.eet);
        if (findViewById instanceof ArkAppLoadLayout) {
            return (ArkAppLoadLayout) findViewById;
        }
        return null;
    }

    private final void K1() {
        Y1(this.currentPosition);
    }

    private final b M1() {
        String str;
        String b16;
        com.tencent.mobileqq.aio.msg.template.d n26 = q1().n2();
        String str2 = "";
        if (n26 == null || (str = n26.a()) == null) {
            str = "";
        }
        com.tencent.mobileqq.aio.msg.template.d n27 = q1().n2();
        if (n27 != null && (b16 = n27.b()) != null) {
            str2 = b16;
        }
        return TemplateMsgConfigManager.f191899a.j(str, str2);
    }

    private final String N1(TemplateMsgItem templateMsgItem) {
        String e16;
        MsgRecord msgRecord = templateMsgItem.getMsgRecord();
        com.tencent.mobileqq.aio.msg.template.d n26 = templateMsgItem.n2();
        if (n26 != null && (e16 = n26.e()) != null) {
            StringBuilder sb5 = new StringBuilder();
            if (MsgExtKt.S(msgRecord)) {
                sb5.append("\u53d1\u51fa");
            } else {
                sb5.append("\u53d1\u6765");
            }
            sb5.append(e16);
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "contentDesc.toString()");
            return sb6;
        }
        return "";
    }

    private final ArkAppLoadLayout O1() {
        return (ArkAppLoadLayout) this.loadingView.getValue();
    }

    private final int P1() {
        return ((Number) this.loadingViewHeight.getValue()).intValue();
    }

    private final int Q1() {
        return ((Number) this.loadingViewWidth.getValue()).intValue();
    }

    private final View S1(String msg2) {
        TextView textView = new TextView(this.context);
        if (msg2 == null) {
            msg2 = "\u8be5\u6d88\u606f\u6682\u4e0d\u652f\u6301";
        }
        textView.setText(msg2);
        textView.setTextSize(32.0f);
        int dpToPx = ViewUtils.dpToPx(32.0f);
        textView.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ View T1(AIOTemplateMsgComponent aIOTemplateMsgComponent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return aIOTemplateMsgComponent.S1(str);
    }

    private final ConstraintLayout U1() {
        return (ConstraintLayout) this.rootView.getValue();
    }

    private final int V1() {
        return Math.min(R1(), INSTANCE.b());
    }

    private final boolean W1(List<Object> payloads) {
        n nVar;
        boolean z16 = false;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                if (((Map) obj).get(AIOMsgItemPayloadType.THEME_CHANGE_PAYLOAD) != null && (nVar = this.richRender) != null) {
                    nVar.d("rich_theme_change", null);
                }
                z16 = true;
            }
        }
        return z16;
    }

    private final void X1() {
        TemplateMsgConfigManager.f191899a.f(this);
    }

    private final void Y1(int position) {
        String a16;
        String str;
        U1().removeAllViews();
        b M1 = M1();
        com.tencent.mobileqq.aio.msg.template.d n26 = q1().n2();
        if (n26 != null && (a16 = n26.a()) != null) {
            com.tencent.mobileqq.aio.msg.template.d n27 = q1().n2();
            if (n27 == null || (str = n27.b()) == null) {
                str = "";
            }
            if (!q1().k2()) {
                TemplateMsgConfigManager templateMsgConfigManager = TemplateMsgConfigManager.f191899a;
                if (templateMsgConfigManager.m(a16, str)) {
                    q1().q2();
                } else {
                    X1();
                    templateMsgConfigManager.o(a16, str);
                }
            }
            if (!c.c(M1)) {
                d2(c.b(M1), c.a(M1));
                c2();
                return;
            }
            e2(this.context, U1(), V1(), q1());
            U1().setContentDescription(N1(q1()));
            a2(U1(), q1());
            Z1(position);
            if (U1().getChildCount() <= 0) {
                QLog.e("TemMsg.AIOTemplateMsgComponent", 1, "bindView got child count 0");
                d2("\u52a0\u8f7d\u5931\u8d25", false);
            }
            c2();
            return;
        }
        QLog.e("TemMsg.AIOTemplateMsgComponent", 1, "appName is null");
    }

    private final void Z1(int position) {
        Integer num;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a L1 = L1();
        if (L1 != null && (g16 = L1.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            num = Integer.valueOf(c16.e());
        } else {
            num = null;
        }
        ((IAIOReport) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOReport.class)).reportArkExpo(position, num, q1().getMsgRecord());
    }

    private final void a2(View rootView, TemplateMsgItem msgItem) {
        float dimension;
        int dimension2 = (int) this.context.getResources().getDimension(R.dimen.f158247b9);
        float f16 = 10;
        int i3 = (int) (this.context.getResources().getDisplayMetrics().density * f16);
        int dimension3 = (int) this.context.getResources().getDimension(R.dimen.b_);
        if (msgItem.o2()) {
            dimension = this.context.getResources().getDisplayMetrics().density * f16;
        } else {
            dimension = getMContext().getResources().getDimension(R.dimen.f158192a0);
        }
        rootView.setPadding(dimension2, i3, dimension3, (int) dimension);
    }

    private final void c2() {
        String str;
        a aVar = a.f191886a;
        if (!aVar.c()) {
            return;
        }
        QLog.e("TemMsg.AIOTemplateMsgComponent", 1, "bindView got child count " + U1().getChildCount());
        com.tencent.mobileqq.aio.msg.template.d n26 = q1().n2();
        String str2 = null;
        if (n26 != null) {
            str = n26.a();
        } else {
            str = null;
        }
        com.tencent.mobileqq.aio.msg.template.d n27 = q1().n2();
        if (n27 != null) {
            str2 = n27.f();
        }
        U1().addView(aVar.d(this.context, str + ";" + str2), new FrameLayout.LayoutParams(-2, -2));
    }

    private final void d2(String msg2, boolean canRetry) {
        ArkAppLoadLayout O1 = O1();
        if (O1 == null) {
            QLog.e("TemMsg.AIOTemplateMsgComponent", 1, "loadingLayout got null, is impossible");
            return;
        }
        if (O1.getParent() != null) {
            ab.c(O1);
        }
        U1().addView(O1(), new ViewGroup.LayoutParams(Math.min(Q1(), R1()), P1()));
        O1.b(msg2, canRetry);
        if (a.f191886a.c()) {
            QLog.w("TemMsg.AIOTemplateMsgComponent", 1, "show errorView", new Exception("show errorView"));
        }
    }

    private final void e2(Context context, ConstraintLayout parentView, int targetWidth, TemplateMsgItem msgItem) {
        j jVar;
        com.tencent.mobileqq.aio.msglist.holder.component.template.report.c cVar;
        String str;
        String str2;
        com.tencent.mobileqq.aio.msglist.holder.component.template.report.b bVar = new com.tencent.mobileqq.aio.msglist.holder.component.template.report.b(msgItem.n2());
        if (msgItem.n2() == null) {
            String m26 = msgItem.m2();
            if (m26 == null) {
                m26 = "template_info_is_null";
            }
            bVar.h("aio_ark2md_render_fail", -1, m26);
        }
        com.tencent.qqnt.rich.c l26 = msgItem.l2();
        String str3 = null;
        if (l26 != null) {
            jVar = new j(l26, null, targetWidth, new p(null, null, 0, 0.0f, 0, 0.0f, 0.0f, 0, 255, null), null, 18, null);
        } else {
            String m27 = msgItem.m2();
            if (m27 == null) {
                m27 = "layoutInfo_is_null";
            }
            bVar.h("aio_ark2md_render_fail", -2, m27);
            jVar = null;
        }
        if (jVar == null) {
            QLog.e("TemMsg.AIOTemplateMsgComponent", 1, "createView but layoutinfo is null");
            d2("\u52a0\u8f7d\u5931\u8d25", false);
            return;
        }
        com.tencent.mobileqq.aio.msg.template.d n26 = msgItem.n2();
        if (n26 != null) {
            cVar = new com.tencent.mobileqq.aio.msglist.holder.component.template.report.c(msgItem, n26);
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.f();
        }
        this.richRender = m.f191935a.a(context, parentView, jVar, new com.tencent.mobileqq.aio.msglist.holder.component.template.jump.c(msgItem, cVar));
        if (parentView.getChildCount() == 0) {
            bVar.h("aio_ark2md_render_fail", -3, "child_count_zero");
            com.tencent.mobileqq.aio.msg.template.d n27 = msgItem.n2();
            if (n27 != null) {
                str2 = n27.a();
            } else {
                str2 = null;
            }
            com.tencent.mobileqq.aio.msg.template.d n28 = msgItem.n2();
            if (n28 != null) {
                str3 = n28.b();
            }
            QLog.w("TemMsg.AIOTemplateMsgComponent", 1, "bind " + str2 + "," + str3 + " failed");
            return;
        }
        bVar.i("aio_ark2md_render_success", 10L);
        if (QLog.isColorLevel()) {
            com.tencent.mobileqq.aio.msg.template.d n29 = msgItem.n2();
            if (n29 != null) {
                str = n29.a();
            } else {
                str = null;
            }
            com.tencent.mobileqq.aio.msg.template.d n210 = msgItem.n2();
            if (n210 != null) {
                str3 = n210.b();
            }
            QLog.i("TemMsg.AIOTemplateMsgComponent", 2, "bind " + str + "," + str3 + " success");
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.template.common.d
    public void L(@NotNull String appName, @NotNull String bizName, @NotNull b config) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appName, bizName, config);
            return;
        }
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(config, "config");
        com.tencent.mobileqq.aio.msg.template.d n26 = q1().n2();
        String str2 = null;
        if (n26 != null) {
            str = n26.a();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(appName, str)) {
            com.tencent.mobileqq.aio.msg.template.d n27 = q1().n2();
            if (n27 != null) {
                str2 = n27.b();
            }
            if (Intrinsics.areEqual(bizName, str2)) {
                q1().q2();
                K1();
            }
        }
    }

    @Nullable
    public final com.tencent.aio.api.runtime.a L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        d.e eVar = new d.e(null, 1, null);
        sendIntent(new d.h(eVar));
        return eVar.a();
    }

    protected int R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return a.C7329a.f192417a.f(true);
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
        this.currentPosition = position;
        if (W1(payloads)) {
            return;
        }
        Y1(position);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return U1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        n nVar = this.richRender;
        if (nVar != null) {
            nVar.d("rich_destory", null);
        }
        U1().removeAllViews();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.aio.msg.template.d n26 = q1().n2();
        k kVar = k.f191932a;
        if (kVar.d(q1())) {
            arrayList.add(new ad(getMContext(), q1(), this));
        }
        if (n26 == null) {
            QLog.e("TemMsg.AIOTemplateMsgComponent", 1, "get menu list for " + q1().getMsgRecord().msgId + " but template info is null");
        } else {
            if (kVar.b(n26)) {
                arrayList.add(new com.tencent.qqnt.aio.menu.k(getMContext(), q1(), this, null, 8, null));
            }
            if (kVar.a(n26)) {
                arrayList.add(new i(getMContext(), q1()));
            }
        }
        arrayList.add(new ap(getMContext(), q1(), this));
        arrayList.add(new af(getMContext(), q1(), this));
        arrayList.add(new h(getMContext(), q1(), this));
        if (n26 != null && kVar.c(n26)) {
            arrayList.add(new u(getMContext(), q1(), this));
        }
        arrayList.add(new com.tencent.qqnt.aio.menu.a(getMContext(), q1(), this));
        arrayList.add(new ao(getMContext(), q1()));
        arrayList.add(new ag(getMContext(), q1()));
        arrayList.add(new aj(getMContext(), q1(), this));
        return arrayList;
    }
}
