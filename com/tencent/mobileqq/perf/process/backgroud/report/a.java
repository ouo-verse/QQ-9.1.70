package com.tencent.mobileqq.perf.process.backgroud.report;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bV\b\u0086\b\u0018\u0000 b2\u00020\u0001:\u0001\u0006B\u00ed\u0001\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u00108\u001a\u00020\u0002\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u0012\b\b\u0002\u0010?\u001a\u00020\u0002\u0012\b\b\u0002\u0010C\u001a\u00020\u0002\u0012\b\b\u0002\u0010G\u001a\u00020\u0002\u0012\b\b\u0002\u0010K\u001a\u00020\u0002\u0012\b\b\u0002\u0010O\u001a\u00020\u0002\u0012\b\b\u0002\u0010S\u001a\u00020\u0002\u0012\b\b\u0002\u0010W\u001a\u00020\u0002\u0012\b\b\u0002\u0010[\u001a\u00020\u0002\u0012\b\b\u0002\u0010_\u001a\u00020\u0002\u00a2\u0006\u0004\b`\u0010aJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011\"\u0004\b!\u0010\u0013R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011\"\u0004\b$\u0010\u0013R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011\"\u0004\b'\u0010\u0013R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u000f\u001a\u0004\b+\u0010\u0011\"\u0004\b*\u0010\u0013R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u000f\u001a\u0004\b.\u0010\u0011\"\u0004\b-\u0010\u0013R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u000f\u001a\u0004\b1\u0010\u0011\"\u0004\b0\u0010\u0013R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u000f\u001a\u0004\b4\u0010\u0011\"\u0004\b3\u0010\u0013R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b9\u0010\u0011\"\u0004\b:\u0010\u0013R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u000f\u001a\u0004\b=\u0010\u0011\"\u0004\b>\u0010\u0013R\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\u000f\u001a\u0004\bA\u0010\u0011\"\u0004\bB\u0010\u0013R\"\u0010G\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u000f\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010\u0013R\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\u000f\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010\u0013R\"\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u000f\u001a\u0004\bM\u0010\u0011\"\u0004\bN\u0010\u0013R\"\u0010S\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010\u000f\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010\u000f\u001a\u0004\bU\u0010\u0011\"\u0004\bV\u0010\u0013R\"\u0010[\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010\u000f\u001a\u0004\bY\u0010\u0011\"\u0004\bZ\u0010\u0013R\"\u0010_\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010\u000f\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010\u0013\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/report/a;", "", "", "key", "value", "Lfeedcloud/FeedCloudCommon$Entry;", "a", "Ljava/util/ArrayList;", DomainData.DOMAIN_NAME, "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getEventId", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "eventId", "b", "getTraceId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "traceId", "getAttachInfo", "attachInfo", "d", "getExt1", "ext1", "e", "getExt2", "ext2", "f", "getExt3", "ext3", "g", "getExt4", "ext4", h.F, "getExt5", "ext5", "i", "getExt6", "ext6", "j", "getExt7", "ext7", "k", "getExt8", "ext8", "l", "getExt9", "ext9", "getExt10", "setExt10", "ext10", "getExt11", "setExt11", "ext11", "o", "getExt12", "setExt12", "ext12", "p", "getExt13", "setExt13", "ext13", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getExt14", "setExt14", "ext14", "r", "getExt15", "setExt15", "ext15", ReportConstant.COSTREPORT_PREFIX, "getExt16", "setExt16", "ext16", "t", "getExt17", "setExt17", "ext17", "u", "getExt18", "setExt18", "ext18", "v", "getExt19", "setExt19", QQLiveReportConstants.AttaColumn.EXT19, "w", "getJsonExt", "setJsonExt", "jsonExt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", HippyTKDListViewAdapter.X, "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String eventId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String attachInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext3;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext4;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext5;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext6;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext7;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext8;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext9;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext10;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext11;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext12;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext13;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext14;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext15;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext16;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext17;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext18;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ext19;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jsonExt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/report/a$a;", "", "", "ATTA_ID", "I", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.process.backgroud.report.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31824);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 78)) {
            redirector.redirect((short) 78);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 77)) {
            return;
        }
        iPatchRedirector.redirect((short) 77, (Object) this);
    }

    private final FeedCloudCommon$Entry a(String key, String value) {
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set(key);
        if (value != null) {
            feedCloudCommon$Entry.value.set(value);
        }
        return feedCloudCommon$Entry;
    }

    public final void b(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.attachInfo = str;
        }
    }

    public final void c(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.eventId = str;
        }
    }

    public final void d(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext1 = str;
        }
    }

    public final void e(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext2 = str;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return ((Boolean) iPatchRedirector.redirect((short) 76, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.eventId, aVar.eventId) && Intrinsics.areEqual(this.traceId, aVar.traceId) && Intrinsics.areEqual(this.attachInfo, aVar.attachInfo) && Intrinsics.areEqual(this.ext1, aVar.ext1) && Intrinsics.areEqual(this.ext2, aVar.ext2) && Intrinsics.areEqual(this.ext3, aVar.ext3) && Intrinsics.areEqual(this.ext4, aVar.ext4) && Intrinsics.areEqual(this.ext5, aVar.ext5) && Intrinsics.areEqual(this.ext6, aVar.ext6) && Intrinsics.areEqual(this.ext7, aVar.ext7) && Intrinsics.areEqual(this.ext8, aVar.ext8) && Intrinsics.areEqual(this.ext9, aVar.ext9) && Intrinsics.areEqual(this.ext10, aVar.ext10) && Intrinsics.areEqual(this.ext11, aVar.ext11) && Intrinsics.areEqual(this.ext12, aVar.ext12) && Intrinsics.areEqual(this.ext13, aVar.ext13) && Intrinsics.areEqual(this.ext14, aVar.ext14) && Intrinsics.areEqual(this.ext15, aVar.ext15) && Intrinsics.areEqual(this.ext16, aVar.ext16) && Intrinsics.areEqual(this.ext17, aVar.ext17) && Intrinsics.areEqual(this.ext18, aVar.ext18) && Intrinsics.areEqual(this.ext19, aVar.ext19) && Intrinsics.areEqual(this.jsonExt, aVar.jsonExt)) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext3 = str;
        }
    }

    public final void g(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext4 = str;
        }
    }

    public final void h(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext5 = str;
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Integer) iPatchRedirector.redirect((short) 75, (Object) this)).intValue();
        }
        return (((((((((((((((((((((((((((((((((((((((((((this.eventId.hashCode() * 31) + this.traceId.hashCode()) * 31) + this.attachInfo.hashCode()) * 31) + this.ext1.hashCode()) * 31) + this.ext2.hashCode()) * 31) + this.ext3.hashCode()) * 31) + this.ext4.hashCode()) * 31) + this.ext5.hashCode()) * 31) + this.ext6.hashCode()) * 31) + this.ext7.hashCode()) * 31) + this.ext8.hashCode()) * 31) + this.ext9.hashCode()) * 31) + this.ext10.hashCode()) * 31) + this.ext11.hashCode()) * 31) + this.ext12.hashCode()) * 31) + this.ext13.hashCode()) * 31) + this.ext14.hashCode()) * 31) + this.ext15.hashCode()) * 31) + this.ext16.hashCode()) * 31) + this.ext17.hashCode()) * 31) + this.ext18.hashCode()) * 31) + this.ext19.hashCode()) * 31) + this.jsonExt.hashCode();
    }

    public final void i(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext6 = str;
        }
    }

    public final void j(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext7 = str;
        }
    }

    public final void k(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext8 = str;
        }
    }

    public final void l(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext9 = str;
        }
    }

    public final void m(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.traceId = str;
        }
    }

    @NotNull
    public final ArrayList<FeedCloudCommon$Entry> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (ArrayList) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        ArrayList<FeedCloudCommon$Entry> arrayList = new ArrayList<>();
        arrayList.add(a("event_id", this.eventId));
        arrayList.add(a("traceid", this.traceId));
        arrayList.add(a("attach_info", this.attachInfo));
        arrayList.add(a("ext1", this.ext1));
        arrayList.add(a("ext2", this.ext2));
        arrayList.add(a("ext3", this.ext3));
        arrayList.add(a("ext4", this.ext4));
        arrayList.add(a("ext5", this.ext5));
        arrayList.add(a("ext6", this.ext6));
        arrayList.add(a("ext7", this.ext7));
        arrayList.add(a("ext8", this.ext8));
        arrayList.add(a("ext9", this.ext9));
        arrayList.add(a("ext10", this.ext10));
        arrayList.add(a("ext11", this.ext11));
        arrayList.add(a("ext12", this.ext12));
        arrayList.add(a("ext13", this.ext13));
        arrayList.add(a("ext14", this.ext14));
        arrayList.add(a("ext15", this.ext15));
        arrayList.add(a("ext16", this.ext16));
        arrayList.add(a("ext17", this.ext17));
        arrayList.add(a("ext18", this.ext18));
        arrayList.add(a(QQLiveReportConstants.AttaColumn.EXT19, this.ext19));
        arrayList.add(a(QQLiveReportConstants.AttaColumn.JSON_EXT, this.jsonExt));
        return arrayList;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (String) iPatchRedirector.redirect((short) 74, (Object) this);
        }
        return "AudioStatReportData(eventId=" + this.eventId + ", traceId=" + this.traceId + ", attachInfo=" + this.attachInfo + ", ext1=" + this.ext1 + ", ext2=" + this.ext2 + ", ext3=" + this.ext3 + ", ext4=" + this.ext4 + ", ext5=" + this.ext5 + ", ext6=" + this.ext6 + ", ext7=" + this.ext7 + ", ext8=" + this.ext8 + ", ext9=" + this.ext9 + ", ext10=" + this.ext10 + ", ext11=" + this.ext11 + ", ext12=" + this.ext12 + ", ext13=" + this.ext13 + ", ext14=" + this.ext14 + ", ext15=" + this.ext15 + ", ext16=" + this.ext16 + ", ext17=" + this.ext17 + ", ext18=" + this.ext18 + ", ext19=" + this.ext19 + ", jsonExt=" + this.jsonExt + ')';
    }

    public a(@NotNull String eventId, @NotNull String traceId, @NotNull String attachInfo, @NotNull String ext1, @NotNull String ext2, @NotNull String ext3, @NotNull String ext4, @NotNull String ext5, @NotNull String ext6, @NotNull String ext7, @NotNull String ext8, @NotNull String ext9, @NotNull String ext10, @NotNull String ext11, @NotNull String ext12, @NotNull String ext13, @NotNull String ext14, @NotNull String ext15, @NotNull String ext16, @NotNull String ext17, @NotNull String ext18, @NotNull String ext19, @NotNull String jsonExt) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        Intrinsics.checkNotNullParameter(ext1, "ext1");
        Intrinsics.checkNotNullParameter(ext2, "ext2");
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        Intrinsics.checkNotNullParameter(ext4, "ext4");
        Intrinsics.checkNotNullParameter(ext5, "ext5");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(ext7, "ext7");
        Intrinsics.checkNotNullParameter(ext8, "ext8");
        Intrinsics.checkNotNullParameter(ext9, "ext9");
        Intrinsics.checkNotNullParameter(ext10, "ext10");
        Intrinsics.checkNotNullParameter(ext11, "ext11");
        Intrinsics.checkNotNullParameter(ext12, "ext12");
        Intrinsics.checkNotNullParameter(ext13, "ext13");
        Intrinsics.checkNotNullParameter(ext14, "ext14");
        Intrinsics.checkNotNullParameter(ext15, "ext15");
        Intrinsics.checkNotNullParameter(ext16, "ext16");
        Intrinsics.checkNotNullParameter(ext17, "ext17");
        Intrinsics.checkNotNullParameter(ext18, "ext18");
        Intrinsics.checkNotNullParameter(ext19, "ext19");
        Intrinsics.checkNotNullParameter(jsonExt, "jsonExt");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, eventId, traceId, attachInfo, ext1, ext2, ext3, ext4, ext5, ext6, ext7, ext8, ext9, ext10, ext11, ext12, ext13, ext14, ext15, ext16, ext17, ext18, ext19, jsonExt);
            return;
        }
        this.eventId = eventId;
        this.traceId = traceId;
        this.attachInfo = attachInfo;
        this.ext1 = ext1;
        this.ext2 = ext2;
        this.ext3 = ext3;
        this.ext4 = ext4;
        this.ext5 = ext5;
        this.ext6 = ext6;
        this.ext7 = ext7;
        this.ext8 = ext8;
        this.ext9 = ext9;
        this.ext10 = ext10;
        this.ext11 = ext11;
        this.ext12 = ext12;
        this.ext13 = ext13;
        this.ext14 = ext14;
        this.ext15 = ext15;
        this.ext16 = ext16;
        this.ext17 = ext17;
        this.ext18 = ext18;
        this.ext19 = ext19;
        this.jsonExt = jsonExt;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? "" : str9, (i3 & 512) != 0 ? "" : str10, (i3 & 1024) != 0 ? "" : str11, (i3 & 2048) != 0 ? "" : str12, (i3 & 4096) != 0 ? "" : str13, (i3 & 8192) != 0 ? "" : str14, (i3 & 16384) != 0 ? "" : str15, (32768 & i3) != 0 ? "" : str16, (65536 & i3) != 0 ? "" : str17, (131072 & i3) != 0 ? "" : str18, (262144 & i3) != 0 ? "" : str19, (524288 & i3) != 0 ? "" : str20, (1048576 & i3) != 0 ? "" : str21, (2097152 & i3) != 0 ? "" : str22, (4194304 & i3) != 0 ? "" : str23);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
