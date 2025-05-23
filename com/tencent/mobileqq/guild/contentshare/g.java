package com.tencent.mobileqq.guild.contentshare;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/g;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Lcom/tencent/mobileqq/guild/contentshare/h;", "style", "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static /* synthetic */ void a(g gVar, ViewGroup viewGroup, d dVar, h hVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    hVar = null;
                }
                gVar.a(viewGroup, dVar, hVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContent");
        }
    }

    void a(@NotNull ViewGroup parent, @NotNull d shareData, @Nullable h style);
}
