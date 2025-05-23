package com.tencent.mobileqq.aio.msglist.holder.component.mask;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aio.data.msglist.a;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.e;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b!\u0010\"J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/mask/AIOContentMaskComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/e;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "c1", "v", NodeProps.ON_CLICK, "", NodeProps.ON_LONG_CLICK, "Landroid/content/Context;", h.F, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "i", "Lkotlin/Lazy;", "r1", "()Landroid/view/View;", "content", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/data/msglist/a;", "curItemMsg", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOContentMaskComponent extends e implements View.OnClickListener, View.OnLongClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy content;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a curItemMsg;

    public AIOContentMaskComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.mask.AIOContentMaskComponent$content$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOContentMaskComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                View view = new View(AIOContentMaskComponent.this.getContext());
                AIOContentMaskComponent aIOContentMaskComponent = AIOContentMaskComponent.this;
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                view.setOnClickListener(aIOContentMaskComponent);
                view.setOnLongClickListener(aIOContentMaskComponent);
                view.setAlpha(0.0f);
                return view;
            }
        });
        this.content = lazy;
    }

    private final View r1() {
        return (View) this.content.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull a msgItem, @NotNull List<Object> payloads) {
        com.tencent.aio.api.runtime.a aVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curItemMsg = msgItem;
        if (!payloads.isEmpty()) {
            return;
        }
        AIOUtil aIOUtil = AIOUtil.f194084a;
        FrameworkVM mUIModel = getMUIModel();
        AIOMsgItem aIOMsgItem = null;
        if (mUIModel != null) {
            aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext();
        } else {
            aVar = null;
        }
        if (aIOUtil.y(aVar)) {
            if (msgItem instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) msgItem;
            }
            if (aIOMsgItem != null) {
                z16 = d.x(aIOMsgItem);
            } else {
                z16 = false;
            }
            View r16 = r1();
            if (z16) {
                i3 = 8;
            }
            r16.setVisibility(i3);
            if (!z16) {
                q1();
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return r1();
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
    public void onClick(@Nullable View v3) {
        com.tencent.aio.api.runtime.a aVar;
        AIOMsgItem aIOMsgItem;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            FrameworkVM mUIModel = getMUIModel();
            if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null) {
                a aVar2 = this.curItemMsg;
                if (aVar2 instanceof AIOMsgItem) {
                    aIOMsgItem = (AIOMsgItem) aVar2;
                } else {
                    aIOMsgItem = null;
                }
                AIOMsgItem aIOMsgItem2 = aIOMsgItem;
                if (aIOMsgItem2 != null) {
                    AIOUtil aIOUtil = AIOUtil.f194084a;
                    if (aIOUtil.y(aVar)) {
                        aIOUtil.E(aVar, aIOMsgItem2);
                        AIOUtil.B(aIOUtil, aVar, aIOMsgItem2, null, 4, null);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@Nullable View v3) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3)).booleanValue();
        } else {
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(v3);
        return z16;
    }
}
