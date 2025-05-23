package com.tencent.mobileqq.app.msgnotify;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.bk;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes11.dex */
public class MsgNotifyPushDialog extends ReportDialog {
    static IPatchRedirector $redirector_;
    public static String F;
    private static long G;
    public static long H;
    public static String I;
    public static String J;
    public static String K;
    public static String L;
    public static int M;
    public static String N;
    public static g P;
    public static boolean Q;
    public static boolean R;
    public static int S;
    public static Intent T;
    public static boolean U;

    @Deprecated
    public static long V;

    @Deprecated
    public static String W;
    public static String X;
    public static String Y;
    public static int Z;

    /* renamed from: a0, reason: collision with root package name */
    public static int f196329a0;

    /* renamed from: b0, reason: collision with root package name */
    public static int f196330b0;

    /* renamed from: c0, reason: collision with root package name */
    public static int f196331c0;

    /* renamed from: d0, reason: collision with root package name */
    public static int f196332d0;

    /* renamed from: e0, reason: collision with root package name */
    public static int f196333e0;

    /* renamed from: f0, reason: collision with root package name */
    public static int f196334f0;

    /* renamed from: g0, reason: collision with root package name */
    public static boolean f196335g0;

    /* renamed from: h0, reason: collision with root package name */
    public static String f196336h0;
    private Context C;
    ImageView D;
    private boolean E;

    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgNotifyPushDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (QQAppInterface.isNotificationEnabled() == 0) {
                    com.tencent.mobileqq.app.msgnotify.a.f196345a.q();
                    if (MsgNotifyPushDialog.T != null) {
                        MsgNotifyPushDialog.this.C.startActivity(MsgNotifyPushDialog.T);
                    }
                } else {
                    com.tencent.mobileqq.app.msgnotify.a.f196345a.o(MsgNotifyPushDialog.this.C);
                }
                ReportController.o(null, "CliOper", "", "", "0X8006B15", "0X8006B15", 0, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X8009AC8", "0X8009AC8", 0, 0, "", "", "", "");
                MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                String i3 = com.tencent.mobileqq.app.msgnotify.a.f196345a.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_OPEN);
                int decodeInt = fromV2.decodeInt(i3, 0);
                MsgNotifyPushDialog.this.e0("em_bas_set_up_now");
                fromV2.encodeInt(i3, decodeInt + 1);
                MsgNotifyPushDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes11.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgNotifyPushDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "CliOper", "", "", "0X8006B16", "0X8006B16", 0, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X8009AC9", "0X8009AC9", 0, 0, "", "", "", "");
                MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                String i3 = com.tencent.mobileqq.app.msgnotify.a.f196345a.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_CANCLE);
                fromV2.encodeInt(i3, fromV2.decodeInt(i3, 0) + 1);
                MsgNotifyPushDialog.this.e0("em_bas_close");
                MsgNotifyPushDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes11.dex */
    class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f196341d;

        c(ImageView imageView) {
            this.f196341d = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgNotifyPushDialog.this, (Object) imageView);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 0) {
                if (motionEvent.getAction() == 1) {
                    i3 = 255;
                } else {
                    i3 = 127;
                }
                this.f196341d.setImageAlpha(i3);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f196343a;

        d(String str) {
            this.f196343a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onCancel(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            } else {
                MsgNotifyPushDialog.P = null;
                QLog.d(MsgNotifyPushDialog.F, 1, "downloadZipFile cancel");
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            MsgNotifyPushDialog.P = null;
            if (gVar.i() == 3) {
                QLog.d(MsgNotifyPushDialog.F, 1, "download finished " + MsgNotifyPushDialog.N);
                File file = new File(this.f196343a);
                if (file.exists() && MsgNotifyPushDialog.g0(file)) {
                    QLog.d(MsgNotifyPushDialog.F, 1, "downloadZipFile suc and zip succ");
                    return;
                }
                return;
            }
            QLog.d(MsgNotifyPushDialog.F, 1, "downloadZipFile failed: ", gVar.f313007e, " code=", Integer.valueOf(gVar.f313006d));
        }
    }

    /* loaded from: classes11.dex */
    public static class e extends AsyncTask<Void, Integer, Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<QQAppInterface> f196344a;

        public e(QQAppInterface qQAppInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            } else {
                this.f196344a = new WeakReference<>(qQAppInterface);
                QLog.d(MsgNotifyPushDialog.F, 1, "doafterlogin");
            }
        }

        private boolean c() {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            boolean z16 = true;
            if (qBaseActivity instanceof BaseActivity) {
                FrameHelperActivity ji5 = FrameHelperActivity.ji((BaseActivity) qBaseActivity);
                if (ji5 == null || ji5.isHidden() || ji5.getCurrentTab() != com.tencent.mobileqq.activity.home.impl.a.f183038a) {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(MsgNotifyPushDialog.F, 2, "isInConversationTab " + z16);
                }
                return z16;
            }
            return !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("is_only_show_in_conversation_tab", true);
        }

        private boolean d(QQAppInterface qQAppInterface, String str) {
            if (!com.tencent.mobileqq.app.msgnotify.a.f196345a.d()) {
                return false;
            }
            if (com.tencent.mobileqq.app.msgnotify.e.a()) {
                return c();
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x018d A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean e(QQAppInterface qQAppInterface, String str) {
            long j3;
            int i3;
            int i16;
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            long currentTimeMillis = System.currentTimeMillis();
            if (MsgNotifyPushDialog.G == -1) {
                MsgNotifyPushDialog.G = fromV2.decodeLong(com.tencent.mobileqq.app.msgnotify.a.f196345a.i(AppConstants.Preferences.PUSH_OPEN_NOTIFY_LASTTIME), currentTimeMillis);
            }
            com.tencent.mobileqq.app.msgnotify.a aVar = com.tencent.mobileqq.app.msgnotify.a.f196345a;
            int decodeInt = fromV2.decodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_STAGE), 1);
            int decodeInt2 = fromV2.decodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_STAGE_COUNT), 0);
            int decodeInt3 = fromV2.decodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_COUNT), 0);
            int decodeInt4 = fromV2.decodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_COUNT), 0);
            if (QLog.isColorLevel()) {
                QLog.d(MsgNotifyPushDialog.F, 1, "doInBackground: newDialogShowCount " + decodeInt4);
            }
            if (com.tencent.mobileqq.app.msgnotify.e.a() && decodeInt4 >= MsgNotifyPushDialog.f196334f0) {
                fromV2.encodeBool(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_IS_MAX), true);
                if (QLog.isColorLevel()) {
                    QLog.d(MsgNotifyPushDialog.F, 1, "doInBackground: newDialogShowCount >= newPushOpenNotifyFreq_Max");
                }
                return false;
            }
            if (decodeInt == 1) {
                j3 = MsgNotifyPushDialog.Z * MsgNotifyPushDialog.H;
                i16 = MsgNotifyPushDialog.f196329a0;
            } else if (decodeInt == 2) {
                j3 = MsgNotifyPushDialog.f196330b0 * MsgNotifyPushDialog.H;
                i16 = MsgNotifyPushDialog.f196331c0;
            } else {
                if (decodeInt == 3) {
                    j3 = MsgNotifyPushDialog.f196332d0 * MsgNotifyPushDialog.H;
                    i3 = Integer.MAX_VALUE;
                } else {
                    j3 = 0;
                    i3 = 0;
                }
                if (decodeInt2 >= i3) {
                    decodeInt++;
                    fromV2.encodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_STAGE), decodeInt);
                    fromV2.encodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_STAGE_COUNT), 0);
                    if (decodeInt == 1) {
                        j3 = MsgNotifyPushDialog.Z * MsgNotifyPushDialog.H;
                        i3 = MsgNotifyPushDialog.f196329a0;
                    } else if (decodeInt == 2) {
                        j3 = MsgNotifyPushDialog.f196330b0 * MsgNotifyPushDialog.H;
                        i3 = MsgNotifyPushDialog.f196331c0;
                    } else if (decodeInt == 3) {
                        j3 = MsgNotifyPushDialog.f196332d0 * MsgNotifyPushDialog.H;
                        decodeInt2 = 0;
                        i3 = Integer.MAX_VALUE;
                    }
                    decodeInt2 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PushOpenNotify", 2, "PopOpenMsgNotifation, stage:", Integer.valueOf(decodeInt), " stagecount:", Integer.valueOf(decodeInt2), " count:", Integer.valueOf(decodeInt3), " countMax:", Integer.valueOf(i3), " pushInteral:", Long.valueOf(j3), " timeDiff:", Long.valueOf(currentTimeMillis - MsgNotifyPushDialog.G));
                }
                if (com.tencent.mobileqq.app.msgnotify.e.a()) {
                    j3 = MsgNotifyPushDialog.f196333e0 * MsgNotifyPushDialog.H;
                }
                if (currentTimeMillis - MsgNotifyPushDialog.G <= j3 || decodeInt3 == 0) {
                    MsgNotifyPushDialog.G = currentTimeMillis;
                    fromV2.encodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_STAGE_COUNT), decodeInt2 + 1);
                    if (com.tencent.mobileqq.app.msgnotify.e.a()) {
                        return true;
                    }
                    return c();
                }
                return false;
            }
            i3 = i16;
            if (decodeInt2 >= i3) {
            }
            if (QLog.isColorLevel()) {
            }
            if (com.tencent.mobileqq.app.msgnotify.e.a()) {
            }
            if (currentTimeMillis - MsgNotifyPushDialog.G <= j3) {
            }
            MsgNotifyPushDialog.G = currentTimeMillis;
            fromV2.encodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_STAGE_COUNT), decodeInt2 + 1);
            if (com.tencent.mobileqq.app.msgnotify.e.a()) {
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0073 A[Catch: Exception -> 0x00cb, TryCatch #0 {Exception -> 0x00cb, blocks: (B:9:0x0012, B:11:0x001c, B:13:0x001f, B:15:0x0025, B:17:0x0028, B:19:0x002c, B:21:0x0034, B:23:0x0037, B:25:0x003e, B:27:0x0042, B:30:0x0048, B:32:0x004c, B:34:0x0052, B:36:0x0055, B:38:0x0061, B:42:0x006d, B:44:0x0073, B:46:0x008c, B:48:0x0092, B:50:0x0098, B:51:0x00a0, B:53:0x00a8, B:55:0x00b3, B:57:0x00bc, B:62:0x00c8), top: B:8:0x0012 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x008c A[Catch: Exception -> 0x00cb, TryCatch #0 {Exception -> 0x00cb, blocks: (B:9:0x0012, B:11:0x001c, B:13:0x001f, B:15:0x0025, B:17:0x0028, B:19:0x002c, B:21:0x0034, B:23:0x0037, B:25:0x003e, B:27:0x0042, B:30:0x0048, B:32:0x004c, B:34:0x0052, B:36:0x0055, B:38:0x0061, B:42:0x006d, B:44:0x0073, B:46:0x008c, B:48:0x0092, B:50:0x0098, B:51:0x00a0, B:53:0x00a8, B:55:0x00b3, B:57:0x00bc, B:62:0x00c8), top: B:8:0x0012 }] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00c5  */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean doInBackground(Void... voidArr) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            try {
                QQAppInterface qQAppInterface = this.f196344a.get();
                if (qQAppInterface == null) {
                    return Boolean.FALSE;
                }
                if (!qQAppInterface.isLogin()) {
                    return Boolean.FALSE;
                }
                GuardManager guardManager = GuardManager.sInstance;
                if (guardManager != null && !guardManager.isProcessForeground(MobileQQ.PACKAGE_NAME)) {
                    return Boolean.FALSE;
                }
                MsgNotifyPushDialog.Y(qQAppInterface);
                if (MsgNotifyPushDialog.Q && !MsgNotifyPushDialog.U && MsgNotifyPushDialog.T != null) {
                    if (MsgNotifyPushDialog.S != 0 && Build.VERSION.SDK_INT > MsgNotifyPushDialog.S) {
                        return Boolean.FALSE;
                    }
                    String currentUin = qQAppInterface.getCurrentUin();
                    if (QQAppInterface.isNotificationEnabled() != 0 && com.tencent.mobileqq.app.msgnotify.a.f196345a.m()) {
                        z16 = false;
                        if (QLog.isColorLevel()) {
                            QLog.d(MsgNotifyPushDialog.F, 2, "isNotificationClose " + z16);
                        }
                        if (!z16) {
                            if (!MsgNotifyPushDialog.X(qQAppInterface)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(MsgNotifyPushDialog.F, 2, "checkPicResReady false");
                                }
                                com.tencent.mobileqq.app.msgnotify.a.f196345a.p(false);
                                return Boolean.FALSE;
                            }
                            com.tencent.mobileqq.app.msgnotify.a aVar = com.tencent.mobileqq.app.msgnotify.a.f196345a;
                            aVar.p(true);
                            if (aVar.g()) {
                                return Boolean.valueOf(d(qQAppInterface, currentUin));
                            }
                            return Boolean.valueOf(e(qQAppInterface, currentUin));
                        }
                        return Boolean.FALSE;
                    }
                    z16 = true;
                    if (QLog.isColorLevel()) {
                    }
                    if (!z16) {
                    }
                }
                return Boolean.FALSE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bool);
                return;
            }
            try {
                QQAppInterface qQAppInterface = this.f196344a.get();
                if (bool.booleanValue() && qQAppInterface != null) {
                    Intent intent = new Intent(qQAppInterface.getApp(), (Class<?>) DialogActivity.class);
                    intent.addFlags(268435456);
                    intent.addFlags(536870912);
                    intent.addFlags(67108864);
                    intent.addFlags(131072);
                    intent.putExtra("key_dialog_type", DialogActivity.f175528f0);
                    qQAppInterface.getApp().startActivity(intent);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("PushOpenNotify", 2, "popOpenMsgNotifation, exception: ", e16);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70449);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        F = "PushOpenNotify";
        G = -1L;
        H = 86400000L;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(AppConstants.SDCARD_PATH);
        sb5.append("MsgPushNotify");
        String str = File.separator;
        sb5.append(str);
        I = VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
        J = I + "msgnotify_pic" + str;
        K = "msgnotify_pic.zip";
        L = "msgnotify_pic_%d.jpg";
        M = 25;
        N = "https://sqimg.qq.com/qq_product_operations/banner/msgnotify_pic.zip";
        Q = true;
        R = true;
        S = 0;
        T = null;
        U = false;
        V = 0L;
        W = HardCodeUtil.qqStr(R.string.oad);
        X = HardCodeUtil.qqStr(R.string.oa8);
        Y = HardCodeUtil.qqStr(R.string.oaa);
        Z = 0;
        f196329a0 = 3;
        f196330b0 = 7;
        f196331c0 = 3;
        f196332d0 = 30;
        f196333e0 = 1;
        f196334f0 = 3;
        f196335g0 = false;
        f196336h0 = null;
    }

    @TargetApi(14)
    public MsgNotifyPushDialog(Context context) {
        super(context, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
        this.C = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean X(QQAppInterface qQAppInterface) {
        String str = I + K;
        File file = new File(str);
        if (file.exists() && g0(file)) {
            return true;
        }
        if (NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication()) == 0) {
            QLog.d(F, 1, "res download give up");
            return false;
        }
        g gVar = P;
        if (gVar != null) {
            if (gVar.i() != 2 && P.i() != 3) {
                QLog.d(F, 1, "res download task status error, cancel it, status: " + P.i());
                P.c(true);
            } else {
                QLog.d(F, 1, "res download duplicated, " + str);
                return false;
            }
        }
        g gVar2 = new g(N, file);
        P = gVar2;
        gVar2.Q = true;
        h u16 = ((DownloaderFactory) qQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
        QLog.d(F, 1, "start download ");
        u16.startDownload(P, new d(str), null);
        return false;
    }

    public static void Y(QQAppInterface qQAppInterface) {
        if (!f196335g0 || !qQAppInterface.getCurrentUin().equals(f196336h0)) {
            if (QLog.isColorLevel()) {
                QLog.d("PushOpenNotify", 2, "initPushOpeNotifyConfig");
            }
            f196335g0 = true;
            f196336h0 = qQAppInterface.getCurrentUin();
            c0(qQAppInterface, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", str);
        hashMap.put("qq_pgid", DTChatsConst.m.f354839a.a());
        VideoReport.reportEvent("qq_clck", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0() {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", "em_bas_message_push_popup");
        hashMap.put("qq_pgid", DTChatsConst.m.f354839a.a());
        VideoReport.reportEvent("qq_imp", hashMap);
    }

    private static void b0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name.equals(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)) {
                    Q = xmlPullParser.nextText().equals("true");
                } else if (name.equals("frequency")) {
                    long longValue = Long.valueOf(xmlPullParser.nextText()).longValue();
                    V = longValue;
                    if (longValue < 0) {
                        V = 0L;
                    }
                } else if (name.equals("wording")) {
                    W = xmlPullParser.nextText();
                } else if (name.equals("title")) {
                    X = xmlPullParser.nextText();
                } else if (name.equals("content")) {
                    Y = xmlPullParser.nextText();
                } else if (name.equals("frequency_OneTime")) {
                    Z = Integer.valueOf(xmlPullParser.nextText()).intValue();
                } else if (name.equals("frequency_OneMax")) {
                    f196329a0 = Integer.valueOf(xmlPullParser.nextText()).intValue();
                } else if (name.equals("frequency_TwoTime")) {
                    f196330b0 = Integer.valueOf(xmlPullParser.nextText()).intValue();
                } else if (name.equals("frequency_TwoMax")) {
                    f196331c0 = Integer.valueOf(xmlPullParser.nextText()).intValue();
                } else if (name.equals("frequency_ThreeTime")) {
                    f196332d0 = Integer.valueOf(xmlPullParser.nextText()).intValue();
                } else if (name.equals("new_Time_frequency")) {
                    f196333e0 = Integer.valueOf(xmlPullParser.nextText()).intValue();
                } else if (name.equals("new_Time_max")) {
                    f196334f0 = Integer.valueOf(xmlPullParser.nextText()).intValue();
                } else if (name.equals("maxOSVersion")) {
                    S = Integer.valueOf(xmlPullParser.nextText()).intValue();
                } else if (name.equals("defaultSwitch")) {
                    R = xmlPullParser.nextText().equals("true");
                } else {
                    if (name.equals("rom") && xmlPullParser.getAttributeValue(null, "name").equals(ROMUtil.getRomName())) {
                        if (xmlPullParser.getAttributeValue(null, "sdk").equals(Build.VERSION.SDK_INT + "")) {
                            d0(xmlPullParser);
                        }
                    }
                    if (name.equals("device") && xmlPullParser.getAttributeValue(null, "id").equals(ah.s())) {
                        d0(xmlPullParser);
                        if (T != null) {
                            return;
                        }
                    }
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public static void c0(AppRuntime appRuntime, String str, boolean z16) {
        if (z16) {
            str = PreferenceManager.getDefaultSharedPreferences(appRuntime.getApp()).getString(appRuntime.getCurrentUin() + "_" + AppConstants.Preferences.PUSH_OPEN_NOTIFY_XML, null);
        }
        if (str == null) {
            T = bk.a(appRuntime.getApp());
            return;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(byteArrayInputStream, "utf-8");
            b0(newPullParser);
            if (QLog.isColorLevel()) {
                QLog.d("PushOpenNotify", 2, "handlePushOpenNotifyConfig, switch:", Boolean.valueOf(Q), ", frequency:", Integer.valueOf(Z), " ", Integer.valueOf(f196329a0), " ", Integer.valueOf(f196330b0), " ", Integer.valueOf(f196331c0), " ", Integer.valueOf(f196332d0), ", intent:", T);
            }
            if (R && !U && T == null) {
                T = bk.a(appRuntime.getApp());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("PushOpenNotify", 2, "handlePushOpenNotifyConfig, exception: " + e16.getStackTrace());
            }
        }
    }

    private static void d0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        T = null;
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (T == null) {
                    T = new Intent();
                }
                String name = xmlPullParser.getName();
                if (name.equals("action")) {
                    T.setAction(xmlPullParser.nextText());
                } else if (name.equals("data")) {
                    T.setData(Uri.parse(xmlPullParser.nextText()));
                } else if (name.equals("type")) {
                    T.setType(xmlPullParser.nextText());
                } else if (name.equals("package")) {
                    T.setPackage(xmlPullParser.nextText());
                } else if (name.equals(HippyQQConstants.URL_COMPONENT_NAME)) {
                    String[] split = xmlPullParser.nextText().split(";");
                    T.setComponent(new ComponentName(split[0].trim(), split[1].trim()));
                } else if (name.equals("category")) {
                    T.addCategory(xmlPullParser.nextText());
                } else if (name.equals("blackList")) {
                    U = true;
                    T = null;
                    return;
                } else if (name.equals("app_uid")) {
                    T.putExtra("app_uid", Process.myUid());
                    xmlPullParser.nextText();
                } else {
                    T.putExtra(name, xmlPullParser.nextText());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(final String str) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.app.msgnotify.d
            @Override // java.lang.Runnable
            public final void run() {
                MsgNotifyPushDialog.Z(str);
            }
        });
    }

    private void f0() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.app.msgnotify.c
            @Override // java.lang.Runnable
            public final void run() {
                MsgNotifyPushDialog.a0();
            }
        });
    }

    public static boolean g0(File file) {
        boolean z16;
        int i3 = 0;
        while (true) {
            try {
                if (i3 < M) {
                    if (!new File(String.format(J + L, Integer.valueOf(i3))).exists()) {
                        z16 = false;
                        break;
                    }
                    i3++;
                } else {
                    z16 = true;
                    break;
                }
            } catch (Exception e16) {
                QLog.e(F, 1, "unzipFile err, ", e16);
            }
        }
        if (z16) {
            return true;
        }
        for (int i16 = 0; i16 < M; i16++) {
            FileUtils.deleteFile(String.format(J + L, Integer.valueOf(i16)));
        }
        if (file.exists()) {
            FileUtils.uncompressZip(file.getPath(), I, false);
            return true;
        }
        return false;
    }

    @Override // android.app.Dialog
    @TargetApi(16)
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (com.tencent.mobileqq.app.msgnotify.e.a()) {
            super.setContentView(R.layout.foo);
        } else {
            super.setContentView(R.layout.f167862ju);
        }
        this.D = (ImageView) findViewById(R.id.bj8);
        TextView textView = (TextView) findViewById(R.id.dialogTitle);
        TextView textView2 = (TextView) findViewById(R.id.bin);
        Button button = (Button) findViewById(R.id.bik);
        ImageView imageView = (ImageView) findViewById(R.id.az7);
        if (com.tencent.mobileqq.app.msgnotify.e.a()) {
            if (QQTheme.isNowThemeIsNight()) {
                this.D.setImageResource(R.drawable.n2c);
            }
            button.setText(getContext().getResources().getString(R.string.f22047698));
        } else {
            try {
                this.D.setBackgroundDrawable(new BitmapDrawable(this.C.getResources(), BitmapFactory.decodeFile(String.format(J + L, 0))));
            } catch (OutOfMemoryError unused) {
                getOwnerActivity().finish();
            }
            button.setText(HardCodeUtil.qqStr(R.string.oa9));
        }
        textView.setText(X);
        textView2.setText(Y);
        button.setOnClickListener(new a());
        imageView.setOnClickListener(new b());
        imageView.setOnTouchListener(new c(imageView));
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        if (!com.tencent.mobileqq.app.msgnotify.e.a() && !this.E) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgNotifyPushDialog.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (MsgNotifyPushDialog.this.isShowing()) {
                        MsgNotifyPushDialog.this.E = true;
                        AnimationDrawable animationDrawable = new AnimationDrawable();
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            for (int i3 = 0; i3 < MsgNotifyPushDialog.M; i3++) {
                                animationDrawable.addFrame(new BitmapDrawable(MsgNotifyPushDialog.this.C.getResources(), j.c(String.format(MsgNotifyPushDialog.J + MsgNotifyPushDialog.L, Integer.valueOf(i3)))), 1000 / MsgNotifyPushDialog.M);
                            }
                            animationDrawable.setOneShot(true);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (QLog.isColorLevel()) {
                                QLog.d(MsgNotifyPushDialog.F, 2, "Frame Animation decode cost ", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                            }
                            MsgNotifyPushDialog.this.D.postDelayed(new Runnable(animationDrawable) { // from class: com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.4.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ AnimationDrawable f196337d;

                                {
                                    this.f196337d = animationDrawable;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) animationDrawable);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        MsgNotifyPushDialog.this.D.setBackgroundDrawable(this.f196337d);
                                        this.f196337d.start();
                                    }
                                }
                            }, 500L);
                        } catch (OutOfMemoryError unused) {
                        }
                    }
                }
            }, 10, null, true);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.mobileqq.app.msgnotify.a.f196345a.t();
        f0();
        super.show();
    }
}
