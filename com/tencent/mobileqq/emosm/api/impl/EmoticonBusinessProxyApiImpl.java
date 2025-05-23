package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emoticonview.AIEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import com.tencent.qqnt.msg.data.g;

/* loaded from: classes6.dex */
public class EmoticonBusinessProxyApiImpl implements IEmoticonBusinessProxyApi {
    private static final int MD5_LENGTH = 32;

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public String getCameraEmoHandlerImplClassName() {
        return CameraEmoRoamingHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public String getEmoticonHandlerImplClassName() {
        return EmoticonHandler.class.getName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        if (r7.length() == 32) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        r2 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        if (r7 != null) goto L25;
     */
    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getEmoticonMD5(EmoticonInfo emoticonInfo) {
        String str;
        String str2 = "";
        if (emoticonInfo instanceof FavoriteEmoticonInfo) {
            String str3 = ((FavoriteEmoticonInfo) emoticonInfo).resID;
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str3.split("_");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String str4 = split[i3];
                    if (str4.length() == 32) {
                        str2 = str4;
                        break;
                    }
                    i3++;
                }
            }
        } else if (emoticonInfo instanceof PicEmoticonInfo) {
            str = ((PicEmoticonInfo) emoticonInfo).getEid();
            if (!TextUtils.isEmpty(str)) {
            }
        } else if (emoticonInfo instanceof HotPicSearchEmoticonInfo) {
            EmotionSearchItem emotionSearchItem = ((HotPicSearchEmoticonInfo) emoticonInfo).mSearchItem;
            if (emotionSearchItem != null) {
                str = emotionSearchItem.md5;
            }
        }
        return str2.toLowerCase();
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public String getFavEmoHandlerImplClassName() {
        return FavEmoRoamingHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public String getFavEmoPath(EmoticonInfo emoticonInfo) {
        if (isFavoriteEmoticonType(emoticonInfo)) {
            return ((FavoriteEmoticonInfo) emoticonInfo).path;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public EmotionSearchItem getSearchItem(EmoticonInfo emoticonInfo) {
        if (isHotPicType(emoticonInfo)) {
            return ((HotPicSearchEmoticonInfo) emoticonInfo).mSearchItem;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public String getSearchWord(EmoticonInfo emoticonInfo) {
        String str;
        if (emoticonInfo instanceof HotPicSearchEmoticonInfo) {
            str = ((HotPicSearchEmoticonInfo) emoticonInfo).mSearchWord;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public String getVipComicMqqHandlerImplClassName() {
        return VipComicMqqHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public String getZPlanEmoPath(EmoticonInfo emoticonInfo) {
        return ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).getZPlanEmoPath(emoticonInfo);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public String getZPlanEmoTextSummary(EmoticonInfo emoticonInfo) {
        return ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).getZPlanEmoTextSummary(emoticonInfo);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public g getZPlanPicExtBizInfo(EmoticonInfo emoticonInfo) {
        return ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).getZPlanPicExtBizInfo(emoticonInfo);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public boolean isAIEmoticon(EmoticonInfo emoticonInfo) {
        return emoticonInfo instanceof AIEmoticonInfo;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public boolean isFavoriteEmoticonType(EmoticonInfo emoticonInfo) {
        return emoticonInfo instanceof FavoriteEmoticonInfo;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public boolean isHotPicFromSearchType(EmoticonInfo emoticonInfo) {
        if (emoticonInfo instanceof HotPicSearchEmoticonInfo) {
            return !TextUtils.isEmpty(((HotPicSearchEmoticonInfo) emoticonInfo).mSearchWord);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public boolean isHotPicType(EmoticonInfo emoticonInfo) {
        return emoticonInfo instanceof HotPicSearchEmoticonInfo;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public boolean isMarketFaceEmoticonType(EmoticonInfo emoticonInfo) {
        return emoticonInfo instanceof PicEmoticonInfo;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi
    public boolean isZPlanEmoticonType(EmoticonInfo emoticonInfo) {
        return ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).isZPlanEmoticonType(emoticonInfo);
    }
}
