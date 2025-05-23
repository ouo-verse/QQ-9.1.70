package com.tencent.mobileqq.aio.msglist.holder.component.select;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.e;
import com.tencent.mobileqq.aio.msglist.holder.component.select.SelectComponentUIState;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u001b\u0010!\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/select/AIOSelectComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/e;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "C1", "", "", "payloads", "", "x1", "y1", "Landroid/content/Context;", "context", "", "w1", "z1", "B1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mobileqq/aio/msglist/holder/component/select/b;", "u1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, h.F, "Lkotlin/Lazy;", "v1", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "contentView", "i", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "currentMsgItem", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOSelectComponent extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem currentMsgItem;

    public AIOSelectComponent(@NotNull final Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUICheckBox>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.select.AIOSelectComponent$contentView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final QUICheckBox invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (QUICheckBox) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    QUICheckBox qUICheckBox = new QUICheckBox(this.$context);
                    Context context2 = this.$context;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(context2.getResources().getDimensionPixelOffset(R.dimen.c0p), context2.getResources().getDimensionPixelOffset(R.dimen.c0p));
                    layoutParams.setMargins(context2.getResources().getDimensionPixelOffset(R.dimen.c0o), context2.getResources().getDimensionPixelOffset(R.dimen.c0q), 0, 0);
                    qUICheckBox.setLayoutParams(layoutParams);
                    qUICheckBox.setVisibility(8);
                    return qUICheckBox;
                }
            });
            this.contentView = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(AIOSelectComponent this$0, CompoundButton compoundButton, boolean z16) {
        AIOMsgItem aIOMsgItem;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack() && (aIOMsgItem = this$0.currentMsgItem) != null) {
            this$0.sendIntent(new c(aIOMsgItem, z16));
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void B1(AIOMsgItem msgItem) {
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            v1().setContentDescription(msgItem.w());
        }
    }

    private final void C1(AIOMsgItem msgItem) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (msgItem.P0() && !msgItem.S0()) {
            QUICheckBox v16 = v1();
            v16.setVisibility(msgItem.V0());
            v16.setChecked(y1(msgItem));
            ViewGroup.LayoutParams layoutParams = v16.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                Context context = v16.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "it.context");
                marginLayoutParams.rightMargin = w1(msgItem, context);
            }
            q1();
            z1();
            B1(msgItem);
            return;
        }
        p1();
    }

    private final QUICheckBox v1() {
        return (QUICheckBox) this.contentView.getValue();
    }

    private final int w1(AIOMsgItem msgItem, Context context) {
        int viewType = msgItem.getViewType();
        if (viewType != 69) {
            if (viewType != 92) {
                return 0;
            }
            return context.getResources().getDimensionPixelOffset(R.dimen.c0q);
        }
        return context.getResources().getDimensionPixelOffset(R.dimen.c0q);
    }

    private final boolean x1(List<Object> payloads, AIOMsgItem msgItem) {
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if ((obj instanceof HashMap) && ((Map) obj).get(AIOMsgItemPayloadType.SELECT_PAYLOAD) != null) {
                C1(msgItem);
            }
        }
        return false;
    }

    private final boolean y1(AIOMsgItem msgItem) {
        d dVar = new d(msgItem, false, 2, null);
        sendIntent(dVar);
        return dVar.b();
    }

    private final void z1() {
        v1().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.select.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                AIOSelectComponent.A1(AIOSelectComponent.this, compoundButton, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
        this.currentMsgItem = aIOMsgItem;
        if (x1(payloads, aIOMsgItem)) {
            C1(aIOMsgItem);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof SelectComponentUIState.SetCheck) {
            v1().setChecked(((SelectComponentUIState.SetCheck) state).a());
        } else if (state instanceof SelectComponentUIState.HideCheckBox) {
            p1();
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            this.currentMsgItem = null;
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public QUICheckBox c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QUICheckBox) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return v1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b();
    }
}
