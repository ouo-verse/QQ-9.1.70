package com.tencent.mobileqq.qwallet.utils;

import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qwallet.plugin.IQWalletHelper;

/* compiled from: P */
/* loaded from: classes16.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f279282a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f279283b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f279284c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f279285d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f279286e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f279287f;

    static {
        String qWalletExternalPath = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getQWalletExternalPath();
        f279282a = qWalletExternalPath;
        f279283b = qWalletExternalPath + ".tmp/";
        String qWalletInternalPath = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getQWalletInternalPath();
        f279284c = qWalletInternalPath;
        String str = qWalletInternalPath + ".tmp/";
        f279285d = str;
        f279286e = str + "topay_recommends";
        f279287f = str + "group_available_list_";
    }
}
