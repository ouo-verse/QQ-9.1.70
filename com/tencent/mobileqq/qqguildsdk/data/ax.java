package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityInstruction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ax implements du {

    /* renamed from: a, reason: collision with root package name */
    private final GProIdentityInstruction f265704a;

    /* renamed from: b, reason: collision with root package name */
    private final List<IGProIdentityInfo> f265705b = new ArrayList();

    public ax(GProIdentityInstruction gProIdentityInstruction) {
        this.f265704a = gProIdentityInstruction;
        if (gProIdentityInstruction != null) {
            Iterator<GProIdentity> it = gProIdentityInstruction.getIdentityList().iterator();
            while (it.hasNext()) {
                this.f265705b.add(new GProIdentityInfo(it.next()));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.du
    public String a() {
        return this.f265704a.getMemberListPreviewImg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.du
    public String b() {
        return this.f265704a.getInstructionText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.du
    public String c() {
        return this.f265704a.getNoteText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.du
    public String d() {
        return this.f265704a.getTextChannelPreviewImg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.du
    public List<IGProIdentityInfo> getIdentityList() {
        return this.f265705b;
    }

    @NotNull
    public String toString() {
        return "GProIdentityInstructionInfo{identityInstruction=" + this.f265704a + ", mGProIdentityList=" + this.f265705b + '}';
    }
}
