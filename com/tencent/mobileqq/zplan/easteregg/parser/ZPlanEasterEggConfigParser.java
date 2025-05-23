package com.tencent.mobileqq.zplan.easteregg.parser;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aio.IZPlanHeadEffectUtil;
import com.tencent.mobileqq.zplan.easteregg.EasterEggPagConfigRepo;
import com.tencent.qphone.base.util.QLog;
import gh3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/parser/ZPlanEasterEggConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lgh3/a;", "", "content", "c", "b", "", "success", "", "onCdnDownload", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEasterEggConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a("{}");
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(byte[] content) {
        String str;
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            JSONObject optJSONObject = new JSONObject(new String(content, Charsets.UTF_8)).optJSONObject("EasterEggInfo");
            if (optJSONObject == null || (str = optJSONObject.toString()) == null) {
                str = "{}";
            }
            return new a(str);
        } catch (Exception e16) {
            QLog.e("ZPlanEasterEggConfigParser", 1, "parse error", e16);
            return defaultConfig();
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        QLog.i("ZPlanEasterEggConfigParser", 1, "onCdnDownload success:" + success);
        if (!((IZPlanHeadEffectUtil) QRoute.api(IZPlanHeadEffectUtil.class)).enable("aio") && !((IZPlanHeadEffectUtil) QRoute.api(IZPlanHeadEffectUtil.class)).enable(RecentUser.TABLE_NAME)) {
            EasterEggPagConfigRepo.f332820a.g();
        } else {
            EasterEggPagConfigRepo.f332820a.s();
        }
    }
}
