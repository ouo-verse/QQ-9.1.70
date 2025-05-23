package com.tencent.mobileqq.search;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class af implements Manager {

    /* renamed from: f, reason: collision with root package name */
    public static final String f282716f = HardCodeUtil.qqStr(R.string.t7z);

    /* renamed from: h, reason: collision with root package name */
    public static final String f282717h = HardCodeUtil.qqStr(R.string.t7y);

    /* renamed from: i, reason: collision with root package name */
    public static final String f282718i = HardCodeUtil.qqStr(R.string.t7x);

    /* renamed from: m, reason: collision with root package name */
    public static final String f282719m = HardCodeUtil.qqStr(R.string.f172670t80);

    /* renamed from: d, reason: collision with root package name */
    int f282720d = -1;

    /* renamed from: e, reason: collision with root package name */
    QQAppInterface f282721e;

    public af(QQAppInterface qQAppInterface) {
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f282721e = null;
    }
}
