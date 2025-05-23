package com.tencent.mobileqq.guild.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0010\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/config/q;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "programOriginAppId", "f", "l", "wxAppId", "c", "i", "pathGuildHome", tl.h.F, "j", "pathGuildTextChannel", "a", "g", "pathGuildFeedChannel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "pathGuildFeedDetail", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class q implements IConfigData {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String programOriginAppId = "gh_cea36784360f";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String wxAppId = "wxf14070172bb44e41";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pathGuildHome = "pages-guild/index/index";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pathGuildTextChannel = "pages-guild/jump/jump";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pathGuildFeedChannel = "pages-guild/index/index";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pathGuildFeedDetail = "pages-guild/index/index";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/config/q$a;", "", "", "content", "Lcom/tencent/mobileqq/guild/config/q;", "a", "sPathGuildFeedChannel", "Ljava/lang/String;", "sPathGuildFeedDetail", "sPathGuildHome", "sPathGuildTextChannel", "sProgramOriginAppId", "sWxAppId", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.q$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final q a(@Nullable String content) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildShare2WechatConfig", 1, "parse content:" + content);
            }
            q qVar = new q();
            if (MiscKt.f(content)) {
                return qVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (jSONObject.has("programOriginAppId")) {
                    String optString = jSONObject.optString("programOriginAppId");
                    Intrinsics.checkNotNullExpressionValue(optString, "contentObj.optString(sProgramOriginAppId)");
                    qVar.k(optString);
                }
                if (jSONObject.has("wxAppId")) {
                    String optString2 = jSONObject.optString("wxAppId");
                    Intrinsics.checkNotNullExpressionValue(optString2, "contentObj.optString(sWxAppId)");
                    qVar.l(optString2);
                }
                if (jSONObject.has("pathGuildHome")) {
                    String optString3 = jSONObject.optString("pathGuildHome");
                    Intrinsics.checkNotNullExpressionValue(optString3, "contentObj.optString(sPathGuildHome)");
                    qVar.i(optString3);
                }
                if (jSONObject.has("pathGuildTextChannel")) {
                    String optString4 = jSONObject.optString("pathGuildTextChannel");
                    Intrinsics.checkNotNullExpressionValue(optString4, "contentObj.optString(sPathGuildTextChannel)");
                    qVar.j(optString4);
                }
                if (jSONObject.has("pathGuildFeedChannel")) {
                    String optString5 = jSONObject.optString("pathGuildFeedChannel");
                    Intrinsics.checkNotNullExpressionValue(optString5, "contentObj.optString(sPathGuildFeedChannel)");
                    qVar.g(optString5);
                }
                if (jSONObject.has("pathGuildFeedDetail")) {
                    String optString6 = jSONObject.optString("pathGuildFeedDetail");
                    Intrinsics.checkNotNullExpressionValue(optString6, "contentObj.optString(sPathGuildFeedDetail)");
                    qVar.h(optString6);
                }
            } catch (JSONException e16) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "error parse content:" + content;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildShare2WechatConfig", 1, (String) it.next(), e16);
                }
            }
            return qVar;
        }

        Companion() {
        }
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getPathGuildFeedChannel() {
        return this.pathGuildFeedChannel;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPathGuildFeedDetail() {
        return this.pathGuildFeedDetail;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPathGuildHome() {
        return this.pathGuildHome;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPathGuildTextChannel() {
        return this.pathGuildTextChannel;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getProgramOriginAppId() {
        return this.programOriginAppId;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getWxAppId() {
        return this.wxAppId;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pathGuildFeedChannel = str;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pathGuildFeedDetail = str;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pathGuildHome = str;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pathGuildTextChannel = str;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.programOriginAppId = str;
    }

    public final void l(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wxAppId = str;
    }
}
