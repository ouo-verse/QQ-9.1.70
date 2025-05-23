package com.tencent.mobileqq.subaccount.api;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes18.dex */
public interface ISubAccountControlService extends IRuntimeService {
    public static final int ACT_BINDED = 1;
    public static final int ACT_CANCEL_TOP = 5;
    public static final int ACT_DEMAND = 7;
    public static final int ACT_GET_BINDED = 2;
    public static final String ACT_GET_THIRD_QQ_UNREAD_NUM = "getThirdQQUnreadNum";
    public static final int ACT_NEW_MSG = 6;
    public static final int ACT_SET_TOP = 4;
    public static final int ACT_UNBIND = 3;
    public static final int ACT_UNCHANGED = 0;
    public static final long DELAY_TIME = 300;
    public static final String FAIL_LOCATION = "fail_location";
    public static final String FAIL_STEP = "fail_step";
    public static final int FETCH_C2C_MSG_SCHEDULE_TIME = 1;
    public static final int FETCH_DEFAULT_MSG_SCHEDULE_TIME = 0;
    public static final int FETCH_TROOP_MSG_SCHEDULE_TIME = 2;
    public static final int HINT_BIND_N_QQ = 1;
    public static final int HINT_BIND_QQ_AGAIN = 2;
    public static final int HINT_NOTHING = 0;
    public static final boolean IS_OPEN_UPLOAD_DATA = true;
    public static final int MAX_SUB_ACCOUNT_NUMBER = 2;
    public static final String PARAM_FAILCODE = "param_FailCode";
    public static final int REQUEST_TIMEOUT = 60000;
    public static final long THIRDQQ_UNREAD_NUM_DELAY_MAX_TIME = 86400;
    public static final long THIRDQQ_UNREAD_NUM_DELAY_MIN_TIME = 60;
    public static final long THIRDQQ_UNREAD_NUM_DELAY_TIME = 300;
    public static final String UIN_ALL = "sub.uin.all";
    public static final String UIN_DEFAULT = "sub.uin.default";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f291056a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f291057b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f291056a = 0;
                this.f291057b = false;
            }
        }
    }

    Pair<String, Integer> addHintPair(String str, int i3);

    void bindRecentItem(AppInterface appInterface, String str, int i3);

    void cancelHintDialog(String str, int i3, boolean z16);

    void cancelTimedMsgTask(AppInterface appInterface, int i3);

    void clearAllData(AppInterface appInterface, String str);

    String dealSysMsgContent(AppInterface appInterface, String str, int i3, String str2);

    void destoryHintDialog(Activity activity);

    int getAssociatedQQCacheInt(String str);

    String getAssociatedQQCacheString(String str);

    String getDateFormate();

    boolean getIsThirdUnreadReqSkip();

    long getLastSpecialCareRequestTime();

    int getReqSubAccountSpecialCareListSysTime(AppInterface appInterface, String str, String str2);

    long getSpecialCareReqAdviseGap();

    void getSubAccountSpecialCareList(ArrayList<String> arrayList, String str);

    byte[] getThirdQQUnreadNumReqCookie(AppInterface appInterface, String str);

    long getsTroopDelayTime();

    boolean handleListWaittingHint(String str);

    boolean isHeadIconLongClickFunc(boolean z16);

    void launchTimedMsgTask(AppInterface appInterface, int i3);

    void launchTimedThirdQQUnreadNumTask(AppInterface appInterface);

    ArrayList<Pair<String, Integer>> popWaittingHintPair(String str);

    boolean putAssociatedQQCache(String str, Object obj);

    void setBindUinStatus(AppInterface appInterface, byte b16, String str);

    void setDateFormate(String str);

    void setIsThirdUnreadReqSkip(boolean z16);

    void setLastSpecialCareRequestTime(long j3);

    void setTroopDelayTime(long j3);

    void showHintDialog(AppInterface appInterface, QBaseActivity qBaseActivity, Pair<String, Integer> pair, DialogInterface.OnClickListener onClickListener);

    boolean startGetThirdQQUnreadNum(boolean z16);

    void storeSubAccountSpecialCareList(String str, String str2, ArrayList<String> arrayList, int i3, int i16);

    void storeThirdQQUnreadInfo(String str, String str2, byte[] bArr, int i3, int i16, int i17, int i18, int i19);

    void storeThirdQQUnreadMsgNumInterval(AppInterface appInterface, String str, int i3);

    void updateThirdQQUnreadDelayTime(int i3);
}
