package com.tencent.mobileqq.vas.font.api;

import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Message;
import com.etrump.mixlayout.k;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes20.dex */
public interface IFontManagerService extends IRuntimeService {
    void addFontLoadCallback(FontLoadCallback fontLoadCallback);

    boolean checkUpdateDIYConfig(AppRuntime appRuntime, String str, NTVasSimpleInfo nTVasSimpleInfo, int i3, int i16);

    boolean getChatFontAbility();

    String getEnlargeFontDesc();

    String getEnlargeFontImgURL();

    File getFontBaseDir();

    int getFontEffectPrefer();

    k getFontInfo(int i3, int i16, boolean z16, String str, int i17);

    Drawable getFontNameDrawable(int i3);

    boolean getFounderDynamicFontAbility();

    boolean getFounderFontAbility();

    HandlerThread getHandlerThread();

    String getTestFontFile();

    int getTestFontType();

    int getVariedStyleIndex(long j3);

    boolean handleMessage(Message message);

    boolean isAnonymousMsg(MessageRecord messageRecord);

    boolean isSupportFont();

    boolean isTestOn();

    void onDownloadComplete(int i3, int i16, String str);

    void onProgress(int i3, float f16);

    void onSoDownloadCompleted(int i3, int i16);

    void openFontTest(boolean z16);

    JSONObject queryInfo(int i3, int i16);

    void registerIPCDownloadListener(com.tencent.mobileqq.vip.k kVar);

    void removeFontLoadCallback(FontLoadCallback fontLoadCallback);

    void resetLastSendReportTime();

    void setChatFontSwitchStatus(boolean z16);

    void setDownloadHYSoCallback(String str);

    void setTestFont(boolean z16, int i3, String str);

    void startDownload(int i3, String str, int i16);

    int stopDownload(int i3);

    void tryInitHYEngine();

    void updateDiyConfig(String str, int i3);

    void updateSelfFontEffectId(String str, int i3);
}
