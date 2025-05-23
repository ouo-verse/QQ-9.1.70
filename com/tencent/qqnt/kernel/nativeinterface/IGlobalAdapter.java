package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IGlobalAdapter {
    AvifTranscodeResult avifTranscodeJpgAndGenAIOThumb(int i3, AvifTranscodeInfo avifTranscodeInfo);

    CopyImgWithDelGPSResult copyImgWithDelGPS(String str, String str2);

    Integer fixPicImgType(String str);

    Boolean generatePicAioThumb(String str, String str2);

    Boolean generateThumb(String str, String str2, int i3, int i16);

    Integer getActiveIPStackType();

    AppSetting getAppSetting();

    DeviceCodecFormatInfo getDeviceCodecFormatInfo();

    DeviceInfo getDeviceInfo();

    Integer getMSFUsedIpProtocolType();

    RichMediaImgSize getRichMediaImgSize(String str, int i3);

    IOperateResult onCompressVideo(String str, String str2);

    void onDataReport(String str, String str2, boolean z16, HashMap<String, String> hashMap, boolean z17);

    void onDataReportWithAppKey(String str, String str2, String str3, boolean z16, HashMap<String, String> hashMap, boolean z17);

    OpentelemetryTracePlan onGetMqqOpentelemetryTraceReportPlan();

    void onGetOfflineMsg();

    Long onGetSrvCalTime();

    void onInstallFinished(boolean z16);

    void onLog(int i3, String str);

    MarkdownParseRsp onParseMarkdown(MarkdownParseReq markdownParseReq);

    void onRegisterCountInstruments(ArrayList<String> arrayList, int i3, int i16);

    void onRegisterValueInstruments(ArrayList<String> arrayList, ArrayList<Double> arrayList2, int i3, int i16);

    void onReportCountIndicators(HashMap<String, String> hashMap, String str, long j3);

    void onReportValueIndicators(HashMap<String, String> hashMap, String str, double d16);

    void onSendSSORequest(long j3, String str, byte[] bArr, SendRequestParam sendRequestParam, String str2, HashMap<String, byte[]> hashMap, int i3);

    void onShowErrUITips(String str);

    void onUpdateGeneralFlag(int i3);
}
