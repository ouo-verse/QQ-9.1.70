package com.tencent.mobileqq.zootopia.permission.follow.data;

import cooperation.qzone.QzoneIPCModule;
import hu4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0018\u00a2\u0006\u0004\b \u0010!R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/follow/data/a;", "", "Lhu4/g;", "Lcom/tencent/mobileqq/zootopia/permission/follow/data/RequestState;", "a", "Lcom/tencent/mobileqq/zootopia/permission/follow/data/RequestState;", "b", "()Lcom/tencent/mobileqq/zootopia/permission/follow/data/RequestState;", "setRequestState", "(Lcom/tencent/mobileqq/zootopia/permission/follow/data/RequestState;)V", "requestState", "Lhu4/g;", "()Lhu4/g;", "setPrivacyInfo", "(Lhu4/g;)V", "privacyInfo", "", "c", "I", "getResultCode", "()I", "setResultCode", "(I)V", QzoneIPCModule.RESULT_CODE, "", "d", "Ljava/lang/String;", "getResultMsg", "()Ljava/lang/String;", "setResultMsg", "(Ljava/lang/String;)V", "resultMsg", "<init>", "(Lcom/tencent/mobileqq/zootopia/permission/follow/data/RequestState;Lhu4/g;ILjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RequestState requestState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private g privacyInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int resultCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String resultMsg;

    public a(RequestState requestState, g privacyInfo, int i3, String resultMsg) {
        Intrinsics.checkNotNullParameter(requestState, "requestState");
        Intrinsics.checkNotNullParameter(privacyInfo, "privacyInfo");
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        this.requestState = requestState;
        this.privacyInfo = privacyInfo;
        this.resultCode = i3;
        this.resultMsg = resultMsg;
    }

    /* renamed from: a, reason: from getter */
    public final g getPrivacyInfo() {
        return this.privacyInfo;
    }

    /* renamed from: b, reason: from getter */
    public final RequestState getRequestState() {
        return this.requestState;
    }
}
