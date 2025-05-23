package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.guild.media.pic.config.api.IGuildPicPreDownLoadApi;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.r;
import com.tencent.mobileqq.guild.performance.report.u;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

/* loaded from: classes19.dex */
public class GuildPicDownloadProcessor extends GroupPicDownloadProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GuildPicDownloadProcessor.<gld>";

    public GuildPicDownloadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        IGProChannelInfo channelInfo = ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getChannelInfo(transferRequest.mPeerUin);
        String guildId = channelInfo != null ? channelInfo.getGuildId() : "";
        if (!TextUtils.isEmpty(guildId)) {
            this.mUiRequest.mSecondId = guildId;
        }
        this.mEncryptPic = false;
        this.mEncryptUrl = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.GroupPicDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        super.doReport(z16);
        long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
        r.a aVar = new r.a();
        String str2 = "0";
        aVar.f231044a = "0";
        NetReq netReq = this.mNetReq;
        if (netReq instanceof HttpNetReq) {
            aVar.f231045b = ((HttpNetReq) netReq).mReqUrl;
        }
        aVar.f231046c = String.valueOf(this.mTotolLen);
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest != null) {
            str = transferRequest.mMd5;
        } else {
            str = "";
        }
        aVar.f231047d = str;
        aVar.f231048e = "0";
        aVar.f231049f = String.valueOf(System.currentTimeMillis() - nanoTime);
        aVar.f231050g = String.valueOf(nanoTime);
        if (!z16) {
            str2 = String.valueOf(this.mProcessorReport.errCode);
        }
        aVar.f231051h = str2;
        aVar.f231052i = this.mProcessorReport.errDesc;
        if (nanoTime > 0) {
            aVar.f231053j = (((((float) this.mTotolLen) * 1.0f) / ((float) nanoTime)) * 1000.0f) + "B/s";
        }
        TransferRequest transferRequest2 = this.mUiRequest;
        if (transferRequest2 != null) {
            aVar.f231054k = transferRequest2.mOutFilePath;
        }
        r.c(GuildTelemetryTask.DOWNLOAD_PIC, aVar);
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricCount(GuildCounterNames.PIC_DOWNLOAD, z16, null);
        u.a("guild_pic_download_cost", nanoTime);
    }

    @Override // com.tencent.mobileqq.transfile.BasePicDownloadProcessor
    protected boolean isUsingHttps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ((IGuildPicPreDownLoadApi) this.app.getRuntimeService(IGuildPicPreDownLoadApi.class, "")).isUsingHttps();
    }

    @Override // com.tencent.mobileqq.transfile.BasePicDownloadProcessor
    protected void refreshURLDrawable(MessageForPic messageForPic, URL url, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageForPic, url, Boolean.valueOf(z16));
            return;
        }
        String str = url.toString() + "#" + IGuildPicAIO.GUILD_PIC_URLDRAWABLE_STUFF;
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        if (imageCacheHelper.g(str) == null) {
            return;
        }
        imageCacheHelper.m(str);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mMemoryCacheKeySuffix = IGuildPicAIO.GUILD_PIC_URLDRAWABLE_STUFF;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        drawable.setTag(messageForPic);
        drawable.downloadImediatly();
        drawable.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.GroupPicDownloadProcessor
    public void sendHttpReq(HttpNetReq httpNetReq) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) httpNetReq);
            return;
        }
        if (this.mUiRequest.mIsOnlyGetUrl) {
            this.mController.removeProcessor(getKey());
            ArrayList<String> arrayList = new ArrayList<>(this.mIpList.size());
            for (int i3 = 0; i3 < this.mIpList.size(); i3++) {
                ServerAddr serverAddr = this.mIpList.get(i3);
                StringBuilder sb5 = new StringBuilder();
                if (httpNetReq.mIsHttps) {
                    str = "https://";
                } else {
                    str = "http://";
                }
                sb5.append(str);
                sb5.append(serverAddr.mIp);
                if (serverAddr.port != 80) {
                    sb5.append(":");
                    sb5.append(serverAddr.port);
                }
                sb5.append("/");
                arrayList.add(TransFileUtil.replaceIp(httpNetReq.mReqUrl, sb5.toString()));
            }
            Object obj = this.mUiRequest.extraObject;
            if (obj instanceof ft1.a) {
                ((ft1.a) obj).a(arrayList);
                return;
            }
            return;
        }
        super.sendHttpReq(httpNetReq);
    }

    @Override // com.tencent.mobileqq.transfile.GroupPicDownloadProcessor, com.tencent.mobileqq.transfile.BasePicDownloadProcessor
    void sendRequest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        this.mDirectMsgUrlDown = false;
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.GuildPicDownReq guildPicDownReq = new RichProto.RichProtoReq.GuildPicDownReq();
        TransferRequest transferRequest = this.mUiRequest;
        guildPicDownReq.index = transferRequest.mExtentionInfo;
        guildPicDownReq.selfUin = transferRequest.mSelfUin;
        guildPicDownReq.peerUin = transferRequest.mPeerUin;
        guildPicDownReq.secondUin = transferRequest.mSecondId;
        guildPicDownReq.uinType = transferRequest.mUinType;
        guildPicDownReq.fileType = transferRequest.mFileType;
        guildPicDownReq.groupFileID = this.mGroupFileID;
        guildPicDownReq.md5 = this.mMsgFileMd5;
        guildPicDownReq.msgTime = (int) transferRequest.mMsgTime;
        guildPicDownReq.protocolType = 0;
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.GLD_PIC_DW;
        richProtoReq.reqs.add(guildPicDownReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
        } else {
            if (QLog.isColorLevel()) {
                logRichMediaEvent("requestStart", richProtoReq.toString());
            }
            if (!canDoNextStep()) {
                return;
            }
            this.mRichProtoReq = richProtoReq;
            RichProtoProc.procRichProtoReq(richProtoReq);
        }
    }

    @Override // com.tencent.mobileqq.transfile.GroupPicDownloadProcessor
    protected boolean supportQuic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }
}
