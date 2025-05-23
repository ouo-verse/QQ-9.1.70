package f03;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ads.data.AdParam;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\bC\u0010DR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R2\u00101\u001a\u0012\u0012\u0004\u0012\u00020#0*j\b\u0012\u0004\u0012\u00020#`+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R2\u00103\u001a\u0012\u0012\u0004\u0012\u00020#0*j\b\u0012\u0004\u0012\u00020#`+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010,\u001a\u0004\b\n\u0010.\"\u0004\b2\u00100R2\u00105\u001a\u0012\u0012\u0004\u0012\u00020#0*j\b\u0012\u0004\u0012\u00020#`+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010,\u001a\u0004\b\u000e\u0010.\"\u0004\b4\u00100R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b9\u0010\bR\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR2\u0010A\u001a\u0012\u0012\u0004\u0012\u00020>0*j\b\u0012\u0004\u0012\u00020>`+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010,\u001a\u0004\b\u0003\u0010.\"\u0004\b@\u00100R\"\u0010B\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010$\u001a\u0004\b\u0012\u0010&\"\u0004\b?\u0010(\u00a8\u0006E"}, d2 = {"Lf03/d;", "", "", "a", "I", "e", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "duration", "b", "j", "w", "physicalAnimDelay", "c", "k", HippyTKDListViewAdapter.X, "physicalRotate", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "showAlphaDelay", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "showAlphaDur", "f", "g", ReportConstant.COSTREPORT_PREFIX, "hideAlphaDelay", h.F, "t", "hideAlphaDur", "i", "v", "parCount", "", "Ljava/lang/String;", "getShootAnimRule", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", "shootAnimRule", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "l", "()Ljava/util/ArrayList;", "setShootAnimas", "(Ljava/util/ArrayList;)V", "shootAnimas", "setAnimasDirXs", "animasDirXs", "setAnimasDirYs", "animasDirYs", "o", "B", "width", "r", "height", "getOp", "u", "op", "Lf03/d$a;", "p", "setAnimConfigList", "animConfigList", "bubbleId", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int duration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int physicalAnimDelay;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int physicalRotate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int showAlphaDelay;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int showAlphaDur;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int hideAlphaDelay;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int hideAlphaDur;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int parCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int op;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String shootAnimRule = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> shootAnimas = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> animasDirXs = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> animasDirYs = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<a> animConfigList = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String bubbleId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b#\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\r\"\u0004\b \u0010\u000fR\"\u0010$\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\f\u001a\u0004\b\u0014\u0010\r\"\u0004\b#\u0010\u000fR\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR\"\u0010*\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\f\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000f\u00a8\u0006-"}, d2 = {"Lf03/d$a;", "", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "type", "", "b", "I", "()I", "i", "(I)V", "duration", "c", "f", "delay", "d", "j", "op", "getTx", DomainData.DOMAIN_NAME, "tx", "getTy", "o", AdParam.TY, "g", "getDirX", "dirX", h.F, "getDirY", "dirY", "k", "rz", "getSx", "l", "sx", "getSy", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sy", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int duration;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int delay;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int op;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int tx;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int ty;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int dirX;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int dirY;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int rz;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String type = "";

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int sx = 1;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int sy = 1;

        /* renamed from: a, reason: from getter */
        public final int getDelay() {
            return this.delay;
        }

        /* renamed from: b, reason: from getter */
        public final int getDuration() {
            return this.duration;
        }

        /* renamed from: c, reason: from getter */
        public final int getOp() {
            return this.op;
        }

        /* renamed from: d, reason: from getter */
        public final int getRz() {
            return this.rz;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final void f(int i3) {
            this.delay = i3;
        }

        public final void g(int i3) {
            this.dirX = i3;
        }

        public final void h(int i3) {
            this.dirY = i3;
        }

        public final void i(int i3) {
            this.duration = i3;
        }

        public final void j(int i3) {
            this.op = i3;
        }

        public final void k(int i3) {
            this.rz = i3;
        }

        public final void l(int i3) {
            this.sx = i3;
        }

        public final void m(int i3) {
            this.sy = i3;
        }

        public final void n(int i3) {
            this.tx = i3;
        }

        public final void o(int i3) {
            this.ty = i3;
        }

        public final void p(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }
    }

    public final void A(int i3) {
        this.showAlphaDur = i3;
    }

    public final void B(int i3) {
        this.width = i3;
    }

    @NotNull
    public final ArrayList<a> a() {
        return this.animConfigList;
    }

    @NotNull
    public final ArrayList<String> b() {
        return this.animasDirXs;
    }

    @NotNull
    public final ArrayList<String> c() {
        return this.animasDirYs;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getBubbleId() {
        return this.bubbleId;
    }

    /* renamed from: e, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* renamed from: f, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: g, reason: from getter */
    public final int getHideAlphaDelay() {
        return this.hideAlphaDelay;
    }

    /* renamed from: h, reason: from getter */
    public final int getHideAlphaDur() {
        return this.hideAlphaDur;
    }

    /* renamed from: i, reason: from getter */
    public final int getParCount() {
        return this.parCount;
    }

    /* renamed from: j, reason: from getter */
    public final int getPhysicalAnimDelay() {
        return this.physicalAnimDelay;
    }

    /* renamed from: k, reason: from getter */
    public final int getPhysicalRotate() {
        return this.physicalRotate;
    }

    @NotNull
    public final ArrayList<String> l() {
        return this.shootAnimas;
    }

    /* renamed from: m, reason: from getter */
    public final int getShowAlphaDelay() {
        return this.showAlphaDelay;
    }

    /* renamed from: n, reason: from getter */
    public final int getShowAlphaDur() {
        return this.showAlphaDur;
    }

    /* renamed from: o, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bubbleId = str;
    }

    public final void q(int i3) {
        this.duration = i3;
    }

    public final void r(int i3) {
        this.height = i3;
    }

    public final void s(int i3) {
        this.hideAlphaDelay = i3;
    }

    public final void t(int i3) {
        this.hideAlphaDur = i3;
    }

    public final void u(int i3) {
        this.op = i3;
    }

    public final void v(int i3) {
        this.parCount = i3;
    }

    public final void w(int i3) {
        this.physicalAnimDelay = i3;
    }

    public final void x(int i3) {
        this.physicalRotate = i3;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shootAnimRule = str;
    }

    public final void z(int i3) {
        this.showAlphaDelay = i3;
    }
}
