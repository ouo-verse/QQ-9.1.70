package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdFormInputFieldInfo extends JceStruct {
    public String errorHint;
    public String hint;
    public String inputId;
    public String keyBoardHint;
    public int maxLength;
    public String regular;

    public AdFormInputFieldInfo() {
        this.hint = "";
        this.keyBoardHint = "";
        this.errorHint = "";
        this.regular = "";
        this.maxLength = 0;
        this.inputId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hint = jceInputStream.readString(1, false);
        this.keyBoardHint = jceInputStream.readString(2, false);
        this.errorHint = jceInputStream.readString(3, false);
        this.regular = jceInputStream.readString(4, false);
        this.maxLength = jceInputStream.read(this.maxLength, 5, false);
        this.inputId = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.hint;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.keyBoardHint;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.errorHint;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.regular;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.maxLength, 5);
        String str5 = this.inputId;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
    }

    public AdFormInputFieldInfo(String str, String str2, String str3, String str4, int i3, String str5) {
        this.hint = str;
        this.keyBoardHint = str2;
        this.errorHint = str3;
        this.regular = str4;
        this.maxLength = i3;
        this.inputId = str5;
    }
}
