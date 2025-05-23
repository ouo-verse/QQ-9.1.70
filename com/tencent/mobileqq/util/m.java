package com.tencent.mobileqq.util;

import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\b2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/util/m;", "", "Lcom/tencent/mobileqq/util/m$a;", "partnerReportData", "", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "<init>", "()V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f306784a = new m();

    m() {
    }

    public final HashMap<String, Object> a(PartnerReportData partnerReportData) {
        String str;
        List<com.tencent.mobileqq.partner.signin.a> g16;
        Intrinsics.checkNotNullParameter(partnerReportData, "partnerReportData");
        HashMap<String, Object> hashMap = new HashMap<>();
        com.tencent.mobileqq.partner.signin.b signInData = partnerReportData.getSignInData();
        if (signInData == null || (str = Long.valueOf(signInData.f()).toString()) == null) {
            str = "0";
        }
        hashMap.put("lap_subtype", str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        hashMap.put("clockin_state", "2");
        com.tencent.mobileqq.partner.signin.b signInData2 = partnerReportData.getSignInData();
        if (signInData2 != null && (g16 = signInData2.g()) != null) {
            for (com.tencent.mobileqq.partner.signin.a aVar : g16) {
                if (Intrinsics.areEqual(currentAccountUin, aVar.a()) && aVar.c()) {
                    hashMap.put("clockin_state", "1");
                }
            }
        }
        hashMap.put("touin", partnerReportData.getToUin());
        String sourceId = partnerReportData.getSourceId();
        if (sourceId != null) {
            hashMap.put("come_from", sourceId);
        }
        return hashMap;
    }

    public final void b(PartnerReportData partnerReportData) {
        Intrinsics.checkNotNullParameter(partnerReportData, "partnerReportData");
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent(partnerReportData.getEventId(), partnerReportData.getPgId(), partnerReportData.getElemId(), ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), a(partnerReportData));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/util/m$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "pgId", "b", "elemId", "eventId", "Lcom/tencent/mobileqq/partner/signin/b;", "d", "Lcom/tencent/mobileqq/partner/signin/b;", "()Lcom/tencent/mobileqq/partner/signin/b;", "signInData", "e", "f", "toUin", "sourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/partner/signin/b;Ljava/lang/String;Ljava/lang/String;)V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.util.m$a, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class PartnerReportData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String pgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String elemId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String eventId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final com.tencent.mobileqq.partner.signin.b signInData;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final String toUin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final String sourceId;

        public PartnerReportData(String pgId, String elemId, String eventId, com.tencent.mobileqq.partner.signin.b bVar, String toUin, String str) {
            Intrinsics.checkNotNullParameter(pgId, "pgId");
            Intrinsics.checkNotNullParameter(elemId, "elemId");
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(toUin, "toUin");
            this.pgId = pgId;
            this.elemId = elemId;
            this.eventId = eventId;
            this.signInData = bVar;
            this.toUin = toUin;
            this.sourceId = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getElemId() {
            return this.elemId;
        }

        /* renamed from: b, reason: from getter */
        public final String getEventId() {
            return this.eventId;
        }

        /* renamed from: c, reason: from getter */
        public final String getPgId() {
            return this.pgId;
        }

        /* renamed from: d, reason: from getter */
        public final com.tencent.mobileqq.partner.signin.b getSignInData() {
            return this.signInData;
        }

        /* renamed from: e, reason: from getter */
        public final String getSourceId() {
            return this.sourceId;
        }

        /* renamed from: f, reason: from getter */
        public final String getToUin() {
            return this.toUin;
        }

        public int hashCode() {
            int hashCode = ((((this.pgId.hashCode() * 31) + this.elemId.hashCode()) * 31) + this.eventId.hashCode()) * 31;
            com.tencent.mobileqq.partner.signin.b bVar = this.signInData;
            int hashCode2 = (((hashCode + (bVar == null ? 0 : bVar.hashCode())) * 31) + this.toUin.hashCode()) * 31;
            String str = this.sourceId;
            return hashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "PartnerReportData(pgId=" + this.pgId + ", elemId=" + this.elemId + ", eventId=" + this.eventId + ", signInData=" + this.signInData + ", toUin=" + this.toUin + ", sourceId=" + this.sourceId + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PartnerReportData)) {
                return false;
            }
            PartnerReportData partnerReportData = (PartnerReportData) other;
            return Intrinsics.areEqual(this.pgId, partnerReportData.pgId) && Intrinsics.areEqual(this.elemId, partnerReportData.elemId) && Intrinsics.areEqual(this.eventId, partnerReportData.eventId) && Intrinsics.areEqual(this.signInData, partnerReportData.signInData) && Intrinsics.areEqual(this.toUin, partnerReportData.toUin) && Intrinsics.areEqual(this.sourceId, partnerReportData.sourceId);
        }
    }
}
