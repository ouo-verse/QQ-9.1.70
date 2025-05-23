package com.tencent.luggage.wxa.cn;

import com.huawei.hms.support.api.entity.common.CommonConstant;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        if (!"EAN-13".equals(str) && !"EAN_13".equals(str)) {
            if (!"EAN-8".equals(str) && !"EAN_8".equals(str)) {
                if ("EAN-2".equals(str)) {
                    return 1;
                }
                if ("EAN-5".equals(str)) {
                    return 2;
                }
                if (!"UPC-A".equals(str) && !"UPC_A".equals(str)) {
                    if (!"UPC-E".equals(str) && !"UPC_E".equals(str)) {
                        if (!"CODE-39".equals(str) && !"CODE_39".equals(str)) {
                            if (!"CODE-93".equals(str) && !"CODE_93".equals(str)) {
                                if (!"CODE-128".equals(str) && !"CODE_128".equals(str)) {
                                    if ("COMPOSITE".equals(str)) {
                                        return 12;
                                    }
                                    if (!"I/25".equals(str) && !"ITF".equals(str)) {
                                        if ("DATABAR".equals(str)) {
                                            return 7;
                                        }
                                        if ("DATABAR-EXP".equals(str)) {
                                            return 8;
                                        }
                                        if ("RSS_14".equals(str)) {
                                            return 15;
                                        }
                                        if ("RSS_EXPANDED".equals(str)) {
                                            return 16;
                                        }
                                        if ("MAXICODE".equals(str)) {
                                            return 18;
                                        }
                                        if ("PDF_417".equals(str)) {
                                            return 20;
                                        }
                                        if (CommonConstant.RETKEY.QR_CODE.equals(str)) {
                                            return 19;
                                        }
                                        if ("CODABAR".equals(str)) {
                                            return 17;
                                        }
                                        if ("ISBN10".equals(str)) {
                                            return 14;
                                        }
                                        if ("DATA_MATRIX".equals(str)) {
                                            return 21;
                                        }
                                        if (!"WX_CODE".equals(str)) {
                                            return 0;
                                        }
                                        return 22;
                                    }
                                    return 13;
                                }
                                return 11;
                            }
                            return 10;
                        }
                        return 9;
                    }
                    return 6;
                }
                return 5;
            }
            return 3;
        }
        return 4;
    }
}
