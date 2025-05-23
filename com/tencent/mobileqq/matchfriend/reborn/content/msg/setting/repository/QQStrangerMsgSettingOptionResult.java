package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository;

import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$GetOptionsRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSuccess", "b", "isFromCache", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$GetOptionsRsp;", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$GetOptionsRsp;", "()Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$GetOptionsRsp;", "data", "<init>", "(ZZLcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$GetOptionsRsp;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.b, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerMsgSettingOptionResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFromCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final UserConfig$GetOptionsRsp data;

    public QQStrangerMsgSettingOptionResult() {
        this(false, false, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final UserConfig$GetOptionsRsp getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsFromCache() {
        return this.isFromCache;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.isFromCache;
        int i16 = (i3 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        UserConfig$GetOptionsRsp userConfig$GetOptionsRsp = this.data;
        return i16 + (userConfig$GetOptionsRsp == null ? 0 : userConfig$GetOptionsRsp.hashCode());
    }

    public String toString() {
        return "QQStrangerMsgSettingOptionResult(isSuccess=" + this.isSuccess + ", isFromCache=" + this.isFromCache + ", data=" + this.data + ")";
    }

    public QQStrangerMsgSettingOptionResult(boolean z16, boolean z17, UserConfig$GetOptionsRsp userConfig$GetOptionsRsp) {
        this.isSuccess = z16;
        this.isFromCache = z17;
        this.data = userConfig$GetOptionsRsp;
    }

    public /* synthetic */ QQStrangerMsgSettingOptionResult(boolean z16, boolean z17, UserConfig$GetOptionsRsp userConfig$GetOptionsRsp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? null : userConfig$GetOptionsRsp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerMsgSettingOptionResult)) {
            return false;
        }
        QQStrangerMsgSettingOptionResult qQStrangerMsgSettingOptionResult = (QQStrangerMsgSettingOptionResult) other;
        return this.isSuccess == qQStrangerMsgSettingOptionResult.isSuccess && this.isFromCache == qQStrangerMsgSettingOptionResult.isFromCache && Intrinsics.areEqual(this.data, qQStrangerMsgSettingOptionResult.data);
    }
}
