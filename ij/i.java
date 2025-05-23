package ij;

import com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$CreateMoreSpaceGuide;
import qzone.QZIntimateProfileReader$IntimateSpaceAbs;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\"\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\f\u001a\u0004\b\b\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\"\u001a\u0004\b\u0018\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lij/i;", "", "", "a", "I", "d", "()I", "type", "b", "c", "status", "Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;", "Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;", "()Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;", "j", "(Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;)V", "spaceAbsData", "Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;", "Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;", "()Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;", "g", "(Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;)V", "createMoreSpaceGuide", "", "e", "Z", "isGuest", "()Z", tl.h.F, "(Z)V", "f", "i", "isNeedUpdateDesc", "Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "()Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "k", "(Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;)V", "vipInfoBean", "<init>", "(II)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int status;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZIntimateProfileReader$CreateMoreSpaceGuide createMoreSpaceGuide;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isGuest;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private QZIntimateSpaceVipInfoBean vipInfoBean;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private QZIntimateProfileReader$IntimateSpaceAbs spaceAbsData = new QZIntimateProfileReader$IntimateSpaceAbs();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedUpdateDesc = true;

    public i(int i3, int i16) {
        this.type = i3;
        this.status = i16;
    }

    /* renamed from: a, reason: from getter */
    public final QZIntimateProfileReader$CreateMoreSpaceGuide getCreateMoreSpaceGuide() {
        return this.createMoreSpaceGuide;
    }

    /* renamed from: b, reason: from getter */
    public final QZIntimateProfileReader$IntimateSpaceAbs getSpaceAbsData() {
        return this.spaceAbsData;
    }

    /* renamed from: c, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final QZIntimateSpaceVipInfoBean getVipInfoBean() {
        return this.vipInfoBean;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsNeedUpdateDesc() {
        return this.isNeedUpdateDesc;
    }

    public final void g(QZIntimateProfileReader$CreateMoreSpaceGuide qZIntimateProfileReader$CreateMoreSpaceGuide) {
        this.createMoreSpaceGuide = qZIntimateProfileReader$CreateMoreSpaceGuide;
    }

    public final void h(boolean z16) {
        this.isGuest = z16;
    }

    public final void i(boolean z16) {
        this.isNeedUpdateDesc = z16;
    }

    public final void j(QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs) {
        Intrinsics.checkNotNullParameter(qZIntimateProfileReader$IntimateSpaceAbs, "<set-?>");
        this.spaceAbsData = qZIntimateProfileReader$IntimateSpaceAbs;
    }

    public final void k(QZIntimateSpaceVipInfoBean qZIntimateSpaceVipInfoBean) {
        this.vipInfoBean = qZIntimateSpaceVipInfoBean;
    }
}
