package com.tencent.mobileqq.zplan.proxy.filament.parser;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.freesia.NetworkResult;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.common.utils.GsonUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0006B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/filament/parser/ZPlanUrlTemplateConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/zplan/proxy/filament/parser/ZPlanUrlTemplateConfigParser$b;", "", "content", "d", "b", DownloadInfo.spKey_Config, "", "c", "", "version", "onSend", "", "success", "onReceive", "Lcom/tencent/freesia/NetworkResult;", "result", "onReceiveNotUpdate", "onRemoved", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanUrlTemplateConfigParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0001\bB\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/filament/parser/ZPlanUrlTemplateConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "data", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "b", "d", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "a", "()Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "content", "<init>", "([B)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final FilamentUrlTemplate urlTemplate;

        public b(byte[] bArr) {
            this.urlTemplate = b(bArr);
        }

        private final FilamentUrlTemplate b(byte[] data) {
            if (data == null) {
                QLog.w("ZPlanUrlTemplateConfigParser.Config", 1, "parse config, data null, use default, version:2");
                return new FilamentUrlTemplate("2");
            }
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            String str = new String(data, UTF_8);
            QLog.e("ZPlanUrlTemplateConfigParser.Config", 1, "parse config, data:" + str);
            try {
                Object fromJson = GsonUtil.f385283b.a().fromJson(str, (Class<Object>) FilamentUrlTemplate.class);
                ((FilamentUrlTemplate) fromJson).setRawString(str);
                Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                GsonUt\u2026          }\n            }");
                return (FilamentUrlTemplate) fromJson;
            } catch (JsonSyntaxException e16) {
                QLog.e("ZPlanUrlTemplateConfigParser.Config", 1, "parse fail. use default, version:2", e16);
                return new FilamentUrlTemplate("2");
            }
        }

        /* renamed from: a, reason: from getter */
        public final FilamentUrlTemplate getUrlTemplate() {
            return this.urlTemplate;
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
        QLog.i("ZPlanUrlTemplateConfigParser", 1, "doOnConfigUpdate config:" + (config != null ? config.getUrlTemplate() : null));
        if (!TextUtils.isEmpty(j74.b.e(j74.b.f409622a, null, 1, null))) {
            QLog.i("ZPlanUrlTemplateConfigParser", 1, "there is debug urlTemplate");
        } else if (config != null) {
            FilamentFeatureUtil.f106409g.I(config.getUrlTemplate());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new b(content);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceive(boolean success) {
        super.onReceive(success);
        QLog.i("ZPlanUrlTemplateConfigParser", 1, "onReceive success:" + success);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceiveNotUpdate(NetworkResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        super.onReceiveNotUpdate(result);
        QLog.i("ZPlanUrlTemplateConfigParser", 1, "onReceiveNotUpdate result:" + result);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onRemoved() {
        super.onRemoved();
        QLog.i("ZPlanUrlTemplateConfigParser", 1, "onRemoved");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        super.onSend(version);
        QLog.i("ZPlanUrlTemplateConfigParser", 1, "onSend version:" + version);
    }
}
