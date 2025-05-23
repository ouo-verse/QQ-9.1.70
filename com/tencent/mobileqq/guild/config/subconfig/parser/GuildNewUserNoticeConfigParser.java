package com.tencent.mobileqq.guild.config.subconfig.parser;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u0006B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildNewUserNoticeConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildNewUserNoticeConfigParser$b;", "", "content", "c", "b", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNewUserNoticeConfigParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0011B/\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildNewUserNoticeConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "d", "I", "getNoticeInterval", "()I", "noticeInterval", "e", "getMinInterval", "minInterval", "f", "getMaxInterval", "maxInterval", "", tl.h.F, "Z", "a", "()Z", "needShow", "<init>", "(IIIZ)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IConfigData {

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int noticeInterval;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int minInterval;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int maxInterval;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean needShow;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildNewUserNoticeConfigParser$b$a;", "", "", "content", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildNewUserNoticeConfigParser$b;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.config.subconfig.parser.GuildNewUserNoticeConfigParser$b$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final b a(@Nullable String content) {
                boolean z16;
                if (content != null && content.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    return new b(0, 0, 0, false, 15, null);
                }
                try {
                    JSONObject jSONObject = new JSONObject(content);
                    if (jSONObject.has("GuildNotfiyGuideNeedShow")) {
                        Logger logger = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            logger.d().d("GuildNewUserNoticeConfigParser.Config", 2, "content: " + content);
                        }
                        return new b(jSONObject.optInt("ChannelMsgNoticeInterval"), jSONObject.optInt("GuildChannelListMsgNoticeMinInterval"), jSONObject.optInt("GuildChannelListMsgNoticeMaxInterval"), jSONObject.optBoolean("GuildNotfiyGuideNeedShow"));
                    }
                    return new b(0, 0, 0, false, 15, null);
                } catch (JSONException e16) {
                    QLog.e("GuildNewUserNoticeConfigParser.Config", 1, "error parse GuildNewUserNoticeConfigParser content:" + content, e16);
                    return new b(0, 0, 0, false, 15, null);
                }
            }

            Companion() {
            }
        }

        public b() {
            this(0, 0, 0, false, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getNeedShow() {
            return this.needShow;
        }

        public b(int i3, int i16, int i17, boolean z16) {
            this.noticeInterval = i3;
            this.minInterval = i16;
            this.maxInterval = i17;
            this.needShow = z16;
        }

        public /* synthetic */ b(int i3, int i16, int i17, boolean z16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? 0 : i16, (i18 & 4) != 0 ? 0 : i17, (i18 & 8) != 0 ? false : z16);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b(0, 0, 0, false, 15, null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        b.Companion companion = b.INSTANCE;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return companion.a(new String(content, UTF_8));
    }
}
