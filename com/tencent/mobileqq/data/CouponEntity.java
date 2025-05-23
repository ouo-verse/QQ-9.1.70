package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "cid,bid,source_id")
/* loaded from: classes10.dex */
public class CouponEntity extends Entity {
    public static final int VERIFY_TYPE_BARCODE = 2;
    public static final int VERIFY_TYPE_DIGITAL_CODE = 1;
    public static final int VERIFY_TYPE_SHOWED_AND_VALID = 0;
    public int bid;
    public int cid;
    public String detail;
    public long etime;
    public boolean isNew;
    public int is_read_able;
    public int is_valid;
    public String name;
    public String pic;
    public String qlife_url;
    public String qrcode;
    public long rcv_time;
    public String rebate;
    public String shids;

    @notColumn
    public CharSequence shopData;

    @notColumn
    private List<Integer> shopList;
    public int source_id;
    public long stime;
    public String tag;
    public String usage;
    public int veri_type;

    public CouponEntity() {
        this.isNew = false;
    }

    public List<Integer> getShopList() {
        if (this.shopList == null) {
            this.shopList = new ArrayList();
            if (!TextUtils.isEmpty(this.shids)) {
                for (String str : this.shids.split("\\,")) {
                    this.shopList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
        }
        return this.shopList;
    }

    public CouponEntity(int i3, int i16, String str, String str2, long j3, long j16, int i17, String str3, String str4, List<Integer> list, int i18, String str5, String str6, String str7, String str8, int i19, long j17, int i26) {
        this.isNew = false;
        this.cid = i3;
        this.bid = i16;
        this.name = str;
        this.detail = str2;
        this.stime = j3;
        this.etime = j16;
        this.veri_type = i17;
        this.pic = str3;
        this.tag = str4;
        this.shopList = list;
        this.shids = TextUtils.join(",", list);
        this.is_valid = i18;
        this.usage = str5;
        this.rebate = str6;
        this.qrcode = str7;
        this.qlife_url = str8;
        this.source_id = i19;
        this.rcv_time = j17;
        this.is_read_able = i26;
        this.isNew = false;
    }
}
