package cooperation.vip.ad;

import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ai {
    /* JADX WARN: Code restructure failed: missing block: B:112:0x013e, code lost:
    
        if (r4.equals(com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData.KEY_BUTTON_TEXT) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static UserLeadingDialogModel[] a(List<TianShuAccess.MapEntry> list) {
        int i3;
        int length;
        UserLeadingDialogModel[] userLeadingDialogModelArr = new UserLeadingDialogModel[5];
        for (int i16 = 0; i16 < 5; i16++) {
            userLeadingDialogModelArr[i16] = new UserLeadingDialogModel();
        }
        Iterator<TianShuAccess.MapEntry> it = list.iterator();
        while (true) {
            String str = "";
            if (it.hasNext()) {
                TianShuAccess.MapEntry next = it.next();
                String str2 = next.key.get();
                String str3 = next.value.get();
                String[] split = str2.split("_");
                char c16 = 1;
                Matcher matcher = Pattern.compile("[0-9]*").matcher(split[split.length - 1]);
                if (matcher.matches()) {
                    i3 = Integer.parseInt(split[split.length - 1]) - 1;
                } else {
                    i3 = 0;
                }
                if (i3 < 5) {
                    if (split.length > 2) {
                        int i17 = 0;
                        while (true) {
                            if (matcher.matches()) {
                                length = split.length - 1;
                            } else {
                                length = split.length;
                            }
                            if (i17 < length) {
                                if (i17 == 0) {
                                    str = split[0];
                                } else {
                                    str = str + "_" + split[i17];
                                }
                                i17++;
                            }
                        }
                    } else {
                        str = split[0];
                    }
                    str.hashCode();
                    switch (str.hashCode()) {
                        case -2071290626:
                            if (str.equals("button_text_color")) {
                                c16 = 0;
                                break;
                            }
                            break;
                        case -1759410662:
                            break;
                        case -356117447:
                            if (str.equals("res_link")) {
                                c16 = 2;
                                break;
                            }
                            break;
                        case -355863687:
                            if (str.equals("res_type")) {
                                c16 = 3;
                                break;
                            }
                            break;
                        case -206713337:
                            if (str.equals("res_custom_hippy_wh")) {
                                c16 = 4;
                                break;
                            }
                            break;
                        case 1427485:
                            if (str.equals("content_color")) {
                                c16 = 5;
                                break;
                            }
                            break;
                        case 98523296:
                            if (str.equals("res_custom_url")) {
                                c16 = 6;
                                break;
                            }
                            break;
                        case 110371416:
                            if (str.equals("title")) {
                                c16 = 7;
                                break;
                            }
                            break;
                        case 844796604:
                            if (str.equals("title_color")) {
                                c16 = '\b';
                                break;
                            }
                            break;
                        case 951530617:
                            if (str.equals("content")) {
                                c16 = '\t';
                                break;
                            }
                            break;
                        case 1096899920:
                            if (str.equals("res_url")) {
                                c16 = '\n';
                                break;
                            }
                            break;
                        case 1134996564:
                            if (str.equals("res_placeholder")) {
                                c16 = 11;
                                break;
                            }
                            break;
                        case 1277430806:
                            if (str.equals("button_color")) {
                                c16 = '\f';
                                break;
                            }
                            break;
                        case 1519915946:
                            if (str.equals("res_custom_hippy_traceid")) {
                                c16 = '\r';
                                break;
                            }
                            break;
                    }
                    c16 = '\uffff';
                    switch (c16) {
                        case 0:
                            userLeadingDialogModelArr[i3].setButtonTextColor(str3);
                            break;
                        case 1:
                            userLeadingDialogModelArr[i3].setButtonText(str3);
                            break;
                        case 2:
                            userLeadingDialogModelArr[i3].setResLink(str3);
                            break;
                        case 3:
                            userLeadingDialogModelArr[i3].setResType(str3);
                            break;
                        case 4:
                            userLeadingDialogModelArr[i3].setResCustomHippyWh(str3);
                            break;
                        case 5:
                            userLeadingDialogModelArr[i3].setContentColor(str3);
                            break;
                        case 6:
                            userLeadingDialogModelArr[i3].setResCustomUrl(str3);
                            break;
                        case 7:
                            userLeadingDialogModelArr[i3].setTitle(str3);
                            break;
                        case '\b':
                            userLeadingDialogModelArr[i3].setTitleColor(str3);
                            break;
                        case '\t':
                            userLeadingDialogModelArr[i3].setContent(str3);
                            break;
                        case '\n':
                            userLeadingDialogModelArr[i3].setResUrl(str3);
                            break;
                        case 11:
                            userLeadingDialogModelArr[i3].setResPlaceholder(str3);
                            break;
                        case '\f':
                            userLeadingDialogModelArr[i3].setButtonColor(str3);
                            break;
                        case '\r':
                            userLeadingDialogModelArr[i3].setResCustomHippyTraceId(str3);
                            break;
                    }
                }
            } else {
                ArrayList arrayList = new ArrayList();
                int i18 = 0;
                for (int i19 = 0; i19 < 5; i19++) {
                    UserLeadingDialogModel userLeadingDialogModel = userLeadingDialogModelArr[i19];
                    if ((!userLeadingDialogModel.getResUrl().equals("") || !userLeadingDialogModel.getResCustomUrl().equals("")) && (!userLeadingDialogModel.getResType().equals("3") || i18 <= 0)) {
                        if (userLeadingDialogModel.getResType().equals("3")) {
                            i18++;
                        }
                        arrayList.add(userLeadingDialogModel);
                    }
                }
                return (UserLeadingDialogModel[]) arrayList.toArray(new UserLeadingDialogModel[arrayList.size()]);
            }
        }
    }

    public static int b(List<TianShuAccess.MapEntry> list) {
        int i3 = -1;
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str = mapEntry.key.get();
            String str2 = mapEntry.value.get();
            if (str.equals("is_auto_play") && str2.equals("0")) {
                return -1;
            }
            if (str.equals("play_interval")) {
                try {
                    i3 = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    QLog.d("UserModelUtils", 1, "number format is wrong");
                }
            }
        }
        return i3;
    }

    public static boolean c(List<TianShuAccess.MapEntry> list) {
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str = mapEntry.key.get();
            String str2 = mapEntry.value.get();
            if (str.equals("title_area_hidden") && str2.equals("1")) {
                return true;
            }
        }
        return false;
    }
}
