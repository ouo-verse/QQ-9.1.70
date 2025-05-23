package com.tencent.mobileqq.guild.message.msgtype;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes14.dex */
public class MessageRecordForMarkdown extends ChatMessage {
    public static final String MSG_MARKDOWN_COMPATIBLE_TEXT = "compatibleText";
    public static final String MSG_MARKDOWN_PARSED_TEXT = "markdownParsedText";
    private static final String TAG = "MessageRecordForMarkdown";
    private String compatibleText;
    private String parsedText;

    public MessageRecordForMarkdown(String str) {
        this.compatibleText = "";
        this.parsedText = "";
        this.msgtype = MessageRecord.MSG_TYPE_GUILD_MARK_DOWN;
        this.f203106msg = str;
        this.msgData = str.getBytes(StandardCharsets.UTF_8);
    }

    public String getCompatibleText() {
        if (TextUtils.isEmpty(this.compatibleText)) {
            this.compatibleText = getExtInfoFromExtStr(MSG_MARKDOWN_COMPATIBLE_TEXT);
        }
        return this.compatibleText;
    }

    public String getParsedText() {
        if (TextUtils.isEmpty(this.parsedText)) {
            this.parsedText = getExtInfoFromExtStr(MSG_MARKDOWN_PARSED_TEXT);
        }
        return this.parsedText;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        if (!TextUtils.isEmpty(getParsedText())) {
            return getParsedText();
        }
        return getCompatibleText();
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        super.prewrite();
    }

    public void setCompatibleText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.compatibleText = str;
            saveExtInfoToExtStr(MSG_MARKDOWN_COMPATIBLE_TEXT, str);
        }
    }

    public void setParsedText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.parsedText = str;
            saveExtInfoToExtStr(MSG_MARKDOWN_PARSED_TEXT, str);
        }
    }

    public MessageRecordForMarkdown(String str, String str2) {
        this(str);
        this.compatibleText = str2;
        saveExtInfoToExtStr(MSG_MARKDOWN_COMPATIBLE_TEXT, str2);
    }

    public MessageRecordForMarkdown() {
        this.compatibleText = "";
        this.parsedText = "";
        this.msgtype = MessageRecord.MSG_TYPE_GUILD_MARK_DOWN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
    }
}
