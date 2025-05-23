package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/q;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/p;", "a", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g eventHandler;

    public q(@NotNull g eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    @NotNull
    public final p a(@NotNull ViewGroup parent, int viewType) {
        p yVar;
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ehk, parent, false);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                return new ac(view, this.eventHandler);
            case 1:
            case 2:
            case 3:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.ehj, parent, false);
                Intrinsics.checkNotNullExpressionValue(view2, "view");
                return new ah(view2, this.eventHandler);
            case 4:
                vp1.t g16 = vp1.t.g(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026lse\n                    )");
                yVar = new y(g16, this.eventHandler);
                break;
            case 5:
                vp1.s g17 = vp1.s.g(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(g17, "inflate(\n               \u2026lse\n                    )");
                yVar = new w(g17, this.eventHandler);
                break;
            case 6:
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(context, null, 2, null);
                qUISingleLineListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return new af(qUISingleLineListItem, this.eventHandler);
            default:
                throw new IllegalArgumentException();
        }
        return yVar;
    }
}
