package com.tencent.mobileqq.data;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForVideoVip extends ChatMessage {
    public String url;
    public String wording;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        String[] strArr;
        String str = this.f203106msg;
        if (str != null) {
            strArr = str.split("\\|");
        } else {
            strArr = null;
        }
        if (strArr != null && strArr.length == 2) {
            this.wording = strArr[0];
            this.url = strArr[1];
        }
    }
}
