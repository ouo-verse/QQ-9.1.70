package com.tencent.mobileqq.aio.msglist.holder.component.timestamp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aio.data.msglist.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.c;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.k;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b#\u0010$J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/timestamp/AIOTimestampComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "", "o1", "", "q1", "p1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Landroid/view/View;", "c1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "importance", "l1", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/TextView;", "f", "Lkotlin/Lazy;", ICustomDataEditor.NUMBER_PARAM_1, "()Landroid/widget/TextView;", "timeTv", "<init>", "(Landroid/content/Context;)V", h.F, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOTimestampComponent extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy timeTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/timestamp/AIOTimestampComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.timestamp.AIOTimestampComponent$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOTimestampComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.timestamp.AIOTimestampComponent$timeTv$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTimestampComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TextView textView = new TextView(AIOTimestampComponent.this.getContext());
                textView.setTextSize(2, 12.0f);
                textView.setGravity(17);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                k kVar = k.f192476a;
                marginLayoutParams.topMargin = kVar.b();
                marginLayoutParams.bottomMargin = kVar.a();
                textView.setLayoutParams(marginLayoutParams);
                return textView;
            }
        });
        this.timeTv = lazy;
    }

    private final TextView n1() {
        return (TextView) this.timeTv.getValue();
    }

    private final boolean o1(AIOMsgItem msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return false;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.BG_TEXT_COLOR_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOTimestampComponent", 4, "[handleBgTextColorPayload]: msgId is " + msgItem.getMsgId());
                    }
                    p1(msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.TIMESTAMP_PAYLOAD) != null) {
                    q1(msgItem);
                }
            }
        }
        return true;
    }

    private final void p1(AIOMsgItem msgItem) {
        ColorStateList r16 = msgItem.r();
        if (r16 == null) {
            r16 = this.context.getResources().getColorStateList(R.color.qui_common_text_secondary);
            Intrinsics.checkNotNullExpressionValue(r16, "context.resources.getCol\u2026ui_common_text_secondary)");
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOTimestampComponent", 4, "[updateText]: msgId is " + msgItem.getMsgId() + " textColor is " + r16);
        }
        n1().setTextColor(r16);
    }

    private final void q1(AIOMsgItem msgItem) {
        if (msgItem.w0()) {
            View f16 = f1();
            Intrinsics.checkNotNull(f16);
            f16.setVisibility(0);
            if (TextUtils.isEmpty(msgItem.A0())) {
                n1().setText(en.f(this.context, 3, msgItem.getMsgRecord().msgTime * 1000, true, true));
            } else {
                n1().setText(msgItem.A0());
            }
            p1(msgItem);
            f1().setImportantForAccessibility(2);
            f1().setContentDescription("");
            n1().setContentDescription(n1().getText());
            n1().setClickable(true);
            n1().setFocusable(true);
            return;
        }
        View f17 = f1();
        Intrinsics.checkNotNull(f17);
        f17.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
        aIOMsgItem.b2(false);
        if (o1(aIOMsgItem, payloads)) {
            return;
        }
        q1(aIOMsgItem);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return n1();
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, importance);
        } else {
            n1().setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View f16 = f1();
        Intrinsics.checkNotNull(f16);
        return f16;
    }
}
