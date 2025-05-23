package n24;

import android.content.Context;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.input.adorn.a;
import com.tencent.mobileqq.aio.input.adorn.c;
import com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVBDelegate;
import com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVMDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.IInputBarAdornSuiteApi;
import com.tencent.robot.aio.input.inputbar.interceptor.RobotAIOSendMsgInterceptor;
import com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordVMDelegate;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r24.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J<\u0010\u000e\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0006\b\u0000\u0012\u00020\u00020\nj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\r0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J2\u0010\u0013\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\u0010j\u0002`\u00120\t2\u0006\u0010\b\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0018"}, d2 = {"Ln24/a;", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Landroid/content/Context;", "context", "Ln24/b;", "f", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "e", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "c", "", "d", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements com.tencent.mobileqq.aio.input.adorn.a<com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {
    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> a() {
        return a.C7250a.a(this);
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<e<at.a, InputUIState, com.tencent.aio.api.runtime.a, c>> c(@NotNull c host) {
        List listOf;
        List<e<at.a, InputUIState, com.tencent.aio.api.runtime.a, c>> plus;
        Intrinsics.checkNotNullParameter(host, "host");
        RobotAIOSendMsgVMDelegate robotAIOSendMsgVMDelegate = new RobotAIOSendMsgVMDelegate(host);
        robotAIOSendMsgVMDelegate.a(new RobotAIOSendMsgInterceptor());
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new e[]{new t24.c(host), new d(host), new q24.d(host), new p24.e(host), new RobotInputPttRecordVMDelegate(host), new s24.d(host), new o24.e(host), robotAIOSendMsgVMDelegate, new h81.b(host)});
        plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) ((IInputBarAdornSuiteApi) QRoute.api(IInputBarAdornSuiteApi.class)).getVMDelegateList(host, k24.a.INSTANCE.a()));
        return plus;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    public boolean d() {
        return false;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> e(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
        List listOf;
        List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> plus;
        Intrinsics.checkNotNullParameter(host, "host");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.c[]{new t24.b(host), new r24.c(host), new q24.c(host), new p24.c(host), new com.tencent.robot.aio.input.inputbar.pttrecord.b(host), new s24.c(host), new o24.d(host), new RobotAIOSendMsgVBDelegate(host), new h81.a(host)});
        List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ?>> vBDelegateList = ((IInputBarAdornSuiteApi) QRoute.api(IInputBarAdornSuiteApi.class)).getVBDelegateList(host, k24.a.INSTANCE.a());
        Intrinsics.checkNotNull(vBDelegateList, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.input.base.mvicompat.IVBDelegate<com.tencent.aio.base.mvi.part.InputMviIntent, com.tencent.aio.base.mvi.part.InputUIState, com.tencent.mobileqq.aio.input.adorn.IInputBarVBDelegateHost, in com.tencent.mobileqq.aio.input.inputbar.viewbinding.AIODefaultInputBarViewBinding>{ com.tencent.mobileqq.aio.input.adorn.IInputBarAdornApiKt.IInputBarVBDelegate<in com.tencent.mobileqq.aio.input.inputbar.viewbinding.AIODefaultInputBarViewBinding> }>");
        plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) vBDelegateList);
        return plus;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new b(context);
    }
}
