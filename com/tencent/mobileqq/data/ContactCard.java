package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ContactCard extends Entity {
    public byte bAge;
    public boolean bindQQ;
    public String mobileCode;

    @unique
    public String mobileNo;
    public String nationCode;
    public String nickName;
    public String strCity;
    public String strContactName;
    public String strCountry;
    public String strProvince;
    public String uin;
    public byte[] vCoverInfo;
    public byte bSex = -1;
    public byte[] vRichSign = null;
    public boolean isForbidAccount = false;
    public int forbidCode = 0;
}
