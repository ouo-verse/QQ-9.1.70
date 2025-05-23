package com.tencent.mobileqq.zootopia;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\"\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b!\u0010\u0018R\"\u0010(\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010$\u001a\u0004\b\u000f\u0010%\"\u0004\b&\u0010'R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b \u0010\u0007\"\u0004\b)\u0010\t\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zootopia/l;", "", "", "a", "", "I", "getTotalMode", "()I", "p", "(I)V", "totalMode", "b", "getCurrentMode", tl.h.F, "currentMode", "c", HippyQQPagView.FunctionName.GET_PROGRESS, "o", "progress", "", "d", "J", "()J", "k", "(J)V", "loadingStartTime", "e", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "nativeSucceedTime", "i", "enterAvatarSceneStartTime", "g", "l", "loadingSucceedTime", "", "Ljava/lang/String;", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "loadingId", DomainData.DOMAIN_NAME, "needHotFix", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int totalMode = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currentMode = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int progress = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long loadingStartTime = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long nativeSucceedTime = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long enterAvatarSceneStartTime = -1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long loadingSucceedTime = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String loadingId = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int needHotFix;

    /* renamed from: b, reason: from getter */
    public final long getEnterAvatarSceneStartTime() {
        return this.enterAvatarSceneStartTime;
    }

    /* renamed from: c, reason: from getter */
    public final String getLoadingId() {
        return this.loadingId;
    }

    /* renamed from: d, reason: from getter */
    public final long getLoadingStartTime() {
        return this.loadingStartTime;
    }

    /* renamed from: e, reason: from getter */
    public final long getLoadingSucceedTime() {
        return this.loadingSucceedTime;
    }

    /* renamed from: f, reason: from getter */
    public final long getNativeSucceedTime() {
        return this.nativeSucceedTime;
    }

    /* renamed from: g, reason: from getter */
    public final int getNeedHotFix() {
        return this.needHotFix;
    }

    public final void h(int i3) {
        this.currentMode = i3;
    }

    public final void i(long j3) {
        this.enterAvatarSceneStartTime = j3;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadingId = str;
    }

    public final void k(long j3) {
        this.loadingStartTime = j3;
    }

    public final void l(long j3) {
        this.loadingSucceedTime = j3;
    }

    public final void m(long j3) {
        this.nativeSucceedTime = j3;
    }

    public final void n(int i3) {
        this.needHotFix = i3;
    }

    public final void o(int i3) {
        this.progress = i3;
    }

    public final void p(int i3) {
        this.totalMode = i3;
    }

    public final void a() {
        this.totalMode = -1;
        this.currentMode = -1;
        this.progress = -1;
        this.loadingStartTime = -1L;
        this.enterAvatarSceneStartTime = -1L;
        this.loadingId = "";
        this.needHotFix = 0;
    }
}
