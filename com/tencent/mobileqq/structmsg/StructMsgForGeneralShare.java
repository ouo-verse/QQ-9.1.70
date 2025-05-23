package com.tencent.mobileqq.structmsg;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.an;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.aa;
import com.tencent.mobileqq.structmsg.view.ab;
import com.tencent.mobileqq.structmsg.view.ad;
import com.tencent.mobileqq.structmsg.view.ae;
import com.tencent.mobileqq.structmsg.view.ag;
import com.tencent.mobileqq.structmsg.view.ai;
import com.tencent.mobileqq.structmsg.view.aj;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.structmsg.view.q;
import com.tencent.mobileqq.structmsg.view.r;
import com.tencent.mobileqq.structmsg.view.s;
import com.tencent.mobileqq.structmsg.view.t;
import com.tencent.mobileqq.structmsg.view.u;
import com.tencent.mobileqq.structmsg.view.w;
import com.tencent.mobileqq.structmsg.view.x;
import com.tencent.mobileqq.structmsg.view.y;
import com.tencent.mobileqq.structmsg.view.z;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StructMsgForGeneralShare extends AbsShareMsg {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_PAY_STAT = "order_pay_state_";
    public static final String LOGO_URL_POSTFIX = ".png";
    public static int clickedItemIndex;

    /* renamed from: d, reason: collision with root package name */
    private static String f290356d;

    /* renamed from: e, reason: collision with root package name */
    private static int f290357e;
    public static String eventId;
    public static String eventType;

    /* renamed from: f, reason: collision with root package name */
    private static View.OnClickListener f290358f;
    public static QIPCModule receiptServer;
    public static String remindBrief;
    public static String tips;
    public String animResId;
    public String atMembers;
    public boolean havaPayInfoInit;
    boolean isMultiVideoItem;
    int mClickpositionX;
    int mClickpositionY;
    WeakReference<Context> mContext;
    WeakReference<LinearLayout> mExpandView;
    public List<String> mHadPaidList;
    public boolean mIsPAVideoStructMsg;
    public String mPARedPacket;
    public String mVipDonateStr;
    public String mWarningTips;
    public boolean needSendLongMsgWhenFailed;
    public int pobingTemplateId;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ an f290363d;

        a(an anVar) {
            this.f290363d = anVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgForGeneralShare.this, (Object) anVar);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean onLongClick;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                onLongClick = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                StructMsgForGeneralShare.clickedItemIndex = 0;
                AbsStructMsgElement absStructMsgElement = (AbsStructMsgElement) view.getTag();
                if (!TextUtils.isEmpty(absStructMsgElement.K0)) {
                    StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(absStructMsgElement.K0).intValue();
                }
                onLongClick = this.f290363d.onLongClick(view);
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return onLongClick;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ an f290365d;

        b(an anVar) {
            this.f290365d = anVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgForGeneralShare.this, (Object) anVar);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return this.f290365d.onTouch(view, motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ an f290367d;

        c(an anVar) {
            this.f290367d = anVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgForGeneralShare.this, (Object) anVar);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean onLongClick;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                onLongClick = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                StructMsgForGeneralShare.clickedItemIndex = 0;
                AbsStructMsgElement absStructMsgElement = (AbsStructMsgElement) view.getTag();
                if (!TextUtils.isEmpty(absStructMsgElement.K0)) {
                    StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(absStructMsgElement.K0).intValue();
                }
                onLongClick = this.f290367d.onLongClick(view);
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return onLongClick;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ an f290369d;

        d(an anVar) {
            this.f290369d = anVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgForGeneralShare.this, (Object) anVar);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return this.f290369d.onTouch(view, motionEvent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75492);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
            return;
        }
        f290356d = "structmsg.StructMsgForGeneralShare";
        f290357e = -3;
        clickedItemIndex = 0;
        eventId = "";
        remindBrief = "";
        eventType = "";
        tips = "";
        f290358f = new View.OnClickListener() { // from class: com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            long f290359d;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag;
                QQAppInterface qQAppInterface;
                View view2;
                String str;
                String str2;
                int i3;
                int i16;
                View childAt;
                Object tag2;
                int indexOf;
                String substring;
                int indexOf2;
                int parseInt;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(StructMsgForGeneralShare.f290356d, 4, "geneal struct msg onclick start ........");
                    }
                    if (SystemClock.uptimeMillis() - this.f290359d >= 1000) {
                        this.f290359d = SystemClock.uptimeMillis();
                        View findViewById = view.findViewById(R.id.j59);
                        if (findViewById != null && (tag = findViewById.getTag(R.id.j59)) != null && StructMsgForGeneralShare.class.isInstance(tag)) {
                            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) tag;
                            if (view.getTag() == null ? view.getTag(R.id.j56) != null : view.getTag(R.id.j56) != null) {
                                Context context = view.getContext();
                                ChatFragment chatFragment = ((BaseActivity) context).getChatFragment();
                                if (chatFragment != null) {
                                    qQAppInterface = chatFragment.ph();
                                } else {
                                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                                    if (runtime != null && (runtime instanceof QQAppInterface)) {
                                        qQAppInterface = (QQAppInterface) runtime;
                                    } else {
                                        qQAppInterface = null;
                                    }
                                }
                                if (qQAppInterface != null) {
                                    if ("micro_app".equals(structMsgForGeneralShare.mMsg_A_ActionData)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(structMsgForGeneralShare.mMsgActionData);
                                            String optString = jSONObject.optString("appId");
                                            String optString2 = jSONObject.optString("entryPath");
                                            if (!TextUtils.isEmpty(optString)) {
                                                MiniAppLauncher.launchMiniApp(context, optString, structMsgForGeneralShare, optString2);
                                            }
                                        } catch (Throwable th5) {
                                            th5.printStackTrace();
                                        }
                                    } else {
                                        AbsShareMsg.doReport(qQAppInterface, structMsgForGeneralShare);
                                        PublicAccountEventReport.l(qQAppInterface, 0, 4, structMsgForGeneralShare.message);
                                        MessageRecord messageRecord = structMsgForGeneralShare.message;
                                        if (messageRecord != null && "1".equals(messageRecord.getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                                            try {
                                                JSONObject jSONObject2 = new JSONObject();
                                                jSONObject2.put(IPublicAccountBrowser.KEY_PUB_UIN, structMsgForGeneralShare.message.frienduin);
                                                jSONObject2.put("type", structMsgForGeneralShare.index_type);
                                                jSONObject2.put("index", structMsgForGeneralShare.index);
                                                jSONObject2.put("name", structMsgForGeneralShare.index_name);
                                                jSONObject2.put("net", String.valueOf(HttpUtil.getNetWorkType()));
                                                jSONObject2.put("mobile_imei", ah.z());
                                                jSONObject2.put("obj", "");
                                                jSONObject2.put("gdt_cli_data", structMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                                                jSONObject2.put("view_id", structMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                                                ((IPAReportUtil) QRoute.api(IPAReportUtil.class)).reportClickEventForAdver(qQAppInterface, structMsgForGeneralShare.message.selfuin, jSONObject2.toString(), "" + structMsgForGeneralShare.msgId);
                                            } catch (JSONException e16) {
                                                e16.printStackTrace();
                                            }
                                        }
                                        EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) qQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
                                        EcshopReportHandler ecshopReportHandler = (EcshopReportHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
                                        MessageRecord messageRecord2 = structMsgForGeneralShare.message;
                                        if (messageRecord2 != null && ecShopAssistantManager != null && ecshopReportHandler != null && ecShopAssistantManager.o(messageRecord2.senderuin)) {
                                            MessageRecord messageRecord3 = structMsgForGeneralShare.message;
                                            if (TextUtils.isEmpty(structMsgForGeneralShare.index)) {
                                                parseInt = 0;
                                            } else {
                                                parseInt = Integer.parseInt(structMsgForGeneralShare.index);
                                            }
                                            ecshopReportHandler.G2(false, messageRecord3, parseInt, structMsgForGeneralShare.mMsgUrl);
                                        }
                                        long j3 = structMsgForGeneralShare.msgId;
                                        if (j3 > 0) {
                                            view2 = findViewById;
                                            str = "";
                                            str2 = "1";
                                            ReportController.o(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, structMsgForGeneralShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(j3), "");
                                            ThreadManager.getSubThreadHandler().postDelayed(new Runnable(structMsgForGeneralShare, qQAppInterface) { // from class: com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5.1
                                                static IPatchRedirector $redirector_;

                                                /* renamed from: d, reason: collision with root package name */
                                                final /* synthetic */ StructMsgForGeneralShare f290360d;

                                                /* renamed from: e, reason: collision with root package name */
                                                final /* synthetic */ QQAppInterface f290361e;

                                                {
                                                    this.f290360d = structMsgForGeneralShare;
                                                    this.f290361e = qQAppInterface;
                                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                        iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, structMsgForGeneralShare, qQAppInterface);
                                                    }
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                                        return;
                                                    }
                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f290361e, "CliOper", "", this.f290360d.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(NetConnInfoCenter.getServerTime()), Long.toString(this.f290360d.msgId), this.f290360d.mMsgAction, Integer.toString(com.tencent.mobileqq.activity.aio.rebuild.c.y(this.f290360d.uin, this.f290361e) ? 1 : 0), false);
                                                }
                                            }, 0L);
                                        } else {
                                            view2 = findViewById;
                                            str = "";
                                            str2 = "1";
                                        }
                                        if (QLog.isDevelopLevel()) {
                                            QLog.d(StructMsgForGeneralShare.f290356d, 4, "geneal struct msg onclick middle ........");
                                        }
                                        int i17 = structMsgForGeneralShare.uinType;
                                        if (i17 == 0) {
                                            i3 = 0;
                                        } else if (i17 == 1) {
                                            i3 = 1;
                                        } else if (i17 == 3000) {
                                            i3 = 2;
                                        } else {
                                            i3 = 3;
                                        }
                                        String str3 = structMsgForGeneralShare.mMsgUrl;
                                        if (!TextUtils.isEmpty(str3) && (indexOf = structMsgForGeneralShare.mMsgUrl.indexOf("article_id=")) > 0 && (indexOf2 = (substring = structMsgForGeneralShare.mMsgUrl.substring(indexOf + 11)).indexOf(ContainerUtils.FIELD_DELIMITER)) >= 0) {
                                            str3 = substring.substring(0, indexOf2);
                                        }
                                        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, structMsgForGeneralShare.mMsgServiceID + str, "", "", "");
                                        if (structMsgForGeneralShare.uinType == 1008) {
                                            i16 = 2;
                                        } else {
                                            i16 = 1;
                                        }
                                        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004B5C", "0X8004B5C", i16, 0, "", String.valueOf(i3), str3, structMsgForGeneralShare.source_puin);
                                        jq3.a.c(str2, structMsgForGeneralShare.uinType, structMsgForGeneralShare.mContentTitle, structMsgForGeneralShare.mSourceAppid);
                                        View view3 = view2;
                                        if ((view3 instanceof ViewGroup) && (childAt = ((ViewGroup) view3).getChildAt(0)) != null && (childAt instanceof TextViewWrapLayout) && (tag2 = childAt.getTag(StructMsgForGeneralShare.f290357e)) != null && (tag2 instanceof u)) {
                                            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007C38", "0X8007C38", 0, 0, ((u) tag2).R0 + str, "", "", "");
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
    }

    public StructMsgForGeneralShare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.havaPayInfoInit = false;
        this.mHadPaidList = new ArrayList();
        this.mExpandView = new WeakReference<>(null);
        this.mContext = new WeakReference<>(null);
        this.mWarningTips = "";
        this.mPARedPacket = "";
        this.mIsPAVideoStructMsg = false;
        this.mVipDonateStr = "";
        this.isMultiVideoItem = false;
        this.pobingTemplateId = 2000;
        this.needSendLongMsgWhenFailed = false;
        this.mMsgServiceID = 1;
        this.mMsgAction = "web";
    }

    public static boolean HandleMiniAppJump(Context context, String str) {
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
            QLog.d(f290356d, 2, " jump to miniApp: " + str);
            Uri parse = Uri.parse(str);
            if (TextUtils.equals(parse.getQueryParameter("_miniapptype"), "2")) {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(context, parse.getQueryParameter("_mappid"), parse.getQueryParameter("_path"), 1043);
                return true;
            }
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, str, 1043, null);
        }
        if (str.startsWith("http://q.url.cn/url/Jump") || str.startsWith("https://q.url.cn/url/Jump")) {
            try {
                Map<String, String> arguments = URLUtil.getArguments(str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1));
                HashMap hashMap = new HashMap();
                hashMap.putAll(arguments);
                if (hashMap.containsKey("url")) {
                    String str2 = (String) hashMap.get("url");
                    if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str2)) {
                        QLog.d(f290356d, 2, " jump to miniApp: " + str2);
                        return ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, str2, 1043, null);
                    }
                }
            } catch (Exception e16) {
                QLog.e(f290356d, 2, "parse url failed, ", e16);
                return false;
            }
        }
        return false;
    }

    public static Intent createMultiMsgForwardIntent(Context context, StructMsgForGeneralShare structMsgForGeneralShare, String str, int i3, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) MultiForwardActivity.class);
        intent.putExtra("chat_subType", 3);
        intent.putExtra("uin", str2);
        intent.putExtra("uintype", i3);
        intent.putExtra(AppConstants.Key.TROOP_CODE, str3);
        intent.putExtra("multi_url", structMsgForGeneralShare.mResid);
        intent.putExtra("multimsg_uniseq", structMsgForGeneralShare.uniseq);
        intent.putExtra("origin_merge_structing_msg_uniseq", s(structMsgForGeneralShare, (BaseActivity) context));
        intent.putExtra("multi_title", str);
        return intent;
    }

    public static void dealMsgBeforeClick(StructMsgForGeneralShare structMsgForGeneralShare, ChatMessage chatMessage) {
        if (structMsgForGeneralShare != null && chatMessage != null) {
            if (structMsgForGeneralShare.mMsgServiceID == 14 && !TextUtils.isEmpty(structMsgForGeneralShare.mMsg_A_ActionData) && !structMsgForGeneralShare.mMsg_A_ActionData.contains("&referee=")) {
                structMsgForGeneralShare.mMsg_A_ActionData = String.format("%s&referee=%s", structMsgForGeneralShare.mMsg_A_ActionData, chatMessage.senderuin);
            }
            if (QLog.isColorLevel()) {
                QLog.i(f290356d, 2, String.format("dealMsgBeforeClick service_id:%s, data:%s, frd_uin:%s, sender_uin:%s", Integer.valueOf(structMsgForGeneralShare.mMsgServiceID), structMsgForGeneralShare.mMsg_A_ActionData, chatMessage.frienduin, chatMessage.senderuin));
            }
        }
    }

    public static String getCoverForChatHistory(AbsStructMsgElement absStructMsgElement) {
        if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.c) {
            return ((com.tencent.mobileqq.structmsg.view.c) absStructMsgElement).S0;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static String getResponseRedirectLocation(String str) {
        String str2;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();
            str2 = httpURLConnection.getHeaderField("location");
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f290356d, 2, "getResponseRedirectLocation  MalformedURLException ", e16);
            }
            str2 = null;
            if (QLog.isColorLevel()) {
            }
            return str2;
        } catch (IOException e17) {
            if (QLog.isColorLevel()) {
                QLog.d(f290356d, 2, "getResponseRedirectLocation  IOException ", e17);
            }
            str2 = null;
            if (QLog.isColorLevel()) {
            }
            return str2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f290356d, 2, "getResponseRedirectLocation  location = " + str2);
        }
        return str2;
    }

    public static String getSummary(AbsStructMsgElement absStructMsgElement) {
        if (absStructMsgElement instanceof ap) {
            return ((ap) absStructMsgElement).X0;
        }
        return null;
    }

    public static String getTitleForChatHistory(AbsStructMsgElement absStructMsgElement) {
        if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.b) {
            return ((com.tencent.mobileqq.structmsg.b) absStructMsgElement).X0;
        }
        return null;
    }

    static boolean handleNearbyPublicAccountMsg(QQAppInterface qQAppInterface, Context context, StructMsgForGeneralShare structMsgForGeneralShare) {
        String responseRedirectLocation;
        int indexOf;
        boolean z16 = false;
        if (structMsgForGeneralShare.mMsgBrief.contains(HardCodeUtil.qqStr(R.string.tvu)) && (responseRedirectLocation = getResponseRedirectLocation(structMsgForGeneralShare.mMsgUrl)) != null && responseRedirectLocation.contains("find_school_mate_guide") && (indexOf = responseRedirectLocation.indexOf("find_school_mate_guide")) > 0) {
            try {
                String decode = URLDecoder.decode(responseRedirectLocation.substring(indexOf + 22 + 1), "UTF-8");
                if (QLog.isColorLevel()) {
                    QLog.d(f290356d, 2, "handleNearbyPublicAccountMsg find shoolmate msg clicked, url =  " + responseRedirectLocation + ",schema = " + decode);
                }
                ax c16 = bi.c(qQAppInterface, context, decode);
                if (c16 != null) {
                    c16.b();
                    z16 = true;
                }
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f290356d, 2, "handleNearbyPublicAccountMsg  result = " + z16 + ",msg.mMsgBrief = " + structMsgForGeneralShare.mMsgBrief);
        }
        return z16;
    }

    private void q(Context context, int i3, View view) {
        int i16;
        int i17;
        if (view == null) {
            return;
        }
        if (i3 <= 2 && i3 - 1 >= 0) {
            int f16 = BaseAIOUtils.f(12.0f, context.getResources());
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            AbsStructMsgElement itemByIndex = getItemByIndex(i16);
            if (itemByIndex instanceof ag) {
                ag agVar = (ag) itemByIndex;
                if (agVar.U0.size() == 1 && (agVar.U0.get(0) instanceof com.tencent.mobileqq.structmsg.view.d) && i3 - 2 >= 0 && (getItemByIndex(i17) instanceof y) && z.a((com.tencent.mobileqq.structmsg.a) getItemByIndex(i17), i17)) {
                    view.setPadding(paddingLeft, f16, paddingRight, paddingBottom);
                    return;
                }
            }
            if ((itemByIndex instanceof y) && (z.a((com.tencent.mobileqq.structmsg.a) itemByIndex, i16) || this.isMultiVideoItem)) {
                view.setPadding(paddingLeft, f16, paddingRight, paddingBottom);
                return;
            }
        }
        if (i3 == getItemCount() - 1) {
            AbsStructMsgElement itemByIndex2 = getItemByIndex(0);
            if (itemByIndex2 instanceof y) {
                if (z.a((com.tencent.mobileqq.structmsg.a) itemByIndex2, 0) || this.isMultiVideoItem) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), BaseAIOUtils.f(12.0f, context.getResources()));
                }
            }
        }
    }

    private void r(com.tencent.mobileqq.structmsg.a aVar, boolean z16, String str, String str2, String str3, String str4, String str5, Bundle bundle) {
        StructMsgItemVideo structMsgItemVideo;
        String string = bundle.getString("VINFO");
        String string2 = bundle.getString("TINFO");
        int i3 = bundle.getInt("PREVIEW_VIDEO_TIME", 0);
        int i16 = bundle.getInt("PREVIEW_START_POSI", 0);
        int i17 = bundle.getInt("PREVIEW_VIDEO_WIDTH", 0);
        int i18 = bundle.getInt("PREVIEW_VIDEO_HEIGHT", 0);
        int i19 = bundle.getInt("FULL_VIDEO_TIME", 0);
        String string3 = bundle.getString("ACCOUNT_UIN");
        String string4 = bundle.getString("ACCOUNT_NAME");
        String string5 = bundle.getString("ARTICLE_ID");
        int i26 = bundle.getInt("TYPE", 0);
        int i27 = bundle.getInt("VIDEO_FEED_TYPE", 0);
        long j3 = bundle.getLong("VIDEO_FEED_ID", 0L);
        if (com.tencent.biz.pubaccount.util.g.a(i26)) {
            structMsgItemVideo = new StructMsgItemVideo(str2, i26, string, string2, str5, i3, i16, i17, i18, i19, string3, string4, string5, i27, j3);
        } else {
            structMsgItemVideo = new StructMsgItemVideo(str2, str3, z16);
        }
        structMsgItemVideo.P0 = this;
        this.mMsgUrl = str;
        aVar.m(structMsgItemVideo);
        aVar.m(new StructMsgItemTitle(str4));
    }

    private static long s(AbsStructMsg absStructMsg, BaseActivity baseActivity) {
        long j3 = absStructMsg.uniseq;
        if (baseActivity.getIntent() != null && baseActivity.getIntent().hasExtra("origin_merge_structing_msg_uniseq")) {
            long longExtra = baseActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
            if (longExtra > 0) {
                return longExtra;
            }
            return j3;
        }
        return j3;
    }

    private void t(View view, Resources resources, Bundle bundle) {
        View findViewById;
        boolean z16;
        if (view != null && resources != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(BaseChatItemLayout.f178058p0, -2);
            } else {
                layoutParams.width = BaseChatItemLayout.f178058p0;
                layoutParams.height = -2;
            }
            if (hasFlag(4)) {
                layoutParams.width = -1;
                if (bundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 || !hasFlag(4)) {
                    view.setBackgroundResource(R.drawable.f160240dy);
                }
            }
            int i3 = this.mMsgServiceID;
            if (i3 == 76) {
                layoutParams.width = -1;
                view.setBackgroundDrawable(null);
            } else if (i3 != 83 && i3 != 108 && i3 != 151 && i3 != 156) {
                if (i3 != 114 && i3 != 116) {
                    if (i3 == 98) {
                        layoutParams.width = Math.min(BaseChatItemLayout.f178058p0 + BaseAIOUtils.f(10.0f, resources), BaseAIOUtils.f(206.0f, resources));
                        view.setBackgroundDrawable(null);
                    } else if (i3 == 91) {
                        layoutParams.width = -1;
                        view.setBackgroundResource(R.drawable.f160240dy);
                    } else if (i3 == 97) {
                        layoutParams.width = -2;
                        view.setBackgroundDrawable(null);
                    } else if (i3 == 106 || i3 == 107) {
                        layoutParams.width = -2;
                        view.setBackgroundDrawable(null);
                    }
                } else {
                    layoutParams.width = BaseChatItemLayout.f178058p0;
                    if (!TextUtils.isEmpty(this.mMsgActionData)) {
                        layoutParams.width += BaseAIOUtils.f(18.0f, resources);
                    }
                    view.setBackgroundDrawable(null);
                    int i16 = this.mMsgServiceID;
                    if (i16 == 116) {
                        View findViewById2 = view.findViewById(R.id.bat);
                        if (findViewById2 != null) {
                            int height = findViewById2.getHeight();
                            double d16 = layoutParams.width;
                            if (d16 > height * 2.1311999999999998d) {
                                int i17 = (int) (d16 / 1.776d);
                                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                                layoutParams2.height = i17;
                                findViewById2.setLayoutParams(layoutParams2);
                            }
                        }
                    } else if (i16 == 114 && (findViewById = view.findViewById(R.id.bat)) != null) {
                        ViewGroup.LayoutParams layoutParams3 = findViewById.getLayoutParams();
                        if (ScreenUtil.SCREEN_WIDTH > 1280) {
                            layoutParams3.height = BaseAIOUtils.f(144.0f, findViewById.getResources());
                        } else {
                            layoutParams3.height = BaseAIOUtils.f(112.0f, findViewById.getResources());
                        }
                        findViewById.setLayoutParams(layoutParams3);
                    }
                }
            } else {
                layoutParams.width = BaseChatItemLayout.f178058p0 + BaseAIOUtils.f(10.0f, resources);
                if (!TextUtils.isEmpty(this.mMsgActionData)) {
                    layoutParams.width += BaseAIOUtils.f(18.0f, resources);
                }
                view.setBackgroundDrawable(null);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static void unRegisterQIPC() {
        if (receiptServer != null) {
            QIPCServerHelper.getInstance().getServer().unRegisterModule(receiptServer);
            receiptServer = null;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    public boolean LayoutEquals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return getLayoutStr().equals(((StructMsgForGeneralShare) obj).getLayoutStr());
    }

    public String getLayoutStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = this.mMsgServiceID;
        if (i3 != 83 && i3 != 108 && i3 != 114 && i3 != 116 && i3 != 151 && i3 != 156) {
            List<AbsStructMsgElement> list = this.mStructMsgItemLists;
            if (list != null) {
                Iterator<AbsStructMsgElement> it = list.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next().f());
                }
            }
        } else {
            stringBuffer.append("StructMsgItemLayoutNew2");
        }
        stringBuffer.append(this.mFlag & 4);
        return stringBuffer.toString();
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    public View.OnClickListener getOnClickListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return f290358f;
    }

    public int getProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        AbsStructMsgElement findXmlNode = findXmlNode("progress");
        if (findXmlNode != null && (findXmlNode instanceof com.tencent.mobileqq.structmsg.view.an)) {
            return ((com.tencent.mobileqq.structmsg.view.an) findXmlNode).m();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg, com.tencent.mobileqq.structmsg.AbsStructMsg
    public View getSourceView(Context context, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) view);
        }
        return super.getSourceView(context, view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0344, code lost:
    
        if ((((com.tencent.mobileqq.structmsg.view.w) r4).U0.get(r1) instanceof com.tencent.mobileqq.structmsg.view.StructMsgItemButton) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x066e, code lost:
    
        if ((((com.tencent.mobileqq.structmsg.view.ag) r2).U0.get(0) instanceof com.tencent.mobileqq.structmsg.view.ak) == false) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0684, code lost:
    
        r2 = (android.view.ViewGroup.MarginLayoutParams) r9.getLayoutParams();
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x068a, code lost:
    
        if (r2 == null) goto L383;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x068e, code lost:
    
        if ((r8 instanceof com.tencent.mobileqq.structmsg.view.ag) == false) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0690, code lost:
    
        if (r5 == false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0692, code lost:
    
        r2.bottomMargin = com.tencent.mobileqq.activity.aio.BaseAIOUtils.f(11.0f, r22.getResources());
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x06cc, code lost:
    
        r9.setLayoutParams(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x069f, code lost:
    
        r2.bottomMargin = com.tencent.mobileqq.activity.aio.BaseAIOUtils.f(16.0f, r22.getResources());
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x06b2, code lost:
    
        if ((r8 instanceof com.tencent.mobileqq.structmsg.view.aa) == false) goto L380;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x06bb, code lost:
    
        if (com.tencent.mobileqq.structmsg.view.ab.a((com.tencent.mobileqq.structmsg.a) r8, r6) != false) goto L380;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x06bd, code lost:
    
        r2.bottomMargin = com.tencent.mobileqq.activity.aio.BaseAIOUtils.f(7.5f, r22.getResources());
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0682, code lost:
    
        if ((((com.tencent.mobileqq.structmsg.view.w) r2).U0.get(r7) instanceof com.tencent.mobileqq.structmsg.view.StructMsgItemButton) != false) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0332, code lost:
    
        if ((((com.tencent.mobileqq.structmsg.view.ag) r4).U0.get(0) instanceof com.tencent.mobileqq.structmsg.view.ak) == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0346, code lost:
    
        r1 = (android.view.ViewGroup.MarginLayoutParams) r7.getLayoutParams();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x034c, code lost:
    
        if (r1 == null) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0350, code lost:
    
        if ((r9 instanceof com.tencent.mobileqq.structmsg.view.ag) == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0352, code lost:
    
        if (r5 == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0354, code lost:
    
        r1.bottomMargin = com.tencent.mobileqq.activity.aio.BaseAIOUtils.f(11.0f, r22.getResources());
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0387, code lost:
    
        r7.setLayoutParams(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0361, code lost:
    
        r1.bottomMargin = com.tencent.mobileqq.activity.aio.BaseAIOUtils.f(16.0f, r22.getResources());
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0370, code lost:
    
        if ((r9 instanceof com.tencent.mobileqq.structmsg.view.aa) == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0379, code lost:
    
        if (com.tencent.mobileqq.structmsg.view.ab.a((com.tencent.mobileqq.structmsg.a) r9, r6) != false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x037b, code lost:
    
        r1.bottomMargin = com.tencent.mobileqq.activity.aio.BaseAIOUtils.f(7.5f, r22.getResources());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:310:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0749  */
    /* JADX WARN: Type inference failed for: r1v49, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r7v51, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v65, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v69 */
    /* JADX WARN: Type inference failed for: r7v70 */
    /* JADX WARN: Type inference failed for: r7v71 */
    /* JADX WARN: Type inference failed for: r7v72 */
    /* JADX WARN: Type inference failed for: r7v73 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v5, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v34, types: [com.tencent.mobileqq.structmsg.AbsStructMsgElement, android.view.View$OnClickListener, java.lang.Object] */
    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(Context context, View view, an anVar, Bundle bundle) {
        View view2;
        int i3;
        boolean z16;
        View view3;
        boolean z17;
        ViewGroup viewGroup;
        boolean z18;
        View view4;
        View c16;
        boolean z19;
        com.tencent.mobileqq.structmsg.a aVar;
        AbsStructMsgElement itemByIndex;
        int i16;
        View view5;
        int i17;
        View c17;
        View c18;
        View view6;
        LinearLayout linearLayout;
        LinearLayout.LayoutParams layoutParams;
        Context context2 = context;
        View view7 = view;
        IPatchRedirector iPatchRedirector = $redirector_;
        ?? r85 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, this, context2, view7, anVar, bundle);
        }
        if (view7 != null && (view7.getTag(R.id.j56) != null || view7.getTag(R.id.f166666h55) != null)) {
            view7 = null;
        }
        if (QLog.isColorLevel()) {
            String str = f290356d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getView convertView=");
            sb5.append(view7);
            sb5.append(",mMsg_A_ActionData=");
            sb5.append(this.mMsg_A_ActionData);
            sb5.append(",tag=");
            sb5.append(view7 != null ? view7.getTag(R.id.f166942ja3) : null);
            QLog.d(str, 2, sb5.toString());
        }
        this.mContext = new WeakReference<>(context2);
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        bundle2.putBoolean("hasHeadIcon", hasFlag(4));
        bundle2.putInt("serviceID", this.mMsgServiceID);
        if (QLog.isColorLevel()) {
            QLog.d(f290356d, 2, "getView(): convertView=" + view7 + ", args = " + bundle2.toString());
        }
        int i18 = bundle2.getInt("longMsgHolderType", -1);
        if (i18 != 1 && i18 != 2 && i18 != 3) {
            boolean z26 = bundle2.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA;
            if (this.mMsgException) {
                QLog.d(f290356d, 1, "struct msg has version exception! uin : " + this.uin + " msgVersion : " + this.messageVersion + " version : " + this.mVersion + " msgUniseq" + this.uniseq);
                View versionExceptionView = AbsStructMsg.getVersionExceptionView(context2, view7, anVar, bundle2);
                versionExceptionView.setId(R.id.j59);
                versionExceptionView.setTag(R.id.j59, this);
                return versionExceptionView;
            }
            boolean supportNightMode = supportNightMode();
            bundle2.putBoolean("key_support_night_mode", supportNightMode);
            boolean z27 = supportNightMode && QQTheme.isNowThemeIsNight();
            if (view7 == null) {
                View view8 = super.getView(context2, null, anVar, bundle2);
                if (view8 == null) {
                    return null;
                }
                ?? r26 = view8 instanceof ViewGroup ? (ViewGroup) view8 : 0;
                if (r26 == 0) {
                    return null;
                }
                int itemCount = this.mStructMsgItemLists != null ? getItemCount() : 0;
                if (itemCount > 0) {
                    z17 = true;
                    int i19 = 0;
                    while (i19 < itemCount) {
                        ?? itemByIndex2 = getItemByIndex(i19);
                        itemByIndex2.O0 = new WeakReference(anVar);
                        symbol2CharactorForSmallEmoji(itemByIndex2);
                        String str2 = this.uin;
                        if (str2 != null && !str2.equalsIgnoreCase(itemByIndex2.M0)) {
                            itemByIndex2.M0 = this.uin;
                        }
                        if (itemByIndex2.g() == 0) {
                            if (i19 == 0) {
                                itemByIndex2.a(r85);
                            }
                            if (i19 == itemCount - 1) {
                                itemByIndex2.a(2);
                            }
                        }
                        if (itemByIndex2 instanceof ad) {
                            linearLayout = itemByIndex2.c(context2, null, bundle2);
                        } else if (itemByIndex2 instanceof ae) {
                            linearLayout = itemByIndex2.c(context2, null, bundle2);
                        } else {
                            if (itemByIndex2 instanceof com.tencent.mobileqq.structmsg.view.h) {
                                view6 = itemByIndex2.c(context2, null, bundle2);
                            } else {
                                if (itemByIndex2 instanceof y) {
                                    if (i19 + 1 < itemCount) {
                                        ((y) itemByIndex2).X0 = r85;
                                        this.isMultiVideoItem = r85;
                                    } else {
                                        ((y) itemByIndex2).X0 = false;
                                        this.isMultiVideoItem = false;
                                    }
                                    c17 = z26 ? new z((com.tencent.mobileqq.structmsg.a) itemByIndex2, context2, i19).c(context2, null, bundle2) : itemByIndex2.c(context2, null, bundle2);
                                } else if (itemByIndex2 instanceof aa) {
                                    c17 = z26 ? new ab((com.tencent.mobileqq.structmsg.a) itemByIndex2, context2, i19).c(context2, null, bundle2) : itemByIndex2.c(context2, null, bundle2);
                                } else if (itemByIndex2 instanceof x) {
                                    c17 = itemByIndex2.c(context2, null, bundle2);
                                    if (z26) {
                                        q(context2, i19, c17);
                                    }
                                } else {
                                    if (itemByIndex2 instanceof com.tencent.mobileqq.structmsg.view.i) {
                                        c18 = itemByIndex2.c(context2, null, bundle2);
                                    } else if (itemByIndex2 instanceof com.tencent.mobileqq.structmsg.view.j) {
                                        c18 = itemByIndex2.c(context2, null, bundle2);
                                    } else if (itemByIndex2 instanceof u) {
                                        int i26 = this.mMsgServiceID;
                                        if (i26 != 83 && i26 != 108 && i26 != 114 && i26 != 116 && i26 != 151 && i26 != 156) {
                                            if (this.mDatas != null) {
                                                MessageRecord messageRecord = this.message;
                                                if (messageRecord != null && !TextUtils.isEmpty(messageRecord.senderuin)) {
                                                    try {
                                                        this.mDatas.put("senderuin", this.message.senderuin);
                                                        this.mDatas.put("invitedUin", this.message.isSend() ? this.message.frienduin : this.message.selfuin);
                                                    } catch (JSONException unused) {
                                                    }
                                                }
                                                bundle2.putString("extend-data-json", this.mDatas.toString());
                                            }
                                            ?? c19 = itemByIndex2.c(context2, null, bundle2);
                                            linearLayout = c19;
                                            if (c19 != 0) {
                                                c19.setTag(f290357e, itemByIndex2);
                                                linearLayout = c19;
                                            }
                                        } else {
                                            ai aiVar = new ai();
                                            aiVar.P0 = this;
                                            aiVar.O0 = new WeakReference(anVar);
                                            c18 = aiVar.c(context2, null, bundle2);
                                        }
                                    } else if (itemByIndex2 instanceof StructMsgItemLayout20) {
                                        c17 = itemByIndex2.c(context2, null, bundle2);
                                    } else if (itemByIndex2 instanceof q) {
                                        bundle2.putString(WadlProxyConsts.EXTRA_DATA, this.mExtraData);
                                        c18 = itemByIndex2.c(context2, null, bundle2);
                                    } else if (itemByIndex2 instanceof r) {
                                        c18 = itemByIndex2.c(context2, null, bundle2);
                                    } else if (itemByIndex2 instanceof s) {
                                        c18 = itemByIndex2.c(context2, null, bundle2);
                                    } else if (itemByIndex2 instanceof t) {
                                        itemByIndex2.P0 = this;
                                        c18 = itemByIndex2.c(context2, null, bundle2);
                                    } else if (itemByIndex2 instanceof com.tencent.mobileqq.structmsg.view.ah) {
                                        itemByIndex2.P0 = this;
                                        c18 = itemByIndex2.c(context2, null, bundle2);
                                    } else {
                                        c17 = itemByIndex2.c(context2, null, bundle2);
                                    }
                                    view6 = c18;
                                }
                                linearLayout = c17;
                            }
                            z17 = false;
                            linearLayout = view6;
                        }
                        int i27 = i19 + 2;
                        if (i27 < itemCount && linearLayout != 0) {
                            AbsStructMsgElement itemByIndex3 = getItemByIndex(i27);
                            if (((com.tencent.mobileqq.structmsg.a) itemByIndex3).U0.size() != 0) {
                                int i28 = itemByIndex3 instanceof ag ? 0 : 0;
                                if (itemByIndex3 instanceof w) {
                                }
                            }
                        }
                        i19++;
                        if (i19 < itemCount && linearLayout != 0 && z26) {
                            com.tencent.mobileqq.structmsg.a aVar2 = (com.tencent.mobileqq.structmsg.a) itemByIndex2;
                            if (aVar2.U0.size() == 1 && (aVar2.U0.get(0) instanceof com.tencent.mobileqq.structmsg.view.d)) {
                                AbsStructMsgElement itemByIndex4 = getItemByIndex(i19);
                                if (((com.tencent.mobileqq.structmsg.a) itemByIndex4).U0.size() != 0 && (itemByIndex4 instanceof w) && (((w) itemByIndex4).U0.get(0) instanceof StructMsgItemButton)) {
                                    linearLayout.setPadding(2, linearLayout.getPaddingTop(), 2, linearLayout.getPaddingBottom());
                                    if ((linearLayout instanceof LinearLayout) && (layoutParams = (LinearLayout.LayoutParams) linearLayout.getChildAt(0).getLayoutParams()) != null) {
                                        layoutParams.leftMargin = 0;
                                        layoutParams.rightMargin = 0;
                                    }
                                }
                            }
                        }
                        if (linearLayout != 0) {
                            if (!TextUtils.isEmpty(itemByIndex2.f290329i) || (itemByIndex2 instanceof s)) {
                                linearLayout.setTag(itemByIndex2);
                                linearLayout.setClickable(true);
                                linearLayout.setOnClickListener(itemByIndex2);
                                linearLayout.setOnLongClickListener(new a(anVar));
                                linearLayout.setOnTouchListener(new b(anVar));
                                clickedItemIndex = 0;
                            }
                            if (linearLayout.getParent() != null) {
                                ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
                                if (QLog.isColorLevel()) {
                                    QLog.e(f290356d, 2, "getView itemView.getParent != null .itemName = ." + itemByIndex2.getClass().getName());
                                }
                            }
                            r26.addView(linearLayout);
                        } else if (QLog.isDevelopLevel()) {
                            QLog.e(f290356d, 4, "Create item view failure by #StructMsgItemViewFactory");
                            context2 = context;
                            r85 = 1;
                        }
                        context2 = context;
                        r85 = 1;
                    }
                    i17 = 4;
                } else {
                    i17 = 4;
                    z17 = true;
                }
                if ((z26 && hasFlag(i17)) || this.mMsgServiceID == 91) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.SUBSCRIPT, 2, "StructMsgForGeneralShare use subscript structmsg bg");
                    }
                    r26.setBackgroundResource(z27 ? R.drawable.f160249j94 : R.drawable.f160246e4);
                }
                t(r26, context.getResources(), bundle2);
                view5 = r26;
            } else {
                int itemCount2 = getItemCount();
                if (itemCount2 > 0) {
                    ViewGroup viewGroup2 = (ViewGroup) view7;
                    int i29 = 0;
                    boolean z28 = true;
                    while (i29 < itemCount2) {
                        AbsStructMsgElement itemByIndex5 = getItemByIndex(i29);
                        itemByIndex5.O0 = new WeakReference(anVar);
                        String str3 = this.uin;
                        if (str3 != null && !str3.equalsIgnoreCase(itemByIndex5.M0)) {
                            itemByIndex5.M0 = this.uin;
                        }
                        if (itemByIndex5.g() == 0) {
                            if (i29 == 0) {
                                itemByIndex5.a(1);
                            }
                            if (i29 == itemCount2 - 1) {
                                itemByIndex5.a(2);
                            }
                        }
                        View childAt = viewGroup2.getChildAt(i29);
                        if (itemByIndex5 instanceof ad) {
                            c16 = itemByIndex5.c(context, childAt, bundle2);
                            view4 = view7;
                            viewGroup = viewGroup2;
                        } else {
                            viewGroup = viewGroup2;
                            if (itemByIndex5 instanceof ae) {
                                c16 = itemByIndex5.c(context, childAt, bundle2);
                                view4 = view7;
                            } else {
                                if (itemByIndex5 instanceof com.tencent.mobileqq.structmsg.view.h) {
                                    c16 = itemByIndex5.c(context, childAt, bundle2);
                                } else {
                                    if (itemByIndex5 instanceof y) {
                                        if (i29 + 1 < itemCount2) {
                                            z18 = z28;
                                            ((y) itemByIndex5).X0 = true;
                                            this.isMultiVideoItem = true;
                                        } else {
                                            z18 = z28;
                                            ((y) itemByIndex5).X0 = false;
                                            this.isMultiVideoItem = false;
                                        }
                                        c16 = z26 ? new z((com.tencent.mobileqq.structmsg.a) itemByIndex5, context, i29).c(context, childAt, bundle2) : itemByIndex5.c(context, childAt, bundle2);
                                    } else {
                                        z18 = z28;
                                        if (itemByIndex5 instanceof aa) {
                                            c16 = z26 ? new ab((com.tencent.mobileqq.structmsg.a) itemByIndex5, context, i29).c(context, childAt, bundle2) : itemByIndex5.c(context, childAt, bundle2);
                                        } else if (itemByIndex5 instanceof x) {
                                            c16 = itemByIndex5.c(context, childAt, bundle2);
                                            if (z26) {
                                                q(context, i29, c16);
                                            }
                                        } else if (itemByIndex5 instanceof com.tencent.mobileqq.structmsg.view.i) {
                                            c16 = itemByIndex5.c(context, childAt, bundle2);
                                        } else if (itemByIndex5 instanceof com.tencent.mobileqq.structmsg.view.j) {
                                            c16 = itemByIndex5.c(context, childAt, bundle2);
                                        } else if (itemByIndex5 instanceof u) {
                                            int i36 = this.mMsgServiceID;
                                            if (i36 != 83 && i36 != 108 && i36 != 114 && i36 != 116 && i36 != 151 && i36 != 156) {
                                                if (this.mDatas != null) {
                                                    MessageRecord messageRecord2 = this.message;
                                                    if (messageRecord2 != null && !TextUtils.isEmpty(messageRecord2.senderuin)) {
                                                        try {
                                                            view4 = view7;
                                                            try {
                                                                this.mDatas.put("senderuin", this.message.senderuin);
                                                                this.mDatas.put("invitedUin", this.message.isSend() ? this.message.frienduin : this.message.selfuin);
                                                            } catch (JSONException unused2) {
                                                            }
                                                        } catch (JSONException unused3) {
                                                        }
                                                        bundle2.putString("extend-data-json", this.mDatas.toString());
                                                    }
                                                    view4 = view7;
                                                    bundle2.putString("extend-data-json", this.mDatas.toString());
                                                } else {
                                                    view4 = view7;
                                                }
                                                c16 = itemByIndex5.c(context, childAt, bundle2);
                                                if (c16 != null) {
                                                    c16.setTag(f290357e, itemByIndex5);
                                                }
                                                z28 = z18;
                                            } else {
                                                view4 = view7;
                                                ai aiVar2 = new ai();
                                                aiVar2.P0 = this;
                                                aiVar2.O0 = new WeakReference(anVar);
                                                c16 = aiVar2.c(context, childAt, bundle2);
                                                z28 = false;
                                            }
                                        } else {
                                            view4 = view7;
                                            if (itemByIndex5 instanceof StructMsgItemLayout20) {
                                                c16 = itemByIndex5.c(context, childAt, bundle2);
                                            } else {
                                                if (itemByIndex5 instanceof q) {
                                                    c16 = itemByIndex5.c(context, childAt, bundle2);
                                                } else if (itemByIndex5 instanceof r) {
                                                    c16 = itemByIndex5.c(context, childAt, bundle2);
                                                } else if (itemByIndex5 instanceof s) {
                                                    c16 = itemByIndex5.c(context, childAt, bundle2);
                                                } else if (itemByIndex5 instanceof t) {
                                                    itemByIndex5.P0 = this;
                                                    c16 = itemByIndex5.c(context, childAt, bundle2);
                                                } else if (itemByIndex5 instanceof com.tencent.mobileqq.structmsg.view.ah) {
                                                    itemByIndex5.P0 = this;
                                                    c16 = itemByIndex5.c(context, childAt, bundle2);
                                                } else {
                                                    c16 = itemByIndex5.c(context, childAt, bundle2);
                                                }
                                                z28 = false;
                                            }
                                            z28 = z18;
                                        }
                                    }
                                    view4 = view7;
                                    z28 = z18;
                                }
                                view4 = view7;
                                z28 = false;
                            }
                        }
                        int i37 = i29 + 2;
                        if (i37 < itemCount2) {
                            AbsStructMsgElement itemByIndex6 = getItemByIndex(i37);
                            if (((com.tencent.mobileqq.structmsg.a) itemByIndex6).U0.size() != 0 && c16 != null) {
                                if (itemByIndex6 instanceof ag) {
                                    z19 = z28;
                                    i16 = 0;
                                } else {
                                    z19 = z28;
                                    i16 = 0;
                                }
                                if (itemByIndex6 instanceof w) {
                                }
                                i29++;
                                if (i29 < itemCount2 && c16 != null) {
                                    aVar = (com.tencent.mobileqq.structmsg.a) itemByIndex5;
                                    if (aVar.U0.size() == 1 && (aVar.U0.get(0) instanceof com.tencent.mobileqq.structmsg.view.d)) {
                                        itemByIndex = getItemByIndex(i29);
                                        if (((com.tencent.mobileqq.structmsg.a) itemByIndex).U0.size() != 0 && (itemByIndex instanceof w) && (((w) itemByIndex).U0.get(0) instanceof StructMsgItemButton)) {
                                            c16.setPadding(2, c16.getPaddingTop(), 2, c16.getPaddingBottom());
                                        }
                                    }
                                }
                                if (c16 == null) {
                                    if (!TextUtils.isEmpty(itemByIndex5.f290329i) || (itemByIndex5 instanceof s)) {
                                        c16.setTag(itemByIndex5);
                                        c16.setClickable(true);
                                        c16.setOnClickListener(itemByIndex5);
                                        c16.setOnLongClickListener(new c(anVar));
                                        c16.setOnTouchListener(new d(anVar));
                                        clickedItemIndex = 0;
                                    }
                                } else if (QLog.isDevelopLevel()) {
                                    QLog.e(f290356d, 4, "Create item view failure by #StructMsgItemViewFactory");
                                    viewGroup2 = viewGroup;
                                    z28 = z19;
                                    view7 = view4;
                                }
                                viewGroup2 = viewGroup;
                                z28 = z19;
                                view7 = view4;
                            }
                        }
                        z19 = z28;
                        i29++;
                        if (i29 < itemCount2) {
                            aVar = (com.tencent.mobileqq.structmsg.a) itemByIndex5;
                            if (aVar.U0.size() == 1) {
                                itemByIndex = getItemByIndex(i29);
                                if (((com.tencent.mobileqq.structmsg.a) itemByIndex).U0.size() != 0) {
                                    c16.setPadding(2, c16.getPaddingTop(), 2, c16.getPaddingBottom());
                                }
                            }
                        }
                        if (c16 == null) {
                        }
                        viewGroup2 = viewGroup;
                        z28 = z19;
                        view7 = view4;
                    }
                    view2 = view7;
                    i3 = 4;
                    z16 = z28;
                } else {
                    view2 = view7;
                    i3 = 4;
                    z16 = true;
                }
                if (z26 && hasFlag(i3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.SUBSCRIPT, 2, "StructMsgForGeneralShare use subscript structmsg bg");
                    }
                    View view9 = view2;
                    view9.setBackgroundResource(z27 ? R.drawable.f160249j94 : R.drawable.f160246e4);
                    view3 = view9;
                } else {
                    view3 = view2;
                }
                t(view3, context.getResources(), bundle2);
                z17 = z16;
                view5 = view3;
            }
            if (bundle2.getBoolean("v_crap_ctn", false)) {
                view5.getLayoutParams().width = -2;
            }
            if (bundle2.getBoolean("is_public_account_video_msg", false)) {
                this.mIsPAVideoStructMsg = true;
                if (!this.isMultiVideoItem) {
                    view5.setBackgroundDrawable(null);
                }
                if (!hasFlag(4)) {
                    view5.getLayoutParams().width = -2;
                }
            }
            view5.setId(R.id.j59);
            view5.setTag(R.id.j59, this);
            if (!z17) {
                view5.setBackgroundDrawable(null);
            }
            return view5;
        }
        View a16 = aj.a(context2, view7, anVar, bundle2);
        a16.setId(R.id.j59);
        a16.setTag(R.id.j59, this);
        if (!bundle2.getBoolean("isSubscript", false) && hasFlag(4)) {
            a16.setBackgroundResource(R.drawable.f160240dy);
        } else {
            a16.setBackgroundDrawable(null);
        }
        return a16;
    }

    public void initPay(Context context, MessageRecord messageRecord) {
        List<AbsStructMsgElement> list;
        ArrayList<AbsStructMsgElement> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) context, (Object) messageRecord);
            return;
        }
        this.havaPayInfoInit = true;
        if (context != null && (list = this.mStructMsgItemLists) != null) {
            for (AbsStructMsgElement absStructMsgElement : list) {
                if ((absStructMsgElement instanceof w) && (arrayList = ((w) absStructMsgElement).U0) != null) {
                    Iterator<AbsStructMsgElement> it = arrayList.iterator();
                    while (it.hasNext()) {
                        AbsStructMsgElement next = it.next();
                        if (next instanceof StructMsgItemButton) {
                            StructMsgItemButton structMsgItemButton = (StructMsgItemButton) next;
                            if (structMsgItemButton.O()) {
                                structMsgItemButton.N(messageRecord.getExtInfoFromExtStr(KEY_PAY_STAT + structMsgItemButton.f290434h1), messageRecord, this);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isPayMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        List<AbsStructMsgElement> list = this.mStructMsgItemLists;
        if (list != null) {
            for (AbsStructMsgElement absStructMsgElement : list) {
                if (absStructMsgElement instanceof w) {
                    Iterator<AbsStructMsgElement> it = ((w) absStructMsgElement).U0.iterator();
                    while (it.hasNext()) {
                        AbsStructMsgElement next = it.next();
                        if ((next instanceof StructMsgItemButton) && ((StructMsgItemButton) next).O()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    protected boolean layoutSupportNightMode(AbsStructMsgElement absStructMsgElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) absStructMsgElement)).booleanValue();
        }
        return h.f290426c.contains(absStructMsgElement.getClass().getName());
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    protected boolean parseContentNode(j jVar) {
        AbsStructMsgElement a16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        if (PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME.equals(jVar.f290428b)) {
            String a17 = jVar.a(TtmlNode.TAG_LAYOUT);
            try {
                if (!TextUtils.isEmpty(a17)) {
                    i3 = Integer.parseInt(a17);
                } else {
                    i3 = 0;
                }
                try {
                    if (this.mMsgServiceID == 91 && i3 == 21) {
                        i3 = 25;
                    }
                    a16 = h.c(i3);
                } catch (NumberFormatException unused) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(f290356d, 4, "Item layout value is " + i3);
                    }
                    return false;
                }
            } catch (NumberFormatException unused2) {
                i3 = 0;
            }
        } else {
            a16 = h.a(jVar.f290428b);
        }
        if (a16 == null) {
            return true;
        }
        a16.P0 = this;
        if (!a16.d(jVar)) {
            return false;
        }
        addItem(a16);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    public void parseMsgAttrubutes(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jVar);
        } else {
            super.parseMsgAttrubutes(jVar);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        AbsStructMsgElement a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) objectInput);
            return;
        }
        try {
            int readInt = objectInput.readInt();
            this.mVersion = readInt;
            if (readInt == 1) {
                this.mMsgTemplateID = objectInput.readInt();
                this.mMsgAction = objectInput.readUTF();
                this.mMsgActionData = objectInput.readUTF();
                this.mMsg_A_ActionData = objectInput.readUTF();
                this.mMsg_I_ActionData = objectInput.readUTF();
                this.mMsgUrl = objectInput.readUTF();
                this.mMsgBrief = objectInput.readUTF();
                this.mContentLayout = objectInput.readInt();
                this.mContentCover = objectInput.readUTF();
                this.mContentTitle = objectInput.readUTF();
                this.mContentSummary = objectInput.readUTF();
                com.tencent.mobileqq.structmsg.a c16 = h.c(this.mContentLayout);
                c16.m(new com.tencent.mobileqq.structmsg.view.c(this.mContentCover));
                c16.m(new StructMsgItemTitle(this.mContentTitle));
                c16.m(new ap(this.mContentSummary));
                addItem(c16);
                this.mSourceAppid = objectInput.readLong();
                this.mSourceIcon = objectInput.readUTF();
                this.mSourceName = objectInput.readUTF();
                this.mSourceUrl = objectInput.readUTF();
                this.mSourceAction = objectInput.readUTF();
                this.mSourceActionData = objectInput.readUTF();
                this.mSource_A_ActionData = objectInput.readUTF();
                this.mSource_I_ActionData = objectInput.readUTF();
                this.fwFlag = objectInput.readInt();
            } else if (readInt >= 2) {
                this.mMsgTemplateID = objectInput.readInt();
                this.mMsgAction = objectInput.readUTF();
                this.mMsgActionData = objectInput.readUTF();
                this.mMsg_A_ActionData = objectInput.readUTF();
                this.mMsg_I_ActionData = objectInput.readUTF();
                this.mMsgUrl = objectInput.readUTF();
                this.mMsgBrief = objectInput.readUTF();
                int readInt2 = objectInput.readInt();
                int i3 = 1;
                for (int i16 = 0; i16 < readInt2; i16++) {
                    String readUTF = objectInput.readUTF();
                    if (PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME.equals(readUTF)) {
                        int readInt3 = objectInput.readInt();
                        if (readInt3 == 2 && "micro_app".equals(this.mMsg_A_ActionData)) {
                            a16 = new com.tencent.mobileqq.structmsg.view.ah();
                        } else {
                            if (readInt3 == 1 && "viewMultiMsg".equalsIgnoreCase(this.mMsgAction)) {
                                readInt3 = 30;
                            }
                            a16 = h.c(readInt3);
                        }
                    } else {
                        a16 = h.a(readUTF);
                        if (a16 != null && com.tencent.mobileqq.structmsg.a.class.isInstance(a16)) {
                            objectInput.readInt();
                        }
                    }
                    if (a16 != null) {
                        a16.M0 = this.uin;
                        a16.P0 = this;
                        a16.i(objectInput);
                        com.tencent.mobileqq.structmsg.a aVar = (com.tencent.mobileqq.structmsg.a) a16;
                        if (aVar.U0.size() != 1 || !aVar.U0.get(0).f290322e.equals("hr")) {
                            a16.K0 = String.valueOf(i3);
                            i3++;
                        }
                        addItem(a16);
                        a16.j(this);
                    }
                }
                this.mSourceAppid = objectInput.readLong();
                this.mSourceIcon = objectInput.readUTF();
                this.mSourceName = objectInput.readUTF();
                this.mSourceUrl = objectInput.readUTF();
                this.mSourceAction = objectInput.readUTF();
                this.mSourceActionData = objectInput.readUTF();
                this.mSource_A_ActionData = objectInput.readUTF();
                this.mSource_I_ActionData = objectInput.readUTF();
                this.fwFlag = objectInput.readInt();
                this.mFlag = objectInput.readInt();
                this.mResid = objectInput.readUTF();
                this.mFileName = objectInput.readUTF();
                this.mFileSize = objectInput.readLong();
                this.mCommentText = objectInput.readUTF();
                if (readInt >= 3) {
                    this.mCompatibleText = objectInput.readUTF();
                    this.msgId = objectInput.readLong();
                    this.mPromotionType = objectInput.readInt();
                    this.mPromotionMsg = objectInput.readUTF();
                    this.mPromotionMenus = objectInput.readUTF();
                    this.mPromotionMenuDestructiveIndex = objectInput.readInt();
                    for (int i17 = 0; i17 < this.mStructMsgItemLists.size(); i17++) {
                        AbsStructMsgElement absStructMsgElement = this.mStructMsgItemLists.get(i17);
                        absStructMsgElement.L0 = this.msgId;
                        absStructMsgElement.N0 = this.mPromotionType;
                    }
                    if (readInt >= 4) {
                        this.dynamicMsgMergeKey = objectInput.readUTF();
                        this.dynamicMsgMergeIndex = objectInput.readInt();
                        if (readInt >= 5) {
                            this.source_puin = objectInput.readUTF();
                            if (readInt >= 6) {
                                this.mSType = objectInput.readUTF();
                                if (readInt >= 7) {
                                    this.adverSign = objectInput.readInt();
                                    this.adverKey = objectInput.readUTF();
                                    this.index = objectInput.readUTF();
                                    this.index_name = objectInput.readUTF();
                                    this.index_type = objectInput.readUTF();
                                    this.rijAlbumActionData = objectInput.readUTF();
                                    if (readInt >= 8) {
                                        this.mArticleIds = objectInput.readUTF();
                                        this.mOrangeWord = objectInput.readUTF();
                                        this.mAlgorithmIds = objectInput.readUTF();
                                        this.mStrategyIds = objectInput.readUTF();
                                        if (readInt >= 9) {
                                            this.mExtraData = objectInput.readUTF();
                                            this.mCreateTime = objectInput.readUTF();
                                            this.mTagName = objectInput.readUTF();
                                            if (readInt >= 10) {
                                                eventId = objectInput.readUTF();
                                                remindBrief = objectInput.readUTF();
                                                eventType = objectInput.readUTF();
                                                if (readInt >= 11) {
                                                    tips = objectInput.readUTF();
                                                    if (readInt >= 12) {
                                                        this.mInnerUniqIds = objectInput.readUTF();
                                                        if (readInt >= 13) {
                                                            this.mSourceThirdName = objectInput.readUTF();
                                                            this.mQQStoryExtra = objectInput.readUTF();
                                                            this.mNeedRound = objectInput.readUTF();
                                                            if (readInt >= 14) {
                                                                this.mQidianBulkTaskId = objectInput.readUTF();
                                                                this.reportEventFolderStatusValue = objectInput.readUTF();
                                                                if (readInt >= 15) {
                                                                    this.forwardType = objectInput.readInt();
                                                                    this.shareData.readExternal(objectInput);
                                                                    if (readInt >= 16 && readInt >= 17) {
                                                                        this.mAdSourceName = objectInput.readUTF();
                                                                        this.mCommonData = objectInput.readUTF();
                                                                        if (readInt >= 18) {
                                                                            this.animResId = objectInput.readUTF();
                                                                            this.atMembers = objectInput.readUTF();
                                                                            if (readInt >= 19) {
                                                                                this.mMergeSeq = objectInput.readUTF();
                                                                                this.mSortKey = objectInput.readLong();
                                                                                if (readInt >= 21) {
                                                                                    this.mTribeShortVideoExtra = objectInput.readUTF();
                                                                                    if (readInt >= 22) {
                                                                                        this.needSendLongMsgWhenFailed = objectInput.readBoolean();
                                                                                        if (readInt >= 23) {
                                                                                            this.mTSum = objectInput.readInt();
                                                                                            if (readInt >= 24) {
                                                                                                String readUTF2 = objectInput.readUTF();
                                                                                                if (!TextUtils.isEmpty(readUTF2)) {
                                                                                                    try {
                                                                                                        this.mDatas = new JSONObject(readUTF2);
                                                                                                    } catch (JSONException unused) {
                                                                                                        this.mDatas = null;
                                                                                                    }
                                                                                                } else {
                                                                                                    this.mDatas = null;
                                                                                                }
                                                                                                if (readInt >= 25) {
                                                                                                    this.mAdSourceMenu = objectInput.readUTF();
                                                                                                    if (readInt >= 27) {
                                                                                                        this.pobingTemplateId = objectInput.readInt();
                                                                                                        if (readInt >= 28) {
                                                                                                            this.mQzoneExtraMsg = objectInput.readUTF();
                                                                                                            if (readInt >= 29) {
                                                                                                                this.mBirthReminder = objectInput.readUTF();
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                this.mMsgException = true;
            }
            if (!this.mHasSource && (!TextUtils.isEmpty(this.mSourceName) || !TextUtils.isEmpty(this.mSourceIcon))) {
                this.mHasSource = true;
            }
            if (!this.mHasAdSource && !TextUtils.isEmpty(this.mAdSourceName)) {
                this.mHasAdSource = true;
            }
            String str = this.mSourceName;
            if (str != null) {
                if (str.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.f172741tw2))) {
                    this.mMsgServiceID = 54;
                } else if (this.mSourceName.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.c08))) {
                    this.mMsgServiceID = 53;
                }
            }
        } catch (IOException e16) {
            if (e16.getMessage() != null && e16.getMessage().equals("structmsg_version_error")) {
                this.mMsgException = true;
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    public void report(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, obj);
            return;
        }
        jq3.a.n("1", this.uinType, this.mContentTitle, this.mSourceAppid);
        if (IPublicAccountUtil.UIN_FOR_WALLET.equals(this.uin) && this.message != null) {
            ReportController.o(null, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "public.message.show", 0, 0, this.message.time + "", "", "", this.mMsgBrief);
            if (!TextUtils.isEmpty(this.mBirthReminder)) {
                ReportController.o(null, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "public.birthmessage.show", 0, 0, NetConnInfoCenter.getServerTimeMillis() + "", "", "", "");
            }
        }
    }

    public void savePayInfo(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, context, str, Integer.valueOf(i3));
            return;
        }
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (this.message != null && runtime != null && !TextUtils.isEmpty(str)) {
                this.message.saveExtInfoToExtStr(KEY_PAY_STAT + str, "" + i3);
                if (context instanceof BaseActivity) {
                    ((BaseActivity) context).getChatFragment().qh().f25585j.notifyDataSetChanged();
                }
                ThreadManagerV2.post(new Runnable(runtime) { // from class: com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.6
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AppRuntime f290362d;

                    {
                        this.f290362d = runtime;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StructMsgForGeneralShare.this, (Object) runtime);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QQMessageFacade messageFacade = ((QQAppInterface) this.f290362d).getMessageFacade();
                        MessageRecord messageRecord = StructMsgForGeneralShare.this.message;
                        messageFacade.a1(messageRecord.frienduin, messageRecord.msgtype, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
                    }
                }, 5, null, false);
            }
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f290356d, 4, "savePayInfo error " + e16.getMessage());
            }
        }
    }

    @Deprecated
    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        AbsStructMsgElement findXmlNode = findXmlNode("progress");
        if (findXmlNode != null && (findXmlNode instanceof com.tencent.mobileqq.structmsg.view.an)) {
            ((com.tencent.mobileqq.structmsg.view.an) findXmlNode).n(i3);
        }
    }

    @Deprecated
    public void setSummary(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        AbsStructMsgElement findXmlNode = findXmlNode("summary");
        if (findXmlNode != null && (findXmlNode instanceof ap)) {
            ((ap) findXmlNode).E(str);
        }
    }

    @Deprecated
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        AbsStructMsgElement findXmlNode = findXmlNode("title");
        if (findXmlNode != null && (findXmlNode instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle) findXmlNode).E(str);
        }
    }

    protected boolean supportNightMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        Iterator<AbsStructMsgElement> it = this.mStructMsgItemLists.iterator();
        while (it.hasNext()) {
            if (!layoutSupportNightMode(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void symbol2CharactorForSmallEmoji(AbsStructMsgElement absStructMsgElement) {
        ArrayList<AbsStructMsgElement> arrayList;
        WeakReference<Context> weakReference;
        QQAppInterface qQAppInterface;
        int i3;
        Emoticon emoticon;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) absStructMsgElement);
            return;
        }
        if (absStructMsgElement != null && (absStructMsgElement instanceof u) && (arrayList = ((u) absStructMsgElement).U0) != null && arrayList.size() != 0) {
            Iterator<AbsStructMsgElement> it = arrayList.iterator();
            ap apVar = null;
            while (it.hasNext()) {
                AbsStructMsgElement next = it.next();
                if (next instanceof ap) {
                    apVar = (ap) next;
                }
            }
            if (apVar == null) {
                return;
            }
            String t16 = apVar.t();
            if (!TextUtils.isEmpty(t16) && (weakReference = this.mContext) != null && weakReference.get() != null && (this.mContext.get() instanceof BaseActivity)) {
                ChatFragment chatFragment = ((BaseActivity) this.mContext.get()).getChatFragment();
                if (chatFragment != null) {
                    qQAppInterface = chatFragment.ph();
                } else {
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (runtime != null && (runtime instanceof QQAppInterface)) {
                        qQAppInterface = (QQAppInterface) runtime;
                    } else {
                        qQAppInterface = null;
                    }
                }
                if (qQAppInterface == null) {
                    return;
                }
                IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class);
                StringBuilder sb5 = new StringBuilder(t16);
                int i16 = 0;
                while (i16 < sb5.length()) {
                    if ('\u00ff' == sb5.charAt(i16) && (i3 = i16 + 3) < sb5.length()) {
                        char[] cArr = new char[4];
                        cArr[0] = sb5.charAt(i3);
                        cArr[1] = sb5.charAt(i16 + 2);
                        cArr[2] = sb5.charAt(i16 + 1);
                        cArr[3] = sb5.charAt(i16);
                        for (int i17 = 0; i17 < 4; i17++) {
                            char c16 = cArr[i17];
                            if (c16 == '\u00fa') {
                                cArr[i17] = '\n';
                            } else if (c16 == '\u00fe') {
                                cArr[i17] = '\r';
                            } else if (c16 == '\u00fd') {
                                cArr[i17] = 20;
                            }
                        }
                        int[] r16 = com.tencent.mobileqq.emosm.e.r(cArr);
                        String str = AbsQQText.SMALL_EMOJI_SYMBOL;
                        if (iEmoticonManagerService != null) {
                            emoticon = iEmoticonManagerService.syncFindEmoticonById(Integer.toString(r16[0]), Integer.toString(r16[1]));
                        } else {
                            emoticon = null;
                        }
                        if (emoticon != null) {
                            str = emoticon.character;
                        }
                        sb5.replace(i16, i3, str);
                        i16 += str.length();
                    }
                    i16++;
                }
                if (!TextUtils.isEmpty(sb5)) {
                    apVar.E(sb5.toString());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    protected void toContentXml(AbsStructMsg.a aVar) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        Iterator<AbsStructMsgElement> it = iterator();
        while (it.hasNext()) {
            it.next().k(aVar);
        }
        if (this.mMsgServiceID == 128 && this.mDatas != null) {
            aVar.startTag(null, "data");
            aVar.attribute(null, "groupcode", this.mDatas.optString("groupcode"));
            aVar.attribute(null, FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME, this.mDatas.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME));
            aVar.attribute(null, AppConstants.Key.COLUMN_MSG_SEQ, this.mDatas.optString(AppConstants.Key.COLUMN_MSG_SEQ));
            aVar.attribute(null, AppConstants.Key.COLUMN_MSG_TYPE, this.mDatas.optString(AppConstants.Key.COLUMN_MSG_TYPE));
            aVar.endTag(null, "data");
        }
    }

    public void unInitPay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.havaPayInfoInit = false;
            this.mHadPaidList = new ArrayList();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    public void updateCover(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
            return;
        }
        super.updateCover(str);
        for (AbsStructMsgElement absStructMsgElement : this.mStructMsgItemLists) {
            if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a) {
                Iterator<AbsStructMsgElement> it = ((com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0.iterator();
                while (it.hasNext()) {
                    AbsStructMsgElement next = it.next();
                    if (next instanceof com.tencent.mobileqq.structmsg.view.c) {
                        ((com.tencent.mobileqq.structmsg.view.c) next).S0 = str;
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    public void updateTitleSummaryAndCover(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, str2, str3);
            return;
        }
        super.updateTitleSummaryAndCover(str, str2, str3);
        for (AbsStructMsgElement absStructMsgElement : this.mStructMsgItemLists) {
            if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a) {
                Iterator<AbsStructMsgElement> it = ((com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0.iterator();
                while (it.hasNext()) {
                    AbsStructMsgElement next = it.next();
                    if (next instanceof StructMsgItemTitle) {
                        ((StructMsgItemTitle) next).X0 = str;
                    } else if (next instanceof ap) {
                        ((ap) next).X0 = str2;
                    } else if (next instanceof com.tencent.mobileqq.structmsg.view.c) {
                        ((com.tencent.mobileqq.structmsg.view.c) next).S0 = str3;
                    }
                }
            }
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        String jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) objectOutput);
            return;
        }
        objectOutput.writeInt(this.mMsgServiceID);
        objectOutput.writeInt(this.mVersion);
        objectOutput.writeInt(this.mMsgTemplateID);
        String str = this.mMsgAction;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        String str3 = this.mMsgActionData;
        if (str3 == null) {
            str3 = "";
        }
        objectOutput.writeUTF(str3);
        String str4 = this.mMsg_A_ActionData;
        if (str4 == null) {
            str4 = "";
        }
        objectOutput.writeUTF(str4);
        String str5 = this.mMsg_I_ActionData;
        if (str5 == null) {
            str5 = "";
        }
        objectOutput.writeUTF(str5);
        String str6 = this.mMsgUrl;
        if (str6 == null) {
            str6 = "";
        }
        objectOutput.writeUTF(str6);
        String str7 = this.mMsgBrief;
        if (str7 == null) {
            str7 = "";
        }
        objectOutput.writeUTF(str7);
        objectOutput.writeInt(getItemCount());
        Iterator<AbsStructMsgElement> it = iterator();
        while (it.hasNext()) {
            it.next().l(objectOutput);
        }
        objectOutput.writeLong(this.mSourceAppid);
        String str8 = this.mSourceIcon;
        if (str8 == null) {
            str8 = "";
        }
        objectOutput.writeUTF(str8);
        String str9 = this.mSourceName;
        if (str9 == null) {
            str9 = "";
        }
        objectOutput.writeUTF(str9);
        String str10 = this.mSourceUrl;
        if (str10 == null) {
            str10 = "";
        }
        objectOutput.writeUTF(str10);
        String str11 = this.mSourceAction;
        if (str11 == null) {
            str11 = "";
        }
        objectOutput.writeUTF(str11);
        String str12 = this.mSourceActionData;
        if (str12 == null) {
            str12 = "";
        }
        objectOutput.writeUTF(str12);
        String str13 = this.mSource_A_ActionData;
        if (str13 == null) {
            str13 = "";
        }
        objectOutput.writeUTF(str13);
        String str14 = this.mSource_I_ActionData;
        if (str14 == null) {
            str14 = "";
        }
        objectOutput.writeUTF(str14);
        objectOutput.writeInt(this.fwFlag);
        objectOutput.writeInt(this.mFlag);
        String str15 = this.mResid;
        if (str15 == null) {
            str15 = "";
        }
        objectOutput.writeUTF(str15);
        String str16 = this.mFileName;
        if (str16 == null) {
            str16 = "";
        }
        objectOutput.writeUTF(str16);
        objectOutput.writeLong(this.mFileSize);
        String str17 = this.mCommentText;
        if (str17 == null) {
            str17 = "";
        }
        objectOutput.writeUTF(str17);
        String str18 = this.mCompatibleText;
        if (str18 == null) {
            str18 = "";
        }
        objectOutput.writeUTF(str18);
        objectOutput.writeLong(this.msgId);
        objectOutput.writeInt(this.mPromotionType);
        String str19 = this.mPromotionMsg;
        if (str19 == null) {
            str19 = "";
        }
        objectOutput.writeUTF(str19);
        String str20 = this.mPromotionMenus;
        if (str20 == null) {
            str20 = "";
        }
        objectOutput.writeUTF(str20);
        objectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
        String str21 = this.dynamicMsgMergeKey;
        if (str21 == null) {
            str21 = "";
        }
        objectOutput.writeUTF(str21);
        objectOutput.writeInt(this.dynamicMsgMergeIndex);
        String str22 = this.source_puin;
        if (str22 == null) {
            str22 = "";
        }
        objectOutput.writeUTF(str22);
        String str23 = this.mSType;
        if (str23 == null) {
            str23 = "";
        }
        objectOutput.writeUTF(str23);
        objectOutput.writeInt(this.adverSign);
        String str24 = this.adverKey;
        if (str24 == null) {
            str24 = "";
        }
        objectOutput.writeUTF(str24);
        String str25 = this.index;
        if (str25 == null) {
            str25 = "";
        }
        objectOutput.writeUTF(str25);
        String str26 = this.index_name;
        if (str26 == null) {
            str26 = "";
        }
        objectOutput.writeUTF(str26);
        String str27 = this.index_type;
        if (str27 == null) {
            str27 = "";
        }
        objectOutput.writeUTF(str27);
        String str28 = this.rijAlbumActionData;
        if (str28 == null) {
            str28 = "";
        }
        objectOutput.writeUTF(str28);
        String str29 = this.mArticleIds;
        if (str29 == null) {
            str29 = "";
        }
        objectOutput.writeUTF(str29);
        String str30 = this.mOrangeWord;
        if (str30 == null) {
            str30 = "";
        }
        objectOutput.writeUTF(str30);
        String str31 = this.mAlgorithmIds;
        if (str31 == null) {
            str31 = "";
        }
        objectOutput.writeUTF(str31);
        String str32 = this.mStrategyIds;
        if (str32 == null) {
            str32 = "";
        }
        objectOutput.writeUTF(str32);
        String str33 = this.mExtraData;
        if (str33 == null) {
            str33 = "";
        }
        objectOutput.writeUTF(str33);
        String str34 = this.mCreateTime;
        if (str34 == null) {
            str34 = "";
        }
        objectOutput.writeUTF(str34);
        String str35 = this.mTagName;
        if (str35 == null) {
            str35 = "";
        }
        objectOutput.writeUTF(str35);
        String str36 = eventId;
        if (str36 == null) {
            str36 = "";
        }
        objectOutput.writeUTF(str36);
        String str37 = remindBrief;
        if (str37 == null) {
            str37 = "";
        }
        objectOutput.writeUTF(str37);
        String str38 = eventType;
        if (str38 == null) {
            str38 = "";
        }
        objectOutput.writeUTF(str38);
        String str39 = tips;
        if (str39 == null) {
            str39 = "";
        }
        objectOutput.writeUTF(str39);
        String str40 = this.mInnerUniqIds;
        if (str40 == null) {
            str40 = "";
        }
        objectOutput.writeUTF(str40);
        String str41 = this.mSourceThirdName;
        if (str41 == null) {
            str41 = "";
        }
        objectOutput.writeUTF(str41);
        String str42 = this.mQQStoryExtra;
        if (str42 == null) {
            str42 = "";
        }
        objectOutput.writeUTF(str42);
        String str43 = this.mNeedRound;
        if (str43 == null) {
            str43 = "";
        }
        objectOutput.writeUTF(str43);
        String str44 = this.mQidianBulkTaskId;
        if (str44 == null) {
            str44 = "";
        }
        objectOutput.writeUTF(str44);
        String str45 = this.reportEventFolderStatusValue;
        if (str45 == null) {
            str45 = "";
        }
        objectOutput.writeUTF(str45);
        objectOutput.writeInt(this.forwardType);
        this.shareData.writeExternal(objectOutput);
        String str46 = this.mAdSourceName;
        if (str46 == null) {
            str46 = "";
        }
        objectOutput.writeUTF(str46);
        String str47 = this.mCommonData;
        if (str47 == null) {
            str47 = "";
        }
        objectOutput.writeUTF(str47);
        String str48 = this.animResId;
        if (str48 == null) {
            str48 = "";
        }
        objectOutput.writeUTF(str48);
        String str49 = this.atMembers;
        if (str49 == null) {
            str49 = "";
        }
        objectOutput.writeUTF(str49);
        String str50 = this.mMergeSeq;
        if (str50 == null) {
            str50 = "";
        }
        objectOutput.writeUTF(str50);
        objectOutput.writeLong(this.mSortKey);
        String str51 = this.mTribeShortVideoExtra;
        if (str51 == null) {
            str51 = "";
        }
        objectOutput.writeUTF(str51);
        objectOutput.writeBoolean(this.needSendLongMsgWhenFailed);
        objectOutput.writeInt(this.mTSum);
        JSONObject jSONObject2 = this.mDatas;
        if (jSONObject2 == null) {
            jSONObject = "";
        } else {
            jSONObject = jSONObject2.toString();
        }
        objectOutput.writeUTF(jSONObject);
        String str52 = this.mAdSourceMenu;
        if (str52 == null) {
            str52 = "";
        }
        objectOutput.writeUTF(str52);
        objectOutput.writeInt(this.pobingTemplateId);
        String str53 = this.mQzoneExtraMsg;
        if (str53 == null) {
            str53 = "";
        }
        objectOutput.writeUTF(str53);
        String str54 = this.mBirthReminder;
        if (str54 != null) {
            str2 = str54;
        }
        objectOutput.writeUTF(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StructMsgForGeneralShare(Bundle bundle) {
        super(bundle);
        com.tencent.mobileqq.structmsg.a c16;
        com.tencent.mobileqq.structmsg.a aVar;
        String str;
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        this.havaPayInfoInit = false;
        this.mHadPaidList = new ArrayList();
        this.mExpandView = new WeakReference<>(null);
        this.mContext = new WeakReference<>(null);
        this.mWarningTips = "";
        this.mPARedPacket = "";
        this.mIsPAVideoStructMsg = false;
        this.mVipDonateStr = "";
        this.isMultiVideoItem = false;
        this.pobingTemplateId = 2000;
        this.needSendLongMsgWhenFailed = false;
        this.mContentLayout = 2;
        this.mMsgServiceID = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
        this.mNeedRound = bundle.getString(AppConstants.Key.KEY_ICON_NEED_ROUND);
        String str2 = this.mSourceName;
        if (str2 != null) {
            if (str2.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.tvy))) {
                this.mMsgServiceID = 54;
            } else if (this.mSourceName.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.c08))) {
                this.mMsgServiceID = 53;
            }
        }
        String string = bundle.getString(AppConstants.Key.KEY_NEW_SHARE_SERVICE_ID);
        if (!TextUtils.isEmpty(string) && TextUtils.isDigitsOnly(string) && ((parseInt = Integer.parseInt(string)) == 83 || parseInt == 108 || parseInt == 114 || parseInt == 116 || parseInt == 123)) {
            this.mMsgServiceID = parseInt;
        }
        this.mCreateTime = bundle.getString(AppConstants.Key.SHARE_REQ_CREATE_TIME);
        String string2 = bundle.getString("source_puin");
        this.source_puin = TextUtils.isEmpty(string2) ? "" : string2;
        this.mSourceUrl = bundle.getString(AppConstants.Key.SHARE_SOURCE_URL);
        this.rijAlbumActionData = bundle.getString(AppConstants.Key.SHARE_READINJOY_GALLERY);
        if (TextUtils.isEmpty(this.mSourceUrl)) {
            this.mSourceUrl = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL);
        }
        String string3 = bundle.getString("detail_url");
        String string4 = bundle.getString("category");
        String string5 = bundle.getString("video_url");
        boolean z16 = bundle.getBoolean(AppConstants.Key.SHARE_VIDEO_SHOULD_LOAD, false);
        int i3 = TextUtils.isEmpty(string5) ? bundle.getInt(AppConstants.Key.SHARE_LAYOUT_ITEM, 2) : 5;
        if ("web".equals(this.mMsgAction) && "micro_app".equals(this.mMsg_A_ActionData)) {
            c16 = new com.tencent.mobileqq.structmsg.view.ah();
        } else {
            c16 = h.c(i3);
        }
        com.tencent.mobileqq.structmsg.a aVar2 = c16;
        if (!TextUtils.isEmpty(string4)) {
            com.tencent.mobileqq.structmsg.a c17 = h.c(0);
            c17.C(1);
            c17.s(string4);
            addItem(c17);
            if (TextUtils.isEmpty(string5)) {
                aVar2.p(this.mContentCover, this.mContentTitle, this.mContentSummary, 1);
            } else {
                r(aVar2, z16, string3, this.mContentCover, string5, this.mContentTitle, this.mContentSummary, bundle);
                aVar2.R0 = 1;
            }
        } else if (this.mMsgServiceID == 118 && (str = this.mSourceName) != null && str.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.tvw))) {
            aVar2.n(this.mContentCover, this.mContentTitle, 0, this.mNeedRound);
        } else {
            if (TextUtils.isEmpty(string5)) {
                aVar = aVar2;
                aVar2.q(this.mContentCover, this.mContentTitle, this.mContentSummary, 0, this.mNeedRound);
            } else {
                aVar = aVar2;
                r(aVar, z16, string3, this.mContentCover, string5, this.mContentTitle, this.mContentSummary, bundle);
                aVar.R0 = 0;
            }
            this.needSendLongMsgWhenFailed = bundle.getBoolean(AppConstants.Key.NEED_SEND_LONG_MSG_WHEN_FAILED, false);
            addItem(aVar);
            if (this.mMsgAction != null) {
                this.mMsgAction = "web";
                return;
            }
            return;
        }
        aVar = aVar2;
        this.needSendLongMsgWhenFailed = bundle.getBoolean(AppConstants.Key.NEED_SEND_LONG_MSG_WHEN_FAILED, false);
        addItem(aVar);
        if (this.mMsgAction != null) {
        }
    }

    StructMsgForGeneralShare(j jVar) {
        super(jVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jVar);
            return;
        }
        this.havaPayInfoInit = false;
        this.mHadPaidList = new ArrayList();
        this.mExpandView = new WeakReference<>(null);
        this.mContext = new WeakReference<>(null);
        this.mWarningTips = "";
        this.mPARedPacket = "";
        this.mIsPAVideoStructMsg = false;
        this.mVipDonateStr = "";
        this.isMultiVideoItem = false;
        this.pobingTemplateId = 2000;
        this.needSendLongMsgWhenFailed = false;
        this.mWarningTips = jVar.a("warningTipsContent");
        this.mPARedPacket = jVar.a("paRedPacket");
        this.mVipDonateStr = jVar.a("vipDonate");
        eventId = jVar.a("eventId");
        remindBrief = jVar.a("remindBrief");
        eventType = jVar.a("eventType");
        this.animResId = jVar.a("resid");
        tips = jVar.a("tips");
        this.atMembers = jVar.a("atmembers");
    }
}
