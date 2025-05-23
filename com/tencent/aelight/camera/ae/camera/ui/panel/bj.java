package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\b&\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\"\u001a\u00020\u0014\u0012\b\b\u0002\u0010$\u001a\u00020\u000e\u0012\b\b\u0002\u0010&\u001a\u00020\u000e\u0012\b\b\u0002\u0010)\u001a\u00020\u0014\u0012\b\b\u0002\u0010+\u001a\u00020\u000e\u00a2\u0006\u0004\b,\u0010-R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\b\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\"\u0010\u001f\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0003\u0010\u0012\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\"\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017R\"\u0010$\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0010\u001a\u0004\b \u0010\u0012\"\u0004\b#\u0010\u001eR\"\u0010&\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b%\u0010\u001eR\"\u0010)\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b(\u0010\u0019R\"\u0010+\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b'\u0010\u0012\"\u0004\b*\u0010\u001e\u00a8\u0006."}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "", "", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "id", "b", "i", "name", "c", "e", "icon", "", "d", "I", "f", "()I", "iconId", "", "Z", "l", "()Z", "r", "(Z)V", "usable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, LibraTraceConst.Node.IMAGE_DOWNLOADING, "setDownloadProgress", "(I)V", "downloadProgress", tl.h.F, "j", "showAdjust", "p", "maleOrder", "o", "femaleOrder", "k", DomainData.DOMAIN_NAME, "enable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "slidingValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIZIIZI)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class bj {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String icon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int iconId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean usable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean downloading;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int downloadProgress;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean showAdjust;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int maleOrder;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int femaleOrder;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean enable;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int slidingValue;

    public bj() {
        this(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
    }

    /* renamed from: a, reason: from getter */
    public int getDownloadProgress() {
        return this.downloadProgress;
    }

    /* renamed from: b, reason: from getter */
    public boolean getDownloading() {
        return this.downloading;
    }

    /* renamed from: c, reason: from getter */
    public boolean getEnable() {
        return this.enable;
    }

    /* renamed from: d, reason: from getter */
    public int getFemaleOrder() {
        return this.femaleOrder;
    }

    /* renamed from: e, reason: from getter */
    public String getIcon() {
        return this.icon;
    }

    /* renamed from: f, reason: from getter */
    public int getIconId() {
        return this.iconId;
    }

    /* renamed from: g, reason: from getter */
    public String getId() {
        return this.id;
    }

    /* renamed from: h, reason: from getter */
    public int getMaleOrder() {
        return this.maleOrder;
    }

    /* renamed from: i, reason: from getter */
    public String getName() {
        return this.name;
    }

    /* renamed from: j, reason: from getter */
    public boolean getShowAdjust() {
        return this.showAdjust;
    }

    /* renamed from: k, reason: from getter */
    public int getSlidingValue() {
        return this.slidingValue;
    }

    /* renamed from: l, reason: from getter */
    public boolean getUsable() {
        return this.usable;
    }

    public void m(boolean z16) {
        this.downloading = z16;
    }

    public void n(boolean z16) {
        this.enable = z16;
    }

    public void o(int i3) {
        this.femaleOrder = i3;
    }

    public void p(int i3) {
        this.maleOrder = i3;
    }

    public void q(int i3) {
        this.slidingValue = i3;
    }

    public void r(boolean z16) {
        this.usable = z16;
    }

    public bj(String id5, String name, String icon, int i3, boolean z16, boolean z17, int i16, boolean z18, int i17, int i18, boolean z19, int i19) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = id5;
        this.name = name;
        this.icon = icon;
        this.iconId = i3;
        this.usable = z16;
        this.downloading = z17;
        this.downloadProgress = i16;
        this.showAdjust = z18;
        this.maleOrder = i17;
        this.femaleOrder = i18;
        this.enable = z19;
        this.slidingValue = i19;
    }

    public /* synthetic */ bj(String str, String str2, String str3, int i3, boolean z16, boolean z17, int i16, boolean z18, int i17, int i18, boolean z19, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? "" : str, (i26 & 2) != 0 ? "" : str2, (i26 & 4) == 0 ? str3 : "", (i26 & 8) != 0 ? 0 : i3, (i26 & 16) != 0 ? true : z16, (i26 & 32) != 0 ? false : z17, (i26 & 64) != 0 ? 0 : i16, (i26 & 128) == 0 ? z18 : false, (i26 & 256) != 0 ? -1 : i17, (i26 & 512) == 0 ? i18 : -1, (i26 & 1024) == 0 ? z19 : true, (i26 & 2048) != 0 ? 100 : i19);
    }
}
