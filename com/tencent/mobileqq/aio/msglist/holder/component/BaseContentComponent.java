package com.tencent.mobileqq.aio.msglist.holder.component;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.template.BubbleLayoutCompatPress;
import com.tencent.qqnt.aio.holder.template.b;
import com.tencent.qqnt.aio.menu.q;
import com.tencent.qqnt.aio.menu.r;
import com.tencent.qqnt.aio.menu.t;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
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
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J&\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cH\u0016J\u0006\u0010\u001f\u001a\u00020\u000fJ\b\u0010 \u001a\u00020\u000fH\u0004J\b\u0010!\u001a\u00020\u000fH\u0004J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u000fH\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H&J\b\u0010'\u001a\u00020\u000fH\u0004J\b\u0010(\u001a\u00020\tH\u0004J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016J\u0006\u0010,\u001a\u00020\u0007J\u000f\u0010-\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u0007H\u0017R\"\u00105\u001a\u00028\u00008\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u0010.\"\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "T", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "Lcom/tencent/qqnt/aio/holder/template/b;", "Lcom/tencent/qqnt/aio/menu/processor/b;", "", "", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "o1", "F1", "Lcom/tencent/aio/data/msglist/a;", "bindData", "", "B1", "y1", "A1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "position", "msgItem", "", "payloads", "b1", "w1", "x1", "z1", "h1", ExifInterface.LATITUDE_SOUTH, "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "v1", "u1", "Lcom/tencent/qqnt/aio/holder/a;", "intent", "p0", "C1", Constants.BASE_IN_PLUGIN_ID, "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "q1", "E1", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "mCurrentMsgItem", "f", "Z", "mIsSameBindData", h.F, "mIsSameElement", "Lcom/tencent/qqnt/aio/menu/processor/d;", "i", "Lkotlin/Lazy;", "r1", "()Lcom/tencent/qqnt/aio/menu/processor/d;", "mMenuAddProcessor", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class BaseContentComponent<T extends AIOMsgItem> extends c implements com.tencent.qqnt.aio.holder.template.b, com.tencent.qqnt.aio.menu.processor.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected T mCurrentMsgItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSameBindData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSameElement;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMenuAddProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent$a", "Lcom/tencent/qqnt/aio/menu/ui/c;", "", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends com.tencent.qqnt.aio.menu.ui.c {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseContentComponent<T> f190656c;

        a(BaseContentComponent<T> baseContentComponent) {
            this.f190656c = baseContentComponent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseContentComponent);
            }
        }
    }

    public BaseContentComponent() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.aio.menu.processor.d>(this) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent$mMenuAddProcessor$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ BaseContentComponent<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.qqnt.aio.menu.processor.d invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new com.tencent.qqnt.aio.menu.processor.d(this.this$0) : (com.tencent.qqnt.aio.menu.processor.d) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mMenuAddProcessor = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean A1(com.tencent.aio.data.msglist.a bindData) {
        if (w1() && q1().N0(bindData)) {
            return true;
        }
        return false;
    }

    private final boolean B1(com.tencent.aio.data.msglist.a bindData) {
        Integer num;
        AIOMsgItem aIOMsgItem;
        MsgRecord msgRecord;
        MsgRecord msgRecord2;
        T q16 = q1();
        Integer num2 = null;
        if (!(q16 instanceof AIOMsgItem)) {
            q16 = null;
        }
        if (q16 != null && (msgRecord2 = q16.getMsgRecord()) != null) {
            num = Integer.valueOf(msgRecord2.sendStatus);
        } else {
            num = null;
        }
        if (bindData instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) bindData;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem != null && (msgRecord = aIOMsgItem.getMsgRecord()) != null) {
            num2 = Integer.valueOf(msgRecord.sendStatus);
        }
        return Intrinsics.areEqual(num, num2);
    }

    private final void F1() {
        if (!w1()) {
            return;
        }
        com.tencent.qqnt.aio.menu.ui.c u16 = u1();
        if (u16.d() > 0) {
            sendIntent(new d.at(c1(), u16));
        }
    }

    private final void n1() {
        if (f1() instanceof BubbleLayoutCompatPress) {
            View f16 = f1();
            Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.qqnt.aio.holder.template.BubbleLayoutCompatPress");
            ((BubbleLayoutCompatPress) f16).setLongClickInterceptListener(this);
        }
    }

    private final void o1(com.tencent.qqnt.aio.menu.ui.c menu) {
        if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() && w1()) {
            com.tencent.qqnt.aio.menu.processor.d r16 = r1();
            Context mContext = getMContext();
            T q16 = q1();
            Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            r16.a(menu, new t(mContext, q16, this), new Bundle());
        }
    }

    private final com.tencent.qqnt.aio.menu.processor.d r1() {
        return (com.tencent.qqnt.aio.menu.processor.d) this.mMenuAddProcessor.getValue();
    }

    private final boolean y1(com.tencent.aio.data.msglist.a bindData) {
        if (w1() && q1().isSameItem(bindData) && q1().isSameContent(bindData) && B1(bindData)) {
            return true;
        }
        return false;
    }

    public final void C1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (w1()) {
            HashMap hashMap = new HashMap();
            hashMap.put("aio_information_type", String.valueOf(q1().getMsgRecord().msgType));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_message_bubble", hashMap);
        }
    }

    @Nullable
    public final T D1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (T) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (!w1()) {
            return null;
        }
        return q1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E1(@NotNull T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16);
        } else {
            Intrinsics.checkNotNullParameter(t16, "<set-?>");
            this.mCurrentMsgItem = t16;
        }
    }

    @Override // com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.mIsSameElement = A1(msgItem);
        this.mIsSameBindData = y1(msgItem);
        E1((AIOMsgItem) msgItem);
    }

    @Override // com.tencent.qqnt.aio.holder.template.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            b.a.a(this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void h1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            F1();
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
        n1();
        return f1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    @CallSuper
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.qqnt.aio.menu.processor.b
    public void p0(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            sendIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final T q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        T t16 = this.mCurrentMsgItem;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
        return null;
    }

    @NotNull
    public abstract List<com.tencent.qqnt.aio.menu.ui.d> s1();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.qqnt.aio.menu.ui.c u1() {
        List<com.tencent.qqnt.aio.menu.ui.d> s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.qqnt.aio.menu.ui.c) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        a aVar = new a(this);
        Bundle bundle = new Bundle();
        boolean v16 = v1();
        bundle.putBoolean("isInMultiForwardPage", v16);
        QLog.d("BaseContentComponent", 1, "isInMultiForwardPage = " + v16);
        q b16 = r.f351470a.b(q1());
        if (b16 == null || (s16 = b16.f(getMContext(), q1(), this)) == null) {
            s16 = s1();
        }
        for (com.tencent.qqnt.aio.menu.ui.d dVar : s16) {
            if (!TextUtils.isEmpty(dVar.f())) {
                QLog.d("BaseContentComponent", 1, "menu " + com.tencent.qqnt.aio.utils.b.c(dVar.f()));
            }
            r1().a(aVar, dVar, bundle);
        }
        o1(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean v1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        d.s sVar = new d.s(false, 1, null);
        sendIntent(sVar);
        return sVar.a();
    }

    public final boolean w1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.mCurrentMsgItem != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean x1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.mIsSameBindData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.mIsSameElement;
    }
}
