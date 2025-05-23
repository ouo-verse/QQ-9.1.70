package com.tencent.mobileqq.troop.homework.coursemgr.repo;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "Ljava/io/Serializable;", "courseId", "", "courseName", "", "coursePic", "(ILjava/lang/String;Ljava/lang/String;)V", "getCourseId", "()I", "setCourseId", "(I)V", "getCourseName", "()Ljava/lang/String;", "setCourseName", "(Ljava/lang/String;)V", "getCoursePic", "setCoursePic", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "parseFromJSONObject", "jsonData", "Lorg/json/JSONObject;", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class CourseInfo implements Serializable {
    static IPatchRedirector $redirector_;
    private int courseId;

    @NotNull
    private String courseName;

    @NotNull
    private String coursePic;

    public CourseInfo() {
        this(0, null, null, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this);
    }

    public static /* synthetic */ CourseInfo copy$default(CourseInfo courseInfo, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = courseInfo.courseId;
        }
        if ((i16 & 2) != 0) {
            str = courseInfo.courseName;
        }
        if ((i16 & 4) != 0) {
            str2 = courseInfo.coursePic;
        }
        return courseInfo.copy(i3, str, str2);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.courseId;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.courseName;
    }

    @NotNull
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.coursePic;
    }

    @NotNull
    public final CourseInfo copy(int courseId, @NotNull String courseName, @NotNull String coursePic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (CourseInfo) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(courseId), courseName, coursePic);
        }
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(coursePic, "coursePic");
        return new CourseInfo(courseId, courseName, coursePic);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof CourseInfo)) {
            return false;
        }
        CourseInfo courseInfo = (CourseInfo) other;
        if (this.courseId == courseInfo.courseId && Intrinsics.areEqual(this.courseName, courseInfo.courseName) && Intrinsics.areEqual(this.coursePic, courseInfo.coursePic)) {
            return true;
        }
        return false;
    }

    public final int getCourseId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.courseId;
    }

    @NotNull
    public final String getCourseName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.courseName;
    }

    @NotNull
    public final String getCoursePic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.coursePic;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return (((this.courseId * 31) + this.courseName.hashCode()) * 31) + this.coursePic.hashCode();
    }

    @NotNull
    public final CourseInfo parseFromJSONObject(@NotNull JSONObject jsonData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CourseInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) jsonData);
        }
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        this.courseId = jsonData.optInt("course_id", 0);
        String optString = jsonData.optString(Element.ELEMENT_NAME_COURSE_NAME, "");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonData.optString(\"course_name\", \"\")");
        this.courseName = optString;
        String optString2 = jsonData.optString("course_pic", "");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonData.optString(\"course_pic\", \"\")");
        this.coursePic = optString2;
        return this;
    }

    public final void setCourseId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.courseId = i3;
        }
    }

    public final void setCourseName(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.courseName = str;
        }
    }

    public final void setCoursePic(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.coursePic = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "CourseInfo(courseId=" + this.courseId + ", courseName=" + this.courseName + ", coursePic=" + this.coursePic + ")";
    }

    public CourseInfo(int i3, @NotNull String courseName, @NotNull String coursePic) {
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(coursePic, "coursePic");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), courseName, coursePic);
            return;
        }
        this.courseId = i3;
        this.courseName = courseName;
        this.coursePic = coursePic;
    }

    public /* synthetic */ CourseInfo(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) == 0 ? str2 : "");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
