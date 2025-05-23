package go2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchBindView;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.al;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.util.URLUtil;
import java.util.Iterator;
import lo2.t;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f402731d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ho2.d f402732e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f402733f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ t f402734h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f402735i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ e f402736m;

        a(boolean z16, ho2.d dVar, Bundle bundle, t tVar, int i3, e eVar) {
            this.f402731d = z16;
            this.f402732e = dVar;
            this.f402733f = bundle;
            this.f402734h = tVar;
            this.f402735i = i3;
            this.f402736m = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!fb0.a.a("GuildSearchItemViewBind")) {
                boolean z16 = this.f402731d;
                ho2.d dVar = this.f402732e;
                d.a(z16, dVar.f405460f, dVar.f405459e, this.f402733f);
                al.b(this.f402734h);
                int i3 = this.f402735i;
                ho2.d dVar2 = this.f402732e;
                com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X800C023", 0, 0, dVar2.f405456b, dVar2.f405460f);
                VideoReport.reportEvent("clck", this.f402736m.getView(), null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static void c(Object obj, Object obj2, Bundle bundle) {
        int i3;
        if ((obj instanceof t) && (obj2 instanceof g)) {
            int i16 = bundle.getInt(ISearchBindView.GUILD_SEARCH_ITEM_INT_FROM_TYPE);
            boolean z16 = bundle.getBoolean(ISearchBindView.GUILD_SEARCH_ITEM_BOOLEAN_SHOW_GUILD);
            t tVar = (t) obj;
            g gVar = (g) obj2;
            LinearLayout linearLayout = (LinearLayout) gVar.p();
            ho2.d X = tVar.X();
            if (linearLayout != null && X != null) {
                linearLayout.removeAllViews();
                if (linearLayout.getParent() != null) {
                    ((View) linearLayout.getParent()).setPadding(0, 0, 0, 0);
                }
                Context context = gVar.getView().getContext();
                LayoutInflater from = LayoutInflater.from(context);
                if (tVar.Y()) {
                    i3 = R.layout.hpt;
                } else {
                    i3 = R.layout.hps;
                }
                View inflate = from.inflate(i3, (ViewGroup) null);
                e eVar = new e(inflate);
                View findViewById = inflate.findViewById(R.id.dpr);
                int dip2px = ViewUtils.dip2px(6.0f);
                findViewById.setPadding(0, dip2px, 0, dip2px);
                linearLayout.addView(inflate);
                i(tVar, X, eVar);
                g(X, context, eVar);
                l(i16, z16, tVar, eVar);
                f(X, eVar);
                h(context, X, eVar);
                com.tencent.mobileqq.search.report.b.e(null, 0, i16, "0X800C022", 0, 0, X.f405456b, X.f405460f);
                return;
            }
            QLog.e("GuildSearchItemViewBind", 1, "llContent or entity is null! entity = " + X);
            return;
        }
        QLog.e("GuildSearchItemViewBind", 1, "bindNetSearchGuild invalid params, return!");
    }

    private static void d(ho2.d dVar, e eVar) {
        int i3;
        ImageView q16 = eVar.q();
        if (q16 == null) {
            return;
        }
        Iterator<ho2.a> it = dVar.f405466l.iterator();
        if (it.hasNext()) {
            ho2.a next = it.next();
            if (next.b().b() && !TextUtils.isEmpty(next.b().a())) {
                ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading(next.b().a(), q16, com.tencent.mobileqq.urldrawable.b.f306350a);
                i3 = 0;
                q16.setVisibility(i3);
            }
        }
        i3 = 8;
        q16.setVisibility(i3);
    }

    private static void e(ho2.d dVar, e eVar) {
        ImageView o16 = eVar.o();
        ImageView p16 = eVar.p();
        if (o16 != null && p16 != null) {
            Iterator<ho2.a> it = dVar.f405466l.iterator();
            int i3 = 8;
            int i16 = 8;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ho2.a next = it.next();
                if (!next.b().b() && !TextUtils.isEmpty(next.a())) {
                    if (i16 == 8) {
                        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading(next.a(), o16, com.tencent.mobileqq.urldrawable.b.f306350a);
                        i16 = 0;
                    } else {
                        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading(next.a(), p16, com.tencent.mobileqq.urldrawable.b.f306350a);
                        i3 = 0;
                        break;
                    }
                }
            }
            o16.setVisibility(i16);
            p16.setVisibility(i3);
        }
    }

    private static void f(ho2.d dVar, e eVar) {
        TextView u16 = eVar.u();
        if (u16 != null) {
            if (!TextUtils.isEmpty(dVar.f405467m)) {
                u16.setVisibility(0);
                u16.setText(dVar.f405467m);
            } else {
                u16.setVisibility(8);
            }
        }
        ImageView s16 = eVar.s();
        if (s16 != null) {
            s16.setImageResource(dVar.f405464j.c());
        }
        ImageView r16 = eVar.r();
        if (r16 != null && !dVar.f405464j.d()) {
            r16.setVisibility(0);
        }
        d(dVar, eVar);
        e(dVar, eVar);
    }

    private static void g(ho2.d dVar, Context context, e eVar) {
        ImageView f16 = eVar.f();
        String str = dVar.f405461g;
        if (f16 != null && !TextUtils.isEmpty(str)) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int c16 = x.c(context, 50.0f);
            obtain.mRequestWidth = c16;
            obtain.mRequestHeight = c16;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            if (URLUtil.isValidUrl(str)) {
                URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
                drawable.setTag(f.a(c16, c16, x.c(context, 3.0f)));
                drawable.setDecodeHandler(f.f402737a);
                f16.setImageDrawable(drawable);
                if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                    drawable.restartDownload();
                    return;
                }
                return;
            }
            f16.setImageDrawable(colorDrawable);
        }
    }

    private static void h(final Context context, final ho2.d dVar, e eVar) {
        final QUIButton t16 = eVar.t();
        if (t16 != null) {
            VideoReport.setElementId(t16, "em_search_result_channel_join");
            VideoReport.setElementParam(t16, "sgrp_channel_id", dVar.f405469o);
            VideoReport.setElementClickPolicy(t16, ClickPolicy.REPORT_NONE);
            if (dVar.f405455a == 1) {
                t16.setEnabled(true);
                t16.setText(context.getString(R.string.f213965rm));
            } else {
                t16.setEnabled(false);
                t16.setText(context.getString(R.string.f213975rn));
            }
            t16.setOnClickListener(new View.OnClickListener() { // from class: go2.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.k(ho2.d.this, context, t16, view);
                }
            });
        }
    }

    private static void i(t tVar, ho2.d dVar, e eVar) {
        TextView k3 = eVar.k();
        if (k3 != null) {
            k3.setText(dVar.a());
        }
        TextView b16 = eVar.b();
        if (b16 != null) {
            b16.setText(SearchUtils.u0(dVar.f405456b, tVar.N, 10, true));
        }
        TextView c16 = eVar.c();
        if (c16 != null) {
            if (dVar.f405472r == 1) {
                c16.setText(SearchUtils.u0("\uff08" + dVar.f405469o + "\uff09", dVar.f405469o, Integer.MAX_VALUE, false));
                c16.setVisibility(0);
                return;
            }
            c16.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(ho2.d dVar, QUIButton qUIButton, Context context) {
        dVar.f405455a = 2;
        qUIButton.setEnabled(false);
        qUIButton.setText(context.getString(R.string.f213975rn));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(final ho2.d dVar, final Context context, final QUIButton qUIButton, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("GuildSearchItemViewBind")) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).addGuildByParam(context, new JumpGuildParam(dVar.f405460f, "", dVar.f405459e, "search", "qq_search_moreresult"), "GuildSearchItemViewBind", new Runnable() { // from class: go2.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.j(ho2.d.this, qUIButton, context);
                }
            });
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private static void l(int i3, boolean z16, t tVar, e eVar) {
        ho2.d X = tVar.X();
        Bundle bundle = new Bundle();
        bundle.putString(JumpGuildParam.EXTRA_KEY_TRACE_ID, X.f405471q.f405478f);
        bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, X.f405471q.f405473a);
        bundle.putString("sgrp_stream_pgin_source", "20");
        bundle.putString("sgrp_stream_pgin_source_name", "functional_qq_search");
        bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_TITLE_RECALL_QUERY, "1");
        bundle.putString("sgrp_search_source", "qq_search");
        if (X.f405455a == 1) {
            bundle.putString("sgrp_join_channel_state", "0");
        } else {
            bundle.putString("sgrp_join_channel_state", "1");
        }
        eVar.getView().setOnClickListener(new a(z16, X, bundle, tVar, i3, eVar));
    }
}
