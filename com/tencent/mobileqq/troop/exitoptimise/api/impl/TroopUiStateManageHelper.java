package com.tencent.mobileqq.troop.exitoptimise.api.impl;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.a;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.exitoptimise.msgintent.TroopUiStateManageMsgIntent;
import com.tencent.mobileqq.troop.utils.p;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u000b*\u0001,\b\u0007\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u00015B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0017H\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010'R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020)0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00102\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b-\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/troop/exitoptimise/api/impl/TroopUiStateManageHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", "e", "g", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "i", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$OnMsgSendFailEvent;", "k", "o", "", "inputEnable", "", "disableHintText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateRight2IvEvent;", "event", DomainData.DOMAIN_NAME, "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/troop/exitoptimise/msgintent/TroopUiStateManageMsgIntent$UpdateInputMode;", "Ljava/util/concurrent/ConcurrentHashMap;", "inputGagModeMap", "Lcom/tencent/mobileqq/troop/exitoptimise/msgintent/TroopUiStateManageMsgIntent$UpdateGroupRight2Iv;", "f", "right2IvMap", "com/tencent/mobileqq/troop/exitoptimise/api/impl/TroopUiStateManageHelper$b", h.F, "Lcom/tencent/mobileqq/troop/exitoptimise/api/impl/TroopUiStateManageHelper$b;", "mAction", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateRight2IvEvent;", "hideTitleRight2IvMsgIntent", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes19.dex */
public final class TroopUiStateManageHelper implements com.tencent.aio.main.businesshelper.h, g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, TroopUiStateManageMsgIntent.UpdateInputMode> inputGagModeMap = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, TroopUiStateManageMsgIntent.UpdateGroupRight2Iv> right2IvMap = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy hideTitleRight2IvMsgIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/exitoptimise/api/impl/TroopUiStateManageHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            TroopUiStateManageHelper.this.i(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public TroopUiStateManageHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIOTitleEvent.UpdateRight2IvEvent>() { // from class: com.tencent.mobileqq.troop.exitoptimise.api.impl.TroopUiStateManageHelper$hideTitleRight2IvMsgIntent$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOTitleEvent.UpdateRight2IvEvent invoke() {
                return new AIOTitleEvent.UpdateRight2IvEvent(false, false, null, 0, "");
            }
        });
        this.hideTitleRight2IvMsgIntent = lazy;
    }

    private final void e() {
        j e16;
        QLog.d("TroopUiStateManageHelper", 4, "[doOnCreate] ");
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.f(this, this.mAction);
        }
    }

    private final void g() {
        j e16;
        QLog.d("TroopUiStateManageHelper", 4, "[doOnDestroy] ");
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this, this.mAction);
        }
        this.inputGagModeMap.clear();
        this.right2IvMap.clear();
    }

    private final AIOTitleEvent.UpdateRight2IvEvent h() {
        return (AIOTitleEvent.UpdateRight2IvEvent) this.hideTitleRight2IvMsgIntent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(MsgIntent msgIntent) {
        if (msgIntent instanceof TroopUiStateManageMsgIntent.UpdateInputMode) {
            TroopUiStateManageMsgIntent.UpdateInputMode updateInputMode = (TroopUiStateManageMsgIntent.UpdateInputMode) msgIntent;
            QLog.d("TroopUiStateManageHelper", 4, "[handleAction] type:" + updateInputMode.getType() + ", enable:" + updateInputMode.getInputEnable() + " ");
            if (updateInputMode.getInputEnable()) {
                this.inputGagModeMap.remove(Integer.valueOf(updateInputMode.getType()));
            } else {
                this.inputGagModeMap.put(Integer.valueOf(updateInputMode.getType()), msgIntent);
            }
            p.f302196a.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.exitoptimise.api.impl.TroopUiStateManageHelper$handleAction$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TroopUiStateManageHelper.this.o();
                }
            });
            return;
        }
        if (msgIntent instanceof TroopUiStateManageMsgIntent.UpdateGroupRight2Iv) {
            this.right2IvMap.put(Integer.valueOf(((TroopUiStateManageMsgIntent.UpdateGroupRight2Iv) msgIntent).getType()), msgIntent);
            p.f302196a.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.exitoptimise.api.impl.TroopUiStateManageHelper$handleAction$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TroopUiStateManageHelper.this.q();
                }
            });
        } else if (msgIntent instanceof AIOMsgSendEvent.OnMsgSendFailEvent) {
            k((AIOMsgSendEvent.OnMsgSendFailEvent) msgIntent);
        }
    }

    private final boolean j() {
        if (this.inputGagModeMap.get(1) != null) {
            return true;
        }
        return false;
    }

    private final void k(AIOMsgSendEvent.OnMsgSendFailEvent msgIntent) {
        FragmentActivity fragmentActivity;
        Fragment c16;
        if (msgIntent.a() == 110) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar != null && (c16 = aVar.c()) != null) {
                fragmentActivity = c16.getActivity();
            } else {
                fragmentActivity = null;
            }
            QQToast.makeText(fragmentActivity, 1, "\u65e0\u6cd5\u5728\u5df2\u9000\u51fa\u7684\u7fa4\u804a\u53d1\u6d88\u606f", 0).show();
        }
    }

    private final void m(boolean inputEnable, String disableHintText) {
        j e16;
        QLog.d("TroopUiStateManageHelper", 4, "[sendInnerChangeInputGapMode] inputEnable:" + inputEnable + ", disableHintText:" + disableHintText);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(new InputGagMsgIntent.ChangeInputGagMode(!inputEnable, disableHintText));
        }
        p();
        q();
    }

    private final void n(AIOTitleEvent.UpdateRight2IvEvent event) {
        j e16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        j e16;
        QLog.d("TroopUiStateManageHelper", 4, "[updateInputMode] ");
        if (this.inputGagModeMap.get(3) != null) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.h(new InputGagMsgIntent.ChangeInputGagMode(!r0.getInputEnable(), "\u65e0\u6cd5\u5728\u5df2\u9000\u51fa\u7684\u7fa4\u804a\u4e2d\u53d1\u9001\u6d88\u606f"));
                return;
            }
            return;
        }
        TroopUiStateManageMsgIntent.UpdateInputMode updateInputMode = this.inputGagModeMap.get(1);
        if (updateInputMode != null) {
            m(updateInputMode.getInputEnable(), updateInputMode.getDisableHintText());
            return;
        }
        TroopUiStateManageMsgIntent.UpdateInputMode updateInputMode2 = this.inputGagModeMap.get(2);
        if (updateInputMode2 != null) {
            m(updateInputMode2.getInputEnable(), updateInputMode2.getDisableHintText());
        } else {
            m(true, "");
        }
    }

    private final void p() {
        j e16;
        int i3;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            if (j()) {
                i3 = 8;
            } else {
                i3 = 9;
            }
            e16.h(new AIOTitleEvent.UpdateRight1IvEvent(false, false, null, i3, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (j()) {
            n(h());
            return;
        }
        TroopUiStateManageMsgIntent.UpdateGroupRight2Iv updateGroupRight2Iv = this.right2IvMap.get(1);
        if (updateGroupRight2Iv != null) {
            n(updateGroupRight2Iv.getEvent());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350642i1;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.troop.exitoptimise.msgintent.TroopUiStateManageMsgIntent.UpdateInputMode");
        hashSet.add("com.tencent.mobileqq.troop.exitoptimise.msgintent.TroopUiStateManageMsgIntent.UpdateGroupRight1Iv");
        hashSet.add("com.tencent.mobileqq.troop.exitoptimise.msgintent.TroopUiStateManageMsgIntent.UpdateGroupRight2Iv");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.OnMsgSendFailEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "TroopUiStateManageHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.aioContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state == 12) {
                g();
                return;
            }
            return;
        }
        e();
    }
}
