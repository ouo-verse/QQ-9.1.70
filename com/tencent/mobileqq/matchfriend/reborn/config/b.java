package com.tencent.mobileqq.matchfriend.reborn.config;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.proavatar.utils.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 H2\u00020\u0001:\u0002IAB\u0007\u00a2\u0006\u0004\bF\u0010GJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR.\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR.\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR.\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u000f\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR.\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\t\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010\rR.\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\rR(\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u001c\u001a\u0004\b\u0013\u0010\u001d\"\u0004\b.\u0010\u001fR(\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR.\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\t\u001a\u0004\b5\u0010\u000b\"\u0004\b!\u0010\rR.\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002070\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\t\u001a\u0004\b\b\u0010\u000b\"\u0004\b9\u0010\rR(\u0010?\u001a\u0004\u0018\u00010\u00042\b\u0010;\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b\u0017\u0010>R\"\u0010E\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010<\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/config/b;", "Lcom/tencent/freesia/IConfigData;", "", "i", "", "toString", "", "", "d", "Ljava/util/Map;", "getColorIdMap", "()Ljava/util/Map;", "l", "(Ljava/util/Map;)V", "colorIdMap", "e", "getEmojiUrlIdMap", DomainData.DOMAIN_NAME, "emojiUrlIdMap", "f", "getTextIdMap", "v", "textIdMap", h.F, "getPublishBgImgIdMap", "u", "publishBgImgIdMap", "", "Ljava/util/List;", "()Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/util/List;)V", "maleAvatarArray", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "o", "femaleAvatarArray", BdhLogUtil.LogTag.Tag_Conn, "getAvatarBgUrlIdMap", "k", "avatarBgUrlIdMap", "D", "getPublishAvatarBgUrlIdMap", "t", "publishAvatarBgUrlIdMap", "E", "r", "nickAdjectiveArray", UserInfo.SEX_FEMALE, "g", ReportConstant.COSTREPORT_PREFIX, "nickNounArray", "G", "getDatingPurposeIconMap", "datingPurposeIconMap", "Lcom/tencent/mobileqq/matchfriend/reborn/config/b$b;", "H", "p", "liteActionConfigs", "<set-?>", "I", "Ljava/lang/String;", "()Ljava/lang/String;", "userZplanAvatarUrl", "J", "b", "()I", "j", "(I)V", "assistedChatCacheExpiredTime", "<init>", "()V", "K", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b implements IConfigData {

    /* renamed from: K, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: I, reason: from kotlin metadata */
    private String userZplanAvatarUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, String> colorIdMap = new HashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, String> emojiUrlIdMap = new HashMap();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, String> textIdMap = new HashMap();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, String> publishBgImgIdMap = new HashMap();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<String> maleAvatarArray = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<String> femaleAvatarArray = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private Map<Integer, String> avatarBgUrlIdMap = new HashMap();

    /* renamed from: D, reason: from kotlin metadata */
    private Map<Integer, String> publishAvatarBgUrlIdMap = new HashMap();

    /* renamed from: E, reason: from kotlin metadata */
    private List<String> nickAdjectiveArray = new ArrayList();

    /* renamed from: F, reason: from kotlin metadata */
    private List<String> nickNounArray = new ArrayList();

    /* renamed from: G, reason: from kotlin metadata */
    private Map<Integer, String> datingPurposeIconMap = new HashMap();

    /* renamed from: H, reason: from kotlin metadata */
    private Map<Integer, C8009b> liteActionConfigs = new HashMap();

    /* renamed from: J, reason: from kotlin metadata */
    private int assistedChatCacheExpiredTime = 3600;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000bR\u0014\u0010\u0010\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/config/b$a;", "", "Lorg/json/JSONObject;", "", "parseKey", "", "", "Lcom/tencent/mobileqq/matchfriend/reborn/config/b$b;", "c", "a", "content", "Lcom/tencent/mobileqq/matchfriend/reborn/config/b;", "b", DownloadInfo.spKey_Config, "", "d", "CONFIG_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.config.b$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String a() {
            String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
            IProAvatarUtilsApi iProAvatarUtilsApi = (IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            Map<String, ? extends Object> avatarInfo = iProAvatarUtilsApi.getAvatarInfo(1, uin);
            Object obj = avatarInfo.get(FaceConstant.AvatarInfoBuilderKeys.STATIC_ZPLAN_FACE_FLAG);
            Byte b16 = obj instanceof Byte ? (Byte) obj : null;
            if ((b16 != null ? b16.byteValue() : (byte) 0) <= 0) {
                return null;
            }
            return d.f259720a.a(avatarInfo, 200);
        }

        private final Map<Integer, C8009b> c(JSONObject jSONObject, String str) {
            JSONObject optJSONObject;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(str)) != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    Object obj = optJSONObject.get(key);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject2 = (JSONObject) obj;
                    C8009b c8009b = new C8009b();
                    c8009b.d(a.c(jSONObject2, "emojiIdList"));
                    String optString = jSONObject2.optString("emojiName", "");
                    Intrinsics.checkNotNullExpressionValue(optString, "value.optString(\"emojiName\", \"\")");
                    c8009b.c(optString);
                    String optString2 = jSONObject2.optString("animatePath", "");
                    Intrinsics.checkNotNullExpressionValue(optString2, "value.optString(\"animatePath\", \"\")");
                    c8009b.e(optString2);
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    linkedHashMap.put(Integer.valueOf(Integer.parseInt(key)), c8009b);
                }
            }
            return linkedHashMap;
        }

        public final b b(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(content);
                bVar.l(a.d(jSONObject, "colorIdMap"));
                bVar.n(a.d(jSONObject, "emojiUrlIdMap"));
                bVar.v(a.d(jSONObject, "textIdMap"));
                bVar.q(a.c(jSONObject, "maleAvatarArray"));
                bVar.o(a.c(jSONObject, "femaleAvatarArray"));
                bVar.k(a.d(jSONObject, "avatarBgUrlIdMap"));
                bVar.t(a.d(jSONObject, "publishAvatarBgUrlIdMap"));
                bVar.u(a.d(jSONObject, "publishBgImgIdMap"));
                bVar.r(a.c(jSONObject, "nickAdjectiveArray"));
                bVar.s(a.c(jSONObject, "nickNounArray"));
                bVar.m(a.d(jSONObject, "datingPurposeIconMap"));
                bVar.p(c(jSONObject, "interactEmojiIdMap"));
                bVar.j(jSONObject.optInt("assistedChatCacheExpiredTime", 3600));
            } catch (Exception e16) {
                QLog.e("QQStrangerConfig", 1, "parse error, ", e16);
            }
            return bVar;
        }

        public final void d(b config) {
            Intrinsics.checkNotNullParameter(config, "config");
            config.userZplanAvatarUrl = a();
            QLog.i("QQStrangerConfig", 1, "updateUserZplanAvatarUrl: " + config.getUserZplanAvatarUrl());
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/config/b$b;", "", "", "", "a", "Ljava/util/List;", "getEmojis", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "emojis", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "emojiName", "e", "lottieUrl", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.config.b$b, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class C8009b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private List<String> emojis = new ArrayList();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String emojiName = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String lottieUrl = "";

        /* renamed from: a, reason: from getter */
        public final String getEmojiName() {
            return this.emojiName;
        }

        /* renamed from: b, reason: from getter */
        public final String getLottieUrl() {
            return this.lottieUrl;
        }

        public final void c(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.emojiName = str;
        }

        public final void d(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.emojis = list;
        }

        public final void e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lottieUrl = str;
        }
    }

    /* renamed from: b, reason: from getter */
    public final int getAssistedChatCacheExpiredTime() {
        return this.assistedChatCacheExpiredTime;
    }

    public final List<String> c() {
        return this.femaleAvatarArray;
    }

    public final Map<Integer, C8009b> d() {
        return this.liteActionConfigs;
    }

    public final List<String> e() {
        return this.maleAvatarArray;
    }

    public final List<String> f() {
        return this.nickAdjectiveArray;
    }

    public final List<String> g() {
        return this.nickNounArray;
    }

    /* renamed from: h, reason: from getter */
    public final String getUserZplanAvatarUrl() {
        return this.userZplanAvatarUrl;
    }

    public final boolean i() {
        return (this.colorIdMap.isEmpty() ^ true) && (this.emojiUrlIdMap.isEmpty() ^ true) && (this.textIdMap.isEmpty() ^ true) && (this.publishBgImgIdMap.isEmpty() ^ true) && (this.maleAvatarArray.isEmpty() ^ true) && (this.femaleAvatarArray.isEmpty() ^ true) && (this.avatarBgUrlIdMap.isEmpty() ^ true) && (this.publishAvatarBgUrlIdMap.isEmpty() ^ true) && (this.nickAdjectiveArray.isEmpty() ^ true) && (this.nickNounArray.isEmpty() ^ true) && (this.datingPurposeIconMap.isEmpty() ^ true);
    }

    public final void j(int i3) {
        this.assistedChatCacheExpiredTime = i3;
    }

    public final void k(Map<Integer, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.avatarBgUrlIdMap = map;
    }

    public final void l(Map<Integer, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.colorIdMap = map;
    }

    public final void m(Map<Integer, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.datingPurposeIconMap = map;
    }

    public final void n(Map<Integer, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.emojiUrlIdMap = map;
    }

    public final void o(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.femaleAvatarArray = list;
    }

    public final void p(Map<Integer, C8009b> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.liteActionConfigs = map;
    }

    public final void q(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.maleAvatarArray = list;
    }

    public final void r(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.nickAdjectiveArray = list;
    }

    public final void s(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.nickNounArray = list;
    }

    public final void t(Map<Integer, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.publishAvatarBgUrlIdMap = map;
    }

    public String toString() {
        return String.valueOf(i());
    }

    public final void u(Map<Integer, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.publishBgImgIdMap = map;
    }

    public final void v(Map<Integer, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.textIdMap = map;
    }
}
