package com.tencent.mobileqq.winkpublish.config;

import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00182\u00020\u0001:\u0001\u0003B1\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/config/l;", "", "", "a", "I", "b", "()I", "businessType", "", "Ljava/lang/String;", "getBusinessName", "()Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "c", "eventIdPrefix", "d", "attaId", "Lcom/tencent/mobileqq/winkpublish/report/a;", "e", "Lcom/tencent/mobileqq/winkpublish/report/a;", "()Lcom/tencent/mobileqq/winkpublish/report/a;", "reporter", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/winkpublish/report/a;)V", "f", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class l {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int businessType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String businessName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String eventIdPrefix;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int attaId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.winkpublish.report.a reporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/config/l$a;", "", "", "businessType", "Lcom/tencent/mobileqq/winkpublish/config/l;", "a", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.winkpublish.config.l$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final l a(int businessType) {
            switch (businessType) {
                case 1:
                    return g.f327175g;
                case 2:
                    return c.f327172g;
                case 3:
                    return f.f327174g;
                case 4:
                    return k.f327179g;
                case 5:
                case 7:
                case 8:
                case 12:
                default:
                    throw new RuntimeException("no support business: " + businessType);
                case 6:
                    return a.f327170g;
                case 9:
                    return j.f327178g;
                case 10:
                    return i.f327177g;
                case 11:
                    return h.f327176g;
                case 13:
                    return b.f327171g;
                case 14:
                    return e.f327173g;
            }
        }
    }

    public l(int i3, String businessName, String eventIdPrefix, int i16, com.tencent.mobileqq.winkpublish.report.a reporter) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(eventIdPrefix, "eventIdPrefix");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.businessType = i3;
        this.businessName = businessName;
        this.eventIdPrefix = eventIdPrefix;
        this.attaId = i16;
        this.reporter = reporter;
    }

    /* renamed from: a, reason: from getter */
    public final int getAttaId() {
        return this.attaId;
    }

    /* renamed from: b, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    /* renamed from: c, reason: from getter */
    public final String getEventIdPrefix() {
        return this.eventIdPrefix;
    }

    /* renamed from: d, reason: from getter */
    public final com.tencent.mobileqq.winkpublish.report.a getReporter() {
        return this.reporter;
    }

    public /* synthetic */ l(int i3, String str, String str2, int i16, com.tencent.mobileqq.winkpublish.report.a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, i16, (i17 & 16) != 0 ? new com.tencent.mobileqq.winkpublish.report.d() : aVar);
    }
}
