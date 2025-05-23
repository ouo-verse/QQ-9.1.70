package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: classes19.dex */
public class NearbyPeoplePhotoUploadProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_CODE_SYSTEM_UNAVAILABLE = 1503;
    public static final String TAG = "NearbyPeoplePhotoUploadProcessor";
    private static final String UPLOAD_AVATAR_FAIL = "\u4e0a\u4f20\u5934\u50cf\u5931\u8d25";
    public static int mPhotoId;
    public String mPhotoUrl;
    public String mThumbPhotoUrl;
    public String mUrl;
    public String mVideoId;
    private Transaction trans;
    public String uuid;

    public NearbyPeoplePhotoUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.trans = null;
        FileMsg fileMsg = this.file;
        fileMsg.processor = this;
        fileMsg.bdhExtendInfo = transferRequest.mExtentionInfo;
        fileMsg.fileKey = transferRequest.getKeyForTransfer();
    }

    private boolean doCompress() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "personality_label start uniseq:" + this.mUiRequest.mUniseq + " src:" + this.mUiRequest.mLocalPath);
        }
        CompressInfo compressInfo = new CompressInfo(this.mUiRequest.mLocalPath, 0);
        compressInfo.K = 0;
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        if (TextUtils.isEmpty(compressInfo.H)) {
            onError();
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "personality_label start compress dst:" + compressInfo.H);
        }
        if (!TextUtils.equals(compressInfo.H, compressInfo.D)) {
            FileMsg fileMsg = this.file;
            TransferRequest transferRequest = this.mUiRequest;
            String str = compressInfo.H;
            transferRequest.mLocalPath = str;
            fileMsg.filePath = str;
            if (checkParam() != 0) {
                return true;
            }
        }
        return false;
    }

    private ITransactionCallback getCb(long j3) {
        return new ITransactionCallback(j3) { // from class: com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NearbyPeoplePhotoUploadProcessor.this, Long.valueOf(j3));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i3, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), bArr, hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_Xg)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_Xg)).longValue();
                String str = hashMap.get(TransReport.rep_time_cache);
                String str2 = hashMap.get(TransReport.rep_bdhTrans);
                String str3 = hashMap.get(TransReport.rep_segsPerConn);
                String str4 = hashMap.get(TransReport.rep_confSegSize);
                String str5 = hashMap.get(TransReport.rep_confSegNum);
                String str6 = hashMap.get(TransReport.rep_confMaxConn);
                if (QLog.isColorLevel()) {
                    QLog.i(NearbyPeoplePhotoUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms");
                }
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put("X-piccachetime", str);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHTRANS_INFO, str2);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SEG_PER_CNT, str3);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegSize, str4);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegNum, str5);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confMaxConn, str6);
                ProcessorReport processorReport = NearbyPeoplePhotoUploadProcessor.this.mProcessorReport;
                processorReport.setError(i3, "OnFailed.", "", processorReport.mStepTrans);
                NearbyPeoplePhotoUploadProcessor.this.onError();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_Xg)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_Xg)).longValue();
                String str = hashMap.get(TransReport.rep_time_cache);
                String str2 = hashMap.get(TransReport.rep_bdhTrans);
                String str3 = hashMap.get(TransReport.rep_segsPerConn);
                String str4 = hashMap.get(TransReport.rep_confSegSize);
                String str5 = hashMap.get(TransReport.rep_confSegNum);
                String str6 = hashMap.get(TransReport.rep_confMaxConn);
                if (QLog.isColorLevel()) {
                    QLog.i(NearbyPeoplePhotoUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms ,fileSize:" + NearbyPeoplePhotoUploadProcessor.this.file.fileSize + " transInfo:" + str2);
                }
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put("X-piccachetime", str);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHTRANS_INFO, str2);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SEG_PER_CNT, str3);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegSize, str4);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegNum, str5);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confMaxConn, str6);
                NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mStepTrans.logFinishTime();
                NearbyPeoplePhotoUploadProcessor nearbyPeoplePhotoUploadProcessor = NearbyPeoplePhotoUploadProcessor.this;
                nearbyPeoplePhotoUploadProcessor.mProcessorReport.mStepTrans.result = 1;
                nearbyPeoplePhotoUploadProcessor.mTransferedSize = nearbyPeoplePhotoUploadProcessor.mFileSize;
                int i3 = nearbyPeoplePhotoUploadProcessor.file.fileType;
                if (i3 == 50 || i3 == 51) {
                    nearbyPeoplePhotoUploadProcessor.handleTransFileStarPhotoOnSuccess(bArr);
                } else if (i3 == 23 || i3 == 67 || i3 == 68) {
                    nearbyPeoplePhotoUploadProcessor.handleTransFileExtendFriendOnSuccess(bArr);
                } else if (i3 == 22) {
                    nearbyPeoplePhotoUploadProcessor.handleTransFileFriendAvatarOnSuccess(bArr);
                } else if (i3 == 48) {
                    nearbyPeoplePhotoUploadProcessor.handleTransFileBaseStaticAvatarOnSuccess(bArr);
                } else if (i3 == 35) {
                    nearbyPeoplePhotoUploadProcessor.handleTransFileProfileCoverOnSuccess(bArr);
                } else if (i3 == 69 || i3 == 70 || i3 == 71 || i3 == 72 || i3 == 327698) {
                    nearbyPeoplePhotoUploadProcessor.handleTransFileZPlanImageOnSuccess(bArr);
                } else {
                    nearbyPeoplePhotoUploadProcessor.handleTransFileOtherConditionOnSuccess(bArr);
                }
                NearbyPeoplePhotoUploadProcessor.this.file.closeInputStream();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this);
                } else {
                    NearbyPeoplePhotoUploadProcessor.this.log("<BDH_LOG> onTransStart()");
                    NearbyPeoplePhotoUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    return;
                }
                NearbyPeoplePhotoUploadProcessor nearbyPeoplePhotoUploadProcessor = NearbyPeoplePhotoUploadProcessor.this;
                long j16 = i3;
                nearbyPeoplePhotoUploadProcessor.file.transferedSize = j16;
                nearbyPeoplePhotoUploadProcessor.mTransferedSize = j16;
                if (j16 <= nearbyPeoplePhotoUploadProcessor.mFileSize && !nearbyPeoplePhotoUploadProcessor.mIsCancel && !nearbyPeoplePhotoUploadProcessor.mIsPause) {
                    nearbyPeoplePhotoUploadProcessor.sendProgressMessage();
                }
            }
        };
    }

    private int getCommandId() {
        int i3 = this.file.fileType;
        if (i3 != 8 && i3 != 64) {
            if (i3 == 21) {
                return 6;
            }
            if (i3 == 22) {
                return 90;
            }
            if (i3 == 34) {
                return 13;
            }
            if (i3 == 35) {
                return 21;
            }
            if (i3 == 36 || i3 == 37 || i3 == 38) {
                return 23;
            }
            if (i3 == 39 || i3 == 40 || i3 == 41) {
                return 22;
            }
            if (i3 == 48) {
                return 24;
            }
            if (i3 == 23) {
                Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
                commFileExtReq.uint32_action_type.set(0);
                commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.app.getCurrentAccountUin()));
                this.file.bdhExtendInfo = commFileExtReq.toByteArray();
                return 59;
            }
            if (i3 == 50 || i3 == 51) {
                return 35;
            }
            if (i3 == 56) {
                return 39;
            }
            if (i3 == 67) {
                return 84;
            }
            if (i3 == 68) {
                return 85;
            }
            if (i3 == 69) {
                return 2005;
            }
            if (i3 == 70) {
                return 2007;
            }
            if (i3 == 71) {
                return 2008;
            }
            if (i3 == 72) {
                return 2012;
            }
            if (i3 == 327698) {
                return 2017;
            }
            return -1;
        }
        return 3;
    }

    private String getRichTag(String str) {
        int i3 = this.file.fileType;
        if (i3 != 8 && i3 != 64) {
            if (i3 == 21) {
                return StatisticCollector.FRESH_NEWS_PIC_UPLOAD_STATISTIC_TAG;
            }
            if (i3 == 22) {
                return StatisticCollector.FRIEND_AVATAR_UPLOAD_STATISTICS_TAG;
            }
            if (i3 == 34) {
                return StatisticCollector.C2B_UPLOAD_FILE_TAG;
            }
            if (i3 == 35) {
                return StatisticCollector.PROFILE_COVER_PIC_UPLOAD_STATISTIC_TAG;
            }
            if (i3 != 36 && i3 != 37 && i3 != 38 && i3 != 48) {
                if (i3 != 39 && i3 != 40 && i3 != 41) {
                    if (i3 != 50 && i3 != 51) {
                        if (i3 == 56) {
                            return StatisticCollector.PERSONALITY_LABEL_PHOTO_UPLOAD_STATISTIC_TAG;
                        }
                        if (i3 == 23) {
                            return StatisticCollector.EXTEND_FRIEND_SOUND_UPLOAD_TAG;
                        }
                        return str;
                    }
                    return StatisticCollector.HONG_BAO_STAR_PHOTO_UPLOAD_STATISTIC_TAG;
                }
                return StatisticCollector.NEARBY_DYNAMIC_AVATAR_UPLOAD_STATISTIC_TAG;
            }
            return StatisticCollector.BASE_DYNAMIC_AVATAR_UPLOAD_STATISTIC_TAG;
        }
        return StatisticCollector.NEARBY_PEOPLE_PIC_UPLOAD_STATISTIC_TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleTransFileBaseStaticAvatarOnSuccess(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte b16 = wrap.get();
        if (b16 == 0) {
            int i3 = wrap.get() & 255;
            this.mPhotoUrl = new String(bArr, 2, i3);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("handleTransFileBaseStaticAvatarOnSuccess success, result=%s length=%s mPhotoUrl=%s", Byte.valueOf(b16), Integer.valueOf(i3), this.mPhotoUrl));
            }
            onSuccess();
            return;
        }
        int i16 = wrap.getInt();
        int i17 = wrap.getShort();
        byte[] bArr2 = new byte[i17];
        wrap.get(bArr2);
        String str = new String(bArr2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("handleTransFileBaseStaticAvatarOnSuccess fail, result=%s errorCode=%s errorMsgLength=%s errorMsg=%s", Byte.valueOf(b16), Integer.valueOf(i16), Short.valueOf((short) i17), str));
        }
        FileMsg fileMsg = this.file;
        fileMsg.errorCode = i16;
        ProcessorReport processorReport = this.mProcessorReport;
        processorReport.errCode = i16;
        processorReport.errDesc = str;
        fileMsg.errorMessage = str;
        onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTransFileExtendFriendOnSuccess(byte[] bArr) {
        String str;
        int i3;
        Bdh_extinfo.CommFileExtRsp commFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
        try {
            commFileExtRsp.mergeFrom(bArr, 0, bArr.length);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        if (commFileExtRsp.bytes_download_url.has()) {
            str = commFileExtRsp.bytes_download_url.get().toStringUtf8();
        } else {
            str = "";
        }
        this.mUrl = str;
        if (commFileExtRsp.int32_retcode.has()) {
            i3 = commFileExtRsp.int32_retcode.get();
        } else {
            i3 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i3 + " url : " + this.mUrl);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            onSuccess();
        } else {
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleTransFileFriendAvatarOnSuccess(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte b16 = wrap.get();
        if (b16 == 0) {
            int i3 = wrap.get();
            byte[] bArr2 = new byte[i3];
            this.mPhotoUrl = new String(bArr2);
            wrap.get(bArr2);
            this.file.msgImageData = new String(bArr2);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("handleTransFileFriendAvatarOnSuccess success, result=%s length=%s mPhotoUrl=%s", Byte.valueOf(b16), Integer.valueOf(i3), this.mPhotoUrl));
            }
            onSuccess();
            com.tencent.mobileqq.avatar.api.a.b(true, 0, "1");
            return;
        }
        int i16 = wrap.getInt();
        int i17 = wrap.getShort();
        byte[] bArr3 = new byte[i17];
        wrap.get(bArr3);
        String str = new String(bArr3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("handleTransFileFriendAvatarOnSuccess fail, result=%s errorCode=%s errorMsgLength=%s errorMsg=%s", Byte.valueOf(b16), Integer.valueOf(i16), Short.valueOf((short) i17), str));
        }
        this.file.errorCode = i16;
        ProcessorReport processorReport = this.mProcessorReport;
        processorReport.errCode = i16;
        processorReport.errDesc = str;
        onError();
        com.tencent.mobileqq.avatar.api.a.b(false, i16, "1");
        if (TextUtils.isEmpty(str)) {
            str = UPLOAD_AVATAR_FAIL;
        }
        QQToastUtil.showQQToastInUiThread(1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTransFileOtherConditionOnSuccess(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte b16 = wrap.get();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + ((int) b16));
        }
        if (b16 == 0) {
            int i3 = this.file.fileType;
            if (i3 != 8 && i3 != 64) {
                if (i3 == 21) {
                    this.mPhotoUrl = new String(bArr, 2, wrap.get() & 255);
                } else if (i3 != 36 && i3 != 37 && i3 != 38 && i3 != 39 && i3 != 40 && i3 != 41) {
                    if (i3 == 56) {
                        try {
                            wrap.getInt();
                            long j3 = wrap.getLong();
                            this.mPhotoUrl = new String(bArr, wrap.position(), wrap.getInt());
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(). personalityLabel uuid:" + j3 + " url:" + this.mPhotoUrl);
                            }
                            FileMsg fileMsg = this.file;
                            fileMsg.thumbPath = this.mUiRequest.mThumbPath;
                            fileMsg.fileID = j3;
                            String str = this.mPhotoUrl;
                            fileMsg.fileUrl = str;
                            if (TextUtils.isEmpty(str)) {
                                this.file.fileUrl = this.mUiRequest.mLocalPath;
                            }
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    this.mVideoId = new String(bArr, 5, ((wrap.get() & 255) << 24) | wrap.get() | 0 | ((wrap.get() & 255) << 8) | ((wrap.get() & 255) << 16));
                    com.tencent.mobileqq.avatar.api.a.b(true, 0, "3");
                }
            } else {
                mPhotoId = Integer.parseInt(new String(bArr, 2, wrap.get() & 255));
            }
            onSuccess();
            return;
        }
        if (this.file.fileType == 34) {
            this.mPhotoUrl = new String(bArr);
            onSuccess();
            return;
        }
        sendMessageToUpdate(1005);
        onError();
        int i16 = this.file.fileType;
        if (i16 == 36 || i16 == 37 || i16 == 38 || i16 == 39 || i16 == 40 || i16 == 41) {
            com.tencent.mobileqq.avatar.api.a.b(false, wrap.getInt(), "3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleTransFileProfileCoverOnSuccess(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte b16 = wrap.get();
        if (b16 == 0) {
            this.file.bdhExtendInfo = bArr;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("handleTransFileProfileCoverOnSuccess success, result=%s", Byte.valueOf(b16)));
            }
            onSuccess();
            return;
        }
        int i3 = wrap.getInt();
        int i16 = wrap.getShort();
        byte[] bArr2 = new byte[i16];
        wrap.get(bArr2);
        String str = new String(bArr2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("handleTransFileProfileCoverOnSuccess fail, result=%s errorCode=%s errorMsgLength=%s errorMsg=%s", Byte.valueOf(b16), Integer.valueOf(i3), Short.valueOf((short) i16), str));
        }
        this.file.errorCode = i3;
        ProcessorReport processorReport = this.mProcessorReport;
        processorReport.errCode = i3;
        processorReport.errDesc = str;
        onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTransFileStarPhotoOnSuccess(byte[] bArr) {
        Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
        try {
            uploadPicExtInfo.mergeFrom(bArr, 0, bArr.length);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        String stringUtf8 = uploadPicExtInfo.bytes_file_resid.get().toStringUtf8();
        this.uuid = stringUtf8;
        if (!TextUtils.isEmpty(stringUtf8)) {
            onSuccess();
        } else {
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTransFileZPlanImageOnSuccess(byte[] bArr) {
        String str;
        if (bArr == null) {
            return;
        }
        Bdh_extinfo.CommFileExtRsp commFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
        try {
            commFileExtRsp.mergeFrom(bArr, 0, bArr.length);
            if (commFileExtRsp.bytes_download_url.has()) {
                str = commFileExtRsp.bytes_download_url.get().toStringUtf8();
            } else {
                str = "";
            }
            this.mUrl = str;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business url : " + this.mUrl);
            }
            if (!TextUtils.isEmpty(this.mUrl)) {
                onSuccess();
            } else {
                onError();
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(TAG, 1, "[NearbyPeoplePhotoUploadProcessor.handleTransFileZPlanImageOnSuccess] InvalidProtocolBufferMicroException:", e16);
            onError();
        }
    }

    private void sendRequest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
        } else {
            if (!canDoNextStep()) {
                return;
            }
            sendFile();
        }
    }

    public void cancelTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.trans != null) {
            this.app.getHwEngine().cancelTransactionTask(this.trans);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        String str = this.mUiRequest.mLocalPath;
        if (TextUtils.isEmpty(str)) {
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("filePath null")), null, null);
            onError();
            return -1;
        }
        File file = new File(str);
        if (!file.exists()) {
            this.mProcessorReport.setError(9042, BaseTransProcessor.getExpStackString(new Exception("sendFile not exist " + str)), null, null);
            onError();
            return -1;
        }
        if (!file.canRead()) {
            this.mProcessorReport.setError(9070, BaseTransProcessor.getExpStackString(new Exception("sendFile not readable " + this.file.filePath)), null, null);
            onError();
            return -1;
        }
        long length = file.length();
        this.file.fileSize = length;
        this.mFileSize = length;
        if (length <= 0) {
            this.mProcessorReport.setError(9071, BaseTransProcessor.getExpStackString(new Exception("file size 0 " + str)), null, null);
            onError();
            return -1;
        }
        return super.checkParam();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        String hexStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (!z16 && RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (!processorReport.mIsOldDbRec) {
            int i3 = 2;
            if (!z16 || (processorReport.mReportedFlag & 2) <= 0) {
                if (z16 || (processorReport.mReportedFlag & 1) <= 0) {
                    int i16 = processorReport.mReportedFlag;
                    if (!z16) {
                        i3 = 1;
                    }
                    processorReport.mReportedFlag = i3 | i16;
                    String richTag = getRichTag("");
                    this.mProcessorReport.mEndTime = System.currentTimeMillis();
                    long nanoTime = System.nanoTime();
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    long j3 = (nanoTime - processorReport2.mStartTime) / 1000000;
                    HashMap<String, String> hashMap = processorReport2.mReportInfo;
                    byte[] bArr = this.mSessionKey;
                    if (bArr == null) {
                        hexStr = "null";
                    } else {
                        hexStr = PkgTools.toHexStr(bArr);
                    }
                    hashMap.put(ReportConstant.KEY_SESSION_KEY, hexStr);
                    if (z16) {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, richTag, true, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                    } else {
                        ProcessorReport processorReport3 = this.mProcessorReport;
                        if (processorReport3.errCode != -9527) {
                            processorReport3.mReportInfo.remove("param_rspHeader");
                        }
                        ProcessorReport processorReport4 = this.mProcessorReport;
                        processorReport4.mReportInfo.put("param_FailCode", String.valueOf(processorReport4.errCode));
                        ProcessorReport processorReport5 = this.mProcessorReport;
                        processorReport5.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport5.errDesc);
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, richTag, false, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                    }
                    setReportFlag();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    protected long getBlockSize(long j3) {
        long min;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, j3)).longValue();
        }
        long j16 = this.mFileSize - j3;
        if (!this.mSSCMSpanned) {
            min = Math.min(j16, this.sscmObject.d(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));
        } else {
            min = Math.min(j16, 14600L);
        }
        return Math.min(min, 131072L);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    byte[] getStreamData(int i3, int i16) {
        return super.getStreamData(i3, i16);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    protected void log(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, str);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    void onError() {
        super.onError();
        sendMessageToUpdate(1005);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onError()---- errCode: " + this.mProcessorReport.errCode + ", errDesc:" + this.mProcessorReport.errDesc);
        }
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = -1;
            ProcessorReport processorReport = this.mProcessorReport;
            aVar.f258598b = processorReport.errCode;
            aVar.f258599c = processorReport.errDesc;
            this.mUiRequest.mUpCallBack.q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) netResp);
        } else {
            super.onResp(netResp);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    void onSuccess() {
        super.onSuccess();
        sendMessageToUpdate(1003);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onSuccess().");
        }
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = 0;
            this.mUiRequest.mUpCallBack.q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "NearbyPeoplePhotoUploadProcessor.resume()");
        }
        cancelTask();
        if (this.mLocalMd5 == null && !getMd5()) {
            onError();
            return 0;
        }
        sendRequest();
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public void sendFile() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
            }
            this.mProcessorReport.mStepTrans.logStartTime();
            ITransactionCallback cb5 = getCb(SystemClock.uptimeMillis());
            int commandId = getCommandId();
            this.file.commandId = commandId;
            synchronized (SessionInfo.class) {
                if (SessionInfo.getInstance(this.app.getCurrentAccountUin()).getHttpconn_sig_session() != null) {
                    int length = SessionInfo.getInstance(this.app.getCurrentAccountUin()).getHttpconn_sig_session().length;
                    this.mSigSession = new byte[length];
                    System.arraycopy(SessionInfo.getInstance(this.app.getCurrentAccountUin()).getHttpconn_sig_session(), 0, this.mSigSession, 0, length);
                }
                if (SessionInfo.getInstance(this.app.getCurrentAccountUin()).getSessionKey() != null) {
                    int length2 = SessionInfo.getInstance(this.app.getCurrentAccountUin()).getSessionKey().length;
                    this.mSessionKey = new byte[length2];
                    System.arraycopy(SessionInfo.getInstance(this.app.getCurrentAccountUin()).getSessionKey(), 0, this.mSessionKey, 0, length2);
                }
            }
            byte[] bArr2 = this.mSigSession;
            if ((bArr2 == null || bArr2.length == 0 || (bArr = this.mSessionKey) == null || bArr.length == 0) && !TextUtils.isEmpty(this.app.getCurrentAccountUin())) {
                AppInterface appInterface = this.app;
                HwServlet.getConfig(appInterface, appInterface.getCurrentAccountUin());
            }
            this.trans = new Transaction(this.app.getCurrentAccountUin(), commandId, this.mUiRequest.mLocalPath, (int) this.mStartOffset, this.mLocalMd5, cb5, this.file.bdhExtendInfo, false);
            int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.trans);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "<BDH_LOG> Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.trans.filePath + " Cmd:" + commandId);
            }
            if (submitTransactionTask != 0) {
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.setError(submitTransactionTask, "SubmitError.", "", processorReport.mStepTrans);
                onError();
            }
        } catch (RuntimeException e16) {
            QLog.e(TAG, 1, "sendFile fail " + e16);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.start();
        sendMessageToUpdate(1001);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "NearbyPeoplePhotoUploadProcessor.start()");
        }
        if (this.file.fileType == 56 && doCompress()) {
            return;
        }
        if (this.mLocalMd5 == null && !getMd5()) {
            onError();
        } else {
            sendRequest();
        }
    }
}
