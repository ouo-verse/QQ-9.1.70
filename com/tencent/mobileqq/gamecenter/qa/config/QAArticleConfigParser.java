package com.tencent.mobileqq.gamecenter.qa.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import ud1.g;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\nB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/config/QAArticleConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/gamecenter/qa/config/QAArticleConfigParser$b;", "", "version", "", "onSend", "", "content", "d", "b", DownloadInfo.spKey_Config, "c", "<init>", "()V", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QAArticleConfigParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/config/QAArticleConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "b", "Lud1/g;", "d", "Lud1/g;", "a", "()Lud1/g;", "setConfig", "(Lud1/g;)V", DownloadInfo.spKey_Config, "<init>", "()V", "e", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private g config;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final g getConfig() {
            return this.config;
        }

        public final void b(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            QLog.d("QAArticleConfigParser.Config", 1, "parse config: " + content);
            try {
                JSONArray optJSONArray = new JSONObject(content).optJSONArray("qaArticleConfig");
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "configJson.optJSONArray(CONFIG_QA_ARTICLE)");
                g gVar = new g();
                gVar.b(optJSONArray);
                this.config = gVar;
            } catch (Exception e16) {
                QLog.e("QAArticleConfigParser.Config", 1, "parse error:", e16);
            }
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        QLog.d("QAArticleConfigParser", 1, "get defaultConfig");
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable b config) {
        QLog.d("QAArticleConfigParser", 1, "doOnConfigUpdate");
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        b bVar = new b();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            bVar.b(new String(content, UTF_8));
            QLog.d("QAArticleConfigParser", 1, "parse, config: " + bVar.getConfig());
        } else {
            QLog.d("QAArticleConfigParser", 1, "parse empty content");
        }
        return bVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        QLog.d("QAArticleConfigParser", 1, "onSend version: ", version);
    }
}
