package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolInfo {
    public int grade;
    public String location = "";
    public String school = "";

    public int getGrade() {
        return this.grade;
    }

    public String getLocation() {
        return this.location;
    }

    public String getSchool() {
        return this.school;
    }

    public String toString() {
        return "GroupSchoolInfo{location=" + this.location + ",grade=" + this.grade + ",school=" + this.school + ",}";
    }
}
