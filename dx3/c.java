package dx3;

import android.content.Context;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeInfo;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeResult;
import com.tencent.qqnt.kernel.nativeinterface.DeviceCodecFormatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateResult;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseReq;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseRsp;
import com.tencent.qqnt.kernel.nativeinterface.OpentelemetryTracePlan;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaImgSize;
import com.tencent.qqnt.kernel.nativeinterface.WrapperEngineGlobalConfig;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH&J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0016\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0017\u001a\u0004\u0018\u00010\bH&J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0004\b\u001e\u0010\u001fJ5\u0010!\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&\u00a2\u0006\u0004\b!\u0010\"J\u001e\u0010&\u001a\u0004\u0018\u00010%2\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\bH&JB\u0010-\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\b2\b\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020\u001d2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010*2\u0006\u0010,\u001a\u00020\u001dH&JL\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010\b2\b\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020\u001d2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010*2\u0006\u0010,\u001a\u00020\u001dH&J(\u00104\u001a\u00020\u00042\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001002\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH&J8\u00107\u001a\u00020\u00042\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001002\u000e\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001002\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH&J0\u0010;\u001a\u00020\u00042\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010*2\b\u00109\u001a\u0004\u0018\u00010\b2\u0006\u0010:\u001a\u00020\u0011H&J0\u0010=\u001a\u00020\u00042\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010*2\b\u00109\u001a\u0004\u0018\u00010\b2\u0006\u0010<\u001a\u000205H&J\n\u0010?\u001a\u0004\u0018\u00010>H&J\b\u0010@\u001a\u00020\u001dH&J(\u0010F\u001a\u00020\u00042\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\u001dH&J\b\u0010H\u001a\u00020GH&J\b\u0010I\u001a\u00020\nH&J\u0010\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\nH&J\u001a\u0010P\u001a\u00020O2\u0006\u0010L\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010MH&J\b\u0010Q\u001a\u00020\u0004H\u0016J\u0012\u0010U\u001a\u00020T2\b\u0010S\u001a\u0004\u0018\u00010RH&\u00a8\u0006V"}, d2 = {"Ldx3/c;", "", "Lmqq/app/AppRuntime;", "app", "", "onAccountChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/WrapperEngineGlobalConfig;", "d", "", "filePath", "", TagName.FILE_TYPE, "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaImgSize;", "getRichMediaImgSize", "level", "msg", "onLog", "", "onGetSrvCalTime", "()Ljava/lang/Long;", "errMsg", "onShowErrUITips", "getGuid", "a", "path", "fixPicImgType", "(Ljava/lang/String;)Ljava/lang/Integer;", "srcPath", "dstPath", "", "generatePicAioThumb", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "thumbSize", "generateThumb", "(Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/Boolean;", "srcVideoPath", "dstVideoPath", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateResult;", "onCompressVideo", "uid", "eventCode", "isSuc", "Ljava/util/HashMap;", "params", "isRealTime", "onDataReport", com.heytap.mcssdk.a.a.f36102l, "onDataReportWithAppKey", "Ljava/util/ArrayList;", "names", "pubPolicy", "grapPolicy", "onRegisterCountInstruments", "", "boundarys", "onRegisterValueInstruments", "label", "name", "count", "onReportCountIndicators", "value", "onReportValueIndicators", "Lcom/tencent/qqnt/kernel/nativeinterface/OpentelemetryTracePlan;", "onGetMqqOpentelemetryTraceReportPlan", "c", "Landroid/content/Context;", "context", "libName", "version", "includePrivateLib", "loadNativeLibrary", "Lcom/tencent/qqnt/kernel/nativeinterface/DeviceCodecFormatInfo;", "getDeviceCodecFormatInfo", "b", "generalFlag", "onUpdateGeneralFlag", CustomImageProps.QUALITY, "Lcom/tencent/qqnt/kernel/nativeinterface/AvifTranscodeInfo;", "transcodeInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/AvifTranscodeResult;", "avifTranscodeJpgAndGenAIOThumb", "onGetOfflineMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownParseReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownParseRsp;", "onParseMarkdown", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface c {
    @Nullable
    String a();

    @NotNull
    AvifTranscodeResult avifTranscodeJpgAndGenAIOThumb(int quality, @Nullable AvifTranscodeInfo transcodeInfo);

    int b();

    boolean c();

    @Nullable
    WrapperEngineGlobalConfig d();

    @Nullable
    Integer fixPicImgType(@Nullable String path);

    @Nullable
    Boolean generatePicAioThumb(@Nullable String srcPath, @Nullable String dstPath);

    @Nullable
    Boolean generateThumb(@Nullable String srcPath, @Nullable String dstPath, int thumbSize, int fileType);

    @NotNull
    DeviceCodecFormatInfo getDeviceCodecFormatInfo();

    @Nullable
    String getGuid();

    @NotNull
    RichMediaImgSize getRichMediaImgSize(@Nullable String filePath, int fileType);

    void loadNativeLibrary(@NotNull Context context, @NotNull String libName, int version, boolean includePrivateLib);

    void onAccountChanged(@NotNull AppRuntime app);

    @Nullable
    IOperateResult onCompressVideo(@Nullable String srcVideoPath, @Nullable String dstVideoPath);

    void onDataReport(@Nullable String uid, @Nullable String eventCode, boolean isSuc, @Nullable HashMap<String, String> params, boolean isRealTime);

    void onDataReportWithAppKey(@Nullable String appKey, @Nullable String uid, @Nullable String eventCode, boolean isSuc, @Nullable HashMap<String, String> params, boolean isRealTime);

    @Nullable
    OpentelemetryTracePlan onGetMqqOpentelemetryTraceReportPlan();

    void onGetOfflineMsg();

    @Nullable
    Long onGetSrvCalTime();

    void onLog(int level, @Nullable String msg2);

    @NotNull
    MarkdownParseRsp onParseMarkdown(@Nullable MarkdownParseReq req);

    void onRegisterCountInstruments(@Nullable ArrayList<String> names, int pubPolicy, int grapPolicy);

    void onRegisterValueInstruments(@Nullable ArrayList<String> names, @Nullable ArrayList<Double> boundarys, int pubPolicy, int grapPolicy);

    void onReportCountIndicators(@Nullable HashMap<String, String> label, @Nullable String name, long count);

    void onReportValueIndicators(@Nullable HashMap<String, String> label, @Nullable String name, double value);

    void onShowErrUITips(@Nullable String errMsg);

    void onUpdateGeneralFlag(int generalFlag);
}
