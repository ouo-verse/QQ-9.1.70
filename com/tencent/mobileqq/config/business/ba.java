package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IQQSysAndEmojiResApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/config/business/ba;", "", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ba {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/config/business/ba$a;", "", "Loa1/d;", "c", "Loa1/c;", "a", "Landroid/content/SharedPreferences;", "b", "", "DEBUG_EXT_ANI_SITCKER_CONFIG_JSON", "Ljava/lang/String;", "DEBUG_FACE_CONFIG_JSON", "MMKV_SP_NAME", "TAG", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.ba$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final oa1.c a() {
            oa1.c cVar;
            try {
                oa1.c extAniStickerConfBean = ((IQQSysAndEmojiResApi) QRoute.api(IQQSysAndEmojiResApi.class)).getExtAniStickerConfBean();
                if (extAniStickerConfBean == null) {
                    return new oa1.c();
                }
                return extAniStickerConfBean;
            } catch (Throwable unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSysAndEmojiConfUtil", 2, "[getSystemAndEmojiConfBean] error");
                }
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    cVar = oa1.c.a("{\n  \"ExtAniStickerConfigUrl\": \"http://down.qq.com/qqface/test/extStickerTest/ext_anisticker_config_202401041946v1.zip\",\n  \"ExtAniStickerConfigMd5\": \"ab849bcb6db16b16344e59c04ae263b8\",\n  \"ExtAniStickerSysfaceResUrl\": \"https://downv6.qq.com/qqface/test/extStickerTest/ext_anisticker_sysface_res_test_202401112059v1.zip\",\n  \"ExtAniStickerSysfaceResMd5\": \"8e9b12cd4e25fea70dcfe3289089d06a\",\n  \"iOSExtAniStickerSysfaceResUrl\": \"https://downv6.qq.com/qqface/test/extStickerTest/iOS_ext_anisticker_sysface_res_test_202401112100v1.zip\",\n  \"iOSExtAniStickerSysfaceResMd5\": \"0fd4ed6c23887ae4484d098300e934ab\",\n  \"ExtAniStickerLottieUrl\": \"https://downv6.qq.com/qqface/test/extStickerTest/ext_qlottie_test_202401112116V1.zip\",\n  \"ExtAniStickerLottieMd5\": \"caf65c2a6f493543b278cf19f1b40dae\"\n}");
                } else {
                    cVar = new oa1.c();
                }
                Intrinsics.checkNotNullExpressionValue(cVar, "{\n                if (QL\u2026          }\n            }");
                return cVar;
            }
        }

        @NotNull
        public final SharedPreferences b() {
            String currentUin;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str = "";
            if (peekAppRuntime != null && (currentUin = peekAppRuntime.getCurrentUin()) != null) {
                str = currentUin;
            }
            SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), "QQSysAndEmojiConfProcessor" + str, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromSpAdapter, "fromSpAdapter(\n         \u2026FILE_COMMON\n            )");
            return fromSpAdapter;
        }

        @NotNull
        public final oa1.d c() {
            oa1.d dVar;
            try {
                oa1.d systemAndEmojiConfBean = ((IQQSysAndEmojiResApi) QRoute.api(IQQSysAndEmojiResApi.class)).getSystemAndEmojiConfBean();
                if (systemAndEmojiConfBean == null) {
                    return new oa1.d();
                }
                return systemAndEmojiConfBean;
            } catch (Throwable unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSysAndEmojiConfUtil", 2, "[getSystemAndEmojiConfBean] error");
                }
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    dVar = oa1.d.a("{\n\"config_url\": \"https://downv6.qq.com/qqface/res/Config/face_config_202403251616.zip\",\n\"config_md5\": \"3f461c1aa9dc68e8a64f78154c84e9a1\",\n\"iOS_sysface_res_url\": \"https://downv6.qq.com/qqface/res/full/sysface_res_iosfull_202403221636.zip\",\n\"iOS_sysface_res_md5\": \"5b1988b90fc3dc4ddec46b5d5c4f08f7\",\n\"sysface_res_url\": \"https://downv6.qq.com/qqface/res/full/sysface_res_androidfull_202403221635.zip\",\n\"sysface_res_md5\": \"cca43ae470180eafcfca0fa1c55ed283\",\n\"iOS_sysface_res_base_url\": \"https://downv6.qq.com/qqface/res/full/sysface_res_iosfull_202312261013.zip\",\n\"iOS_sysface_res_base_md5\": \"178400aa3d351690c7309cf7fc80a534\",\n\"sysface_res_base_url\": \"https://downv6.qq.com/qqface/res/full/sysface_res_androidfull_202312261042.zip\",\n\"sysface_res_base_md5\": \"daa3cf858a53bee1810193ca4f1930df\",\n\"iOS_sysface_res_expand_url\": \"https://downv6.qq.com/qqface/res/full/sysface_res_ios_expand_202403221629.zip\",\n\"iOS_sysface_res_expand_md5\": \"18915e9cce88386ef192785152e6ea0f\",\n\"sysface_res_expand_url\": \"https://downv6.qq.com/qqface/res/full/sysface_res_android_expand_202403221628.zip\",\n\"sysface_res_expand_md5\": \"81c2f5dcebaa1f1696e6553d7676b937\",\n\"emoji_res_url\": \"https://downv6.qq.com/qqface/res/emoji/emoji_res_v1.zip\",\n\"emoji_res_md5\": \"8474b9526dd885bebddacf9cc225d441\",\n\"AniStickerWidth\": 512,\n\"AniStickerHeight\": 512,\n\"AniStickerSvgUrl\": \"https://downv6.qq.com/qqface/res/qsvg/qsvg_202403221709.zip\",\n\"AniStickerSvgMd5\": \"b7b5148c0176a05dae7d28dae424c773\",\n\"AniStickerLottieUrl\": \"https://downv6.qq.com/qqface/res/lottie/qlottie_202403221727.zip\",\n\"AniStickerLottieMd5\": \"b6e15bcf27309776944c714ff6399d9d\",\n\"anim_emoticon_count\": {\n\"version\": \"-21:10|21-26:20|26-:30\"\n},\n\"sysface_recent_line_cnt\": 3,\n\"emoticon_guide_config\": {\n\"emoticon_guide_open\": 1,\n\"emoticon_guide_version\": 127,\n\"emoticon_guide_width\": 338,\n\"emoticon_guide_height\": 160,\n\"emoticon_guide_url\": \"https://downv6.qq.com/qqface/res/bubble/normalbubble2023011201.gif\",\n\"emoticon_guide_night_url\": \"https://downv6.qq.com/qqface/res/bubble/nightbubble2023011201.gif\",\n\"emoticon_guide_serverid\": 341,\n\"emoticon_guide_serverid_type\": 1,\n\"emoticon_guide_time\": 3,\n\"emoticon_guide_invalid_time\": \"2023-02-23 00:00:00\"\n}\n}");
                } else {
                    dVar = new oa1.d();
                }
                Intrinsics.checkNotNullExpressionValue(dVar, "{\n                if (QL\u2026          }\n            }");
                return dVar;
            }
        }

        Companion() {
        }
    }
}
