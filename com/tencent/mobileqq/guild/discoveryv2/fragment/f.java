package com.tencent.mobileqq.guild.discoveryv2.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart;
import com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/f;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart$b;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/ContentPart$b;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface f extends RefreshPart.b, ContentPart.b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static boolean a(@NotNull f fVar) {
            return RefreshPart.b.a.a(fVar);
        }

        public static void b(@NotNull f fVar, @NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            ContentPart.b.a.a(fVar, recyclerView);
        }

        public static void c(@NotNull f fVar, @NotNull SmartRefreshLayout refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            RefreshPart.b.a.b(fVar, refreshLayout);
        }
    }
}
