package com.tencent.biz.pubaccount.weishi.profile.header;

import com.tencent.mobileqq.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00052\u00020\u0001:\u0001\u0003B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/e;", "", "", "a", "I", "e", "()I", "titleStrId", "b", "d", "tipsStrId", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "positionId", "reportJumpType", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Map<Integer, e> f81315f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int titleStrId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int tipsStrId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String positionId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String reportJumpType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/e$a;", "", "", "jumpElementType", "d", "c", "", "a", "b", "TYPE_EDIT_PROFILE", "I", "TYPE_FANS_LIST", "TYPE_FOLLOW_LIST", "TYPE_SEND_CONVERSATION", "", "Lcom/tencent/biz/pubaccount/weishi/profile/header/e;", "sTypeToData", "Ljava/util/Map;", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.profile.header.e$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int jumpElementType) {
            String positionId;
            e eVar = (e) e.f81315f.get(Integer.valueOf(jumpElementType));
            return (eVar == null || (positionId = eVar.getPositionId()) == null) ? "" : positionId;
        }

        public final String b(int jumpElementType) {
            String reportJumpType;
            e eVar = (e) e.f81315f.get(Integer.valueOf(jumpElementType));
            return (eVar == null || (reportJumpType = eVar.getReportJumpType()) == null) ? "" : reportJumpType;
        }

        public final int c(int jumpElementType) {
            e eVar = (e) e.f81315f.get(Integer.valueOf(jumpElementType));
            if (eVar != null) {
                return eVar.getTipsStrId();
            }
            return 0;
        }

        public final int d(int jumpElementType) {
            e eVar = (e) e.f81315f.get(Integer.valueOf(jumpElementType));
            if (eVar != null) {
                return eVar.getTitleStrId();
            }
            return 0;
        }

        Companion() {
        }
    }

    static {
        Map<Integer, e> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new e(R.string.x8t, R.string.x8x, "concern_number", "1")), TuplesKt.to(2, new e(R.string.x8s, R.string.x8w, "fans_number", "2")), TuplesKt.to(3, new e(R.string.x8_, R.string.x8v, "editing_materials", "3")), TuplesKt.to(4, new e(R.string.x8u, R.string.x8y, "private_letter", "4")));
        f81315f = mapOf;
    }

    public e(int i3, int i16, String positionId, String reportJumpType) {
        Intrinsics.checkNotNullParameter(positionId, "positionId");
        Intrinsics.checkNotNullParameter(reportJumpType, "reportJumpType");
        this.titleStrId = i3;
        this.tipsStrId = i16;
        this.positionId = positionId;
        this.reportJumpType = reportJumpType;
    }

    /* renamed from: b, reason: from getter */
    public final String getPositionId() {
        return this.positionId;
    }

    /* renamed from: c, reason: from getter */
    public final String getReportJumpType() {
        return this.reportJumpType;
    }

    /* renamed from: d, reason: from getter */
    public final int getTipsStrId() {
        return this.tipsStrId;
    }

    /* renamed from: e, reason: from getter */
    public final int getTitleStrId() {
        return this.titleStrId;
    }
}
