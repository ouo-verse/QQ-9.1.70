package ij;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010!\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b8\u00109R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010 \u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\"\u0010#\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\"\u0010\u0014R\"\u0010%\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b!\u0010\u0012\"\u0004\b$\u0010\u0014R\"\u0010'\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b&\u0010\u0014R\"\u0010)\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b(\u0010\u0014R(\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010+\u001a\u0004\b\u0003\u0010,\"\u0004\b-\u0010.R(\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e0*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b\n\u0010,\"\u0004\b1\u0010.R\"\u00105\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0010\u001a\u0004\b0\u0010\u0012\"\u0004\b4\u0010\u0014R\"\u00107\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0010\u001a\u0004\b3\u0010\u0012\"\u0004\b6\u0010\u0014\u00a8\u0006:"}, d2 = {"Lij/e;", "", "", "a", "I", tl.h.F, "()I", ReportConstant.COSTREPORT_PREFIX, "(I)V", "id", "b", "getType", "y", "type", "", "c", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "t", "(Ljava/lang/String;)V", WadlProxyConsts.KEY_JUMP_URL, "d", "j", "u", "name", "e", "k", "v", "state", "f", "p", "iconSpecialUrl", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "iconUrlDay", "r", "iconUrlNight", DomainData.DOMAIN_NAME, "iconBgDay", "o", "iconBgNight", "", "Ljava/util/List;", "()Ljava/util/List;", "setBgColorDay", "(Ljava/util/List;)V", "bgColorDay", "l", "setBgColorNight", "bgColorNight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "strokeColorDay", HippyTKDListViewAdapter.X, "strokeColorNight", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int id = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int type = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String jumpUrl = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String name = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String state = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String iconSpecialUrl = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String iconUrlDay = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String iconUrlNight = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String iconBgDay = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String iconBgNight = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private List<String> bgColorDay = new ArrayList();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private List<String> bgColorNight = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String strokeColorDay = "";

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String strokeColorNight = "";

    public final List<String> a() {
        return this.bgColorDay;
    }

    public final List<String> b() {
        return this.bgColorNight;
    }

    /* renamed from: c, reason: from getter */
    public final String getIconBgDay() {
        return this.iconBgDay;
    }

    /* renamed from: d, reason: from getter */
    public final String getIconBgNight() {
        return this.iconBgNight;
    }

    /* renamed from: e, reason: from getter */
    public final String getIconSpecialUrl() {
        return this.iconSpecialUrl;
    }

    /* renamed from: f, reason: from getter */
    public final String getIconUrlDay() {
        return this.iconUrlDay;
    }

    /* renamed from: g, reason: from getter */
    public final String getIconUrlNight() {
        return this.iconUrlNight;
    }

    /* renamed from: h, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: i, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: j, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: k, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: l, reason: from getter */
    public final String getStrokeColorDay() {
        return this.strokeColorDay;
    }

    /* renamed from: m, reason: from getter */
    public final String getStrokeColorNight() {
        return this.strokeColorNight;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconBgDay = str;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconBgNight = str;
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconSpecialUrl = str;
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconUrlDay = str;
    }

    public final void r(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconUrlNight = str;
    }

    public final void s(int i3) {
        this.id = i3;
    }

    public final void t(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void u(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void v(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.state = str;
    }

    public final void w(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.strokeColorDay = str;
    }

    public final void x(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.strokeColorNight = str;
    }

    public final void y(int i3) {
        this.type = i3;
    }
}
