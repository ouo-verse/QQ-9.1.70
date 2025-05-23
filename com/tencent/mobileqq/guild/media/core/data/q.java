package com.tencent.mobileqq.guild.media.core.data;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0000H\u0016J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010!\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010)\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010/\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b\u001b\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 R\"\u00105\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u0011\u001a\u0004\b3\u0010\u0013\"\u0004\b4\u0010\u0015R\"\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010+\u001a\u0004\b\u0017\u0010,\"\u0004\b6\u0010.R\"\u0010;\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010\u0015R\"\u0010=\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b<\u0010\u001e\"\u0004\b8\u0010 R2\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\r0>j\b\u0012\u0004\u0012\u00020\r`?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b\"\u0010B\"\u0004\bC\u0010DR\"\u0010H\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001c\u001a\u0004\bF\u0010\u001e\"\u0004\bG\u0010 R\"\u0010K\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001c\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010 R\"\u0010N\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u001c\u001a\u0004\b*\u0010\u001e\"\u0004\bM\u0010 R\"\u0010R\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010+\u001a\u0004\bP\u0010,\"\u0004\bQ\u0010.R\"\u0010U\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010\u001c\u001a\u0004\b\u0010\u0010\u001e\"\u0004\bT\u0010 R\"\u0010X\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010\u001c\u001a\u0004\b&\u0010\u001e\"\u0004\bW\u0010 \u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/q;", "", "", "a", "b", TtmlNode.ATTR_TTS_ORIGIN, "c", "", "other", "", "equals", "", "hashCode", "", "toString", "", "d", "J", "getTinyId", "()J", "G", "(J)V", "tinyId", "e", "getRoomId", "E", "roomId", "f", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/String;)V", "nickName", tl.h.F, "getHeroName", "w", "heroName", "i", "j", HippyTKDListViewAdapter.X, "heroPic", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "()I", ReportConstant.COSTREPORT_PREFIX, "(I)V", "gameStatus", "o", "D", QQPermissionConstants.Permission.AUIDO_GROUP, "getJoinTimestampMs", "B", "joinTimestampMs", "r", "gameIdentity", UserInfo.SEX_FEMALE, "getGameStatusUpdateTimestampMs", "t", "gameStatusUpdateTimestampMs", "p", QZoneDTLoginReporter.SCHEMA, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setGoodHeroIconList", "(Ljava/util/ArrayList;)V", "goodHeroIconList", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "honorIcon", "k", "y", "honorDesc", "K", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "identityDesc", "L", "getGradeLevel", "u", "gradeLevel", "M", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "backgroundPic", "N", "v", "gradeLevelUrl", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q implements Cloneable {

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private long joinTimestampMs;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private int gameIdentity;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private long gameStatusUpdateTimestampMs;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    private int gradeLevel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long tinyId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long roomId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private int gameStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String nickName = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String heroName = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String heroPic = "";

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private String record = "";

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private String schema = "";

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private ArrayList<String> goodHeroIconList = new ArrayList<>();

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private String honorIcon = "";

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private String honorDesc = "";

    /* renamed from: K, reason: from kotlin metadata and from toString */
    @NotNull
    private String identityDesc = "";

    /* renamed from: M, reason: from kotlin metadata and from toString */
    @NotNull
    private String backgroundPic = "";

    /* renamed from: N, reason: from kotlin metadata and from toString */
    @NotNull
    private String gradeLevelUrl = "";

    public final void A(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.identityDesc = str;
    }

    public final void B(long j3) {
        this.joinTimestampMs = j3;
    }

    public final void C(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.record = str;
    }

    public final void E(long j3) {
        this.roomId = j3;
    }

    public final void F(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schema = str;
    }

    public final void G(long j3) {
        this.tinyId = j3;
    }

    public final void a() {
        this.tinyId = 0L;
        this.roomId = 0L;
        this.nickName = "";
        this.heroName = "";
        this.heroPic = "";
        this.gameStatus = 0;
        this.record = "";
        this.joinTimestampMs = 0L;
        this.gameIdentity = 0;
        this.gameStatusUpdateTimestampMs = 0L;
        this.schema = "";
        this.goodHeroIconList.clear();
        this.honorIcon = "";
        this.honorDesc = "";
        this.identityDesc = "";
        this.gradeLevel = 0;
        this.backgroundPic = "";
        this.gradeLevelUrl = "";
    }

    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.data.UserInfoInGame");
        return (q) clone;
    }

    public final void c(@NotNull q origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.tinyId = origin.tinyId;
        this.roomId = origin.roomId;
        this.nickName = origin.nickName;
        this.heroName = origin.heroName;
        this.heroPic = origin.heroPic;
        this.gameStatus = origin.gameStatus;
        this.record = origin.record;
        this.joinTimestampMs = origin.joinTimestampMs;
        this.gameIdentity = origin.gameIdentity;
        this.gameStatusUpdateTimestampMs = origin.gameStatusUpdateTimestampMs;
        this.schema = origin.schema;
        this.goodHeroIconList.clear();
        this.goodHeroIconList.addAll(origin.goodHeroIconList);
        this.honorIcon = origin.honorIcon;
        this.honorDesc = origin.honorDesc;
        this.identityDesc = origin.identityDesc;
        this.gradeLevel = origin.gradeLevel;
        this.backgroundPic = origin.backgroundPic;
        this.gradeLevelUrl = origin.gradeLevelUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getBackgroundPic() {
        return this.backgroundPic;
    }

    /* renamed from: e, reason: from getter */
    public final int getGameIdentity() {
        return this.gameIdentity;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(q.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.data.UserInfoInGame");
        q qVar = (q) other;
        if (this.tinyId == qVar.tinyId && this.roomId == qVar.roomId && Intrinsics.areEqual(this.nickName, qVar.nickName) && Intrinsics.areEqual(this.heroName, qVar.heroName) && Intrinsics.areEqual(this.heroPic, qVar.heroPic) && this.gameStatus == qVar.gameStatus && Intrinsics.areEqual(this.record, qVar.record) && this.joinTimestampMs == qVar.joinTimestampMs && this.gameIdentity == qVar.gameIdentity && this.gameStatusUpdateTimestampMs == qVar.gameStatusUpdateTimestampMs && Intrinsics.areEqual(this.schema, qVar.schema) && Intrinsics.areEqual(this.goodHeroIconList, qVar.goodHeroIconList) && Intrinsics.areEqual(this.honorIcon, qVar.honorIcon) && Intrinsics.areEqual(this.honorDesc, qVar.honorDesc) && Intrinsics.areEqual(this.identityDesc, qVar.identityDesc) && this.gradeLevel == qVar.gradeLevel && Intrinsics.areEqual(this.backgroundPic, qVar.backgroundPic) && Intrinsics.areEqual(this.gradeLevelUrl, qVar.gradeLevelUrl)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getGameStatus() {
        return this.gameStatus;
    }

    @NotNull
    public final ArrayList<String> h() {
        return this.goodHeroIconList;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((androidx.fragment.app.a.a(this.tinyId) * 31) + androidx.fragment.app.a.a(this.roomId)) * 31) + this.nickName.hashCode()) * 31) + this.heroName.hashCode()) * 31) + this.heroPic.hashCode()) * 31) + this.gameStatus) * 31) + this.record.hashCode()) * 31) + androidx.fragment.app.a.a(this.joinTimestampMs)) * 31) + this.gameIdentity) * 31) + androidx.fragment.app.a.a(this.gameStatusUpdateTimestampMs)) * 31) + this.schema.hashCode()) * 31) + this.goodHeroIconList.hashCode()) * 31) + this.honorIcon.hashCode()) * 31) + this.honorDesc.hashCode()) * 31) + this.identityDesc.hashCode()) * 31) + this.gradeLevel) * 31) + this.backgroundPic.hashCode()) * 31) + this.gradeLevelUrl.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getGradeLevelUrl() {
        return this.gradeLevelUrl;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getHeroPic() {
        return this.heroPic;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getHonorDesc() {
        return this.honorDesc;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getHonorIcon() {
        return this.honorIcon;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getIdentityDesc() {
        return this.identityDesc;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getRecord() {
        return this.record;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundPic = str;
    }

    public final void r(int i3) {
        this.gameIdentity = i3;
    }

    public final void s(int i3) {
        this.gameStatus = i3;
    }

    public final void t(long j3) {
        this.gameStatusUpdateTimestampMs = j3;
    }

    @NotNull
    public String toString() {
        return "UserInfoInGame {tinyId='" + this.tinyId + "', roomId='" + this.roomId + "', nickName='" + this.nickName + "', heroName=" + this.heroName + ", heroPic=" + this.heroPic + ", gameStatus=" + this.gameStatus + ", record=" + this.record + ", joinTimestampMs=" + this.joinTimestampMs + ", gameIdentity=" + this.gameIdentity + ", gameStatusUpdateTimestampMs=" + this.gameStatusUpdateTimestampMs + ", schema=" + this.schema + ", goodHeroIconList=" + this.goodHeroIconList + ", honorIcon=" + this.honorIcon + ", honorDesc=" + this.honorDesc + ", identityDesc=" + this.identityDesc + ", gradeLevel=" + this.gradeLevel + ", backgroundPic=" + this.backgroundPic + ", gradeLevelUrl=" + this.gradeLevelUrl + "}";
    }

    public final void u(int i3) {
        this.gradeLevel = i3;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gradeLevelUrl = str;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.heroName = str;
    }

    public final void x(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.heroPic = str;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.honorDesc = str;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.honorIcon = str;
    }
}
