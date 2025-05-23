package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.notColumn;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForFile extends ChatMessage {
    private static final String TAG = "MessageForFile";
    public String fileName;
    public String filePath;
    public long fileSize;
    public String fileSizeString;
    public String fileType;

    @notColumn
    public long originalMsgUid;

    @notColumn
    public long originalTime;

    @notColumn
    public long originalmsgShseq;
    public int status;
    public String[] tempMsg;
    public String url;
    public String urlAtServer;

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        String str;
        String str2 = this.f203106msg;
        if (str2 != null && str2.length() > 0 && this.f203106msg.charAt(0) == 22) {
            String[] split = this.f203106msg.split("\\|");
            this.tempMsg = split;
            if (split.length > 0 && (str = split[0]) != null && str.length() > 0) {
                int lastIndexOf = str.lastIndexOf(File.separator);
                if (lastIndexOf != -1) {
                    this.fileName = str.substring(lastIndexOf + 1);
                    return;
                } else {
                    this.fileName = str;
                    return;
                }
            }
            return;
        }
        this.tempMsg = null;
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

    public boolean hasFileName() {
        if (TextUtils.isEmpty(this.fileName) || this.fileName.trim().equalsIgnoreCase("null")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        try {
            super.postRead();
        } catch (Exception unused) {
        }
    }
}
