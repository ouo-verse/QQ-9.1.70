package f43;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqgift.data.service.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vasgift.mvvm.business.QQGiftPanelViewModel;
import com.tencent.mobileqq.webview.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends RecyclerView.Adapter<e> {
    protected final QQGiftPanelViewModel D;

    /* renamed from: m, reason: collision with root package name */
    protected final Context f397833m;
    protected final List<List<com.tencent.mobileqq.qqgift.data.service.d>> C = new ArrayList();
    protected com.tencent.mobileqq.qqgift.mvvm.business.data.b E = new com.tencent.mobileqq.qqgift.mvvm.business.data.b(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f397834d;

        a(int i3) {
            this.f397834d = i3;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            List<com.tencent.mobileqq.qqgift.data.service.d> list;
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            c cVar = c.this;
            if (cVar.D != null) {
                int size = cVar.C.size();
                int i16 = this.f397834d;
                if (size > i16 && (list = c.this.C.get(i16)) != null && list.size() > i3) {
                    com.tencent.mobileqq.qqgift.data.service.d dVar = list.get(i3);
                    c.this.D.h0(dVar, i3);
                    c.this.D.s3(dVar, view);
                }
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements AdapterView.OnItemLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f397836d;

        b(int i3) {
            this.f397836d = i3;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            List<com.tencent.mobileqq.qqgift.data.service.d> list;
            EventCollector.getInstance().onItemLongClickBefore(adapterView, view, i3, j3);
            c cVar = c.this;
            if (cVar.D != null) {
                int size = cVar.C.size();
                int i16 = this.f397836d;
                if (size > i16 && (list = c.this.C.get(i16)) != null && list.size() > i3) {
                    c.this.D.w(list.get(i3), i3);
                }
            }
            EventCollector.getInstance().onItemLongClick(adapterView, view, i3, j3);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: f43.c$c, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C10280c extends com.tencent.mobileqq.qqgift.webview.d {
        C10280c(Activity activity, AppInterface appInterface, TouchWebView touchWebView) {
            super(activity, appInterface, touchWebView);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f397839d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e.a f397840e;

        d(TextView textView, e.a aVar) {
            this.f397839d = textView;
            this.f397840e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!c.this.D.W2(view)) {
                Intent intent = new Intent(this.f397839d.getContext(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", this.f397840e.f264902c);
                this.f397839d.getContext().startActivity(intent);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class e extends RecyclerView.ViewHolder {
        public GridView E;
        public int F;

        public e(View view) {
            super(view);
            this.E = null;
            this.F = 0;
        }
    }

    public c(Context context, QQGiftPanelViewModel qQGiftPanelViewModel) {
        this.f397833m = context;
        this.D = qQGiftPanelViewModel;
    }

    private void i0(View view, int i3) {
        List<com.tencent.mobileqq.qqgift.data.service.d> list;
        try {
            com.tencent.mobileqq.vasgift.business.dt.a B2 = this.D.B2();
            if (this.C.size() > i3 && (list = this.C.get(i3)) != null && !list.isEmpty()) {
                com.tencent.mobileqq.qqgift.data.service.d dVar = list.get(0);
                B2.i(view, dVar.V, dVar.U, i3);
            }
        } catch (Exception e16) {
            QLog.e("QQGiftPanelPageAdapter", 1, e16.toString());
        }
    }

    private void j0(TextView textView) {
        if (q0()) {
            Drawable drawable = textView.getResources().getDrawable(R.drawable.f161931nk4);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.setColorFilter(this.E.f264954b, PorterDuff.Mode.SRC_ATOP);
            textView.setCompoundDrawables(null, null, drawable, null);
            textView.setCompoundDrawablePadding(ViewUtils.dip2px(6.0f));
        }
    }

    private boolean n0(@NonNull e eVar, List<com.tencent.mobileqq.qqgift.data.service.d> list) {
        int i3;
        int i16;
        int i17;
        int i18 = 0;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        TextView textView = (TextView) eVar.itemView.findViewById(R.id.f107716b6);
        TextView textView2 = (TextView) eVar.itemView.findViewById(R.id.f107686b3);
        TextView textView3 = (TextView) eVar.itemView.findViewById(R.id.f110306i6);
        e.a L2 = this.D.L2();
        if (textView != null) {
            textView.setTextColor(this.E.f264955c);
            textView.setText(R.string.f209945gs);
            if (textView2 != null && L2 != null) {
                if (!TextUtils.isEmpty(L2.f264900a)) {
                    textView.setText(L2.f264900a);
                }
                if (!TextUtils.isEmpty(L2.f264901b) && !TextUtils.isEmpty(L2.f264902c)) {
                    if (!r0()) {
                        i16 = 0;
                    } else {
                        i16 = 8;
                    }
                    textView2.setVisibility(i16);
                    textView2.setTextColor(this.E.f264954b);
                    textView2.setText(L2.f264901b);
                    j0(textView2);
                    u0(textView2);
                    d dVar = new d(textView2, L2);
                    textView2.setOnClickListener(dVar);
                    if (textView3 != null) {
                        if (!TextUtils.isEmpty(L2.f264901b)) {
                            textView3.setText(L2.f264901b);
                        }
                        if (r0()) {
                            i17 = 0;
                        } else {
                            i17 = 8;
                        }
                        textView3.setVisibility(i17);
                        textView3.setOnClickListener(dVar);
                    }
                }
            }
            View findViewById = eVar.itemView.findViewById(R.id.y2q);
            if (findViewById != null) {
                if (r0()) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                findViewById.setVisibility(i3);
            }
            View findViewById2 = eVar.itemView.findViewById(R.id.y7h);
            if (findViewById2 != null) {
                if (!r0()) {
                    i18 = 8;
                }
                findViewById2.setVisibility(i18);
            }
            if (r0()) {
                textView.setText(R.string.f209965gu);
                return true;
            }
            return true;
        }
        return true;
    }

    private boolean o0(@NonNull e eVar, int i3) {
        e.a aVar;
        if (eVar.F == -2) {
            TouchWebView touchWebView = (TouchWebView) eVar.itemView.findViewById(R.id.f643435z);
            com.tencent.mobileqq.qqgift.data.service.e T2 = this.D.T2(i3);
            if (touchWebView != null && T2 != null && (aVar = T2.f264899f) != null && !TextUtils.isEmpty(aVar.f264902c)) {
                p0(touchWebView, (Activity) this.f397833m, T2.f264899f.f264902c);
                return true;
            }
            return true;
        }
        return false;
    }

    private void p0(TouchWebView touchWebView, Activity activity, String str) {
        C10280c c10280c = new C10280c(activity, com.tencent.mobileqq.qqgift.utils.a.a(), touchWebView);
        c10280c.setTimeBeforeLoadUrl(System.currentTimeMillis());
        new m(c10280c).a(null, com.tencent.mobileqq.qqgift.utils.a.a(), null);
        TouchWebView touchWebView2 = (TouchWebView) c10280c.getWebView();
        touchWebView2.setWillNotCacheDrawing(false);
        touchWebView2.setDrawingCacheEnabled(true);
        touchWebView2.loadUrl(str);
    }

    private boolean q0() {
        QQGiftPanelViewModel qQGiftPanelViewModel = this.D;
        if (qQGiftPanelViewModel == null || qQGiftPanelViewModel.H2() == null || this.D.H2().getSDKConfig() == null) {
            return false;
        }
        if (this.D.H2().getSDKConfig().f264972a != 10016 && this.D.H2().getSDKConfig().f264972a != 10006) {
            return false;
        }
        return true;
    }

    private boolean r0() {
        QQGiftPanelViewModel qQGiftPanelViewModel = this.D;
        if (qQGiftPanelViewModel == null || qQGiftPanelViewModel.H2() == null || this.D.H2().getSDKConfig() == null) {
            return false;
        }
        if (this.D.H2().getSDKConfig().f264972a != 10011 && this.D.H2().getSDKConfig().f264972a != 10008) {
            return false;
        }
        return true;
    }

    private void u0(View view) {
        this.D.B2().o(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        com.tencent.mobileqq.qqgift.data.service.e T2;
        QQGiftPanelViewModel qQGiftPanelViewModel = this.D;
        if (qQGiftPanelViewModel != null && (T2 = qQGiftPanelViewModel.T2(i3)) != null && "WELFARE_TAB_ID".equals(T2.f264894a)) {
            return -2;
        }
        if (this.C.get(i3) != null && !this.C.get(i3).isEmpty()) {
            return super.getItemViewType(i3);
        }
        return -1;
    }

    protected f43.b k0(Context context, com.tencent.mobileqq.vasgift.mvvm.business.a aVar) {
        return new f43.b(context, aVar);
    }

    protected int l0() {
        return 0;
    }

    protected int m0() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull e eVar, int i3) {
        i0(eVar.E, i3);
        List<com.tencent.mobileqq.qqgift.data.service.d> list = this.C.get(i3);
        if (o0(eVar, i3) || n0(eVar, list)) {
            return;
        }
        ListAdapter adapter = eVar.E.getAdapter();
        if (adapter instanceof f43.b) {
            f43.b bVar = (f43.b) adapter;
            bVar.b(list, i3, this.E);
            bVar.notifyDataSetChanged();
        } else {
            f43.b k06 = k0(this.f397833m, this.D);
            k06.b(list, i3, this.E);
            eVar.E.setAdapter((ListAdapter) k06);
        }
        eVar.E.setOnItemClickListener(new a(i3));
        eVar.E.setOnItemLongClickListener(new b(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        int i16;
        if (-1 == i3) {
            FrameLayout frameLayout = new FrameLayout(this.f397833m);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            View.inflate(this.f397833m, R.layout.h8z, frameLayout);
            e eVar = new e(frameLayout);
            eVar.F = -1;
            return eVar;
        }
        if (-2 == i3) {
            FrameLayout frameLayout2 = new FrameLayout(this.f397833m);
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            View.inflate(this.f397833m, R.layout.h8y, frameLayout2);
            e eVar2 = new e(frameLayout2);
            eVar2.F = -2;
            return eVar2;
        }
        GridView gridView = new GridView(this.f397833m);
        gridView.setGravity(17);
        if (((IVasTempApi) QRoute.api(IVasTempApi.class)).isTabletDevice(this.f397833m)) {
            i16 = 5;
        } else {
            i16 = 4;
        }
        gridView.setNumColumns(i16);
        gridView.setVerticalSpacing(m0());
        gridView.setHorizontalSpacing(l0());
        gridView.setSelector(new ColorDrawable(0));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        gridView.setPadding(ViewUtils.dip2px(12.5f), ViewUtils.dip2px(12.5f), ViewUtils.dip2px(12.5f), 0);
        gridView.setLayoutParams(layoutParams);
        e eVar3 = new e(gridView);
        eVar3.E = gridView;
        return eVar3;
    }

    public void updateData(List<List<com.tencent.mobileqq.qqgift.data.service.d>> list) {
        this.C.clear();
        this.C.addAll(list);
    }

    public void v0(com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar) {
        this.E = bVar;
    }
}
