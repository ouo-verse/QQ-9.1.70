package com.tencent.mobileqq.vas.font.api.impl;

import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Message;
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.k;
import com.tencent.biz.anonymous.a;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.io.File;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FontManagerServiceImpl implements IFontManagerService {
    private FontManager mFontManager;

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void addFontLoadCallback(FontLoadCallback fontLoadCallback) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.i(fontLoadCallback);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public boolean checkUpdateDIYConfig(AppRuntime appRuntime, String str, NTVasSimpleInfo nTVasSimpleInfo, int i3, int i16) {
        if (this.mFontManager != null) {
            return FontManager.n(str, nTVasSimpleInfo, i3, i16);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public boolean getChatFontAbility() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.s();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public String getEnlargeFontDesc() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.N;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public String getEnlargeFontImgURL() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.P;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public File getFontBaseDir() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.v();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public int getFontEffectPrefer() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.Q;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public k getFontInfo(int i3, int i16, boolean z16, String str, int i17) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.w(i3, i16, z16, str, i17);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public Drawable getFontNameDrawable(int i3) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.x(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public boolean getFounderDynamicFontAbility() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.y();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public boolean getFounderFontAbility() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.z();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public HandlerThread getHandlerThread() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.I;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public String getTestFontFile() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.D;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public int getTestFontType() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.C;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public int getVariedStyleIndex(long j3) {
        return FontManager.A(j3);
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public boolean handleMessage(Message message) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.handleMessage(message);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public boolean isAnonymousMsg(MessageRecord messageRecord) {
        return a.m(messageRecord);
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public boolean isSupportFont() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.f32639d;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public boolean isTestOn() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.f32644m.get();
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mFontManager = (FontManager) appRuntime.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void onDownloadComplete(int i3, int i16, String str) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.D(i3, i16, str);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void onProgress(int i3, float f16) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.E(i3, f16);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void onSoDownloadCompleted(int i3, int i16) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.F(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void openFontTest(boolean z16) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.G(z16);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public JSONObject queryInfo(int i3, int i16) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.H(i3, i16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void registerIPCDownloadListener(com.tencent.mobileqq.vip.k kVar) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.J(kVar);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void removeFontLoadCallback(FontLoadCallback fontLoadCallback) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.K(fontLoadCallback);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void resetLastSendReportTime() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.L();
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void setChatFontSwitchStatus(boolean z16) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.N(z16);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void setDownloadHYSoCallback(String str) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.K = str;
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void setTestFont(boolean z16, int i3, String str) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.O(z16, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void startDownload(int i3, String str, int i16) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.P(i3, str, i16);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public int stopDownload(int i3) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            return fontManager.Q(i3);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void tryInitHYEngine() {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.R();
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void updateDiyConfig(String str, int i3) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.S(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontManagerService
    public void updateSelfFontEffectId(String str, int i3) {
        FontManager fontManager = this.mFontManager;
        if (fontManager != null) {
            fontManager.T(str, i3);
        }
    }
}
