package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/views/bk;", "Lcom/tencent/kuikly/core/base/m;", "", "a", "Z", tl.h.F, "()Z", "j", "(Z)V", "refreshEnable", "", "b", UserInfo.SEX_FEMALE, "i", "()F", "setRefreshHeight$core_release", "(F)V", "refreshHeight", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bk extends com.tencent.kuikly.core.base.m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean refreshEnable = true;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float refreshHeight;

    /* renamed from: h, reason: from getter */
    public final boolean getRefreshEnable() {
        return this.refreshEnable;
    }

    /* renamed from: i, reason: from getter */
    public final float getRefreshHeight() {
        return this.refreshHeight;
    }

    public final void j(boolean z16) {
        this.refreshEnable = z16;
    }
}
