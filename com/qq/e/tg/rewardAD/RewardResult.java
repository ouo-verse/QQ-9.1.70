package com.qq.e.tg.rewardAD;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardResult {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40608a;

    /* renamed from: b, reason: collision with root package name */
    private int f40609b;

    /* renamed from: c, reason: collision with root package name */
    private String f40610c;

    /* renamed from: d, reason: collision with root package name */
    private int f40611d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i3) {
        this.f40609b = i3;
    }

    public int getErrorCode() {
        return this.f40609b;
    }

    public String getSecId() {
        return this.f40610c;
    }

    public int getUserMaxGradientRewardLevel() {
        return this.f40611d;
    }

    public boolean isS2SRewardSuccess() {
        return this.f40608a;
    }

    public void setUserMaxGradientRewardLevel(int i3) {
        this.f40611d = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        this.f40610c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z16) {
        this.f40608a = z16;
    }
}
