package hd3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b\u00a8\u0006\u001d"}, d2 = {"Lhd3/b;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "headBg", "b", "f", "l", "titlePic", "d", "j", "listBgColor", "e", "k", "sendBtnPic", "setAvatarEntranceText", "avatarEntranceText", h.F, "avatarEntranceTextColor", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "translucentColor", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String headBg = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String titlePic = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String listBgColor = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String sendBtnPic = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String avatarEntranceText = "\u53bb\u8d85\u7ea7QQ\u79c0\u6362\u88c5 \uff1e";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String avatarEntranceTextColor = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String translucentColor = "";

    /* renamed from: a, reason: from getter */
    public final String getAvatarEntranceText() {
        return this.avatarEntranceText;
    }

    /* renamed from: b, reason: from getter */
    public final String getAvatarEntranceTextColor() {
        return this.avatarEntranceTextColor;
    }

    /* renamed from: c, reason: from getter */
    public final String getHeadBg() {
        return this.headBg;
    }

    /* renamed from: d, reason: from getter */
    public final String getListBgColor() {
        return this.listBgColor;
    }

    /* renamed from: e, reason: from getter */
    public final String getSendBtnPic() {
        return this.sendBtnPic;
    }

    /* renamed from: f, reason: from getter */
    public final String getTitlePic() {
        return this.titlePic;
    }

    /* renamed from: g, reason: from getter */
    public final String getTranslucentColor() {
        return this.translucentColor;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatarEntranceTextColor = str;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headBg = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.listBgColor = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sendBtnPic = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.titlePic = str;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.translucentColor = str;
    }
}
