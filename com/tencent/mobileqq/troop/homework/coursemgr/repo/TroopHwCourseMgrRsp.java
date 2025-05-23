package com.tencent.mobileqq.troop.homework.coursemgr.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\tH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;", "Ljava/io/Serializable;", "", "teacherType", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "getDefaultSelectCourseInfo", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseData;", "component1", "component2", "", "component3", "courseData", "msg", "retCode", "copy", "toString", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseData;", "getCourseData", "()Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseData;", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "I", "getRetCode", "()I", "<init>", "(Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseData;Ljava/lang/String;I)V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopHwCourseMgrRsp implements Serializable {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private final CourseData courseData;

    @NotNull
    private final String msg;
    private final int retCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp$a;", "", "Lorg/json/JSONArray;", "jsonArray", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "Lkotlin/collections/ArrayList;", "c", "Lorg/json/JSONObject;", "jsonObject", "b", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.coursemgr.repo.TroopHwCourseMgrRsp$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final CourseInfo b(JSONObject jsonObject) {
            return new CourseInfo(0, null, null, 7, null).parseFromJSONObject(jsonObject);
        }

        private final ArrayList<CourseInfo> c(JSONArray jsonArray) {
            ArrayList<CourseInfo> arrayList = new ArrayList<>();
            int length = jsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jsonArray.optJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "jsonArray.optJSONObject(index)");
                arrayList.add(b(optJSONObject));
            }
            return arrayList;
        }

        @NotNull
        public final TroopHwCourseMgrRsp a(@NotNull JSONObject jsonObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopHwCourseMgrRsp) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonObject);
            }
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            CourseData courseData = new CourseData(null, null, null, null, null, null, 63, null);
            String msg2 = jsonObject.optString("msg", "");
            int optInt = jsonObject.optInt("retcode", 0);
            JSONObject optJSONObject = jsonObject.optJSONObject("data");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("default_list");
            if (optJSONArray != null) {
                courseData.setDefaultList(TroopHwCourseMgrRsp.INSTANCE.c(optJSONArray));
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("custom_list");
            if (optJSONArray2 != null) {
                courseData.setCustomList(TroopHwCourseMgrRsp.INSTANCE.c(optJSONArray2));
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("course_list");
            if (optJSONArray3 != null) {
                courseData.setCourseList(TroopHwCourseMgrRsp.INSTANCE.c(optJSONArray3));
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("last_course");
            if (optJSONObject2 != null) {
                courseData.setLastCourse(TroopHwCourseMgrRsp.INSTANCE.b(optJSONObject2));
            }
            courseData.setCourseId(Integer.valueOf(jsonObject.optInt("course_id")));
            courseData.setServerTime(Long.valueOf(jsonObject.optLong("server_time")));
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            return new TroopHwCourseMgrRsp(courseData, msg2, optInt);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50691);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopHwCourseMgrRsp(@NotNull CourseData courseData, @NotNull String msg2, int i3) {
        Intrinsics.checkNotNullParameter(courseData, "courseData");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, courseData, msg2, Integer.valueOf(i3));
            return;
        }
        this.courseData = courseData;
        this.msg = msg2;
        this.retCode = i3;
    }

    public static /* synthetic */ TroopHwCourseMgrRsp copy$default(TroopHwCourseMgrRsp troopHwCourseMgrRsp, CourseData courseData, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            courseData = troopHwCourseMgrRsp.courseData;
        }
        if ((i16 & 2) != 0) {
            str = troopHwCourseMgrRsp.msg;
        }
        if ((i16 & 4) != 0) {
            i3 = troopHwCourseMgrRsp.retCode;
        }
        return troopHwCourseMgrRsp.copy(courseData, str, i3);
    }

    @NotNull
    public final CourseData component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CourseData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.courseData;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.msg;
    }

    public final int component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.retCode;
    }

    @NotNull
    public final TroopHwCourseMgrRsp copy(@NotNull CourseData courseData, @NotNull String msg2, int retCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TroopHwCourseMgrRsp) iPatchRedirector.redirect((short) 9, this, courseData, msg2, Integer.valueOf(retCode));
        }
        Intrinsics.checkNotNullParameter(courseData, "courseData");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new TroopHwCourseMgrRsp(courseData, msg2, retCode);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopHwCourseMgrRsp)) {
            return false;
        }
        TroopHwCourseMgrRsp troopHwCourseMgrRsp = (TroopHwCourseMgrRsp) other;
        if (Intrinsics.areEqual(this.courseData, troopHwCourseMgrRsp.courseData) && Intrinsics.areEqual(this.msg, troopHwCourseMgrRsp.msg) && this.retCode == troopHwCourseMgrRsp.retCode) {
            return true;
        }
        return false;
    }

    @NotNull
    public final CourseData getCourseData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CourseData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.courseData;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        if (r2 == null) goto L19;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CourseInfo getDefaultSelectCourseInfo(@NotNull String teacherType) {
        CourseInfo courseInfo;
        Object obj;
        Object firstOrNull;
        Object firstOrNull2;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CourseInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) teacherType);
        }
        Intrinsics.checkNotNullParameter(teacherType, "teacherType");
        ArrayList<CourseInfo> defaultList = this.courseData.getDefaultList();
        if (defaultList != null) {
            Iterator<T> it = defaultList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj2 = it.next();
                    if (Intrinsics.areEqual(((CourseInfo) obj2).getCourseName(), teacherType)) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            courseInfo = (CourseInfo) obj2;
        }
        ArrayList<CourseInfo> customList = this.courseData.getCustomList();
        if (customList != null) {
            Iterator<T> it5 = customList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (Intrinsics.areEqual(((CourseInfo) obj).getCourseName(), teacherType)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            courseInfo = (CourseInfo) obj;
        } else {
            courseInfo = null;
        }
        if (courseInfo != null) {
            return courseInfo;
        }
        ArrayList<CourseInfo> defaultList2 = this.courseData.getDefaultList();
        if (defaultList2 != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) defaultList2);
            CourseInfo courseInfo2 = (CourseInfo) firstOrNull2;
            if (courseInfo2 != null) {
                return courseInfo2;
            }
        }
        ArrayList<CourseInfo> customList2 = this.courseData.getCustomList();
        if (customList2 != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) customList2);
            return (CourseInfo) firstOrNull;
        }
        return null;
    }

    @NotNull
    public final String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msg;
    }

    public final int getRetCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.retCode;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return (((this.courseData.hashCode() * 31) + this.msg.hashCode()) * 31) + this.retCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "TroopHwCourseMgrRsp(courseData=" + this.courseData + ", msg=" + this.msg + ", retCode=" + this.retCode + ")";
    }
}
