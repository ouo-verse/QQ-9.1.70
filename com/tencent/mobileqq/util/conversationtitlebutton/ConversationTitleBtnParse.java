package com.tencent.mobileqq.util.conversationtitlebutton;

import android.text.TextUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/ConversationTitleBtnParse;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/b;", "b", "", "content", "d", "", "onRemoved", DownloadInfo.spKey_Config, "c", "<init>", "()V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ConversationTitleBtnParse extends BaseConfigParser<b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002R\u0014\u0010\f\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/ConversationTitleBtnParse$a;", "", "Lorg/json/JSONObject;", "jsonObj", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "f", "", "e", "Lcom/tencent/mobileqq/util/conversationtitlebutton/b;", "configList", "", "d", "GROUP", "Ljava/lang/String;", "TAG", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnParse$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
                TitleButtonProcessorManager.INSTANCE.a().p();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ConversationTitleBtnConfig f(JSONObject jsonObj) {
            String businessTag = jsonObj.optString("businessTag", "");
            int optInt = jsonObj.optInt("redDotSet", -1);
            int optInt2 = jsonObj.optInt("redDotAppId", -1);
            int optInt3 = jsonObj.optInt("tipsSet", -1);
            int optInt4 = jsonObj.optInt("tipsAppId", -1);
            jsonObj.optString("tipsText", "");
            String iconUrl = jsonObj.optString("iconUrl", "");
            String jumpUrl = jsonObj.optString(WadlProxyConsts.KEY_JUMP_URL, "");
            String accessibilityLabel = jsonObj.optString(NodeProps.PROP_ACCESSIBILITY_LABEL, "");
            Intrinsics.checkNotNullExpressionValue(businessTag, "businessTag");
            Intrinsics.checkNotNullExpressionValue(iconUrl, "iconUrl");
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
            Intrinsics.checkNotNullExpressionValue(accessibilityLabel, "accessibilityLabel");
            return new ConversationTitleBtnConfig(businessTag, optInt, optInt2, optInt3, optInt4, iconUrl, jumpUrl, accessibilityLabel);
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d(b configList) {
            if (configList == null) {
                return "(null)";
            }
            StringBuilder sb5 = new StringBuilder();
            for (ConversationTitleBtnConfig conversationTitleBtnConfig : configList.a()) {
                sb5.append("{tag=" + conversationTitleBtnConfig.getBusinessId() + ",desc=" + conversationTitleBtnConfig.getAccessibilityLabel() + "};");
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply {\n\u2026\n            }.toString()");
            return sb6;
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(b config) {
        super.doOnConfigUpdate(config);
        Companion companion = INSTANCE;
        QLog.i("ConversationTitleBtnParse", 1, "[doOnConfigUpdate] config=" + companion.d(config));
        if (config == null || !(!config.a().isEmpty())) {
            return;
        }
        companion.e();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        if (TextUtils.isEmpty(str)) {
            return defaultConfig();
        }
        b bVar = new b();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(Constants.Configs.CONFIGS);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = jSONArray.get(i3);
                if (obj instanceof JSONObject) {
                    ConversationTitleBtnConfig f16 = INSTANCE.f((JSONObject) obj);
                    if (!f16.i()) {
                        QLog.i("ConversationTitleBtnParse", 1, "[parse] invalid config, config=" + f16);
                    } else {
                        bVar.a().add(f16);
                    }
                }
            }
            QLog.i("ConversationTitleBtnParse", 1, "[parse] config=" + bVar.a());
            return bVar;
        } catch (Exception e16) {
            QLog.e("ConversationTitleBtnParse", 1, "[parse] error", e16);
            return defaultConfig();
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onRemoved() {
        QLog.i("ConversationTitleBtnParse", 1, "[doOnConfigUpdate] onRemoved");
        INSTANCE.e();
    }
}
