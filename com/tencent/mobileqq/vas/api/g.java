package com.tencent.mobileqq.vas.api;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u000b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\r\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u0011\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u0012\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J!\u0010\u0017\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00022\u000e\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u00022\u000e\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010 \u001a\u00020\u00022\u000e\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\t\u0010!\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010#\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0002H\u0096\u0001\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/vas/api/g;", "Lcom/tencent/mobileqq/inject/b;", "", "enableTalkBack", "", "kotlin.jvm.PlatformType", "i", "", "getAppId", "g", "getBranchName", "f", "getChannel", "getQUA", "getQimei36", "d", "getReportVersionName", "e", "getSubVersion", "a", "getVersion", "Landroid/content/Context;", "p0", "b", "isAllowLandscape", "c", "isDebugVersion", "j", "isGooglePlayVersion", "isGrayVersion", h.F, "isPublicVersion", "isSplitViewMode", "isUiTest", "", "k", "<init>", "()V", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g implements com.tencent.mobileqq.inject.b {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final g f308459b = new g();

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.inject.b f308460a = y13.a.f449270a;

    g() {
    }

    @Override // com.tencent.mobileqq.inject.b
    public int a() {
        return this.f308460a.a();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String b(Context p06) {
        return this.f308460a.b(p06);
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean c() {
        return this.f308460a.c();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String d() {
        return this.f308460a.d();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String e() {
        return this.f308460a.e();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean enableTalkBack() {
        return this.f308460a.enableTalkBack();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String f() {
        return this.f308460a.f();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String g() {
        return this.f308460a.g();
    }

    @Override // com.tencent.mobileqq.inject.b
    public int getAppId() {
        return this.f308460a.getAppId();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getBranchName() {
        return this.f308460a.getBranchName();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getChannel() {
        return this.f308460a.getChannel();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getQUA() {
        return this.f308460a.getQUA();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getQimei36() {
        return this.f308460a.getQimei36();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getReportVersionName() {
        return this.f308460a.getReportVersionName();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getSubVersion() {
        return this.f308460a.getSubVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getVersion() {
        return this.f308460a.getVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean h(Context p06) {
        return this.f308460a.h(p06);
    }

    @Override // com.tencent.mobileqq.inject.b
    public String i() {
        return this.f308460a.i();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isAllowLandscape(Context p06) {
        return this.f308460a.isAllowLandscape(p06);
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isDebugVersion() {
        return this.f308460a.isDebugVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isGooglePlayVersion() {
        return this.f308460a.isGooglePlayVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isGrayVersion() {
        return this.f308460a.isGrayVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isPublicVersion() {
        return this.f308460a.isPublicVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isSplitViewMode(Context p06) {
        return this.f308460a.isSplitViewMode(p06);
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isUiTest() {
        return this.f308460a.isUiTest();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean j() {
        return this.f308460a.j();
    }

    @Override // com.tencent.mobileqq.inject.b
    public void k(boolean p06) {
        this.f308460a.k(p06);
    }
}
