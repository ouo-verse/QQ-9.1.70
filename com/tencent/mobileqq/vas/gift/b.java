package com.tencent.mobileqq.vas.gift;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/gift/b;", "", "Landroid/view/View;", "getView", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Lcom/tencent/mobileqq/vas/gift/a;", "listener", "", "a", "pauseAnim", "resumeAnim", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface b {
    void a(@NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull a listener);

    @NotNull
    View getView();

    void pauseAnim();

    void resumeAnim();
}
