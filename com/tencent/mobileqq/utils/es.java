package com.tencent.mobileqq.utils;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/utils/es;", "", "", "statOption", "", "a", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class es {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final es f307750a = new es();

    es() {
    }

    @NotNull
    public final String a(int statOption) {
        if (statOption != 21) {
            if (statOption != 1016) {
                if (statOption != 10003) {
                    if (statOption != 10012) {
                        if (statOption != 10015) {
                            if (statOption != 10201 && statOption != 10202) {
                                switch (statOption) {
                                    case 1019:
                                    case 1020:
                                    case 1021:
                                    case 1022:
                                        return "1";
                                    case 1023:
                                    case 1024:
                                        break;
                                    default:
                                        switch (statOption) {
                                            case 50001:
                                            case 50002:
                                                return "40";
                                            default:
                                                return "0";
                                        }
                                }
                            } else {
                                return "37";
                            }
                        } else {
                            return "35";
                        }
                    } else {
                        return "41";
                    }
                } else {
                    return "36";
                }
            }
            return "39";
        }
        return WadlProxyConsts.OPER_TYPE_MONITOR;
    }
}
