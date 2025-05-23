package com.tencent.mobileqq.activity.aio;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/am;", "", "", "imageBizType", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class am {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final am f178207a = new am();

    am() {
    }

    public final int a(int imageBizType) {
        if (imageBizType == 1) {
            return 1;
        }
        int i3 = 2;
        if (imageBizType != 2) {
            i3 = 3;
            if (imageBizType != 3) {
                i3 = 4;
                if (imageBizType != 4) {
                    i3 = 5;
                    if (imageBizType != 5) {
                        if (imageBizType == 1002) {
                            return 1;
                        }
                        switch (imageBizType) {
                            case 7:
                                return 7;
                            case 8:
                                return 8;
                            case 9:
                                return 9;
                            case 10:
                                return 10;
                            case 11:
                                return 11;
                            case 12:
                                return 12;
                            case 13:
                                return 13;
                            case 14:
                                return 14;
                            default:
                                return 0;
                        }
                    }
                }
            }
        }
        return i3;
    }
}
