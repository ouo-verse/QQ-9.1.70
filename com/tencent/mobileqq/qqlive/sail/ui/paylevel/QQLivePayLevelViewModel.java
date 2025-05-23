package com.tencent.mobileqq.qqlive.sail.ui.paylevel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.base.d;
import dk4.c;
import ek4.PayLevelEnterRoomInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/paylevel/QQLivePayLevelViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "", "roomId", "", "fromFloatWindow", "", "O1", "P1", "N1", "Ldk4/a;", "i", "Ldk4/a;", "enterRoomBubbleLogic", "Landroidx/lifecycle/MediatorLiveData;", "Lek4/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MediatorLiveData;", "_enterRoomInfo", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "getEnterRoomInfo", "()Landroidx/lifecycle/LiveData;", "enterRoomInfo", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePayLevelViewModel extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<PayLevelEnterRoomInfo> enterRoomInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final dk4.a enterRoomBubbleLogic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PayLevelEnterRoomInfo> _enterRoomInfo;

    public QQLivePayLevelViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        dk4.a aVar = new dk4.a();
        this.enterRoomBubbleLogic = aVar;
        final MediatorLiveData<PayLevelEnterRoomInfo> mediatorLiveData = new MediatorLiveData<>();
        LiveData<PayLevelEnterRoomInfo> d16 = aVar.d();
        final Function1<PayLevelEnterRoomInfo, Unit> function1 = new Function1<PayLevelEnterRoomInfo, Unit>(mediatorLiveData) { // from class: com.tencent.mobileqq.qqlive.sail.ui.paylevel.QQLivePayLevelViewModel$_enterRoomInfo$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<PayLevelEnterRoomInfo> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PayLevelEnterRoomInfo payLevelEnterRoomInfo) {
                invoke2(payLevelEnterRoomInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PayLevelEnterRoomInfo payLevelEnterRoomInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    c.b(this.$this_apply, payLevelEnterRoomInfo);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) payLevelEnterRoomInfo);
                }
            }
        };
        mediatorLiveData.addSource(d16, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.paylevel.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePayLevelViewModel.M1(Function1.this, obj);
            }
        });
        this._enterRoomInfo = mediatorLiveData;
        this.enterRoomInfo = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void N1(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, roomId);
        } else {
            this.enterRoomBubbleLogic.f(roomId);
        }
    }

    public final void O1(long roomId, boolean fromFloatWindow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(roomId), Boolean.valueOf(fromFloatWindow));
        } else {
            this.enterRoomBubbleLogic.g(roomId, fromFloatWindow);
        }
    }

    public final void P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.enterRoomBubbleLogic.h();
        }
    }

    @NotNull
    public final LiveData<PayLevelEnterRoomInfo> getEnterRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.enterRoomInfo;
    }
}
