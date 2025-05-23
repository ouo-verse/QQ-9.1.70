package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.aa;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.webview.api.IBlessJsApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BlessSelectMemberActivity extends SelectMemberActivity implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static long A0;
    private static long B0;
    private static long C0;
    private static MqqWeakReferenceHandler D0;
    private static boolean E0;

    /* renamed from: t0, reason: collision with root package name */
    private static int f285594t0;

    /* renamed from: u0, reason: collision with root package name */
    private static long f285595u0;

    /* renamed from: v0, reason: collision with root package name */
    private static long f285596v0;

    /* renamed from: w0, reason: collision with root package name */
    public static String f285597w0;

    /* renamed from: x0, reason: collision with root package name */
    public static String f285598x0;

    /* renamed from: y0, reason: collision with root package name */
    private static AtomicBoolean f285599y0;

    /* renamed from: z0, reason: collision with root package name */
    private static AtomicBoolean f285600z0;

    /* renamed from: a0, reason: collision with root package name */
    protected Dialog f285601a0;

    /* renamed from: b0, reason: collision with root package name */
    protected ArrayList<String> f285602b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f285603c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f285604d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f285605e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f285606f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f285607g0;

    /* renamed from: h0, reason: collision with root package name */
    private k f285608h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f285609i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f285610j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f285611k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f285612l0;

    /* renamed from: m0, reason: collision with root package name */
    private String f285613m0;

    /* renamed from: n0, reason: collision with root package name */
    private MessageForPic f285614n0;

    /* renamed from: o0, reason: collision with root package name */
    private BaseMessageObserver f285615o0;

    /* renamed from: p0, reason: collision with root package name */
    private String f285616p0;

    /* renamed from: q0, reason: collision with root package name */
    private Dialog f285617q0;

    /* renamed from: r0, reason: collision with root package name */
    private BroadcastReceiver f285618r0;

    /* renamed from: s0, reason: collision with root package name */
    private com.tencent.mobileqq.shortvideo.g f285619s0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessSelectMemberActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(intent.getAction())) {
                BlessSelectMemberActivity blessSelectMemberActivity = BlessSelectMemberActivity.this;
                if (blessSelectMemberActivity.mType == 9003 && blessSelectMemberActivity.mEntrance == 32) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BlessSelectMemberActivity", 2, "ACTION_START_VIDEO_CHAT from BLESS_WEB");
                    }
                    Intent intent2 = new Intent("tencent.video.q2v.startUploadPTV");
                    intent2.putExtra("broadcastType", 1);
                    BlessSelectMemberActivity.this.app.getApp().sendBroadcast(intent2);
                    BlessSelectMemberActivity.this.finish();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends BaseMessageObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessSelectMemberActivity.this);
            }
        }

        public void onBlessDirtyTextCheck(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BlessSelectMemberActivity", 2, "onBlessDirtyTextCheck " + z16 + " ,code=" + i3);
            }
            if (z16 || i3 == 0) {
                z17 = true;
            } else if (i3 == 1) {
                BlessSelectMemberActivity.n3(BlessSelectMemberActivity.this, R.string.f170607vh, true);
            } else if (i3 == 8) {
                BlessSelectMemberActivity.n3(BlessSelectMemberActivity.this, R.string.f170629wf, true);
            }
            if (z17 && !BlessSelectMemberActivity.E0) {
                BlessSelectMemberActivity blessSelectMemberActivity = BlessSelectMemberActivity.this;
                blessSelectMemberActivity.j3(blessSelectMemberActivity.f285605e0);
            } else {
                BlessSelectMemberActivity.this.Y2();
            }
        }

        public void onSendBlessMsgResp(boolean z16, int i3, long j3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BlessSelectMemberActivity", 2, "onSendBlessMsgResp " + z16 + " ,replyCode=" + i3 + " waitTime=" + j3 + " ,entrance=" + BlessSelectMemberActivity.this.mEntrance);
            }
            BlessSelectMemberActivity blessSelectMemberActivity = BlessSelectMemberActivity.this;
            if (!blessSelectMemberActivity.f285603c0) {
                return;
            }
            blessSelectMemberActivity.f285603c0 = false;
            if (i3 == 67) {
                long unused = BlessSelectMemberActivity.B0 = System.currentTimeMillis();
                BlessSelectMemberActivity.this.l3(j3);
                BlessSelectMemberActivity.this.Y2();
                BlessSelectMemberActivity.n3(BlessSelectMemberActivity.this, R.string.f170618w1, true);
                return;
            }
            if (blessSelectMemberActivity.mEntrance == 15) {
                blessSelectMemberActivity.e3(z16);
            } else {
                blessSelectMemberActivity.d3(z16, z17);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            Object[] objArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            if (obj instanceof Object[]) {
                objArr = (Object[]) obj;
            } else {
                objArr = null;
            }
            if (i3 == 8018) {
                if (objArr != null && objArr.length == 1) {
                    i16 = ((Integer) objArr[0]).intValue();
                }
                onBlessDirtyTextCheck(z16, i16);
                return;
            }
            if (i3 == 8019) {
                if (objArr != null && objArr.length == 3) {
                    onSendBlessMsgResp(z16, ((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Boolean) objArr[2]).booleanValue());
                    return;
                }
                return;
            }
            if (i3 == 999) {
                if (obj instanceof String) {
                    onUpdateMsgContent(z16, (String) obj);
                } else {
                    onUpdateMsgContent(z16, "");
                }
            }
        }

        protected void onUpdateMsgContent(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BlessSelectMemberActivity", 2, "onUpdateMsgContent, isSuc:" + z16 + " ,type:" + BlessSelectMemberActivity.this.f285604d0);
            }
            if (BlessSelectMemberActivity.this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value()) {
                if (z16) {
                    BlessSelectMemberActivity.this.h3();
                    return;
                } else {
                    BlessSelectMemberActivity.this.Y2();
                    BlessSelectMemberActivity.n3(BlessSelectMemberActivity.this, R.string.f170617w0, false);
                    return;
                }
            }
            if (BlessSelectMemberActivity.this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value()) {
                if (((MessageForShortVideo) ((IBlessApi) QRoute.api(IBlessApi.class)).getPtvMessage(BlessSelectMemberActivity.this.app)) != null && z16) {
                    if (!BlessSelectMemberActivity.E0) {
                        BlessSelectMemberActivity.this.i3();
                    }
                } else {
                    BlessSelectMemberActivity.this.Y2();
                    BlessSelectMemberActivity.n3(BlessSelectMemberActivity.this, R.string.f170630wg, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessSelectMemberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(BlessSelectMemberActivity.this.getApplicationContext())) {
                QQToast.makeText(BlessSelectMemberActivity.this, R.string.cqv, 1).show();
            } else {
                BlessSelectMemberActivity.this.c3();
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessSelectMemberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
                BlessSelectMemberActivity.this.f285616p0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessSelectMemberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 84) {
                return true;
            }
            if (i3 != 4) {
                return false;
            }
            if (BlessSelectMemberActivity.D0 != null) {
                BlessSelectMemberActivity.D0.sendEmptyMessage(1);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessSelectMemberActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (BlessSelectMemberActivity.D0 != null) {
                    BlessSelectMemberActivity.D0.sendEmptyMessage(1);
                }
                if (BlessSelectMemberActivity.this.f285601a0.isShowing()) {
                    BlessSelectMemberActivity.this.f285601a0.dismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f285630d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f285631e;

        g(boolean z16, Context context) {
            this.f285630d = z16;
            this.f285631e = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), context);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f285630d) {
                ((Activity) this.f285631e).finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f285632d;

        h(Context context) {
            this.f285632d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ((BlessSelectMemberActivity) this.f285632d).c3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class j extends AsyncTask<Void, Void, Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<AppInterface> f285633a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<QBaseActivity> f285634b;

        /* renamed from: c, reason: collision with root package name */
        Intent f285635c;

        /* renamed from: d, reason: collision with root package name */
        String f285636d;

        /* renamed from: e, reason: collision with root package name */
        int f285637e;

        /* renamed from: f, reason: collision with root package name */
        int f285638f;

        /* renamed from: g, reason: collision with root package name */
        int f285639g;

        /* renamed from: h, reason: collision with root package name */
        MessageForShortVideo f285640h;

        public j(AppInterface appInterface, QBaseActivity qBaseActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) qBaseActivity);
                return;
            }
            this.f285633a = new WeakReference<>(appInterface);
            this.f285634b = new WeakReference<>(qBaseActivity);
            Intent intent = qBaseActivity.getIntent();
            this.f285635c = intent;
            this.f285637e = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 0);
            this.f285636d = this.f285635c.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
            this.f285638f = ((IBlessApi) QRoute.api(IBlessApi.class)).getSVBusiUtil_BUSI_TYPE_SHORTVIDEO_PTV_Value();
            this.f285639g = this.f285635c.getIntExtra("uintype", -1);
            if (QLog.isColorLevel()) {
                QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: create");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) voidArr);
            }
            if (QLog.isColorLevel()) {
                QLog.e("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: doInBackground start");
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            QBaseActivity qBaseActivity = this.f285634b.get();
            if (qBaseActivity == null) {
                return 5;
            }
            if (!TextUtils.isEmpty(BlessSelectMemberActivity.f285597w0)) {
                if (QLog.isColorLevel()) {
                    QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: currVideoPath is not null");
                }
                return 1;
            }
            ((IBlessApi) QRoute.api(IBlessApi.class)).getEncodeQualityParamForSendTask(this.f285635c);
            ((IBlessApi) QRoute.api(IBlessApi.class)).setCodecParam(this.f285635c.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, 0), this.f285635c.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, 0));
            if (!FileUtils.fileExistsAndNotEmpty(this.f285636d)) {
                return 2;
            }
            URLDrawable drawable = URLDrawable.getDrawable(new File(this.f285636d), URLDrawable.URLDrawableOptions.obtain());
            drawable.downloadImediatly();
            if (drawable.getStatus() == 1) {
                v vVar = new v();
                vVar.f288264d = 0;
                vVar.f288265e = this.f285638f;
                aa aaVar = (aa) ((IBlessApi) QRoute.api(IBlessApi.class)).createShortVideoUploadInfo(this.f285635c, vVar);
                if (aaVar == null) {
                    return 5;
                }
                aaVar.C = true;
                aaVar.f287755x = false;
                String str = aaVar.P;
                if (str != null && str.length() == 39) {
                    aaVar.P = aaVar.P.substring(0, 28);
                }
                vVar.e(aaVar);
                MessageForShortVideo messageForShortVideo = (MessageForShortVideo) ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator((BaseQQAppInterface) qBaseActivity.getAppRuntime()).l(aaVar);
                this.f285640h = messageForShortVideo;
                if (messageForShortVideo instanceof MessageForBlessPTV) {
                    ((MessageForBlessPTV) messageForShortVideo).videoFileName = this.f285635c.getStringExtra(ShortVideoConstants.BLESS_PTV_MP4_Path);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: generate req and mr success, cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                ((IBlessApi) QRoute.api(IBlessApi.class)).setPtvMessage(this.f285633a.get(), this.f285640h);
                if (BlessSelectMemberActivity.D0 != null) {
                    BlessSelectMemberActivity.D0.sendEmptyMessage(3);
                } else {
                    QLog.e("BlessSelectMemberActivity", 1, "mUIHandler is null!");
                }
                try {
                    synchronized (BlessSelectMemberActivity.f285600z0) {
                        BlessSelectMemberActivity.f285600z0.wait(BlessSelectMemberActivity.f285595u0);
                        long unused = BlessSelectMemberActivity.C0 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (QLog.isColorLevel()) {
                            QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: encodeVideo cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime2));
                        }
                    }
                    if (BlessSelectMemberActivity.C0 >= BlessSelectMemberActivity.f285595u0) {
                        return 9;
                    }
                    return Integer.valueOf(BlessSelectMemberActivity.f285594t0);
                } catch (InterruptedException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: wait exception = " + e16.getMessage());
                    }
                    return 5;
                }
            }
            return 2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) num);
                return;
            }
            super.onPostExecute(num);
            if (QLog.isColorLevel()) {
                QLog.i("BlessSelectMemberActivity", 1, "BlessPTVProcessTask: onPostExecute result=" + num);
            }
            int unused = BlessSelectMemberActivity.f285594t0 = num.intValue();
            synchronized (BlessSelectMemberActivity.f285599y0) {
                BlessSelectMemberActivity.f285599y0.set(true);
                BlessSelectMemberActivity.f285599y0.notifyAll();
            }
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (((IBlessApi) QRoute.api(IBlessApi.class)).isVideoSoLibLoaded()) {
                return true;
            }
            ((IBlessApi) QRoute.api(IBlessApi.class)).loadShortVideoSo(this.f285633a.get());
            if (((IBlessApi) QRoute.api(IBlessApi.class)).isVideoSoLibLoaded()) {
                return true;
            }
            return false;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            super.onPreExecute();
            int unused = BlessSelectMemberActivity.f285594t0 = 1;
            QLog.d("BlessSelectMemberActivity", 1, "Is video useable:" + c() + ", mEntrance:" + this.f285637e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class k extends AsyncTask<Void, Void, Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Context> f285641a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<AppInterface> f285642b;

        /* renamed from: c, reason: collision with root package name */
        String f285643c;

        /* renamed from: d, reason: collision with root package name */
        long f285644d;

        /* renamed from: e, reason: collision with root package name */
        long f285645e;

        /* renamed from: f, reason: collision with root package name */
        ArrayList<String> f285646f;

        /* renamed from: g, reason: collision with root package name */
        int f285647g;

        public k(AppInterface appInterface, Context context, ArrayList<String> arrayList, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appInterface, context, arrayList, Integer.valueOf(i3));
                return;
            }
            this.f285644d = 0L;
            this.f285645e = 0L;
            this.f285641a = new WeakReference<>(context);
            this.f285642b = new WeakReference<>(appInterface);
            this.f285646f = arrayList;
            this.f285647g = i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) voidArr);
            }
            if (QLog.isColorLevel()) {
                QLog.e("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: doInBackground start");
            }
            try {
                synchronized (BlessSelectMemberActivity.f285599y0) {
                    if (!BlessSelectMemberActivity.f285599y0.get()) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        BlessSelectMemberActivity.f285599y0.wait(BlessSelectMemberActivity.f285595u0);
                        long unused = BlessSelectMemberActivity.C0 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        if (QLog.isColorLevel()) {
                            QLog.d("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: encodeVideo cost = " + BlessSelectMemberActivity.C0 + " ,resultCode=" + BlessSelectMemberActivity.f285594t0);
                        }
                    }
                }
            } catch (InterruptedException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: wait exception = " + e16.getMessage());
                }
            }
            if (BlessSelectMemberActivity.C0 >= BlessSelectMemberActivity.f285595u0) {
                return 9;
            }
            if (BlessSelectMemberActivity.f285594t0 != 1) {
                return Integer.valueOf(BlessSelectMemberActivity.f285594t0);
            }
            this.f285644d = System.currentTimeMillis();
            String str2 = BlessSelectMemberActivity.f285597w0;
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) ((IBlessApi) QRoute.api(IBlessApi.class)).getPtvMessage(this.f285642b.get());
            if (messageForShortVideo == null) {
                return 5;
            }
            if (messageForShortVideo instanceof MessageForBlessPTV) {
                ((MessageForBlessPTV) messageForShortVideo).uinList = this.f285646f;
                if (QLog.isColorLevel()) {
                    QLog.d("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: set uinList = " + this.f285646f.toString());
                }
            }
            AppInterface appInterface = this.f285642b.get();
            if (appInterface != null) {
                ((IBlessApi) QRoute.api(IBlessApi.class)).preConnect(appInterface);
            }
            if (FileUtils.fileExistsAndNotEmpty(messageForShortVideo.videoFileName)) {
                if (QLog.isColorLevel()) {
                    QLog.e("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: mr.videoFileName is exist...");
                }
            } else {
                if (!FileUtils.fileExistsAndNotEmpty(str2)) {
                    if (QLog.isColorLevel()) {
                        QLog.e("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: uploadTask file is null!");
                    }
                    return 10;
                }
                File file = new File(str2);
                long length = file.length();
                if (length == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.e("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: uploadTask file mVideoSize = 0");
                    }
                    return 3;
                }
                try {
                    str = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(file), length));
                    if (TextUtils.isEmpty(str)) {
                        if (QLog.isColorLevel()) {
                            QLog.e("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: process videoMd5 is empty, videoMd5: " + str);
                        }
                        return 3;
                    }
                } catch (FileNotFoundException e17) {
                    e17.printStackTrace();
                    str = null;
                }
                this.f285643c = str;
                messageForShortVideo.videoFileSize = (int) length;
                if (FileUtils.fileExistsAndNotEmpty(messageForShortVideo.mThumbFilePath)) {
                    String l3 = com.tencent.mobileqq.shortvideo.j.l(messageForShortVideo.thumbMD5, "jpg");
                    if (!l3.equals(messageForShortVideo.mThumbFilePath)) {
                        if (!FileUtils.rename(l3, messageForShortVideo.mThumbFilePath)) {
                            return 3;
                        }
                        messageForShortVideo.mThumbFilePath = l3;
                    }
                }
            }
            if (TextUtils.isEmpty(messageForShortVideo.md5)) {
                messageForShortVideo.md5 = this.f285643c;
                String j3 = com.tencent.mobileqq.shortvideo.j.j(messageForShortVideo, "mp4");
                if (!str2.equals(j3)) {
                    FileUtils.rename(str2, j3);
                    if (QLog.isColorLevel()) {
                        QLog.i("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: onPostExecute destVideoPath " + j3);
                    }
                }
                BlessSelectMemberActivity.f285598x0 = j3;
                messageForShortVideo.videoFileName = j3;
                messageForShortVideo.serial();
            }
            boolean z16 = false;
            if (appInterface != null && !BlessSelectMemberActivity.E0) {
                v vVar = new v();
                vVar.f288264d = 0;
                vVar.f288265e = ((IBlessApi) QRoute.api(IBlessApi.class)).getSVBusiUtil_BUSI_TYPE_SHORTVIDEO_PTV_Value();
                aa aaVar = (aa) ((IBlessApi) QRoute.api(IBlessApi.class)).createShortVideoUploadInfo(messageForShortVideo, vVar);
                aaVar.f287755x = false;
                aaVar.C = true;
                String str3 = aaVar.P;
                if (str3 != null && str3.length() == 39) {
                    aaVar.P = aaVar.P.substring(0, 28);
                }
                vVar.e(aaVar);
                ((IBlessApi) QRoute.api(IBlessApi.class)).launchForShortVideoBusiManager(vVar, appInterface);
                this.f285645e = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.i("BlessSelectMemberActivity", 2, "BlessPTVUploadTask: [" + messageForShortVideo.uniseq + "]mMessageForShortVideo = " + messageForShortVideo + "\n |- upload cost:" + ((this.f285645e - this.f285644d) / 1000.0d));
                }
            } else if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("BlessPTVUploadTask: QQAppInterface:");
                if (appInterface != null) {
                    z16 = true;
                }
                sb5.append(z16);
                sb5.append(" ,isBlessCancel:");
                sb5.append(BlessSelectMemberActivity.E0);
                QLog.i("BlessSelectMemberActivity", 2, sb5.toString());
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) num);
                return;
            }
            super.onPostExecute(num);
            QLog.i("BlessSelectMemberActivity", 1, "BlessPTVUploadTask: onPostExecute result=" + num + " ,entrance=" + this.f285647g);
            if (num.intValue() != 1) {
                ((BlessSelectMemberActivity) this.f285641a.get()).Y2();
                switch (num.intValue()) {
                    case 2:
                    case 6:
                    case 8:
                        BlessSelectMemberActivity.n3(this.f285641a.get(), R.string.hly, true);
                        break;
                    case 3:
                        BlessSelectMemberActivity.n3(this.f285641a.get(), R.string.hlt, true);
                        break;
                    case 4:
                        BlessSelectMemberActivity.n3(this.f285641a.get(), R.string.f173146hl0, true);
                        break;
                    case 5:
                        BlessSelectMemberActivity.n3(this.f285641a.get(), R.string.hlq, true);
                        break;
                    case 9:
                        BlessSelectMemberActivity.r3(this.f285641a.get(), R.string.hlu);
                        break;
                    case 10:
                        BlessSelectMemberActivity.n3(this.f285641a.get(), R.string.hlr, true);
                        break;
                }
                int unused = BlessSelectMemberActivity.f285594t0 = 1;
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onPreExecute();
                long unused = BlessSelectMemberActivity.C0 = 0L;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19442);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        f285594t0 = 1;
        f285595u0 = 60000L;
        f285596v0 = 60000L;
        f285597w0 = "";
        f285598x0 = "";
        f285599y0 = new AtomicBoolean(false);
        f285600z0 = new AtomicBoolean(false);
        A0 = 0L;
        B0 = 0L;
        C0 = 0L;
        E0 = false;
    }

    public BlessSelectMemberActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f285603c0 = false;
        this.f285604d0 = ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_UNKNOW_Value();
        this.f285605e0 = null;
        this.f285606f0 = 0;
        this.f285607g0 = 0L;
        this.f285614n0 = null;
        this.f285615o0 = new b();
        this.f285616p0 = null;
        this.f285617q0 = null;
        this.f285618r0 = new a();
        this.f285619s0 = new com.tencent.mobileqq.shortvideo.g() { // from class: com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BlessSelectMemberActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.shortvideo.g
            public void a(String str, byte[] bArr, String str2, int i3, int i16, byte[] bArr2, int i17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, str, bArr, str2, Integer.valueOf(i3), Integer.valueOf(i16), bArr2, Integer.valueOf(i17));
                    return;
                }
                BlessSelectMemberActivity.f285597w0 = str;
                synchronized (BlessSelectMemberActivity.f285600z0) {
                    BlessSelectMemberActivity.f285600z0.set(true);
                    BlessSelectMemberActivity.f285600z0.notifyAll();
                }
            }

            @Override // com.tencent.mobileqq.shortvideo.g
            public void onError(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                    return;
                }
                BlessSelectMemberActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.11.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass11.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            QQToast.makeText(BlessSelectMemberActivity.this, HardCodeUtil.qqStr(R.string.k2k), 0).show(BlessSelectMemberActivity.this.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        }
                    }
                });
                if (BlessSelectMemberActivity.D0 != null) {
                    BlessSelectMemberActivity.D0.sendEmptyMessage(1);
                }
                synchronized (BlessSelectMemberActivity.f285600z0) {
                    BlessSelectMemberActivity.f285600z0.set(true);
                    BlessSelectMemberActivity.f285600z0.notifyAll();
                }
                BlessSelectMemberActivity.this.finish();
            }
        };
    }

    public static int b3(int i3) {
        if (i3 != 15 && i3 != 16) {
            if (i3 == 32) {
                return 2;
            }
            return 0;
        }
        return 1;
    }

    private void f3() {
        boolean z16;
        IBlessApi iBlessApi = (IBlessApi) QRoute.api(IBlessApi.class);
        String str = this.f285612l0;
        String str2 = this.f285613m0;
        String str3 = this.f285611k0;
        if (this.f285610j0 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        iBlessApi.realStartEncode(this, str, str2, str3, z16, this.f285619s0);
    }

    private void g3() {
        if (this.f285606f0 == 1) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        try {
            registerReceiver(this.f285618r0, intentFilter);
            this.f285606f0 = 1;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3() {
        ArrayList<String> arrayList;
        if (this.f285614n0 != null && (arrayList = this.f285602b0) != null && arrayList.size() > 0) {
            boolean z16 = true;
            this.f285603c0 = true;
            if (this.mEntrance == 15) {
                MessageForPic messageForPic = this.f285614n0;
                if (this.f285602b0.size() > ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_UPDATE_MSGTAB_NUM_Value()) {
                    z16 = false;
                }
                messageForPic.needUpdateMsgTag = z16;
            }
            ((IBlessApi) QRoute.api(IBlessApi.class)).sendBlessMsg(this.app, this.f285614n0, this.f285602b0, ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessReportParams(this.app, ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value(), 0));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BlessSelectMemberActivity", 2, "sendBlessPic failed!" + this.f285614n0 + " ,uinList:" + this.f285602b0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3() {
        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) ((IBlessApi) QRoute.api(IBlessApi.class)).getPtvMessage(this.app);
        MessageForBlessPTV messageForBlessPTV = (MessageForBlessPTV) messageForShortVideo;
        if (messageForBlessPTV != null) {
            boolean z16 = true;
            this.f285603c0 = true;
            if (this.mEntrance == 15) {
                if (this.f285602b0.size() > ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_UPDATE_MSGTAB_NUM_Value()) {
                    z16 = false;
                }
                messageForBlessPTV.needUpdateMsgTag = z16;
            }
            ((IBlessApi) QRoute.api(IBlessApi.class)).sendBlessMsg(this.app, messageForShortVideo, messageForBlessPTV.uinList, ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessReportParams(this.app, ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value(), messageForBlessPTV.videoFileTime));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BlessSelectMemberActivity", 2, "error case no ptv message in manager");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(String str) {
        if (!Z2()) {
            Y2();
        } else if (!str.equals("")) {
            this.f285603c0 = true;
            ((IBlessApi) QRoute.api(IBlessApi.class)).sendBlessTextMsg(this.app, str, this.f285602b0, null);
        } else {
            QLog.e("BlessSelectMemberActivity", 1, "Blesswords is null!");
            Y2();
        }
    }

    public static void n3(Context context, int i3, boolean z16) {
        DialogUtil.createCustomDialog(context, 232, null, context.getString(i3), new g(z16, context), null).show();
    }

    public static void r3(Context context, int i3) {
        DialogUtil.createCustomDialog(context, 232, (String) null, context.getString(i3), R.string.cancel, R.string.c0a, new h(context), new i()).show();
    }

    protected void Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        try {
            if (this.f285601a0 != null) {
                if (QLog.isColorLevel()) {
                    QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog");
                }
                this.f285601a0.dismiss();
            }
            MqqWeakReferenceHandler mqqWeakReferenceHandler = D0;
            if (mqqWeakReferenceHandler != null) {
                mqqWeakReferenceHandler.removeMessages(2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog excep!", e16);
            }
        }
    }

    public boolean Z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (A0 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - B0;
            if (QLog.isColorLevel()) {
                QLog.d("BlessSelectMemberActivity", 2, "send text overload=" + (currentTimeMillis / 1000) + " duration=" + A0);
            }
            if (currentTimeMillis > A0 * 1000) {
                l3(0L);
                B0 = 0L;
            } else {
                n3(this, R.string.f170618w1, true);
                return false;
            }
        }
        return true;
    }

    protected void c3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        p3(null);
        E0 = false;
        ((IBlessApi) QRoute.api(IBlessApi.class)).saveUinListToSend(this.app, this.f285602b0);
        this.f285607g0 = System.currentTimeMillis();
        D0.sendEmptyMessageDelayed(2, f285596v0);
        if (this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_TEXT_Value()) {
            j3(this.f285605e0);
            return;
        }
        if (this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value()) {
            if (!Z2()) {
                Y2();
                return;
            }
            new j(this.app, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            k kVar = this.f285608h0;
            if (kVar != null && kVar.getStatus() != AsyncTask.Status.FINISHED) {
                if (QLog.isColorLevel()) {
                    QLog.d("BlessSelectMemberActivity", 2, "There is still a running uploadTask!");
                }
                this.f285608h0.cancel(true);
            }
            k kVar2 = new k(this.app, this, this.f285602b0, this.mEntrance);
            this.f285608h0 = kVar2;
            kVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        if (this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value()) {
            if (TextUtils.isEmpty(this.f285612l0)) {
                QQToast.makeText(this, 1, R.string.fkh, 1).show();
                Y2();
                finish();
                return;
            }
            t3(this.f285612l0);
        }
    }

    protected void d3(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.f285607g0) / 1000);
        if (QLog.isColorLevel()) {
            QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResult result:" + z16 + " ,type:" + this.f285604d0 + " ,cost:" + currentTimeMillis);
        }
        if (z16) {
            Y2();
            if (this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_TEXT_Value() && !this.f285605e0.equals("")) {
                ((IBlessApi) QRoute.api(IBlessApi.class)).saveSendWording(this.app, this.f285605e0);
                ((IBlessApi) QRoute.api(IBlessApi.class)).clearEditingWordings(this.app);
                s3(z17);
                ReportController.o(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.f285604d0), String.valueOf(this.f285602b0.size()), "", "");
                return;
            }
            if (this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value() || this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value()) {
                s3(z17);
                return;
            }
            return;
        }
        QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.f285604d0);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f285604d0 = this.mIntent.getExtras().getInt(ISelectMemberActivityConstants.PARAM_BLESSTYPE);
        this.f285605e0 = this.mIntent.getExtras().getString(ISelectMemberActivityConstants.PARAM_BLESSWORD_CONTENT);
        this.f285610j0 = this.mIntent.getIntExtra("encode_type", 0);
        this.f285611k0 = this.mIntent.getStringExtra(ISelectMemberActivityConstants.FAKE_ID);
        this.f285612l0 = this.mIntent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
        this.f285613m0 = this.mIntent.getStringExtra(ShortVideoConstants.THUMBFILE_MD5);
        this.f285609i0 = this.mIntent.getStringExtra(ISelectMemberActivityConstants.PARAM_WEB_CALLBACK);
        addObserver(this.f285615o0);
        g3();
        this.f285602b0 = new ArrayList<>();
        f285599y0.set(false);
        f285594t0 = 1;
        f285597w0 = "";
        E0 = false;
        this.mIsNeedSendIsResumeBroadcast = false;
        D0 = new MqqWeakReferenceHandler(this);
        Intent intent = new Intent("tencent.video.q2v.startUploadPTV");
        intent.putExtra("broadcastType", 2);
        this.app.getApp().sendBroadcast(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnDestroy();
        removeObserver(this.f285615o0);
        MqqWeakReferenceHandler mqqWeakReferenceHandler = D0;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeMessages(2);
        }
        k kVar = this.f285608h0;
        if (kVar != null && kVar.getStatus() != AsyncTask.Status.FINISHED) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessSelectMemberActivity", 2, "destroy the uploadTask!");
            }
            this.f285608h0.cancel(true);
        }
        try {
            if (this.f285606f0 == 1) {
                unregisterReceiver(this.f285618r0);
                this.f285606f0 = 0;
            }
        } catch (IllegalArgumentException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessSelectMemberActivity", 2, " already unregisterReceiver" + e16);
            }
        }
        this.f285614n0 = null;
        C0 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        removeAllFriendResult();
        ((SelectMemberInnerFrame) this.mInnerFrameManager.getCurrentView()).p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnResume();
        if (SystemBarActivityModule.getSystemBarComp(this) != null) {
            int color = getResources().getColor(R.color.f156824ch);
            SystemBarActivityModule.getSystemBarComp(this).setStatusColor(color);
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarColor(color);
        }
    }

    protected void e3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.f285607g0) / 1000);
        if (QLog.isColorLevel()) {
            QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResultForWeb result:" + z16 + " ,type:" + this.f285604d0 + " ,cost:" + currentTimeMillis);
        }
        if (z16) {
            IBlessApi iBlessApi = (IBlessApi) QRoute.api(IBlessApi.class);
            Y2();
            Intent blessIntent = ((IBlessJsApi) QRoute.api(IBlessJsApi.class)).getBlessIntent(new Intent(), this.f285609i0, this.f285604d0, this.f285602b0.size());
            if (this.f285604d0 == iBlessApi.getBlessManager_TYPE_TEXT_Value() && !TextUtils.isEmpty(this.f285605e0)) {
                ReportController.o(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.f285604d0), String.valueOf(this.f285602b0.size()), "", "");
            } else if (this.f285604d0 == iBlessApi.getBlessManager_TYPE_PTV_Value() || this.f285604d0 == iBlessApi.getBlessManager_TYPE_PIC_Value()) {
                Intent intent = new Intent("tencent.video.q2v.startUploadPTV");
                intent.putExtra("broadcastType", 1);
                intent.putExtra("recordType", this.f285604d0);
                this.app.getApp().sendBroadcast(intent);
                MessageForShortVideo messageForShortVideo = (MessageForShortVideo) iBlessApi.getPtvMessage(this.app);
                if (this.f285604d0 == iBlessApi.getBlessManager_TYPE_PTV_Value() && messageForShortVideo != null) {
                    String ptvUrlByUuid = iBlessApi.getPtvUrlByUuid(this.app, messageForShortVideo.uuid, messageForShortVideo.md5);
                    blessIntent = ((IBlessJsApi) QRoute.api(IBlessJsApi.class)).getPtvIntent(blessIntent, ptvUrlByUuid, messageForShortVideo.uuid, messageForShortVideo.md5, PluginBaseInfoHelper.Base64Helper.encodeToString(this.app.getCurrentNickname().getBytes(), 2), messageForShortVideo.videoFileName, messageForShortVideo.mThumbFilePath);
                    if (QLog.isColorLevel()) {
                        QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResultForWeb ptvurl:" + ptvUrlByUuid);
                    }
                }
            }
            sendBroadcast(blessIntent);
            finish();
            return;
        }
        QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.f285604d0);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.finish();
        int i3 = this.mEntrance;
        if (i3 == 15 || i3 == 32) {
            ((IBlessApi) QRoute.api(IBlessApi.class)).clearUinListToSend(this.app);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (QLog.isColorLevel()) {
                        QLog.i("BlessSelectMemberActivity", 2, "handleMessage realStartEncode!");
                    }
                    f3();
                    return false;
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send bless msg timeout!");
            }
            u3();
            E0 = true;
            Y2();
            r3(this, R.string.hlu);
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send video cannel!");
        }
        u3();
        E0 = true;
        Y2();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity
    public void initTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.initTitleBar();
        this.mTitleBar.setBackgroundColor(getResources().getColor(R.color.f156824ch));
        this.mTitle.setTextColor(-1);
        this.mLeftBackBtn.setTextColor(getResources().getColorStateList(R.color.bless_btn_text));
        this.mRightBtn.setTextColor(getResources().getColorStateList(R.color.bless_btn_text));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity, com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    public void l3(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
            return;
        }
        if (j3 > 300) {
            j3 = 300;
        }
        if (j3 <= 0) {
            j3 = 15;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BlessSelectMemberActivity", 2, "setSendMsgOverloadDuration: " + j3);
        }
        A0 = j3;
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity, android.app.Activity
    public void onRestart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onRestart();
        if (((IBlessApi) QRoute.api(IBlessApi.class)).isUinListToSendChangedOnMem(this.app)) {
            ((IBlessApi) QRoute.api(IBlessApi.class)).setUinListToSendChangedOnMen(this.app, false);
            ArrayList<String> uinListToSend = ((IBlessApi) QRoute.api(IBlessApi.class)).getUinListToSend(this.app);
            if (uinListToSend != null && uinListToSend.size() >= 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = uinListToSend.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(next), "BlessSelectMemberActivity");
                    if (friendsSimpleInfoWithUid != null) {
                        arrayList.add(SelectMemberActivity.constructAResultRecord(next, friendsSimpleInfoWithUid.m(), 0, "-1"));
                    }
                }
                addFriendResults(arrayList, true);
                ((SelectMemberInnerFrame) this.mInnerFrameManager.getCurrentView()).p();
            }
        }
    }

    protected void p3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        if (this.f285601a0 == null) {
            ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
            this.f285601a0 = reportDialog;
            reportDialog.setContentView(R.layout.f167676dz);
            this.f285601a0.setOnKeyListener(new e());
            this.f285601a0.findViewById(R.id.jg_).setOnClickListener(new f());
            this.f285601a0.show();
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = this.f285601a0.getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            attributes.height = defaultDisplay.getHeight();
            this.f285601a0.getWindow().setAttributes(attributes);
            if (this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value()) {
                Window window = this.f285601a0.getWindow();
                window.getAttributes().dimAmount = 0.7f;
                window.addFlags(2);
            }
        }
        TextView textView = (TextView) this.f285601a0.findViewById(R.id.photo_prievew_progress_dialog_text);
        if (TextUtils.isEmpty(str)) {
            textView.setText(R.string.hew);
        } else {
            textView.setText(str);
        }
        if (!this.f285601a0.isShowing()) {
            if (QLog.isColorLevel()) {
                QLog.e("BlessSelectMemberActivity", 2, "showProgressDialog");
            }
            this.f285601a0.show();
        }
    }

    public void s3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        Intent intent = new Intent("tencent.video.q2v.startUploadPTV");
        intent.putExtra("broadcastType", 1);
        intent.putExtra("recordType", this.f285604d0);
        this.app.getApp().sendBroadcast(intent);
        ((IBlessApi) QRoute.api(IBlessApi.class)).reportSendResult(this.app, this.f285602b0, b3(this.mEntrance));
        if (this.mEntrance == 32) {
            ((IBlessApi) QRoute.api(IBlessApi.class)).gotoSplashActivity(this, z16);
            finish();
            QQToast.makeText(this, 2, R.string.ifn, 1).show();
        }
    }

    protected void showConfirmDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X8006190", "0X8006190", 0, 0, String.valueOf(this.f285604d0), "", "", "");
        if (this.f285616p0 == null || this.f285617q0 == null) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = this.mEntrance;
            if (i3 == 15) {
                sb5.append(getString(R.string.f170614vx));
            } else if (i3 == 32) {
                sb5.append(getString(R.string.ifm));
            }
            for (int i16 = 0; i16 < this.f285602b0.size() && i16 < 50; i16++) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f285602b0.get(i16)), "BlessSelectMemberActivity");
                if (friendsSimpleInfoWithUid != null) {
                    sb5.append(friendsSimpleInfoWithUid.m());
                    sb5.append("\u3001 ");
                }
            }
            sb5.setLength(sb5.length() - 2);
            if (this.f285602b0.size() != 1) {
                sb5.append(String.format(getString(R.string.f170615vy), "", Integer.valueOf(this.f285602b0.size())));
            }
            String sb6 = sb5.toString();
            this.f285616p0 = sb6;
            this.f285617q0 = DialogUtil.createCustomDialog(this, -1, (String) null, sb6, R.string.cancel, R.string.f170613vv, new c(), new d());
            if (this.f285604d0 == ((IBlessApi) QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value()) {
                Window window = this.f285617q0.getWindow();
                window.getAttributes().dimAmount = 0.7f;
                window.addFlags(2);
            }
            TextView textView = (TextView) this.f285617q0.findViewById(R.id.dialogText);
            textView.setMaxLines(4);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            textView.setGravity(3);
            textView.post(new Runnable(textView, sb5) { // from class: com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TextView f285622d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ StringBuilder f285623e;

                {
                    this.f285622d = textView;
                    this.f285623e = sb5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BlessSelectMemberActivity.this, textView, sb5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int lineEnd;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f285622d.getLineCount() >= 4 && (lineEnd = this.f285622d.getLayout().getLineEnd(3)) < this.f285623e.length()) {
                        int i17 = 0;
                        String format = String.format(BlessSelectMemberActivity.this.getString(R.string.f170615vy), MiniBoxNoticeInfo.APPNAME_SUFFIX, Integer.valueOf(BlessSelectMemberActivity.this.f285602b0.size()));
                        float measureText = this.f285622d.getPaint().measureText(format);
                        while (true) {
                            if (i17 >= this.f285623e.length()) {
                                break;
                            }
                            int i18 = lineEnd - i17;
                            if (this.f285622d.getPaint().measureText(this.f285623e.substring(i18, lineEnd)) >= measureText) {
                                this.f285623e.setLength(i18);
                                break;
                            }
                            i17++;
                        }
                        BlessSelectMemberActivity.this.f285616p0 = this.f285623e.toString();
                        if (BlessSelectMemberActivity.this.f285616p0.endsWith("\u3001 ")) {
                            StringBuilder sb7 = this.f285623e;
                            sb7.setLength(sb7.length() - 2);
                        } else if (BlessSelectMemberActivity.this.f285616p0.endsWith("\u3001")) {
                            StringBuilder sb8 = this.f285623e;
                            sb8.setLength(sb8.length() - 1);
                        }
                        this.f285623e.append(format);
                        BlessSelectMemberActivity.this.f285616p0 = this.f285623e.toString();
                        this.f285622d.setEllipsize(null);
                        this.f285622d.setText(BlessSelectMemberActivity.this.f285616p0);
                    }
                }
            });
        }
        if (!isFinishing()) {
            this.f285617q0.show();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity
    protected void startCreateOrAdd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
        int i3 = this.mEntrance;
        if (i3 != 15 && i3 != 32) {
            this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, this.mResultList);
            setResult(-1, this.mIntent);
            finish();
            return;
        }
        this.f285602b0.clear();
        if (this.mResultList.size() > 0) {
            Iterator<ResultRecord> it = this.mResultList.iterator();
            while (it.hasNext()) {
                this.f285602b0.add(it.next().uin);
            }
        }
        showConfirmDialog();
    }

    public void t3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        v.a aVar = new v.a();
        aVar.v(str);
        aVar.m(1056);
        aVar.y(0);
        aVar.x("0");
        aVar.B(this.app.getCurrentAccountUin());
        aVar.I(0);
        com.tencent.mobileqq.pic.v l3 = aVar.l();
        l3.T = false;
        p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, 1056);
        createPicReq.f(l3);
        ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
    }

    protected void u3() {
        IHttpCommunicatorListener findProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) ((IBlessApi) QRoute.api(IBlessApi.class)).getPtvMessage(this.app);
        if (messageForShortVideo != null && (findProcessor = ((ITransFileController) this.app.getRuntimeService(ITransFileController.class, "")).findProcessor(messageForShortVideo.frienduin, messageForShortVideo.uniseq)) != null && IShortVideoUploadProcessor.class.isInstance(findProcessor)) {
            boolean isPause = ((BaseTransProcessor) findProcessor).isPause();
            int i3 = messageForShortVideo.videoFileStatus;
            if (isPause || i3 == 1002 || i3 == 1001) {
                ((IBlessApi) QRoute.api(IBlessApi.class)).stopSendingShortVideo(this.app, messageForShortVideo.frienduin, messageForShortVideo.uniseq);
            }
        }
        if (this.f285614n0 != null) {
            ITransFileController iTransFileController = (ITransFileController) this.app.getRuntimeService(ITransFileController.class, "");
            MessageForPic messageForPic = this.f285614n0;
            IHttpCommunicatorListener findProcessor2 = iTransFileController.findProcessor(messageForPic.frienduin, messageForPic.uniseq);
            if (findProcessor2 != null && ((IPicTransFile) this.app.getRuntimeService(IPicTransFile.class, "")).getC2CUploadProClass().isInstance(findProcessor2)) {
                boolean isPause2 = ((BaseTransProcessor) findProcessor2).isPause();
                if (QLog.isColorLevel()) {
                    QLog.d("BlessSelectMemberActivity", 2, "stop pic upload, pause:" + isPause2);
                }
            }
        }
        k kVar = this.f285608h0;
        if (kVar != null && kVar.getStatus() != AsyncTask.Status.FINISHED) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessSelectMemberActivity", 2, "cancel the uploadTask!");
            }
            this.f285608h0.cancel(true);
        }
    }
}
