package com.immersion.stickersampleapp;

import com.immersion.touchsensesdk.IConnection;
import java.io.IOException;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d$IMMRRsp;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements IConnection {

    /* renamed from: a, reason: collision with root package name */
    private oidb_0xa4d$IMMRRsp f38080a;

    public a(oidb_0xa4d$IMMRRsp oidb_0xa4d_immrrsp) {
        this.f38080a = oidb_0xa4d_immrrsp;
    }

    @Override // com.immersion.touchsensesdk.IConnection
    public int getContentLength() {
        return this.f38080a.bytes_rsp_data.get().toByteArray().length;
    }

    @Override // com.immersion.touchsensesdk.IConnection
    public long getLastModified() {
        return this.f38080a.int64_last_modified.get();
    }

    @Override // com.immersion.touchsensesdk.IConnection
    public int getResponseCode() throws IOException {
        return this.f38080a.int32_ret.get();
    }

    @Override // com.immersion.touchsensesdk.IConnection
    public byte[] readAllData() throws IOException {
        return this.f38080a.bytes_rsp_data.get().toByteArray();
    }

    @Override // com.immersion.touchsensesdk.IConnection
    public void disconnect() {
    }
}
