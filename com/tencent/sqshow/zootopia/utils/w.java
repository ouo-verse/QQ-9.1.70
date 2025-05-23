package com.tencent.sqshow.zootopia.utils;

import com.tencent.qphone.base.remote.SimpleAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/w;", "", "", "b", "uin", "", "c", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f373306a = new w();

    w() {
    }

    public final String a() {
        String property = MobileQQ.sMobileQQ.getProperty(Constants.PropertiesKey.nickName.toString() + b());
        return property == null ? "" : property;
    }

    public final String b() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            String uin = firstSimpleAccount.getUin();
            Intrinsics.checkNotNullExpressionValue(uin, "{\n            simpleAccount.uin\n        }");
            return uin;
        }
        return "";
    }

    public final boolean c(String uin) {
        return Intrinsics.areEqual(b(), uin);
    }
}
