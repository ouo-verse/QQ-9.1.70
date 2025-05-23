package com.qzone.publish.business.model.intimate;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u001d\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003R.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskGeneralInfo;", "Ljava/io/Serializable;", "Ljava/io/ObjectInputStream;", "ois", "", "readObject", "", "toBytes", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskBatchInfo;", "component1", "batchInfoMap", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/concurrent/ConcurrentHashMap;", "getBatchInfoMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setBatchInfoMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "<init>", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class IntimateUploadTaskGeneralInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -2203078732665558763L;
    private ConcurrentHashMap<Long, IntimateUploadTaskBatchInfo> batchInfoMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskGeneralInfo$a;", "", "", "bytes", "Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskGeneralInfo;", "a", "", "TAG", "Ljava/lang/String;", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.publish.business.model.intimate.IntimateUploadTaskGeneralInfo$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[Catch: Exception -> 0x004e, TRY_LEAVE, TryCatch #0 {Exception -> 0x004e, blocks: (B:23:0x0045, B:25:0x004a), top: B:22:0x0045 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final IntimateUploadTaskGeneralInfo a(byte[] bytes) {
            ObjectInputStream objectInputStream;
            Throwable th5;
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (Exception e16) {
                    e = e16;
                    objectInputStream = null;
                } catch (Throwable th6) {
                    objectInputStream = null;
                    th5 = th6;
                    try {
                        byteArrayInputStream.close();
                        if (objectInputStream != null) {
                        }
                    } catch (Exception e17) {
                        RFWLog.fatal("IntimateUploadTaskGeneralInfo", RFWLog.USR, e17);
                    }
                    throw th5;
                }
            } catch (Exception e18) {
                RFWLog.fatal("IntimateUploadTaskGeneralInfo", RFWLog.USR, e18);
            }
            try {
                try {
                    Object readObject = objectInputStream.readObject();
                    r7 = readObject instanceof IntimateUploadTaskGeneralInfo ? (IntimateUploadTaskGeneralInfo) readObject : null;
                    byteArrayInputStream.close();
                    objectInputStream.close();
                } catch (Throwable th7) {
                    th5 = th7;
                    byteArrayInputStream.close();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw th5;
                }
            } catch (Exception e19) {
                e = e19;
                RFWLog.fatal("IntimateUploadTaskGeneralInfo", RFWLog.USR, e);
                byteArrayInputStream.close();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return r7;
            }
            return r7;
        }

        Companion() {
        }
    }

    public IntimateUploadTaskGeneralInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        if (this.batchInfoMap == null) {
            RFWLog.d("IntimateUploadTaskGeneralInfo", RFWLog.USR, "readObject, batchInfoMap is null ");
            this.batchInfoMap = new ConcurrentHashMap<>();
        }
    }

    public final ConcurrentHashMap<Long, IntimateUploadTaskBatchInfo> component1() {
        return this.batchInfoMap;
    }

    public final IntimateUploadTaskGeneralInfo copy(ConcurrentHashMap<Long, IntimateUploadTaskBatchInfo> batchInfoMap) {
        Intrinsics.checkNotNullParameter(batchInfoMap, "batchInfoMap");
        return new IntimateUploadTaskGeneralInfo(batchInfoMap);
    }

    public final ConcurrentHashMap<Long, IntimateUploadTaskBatchInfo> getBatchInfoMap() {
        return this.batchInfoMap;
    }

    public int hashCode() {
        return this.batchInfoMap.hashCode();
    }

    public final void setBatchInfoMap(ConcurrentHashMap<Long, IntimateUploadTaskBatchInfo> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.batchInfoMap = concurrentHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final byte[] toBytes() {
        ?? r36;
        ObjectOutputStream objectOutputStream;
        ?? e16 = new ByteArrayOutputStream();
        byte[] bArr = null;
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(e16);
                } catch (Exception e17) {
                    e = e17;
                    objectOutputStream = null;
                } catch (Throwable th5) {
                    r36 = 0;
                    th = th5;
                    try {
                        e16.close();
                        if (r36 != 0) {
                            r36.close();
                        }
                    } catch (Exception e18) {
                        RFWLog.fatal("IntimateUploadTaskGeneralInfo", RFWLog.USR, e18);
                    }
                    throw th;
                }
                try {
                    objectOutputStream.writeObject(this);
                    bArr = e16.toByteArray();
                    e16.close();
                    objectOutputStream.close();
                    r36 = objectOutputStream;
                } catch (Exception e19) {
                    e = e19;
                    RFWLog.fatal("IntimateUploadTaskGeneralInfo", RFWLog.USR, e);
                    e16.close();
                    r36 = objectOutputStream;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                        r36 = objectOutputStream;
                    }
                    return bArr;
                }
            } catch (Exception e26) {
                e16 = e26;
                r36 = RFWLog.USR;
                RFWLog.fatal("IntimateUploadTaskGeneralInfo", r36, e16);
            }
            return bArr;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public String toString() {
        return "IntimateUploadTaskGeneralInfo(batchInfoMap=" + this.batchInfoMap + ")";
    }

    public IntimateUploadTaskGeneralInfo(ConcurrentHashMap<Long, IntimateUploadTaskBatchInfo> batchInfoMap) {
        Intrinsics.checkNotNullParameter(batchInfoMap, "batchInfoMap");
        this.batchInfoMap = batchInfoMap;
    }

    public /* synthetic */ IntimateUploadTaskGeneralInfo(ConcurrentHashMap concurrentHashMap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ConcurrentHashMap() : concurrentHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntimateUploadTaskGeneralInfo copy$default(IntimateUploadTaskGeneralInfo intimateUploadTaskGeneralInfo, ConcurrentHashMap concurrentHashMap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            concurrentHashMap = intimateUploadTaskGeneralInfo.batchInfoMap;
        }
        return intimateUploadTaskGeneralInfo.copy(concurrentHashMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof IntimateUploadTaskGeneralInfo) && Intrinsics.areEqual(this.batchInfoMap, ((IntimateUploadTaskGeneralInfo) other).batchInfoMap);
    }
}
