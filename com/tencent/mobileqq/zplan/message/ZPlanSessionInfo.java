package com.tencent.mobileqq.zplan.message;

import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\tB3\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0016\u0010\fR$\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/message/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "selfUin", "friendUin", "e", "troopUin", "getEntrance", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<set-?>", "f", "Z", "()Z", "isTroop", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "g", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.message.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanSessionInfo {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sessionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String selfUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String friendUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int entrance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isTroop;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/message/c$a;", "", "Lcom/tencent/mobileqq/activity/aio/p;", SessionDbHelper.SESSION_ID, "Lcom/tencent/mobileqq/zplan/message/c;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.message.c$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanSessionInfo a(p session) {
            Intrinsics.checkNotNullParameter(session, "session");
            QQAppInterface j3 = bb.f335811a.j();
            String currentUin = j3 != null ? j3.getCurrentUin() : null;
            if (currentUin == null) {
                currentUin = "";
            }
            ZPlanSessionInfo zPlanSessionInfo = new ZPlanSessionInfo(session.f179555d, currentUin, session.f179557e, session.f179559f, session.P);
            int i3 = session.f179555d;
            boolean z16 = true;
            if (i3 != 3000 && i3 != 1) {
                z16 = false;
            }
            zPlanSessionInfo.isTroop = z16;
            return zPlanSessionInfo;
        }

        Companion() {
        }
    }

    public ZPlanSessionInfo(int i3, String selfUin, String str, String str2, int i16) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        this.sessionType = i3;
        this.selfUin = selfUin;
        this.friendUin = str;
        this.troopUin = str2;
        this.entrance = i16;
    }

    /* renamed from: b, reason: from getter */
    public final String getFriendUin() {
        return this.friendUin;
    }

    /* renamed from: c, reason: from getter */
    public final String getSelfUin() {
        return this.selfUin;
    }

    /* renamed from: d, reason: from getter */
    public final int getSessionType() {
        return this.sessionType;
    }

    /* renamed from: e, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsTroop() {
        return this.isTroop;
    }

    public int hashCode() {
        int hashCode = ((this.sessionType * 31) + this.selfUin.hashCode()) * 31;
        String str = this.friendUin;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.troopUin;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.entrance;
    }

    public String toString() {
        return "ZPlanSessionInfo(sessionType=" + this.sessionType + ", selfUin=" + this.selfUin + ", friendUin=" + this.friendUin + ", troopUin=" + this.troopUin + ", entrance=" + this.entrance + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanSessionInfo)) {
            return false;
        }
        ZPlanSessionInfo zPlanSessionInfo = (ZPlanSessionInfo) other;
        return this.sessionType == zPlanSessionInfo.sessionType && Intrinsics.areEqual(this.selfUin, zPlanSessionInfo.selfUin) && Intrinsics.areEqual(this.friendUin, zPlanSessionInfo.friendUin) && Intrinsics.areEqual(this.troopUin, zPlanSessionInfo.troopUin) && this.entrance == zPlanSessionInfo.entrance;
    }
}
