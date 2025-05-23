package jc4;

import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\t\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0012\u0010\u001f\u00a8\u0006#"}, d2 = {"Ljc4/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "errorCode", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "errorMsg", "c", "Z", "d", "()Z", "isShowSquare", "", "Ljc4/a;", "Ljava/util/List;", "()Ljava/util/List;", "dataList", "Lcom/tencent/sqshow/zootopia/data/h;", "e", "Lcom/tencent/sqshow/zootopia/data/h;", "()Lcom/tencent/sqshow/zootopia/data/h;", "feedsList", "<init>", "(ILjava/lang/String;ZLjava/util/List;Lcom/tencent/sqshow/zootopia/data/h;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jc4.f, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class UserCenterReqData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String errorMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isShowSquare;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<UserCenterCardData> dataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaDetailFeedsListData feedsList;

    public UserCenterReqData(int i3, String str, boolean z16, List<UserCenterCardData> dataList, ZootopiaDetailFeedsListData zootopiaDetailFeedsListData) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.errorCode = i3;
        this.errorMsg = str;
        this.isShowSquare = z16;
        this.dataList = dataList;
        this.feedsList = zootopiaDetailFeedsListData;
    }

    public final List<UserCenterCardData> a() {
        return this.dataList;
    }

    /* renamed from: b, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: c, reason: from getter */
    public final ZootopiaDetailFeedsListData getFeedsList() {
        return this.feedsList;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsShowSquare() {
        return this.isShowSquare;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.errorCode * 31;
        String str = this.errorMsg;
        int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z16 = this.isShowSquare;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((hashCode + i16) * 31) + this.dataList.hashCode()) * 31;
        ZootopiaDetailFeedsListData zootopiaDetailFeedsListData = this.feedsList;
        return hashCode2 + (zootopiaDetailFeedsListData != null ? zootopiaDetailFeedsListData.hashCode() : 0);
    }

    public String toString() {
        return "UserCenterReqData(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", isShowSquare=" + this.isShowSquare + ", dataList=" + this.dataList + ", feedsList=" + this.feedsList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserCenterReqData)) {
            return false;
        }
        UserCenterReqData userCenterReqData = (UserCenterReqData) other;
        return this.errorCode == userCenterReqData.errorCode && Intrinsics.areEqual(this.errorMsg, userCenterReqData.errorMsg) && this.isShowSquare == userCenterReqData.isShowSquare && Intrinsics.areEqual(this.dataList, userCenterReqData.dataList) && Intrinsics.areEqual(this.feedsList, userCenterReqData.feedsList);
    }
}
