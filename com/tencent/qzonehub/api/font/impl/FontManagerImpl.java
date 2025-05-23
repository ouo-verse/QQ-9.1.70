package com.tencent.qzonehub.api.font.impl;

import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.earlydownload.b;
import com.tencent.qzonehub.api.font.IFontManager;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.font.DefaultSuperFontInfo;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.font.FontManager;

/* compiled from: P */
/* loaded from: classes34.dex */
public class FontManagerImpl implements IFontManager {
    @Override // com.tencent.qzonehub.api.font.IFontManager
    public boolean ETEngineLoaded() {
        return FontManager.getInstance().ETEngineLoaded();
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public DefaultBarrageEffectInfo getDefaultBarrageEffectInfo(long j3) {
        return FontManager.getInstance().getDefaultBarrageEffectInfo(j3);
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public DefaultFontInfo getDefaultFont(long j3) {
        return FontManager.getInstance().getDefaultFont(j3);
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public DefaultSuperFontInfo getDefaultSuperFont(long j3) {
        return FontManager.getInstance().getDefaultSuperFont(j3);
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public ETEngine getETEngine() {
        return FontManager.getInstance().getETEngine();
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public String getFullTypeFont(int i3, String str, String str2, FontInterface.FullTypeResult fullTypeResult) {
        return FontManager.getInstance().getFullTypeFont(i3, str, str2, fullTypeResult);
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public String getTrueTypeFont(int i3, String str, String str2, boolean z16, FontInterface.TrueTypeResult trueTypeResult) {
        return FontManager.getInstance().getTrueTypeFont(i3, str, str2, z16, trueTypeResult);
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public void setDefaultBarrageEffect(long j3, DefaultBarrageEffectInfo defaultBarrageEffectInfo) {
        FontManager.getInstance().setDefaultBarrageEffect(j3, defaultBarrageEffectInfo);
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public void setDefaultFont(long j3, DefaultFontInfo defaultFontInfo) {
        FontManager.getInstance().setDefaultFont(j3, defaultFontInfo);
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public void setDefaultSuperFont(long j3, DefaultSuperFontInfo defaultSuperFontInfo) {
        FontManager.getInstance().setDefaultSuperFont(j3, defaultSuperFontInfo);
    }

    @Override // com.tencent.qzonehub.api.font.IFontManager
    public void startFontSoDownload(b bVar) {
        FontManager.getInstance().startFontSoDownload(bVar);
    }
}
