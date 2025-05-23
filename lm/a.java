package lm;

import android.view.View;
import com.qzone.reborn.base.l;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.itemview.ad.QZoneAdBaseFeedItemView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0014J\u0012\u0010\u0018\u001a\u00020\u000f2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010'R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010'R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010'R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010'\u00a8\u0006/"}, d2 = {"Llm/a;", "", "", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "b", DomainData.DOMAIN_NAME, "l", "e", "o", "a", "k", "Lcom/tencent/biz/richframework/part/Part;", "part", "", h.F, "Lvg/a;", "presenter", "i", "Lne/a;", "g", "Lcom/qzone/reborn/base/l;", "section", "j", "", WadlProxyConsts.BANNER_TYPE, "f", "Landroid/view/View;", "itemView", "p", "", "", "Ljava/util/List;", "mForbiddenPartList", "mForbiddenPresenterList", "mForbiddenFeedSectionList", "mForbiddenBannerList", "mForbiddenSectionList", "Z", "mIsForbiddenPartConfigParse", "mIsForbiddenPresenterConfigParse", "mIsForbiddenFeedSectionConfigParse", "mIsForbiddenBannerConfigParse", "mIsForbiddenSectionConfigParse", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f414989a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static List<String> mForbiddenPartList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static List<String> mForbiddenPresenterList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static List<String> mForbiddenFeedSectionList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static List<String> mForbiddenBannerList = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static List<String> mForbiddenSectionList = new ArrayList();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsForbiddenPartConfigParse;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsForbiddenPresenterConfigParse;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsForbiddenFeedSectionConfigParse;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsForbiddenBannerConfigParse;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsForbiddenSectionConfigParse;

    a() {
    }

    private final void a() {
        if (mIsForbiddenBannerConfigParse) {
            return;
        }
        mIsForbiddenBannerConfigParse = true;
        k();
    }

    private final void b() {
        if (mIsForbiddenFeedSectionConfigParse) {
            return;
        }
        mIsForbiddenFeedSectionConfigParse = true;
        l();
    }

    private final void c() {
        if (mIsForbiddenPartConfigParse) {
            return;
        }
        mIsForbiddenPartConfigParse = true;
        m();
    }

    private final void d() {
        if (mIsForbiddenPresenterConfigParse) {
            return;
        }
        mIsForbiddenPresenterConfigParse = true;
        n();
    }

    private final void e() {
        if (mIsForbiddenSectionConfigParse) {
            return;
        }
        mIsForbiddenSectionConfigParse = true;
        o();
    }

    private final void k() {
        List<String> split$default;
        String j3 = g.f53821a.i().j();
        if (j3.length() > 0) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) j3, new String[]{"_"}, false, 0, 6, (Object) null);
            mForbiddenBannerList = split$default;
        }
    }

    private final void l() {
        List<String> split$default;
        String k3 = g.f53821a.i().k();
        if (k3.length() > 0) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) k3, new String[]{"_"}, false, 0, 6, (Object) null);
            mForbiddenFeedSectionList = split$default;
        }
    }

    private final void m() {
        List<String> split$default;
        String l3 = g.f53821a.i().l();
        if (l3.length() > 0) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) l3, new String[]{"_"}, false, 0, 6, (Object) null);
            mForbiddenPartList = split$default;
        }
    }

    private final void n() {
        List<String> split$default;
        String m3 = g.f53821a.i().m();
        if (m3.length() > 0) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) m3, new String[]{"_"}, false, 0, 6, (Object) null);
            mForbiddenPresenterList = split$default;
        }
    }

    private final void o() {
        List<String> split$default;
        String n3 = g.f53821a.i().n();
        if (n3.length() > 0) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) n3, new String[]{"_"}, false, 0, 6, (Object) null);
            mForbiddenSectionList = split$default;
        }
    }

    public final boolean f(int bannerType) {
        a();
        return mForbiddenBannerList.contains(String.valueOf(bannerType));
    }

    public final boolean g(ne.a presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        b();
        return mForbiddenFeedSectionList.contains(presenter.getClass().getSimpleName()) || mForbiddenFeedSectionList.contains(presenter.o());
    }

    public final boolean h(Part part) {
        Intrinsics.checkNotNullParameter(part, "part");
        c();
        return mForbiddenPartList.contains(part.getClass().getSimpleName()) || mForbiddenPartList.contains(part.getTAG());
    }

    public final boolean i(vg.a presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        d();
        return mForbiddenPresenterList.contains(presenter.getClass().getSimpleName()) || mForbiddenPresenterList.contains(presenter.q());
    }

    public final boolean j(l<?> section) {
        Intrinsics.checkNotNullParameter(section, "section");
        e();
        return mForbiddenSectionList.contains(section.getClass().getSimpleName()) || mForbiddenSectionList.contains(section.s());
    }

    public final boolean p(View itemView) {
        return itemView instanceof QZoneAdBaseFeedItemView;
    }
}
