package com.tencent.qqnt.chats.api;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001f\u001d$JG\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H&J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0010H&J\u001e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H&J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0010H&J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H&J\b\u0010\u001d\u001a\u00020\tH&J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0005H&J\b\u0010!\u001a\u00020\tH&J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H&J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H&J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H&J\b\u0010&\u001a\u00020%H&J\b\u0010'\u001a\u00020\tH&J\b\u0010(\u001a\u00020\tH&J\u0018\u0010+\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)H&J \u0010.\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H&J(\u00101\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H&J(\u00102\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H&\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/chats/api/b;", "", "page", "", "refPageId", "", "pageStp", "", "extra", "", "r", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "u", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "clickId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "j", "", "Lcom/tencent/qqnt/chats/api/b$c;", "marks", DomainData.DOMAIN_NAME, "b", "type", "clickPos", "l", "c", "count", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "p", h.F, "d", "Lcom/tencent/qqnt/chats/api/b$d;", "v", "onClear", "g", "Lcom/tencent/qqnt/chats/biz/bean/c;", "revealItem", "o", "uin", PreDownloadConstants.RPORT_KEY_BUSINESS_ID, "k", "objectType", QCircleLpReportDc010001.KEY_SUBTYPE, "t", "f", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/api/b$a;", "", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.api.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f354227a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38380);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f354227a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.chats.api.b$b, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9561b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b bVar, Object obj, String str, Integer num, Map map, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 2) != 0) {
                    str = null;
                }
                if ((i3 & 4) != 0) {
                    num = null;
                }
                if ((i3 & 8) != 0) {
                    map = null;
                }
                bVar.r(obj, str, num, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPgIn");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/api/b$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "c", "()J", "type", "b", "level", "subLevel", "<init>", "(JJJ)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long level;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long subLevel;

        public c(long j3, long j16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                return;
            }
            this.type = j3;
            this.level = j16;
            this.subLevel = j17;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.level;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.subLevel;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (this.type == cVar.type && this.level == cVar.level && this.subLevel == cVar.subLevel) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((androidx.fragment.app.a.a(this.type) * 31) + androidx.fragment.app.a.a(this.level)) * 31) + androidx.fragment.app.a.a(this.subLevel);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "ItemMark(type=" + this.type + ", level=" + this.level + ", subLevel=" + this.subLevel + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/api/b$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "pageId", "b", "I", "()I", "pageStp", "<init>", "(Ljava/lang/String;I)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String pageId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int pageStp;

        public d(@NotNull String pageId, int i3) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) pageId, i3);
            } else {
                this.pageId = pageId;
                this.pageStp = i3;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.pageId;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.pageStp;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d dVar = (d) other;
            if (Intrinsics.areEqual(this.pageId, dVar.pageId) && this.pageStp == dVar.pageStp) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return (this.pageId.hashCode() * 31) + this.pageStp;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "PageInfo(pageId=" + this.pageId + ", pageStp=" + this.pageStp + ")";
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(38403), (Class<?>) b.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f354227a;
        }
    }

    void a(int count);

    void b(@NotNull g item);

    void c();

    void d(int type);

    void e();

    void f(@NotNull g item, int objectType, int type, int subType);

    void g();

    void h(int type);

    void i(@NotNull g item);

    void j(@NotNull g item);

    void k(@NotNull g item, @NotNull String uin, @NotNull String businessID);

    void l(@NotNull String type, int clickPos);

    void m(int count);

    void n(@NotNull g item, @NotNull List<c> marks);

    void o(@NotNull g item, @NotNull com.tencent.qqnt.chats.biz.bean.c revealItem);

    void onClear();

    void p(int type);

    void q(@NotNull g item, int clickId);

    void r(@NotNull Object page, @Nullable String refPageId, @Nullable Integer pageStp, @Nullable Map<String, ? extends Object> extra);

    void s(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item);

    void t(@NotNull g item, int objectType, int type, int subType);

    void u(@NotNull Object page);

    @NotNull
    d v();
}
