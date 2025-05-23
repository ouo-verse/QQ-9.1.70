package com.tencent.mobileqq.troop.homework.coursemgr.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\u001d\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u00c6\u0003J\u001d\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u00c6\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010,\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0080\u0001\u0010-\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u00c6\u0001\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u00d6\u0003J\t\u00103\u001a\u00020\u000bH\u00d6\u0001J\t\u00104\u001a\u000205H\u00d6\u0001R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseData;", "Ljava/io/Serializable;", "defaultList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "Lkotlin/collections/ArrayList;", "customList", "lastCourse", "courseList", "", "courseId", "", "serverTime", "", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;)V", "getCourseId", "()Ljava/lang/Integer;", "setCourseId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCourseList", "()Ljava/util/List;", "setCourseList", "(Ljava/util/List;)V", "getCustomList", "()Ljava/util/ArrayList;", "setCustomList", "(Ljava/util/ArrayList;)V", "getDefaultList", "setDefaultList", "getLastCourse", "()Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "setLastCourse", "(Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;)V", "getServerTime", "()Ljava/lang/Long;", "setServerTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseData;", "equals", "", "other", "", "hashCode", "toString", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class CourseData implements Serializable {
    static IPatchRedirector $redirector_;

    @Nullable
    private Integer courseId;

    @Nullable
    private List<CourseInfo> courseList;

    @Nullable
    private ArrayList<CourseInfo> customList;

    @Nullable
    private ArrayList<CourseInfo> defaultList;

    @Nullable
    private CourseInfo lastCourse;

    @Nullable
    private Long serverTime;

    public CourseData() {
        this(null, null, null, null, null, null, 63, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            return;
        }
        iPatchRedirector.redirect((short) 25, (Object) this);
    }

    public static /* synthetic */ CourseData copy$default(CourseData courseData, ArrayList arrayList, ArrayList arrayList2, CourseInfo courseInfo, List list, Integer num, Long l3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = courseData.defaultList;
        }
        if ((i3 & 2) != 0) {
            arrayList2 = courseData.customList;
        }
        ArrayList arrayList3 = arrayList2;
        if ((i3 & 4) != 0) {
            courseInfo = courseData.lastCourse;
        }
        CourseInfo courseInfo2 = courseInfo;
        if ((i3 & 8) != 0) {
            list = courseData.courseList;
        }
        List list2 = list;
        if ((i3 & 16) != 0) {
            num = courseData.courseId;
        }
        Integer num2 = num;
        if ((i3 & 32) != 0) {
            l3 = courseData.serverTime;
        }
        return courseData.copy(arrayList, arrayList3, courseInfo2, list2, num2, l3);
    }

    @Nullable
    public final ArrayList<CourseInfo> component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ArrayList) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.defaultList;
    }

    @Nullable
    public final ArrayList<CourseInfo> component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ArrayList) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.customList;
    }

    @Nullable
    public final CourseInfo component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (CourseInfo) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.lastCourse;
    }

    @Nullable
    public final List<CourseInfo> component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.courseList;
    }

    @Nullable
    public final Integer component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Integer) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.courseId;
    }

    @Nullable
    public final Long component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Long) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.serverTime;
    }

    @NotNull
    public final CourseData copy(@Nullable ArrayList<CourseInfo> defaultList, @Nullable ArrayList<CourseInfo> customList, @Nullable CourseInfo lastCourse, @Nullable List<CourseInfo> courseList, @Nullable Integer courseId, @Nullable Long serverTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (CourseData) iPatchRedirector.redirect((short) 21, this, defaultList, customList, lastCourse, courseList, courseId, serverTime);
        }
        return new CourseData(defaultList, customList, lastCourse, courseList, courseId, serverTime);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof CourseData)) {
            return false;
        }
        CourseData courseData = (CourseData) other;
        if (Intrinsics.areEqual(this.defaultList, courseData.defaultList) && Intrinsics.areEqual(this.customList, courseData.customList) && Intrinsics.areEqual(this.lastCourse, courseData.lastCourse) && Intrinsics.areEqual(this.courseList, courseData.courseList) && Intrinsics.areEqual(this.courseId, courseData.courseId) && Intrinsics.areEqual(this.serverTime, courseData.serverTime)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Integer getCourseId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Integer) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.courseId;
    }

    @Nullable
    public final List<CourseInfo> getCourseList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.courseList;
    }

    @Nullable
    public final ArrayList<CourseInfo> getCustomList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.customList;
    }

    @Nullable
    public final ArrayList<CourseInfo> getDefaultList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.defaultList;
    }

    @Nullable
    public final CourseInfo getLastCourse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CourseInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.lastCourse;
    }

    @Nullable
    public final Long getServerTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Long) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.serverTime;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        ArrayList<CourseInfo> arrayList = this.defaultList;
        int i3 = 0;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        int i16 = hashCode * 31;
        ArrayList<CourseInfo> arrayList2 = this.customList;
        if (arrayList2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = arrayList2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        CourseInfo courseInfo = this.lastCourse;
        if (courseInfo == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = courseInfo.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        List<CourseInfo> list = this.courseList;
        if (list == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = list.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Integer num = this.courseId;
        if (num == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        Long l3 = this.serverTime;
        if (l3 != null) {
            i3 = l3.hashCode();
        }
        return i26 + i3;
    }

    public final void setCourseId(@Nullable Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) num);
        } else {
            this.courseId = num;
        }
    }

    public final void setCourseList(@Nullable List<CourseInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
        } else {
            this.courseList = list;
        }
    }

    public final void setCustomList(@Nullable ArrayList<CourseInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
        } else {
            this.customList = arrayList;
        }
    }

    public final void setDefaultList(@Nullable ArrayList<CourseInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        } else {
            this.defaultList = arrayList;
        }
    }

    public final void setLastCourse(@Nullable CourseInfo courseInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) courseInfo);
        } else {
            this.lastCourse = courseInfo;
        }
    }

    public final void setServerTime(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) l3);
        } else {
            this.serverTime = l3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "CourseData(defaultList=" + this.defaultList + ", customList=" + this.customList + ", lastCourse=" + this.lastCourse + ", courseList=" + this.courseList + ", courseId=" + this.courseId + ", serverTime=" + this.serverTime + ")";
    }

    public CourseData(@Nullable ArrayList<CourseInfo> arrayList, @Nullable ArrayList<CourseInfo> arrayList2, @Nullable CourseInfo courseInfo, @Nullable List<CourseInfo> list, @Nullable Integer num, @Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, arrayList, arrayList2, courseInfo, list, num, l3);
            return;
        }
        this.defaultList = arrayList;
        this.customList = arrayList2;
        this.lastCourse = courseInfo;
        this.courseList = list;
        this.courseId = num;
        this.serverTime = l3;
    }

    public /* synthetic */ CourseData(ArrayList arrayList, ArrayList arrayList2, CourseInfo courseInfo, List list, Integer num, Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : arrayList, (i3 & 2) != 0 ? null : arrayList2, (i3 & 4) != 0 ? null : courseInfo, (i3 & 8) != 0 ? null : list, (i3 & 16) != 0 ? null : num, (i3 & 32) != 0 ? null : l3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, arrayList, arrayList2, courseInfo, list, num, l3, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
