package com.tencent.mobileqq.forward;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MessageShareActivity;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import common.config.service.QzoneConfig;
import cooperation.qqfav.util.HandlerPlus;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class ForwardSdkBaseOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;
    protected static final Object S;
    protected String C;
    protected com.tencent.biz.widgets.f D;
    protected boolean E;
    protected g F;
    protected AbsShareMsg G;
    protected long H;
    protected boolean I;
    protected com.tencent.mobileqq.forward.b J;
    public int K;
    protected boolean L;
    protected String M;
    private Handler.Callback N;
    private HandlerPlus P;
    protected com.tencent.open.appcommon.d Q;

    @SuppressLint({"HandlerLeak"})
    private Handler R;

    /* renamed from: d, reason: collision with root package name */
    public long f210818d;

    /* renamed from: e, reason: collision with root package name */
    protected String f210819e;

    /* renamed from: f, reason: collision with root package name */
    protected String f210820f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f210821h;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f210822i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f210823m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            g gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (message.what != 2) {
                return false;
            }
            QQCustomDialog qQCustomDialog = ForwardSdkBaseOption.this.mConfirmDialog;
            if (qQCustomDialog != null && qQCustomDialog.isShowing() && (gVar = ForwardSdkBaseOption.this.F) != null) {
                gVar.c();
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                dialogInterface.dismiss();
            } catch (Exception e16) {
                QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "handleSDForImageShare dismiss Exception:", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements com.tencent.open.appcommon.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00ea A[Catch: all -> 0x0111, TryCatch #0 {, blocks: (B:11:0x0043, B:29:0x004a, B:31:0x0053, B:33:0x0058, B:35:0x0069, B:36:0x0080, B:43:0x00c2, B:44:0x00b7, B:14:0x00d5, B:16:0x00dc, B:18:0x00e4, B:20:0x00ea, B:22:0x00f5, B:23:0x010a, B:24:0x010f, B:27:0x0101), top: B:10:0x0043 }] */
        @Override // mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            ForwardSdkBaseOption forwardSdkBaseOption;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            ForwardSdkBaseOption.this.z("KEY_GET_APP_INFO", z16);
            QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive isSuccess = ", Boolean.valueOf(z16));
            synchronized (ForwardSdkBaseOption.S) {
                ForwardSdkBaseOption.this.I = false;
                GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = null;
                if (z16) {
                    try {
                        byte[] byteArray = bundle.getByteArray("data");
                        if (byteArray != null) {
                            GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse2 = new GetAppInfoProto$GetAppinfoResponse();
                            try {
                                getAppInfoProto$GetAppinfoResponse2.mergeFrom(byteArray);
                                ForwardSdkBaseOption.this.J = com.tencent.mobileqq.forward.b.a(getAppInfoProto$GetAppinfoResponse2);
                                ForwardSdkBaseOption forwardSdkBaseOption2 = ForwardSdkBaseOption.this;
                                if (forwardSdkBaseOption2 instanceof ForwardSdkShareOption) {
                                    ForwardD55Manager c16 = ((u) forwardSdkBaseOption2.app.getManager(QQManagerFactory.SDK_SHARE)).c();
                                    ForwardSdkBaseOption forwardSdkBaseOption3 = ForwardSdkBaseOption.this;
                                    c16.j(forwardSdkBaseOption3.f210818d, forwardSdkBaseOption3.J);
                                }
                                QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "get appinfo time=", Long.valueOf(System.currentTimeMillis() - ForwardSdkBaseOption.this.H), ", ret=", Integer.valueOf(getAppInfoProto$GetAppinfoResponse2.ret.get()));
                                ForwardSdkBaseOption.this.l();
                                getAppInfoProto$GetAppinfoResponse = getAppInfoProto$GetAppinfoResponse2;
                            } catch (Exception e16) {
                                e = e16;
                                getAppInfoProto$GetAppinfoResponse = getAppInfoProto$GetAppinfoResponse2;
                                QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver.onReceive ", e.getMessage());
                                ForwardSdkBaseOption.this.hideProgressDialog();
                                if (getAppInfoProto$GetAppinfoResponse != null) {
                                    forwardSdkBaseOption = ForwardSdkBaseOption.this;
                                    if (forwardSdkBaseOption instanceof ForwardSdkShareOption) {
                                    }
                                }
                                QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive success, go share");
                                ForwardSdkBaseOption.S.notify();
                            }
                        } else {
                            QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive data=null");
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                }
                ForwardSdkBaseOption.this.hideProgressDialog();
                if (getAppInfoProto$GetAppinfoResponse != null && getAppInfoProto$GetAppinfoResponse.ret.get() != 0) {
                    forwardSdkBaseOption = ForwardSdkBaseOption.this;
                    if (forwardSdkBaseOption instanceof ForwardSdkShareOption) {
                        if (forwardSdkBaseOption.mExtraData.getBoolean("enable_d55", false)) {
                            ForwardSdkBaseOption.this.D(getAppInfoProto$GetAppinfoResponse.f342197msg.get(), true);
                        }
                        ForwardSdkBaseOption.S.notify();
                    }
                }
                QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive success, go share");
                ForwardSdkBaseOption.S.notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ForwardSdkBaseOption.this.endForwardCallback(false);
            com.tencent.mobileqq.phonecontact.constant.b.f258441a = false;
            ForwardSdkBaseOption.this.mActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            com.tencent.mobileqq.phonecontact.constant.b.f258441a = false;
            Intent aliasIntent = SplashActivity.getAliasIntent(ForwardSdkBaseOption.this.mActivity);
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            aliasIntent.setFlags(67108864);
            aliasIntent.setFlags(268435456);
            ForwardSdkBaseOption.this.mActivity.startActivity(aliasIntent);
            ForwardSdkBaseOption.this.mActivity.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f extends Handler {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this);
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
            if (i3 == 0) {
                QQToast.makeText(ForwardSdkBaseOption.this.mActivity, HardCodeUtil.qqStr(R.string.mqb), 0).show();
            } else if (1 == i3) {
                ForwardSdkBaseOption.this.mActivity.setResult(-1);
                ForwardSdkBaseOption.this.mActivity.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Context f210831a;

        /* renamed from: b, reason: collision with root package name */
        View f210832b;

        /* renamed from: c, reason: collision with root package name */
        HashMap<AbsStructMsgElement, View> f210833c;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    AbsShareMsg absShareMsg = ForwardSdkBaseOption.this.G;
                    if (absShareMsg != null) {
                        String trim = absShareMsg.mMsgUrl.trim();
                        if (QLog.isColorLevel()) {
                            QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "gotoWeb " + trim);
                        }
                        Intent intent = new Intent(ForwardSdkBaseOption.this.mActivity, (Class<?>) QQBrowserDelegationActivity.class);
                        intent.putExtra("param_force_internal_browser", true);
                        intent.putExtra("reqType", 7);
                        intent.putExtra("hide_more_button", true);
                        intent.putExtra("url", trim);
                        WebAccelerator.s(ForwardSdkBaseOption.this.mActivity, intent, trim);
                        ForwardSdkBaseOption.this.reportClickContentAction();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this, (Object) context);
            } else {
                this.f210833c = new HashMap<>(1);
                this.f210831a = context;
            }
        }

        boolean a(AbsStructMsg absStructMsg) {
            List<AbsStructMsgElement> structMsgItemLists;
            if ((absStructMsg instanceof StructMsgForGeneralShare) && (structMsgItemLists = ((StructMsgForGeneralShare) absStructMsg).getStructMsgItemLists()) != null) {
                for (int i3 = 0; i3 < structMsgItemLists.size(); i3++) {
                    AbsStructMsgElement absStructMsgElement = structMsgItemLists.get(i3);
                    if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.u) {
                        int i16 = ((com.tencent.mobileqq.structmsg.view.u) absStructMsgElement).R0;
                        if (i16 == 1 || i16 == 3) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View b() {
            AbsShareMsg absShareMsg = ForwardSdkBaseOption.this.G;
            if (absShareMsg instanceof StructMsgForImageShare) {
                return absShareMsg.getPreDialogView(this.f210831a, null);
            }
            if (absShareMsg instanceof StructMsgForAudioShare) {
                this.f210832b = absShareMsg.getPreDialogView(this.f210831a, this.f210832b);
            } else {
                HeightLimitedLinearLayout heightLimitedLinearLayout = new HeightLimitedLinearLayout(this.f210831a);
                heightLimitedLinearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                heightLimitedLinearLayout.setLayoutParams(layoutParams);
                heightLimitedLinearLayout.setMaxHeight(this.f210831a.getResources().getDisplayMetrics().heightPixels >> 1);
                this.f210832b = heightLimitedLinearLayout;
                c();
                if (a(ForwardSdkBaseOption.this.G)) {
                    ForwardSdkBaseOption forwardSdkBaseOption = ForwardSdkBaseOption.this;
                    if (forwardSdkBaseOption.G.mMsgUrl != null && !(forwardSdkBaseOption instanceof ForwardQZoneRichImageOption)) {
                        forwardSdkBaseOption.mForwardReportType = 8;
                        FrameLayout frameLayout = new FrameLayout(this.f210831a);
                        View view = new View(ForwardSdkBaseOption.this.mActivity);
                        view.setBackgroundResource(R.drawable.f160746ms);
                        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(33.0f), 16));
                        view.setOnClickListener(new a());
                        view.setContentDescription(HardCodeUtil.qqStr(R.string.mqv));
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 16);
                        layoutParams2.rightMargin = ViewUtils.dip2px(16.0f);
                        frameLayout.addView(this.f210832b, layoutParams2);
                        ImageView imageView = new ImageView(ForwardSdkBaseOption.this.mActivity);
                        imageView.setImageResource(R.drawable.forward_dialog_file_arrow_normal);
                        frameLayout.addView(imageView, new FrameLayout.LayoutParams(ViewUtils.dip2px(8.0f), ViewUtils.dip2px(14.0f), 21));
                        return frameLayout;
                    }
                }
            }
            return this.f210832b;
        }

        void c() {
            View view;
            TextView textView;
            AbsShareMsg absShareMsg = ForwardSdkBaseOption.this.G;
            if (absShareMsg != null && (view = this.f210832b) != null) {
                if (absShareMsg instanceof StructMsgForImageShare) {
                    QLog.w("ForwardOption.ForwardSdkBaseOption", 1, "updateStructView|StructMsgForImageShare not supported\uff01");
                    return;
                }
                if (absShareMsg instanceof StructMsgForAudioShare) {
                    absShareMsg.getPreDialogView(this.f210831a, view);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("pre_dialog", true);
                ArrayList arrayList = new ArrayList(1);
                boolean z16 = false;
                for (AbsStructMsgElement absStructMsgElement : ForwardSdkBaseOption.this.G.getStructMsgItemLists()) {
                    View view2 = this.f210833c.get(absStructMsgElement);
                    View c16 = absStructMsgElement.c(this.f210831a, view2, bundle);
                    if (c16 != null && (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.u) && (textView = (TextView) c16.findViewById(R.id.kbs)) != null) {
                        textView.setGravity(16);
                        textView.setMaxLines(2);
                        textView.setTextSize(14.0f);
                        textView.setTextColor(this.f210831a.getResources().getColor(R.color.f157083je));
                    }
                    if (c16 != null && c16 != view2) {
                        this.f210833c.put(absStructMsgElement, c16);
                        arrayList.add(c16);
                        z16 = true;
                    }
                }
                if (z16) {
                    ((ViewGroup) this.f210832b).removeAllViewsInLayout();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((ViewGroup) this.f210832b).addView((View) it.next());
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72185);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            S = new Object();
        }
    }

    public ForwardSdkBaseOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210823m = false;
        this.C = "";
        this.E = false;
        this.H = 0L;
        this.L = false;
        this.M = null;
        this.N = new a();
        this.P = new HandlerPlus(Looper.getMainLooper(), this.N);
        this.Q = new c();
        this.R = new f();
    }

    private void B(int i3, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
        bundle.putString("act_type", "80");
        bundle.putString("intext_1", "" + com.tencent.open.agent.report.e.b(i3));
        bundle.putString("intext_3", "0");
        ReportCenter.f().m(bundle, "", this.app.getCurrentAccountUin(), false, z16);
    }

    public static final void E(Activity activity, boolean z16, String str, long j3, int i3, String str2) {
        if (activity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + z16 + " appid=" + j3 + " action=" + str);
        }
        Intent intent = new Intent();
        if (z16) {
            intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", Long.valueOf(j3), str, Integer.valueOf(i3), str2)));
        } else {
            intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", Long.valueOf(j3), str)));
        }
        if (activity.getIntent() != null) {
            String stringExtra = activity.getIntent().getStringExtra("pkg_name");
            if (TextUtils.isEmpty(stringExtra)) {
                try {
                    stringExtra = activity.getIntent().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA).getString("pkg_name");
                } catch (Exception unused) {
                    stringExtra = null;
                }
            }
            intent.setPackage(stringExtra);
        }
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardSdkBaseOption", 2, e16.getMessage());
            }
        }
    }

    public static final void F(Activity activity, boolean z16, String str, long j3) {
        if (activity == null) {
            QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "startSdkCallback activity is null ");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=", Boolean.valueOf(z16), " appid=", Long.valueOf(j3), " action=", str);
        }
        Intent intent = new Intent();
        if (z16) {
            intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(j3), str)));
        } else {
            intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", Long.valueOf(j3), str)));
        }
        if (activity.getIntent() != null) {
            String stringExtra = activity.getIntent().getStringExtra("pkg_name");
            if (TextUtils.isEmpty(stringExtra)) {
                try {
                    stringExtra = activity.getIntent().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA).getString("pkg_name");
                } catch (Exception unused) {
                    stringExtra = null;
                }
            }
            intent.setPackage(stringExtra);
        }
        try {
            activity.startActivity(intent);
        } catch (Exception e16) {
            QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "startSdkCallback failed ", e16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void G(Activity activity, Intent intent, boolean z16) {
        String str;
        if (activity != null && intent != null) {
            Bundle bundleExtra = intent.getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA);
            if (bundleExtra == null) {
                bundleExtra = intent.getExtras();
            }
            if (bundleExtra != null) {
                str = bundleExtra.getString(QZoneShareManager.QZONE_SHARE_ACTION);
            }
            str = "shareToQzone";
            long j3 = 0;
            if (bundleExtra != null) {
                j3 = bundleExtra.getLong("req_share_id", 0L);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + z16 + " appid=" + j3 + " action=shareToQzone");
            }
            Intent intent2 = new Intent();
            if (z16) {
                intent2.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(j3), str)));
            } else {
                intent2.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", Long.valueOf(j3), str)));
            }
            QZoneHelper.addSource(intent2);
            if (bundleExtra != null) {
                try {
                    intent2.setPackage(bundleExtra.getString("pkg_name"));
                } catch (Exception unused) {
                    intent2.setPackage(null);
                }
            }
            try {
                activity.startActivity(intent2);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOption.ForwardSdkBaseOption", 2, e16, new Object[0]);
                }
            }
        }
    }

    private void H(String str) {
        if (this.isSdkShare) {
            ForwardStatisticsReporter.m(str);
        }
    }

    private void p() {
        String f16 = this.J.f();
        if (TextUtils.isEmpty(f16)) {
            return;
        }
        this.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, f16);
        String string = this.mExtraData.getString("app_name");
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "oldAppName=", string, ", mAppInfo.appName=", f16 + ", pkgName=", this.J.j());
        if (TextUtils.isEmpty(string) || string.equals(this.J.j())) {
            this.mExtraData.putString("app_name", this.J.f());
        }
    }

    protected void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), str, str2);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_error_code", i3);
        intent.putExtra("key_error_msg", str);
        intent.putExtra("key_error_detail", str2);
        intent.putExtra("key_response", "");
        this.mActivity.setResult(-1, intent);
        if (this.mActivity instanceof SplashActivity) {
            hideProgressDialog();
        } else if (!isMultiTarget2Send()) {
            this.mActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
            return;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive show forbidden dialog");
        String string = this.mExtraData.getString("app_name");
        QQCustomDialog createCustomDialogUrl = DialogUtil.createCustomDialogUrl(this.mActivity, 230);
        createCustomDialogUrl.setTitle(this.mActivity.getString(R.string.hiz));
        if (z16) {
            if (TextUtils.isEmpty(str)) {
                str = this.mActivity.getString(R.string.f173136hj0);
            }
            createCustomDialogUrl.setMessageWithUrl(str);
        } else {
            createCustomDialogUrl.setMessage(R.string.f173136hj0);
        }
        QQCustomDialog positiveButton = createCustomDialogUrl.setPositiveButton(R.string.hii, new e());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mActivity.getString(R.string.button_back));
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        sb5.append(string);
        positiveButton.setNegativeButton(sb5.toString(), new d());
        createCustomDialogUrl.setCancelable(false);
        createCustomDialogUrl.show();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bundle);
            return;
        }
        if (i3 >= 0) {
            this.mExtraData.putInt("key_forward_ability_type", i3);
        }
        if (bundle != null) {
            this.mExtraData.putAll(bundle);
        }
        if (this.mActivity.isFinishing()) {
            return;
        }
        if (!v()) {
            super.buildForwardDialog(i3, bundle);
            if (i3 == com.tencent.mobileqq.forward.e.T3.intValue()) {
                this.mConfirmDialog.setEditLint("");
            }
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle2.putString("act_type", "81");
            bundle2.putString("intext_1", "" + com.tencent.open.agent.report.e.b(this.K));
            bundle2.putString("intext_2", "" + com.tencent.open.agent.report.e.c(bundle.getInt("uintype"), bundle.getString("uin")));
            bundle2.putString("intext_3", "0");
            ReportCenter.f().m(bundle2, "", this.app.getCurrentAccountUin(), false, this.isSdkShare);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardToMyComputer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mExtraData.putBoolean("forward_jump_to_data_line_aio", true);
            super.forwardToMyComputer(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.J.o()) {
            if (!TextUtils.isEmpty(this.J.i())) {
                this.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, this.J.i());
            }
            String h16 = this.J.h();
            if (!TextUtils.isEmpty(h16)) {
                this.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON_BIG, h16);
            }
            if (!TextUtils.isEmpty(this.J.n()) && this.f210818d != Long.parseLong(QZoneShareManager.QQ_SHARE_APPID)) {
                this.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, this.J.n());
            }
            p();
            if (!TextUtils.isEmpty(this.J.j())) {
                this.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, this.J.j());
            }
            AbsShareMsg absShareMsg = this.G;
            if (absShareMsg != null) {
                absShareMsg.mSourceIcon = this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON);
                this.G.mSourceName = this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME);
                if (TextUtils.isEmpty(this.G.mSourceName)) {
                    this.G.mSourceName = this.mExtraData.getString("app_name");
                }
            }
            this.mExtraData.putByte(AppConstants.Key.STRUCT_SHARE_KEY_APPINFO_STATUS, (byte) 1);
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.mConfirmDialog.dismiss();
        }
        com.tencent.biz.widgets.f fVar = this.mResultDlg;
        if (fVar != null && fVar.isShowing()) {
            this.mResultDlg.dismiss();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "asyncUploadImageAndSendToBuddy mForwardSubType=" + this.K);
        }
        String str = this.C;
        if (str != null) {
            this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, str);
        }
        if (this.K != 5) {
            String string = this.mExtraData.getString("detail_url");
            if (!com.tencent.mobileqq.structmsg.d.e(string)) {
                y();
                return;
            } else {
                showProgressDialog(R.string.b1z);
                ThreadManagerV2.post(new Runnable(string) { // from class: com.tencent.mobileqq.forward.ForwardSdkBaseOption.7
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f210824d;

                    {
                        this.f210824d = string;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this, (Object) string);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        String c16 = com.tencent.mobileqq.structmsg.d.c(ForwardSdkBaseOption.this.mActivity.getApplicationContext(), ForwardSdkBaseOption.this.app.getCurrentUin(), this.f210824d);
                        if (!TextUtils.isEmpty(c16)) {
                            ForwardSdkBaseOption.this.mExtraData.putString("video_url", c16);
                            ForwardSdkBaseOption.this.mExtraData.putBoolean(AppConstants.Key.SHARE_VIDEO_SHOULD_LOAD, true);
                        }
                        ForwardSdkBaseOption.this.y();
                    }
                }, 8, null, false);
                return;
            }
        }
        showProgressDialog(R.string.b1z);
        x("ForwardOption.ForwardSdkBaseOption", "ThreadManager.post asyncUploadImageAndSendToBuddy");
        ThreadManagerV2.post(n(), 8, null, false);
    }

    protected Runnable n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Runnable) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardSdkBaseOption.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ForwardSdkBaseOption.this.x("ForwardOption.ForwardSdkBaseOption", "asyncUploadImageAndSendToBuddy running...");
                for (int i3 = 0; i3 < 3; i3++) {
                    ForwardSdkBaseOption forwardSdkBaseOption = ForwardSdkBaseOption.this;
                    if (forwardSdkBaseOption.J != null) {
                        break;
                    }
                    try {
                        forwardSdkBaseOption.x("ForwardOption.ForwardSdkBaseOption", "asyncUploadImageAndSendToBuddy sleeping...");
                        LockMethodProxy.sleep(1000L);
                        ForwardSdkBaseOption.this.x("ForwardOption.ForwardSdkBaseOption", "asyncUploadImageAndSendToBuddy awake.");
                    } catch (InterruptedException e16) {
                        QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "InterruptedException", e16);
                        ForwardSdkBaseOption.this.A();
                        return;
                    }
                }
                ForwardSdkBaseOption forwardSdkBaseOption2 = ForwardSdkBaseOption.this;
                if (forwardSdkBaseOption2.f210818d != 65520 && !forwardSdkBaseOption2.q()) {
                    ForwardSdkBaseOption.this.A();
                    return;
                }
                com.tencent.mobileqq.forward.b bVar = ForwardSdkBaseOption.this.J;
                if (bVar != null) {
                    if (bVar.n() != null && ForwardSdkBaseOption.this.f210818d != Long.parseLong(QZoneShareManager.QQ_SHARE_APPID)) {
                        ForwardSdkBaseOption forwardSdkBaseOption3 = ForwardSdkBaseOption.this;
                        forwardSdkBaseOption3.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, forwardSdkBaseOption3.J.n());
                    }
                    if (!TextUtils.isEmpty(ForwardSdkBaseOption.this.J.i())) {
                        ForwardSdkBaseOption forwardSdkBaseOption4 = ForwardSdkBaseOption.this;
                        forwardSdkBaseOption4.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, forwardSdkBaseOption4.J.i());
                    }
                    if (ForwardSdkBaseOption.this.J.f() != null) {
                        ForwardSdkBaseOption forwardSdkBaseOption5 = ForwardSdkBaseOption.this;
                        forwardSdkBaseOption5.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, forwardSdkBaseOption5.J.f());
                    }
                    if (ForwardSdkBaseOption.this.J.j() != null) {
                        ForwardSdkBaseOption forwardSdkBaseOption6 = ForwardSdkBaseOption.this;
                        forwardSdkBaseOption6.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, forwardSdkBaseOption6.J.j());
                    }
                }
                String currentAccountUin = ForwardSdkBaseOption.this.app.getCurrentAccountUin();
                String string = ForwardSdkBaseOption.this.mExtraData.getString("detail_url");
                String string2 = ForwardSdkBaseOption.this.mExtraData.getString("image_url");
                String string3 = ForwardSdkBaseOption.this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL);
                String string4 = ForwardSdkBaseOption.this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON);
                HashMap<String, String> hashMap = new HashMap<>();
                if (!TextUtils.isEmpty(string) && string.length() > 150) {
                    hashMap.put("targetUrl", string);
                }
                if (!TextUtils.isEmpty(string3)) {
                    hashMap.put("sourceUrl", string3);
                }
                if (!TextUtils.isEmpty(string4)) {
                    hashMap.put("sourceIcon", string4);
                }
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.U = currentAccountUin;
                imageInfo.C = ForwardSdkBaseOption.this.mExtraData.getString("uin");
                ForwardSdkBaseOption forwardSdkBaseOption7 = ForwardSdkBaseOption.this;
                String scaleLocalImage = StructMsgForImageShare.scaleLocalImage(forwardSdkBaseOption7.mActivity, imageInfo, string2, forwardSdkBaseOption7.mExtraData.getInt("uintype"));
                if (scaleLocalImage != null) {
                    string2 = scaleLocalImage;
                }
                CompressInfo compressInfo = new CompressInfo(string2, 0);
                ((ICompressOperator) QRoute.api(ICompressOperator.class)).startThumbnail(compressInfo);
                if (compressInfo.H != null) {
                    ForwardSdkBaseOption.this.mExtraData.putInt(AppConstants.Key.STRUCT_SHARE_KEY_THUMB_HEIGHT, compressInfo.J);
                    ForwardSdkBaseOption.this.mExtraData.putInt(AppConstants.Key.STRUCT_SHARE_KEY_THUMB_WIDTH, compressInfo.I);
                }
                ForwardSdkBaseOption.this.mExtraData.putString("image_url", string2);
                ForwardSdkBaseOption.this.mExtraData.remove(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
                ForwardSdkBaseOption.this.mExtraData.remove("title");
                ForwardSdkBaseOption.this.mExtraData.remove("desc");
                ForwardSdkBaseOption.this.mExtraData.remove("detail_url");
                ForwardSdkBaseOption.this.t(string, currentAccountUin, hashMap);
            }
        };
    }

    protected boolean o() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.isSdkShare && this.J != null) {
            String string = this.mExtraData.getString("image_url");
            String string2 = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                String h16 = this.J.h();
                this.mExtraData.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, h16);
                AbsShareMsg absShareMsg = this.G;
                if (absShareMsg != null) {
                    absShareMsg.updateCover(h16);
                    this.P.sendEmptyMessage(2);
                }
                QLog.i("ForwardSdkBaseOption", 1, "checkAndUseAppIcon|use app icon:" + h16);
                Bundle bundle = new Bundle();
                bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                bundle.putString("act_type", "18");
                if (TextUtils.isEmpty(h16)) {
                    str = "1";
                } else {
                    str = "0";
                }
                bundle.putString("intext_1", str);
                ReportCenter.f().m(bundle, "" + this.appid, this.app.getCurrentUin(), false, this.isSdkShare);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.biz.widgets.f fVar = this.mResultDlg;
        if (fVar != null && fVar.isShowing()) {
            this.mResultDlg.dismiss();
        }
        com.tencent.biz.widgets.f fVar2 = this.D;
        if (fVar2 != null && fVar2.isShowing()) {
            this.D.dismiss();
        }
        Handler handler = this.f210822i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.R;
        if (handler2 != null) {
            handler2.removeMessages(0);
            this.R = null;
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void onNegativeResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (this.E) {
            F(this.mActivity, true, "shareToQQ", this.f210818d);
        } else {
            F(this.mActivity, false, "shareToQQ", this.f210818d);
        }
        this.mActivity.setResult(1);
        this.mActivity.finish();
        if (QLog.isColorLevel()) {
            QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "back call");
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void onPositiveResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "send call");
        }
        m();
        Bundle bundle = new Bundle();
        bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
        bundle.putString("act_type", "82");
        bundle.putString("intext_1", "" + com.tencent.open.agent.report.e.b(this.K));
        bundle.putString("intext_2", "" + com.tencent.open.agent.report.e.c(this.mExtraData.getInt("uintype"), this.mExtraData.getString("uin")));
        bundle.putString("intext_3", "0");
        ReportCenter.f().m(bundle, "", this.app.getCurrentAccountUin(), false, this.isSdkShare);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        String str = "";
        this.C = "";
        this.f210821h = "login".equals(this.mIntent.getStringExtra(AppConstants.Key.SHARE_REQ_SHARE_JFROM));
        long j3 = this.mExtraData.getLong("req_share_id");
        if (TextUtils.isEmpty(this.mIntent.getStringExtra("pkg_name")) && !QZoneShareManager.QQ_SHARE_APPID.equals(String.valueOf(this.mExtraData.getLong("req_share_id"))) && !QZoneShareManager.KUOLIE_SHARE_APPID.equals(String.valueOf(this.mExtraData.getLong("req_share_id")))) {
            this.mExtraData.putLong("req_share_id", 65520L);
        }
        this.f210818d = this.mExtraData.getLong("req_share_id");
        this.f210819e = this.mIntent.getStringExtra("open_id");
        this.f210820f = this.mIntent.getStringExtra("share_uin");
        this.K = this.mIntent.getIntExtra(AppConstants.Key.SHARE_REQ_TYPE, Integer.MAX_VALUE);
        String string = this.mExtraData.getString("detail_url");
        String string2 = this.mExtraData.getString("image_url");
        String string3 = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        long Z = ForwardUtils.Z(this.mExtraData.getString(AppConstants.Key.SHARE_REQ_CHANNEL_SRC));
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "preloadData subType=", Integer.valueOf(this.K), ",targetUrl=", string, ",remoteImg=", string3, ",localImg=", string2);
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string3) && !HttpUtil.isValidUrl(string3)) {
            try {
                if (string3.startsWith("//")) {
                    string3 = new URL(string).getProtocol() + ":" + string3;
                    this.mExtraData.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, string3);
                } else {
                    string3 = null;
                }
            } catch (MalformedURLException unused) {
            }
            QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "repair invalid img url=", string3);
        }
        B(this.K, this.isSdkShare);
        if (!r(string2, string3)) {
            return false;
        }
        if (w()) {
            z("KEY_STAGE_1_TOTAL", true);
            QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "-->preloadData-- null != mAppInfo");
            return true;
        }
        if (j3 > 0 && !QZoneShareManager.KUOLIE_SHARE_APPID.equals(String.valueOf(j3))) {
            this.H = System.currentTimeMillis();
            this.I = true;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String string4 = this.mExtraData.getString("pkg_name");
            if (!TextUtils.isEmpty(string4)) {
                str = com.tencent.open.agent.util.g.o(this.mAppContext, string4, currentTimeMillis + "");
            }
            String str2 = str;
            QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "-->sdk_share, getting appinfo in construct. sign: ", str2);
            if (!(this instanceof ForwardSdkShareOption)) {
                showProgressDialog(R.string.h5l);
                this.mProgressDialog.setCancelable(false);
            }
            long k3 = x.k();
            H("KEY_GET_APP_INFO");
            QQAppInterface qQAppInterface = this.app;
            Share.m(qQAppInterface, this.mAppContext, qQAppInterface.getCurrentAccountUin(), j3, str2, Z, currentTimeMillis, this.Q, string4, k3, true);
            return true;
        }
        if (!(this instanceof ForwardSdkShareOption)) {
            return true;
        }
        D("", false);
        return true;
    }

    protected boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean r(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (this.K == 5 && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "-->preloadData--is image share type, but imageUrl and remoteImageUrl are both empty");
            }
            C(-1, HardCodeUtil.qqStr(R.string.mq6), HardCodeUtil.qqStr(R.string.mqh));
            try {
                com.tencent.open.business.viareport.c.a().b(1, "SHARE_CHECK_AGENT", this.app.getCurrentAccountUin(), String.valueOf(this.f210818d), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "\u5206\u4eab\u7684\u56fe\u7247\u4e0d\u5b58\u5728");
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        String string = this.mExtraData.getString("title");
        String string2 = this.mExtraData.getString("desc");
        if (!TextUtils.isEmpty(string) && string.endsWith(MiniBoxNoticeInfo.APPNAME_SUFFIX)) {
            string = string.substring(0, string.lastIndexOf(MiniBoxNoticeInfo.APPNAME_SUFFIX));
        }
        if (!TextUtils.isEmpty(string2) && string2.endsWith(MiniBoxNoticeInfo.APPNAME_SUFFIX)) {
            string2 = string2.substring(0, string2.lastIndexOf(MiniBoxNoticeInfo.APPNAME_SUFFIX));
        }
        if (com.tencent.biz.common.util.j.d(string, "UTF-8") > 80) {
            string = com.tencent.biz.common.util.j.f(string, 80, "UTF-8", null);
        }
        if (com.tencent.biz.common.util.j.d(string2, "UTF-8") > 130) {
            string2 = com.tencent.biz.common.util.j.f(string2, 130, "UTF-8", null);
        }
        if (string != null && !string.endsWith(MiniBoxNoticeInfo.APPNAME_SUFFIX) && !string.equals(this.mExtraData.getString("title"))) {
            string = string + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        if (string2 != null && !string2.endsWith(MiniBoxNoticeInfo.APPNAME_SUFFIX) && !string2.equals(this.mExtraData.getString("desc"))) {
            string2 = string2 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        this.mExtraData.putString("title", string);
        this.mExtraData.putString("desc", string2);
    }

    protected void t(String str, String str2, HashMap<String, String> hashMap) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, hashMap);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
        bundle2.putString("act_type", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE);
        bundle2.putString("intext_3", "0");
        bundle2.putString("stringext_1", str);
        ReportCenter.f().m(bundle2, "", str2, false, this.isSdkShare);
        ForwardStatisticsReporter.m("batch_url_exchange");
        HashMap<String, String> batchUrlExchange = HttpUtil.batchUrlExchange(BaseApplication.getContext(), str2, 1, hashMap, bundle);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("param_ret_code", Integer.toString(bundle.getInt("retcode", -1)));
        ForwardStatisticsReporter.i("batch_url_exchange", str2, hashMap2, bundle.getBoolean("isSuccess"));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (batchUrlExchange != null && batchUrlExchange.size() > 0 && batchUrlExchange.get(batchUrlExchange.keySet().iterator().next()).contains("url.cn")) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (QLog.isColorLevel()) {
            String str3 = "batchUrlExchange for IMAGE_SHARE, isFailed = " + i3 + ", cost = " + currentTimeMillis2;
            if (i3 != 1 && currentTimeMillis2 <= 3000) {
                QLog.d("ForwardOption.ForwardSdkBaseOption", 2, str3);
            } else {
                QLog.e("ForwardOption.ForwardSdkBaseOption", 2, str3);
            }
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
        bundle3.putString("act_type", "12");
        bundle3.putString("intext_3", "0");
        bundle3.putString("intext_1", "" + i3);
        bundle3.putString("intext_2", "" + bundle.getInt("retcode", 0));
        bundle3.putString("intext_5", "" + currentTimeMillis2);
        if (i3 == 1) {
            bundle3.putString("stringext_1", str);
        }
        ReportCenter.f().m(bundle3, "", str2, false, this.isSdkShare);
        if (batchUrlExchange != null) {
            if (batchUrlExchange.containsKey("imageUrl")) {
                this.mExtraData.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, batchUrlExchange.get("imageUrl"));
                this.mExtraData.remove("image_url");
            }
            if (batchUrlExchange.containsKey("audioUrl")) {
                this.mExtraData.putString(AppConstants.Key.SHARE_REQ_AUDIO_URL, batchUrlExchange.get("audioUrl"));
            }
            if (batchUrlExchange.containsKey("targetUrl")) {
                this.mExtraData.putString("detail_url", batchUrlExchange.get("targetUrl"));
            }
            if (batchUrlExchange.containsKey("sourceUrl")) {
                this.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, batchUrlExchange.get("sourceUrl"));
            }
            if (batchUrlExchange.containsKey("sourceIcon")) {
                this.mExtraData.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, batchUrlExchange.get("sourceIcon"));
            }
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardSdkBaseOption.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardSdkBaseOption.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ForwardSdkBaseOption.this.y();
                }
            }
        });
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        AbsShareMsg absShareMsg = this.G;
        if (absShareMsg != null) {
            return absShareMsg.mMsgServiceID;
        }
        return 0;
    }

    protected boolean v() {
        String str;
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        String string = this.mExtraData.getString("image_url");
        int i3 = this.mExtraData.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "QQShare find local image shareType:", Integer.valueOf(i3));
        if (i3 != 5 || TextUtils.isEmpty(string) || string.startsWith("http://") || string.startsWith("https://")) {
            return false;
        }
        boolean b16 = BaseForwardUtil.b(this.mAppContext);
        File externalFilesDir = this.mAppContext.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        } else {
            str = "";
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "QQShare find local image hasSDPermission:", Boolean.valueOf(b16), ", localImageUrl:", string, ",appSpecificPath=", str);
        if (b16 || TextUtils.isEmpty(str) || string.contains(str) || (activity = this.mActivity) == null || activity.isFinishing()) {
            return false;
        }
        DialogUtil.createCustomDialog(this.mActivity, 233, HardCodeUtil.qqStr(R.string.f173206i10), HardCodeUtil.qqStr(R.string.w89), -1, R.string.w88, new b(), (DialogInterface.OnClickListener) null).show();
        return true;
    }

    protected boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return ((u) this.app.getManager(QQManagerFactory.SDK_SHARE)).c().g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) str2);
        } else if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        String str;
        if (this.mActivity.isFinishing()) {
            QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "realSendStructMsg mActivity.isFinishing()");
            A();
            return;
        }
        int i3 = 0;
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "realSendStructMsg, mForwardSubType = ", Integer.valueOf(this.K));
        hideProgressDialog();
        if (this.mIntent.getIntExtra("forward_type", -1) == 2) {
            AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(this.mExtraData);
            e16.forwardID = this.mExtraData.getInt("KEY_MSG_FORWARD_ID", 0);
            if (isMultiTarget2Send()) {
                for (ResultRecord resultRecord : this.mExtraData.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET)) {
                    AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg) e16, resultRecord.uin, resultRecord.getUinType(), resultRecord.groupUin);
                }
            } else {
                AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg) e16, this.mExtraData.getString("uin"), this.mExtraData.getInt("uintype"), this.mExtraData.getString("troop_uin"));
            }
        } else {
            Intent intent = new Intent(this.mActivity, (Class<?>) MessageShareActivity.class);
            Bundle bundle = new Bundle(this.mExtraData);
            Activity activity = this.mActivity;
            if (activity instanceof IphoneTitleBarActivity) {
                ((IphoneTitleBarActivity) activity).setTitle((CharSequence) null);
            }
            intent.putExtras(bundle);
            intent.setFlags(67108864);
            this.mActivity.startActivity(intent);
        }
        String string = this.mExtraData.getString("uin");
        int i16 = this.mExtraData.getInt("uintype");
        this.mExtraData.getString("troop_uin");
        StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(this.app, "sha_share2qq", 1, "", "", String.valueOf(this.f210818d));
        if (this.K == 5) {
            str = "connect_sharepic";
        } else {
            str = "connect_share2qq";
        }
        com.tencent.biz.common.util.k.j(this.app, string, str, "send", this.f210818d, u(), String.valueOf(i16));
        C(0, "", "");
        Bundle bundle2 = new Bundle();
        bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
        bundle2.putString("act_type", "83");
        bundle2.putString("intext_1", "" + com.tencent.open.agent.report.e.b(this.K));
        bundle2.putString("intext_2", "" + com.tencent.open.agent.report.e.c(i16, string));
        bundle2.putString("intext_3", "0");
        ReportCenter.f().m(bundle2, "", this.app.getCurrentAccountUin(), false, this.isSdkShare);
        String string2 = this.mExtraData.getString("detail_url");
        if (this.isSdkShare && !TextUtils.isEmpty(string2)) {
            Bundle bundle3 = new Bundle();
            bundle3.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle3.putString("act_type", "55");
            com.tencent.mobileqq.forward.b bVar = this.J;
            if (bVar != null) {
                i3 = bVar.c();
            }
            bundle3.putString("intext_1", "" + i3);
            bundle3.putString("app_id", "" + this.f210818d);
            ReportCenter.f().m(bundle3, "", this.app.getCurrentAccountUin(), false, this.isSdkShare);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Boolean.valueOf(z16));
        } else if (this.isSdkShare) {
            ForwardStatisticsReporter.k(str, z16);
        }
    }
}
