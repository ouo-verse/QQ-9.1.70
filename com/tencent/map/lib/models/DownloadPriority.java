package com.tencent.map.lib.models;

/* loaded from: classes9.dex */
public enum DownloadPriority {
    NONE(-1),
    HIGH(0),
    MIDDLE(1),
    LOW(2);

    private final int mValue;

    /* renamed from: com.tencent.map.lib.models.DownloadPriority$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f147588a;

        static {
            int[] iArr = new int[DownloadPriority.values().length];
            f147588a = iArr;
            try {
                iArr[DownloadPriority.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f147588a[DownloadPriority.LOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f147588a[DownloadPriority.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    DownloadPriority(int i3) {
        this.mValue = i3;
    }

    public static DownloadPriority get(int i3) {
        for (DownloadPriority downloadPriority : values()) {
            if (downloadPriority.mValue == i3) {
                return downloadPriority;
            }
        }
        return NONE;
    }

    public static int getThreadPriority(int i3) {
        int i16 = AnonymousClass1.f147588a[get(i3).ordinal()];
        if (i16 != 1) {
            if (i16 == 2) {
                return 1;
            }
            return 5;
        }
        return 10;
    }

    public final int getValue() {
        return this.mValue;
    }
}
