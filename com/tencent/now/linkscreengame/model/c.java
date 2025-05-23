package com.tencent.now.linkscreengame.model;

import com.tencent.mobileqq.qqlive.api.timi.ITimiAnchor;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/now/linkscreengame/model/c;", "", "", "otherAnchorLiveType", "", "a", "<init>", "()V", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f338502a = new c();

    c() {
    }

    public final boolean a(int otherAnchorLiveType) {
        if (otherAnchorLiveType == 3 || ((ITimiAnchor) QRoute.api(ITimiAnchor.class)).getAnchorRecordType() == 2) {
            return true;
        }
        return false;
    }
}
