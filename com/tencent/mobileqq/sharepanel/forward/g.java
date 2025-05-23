package com.tencent.mobileqq.sharepanel.forward;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/g;", "", "", "show", "dismiss", "Lcom/tencent/mobileqq/sharepanel/forward/a;", "eventListener", "b", "Lcom/tencent/mobileqq/sharepanel/forward/e;", "reportDelegate", "a", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface g {
    @NotNull
    g a(@NotNull e reportDelegate);

    @NotNull
    g b(@NotNull a eventListener);

    void dismiss();

    void show();
}
