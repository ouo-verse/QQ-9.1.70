package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/VasNtMMKV;", "", "()V", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasNtMMKV {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u001c\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/VasNtMMKV$Companion;", "", "()V", "getDressShowBeancurd", "Lcom/tencent/mobileqq/vas/VasMMKVProxy;", "getFileDir", "getMMKVProxy", "id", "", "uin", "getVipDataPb", "getVipDataRandomKey", "getVipDataTimeStamp", "getVipPerception", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final VasMMKVProxy getMMKVProxy(String id5, String uin) {
            boolean z16;
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
            if (uin != null && uin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                id5 = id5 + "_" + uin;
            }
            return new VasMMKVProxy(from, id5);
        }

        static /* synthetic */ VasMMKVProxy getMMKVProxy$default(Companion companion, String str, String str2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            return companion.getMMKVProxy(str, str2);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getDressShowBeancurd() {
            return getMMKVProxy$default(this, "vas_dress_show_Beancurd", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getFileDir() {
            return getMMKVProxy$default(this, "new_vas_file_dir", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipDataPb() {
            return getMMKVProxy$default(this, "vipdata_pb", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipDataRandomKey() {
            return getMMKVProxy$default(this, "vipdata_key", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipDataTimeStamp() {
            return getMMKVProxy$default(this, "vipdata_ts", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipPerception() {
            return getMMKVProxy$default(this, "vas_perception", null, 2, null);
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getDressShowBeancurd() {
        return INSTANCE.getDressShowBeancurd();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getFileDir() {
        return INSTANCE.getFileDir();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipDataPb() {
        return INSTANCE.getVipDataPb();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipDataRandomKey() {
        return INSTANCE.getVipDataRandomKey();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipDataTimeStamp() {
        return INSTANCE.getVipDataTimeStamp();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipPerception() {
        return INSTANCE.getVipPerception();
    }
}
