package com.tencent.mobileqq.z1.download.diffpatch;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pv4.e;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0013\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "Ljava/io/Serializable;", "Lpv4/e;", "diffPatchInfo", "", AppConstants.Key.COLUMN_IS_VALID, "", "component1", "diffInfoBytes", "copy", "", "toString", "", "hashCode", "", "other", "equals", "[B", "getDiffInfoBytes", "()[B", "d", "Lpv4/e;", "diffInfo", "<init>", "([B)V", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class ZPlanMapDiffPatchInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private transient e diffInfo;

    @Nullable
    private final byte[] diffInfoBytes;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo$a;", "", "Lpv4/e;", "info", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "b", "", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableZPlanModDiffUpdate();
        }

        @Nullable
        public final ZPlanMapDiffPatchInfo b(@Nullable e info) {
            if (info != null) {
                return new ZPlanMapDiffPatchInfo(MessageNano.toByteArray(info));
            }
            return null;
        }

        Companion() {
        }
    }

    public ZPlanMapDiffPatchInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ZPlanMapDiffPatchInfo copy$default(ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bArr = zPlanMapDiffPatchInfo.diffInfoBytes;
        }
        return zPlanMapDiffPatchInfo.copy(bArr);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final byte[] getDiffInfoBytes() {
        return this.diffInfoBytes;
    }

    @NotNull
    public final ZPlanMapDiffPatchInfo copy(@Nullable byte[] diffInfoBytes) {
        return new ZPlanMapDiffPatchInfo(diffInfoBytes);
    }

    @Nullable
    public final e diffPatchInfo() {
        byte[] bArr;
        if (this.diffInfo == null && (bArr = this.diffInfoBytes) != null) {
            try {
                this.diffInfo = e.c(bArr);
            } catch (Exception e16) {
                QLog.e("ZPlanMapDiffPatchInfo", 1, "diffInfoBytes error", e16);
            }
        }
        return this.diffInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ZPlanMapDiffPatchInfo) && Intrinsics.areEqual(this.diffInfoBytes, ((ZPlanMapDiffPatchInfo) other).diffInfoBytes)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final byte[] getDiffInfoBytes() {
        return this.diffInfoBytes;
    }

    public int hashCode() {
        byte[] bArr = this.diffInfoBytes;
        if (bArr == null) {
            return 0;
        }
        return Arrays.hashCode(bArr);
    }

    public final boolean isValid() {
        e diffPatchInfo = diffPatchInfo();
        if (diffPatchInfo == null || TextUtils.isEmpty(diffPatchInfo.f427589a) || diffPatchInfo.f427590b <= 0) {
            return false;
        }
        return true;
    }

    @NotNull
    public String toString() {
        return "ZPlanMapDiffPatchInfo(diffInfoBytes=" + Arrays.toString(this.diffInfoBytes) + ')';
    }

    public ZPlanMapDiffPatchInfo(@Nullable byte[] bArr) {
        this.diffInfoBytes = bArr;
    }

    public /* synthetic */ ZPlanMapDiffPatchInfo(byte[] bArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bArr);
    }
}
