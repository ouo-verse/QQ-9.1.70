package com.tencent.sqshow.zootopia.samestyle.mix.helper;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tb4.StageProgress;
import tb4.StageProgressConfig;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/l;", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/d;", "", "i", "Ltb4/e;", "l", DomainData.DOMAIN_NAME, "o", "", "progress", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lsb4/a;", "D", "Lsb4/a;", "previewPage", "Ltb4/b;", "E", "Ltb4/b;", "progressGenerator", "", UserInfo.SEX_FEMALE, "J", WadlProxyConsts.LAST_UPDATE_TIME, "<init>", "(Lsb4/a;)V", "G", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l extends d {

    /* renamed from: D, reason: from kotlin metadata */
    private final sb4.a previewPage;

    /* renamed from: E, reason: from kotlin metadata */
    private tb4.b progressGenerator;

    /* renamed from: F, reason: from kotlin metadata */
    private long lastUpdateTime;

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.d
    public void i() {
        super.i();
        this.progressGenerator.d();
    }

    public final void n(tb4.e l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.progressGenerator.c(l3);
    }

    public final void o() {
        this.progressGenerator.f();
    }

    public final void p(int progress) {
        QLog.i("PreviewMakeProgressHelper_", 1, "updateDownloadProgress progress:" + progress);
        this.progressGenerator.h(new StageProgress(0, progress));
        if (progress == 100) {
            q(0);
        }
    }

    public final void q(int progress) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.lastUpdateTime;
        if (progress == 100 || j3 >= 500) {
            QLog.i("PreviewMakeProgressHelper_", 1, "updateMakeProgress progress:" + progress);
            this.progressGenerator.h(new StageProgress(1, progress));
            this.lastUpdateTime = currentTimeMillis;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(sb4.a previewPage) {
        super(previewPage.getF372926a(), previewPage.getF372927b(), previewPage.getF372928c(), previewPage.getF372929d(), previewPage.b(), previewPage.getLifecycleOwner(), previewPage.getSource());
        List listOf;
        Intrinsics.checkNotNullParameter(previewPage, "previewPage");
        this.previewPage = previewPage;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new StageProgressConfig[]{new StageProgressConfig(0, 0, 50, 60000L), new StageProgressConfig(1, 50, 100, 60000L)});
        this.progressGenerator = new tb4.b(listOf);
    }
}
