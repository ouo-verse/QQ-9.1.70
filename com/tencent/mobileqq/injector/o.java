package com.tencent.mobileqq.injector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.guild.api.pic.IGuildPicApi;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MSFSharedPreUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicConvertForNativeApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqdataline.api.IQQDataLineTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.api.IGetDeviceInfoForNT;
import com.tencent.mobileqq.tianjige.ntkernel.NtKernelMetricHelper;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.compress.api.IVideoCompressApi;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeInfo;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeResult;
import com.tencent.qqnt.kernel.nativeinterface.DeviceCodecFormatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateResult;
import com.tencent.qqnt.kernel.nativeinterface.InitGlobalPathConfig;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseReq;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseRsp;
import com.tencent.qqnt.kernel.nativeinterface.OpentelemetryTracePlan;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaImgSize;
import com.tencent.qqnt.kernel.nativeinterface.ThumbConfig;
import com.tencent.qqnt.kernel.nativeinterface.WrapperEngineGlobalConfig;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bX\u0010YJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J3\u0010\u0013\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016JT\u0010!\u001a\u00020 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\t2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001d2\u0006\u0010\u001f\u001a\u00020\tH\u0016JL\u0010#\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\t2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0016\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u0016J4\u00101\u001a\u00020 2\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`-2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0016JP\u00104\u001a\u00020 2\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`-2\u001a\u00103\u001a\u0016\u0012\u0004\u0012\u000202\u0018\u00010,j\n\u0012\u0004\u0012\u000202\u0018\u0001`-2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0016JB\u00108\u001a\u00020 2&\u00105\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001d2\b\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u00107\u001a\u00020&H\u0016JB\u0010:\u001a\u00020 2&\u00105\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001d2\b\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u00109\u001a\u000202H\u0016J\b\u0010;\u001a\u00020\u0002H\u0016J\n\u0010<\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010>\u001a\u00020=H\u0016J\u001a\u0010C\u001a\u00020B2\u0006\u0010?\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\b\u0010D\u001a\u00020 H\u0016J\u0010\u0010G\u001a\u00020 2\u0006\u0010F\u001a\u00020EH\u0016J\u0012\u0010I\u001a\u00020 2\b\u0010H\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010J\u001a\u00020\tH\u0016J(\u0010P\u001a\u00020 2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\tH\u0016J\b\u0010Q\u001a\u00020\u0004H\u0016J\u0010\u0010S\u001a\u00020 2\u0006\u0010R\u001a\u00020\u0004H\u0016J\u0012\u0010W\u001a\u00020V2\b\u0010U\u001a\u0004\u0018\u00010TH\u0016\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/injector/o;", "Ldx3/c;", "", "path", "", "fixPicImgType", "(Ljava/lang/String;)Ljava/lang/Integer;", "srcPath", "dstPath", "", "generatePicAioThumb", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "Lcom/tencent/qqnt/kernel/nativeinterface/WrapperEngineGlobalConfig;", "d", "filePath", TagName.FILE_TYPE, "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaImgSize;", "getRichMediaImgSize", "thumbSize", "generateThumb", "(Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/Boolean;", "srcVideoPath", "dstVideoPath", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateResult;", "onCompressVideo", "uid", "eventCode", "isSuc", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "isRealTime", "", "onDataReport", com.heytap.mcssdk.a.a.f36102l, "onDataReportWithAppKey", "Lcom/tencent/qqnt/kernel/nativeinterface/OpentelemetryTracePlan;", "onGetMqqOpentelemetryTraceReportPlan", "", "onGetSrvCalTime", "()Ljava/lang/Long;", "level", "msg", "onLog", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "names", "pubPolicy", "grapPolicy", "onRegisterCountInstruments", "", "boundarys", "onRegisterValueInstruments", "label", "name", "count", "onReportCountIndicators", "value", "onReportValueIndicators", "getGuid", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/DeviceCodecFormatInfo;", "getDeviceCodecFormatInfo", CustomImageProps.QUALITY, "Lcom/tencent/qqnt/kernel/nativeinterface/AvifTranscodeInfo;", "transcodeInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/AvifTranscodeResult;", "avifTranscodeJpgAndGenAIOThumb", "onGetOfflineMsg", "Lmqq/app/AppRuntime;", "app", "onAccountChanged", "errMsg", "onShowErrUITips", "c", "Landroid/content/Context;", "context", "libName", "version", "includePrivateLib", "loadNativeLibrary", "b", "generalFlag", "onUpdateGeneralFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownParseReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownParseRsp;", "onParseMarkdown", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class o implements dx3.c {
    static IPatchRedirector $redirector_;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // dx3.c
    @Nullable
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return AppSetting.f99542b;
    }

    @Override // dx3.c
    @NotNull
    public AvifTranscodeResult avifTranscodeJpgAndGenAIOThumb(int quality, @Nullable AvifTranscodeInfo transcodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (AvifTranscodeResult) iPatchRedirector.redirect((short) 20, (Object) this, quality, (Object) transcodeInfo);
        }
        AvifTranscodeResult convertAvif2Jpg = ((IPicConvertForNativeApi) QRoute.api(IPicConvertForNativeApi.class)).convertAvif2Jpg(quality, transcodeInfo);
        Intrinsics.checkNotNullExpressionValue(convertAvif2Jpg, "api(IPicConvertForNative\u2026g(quality, transcodeInfo)");
        return convertAvif2Jpg;
    }

    @Override // dx3.c
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return NetConnInfoCenter.getActiveNetIpFamily(false);
    }

    @Override // dx3.c
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // dx3.c
    @Nullable
    public WrapperEngineGlobalConfig d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (WrapperEngineGlobalConfig) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        QLog.w("QQ_InitialModuleInjector", 1, "getWrapperEngineGlobalConfig, useXlog=" + QLog.isUseXlog());
        return new WrapperEngineGlobalConfig(1, 6, AppSetting.f99554n, String.valueOf(Build.VERSION.SDK_INT), new InitGlobalPathConfig("", ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).getNTKernelDBPath(), ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).getNTKernelExtDataPath(), ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).getNTKernelTempPath(), ""), new ThumbConfig(), QLog.isUseXlog(), "");
    }

    @Override // dx3.c
    @NotNull
    public Integer fixPicImgType(@Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
        }
        return 0;
    }

    @Override // dx3.c
    @NotNull
    public Boolean generatePicAioThumb(@Nullable String srcPath, @Nullable String dstPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) srcPath, (Object) dstPath);
        }
        return Boolean.valueOf(((IGuildPicApi) QRoute.api(IGuildPicApi.class)).generateThumb(srcPath, dstPath));
    }

    @Override // dx3.c
    @NotNull
    public Boolean generateThumb(@Nullable String srcPath, @Nullable String dstPath, int thumbSize, int fileType) {
        Bitmap m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Boolean) iPatchRedirector.redirect((short) 6, this, srcPath, dstPath, Integer.valueOf(thumbSize), Integer.valueOf(fileType));
        }
        if (fileType != 2 && fileType != 5) {
            if (FileUtils.fileExists(dstPath)) {
                FileUtils.deleteFile(dstPath);
            }
            if (fileType == 1 && thumbSize == 0) {
                CompressInfo compressInfo = new CompressInfo(srcPath, 0);
                compressInfo.H = dstPath;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(srcPath, options);
                int max = Math.max(options.outWidth, options.outHeight);
                QRouteApi api = QRoute.api(IPicAIO.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IPicAIO::class.java)");
                IPicAIO iPicAIO = (IPicAIO) api;
                int thumbMinPx = iPicAIO.getThumbMinPx(false, true, max);
                int thumbMaxPx = iPicAIO.getThumbMaxPx(false, true, max);
                compressInfo.U = new ThumbWidthHeightDP(thumbMinPx, thumbMinPx, thumbMaxPx, thumbMaxPx);
                return Boolean.valueOf(((ICompressOperator) QRoute.api(ICompressOperator.class)).startThumbnail(compressInfo));
            }
            return Boolean.valueOf(((IGuildPicApi) QRoute.api(IGuildPicApi.class)).generateThumb(srcPath, dstPath));
        }
        if (srcPath != null && (m3 = f11.c.m(srcPath)) != null) {
            boolean b16 = com.tencent.biz.qqstory.utils.b.b(m3, dstPath);
            QLog.i("QQ_InitialModuleInjector", 1, "generateThumb " + srcPath + " dst: " + dstPath + " " + b16);
            return Boolean.valueOf(b16);
        }
        return Boolean.FALSE;
    }

    @Override // dx3.c
    @NotNull
    public DeviceCodecFormatInfo getDeviceCodecFormatInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (DeviceCodecFormatInfo) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        DeviceCodecFormatInfo deviceCodecFormatInfo = ((IGetDeviceInfoForNT) QRoute.api(IGetDeviceInfoForNT.class)).getDeviceCodecFormatInfo();
        Intrinsics.checkNotNullExpressionValue(deviceCodecFormatInfo, "api(IGetDeviceInfoForNT:\u2026va).deviceCodecFormatInfo");
        return deviceCodecFormatInfo;
    }

    @Override // dx3.c
    @NotNull
    public String getGuid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        String guid = MSFSharedPreUtils.getGuid();
        if (TextUtils.isEmpty(guid)) {
            guid = HexUtil.bytes2HexStr(((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).getGUID());
        }
        if (guid == null) {
            return "";
        }
        return guid;
    }

    @Override // dx3.c
    @NotNull
    public RichMediaImgSize getRichMediaImgSize(@Nullable String filePath, int fileType) {
        boolean z16;
        Bitmap m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RichMediaImgSize) iPatchRedirector.redirect((short) 5, (Object) this, (Object) filePath, fileType);
        }
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new RichMediaImgSize(0, 0);
        }
        if (fileType != 1) {
            if (fileType == 2 && (m3 = f11.c.m(filePath)) != null) {
                QLog.i("QQ_InitialModuleInjector", 1, "getRichMediaImgSize " + filePath + " width: " + m3.getWidth() + ", height: " + m3.getHeight());
                return new RichMediaImgSize(m3.getWidth(), m3.getHeight());
            }
            return new RichMediaImgSize(0, 0);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        QLog.i("QQ_InitialModuleInjector", 1, "getRichMediaImgSize " + filePath + " width: " + options.outWidth + ", height: " + options.outHeight);
        return new RichMediaImgSize(options.outWidth, options.outHeight);
    }

    @Override // dx3.c
    public void loadNativeLibrary(@NotNull Context context, @NotNull String libName, int version, boolean includePrivateLib) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, context, libName, Integer.valueOf(version), Boolean.valueOf(includePrivateLib));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(libName, "libName");
        ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).loadNativeLibrary(context, libName, version, includePrivateLib);
    }

    @Override // dx3.c
    public void onAccountChanged(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) app);
        } else {
            Intrinsics.checkNotNullParameter(app, "app");
        }
    }

    @Override // dx3.c
    @Nullable
    public IOperateResult onCompressVideo(@Nullable String srcVideoPath, @Nullable String dstVideoPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IOperateResult) iPatchRedirector.redirect((short) 7, (Object) this, (Object) srcVideoPath, (Object) dstVideoPath);
        }
        return ((IVideoCompressApi) QRoute.api(IVideoCompressApi.class)).onCompressVideo(srcVideoPath, dstVideoPath);
    }

    @Override // dx3.c
    public void onDataReport(@Nullable String uid, @Nullable String eventCode, boolean isSuc, @Nullable HashMap<String, String> params, boolean isRealTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, uid, eventCode, Boolean.valueOf(isSuc), params, Boolean.valueOf(isRealTime));
        }
    }

    @Override // dx3.c
    public void onDataReportWithAppKey(@Nullable String appKey, @Nullable String uid, @Nullable String eventCode, boolean isSuc, @Nullable HashMap<String, String> params, boolean isRealTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appKey, uid, eventCode, Boolean.valueOf(isSuc), params, Boolean.valueOf(isRealTime));
        }
    }

    @Override // dx3.c
    @Nullable
    public OpentelemetryTracePlan onGetMqqOpentelemetryTraceReportPlan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (OpentelemetryTracePlan) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    @Override // dx3.c
    public void onGetOfflineMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            ((IQQDataLineTempApi) QRoute.api(IQQDataLineTempApi.class)).onGetOfflineMsg();
        }
    }

    @Override // dx3.c
    @Nullable
    public Long onGetSrvCalTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Long) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // dx3.c
    public void onLog(int level, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, level, (Object) msg2);
        }
    }

    @Override // dx3.c
    @NotNull
    public MarkdownParseRsp onParseMarkdown(@Nullable MarkdownParseReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (MarkdownParseRsp) iPatchRedirector.redirect((short) 28, (Object) this, (Object) req);
        }
        MarkdownParseRsp parseMarkdown = ((IGuildMarkdownApi) QRoute.api(IGuildMarkdownApi.class)).parseMarkdown(req);
        Intrinsics.checkNotNullExpressionValue(parseMarkdown, "api(IGuildMarkdownApi::c\u2026.java).parseMarkdown(req)");
        return parseMarkdown;
    }

    @Override // dx3.c
    public void onRegisterCountInstruments(@Nullable ArrayList<String> names, int pubPolicy, int grapPolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, names, Integer.valueOf(pubPolicy), Integer.valueOf(grapPolicy));
        } else {
            if (names == null) {
                return;
            }
            NtKernelMetricHelper.f292997a.k(names, pubPolicy, grapPolicy);
        }
    }

    @Override // dx3.c
    public void onRegisterValueInstruments(@Nullable ArrayList<String> names, @Nullable ArrayList<Double> boundarys, int pubPolicy, int grapPolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, names, boundarys, Integer.valueOf(pubPolicy), Integer.valueOf(grapPolicy));
        } else if (names != null && boundarys != null) {
            NtKernelMetricHelper.f292997a.m(names, boundarys, pubPolicy, grapPolicy);
        }
    }

    @Override // dx3.c
    public void onReportCountIndicators(@Nullable HashMap<String, String> label, @Nullable String name, long count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, label, name, Long.valueOf(count));
        } else {
            if (name == null) {
                return;
            }
            NtKernelMetricHelper.f292997a.n(label, name, count);
        }
    }

    @Override // dx3.c
    public void onReportValueIndicators(@Nullable HashMap<String, String> label, @Nullable String name, double value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, label, name, Double.valueOf(value));
        } else {
            if (name == null) {
                return;
            }
            NtKernelMetricHelper.f292997a.q(label, name, value);
        }
    }

    @Override // dx3.c
    public void onShowErrUITips(@Nullable String errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) errMsg);
        }
    }

    @Override // dx3.c
    public void onUpdateGeneralFlag(int generalFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, generalFlag);
        } else if ((generalFlag & 32) == 32) {
            az.d(true);
        } else {
            az.d(false);
        }
    }
}
