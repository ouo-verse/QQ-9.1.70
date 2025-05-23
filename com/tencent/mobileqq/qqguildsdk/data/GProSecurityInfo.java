package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSecurityResult;
import java.io.Serializable;

/* loaded from: classes17.dex */
public class GProSecurityInfo implements IGProSecurityResult, Serializable {
    private final GProSecurityResult result;

    public GProSecurityInfo(GProSecurityResult gProSecurityResult) {
        this.result = gProSecurityResult;
    }

    public static GProSecurityInfo createDefault() {
        return new GProSecurityInfo(new GProSecurityResult(0L, "", ""));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
    public long getActionCode() {
        return this.result.getAction();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
    public String getStrDetail() {
        return this.result.getStrDetail();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
    public String getStrPrompt() {
        return this.result.getStrPrompt();
    }

    @NonNull
    public String toString() {
        return "{code=" + getActionCode() + ", prompt=" + getStrPrompt() + ", detail=" + getStrDetail() + "}";
    }
}
