package com.tencent.mobileqq.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.filemanager.fileassistant.data.DatalineFileData;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForDLFile extends ChatMessage {
    public static final String TAG = "MessageForDLFile";
    public long associatedId;
    public int deviceType;
    public String fileName;
    public long fileSize;
    public String localPath;
    public String thumbPath;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        DatalineFileData datalineFileData;
        try {
            datalineFileData = (DatalineFileData) MessagePkgUtils.getObjectFromBytes(this.msgData);
        } catch (Exception e16) {
            e16.printStackTrace();
            datalineFileData = null;
        }
        if (datalineFileData == null) {
            return;
        }
        this.associatedId = datalineFileData.associatedId;
        this.deviceType = datalineFileData.deviceType;
        this.fileName = datalineFileData.filename;
        this.fileSize = datalineFileData.filesize;
        this.localPath = datalineFileData.localPath;
        this.thumbPath = datalineFileData.thumbPath;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(HardCodeUtil.qqStr(R.string.o0z));
        String str = this.fileName;
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.data.ChatMessage, com.tencent.mobileqq.data.MessageRecord
    public boolean isSend() {
        return super.isSend();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        serial();
    }

    public void serial() {
        DatalineFileData datalineFileData = new DatalineFileData();
        datalineFileData.filename = this.fileName;
        datalineFileData.filesize = this.fileSize;
        datalineFileData.localPath = this.localPath;
        datalineFileData.thumbPath = this.thumbPath;
        datalineFileData.associatedId = this.associatedId;
        datalineFileData.deviceType = this.deviceType;
        try {
            this.msgData = MessagePkgUtils.getBytesFromObject(datalineFileData);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
