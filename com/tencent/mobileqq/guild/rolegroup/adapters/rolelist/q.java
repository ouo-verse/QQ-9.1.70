package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/q;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ad;", "a", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/p;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/p;", "handler", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/p;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p handler;

    public q(@NotNull p handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
    }

    @NotNull
    public final ad a(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new ac(parent);
            case 1:
                return new v(parent, this.handler.b(), this.handler.a());
            case 2:
                return new o(parent, this.handler.b());
            case 3:
                return new c(parent, this.handler.b());
            case 4:
                return new f(parent);
            case 5:
                return new l(parent, this.handler.b());
            case 6:
                return new LevelRoleTipViewHolder(parent, this.handler.b());
            case 7:
                return new aa(parent, this.handler.b());
            default:
                throw new IllegalArgumentException("Unknown viewType=" + viewType + "!");
        }
    }

    public final int b(@NotNull r item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.getType();
    }
}
