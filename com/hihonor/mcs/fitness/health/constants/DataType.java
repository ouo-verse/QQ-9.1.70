package com.hihonor.mcs.fitness.health.constants;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataType {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DataTypeDef {
    }

    public static List<Integer> a(int i3) {
        if (i3 != 557) {
            switch (i3) {
                case PlayerResources.ViewId.TITLE_BAR /* 551 */:
                case PlayerResources.ViewId.LOADING /* 553 */:
                    return new ArrayList(Arrays.asList(4, 501, 502, 13, 504));
                case 552:
                    return new ArrayList(Arrays.asList(4, 501, 502));
                case PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON /* 554 */:
                    return new ArrayList(Arrays.asList(4, 502, 13, 504));
                default:
                    return new ArrayList();
            }
        }
        return new ArrayList(Arrays.asList(4, 503));
    }

    public static int b(int i3) {
        if (i3 != 21 && i3 != 23 && i3 != 26) {
            if (i3 == 402 || i3 == 557) {
                return 2;
            }
            switch (i3) {
                case 3:
                    return 2;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    return 1;
                default:
                    switch (i3) {
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                            return 1;
                        case 18:
                        case 19:
                            return 2;
                        default:
                            switch (i3) {
                                case 202:
                                case 203:
                                case 204:
                                case 205:
                                case 206:
                                case 207:
                                case 208:
                                case 209:
                                case 210:
                                case 211:
                                    return 1;
                                default:
                                    switch (i3) {
                                        case 501:
                                        case 502:
                                        case 503:
                                        case 504:
                                            return 1;
                                        default:
                                            switch (i3) {
                                                case PlayerResources.ViewId.TITLE_BAR /* 551 */:
                                                case 552:
                                                case PlayerResources.ViewId.LOADING /* 553 */:
                                                case PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON /* 554 */:
                                                    return 2;
                                                default:
                                                    switch (i3) {
                                                        case 10001:
                                                        case 10002:
                                                        case 10003:
                                                            return 1;
                                                        default:
                                                            return -1;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return 1;
    }
}
