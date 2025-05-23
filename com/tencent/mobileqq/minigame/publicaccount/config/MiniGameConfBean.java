package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGameConfBean;", "Lcom/tencent/freesia/IConfigData;", "isShowSubscribe", "", "screenRecordEnabled", "(ZZ)V", "()Z", "setShowSubscribe", "(Z)V", "getScreenRecordEnabled", "setScreenRecordEnabled", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class MiniGameConfBean implements IConfigData {
    private boolean isShowSubscribe;
    private boolean screenRecordEnabled;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MiniGameConfBean() {
        this(r2, r2, 3, null);
        boolean z16 = false;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsShowSubscribe() {
        return this.isShowSubscribe;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getScreenRecordEnabled() {
        return this.screenRecordEnabled;
    }

    public final MiniGameConfBean copy(boolean isShowSubscribe, boolean screenRecordEnabled) {
        return new MiniGameConfBean(isShowSubscribe, screenRecordEnabled);
    }

    public final boolean getScreenRecordEnabled() {
        return this.screenRecordEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isShowSubscribe;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.screenRecordEnabled;
        return i3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isShowSubscribe() {
        return this.isShowSubscribe;
    }

    public final void setScreenRecordEnabled(boolean z16) {
        this.screenRecordEnabled = z16;
    }

    public final void setShowSubscribe(boolean z16) {
        this.isShowSubscribe = z16;
    }

    public String toString() {
        return "MiniGameConfBean(isShowSubscribe=" + this.isShowSubscribe + ", screenRecordEnabled=" + this.screenRecordEnabled + ")";
    }

    public MiniGameConfBean(boolean z16, boolean z17) {
        this.isShowSubscribe = z16;
        this.screenRecordEnabled = z17;
    }

    public /* synthetic */ MiniGameConfBean(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17);
    }

    public static /* synthetic */ MiniGameConfBean copy$default(MiniGameConfBean miniGameConfBean, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = miniGameConfBean.isShowSubscribe;
        }
        if ((i3 & 2) != 0) {
            z17 = miniGameConfBean.screenRecordEnabled;
        }
        return miniGameConfBean.copy(z16, z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniGameConfBean)) {
            return false;
        }
        MiniGameConfBean miniGameConfBean = (MiniGameConfBean) other;
        return this.isShowSubscribe == miniGameConfBean.isShowSubscribe && this.screenRecordEnabled == miniGameConfBean.screenRecordEnabled;
    }
}
