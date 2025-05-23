package com.tencent.mobileqq.vas.updatesystem.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.pb.scupdate.SCUpdatePB$ItemVersion;
import com.tencent.pb.scupdate.SCUpdatePB$UpdateInfo;
import com.tencent.pb.scupdate.SCUpdatePB$VCR;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasUpdateData {
    private static final String TAG = "VasUpdateData";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class GetUrlRsp extends QuickUpdateRsp {
        public List<UpdateInfo> updateList = new ArrayList();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ItemVersion {
        public long bid;
        public long flag;
        public String scid;
        public String version;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class QuickUpdateRsp {
        public long cookie;
        public long ret;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class SCPreloadOrReport {
        public List<ItemVersion> itemList = new ArrayList();
        public long ver;

        public void setList(PBRepeatMessageField<SCUpdatePB$ItemVersion> pBRepeatMessageField) {
            for (int i3 = 0; i3 < pBRepeatMessageField.size(); i3++) {
                ItemVersion itemVersion = new ItemVersion();
                SCUpdatePB$ItemVersion sCUpdatePB$ItemVersion = pBRepeatMessageField.get(i3);
                itemVersion.bid = sCUpdatePB$ItemVersion.bid.get();
                itemVersion.scid = sCUpdatePB$ItemVersion.scid.get();
                itemVersion.version = sCUpdatePB$ItemVersion.version.get();
                itemVersion.flag = sCUpdatePB$ItemVersion.flag.get();
                this.itemList.add(itemVersion);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class SyncVCRRsp extends QuickUpdateRsp {
        public int continueFlag;
        public int environment;
        public int polltime;
        public long seq;
        public int syncSwitch;
        public List<VCR> vcrList = new ArrayList();
        public SCPreloadOrReport preload = new SCPreloadOrReport();
        public SCPreloadOrReport report = new SCPreloadOrReport();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class UpdateInfo {
        public String appVersion;
        public long bid;
        public int code;
        public int compressMode;
        public int deltaMode;
        public String dstVersion;
        public String filecontent;
        public long filesize;
        public String scid;
        public String srcVersion;
        public int storageMode;
        public String url;

        private void checkNoMediaFile(String str) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File file2 = new File(file.getAbsolutePath() + "/.nomedia");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e16) {
                        QLog.e(VasUpdateData.TAG, 1, "createNewFile error, ", e16);
                    }
                }
            }
        }

        private String checkTempPath(int i3, TagItemInfo tagItemInfo, String str) {
            String substring;
            if (tagItemInfo != null && !TextUtils.isEmpty(tagItemInfo.strSavePath)) {
                if (tagItemInfo.bSaveInDir) {
                    substring = tagItemInfo.strSavePath;
                } else {
                    substring = tagItemInfo.strSavePath.substring(0, tagItemInfo.strSavePath.lastIndexOf("/"));
                }
                if (!TextUtils.isEmpty(substring)) {
                    File file = new File(substring);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    checkNoMediaFile(substring);
                    return substring + "/tempFile_" + System.currentTimeMillis() + "_" + i3;
                }
                return str;
            }
            return str;
        }

        private void initTempPath(int i3, byte[] bArr) {
            DataOutputStream dataOutputStream = null;
            try {
                try {
                    try {
                        String checkTempPath = checkTempPath(i3, getItemInfo(this.bid, this.scid), MobileQQ.sMobileQQ.peekAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/tempFile_" + System.currentTimeMillis() + "_" + i3);
                        if (QLog.isColorLevel()) {
                            QLog.d(VasUpdateData.TAG, 2, "UpdateInfo tempFilePath = " + checkTempPath);
                        }
                        if (!TextUtils.isEmpty(checkTempPath)) {
                            DataOutputStream dataOutputStream2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(checkTempPath))));
                            try {
                                dataOutputStream2.write(bArr, 0, bArr.length);
                                dataOutputStream2.flush();
                                this.filecontent = checkTempPath;
                                dataOutputStream = dataOutputStream2;
                            } catch (Exception e16) {
                                e = e16;
                                dataOutputStream = dataOutputStream2;
                                QLog.e(VasUpdateData.TAG, 1, "UpdateInfo set error : ", e);
                                this.filecontent = "file_not_exists";
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                dataOutputStream = dataOutputStream2;
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (Exception e17) {
                                        QLog.e(VasUpdateData.TAG, 1, "UpdateInfo set error :", e17);
                                    }
                                }
                                throw th;
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d(VasUpdateData.TAG, 2, "UpdateInfo error tempfile create fail");
                            }
                            this.filecontent = "file_not_exists";
                        }
                    } catch (Exception e18) {
                        QLog.e(VasUpdateData.TAG, 1, "UpdateInfo set error :", e18);
                        return;
                    }
                } catch (Exception e19) {
                    e = e19;
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }

        public TagItemInfo getItemInfo(long j3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d(VasUpdateData.TAG, 2, "getItemInfo bid = " + j3 + " scid = " + str);
                return null;
            }
            return null;
        }

        public void set(SCUpdatePB$UpdateInfo sCUpdatePB$UpdateInfo, int i3) {
            this.bid = sCUpdatePB$UpdateInfo.bid.get();
            this.scid = sCUpdatePB$UpdateInfo.scid.get();
            this.dstVersion = sCUpdatePB$UpdateInfo.dst_version.get();
            this.srcVersion = sCUpdatePB$UpdateInfo.src_version.get();
            this.deltaMode = sCUpdatePB$UpdateInfo.delta_mode.get();
            this.storageMode = sCUpdatePB$UpdateInfo.storage_mode.get();
            this.compressMode = sCUpdatePB$UpdateInfo.compress_mode.get();
            this.url = sCUpdatePB$UpdateInfo.url.get();
            this.filesize = sCUpdatePB$UpdateInfo.filesize.get();
            byte[] byteArray = sCUpdatePB$UpdateInfo.filecontent.get().toByteArray();
            if (byteArray.length > 0) {
                initTempPath(i3, byteArray);
            }
            this.code = sCUpdatePB$UpdateInfo.code.get();
            this.appVersion = sCUpdatePB$UpdateInfo.extendinfo.app_version.get();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class VCR {
        public String appVersion;
        public long bid;
        public int optype;
        public String scid;
        public long seq;
        public String version;

        public void set(SCUpdatePB$VCR sCUpdatePB$VCR) {
            this.seq = sCUpdatePB$VCR.seq.get();
            this.bid = sCUpdatePB$VCR.bid.get();
            this.scid = sCUpdatePB$VCR.scid.get();
            this.optype = sCUpdatePB$VCR.optype.get();
            this.version = sCUpdatePB$VCR.version.get();
            this.appVersion = sCUpdatePB$VCR.extendinfo.app_version.get();
        }
    }
}
