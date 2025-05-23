package com.tencent.luggage.wxa.mk;

import com.tencent.luggage.wxa.bk.h;
import com.tencent.luggage.wxa.eo.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016JP\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/luggage/wxa/mk/b;", "Lcom/tencent/luggage/wxa/eo/d;", "Lcom/tencent/luggage/wxa/bk/h;", "", "appId", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "pagePath", "sessionBuffer", "a", "b", "", "action", "type", "coType", "path", "query", "sessionId", "scene", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class b extends d implements h {
    @Override // com.tencent.luggage.wxa.bk.h
    public void a(int action, int type, int coType, String appId, String path, String query, String sessionId, int scene) {
    }

    @Override // com.tencent.luggage.wxa.bk.h
    public void b(String appId, String pagePath, String sessionBuffer) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(pagePath, "pagePath");
        Intrinsics.checkNotNullParameter(sessionBuffer, "sessionBuffer");
    }

    @Override // com.tencent.luggage.wxa.bk.h
    public void k(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
    }

    @Override // com.tencent.luggage.wxa.bk.h
    public void m(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
    }

    @Override // com.tencent.luggage.wxa.bk.h
    public void a(String appId, String pagePath, String sessionBuffer) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(pagePath, "pagePath");
        Intrinsics.checkNotNullParameter(sessionBuffer, "sessionBuffer");
    }
}
