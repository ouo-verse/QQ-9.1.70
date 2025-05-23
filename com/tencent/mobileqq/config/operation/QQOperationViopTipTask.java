package com.tencent.mobileqq.config.operation;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "taskid")
/* loaded from: classes10.dex */
public class QQOperationViopTipTask extends Entity {
    public String adwords;
    public String begin;
    public String clickableWord;
    public String end;
    public int frequencyMessage;
    public int frequencyTime;
    public String keywordString;
    public int limitDayAIOCount;
    public int limitDayAIOShowCount;
    public int limitTotalAIOCount;
    public int limitTotalShowCount;
    public int linkOffset;

    @unique
    public int taskid;
    public int tipType;
    public int uinType;
    public String url;

    public Date getBeginDate() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(this.begin);
        } catch (ParseException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public Date getEndDate() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(this.end);
        } catch (ParseException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getKeywordList() {
        ArrayList<String> arrayList = new ArrayList<>();
        String str = this.keywordString;
        if (str != null && str.length() > 0) {
            if (!this.keywordString.contains("|")) {
                arrayList.add(this.keywordString);
            } else {
                for (String str2 : this.keywordString.split("\\|")) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public boolean isBlueTipsTask() {
        if (this.tipType == 1) {
            return true;
        }
        return false;
    }

    public boolean isGryTipsTask() {
        if (this.tipType == 2) {
            return true;
        }
        return false;
    }

    public void setBeginTime(String str) {
        this.begin = str;
    }

    public void setEndTime(String str) {
        this.end = str;
    }

    public void setKeywordString(String str) {
        this.keywordString = str;
    }
}
