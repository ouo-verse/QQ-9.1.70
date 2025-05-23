package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class GrayUinCheckResp extends JceStruct {
    static byte[] cache_err_msg;
    static byte[] cache_jump_url;
    static byte[] cache_title_content;
    static byte[] cache_title_msg;
    public boolean can_apply;
    public byte[] err_msg;
    public boolean is_yingyongbao;
    public byte[] jump_url;
    public boolean new_flag;
    public int status;
    public byte[] title_content;
    public byte[] title_msg;

    static {
        cache_err_msg = r1;
        byte[] bArr = {0};
        cache_jump_url = r1;
        byte[] bArr2 = {0};
        cache_title_msg = r1;
        byte[] bArr3 = {0};
        cache_title_content = r0;
        byte[] bArr4 = {0};
    }

    public GrayUinCheckResp() {
        this.status = 0;
        this.is_yingyongbao = false;
        this.err_msg = null;
        this.jump_url = null;
        this.title_msg = null;
        this.title_content = null;
        this.can_apply = true;
        this.new_flag = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.status = jceInputStream.read(this.status, 1, true);
        this.is_yingyongbao = jceInputStream.read(this.is_yingyongbao, 2, false);
        this.err_msg = jceInputStream.read(cache_err_msg, 3, false);
        this.jump_url = jceInputStream.read(cache_jump_url, 4, false);
        this.title_msg = jceInputStream.read(cache_title_msg, 5, false);
        this.title_content = jceInputStream.read(cache_title_content, 6, false);
        this.can_apply = jceInputStream.read(this.can_apply, 7, false);
        this.new_flag = jceInputStream.read(this.new_flag, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.status, 1);
        jceOutputStream.write(this.is_yingyongbao, 2);
        byte[] bArr = this.err_msg;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        byte[] bArr2 = this.jump_url;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 4);
        }
        byte[] bArr3 = this.title_msg;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 5);
        }
        byte[] bArr4 = this.title_content;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 6);
        }
        jceOutputStream.write(this.can_apply, 7);
        jceOutputStream.write(this.new_flag, 8);
    }

    public GrayUinCheckResp(int i3, boolean z16, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, boolean z17, boolean z18) {
        this.status = i3;
        this.is_yingyongbao = z16;
        this.err_msg = bArr;
        this.jump_url = bArr2;
        this.title_msg = bArr3;
        this.title_content = bArr4;
        this.can_apply = z17;
        this.new_flag = z18;
    }
}
