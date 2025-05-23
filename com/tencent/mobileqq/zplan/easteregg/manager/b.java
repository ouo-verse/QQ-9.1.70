package com.tencent.mobileqq.zplan.easteregg.manager;

import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.asyntask.AsynTaskHandler;
import com.tencent.mobileqq.zplan.easteregg.model.EasterEggBgParam;
import com.tencent.mobileqq.zplan.easteregg.model.EasterEggBgResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0002H\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/manager/b;", "Lcom/tencent/mobileqq/zplan/easteregg/asyntask/AsynTaskHandler;", "Lcom/tencent/mobileqq/zplan/easteregg/model/a;", "Lcom/tencent/mobileqq/zplan/easteregg/model/b;", "param", "Lcom/tencent/mobileqq/zplan/easteregg/asyntask/a;", "listener", "", tl.h.F, "", "g", "<init>", "()V", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b extends AsynTaskHandler<EasterEggBgParam, EasterEggBgResult> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zplan.easteregg.asyntask.AsynTaskHandler
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public String c(EasterEggBgParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return param.getBgUrl() + "EasterEggBackgroundManagerV2";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zplan.easteregg.asyntask.AsynTaskHandler
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void f(EasterEggBgParam param, com.tencent.mobileqq.zplan.easteregg.asyntask.a<EasterEggBgResult> listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        boolean z16 = true;
        if (param.getBgUrl().length() == 0) {
            listener.onResult(new EasterEggBgResult(-5001, null, 0L, null, null, 30, null));
            return;
        }
        String localPath = AbsDownloader.getFilePath(param.getBgUrl());
        if (localPath != null && localPath.length() != 0) {
            z16 = false;
        }
        if (z16) {
            listener.onResult(new EasterEggBgResult(-5001, null, 0L, null, null, 30, null));
            return;
        }
        PortraitSource portraitSource = PortraitSource.LOCAL;
        long uin = param.getUin();
        Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
        listener.onResult(new EasterEggBgResult(0, portraitSource, uin, localPath, null, 16, null));
    }
}
