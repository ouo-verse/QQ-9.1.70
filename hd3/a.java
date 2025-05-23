package hd3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u000b\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"\u00a8\u0006)"}, d2 = {"Lhd3/a;", "", "", "a", "I", "d", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "id", "", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "title", "c", h.F, "actionId", "j", "avatarMd5", "", "J", "()J", "i", "(J)V", "avatarId", "", "f", "Z", "()Z", "k", "(Z)V", "isChecked", "g", "l", "isFooter", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int actionId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long avatarId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isChecked;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isFooter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String title = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String avatarMd5 = "";

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    /* renamed from: b, reason: from getter */
    public final long getAvatarId() {
        return this.avatarId;
    }

    /* renamed from: c, reason: from getter */
    public final String getAvatarMd5() {
        return this.avatarMd5;
    }

    /* renamed from: d, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsFooter() {
        return this.isFooter;
    }

    public final void h(int i3) {
        this.actionId = i3;
    }

    public final void i(long j3) {
        this.avatarId = j3;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatarMd5 = str;
    }

    public final void k(boolean z16) {
        this.isChecked = z16;
    }

    public final void l(boolean z16) {
        this.isFooter = z16;
    }

    public final void m(int i3) {
        this.id = i3;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
