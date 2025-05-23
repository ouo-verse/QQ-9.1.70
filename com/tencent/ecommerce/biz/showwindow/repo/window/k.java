package com.tencent.ecommerce.biz.showwindow.repo.window;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 (2\u00020\u0001:\u0001\u0003B[\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012$\b\u0002\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n`\u0012\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010'R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR>\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b$\u0010\b\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "", "", "a", "I", "b", "()I", "setResultType", "(I)V", RemoteProxy.KEY_RESULT_TYPE, "", "Ljava/lang/String;", "()Ljava/lang/String;", "setCause", "(Ljava/lang/String;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "getDetailCause", "()Ljava/util/HashMap;", "setDetailCause", "(Ljava/util/HashMap;)V", "detailCause", "", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/i;", "d", "Ljava/util/List;", "getFailItem", "()Ljava/util/List;", "setFailItem", "(Ljava/util/List;)V", "failItem", "e", "setTotalAddSuccessCount", "totalAddSuccessCount", "<init>", "(ILjava/lang/String;Ljava/util/HashMap;Ljava/util/List;I)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int resultType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String cause;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private HashMap<Long, String> detailCause;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<FailItem> failItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int totalAddSuccessCount;

    public k() {
        this(0, null, null, null, 0, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getCause() {
        return this.cause;
    }

    /* renamed from: b, reason: from getter */
    public final int getResultType() {
        return this.resultType;
    }

    /* renamed from: c, reason: from getter */
    public final int getTotalAddSuccessCount() {
        return this.totalAddSuccessCount;
    }

    public k(int i3, String str, HashMap<Long, String> hashMap, List<FailItem> list, int i16) {
        this.resultType = i3;
        this.cause = str;
        this.detailCause = hashMap;
        this.failItem = list;
        this.totalAddSuccessCount = i16;
    }

    public /* synthetic */ k(int i3, String str, HashMap hashMap, List list, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? new HashMap() : hashMap, (i17 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i17 & 16) != 0 ? 0 : i16);
    }
}
