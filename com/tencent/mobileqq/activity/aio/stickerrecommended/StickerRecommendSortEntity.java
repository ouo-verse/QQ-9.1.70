package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "usrMessage,recommendType")
/* loaded from: classes10.dex */
public class StickerRecommendSortEntity extends Entity {
    public String clicked;
    public String exposed;
    public String noExpose;
    public int recommendType;
    public String usrMessage;

    @notColumn
    public List<Integer> clickedList = new ArrayList();

    @notColumn
    public List<c> clickCountList = new ArrayList();

    @notColumn
    public List<Integer> noExposeList = new ArrayList();

    @notColumn
    public List<Integer> exposedList = new ArrayList();

    public StickerRecommendSortEntity() {
    }

    public void addClicked(Integer num) {
        this.clickedList.add(0, num);
    }

    public void addExposed(Integer num) {
        this.exposedList.add(num);
    }

    public void addNoExpose(Integer num) {
        this.noExposeList.add(num);
    }

    public void convertToList() {
        String str = this.clicked;
        if (str != null) {
            for (String str2 : str.split(",")) {
                String[] split = str2.split(":");
                try {
                    int parseInt = Integer.parseInt(split[0]);
                    this.clickedList.add(Integer.valueOf(parseInt));
                    c cVar = new c();
                    cVar.f179908d = parseInt;
                    if (split.length > 1) {
                        cVar.f179909e = Integer.parseInt(split[1]);
                    } else {
                        cVar.f179909e = 1;
                    }
                    this.clickCountList.add(cVar);
                } catch (Exception unused) {
                }
            }
        }
        String str3 = this.exposed;
        if (str3 != null) {
            for (String str4 : str3.split(",")) {
                try {
                    this.exposedList.add(Integer.valueOf(Integer.parseInt(str4)));
                } catch (Exception unused2) {
                }
            }
        }
        String str5 = this.noExpose;
        if (str5 != null) {
            for (String str6 : str5.split(",")) {
                try {
                    this.noExposeList.add(Integer.valueOf(Integer.parseInt(str6)));
                } catch (Exception unused3) {
                }
            }
        }
    }

    public void convertToString() {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.clickCountList.size(); i3++) {
            c cVar = this.clickCountList.get(i3);
            sb5.append(cVar.f179908d);
            sb5.append(":");
            sb5.append(cVar.f179909e);
            if (i3 < this.clickCountList.size() - 1) {
                sb5.append(",");
            }
        }
        this.clicked = sb5.toString();
        StringBuilder sb6 = new StringBuilder();
        if (this.exposedList != null) {
            for (int i16 = 0; i16 < this.exposedList.size(); i16++) {
                sb6.append(this.exposedList.get(i16));
                if (i16 < this.exposedList.size() - 1) {
                    sb6.append(",");
                }
            }
        }
        this.exposed = sb6.toString();
        StringBuilder sb7 = new StringBuilder();
        if (this.noExposeList != null) {
            for (int i17 = 0; i17 < this.noExposeList.size(); i17++) {
                sb7.append(this.noExposeList.get(i17));
                if (i17 < this.noExposeList.size() - 1) {
                    sb7.append(",");
                }
            }
        }
        this.noExpose = sb7.toString();
    }

    public void removeClicked(Integer num) {
        this.clickedList.remove(num);
    }

    public void removeExposed(Integer num) {
        this.exposedList.remove(num);
    }

    public void removeNoExpose(Integer num) {
        this.noExposeList.remove(num);
    }

    public String toString() {
        return "StickerRecommendSortEntity{usrMessage='" + this.usrMessage + "', clicked='" + this.clicked + "', noExpose='" + this.noExpose + "', exposed='" + this.exposed + "', recommendType=" + this.recommendType + '}';
    }

    public void updateClicked(Integer num) {
        for (int i3 = 0; i3 < this.clickCountList.size(); i3++) {
            c cVar = this.clickCountList.get(i3);
            if (cVar.f179908d == num.intValue()) {
                cVar.f179909e++;
                this.clickCountList.remove(i3);
                this.clickCountList.add(0, cVar);
                return;
            }
        }
        this.clickCountList.add(0, new c(num.intValue(), 1));
    }

    public StickerRecommendSortEntity(String str) {
        this.usrMessage = str;
    }
}
