package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticon.CommonUsedSystemEmojiManagerConstants;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb$SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x13Rsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CommonUsedSystemEmojiManagerServiceImpl implements ICommonUsedSystemEmojiManagerService {
    public static final int[] DEFAULT_IDS;
    private static final HashMap<Integer, Integer> EMOJI_CONVERT_MAP;
    public static final String TAG = "CommonUsedSystemEmojiManager";
    private AppInterface app;
    private boolean hasWhiteList;
    public List<EmosmPb$SmallYellowItem> itemInfos = new ArrayList();
    public Object lock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Comparator<EmosmPb$SmallYellowItem> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EmosmPb$SmallYellowItem emosmPb$SmallYellowItem, EmosmPb$SmallYellowItem emosmPb$SmallYellowItem2) {
            if (emosmPb$SmallYellowItem2.f342126ts.get() > emosmPb$SmallYellowItem.f342126ts.get()) {
                return 1;
            }
            if (emosmPb$SmallYellowItem2.f342126ts.get() == emosmPb$SmallYellowItem.f342126ts.get()) {
                return 0;
            }
            return -1;
        }
    }

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>(5);
        EMOJI_CONVERT_MAP = hashMap;
        hashMap.put(217, 0);
        hashMap.put(223, 3);
        hashMap.put(168, 8);
        hashMap.put(219, 10);
        hashMap.put(212, 12);
        DEFAULT_IDS = new int[]{128525, 13, 128532, 5, 6, 14, 3, 20, 109, 28, 127874, 63, 9, 1, 49, 22, 128557, 11, 128169, 128163, 98, 27, 35, 2};
    }

    private void printAfterSortLog(List<EmosmPb$SmallYellowItem> list) {
        if (list != null && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("mergeAndSortSystemEmojiInfo:");
            sb5.append("after sort ,mergeList:");
            for (int i3 = 0; i3 < list.size(); i3++) {
                EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = list.get(i3);
                sb5.append("type = " + emosmPb$SmallYellowItem.type.get());
                sb5.append(";id = " + emosmPb$SmallYellowItem.f342125id.get());
                sb5.append(";ts = " + emosmPb$SmallYellowItem.f342126ts.get());
            }
            QLog.d(TAG, 2, "mergeAndSortSystemEmojiInfo merge:" + sb5.toString());
        }
    }

    private void printBeforeSortLog(List<EmosmPb$SmallYellowItem> list, List<EmosmPb$SmallYellowItem> list2) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("mergeAndSortSystemEmojiInfo:");
            if (list != null) {
                sb5.append("befor sort list1 : ");
                for (int i3 = 0; i3 < list.size(); i3++) {
                    EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = list.get(i3);
                    sb5.append("type = " + emosmPb$SmallYellowItem.type.get());
                    sb5.append(";id = " + emosmPb$SmallYellowItem.f342125id.get());
                    sb5.append(";ts = " + emosmPb$SmallYellowItem.f342126ts.get());
                }
            }
            if (list2 != null) {
                sb5.append("befor sort list2 : ");
                for (int i16 = 0; i16 < list2.size(); i16++) {
                    EmosmPb$SmallYellowItem emosmPb$SmallYellowItem2 = list2.get(i16);
                    sb5.append("type = " + emosmPb$SmallYellowItem2.type.get());
                    sb5.append(";id = " + emosmPb$SmallYellowItem2.f342125id.get());
                    sb5.append(";ts = " + emosmPb$SmallYellowItem2.f342126ts.get());
                }
            }
            QLog.d(TAG, 2, "mergeAndSortSystemEmojiInfo merge:" + sb5.toString());
        }
    }

    private void saveMergeInfoToFile(List<EmosmPb$SmallYellowItem> list) {
        synchronized (this.lock) {
            File file = new File(BaseApplication.getContext().getFilesDir(), CommonUsedSystemEmojiManagerConstants.COMMONUSED_SYSTEM_EMOJI_FILE_NAME_V2_ + MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
            EmosmPb$SubCmd0x13Rsp emosmPb$SubCmd0x13Rsp = new EmosmPb$SubCmd0x13Rsp();
            emosmPb$SubCmd0x13Rsp.itemlist.set(list);
            FileUtils.pushData2File(file.getAbsolutePath(), emosmPb$SubCmd0x13Rsp.toByteArray(), false);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public void copySystemEmojiFileToFileV2(File file, File file2) {
        byte[] fileToBytes;
        synchronized (this.lock) {
            fileToBytes = FileUtils.fileToBytes(file);
        }
        if (fileToBytes == null) {
            QLog.e(TAG, 1, "Can not translate pb file to byte");
            return;
        }
        EmosmPb$SubCmd0x13Rsp emosmPb$SubCmd0x13Rsp = new EmosmPb$SubCmd0x13Rsp();
        try {
            emosmPb$SubCmd0x13Rsp.mergeFrom(fileToBytes);
            emosmPb$SubCmd0x13Rsp.itemlist.set(emosmPb$SubCmd0x13Rsp.itemlist.get());
            FileUtils.pushData2File(file2.getAbsolutePath(), emosmPb$SubCmd0x13Rsp.toByteArray(), false);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getLocalSystemEmojiInfoFromFile mergeFromBody exception e = " + e16.getMessage());
        }
    }

    public void filterAbnormalData(List<EmosmPb$SmallYellowItem> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = list.get(i3);
            int i16 = emosmPb$SmallYellowItem.type.get();
            int i17 = emosmPb$SmallYellowItem.f342125id.get();
            if (i16 == 1) {
                int convertToLocal = QQSysFaceUtil.convertToLocal(i17);
                if (convertToLocal != -1) {
                    if (convertToLocal == 250) {
                        convertToLocal = 10;
                    }
                    if (QQSysFaceUtil.isValidFaceId(convertToLocal)) {
                        emosmPb$SmallYellowItem.f342125id.set(convertToLocal);
                    } else {
                        arrayList.add(emosmPb$SmallYellowItem);
                        QLog.e(TAG, 1, "updateItemInfo system id overflow index = " + i17 + ";emId = " + convertToLocal);
                    }
                } else {
                    arrayList.add(emosmPb$SmallYellowItem);
                    QLog.e(TAG, 1, "updateItemInfo system id overflow index = " + i17);
                }
            } else if (i16 == 2) {
                int emojiLocalId = QQEmojiUtil.getEmojiLocalId(i17);
                HashMap<Integer, Integer> hashMap = EMOJI_CONVERT_MAP;
                if (hashMap.containsKey(Integer.valueOf(emojiLocalId))) {
                    QLog.d(TAG, 2, "updateItemInfo before EMOTIONPANEL_EMOJI_MAP index = " + emojiLocalId);
                    emojiLocalId = hashMap.get(Integer.valueOf(emojiLocalId)).intValue();
                    QLog.d(TAG, 2, "updateItemInfo after EMOTIONPANEL_EMOJI_MAP index = " + emojiLocalId);
                }
                if (emojiLocalId < 0) {
                    arrayList.add(emosmPb$SmallYellowItem);
                    QLog.e(TAG, 1, "updateItemInfo emoji id overflow index = " + i17 + ";localIndex = " + emojiLocalId);
                } else {
                    emosmPb$SmallYellowItem.f342125id.set(emojiLocalId);
                }
            }
        }
        if (arrayList.size() > 0) {
            list.removeAll(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public List<EmosmPb$SmallYellowItem> getCacheInfo() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCacheInfo");
        }
        List<EmosmPb$SmallYellowItem> list = this.itemInfos;
        if (list != null && list.size() >= 1) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<EmosmPb$SmallYellowItem> it = this.itemInfos.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
            return arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCacheInfo is null");
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public List<EmosmPb$SmallYellowItem> getCommonUsedSystemEmojiInfo() {
        List<EmosmPb$SmallYellowItem> list = this.itemInfos;
        if (list != null && list.size() >= 1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getCommonUsedSystemEmojiInfo ");
            }
            List<EmosmPb$SmallYellowItem> cacheInfo = getCacheInfo();
            if (!this.hasWhiteList && cacheInfo != null) {
                Iterator<EmosmPb$SmallYellowItem> it = cacheInfo.iterator();
                while (it.hasNext()) {
                    EmosmPb$SmallYellowItem next = it.next();
                    if (QQSysAndEmojiResMgr.getInstance().getResImpl(next.type.get()).checkEmoticonShouldHide(next.f342125id.get())) {
                        it.remove();
                    }
                }
            }
            return cacheInfo;
        }
        QLog.e(TAG, 1, "getCommonUsedSystemEmojiInfo  useDefaultinfo");
        updateCacheFromFile();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int[] iArr = DEFAULT_IDS;
            if (i3 < iArr.length) {
                EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = new EmosmPb$SmallYellowItem();
                int i16 = iArr[i3];
                if (i16 > QQSysFaceUtil.maxServerId()) {
                    emosmPb$SmallYellowItem.type.set(2);
                    int emojiLocalId = QQEmojiUtil.getEmojiLocalId(i16);
                    HashMap<Integer, Integer> hashMap = EMOJI_CONVERT_MAP;
                    if (hashMap.containsKey(Integer.valueOf(emojiLocalId))) {
                        QLog.d(TAG, 2, "getCommonUsedSystemEmojiInfo dedault before EMOTIONPANEL_EMOJI_MAP index = " + emojiLocalId);
                        emojiLocalId = hashMap.get(Integer.valueOf(emojiLocalId)).intValue();
                        QLog.d(TAG, 2, "getCommonUsedSystemEmojiInfo dedault after EMOTIONPANEL_EMOJI_MAP index = " + emojiLocalId);
                    }
                    emosmPb$SmallYellowItem.f342125id.set(emojiLocalId);
                } else {
                    emosmPb$SmallYellowItem.type.set(1);
                    int convertToLocal = QQSysFaceUtil.convertToLocal(i16);
                    if (convertToLocal == 250) {
                        convertToLocal = 10;
                    }
                    emosmPb$SmallYellowItem.f342125id.set(convertToLocal);
                }
                if (QQSysAndEmojiResMgr.getInstance().getResImpl(emosmPb$SmallYellowItem.type.get()).checkEmoticonShouldHide(emosmPb$SmallYellowItem.f342125id.get())) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "emo should be hided:", Integer.valueOf(emosmPb$SmallYellowItem.f342125id.get()), " ,type:", Integer.valueOf(emosmPb$SmallYellowItem.type.get()));
                    }
                } else {
                    emosmPb$SmallYellowItem.f342126ts.set(0L);
                    arrayList.add(emosmPb$SmallYellowItem);
                }
                i3++;
            } else {
                synchronized (this) {
                    this.itemInfos = arrayList;
                }
                return getCacheInfo();
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public List<EmosmPb$SmallYellowItem> getLocalSystemEmojiInfoFromFile() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getLocalSystemEmojiInfoFromFile");
        }
        synchronized (this.lock) {
            File file = new File(BaseApplication.getContext().getFilesDir(), CommonUsedSystemEmojiManagerConstants.COMMONUSED_SYSTEM_EMOJI_FILE_NAME_V2_ + MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
            if (!file.exists()) {
                QLog.d(TAG, 2, "getLocalSystemEmojiInfoFromFile file not exists");
                return null;
            }
            byte[] fileToBytes = FileUtils.fileToBytes(file);
            if (fileToBytes == null) {
                QLog.e(TAG, 1, "Can not translate pb file to byte");
                return null;
            }
            EmosmPb$SubCmd0x13Rsp emosmPb$SubCmd0x13Rsp = new EmosmPb$SubCmd0x13Rsp();
            try {
                emosmPb$SubCmd0x13Rsp.mergeFrom(fileToBytes);
                List<EmosmPb$SmallYellowItem> list = emosmPb$SubCmd0x13Rsp.itemlist.get();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = list.get(i3);
                        EmosmPb$SmallYellowItem emosmPb$SmallYellowItem2 = new EmosmPb$SmallYellowItem();
                        emosmPb$SmallYellowItem2.f342126ts.set(emosmPb$SmallYellowItem.f342126ts.get());
                        emosmPb$SmallYellowItem2.type.set(emosmPb$SmallYellowItem.type.get());
                        int i16 = emosmPb$SmallYellowItem.type.get();
                        int i17 = emosmPb$SmallYellowItem.f342125id.get();
                        if (i16 == 1) {
                            if (!QQSysFaceUtil.isValidFaceId(i17)) {
                                QLog.e(TAG, 1, "getLocalSystemEmojiInfoFromFile type = system, id error, id = " + i17);
                            } else {
                                if (i17 == 250) {
                                    i17 = 10;
                                }
                                emosmPb$SmallYellowItem2.f342125id.set(i17);
                                arrayList.add(emosmPb$SmallYellowItem2);
                            }
                        } else {
                            if (i16 == 2) {
                                if (!QQEmojiUtil.isValidEmojiId(i17)) {
                                    QLog.e(TAG, 1, "getLocalSystemEmojiInfoFromFile type = emoji, id error, id = " + i17);
                                } else {
                                    HashMap<Integer, Integer> hashMap = EMOJI_CONVERT_MAP;
                                    if (hashMap.containsKey(Integer.valueOf(i17))) {
                                        QLog.d(TAG, 2, "getLocalSystemEmojiInfoFromFile before EMOTIONPANEL_EMOJI_MAP index = " + i17);
                                        i17 = hashMap.get(Integer.valueOf(i17)).intValue();
                                        QLog.d(TAG, 2, "getLocalSystemEmojiInfoFromFile after EMOTIONPANEL_EMOJI_MAP index = " + i17);
                                    }
                                }
                            }
                            emosmPb$SmallYellowItem2.f342125id.set(i17);
                            arrayList.add(emosmPb$SmallYellowItem2);
                        }
                    }
                }
                List<EmosmPb$SmallYellowItem> cacheInfo = getCacheInfo();
                if (list != null && list.size() > 0) {
                    for (int i18 = 0; i18 < list.size(); i18++) {
                        EmosmPb$SmallYellowItem emosmPb$SmallYellowItem3 = list.get(i18);
                        int i19 = emosmPb$SmallYellowItem3.type.get();
                        int i26 = emosmPb$SmallYellowItem3.f342125id.get();
                        if (i19 == 1) {
                            int convertToServer = QQSysFaceUtil.convertToServer(i26);
                            if (convertToServer >= 0) {
                                emosmPb$SmallYellowItem3.f342125id.set(convertToServer);
                                arrayList2.add(emosmPb$SmallYellowItem3);
                            } else {
                                QLog.e(TAG, 1, "getLocalSystemEmojiInfoFromFile system error localId = " + i26);
                            }
                        } else {
                            int emojiUnicode = QQEmojiUtil.getEmojiUnicode(i26);
                            if (emojiUnicode != -1) {
                                emosmPb$SmallYellowItem3.f342125id.set(emojiUnicode);
                                arrayList2.add(emosmPb$SmallYellowItem3);
                            } else {
                                QLog.e(TAG, 1, "getLocalSystemEmojiInfoFromFile emoji error localId = " + i26);
                            }
                        }
                    }
                }
                List<EmosmPb$SmallYellowItem> mergeAndSortSystemEmojiInfo = mergeAndSortSystemEmojiInfo(arrayList, cacheInfo);
                List<EmosmPb$SmallYellowItem> paddedData = getPaddedData(mergeAndSortSystemEmojiInfo);
                if (paddedData != null) {
                    mergeAndSortSystemEmojiInfo.addAll(paddedData);
                }
                synchronized (this) {
                    this.itemInfos = mergeAndSortSystemEmojiInfo;
                }
                return arrayList2;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getLocalSystemEmojiInfoFromFile mergeFromBody exception e = " + e16.getMessage());
                return null;
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public List<EmosmPb$SmallYellowItem> getPaddedData(List<EmosmPb$SmallYellowItem> list) {
        int emojiLocalId;
        int i3;
        if (list == null) {
            list = new ArrayList<>();
        }
        int size = list.size();
        int i16 = EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI;
        if (size < i16 * 3) {
            int size2 = (i16 * 3) - list.size();
            ArrayList arrayList = new ArrayList();
            if (size2 > 0) {
                int i17 = 0;
                while (true) {
                    int[] iArr = DEFAULT_IDS;
                    if (i17 < iArr.length) {
                        int i18 = iArr[i17];
                        boolean z16 = true;
                        if (i18 < QQSysFaceUtil.maxServerId()) {
                            emojiLocalId = QQSysFaceUtil.convertToLocal(i18);
                            if (emojiLocalId == 250) {
                                emojiLocalId = 10;
                            }
                            i3 = 1;
                        } else {
                            emojiLocalId = QQEmojiUtil.getEmojiLocalId(i18);
                            HashMap<Integer, Integer> hashMap = EMOJI_CONVERT_MAP;
                            if (hashMap.containsKey(Integer.valueOf(emojiLocalId))) {
                                QLog.d(TAG, 2, "paddedData dedault before EMOTIONPANEL_EMOJI_MAP index = " + emojiLocalId);
                                emojiLocalId = hashMap.get(Integer.valueOf(emojiLocalId)).intValue();
                                QLog.d(TAG, 2, "paddedData dedault after EMOTIONPANEL_EMOJI_MAP index = " + emojiLocalId);
                            }
                            i3 = 2;
                        }
                        if (QQSysAndEmojiResMgr.getInstance().getResImpl(i3).checkEmoticonShouldHide(emojiLocalId)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "emo should be hided:", Integer.valueOf(emojiLocalId), " ,type:", Integer.valueOf(i3));
                            }
                        } else {
                            int i19 = 0;
                            while (true) {
                                if (i19 < list.size()) {
                                    EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = list.get(i19);
                                    int i26 = emosmPb$SmallYellowItem.type.get();
                                    int i27 = emosmPb$SmallYellowItem.f342125id.get();
                                    if (i26 == i3 && i27 == emojiLocalId) {
                                        break;
                                    }
                                    i19++;
                                } else {
                                    z16 = false;
                                    break;
                                }
                            }
                            if (!z16) {
                                EmosmPb$SmallYellowItem emosmPb$SmallYellowItem2 = new EmosmPb$SmallYellowItem();
                                emosmPb$SmallYellowItem2.type.set(i3);
                                emosmPb$SmallYellowItem2.f342125id.set(emojiLocalId);
                                emosmPb$SmallYellowItem2.f342126ts.set(0L);
                                arrayList.add(emosmPb$SmallYellowItem2);
                            }
                        }
                        i17++;
                    } else {
                        return arrayList;
                    }
                }
            } else {
                return arrayList;
            }
        } else {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public List<EmosmPb$SmallYellowItem> mergeAndSortSystemEmojiInfo(List<EmosmPb$SmallYellowItem> list, List<EmosmPb$SmallYellowItem> list2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "mergeAndSortSystemEmojiInfo");
        }
        List<EmosmPb$SmallYellowItem> list3 = null;
        if (list == null && list2 == null) {
            QLog.e(TAG, 1, "mergeAndSortSystemEmojiInfo list IS null");
            return null;
        }
        if (list == null) {
            QLog.e(TAG, 1, "mergeAndSortSystemEmojiInfo  list1 = NULL");
            list3 = list2;
        }
        if (list2 == null) {
            QLog.e(TAG, 1, "mergeAndSortSystemEmojiInfo  list2 = NULL");
            list3 = list;
        }
        if (list3 == null) {
            list.addAll(list2);
            list3 = list;
        }
        printBeforeSortLog(list, list2);
        Collections.sort(list3, new a());
        printAfterSortLog(list3);
        HashSet hashSet = new HashSet();
        Iterator<EmosmPb$SmallYellowItem> it = list3.iterator();
        while (it.hasNext()) {
            EmosmPb$SmallYellowItem next = it.next();
            String str = next.type.get() + "-" + next.f342125id.get();
            if (!hashSet.contains(str) && !QQSysAndEmojiResMgr.getInstance().getResImpl(next.type.get()).checkEmoticonShouldHide(next.f342125id.get())) {
                hashSet.add(str);
            } else {
                it.remove();
            }
        }
        printAfterSortLog(list3);
        return list3;
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public List<EmosmPb$SmallYellowItem> mergeList(List<EmosmPb$SmallYellowItem> list) {
        List<EmosmPb$SmallYellowItem> mergeAndSortSystemEmojiInfo;
        new ArrayList();
        List<EmosmPb$SmallYellowItem> list2 = this.itemInfos;
        if (list2 != null && list2.size() > 0) {
            mergeAndSortSystemEmojiInfo = mergeAndSortSystemEmojiInfo(list, getCacheInfo());
        } else {
            mergeAndSortSystemEmojiInfo = mergeAndSortSystemEmojiInfo(null, list);
        }
        int size = mergeAndSortSystemEmojiInfo.size();
        int i3 = EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI;
        if (size > i3 * 3) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "before remove size = " + mergeAndSortSystemEmojiInfo.size());
            }
            ArrayList arrayList = new ArrayList();
            for (int i16 = i3 * 3; i16 < mergeAndSortSystemEmojiInfo.size(); i16++) {
                arrayList.add(mergeAndSortSystemEmojiInfo.get(i16));
            }
            mergeAndSortSystemEmojiInfo.removeAll(arrayList);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "after remove size = " + mergeAndSortSystemEmojiInfo.size());
            }
        }
        Collection<? extends EmosmPb$SmallYellowItem> paddedData = getPaddedData(mergeAndSortSystemEmojiInfo);
        if (paddedData != null) {
            mergeAndSortSystemEmojiInfo.addAll(paddedData);
        }
        return mergeAndSortSystemEmojiInfo;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = (AppInterface) appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        synchronized (this) {
            List<EmosmPb$SmallYellowItem> list = this.itemInfos;
            if (list != null) {
                list.clear();
                this.itemInfos = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public void saveSystemEmojiInfoToCahce(EmosmPb$SmallYellowItem emosmPb$SmallYellowItem) {
        EmosmPb$SmallYellowItem emosmPb$SmallYellowItem2;
        if (emosmPb$SmallYellowItem == null) {
            QLog.e(TAG, 1, "saveSystemEmojiInfoToCahce info = null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveSystemEmojiInfoToCahce id = " + emosmPb$SmallYellowItem.f342125id.get() + ";type = " + emosmPb$SmallYellowItem.type.get() + ";ts = " + emosmPb$SmallYellowItem.f342126ts.get());
        }
        int i3 = emosmPb$SmallYellowItem.type.get();
        int i16 = emosmPb$SmallYellowItem.f342125id.get();
        synchronized (this) {
            if (this.itemInfos != null) {
                int i17 = 0;
                while (true) {
                    if (i17 < this.itemInfos.size()) {
                        EmosmPb$SmallYellowItem emosmPb$SmallYellowItem3 = this.itemInfos.get(i17);
                        if (emosmPb$SmallYellowItem3.type.get() == i3 && emosmPb$SmallYellowItem3.f342125id.get() == i16) {
                            break;
                        } else {
                            i17++;
                        }
                    } else {
                        i17 = -1;
                        break;
                    }
                }
                if (i17 >= 0) {
                    emosmPb$SmallYellowItem2 = this.itemInfos.remove(i17);
                } else if (this.itemInfos.size() >= EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI * 3) {
                    List<EmosmPb$SmallYellowItem> list = this.itemInfos;
                    emosmPb$SmallYellowItem2 = list.remove(list.size() - 1);
                } else {
                    emosmPb$SmallYellowItem2 = null;
                }
                if (QLog.isColorLevel() && emosmPb$SmallYellowItem2 != null) {
                    QLog.d(TAG, 2, "saveSystemEmojiInfoToCahce removeInfo : type =" + emosmPb$SmallYellowItem2.type.get() + ";id = " + emosmPb$SmallYellowItem2.f342125id.get() + ";ts = " + emosmPb$SmallYellowItem2.f342126ts.get());
                }
                this.itemInfos.add(0, emosmPb$SmallYellowItem);
            } else {
                ArrayList arrayList = new ArrayList();
                this.itemInfos = arrayList;
                arrayList.add(emosmPb$SmallYellowItem);
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public void saveSystemEmojiInfoToFile() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveSystemEmojiInfoToFile");
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.CommonUsedSystemEmojiManagerServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CommonUsedSystemEmojiManagerServiceImpl.this.lock) {
                    File file = new File(BaseApplication.getContext().getFilesDir(), CommonUsedSystemEmojiManagerConstants.COMMONUSED_SYSTEM_EMOJI_FILE_NAME_V2_ + MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
                    EmosmPb$SubCmd0x13Rsp emosmPb$SubCmd0x13Rsp = new EmosmPb$SubCmd0x13Rsp();
                    List<EmosmPb$SmallYellowItem> cacheInfo = CommonUsedSystemEmojiManagerServiceImpl.this.getCacheInfo();
                    if (cacheInfo == null) {
                        cacheInfo = new ArrayList<>();
                    }
                    emosmPb$SubCmd0x13Rsp.itemlist.set(cacheInfo);
                    if (QLog.isColorLevel() && cacheInfo.size() > 0) {
                        StringBuilder sb5 = new StringBuilder("saveSystemEmojiInfoToFile : itemsInfo = ");
                        for (int i3 = 0; i3 < cacheInfo.size(); i3++) {
                            EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = cacheInfo.get(i3);
                            sb5.append(";type = " + emosmPb$SmallYellowItem.type.get());
                            sb5.append(";id = " + emosmPb$SmallYellowItem.f342125id.get());
                            sb5.append(";ts = " + emosmPb$SmallYellowItem.f342126ts.get());
                        }
                        QLog.d(CommonUsedSystemEmojiManagerServiceImpl.TAG, 2, sb5.toString());
                    }
                    FileUtils.pushData2File(file.getAbsolutePath(), emosmPb$SubCmd0x13Rsp.toByteArray(), false);
                }
            }
        });
    }

    public void updateCacheFromFile() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateCacheFromFile");
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.CommonUsedSystemEmojiManagerServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                CommonUsedSystemEmojiManagerServiceImpl.this.getLocalSystemEmojiInfoFromFile();
            }
        });
    }

    @Override // com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService
    public void updateItemInfo(List<EmosmPb$SmallYellowItem> list) {
        if (list == null) {
            QLog.e(TAG, 1, "updateItemInfo info = null");
            return;
        }
        this.hasWhiteList = SystemEmoticonInfo.parseWhiteList(this.app, false);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("updateItemInfo backList size = ");
            sb5.append(list.size());
            sb5.append(", before convert: ");
            for (int i3 = 0; i3 < list.size(); i3++) {
                EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = list.get(i3);
                sb5.append("type = " + emosmPb$SmallYellowItem.type.get());
                sb5.append(";id = " + emosmPb$SmallYellowItem.f342125id.get());
                sb5.append(";ts = " + emosmPb$SmallYellowItem.f342126ts.get());
            }
            QLog.d(TAG, 2, sb5.toString());
        }
        filterAbnormalData(list);
        if (list.size() < 1) {
            QLog.e(TAG, 1, "updateItemInfo itemInfos size < 1");
            return;
        }
        List<EmosmPb$SmallYellowItem> mergeList = mergeList(list);
        synchronized (this) {
            this.itemInfos = mergeList;
        }
        saveMergeInfoToFile(mergeList);
    }
}
