package com.tencent.biz.qqstory.takevideo.slideshow;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {
    public static List<SlideItemInfo> a(List<String> list, HashMap<String, LocalMediaInfo> hashMap, List<SlideItemInfo> list2) {
        SlideItemInfo slideItemInfo;
        LocalMediaInfo localMediaInfo;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            LocalMediaInfo localMediaInfo2 = hashMap.get(list.get(i3));
            if (localMediaInfo2 != null) {
                slideItemInfo = new SlideItemInfo(localMediaInfo2);
            } else {
                slideItemInfo = null;
            }
            if (list2 != null) {
                for (int i16 = 0; i16 < list2.size(); i16++) {
                    SlideItemInfo slideItemInfo2 = list2.get(i16);
                    if (slideItemInfo2 != null) {
                        localMediaInfo = slideItemInfo2.f94287d;
                    } else {
                        localMediaInfo = null;
                    }
                    if (localMediaInfo != null && list.get(i3).equals(localMediaInfo.path)) {
                        SlideItemInfo slideItemInfo3 = list2.get(i16);
                        if (slideItemInfo != null && slideItemInfo3 != null) {
                            slideItemInfo.D = slideItemInfo3.D;
                            slideItemInfo.E = slideItemInfo3.E;
                            slideItemInfo.K = slideItemInfo3.K;
                            slideItemInfo.L = slideItemInfo3.L;
                            slideItemInfo.J = slideItemInfo3.J;
                            slideItemInfo.N = slideItemInfo3.N;
                            slideItemInfo.I = slideItemInfo3.I;
                            slideItemInfo.H = slideItemInfo3.H;
                            slideItemInfo.P = slideItemInfo3.P;
                            slideItemInfo.M = slideItemInfo3.M;
                            slideItemInfo.f94288e = slideItemInfo3.f94288e;
                            slideItemInfo.f94289f = slideItemInfo3.f94289f;
                            LocalMediaInfo localMediaInfo3 = slideItemInfo.f94287d;
                            if (localMediaInfo3 != null) {
                                localMediaInfo3.mediaWidth = localMediaInfo.mediaWidth;
                                localMediaInfo3.mediaHeight = localMediaInfo.mediaHeight;
                                localMediaInfo3.rotation = localMediaInfo.rotation;
                            }
                        } else {
                            slideItemInfo = slideItemInfo2;
                        }
                    }
                }
            }
            arrayList.add(slideItemInfo);
        }
        return arrayList;
    }

    public static List<String> b(List<SlideItemInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SlideItemInfo slideItemInfo : list) {
            if (slideItemInfo != null) {
                arrayList.add(slideItemInfo.f94291i);
            }
        }
        return arrayList;
    }

    public static String c(long j3) {
        String str;
        String str2;
        int i3 = (int) (j3 / 1000);
        int i16 = i3 % 60;
        int i17 = i3 / 60;
        if (i16 > 9) {
            str = String.valueOf(i16);
        } else {
            str = "0" + String.valueOf(i16);
        }
        if (i17 > 9) {
            str2 = String.valueOf(i17);
        } else {
            str2 = "0" + String.valueOf(i17);
        }
        return str2 + ":" + str;
    }

    public static String d() {
        String str = "" + System.currentTimeMillis();
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "multipicset/" + str + "/" + str + ".mp4");
        File file = new File(sDKPrivatePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return sDKPrivatePath;
    }
}
