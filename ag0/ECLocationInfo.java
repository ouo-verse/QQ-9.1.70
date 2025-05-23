package ag0;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00100\u001a\u00020,\u0012\u0006\u00102\u001a\u00020,\u0012\u0006\u00107\u001a\u000203\u00a2\u0006\u0004\b8\u00109J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u001b\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b!\u0010\u000eR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b \u0010\f\"\u0004\b#\u0010\u000eR(\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010'\u001a\u0004\b\u001a\u0010(\"\u0004\b)\u0010*R\u0017\u00100\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b.\u0010/R\u0017\u00102\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b!\u0010-\u001a\u0004\b1\u0010/R\u0017\u00107\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b\r\u00104\u001a\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lag0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "name", "b", "getAddress", h.F, "address", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "nation", "f", "o", "province", "e", "i", "city", "getCityCode", "j", b8.a.CITYCODE, "g", "k", "district", "p", "street", "", "Lag0/b;", "Ljava/util/List;", "()Ljava/util/List;", DomainData.DOMAIN_NAME, "(Ljava/util/List;)V", PoiListCacheRecord.POILIST, "", "D", "getLatitude", "()D", "latitude", "getLongitude", "longitude", "", UserInfo.SEX_FEMALE, "getAccuracy", "()F", "accuracy", "<init>", "(DDF)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: ag0.a, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECLocationInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String name = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String address = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String nation = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String province = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String city = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String cityCode = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String district = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String street = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<ECPoi> poiList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final double latitude;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final double longitude;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final float accuracy;

    public ECLocationInfo(double d16, double d17, float f16) {
        List<ECPoi> emptyList;
        this.latitude = d16;
        this.longitude = d17;
        this.accuracy = f16;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.poiList = emptyList;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getNation() {
        return this.nation;
    }

    @NotNull
    public final List<ECPoi> e() {
        return this.poiList;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECLocationInfo) {
                ECLocationInfo eCLocationInfo = (ECLocationInfo) other;
                if (Double.compare(this.latitude, eCLocationInfo.latitude) != 0 || Double.compare(this.longitude, eCLocationInfo.longitude) != 0 || Float.compare(this.accuracy, eCLocationInfo.accuracy) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getStreet() {
        return this.street;
    }

    public final void h(@NotNull String str) {
        this.address = str;
    }

    public int hashCode() {
        return (((com.tencent.biz.qqcircle.comment.recpic.a.a(this.latitude) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.longitude)) * 31) + Float.floatToIntBits(this.accuracy);
    }

    public final void i(@NotNull String str) {
        this.city = str;
    }

    public final void j(@NotNull String str) {
        this.cityCode = str;
    }

    public final void k(@NotNull String str) {
        this.district = str;
    }

    public final void l(@NotNull String str) {
        this.name = str;
    }

    public final void m(@NotNull String str) {
        this.nation = str;
    }

    public final void n(@NotNull List<ECPoi> list) {
        this.poiList = list;
    }

    public final void o(@NotNull String str) {
        this.province = str;
    }

    public final void p(@NotNull String str) {
        this.street = str;
    }

    @NotNull
    public String toString() {
        return "ECLocationInfo(latitude=" + this.latitude + ", longitude=" + this.longitude + ", accuracy=" + this.accuracy + ")";
    }
}
