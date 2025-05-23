package com.tencent.mobileqq.zootopia.data;

import com.google.protobuf.nano.MessageNano;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pu4.g;
import qv4.at;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u001d\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "Ljava/io/Serializable;", "Lpu4/g;", "loadingBackgroundMaterial", "", "loadingBackgroundBytes", "[B", "getLoadingBackgroundBytes", "()[B", "", "isUseNewLoading", "Z", "()Z", "d", "Lpu4/g;", "<init>", "([BZ)V", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ZootopiaMapLoadingParams implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private transient g loadingBackgroundMaterial;
    private final boolean isUseNewLoading;

    @Nullable
    private final byte[] loadingBackgroundBytes;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams$a;", "", "Lqv4/at;", "modLoadingParam", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ZootopiaMapLoadingParams a(@Nullable at modLoadingParam) {
            g gVar;
            byte[] bArr = null;
            if (modLoadingParam != null) {
                gVar = modLoadingParam.f430006a;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                bArr = MessageNano.toByteArray(modLoadingParam.f430006a);
            }
            boolean z16 = false;
            if (modLoadingParam != null && modLoadingParam.f430007b == 1) {
                z16 = true;
            }
            return new ZootopiaMapLoadingParams(bArr, z16);
        }

        Companion() {
        }
    }

    public ZootopiaMapLoadingParams() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final byte[] getLoadingBackgroundBytes() {
        return this.loadingBackgroundBytes;
    }

    /* renamed from: isUseNewLoading, reason: from getter */
    public final boolean getIsUseNewLoading() {
        return this.isUseNewLoading;
    }

    @Nullable
    public final g loadingBackgroundMaterial() {
        byte[] bArr;
        if (this.loadingBackgroundMaterial == null && (bArr = this.loadingBackgroundBytes) != null) {
            try {
                this.loadingBackgroundMaterial = g.d(bArr);
            } catch (Exception e16) {
                QLog.e("ZootopiaMapLoadingParams", 1, "createExtraData loadingBackgroundMaterialBytes", e16);
            }
        }
        return this.loadingBackgroundMaterial;
    }

    public ZootopiaMapLoadingParams(@Nullable byte[] bArr, boolean z16) {
        this.loadingBackgroundBytes = bArr;
        this.isUseNewLoading = z16;
    }

    public /* synthetic */ ZootopiaMapLoadingParams(byte[] bArr, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bArr, (i3 & 2) != 0 ? false : z16);
    }
}
