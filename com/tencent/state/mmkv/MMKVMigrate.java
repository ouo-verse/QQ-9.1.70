package com.tencent.state.mmkv;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.square.mmkv.SMMKV;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/mmkv/MMKVMigrate;", "", "()V", "migrateVasFileToDovFile", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MMKVMigrate {
    public static final int CODE_ERROR = -4;
    public static final int CODE_SOURCE_NOT_EXIST = -1;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_TARGET_EXIST = -3;
    public static final int CODE_UNSUPPORT_TYPE = -2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "SquareMMKVMigrate";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JW\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u0002H\f2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/mmkv/MMKVMigrate$Companion;", "", "()V", "CODE_ERROR", "", "CODE_SOURCE_NOT_EXIST", "CODE_SUCCESS", "CODE_TARGET_EXIST", "CODE_UNSUPPORT_TYPE", "TAG", "", "migrateValue", "T", "from", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "to", "Lcom/tencent/state/square/mmkv/SMMKV;", "sourceKey", "targetKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "postFix", "ignoreFillUin", "", "delete", "(Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;Lcom/tencent/state/square/mmkv/SMMKV;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;ZZ)I", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> int migrateValue(MMKVOptionEntity from, SMMKV to5, String sourceKey, String targetKey, T defaultValue, String postFix, boolean ignoreFillUin, boolean delete) {
            int i3;
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to5, "to");
            Intrinsics.checkNotNullParameter(sourceKey, "sourceKey");
            Intrinsics.checkNotNullParameter(targetKey, "targetKey");
            Intrinsics.checkNotNullParameter(postFix, "postFix");
            try {
                if (!from.containsKey(sourceKey)) {
                    return -1;
                }
                if (to5.containsKey(targetKey, postFix, ignoreFillUin)) {
                    i3 = -3;
                } else {
                    if (defaultValue instanceof Boolean) {
                        to5.encodeBool(targetKey, from.decodeBool(sourceKey, ((Boolean) defaultValue).booleanValue()), postFix, ignoreFillUin);
                    } else if (defaultValue instanceof Long) {
                        to5.encodeLong(targetKey, from.decodeLong(sourceKey, ((Number) defaultValue).longValue()), postFix, ignoreFillUin);
                    } else if (defaultValue instanceof Integer) {
                        to5.encodeInt(targetKey, from.decodeInt(sourceKey, ((Number) defaultValue).intValue()), postFix, ignoreFillUin);
                    } else if (defaultValue instanceof String) {
                        String decodeString = from.decodeString(sourceKey, (String) defaultValue);
                        Intrinsics.checkNotNullExpressionValue(decodeString, "from.decodeString(sourceKey, defaultValue)");
                        to5.encodeString(targetKey, decodeString, postFix, ignoreFillUin);
                    } else {
                        SquareLogger squareLog = SquareBaseKt.getSquareLog();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("migrateValue unSupport type: ");
                        sb5.append(defaultValue != 0 ? defaultValue.getClass() : null);
                        SquareLogger.DefaultImpls.e$default(squareLog, MMKVMigrate.TAG, sb5.toString(), null, 4, null);
                        i3 = -2;
                    }
                    i3 = 0;
                }
                if (!delete) {
                    return i3;
                }
                from.removeKey(sourceKey);
                return i3;
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(MMKVMigrate.TAG, "migrateValue err.", th5);
                return -4;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:2:0x0000, B:4:0x000a, B:9:0x0016), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void migrateVasFileToDovFile() {
        boolean z16;
        try {
            String currentAccountUin = SquareBaseKt.getSquareCommon().getCurrentAccountUin();
            if (currentAccountUin != null && currentAccountUin.length() != 0) {
                z16 = false;
                if (!z16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "migrateVasFileToDovFile, selfUin is nullOrEmpty", null, 4, null);
                    return;
                } else {
                    SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.mmkv.MMKVMigrate$migrateVasFileToDovFile$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Migrate.HAS_MIGRATE_VAS_FILE, false, null, false, 12, null)) {
                                SquareBaseKt.getSquareLog().i(MMKVMigrate.TAG, "migrateVasFileToDovFile, has migrated");
                                return;
                            }
                            SquareBaseKt.getSquareLog().i(MMKVMigrate.TAG, "migrate start");
                            long currentTimeMillis = System.currentTimeMillis();
                            new MigrateVasFileToDovFile().migrate();
                            IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Migrate.HAS_MIGRATE_VAS_FILE, true, null, false, 12, null);
                            SquareBaseKt.getSquareLog().i(MMKVMigrate.TAG, "migrate end, pass:" + (System.currentTimeMillis() - currentTimeMillis));
                        }
                    });
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "migrateVasFileToDovFile, err.", th5);
        }
    }
}
