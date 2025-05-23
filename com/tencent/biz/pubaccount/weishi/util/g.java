package com.tencent.biz.pubaccount.weishi.util;

import NS_KING_SOCIALIZE_META.stMetaAddr;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/g;", "", "", "country", "province", "city", "", "needSpace", "b", "LNS_KING_SOCIALIZE_META/stMetaAddr;", "address", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f81765a = new g();

    g() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x007e, code lost:
    
        if (r6 != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String b(String country, String province, String city, boolean needSpace) {
        String str;
        boolean z16;
        boolean z17;
        boolean isBlank;
        boolean z18;
        boolean isBlank2;
        boolean isBlank3;
        boolean z19;
        boolean z26;
        boolean isBlank4;
        boolean isBlank5;
        boolean isBlank6;
        if (!needSpace) {
            str = "";
        } else {
            str = " ";
        }
        boolean z27 = false;
        if (country != null) {
            isBlank6 = StringsKt__StringsJVMKt.isBlank(country);
            if (!isBlank6) {
                z16 = false;
                if (!z16) {
                    if (province != null) {
                        isBlank5 = StringsKt__StringsJVMKt.isBlank(province);
                        if (!isBlank5) {
                            z19 = false;
                            if (!z19) {
                                if (city != null) {
                                    isBlank4 = StringsKt__StringsJVMKt.isBlank(city);
                                    if (!isBlank4) {
                                        z26 = false;
                                        if (!z26) {
                                            return province + str + city;
                                        }
                                    }
                                }
                                z26 = true;
                                if (!z26) {
                                }
                            }
                        }
                    }
                    z19 = true;
                    if (!z19) {
                    }
                }
                if (country != null) {
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(country);
                    if (!isBlank3) {
                        z17 = false;
                        if (!z17) {
                            if (province != null) {
                                isBlank2 = StringsKt__StringsJVMKt.isBlank(province);
                                if (!isBlank2) {
                                    z18 = false;
                                    if (!z18) {
                                        return country + str + province;
                                    }
                                }
                            }
                            z18 = true;
                            if (!z18) {
                            }
                        }
                        if (country != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(country);
                        }
                        z27 = true;
                        return !z27 ? country : "";
                    }
                }
                z17 = true;
                if (!z17) {
                }
                if (country != null) {
                }
                z27 = true;
                if (!z27) {
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
        if (country != null) {
        }
        z17 = true;
        if (!z17) {
        }
        if (country != null) {
        }
        z27 = true;
        if (!z27) {
        }
    }

    public final String a(stMetaAddr address, boolean needSpace) {
        if (address == null) {
            return "";
        }
        return b(address.country, address.province, address.city, needSpace);
    }
}
