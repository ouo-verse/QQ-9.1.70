package com.tencent.bugly.common.utils;

import com.tencent.bugly.common.privacy.PrivacyInformation;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/bugly/common/utils/AndroidVersion;", "", "()V", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class AndroidVersion {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/bugly/common/utils/AndroidVersion$Companion;", "", "()V", "isOver33", "", "isOver34", "isOverHoneycomb", "isOverIceScreamSandwich", "isOverJellyBean", "isOverJellyBeanMr1", "isOverJellyBeanMr2", "isOverKitKat", "isOverKitKatWatch", "isOverL", "isOverLollipopMR1", "isOverM", "isOverN", "isOverO", "isOverP", "isOverQ", "isOverR", "isOverS", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        public final boolean isOver33() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 33) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOver34() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 34) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverHoneycomb() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 13) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverIceScreamSandwich() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 14) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverJellyBean() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 16) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverJellyBeanMr1() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 17) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverJellyBeanMr2() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 18) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverKitKat() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 19) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverKitKatWatch() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 20) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverL() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 21) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverLollipopMR1() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 22) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverM() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 23) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverN() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 24) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverO() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 26) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverP() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 28) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverQ() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 29) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverR() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 30) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final boolean isOverS() {
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.getAndroidFrameworkVersion() >= 31) {
                return true;
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    public static final boolean isOver33() {
        return INSTANCE.isOver33();
    }

    @JvmStatic
    public static final boolean isOver34() {
        return INSTANCE.isOver34();
    }

    @JvmStatic
    public static final boolean isOverHoneycomb() {
        return INSTANCE.isOverHoneycomb();
    }

    @JvmStatic
    public static final boolean isOverIceScreamSandwich() {
        return INSTANCE.isOverIceScreamSandwich();
    }

    @JvmStatic
    public static final boolean isOverJellyBean() {
        return INSTANCE.isOverJellyBean();
    }

    @JvmStatic
    public static final boolean isOverJellyBeanMr1() {
        return INSTANCE.isOverJellyBeanMr1();
    }

    @JvmStatic
    public static final boolean isOverJellyBeanMr2() {
        return INSTANCE.isOverJellyBeanMr2();
    }

    @JvmStatic
    public static final boolean isOverKitKat() {
        return INSTANCE.isOverKitKat();
    }

    @JvmStatic
    public static final boolean isOverKitKatWatch() {
        return INSTANCE.isOverKitKatWatch();
    }

    @JvmStatic
    public static final boolean isOverL() {
        return INSTANCE.isOverL();
    }

    @JvmStatic
    public static final boolean isOverLollipopMR1() {
        return INSTANCE.isOverLollipopMR1();
    }

    @JvmStatic
    public static final boolean isOverM() {
        return INSTANCE.isOverM();
    }

    @JvmStatic
    public static final boolean isOverN() {
        return INSTANCE.isOverN();
    }

    @JvmStatic
    public static final boolean isOverO() {
        return INSTANCE.isOverO();
    }

    @JvmStatic
    public static final boolean isOverP() {
        return INSTANCE.isOverP();
    }

    @JvmStatic
    public static final boolean isOverQ() {
        return INSTANCE.isOverQ();
    }

    @JvmStatic
    public static final boolean isOverR() {
        return INSTANCE.isOverR();
    }

    @JvmStatic
    public static final boolean isOverS() {
        return INSTANCE.isOverS();
    }
}
