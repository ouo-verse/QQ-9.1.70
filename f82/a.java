package f82;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J \u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0014\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0012R$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001cj\b\u0012\u0004\u0012\u00020\u0012`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001e\u00a8\u0006\""}, d2 = {"Lf82/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/view/QQStrangerSignalPickerView$g;", "Lf82/a$a;", "", "a", "firstRow", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "secondRow", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "row", "o", "vh", "", "p", DomainData.DOMAIN_NAME, "", "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", Constants.Configs.CONFIGS, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "position", "k", "", "partnerId", "l", "signalConfig", "j", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "signalConfigs", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends QQStrangerSignalPickerView.g<C10290a> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<SignalPB$SignalConfig> signalConfigs = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lf82/a$a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/view/QQStrangerSignalPickerView$h;", "", "text", "", "a", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f82.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10290a extends QQStrangerSignalPickerView.h {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10290a(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.opb);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026sh_picker_view_item_name)");
            this.textView = (TextView) findViewById;
        }

        public final void a(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.textView.setText(text);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView.g
    public int a() {
        return this.signalConfigs.size();
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView.g
    public int b(int firstRow) {
        if (this.signalConfigs.size() <= firstRow || firstRow < 0) {
            return 0;
        }
        return this.signalConfigs.get(firstRow).partner_adjs.size();
    }

    public final int j(SignalPB$SignalConfig signalConfig) {
        Intrinsics.checkNotNullParameter(signalConfig, "signalConfig");
        return this.signalConfigs.indexOf(signalConfig);
    }

    public final SignalPB$SignalConfig l(long partnerId) {
        Object obj;
        Iterator<T> it = this.signalConfigs.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SignalPB$SignalConfig) obj).partner_id.get() == partnerId) {
                break;
            }
        }
        return (SignalPB$SignalConfig) obj;
    }

    public final void m(List<SignalPB$SignalConfig> configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        this.signalConfigs.clear();
        this.signalConfigs.addAll(configs);
        c();
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView.g
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void d(C10290a vh5, int row) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (row < 0 || row >= this.signalConfigs.size()) {
            return;
        }
        String str = this.signalConfigs.get(row).partner_name.get();
        Intrinsics.checkNotNullExpressionValue(str, "signalConfigs[row].partner_name.get()");
        vh5.a(str);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C10290a e(ViewGroup parent, int row) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cxx, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026em_layout, parent, false)");
        return new C10290a(inflate);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView.g
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void f(C10290a vh5, int firstRow, int secondRow) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (firstRow < 0 || firstRow >= this.signalConfigs.size()) {
            return;
        }
        SignalPB$SignalConfig signalPB$SignalConfig = this.signalConfigs.get(firstRow);
        Intrinsics.checkNotNullExpressionValue(signalPB$SignalConfig, "signalConfigs[firstRow]");
        SignalPB$SignalConfig signalPB$SignalConfig2 = signalPB$SignalConfig;
        if (secondRow < 0 || secondRow >= signalPB$SignalConfig2.partner_adjs.size()) {
            return;
        }
        String str = signalPB$SignalConfig2.partner_adjs.get(secondRow).partner_adj_name.get();
        Intrinsics.checkNotNullExpressionValue(str, "config.partner_adjs[seco\u2026w].partner_adj_name.get()");
        vh5.a(str);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView.g
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C10290a g(ViewGroup parent, int firstRow, int secondRow) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cxx, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026em_layout, parent, false)");
        return new C10290a(inflate);
    }

    public final SignalPB$SignalConfig k(int position) {
        if (position < 0 || position >= this.signalConfigs.size()) {
            return null;
        }
        return this.signalConfigs.get(position);
    }
}
