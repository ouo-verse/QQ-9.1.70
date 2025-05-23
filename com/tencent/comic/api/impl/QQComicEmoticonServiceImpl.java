package com.tencent.comic.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.comic.api.IQQComicEmoticonService;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tencent.im.cs.cmd0x388.cmd0x388$ExtensionCommPicTryUp;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicEmoticonServiceImpl implements IQQComicEmoticonService {
    public static final String TAG = "VipComicEmoticonUploader";
    private AppRuntime mApp;
    private ITransFileController mFileController;
    private String mUin;
    public IQQComicEmoticonService.a mOnInvokeFinishListener = null;
    private ad mUpCallback = new a();

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        this.mFileController = (ITransFileController) appRuntime.getRuntimeService(ITransFileController.class, "");
        this.mUin = appRuntime.getCurrentUin();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements ad {
        a() {
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            if (aVar == null || QQComicEmoticonServiceImpl.this.mOnInvokeFinishListener == null) {
                return;
            }
            if (aVar.f258597a == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(QQComicEmoticonServiceImpl.TAG, 2, "Upload finish, id=" + aVar.f258602f);
                }
                Bundle bundle = new Bundle();
                bundle.putInt("result", 0);
                bundle.putString("id", aVar.f258602f);
                QQComicEmoticonServiceImpl.this.mOnInvokeFinishListener.a(bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(QQComicEmoticonServiceImpl.TAG, 2, "Upload error");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("result", 1);
            bundle2.putInt("errCode", aVar.f258598b);
            bundle2.putString("errMsg", aVar.f258599c);
            QQComicEmoticonServiceImpl.this.mOnInvokeFinishListener.a(bundle2);
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mFileController = null;
        this.mUin = null;
        this.mOnInvokeFinishListener = null;
        this.mApp = null;
    }

    @Override // com.tencent.comic.api.IQQComicEmoticonService
    public void uploadComicEmoticon(Bundle bundle, IQQComicEmoticonService.a aVar) {
        if (bundle == null) {
            return;
        }
        this.mOnInvokeFinishListener = aVar;
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = 20;
        transferRequest.mRichTag = StatisticCollector.QQCOMIC_PIC_UPLOAD_STATISTIC_TAG;
        String str = this.mUin;
        transferRequest.mSelfUin = str;
        transferRequest.mPeerUin = str;
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = bundle.getString("localPath");
        transferRequest.mUpCallBack = this.mUpCallback;
        String string = bundle.getString(ComicCancelRedPointPopItemData.JSON_KEY_COMIC_ID);
        String string2 = bundle.getString("picMd5");
        String string3 = bundle.getString(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ComicCancelRedPointPopItemData.JSON_KEY_COMIC_ID, string);
            jSONObject.put("picMd5", string2);
            jSONObject.put(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, string3);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        cmd0x388$ExtensionCommPicTryUp cmd0x388_extensioncommpictryup = new cmd0x388$ExtensionCommPicTryUp();
        cmd0x388_extensioncommpictryup.rpt_bytes_extinfo.add(ByteStringMicro.copyFrom(jSONObject.toString().getBytes()));
        transferRequest.mExtentionInfo = cmd0x388_extensioncommpictryup.toByteArray();
        ITransFileController iTransFileController = this.mFileController;
        if (iTransFileController != null) {
            iTransFileController.transferAsync(transferRequest);
        }
    }
}
