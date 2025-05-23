package com.tencent.mobileqq.friend.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\u000b\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tH\u0007J\u001e\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0007H\u0007J,\u0010\u0014\u001a\u00020\u00042\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0012H\u0007J,\u0010\u0017\u001a\u00020\u00162\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0012H\u0002R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001f\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/friend/utils/MMKForUinUid;", "", "", "key", "", "a", "value", "", "d", "", "keyList", "j", RemoteHandleConst.PARAM_DEFAULT_VALUE, "c", "b", "g", "k", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportParam", h.F, "map", "", "i", "Ljava/lang/Boolean;", "migrated", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "newEntity", "f", "oldEntity", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MMKForUinUid {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MMKForUinUid f211734a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Boolean migrated;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy newEntity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy oldEntity;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35248);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f211734a = new MMKForUinUid();
        lazy = LazyKt__LazyJVMKt.lazy(MMKForUinUid$newEntity$2.INSTANCE);
        newEntity = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(MMKForUinUid$oldEntity$2.INSTANCE);
        oldEntity = lazy2;
    }

    MMKForUinUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a(@Nullable String key) {
        boolean z16;
        boolean startsWith$default;
        if (key != null && key.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, "uid_prefix_key_", false, 2, null);
        if (startsWith$default && g()) {
            return f211734a.e().containsKey(key);
        }
        return f211734a.f().containsKey(key);
    }

    @JvmStatic
    public static final boolean b(@Nullable String key, boolean defaultValue) {
        return f211734a.f().decodeBool(key, defaultValue);
    }

    @JvmStatic
    @Nullable
    public static final String c(@Nullable String key, @Nullable String defaultValue) {
        boolean z16;
        boolean startsWith$default;
        if (key != null && key.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, "uid_prefix_key_", false, 2, null);
            if (startsWith$default && g()) {
                return f211734a.e().decodeString(key, defaultValue);
            }
            return f211734a.f().decodeString(key, defaultValue);
        }
        return defaultValue;
    }

    @JvmStatic
    public static final void d(@Nullable String key, @Nullable String value) {
        boolean z16;
        boolean startsWith$default;
        if (key != null && key.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, "uid_prefix_key_", false, 2, null);
            if (startsWith$default && g()) {
                f211734a.e().encodeString(key, value);
            } else {
                f211734a.f().encodeString(key, value);
            }
        }
    }

    private final MMKVOptionEntity e() {
        return (MMKVOptionEntity) newEntity.getValue();
    }

    private final MMKVOptionEntity f() {
        return (MMKVOptionEntity) oldEntity.getValue();
    }

    @JvmStatic
    public static final boolean g() {
        if (migrated == null) {
            migrated = Boolean.valueOf(f211734a.e().decodeBool("flag_Migrate_MMKForUinUid", false));
            QLog.d("MMKForUinUid", 1, "isMigrated: " + migrated);
        }
        Boolean bool = migrated;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    @JvmStatic
    public static final boolean h(@NotNull HashMap<String, String> reportParam) {
        String str;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(reportParam, "reportParam");
        QLog.i("MMKForUinUid", 1, "migrate start...");
        long currentTimeMillis = System.currentTimeMillis();
        MMKForUinUid mMKForUinUid = f211734a;
        long j3 = mMKForUinUid.f().totalSize();
        long count = mMKForUinUid.f().count();
        HashMap<String, String> hashMap = new HashMap<>();
        String[] allKeyArr = mMKForUinUid.f().allKeyArr();
        Intrinsics.checkNotNullExpressionValue(allKeyArr, "oldEntity.allKeyArr()");
        int length = allKeyArr.length;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i3 < length) {
            String it = allKeyArr[i3];
            Intrinsics.checkNotNullExpressionValue(it, "it");
            String[] strArr = allKeyArr;
            int i18 = length;
            long j16 = count;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it, "uid_prefix_key_", false, 2, null);
            if (startsWith$default) {
                i17++;
                MMKForUinUid mMKForUinUid2 = f211734a;
                String decodeString = mMKForUinUid2.f().decodeString(it, "");
                Intrinsics.checkNotNullExpressionValue(decodeString, "oldEntity.decodeString(it, \"\")");
                hashMap.put(it, decodeString);
                if (i17 % 100 == 0) {
                    i16 += mMKForUinUid2.i(hashMap);
                    hashMap.clear();
                    if (QLog.isColorLevel()) {
                        QLog.d("MMKForUinUid", 1, "migrate index:" + i17 + TokenParser.SP + i16 + '/' + i17);
                    }
                }
            }
            i3++;
            allKeyArr = strArr;
            length = i18;
            count = j16;
        }
        long j17 = count;
        MMKForUinUid mMKForUinUid3 = f211734a;
        int i19 = i16 + mMKForUinUid3.i(hashMap);
        if (i19 == i17) {
            k();
        }
        if (i19 > 0) {
            try {
                mMKForUinUid3.f().trim();
            } catch (Throwable th5) {
                QLog.e("MMKForUinUid", 1, "migrateInternal trim exception: " + th5.getMessage(), th5);
            }
        }
        MMKForUinUid mMKForUinUid4 = f211734a;
        long j18 = mMKForUinUid4.f().totalSize();
        long j19 = mMKForUinUid4.e().totalSize();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        reportParam.put("fileSizeBefore", String.valueOf(j3 >> 10));
        reportParam.put("keyCount", String.valueOf(j17));
        reportParam.put("sucCount", String.valueOf(i19));
        reportParam.put("migrateCount", String.valueOf(i17));
        if (i19 == i17) {
            str = "1";
        } else {
            str = "0";
        }
        reportParam.put("result", str);
        reportParam.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(currentTimeMillis2));
        reportParam.put("fileSizeAfter", String.valueOf(j18 >> 10));
        reportParam.put("newFileSize", String.valueOf(j19 >> 10));
        QLog.d("MMKForUinUid", 1, "migrate done " + i19 + '/' + i17 + " fileSize:" + (j3 >>> 10) + "Kb to " + (j18 >>> 10) + "Kb newFileSize:" + (j19 >>> 10) + "Kb cost:" + currentTimeMillis2 + " ms");
        if (i19 != i17) {
            return false;
        }
        return true;
    }

    private final int i(HashMap<String, String> map) {
        int i3 = 0;
        if (map.size() == 0) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (f211734a.e().encodeStringR(entry.getKey(), entry.getValue())) {
                    arrayList.add(entry.getKey());
                    i3++;
                }
            }
            f().removeKeyList(arrayList);
        } catch (Throwable th5) {
            QLog.e("MMKForUinUid", 1, "migrateInternal exception: " + th5.getMessage(), th5);
        }
        return i3;
    }

    @JvmStatic
    public static final void j(@Nullable List<String> keyList) {
        boolean z16;
        boolean startsWith$default;
        if (keyList != null) {
            for (String str : keyList) {
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "uid_prefix_key_", false, 2, null);
                    if (startsWith$default && g()) {
                        f211734a.e().removeKey(str);
                    } else {
                        f211734a.f().removeKey(str);
                    }
                }
            }
        }
    }

    @JvmStatic
    public static final void k() {
        migrated = Boolean.TRUE;
        f211734a.e().encodeBool("flag_Migrate_MMKForUinUid", true);
        QLog.d("MMKForUinUid", 1, "setMigrated true");
    }
}
