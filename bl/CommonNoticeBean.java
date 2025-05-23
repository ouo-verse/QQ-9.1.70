package bl;

import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.tenpay.sdk.util.UinConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lbl/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lbl/f;", "a", "Lbl/f;", "b", "()Lbl/f;", UinConfigManager.KEY_ADS, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "setCommonExt", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;)V", "commonExt", "<init>", "(Lbl/f;Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bl.a, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class CommonNoticeBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final f notice;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private CommonStCommonExt commonExt;

    public CommonNoticeBean(f notice, CommonStCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(notice, "notice");
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        this.notice = notice;
        this.commonExt = commonExt;
    }

    /* renamed from: a, reason: from getter */
    public final CommonStCommonExt getCommonExt() {
        return this.commonExt;
    }

    /* renamed from: b, reason: from getter */
    public final f getNotice() {
        return this.notice;
    }

    public int hashCode() {
        return (this.notice.hashCode() * 31) + this.commonExt.hashCode();
    }

    public String toString() {
        return "CommonNoticeBean(notice=" + this.notice + ", commonExt=" + this.commonExt + ")";
    }

    public /* synthetic */ CommonNoticeBean(f fVar, CommonStCommonExt commonStCommonExt, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar, (i3 & 2) != 0 ? new CommonStCommonExt() : commonStCommonExt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonNoticeBean)) {
            return false;
        }
        CommonNoticeBean commonNoticeBean = (CommonNoticeBean) other;
        return Intrinsics.areEqual(this.notice, commonNoticeBean.notice) && Intrinsics.areEqual(this.commonExt, commonNoticeBean.commonExt);
    }
}
