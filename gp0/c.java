package gp0;

import android.view.ViewGroup;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPageType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\bH\u0014J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015R(\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lgp0/c;", "Loo0/a;", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "pageType", "", "event", "", "k", "", "d", "Landroid/view/ViewGroup;", "content", h.F, "b", "g", "f", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "c", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "panelContext", "Lfp0/b;", "Lfp0/b;", "panelStyle", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "<set-?>", "e", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "l", "()Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "quiPageTabBar", "<init>", "(Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;Lfp0/b;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends oo0.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fp0.b panelStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIPageTabBar quiPageTabBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext, @NotNull fp0.b panelStyle) {
        super(panelContext.c());
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(panelStyle, "panelStyle");
        this.panelContext = panelContext;
        this.panelStyle = panelStyle;
    }

    private final void k(HashTagPageType pageType, String event) {
        int i3;
        HashMap hashMapOf;
        if (pageType == HashTagPageType.Troop_Page) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        QUIPageTabBar qUIPageTabBar = this.quiPageTabBar;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_tab_type", Integer.valueOf(i3)));
        iGuildDTReportApi.reportDtEventManual(qUIPageTabBar, "em_sgrp_top_tab", event, hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(c this$0, int i3, boolean z16) {
        Object orNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("GFT_DialogQUIPageTabBarComponent", 1, "[onTabChanged] position " + i3);
        orNull = CollectionsKt___CollectionsKt.getOrNull(this$0.panelContext.j(), i3);
        HashTagPageType hashTagPageType = (HashTagPageType) orNull;
        if (hashTagPageType == null) {
            hashTagPageType = HashTagPageType.Channel_Page;
        }
        this$0.k(hashTagPageType, "clck");
    }

    @Override // oo0.a
    protected int b() {
        return R.layout.f__;
    }

    @Override // oo0.a
    public int d() {
        ViewGroup viewGroup = this.f423246b;
        if (viewGroup != null) {
            int height = viewGroup.getHeight();
            if (height <= 0) {
                return this.panelStyle.getDimen().getPageTabBarHeight();
            }
            return height;
        }
        return 0;
    }

    @Override // oo0.a
    public void f() {
        super.f();
        Iterator<T> it = this.panelContext.j().iterator();
        while (it.hasNext()) {
            k((HashTagPageType) it.next(), "imp_end");
        }
    }

    @Override // oo0.a
    public void g() {
        super.g();
        Iterator<T> it = this.panelContext.j().iterator();
        while (it.hasNext()) {
            k((HashTagPageType) it.next(), "imp");
        }
    }

    @Override // oo0.a
    protected void h(@NotNull ViewGroup content) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(content, "content");
        content.setLayoutParams(new ViewGroup.LayoutParams(-1, this.panelStyle.getDimen().getPageTabBarHeight()));
        content.setBackgroundResource(this.panelStyle.getDrawable().getLittleTongueTitleBarBackground());
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) content.findViewById(R.id.x2q);
        this.quiPageTabBar = qUIPageTabBar;
        if (qUIPageTabBar != null) {
            List<HashTagPageType> j3 = this.panelContext.j();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(j3, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = j3.iterator();
            while (it.hasNext()) {
                arrayList.add(((HashTagPageType) it.next()).getTitle());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            qUIPageTabBar.setTabData((String[]) array);
        }
        QUIPageTabBar qUIPageTabBar2 = this.quiPageTabBar;
        if (qUIPageTabBar2 != null) {
            qUIPageTabBar2.setTabChangeListener(new QUIPageTabBar.i() { // from class: gp0.b
                @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
                public final void I0(int i3, boolean z16) {
                    c.m(c.this, i3, z16);
                }
            });
        }
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final QUIPageTabBar getQuiPageTabBar() {
        return this.quiPageTabBar;
    }
}
