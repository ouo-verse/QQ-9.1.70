package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.EmojiConstants;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceResImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.emoticonview.api.ISystemAndEmojiSenderService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SystemAndEmojiEmoticonInfo extends EmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int BLANK_FILLING_EMOTION_CODE = -1;
    public static final int COLUMNNUM_SYSTEM_AND_EMOJI;
    public static final Parcelable.Creator<SystemAndEmojiEmoticonInfo> CREATOR;
    public static int EMOJI_COUNT = 0;
    public static final String TAG = "SystemAndEmojiEmoticonInfo";
    public static final String TITLE_ANI_STICKER;
    public static final String TITLE_EMOJI;
    public static final String TITLE_OFTEN;
    public static final String TITLE_RARE_EMOTION;
    public static final String TITLE_SMALL_FACE;
    public static final String TITLE_SYSTEM;
    public static final String TITLE_YELLOW_FACE;
    public static final int TYPE_EMOJI = 2;
    public static final int TYPE_SYSTEM = 1;
    public static final int TYPE_TITLE = 3;
    public static final String YELLOW_FACE_ANI_STICKER_PACK_ID = "1";
    public int code;
    public int emotionType;
    public boolean isCommonUsed;
    private Drawable mDefault;
    public String title;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class EmoticonInfoList {
        static IPatchRedirector $redirector_;
        public int emojiCount;
        public final ArrayList<EmoticonInfo> emoticons;
        public int sysEmoticonCount;

        EmoticonInfoList(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.sysEmoticonCount = 0;
                this.emoticons = new ArrayList<>(i3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35675);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        EMOJI_COUNT = 165;
        TITLE_OFTEN = MobileQQ.sMobileQQ.getString(R.string.f230246ym);
        TITLE_SYSTEM = MobileQQ.sMobileQQ.getString(R.string.f230126ya);
        TITLE_EMOJI = MobileQQ.sMobileQQ.getString(R.string.f230196yh);
        TITLE_SMALL_FACE = MobileQQ.sMobileQQ.getString(R.string.f230276yp);
        TITLE_YELLOW_FACE = MobileQQ.sMobileQQ.getString(R.string.f230306ys);
        TITLE_ANI_STICKER = MobileQQ.sMobileQQ.getString(R.string.f230136yb);
        TITLE_RARE_EMOTION = MobileQQ.sMobileQQ.getString(R.string.f230236yl);
        CREATOR = new Parcelable.Creator<SystemAndEmojiEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SystemAndEmojiEmoticonInfo createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SystemAndEmojiEmoticonInfo(parcel) : (SystemAndEmojiEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SystemAndEmojiEmoticonInfo[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SystemAndEmojiEmoticonInfo[i3] : (SystemAndEmojiEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        };
        COLUMNNUM_SYSTEM_AND_EMOJI = EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI;
    }

    public SystemAndEmojiEmoticonInfo(int i3, int i16, int i17, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, Boolean.valueOf(z16));
            return;
        }
        this.mDefault = null;
        this.type = i3;
        this.emotionType = i16;
        this.code = i17;
        this.title = str;
        this.isCommonUsed = z16;
    }

    private static void addEmotionPanelData(List<EmotionPanelData> list, List<EmotionPanelData> list2, int i3, int i16, String str, int i17) {
        if (list2.isEmpty()) {
            return;
        }
        for (int i18 = 0; i18 < i3; i18++) {
            list.add(new SystemAndEmojiEmoticonInfo(7, 3, i17, str, false));
        }
        list.addAll(list2);
        int size = list2.size() % i3;
        if (size > 0) {
            for (int i19 = 0; i19 < i3 - size; i19++) {
                list.add(new SystemAndEmojiEmoticonInfo(7, i16, -1, "", false));
            }
        }
    }

    public static List<EmotionPanelData> getAniStickerPanelData(boolean z16, int i3, EmoticonParams emoticonParams) {
        int i16;
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> extAniStickerOrderList = QQSysFaceUtil.getExtAniStickerOrderList();
        if (extAniStickerOrderList != null || extAniStickerOrderList.size() > 0) {
            QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
            ArrayList arrayList2 = new ArrayList();
            Iterator<Integer> it = extAniStickerOrderList.iterator();
            String str = null;
            ArrayList arrayList3 = arrayList2;
            int i17 = -1;
            while (it.hasNext()) {
                Integer next = it.next();
                if (next == null) {
                    QLog.e(TAG, 1, "[getAniStickerPanelData] error, code is null!");
                } else {
                    try {
                        i16 = Integer.parseInt(resImpl.getAniStickerPackageId(next.intValue()));
                    } catch (NumberFormatException e16) {
                        QLog.e(TAG, 1, "getAniStickerPanelData NumberFormatException", e16);
                        i16 = -1;
                    }
                    String aniStickerPackageName = resImpl.getAniStickerPackageName(next.intValue());
                    if (!TextUtils.isEmpty(str)) {
                        if (!TextUtils.equals(str, aniStickerPackageName)) {
                            addEmotionPanelData(arrayList, arrayList3, i3, 1, str, i17);
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(new ExtAniStickerEmoticonInfo(7, 1, next.intValue(), "", false));
                    }
                    i17 = i16;
                    str = aniStickerPackageName;
                    arrayList3.add(new ExtAniStickerEmoticonInfo(7, 1, next.intValue(), "", false));
                }
            }
            if (!arrayList3.isEmpty()) {
                if (!TextUtils.isEmpty(str)) {
                    addEmotionPanelData(arrayList, arrayList3, i3, 1, str, i17);
                } else {
                    QLog.e(TAG, 1, "[getAniStickerPanelData] curCategoryPackageName is empty!");
                }
            }
        }
        return arrayList;
    }

    public static List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3) {
        return getCommonUsedSystemEmojiPanelData(iEmoticonMainPanelApp, i3, false);
    }

    public static List<EmotionPanelData> getCustomEmoticonPanelData(String str, int i3, List<EmotionPanelData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i16 = 0; i16 < i3; i16++) {
                arrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, str, false));
            }
            arrayList.addAll(list);
            int size = list.size() % i3;
            if (size > 0) {
                for (int i17 = 0; i17 < i3 - size; i17++) {
                    arrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
                }
            }
        }
        return arrayList;
    }

    public static List<EmotionPanelData> getEmojiEmoticonPanelData(int i3, ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i16 = 0; i16 < i3; i16++) {
                arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, TITLE_EMOJI, false));
            }
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                Integer num = arrayList.get(i17);
                if (num == null) {
                    QLog.e(TAG, 1, "[getEmojiEmoticonPanelData] curEmojiOrderList error, emo code is null!");
                } else {
                    arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 2, num.intValue(), "", false));
                }
            }
            int size = arrayList.size() % i3;
            if (size > 0) {
                for (int i18 = 0; i18 < i3 - size; i18++) {
                    arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
                }
            }
        }
        return arrayList2;
    }

    public static List<EmotionPanelData> getEmoticonList(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3) {
        return getEmoticonListFromConfig(iEmoticonMainPanelApp, false, COLUMNNUM_SYSTEM_AND_EMOJI, i3);
    }

    public static List<EmotionPanelData> getEmoticonListFromConfig(IEmoticonMainPanelApp iEmoticonMainPanelApp, boolean z16, int i3, int i16) {
        return getEmoticonListFromConfig(iEmoticonMainPanelApp, z16, i3, i16, new EmoticonParams());
    }

    public static EmoticonInfoList getOldEmoticonList(int[] iArr) {
        EmoticonInfoList emoticonInfoList = new EmoticonInfoList(iArr.length + EMOJI_COUNT);
        ArrayList<EmoticonInfo> arrayList = emoticonInfoList.emoticons;
        int i3 = EMOJI_COUNT % 20;
        for (int i16 = r2 - 1; i16 >= EMOJI_COUNT - i3; i16--) {
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i16, "", false));
        }
        for (int i17 = 0; i17 < 20 - i3; i17++) {
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
        }
        for (int i18 = (EMOJI_COUNT - i3) - 1; i18 >= 0; i18--) {
            if (!QQSysAndEmojiResMgr.getInstance().getResImpl(2).checkEmoticonShouldHide(i18)) {
                arrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i18, "", false));
            }
        }
        emoticonInfoList.emojiCount = arrayList.size();
        for (int i19 : iArr) {
            if (!QQSysAndEmojiResMgr.getInstance().getResImpl(1).checkEmoticonShouldHide(i19)) {
                emoticonInfoList.sysEmoticonCount++;
                arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, i19, "", false));
            }
        }
        return emoticonInfoList;
    }

    public static List<EmotionPanelData> getOnlySysEmoticonListFromConfig(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, int[] iArr) {
        int[] iArr2 = iArr;
        if (iEmoticonMainPanelApp == null) {
            QLog.e(TAG, 1, "getEmoticonList app = null");
            return null;
        }
        if (iArr2 == null || iArr2.length == 0) {
            iArr2 = SystemEmoticonInfo.getSysEmotionOrder();
        }
        ArrayList arrayList = new ArrayList(iArr2.length);
        for (int i16 : iArr2) {
            arrayList.add(Integer.valueOf(i16));
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i17 = 0; i17 < size; i17++) {
            Integer num = (Integer) arrayList.get(i17);
            if (num == null) {
                QLog.e(TAG, 1, "[getEmojiEmoticonPanelData] curEmojiOrderList error, emo code is null!");
            } else if (!com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(num.intValue())) {
                if (num.intValue() == -1) {
                    arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 1, 0, "", false));
                } else {
                    arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 1, num.intValue(), "", false));
                }
            }
        }
        int size2 = arrayList2.size() % i3;
        if (size2 > 0) {
            for (int i18 = 0; i18 < i3 - size2; i18++) {
                arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
            }
        }
        return arrayList2;
    }

    public static int getPageCount(int[] iArr) {
        return getPageCount(iArr.length);
    }

    public static List<EmotionPanelData> getRecentEmoticonPanelData(boolean z16, int i3, EmoticonParams emoticonParams, List<EmotionPanelData> list) {
        List<EmotionPanelData> sysEmotionPanelData = getSysEmotionPanelData(z16, i3, emoticonParams);
        List<EmotionPanelData> emojiEmoticonPanelData = getEmojiEmoticonPanelData(i3, QQEmojiUtil.getOrderList());
        List<EmotionPanelData> customEmoticonPanelData = getCustomEmoticonPanelData(TITLE_OFTEN, i3, list);
        ArrayList arrayList = new ArrayList();
        if (!customEmoticonPanelData.isEmpty()) {
            for (EmotionPanelData emotionPanelData : customEmoticonPanelData) {
                if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
                    if (systemAndEmojiEmoticonInfo.emotionType != 3) {
                        systemAndEmojiEmoticonInfo.title = TITLE_OFTEN;
                    }
                }
            }
            arrayList.addAll(customEmoticonPanelData);
        }
        if (!sysEmotionPanelData.isEmpty()) {
            for (EmotionPanelData emotionPanelData2 : sysEmotionPanelData) {
                if (emotionPanelData2 instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo2 = (SystemAndEmojiEmoticonInfo) emotionPanelData2;
                    if (systemAndEmojiEmoticonInfo2.emotionType != 3) {
                        systemAndEmojiEmoticonInfo2.title = TITLE_SYSTEM;
                    }
                }
            }
            arrayList.addAll(sysEmotionPanelData);
        }
        if (!emojiEmoticonPanelData.isEmpty()) {
            for (EmotionPanelData emotionPanelData3 : emojiEmoticonPanelData) {
                if (emotionPanelData3 instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo3 = (SystemAndEmojiEmoticonInfo) emotionPanelData3;
                    if (systemAndEmojiEmoticonInfo3.emotionType != 3) {
                        systemAndEmojiEmoticonInfo3.title = TITLE_EMOJI;
                    }
                }
            }
            arrayList.addAll(emojiEmoticonPanelData);
        }
        return arrayList;
    }

    public static List<EmotionPanelData> getSmallAndAniStickerPanelData(int i3, boolean z16, ArrayList<Integer> arrayList, boolean z17) {
        ArrayList<Integer> arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4 = new ArrayList();
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            boolean g16 = com.tencent.mobileqq.emoticon.rare.config.c.f204869a.g();
            if (com.tencent.mobileqq.emoticon.u.f204891a.b()) {
                arrayList2 = QQSysFaceUtil.getExtAniStickerOrderList();
                if (arrayList2 != null && arrayList2.size() > 0) {
                    Iterator<Integer> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        Integer next = it.next();
                        if (next != null) {
                            arrayList6.add(new SystemAndEmojiEmoticonInfo(7, 1, next.intValue(), "", false));
                        } else {
                            QLog.e(TAG, 1, "[getSmallAndAniStickerPanelData] curExtAniStickerOrderList error, face code is null!");
                        }
                    }
                }
            } else {
                arrayList2 = null;
            }
            int size = arrayList.size();
            for (int i16 = 0; i16 < size; i16++) {
                Integer num = arrayList.get(i16);
                if (num == null) {
                    QLog.e(TAG, 1, "[getSmallAndAniStickerPanelData] curSysFaceOrderList error, face code is null!");
                } else if (!z16 || num.intValue() <= 255) {
                    if (g16) {
                        if (com.tencent.mobileqq.emoticon.rare.config.c.f204869a.b().e(QQSysFaceUtil.convertToServer(num.intValue()))) {
                            arrayList7.add(new SystemAndEmojiEmoticonInfo(7, 1, num.intValue(), "", false));
                        }
                    }
                    if (isAniStickerEnable(num.intValue(), z17)) {
                        if (arrayList2 == null || !arrayList2.contains(num)) {
                            arrayList3 = arrayList6;
                        }
                    } else {
                        arrayList3 = arrayList5;
                    }
                    if (num.intValue() == -1) {
                        arrayList3.add(new SystemAndEmojiEmoticonInfo(7, 1, 0, "", false));
                    } else {
                        arrayList3.add(new SystemAndEmojiEmoticonInfo(7, 1, num.intValue(), "", false));
                    }
                }
            }
            if (arrayList6.isEmpty()) {
                addEmotionPanelData(arrayList4, arrayList5, i3, 1, TITLE_SYSTEM, -1);
            } else {
                addEmotionPanelData(arrayList4, arrayList6, i3, 1, TITLE_ANI_STICKER, -1);
                addEmotionPanelData(arrayList4, arrayList5, i3, 1, TITLE_SMALL_FACE, -1);
            }
            if (g16 && !arrayList7.isEmpty()) {
                String b16 = com.tencent.mobileqq.emoticon.rare.config.c.f204869a.b().b();
                if (TextUtils.isEmpty(b16)) {
                    b16 = TITLE_RARE_EMOTION;
                }
                addEmotionPanelData(arrayList4, arrayList7, i3, 1, b16, -1);
            }
        }
        return arrayList4;
    }

    public static List<EmotionPanelData> getSysEmotionPanelData(boolean z16, int i3, EmoticonParams emoticonParams) {
        boolean z17 = !emoticonParams.keepLottieMerged;
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> orderList = QQSysFaceUtil.getOrderList();
        if (z17) {
            arrayList.addAll(getSmallAndAniStickerPanelData(i3, z16, orderList, emoticonParams.randomLottieEmoSwitch));
        } else {
            arrayList.addAll(getSystemEmoticonPanelData(i3, z16, orderList));
        }
        return arrayList;
    }

    public static List<EmotionPanelData> getSystemEmoticonPanelData(int i3, ArrayList<Integer> arrayList) {
        return getSystemEmoticonPanelData(i3, false, arrayList);
    }

    public static List<EmotionPanelData> getUniversalEmoticonListFromConfig(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, boolean z16, boolean z17, boolean z18, boolean z19) {
        ArrayList<Integer> orderList = QQSysFaceUtil.getOrderList();
        ArrayList<Integer> orderList2 = QQEmojiUtil.getOrderList();
        ArrayList arrayList = new ArrayList(orderList.size() + orderList2.size());
        if (z16) {
            arrayList.addAll(getCommonUsedSystemEmojiPanelData(iEmoticonMainPanelApp, i3, z18));
        }
        if (z19) {
            arrayList.addAll(getSmallAndAniStickerPanelData(i3, z18, orderList, true));
        } else {
            arrayList.addAll(getSystemEmoticonPanelData(i3, z18, orderList));
        }
        if (z17) {
            arrayList.addAll(getEmojiEmoticonPanelData(i3, orderList2));
        }
        return arrayList;
    }

    public static boolean isAniStickerEnable(int i3, boolean z16) {
        int aniStickerType = ((QQSysFaceResImpl) QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerType(i3);
        if (QQSysFaceUtil.isRandomAniStickerByType(aniStickerType)) {
            return z16;
        }
        return QQSysFaceUtil.isBigStickerByType(aniStickerType);
    }

    public static void preload(AppRuntime appRuntime) {
        URLDrawable uRLDrawable;
        EmoticonParams emoticonParams = new EmoticonParams(0, true);
        emoticonParams.foreSplitLottieSticker = true;
        List<EmotionPanelData> emoticonListFromConfig = getEmoticonListFromConfig(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(appRuntime), false, COLUMNNUM_SYSTEM_AND_EMOJI, 0, emoticonParams);
        if (emoticonListFromConfig != null && emoticonListFromConfig.size() > 0) {
            int i3 = EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI * 12;
            for (int i16 = 0; i16 < i3 && i16 < emoticonListFromConfig.size(); i16++) {
                EmotionPanelData emotionPanelData = emoticonListFromConfig.get(i16);
                if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
                    if (systemAndEmojiEmoticonInfo.type != 3 && systemAndEmojiEmoticonInfo.code != -1 && (uRLDrawable = (URLDrawable) systemAndEmojiEmoticonInfo.getDrawable(false)) != null && uRLDrawable.getStatus() != 1) {
                        uRLDrawable.startDownload();
                    }
                }
            }
        }
    }

    public void addToCommonUsed(AppRuntime appRuntime, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).addToCommonUsed(appRuntime, parcelable, this.code, this.emotionType);
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) appRuntime, (Object) parcelable);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getBigDrawable(Context context, float f16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Drawable) iPatchRedirector.redirect((short) 12, this, context, Float.valueOf(f16));
        }
        int i16 = this.emotionType;
        if (i16 == 1 && (i3 = this.code) != -1) {
            return com.tencent.mobileqq.text.TextUtils.getSysEmotcationDrawable(i3, true);
        }
        if (i16 == 2 && this.code != -1) {
            return super.getBigDrawable(context, f16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public String getBigImagePath() {
        QQSysAndEmojiResInfo resImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.type != 7 || (resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(this.emotionType)) == null) {
            return null;
        }
        return QQSysAndEmojiResMgr.getInstance().getFullResPath(4, resImpl.getServerId(this.code));
    }

    public int getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.code;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? getSystemEmojiStaticImg(this.code, true) : (Drawable) iPatchRedirector.redirect((short) 10, this, context, Float.valueOf(f16));
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public int getEmoticonType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.type;
    }

    public String getEncodedString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return QQSysFaceUtil.getFaceString(this.code);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String faceDescription = QQSysFaceUtil.getFaceDescription(this.code);
        if (faceDescription == null) {
            return "";
        }
        return faceDescription;
    }

    public Drawable getSystemEmojiStaticImg(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        int i16 = this.emotionType;
        if (1 == i16 && this.code != -1) {
            return QQSysFaceUtil.getFaceDrawable(i3);
        }
        if (2 == i16 && this.code != -1) {
            return QQEmojiUtil.getEmojiDrawable(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public String getThumbImagePath() {
        QQSysAndEmojiResInfo resImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.type != 7 || (resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(this.emotionType)) == null) {
            return null;
        }
        return QQSysAndEmojiResMgr.getInstance().getFullResPath(2, resImpl.getServerId(this.code));
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appRuntime, context, editText, parcelable);
        } else {
            ((ISystemAndEmojiSenderService) QRoute.api(ISystemAndEmojiSenderService.class)).send(this, appRuntime, context, editText, parcelable);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) parcel, i3);
            return;
        }
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.emotionType);
        parcel.writeInt(this.code);
        parcel.writeString(this.title);
        parcel.writeByte(this.isCommonUsed ? (byte) 1 : (byte) 0);
    }

    public static List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, boolean z16) {
        return ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).getCommonUsedSystemEmojiPanelData(iEmoticonMainPanelApp, i3, z16);
    }

    public static List<EmotionPanelData> getEmoticonList(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, int i16) {
        return ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).getEmoticonList(iEmoticonMainPanelApp, i3, i16);
    }

    public static List<EmotionPanelData> getEmoticonListFromConfig(IEmoticonMainPanelApp iEmoticonMainPanelApp, boolean z16, int i3, int i16, EmoticonParams emoticonParams) {
        if (iEmoticonMainPanelApp == null) {
            QLog.e(TAG, 1, "getEmoticonList app = null");
            return null;
        }
        List<EmotionPanelData> sysEmotionPanelData = getSysEmotionPanelData(z16, i3, emoticonParams);
        ArrayList<Integer> orderList = QQEmojiUtil.getOrderList();
        ArrayList arrayList = new ArrayList(sysEmotionPanelData.size() + orderList.size());
        if (i16 != 2 && i16 != 3) {
            arrayList.addAll(getCommonUsedSystemEmojiPanelData(iEmoticonMainPanelApp, i3, z16));
        }
        arrayList.addAll(sysEmotionPanelData);
        if (i16 != 2) {
            arrayList.addAll(getEmojiEmoticonPanelData(i3, orderList));
        }
        return arrayList;
    }

    public static int getPageCount(int i3) {
        return (i3 + 19) / 20;
    }

    public static List<EmotionPanelData> getSystemEmoticonPanelData(int i3, boolean z16, ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i16 = 0; i16 < i3; i16++) {
                arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, TITLE_SYSTEM, false));
            }
            int size = arrayList.size();
            int i17 = 0;
            for (int i18 = 0; i18 < size; i18++) {
                Integer num = arrayList.get(i18);
                if (num == null) {
                    QLog.e(TAG, 1, "[getSystemEmoticonPanelData] curSysFaceOrderList error, emo code is null!");
                } else if (z16 && num.intValue() > 255) {
                    i17++;
                } else if (num.intValue() == -1) {
                    arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 1, 0, "", false));
                } else {
                    arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 1, num.intValue(), "", false));
                }
            }
            int size2 = (arrayList.size() - i17) % i3;
            if (size2 > 0) {
                for (int i19 = 0; i19 < i3 - size2; i19++) {
                    arrayList2.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
                }
            }
        }
        return arrayList2;
    }

    public void addToCommonUsed(IEmoticonMainPanelApp iEmoticonMainPanelApp, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).addToCommonUsed(iEmoticonMainPanelApp, parcelable, this.code, this.emotionType);
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) iEmoticonMainPanelApp, (Object) parcelable);
        }
    }

    public Drawable getDrawable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? getSystemEmojiStaticImg(this.code, z16) : (Drawable) iPatchRedirector.redirect((short) 11, (Object) this, z16);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class EmoticonParams {
        static IPatchRedirector $redirector_;
        private boolean foreSplitLottieSticker;
        boolean keepLottieMerged;
        boolean randomLottieEmoSwitch;
        int sessionType;

        public EmoticonParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.sessionType = -1;
            this.randomLottieEmoSwitch = false;
            this.keepLottieMerged = false;
            this.foreSplitLottieSticker = false;
        }

        public EmoticonParams(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.keepLottieMerged = false;
            this.foreSplitLottieSticker = false;
            this.sessionType = i3;
            this.randomLottieEmoSwitch = z16;
        }

        public EmoticonParams(int i3, boolean z16, boolean z17) {
            this(i3, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.keepLottieMerged = z17;
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SystemAndEmojiEmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mDefault = null;
        this.emotionType = parcel.readInt();
        this.code = parcel.readInt();
        this.title = parcel.readString();
        this.isCommonUsed = parcel.readByte() != 0;
    }

    public static List<EmotionPanelData> getUniversalEmoticonListFromConfig(int i3, boolean z16, boolean z17, boolean z18) {
        ArrayList<Integer> orderList = QQSysFaceUtil.getOrderList();
        ArrayList<Integer> orderList2 = QQEmojiUtil.getOrderList();
        ArrayList arrayList = new ArrayList(orderList.size() + orderList2.size());
        if (z16) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime instanceof BaseQQAppInterface) {
                arrayList.addAll(getCommonUsedSystemEmojiPanelData(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(waitAppRuntime), i3, z18));
            }
        }
        arrayList.addAll(getSystemEmoticonPanelData(i3, z18, orderList));
        if (z17) {
            arrayList.addAll(getEmojiEmoticonPanelData(i3, orderList2));
        }
        return arrayList;
    }
}
