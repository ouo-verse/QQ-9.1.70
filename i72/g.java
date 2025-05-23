package i72;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Li72/g;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "", "c", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", "holder", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "model", "", "f", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(g this$0, int i3, Map param, View it) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(param, "$param");
        com.tencent.aio.api.runtime.a a16 = this$0.a();
        if (a16 != null && (e16 = a16.e()) != null) {
            e16.h(new AIOMsgSendEvent.EmojiFaceSendEvent(i3, true));
        }
        IAssistedChatApi iAssistedChatApi = (IAssistedChatApi) QRoute.api(IAssistedChatApi.class);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        iAssistedChatApi.reportClickEvent("em_kl_toolbar_assist_chat_entry", it, param);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int b() {
        return 3;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int c() {
        return 3;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void f(RecyclerView.ViewHolder holder, com.tencent.qqnt.aio.bottombar.sectionbar.model.a model) {
        final Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(model, "model");
        if (holder instanceof k) {
            Object a16 = model.a();
            Map map = a16 instanceof Map ? (Map) a16 : null;
            if (map == null) {
                return;
            }
            k kVar = (k) holder;
            kVar.getBinding().f30347d.setText("Hi");
            Object obj = map.get("emoji_id");
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            if (num != null) {
                final int intValue = num.intValue();
                kVar.getBinding().f30345b.setImageDrawable(QQSysFaceUtil.getFaceDrawable(intValue));
                kVar.o();
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("content_type", "4"));
                IAssistedChatApi iAssistedChatApi = (IAssistedChatApi) QRoute.api(IAssistedChatApi.class);
                View view = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                iAssistedChatApi.reportImpEvent("em_kl_toolbar_assist_chat_entry", view, mapOf);
                holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: i72.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        g.o(g.this, intValue, mapOf, view2);
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public RecyclerView.ViewHolder g(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c51.c g16 = c51.c.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new k(g16);
    }
}
