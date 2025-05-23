package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AppGuideTipsConfig extends Entity {
    public static final String SWITCH_KEY_OFF = "0";
    public static final String TAIL_ID = "app_tail_id";
    public static final String TAIL_QIM_ID = "app_qim_tail_id";
    public static final String TIPS_TYPE_TIM = "1";

    @notColumn
    public String aioTypeStr;

    @notColumn
    public boolean allow;
    public long duration;
    public long lastAddTime;
    public String msgTypeStr;
    public String opkey;
    public String switchKey;
    public String tipsHighLight;
    public String tipsMsg;

    @unique
    public String tipsType;
    public String tipsUrl;
    public int maxCount = 0;
    public int addCount = 0;

    @notColumn
    public HashSet<Integer> aioTypes = new HashSet<>();

    @notColumn
    public Map<Integer, Boolean> msgTypeMap = new HashMap();
}
