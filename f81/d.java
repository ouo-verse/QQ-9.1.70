package f81;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.aio.qwallet.RedPacketPanelState;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.panel.RedPacketPanelDelegateQQ;
import f81.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lf81/d;", "Lcom/tencent/aio/base/mvvm/a;", "Lf81/c;", "Lcom/tencent/mobileqq/aio/qwallet/RedPacketPanelState;", "Landroid/content/Context;", "context", "Landroid/view/View;", "c1", "", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "b1", "bindViewAndData", "state", "d1", "Lrx3/c;", "d", "Lrx3/c;", "getDelegate", "()Lrx3/c;", "setDelegate", "(Lrx3/c;)V", "delegate", "<init>", "()V", "e", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends com.tencent.aio.base.mvvm.a<c, RedPacketPanelState> {

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList f398005f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/QWallet/Inject_RedPacket_Panel_Delegate.yml", version = 1)
    @Nullable
    private rx3.c delegate;

    static {
        ArrayList arrayList = new ArrayList();
        f398005f = arrayList;
        arrayList.add(RedPacketPanelDelegateQQ.class);
        INSTANCE = new Companion(null);
    }

    public d() {
        e1();
    }

    private final View c1(Context context) {
        TextView textView = new TextView(context);
        textView.setText("RedPacketPanelView, Inject FAIL!!!!");
        return textView;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<c, RedPacketPanelState> createVM() {
        QLog.d("RedPacketPanelVB", 4, "createVM: ");
        return new e();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        QLog.d("RedPacketPanelVB", 4, "bindViewAndData: ");
        sendIntent(c.a.f398003d);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RedPacketPanelState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        QLog.d("RedPacketPanelVB", 4, "handleUIState: " + state);
        if (state instanceof RedPacketPanelState.InitCompletedState) {
            rx3.c cVar = this.delegate;
            if (cVar != null) {
                RedPacketPanelState.InitCompletedState initCompletedState = (RedPacketPanelState.InitCompletedState) state;
                cVar.c(initCompletedState.getChatType(), initCompletedState.getChatId(), initCompletedState.getAioContext());
                return;
            }
            return;
        }
        if (state instanceof RedPacketPanelState.VisibilityChangeState) {
            if (((RedPacketPanelState.VisibilityChangeState) state).getIsVisible()) {
                rx3.c cVar2 = this.delegate;
                if (cVar2 != null) {
                    cVar2.a();
                    return;
                }
                return;
            }
            rx3.c cVar3 = this.delegate;
            if (cVar3 != null) {
                cVar3.b();
            }
        }
    }

    @QAutoInitMethod
    public final void e1() {
        this.delegate = (rx3.c) com.tencent.mobileqq.qroute.utils.b.a(f398005f);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        View createPanelView;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        if (QLog.isDevelopLevel()) {
            QLog.d("RedPacketPanelVB", 4, "onCreateView: ");
        }
        Context a16 = createViewParams.a();
        rx3.c cVar = this.delegate;
        if (cVar == null || (createPanelView = cVar.createPanelView(a16)) == null) {
            return c1(a16);
        }
        return createPanelView;
    }
}
