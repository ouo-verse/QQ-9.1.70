package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.api.IHotPicSearchService;
import com.tencent.mobileqq.emotionintegrate.ad;
import com.tencent.mobileqq.hotpic.api.IHotPicPageApi;
import com.tencent.mobileqq.panel.RichTextPanel;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class HotPicSearchServiceImpl implements IHotPicSearchService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "HotPicSearchServiceImpl";

    public HotPicSearchServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendVideoEmoticon(QQAppInterface qQAppInterface, Intent intent, EmotionSearchItem emotionSearchItem) {
        intent.putExtra(ShortVideoConstants.FILE_UUID, emotionSearchItem.videoFileId);
        intent.putExtra("file_send_path", emotionSearchItem.videoName);
        intent.putExtra("file_name", emotionSearchItem.videoName);
        intent.putExtra(ShortVideoConstants.FILE_FORMAT, emotionSearchItem.videoFormat);
        intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, emotionSearchItem.videoSize);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, (int) emotionSearchItem.videoDuration);
        intent.putExtra(ShortVideoConstants.FILE_SOURCE, ShortVideoConstants.FILE_SOURCE_HOT_PIC);
        intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, emotionSearchItem.videoMD5);
        intent.putExtra(ShortVideoConstants.FILE_THUMB_SIZE, emotionSearchItem.thumbSize);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, emotionSearchItem.thumbImgWidth);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, emotionSearchItem.thumbImgHeight);
        intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, emotionSearchItem.thumbImgMD5);
        intent.putExtra(ShortVideoConstants.FILE_WIDTH, emotionSearchItem.videoWidth);
        intent.putExtra(ShortVideoConstants.FILE_HEIGHT, emotionSearchItem.videoHeight);
        intent.putExtra(ShortVideoConstants.FILE_RAW_SIZE, true);
        intent.putExtra(ShortVideoConstants.SUPPORT_PROGRESSIVE, true);
        intent.putExtra(ShortVideoConstants.VIDEO_EMOTICON_SRC_TYPE, emotionSearchItem.srcType);
        intent.putExtra(ShortVideoConstants.VIDEO_EMOTICON_SRC_DESC, emotionSearchItem.srcDesc);
        intent.putExtra(ShortVideoConstants.VIDEO_EMOTICON_HOMEPAGE_URL, emotionSearchItem.homepageUrl);
        intent.putExtra(ShortVideoConstants.VIDEO_EMOTICON_VIDEO_ICON_URL, emotionSearchItem.videoIconUrl);
        intent.putExtra(ShortVideoConstants.VIDEO_EMOTICON_VIDEO_OTHER, emotionSearchItem.videoOther);
        ad.f(qQAppInterface, intent);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IHotPicSearchService
    public int getReportFromType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return RichTextPanel.R;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IHotPicSearchService
    public URL getURL(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (URL) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return com.tencent.mobileqq.hotpic.b.getURL(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IHotPicSearchService
    public boolean isRichTextLastTab(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        if (com.tencent.mobileqq.core.util.b.c(context, str) == 5) {
            return true;
        }
        return false;
    }

    protected void reportEvent(QQAppInterface qQAppInterface, EmotionSearchItem emotionSearchItem, String str, int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, emotionSearchItem, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 == 1) {
            if (!StringUtil.isEmpty(str)) {
                ReportController.o(qQAppInterface, "dc00898", "", "", EmoticonOperateReport.REPORT_TAG_0X800AE2E, EmoticonOperateReport.REPORT_TAG_0X800AE2E, 0, 0, "2", i16 + "", emotionSearchItem.getOriginEmoMd5(), "");
            }
            if (StringUtil.isEmpty(str)) {
                i17 = 1;
            } else {
                i17 = 2;
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", EmoticonOperateReport.REPORT_TAG_0X800AE20, EmoticonOperateReport.REPORT_TAG_0X800AE20, i17, 0, "2", i16 + "", emotionSearchItem.getOriginEmoMd5(), "");
            return;
        }
        if (i3 == 2) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800AE36", "0X800AE36", 0, 0, i16 + "", "", emotionSearchItem.getEmoMd5(), "");
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IHotPicSearchService
    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable, Parcelable parcelable2, String str, int i3, int i16) {
        boolean z16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, context, editText, parcelable, parcelable2, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if ((appRuntime instanceof QQAppInterface) && parcelable != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            SessionInfo sessionInfo = (SessionInfo) parcelable;
            if (!(context instanceof BaseActivity)) {
                return;
            }
            EmotionSearchItem emotionSearchItem = (EmotionSearchItem) parcelable2;
            File diskFile = com.tencent.mobileqq.hotpic.b.getDiskFile(emotionSearchItem.originalUrl);
            if (diskFile != null && FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
                String absolutePath = diskFile.getAbsolutePath();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "senHotPic, urlHotPicOringinal = " + emotionSearchItem.originalUrl + ", paths = " + absolutePath);
                }
                str2 = absolutePath;
                z16 = true;
            } else if (((IHotPicPageApi) QRoute.api(IHotPicPageApi.class)).checkAndDownLoadHotPic(emotionSearchItem) == 0) {
                String absolutePath2 = com.tencent.mobileqq.hotpic.b.getDiskFile(emotionSearchItem.url).getAbsolutePath();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "senHotPic, urlHotPic = " + emotionSearchItem.url + ", paths = " + absolutePath2);
                }
                str2 = absolutePath2;
                z16 = false;
            } else {
                z16 = false;
                str2 = null;
            }
            if (str2 == null && sessionInfo.f179555d != 1008 && TextUtils.isEmpty(emotionSearchItem.videoFileId)) {
                QQToast.makeText(context, com.tencent.mobileqq.R.string.fkh, 0).show();
                return;
            }
            reportEvent(qQAppInterface, emotionSearchItem, str, i3, i16);
            Intent intent = new Intent();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str2);
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            intent.putExtra("uin", sessionInfo.f179557e);
            intent.putExtra("uintype", sessionInfo.f179555d);
            intent.putExtra("troop_uin", sessionInfo.f179559f);
            intent.putExtra(ConfessInfo.KEY_CONFESS_TOPICID, sessionInfo.S);
            intent.putExtra(PeakConstants.SEND_SIZE_SPEC, 0);
            intent.putExtra(PeakConstants.SEND_IN_BACKGROUND, true);
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList);
            intent.putExtra("PicContants.NEED_COMPRESS", false);
            intent.putExtra(IPicBus.IS_EMO_SEARCH, true);
            if (!z16) {
                intent.putExtra(IPicBus.ORIGINAL_MD5, emotionSearchItem.originalMD5);
                intent.putExtra(IPicBus.ORIGINAL_SIZE, emotionSearchItem.oringinalSize);
                intent.putExtra(IPicBus.THUMB_MD5, emotionSearchItem.md5);
                intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1042);
            } else {
                intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1031);
            }
            if (TextUtils.isEmpty(emotionSearchItem.videoFileId)) {
                ThreadManagerV2.post(new SendPhotoTask((BaseActivity) context, intent, null), 8, null, false);
            } else {
                ThreadManagerV2.post(new Runnable(qQAppInterface, intent, emotionSearchItem) { // from class: com.tencent.mobileqq.emoticonview.api.impl.HotPicSearchServiceImpl.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ QQAppInterface val$app;
                    final /* synthetic */ Intent val$data;
                    final /* synthetic */ EmotionSearchItem val$mSearchItem;

                    {
                        this.val$app = qQAppInterface;
                        this.val$data = intent;
                        this.val$mSearchItem = emotionSearchItem;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, HotPicSearchServiceImpl.this, qQAppInterface, intent, emotionSearchItem);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            HotPicSearchServiceImpl.this.doSendVideoEmoticon(this.val$app, this.val$data, this.val$mSearchItem);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                }, 8, null, false);
            }
        }
    }
}
