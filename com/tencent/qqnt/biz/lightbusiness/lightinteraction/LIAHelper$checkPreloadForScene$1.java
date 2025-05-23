package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "it", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LIAHelper$checkPreloadForScene$1 extends Lambda implements Function1<Map<Integer, ? extends List<? extends com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function3<Boolean, Integer, Integer, Unit> $doneCallback;
    final /* synthetic */ LIAActionItem $item;
    final /* synthetic */ LIAScene $scene;
    final /* synthetic */ String $uid;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LIAHelper$checkPreloadForScene$1(LIAActionItem lIAActionItem, LIAScene lIAScene, Function3<? super Boolean, ? super Integer, ? super Integer, Unit> function3, String str) {
        super(1);
        this.$item = lIAActionItem;
        this.$scene = lIAScene;
        this.$doneCallback = function3;
        this.$uid = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, lIAActionItem, lIAScene, function3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function3 doneCallback, Ref.BooleanRef isSuc, Ref.IntRef sucCount, int i3) {
        Intrinsics.checkNotNullParameter(doneCallback, "$doneCallback");
        Intrinsics.checkNotNullParameter(isSuc, "$isSuc");
        Intrinsics.checkNotNullParameter(sucCount, "$sucCount");
        doneCallback.invoke(Boolean.valueOf(isSuc.element), Integer.valueOf(sucCount.element), Integer.valueOf(i3));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, ? extends List<? extends com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> map) {
        invoke2((Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>>) map);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> it) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        Intrinsics.checkNotNullParameter(it, "it");
        List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b> i3 = LIAConfigManager.INSTANCE.a().i(this.$item.getType(), this.$scene);
        if (i3.isEmpty()) {
            this.$doneCallback.invoke(Boolean.FALSE, 0, 0);
            return;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        final Ref.IntRef intRef = new Ref.IntRef();
        final int size = i3.size();
        String str = this.$uid;
        final LIAActionItem lIAActionItem = this.$item;
        Iterator<T> it5 = i3.iterator();
        while (it5.hasNext()) {
            LIAInjectUtil.f353125a.i(str, lIAActionItem, (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) it5.next(), new Function1<Boolean, Unit>(intRef, booleanRef) { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAHelper$checkPreloadForScene$1$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Ref.BooleanRef $isSuc;
                final /* synthetic */ Ref.IntRef $sucCount;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$sucCount = intRef;
                    this.$isSuc = booleanRef;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LIAActionItem.this, intRef, booleanRef);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                        return;
                    }
                    QLog.d("LIAHelper", 1, "[handlePreloadRes] type=" + LIAActionItem.this.getType() + ", subType=" + LIAActionItem.this.c() + ", success=" + z16);
                    Ref.IntRef intRef2 = this.$sucCount;
                    intRef2.element = intRef2.element + (z16 ? 1 : 0);
                    Ref.BooleanRef booleanRef2 = this.$isSuc;
                    booleanRef2.element = (z16 ? 1 : 0) & (booleanRef2.element ? 1 : 0);
                }
            });
        }
        LIAHelper lIAHelper = LIAHelper.f353124a;
        final Function3<Boolean, Integer, Integer, Unit> function3 = this.$doneCallback;
        lIAHelper.h(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.n
            @Override // java.lang.Runnable
            public final void run() {
                LIAHelper$checkPreloadForScene$1.b(Function3.this, booleanRef, intRef, size);
            }
        });
    }
}
