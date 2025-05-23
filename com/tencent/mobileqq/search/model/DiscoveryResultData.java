package com.tencent.mobileqq.search.model;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u0010\u0010\u001bR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\t\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/search/model/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "f", "()Z", "isSuccess", "", "Lcom/tencent/mobileqq/search/model/SearchEntryDataModel;", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "result", "c", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", IProfileCardConst.KEY_FROM_TYPE, "Lcom/tencent/mobileqq/app/UnifySearchHandler$a;", "Lcom/tencent/mobileqq/app/UnifySearchHandler$a;", "()Lcom/tencent/mobileqq/app/UnifySearchHandler$a;", WadlProxyConsts.EXTRA_DATA, "e", "I", "()I", QzoneIPCModule.RESULT_CODE, "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "<init>", "(ZLjava/util/List;Ljava/lang/Integer;Lcom/tencent/mobileqq/app/UnifySearchHandler$a;ILjava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.model.c, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class DiscoveryResultData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<SearchEntryDataModel> result;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer fromType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final UnifySearchHandler.a extraData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resultCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMsg;

    /* JADX WARN: Multi-variable type inference failed */
    public DiscoveryResultData(boolean z16, @Nullable List<? extends SearchEntryDataModel> list, @Nullable Integer num, @Nullable UnifySearchHandler.a aVar, int i3, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.isSuccess = z16;
        this.result = list;
        this.fromType = num;
        this.extraData = aVar;
        this.resultCode = i3;
        this.errorMsg = errorMsg;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final UnifySearchHandler.a getExtraData() {
        return this.extraData;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getFromType() {
        return this.fromType;
    }

    @Nullable
    public final List<SearchEntryDataModel> d() {
        return this.result;
    }

    /* renamed from: e, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiscoveryResultData)) {
            return false;
        }
        DiscoveryResultData discoveryResultData = (DiscoveryResultData) other;
        if (this.isSuccess == discoveryResultData.isSuccess && Intrinsics.areEqual(this.result, discoveryResultData.result) && Intrinsics.areEqual(this.fromType, discoveryResultData.fromType) && Intrinsics.areEqual(this.extraData, discoveryResultData.extraData) && this.resultCode == discoveryResultData.resultCode && Intrinsics.areEqual(this.errorMsg, discoveryResultData.errorMsg)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        List<SearchEntryDataModel> list = this.result;
        int i16 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        Integer num = this.fromType;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        UnifySearchHandler.a aVar = this.extraData;
        if (aVar != null) {
            i16 = aVar.hashCode();
        }
        return ((((i18 + i16) * 31) + this.resultCode) * 31) + this.errorMsg.hashCode();
    }

    @NotNull
    public String toString() {
        return "DiscoveryResultData(isSuccess=" + this.isSuccess + ", result=" + this.result + ", fromType=" + this.fromType + ", extraData=" + this.extraData + ", resultCode=" + this.resultCode + ", errorMsg=" + this.errorMsg + ")";
    }

    public /* synthetic */ DiscoveryResultData(boolean z16, List list, Integer num, UnifySearchHandler.a aVar, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i16 & 2) != 0 ? null : list, (i16 & 4) != 0 ? null : num, (i16 & 8) == 0 ? aVar : null, (i16 & 16) != 0 ? -1 : i3, (i16 & 32) != 0 ? "" : str);
    }
}
