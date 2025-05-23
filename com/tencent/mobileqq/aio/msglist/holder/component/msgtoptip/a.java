package com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.c;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J&\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtoptip/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "", "p1", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "", ICustomDataEditor.NUMBER_PARAM_1, "o1", "Landroid/view/View;", "c1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "f", "Z", "isInflated", "Landroid/view/ViewStub;", h.F, "Landroid/view/ViewStub;", "viewStub", "i", "Lcom/tencent/aio/data/msglist/a;", "mCurMsgItem", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInflated;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewStub viewStub;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a mCurMsgItem;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
            this.viewStub = new ViewStub(context, R.layout.dvu);
        }
    }

    private final boolean n1(AIOMsgItem msgItem, List<Object> payloads) {
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                if (((Map) obj).get(AIOMsgItemPayloadType.NEW_MSG_TIP_LINE) instanceof a.af) {
                    p1();
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    private final boolean o1() {
        return false;
    }

    private final void p1() {
        AIOMsgItem aIOMsgItem;
        int color;
        View findViewById;
        View findViewById2;
        TextView textView;
        com.tencent.aio.data.msglist.a aVar = this.mCurMsgItem;
        if (aVar instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) aVar;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem != null) {
            if (aIOMsgItem.u0()) {
                if (!this.isInflated) {
                    this.viewStub.inflate();
                    this.isInflated = true;
                }
                View f16 = f1();
                if (f16 != null) {
                    f16.setVisibility(0);
                }
                if (o1()) {
                    color = 39423;
                } else {
                    color = this.context.getResources().getColor(R.color.qui_common_brand_standard);
                }
                View f17 = f1();
                if (f17 != null && (textView = (TextView) f17.findViewById(R.id.jml)) != null) {
                    textView.setTextColor(color);
                }
                View f18 = f1();
                if (f18 != null && (findViewById2 = f18.findViewById(R.id.lpp)) != null) {
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(R.id.left_line)");
                    findViewById2.setBackgroundColor(color);
                    findViewById2.getBackground().mutate().setAlpha(128);
                }
                View f19 = f1();
                if (f19 != null && (findViewById = f19.findViewById(R.id.m69)) != null) {
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.right_line)");
                    findViewById.setBackgroundColor(color);
                    findViewById.getBackground().mutate().setAlpha(128);
                    return;
                }
                return;
            }
            View f110 = f1();
            if (f110 != null) {
                f110.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.mCurMsgItem = msgItem;
        if (n1((AIOMsgItem) msgItem, payloads)) {
            return;
        }
        p1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.viewStub;
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
