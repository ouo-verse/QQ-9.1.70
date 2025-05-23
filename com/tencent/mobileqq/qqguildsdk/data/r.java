package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSpeakPermissionInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class r implements eo {

    /* renamed from: a, reason: collision with root package name */
    public final GProSpeakPermissionInfo f266735a;

    public r(GProSpeakPermissionInfo gProSpeakPermissionInfo) {
        this.f266735a = gProSpeakPermissionInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.eo
    public boolean a() {
        if (this.f266735a.getSendRedPacket() != null && !this.f266735a.getSendRedPacket().booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.eo
    public ArrayList<String> b() {
        if (this.f266735a.getSendProhibiteWords() == null) {
            return new ArrayList<>();
        }
        return this.f266735a.getSendProhibiteWords();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.eo
    public boolean c() {
        if (this.f266735a.getSendAdvertise() != null && !this.f266735a.getSendAdvertise().booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.eo
    public boolean d() {
        if (this.f266735a.getSendLink() != null && !this.f266735a.getSendLink().booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.eo
    public boolean e() {
        if (this.f266735a.getSendQrCode() != null && !this.f266735a.getSendQrCode().booleanValue()) {
            return false;
        }
        return true;
    }
}
