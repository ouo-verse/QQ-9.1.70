package com.tencent.mobileqq.zplan.mod.impl.parser;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import si3.a;
import vi3.ModCloudConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/mod/impl/parser/ModCloudConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lvi3/b;", "", "content", "d", DownloadInfo.spKey_Config, "", "c", "b", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModCloudConfigParser extends BaseConfigParser<ModCloudConfig> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ModCloudConfig defaultConfig() {
        return new ModCloudConfig(null, 1, null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ModCloudConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        String jSONObject = CommonExKt.B(content).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "content.toJson().toString()");
        QLog.i("ModCloudConfigParser_", 1, "parse configJson:" + jSONObject);
        ModCloudConfig modCloudConfig = (ModCloudConfig) DataConvertUtil.f329546a.a().fromJson(jSONObject, ModCloudConfig.class);
        QLog.i("ModCloudConfigParser_", 1, "parse modCloudConfig:" + modCloudConfig);
        Intrinsics.checkNotNullExpressionValue(modCloudConfig, "modCloudConfig");
        return modCloudConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(ModCloudConfig config) {
        if (config == null) {
            return;
        }
        ((a) vb3.a.f441346a.b(a.class)).d0("doOnConfigUpdate", config);
    }
}
