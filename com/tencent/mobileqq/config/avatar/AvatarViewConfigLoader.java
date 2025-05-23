package com.tencent.mobileqq.config.avatar;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002R\u0014\u0010\u0014\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/AvatarViewConfigLoader;", "", "", "url", "md5", "", "c", "j", "o", "targetMd5", "", "e", "k", DomainData.DOMAIN_NAME, "Lorg/json/JSONObject;", "jsonObject", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "()Ljava/lang/String;", "mPathConfigZip", "i", "mPathTmpConfigDir", "g", "mPathConfigDir", "f", "mPathConfig", "<init>", "()V", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AvatarViewConfigLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<AvatarViewConfigLoader> f202363b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/AvatarViewConfigLoader$a;", "", "Lcom/tencent/mobileqq/config/avatar/AvatarViewConfigLoader;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/config/avatar/AvatarViewConfigLoader;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "FILE_NAME_CONFIG", "Ljava/lang/String;", "JSON_KEY_AVATAR_VIEW", "JSON_KEY_MD5", "JSON_KEY_URL", "MMKV_KEY_CONFIG_MD5", "NAME_AVATAR_CONFIG_DIR", "NAME_AVATAR_TMP_CONFIG_DIR", "NAME_AVATAR_ZIP_CONFIG", "TAG", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.avatar.AvatarViewConfigLoader$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AvatarViewConfigLoader a() {
            return (AvatarViewConfigLoader) AvatarViewConfigLoader.f202363b.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<AvatarViewConfigLoader> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<AvatarViewConfigLoader>() { // from class: com.tencent.mobileqq.config.avatar.AvatarViewConfigLoader$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AvatarViewConfigLoader invoke() {
                return new AvatarViewConfigLoader(null);
            }
        });
        f202363b = lazy;
    }

    public /* synthetic */ AvatarViewConfigLoader(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void c(final String url, final String md5) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.avatar.g
            @Override // java.lang.Runnable
            public final void run() {
                AvatarViewConfigLoader.d(md5, this, url);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(String md5, AvatarViewConfigLoader this$0, String url) {
        boolean equals;
        boolean z16;
        Intrinsics.checkNotNullParameter(md5, "$md5");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        equals = StringsKt__StringsJVMKt.equals(md5, this$0.j(), true);
        if (equals & this$0.k()) {
            QLog.i("AvatarViewConfig", 1, "config exist! return");
            return;
        }
        try {
            z16 = HttpDownloadUtil.download(MobileQQ.sMobileQQ.peekAppRuntime(), url, new File(this$0.h()));
        } catch (Error e16) {
            QLog.i("AvatarViewConfig", 1, "download config: " + e16);
            z16 = false;
            QLog.i("AvatarViewConfig", 1, "download config " + z16);
            if (z16) {
                return;
            } else {
                return;
            }
        } catch (Exception e17) {
            QLog.i("AvatarViewConfig", 1, "download config: " + e17);
            z16 = false;
            QLog.i("AvatarViewConfig", 1, "download config " + z16);
            if (z16) {
            }
        }
        QLog.i("AvatarViewConfig", 1, "download config " + z16);
        if (z16 && this$0.e(md5) && this$0.n()) {
            AvatarViewConfig.INSTANCE.a().j(true);
            this$0.o(md5);
        }
    }

    private final boolean e(String targetMd5) {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(targetMd5, HexUtil.bytes2HexStr(MD5.getFileMd5(h())), true);
        QLog.i("AvatarViewConfig", 1, "checkZipMd5 result: " + equals);
        return equals;
    }

    private final String f() {
        return g() + File.separator + "avatar_config.json";
    }

    private final String g() {
        return d.f202369a.f() + File.separator + DownloadInfo.spKey_Config;
    }

    private final String h() {
        return d.f202369a.f() + File.separator + "config_zip";
    }

    private final String i() {
        return d.f202369a.f() + File.separator + "temp_config";
    }

    private final String j() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString("key_config_md5", "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(MMKV_KEY_CONFIG_MD5, \"\")");
        return decodeString;
    }

    private final boolean k() {
        return new File(f()).exists();
    }

    private final synchronized boolean n() {
        boolean z16;
        String str;
        String str2;
        z16 = false;
        try {
            try {
                try {
                    FileUtils.delete(i(), false);
                    FileUtils.uncompressZip(h(), i(), false);
                    FileUtils.delete(g(), false);
                    FileUtils.rename(i(), g());
                    z16 = true;
                } catch (OutOfMemoryError e16) {
                    QLog.e("AvatarViewConfig", 1, "uncompress err: " + e16);
                    FileUtils.delete(h(), false);
                    FileUtils.delete(i(), false);
                    str = "AvatarViewConfig";
                    str2 = "delete zip and tmp file";
                    QLog.i(str, 1, str2);
                    QLog.i("AvatarViewConfig", 1, "unCompressZipConfig: " + z16);
                    return z16;
                }
            } catch (Exception e17) {
                QLog.e("AvatarViewConfig", 1, "uncompress exception: " + e17);
                FileUtils.delete(h(), false);
                FileUtils.delete(i(), false);
                str = "AvatarViewConfig";
                str2 = "delete zip and tmp file";
                QLog.i(str, 1, str2);
                QLog.i("AvatarViewConfig", 1, "unCompressZipConfig: " + z16);
                return z16;
            }
            QLog.i("AvatarViewConfig", 1, "unCompressZipConfig: " + z16);
        } finally {
            FileUtils.delete(h(), false);
            FileUtils.delete(i(), false);
            QLog.i("AvatarViewConfig", 1, "delete zip and tmp file");
        }
        return z16;
    }

    private final void o(String md5) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString("key_config_md5", md5);
        from.commitAsync();
    }

    public final void l(@NotNull JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        try {
            JSONObject optJSONObject = jsonObject.optJSONObject("avatar_view");
            if (optJSONObject != null) {
                String url = optJSONObject.optString("url");
                String md5 = optJSONObject.optString("md5");
                Intrinsics.checkNotNullExpressionValue(url, "url");
                Intrinsics.checkNotNullExpressionValue(md5, "md5");
                c(url, md5);
            } else {
                optJSONObject = null;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AvatarViewConfig", 2, "config is " + optJSONObject);
            }
        } catch (Exception e16) {
            QLog.e("AvatarViewConfig", 1, "parseConfig fail: " + e16);
        }
    }

    @NotNull
    public final synchronized String m() {
        List readLines$default;
        String sb5;
        StringBuilder sb6 = new StringBuilder();
        readLines$default = FilesKt__FileReadWriteKt.readLines$default(new File(f()), null, 1, null);
        Iterator it = readLines$default.iterator();
        while (it.hasNext()) {
            sb6.append((String) it.next());
        }
        sb5 = sb6.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "sb.toString()");
        return sb5;
    }

    AvatarViewConfigLoader() {
    }
}
