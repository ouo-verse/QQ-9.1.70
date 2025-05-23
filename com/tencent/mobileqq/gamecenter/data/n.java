package com.tencent.mobileqq.gamecenter.data;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010'\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR$\u0010*\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b)\u0010\u0013R$\u0010-\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013R$\u0010/\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b \u0010\u0011\"\u0004\b.\u0010\u0013R$\u00102\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R$\u00104\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u000f\u001a\u0004\b$\u0010\u0011\"\u0004\b3\u0010\u0013R\"\u0010:\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00106\u001a\u0004\b(\u00107\"\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/n;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "gameSession", "", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "p", "Lorg/json/JSONObject;", "B", "", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "nickname", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, PhotoCategorySummaryInfo.AVATAR_URL, "", "c", "I", tl.h.F, "()I", "w", "(I)V", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "d", "i", HippyTKDListViewAdapter.X, "status", "e", "l", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "unreadCnt", "f", "r", "fromOpenAioId", "j", "y", "toOpenAioId", ReportConstant.COSTREPORT_PREFIX, "fromRoleId", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "toRoleId", "t", "gameAppId", "", "J", "()J", "u", "(J)V", "lastMsgTime", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class n {

    /* renamed from: n, reason: collision with root package name */
    private static final int f212048n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static final int f212049o = 0;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int unreadCnt;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long lastMsgTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final int f212047m = 1;

    /* renamed from: p, reason: collision with root package name */
    private static final int f212050p = 1;

    /* renamed from: q, reason: collision with root package name */
    private static final int f212051q = 2;

    /* renamed from: r, reason: collision with root package name */
    private static final int f212052r = 3;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String nickname = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String avatarUrl = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int sessionType = f212049o;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int status = f212048n;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String fromOpenAioId = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String toOpenAioId = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String fromRoleId = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String toRoleId = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String gameAppId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/n$a;", "", "", "PARTNER_STATUS_TO_ME_AGREED", "I", "a", "()I", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.data.n$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return n.f212052r;
        }

        Companion() {
        }
    }

    private final boolean n(TempChatGameSession gameSession) {
        boolean z16;
        boolean z17;
        if (gameSession != null) {
            String str = this.fromRoleId;
            if (str != null && str.equals(gameSession.selfRoleId)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String str2 = this.toRoleId;
                if (str2 != null && str2.equals(gameSession.peerRoleId)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void A(int i3) {
        this.unreadCnt = i3;
    }

    @Nullable
    public final JSONObject B() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nickname", this.nickname);
        jSONObject.put(PhotoCategorySummaryInfo.AVATAR_URL, this.avatarUrl);
        jSONObject.put("type", this.sessionType);
        jSONObject.put("status", this.status);
        jSONObject.put("unreadCnt", this.unreadCnt);
        jSONObject.put("fromOpenAioId", this.fromOpenAioId);
        jSONObject.put("toOpenAioId", this.toOpenAioId);
        jSONObject.put("gameAppId", this.gameAppId);
        jSONObject.put("lastMsgTime", this.lastMsgTime);
        return jSONObject;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getFromOpenAioId() {
        return this.fromOpenAioId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getFromRoleId() {
        return this.fromRoleId;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getGameAppId() {
        return this.gameAppId;
    }

    /* renamed from: f, reason: from getter */
    public final long getLastMsgTime() {
        return this.lastMsgTime;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: h, reason: from getter */
    public final int getSessionType() {
        return this.sessionType;
    }

    /* renamed from: i, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getToOpenAioId() {
        return this.toOpenAioId;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getToRoleId() {
        return this.toRoleId;
    }

    /* renamed from: l, reason: from getter */
    public final int getUnreadCnt() {
        return this.unreadCnt;
    }

    public final boolean m(@Nullable RecentContactInfo info) {
        ArrayList<RecentContactExtAttr> arrayList;
        TempChatGameSession tempChatGameSession;
        if (info != null && (arrayList = info.extAttrs) != null) {
            for (RecentContactExtAttr recentContactExtAttr : arrayList) {
                if (recentContactExtAttr != null) {
                    tempChatGameSession = recentContactExtAttr.gameSession;
                } else {
                    tempChatGameSession = null;
                }
                if (n(tempChatGameSession)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean o(@Nullable RecentContactInfo info) {
        if (this.sessionType == f212052r && m(info)) {
            return true;
        }
        return false;
    }

    public final boolean p(@Nullable TempChatGameSession gameSession) {
        if (this.sessionType == f212052r && n(gameSession)) {
            return true;
        }
        return false;
    }

    public final void q(@Nullable String str) {
        this.avatarUrl = str;
    }

    public final void r(@Nullable String str) {
        this.fromOpenAioId = str;
    }

    public final void s(@Nullable String str) {
        this.fromRoleId = str;
    }

    public final void t(@Nullable String str) {
        this.gameAppId = str;
    }

    public final void u(long j3) {
        this.lastMsgTime = j3;
    }

    public final void v(@Nullable String str) {
        this.nickname = str;
    }

    public final void w(int i3) {
        this.sessionType = i3;
    }

    public final void x(int i3) {
        this.status = i3;
    }

    public final void y(@Nullable String str) {
        this.toOpenAioId = str;
    }

    public final void z(@Nullable String str) {
        this.toRoleId = str;
    }
}
