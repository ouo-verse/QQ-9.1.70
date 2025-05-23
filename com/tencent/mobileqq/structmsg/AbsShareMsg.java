package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5BuilderFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.ag;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.structmsg.view.au;
import com.tencent.mobileqq.structmsg.view.t;
import com.tencent.mobileqq.structmsg.view.u;
import com.tencent.mobileqq.structmsg.view.y;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.realname.RealNameSource;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class AbsShareMsg extends AbsStructMsg implements Iterable<AbsStructMsgElement> {
    static IPatchRedirector $redirector_ = null;
    public static final int PACKAGE_NAME_INDEX = 0;
    public static final int URL_DATA_INDEX = 1;
    public int forwardType;
    public String mAdSourceIcon;
    public String mAdSourceMenu;
    public String mAdSourceName;
    public String mContentCover;
    public int mContentLayout;
    public String mContentSrc;
    public String mContentSummary;
    public String mContentTitle;
    JSONObject mDatas;
    public boolean mHasAdSource;
    boolean mHasSource;
    public boolean mMsgException;
    public String mSourceAction;
    public String mSourceActionData;
    public long mSourceAppid;
    public String mSourceIcon;
    public String mSourceName;
    protected View.OnClickListener mSourceOnClickListener;
    public String mSourceUrl;
    public String mSource_A_ActionData;
    public String mSource_I_ActionData;
    public List<AbsStructMsgElement> mStructMsgItemLists;
    public ShareData shareData;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class ShareData implements Externalizable {
        static IPatchRedirector $redirector_ = null;
        public static final byte APP_INFO_STATUS_INIT = 0;
        public static final byte APP_INFO_STATUS_READY = 1;
        public static final byte IMAGE_URL_STATUS_INIT = 0;
        public static final byte IMAGE_URL_STATUS_LOCAL = 2;
        public static final byte IMAGE_URL_STATUS_OK = 1;
        public static final byte IMAGE_URL_STATUS_REMOTE = 4;
        public static final byte IMAGE_URL_STATUS_REMOTE_CHANGED = 3;
        public static final byte SHORT_URL_STATUS_CHANGED = 1;
        public static final byte SHORT_URL_STATUS_INIT = 0;
        public byte appInfoStatus;
        public byte imageUrlStatus;
        public String pkgName;
        public byte shortUrlStatus;
        public String sourceIconBig;
        public int status;
        public byte version;

        public ShareData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.version = (byte) 1;
            this.appInfoStatus = (byte) 0;
            this.imageUrlStatus = (byte) 0;
            this.shortUrlStatus = (byte) 0;
            this.status = 0;
        }

        public boolean isFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (this.status == 1003) {
                return true;
            }
            return false;
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) objectInput);
                return;
            }
            this.version = objectInput.readByte();
            this.appInfoStatus = objectInput.readByte();
            this.imageUrlStatus = objectInput.readByte();
            this.shortUrlStatus = objectInput.readByte();
            this.status = objectInput.readInt();
            this.pkgName = objectInput.readUTF();
            this.sourceIconBig = objectInput.readUTF();
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) objectOutput);
                return;
            }
            objectOutput.writeByte(this.version);
            objectOutput.writeByte(this.appInfoStatus);
            objectOutput.writeByte(this.imageUrlStatus);
            objectOutput.writeByte(this.shortUrlStatus);
            objectOutput.writeInt(this.status);
            String str = this.pkgName;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            objectOutput.writeUTF(str);
            String str3 = this.sourceIconBig;
            if (str3 != null) {
                str2 = str3;
            }
            objectOutput.writeUTF(str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;
        String A;

        /* renamed from: a, reason: collision with root package name */
        Class<? extends AbsShareMsg> f290289a;

        /* renamed from: b, reason: collision with root package name */
        AbsShareMsg f290290b;

        /* renamed from: c, reason: collision with root package name */
        int f290291c;

        /* renamed from: d, reason: collision with root package name */
        int f290292d;

        /* renamed from: e, reason: collision with root package name */
        String f290293e;

        /* renamed from: f, reason: collision with root package name */
        String f290294f;

        /* renamed from: g, reason: collision with root package name */
        String f290295g;

        /* renamed from: h, reason: collision with root package name */
        String f290296h;

        /* renamed from: i, reason: collision with root package name */
        String f290297i;

        /* renamed from: j, reason: collision with root package name */
        String f290298j;

        /* renamed from: k, reason: collision with root package name */
        String f290299k;

        /* renamed from: l, reason: collision with root package name */
        int f290300l;

        /* renamed from: m, reason: collision with root package name */
        int f290301m;

        /* renamed from: n, reason: collision with root package name */
        int f290302n;

        /* renamed from: o, reason: collision with root package name */
        String f290303o;

        /* renamed from: p, reason: collision with root package name */
        String f290304p;

        /* renamed from: q, reason: collision with root package name */
        String f290305q;

        /* renamed from: r, reason: collision with root package name */
        String f290306r;

        /* renamed from: s, reason: collision with root package name */
        String f290307s;

        /* renamed from: t, reason: collision with root package name */
        String f290308t;

        /* renamed from: u, reason: collision with root package name */
        String f290309u;

        /* renamed from: v, reason: collision with root package name */
        long f290310v;

        /* renamed from: w, reason: collision with root package name */
        boolean f290311w;

        /* renamed from: x, reason: collision with root package name */
        String f290312x;

        /* renamed from: y, reason: collision with root package name */
        String f290313y;

        /* renamed from: z, reason: collision with root package name */
        long f290314z;

        public a(Class<? extends AbsShareMsg> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls);
                return;
            }
            this.f290294f = null;
            this.f290295g = null;
            this.f290296h = null;
            this.f290297i = null;
            this.f290298j = null;
            this.f290299k = null;
            this.f290303o = null;
            this.f290304p = null;
            this.f290305q = null;
            this.f290306r = null;
            this.f290307s = null;
            this.f290308t = null;
            this.f290309u = null;
            this.f290310v = -1L;
            this.f290312x = null;
            this.f290313y = null;
            this.f290314z = 0L;
            this.A = null;
            this.f290289a = cls;
            this.f290291c = 1;
            this.f290292d = 1;
            this.f290293e = "web";
            this.f290300l = 29;
        }

        public AbsShareMsg a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (AbsShareMsg) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            try {
                this.f290290b = this.f290289a.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
            }
            AbsShareMsg absShareMsg = this.f290290b;
            if (absShareMsg != null) {
                absShareMsg.mMsgTemplateID = this.f290291c;
                absShareMsg.mMsgServiceID = this.f290292d;
                absShareMsg.mVersion = this.f290300l;
                absShareMsg.mMsgAction = this.f290293e;
                absShareMsg.mMsgActionData = this.f290294f;
                absShareMsg.mMsg_A_ActionData = this.f290295g;
                absShareMsg.mMsg_I_ActionData = this.f290296h;
                absShareMsg.mMsgUrl = this.f290297i;
                absShareMsg.mMsgBrief = this.f290298j;
                absShareMsg.mCompatibleText = this.f290299k;
                absShareMsg.mFlag = this.f290302n;
                absShareMsg.mSourceAction = this.f290304p;
                absShareMsg.mSourceUrl = this.f290303o;
                absShareMsg.mSourceActionData = this.f290305q;
                absShareMsg.mSource_A_ActionData = this.f290306r;
                absShareMsg.mSource_I_ActionData = this.f290307s;
                absShareMsg.mSourceName = this.f290309u;
                absShareMsg.mSourceIcon = this.f290308t;
                absShareMsg.mHasSource = this.f290311w;
                absShareMsg.mResid = this.f290312x;
                absShareMsg.mFileName = this.f290313y;
                absShareMsg.mFileSize = this.f290314z;
                absShareMsg.mSType = this.A;
            }
            return absShareMsg;
        }

        public a b(String str, String str2, String str3, String str4, String str5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (a) iPatchRedirector.redirect((short) 10, this, str, str2, str3, str4, str5);
            }
            this.f290293e = str;
            this.f290297i = str2;
            this.f290294f = str3;
            this.f290295g = str4;
            this.f290296h = str5;
            return this;
        }

        public a c(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (a) iPatchRedirector.redirect((short) 17, (Object) this, j3);
            }
            this.f290310v = j3;
            return this;
        }

        public a d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f290298j = str;
            return this;
        }

        public a e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            this.f290299k = str;
            return this;
        }

        public a f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f290302n = i3;
            if ((i3 & 1) == 1) {
                this.f290301m = 1;
            }
            return this;
        }

        public a g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.f290292d = i3;
            return this;
        }

        public a h(String str, String str2, String str3, String str4, String str5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (a) iPatchRedirector.redirect((short) 14, this, str, str2, str3, str4, str5);
            }
            this.f290304p = str;
            this.f290303o = str2;
            this.f290305q = str3;
            this.f290306r = str4;
            this.f290307s = str5;
            return this;
        }

        public a i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2);
            }
            this.f290309u = str;
            this.f290308t = str2;
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                this.f290311w = true;
            }
            return this;
        }

        public a j(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (a) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            }
            return b("web", str, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsShareMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mStructMsgItemLists = new ArrayList();
        this.mContentLayout = -1;
        this.mContentCover = null;
        this.mContentSrc = null;
        this.mContentTitle = null;
        this.mContentSummary = null;
        this.mSourceUrl = null;
        this.mSourceAction = null;
        this.mSourceActionData = null;
        this.mSource_A_ActionData = null;
        this.mSource_I_ActionData = null;
        this.mSourceIcon = null;
        this.mSourceName = null;
        this.mSourceAppid = -1L;
        this.mMsgException = false;
        this.mAdSourceIcon = null;
        this.mAdSourceName = null;
        this.shareData = new ShareData();
        this.mDatas = null;
        this.mAdSourceMenu = null;
        this.mSourceOnClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.structmsg.AbsShareMsg.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private long f290285d;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsShareMsg.this);
                } else {
                    this.f290285d = 0L;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:119:0x03fb  */
            /* JADX WARN: Removed duplicated region for block: B:164:0x028b A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x03b5  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x03ee  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0403  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x04da  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                AbsShareMsg absShareMsg;
                String str;
                String str2;
                AbsShareMsg absShareMsg2;
                QQAppInterface qQAppInterface;
                String str3;
                ax c16;
                String f16;
                String f17;
                int i3;
                int i16;
                String str4;
                String str5;
                String str6;
                String str7;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else if (SystemClock.uptimeMillis() - this.f290285d >= 1000) {
                    this.f290285d = SystemClock.uptimeMillis();
                    Object tag = view.getTag();
                    if (tag != null && AbsShareMsg.class.isInstance(tag)) {
                        AbsShareMsg absShareMsg3 = (AbsShareMsg) tag;
                        Context context = view.getContext();
                        if (SplashActivity.class.isInstance(context) || ChatActivity.class.isInstance(context)) {
                            if (context == null) {
                                QLog.e("StructMsg", 1, "context is null, never do click, return");
                            } else {
                                ChatFragment chatFragment = ((BaseActivity) context).getChatFragment();
                                if (chatFragment == null) {
                                    QLog.e("StructMsg", 1, "context.getChatFragment is null, never do click, return");
                                } else {
                                    QQAppInterface ph5 = chatFragment.ph();
                                    if (ph5 != null) {
                                        String str8 = AbsShareMsg.this.mSourceActionData;
                                        if (str8 != null && str8.startsWith("mqqapi://qsubscribe")) {
                                            QLog.i("StructMsg", 2, "scheme jump to subscribe hybird");
                                            try {
                                                Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                                                intent.setData(Uri.parse(AbsShareMsg.this.mSourceActionData));
                                                intent.putExtra("from", "from_aio");
                                                context.startActivity(intent);
                                            } catch (Exception e16) {
                                                e16.printStackTrace();
                                            }
                                        } else {
                                            String str9 = AbsShareMsg.this.mSourceAction;
                                            if (str9.equals("web") && AbsShareMsg.this.mSourceUrl.contains("webcard.mp.qq.com")) {
                                                AbsShareMsg absShareMsg4 = AbsShareMsg.this;
                                                absShareMsg4.mSourceAction = "plugin";
                                                absShareMsg4.mSource_A_ActionData = String.format(IPublicAccountBrowser.SCHEME_ANDROID_PUBLIC_ACCOUNT_DETAIL, absShareMsg4.source_puin);
                                                str9 = "plugin";
                                            }
                                            if (QLog.isColorLevel()) {
                                                QLog.d("StructMsg", 2, "mSourceOnClickListener sourceAction = " + str9);
                                            }
                                            if ("app".equals(str9)) {
                                                String str10 = AbsShareMsg.this.mMsgActionData;
                                                if (str10 != null && (str10.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID) || AbsShareMsg.this.mMsg_A_ActionData.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID))) {
                                                    AbsShareMsg.this.m(context);
                                                }
                                                ReportCenter.f().p(ph5.getAccount(), "", String.valueOf(AbsShareMsg.this.mSourceAppid), "1000", "80", "0", false);
                                            } else {
                                                if ("web".equals(str9)) {
                                                    AbsShareMsg absShareMsg5 = AbsShareMsg.this;
                                                    String str11 = absShareMsg5.mSourceUrl;
                                                    int i17 = absShareMsg5.mMsgServiceID;
                                                    if (i17 == 114) {
                                                        str11 = ((MedalWallMng) ph5.getManager(QQManagerFactory.MEDAL_WALL_MNG)).i(true, ph5.getCurrentAccountUin(), MedalWallMng.Q);
                                                    } else if (absShareMsg3.uinType == 1 && (i17 == 116 || i17 == 123)) {
                                                        str11 = String.format("%s&gc=%s", str11, com.tencent.mobileqq.nearby.k.b(absShareMsg3.uin));
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess groupUin:" + absShareMsg3.uin);
                                                        }
                                                    }
                                                    if (!TextUtils.isEmpty(str11) && str11.equals("mqqapi://readinjoy/open?src_type=internal&version=1&target=1")) {
                                                        ax c17 = bi.c(ph5, context, str11);
                                                        if (c17 != null) {
                                                            c17.b();
                                                        } else {
                                                            context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(str11)));
                                                        }
                                                        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str11, "", "", "");
                                                    }
                                                    str2 = ColorRingJsPlugin.Method_SetUp;
                                                } else if ("plugin".equals(str9)) {
                                                    if (absShareMsg3.uinType == 1) {
                                                        AbsShareMsg absShareMsg6 = AbsShareMsg.this;
                                                        if (absShareMsg6.mMsgServiceID == 123) {
                                                            absShareMsg6.mSourceActionData = com.tencent.mobileqq.confess.g.i(absShareMsg6.mSourceActionData, absShareMsg3.uin);
                                                            boolean f18 = com.tencent.mobileqq.confess.g.f(ph5, absShareMsg3.uin, false);
                                                            String str12 = AbsShareMsg.this.mMsgUrl;
                                                            if (f18 && !TextUtils.isEmpty(str12) && (context instanceof BaseActivity)) {
                                                                QLog.w("StructMsg", 1, "GeneralClickHandler clickWebMsg source confess url:" + str12);
                                                            }
                                                            if (!f18) {
                                                                QQToast.makeText(BaseApplication.getContext(), com.tencent.mobileqq.confess.g.f202191a, 0).show();
                                                            }
                                                            if (QLog.isColorLevel()) {
                                                                QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess url:" + AbsShareMsg.this.mSourceActionData);
                                                            }
                                                            absShareMsg = AbsShareMsg.this;
                                                            if (absShareMsg.mSourceName.equals(absShareMsg.readInjoy)) {
                                                                try {
                                                                    str = Uri.parse(AbsShareMsg.this.mMsgUrl).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                                                                } catch (Exception e17) {
                                                                    e17.printStackTrace();
                                                                    str = null;
                                                                }
                                                                if (!TextUtils.isEmpty(str)) {
                                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, str, AbsShareMsg.this.mMsgUrl, "", "", false);
                                                                } else {
                                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, "", AbsShareMsg.this.mMsgUrl, "", "", false);
                                                                }
                                                            }
                                                            str2 = "plugin";
                                                        }
                                                    }
                                                    absShareMsg = AbsShareMsg.this;
                                                    if (absShareMsg.mSourceName.equals(absShareMsg.readInjoy)) {
                                                    }
                                                    str2 = "plugin";
                                                }
                                                AbsShareMsg absShareMsg7 = AbsShareMsg.this;
                                                com.tencent.biz.common.util.k.i(ph5, absShareMsg7.uin, "sourceclick", absShareMsg7.mSourceAppid, absShareMsg7.mMsgServiceID, str2);
                                                ReportController.o(ph5, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                                ReportController.o(ph5, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                                ReportController.o(ph5, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", AbsShareMsg.this.mSourceName, "");
                                                absShareMsg2 = AbsShareMsg.this;
                                                if (absShareMsg2.adverSign == 1) {
                                                    ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absShareMsg2.uin, "0X800631F", "0X800631F", 0, 0, "" + AbsShareMsg.this.msgId, "", "", "");
                                                }
                                                if (AbsShareMsg.this.mMsgServiceID != 114) {
                                                    qQAppInterface = ph5;
                                                    str3 = null;
                                                    ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.structmsg.AbsShareMsg.1.1
                                                        static IPatchRedirector $redirector_;

                                                        /* renamed from: d, reason: collision with root package name */
                                                        final /* synthetic */ QQAppInterface f290287d;

                                                        {
                                                            this.f290287d = qQAppInterface;
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) qQAppInterface);
                                                            }
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                                            } else {
                                                                ((MedalWallMng) this.f290287d.getManager(QQManagerFactory.MEDAL_WALL_MNG)).u(2, null);
                                                            }
                                                        }
                                                    }, 0, null, false);
                                                } else {
                                                    qQAppInterface = ph5;
                                                    str3 = null;
                                                }
                                                if (absShareMsg3 instanceof StructMsgForGeneralShare) {
                                                    StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absShareMsg3;
                                                    if (structMsgForGeneralShare.mIsPAVideoStructMsg) {
                                                        Iterator<AbsStructMsgElement> it = structMsgForGeneralShare.iterator();
                                                        while (it.hasNext()) {
                                                            AbsStructMsgElement next = it.next();
                                                            if (next instanceof y) {
                                                                Iterator<AbsStructMsgElement> it5 = ((y) next).U0.iterator();
                                                                while (it5.hasNext()) {
                                                                    AbsStructMsgElement next2 = it5.next();
                                                                    if (next2 instanceof StructMsgItemVideo) {
                                                                        StructMsgItemVideo structMsgItemVideo = (StructMsgItemVideo) next2;
                                                                        if (structMsgItemVideo.v()) {
                                                                            String a16 = ((IVideoR5BuilderFactory) QRoute.api(IVideoR5BuilderFactory.class)).create(str3, structMsgForGeneralShare.source_puin, structMsgItemVideo.W0, structMsgItemVideo.f290492g1).put("aio_app_id", Long.valueOf(structMsgForGeneralShare.mSourceAppid)).a();
                                                                            int i18 = structMsgForGeneralShare.uinType;
                                                                            if (i18 == 1008) {
                                                                                str6 = "1";
                                                                            } else if (i18 == 0) {
                                                                                str6 = "2";
                                                                            } else if (i18 == 1) {
                                                                                str6 = "3";
                                                                            } else if (i18 == 3000) {
                                                                                str6 = "4";
                                                                            } else {
                                                                                str5 = "";
                                                                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, str5, Integer.toString(((IVideoReporter) QRoute.api(IVideoReporter.class)).getReportVideoType(structMsgItemVideo.f290495j1, structMsgForGeneralShare.mSourceName)), "", a16, false);
                                                                                IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                                                                String str13 = structMsgForGeneralShare.source_puin;
                                                                                str7 = structMsgItemVideo.f290492g1;
                                                                                if (str7 == null) {
                                                                                    str7 = "0";
                                                                                }
                                                                                str4 = str3;
                                                                                iPublicAccountReportUtils.publicAccountReportClickEvent(qQAppInterface, str13, "0x8007410", "0x8007410", 0, 0, "1", "", str7, a16, false);
                                                                                str3 = str4;
                                                                            }
                                                                            str5 = str6;
                                                                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, str5, Integer.toString(((IVideoReporter) QRoute.api(IVideoReporter.class)).getReportVideoType(structMsgItemVideo.f290495j1, structMsgForGeneralShare.mSourceName)), "", a16, false);
                                                                            IPublicAccountReportUtils iPublicAccountReportUtils2 = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                                                            String str132 = structMsgForGeneralShare.source_puin;
                                                                            str7 = structMsgItemVideo.f290492g1;
                                                                            if (str7 == null) {
                                                                            }
                                                                            str4 = str3;
                                                                            iPublicAccountReportUtils2.publicAccountReportClickEvent(qQAppInterface, str132, "0x8007410", "0x8007410", 0, 0, "1", "", str7, a16, false);
                                                                            str3 = str4;
                                                                        }
                                                                    }
                                                                    str4 = str3;
                                                                    str3 = str4;
                                                                }
                                                            }
                                                            str3 = str3;
                                                        }
                                                    }
                                                }
                                                if (absShareMsg3.mMsgServiceID == 81 && !TextUtils.isEmpty(absShareMsg3.mMsg_A_ActionData) && (c16 = bi.c(qQAppInterface, context, absShareMsg3.mMsg_A_ActionData)) != null) {
                                                    f16 = c16.f("usertype");
                                                    f17 = c16.f("unionid");
                                                    if (!TextUtils.isEmpty(f16) && !TextUtils.isEmpty(f17)) {
                                                        try {
                                                            i16 = Integer.parseInt(f16);
                                                            i3 = 1;
                                                        } catch (NumberFormatException unused) {
                                                            i3 = 1;
                                                            i16 = 0;
                                                        }
                                                        String[] strArr = new String[i3];
                                                        strArr[0] = f17;
                                                        id0.a.n("share_uin_obj", "clk_tail", 0, i16, strArr);
                                                    }
                                                }
                                            }
                                            str2 = "";
                                            AbsShareMsg absShareMsg72 = AbsShareMsg.this;
                                            com.tencent.biz.common.util.k.i(ph5, absShareMsg72.uin, "sourceclick", absShareMsg72.mSourceAppid, absShareMsg72.mMsgServiceID, str2);
                                            ReportController.o(ph5, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                            ReportController.o(ph5, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                            ReportController.o(ph5, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", AbsShareMsg.this.mSourceName, "");
                                            absShareMsg2 = AbsShareMsg.this;
                                            if (absShareMsg2.adverSign == 1) {
                                            }
                                            if (AbsShareMsg.this.mMsgServiceID != 114) {
                                            }
                                            if (absShareMsg3 instanceof StructMsgForGeneralShare) {
                                            }
                                            if (absShareMsg3.mMsgServiceID == 81) {
                                                f16 = c16.f("usertype");
                                                f17 = c16.f("unionid");
                                                if (!TextUtils.isEmpty(f16)) {
                                                    i16 = Integer.parseInt(f16);
                                                    i3 = 1;
                                                    String[] strArr2 = new String[i3];
                                                    strArr2[0] = f17;
                                                    id0.a.n("share_uin_obj", "clk_tail", 0, i16, strArr2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mVersion = 29;
    }

    private boolean d() {
        List<AbsStructMsgElement> list;
        ag agVar;
        ArrayList<AbsStructMsgElement> arrayList;
        if (TextUtils.isEmpty(this.mSourceAction) && (list = this.mStructMsgItemLists) != null && !list.isEmpty()) {
            AbsStructMsgElement absStructMsgElement = this.mStructMsgItemLists.get(0);
            if ((absStructMsgElement instanceof ag) && (arrayList = (agVar = (ag) absStructMsgElement).U0) != null && !arrayList.isEmpty()) {
                AbsStructMsgElement absStructMsgElement2 = agVar.U0.get(0);
                if (!(absStructMsgElement2 instanceof com.tencent.mobileqq.structmsg.view.e)) {
                    return false;
                }
                return ((com.tencent.mobileqq.structmsg.view.e) absStructMsgElement2).n();
            }
        }
        return false;
    }

    public static final void doReport(QQAppInterface qQAppInterface, AbsShareMsg absShareMsg) {
        StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(qQAppInterface, absShareMsg.uin, "Structured_msg", "Clk_smsg", 0, 1, null, String.valueOf(absShareMsg.mSourceAppid), String.valueOf(absShareMsg.mMsgServiceID), absShareMsg.mMsgAction, null);
        if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "doReport msg:" + absShareMsg);
        }
    }

    private int g(String[] strArr) {
        if (h(strArr)) {
            return 4;
        }
        if (i(strArr)) {
            return 8;
        }
        return -1;
    }

    private boolean h(String[] strArr) {
        return strArr[7].equals(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
    }

    private boolean i(String[] strArr) {
        if (strArr[7].equals("scrawl_link") && strArr.length >= 9) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Context context) {
        String str;
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTER_VIPCOMIC);
        activityURIRequest.extra().putString("options", "{\"from\":28, \"mod\":\"4008004\"}");
        QRoute.startUri(activityURIRequest, (o) null);
        String[] a16 = com.tencent.mobileqq.richmediabrowser.j.a(this.mMsgActionData);
        if (a16 != null && a16.length >= 8) {
            int g16 = g(a16);
            if (g16 == -1) {
                str = "";
            } else {
                str = a16[g16];
            }
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.uin, context, "3009", "2", "40059", a16[0], a16[2], a16[4], str);
        }
    }

    private static void n(QQAppInterface qQAppInterface, TransferRequest transferRequest) {
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    public static final String[] parsePackageNameAndData(String str, String str2) {
        int indexOf;
        String[] strArr = {"", ""};
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            indexOf = -1;
        } else {
            indexOf = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        }
        if (indexOf == -1) {
            strArr[0] = str;
        } else {
            strArr[0] = str.substring(0, indexOf);
            strArr[1] = str.substring(indexOf + 3);
        }
        return strArr;
    }

    public static void resendSdkFakeMessage(MessageForArkApp messageForArkApp, JSONObject jSONObject, ad adVar) {
        n((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), ForwardSdkShareProcessor.buildTransferRequest(messageForArkApp, jSONObject, adVar));
    }

    public static void resendSdkShareMessage(QQAppInterface qQAppInterface, MessageRecord messageRecord, AbsShareMsg absShareMsg) {
        MessageRecord n3 = q.n(messageRecord);
        com.tencent.mobileqq.activity.aio.forward.b.d().e(n3.uniseq, absShareMsg.parentUniseq, absShareMsg.forwardID);
        qQAppInterface.getMessageFacade().n(n3, com.tencent.mobileqq.service.message.e.Q0);
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(ForwardSdkShareProcessor.buildTransferRequestFromMessage(n3, absShareMsg));
    }

    public static MessageForArkApp sendSdkFakeMessage(Bundle bundle, QQAppInterface qQAppInterface, AbsShareMsg absShareMsg, String str, int i3, String str2, ad adVar) {
        MessageForArkApp a16 = com.tencent.mobileqq.utils.i.a(bundle, qQAppInterface, str, i3, str2);
        com.tencent.mobileqq.activity.aio.forward.b.d().e(a16.uniseq, absShareMsg.parentUniseq, absShareMsg.forwardID);
        qQAppInterface.getMessageFacade().n(a16, com.tencent.mobileqq.service.message.e.Q0);
        n(qQAppInterface, ForwardSdkShareProcessor.buildTransferRequestFromMessageExtra(a16, absShareMsg, adVar));
        QLog.d("StructMsg", 1, "sendSdkFakeMessage uinType=", Integer.valueOf(i3), ", groupUin=", str2);
        return a16;
    }

    public static void sendSdkShareMessage(QQAppInterface qQAppInterface, AbsShareMsg absShareMsg, String str, int i3, String str2) {
        String str3;
        int i16 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i16 + 1;
        long j3 = i16;
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (TextUtils.isEmpty(str2)) {
            str3 = currentAccountUin;
        } else {
            str3 = str2;
        }
        MessageForStructing A = q.A(qQAppInterface, currentAccountUin, str, str3, i3, j3, absShareMsg);
        com.tencent.mobileqq.activity.aio.forward.b.d().e(A.uniseq, absShareMsg.parentUniseq, absShareMsg.forwardID);
        qQAppInterface.getMessageFacade().n(A, MessageHandler.f194802e0);
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(ForwardSdkShareProcessor.buildTransferRequestFromMessage(A, absShareMsg));
    }

    public static void sendSdkShareMessageByServer(QQAppInterface qQAppInterface, AbsShareMsg absShareMsg, String str, int i3, String str2, ad adVar) {
        String str3;
        int i16 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i16 + 1;
        long j3 = i16;
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (TextUtils.isEmpty(str2)) {
            str3 = currentAccountUin;
        } else {
            str3 = str2;
        }
        MessageForStructing A = q.A(qQAppInterface, currentAccountUin, str, str3, i3, j3, absShareMsg);
        com.tencent.mobileqq.activity.aio.forward.b.d().e(A.uniseq, absShareMsg.parentUniseq, absShareMsg.forwardID);
        n(qQAppInterface, ForwardSdkShareProcessor.buildTransferRequestFromMessageExtra(A, absShareMsg, adVar));
        QLog.d("StructMsg", 1, "sendSdkShareMessageByServer");
    }

    public void addItem(AbsStructMsgElement absStructMsgElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) absStructMsgElement);
        } else {
            this.mStructMsgItemLists.add(absStructMsgElement);
        }
    }

    public void addItems(List<AbsStructMsgElement> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.mStructMsgItemLists.addAll(list);
        }
    }

    public void clearItems() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mStructMsgItemLists.clear();
        }
    }

    public AbsStructMsgElement findXmlNode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AbsStructMsgElement) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int itemCount = getItemCount();
        for (int i3 = 0; i3 < itemCount; i3++) {
            AbsStructMsgElement itemByIndex = getItemByIndex(i3);
            if (itemByIndex != null) {
                if (itemByIndex instanceof com.tencent.mobileqq.structmsg.a) {
                    Iterator<AbsStructMsgElement> it = ((com.tencent.mobileqq.structmsg.a) itemByIndex).U0.iterator();
                    while (it.hasNext()) {
                        AbsStructMsgElement next = it.next();
                        if (str.equals(next.f290322e)) {
                            return next;
                        }
                    }
                } else if (str.equals(itemByIndex.f290322e)) {
                    return itemByIndex;
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    public byte[] getBytes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (byte[]) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            writeExternal(objectOutputStream);
            objectOutputStream.flush();
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, e16.getMessage());
                return null;
            }
            return null;
        }
    }

    public AbsStructMsgElement getItemByIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (AbsStructMsgElement) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        return this.mStructMsgItemLists.get(i3);
    }

    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mStructMsgItemLists.size();
    }

    public abstract View.OnClickListener getOnClickListener();

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    public View getPreDialogView(Context context, View view) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context, (Object) view);
        }
        if (QLog.isColorLevel()) {
            QLog.d("[@]", 2, "AbsShareMsg getPreDialogView start!");
        }
        HeightLimitedLinearLayout heightLimitedLinearLayout = new HeightLimitedLinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        heightLimitedLinearLayout.setOrientation(1);
        try {
            heightLimitedLinearLayout.setMaxHeight(context.getResources().getDisplayMetrics().heightPixels >> 1);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "shareMsg preDialogView setMaxHeight error!");
            }
        }
        layoutParams.gravity = 1;
        heightLimitedLinearLayout.setLayoutParams(layoutParams);
        Bundle bundle = new Bundle();
        bundle.putBoolean("pre_dialog", true);
        for (AbsStructMsgElement absStructMsgElement : this.mStructMsgItemLists) {
            View c16 = absStructMsgElement.c(context, view, bundle);
            if (c16 != null && (!(absStructMsgElement instanceof ag) || ((ag) absStructMsgElement).R0 != 1)) {
                if ((absStructMsgElement instanceof u) && (textView = (TextView) c16.findViewById(R.id.kbs)) != null) {
                    int i3 = ((u) absStructMsgElement).R0;
                    if (i3 != 1 && i3 != 3) {
                        textView.setGravity(16);
                        textView.setMaxLines(2);
                        textView.setTextSize(14.0f);
                        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_secondary));
                        if (TextUtils.isEmpty(textView.getText())) {
                            textView.setText("");
                            textView.setVisibility(0);
                        }
                    } else {
                        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_primary));
                    }
                }
                heightLimitedLinearLayout.addView(c16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("[@]", 2, "AbsShareMsg getPreDialogView end!");
        }
        return heightLimitedLinearLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    public String getSourceName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mSourceName;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    public View getSourceView(Context context, View view) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) view);
        }
        boolean z17 = this.mHasSource;
        if (this.mMsgServiceID == 35) {
            z17 = false;
        }
        if (!z17) {
            return null;
        }
        Resources resources = context.getResources();
        View view2 = view;
        if (view == null) {
            TextView textView = new TextView(context);
            textView.setSingleLine(true);
            textView.setGravity(16);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(-1);
            textView.setTextSize(2, 12.0f);
            view2 = textView;
        }
        TextView textView2 = (TextView) view2;
        textView2.setText(this.mSourceName);
        textView2.setBackgroundResource(R.drawable.f161457xw);
        if (!TextUtils.isEmpty(this.mSourceIcon)) {
            String str = this.mSourceIcon;
            Drawable drawable = resources.getDrawable(R.drawable.h2t);
            drawable.setBounds(0, 0, BaseAIOUtils.f(12.0f, resources), BaseAIOUtils.f(12.0f, resources));
            Drawable drawable2 = resources.getDrawable(R.drawable.h2u);
            drawable2.setBounds(0, 0, BaseAIOUtils.f(12.0f, resources), BaseAIOUtils.f(12.0f, resources));
            try {
                URLDrawable drawable3 = URLDrawable.getDrawable(str, drawable, drawable2);
                if (!URLDrawableHelper.isMobileNetAndAutodownDisabled(context)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                drawable3.setAutoDownload(z16);
                drawable2 = drawable3;
            } catch (Exception e16) {
                QLog.e("StructMsg", 1, e16.getMessage(), e16);
            }
            setCompoundDrawable(textView2, drawable2, resources);
        } else {
            textView2.setCompoundDrawables(null, null, null, null);
        }
        textView2.setPadding(BaseAIOUtils.f(5.0f, resources), 0, BaseAIOUtils.f(5.0f, resources), 0);
        view2.setTag(this);
        view2.setOnClickListener(this.mSourceOnClickListener);
        if (d()) {
            view2.setClickable(false);
            QLog.d("StructMsg", 1, "mSourceOnClickListener =========forbidClickForImageShare ========= ");
        } else {
            view2.setClickable(true);
        }
        return view2;
    }

    public List<AbsStructMsgElement> getStructMsgItemLists() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mStructMsgItemLists;
    }

    public String getTalkBackStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            List<AbsStructMsgElement> list = this.mStructMsgItemLists;
            if (list != null) {
                for (AbsStructMsgElement absStructMsgElement : list) {
                    if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.k) {
                        Iterator<AbsStructMsgElement> it = ((com.tencent.mobileqq.structmsg.view.k) absStructMsgElement).U0.iterator();
                        while (it.hasNext()) {
                            AbsStructMsgElement next = it.next();
                            if (next instanceof StructMsgItemTitle) {
                                stringBuffer.append(((StructMsgItemTitle) next).X0);
                            }
                        }
                    } else if (absStructMsgElement instanceof u) {
                        stringBuffer.append("\u94fe\u63a5");
                        Iterator<AbsStructMsgElement> it5 = ((u) absStructMsgElement).U0.iterator();
                        while (it5.hasNext()) {
                            AbsStructMsgElement next2 = it5.next();
                            if (next2 instanceof StructMsgItemTitle) {
                                stringBuffer.append(((StructMsgItemTitle) next2).X0);
                            } else if (next2 instanceof ap) {
                                stringBuffer.append(((ap) next2).X0);
                            }
                        }
                    } else if (absStructMsgElement instanceof t) {
                        Iterator<AbsStructMsgElement> it6 = ((t) absStructMsgElement).U0.iterator();
                        int i3 = 0;
                        while (it6.hasNext()) {
                            AbsStructMsgElement next3 = it6.next();
                            if ("type".equals(next3.f290322e) && (next3 instanceof au)) {
                                i3 = ((au) next3).R0;
                            }
                        }
                        if (i3 != 2) {
                            if (i3 != 3) {
                                stringBuffer.append("\u6587\u672c");
                            } else {
                                stringBuffer.append("\u8bed\u97f3");
                            }
                        } else {
                            stringBuffer.append("\u56fe\u7247");
                        }
                        stringBuffer.append("\u56de\u6267\u6d88\u606f");
                        if (this.message.isSend()) {
                            stringBuffer.append(",\u67e5\u770b\u9605\u8bfb\u72b6\u6001");
                        } else if ("1".equals(ReceiptMsgManager.r(this.message))) {
                            stringBuffer.append(",\u5df2\u8bfb");
                        } else {
                            stringBuffer.append(",\u672a\u8bfb");
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    public boolean isSdkShareMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return ForwardUtils.M(this.forwardType, this.mMsgServiceID);
    }

    @Override // java.lang.Iterable
    public Iterator<AbsStructMsgElement> iterator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Iterator) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mStructMsgItemLists.iterator();
    }

    protected void parseAdSourceNode(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jVar);
            return;
        }
        if (jVar == null) {
            return;
        }
        String a16 = jVar.a("name");
        this.mAdSourceName = a16;
        if (!a16.equals("")) {
            this.mHasAdSource = true;
        }
        try {
            if (this.mHasAdSource) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                List<j> list = jVar.f290430d;
                if (list != null && !list.isEmpty()) {
                    Iterator<j> it = list.iterator();
                    while (it.hasNext()) {
                        List<j> list2 = it.next().f290430d;
                        if (list2 != null && !list2.isEmpty()) {
                            for (j jVar2 : list2) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("icon_url", jVar2.a("icon_url"));
                                jSONObject2.put("action_type", jVar2.a("action_type"));
                                jSONObject2.put("title", jVar2.a("title"));
                                jSONObject2.put("action_url", jVar2.a("action_url"));
                                jSONArray.mo162put(jSONObject2);
                            }
                        }
                    }
                }
                jSONObject.put("menus", jSONArray);
                this.mAdSourceMenu = jSONObject.toString();
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, "mAdSourceMenu: " + this.mAdSourceMenu);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    protected abstract boolean parseContentNode(j jVar);

    protected void parseDataNode(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jVar);
            return;
        }
        if (this.mDatas == null) {
            this.mDatas = new JSONObject();
        }
        if ("data".equals(jVar.f290428b) && this.mMsgServiceID == 128 && TextUtils.equals("2", jVar.a(AppConstants.Key.COLUMN_MSG_TYPE))) {
            try {
                this.mDatas.put("groupcode", jVar.a("groupcode"));
                this.mDatas.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME, jVar.a(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME));
                this.mDatas.put(AppConstants.Key.COLUMN_MSG_SEQ, jVar.a(AppConstants.Key.COLUMN_MSG_SEQ));
                this.mDatas.put(AppConstants.Key.COLUMN_MSG_TYPE, jVar.a(AppConstants.Key.COLUMN_MSG_TYPE));
            } catch (JSONException e16) {
                QLog.d("StructMsg", 1, "parseDataNode error:" + e16.getMessage());
            }
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "parseDataNode json:" + this.mDatas.toString());
            }
        }
    }

    protected void parseDefaultContentNode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        com.tencent.mobileqq.structmsg.a c16 = h.c(2);
        c16.o("", this.mMsgBrief, g.f290422o4);
        addItem(c16);
    }

    protected void parseSourceNode(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) jVar);
            return;
        }
        if (jVar == null) {
            return;
        }
        this.mSourceAppid = k.e(jVar.a("appid"));
        this.mSourceName = jVar.a("name");
        if (TextUtils.isEmpty(this.mMsgBrief)) {
            this.mEmptyMsgBriefModified = true;
            if (!TextUtils.isEmpty(this.mSourceName)) {
                this.mMsgBrief = String.format(g.f290421n4, this.mSourceName);
            } else {
                this.mMsgBrief = AbsStructMsg.DEFAULT_MSG_BRIEF;
            }
        }
        this.mSourceIcon = jVar.a("icon");
        this.mSourceUrl = jVar.a("url");
        this.mSourceAction = jVar.a("action");
        this.mSourceActionData = jVar.a(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
        this.mSource_A_ActionData = jVar.a(PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA);
        this.mSource_I_ActionData = jVar.a(PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA);
        if (!this.mHasSource) {
            if (!TextUtils.isEmpty(this.mSourceName) || !TextUtils.isEmpty(this.mSourceIcon)) {
                this.mHasSource = true;
            }
        }
    }

    public abstract void report(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCompoundDrawable(TextView textView, Drawable drawable, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, textView, drawable, resources);
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(com.tencent.mobileqq.structmsg.view.c.o(drawable));
        textView.setCompoundDrawablePadding(BaseAIOUtils.f(3.0f, resources));
        bitmapDrawable.setBounds(0, 0, BaseAIOUtils.f(14.0f, resources), BaseAIOUtils.f(14.0f, resources));
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    public void setHasSource(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.mHasSource = z16;
        }
    }

    public void setSourceIcon(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        } else {
            this.mSourceIcon = str;
        }
    }

    public void setSourceName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        } else {
            this.mSourceName = str;
        }
    }

    public void setStructMsgItemLists(List<AbsStructMsgElement> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
        } else {
            this.mStructMsgItemLists = list;
        }
    }

    protected abstract void toContentXml(AbsStructMsg.a aVar) throws IOException;

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    protected void toXml(ByteArrayOutputStream byteArrayOutputStream, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) byteArrayOutputStream, (Object) str);
            return;
        }
        AbsStructMsg.a aVar = new AbsStructMsg.a(new e());
        try {
            aVar.setOutput(byteArrayOutputStream, str);
            aVar.startDocument(str, Boolean.TRUE);
            aVar.startTag(null, "msg");
            aVar.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
            aVar.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
            String str2 = this.mMsgAction;
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            aVar.attribute(null, "action", str2);
            if (!TextUtils.isEmpty(this.mMsgActionData)) {
                aVar.attribute(null, PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, this.mMsgActionData);
            }
            if (!TextUtils.isEmpty(this.mMsg_A_ActionData)) {
                aVar.attribute(null, PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA, this.mMsg_A_ActionData);
            }
            if (!TextUtils.isEmpty(this.mMsg_I_ActionData)) {
                aVar.attribute(null, PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA, this.mMsg_I_ActionData);
            }
            String str4 = this.mMsgBrief;
            if (str4 == null) {
                str4 = "";
            }
            aVar.attribute(null, "brief", str4);
            if (!TextUtils.isEmpty(this.mResid)) {
                aVar.attribute(null, "m_resid", this.mResid);
            }
            if (!TextUtils.isEmpty(this.mFileName)) {
                aVar.attribute(null, "m_fileName", this.mFileName);
            }
            int i3 = this.mTSum;
            if (i3 > 0) {
                aVar.attribute(null, "tSum", String.valueOf(i3));
            }
            long j3 = this.mFileSize;
            if (j3 > 0) {
                aVar.attribute(null, "m_fileSize", String.valueOf(j3));
            }
            if (!TextUtils.isEmpty(this.source_puin)) {
                aVar.attribute(null, "sourcePublicUin", this.source_puin);
            }
            aVar.attribute(null, "sourceMsgId", String.valueOf(this.msgId));
            int i16 = this.fwFlag;
            boolean z16 = true;
            if (i16 == 1) {
                aVar.attribute(null, "fwflag", String.valueOf(i16));
            }
            String str5 = this.mMsgUrl;
            if (str5 == null) {
                str5 = "";
            }
            aVar.attribute(null, "url", str5);
            if (!TextUtils.isEmpty(this.rijAlbumActionData)) {
                aVar.attribute(null, "rijAlbumActionData", this.rijAlbumActionData);
            }
            aVar.attribute(null, "flag", String.valueOf(this.mFlag));
            if (!TextUtils.isEmpty(this.mSType)) {
                aVar.attribute(null, "sType", this.mSType);
            }
            int i17 = this.sourceAccoutType;
            int i18 = AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA;
            if (i17 == i18) {
                aVar.attribute(null, "accostType", String.valueOf(i18));
            }
            String valueOf = String.valueOf(this.adverSign);
            if (!TextUtils.isEmpty(valueOf)) {
                aVar.attribute(null, "adverSign", valueOf);
            }
            if (!TextUtils.isEmpty(this.adverKey)) {
                aVar.attribute(null, "adverKey", this.adverKey);
            }
            if (!TextUtils.isEmpty(this.mExtraData)) {
                aVar.attribute(null, WadlProxyConsts.EXTRA_DATA, this.mExtraData);
            }
            if (!TextUtils.isEmpty(this.mCreateTime)) {
                aVar.attribute(null, WadlProxyConsts.CREATE_TIME, this.mCreateTime);
            }
            if (!TextUtils.isEmpty(this.mTagName)) {
                aVar.attribute(null, "tagName", this.mTagName);
            }
            if (!TextUtils.isEmpty(this.mSourceThirdName)) {
                aVar.attribute(null, RealNameSource.EXTRA_KEY_SOURCE_NAME, this.mSourceThirdName);
            }
            if (!TextUtils.isEmpty(this.mQQStoryExtra)) {
                aVar.attribute(null, "qqstoryExtra", this.mQQStoryExtra);
            }
            if (!TextUtils.isEmpty(this.mTribeShortVideoExtra)) {
                aVar.attribute(null, "qqtribeVideoInfoExtra", this.mTribeShortVideoExtra);
            }
            if (!TextUtils.isEmpty(this.mNeedRound)) {
                aVar.attribute(null, "needRoundView", this.mNeedRound);
            }
            if (!TextUtils.isEmpty(this.mCommonData)) {
                aVar.attribute(null, "msgCommonData", this.mCommonData);
            }
            aVar.attribute(null, "multiMsgFlag", String.valueOf(this.multiMsgFlag));
            if (!TextUtils.isEmpty(this.mQzoneExtraMsg)) {
                aVar.attribute(null, "qzFloatExtra", this.mQzoneExtraMsg);
            }
            if (!TextUtils.isEmpty(this.mBirthReminder)) {
                aVar.attribute(null, "birthReminderMsg", this.mBirthReminder);
            }
            toContentXml(aVar);
            if (this.mMsgServiceID != 128) {
                z16 = false;
            }
            if (!z16) {
                aVar.startTag(null, "source");
                String str6 = this.mSourceName;
                if (str6 == null) {
                    str6 = "";
                }
                aVar.attribute(null, "name", str6);
                String str7 = this.mSourceIcon;
                if (str7 == null) {
                    str7 = "";
                }
                aVar.attribute(null, "icon", str7);
                if (!TextUtils.isEmpty(this.mSourceUrl)) {
                    aVar.attribute(null, "url", this.mSourceUrl);
                }
                String str8 = this.mSourceAction;
                if (str8 != null) {
                    str3 = str8;
                }
                aVar.attribute(null, "action", str3);
                if (!TextUtils.isEmpty(this.mSourceActionData)) {
                    aVar.attribute(null, PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, this.mSourceActionData);
                }
                if (!TextUtils.isEmpty(this.mSource_A_ActionData)) {
                    aVar.attribute(null, PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA, this.mSource_A_ActionData);
                }
                if (!TextUtils.isEmpty(this.mSource_I_ActionData)) {
                    aVar.attribute(null, PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA, this.mSource_I_ActionData);
                }
                aVar.attribute(null, "appid", String.valueOf(this.mSourceAppid));
                aVar.endTag(null, "source");
            }
            aVar.endTag(null, "msg");
            aVar.endDocument();
            aVar.flush();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, e16.getMessage(), e16);
            }
        }
    }

    public void updateCover(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.mContentCover = str;
        }
    }

    public void updateTitleSummaryAndCover(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, str2, str3);
            return;
        }
        this.mContentTitle = str;
        this.mContentSummary = str2;
        this.mContentCover = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsShareMsg(Bundle bundle) {
        super(bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        this.mStructMsgItemLists = new ArrayList();
        this.mContentLayout = -1;
        this.mContentCover = null;
        this.mContentSrc = null;
        this.mContentTitle = null;
        this.mContentSummary = null;
        this.mSourceUrl = null;
        this.mSourceAction = null;
        this.mSourceActionData = null;
        this.mSource_A_ActionData = null;
        this.mSource_I_ActionData = null;
        this.mSourceIcon = null;
        this.mSourceName = null;
        this.mSourceAppid = -1L;
        this.mMsgException = false;
        this.mAdSourceIcon = null;
        this.mAdSourceName = null;
        this.shareData = new ShareData();
        this.mDatas = null;
        this.mAdSourceMenu = null;
        this.mSourceOnClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.structmsg.AbsShareMsg.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private long f290285d;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsShareMsg.this);
                } else {
                    this.f290285d = 0L;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:119:0x03fb  */
            /* JADX WARN: Removed duplicated region for block: B:164:0x028b A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x03b5  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x03ee  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0403  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x04da  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                AbsShareMsg absShareMsg;
                String str;
                String str2;
                AbsShareMsg absShareMsg2;
                QQAppInterface qQAppInterface;
                String str3;
                ax c16;
                String f16;
                String f17;
                int i3;
                int i16;
                String str4;
                String str5;
                String str6;
                String str7;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else if (SystemClock.uptimeMillis() - this.f290285d >= 1000) {
                    this.f290285d = SystemClock.uptimeMillis();
                    Object tag = view.getTag();
                    if (tag != null && AbsShareMsg.class.isInstance(tag)) {
                        AbsShareMsg absShareMsg3 = (AbsShareMsg) tag;
                        Context context = view.getContext();
                        if (SplashActivity.class.isInstance(context) || ChatActivity.class.isInstance(context)) {
                            if (context == null) {
                                QLog.e("StructMsg", 1, "context is null, never do click, return");
                            } else {
                                ChatFragment chatFragment = ((BaseActivity) context).getChatFragment();
                                if (chatFragment == null) {
                                    QLog.e("StructMsg", 1, "context.getChatFragment is null, never do click, return");
                                } else {
                                    QQAppInterface ph5 = chatFragment.ph();
                                    if (ph5 != null) {
                                        String str8 = AbsShareMsg.this.mSourceActionData;
                                        if (str8 != null && str8.startsWith("mqqapi://qsubscribe")) {
                                            QLog.i("StructMsg", 2, "scheme jump to subscribe hybird");
                                            try {
                                                Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                                                intent.setData(Uri.parse(AbsShareMsg.this.mSourceActionData));
                                                intent.putExtra("from", "from_aio");
                                                context.startActivity(intent);
                                            } catch (Exception e16) {
                                                e16.printStackTrace();
                                            }
                                        } else {
                                            String str9 = AbsShareMsg.this.mSourceAction;
                                            if (str9.equals("web") && AbsShareMsg.this.mSourceUrl.contains("webcard.mp.qq.com")) {
                                                AbsShareMsg absShareMsg4 = AbsShareMsg.this;
                                                absShareMsg4.mSourceAction = "plugin";
                                                absShareMsg4.mSource_A_ActionData = String.format(IPublicAccountBrowser.SCHEME_ANDROID_PUBLIC_ACCOUNT_DETAIL, absShareMsg4.source_puin);
                                                str9 = "plugin";
                                            }
                                            if (QLog.isColorLevel()) {
                                                QLog.d("StructMsg", 2, "mSourceOnClickListener sourceAction = " + str9);
                                            }
                                            if ("app".equals(str9)) {
                                                String str10 = AbsShareMsg.this.mMsgActionData;
                                                if (str10 != null && (str10.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID) || AbsShareMsg.this.mMsg_A_ActionData.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID))) {
                                                    AbsShareMsg.this.m(context);
                                                }
                                                ReportCenter.f().p(ph5.getAccount(), "", String.valueOf(AbsShareMsg.this.mSourceAppid), "1000", "80", "0", false);
                                            } else {
                                                if ("web".equals(str9)) {
                                                    AbsShareMsg absShareMsg5 = AbsShareMsg.this;
                                                    String str11 = absShareMsg5.mSourceUrl;
                                                    int i17 = absShareMsg5.mMsgServiceID;
                                                    if (i17 == 114) {
                                                        str11 = ((MedalWallMng) ph5.getManager(QQManagerFactory.MEDAL_WALL_MNG)).i(true, ph5.getCurrentAccountUin(), MedalWallMng.Q);
                                                    } else if (absShareMsg3.uinType == 1 && (i17 == 116 || i17 == 123)) {
                                                        str11 = String.format("%s&gc=%s", str11, com.tencent.mobileqq.nearby.k.b(absShareMsg3.uin));
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess groupUin:" + absShareMsg3.uin);
                                                        }
                                                    }
                                                    if (!TextUtils.isEmpty(str11) && str11.equals("mqqapi://readinjoy/open?src_type=internal&version=1&target=1")) {
                                                        ax c17 = bi.c(ph5, context, str11);
                                                        if (c17 != null) {
                                                            c17.b();
                                                        } else {
                                                            context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(str11)));
                                                        }
                                                        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str11, "", "", "");
                                                    }
                                                    str2 = ColorRingJsPlugin.Method_SetUp;
                                                } else if ("plugin".equals(str9)) {
                                                    if (absShareMsg3.uinType == 1) {
                                                        AbsShareMsg absShareMsg6 = AbsShareMsg.this;
                                                        if (absShareMsg6.mMsgServiceID == 123) {
                                                            absShareMsg6.mSourceActionData = com.tencent.mobileqq.confess.g.i(absShareMsg6.mSourceActionData, absShareMsg3.uin);
                                                            boolean f18 = com.tencent.mobileqq.confess.g.f(ph5, absShareMsg3.uin, false);
                                                            String str12 = AbsShareMsg.this.mMsgUrl;
                                                            if (f18 && !TextUtils.isEmpty(str12) && (context instanceof BaseActivity)) {
                                                                QLog.w("StructMsg", 1, "GeneralClickHandler clickWebMsg source confess url:" + str12);
                                                            }
                                                            if (!f18) {
                                                                QQToast.makeText(BaseApplication.getContext(), com.tencent.mobileqq.confess.g.f202191a, 0).show();
                                                            }
                                                            if (QLog.isColorLevel()) {
                                                                QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess url:" + AbsShareMsg.this.mSourceActionData);
                                                            }
                                                            absShareMsg = AbsShareMsg.this;
                                                            if (absShareMsg.mSourceName.equals(absShareMsg.readInjoy)) {
                                                                try {
                                                                    str = Uri.parse(AbsShareMsg.this.mMsgUrl).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                                                                } catch (Exception e17) {
                                                                    e17.printStackTrace();
                                                                    str = null;
                                                                }
                                                                if (!TextUtils.isEmpty(str)) {
                                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, str, AbsShareMsg.this.mMsgUrl, "", "", false);
                                                                } else {
                                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, "", AbsShareMsg.this.mMsgUrl, "", "", false);
                                                                }
                                                            }
                                                            str2 = "plugin";
                                                        }
                                                    }
                                                    absShareMsg = AbsShareMsg.this;
                                                    if (absShareMsg.mSourceName.equals(absShareMsg.readInjoy)) {
                                                    }
                                                    str2 = "plugin";
                                                }
                                                AbsShareMsg absShareMsg72 = AbsShareMsg.this;
                                                com.tencent.biz.common.util.k.i(ph5, absShareMsg72.uin, "sourceclick", absShareMsg72.mSourceAppid, absShareMsg72.mMsgServiceID, str2);
                                                ReportController.o(ph5, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                                ReportController.o(ph5, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                                ReportController.o(ph5, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", AbsShareMsg.this.mSourceName, "");
                                                absShareMsg2 = AbsShareMsg.this;
                                                if (absShareMsg2.adverSign == 1) {
                                                    ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absShareMsg2.uin, "0X800631F", "0X800631F", 0, 0, "" + AbsShareMsg.this.msgId, "", "", "");
                                                }
                                                if (AbsShareMsg.this.mMsgServiceID != 114) {
                                                    qQAppInterface = ph5;
                                                    str3 = null;
                                                    ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.structmsg.AbsShareMsg.1.1
                                                        static IPatchRedirector $redirector_;

                                                        /* renamed from: d, reason: collision with root package name */
                                                        final /* synthetic */ QQAppInterface f290287d;

                                                        {
                                                            this.f290287d = qQAppInterface;
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) qQAppInterface);
                                                            }
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                                            } else {
                                                                ((MedalWallMng) this.f290287d.getManager(QQManagerFactory.MEDAL_WALL_MNG)).u(2, null);
                                                            }
                                                        }
                                                    }, 0, null, false);
                                                } else {
                                                    qQAppInterface = ph5;
                                                    str3 = null;
                                                }
                                                if (absShareMsg3 instanceof StructMsgForGeneralShare) {
                                                    StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absShareMsg3;
                                                    if (structMsgForGeneralShare.mIsPAVideoStructMsg) {
                                                        Iterator<AbsStructMsgElement> it = structMsgForGeneralShare.iterator();
                                                        while (it.hasNext()) {
                                                            AbsStructMsgElement next = it.next();
                                                            if (next instanceof y) {
                                                                Iterator<AbsStructMsgElement> it5 = ((y) next).U0.iterator();
                                                                while (it5.hasNext()) {
                                                                    AbsStructMsgElement next2 = it5.next();
                                                                    if (next2 instanceof StructMsgItemVideo) {
                                                                        StructMsgItemVideo structMsgItemVideo = (StructMsgItemVideo) next2;
                                                                        if (structMsgItemVideo.v()) {
                                                                            String a16 = ((IVideoR5BuilderFactory) QRoute.api(IVideoR5BuilderFactory.class)).create(str3, structMsgForGeneralShare.source_puin, structMsgItemVideo.W0, structMsgItemVideo.f290492g1).put("aio_app_id", Long.valueOf(structMsgForGeneralShare.mSourceAppid)).a();
                                                                            int i18 = structMsgForGeneralShare.uinType;
                                                                            if (i18 == 1008) {
                                                                                str6 = "1";
                                                                            } else if (i18 == 0) {
                                                                                str6 = "2";
                                                                            } else if (i18 == 1) {
                                                                                str6 = "3";
                                                                            } else if (i18 == 3000) {
                                                                                str6 = "4";
                                                                            } else {
                                                                                str5 = "";
                                                                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, str5, Integer.toString(((IVideoReporter) QRoute.api(IVideoReporter.class)).getReportVideoType(structMsgItemVideo.f290495j1, structMsgForGeneralShare.mSourceName)), "", a16, false);
                                                                                IPublicAccountReportUtils iPublicAccountReportUtils2 = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                                                                String str132 = structMsgForGeneralShare.source_puin;
                                                                                str7 = structMsgItemVideo.f290492g1;
                                                                                if (str7 == null) {
                                                                                    str7 = "0";
                                                                                }
                                                                                str4 = str3;
                                                                                iPublicAccountReportUtils2.publicAccountReportClickEvent(qQAppInterface, str132, "0x8007410", "0x8007410", 0, 0, "1", "", str7, a16, false);
                                                                                str3 = str4;
                                                                            }
                                                                            str5 = str6;
                                                                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, str5, Integer.toString(((IVideoReporter) QRoute.api(IVideoReporter.class)).getReportVideoType(structMsgItemVideo.f290495j1, structMsgForGeneralShare.mSourceName)), "", a16, false);
                                                                            IPublicAccountReportUtils iPublicAccountReportUtils22 = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                                                            String str1322 = structMsgForGeneralShare.source_puin;
                                                                            str7 = structMsgItemVideo.f290492g1;
                                                                            if (str7 == null) {
                                                                            }
                                                                            str4 = str3;
                                                                            iPublicAccountReportUtils22.publicAccountReportClickEvent(qQAppInterface, str1322, "0x8007410", "0x8007410", 0, 0, "1", "", str7, a16, false);
                                                                            str3 = str4;
                                                                        }
                                                                    }
                                                                    str4 = str3;
                                                                    str3 = str4;
                                                                }
                                                            }
                                                            str3 = str3;
                                                        }
                                                    }
                                                }
                                                if (absShareMsg3.mMsgServiceID == 81 && !TextUtils.isEmpty(absShareMsg3.mMsg_A_ActionData) && (c16 = bi.c(qQAppInterface, context, absShareMsg3.mMsg_A_ActionData)) != null) {
                                                    f16 = c16.f("usertype");
                                                    f17 = c16.f("unionid");
                                                    if (!TextUtils.isEmpty(f16) && !TextUtils.isEmpty(f17)) {
                                                        try {
                                                            i16 = Integer.parseInt(f16);
                                                            i3 = 1;
                                                        } catch (NumberFormatException unused) {
                                                            i3 = 1;
                                                            i16 = 0;
                                                        }
                                                        String[] strArr2 = new String[i3];
                                                        strArr2[0] = f17;
                                                        id0.a.n("share_uin_obj", "clk_tail", 0, i16, strArr2);
                                                    }
                                                }
                                            }
                                            str2 = "";
                                            AbsShareMsg absShareMsg722 = AbsShareMsg.this;
                                            com.tencent.biz.common.util.k.i(ph5, absShareMsg722.uin, "sourceclick", absShareMsg722.mSourceAppid, absShareMsg722.mMsgServiceID, str2);
                                            ReportController.o(ph5, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                            ReportController.o(ph5, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                            ReportController.o(ph5, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", AbsShareMsg.this.mSourceName, "");
                                            absShareMsg2 = AbsShareMsg.this;
                                            if (absShareMsg2.adverSign == 1) {
                                            }
                                            if (AbsShareMsg.this.mMsgServiceID != 114) {
                                            }
                                            if (absShareMsg3 instanceof StructMsgForGeneralShare) {
                                            }
                                            if (absShareMsg3.mMsgServiceID == 81) {
                                                f16 = c16.f("usertype");
                                                f17 = c16.f("unionid");
                                                if (!TextUtils.isEmpty(f16)) {
                                                    i16 = Integer.parseInt(f16);
                                                    i3 = 1;
                                                    String[] strArr22 = new String[i3];
                                                    strArr22[0] = f17;
                                                    id0.a.n("share_uin_obj", "clk_tail", 0, i16, strArr22);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mVersion = 29;
        String string = bundle.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        this.mContentCover = string;
        if (string != null) {
            this.shareData.imageUrlStatus = bundle.getByte(AppConstants.Key.STRUCT_SHARE_KEY_IMG_URL_STATUS, (byte) 4).byteValue();
        } else {
            this.mContentCover = bundle.getString("image_url");
            this.shareData.imageUrlStatus = (byte) 2;
        }
        this.mContentTitle = bundle.getString("title");
        this.mContentSummary = bundle.getString("desc");
        String str = this.mContentTitle;
        if (str != null) {
            this.mContentTitle = s.c(str, false);
        }
        String str2 = this.mContentSummary;
        if (str2 != null) {
            this.mContentSummary = s.c(str2, false);
        }
        this.mMsgAction = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION);
        this.mMsgActionData = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION_DATA);
        this.mMsg_A_ActionData = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_A_ACTION_DATA);
        this.mMsg_I_ActionData = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_I_ACTION_DATA);
        this.mSourceAppid = bundle.getLong("req_share_id", -1L);
        this.mSourceUrl = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL);
        String string2 = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION);
        this.mSourceAction = string2;
        if (TextUtils.isEmpty(string2)) {
            this.mSourceAction = "app";
        }
        this.mSourceActionData = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA);
        this.mSource_A_ActionData = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA);
        String string3 = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_I_ACTION_DATA);
        this.mSource_I_ActionData = string3;
        if (TextUtils.isEmpty(string3) && this.mSourceAppid > 0 && !"plugin".equals(this.mSourceAction)) {
            this.mSource_I_ActionData = String.format("tencent%d://", Long.valueOf(this.mSourceAppid));
        }
        this.mSourceIcon = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON);
        this.mSourceName = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME);
        int i3 = bundle.getInt("forward_type");
        this.forwardType = i3;
        if (i3 != 11 && TextUtils.isEmpty(this.mSourceName)) {
            this.mSourceName = bundle.getString("app_name");
        }
        String string4 = bundle.getString(AppConstants.Key.SHARE_BRIEF);
        this.mMsgBrief = string4;
        if (TextUtils.isEmpty(string4)) {
            if (TextUtils.isEmpty(this.mSourceName)) {
                this.mMsgBrief = AbsStructMsg.DEFAULT_MSG_BRIEF;
            } else {
                this.mMsgBrief = String.format(g.f290421n4, this.mSourceName);
            }
        }
        this.mResid = bundle.getString(AppConstants.Key.SHARE_MM_RESID);
        this.mFileName = bundle.getString(AppConstants.Key.SHARE_MM_FILE_NAME);
        this.mFileSize = bundle.getLong(AppConstants.Key.SHARE_MM_FILE_SIZE);
        this.mCompatibleText = bundle.getString(AppConstants.Key.KEY_STRUCT_MSG_COMPATIBLE_TEXT);
        this.fwFlag = bundle.getInt(AppConstants.Key.SHARE_FLAG, 0);
        if (!this.mHasSource && (!TextUtils.isEmpty(this.mSourceName) || !TextUtils.isEmpty(this.mSourceIcon))) {
            this.mHasSource = true;
        }
        if (TextUtils.isEmpty(this.mContentTitle) && TextUtils.isEmpty(this.mContentSummary)) {
            if (TextUtils.isEmpty(this.mSourceName)) {
                this.mContentTitle = g.f290420m4;
            } else {
                this.mContentTitle = String.format(g.f290419l4, this.mSourceName);
            }
        }
        this.mNeedRound = bundle.getString(AppConstants.Key.KEY_ICON_NEED_ROUND);
        this.mFlag = bundle.getInt("flag");
        this.shareData.appInfoStatus = bundle.getByte(AppConstants.Key.STRUCT_SHARE_KEY_APPINFO_STATUS, (byte) 0).byteValue();
        this.shareData.sourceIconBig = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON_BIG);
        this.shareData.pkgName = bundle.getString("pkg_name");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("msgUrl = " + this.mMsgUrl);
            sb5.append(", mVersion = " + this.mVersion);
            sb5.append(", mContentCover = ");
            sb5.append(this.mContentCover);
            sb5.append(", mContentTitle = ");
            sb5.append(this.mContentTitle);
            sb5.append(", mContentSummary = ");
            sb5.append(this.mContentSummary);
            sb5.append(", mMsgAction = ");
            sb5.append(this.mMsgAction);
            sb5.append(", mMsgActionData = ");
            sb5.append(this.mMsgActionData);
            sb5.append(", mMsg_A_ActionData = ");
            sb5.append(this.mMsg_A_ActionData);
            sb5.append(", mMsg_I_ActionData = ");
            sb5.append(this.mMsg_I_ActionData);
            sb5.append(", mSourceAppid = ");
            sb5.append(this.mSourceAppid);
            sb5.append(", mSourceUrl = ");
            sb5.append(this.mSourceUrl);
            sb5.append(", mSourceAction = ");
            sb5.append(this.mSourceAction);
            sb5.append(", mSourceActionData = ");
            sb5.append(this.mSourceActionData);
            sb5.append(", mSource_A_ActionData = ");
            sb5.append(this.mSource_A_ActionData);
            sb5.append(", mSource_I_ActionData = ");
            sb5.append(this.mSource_I_ActionData);
            sb5.append(", mSourceIcon = ");
            sb5.append(this.mSourceIcon);
            sb5.append(", mSourceName = ");
            sb5.append(this.mSourceName);
            sb5.append(", mMsgBrief = ");
            sb5.append(this.mMsgBrief);
            sb5.append(", mResid = ");
            sb5.append(this.mResid);
            sb5.append(", mFileName = ");
            sb5.append(this.mFileName);
            sb5.append(", mFileSize = ");
            sb5.append(this.mFileSize);
            sb5.append(", mCompatibleText = ");
            sb5.append(this.mCompatibleText);
            sb5.append(", fwFlag = ");
            sb5.append(this.fwFlag);
            sb5.append(", mHasSource = ");
            sb5.append(this.mHasSource);
            sb5.append(", mSType = ");
            sb5.append(this.mSType);
            QLog.d("StructMsg", 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsShareMsg(j jVar) {
        super(jVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar);
            return;
        }
        this.mStructMsgItemLists = new ArrayList();
        this.mContentLayout = -1;
        this.mContentCover = null;
        this.mContentSrc = null;
        this.mContentTitle = null;
        this.mContentSummary = null;
        this.mSourceUrl = null;
        this.mSourceAction = null;
        this.mSourceActionData = null;
        this.mSource_A_ActionData = null;
        this.mSource_I_ActionData = null;
        this.mSourceIcon = null;
        this.mSourceName = null;
        this.mSourceAppid = -1L;
        this.mMsgException = false;
        this.mAdSourceIcon = null;
        this.mAdSourceName = null;
        this.shareData = new ShareData();
        this.mDatas = null;
        this.mAdSourceMenu = null;
        this.mSourceOnClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.structmsg.AbsShareMsg.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private long f290285d;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsShareMsg.this);
                } else {
                    this.f290285d = 0L;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:119:0x03fb  */
            /* JADX WARN: Removed duplicated region for block: B:164:0x028b A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x03b5  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x03ee  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0403  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x04da  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                AbsShareMsg absShareMsg;
                String str;
                String str2;
                AbsShareMsg absShareMsg2;
                QQAppInterface qQAppInterface;
                String str3;
                ax c16;
                String f16;
                String f17;
                int i3;
                int i16;
                String str4;
                String str5;
                String str6;
                String str7;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else if (SystemClock.uptimeMillis() - this.f290285d >= 1000) {
                    this.f290285d = SystemClock.uptimeMillis();
                    Object tag = view.getTag();
                    if (tag != null && AbsShareMsg.class.isInstance(tag)) {
                        AbsShareMsg absShareMsg3 = (AbsShareMsg) tag;
                        Context context = view.getContext();
                        if (SplashActivity.class.isInstance(context) || ChatActivity.class.isInstance(context)) {
                            if (context == null) {
                                QLog.e("StructMsg", 1, "context is null, never do click, return");
                            } else {
                                ChatFragment chatFragment = ((BaseActivity) context).getChatFragment();
                                if (chatFragment == null) {
                                    QLog.e("StructMsg", 1, "context.getChatFragment is null, never do click, return");
                                } else {
                                    QQAppInterface ph5 = chatFragment.ph();
                                    if (ph5 != null) {
                                        String str8 = AbsShareMsg.this.mSourceActionData;
                                        if (str8 != null && str8.startsWith("mqqapi://qsubscribe")) {
                                            QLog.i("StructMsg", 2, "scheme jump to subscribe hybird");
                                            try {
                                                Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                                                intent.setData(Uri.parse(AbsShareMsg.this.mSourceActionData));
                                                intent.putExtra("from", "from_aio");
                                                context.startActivity(intent);
                                            } catch (Exception e16) {
                                                e16.printStackTrace();
                                            }
                                        } else {
                                            String str9 = AbsShareMsg.this.mSourceAction;
                                            if (str9.equals("web") && AbsShareMsg.this.mSourceUrl.contains("webcard.mp.qq.com")) {
                                                AbsShareMsg absShareMsg4 = AbsShareMsg.this;
                                                absShareMsg4.mSourceAction = "plugin";
                                                absShareMsg4.mSource_A_ActionData = String.format(IPublicAccountBrowser.SCHEME_ANDROID_PUBLIC_ACCOUNT_DETAIL, absShareMsg4.source_puin);
                                                str9 = "plugin";
                                            }
                                            if (QLog.isColorLevel()) {
                                                QLog.d("StructMsg", 2, "mSourceOnClickListener sourceAction = " + str9);
                                            }
                                            if ("app".equals(str9)) {
                                                String str10 = AbsShareMsg.this.mMsgActionData;
                                                if (str10 != null && (str10.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID) || AbsShareMsg.this.mMsg_A_ActionData.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID))) {
                                                    AbsShareMsg.this.m(context);
                                                }
                                                ReportCenter.f().p(ph5.getAccount(), "", String.valueOf(AbsShareMsg.this.mSourceAppid), "1000", "80", "0", false);
                                            } else {
                                                if ("web".equals(str9)) {
                                                    AbsShareMsg absShareMsg5 = AbsShareMsg.this;
                                                    String str11 = absShareMsg5.mSourceUrl;
                                                    int i17 = absShareMsg5.mMsgServiceID;
                                                    if (i17 == 114) {
                                                        str11 = ((MedalWallMng) ph5.getManager(QQManagerFactory.MEDAL_WALL_MNG)).i(true, ph5.getCurrentAccountUin(), MedalWallMng.Q);
                                                    } else if (absShareMsg3.uinType == 1 && (i17 == 116 || i17 == 123)) {
                                                        str11 = String.format("%s&gc=%s", str11, com.tencent.mobileqq.nearby.k.b(absShareMsg3.uin));
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess groupUin:" + absShareMsg3.uin);
                                                        }
                                                    }
                                                    if (!TextUtils.isEmpty(str11) && str11.equals("mqqapi://readinjoy/open?src_type=internal&version=1&target=1")) {
                                                        ax c17 = bi.c(ph5, context, str11);
                                                        if (c17 != null) {
                                                            c17.b();
                                                        } else {
                                                            context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(str11)));
                                                        }
                                                        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str11, "", "", "");
                                                    }
                                                    str2 = ColorRingJsPlugin.Method_SetUp;
                                                } else if ("plugin".equals(str9)) {
                                                    if (absShareMsg3.uinType == 1) {
                                                        AbsShareMsg absShareMsg6 = AbsShareMsg.this;
                                                        if (absShareMsg6.mMsgServiceID == 123) {
                                                            absShareMsg6.mSourceActionData = com.tencent.mobileqq.confess.g.i(absShareMsg6.mSourceActionData, absShareMsg3.uin);
                                                            boolean f18 = com.tencent.mobileqq.confess.g.f(ph5, absShareMsg3.uin, false);
                                                            String str12 = AbsShareMsg.this.mMsgUrl;
                                                            if (f18 && !TextUtils.isEmpty(str12) && (context instanceof BaseActivity)) {
                                                                QLog.w("StructMsg", 1, "GeneralClickHandler clickWebMsg source confess url:" + str12);
                                                            }
                                                            if (!f18) {
                                                                QQToast.makeText(BaseApplication.getContext(), com.tencent.mobileqq.confess.g.f202191a, 0).show();
                                                            }
                                                            if (QLog.isColorLevel()) {
                                                                QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess url:" + AbsShareMsg.this.mSourceActionData);
                                                            }
                                                            absShareMsg = AbsShareMsg.this;
                                                            if (absShareMsg.mSourceName.equals(absShareMsg.readInjoy)) {
                                                                try {
                                                                    str = Uri.parse(AbsShareMsg.this.mMsgUrl).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                                                                } catch (Exception e17) {
                                                                    e17.printStackTrace();
                                                                    str = null;
                                                                }
                                                                if (!TextUtils.isEmpty(str)) {
                                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, str, AbsShareMsg.this.mMsgUrl, "", "", false);
                                                                } else {
                                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, "", AbsShareMsg.this.mMsgUrl, "", "", false);
                                                                }
                                                            }
                                                            str2 = "plugin";
                                                        }
                                                    }
                                                    absShareMsg = AbsShareMsg.this;
                                                    if (absShareMsg.mSourceName.equals(absShareMsg.readInjoy)) {
                                                    }
                                                    str2 = "plugin";
                                                }
                                                AbsShareMsg absShareMsg722 = AbsShareMsg.this;
                                                com.tencent.biz.common.util.k.i(ph5, absShareMsg722.uin, "sourceclick", absShareMsg722.mSourceAppid, absShareMsg722.mMsgServiceID, str2);
                                                ReportController.o(ph5, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                                ReportController.o(ph5, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                                ReportController.o(ph5, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", AbsShareMsg.this.mSourceName, "");
                                                absShareMsg2 = AbsShareMsg.this;
                                                if (absShareMsg2.adverSign == 1) {
                                                    ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absShareMsg2.uin, "0X800631F", "0X800631F", 0, 0, "" + AbsShareMsg.this.msgId, "", "", "");
                                                }
                                                if (AbsShareMsg.this.mMsgServiceID != 114) {
                                                    qQAppInterface = ph5;
                                                    str3 = null;
                                                    ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.structmsg.AbsShareMsg.1.1
                                                        static IPatchRedirector $redirector_;

                                                        /* renamed from: d, reason: collision with root package name */
                                                        final /* synthetic */ QQAppInterface f290287d;

                                                        {
                                                            this.f290287d = qQAppInterface;
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) qQAppInterface);
                                                            }
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                                            } else {
                                                                ((MedalWallMng) this.f290287d.getManager(QQManagerFactory.MEDAL_WALL_MNG)).u(2, null);
                                                            }
                                                        }
                                                    }, 0, null, false);
                                                } else {
                                                    qQAppInterface = ph5;
                                                    str3 = null;
                                                }
                                                if (absShareMsg3 instanceof StructMsgForGeneralShare) {
                                                    StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absShareMsg3;
                                                    if (structMsgForGeneralShare.mIsPAVideoStructMsg) {
                                                        Iterator<AbsStructMsgElement> it = structMsgForGeneralShare.iterator();
                                                        while (it.hasNext()) {
                                                            AbsStructMsgElement next = it.next();
                                                            if (next instanceof y) {
                                                                Iterator<AbsStructMsgElement> it5 = ((y) next).U0.iterator();
                                                                while (it5.hasNext()) {
                                                                    AbsStructMsgElement next2 = it5.next();
                                                                    if (next2 instanceof StructMsgItemVideo) {
                                                                        StructMsgItemVideo structMsgItemVideo = (StructMsgItemVideo) next2;
                                                                        if (structMsgItemVideo.v()) {
                                                                            String a16 = ((IVideoR5BuilderFactory) QRoute.api(IVideoR5BuilderFactory.class)).create(str3, structMsgForGeneralShare.source_puin, structMsgItemVideo.W0, structMsgItemVideo.f290492g1).put("aio_app_id", Long.valueOf(structMsgForGeneralShare.mSourceAppid)).a();
                                                                            int i18 = structMsgForGeneralShare.uinType;
                                                                            if (i18 == 1008) {
                                                                                str6 = "1";
                                                                            } else if (i18 == 0) {
                                                                                str6 = "2";
                                                                            } else if (i18 == 1) {
                                                                                str6 = "3";
                                                                            } else if (i18 == 3000) {
                                                                                str6 = "4";
                                                                            } else {
                                                                                str5 = "";
                                                                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, str5, Integer.toString(((IVideoReporter) QRoute.api(IVideoReporter.class)).getReportVideoType(structMsgItemVideo.f290495j1, structMsgForGeneralShare.mSourceName)), "", a16, false);
                                                                                IPublicAccountReportUtils iPublicAccountReportUtils22 = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                                                                String str1322 = structMsgForGeneralShare.source_puin;
                                                                                str7 = structMsgItemVideo.f290492g1;
                                                                                if (str7 == null) {
                                                                                    str7 = "0";
                                                                                }
                                                                                str4 = str3;
                                                                                iPublicAccountReportUtils22.publicAccountReportClickEvent(qQAppInterface, str1322, "0x8007410", "0x8007410", 0, 0, "1", "", str7, a16, false);
                                                                                str3 = str4;
                                                                            }
                                                                            str5 = str6;
                                                                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, str5, Integer.toString(((IVideoReporter) QRoute.api(IVideoReporter.class)).getReportVideoType(structMsgItemVideo.f290495j1, structMsgForGeneralShare.mSourceName)), "", a16, false);
                                                                            IPublicAccountReportUtils iPublicAccountReportUtils222 = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                                                            String str13222 = structMsgForGeneralShare.source_puin;
                                                                            str7 = structMsgItemVideo.f290492g1;
                                                                            if (str7 == null) {
                                                                            }
                                                                            str4 = str3;
                                                                            iPublicAccountReportUtils222.publicAccountReportClickEvent(qQAppInterface, str13222, "0x8007410", "0x8007410", 0, 0, "1", "", str7, a16, false);
                                                                            str3 = str4;
                                                                        }
                                                                    }
                                                                    str4 = str3;
                                                                    str3 = str4;
                                                                }
                                                            }
                                                            str3 = str3;
                                                        }
                                                    }
                                                }
                                                if (absShareMsg3.mMsgServiceID == 81 && !TextUtils.isEmpty(absShareMsg3.mMsg_A_ActionData) && (c16 = bi.c(qQAppInterface, context, absShareMsg3.mMsg_A_ActionData)) != null) {
                                                    f16 = c16.f("usertype");
                                                    f17 = c16.f("unionid");
                                                    if (!TextUtils.isEmpty(f16) && !TextUtils.isEmpty(f17)) {
                                                        try {
                                                            i16 = Integer.parseInt(f16);
                                                            i3 = 1;
                                                        } catch (NumberFormatException unused) {
                                                            i3 = 1;
                                                            i16 = 0;
                                                        }
                                                        String[] strArr22 = new String[i3];
                                                        strArr22[0] = f17;
                                                        id0.a.n("share_uin_obj", "clk_tail", 0, i16, strArr22);
                                                    }
                                                }
                                            }
                                            str2 = "";
                                            AbsShareMsg absShareMsg7222 = AbsShareMsg.this;
                                            com.tencent.biz.common.util.k.i(ph5, absShareMsg7222.uin, "sourceclick", absShareMsg7222.mSourceAppid, absShareMsg7222.mMsgServiceID, str2);
                                            ReportController.o(ph5, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                            ReportController.o(ph5, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, AbsShareMsg.this.mMsgServiceID + "", "", "", "");
                                            ReportController.o(ph5, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, AbsShareMsg.this.mMsgServiceID + "", "", AbsShareMsg.this.mSourceName, "");
                                            absShareMsg2 = AbsShareMsg.this;
                                            if (absShareMsg2.adverSign == 1) {
                                            }
                                            if (AbsShareMsg.this.mMsgServiceID != 114) {
                                            }
                                            if (absShareMsg3 instanceof StructMsgForGeneralShare) {
                                            }
                                            if (absShareMsg3.mMsgServiceID == 81) {
                                                f16 = c16.f("usertype");
                                                f17 = c16.f("unionid");
                                                if (!TextUtils.isEmpty(f16)) {
                                                    i16 = Integer.parseInt(f16);
                                                    i3 = 1;
                                                    String[] strArr222 = new String[i3];
                                                    strArr222[0] = f17;
                                                    id0.a.n("share_uin_obj", "clk_tail", 0, i16, strArr222);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mVersion = 29;
        int b16 = jVar.b();
        boolean z16 = false;
        for (int i3 = 0; i3 < b16; i3++) {
            j c16 = jVar.c(i3);
            if (c16 != null) {
                if (c16.f290428b.equals("source")) {
                    parseSourceNode(c16);
                    if (z16) {
                        parseDefaultContentNode();
                    }
                } else if (c16.f290428b.equals("sourceAd")) {
                    parseAdSourceNode(c16);
                    if (z16) {
                        parseDefaultContentNode();
                    }
                } else if (this.mMsgServiceID == 128 && c16.f290428b.equals("data")) {
                    parseDataNode(c16);
                } else if (!z16 && !parseContentNode(c16)) {
                    this.mStructMsgItemLists.clear();
                    z16 = true;
                }
            }
        }
    }
}
