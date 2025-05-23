package com.tencent.util.notification;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.zip.InflaterInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import tencent.im.user.set.NewMsgNotifySwitchPb$ReqBody;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NotificationController extends BusinessHandler implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    public static final String CMD_SET_NEW_MSG_SWITCH = "PushService.SetUserSwitch";
    public static final int MSG_PARSE_CONFIG_XML = 0;
    public static final int MSG_UPDATE_LIMITENTRY = 1;
    public static final String TAG = "NCtr";
    private BaseQQAppInterface app;
    private Handler mHandler;
    private boolean mHasInit;
    private HashMap<String, LimitEntry> mLimitEntries;
    private boolean mShouldLimit;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface Constants {
        public static final String CONFIG_APPID = "config_appid";
        public static final String CONFIG_PREFILE = "config_prefile";
        public static final String CONFIG_SHOULD_LIMIT = "config_should_limit";
        public static final String CONFIG_VERSION = "config_version";
        public static final String EXTRA_LIMIT_ENTRY = "extra_limit_entry_";
        public static final String EXTRA_LIMIT_UINS = "extra_limit_uins_";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class LimitEntry {
        static IPatchRedirector $redirector_;
        long mBaseLineTime;
        int mDay;
        int mEnableTimes;
        int mShowTimes;
        String mUin;

        public LimitEntry(String str, int i3, int i16, long j3, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotificationController.this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17));
                return;
            }
            this.mUin = str;
            this.mDay = i3;
            this.mEnableTimes = i16;
            this.mBaseLineTime = j3;
            this.mShowTimes = i17;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mUin + "," + this.mDay + "," + this.mEnableTimes + "," + this.mBaseLineTime + "," + this.mShowTimes;
        }
    }

    public NotificationController(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.mShouldLimit = false;
        this.mHasInit = false;
        this.app = baseQQAppInterface;
        this.mHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
    }

    public static Long getDayBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 1);
        return Long.valueOf(new Timestamp(calendar.getTimeInMillis()).getTime());
    }

    private synchronized HashMap<String, LimitEntry> getLocalLimitEntries() {
        boolean z16;
        int i3;
        if (!this.mHasInit) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[init]");
            }
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(Constants.CONFIG_PREFILE, 0);
            this.mShouldLimit = sharedPreferences.getBoolean("config_should_limit_" + this.app.getAccount(), false);
            String string = sharedPreferences.getString(Constants.EXTRA_LIMIT_UINS + this.app.getAccount(), "");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "LimitUins:[" + string.toString() + "]");
            }
            char c16 = 1;
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                HashMap<String, LimitEntry> hashMap = new HashMap<>();
                int length = split.length;
                int i16 = 0;
                while (i16 < length) {
                    String str = split[i16];
                    String string2 = sharedPreferences.getString(Constants.EXTRA_LIMIT_ENTRY + this.app.getAccount() + "_" + str, "");
                    if (!TextUtils.isEmpty(string2)) {
                        String[] split2 = string2.split(",");
                        i3 = i16;
                        LimitEntry limitEntry = new LimitEntry(split2[0], Integer.valueOf(split2[c16]).intValue(), Integer.valueOf(split2[2]).intValue(), Long.valueOf(split2[3]).longValue(), Integer.valueOf(split2[4]).intValue());
                        hashMap.put(split2[0], limitEntry);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "LimitEntry:[" + limitEntry.toString() + "]");
                        }
                    } else {
                        i3 = i16;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "LimitEntry is null [" + str + "]");
                        }
                    }
                    i16 = i3 + 1;
                    c16 = 1;
                }
                this.mLimitEntries = hashMap;
                z16 = true;
            } else {
                z16 = true;
            }
            this.mHasInit = z16;
        }
        return this.mLimitEntries;
    }

    private void updateLimitEntrySP(Context context, String str) {
        HashMap<String, LimitEntry> hashMap = this.mLimitEntries;
        boolean z16 = false;
        if (hashMap != null && hashMap.containsKey(str)) {
            LimitEntry limitEntry = this.mLimitEntries.get(str);
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.CONFIG_PREFILE, 0).edit();
            edit.putString(Constants.EXTRA_LIMIT_ENTRY + this.app.getAccount() + "_" + str, limitEntry.toString());
            edit.apply();
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[updateLimitEntrySP]" + str + " " + z16);
        }
    }

    public void cleanConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(Constants.CONFIG_PREFILE, 0);
        String string = sharedPreferences.getString(Constants.EXTRA_LIMIT_UINS + str, "");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("config_version_" + str);
        edit.remove("config_appid_" + str);
        edit.remove("config_should_limit_" + str);
        edit.remove("extra_limit_uins__" + str);
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split(",")) {
                edit.remove(Constants.EXTRA_LIMIT_ENTRY + str + "_" + str2);
            }
        }
        edit.apply();
    }

    public byte[] decodeXML(byte[] bArr) {
        InflaterInputStream inflaterInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inflaterInputStream.read(bArr2);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                inflaterInputStream.close();
            } catch (Throwable th6) {
                QLog.i(TAG, 1, "decodeXML zis.close fail", th6);
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th7) {
                QLog.i(TAG, 1, "decodeXML bos.close fail", th7);
            }
            return byteArray;
        } catch (Throwable th8) {
            th = th8;
            try {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "inflateConfigString fail", th);
                }
                if (inflaterInputStream != null) {
                    try {
                        inflaterInputStream.close();
                    } catch (Throwable th9) {
                        QLog.i(TAG, 1, "decodeXML zis.close fail", th9);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th10) {
                    QLog.i(TAG, 1, "decodeXML bos.close fail", th10);
                }
                return null;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0144 A[Catch: Exception -> 0x02b2, LOOP:0: B:17:0x007e->B:24:0x0144, LOOP_END, TryCatch #0 {Exception -> 0x02b2, blocks: (B:9:0x002e, B:11:0x0034, B:12:0x003c, B:14:0x0048, B:15:0x005d, B:18:0x0080, B:27:0x0151, B:30:0x01b8, B:32:0x01be, B:33:0x01c6, B:35:0x01cc, B:37:0x01eb, B:39:0x01f6, B:40:0x01fe, B:42:0x0204, B:45:0x023b, B:50:0x025c, B:52:0x0281, B:53:0x02ac, B:24:0x0144, B:56:0x008d, B:59:0x0098, B:61:0x009e, B:63:0x00ab, B:65:0x00af, B:66:0x00df, B:67:0x00b5, B:68:0x00cd, B:69:0x00e6, B:71:0x00f2, B:76:0x0107, B:78:0x0110, B:79:0x0115, B:81:0x011e, B:82:0x012b, B:84:0x0134), top: B:8:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0143 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doActionParse(String str, int i3, int i16) {
        HashMap hashMap;
        HashMap<String, LimitEntry> hashMap2;
        XmlPullParser xmlPullParser;
        String str2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 3;
        int i18 = 2;
        int i19 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            HashMap<String, LimitEntry> localLimitEntries = getLocalLimitEntries();
            if (localLimitEntries != null) {
                hashMap = (HashMap) localLimitEntries.clone();
            } else {
                hashMap = null;
            }
            HashMap hashMap3 = hashMap;
            HashMap<String, LimitEntry> hashMap4 = new HashMap<>();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "sourceString : " + str);
            }
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            int eventType = newPullParser.getEventType();
            int i26 = 50;
            int i27 = 0;
            int i28 = 0;
            boolean z17 = false;
            String str3 = "";
            while (true) {
                if (eventType != i19) {
                    String name = newPullParser.getName();
                    if (eventType != i18) {
                        if (eventType != i17 || !name.equalsIgnoreCase("entry")) {
                            xmlPullParser = newPullParser;
                            str2 = str3;
                            hashMap2 = hashMap4;
                            str3 = str2;
                            if (i26 > 0) {
                            }
                        } else {
                            if (hashMap3 != null && hashMap3.containsKey(str3)) {
                                LimitEntry limitEntry = (LimitEntry) hashMap3.get(str3);
                                hashMap3.remove(str3);
                                if (i27 == limitEntry.mDay && i28 == limitEntry.mEnableTimes) {
                                    hashMap4.put(str3, limitEntry);
                                    xmlPullParser = newPullParser;
                                    hashMap2 = hashMap4;
                                } else {
                                    xmlPullParser = newPullParser;
                                    hashMap2 = hashMap4;
                                    hashMap2.put(str3, new LimitEntry(str3, i27, i28, 0L, 0));
                                }
                            } else {
                                xmlPullParser = newPullParser;
                                String str4 = str3;
                                hashMap2 = hashMap4;
                                hashMap2.put(str4, new LimitEntry(str4, i27, i28, 0L, 0));
                            }
                            i26--;
                            i27 = 0;
                            i28 = 0;
                            str3 = "";
                            if (i26 > 0) {
                                break;
                            }
                            eventType = xmlPullParser.next();
                            newPullParser = xmlPullParser;
                            hashMap4 = hashMap2;
                            i17 = 3;
                            i18 = 2;
                            i19 = 1;
                        }
                    } else {
                        xmlPullParser = newPullParser;
                        str2 = str3;
                        hashMap2 = hashMap4;
                        if (name.equalsIgnoreCase("body")) {
                            if (Integer.valueOf(xmlPullParser.getAttributeValue(0)).intValue() == 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            z17 = z16;
                        } else if (name.equalsIgnoreCase(IPublicAccountBrowser.KEY_PUB_UIN)) {
                            str3 = xmlPullParser.nextText();
                            if (i26 > 0) {
                            }
                        } else if (name.equalsIgnoreCase("day")) {
                            i27 = Integer.valueOf(xmlPullParser.nextText()).intValue();
                        } else if (name.equalsIgnoreCase("enableTimes")) {
                            i28 = Integer.valueOf(xmlPullParser.nextText()).intValue();
                        }
                        str3 = str2;
                        if (i26 > 0) {
                        }
                    }
                } else {
                    hashMap2 = hashMap4;
                    break;
                }
            }
            boolean z18 = z17;
            this.mShouldLimit = z18;
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(Constants.CONFIG_PREFILE, 0).edit();
            String account = this.app.getAccount();
            edit.putInt("config_version_" + account, i3);
            edit.putInt("config_appid_" + account, i16);
            edit.apply();
            edit.putBoolean("config_should_limit_" + account, z18);
            if (hashMap3 != null && hashMap3.size() > 0) {
                for (String str5 : hashMap3.keySet()) {
                    edit.remove(Constants.EXTRA_LIMIT_ENTRY + account + "_" + str3);
                }
            }
            StringBuilder sb5 = new StringBuilder();
            if (hashMap2.size() > 0) {
                for (String str6 : hashMap2.keySet()) {
                    LimitEntry limitEntry2 = hashMap2.get(str6);
                    edit.putString(Constants.EXTRA_LIMIT_ENTRY + account + "_" + str6, limitEntry2.toString());
                    sb5.append(str6);
                    sb5.append(",");
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "LimitEntry:[" + limitEntry2.toString() + "]");
                    }
                }
                edit.putString(Constants.EXTRA_LIMIT_UINS + account, sb5.substring(0, sb5.length() - 1));
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "LimitUins:[" + sb5.substring(0, sb5.length() - 1) + "].mShouldLimit" + this.mShouldLimit);
                }
            }
            edit.apply();
            this.mLimitEntries = hashMap2;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "parse fail", e16);
            }
        }
    }

    public int getConfigAppId(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) str)).intValue();
        }
        return context.getSharedPreferences(Constants.CONFIG_PREFILE, 0).getInt("config_appid_" + str, 0);
    }

    public int getConfigVersion(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) str)).intValue();
        }
        return context.getSharedPreferences(Constants.CONFIG_PREFILE, 0).getInt("config_version_" + str, 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                updateLimitEntrySP(BaseApplication.getContext(), (String) message.obj);
            }
        } else {
            doActionParse((String) message.obj, message.arg1, message.arg2);
        }
        return true;
    }

    public boolean isInValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.mHandler == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onDestroy();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void parseXMLAndSave(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Message obtain = Message.obtain();
        obtain.arg1 = i3;
        obtain.arg2 = i16;
        obtain.obj = str;
        obtain.what = 0;
        this.mHandler.sendMessage(obtain);
    }

    public void requestSetNewMsgSwitch(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "HPush_requestSetNewMsgSwitch switchValue:", Boolean.valueOf(z16));
        }
        NewMsgNotifySwitchPb$ReqBody newMsgNotifySwitchPb$ReqBody = new NewMsgNotifySwitchPb$ReqBody();
        newMsgNotifySwitchPb$ReqBody.uint32_notify_switch.set(z16 ? 1 : 0);
        newMsgNotifySwitchPb$ReqBody.uint32_bind_uin_notify_switch.set(z17 ? 1 : 0);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), CMD_SET_NEW_MSG_SWITCH);
        toServiceMsg.putWupBuffer(newMsgNotifySwitchPb$ReqBody.toByteArray());
        sendPbReq(toServiceMsg);
    }

    public void setConfigAppId(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, str, Integer.valueOf(i3));
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.CONFIG_PREFILE, 0).edit();
        edit.putInt("config_appid_" + str, i3);
        edit.apply();
    }

    public void setConfigVersion(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, str, Integer.valueOf(i3));
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.CONFIG_PREFILE, 0).edit();
        edit.putInt("config_version_" + str, i3);
        edit.apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f4 A[Catch: all -> 0x0198, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x0013, B:12:0x001f, B:14:0x0026, B:23:0x0054, B:26:0x005e, B:28:0x0064, B:30:0x0078, B:31:0x00b9, B:33:0x00c2, B:35:0x00c6, B:38:0x00f4, B:41:0x0106, B:42:0x013a, B:44:0x0174, B:47:0x00d2, B:49:0x00dd, B:50:0x00e4, B:52:0x00e8, B:54:0x00ec), top: B:3:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean shouldNotify(String str, int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shouldNotify uin " + str + " type " + i3);
        }
        boolean z19 = true;
        if (i3 == 7200 || i3 == 1008 || i3 == 7220) {
            HashMap<String, LimitEntry> localLimitEntries = getLocalLimitEntries();
            if (this.mShouldLimit && localLimitEntries != null && localLimitEntries.containsKey(str)) {
                long longValue = getDayBegin().longValue();
                LimitEntry limitEntry = localLimitEntries.get(str);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "todayBeginTime = " + new Date(longValue) + ProvinceSelectorView.NAME_NO_SELECT_PROFILE + longValue + " \uff0centry.mBaseLineTime = " + new Date(limitEntry.mBaseLineTime) + ProvinceSelectorView.NAME_NO_SELECT_PROFILE + limitEntry.mBaseLineTime);
                }
                long j3 = limitEntry.mBaseLineTime;
                boolean z26 = false;
                if (j3 < 1) {
                    if (limitEntry.mEnableTimes > 0) {
                        limitEntry.mBaseLineTime = longValue;
                        limitEntry.mShowTimes++;
                        z18 = true;
                        z26 = true;
                        if (z26) {
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            obtain.obj = str;
                            this.mHandler.sendMessage(obtain);
                        }
                        z16 = z18;
                    } else {
                        z18 = false;
                        if (z26) {
                        }
                        z16 = z18;
                    }
                } else {
                    if (((int) ((longValue - j3) / 86400000)) >= limitEntry.mDay) {
                        limitEntry.mBaseLineTime = longValue;
                        limitEntry.mShowTimes = 0;
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    int i17 = limitEntry.mEnableTimes;
                    if (i17 > 0 && (i16 = limitEntry.mShowTimes) < i17) {
                        limitEntry.mShowTimes = i16 + 1;
                        z18 = true;
                        z26 = true;
                        if (z26) {
                        }
                        z16 = z18;
                    } else {
                        z18 = false;
                        z26 = z17;
                        if (z26) {
                        }
                        z16 = z18;
                    }
                }
            } else {
                z16 = true;
            }
            if (!z16) {
                ReportController.o(this.app, "dc00898", "", str, "0X8009995", "0X8009995", 0, 0, "" + System.currentTimeMillis(), "", "", "");
            }
            ReportController.o(this.app, "dc00898", "", str, "0X8009996", "0X8009996", 0, 0, "" + System.currentTimeMillis(), "", "", "");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "uin " + str + " shouldNotify is " + z16);
            }
            z19 = z16;
        }
        return z19;
    }
}
