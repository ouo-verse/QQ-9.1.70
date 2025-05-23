package com.tencent.qqnt.pluspanel.config;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001CB\u00cf\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\u001c\b\u0002\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`-\u0012\u001c\b\u0002\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`-\u0012\u001c\b\u0002\u0010;\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`-\u0012\b\b\u0002\u0010?\u001a\u00020\u0003\u00a2\u0006\u0004\b@\u0010AJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0017\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0019\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u001c\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000eR\u0017\u0010\u001f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000eR\u0017\u0010#\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001a\u0010\"R\u0017\u0010&\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u000eR\"\u0010+\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010*R6\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R6\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103R6\u0010;\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010/\u001a\u0004\b9\u00101\"\u0004\b:\u00103R\"\u0010?\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010!\u001a\u0004\b=\u0010\"\"\u0004\b>\u0010*\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/pluspanel/config/b;", "", "other", "", "c", "", "toString", "hashCode", "", "", "equals", "d", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "appid", "e", "r", "title", "f", "i", "actionType", h.F, "action", "o", "iconNormal", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "iconConciseNormal", BdhLogUtil.LogTag.Tag_Conn, "p", "iconVip", "D", "I", "()I", "enable", "E", "getRedDotId", "redDotId", UserInfo.SEX_FEMALE, "getOrder", "v", "(I)V", "order", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "k", "()Ljava/util/ArrayList;", "t", "(Ljava/util/ArrayList;)V", "childList", "H", "l", "u", "conciseChildList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "teenagerChildList", "J", ReportConstant.COSTREPORT_PREFIX, "setVersion", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;I)V", "K", "a", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class b implements Comparable<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String iconVip;

    /* renamed from: D, reason: from kotlin metadata */
    private final int enable;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String redDotId;

    /* renamed from: F, reason: from kotlin metadata */
    private int order;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ArrayList<Integer> childList;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ArrayList<Integer> conciseChildList;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ArrayList<Integer> teenagerChildList;

    /* renamed from: J, reason: from kotlin metadata */
    private int version;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String actionType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String action;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconNormal;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconConciseNormal;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/config/b$a;", "", "", "VERSION", "I", "<init>", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.config.b$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37313);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        this(null, null, null, null, null, null, null, 0, null, 0, null, null, null, 0, 16383, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) {
            return;
        }
        iPatchRedirector.redirect((short) 41, (Object) this);
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull b other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) other)).intValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        return this.order - other.order;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.appid, bVar.appid) && Intrinsics.areEqual(this.title, bVar.title) && Intrinsics.areEqual(this.actionType, bVar.actionType) && Intrinsics.areEqual(this.action, bVar.action) && Intrinsics.areEqual(this.iconNormal, bVar.iconNormal) && Intrinsics.areEqual(this.iconConciseNormal, bVar.iconConciseNormal) && Intrinsics.areEqual(this.iconVip, bVar.iconVip) && this.enable == bVar.enable && Intrinsics.areEqual(this.redDotId, bVar.redDotId) && this.order == bVar.order && Intrinsics.areEqual(this.childList, bVar.childList) && Intrinsics.areEqual(this.conciseChildList, bVar.conciseChildList) && Intrinsics.areEqual(this.teenagerChildList, bVar.teenagerChildList) && this.version == bVar.version) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.action;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        int hashCode3 = ((((((((((((((((((this.appid.hashCode() * 31) + this.title.hashCode()) * 31) + this.actionType.hashCode()) * 31) + this.action.hashCode()) * 31) + this.iconNormal.hashCode()) * 31) + this.iconConciseNormal.hashCode()) * 31) + this.iconVip.hashCode()) * 31) + this.enable) * 31) + this.redDotId.hashCode()) * 31) + this.order) * 31;
        ArrayList<Integer> arrayList = this.childList;
        int i3 = 0;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        ArrayList<Integer> arrayList2 = this.conciseChildList;
        if (arrayList2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = arrayList2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        ArrayList<Integer> arrayList3 = this.teenagerChildList;
        if (arrayList3 != null) {
            i3 = arrayList3.hashCode();
        }
        return ((i17 + i3) * 31) + this.version;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.actionType;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appid;
    }

    @Nullable
    public final ArrayList<Integer> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.childList;
    }

    @Nullable
    public final ArrayList<Integer> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ArrayList) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.conciseChildList;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.enable;
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.iconConciseNormal;
    }

    @NotNull
    public final String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.iconNormal;
    }

    @NotNull
    public final String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.iconVip;
    }

    @Nullable
    public final ArrayList<Integer> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ArrayList) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.teenagerChildList;
    }

    @NotNull
    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.title;
    }

    public final int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.version;
    }

    public final void t(@Nullable ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) arrayList);
        } else {
            this.childList = arrayList;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return "AppInfoConfigData(appid=" + this.appid + ", title=" + this.title + ", actionType=" + this.actionType + ", action=" + this.action + ", iconNormal=" + this.iconNormal + ", iconConciseNormal=" + this.iconConciseNormal + ", iconVip=" + this.iconVip + ", enable=" + this.enable + ", redDotId=" + this.redDotId + ", order=" + this.order + ", childList=" + this.childList + ", conciseChildList=" + this.conciseChildList + ", teenagerChildList=" + this.teenagerChildList + ", version=" + this.version + ")";
    }

    public final void u(@Nullable ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) arrayList);
        } else {
            this.conciseChildList = arrayList;
        }
    }

    public final void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.order = i3;
        }
    }

    public final void w(@Nullable ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) arrayList);
        } else {
            this.teenagerChildList = arrayList;
        }
    }

    public b(@NotNull String appid, @NotNull String title, @NotNull String actionType, @NotNull String action, @NotNull String iconNormal, @NotNull String iconConciseNormal, @NotNull String iconVip, int i3, @NotNull String redDotId, int i16, @Nullable ArrayList<Integer> arrayList, @Nullable ArrayList<Integer> arrayList2, @Nullable ArrayList<Integer> arrayList3, int i17) {
        Intrinsics.checkNotNullParameter(appid, "appid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(iconNormal, "iconNormal");
        Intrinsics.checkNotNullParameter(iconConciseNormal, "iconConciseNormal");
        Intrinsics.checkNotNullParameter(iconVip, "iconVip");
        Intrinsics.checkNotNullParameter(redDotId, "redDotId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appid, title, actionType, action, iconNormal, iconConciseNormal, iconVip, Integer.valueOf(i3), redDotId, Integer.valueOf(i16), arrayList, arrayList2, arrayList3, Integer.valueOf(i17));
            return;
        }
        this.appid = appid;
        this.title = title;
        this.actionType = actionType;
        this.action = action;
        this.iconNormal = iconNormal;
        this.iconConciseNormal = iconConciseNormal;
        this.iconVip = iconVip;
        this.enable = i3;
        this.redDotId = redDotId;
        this.order = i16;
        this.childList = arrayList;
        this.conciseChildList = arrayList2;
        this.teenagerChildList = arrayList3;
        this.version = i17;
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, String str8, int i16, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? "" : str2, (i18 & 4) != 0 ? "" : str3, (i18 & 8) != 0 ? "" : str4, (i18 & 16) != 0 ? "" : str5, (i18 & 32) != 0 ? "" : str6, (i18 & 64) != 0 ? "" : str7, (i18 & 128) != 0 ? 0 : i3, (i18 & 256) != 0 ? "" : str8, (i18 & 512) != 0 ? 0 : i16, (i18 & 1024) != 0 ? null : arrayList, (i18 & 2048) != 0 ? null : arrayList2, (i18 & 4096) != 0 ? null : arrayList3, (i18 & 8192) != 0 ? 0 : i17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i3), str8, Integer.valueOf(i16), arrayList, arrayList2, arrayList3, Integer.valueOf(i17), Integer.valueOf(i18), defaultConstructorMarker);
    }
}
