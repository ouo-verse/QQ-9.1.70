package com.tencent.mobileqq.zplan.easteregg.repository;

import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.model.ErrorMsg;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ResultCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010!\u0012\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u00010(\u00a2\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b\u0011\u0010,\"\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/repository/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ResultCode;", "a", "Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ResultCode;", "()Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ResultCode;", "setCode", "(Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ResultCode;)V", "code", "", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "idList", "d", "setPathList", "(Ljava/util/List;)V", "pathList", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "e", "()Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "setSource", "(Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;)V", "source", "Lcom/tencent/mobileqq/zplan/easteregg/model/e;", "Lcom/tencent/mobileqq/zplan/easteregg/model/e;", "getErrorDetail", "()Lcom/tencent/mobileqq/zplan/easteregg/model/e;", "setErrorDetail", "(Lcom/tencent/mobileqq/zplan/easteregg/model/e;)V", "errorDetail", "Lkotlin/Pair;", "", "f", "Lkotlin/Pair;", "()Lkotlin/Pair;", "setErrorAppearanceInfo", "(Lkotlin/Pair;)V", "ErrorAppearanceInfo", "<init>", "(Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ResultCode;Ljava/util/List;Ljava/util/List;Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;Lcom/tencent/mobileqq/zplan/easteregg/model/e;Lkotlin/Pair;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.easteregg.repository.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ResultData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ResultCode code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<Integer> idList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private List<String> pathList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private PortraitSource source;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private ErrorMsg errorDetail;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private Pair<String, Long> ErrorAppearanceInfo;

    public ResultData(ResultCode code, List<Integer> idList, List<String> list, PortraitSource portraitSource, ErrorMsg errorMsg, Pair<String, Long> pair) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(idList, "idList");
        this.code = code;
        this.idList = idList;
        this.pathList = list;
        this.source = portraitSource;
        this.errorDetail = errorMsg;
        this.ErrorAppearanceInfo = pair;
    }

    /* renamed from: a, reason: from getter */
    public final ResultCode getCode() {
        return this.code;
    }

    public final Pair<String, Long> b() {
        return this.ErrorAppearanceInfo;
    }

    public final List<Integer> c() {
        return this.idList;
    }

    public final List<String> d() {
        return this.pathList;
    }

    /* renamed from: e, reason: from getter */
    public final PortraitSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int hashCode = ((this.code.hashCode() * 31) + this.idList.hashCode()) * 31;
        List<String> list = this.pathList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        PortraitSource portraitSource = this.source;
        int hashCode3 = (hashCode2 + (portraitSource == null ? 0 : portraitSource.hashCode())) * 31;
        ErrorMsg errorMsg = this.errorDetail;
        int hashCode4 = (hashCode3 + (errorMsg == null ? 0 : errorMsg.hashCode())) * 31;
        Pair<String, Long> pair = this.ErrorAppearanceInfo;
        return hashCode4 + (pair != null ? pair.hashCode() : 0);
    }

    public String toString() {
        return "ResultData(code=" + this.code + ", idList=" + this.idList + ", pathList=" + this.pathList + ", source=" + this.source + ", errorDetail=" + this.errorDetail + ", ErrorAppearanceInfo=" + this.ErrorAppearanceInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultData)) {
            return false;
        }
        ResultData resultData = (ResultData) other;
        return this.code == resultData.code && Intrinsics.areEqual(this.idList, resultData.idList) && Intrinsics.areEqual(this.pathList, resultData.pathList) && this.source == resultData.source && Intrinsics.areEqual(this.errorDetail, resultData.errorDetail) && Intrinsics.areEqual(this.ErrorAppearanceInfo, resultData.ErrorAppearanceInfo);
    }

    public /* synthetic */ ResultData(ResultCode resultCode, List list, List list2, PortraitSource portraitSource, ErrorMsg errorMsg, Pair pair, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ResultCode.FAIL : resultCode, list, (i3 & 4) != 0 ? null : list2, (i3 & 8) != 0 ? PortraitSource.UNKNOWN : portraitSource, (i3 & 16) != 0 ? null : errorMsg, (i3 & 32) != 0 ? null : pair);
    }
}
