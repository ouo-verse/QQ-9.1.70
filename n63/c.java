package n63;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Ln63/c;", "", "Lcom/tencent/mobileqq/wink/model/WinkExportParams;", "winkExportParams", "", "g", "e", "f", "", "type", "a", "c", "d", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f418525a = new c();

    c() {
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final boolean d() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:3:0x0005, B:5:0x000b, B:10:0x0017, B:13:0x001e, B:15:0x0036, B:16:0x003c, B:18:0x0058, B:19:0x005f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e A[Catch: Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:3:0x0005, B:5:0x000b, B:10:0x0017, B:13:0x001e, B:15:0x0036, B:16:0x003c, B:18:0x0058, B:19:0x005f), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e() {
        boolean z16;
        Integer intOrNull;
        int i3;
        Integer intOrNull2;
        int i16;
        try {
            String uinStr = WinkCommonUtil.getCurrentAccount();
            if (uinStr != null && uinStr.length() != 0) {
                z16 = false;
                if (!z16) {
                    com.tencent.xaction.log.b.a("WinkPublish-Export-WinkCompressConfigUtil", 1, "isEnableAudioEncodeAsync, uinStr is null or empty ");
                    return false;
                }
                String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_audio_encoder_async", "100");
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(loadAsString);
                if (intOrNull != null) {
                    i3 = intOrNull.intValue();
                } else {
                    i3 = 0;
                }
                Intrinsics.checkNotNullExpressionValue(uinStr, "uinStr");
                String substring = uinStr.substring(uinStr.length() - 2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(substring);
                if (intOrNull2 != null) {
                    i16 = intOrNull2.intValue();
                } else {
                    i16 = 100;
                }
                com.tencent.xaction.log.b.a("WinkPublish-Export-WinkCompressConfigUtil", 1, "isEnableAudioEncodeAsync, configStr:" + loadAsString + ", configInt:" + i3 + ", uinInt:" + i16);
                if (i16 >= i3) {
                    return false;
                }
                return true;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Exception e16) {
            com.tencent.xaction.log.b.c("WinkPublish-Export-WinkCompressConfigUtil", 1, "isEnableAudioEncodeAsync, error ", e16);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:3:0x0005, B:5:0x000b, B:10:0x0017, B:13:0x001e, B:15:0x0036, B:16:0x003c, B:18:0x0058, B:19:0x005f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e A[Catch: Exception -> 0x008a, TryCatch #0 {Exception -> 0x008a, blocks: (B:3:0x0005, B:5:0x000b, B:10:0x0017, B:13:0x001e, B:15:0x0036, B:16:0x003c, B:18:0x0058, B:19:0x005f), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f() {
        boolean z16;
        Integer intOrNull;
        int i3;
        Integer intOrNull2;
        int i16;
        try {
            String uinStr = WinkCommonUtil.getCurrentAccount();
            if (uinStr != null && uinStr.length() != 0) {
                z16 = false;
                if (!z16) {
                    com.tencent.xaction.log.b.a("WinkPublish-Export-WinkCompressConfigUtil", 1, "isEnableAudioPreDecode, uinStr is null or empty ");
                    return false;
                }
                String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_pre_audio_decode", "100");
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(loadAsString);
                if (intOrNull != null) {
                    i3 = intOrNull.intValue();
                } else {
                    i3 = 0;
                }
                Intrinsics.checkNotNullExpressionValue(uinStr, "uinStr");
                String substring = uinStr.substring(uinStr.length() - 2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(substring);
                if (intOrNull2 != null) {
                    i16 = intOrNull2.intValue();
                } else {
                    i16 = 100;
                }
                com.tencent.xaction.log.b.a("WinkPublish-Export-WinkCompressConfigUtil", 1, "isEnableAudioPreDecode, configStr:" + loadAsString + ", configInt:" + i3 + ", uinInt:" + i16);
                if (i16 >= i3) {
                    return false;
                }
                return true;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Exception e16) {
            com.tencent.xaction.log.b.c("WinkPublish-Export-WinkCompressConfigUtil", 1, "isEnableAudioPreDecode, error ", e16);
            return false;
        }
    }

    public final boolean g(@Nullable WinkExportParams winkExportParams) {
        String str;
        Long l3;
        Integer intOrNull;
        int i3;
        LocalMediaInfo b16;
        Integer intOrNull2;
        int i16;
        LocalMediaInfo b17;
        Long l16 = null;
        if (winkExportParams != null) {
            try {
                str = winkExportParams.D;
            } catch (Exception e16) {
                com.tencent.xaction.log.b.c("WinkPublish-Export-WinkCompressConfigUtil", 1, "isEnableSoftCompress, error ", e16);
            }
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual("QCIRCLE", str) || MobileQQ.sProcessId == 9) {
            return false;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_compress_softcompress", false)) {
            w53.b.c("WinkPublish-Export-WinkCompressConfigUtil", "notEnableSoftCompress");
            return false;
        }
        if (winkExportParams != null && (b17 = winkExportParams.b()) != null) {
            l3 = Long.valueOf(b17.mediaBitrate);
        } else {
            l3 = null;
        }
        if (l3 != null) {
            l3.longValue();
            intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_enable_soft_compress", "20000000"));
            if (intOrNull2 != null) {
                i16 = intOrNull2.intValue();
            } else {
                i16 = 0;
            }
            if (l3.longValue() > i16) {
                return true;
            }
        }
        if (winkExportParams != null && (b16 = winkExportParams.b()) != null) {
            l16 = Long.valueOf(b16.fileSize);
        }
        if (l16 != null) {
            l16.longValue();
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_enable_soft_compress_max_file_size", "1500000000"));
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 0;
            }
            if (l16.longValue() > i3) {
                return true;
            }
        }
        return false;
    }

    public final int a(int type) {
        return type;
    }
}
