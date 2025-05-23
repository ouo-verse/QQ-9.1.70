package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SystemEmoticonInfo extends EmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int[] APOLLO_EMOTICON_ORDER;
    public static final Parcelable.Creator<SystemEmoticonInfo> CREATOR;
    public static final String KEY_STATIC_DRAWABLE_ID = "KEY_STATIC_DRAWABLE_ID";
    private static int[] SYS_EMOTION_ORDER = null;
    private static final String TAG = "SystemEmoticonInfo";
    private static boolean parsed;
    public static HashMap<String, List<Integer>> sNewApolloEmoticonMap;
    private static int[] sortedOrderList;
    public int code;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37222);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        SYS_EMOTION_ORDER = new int[]{23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 164, 174, 171, 165, 166, 161, 167, 170, 169, 172, 173, 168, 175, 17, 60, 61, 92, 93, 163, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 108, 109, 110, 112, 116, 118, 119, 120, 123, 130, 140, 141, 180, 184, 176, 177, 182, 179, 185, 143, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 214, 215, 216, 187, 209, 198, 186, 189, 212, 188, 190, 201, 210, 191, 197, 203, 205, 193, 194, 211, 204, 192, 207, 213, 202, 196, 208, 200, 206, 195, 199};
        APOLLO_EMOTICON_ORDER = new int[]{186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216};
        sNewApolloEmoticonMap = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(214);
        arrayList.add(215);
        arrayList.add(216);
        sNewApolloEmoticonMap.put("8.0.0", arrayList);
        sortedOrderList = null;
        CREATOR = new Parcelable.Creator<SystemEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.SystemEmoticonInfo.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SystemEmoticonInfo createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SystemEmoticonInfo(parcel) : (SystemEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SystemEmoticonInfo[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SystemEmoticonInfo[i3] : (SystemEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        };
    }

    public SystemEmoticonInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static List<EmoticonInfo> getEmoticonList(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            SystemEmoticonInfo systemEmoticonInfo = new SystemEmoticonInfo();
            systemEmoticonInfo.code = i3;
            systemEmoticonInfo.type = 1;
            arrayList.add(systemEmoticonInfo);
        }
        return arrayList;
    }

    private static int[] getSortedOrderList() {
        if (sortedOrderList == null) {
            int[] iArr = SYS_EMOTION_ORDER;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(copyOf);
            sortedOrderList = copyOf;
        }
        return sortedOrderList;
    }

    public static int[] getSysEmotionOrder() {
        return SYS_EMOTION_ORDER;
    }

    public static boolean isCodeCanShow(int i3) {
        if (Arrays.binarySearch(getSortedOrderList(), i3) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean parseWhiteList(AppRuntime appRuntime, boolean z16) {
        if (!z16 && parsed) {
            return true;
        }
        JSONObject jSONFromLocal = ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).getJSONFromLocal(appRuntime, true);
        if (jSONFromLocal != null) {
            try {
                JSONArray optJSONArray = jSONFromLocal.optJSONArray("systemEmojiWhiteList").optJSONObject(0).optJSONArray("androidEmoticonWhiteList");
                int[] iArr = new int[optJSONArray.length()];
                int length = optJSONArray.length();
                int i3 = 0;
                for (int i16 = 0; i16 < length; i16++) {
                    int optInt = optJSONArray.optInt(i16, -1);
                    if (optInt >= 0 && optInt < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT) {
                        iArr[i3] = optInt;
                        i3++;
                    }
                }
                if (i3 == 0) {
                    QLog.e(TAG, 1, "parseWhiteList no valid emoticon, use default");
                    return true;
                }
                int[] copyOf = Arrays.copyOf(iArr, i3);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "newOrderList: " + Arrays.toString(copyOf));
                }
                int[] copyOf2 = Arrays.copyOf(iArr, i3);
                Arrays.sort(copyOf2);
                SYS_EMOTION_ORDER = copyOf;
                sortedOrderList = copyOf2;
                parsed = true;
            } catch (Throwable th5) {
                QLog.e(TAG, 2, "parseWhiteList error", th5);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "parseWhiteList: local file not exist.");
        }
        return parsed;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getBigDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, context, Float.valueOf(f16));
        }
        return QQSysFaceUtil.getFaceGifDrawable(this.code);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, this, context, Float.valueOf(f16));
        }
        return QQSysFaceUtil.getFaceDrawable(this.code);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, context, editText, parcelable);
            return;
        }
        int i3 = this.srcType;
        if (i3 == 1) {
            ReportController.o(null, "CliOper", "", "", "0X8005507", "0X8005507", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            ReportController.o(null, "CliOper", "", "", "0X8005508", "0X8005508", 0, 0, "", "", "", "");
        }
        editText.getEditableText().replace(editText.getSelectionStart(), editText.getSelectionEnd(), QQSysFaceUtil.getFaceString(this.code));
        editText.requestFocus();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel, i3);
        } else {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.code);
        }
    }

    protected SystemEmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.code = parcel.readInt();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
        }
    }
}
