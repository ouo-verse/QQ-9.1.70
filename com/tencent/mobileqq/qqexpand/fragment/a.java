package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f263787a = new HashMap();

    public PageParams a() {
        this.f263787a.put(DTParamKey.REPORT_KEY_APPKEY, IExpandReportUtils.EXPAND_APP_KEY);
        return new PageParams((Map<String, ?>) this.f263787a);
    }
}
