package com.tencent.mobileqq.qcircle.api.data;

import java.util.List;

/* loaded from: classes16.dex */
public class QFSFlowPeakRuleBean {
    private int effectiveYear;
    private Festival festival;
    private FestivalStrict festivalStrict;
    private List<Holiday> holidays;
    private boolean isJudgeWeek = false;
    private Normal normal;
    private NormalStrict normalStrict;
    private List<Holiday> workDayWhiteList;

    /* loaded from: classes16.dex */
    public static class Festival {
        private String highRangTime;

        public String getHighRangTime() {
            return this.highRangTime;
        }

        public void setHighRangTime(String str) {
            this.highRangTime = str;
        }
    }

    /* loaded from: classes16.dex */
    public static class FestivalStrict {
        private String highRangTime;

        public String getHighRangTime() {
            return this.highRangTime;
        }

        public void setHighRangTime(String str) {
            this.highRangTime = str;
        }
    }

    /* loaded from: classes16.dex */
    public static class Holiday {
        private String dates;
        private String name;

        public String getDates() {
            return this.dates;
        }

        public String getName() {
            return this.name;
        }

        public void setDates(String str) {
            this.dates = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    /* loaded from: classes16.dex */
    public static class Normal {
        private String highRangTime;

        public String getHighRangTime() {
            return this.highRangTime;
        }

        public void setHighRangTime(String str) {
            this.highRangTime = str;
        }
    }

    /* loaded from: classes16.dex */
    public static class NormalStrict {
        private String highRangTime;

        public String getHighRangTime() {
            return this.highRangTime;
        }

        public void setHighRangTime(String str) {
            this.highRangTime = str;
        }
    }

    public int getEffectiveYear() {
        return this.effectiveYear;
    }

    public Festival getFestival() {
        return this.festival;
    }

    public FestivalStrict getFestivalStrict() {
        return this.festivalStrict;
    }

    public List<Holiday> getHolidays() {
        return this.holidays;
    }

    public Normal getNormal() {
        return this.normal;
    }

    public NormalStrict getNormalStrict() {
        return this.normalStrict;
    }

    public List<Holiday> getWorkDayWhiteList() {
        return this.workDayWhiteList;
    }

    public boolean isJudgeWeek() {
        return this.isJudgeWeek;
    }

    public void setEffectiveYear(int i3) {
        this.effectiveYear = i3;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public void setFestivalStrict(FestivalStrict festivalStrict) {
        this.festivalStrict = festivalStrict;
    }

    public void setHolidays(List<Holiday> list) {
        this.holidays = list;
    }

    public void setJudgeWeek(boolean z16) {
        this.isJudgeWeek = z16;
    }

    public void setNormal(Normal normal) {
        this.normal = normal;
    }

    public void setNormalStrict(NormalStrict normalStrict) {
        this.normalStrict = normalStrict;
    }

    public void setWorkDayWhiteList(List<Holiday> list) {
        this.workDayWhiteList = list;
    }
}
