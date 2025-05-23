package com.tencent.mobileqq.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.ap;
import com.tencent.mobileqq.vas.quickupdate.ChatBackgroundBusiness;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ChatBackgroundManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    static String f247211h;

    /* renamed from: i, reason: collision with root package name */
    static int f247212i;

    /* renamed from: m, reason: collision with root package name */
    static Handler f247213m;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f247214d;

    /* renamed from: e, reason: collision with root package name */
    String f247215e;

    /* renamed from: f, reason: collision with root package name */
    LruCache<String, Vector<Integer>> f247216f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class BgColorExtractJob implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap f247223d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f247224e;

        /* renamed from: f, reason: collision with root package name */
        private String f247225f;
        final /* synthetic */ ChatBackgroundManager this$0;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.model.ChatBackgroundManager$BgColorExtractJob$1, reason: invalid class name */
        /* loaded from: classes15.dex */
        class AnonymousClass1 implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ BgColorExtractJob f247226d;

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    BgColorExtractJob.a(this.f247226d);
                    throw null;
                }
            }
        }

        static /* bridge */ /* synthetic */ a a(BgColorExtractJob bgColorExtractJob) {
            bgColorExtractJob.getClass();
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Bitmap bitmap = this.f247223d;
            if (bitmap != null) {
                Vector<Integer> e16 = this.this$0.e(bitmap);
                if (this.f247224e) {
                    this.f247223d.recycle();
                }
                if (e16 != null && !e16.isEmpty()) {
                    if (this.this$0.f247216f.get(this.f247225f) != null) {
                        this.this$0.f247216f.get(this.f247225f).addAll(e16);
                    } else {
                        this.this$0.f247216f.put(this.f247225f, e16);
                    }
                } else {
                    this.this$0.f247216f.remove(this.f247225f);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable success.");
                    return;
                }
                return;
            }
            this.this$0.f247216f.remove(this.f247225f);
            if (QLog.isDevelopLevel()) {
                QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable failed.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    static class b extends Handler {
        static IPatchRedirector $redirector_;

        public b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            Object[] objArr = (Object[]) message.obj;
            if (i3 == 1) {
                if (ChatBackgroundManager.f247212i < 3) {
                    String str = (String) objArr[0];
                    QQAppInterface qQAppInterface = (QQAppInterface) objArr[1];
                    ChatBackgroundManager.u(qQAppInterface, str, StatisticCollector.getInstance(BaseApplication.getContext()));
                    ChatBackgroundManager.f247212i++;
                    if (QLog.isColorLevel()) {
                        QLog.d("ThemeDownloadTrace", 2, "reportTimes is:" + ChatBackgroundManager.f247212i);
                    }
                    Message obtainMessage = ChatBackgroundManager.f247213m.obtainMessage();
                    obtainMessage.what = 1;
                    obtainMessage.obj = new Object[]{str, qQAppInterface};
                    ChatBackgroundManager.f247213m.sendMessageDelayed(obtainMessage, 120000L);
                    return;
                }
                ChatBackgroundManager.f247212i = 0;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73097);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            f247213m = new b(BaseApplication.getContext().getMainLooper());
            f247212i = 0;
        }
    }

    public ChatBackgroundManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f247214d = qQAppInterface;
            this.f247215e = qQAppInterface.getAccount();
        }
    }

    public static void d() {
        f247211h = null;
        f247212i = 0;
        f247213m.removeMessages(1);
        if (QLog.isColorLevel()) {
            QLog.d("ThemeDownloadTrace", 2, "ChatBackground destroy() is called");
        }
    }

    public static int h() {
        return 3;
    }

    public static int i(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null) {
            return 0;
        }
        int i3 = sharedPreferences.getInt(str + AppConstants.Preferences.CHAT_BG_EFFECT, -1);
        if (i3 == -1) {
            return sharedPreferences.getInt(AppConstants.Preferences.CHAT_BG_EFFECT, 0);
        }
        return i3;
    }

    public static int l(Context context, String str, String str2) {
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(context, str);
        if (TextUtils.isEmpty(str2)) {
            return mMKVData.getInt(AppConstants.Preferences.CHAT_BG_EFFECT, 0);
        }
        return i(mMKVData, str2);
    }

    public static boolean s(Context context, String str, String str2) {
        String chatBackgroundPath = ChatBackgroundUtil.getChatBackgroundPath(context, str, str2);
        if (chatBackgroundPath.contains("aioImage")) {
            return new File(chatBackgroundPath.replace("aioImage", "main.json")).exists();
        }
        return false;
    }

    public static boolean t(File file) {
        byte[] bArr = {-119, 80, 78, 71, 13, 10, 26, 10};
        if (!file.exists()) {
            return false;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr2 = new byte[8];
                    randomAccessFile2.read(bArr2);
                    for (int i3 = 0; i3 < 8; i3++) {
                        if (bArr2[i3] != bArr[i3]) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e16) {
                                QLog.e("ChatBackground", 1, "", e16);
                            }
                            return false;
                        }
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e17) {
                        QLog.e("ChatBackground", 1, "", e17);
                    }
                    return true;
                } catch (IOException e18) {
                    e = e18;
                    randomAccessFile = randomAccessFile2;
                    QLog.e("ChatBackground", 1, "", e);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e19) {
                            QLog.e("ChatBackground", 1, "", e19);
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e26) {
                            QLog.e("ChatBackground", 1, "", e26);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e27) {
            e = e27;
        }
    }

    static void u(QQAppInterface qQAppInterface, String str, StatisticCollector statisticCollector) {
        HashMap hashMap = new HashMap();
        hashMap.put(f247211h, 1);
        if (QLog.isColorLevel()) {
            QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + f247211h);
        }
        try {
            statisticCollector.reportOnOff(qQAppInterface, str, hashMap);
        } catch (NoClassDefFoundError e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ThemeDownloadTrace", 2, "realReportCurrChatBgName reportOnOff exception:" + e16.getMessage());
            }
        }
    }

    public static void w(String str) {
        VasMonitorDT.reportErrCode("individual_v2_background_play_fail", DeviceInfoMonitor.getModel() + " " + Build.VERSION.RELEASE + " " + Long.toString(m.c()));
    }

    public void A(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3, Integer.valueOf(i3));
        } else {
            ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).setZPlanChatBackgroundPicPath(str, str2, str3, i3);
        }
    }

    public void a(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) intent);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String B = ChatActivityUtils.B(extras.getInt("uintype", 999));
            int i3 = extras.getInt("bg_replace_entrance", 999);
            if (QLog.isDevelopLevel()) {
                QLog.d("reportEvent", 4, " uin_type : " + B + " entrance_type \uff1a " + i3);
            }
            if (i3 != 999) {
                ReportController.o(null, "CliOper", "", "", "background", "bkground_replace", i3, 0, "0", "0", "", "");
            }
        }
    }

    public HashMap<String, Integer> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(this.f247214d.getApplication().getApplicationContext(), this.f247214d.getCurrentAccountUin());
        HashMap<String, Integer> hashMap = new HashMap<>();
        SharedPreferences.Editor edit = mMKVData.edit();
        for (String str : mMKVData.getAll().keySet()) {
            if (Pattern.compile("[0-9]*").matcher(str).matches() && i(mMKVData, str) > 0) {
                VasLogReporter.getChatBackground().reportDebug("auth : remove effect " + str);
                edit.remove(str + ChatBackgroundUtil.UIN_TYPE);
                edit.remove(str + AppConstants.Preferences.CHAT_BG_EFFECT);
            }
        }
        if (i(mMKVData, "") > 0) {
            VasLogReporter.getChatBackground().reportDebug("auth : remove effect null");
            edit.remove("null");
        }
        return hashMap;
    }

    public void c() {
        String id5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(this.f247214d.getApplication().getApplicationContext(), this.f247214d.getCurrentAccountUin());
        SharedPreferences.Editor edit = mMKVData.edit();
        new HashMap();
        for (String str : mMKVData.getAll().keySet()) {
            if (Pattern.compile("[0-9]*").matcher(str).matches() && (id5 = ChatBackgroundUtil.getId(mMKVData.getString(str, "null"))) != null && !id5.equals("null") && !id5.equals("custom")) {
                VasLogReporter.getChatBackground().reportDebug("auth : remove bg " + str);
                edit.remove(str);
                edit.remove(str + ChatBackgroundUtil.UIN_TYPE);
            }
        }
        String id6 = ChatBackgroundUtil.getId(mMKVData.getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, "null"));
        if (id6 != null && !id6.equals("null") && !id6.equals("custom")) {
            VasLogReporter.getChatBackground().reportDebug("auth : remove bg uniform");
            edit.remove(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH);
        }
        edit.commit();
    }

    public Vector<Integer> e(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Vector) iPatchRedirector.redirect((short) 23, (Object) this, (Object) bitmap);
        }
        List<ap.a> a16 = ap.a(bitmap);
        if (a16 != null && !a16.isEmpty()) {
            Iterator<ap.a> it = a16.iterator();
            int i3 = 0;
            int i16 = 0;
            while (it.hasNext()) {
                i16 += it.next().f308438d;
            }
            Vector<Integer> vector = new Vector<>();
            float c16 = a16.get(0).c();
            for (ap.a aVar : a16) {
                if (aVar.c() / c16 <= 0.2f) {
                    break;
                }
                vector.add(Integer.valueOf(aVar.c()));
                i3 += aVar.f308438d;
                if (i3 / i16 > 0.800000011920929d) {
                    break;
                }
            }
            return vector;
        }
        return null;
    }

    public HashMap<String, Integer> f() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashMap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(this.f247214d.getApplication().getApplicationContext(), this.f247214d.getCurrentAccountUin());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str : mMKVData.getAll().keySet()) {
            if (Pattern.compile("[0-9]*").matcher(str).matches() && (i3 = i(mMKVData, str)) > 0) {
                hashMap.put(str + "_" + mMKVData.getInt(str + ChatBackgroundUtil.UIN_TYPE, -1), Integer.valueOf(i3));
            }
        }
        int i16 = i(mMKVData, "");
        if (i16 > 0) {
            hashMap.put("null", Integer.valueOf(i16));
        }
        return hashMap;
    }

    public HashMap<String, Integer> g() {
        String id5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(this.f247214d.getApplication().getApplicationContext(), this.f247214d.getCurrentAccountUin());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str : mMKVData.getAll().keySet()) {
            if (Pattern.compile("[0-9]*").matcher(str).matches() && (id5 = ChatBackgroundUtil.getId(mMKVData.getString(str, "null"))) != null && !id5.equals("null") && !id5.equals("custom")) {
                try {
                    hashMap.put(str + "_" + mMKVData.getInt(str + ChatBackgroundUtil.UIN_TYPE, -1), Integer.valueOf(id5));
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                    QLog.e("ChatBackgroundManager", 2, "getAllBgId id not number bgId:" + id5, e16);
                }
            }
        }
        String id6 = ChatBackgroundUtil.getId(mMKVData.getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, "null"));
        if (id6 != null && !id6.equals("null") && !id6.equals("custom")) {
            try {
                hashMap.put("null", Integer.valueOf(id6));
            } catch (NumberFormatException e17) {
                e17.printStackTrace();
                QLog.e("ChatBackgroundManager", 2, "getAllBgId id not number bgId:" + id6, e17);
            }
        }
        return hashMap;
    }

    public int j(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, (Object) str)).intValue();
        }
        return context.getSharedPreferences("mobileQQ", 4).getInt(k(str), 0);
    }

    public String k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        return "chat_background_switch_times_" + str;
    }

    public String m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return n(this.f247215e, str);
    }

    public String n(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        }
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(this.f247214d.getApp(), str);
        String str3 = "null";
        if (TextUtils.isEmpty(str2)) {
            String string = mMKVData.getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, null);
            if (TextUtils.isEmpty(string)) {
                return ChatBackgroundUtil.getId("null");
            }
            return ChatBackgroundUtil.getId(string);
        }
        String string2 = mMKVData.getString(str2, null);
        if (string2 == null) {
            String string3 = mMKVData.getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, null);
            if (string3 != null) {
                str3 = string3;
            }
        } else {
            str3 = string2;
        }
        String id5 = ChatBackgroundUtil.getId(str3);
        QLog.i("ChatBackgroundManager", 1, "getChatBackgroundId, path: " + str3 + ", id: " + id5);
        return id5;
    }

    public String o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return ChatBackgroundUtil.getChatBackgroundPath(this.f247214d.getApp(), this.f247215e, str);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    public HashMap<String, String> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (HashMap) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(this.f247214d.getApplication().getApplicationContext(), this.f247214d.getCurrentAccountUin());
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : mMKVData.getAll().keySet()) {
            if (Pattern.compile("[0-9]*").matcher(str).matches()) {
                hashMap.put(str, ChatBackgroundUtil.getId(mMKVData.getString(str, "null")));
            }
        }
        hashMap.put(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, ChatBackgroundUtil.getId(mMKVData.getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, "null")));
        return hashMap;
    }

    public HashMap<String, Integer> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (HashMap) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(this.f247214d.getApplication().getApplicationContext(), this.f247214d.getCurrentAccountUin());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str : mMKVData.getAll().keySet()) {
            if (Pattern.compile("[0-9]*").matcher(str).matches()) {
                hashMap.put(str, Integer.valueOf(l(this.f247214d.getApp(), this.f247215e, str)));
            }
        }
        hashMap.put(AppConstants.Preferences.CHAT_BG_EFFECT, Integer.valueOf(l(this.f247214d.getApp(), this.f247215e, "")));
        return hashMap;
    }

    public void r(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mobileQQ", 4);
        if (str != null && str.trim().length() != 0) {
            String k3 = k(str);
            int i3 = sharedPreferences.getInt(k3, 0);
            if (QLog.isColorLevel()) {
                QLog.d("ChatBackgroundManager", 2, "oldCount is:" + i3);
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            int i16 = i3 + 1;
            edit.putInt(k3, i16);
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.d("ChatBackgroundManager", 2, "save count is:" + i16);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ChatBackgroundManager", 2, "uin is empty,not save switch bg times");
        }
    }

    public void v(QQAppInterface qQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) qQAppInterface, (Object) str);
            return;
        }
        f247212i = 0;
        f247213m.removeMessages(1);
        f247211h = null;
        qQAppInterface.execute(new Runnable(str, qQAppInterface) { // from class: com.tencent.mobileqq.model.ChatBackgroundManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f247221d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f247222e;

            {
                this.f247221d = str;
                this.f247222e = qQAppInterface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ChatBackgroundManager.this, str, qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ChatBackgroundManager.f247211h = ChatBackgroundManager.this.m(null);
                Message obtainMessage = ChatBackgroundManager.f247213m.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = new Object[]{this.f247221d, this.f247222e};
                if (QLog.isColorLevel()) {
                    QLog.d("ThemeDownloadTrace", 2, "bgin to report chat bg info");
                    QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + ChatBackgroundManager.f247211h);
                }
                ChatBackgroundManager.f247213m.sendMessage(obtainMessage);
            }
        });
    }

    public void x(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) context, (Object) str);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mobileQQ", 4);
        String k3 = k(str);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(k3, 0);
        edit.commit();
    }

    public void y(int i3, int i16, String str, String str2, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, Integer.valueOf(i17));
            return;
        }
        VasLogReporter.getChatBackground().reportLow("setBgByScid  bgId:" + i3 + " effectId:" + i16 + " friendUin:" + str + " from:" + str2 + " uinType:" + i17);
        if (ThemeBackground.DIY_UPLOAD_BG_ID.equals(String.valueOf(i3))) {
            String chatBackgroundPath = ChatBackgroundUtil.getChatBackgroundPath(this.f247214d.getApp().getApplicationContext(), this.f247214d.getCurrentUin(), str);
            VasLogReporter.getChatBackgroundJsb().reportHighest("set diy background " + chatBackgroundPath);
            ChatBackgroundUtil.setChatBackground(this.f247214d.getApp().getApplicationContext(), this.f247214d.getCurrentUin(), str, chatBackgroundPath, i16, i17);
            return;
        }
        if (!"100".equals(String.valueOf(i3)) && !"0".equals(String.valueOf(i3))) {
            String shopBgPath = ChatBackgroundUtil.getShopBgPath(String.valueOf(i3));
            if (new File(shopBgPath).exists()) {
                VasLogReporter.getChatBackgroundJsb().reportHighest("setChatBackground before download id = " + i3);
                ChatBackgroundUtil.setChatBackground(this.f247214d.getApp().getApplicationContext(), this.f247214d.getCurrentUin(), str, shopBgPath, i16, i17);
                return;
            }
            ChatBackgroundBusiness chatBackgroundBusiness = (ChatBackgroundBusiness) QQVasUpdateBusiness.getBusiness(ChatBackgroundBusiness.class);
            chatBackgroundBusiness.addDownLoadListener(i3, new Runnable(i3, str, i16, i17) { // from class: com.tencent.mobileqq.model.ChatBackgroundManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f247217d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f247218e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f247219f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f247220h;

                {
                    this.f247217d = i3;
                    this.f247218e = str;
                    this.f247219f = i16;
                    this.f247220h = i17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ChatBackgroundManager.this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String shopBgPath2 = ChatBackgroundUtil.getShopBgPath(String.valueOf(this.f247217d));
                    if (new File(shopBgPath2).exists()) {
                        VasLogReporter.getChatBackgroundJsb().reportHighest("setChatBackground after download id = " + this.f247217d);
                        ChatBackgroundUtil.setChatBackground(ChatBackgroundManager.this.f247214d.getApp().getApplicationContext(), ChatBackgroundManager.this.f247214d.getCurrentUin(), this.f247218e, shopBgPath2, this.f247219f, this.f247220h);
                    }
                }
            });
            chatBackgroundBusiness.startDownload(i3);
            return;
        }
        VasLogReporter.getChatBackgroundJsb().reportHighest("clear background id = " + i3);
        ChatBackgroundUtil.setChatBackground(this.f247214d.getApp().getApplicationContext(), this.f247214d.getCurrentUin(), str, "null", i16, i17);
    }

    public void z(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3));
        } else {
            ChatBackgroundUtil.setChatBackground(this.f247214d.getApp().getApplicationContext(), str, str2, str3, i3);
            ReportController.o(null, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "0", "0", "", ChatBackgroundUtil.getId(str3));
        }
    }
}
