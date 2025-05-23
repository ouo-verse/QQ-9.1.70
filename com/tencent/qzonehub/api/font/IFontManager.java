package com.tencent.qzonehub.api.font;

import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.earlydownload.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.font.DefaultSuperFontInfo;
import cooperation.qzone.font.FontInterface;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IFontManager extends QRouteApi {
    boolean ETEngineLoaded();

    DefaultBarrageEffectInfo getDefaultBarrageEffectInfo(long j3);

    DefaultFontInfo getDefaultFont(long j3);

    DefaultSuperFontInfo getDefaultSuperFont(long j3);

    ETEngine getETEngine();

    String getFullTypeFont(int i3, String str, String str2, FontInterface.FullTypeResult fullTypeResult);

    String getTrueTypeFont(int i3, String str, String str2, boolean z16, FontInterface.TrueTypeResult trueTypeResult);

    void setDefaultBarrageEffect(long j3, DefaultBarrageEffectInfo defaultBarrageEffectInfo);

    void setDefaultFont(long j3, DefaultFontInfo defaultFontInfo);

    void setDefaultSuperFont(long j3, DefaultSuperFontInfo defaultSuperFontInfo);

    void startFontSoDownload(b bVar);
}
