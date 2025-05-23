package com.tencent.mobileqq.zplan.api.impl;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.CleanZPlanMMKVConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0010\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u001b\u0010$\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanMMKVApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "", "prefix", "", "cleanMMKV", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "edit", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getBoolean", "value", "setBoolean", "getString", "setString", "", "getInt", "setInt", "", "getLong", "setLong", "", "getFloat", QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_SETFLOAT, "", "getBytes", "byteArray", "setBytes", "cleanPrefix", "setBytesWithClean", "remove", "entity$delegate", "Lkotlin/Lazy;", "getEntity", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanMMKVApiImpl implements IZPlanMMKVApi {
    private static final String LAST_CLEAN_TIME = "zplan_mmkv_last_clean_time";
    private static final String TAG = "ZPlanMMKVApiImpl";

    /* renamed from: entity$delegate, reason: from kotlin metadata */
    private final Lazy entity;

    public ZPlanMMKVApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntity>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanMMKVApiImpl$entity$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKVOptionEntity invoke() {
                MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_ZPLAN);
                Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026(), QMMKVFile.FILE_ZPLAN)");
                return from;
            }
        });
        this.entity = lazy;
    }

    private final synchronized void cleanMMKV(String prefix) {
        boolean startsWith$default;
        if (prefix.length() == 0) {
            QLog.e(TAG, 1, "[cleanMMKV]empty prefix return");
            return;
        }
        ZPlanQQMC zPlanQQMC = ZPlanQQMC.INSTANCE;
        if (!zPlanQQMC.enableCleanZPlanMMKV()) {
            QLog.e(TAG, 1, "[cleanMMKV]enableClean=false return");
            return;
        }
        CleanZPlanMMKVConfig cleanMMKVConfig = zPlanQQMC.getCleanMMKVConfig();
        long j3 = getEntity().totalSize();
        if (j3 < cleanMMKVConfig.getLimitFileSize()) {
            QLog.e(TAG, 1, "[cleanMMKV]size is:" + j3 + " return");
            return;
        }
        long decodeLong = getEntity().decodeLong(LAST_CLEAN_TIME, 0L);
        if (System.currentTimeMillis() - decodeLong < cleanMMKVConfig.getLimitCleanTime()) {
            QLog.e(TAG, 1, "[cleanMMKV]has cleaned, lastTime:" + decodeLong + " return");
            return;
        }
        QLog.e(TAG, 1, "[cleanMMKV]cleanMMKV start, size:" + j3 + ", actualSize:" + getEntity().actualSize() + ", count:" + getEntity().count() + " prefix: " + prefix);
        String[] allKeyArr = getEntity().allKeyArr();
        if (allKeyArr != null) {
            ArrayList<String> arrayList = new ArrayList();
            for (String it : allKeyArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it, prefix, false, 2, null);
                if (startsWith$default) {
                    arrayList.add(it);
                }
            }
            for (String str : arrayList) {
                getEntity().removeKey(str);
                QLog.e(TAG, 1, "[cleanMMKV]removeKey:" + str);
            }
        }
        getEntity().trim();
        long j16 = getEntity().totalSize();
        long actualSize = getEntity().actualSize();
        long count = getEntity().count();
        getEntity().encodeLong(LAST_CLEAN_TIME, System.currentTimeMillis());
        QLog.e(TAG, 1, "[cleanMMKV]end, newSize:" + j16 + ", newActualSize:" + actualSize + ", newCount:" + count);
    }

    private final MMKVOptionEntity getEntity() {
        return (MMKVOptionEntity) this.entity.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBytes$lambda$0(ZPlanMMKVApiImpl this$0, String key, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(byteArray, "$byteArray");
        this$0.getEntity().encodeBytes(key, byteArray).commitAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBytesWithClean$lambda$1(ZPlanMMKVApiImpl this$0, String cleanPrefix, String key, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cleanPrefix, "$cleanPrefix");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(byteArray, "$byteArray");
        try {
            this$0.cleanMMKV(cleanPrefix);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[cleanMMKV]error: " + th5);
        }
        this$0.getEntity().encodeBytes(key, byteArray).commitAsync();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public MMKVOptionEntity edit() {
        return getEntity();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public boolean getBoolean(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getEntity().decodeBool(key, defaultValue);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public byte[] getBytes(String key, byte[] defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        byte[] decodeBytes = getEntity().decodeBytes(key, defaultValue);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "entity.decodeBytes(key, defaultValue)");
        return decodeBytes;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public float getFloat(String key, float defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getEntity().decodeFloat(key, defaultValue);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public int getInt(String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getEntity().decodeInt(key, defaultValue);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public long getLong(String key, long defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getEntity().decodeLong(key, defaultValue);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public String getString(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String decodeString = getEntity().decodeString(key, defaultValue);
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(key, defaultValue)");
        return decodeString;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        getEntity().removeKey(key);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public void setBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getEntity().encodeBool(key, value).commitAsync();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public void setBytes(final String key, final byte[] byteArray) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.u
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanMMKVApiImpl.setBytes$lambda$0(ZPlanMMKVApiImpl.this, key, byteArray);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public void setBytesWithClean(final String key, final byte[] byteArray, final String cleanPrefix) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(cleanPrefix, "cleanPrefix");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.t
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanMMKVApiImpl.setBytesWithClean$lambda$1(ZPlanMMKVApiImpl.this, cleanPrefix, key, byteArray);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public void setFloat(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getEntity().encodeFloat(key, value).commitAsync();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public void setInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getEntity().encodeInt(key, value).commitAsync();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public void setLong(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getEntity().encodeLong(key, value).commitAsync();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanMMKVApi
    public void setString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        getEntity().encodeString(key, value).commitAsync();
    }
}
