package com.tencent.mobileqq.aio.msglist.holder.component.chain;

import android.text.TextUtils;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emoticon.api.IEmoticonApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/chain/j;", "", "", "c", "", "d", "e", "", "a", "", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "devicePerfLevelNameMap", "Ljava/lang/Boolean;", "configSwitch", "devicePerfConfigMap", "Ljava/lang/String;", "devicePerfLevelName", "f", "Ljava/lang/Integer;", "chainStickerPlayCount", "g", "Ljava/lang/Double;", "chainStickerLottieDrawableScaleMultiple", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f190747a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, String> devicePerfLevelNameMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean configSwitch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> devicePerfConfigMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String devicePerfLevelName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Integer chainStickerPlayCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Double chainStickerLottieDrawableScaleMultiple;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60279);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f190747a = new j();
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(-1, "default");
        hashMap.put(1, "very_low");
        hashMap.put(2, HippyImageInfo.QUALITY_LOW);
        hashMap.put(3, "middle");
        hashMap.put(4, "high");
        hashMap.put(5, "very_high");
        devicePerfLevelNameMap = hashMap;
        devicePerfConfigMap = new HashMap<>();
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean c() {
        if (configSwitch == null) {
            configSwitch = Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_chain_sticker_play_strategy", true));
        }
        return Intrinsics.areEqual(configSwitch, Boolean.TRUE);
    }

    private final void d() {
        if (TextUtils.isEmpty(devicePerfLevelName)) {
            IEmoticonApi iEmoticonApi = (IEmoticonApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IEmoticonApi.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int devicePerfLevel = iEmoticonApi.getDevicePerfLevel(context);
            String str = devicePerfLevelNameMap.get(Integer.valueOf(devicePerfLevel));
            devicePerfLevelName = str;
            QLog.d("ChainStickerPlayStrategyConfig", 1, "[loadDevicePerLevel] devicePerfLevelName=" + str + ", devicePerfLevelInt=" + devicePerfLevel);
        }
    }

    private final void e() {
        String str;
        HashMap<String, Integer> hashMap = devicePerfConfigMap;
        if (!hashMap.isEmpty()) {
            return;
        }
        if (AIOUtil.f194084a.t() && com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
            str = "{\n  \"play_count_default\": -1,\n  \"play_count_by_device_perf_level\": {\n    \"very_low\": 1,\n    \"low\": 1,\n    \"middle\": -1,\n    \"high\": -1,\n    \"very_high\": -1\n  },\n  \"lottie_drawable_scale_multiple\": 0.6\n}";
        } else {
            str = "";
        }
        String loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("aio_chain_sticker_play_strategy", str);
        if (QLog.isDevelopLevel()) {
            QLog.d("ChainStickerPlayStrategyConfig", 4, "[loadPlayStrategyConfig] content=" + loadConfigAsString);
        }
        if (TextUtils.isEmpty(loadConfigAsString)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(loadConfigAsString);
            hashMap.put("default", Integer.valueOf(jSONObject.optInt("play_count_default", -1)));
            JSONObject optJSONObject = jSONObject.optJSONObject("play_count_by_device_perf_level");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    HashMap<String, Integer> hashMap2 = devicePerfConfigMap;
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap2.put(key, Integer.valueOf(optJSONObject.optInt(key, -1)));
                }
            }
            chainStickerLottieDrawableScaleMultiple = Double.valueOf(jSONObject.optDouble("lottie_drawable_scale_multiple", 1.0d));
            QLog.d("ChainStickerPlayStrategyConfig", 1, "[loadPlayStrategyConfig] devicePerfConfigMap=" + devicePerfConfigMap);
        } catch (JSONException e16) {
            QLog.e("ChainStickerPlayStrategyConfig", 1, "[loadPlayStrategyConfig] exception! stack=", e16);
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (chainStickerPlayCount == null && c()) {
            d();
            e();
            String str = devicePerfLevelName;
            if (str != null) {
                chainStickerPlayCount = devicePerfConfigMap.get(str);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChainStickerPlayStrategyConfig", 2, "[getChainStickerConfigPlayCount]", ", chainStickerPlayCount=" + chainStickerPlayCount, ", devicePerfLevelName=" + devicePerfLevelName, ", devicePerfConfigMap=" + devicePerfConfigMap);
            }
        }
        Integer num = chainStickerPlayCount;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public double b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
        }
        if (chainStickerLottieDrawableScaleMultiple == null && c()) {
            e();
            if (QLog.isDevelopLevel()) {
                QLog.d("ChainStickerPlayStrategyConfig", 4, "[getChainStickerDrawableScaleMultiple]", ", chainStickerLottieDrawableScaleMultiple=" + chainStickerLottieDrawableScaleMultiple);
            }
        }
        Double d16 = chainStickerLottieDrawableScaleMultiple;
        if (d16 != null) {
            return d16.doubleValue();
        }
        return 1.0d;
    }
}
