package ij;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceMedal$MedalInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b\u0016\u0010 \"\u0004\b!\u0010\"R$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b$\u0010\n\u00a8\u0006("}, d2 = {"Lij/a;", "", "", "g", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "badgeName", "c", "k", "badgeUrl", "f", DomainData.DOMAIN_NAME, "numContent", "d", "l", "listContent", "", "e", "I", "getAnimType", "()I", "i", "(I)V", "animType", "", "Lqzone/QZIntimateSpaceMedal$MedalInfo;", "Ljava/util/List;", "()Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/util/List;)V", "newMedalInfoList", tl.h.F, "alertMedalId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int animType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String alertMedalId;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String badgeName = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String badgeUrl = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String numContent = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String listContent = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<QZIntimateSpaceMedal$MedalInfo> newMedalInfoList = new ArrayList();

    /* renamed from: a, reason: from getter */
    public final String getAlertMedalId() {
        return this.alertMedalId;
    }

    /* renamed from: b, reason: from getter */
    public final String getBadgeName() {
        return this.badgeName;
    }

    /* renamed from: c, reason: from getter */
    public final String getBadgeUrl() {
        return this.badgeUrl;
    }

    /* renamed from: d, reason: from getter */
    public final String getListContent() {
        return this.listContent;
    }

    public final List<QZIntimateSpaceMedal$MedalInfo> e() {
        return this.newMedalInfoList;
    }

    /* renamed from: f, reason: from getter */
    public final String getNumContent() {
        return this.numContent;
    }

    public final boolean g() {
        return this.animType == 1;
    }

    public final void h(String str) {
        this.alertMedalId = str;
    }

    public final void i(int i3) {
        this.animType = i3;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.badgeName = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.badgeUrl = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.listContent = str;
    }

    public final void m(List<QZIntimateSpaceMedal$MedalInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.newMedalInfoList = list;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.numContent = str;
    }
}
