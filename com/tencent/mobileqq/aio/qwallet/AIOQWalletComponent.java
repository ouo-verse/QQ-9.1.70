package com.tencent.mobileqq.aio.qwallet;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.menu.ui.d;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import f81.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0007J$\u0010\f\u001a\u00020\u00052\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J&\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\tH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000eH\u0016R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/aio/qwallet/AIOQWalletComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lf81/b;", "Landroid/view/View;", Constants.APK_CERTIFICATE, "", "H1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "Lcom/tencent/aio/api/runtime/a;", "mUIModel", "afterCreateVM", "c1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "state", "g1", "e1", "importance", "l1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lrx3/a;", BdhLogUtil.LogTag.Tag_Conn, "Lrx3/a;", "getDelegate", "()Lrx3/a;", "setDelegate", "(Lrx3/a;)V", "delegate", "<init>", "(Landroid/content/Context;)V", "D", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOQWalletComponent extends BaseContentComponent<b> {
    private static ArrayList E;

    /* renamed from: C, reason: from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/QWallet/Inject_AIO_Component_Delegate.yml", version = 1)
    @Nullable
    private a delegate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    static {
        ArrayList arrayList = new ArrayList();
        E = arrayList;
        arrayList.add(com.tencent.qqnt.qwallet.aio.a.class);
        INSTANCE = new Companion(null);
    }

    public AIOQWalletComponent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        H1();
    }

    private final View G1() {
        TextView textView = new TextView(this.context);
        textView.setText("AIOComponentView, Inject FAIL !!!");
        return textView;
    }

    @QAutoInitMethod
    public final void H1() {
        this.delegate = (a) com.tencent.mobileqq.qroute.utils.b.a(E);
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        com.tencent.aio.api.runtime.a mContext;
        a aVar;
        if (mUIModel != null && (mContext = mUIModel.getMContext()) != null && (aVar = this.delegate) != null) {
            aVar.d(mContext);
        }
        super.afterCreateVM(mUIModel);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        a aVar = this.delegate;
        if (aVar != null) {
            aVar.a(q1().getMsgRecord());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        View c16;
        a aVar = this.delegate;
        if (aVar == null || (c16 = aVar.c(this.context)) == null) {
            return G1();
        }
        return c16;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        a aVar = this.delegate;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        QLog.d("AIOQWalletComponent", 1, "handleUIState: state " + state);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        View e16 = e1();
        if (e16 != null) {
            e16.setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<d> s1() {
        List<d> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ad(getMContext(), q1(), this), new ap(getMContext(), q1(), this), new h(getMContext(), q1(), this));
        if (q1().e2()) {
            mutableListOf.add(new u(getMContext(), q1(), this));
        }
        mutableListOf.add(new aj(getMContext(), q1(), this));
        return mutableListOf;
    }
}
