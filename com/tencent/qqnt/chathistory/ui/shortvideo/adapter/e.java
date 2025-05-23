package com.tencent.qqnt.chathistory.ui.shortvideo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chathistory.x2k.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/adapter/e;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "helper", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", DomainData.DOMAIN_NAME, "", "f", "()I", "itemViewType", "<init>", "()V", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e extends com.tencent.qqnt.expandRecyclerView.adapter.provider.c {
    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    @NotNull
    public View c(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new y(context, null, null, false, 14, null).getMContainer();
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    public int f() {
        return 800;
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a helper, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b item, @NotNull List<? extends Object> payloads) {
        com.tencent.qqnt.chathistory.ui.shortvideo.data.model.b bVar;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        boolean z16 = item instanceof com.tencent.qqnt.chathistory.ui.shortvideo.data.model.b;
        if (!z16) {
            return;
        }
        TextView textView = null;
        if (z16) {
            bVar = (com.tencent.qqnt.chathistory.ui.shortvideo.data.model.b) item;
        } else {
            bVar = null;
        }
        View view = helper.itemView;
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = null;
        }
        if (linearLayout != null && bVar != null) {
            View childAt = linearLayout.getChildAt(0);
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            }
            if (textView != null) {
                textView.setText(HardCodeUtil.qqStr(R.string.zkh));
                return;
            }
            return;
        }
        com.tencent.qqnt.chathistory.util.d.f354054a.a("QCHV-ChatHistoryShortVideoLoadMoreFinishProvider", "convert null baseTailNode:" + bVar + ", linearLayout:" + linearLayout);
    }
}
