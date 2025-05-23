package com.tencent.luggage.wxa.ne;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public static String a(int i3) {
        if (i3 != 257) {
            switch (i3) {
                case 0:
                    return "GATT SUCCESS";
                case 1:
                    return "GATT INVALID HANDLE";
                case 2:
                    return "GATT READ NOT PERMIT";
                case 3:
                    return "GATT WRITE NOT PERMIT";
                case 4:
                    return "GATT INVALID PDU";
                case 5:
                    return "GATT INSUF AUTHENTICATION";
                case 6:
                    return "GATT REQ NOT SUPPORTED";
                case 7:
                    return "GATT INVALID OFFSET";
                case 8:
                    return "GATT INSUF AUTHORIZATION";
                case 9:
                    return "GATT PREPARE Q FULL";
                case 10:
                    return "GATT NOT FOUND";
                case 11:
                    return "GATT NOT LONG";
                case 12:
                    return "GATT INSUF KEY SIZE";
                case 13:
                    return "GATT INVALID ATTR LEN";
                case 14:
                    return "GATT ERR UNLIKELY";
                case 15:
                    return "GATT INSUF ENCRYPTION";
                case 16:
                    return "GATT UNSUPPORT GRP TYPE";
                case 17:
                    return "GATT INSUF RESOURCE";
                default:
                    switch (i3) {
                        case 128:
                            return "GATT NO RESOURCES";
                        case 129:
                            return "GATT INTERNAL ERROR";
                        case 130:
                            return "GATT WRONG STATE";
                        case 131:
                            return "GATT DB FULL";
                        case 132:
                            return "GATT BUSY";
                        case 133:
                            return "GATT ERROR";
                        case 134:
                            return "GATT CMD STARTED";
                        case 135:
                            return "GATT ILLEGAL PARAMETER";
                        case 136:
                            return "GATT PENDING";
                        case 137:
                            return "GATT AUTH FAIL";
                        case 138:
                            return "GATT MORE";
                        case 139:
                            return "GATT INVALID CFG";
                        case 140:
                            return "GATT SERVICE STARTED";
                        case 141:
                            return "GATT ENCRYPTED NO MITM";
                        case 142:
                            return "GATT NOT ENCRYPTED";
                        case 143:
                            return "GATT CONGESTED";
                        default:
                            switch (i3) {
                                case 253:
                                    return "GATT CCCD CFG ERROR";
                                case 254:
                                    return "GATT PROCEDURE IN PROGRESS";
                                case 255:
                                    return "GATT VALUE OUT OF RANGE";
                                default:
                                    return "UNKNOWN (" + i3 + ")";
                            }
                    }
            }
        }
        return "GATT FAILURE, TOO MANY OPEN CONNECTIONS";
    }

    public static String b(int i3) {
        if (i3 != 1) {
            if (i3 != 8) {
                if (i3 != 19) {
                    if (i3 != 22) {
                        if (i3 != 34) {
                            if (i3 != 62) {
                                if (i3 != 133) {
                                    if (i3 != 256) {
                                        return a(i3);
                                    }
                                    return "GATT CONN CANCEL ";
                                }
                                return "GATT ERROR";
                            }
                            return "GATT CONN FAIL ESTABLISH";
                        }
                        return "GATT CONN LMP TIMEOUT";
                    }
                    return "GATT CONN TERMINATE LOCAL HOST";
                }
                return "GATT CONN TERMINATE PEER USER";
            }
            return "GATT CONN TIMEOUT";
        }
        return "GATT CONN L2C FAILURE";
    }
}
