package com.tencent.mobileqq.qqecommerce.base.config.united;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\nB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/config/united/ECUnitedConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/qqecommerce/base/config/united/ECUnitedConfigParser$b;", "", "version", "", "onSend", "", "content", "d", "b", DownloadInfo.spKey_Config, "c", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECUnitedConfigParser extends BaseConfigParser<b> {
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("ECUnitedConfigParser", 1, "parse config");
        b bVar = new b();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            bVar.b(new String(content, UTF_8));
            QLog.d("ECUnitedConfigParser", 1, "config: " + bVar.a());
        } else {
            QLog.d("ECUnitedConfigParser", 1, "parse empty content");
        }
        return bVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        QLog.d("ECUnitedConfigParser", 1, "onSend version: ", version);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/config/united/ECUnitedConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "jsonString", "Lorg/json/JSONObject;", "c", "content", "", "b", "", "d", "Ljava/util/Map;", "a", "()Ljava/util/Map;", DownloadInfo.spKey_Config, "<init>", "()V", "e", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Map<String, String> config = new LinkedHashMap();

        public final Map<String, String> a() {
            return this.config;
        }

        public final void b(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            JSONObject c16 = c(content);
            Iterator keys = c16.keys();
            while (keys.hasNext()) {
                Object next = keys.next();
                Object opt = c16.opt(String.valueOf(next));
                if (opt != null) {
                    this.config.put(String.valueOf(next), opt.toString());
                }
            }
        }

        private final JSONObject c(String jsonString) {
            if (jsonString == null || jsonString.length() == 0) {
                return new JSONObject();
            }
            try {
                return new JSONObject(jsonString);
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        QLog.d("ECUnitedConfigParser", 1, "get defaultConfig");
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(b config) {
        QLog.d("ECUnitedConfigParser", 1, "doOnConfigUpdate");
    }
}
