package com.tencent.now.od.ui.gift;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/now/od/ui/gift/a;", "", "", "roomId", "uid", "", "t0", "Lcom/tencent/now/od/ui/gift/b;", "callback", "setUserSelectedCallback", "Landroid/view/View;", "getView", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface a {
    @NotNull
    View getView();

    void setUserSelectedCallback(@NotNull b callback);

    void t0(long roomId, long uid);
}
