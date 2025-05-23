package com.tencent.mobileqq.sharepanel.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J2\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004J\u0006\u0010\n\u001a\u00020\bJ$\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004J$\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004J$\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004J\"\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013R,\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00120\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/report/b;", "", "", "elemId", "", "params", "a", "pageId", "", "d", h.F, "c", "g", "e", "elemParams", "b", "Ljava/lang/String;", "curPageId", "", "Ljava/util/Map;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "elemId2Params", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curPageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> pageParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Map<String, Object>> elemId2Params;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/report/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.report.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.curPageId = "";
        this.pageParams = new LinkedHashMap();
        this.elemId2Params = new LinkedHashMap();
    }

    private final Map<String, Object> a(String elemId, Map<String, ? extends Object> params) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qq_pgid", this.curPageId);
        linkedHashMap.put("cur_pg", this.pageParams);
        Map<String, Object> map = this.elemId2Params.get(elemId);
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        linkedHashMap.putAll(params);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(b bVar, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        bVar.e(str, map);
    }

    @NotNull
    public final String b(@NotNull String elemId, @NotNull Map<String, ? extends Object> elemParams) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) elemId, (Object) elemParams);
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(elemParams, "elemParams");
        int hashCode = elemId.hashCode();
        String str2 = "";
        String str3 = null;
        if (hashCode != 166311382) {
            if (hashCode != 254021517) {
                if (hashCode == 916211562 && elemId.equals("em_share_item")) {
                    Object obj = elemParams.get("share_channel_id");
                    if (obj instanceof String) {
                        str3 = (String) obj;
                    }
                    if (str3 != null) {
                        str2 = str3;
                    }
                    return elemId + "_" + str2;
                }
                return elemId;
            }
            if (elemId.equals("em_share_controls")) {
                Object obj2 = elemParams.get("operation_id");
                if (obj2 instanceof String) {
                    str3 = (String) obj2;
                }
                if (str3 != null) {
                    str2 = str3;
                }
                return elemId + "_" + str2;
            }
            return elemId;
        }
        if (elemId.equals("em_share_object")) {
            Object obj3 = elemParams.get(SquareReportConst.Key.KEY_ZPLAN_TO_UID);
            if (obj3 instanceof String) {
                str = (String) obj3;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            Object obj4 = elemParams.get("object_type");
            if (obj4 instanceof String) {
                str3 = (String) obj4;
            }
            if (str3 != null) {
                str2 = str3;
            }
            return elemId + "_" + str2 + "_" + str;
        }
        return elemId;
    }

    public final void c(@NotNull String elemId, @NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) elemId, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.elemId2Params.containsKey(elemId)) {
            return;
        }
        Map<String, Object> map = this.elemId2Params.get(elemId);
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        map.put("qq_eid", elemId);
        map.putAll(params);
        this.elemId2Params.put(elemId, map);
    }

    public final void d(@NotNull String pageId, @NotNull Map<String, ? extends Object> params) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pageId, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.curPageId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.curPageId = pageId;
        this.pageParams.putAll(params);
    }

    public final void e(@NotNull String elemId, @NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) elemId, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(params, "params");
        VideoReport.reportEvent("ev_share_clck", a(elemId, params));
    }

    public final void g(@NotNull String elemId, @NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) elemId, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(params, "params");
        VideoReport.reportEvent("ev_share_imp", a(elemId, params));
    }

    public final void h() {
        Map mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("qq_pgid", this.curPageId), TuplesKt.to("cur_pg", this.pageParams));
            VideoReport.reportEvent("ev_share_pgin", mapOf);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
