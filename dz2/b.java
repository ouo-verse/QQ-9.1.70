package dz2;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.ark.ark;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J)\u0010\n\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\t\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\n\u0010\u000bJ2\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0002H&J8\u0010\u0019\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0002H&J,\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH&J0\u0010'\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020 0%H&J\u0014\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010*\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u0002H&J!\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+2\b\u0010(\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b,\u0010-J\u0018\u00100\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010/\u001a\u00020.H&J\u001a\u00102\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH&\u00a8\u00063"}, d2 = {"Ldz2/b;", "", "", "b", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "getDeviceInfo", "getDeviceInfoAsJson", "Lcom/tencent/mobileqq/pb/PBField;", "T", "pbField", "convertPbToJson", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "adInfo", "Lsz2/a;", "profitableCallback", "rewardText", ark.APP_SPECIFIC_BIZSRC, "", h.F, "Ljava/lang/ref/WeakReference;", "Ltz2/a;", "profitableCallbackRef", "e", "Landroid/content/Context;", "context", "jsonGdtAdInfo", "pbAdInfo", "", "position", "", "doOriginalExposure", "exposureUrl", "Landroid/view/View;", "adView", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "resultCallback", "doExposure", "gdtTangramAdJson", "getMarketPendantImgUrl", "getGdtCountdownTime", "", "getGdtDanmakuStrContents", "(Ljava/lang/String;)[Ljava/lang/String;", "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "params", "toLandingPage", "", "getIndustryLabels", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface b {
    @NotNull
    String b();

    @Nullable
    <T extends PBField<T>> String convertPbToJson(@NotNull T pbField);

    void doExposure(@NotNull String exposureUrl, @NotNull View adView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, @NotNull VasResultCallback<Boolean> resultCallback);

    boolean doOriginalExposure(@NotNull Context context, @Nullable String jsonGdtAdInfo, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, int position);

    void e(@NotNull Activity activity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull WeakReference<tz2.a> profitableCallbackRef, @Nullable String rewardText, @NotNull String bizSrc);

    @Nullable
    qq_ad_get.QQAdGet.DeviceInfo getDeviceInfo();

    @Nullable
    String getDeviceInfoAsJson();

    int getGdtCountdownTime(@Nullable String gdtTangramAdJson);

    @Nullable
    String[] getGdtDanmakuStrContents(@Nullable String gdtTangramAdJson);

    @Nullable
    List<String> getIndustryLabels(@Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo);

    @Nullable
    String getMarketPendantImgUrl(@Nullable String gdtTangramAdJson);

    void h(@NotNull Activity activity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull sz2.a profitableCallback, @Nullable String rewardText, @NotNull String bizSrc);

    void toLandingPage(@NotNull Activity activity, @NotNull LandingPageParams params);
}
