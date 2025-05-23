package com.tencent.mobileqq.structmsg;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.an;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IPictureBusinessApi;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.util.BinderWarpper;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.util.Iterator;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StructMsgForImageShare extends AbsShareMsg {
    static IPatchRedirector $redirector_ = null;
    public static final String BRIEF_PREFIX = "[\u5206\u4eab]";
    public static final int SHARE_IMAGE_FREVIEW_MAX_SZIE = 140;

    /* renamed from: d, reason: collision with root package name */
    private static View.OnClickListener f290371d;
    public String bigUrl;
    public int height;
    public int mImageBizType;
    public int mIsSend;
    public int mMsgType;
    public long mUniseq;
    public String rawUrl;
    public int thumbHeight;
    public String thumbUrl;
    public int thumbWidth;
    public int width;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75499);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f290371d = new View.OnClickListener() { // from class: com.tencent.mobileqq.structmsg.StructMsgForImageShare.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:120:0x0336  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0123  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onClick(View view) {
                    Context context;
                    com.tencent.mobileqq.structmsg.view.e firstImageElement;
                    boolean z16;
                    Context context2;
                    AIOImageData aIOImageData;
                    AIOImageProviderService aIOImageProviderService;
                    String str;
                    MessageForPic messageForPic;
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        View findViewById = view.findViewById(R.id.j59);
                        if (findViewById != null) {
                            Object tag = findViewById.getTag(R.id.j59);
                            if (tag instanceof StructMsgForImageShare) {
                                StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) tag;
                                Context context3 = findViewById.getContext();
                                try {
                                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getAppRuntime(structMsgForImageShare.currentAccountUin);
                                    AbsShareMsg.doReport(qQAppInterface, structMsgForImageShare);
                                    long j3 = structMsgForImageShare.msgId;
                                    if (j3 > 0) {
                                        context = context3;
                                        try {
                                            ReportController.o(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, structMsgForImageShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(j3), "");
                                            ThreadManager.getSubThreadHandler().postDelayed(new Runnable(structMsgForImageShare, qQAppInterface) { // from class: com.tencent.mobileqq.structmsg.StructMsgForImageShare.2.1
                                                static IPatchRedirector $redirector_;

                                                /* renamed from: d, reason: collision with root package name */
                                                final /* synthetic */ StructMsgForImageShare f290378d;

                                                /* renamed from: e, reason: collision with root package name */
                                                final /* synthetic */ QQAppInterface f290379e;

                                                {
                                                    this.f290378d = structMsgForImageShare;
                                                    this.f290379e = qQAppInterface;
                                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                        iPatchRedirector2.redirect((short) 1, this, AnonymousClass2.this, structMsgForImageShare, qQAppInterface);
                                                    }
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                                        return;
                                                    }
                                                    long serverTime = NetConnInfoCenter.getServerTime();
                                                    com.tencent.mobileqq.activity.aio.rebuild.c.y(this.f290378d.uin, this.f290379e);
                                                    IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                                    QQAppInterface qQAppInterface2 = this.f290379e;
                                                    String str2 = this.f290378d.uin;
                                                    String l3 = Long.toString(serverTime);
                                                    String l16 = Long.toString(this.f290378d.msgId);
                                                    StructMsgForImageShare structMsgForImageShare2 = this.f290378d;
                                                    iPublicAccountReportUtils.publicAccountReportClickEventForMigrate(qQAppInterface2, "CliOper", "", str2, "0X80055C7", "0X80055C7", 0, 0, l3, l16, structMsgForImageShare2.mMsgAction, Integer.toString(structMsgForImageShare2.mPromotionType), false);
                                                }
                                            }, 0L);
                                        } catch (AccountNotMatchException e16) {
                                            e = e16;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("StructMsg", 2, e.getStackTrace().toString());
                                            }
                                            ReportController.o(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, structMsgForImageShare.mMsgServiceID + "", "", "", "");
                                            ReportController.o(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
                                            firstImageElement = structMsgForImageShare.getFirstImageElement();
                                            if (firstImageElement == null) {
                                            }
                                            boolean z17 = z16;
                                            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, structMsgForImageShare.uin, "0X80055C7", "0X80055C7", 0, z17 ? 1 : 0, "" + structMsgForImageShare.msgId, "" + structMsgForImageShare.templateIDForPortal, "", structMsgForImageShare.mMsgUrl);
                                            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, structMsgForImageShare.uin, "0X8005D49", "0X8005D49", 0, z17 ? 1 : 0, "MSGID=" + Long.toString(structMsgForImageShare.msgId) + ";TEPLATEID=" + structMsgForImageShare.templateIDForPortal + ";ARTICALID=;REFERRER=" + AbsStructMsgElement.e(structMsgForImageShare.mMsgUrl), "", "", "");
                                            EventCollector.getInstance().onViewClicked(view);
                                        }
                                    } else {
                                        context = context3;
                                    }
                                    if (structMsgForImageShare.getFirstImageElement() != null && structMsgForImageShare.getFirstImageElement().n()) {
                                        jq3.a.d(structMsgForImageShare.uinType, structMsgForImageShare.mSourceAppid, structMsgForImageShare.getTitleFromBrief());
                                    }
                                } catch (AccountNotMatchException e17) {
                                    e = e17;
                                    context = context3;
                                }
                                ReportController.o(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, structMsgForImageShare.mMsgServiceID + "", "", "", "");
                                ReportController.o(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
                                firstImageElement = structMsgForImageShare.getFirstImageElement();
                                if (firstImageElement == null) {
                                    if (!com.tencent.mobileqq.service.message.remote.a.c(structMsgForImageShare.mIsSend) && (messageForPic = firstImageElement.f290638c1) != null) {
                                        context2 = context;
                                        URLDrawable d16 = com.tencent.mobileqq.activity.aio.item.i.d(context2, messageForPic);
                                        if (d16 != null) {
                                            if (d16.getStatus() == 2) {
                                                d16.restartDownload();
                                            } else if (d16.getStatus() == 0 && !d16.isDownloadStarted()) {
                                                d16.startDownload();
                                            }
                                        }
                                    } else {
                                        context2 = context;
                                    }
                                    MessageForPic messageForPic2 = firstImageElement.f290638c1;
                                    if (messageForPic2 != null) {
                                        String str2 = messageForPic2.selfuin;
                                        if (messageForPic2.isMultiMsg) {
                                            try {
                                                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                                                if (waitAppRuntime instanceof QQAppInterface) {
                                                    str2 = waitAppRuntime.getAccount();
                                                }
                                            } catch (Exception unused) {
                                            }
                                        }
                                        String str3 = str2;
                                        AIOImageProviderService aIOImageProviderService2 = new AIOImageProviderService(str3, messageForPic2.frienduin, messageForPic2.istroop, messageForPic2);
                                        AIOImageData t16 = com.tencent.mobileqq.activity.aio.photo.c.t(messageForPic2);
                                        MessageRecord messageRecord = structMsgForImageShare.message;
                                        if (messageRecord != null) {
                                            t16.f179630f = messageRecord.time;
                                            t16.f179632i = messageRecord.shmsgseq;
                                        }
                                        String str4 = structMsgForImageShare.mMsgActionData;
                                        if (str4 != null && str4.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID)) {
                                            t16.Y = 1;
                                            t16.Z = structMsgForImageShare.getBytes();
                                            String[] parseQQComicParams = ((IPictureBusinessApi) QRoute.api(IPictureBusinessApi.class)).parseQQComicParams(structMsgForImageShare);
                                            t16.f179575f0 = com.tencent.mobileqq.richmediabrowser.j.c(parseQQComicParams);
                                            if (parseQQComicParams != null && parseQQComicParams.length >= 8) {
                                                if (parseQQComicParams[7].equals(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)) {
                                                    str = parseQQComicParams[4];
                                                } else if (!parseQQComicParams[7].equals("scrawl_link") || parseQQComicParams.length < 9) {
                                                    str = "";
                                                } else {
                                                    str = parseQQComicParams[8];
                                                }
                                                aIOImageData = t16;
                                                aIOImageProviderService = aIOImageProviderService2;
                                                z16 = true;
                                                ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(null, str3, context2, "3009", "2", "40054", parseQQComicParams[0], parseQQComicParams[2], parseQQComicParams[4], str);
                                            } else {
                                                aIOImageData = t16;
                                                aIOImageProviderService = aIOImageProviderService2;
                                                z16 = true;
                                            }
                                        } else {
                                            aIOImageData = t16;
                                            aIOImageProviderService = aIOImageProviderService2;
                                            z16 = true;
                                            String str5 = structMsgForImageShare.mMsgActionData;
                                            if (str5 != null && str5.startsWith("ScreenShotShare")) {
                                                aIOImageData.Y = 2;
                                                aIOImageData.Z = structMsgForImageShare.getBytes();
                                                if (com.tencent.mobileqq.service.message.remote.a.c(messageForPic2.issend) && !TextUtils.isEmpty(messageForPic2.path) && new File(messageForPic2.path).exists()) {
                                                    aIOImageData.G = messageForPic2.path;
                                                }
                                            } else if (structMsgForImageShare.mImageBizType == 2) {
                                                if (com.tencent.mobileqq.service.message.remote.a.c(messageForPic2.issend) && !TextUtils.isEmpty(messageForPic2.path) && TextUtils.isEmpty(messageForPic2.md5) && new File(messageForPic2.path).exists()) {
                                                    aIOImageData.G = messageForPic2.path;
                                                }
                                                aIOImageData.Y = 4;
                                            } else if (((IGameShareUtil) QRoute.api(IGameShareUtil.class)).isGameShare(structMsgForImageShare)) {
                                                aIOImageData.Y = 5;
                                                ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).convertDataForGallery(aIOImageData, structMsgForImageShare);
                                            }
                                        }
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(aIOImageProviderService.asBinder()));
                                        bundle.putParcelable(RichMediaBrowserConstants.INTERNAL_EXTRA_CURRENT_IMAGE, aIOImageData);
                                        bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, structMsgForImageShare.uinType);
                                        if ((context2 instanceof SplashActivity) || (context2 instanceof ChatActivity) || (context2 instanceof PublicFragmentActivity)) {
                                            if (context2 instanceof MultiForwardActivity) {
                                                AppInterface appInterface = ((BaseActivity) context2).getAppInterface();
                                                if (appInterface instanceof QQAppInterface) {
                                                    bundle.putBoolean(RichMediaBrowserConstants.EXTRA_FROM_AIO, z16);
                                                    bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
                                                    bundle.putString("uin", ((MultiForwardActivity) context2).getChatFragment().qh().m().f179557e);
                                                    String string = bundle.getString("extra.GROUP_UIN");
                                                    if (string != null && ((QQAppInterface) appInterface).getTroopMask(string) == GroupMsgMask.ASSISTANT) {
                                                        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
                                                    }
                                                }
                                            } else {
                                                bundle.putBoolean(RichMediaBrowserConstants.EXTRA_FROM_AIO, z16);
                                                bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity) context2).getClass().getName());
                                            }
                                        }
                                    } else {
                                        z16 = true;
                                    }
                                } else {
                                    z16 = false;
                                }
                                boolean z172 = z16;
                                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, structMsgForImageShare.uin, "0X80055C7", "0X80055C7", 0, z172 ? 1 : 0, "" + structMsgForImageShare.msgId, "" + structMsgForImageShare.templateIDForPortal, "", structMsgForImageShare.mMsgUrl);
                                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, structMsgForImageShare.uin, "0X8005D49", "0X8005D49", 0, z172 ? 1 : 0, "MSGID=" + Long.toString(structMsgForImageShare.msgId) + ";TEPLATEID=" + structMsgForImageShare.templateIDForPortal + ";ARTICALID=;REFERRER=" + AbsStructMsgElement.e(structMsgForImageShare.mMsgUrl), "", "", "");
                            }
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StructMsgForImageShare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsSend = 1;
        this.mUniseq = 0L;
        this.mMsgType = 0;
        this.mImageBizType = 0;
        this.mMsgServiceID = 5;
    }

    public static boolean resendAndUploadImageShare(QQAppInterface qQAppInterface, MessageRecord messageRecord, StructMsgForImageShare structMsgForImageShare) {
        if (structMsgForImageShare == null) {
            return false;
        }
        com.tencent.mobileqq.structmsg.view.e firstImageElement = structMsgForImageShare.getFirstImageElement();
        if (firstImageElement == null) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
            }
            return false;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        MessageRecord n3 = q.n(messageRecord);
        qQAppInterface.getMessageFacade().c(n3, currentAccountUin);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = currentAccountUin;
        transferRequest.mPeerUin = messageRecord.frienduin;
        transferRequest.mUinType = messageRecord.istroop;
        transferRequest.mFileType = 1;
        transferRequest.mUniseq = n3.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mBusiType = 1030;
        transferRequest.mLocalPath = firstImageElement.R0;
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
    
        if (com.tencent.mobileqq.utils.aw.c(4, r15, r17, r13, true, r16, r18) == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String scaleLocalImage(Context context, ImageInfo imageInfo, String str, int i3) {
        String str2;
        if (context == null || imageInfo == null || str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "handleAppShareAction mShareImageUrl NULL!!!");
            }
            return null;
        }
        try {
            if (!GifDrawable.isGifFile(file) || file.length() >= 12582912) {
                String str3 = g.f290423q4;
                File file2 = new File(str3);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                str2 = str3 + System.currentTimeMillis() + ".jpg";
                try {
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        QLog.d("StructMsg", 2, e.getMessage());
                    }
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
            }
            str2 = str;
        } catch (Exception e17) {
            e = e17;
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                SafeBitmapFactory.decodeFile(str, options);
                int i16 = options.outWidth;
                int i17 = options.outHeight;
                SafeBitmapFactory.decodeFile(str2, options);
                int i18 = options.outWidth;
                int i19 = options.outHeight;
                QLog.d("StructMsg", 2, "srcBmp = " + str + ", length = " + new File(str).length() + ", srcWidth = " + i16 + ", srcHeight = " + i17 + ", destBmp = " + str2 + ", length = " + new File(str2).length() + ", destWidth = " + i18 + ", distHeight = " + i19);
            } catch (Exception e18) {
                QLog.d("StructMsg", 2, e18.getMessage());
            }
        }
        return str2;
    }

    public static boolean sendAndUploadImageShare(QQAppInterface qQAppInterface, StructMsgForImageShare structMsgForImageShare, String str, int i3, String str2, int i16) {
        return sendAndUploadImageShare(qQAppInterface, structMsgForImageShare, str, i3, str2, i16, null, false);
    }

    public boolean checkImageSharePic(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) context)).booleanValue();
        }
        com.tencent.mobileqq.structmsg.view.e firstImageElement = getFirstImageElement();
        if (firstImageElement != null) {
            if (firstImageElement.f290637b1 == null) {
                firstImageElement.f290637b1 = this;
            }
            MessageForPic m3 = firstImageElement.m();
            URLDrawable n3 = ForwardUtils.n(context, m3);
            if (new File(m3.path).exists()) {
                firstImageElement.R0 = m3.path;
            } else {
                String url = n3.getURL().toString();
                String str = null;
                if (AbsDownloader.hasFile(url)) {
                    File file = AbsDownloader.getFile(url);
                    if (file != null && file.exists()) {
                        str = file.getAbsolutePath();
                    }
                } else {
                    File file2 = AbsDownloader.getFile(URLDrawableHelper.getURL(m3, 65537).toString());
                    if (file2 != null && file2.exists()) {
                        str = file2.getAbsolutePath();
                    }
                }
                firstImageElement.R0 = str;
            }
            if (TextUtils.isEmpty(firstImageElement.R0)) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
                }
                return false;
            }
            if (!AbsDownloader.hasFile(n3.getURL().toString())) {
                n3.startDownload();
                return true;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
        }
        return false;
    }

    public com.tencent.mobileqq.structmsg.view.e getFirstImageElement() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.structmsg.view.e) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.mStructMsgItemLists != null) {
            for (int i3 = 0; i3 < this.mStructMsgItemLists.size(); i3++) {
                AbsStructMsgElement absStructMsgElement = this.mStructMsgItemLists.get(i3);
                if (absStructMsgElement instanceof a) {
                    a aVar = (a) absStructMsgElement;
                    if (aVar.U0 != null) {
                        for (int i16 = 0; i16 < aVar.U0.size(); i16++) {
                            AbsStructMsgElement absStructMsgElement2 = aVar.U0.get(i16);
                            if (absStructMsgElement2 != null && (absStructMsgElement2 instanceof com.tencent.mobileqq.structmsg.view.e)) {
                                return (com.tencent.mobileqq.structmsg.view.e) absStructMsgElement2;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    public View.OnClickListener getOnClickListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return f290371d;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg, com.tencent.mobileqq.structmsg.AbsStructMsg
    public View getPreDialogView(Context context, View view) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) view);
        }
        Resources resources = context.getResources();
        int i3 = (int) resources.getDisplayMetrics().density;
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setMaxHeight(i3 * 140);
        imageView.setAdjustViewBounds(true);
        imageView.setPadding(0, 10, 0, 10);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setMinimumHeight(i3 * 120);
        if (AppSetting.f99565y) {
            imageView.setContentDescription(context.getString(R.string.go5));
        }
        Drawable drawable = resources.getDrawable(R.drawable.h2r);
        com.tencent.mobileqq.structmsg.view.e firstImageElement = getFirstImageElement();
        if (firstImageElement != null && (str = firstImageElement.R0) != null) {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                imageView.setImageDrawable(drawable);
                ThreadManagerV2.excute(new Runnable(firstImageElement, i3, imageView, drawable) { // from class: com.tencent.mobileqq.structmsg.StructMsgForImageShare.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mobileqq.structmsg.view.e f290372d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f290373e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ ImageView f290374f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ Drawable f290375h;

                    {
                        this.f290372d = firstImageElement;
                        this.f290373e = i3;
                        this.f290374f = imageView;
                        this.f290375h = drawable;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, StructMsgForImageShare.this, firstImageElement, Integer.valueOf(i3), imageView, drawable);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        Bitmap g16 = com.tencent.biz.common.util.e.g(this.f290372d.R0, this.f290373e * 140);
                        if (g16 != null) {
                            g16 = aw.s(g16, new File(this.f290372d.R0));
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getPreDialogView bitmap null? ");
                        if (g16 == null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        sb5.append(z16);
                        QLog.i("StructMsg", 1, sb5.toString());
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(g16) { // from class: com.tencent.mobileqq.structmsg.StructMsgForImageShare.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Bitmap f290376d;

                            {
                                this.f290376d = g16;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) g16);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                QLog.i("StructMsg", 2, "getPreDialogView setPreviewBitmap");
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                ImageView imageView2 = anonymousClass1.f290374f;
                                if (imageView2 != null) {
                                    Bitmap bitmap = this.f290376d;
                                    if (bitmap != null) {
                                        imageView2.setImageBitmap(bitmap);
                                    } else {
                                        imageView2.setImageDrawable(anonymousClass1.f290375h);
                                    }
                                }
                            }
                        });
                    }
                }, 64, null, true);
            } else {
                imageView.setImageDrawable(URLDrawable.getDrawable(str, drawable, drawable));
            }
            return imageView;
        }
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    public String getTitleFromBrief() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (TextUtils.isEmpty(this.mMsgBrief)) {
            return "";
        }
        if (this.mMsgBrief.startsWith(BRIEF_PREFIX)) {
            return this.mMsgBrief.substring(4);
        }
        return this.mMsgBrief;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsg
    public View getView(Context context, View view, an anVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, context, view, anVar, bundle);
        }
        if (this.mMsgException) {
            View versionExceptionView = AbsStructMsg.getVersionExceptionView(context, view, anVar, bundle);
            versionExceptionView.setId(R.id.j59);
            versionExceptionView.setTag(R.id.j59, this);
            return versionExceptionView;
        }
        ViewGroup viewGroup = (ViewGroup) super.getView(context, view, anVar, bundle);
        com.tencent.mobileqq.structmsg.view.e firstImageElement = getFirstImageElement();
        if (firstImageElement != null) {
            firstImageElement.f290637b1 = this;
            if (viewGroup.getChildCount() == 1 && (viewGroup.getChildAt(0) instanceof BubbleImageView) && firstImageElement.n()) {
                firstImageElement.c(context, viewGroup.getChildAt(0), bundle);
            } else {
                viewGroup.addView(firstImageElement.c(context, view, bundle));
            }
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        } else {
            layoutParams.height = -2;
            layoutParams.width = -2;
        }
        viewGroup.setLayoutParams(layoutParams);
        viewGroup.setBackgroundDrawable(null);
        viewGroup.setId(R.id.j59);
        viewGroup.setTag(R.id.j59, this);
        return viewGroup;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    protected boolean parseContentNode(j jVar) {
        AbsStructMsgElement a16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) jVar)).booleanValue();
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
                a16 = h.c(i3);
            } catch (NumberFormatException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, "Item layout value is 0");
                }
                return false;
            }
        } else {
            a16 = h.a(jVar.f290428b);
        }
        if (a16 == null || !a16.d(jVar)) {
            return false;
        }
        addItem(a16);
        return true;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        AbsStructMsgElement a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) objectInput);
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
                a c16 = h.c(this.mContentLayout);
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
                if (!TextUtils.isEmpty(this.mSourceName) || !TextUtils.isEmpty(this.mSourceIcon)) {
                    this.mHasSource = true;
                    return;
                }
                return;
            }
            if (readInt >= 2) {
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
                        a16 = h.c(objectInput.readInt());
                    } else {
                        a16 = h.a(readUTF);
                        if (a16 != null && a.class.isInstance(a16)) {
                            objectInput.readInt();
                        }
                    }
                    if (a16 != null) {
                        a16.i(objectInput);
                        if (!TextUtils.isEmpty(a16.f290329i)) {
                            a16.K0 = String.valueOf(i3);
                            i3++;
                        }
                        a16.M0 = this.uin;
                        addItem(a16);
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
                this.mHasSource = objectInput.readBoolean();
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
                    if (readInt >= 5) {
                        this.source_puin = objectInput.readUTF();
                        if (readInt >= 7) {
                            this.adverSign = objectInput.readInt();
                            this.adverKey = objectInput.readUTF();
                            this.index = objectInput.readUTF();
                            this.index_name = objectInput.readUTF();
                            this.index_type = objectInput.readUTF();
                            if (readInt >= 16) {
                                this.thumbWidth = objectInput.readInt();
                                this.thumbHeight = objectInput.readInt();
                                this.mImageBizType = objectInput.readInt();
                                if (readInt >= 20) {
                                    this.rawUrl = objectInput.readUTF();
                                    if (readInt >= 21) {
                                        this.bigUrl = objectInput.readUTF();
                                        this.thumbUrl = objectInput.readUTF();
                                        if (readInt >= 26) {
                                            this.width = objectInput.readInt();
                                            this.height = objectInput.readInt();
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.mMsgException = true;
        } catch (IOException e16) {
            if (e16.getMessage() != null && e16.getMessage().equals("structmsg_version_error")) {
                this.mMsgException = true;
            }
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    public void report(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, obj);
            return;
        }
        com.tencent.mobileqq.structmsg.view.e firstImageElement = getFirstImageElement();
        if (firstImageElement == null || !firstImageElement.n() || !(obj instanceof Long)) {
            return;
        }
        jq3.a.o(this.uinType, this.mSourceAppid, getTitleFromBrief());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    public void setCompoundDrawable(TextView textView, Drawable drawable, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, textView, drawable, resources);
            return;
        }
        com.tencent.mobileqq.structmsg.view.e firstImageElement = getFirstImageElement();
        if (firstImageElement != null && firstImageElement.n()) {
            ThreadManagerV2.executeOnSubThread(new Runnable(drawable, resources, textView) { // from class: com.tencent.mobileqq.structmsg.StructMsgForImageShare.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Drawable f290380d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Resources f290381e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ TextView f290382f;

                {
                    this.f290380d = drawable;
                    this.f290381e = resources;
                    this.f290382f = textView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, StructMsgForImageShare.this, drawable, resources, textView);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(com.tencent.mobileqq.structmsg.view.c.o(this.f290380d));
                    bitmapDrawable.setBounds(0, 0, BaseAIOUtils.f(14.0f, this.f290381e), BaseAIOUtils.f(14.0f, this.f290381e));
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(bitmapDrawable) { // from class: com.tencent.mobileqq.structmsg.StructMsgForImageShare.3.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Drawable f290383d;

                        {
                            this.f290383d = bitmapDrawable;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) bitmapDrawable);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            anonymousClass3.f290382f.setCompoundDrawablePadding(BaseAIOUtils.f(3.0f, anonymousClass3.f290381e));
                            AnonymousClass3.this.f290382f.setCompoundDrawables(this.f290383d, null, null, null);
                        }
                    });
                }
            });
        } else {
            super.setCompoundDrawable(textView, drawable, resources);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsShareMsg
    protected void toContentXml(AbsStructMsg.a aVar) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        Iterator<AbsStructMsgElement> it = iterator();
        while (it.hasNext()) {
            it.next().k(aVar);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectOutput);
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
        objectOutput.writeBoolean(this.mHasSource);
        String str15 = this.mCommentText;
        if (str15 == null) {
            str15 = "";
        }
        objectOutput.writeUTF(str15);
        String str16 = this.mCompatibleText;
        if (str16 == null) {
            str16 = "";
        }
        objectOutput.writeUTF(str16);
        objectOutput.writeLong(this.msgId);
        objectOutput.writeInt(this.mPromotionType);
        String str17 = this.mPromotionMsg;
        if (str17 == null) {
            str17 = "";
        }
        objectOutput.writeUTF(str17);
        String str18 = this.mPromotionMenus;
        if (str18 == null) {
            str18 = "";
        }
        objectOutput.writeUTF(str18);
        objectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
        String str19 = this.source_puin;
        if (str19 == null) {
            str19 = "";
        }
        objectOutput.writeUTF(str19);
        objectOutput.writeInt(this.adverSign);
        String str20 = this.adverKey;
        if (str20 == null) {
            str20 = "";
        }
        objectOutput.writeUTF(str20);
        String str21 = this.index;
        if (str21 == null) {
            str21 = "";
        }
        objectOutput.writeUTF(str21);
        String str22 = this.index_name;
        if (str22 == null) {
            str22 = "";
        }
        objectOutput.writeUTF(str22);
        String str23 = this.index_type;
        if (str23 == null) {
            str23 = "";
        }
        objectOutput.writeUTF(str23);
        objectOutput.writeInt(this.thumbWidth);
        objectOutput.writeInt(this.thumbHeight);
        objectOutput.writeInt(this.mImageBizType);
        String str24 = this.rawUrl;
        if (str24 == null) {
            str24 = "";
        }
        objectOutput.writeUTF(str24);
        String str25 = this.bigUrl;
        if (str25 == null) {
            str25 = "";
        }
        objectOutput.writeUTF(str25);
        String str26 = this.thumbUrl;
        if (str26 != null) {
            str2 = str26;
        }
        objectOutput.writeUTF(str2);
        objectOutput.writeInt(this.width);
        objectOutput.writeInt(this.height);
    }

    public static boolean sendAndUploadImageShare(QQAppInterface qQAppInterface, StructMsgForImageShare structMsgForImageShare, String str, int i3, String str2, int i16, ad adVar, boolean z16) {
        if (structMsgForImageShare == null) {
            return false;
        }
        if (str != null && i3 >= 0) {
            com.tencent.mobileqq.structmsg.view.e firstImageElement = structMsgForImageShare.getFirstImageElement();
            if (firstImageElement == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
                }
                return false;
            }
            int i17 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i17 + 1;
            long j3 = i17;
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            String str3 = ((i3 == 1000 || i3 == 1020 || i3 == 1004) && !TextUtils.isEmpty(str2)) ? str2 : currentAccountUin;
            firstImageElement.Z0 = 0L;
            MessageForStructing A = q.A(qQAppInterface, currentAccountUin, str, str3, i3, j3, structMsgForImageShare);
            com.tencent.mobileqq.activity.aio.forward.b.d().e(A.uniseq, structMsgForImageShare.uniseq, structMsgForImageShare.forwardID);
            if (ao.c(i3) == 1032) {
                ConfessMsgUtil.d(qQAppInterface, A, str, i3, i16);
            }
            if (!structMsgForImageShare.checkImageSharePic(qQAppInterface.getApp())) {
                return false;
            }
            if (FileUtils.isLocalPath(firstImageElement.R0)) {
                String bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(firstImageElement.R0));
                if (bytes2HexStr == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("StructMsg", 2, "handleAppShareAction MD5 NULL!!!");
                    }
                    return false;
                }
                firstImageElement.T0 = bytes2HexStr;
                URL url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(bytes2HexStr, 1);
                String url2 = url == null ? null : url.toString();
                if (!AbsDownloader.hasFile(url2)) {
                    FileUtils.copyFile(firstImageElement.R0, AbsDownloader.getFilePath(url2));
                }
            }
            TransferRequest transferRequest = new TransferRequest();
            transferRequest.mSelfUin = currentAccountUin;
            transferRequest.mPeerUin = str;
            transferRequest.mUinType = i3;
            transferRequest.mFileType = 1;
            transferRequest.mUniseq = A.uniseq;
            transferRequest.mIsUp = true;
            transferRequest.mBusiType = 1030;
            transferRequest.mLocalPath = firstImageElement.R0;
            transferRequest.mUpCallBack = adVar;
            if (z16) {
                transferRequest.needSendMsg = false;
                transferRequest.isShareImageByServer = true;
            } else {
                qQAppInterface.getMessageFacade().c(A, currentAccountUin);
            }
            ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "handleAppShareAction toUin is NULL!!!");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StructMsgForImageShare(Bundle bundle) {
        super(bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        this.mIsSend = 1;
        this.mUniseq = 0L;
        this.mMsgType = 0;
        this.mImageBizType = 0;
        if (bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE, 1) != 5) {
            return;
        }
        this.mMsgServiceID = 5;
        a c16 = h.c(0);
        c16.t(bundle.getString("image_url"));
        this.mStructMsgItemLists.add(c16);
        this.thumbWidth = bundle.getInt(AppConstants.Key.STRUCT_SHARE_KEY_THUMB_WIDTH, 0);
        this.thumbHeight = bundle.getInt(AppConstants.Key.STRUCT_SHARE_KEY_THUMB_HEIGHT, 0);
    }

    StructMsgForImageShare(j jVar) {
        super(jVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar);
            return;
        }
        this.mIsSend = 1;
        this.mUniseq = 0L;
        this.mMsgType = 0;
        this.mImageBizType = 0;
    }
}
