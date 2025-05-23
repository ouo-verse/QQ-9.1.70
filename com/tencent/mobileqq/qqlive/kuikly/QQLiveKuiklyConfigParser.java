package com.tencent.mobileqq.qqlive.kuikly;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/kuikly/QQLiveKuiklyConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/qqlive/kuikly/a;", "b", "", "content", "c", "<init>", "()V", "d", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveKuiklyConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:7:0x003b, B:9:0x0049, B:11:0x004f, B:13:0x0056, B:15:0x005c, B:20:0x0068, B:22:0x0075, B:26:0x0078), top: B:6:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075 A[SYNTHETIC] */
    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a parse(@NotNull byte[] content) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(content, "content");
        a aVar = new a();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(content, UTF_8);
            QLog.i("QQLiveKuiklyConfigParser", 2, "config=" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("bundle_name");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String bundle = optJSONArray.getString(i3);
                        if (bundle != null && bundle.length() != 0) {
                            z17 = false;
                            if (z17) {
                                Set<String> a16 = aVar.a();
                                Intrinsics.checkNotNullExpressionValue(bundle, "bundle");
                                a16.add(bundle);
                            }
                        }
                        z17 = true;
                        if (z17) {
                        }
                    }
                }
                aVar.c(jSONObject.optLong("cooldown", 30000L));
            } catch (Throwable th5) {
                QLog.e("QQLiveKuiklyConfigParser", 1, "parse failed throw:", th5);
            }
        }
        return aVar;
    }
}
