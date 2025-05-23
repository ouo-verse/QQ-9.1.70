package fl3;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pv4.o;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\u0012\b\b\u0002\u0010 \u001a\u00020\u001d\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020$\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u00101\u001a\u00020\u0007\u0012(\b\u0002\u00106\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u000102j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`3\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001f\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\n\u0010\u001fR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\u0019\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010-\u001a\u0004\u0018\u00010)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b\u000f\u0010,R\u0017\u00101\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b&\u0010.\u001a\u0004\b/\u00100R7\u00106\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u000102j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`38\u0006\u00a2\u0006\f\n\u0004\b/\u00104\u001a\u0004\b*\u00105\u00a8\u00069"}, d2 = {"Lfl3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lpv4/o;", "a", "Lpv4/o;", "f", "()Lpv4/o;", "indexButton", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "c", "e", "defBgColorRes", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "d", "Ljava/lang/Class;", "()Ljava/lang/Class;", "clazz", "Lcom/tencent/sqshow/zootopia/data/ZootopiaDownloadBarType;", "Lcom/tencent/sqshow/zootopia/data/ZootopiaDownloadBarType;", "()Lcom/tencent/sqshow/zootopia/data/ZootopiaDownloadBarType;", "barType", "I", "()I", "cloudModBtnType", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "i", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", h.F, "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "binder", "Z", "j", "()Z", "isReportOutSide", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "<init>", "(Lpv4/o;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lcom/tencent/sqshow/zootopia/data/ZootopiaDownloadBarType;ILcom/tencent/mobileqq/zootopia/ZootopiaSource;Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;ZLjava/util/HashMap;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final o indexButton;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String jumpUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String defBgColorRes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Class<? extends ZootopiaDownloadButton> clazz;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaDownloadBarType barType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int cloudModBtnType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaDownloadButtonBinder binder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean isReportOutSide;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Object> reportParams;

    public a(o oVar, String str, String defBgColorRes, Class<? extends ZootopiaDownloadButton> clazz, ZootopiaDownloadBarType barType, int i3, ZootopiaSource sourceCurrent, ZootopiaDownloadButtonBinder zootopiaDownloadButtonBinder, boolean z16, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(defBgColorRes, "defBgColorRes");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(barType, "barType");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.indexButton = oVar;
        this.jumpUrl = str;
        this.defBgColorRes = defBgColorRes;
        this.clazz = clazz;
        this.barType = barType;
        this.cloudModBtnType = i3;
        this.sourceCurrent = sourceCurrent;
        this.binder = zootopiaDownloadButtonBinder;
        this.isReportOutSide = z16;
        this.reportParams = hashMap;
    }

    /* renamed from: a, reason: from getter */
    public final ZootopiaDownloadBarType getBarType() {
        return this.barType;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaDownloadButtonBinder getBinder() {
        return this.binder;
    }

    public final Class<? extends ZootopiaDownloadButton> c() {
        return this.clazz;
    }

    /* renamed from: d, reason: from getter */
    public final int getCloudModBtnType() {
        return this.cloudModBtnType;
    }

    /* renamed from: e, reason: from getter */
    public final String getDefBgColorRes() {
        return this.defBgColorRes;
    }

    /* renamed from: f, reason: from getter */
    public final o getIndexButton() {
        return this.indexButton;
    }

    /* renamed from: g, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final HashMap<String, Object> h() {
        return this.reportParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        o oVar = this.indexButton;
        int hashCode = (oVar == null ? 0 : oVar.hashCode()) * 31;
        String str = this.jumpUrl;
        int hashCode2 = (((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.defBgColorRes.hashCode()) * 31) + this.clazz.hashCode()) * 31) + this.barType.hashCode()) * 31) + this.cloudModBtnType) * 31) + this.sourceCurrent.hashCode()) * 31;
        ZootopiaDownloadButtonBinder zootopiaDownloadButtonBinder = this.binder;
        int hashCode3 = (hashCode2 + (zootopiaDownloadButtonBinder == null ? 0 : zootopiaDownloadButtonBinder.hashCode())) * 31;
        boolean z16 = this.isReportOutSide;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode3 + i3) * 31;
        HashMap<String, Object> hashMap = this.reportParams;
        return i16 + (hashMap != null ? hashMap.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final ZootopiaSource getSourceCurrent() {
        return this.sourceCurrent;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsReportOutSide() {
        return this.isReportOutSide;
    }

    public String toString() {
        o oVar = this.indexButton;
        Integer valueOf = oVar != null ? Integer.valueOf(oVar.f427645c) : null;
        o oVar2 = this.indexButton;
        return "indexButton " + valueOf + " , " + (oVar2 != null ? oVar2.f427643a : null) + " " + (oVar2 != null ? oVar2.f427644b : null) + ", defBgColorRes " + this.defBgColorRes + " clazz: " + this.clazz.getCanonicalName() + " ";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return Intrinsics.areEqual(this.indexButton, aVar.indexButton) && Intrinsics.areEqual(this.jumpUrl, aVar.jumpUrl) && Intrinsics.areEqual(this.defBgColorRes, aVar.defBgColorRes) && Intrinsics.areEqual(this.clazz, aVar.clazz) && this.barType == aVar.barType && this.cloudModBtnType == aVar.cloudModBtnType && Intrinsics.areEqual(this.sourceCurrent, aVar.sourceCurrent) && Intrinsics.areEqual(this.binder, aVar.binder) && this.isReportOutSide == aVar.isReportOutSide && Intrinsics.areEqual(this.reportParams, aVar.reportParams);
    }

    public /* synthetic */ a(o oVar, String str, String str2, Class cls, ZootopiaDownloadBarType zootopiaDownloadBarType, int i3, ZootopiaSource zootopiaSource, ZootopiaDownloadButtonBinder zootopiaDownloadButtonBinder, boolean z16, HashMap hashMap, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(oVar, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? "#80302F2F" : str2, (i16 & 8) != 0 ? ZootopiaDownloadButton.class : cls, (i16 & 16) != 0 ? ZootopiaDownloadBarType.VIDEO_DOWNLOAD_BAR : zootopiaDownloadBarType, (i16 & 32) != 0 ? 2 : i3, (i16 & 64) != 0 ? ZootopiaSource.INSTANCE.a(Source.UnSet) : zootopiaSource, (i16 & 128) != 0 ? null : zootopiaDownloadButtonBinder, (i16 & 256) != 0 ? true : z16, (i16 & 512) == 0 ? hashMap : null);
    }
}
