package com.qzone.common.activities;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.font.IFontManager;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.font.DefaultSuperFontInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FontCacheManager {

    /* renamed from: a, reason: collision with root package name */
    private static FontCacheManager f44974a;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CommentFontInfo implements SmartParcelable {

        /* renamed from: id, reason: collision with root package name */
        @NeedParcel
        public int f44975id = 0;

        @NeedParcel
        public int fontFormatType = 0;

        @NeedParcel
        public String fontUrl = "";

        @NeedParcel
        public int superFontId = -1;

        @NeedParcel
        public String superFontJson = "";

        @NeedParcel
        public int barrageEffectId = -1;

        @NeedParcel
        public String barrageEffectJson = "";
    }

    public static synchronized FontCacheManager a() {
        FontCacheManager fontCacheManager;
        synchronized (FontCacheManager.class) {
            if (f44974a == null) {
                synchronized (FontCacheManager.class) {
                    if (f44974a == null) {
                        f44974a = new FontCacheManager();
                    }
                }
            }
            fontCacheManager = f44974a;
        }
        return fontCacheManager;
    }

    public CommentFontInfo b() {
        CommentFontInfo commentFontInfo = new CommentFontInfo();
        DefaultFontInfo defaultFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultFont(LoginData.getInstance().getUin());
        if (defaultFont != null && !TextUtils.isEmpty(defaultFont.fontUrl)) {
            commentFontInfo.f44975id = defaultFont.fontId;
            commentFontInfo.fontFormatType = defaultFont.formatType;
            commentFontInfo.fontUrl = defaultFont.fontUrl;
        }
        DefaultSuperFontInfo defaultSuperFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultSuperFont(LoginData.getInstance().getUin());
        if (defaultSuperFont != null && !TextUtils.isEmpty(defaultSuperFont.jsonStr)) {
            commentFontInfo.superFontId = defaultSuperFont.fontId;
            commentFontInfo.superFontJson = defaultSuperFont.jsonStr;
        }
        DefaultBarrageEffectInfo defaultBarrageEffectInfo = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultBarrageEffectInfo(LoginData.getInstance().getUin());
        if (defaultBarrageEffectInfo != null && !TextUtils.isEmpty(defaultBarrageEffectInfo.jsonStr)) {
            commentFontInfo.barrageEffectId = defaultBarrageEffectInfo.itemId;
            commentFontInfo.barrageEffectJson = defaultBarrageEffectInfo.jsonStr;
        }
        return commentFontInfo;
    }
}
