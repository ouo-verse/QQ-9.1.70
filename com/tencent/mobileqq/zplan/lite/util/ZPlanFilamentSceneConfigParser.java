package com.tencent.mobileqq.zplan.lite.util;

import com.google.gson.JsonSyntaxException;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.model.z;
import com.tencent.zplan.common.utils.GsonUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\f\u0006B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/util/ZPlanFilamentSceneConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/zplan/lite/util/ZPlanFilamentSceneConfigParser$b;", "", "content", "d", "b", DownloadInfo.spKey_Config, "", "c", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFilamentSceneConfigParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002R\u0017\u0010\t\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/util/ZPlanFilamentSceneConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "Lcom/tencent/sqshow/utils/featureswitch/model/z;", "b", "d", "Lcom/tencent/sqshow/utils/featureswitch/model/z;", "a", "()Lcom/tencent/sqshow/utils/featureswitch/model/z;", "sceneCfg", "content", "<init>", "([B)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final z sceneCfg;

        public b(byte[] bArr) {
            z b16;
            this.sceneCfg = (bArr == null || (b16 = b(bArr)) == null) ? new z() : b16;
        }

        private final z b(byte[] bArr) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            try {
                Object fromJson = GsonUtil.f385283b.a().fromJson(new String(bArr, UTF_8), (Class<Object>) z.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                GsonUt\u2026class.java)\n            }");
                return (z) fromJson;
            } catch (JsonSyntaxException e16) {
                QLog.e("ZPlanFilamentSceneConfigParser_Config", 1, "parse fail. ", e16);
                return new z();
            }
        }

        /* renamed from: a, reason: from getter */
        public final z getSceneCfg() {
            return this.sceneCfg;
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(b config) {
        super.doOnConfigUpdate(config);
        QLog.i("ZPlanFilamentSceneConfigParser", 1, "doOnConfigUpdate config:" + (config != null ? config.getSceneCfg() : null));
        if (config != null) {
            e.f333809a.p(config.getSceneCfg());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new b(content);
    }
}
