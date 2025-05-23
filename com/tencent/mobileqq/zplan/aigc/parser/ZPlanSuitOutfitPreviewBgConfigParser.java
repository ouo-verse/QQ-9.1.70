package com.tencent.mobileqq.zplan.aigc.parser;

import com.google.gson.JsonSyntaxException;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.aigc.data.SuitOutfitPreviewBgUrlConfig;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u0006B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/parser/ZPlanSuitOutfitPreviewBgConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/zplan/aigc/parser/ZPlanSuitOutfitPreviewBgConfigParser$b;", "", "content", "c", "b", "", "success", "", "onCdnDownload", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanSuitOutfitPreviewBgConfigParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002R\u0017\u0010\t\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/parser/ZPlanSuitOutfitPreviewBgConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "Lcom/tencent/mobileqq/zplan/aigc/data/SuitOutfitPreviewBgUrlConfig;", "b", "d", "Lcom/tencent/mobileqq/zplan/aigc/data/SuitOutfitPreviewBgUrlConfig;", "a", "()Lcom/tencent/mobileqq/zplan/aigc/data/SuitOutfitPreviewBgUrlConfig;", "outfitBgUrlConfig", "content", "<init>", "([B)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final SuitOutfitPreviewBgUrlConfig outfitBgUrlConfig;

        public b(byte[] bArr) {
            SuitOutfitPreviewBgUrlConfig b16;
            this.outfitBgUrlConfig = (bArr == null || (b16 = b(bArr)) == null) ? new SuitOutfitPreviewBgUrlConfig() : b16;
        }

        private final SuitOutfitPreviewBgUrlConfig b(byte[] bArr) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            try {
                Object fromJson = DataConvertUtil.f329546a.a().fromJson(new String(bArr, UTF_8), (Class<Object>) SuitOutfitPreviewBgUrlConfig.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                DataCo\u2026class.java)\n            }");
                return (SuitOutfitPreviewBgUrlConfig) fromJson;
            } catch (JsonSyntaxException e16) {
                QLog.e("ZPlanSuitOutfitPreviewBgConfigParser_Config", 1, "parse fail. ", e16);
                return new SuitOutfitPreviewBgUrlConfig();
            }
        }

        /* renamed from: a, reason: from getter */
        public final SuitOutfitPreviewBgUrlConfig getOutfitBgUrlConfig() {
            return this.outfitBgUrlConfig;
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b(null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new b(content);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        QLog.i("ZPlanSuitOutfitPreviewBgConfigParser", 1, "onCdnDownload success:" + success);
    }
}
