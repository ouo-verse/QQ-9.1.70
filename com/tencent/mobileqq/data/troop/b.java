package com.tencent.mobileqq.data.troop;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.GroupGeoInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGeoInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupModifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupModifyInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolInfoFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bH\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR(\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0014\u0010\b\"\u0004\b\u001c\u0010\u001aR.\u0010%\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R.\u0010(\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\b\u001a\u0004\b'\u0010\n\"\u0004\b&\u0010\u001aR:\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R.\u00105\u001a\u0004\u0018\u0001002\b\u0010\u0017\u001a\u0004\u0018\u0001008\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b\u0007\u00103\"\u0004\b\u001f\u00104R.\u00108\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010 \u001a\u0004\b\u0012\u0010\"\"\u0004\b7\u0010$R.\u0010:\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010 \u001a\u0004\b\u0018\u0010\"\"\u0004\b9\u0010$R.\u0010=\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010 \u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$R.\u0010?\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\b\u001a\u0004\b>\u0010\n\"\u0004\b1\u0010\u001aR.\u0010B\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\b\u001a\u0004\b@\u0010\n\"\u0004\bA\u0010\u001aR.\u0010E\u001a\u0004\u0018\u0001002\b\u0010\u0017\u001a\u0004\u0018\u0001008\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u00102\u001a\u0004\bD\u00103\"\u0004\b6\u00104R.\u0010G\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\b\u001a\u0004\bF\u0010\n\"\u0004\bC\u0010\u001a\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/data/troop/b;", "", "", "memo", "", ReportConstant.COSTREPORT_PREFIX, "toString", "a", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfoFilter;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfoFilter;", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfoFilter;", "filter", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfo;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfo;", "e", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfo;", "modifyInfo", "value", "d", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "richFingerMemo", h.F, "fingerMemo", "", "f", "Ljava/lang/Long;", "getTroopClassExt", "()Ljava/lang/Long;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/Long;)V", "troopClassExt", "g", "getClassText", "classText", "", "Ljava/util/List;", "getTroopTags", "()Ljava/util/List;", "r", "(Ljava/util/List;)V", "troopTags", "", "i", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "cityId", "j", "k", QCircleSchemeAttr.Polymerize.LAT, "l", "lon", "getPoiId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "poiId", "getGeoContent", "geoContent", "getSchoolLocation", "p", "schoolLocation", "o", "getGrade", "grade", "getSchool", "school", "<init>", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupModifyInfoFilter filter = new GroupModifyInfoFilter();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupModifyInfo modifyInfo = new GroupModifyInfo();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String richFingerMemo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String fingerMemo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long troopClassExt;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String classText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> troopTags;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer cityId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long lat;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long lon;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long poiId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String geoContent;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String schoolLocation;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer grade;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String school;

    public b(@Nullable String str) {
        this.troopUin = str;
    }

    private final void h(String str) {
        int i3;
        this.fingerMemo = str;
        GroupModifyInfoFilter groupModifyInfoFilter = this.filter;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupModifyInfoFilter.fingerMemo = i3;
        this.modifyInfo.fingerMemo = str;
    }

    private final void n(String str) {
        int i3;
        this.richFingerMemo = str;
        GroupModifyInfoFilter groupModifyInfoFilter = this.filter;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupModifyInfoFilter.richFingerMemo = i3;
        this.modifyInfo.richFingerMemo = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getCityId() {
        return this.cityId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final GroupModifyInfoFilter getFilter() {
        return this.filter;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Long getLat() {
        return this.lat;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Long getLon() {
        return this.lon;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final GroupModifyInfo getModifyInfo() {
        return this.modifyInfo;
    }

    public final void f(@Nullable Integer num) {
        int i3;
        this.cityId = num;
        GroupGeoInfoFilter groupGeoInfoFilter = this.filter.groupGeoInfo;
        int i16 = 0;
        if (num == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupGeoInfoFilter.cityId = i3;
        GroupGeoInfo groupGeoInfo = this.modifyInfo.groupGeoInfo;
        if (num != null) {
            i16 = num.intValue();
        }
        groupGeoInfo.setCityId(i16);
    }

    public final void g(@Nullable String str) {
        int i3;
        this.classText = str;
        GroupModifyInfoFilter groupModifyInfoFilter = this.filter;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupModifyInfoFilter.classText = i3;
        GroupModifyInfo groupModifyInfo = this.modifyInfo;
        if (str == null) {
            str = "";
        }
        groupModifyInfo.classText = str;
    }

    public final void i(@Nullable String str) {
        int i3;
        this.geoContent = str;
        GroupGeoInfoFilter groupGeoInfoFilter = this.filter.groupGeoInfo;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupGeoInfoFilter.geoContent = i3;
        GroupGeoInfo groupGeoInfo = this.modifyInfo.groupGeoInfo;
        if (str == null) {
            str = "";
        }
        groupGeoInfo.setGeoContent(str);
    }

    public final void j(@Nullable Integer num) {
        int i3;
        this.grade = num;
        GroupSchoolInfoFilter groupSchoolInfoFilter = this.filter.groupSchoolInfo;
        int i16 = 0;
        if (num == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupSchoolInfoFilter.grade = i3;
        GroupSchoolInfo groupSchoolInfo = this.modifyInfo.groupSchoolInfo;
        if (num != null) {
            i16 = num.intValue();
        }
        groupSchoolInfo.grade = i16;
    }

    public final void k(@Nullable Long l3) {
        int i3;
        long j3;
        this.lat = l3;
        GroupGeoInfoFilter groupGeoInfoFilter = this.filter.groupGeoInfo;
        if (l3 == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupGeoInfoFilter.latitude = i3;
        GroupGeoInfo groupGeoInfo = this.modifyInfo.groupGeoInfo;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        groupGeoInfo.setLatitude(j3);
    }

    public final void l(@Nullable Long l3) {
        int i3;
        long j3;
        this.lon = l3;
        GroupGeoInfoFilter groupGeoInfoFilter = this.filter.groupGeoInfo;
        if (l3 == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupGeoInfoFilter.longitude = i3;
        GroupGeoInfo groupGeoInfo = this.modifyInfo.groupGeoInfo;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        groupGeoInfo.setLongitude(j3);
    }

    public final void m(@Nullable Long l3) {
        int i3;
        long j3;
        this.poiId = l3;
        GroupGeoInfoFilter groupGeoInfoFilter = this.filter.groupGeoInfo;
        if (l3 == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupGeoInfoFilter.poiId = i3;
        GroupGeoInfo groupGeoInfo = this.modifyInfo.groupGeoInfo;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        groupGeoInfo.poiId = j3;
    }

    public final void o(@Nullable String str) {
        int i3;
        this.school = str;
        GroupSchoolInfoFilter groupSchoolInfoFilter = this.filter.groupSchoolInfo;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupSchoolInfoFilter.school = i3;
        GroupSchoolInfo groupSchoolInfo = this.modifyInfo.groupSchoolInfo;
        if (str == null) {
            str = "";
        }
        groupSchoolInfo.school = str;
    }

    public final void p(@Nullable String str) {
        int i3;
        this.schoolLocation = str;
        GroupSchoolInfoFilter groupSchoolInfoFilter = this.filter.groupSchoolInfo;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupSchoolInfoFilter.location = i3;
        GroupSchoolInfo groupSchoolInfo = this.modifyInfo.groupSchoolInfo;
        if (str == null) {
            str = "";
        }
        groupSchoolInfo.location = str;
    }

    public final void q(@Nullable Long l3) {
        int i3;
        this.troopClassExt = l3;
        GroupModifyInfoFilter groupModifyInfoFilter = this.filter;
        int i16 = 0;
        if (l3 == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupModifyInfoFilter.classExt = i3;
        GroupModifyInfo groupModifyInfo = this.modifyInfo;
        if (l3 != null) {
            i16 = (int) l3.longValue();
        }
        groupModifyInfo.classExt = i16;
    }

    public final void r(@Nullable List<String> list) {
        int i3;
        this.troopTags = list;
        GroupModifyInfoFilter groupModifyInfoFilter = this.filter;
        if (list == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        groupModifyInfoFilter.tagRecord = i3;
        GroupModifyInfo groupModifyInfo = this.modifyInfo;
        if (list == null) {
            list = new ArrayList<>();
        }
        groupModifyInfo.tagRecord = new ArrayList<>(list);
    }

    public final void s(@Nullable String memo) {
        boolean z16;
        if (memo != null && memo.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            n("");
            h("");
        } else {
            n(com.tencent.mobileqq.troop.util.a.a(memo));
            h(new QQText(memo, 2).toPlainText(false));
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb5;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("troopUin=" + this.troopUin + ", ");
        sb6.append("troopClassExt=" + this.troopClassExt + ", ");
        sb6.append("classText=" + this.classText + ", ");
        if (this.troopTags == null) {
            sb5 = new StringBuilder("null");
        } else {
            sb5 = new StringBuilder("");
        }
        List<String> list = this.troopTags;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(((String) it.next()) + '-');
            }
        }
        sb6.append("richFingerMemo=" + this.richFingerMemo + ", ");
        sb6.append("fingerMemo=" + this.fingerMemo + ", ");
        sb6.append("troopTags=" + ((Object) sb5) + ", ");
        sb6.append("cityId=" + this.cityId + ", ");
        sb6.append("lat=" + this.lat + ", ");
        sb6.append("lon=" + this.lon + ", ");
        sb6.append("poiId=" + this.poiId + ", ");
        sb6.append("geoContent=" + this.geoContent + ", ");
        sb6.append("schoolLocation=" + this.schoolLocation + ", ");
        sb6.append("grade=" + this.grade + ", ");
        sb6.append("school=" + this.school + ", ");
        String sb7 = sb6.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "logStr.toString()");
        return sb7;
    }
}
