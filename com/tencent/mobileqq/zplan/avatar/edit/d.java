package com.tencent.mobileqq.zplan.avatar.edit;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b)\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001\u001aB\u0093\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0095\u0001\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010%R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010%R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u000b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u001e\u001a\u0004\b,\u0010 R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u001b\u001a\u0004\b(\u0010\u001d\"\u0004\b-\u0010%R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b5\u0010<\u001a\u0004\b9\u0010=R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b>\u0010\u001b\u001a\u0004\b3\u0010\u001d\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "", "", "toString", "uin", "", "actionId", "actionName", "defaultUrl", "Lcom/tencent/mobileqq/zplan/avatar/edit/b;", "backgroundInfo", "avatarSize", "appearanceKey", "", "maskRate", "Lcom/tencent/mobileqq/zplan/avatar/edit/c;", "inBoundsClipperInfo", "outBoundsClipperInfo", "", "eventTags", "eventInfo", "b", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "I", "c", "()I", "p", "(I)V", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "e", "Lcom/tencent/mobileqq/zplan/avatar/edit/b;", "g", "()Lcom/tencent/mobileqq/zplan/avatar/edit/b;", "f", "r", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()D", "u", "(D)V", "i", "Lcom/tencent/mobileqq/zplan/avatar/edit/c;", "k", "()Lcom/tencent/mobileqq/zplan/avatar/edit/c;", "t", "(Lcom/tencent/mobileqq/zplan/avatar/edit/c;)V", "j", DomainData.DOMAIN_NAME, "v", "Ljava/util/List;", "()Ljava/util/List;", "l", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/zplan/avatar/edit/b;ILjava/lang/String;DLcom/tencent/mobileqq/zplan/avatar/edit/c;Lcom/tencent/mobileqq/zplan/avatar/edit/c;Ljava/util/List;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class d {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int actionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String actionName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String defaultUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final BackgroundInfo backgroundInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int avatarSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appearanceKey;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private double maskRate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ClipperInfo inBoundsClipperInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ClipperInfo outBoundsClipperInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<Integer> eventTags;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String eventInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/edit/d$a;", "", "", "", "actionIdList", "", "uin", "appearanceKey", "", "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "b", "editAvatarData", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.edit.d$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final d a(@Nullable d editAvatarData) {
            if (editAvatarData == null) {
                return null;
            }
            return new d(editAvatarData.getUin(), editAvatarData.getActionId(), editAvatarData.getActionName(), editAvatarData.getDefaultUrl(), editAvatarData.getBackgroundInfo(), editAvatarData.getAvatarSize(), editAvatarData.getAppearanceKey(), editAvatarData.getMaskRate(), editAvatarData.getInBoundsClipperInfo(), editAvatarData.getOutBoundsClipperInfo(), editAvatarData.j(), editAvatarData.getEventInfo());
        }

        @JvmStatic
        @NotNull
        public final List<d> b(@NotNull List<Integer> actionIdList, @NotNull String uin, @NotNull String appearanceKey) {
            Intrinsics.checkNotNullParameter(actionIdList, "actionIdList");
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = actionIdList.iterator();
            while (it.hasNext()) {
                arrayList.add(new d(uin, ((Number) it.next()).intValue(), null, null, null, 0, appearanceKey, 0.0d, null, null, null, null, 4028, null));
            }
            return arrayList;
        }

        Companion() {
        }
    }

    public d() {
        this(null, 0, null, null, null, 0, null, 0.0d, null, null, null, null, 4095, null);
    }

    @JvmStatic
    @Nullable
    public static final d a(@Nullable d dVar) {
        return INSTANCE.a(dVar);
    }

    @JvmStatic
    @NotNull
    public static final List<d> l(@NotNull List<Integer> list, @NotNull String str, @NotNull String str2) {
        return INSTANCE.b(list, str, str2);
    }

    @NotNull
    public final d b(@NotNull String uin, int actionId, @Nullable String actionName, @Nullable String defaultUrl, @Nullable BackgroundInfo backgroundInfo, int avatarSize, @NotNull String appearanceKey, double maskRate, @Nullable ClipperInfo inBoundsClipperInfo, @Nullable ClipperInfo outBoundsClipperInfo, @Nullable List<Integer> eventTags, @Nullable String eventInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        return new d(uin, actionId, actionName, defaultUrl, backgroundInfo, avatarSize, appearanceKey, maskRate, inBoundsClipperInfo, outBoundsClipperInfo, eventTags, eventInfo);
    }

    /* renamed from: c, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getActionName() {
        return this.actionName;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getAppearanceKey() {
        return this.appearanceKey;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.uin, dVar.uin) && this.actionId == dVar.actionId && Intrinsics.areEqual(this.actionName, dVar.actionName) && Intrinsics.areEqual(this.defaultUrl, dVar.defaultUrl) && Intrinsics.areEqual(this.backgroundInfo, dVar.backgroundInfo) && this.avatarSize == dVar.avatarSize && Intrinsics.areEqual(this.appearanceKey, dVar.appearanceKey) && Double.compare(this.maskRate, dVar.maskRate) == 0 && Intrinsics.areEqual(this.inBoundsClipperInfo, dVar.inBoundsClipperInfo) && Intrinsics.areEqual(this.outBoundsClipperInfo, dVar.outBoundsClipperInfo) && Intrinsics.areEqual(this.eventTags, dVar.eventTags) && Intrinsics.areEqual(this.eventInfo, dVar.eventInfo)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getAvatarSize() {
        return this.avatarSize;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final BackgroundInfo getBackgroundInfo() {
        return this.backgroundInfo;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getDefaultUrl() {
        return this.defaultUrl;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7 = ((this.uin.hashCode() * 31) + this.actionId) * 31;
        String str = this.actionName;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode7 + hashCode) * 31;
        String str2 = this.defaultUrl;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        BackgroundInfo backgroundInfo = this.backgroundInfo;
        if (backgroundInfo == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = backgroundInfo.hashCode();
        }
        int hashCode8 = (((((((i17 + hashCode3) * 31) + this.avatarSize) * 31) + this.appearanceKey.hashCode()) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.maskRate)) * 31;
        ClipperInfo clipperInfo = this.inBoundsClipperInfo;
        if (clipperInfo == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = clipperInfo.hashCode();
        }
        int i18 = (hashCode8 + hashCode4) * 31;
        ClipperInfo clipperInfo2 = this.outBoundsClipperInfo;
        if (clipperInfo2 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = clipperInfo2.hashCode();
        }
        int i19 = (i18 + hashCode5) * 31;
        List<Integer> list = this.eventTags;
        if (list == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = list.hashCode();
        }
        int i26 = (i19 + hashCode6) * 31;
        String str3 = this.eventInfo;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i26 + i3;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getEventInfo() {
        return this.eventInfo;
    }

    @Nullable
    public final List<Integer> j() {
        return this.eventTags;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final ClipperInfo getInBoundsClipperInfo() {
        return this.inBoundsClipperInfo;
    }

    /* renamed from: m, reason: from getter */
    public final double getMaskRate() {
        return this.maskRate;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final ClipperInfo getOutBoundsClipperInfo() {
        return this.outBoundsClipperInfo;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final void p(int i3) {
        this.actionId = i3;
    }

    public final void q(@Nullable String str) {
        this.actionName = str;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appearanceKey = str;
    }

    public final void s(@Nullable String str) {
        this.defaultUrl = str;
    }

    public final void t(@Nullable ClipperInfo clipperInfo) {
        this.inBoundsClipperInfo = clipperInfo;
    }

    @NotNull
    public String toString() {
        Integer num;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[EditAvatarData actionId:");
        sb5.append(this.actionId);
        sb5.append(",appearanceKey:");
        sb5.append(this.appearanceKey);
        sb5.append(",maskRate:");
        sb5.append(this.maskRate);
        sb5.append(",bgId:");
        BackgroundInfo backgroundInfo = this.backgroundInfo;
        String str = null;
        if (backgroundInfo != null) {
            num = backgroundInfo.getId();
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(",bgurl:");
        BackgroundInfo backgroundInfo2 = this.backgroundInfo;
        if (backgroundInfo2 != null) {
            str = backgroundInfo2.getUrl();
        }
        sb5.append(str);
        sb5.append(']');
        return sb5.toString();
    }

    public final void u(double d16) {
        this.maskRate = d16;
    }

    public final void v(@Nullable ClipperInfo clipperInfo) {
        this.outBoundsClipperInfo = clipperInfo;
    }

    public d(@NotNull String uin, int i3, @Nullable String str, @Nullable String str2, @Nullable BackgroundInfo backgroundInfo, int i16, @NotNull String appearanceKey, double d16, @Nullable ClipperInfo clipperInfo, @Nullable ClipperInfo clipperInfo2, @Nullable List<Integer> list, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        this.uin = uin;
        this.actionId = i3;
        this.actionName = str;
        this.defaultUrl = str2;
        this.backgroundInfo = backgroundInfo;
        this.avatarSize = i16;
        this.appearanceKey = appearanceKey;
        this.maskRate = d16;
        this.inBoundsClipperInfo = clipperInfo;
        this.outBoundsClipperInfo = clipperInfo2;
        this.eventTags = list;
        this.eventInfo = str3;
    }

    public /* synthetic */ d(String str, int i3, String str2, String str3, BackgroundInfo backgroundInfo, int i16, String str4, double d16, ClipperInfo clipperInfo, ClipperInfo clipperInfo2, List list, String str5, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? -1 : i3, (i17 & 4) != 0 ? "" : str2, (i17 & 8) != 0 ? "" : str3, (i17 & 16) != 0 ? null : backgroundInfo, (i17 & 32) != 0 ? 640 : i16, (i17 & 64) == 0 ? str4 : "", (i17 & 128) != 0 ? 0.25d : d16, (i17 & 256) != 0 ? null : clipperInfo, (i17 & 512) != 0 ? null : clipperInfo2, (i17 & 1024) != 0 ? null : list, (i17 & 2048) == 0 ? str5 : null);
    }
}
