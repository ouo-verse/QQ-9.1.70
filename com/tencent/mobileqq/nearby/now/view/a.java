package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends BaseAdapter {
    private VideoData C;
    private s92.a D;
    private Context E;
    private Paint F;
    private int G;

    /* renamed from: h, reason: collision with root package name */
    private LayoutInflater f252862h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f252863i;

    /* renamed from: m, reason: collision with root package name */
    private Comments f252864m;

    /* renamed from: d, reason: collision with root package name */
    private final String f252859d = "CommentsAdapter";

    /* renamed from: e, reason: collision with root package name */
    private int f252860e = 1;

    /* renamed from: f, reason: collision with root package name */
    private int f252861f = 2;
    private boolean H = false;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.nearby.now.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    class ViewOnClickListenerC8141a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f252865d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f252866e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f252867f;

        ViewOnClickListenerC8141a(long j3, long j16, long j17) {
            this.f252865d = j3;
            this.f252866e = j16;
            this.f252867f = j17;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QQAppInterface qQAppInterface;
            Context context = view.getContext();
            int i3 = ((context instanceof BaseActivity) && (qQAppInterface = ((BaseActivity) context).app) != null && this.f252865d == Long.parseLong(qQAppInterface.getCurrentAccountUin())) ? 2 : 3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("&from=3");
            sb5.append("&mode=" + i3);
            sb5.append("&now_id=" + this.f252866e);
            sb5.append("&now_user_type=" + this.f252867f);
            view.getContext().startActivity(new Intent(view.getContext(), (Class<?>) JumpActivity.class).setData(Uri.parse("mqq://card/show_pslcard/?uin=" + this.f252865d + "&card_type=nearby" + sb5.toString())));
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f252864m.f252665f.clear();
            a.this.D.i();
        }
    }

    public a(Context context, Comments comments, VideoData videoData, s92.a aVar, Paint paint, int i3) {
        this.E = context;
        this.f252862h = LayoutInflater.from(context);
        this.f252864m = comments;
        this.C = videoData;
        this.D = aVar;
        this.F = paint;
        this.G = i3;
    }

    public boolean c(Comments.Comment comment) {
        return this.f252864m.a(comment);
    }

    public void e(boolean z16) {
        this.H = z16;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Comments.Comment> list = this.f252864m.f252665f;
        if (list == null || list.size() <= 0) {
            return 1;
        }
        return this.f252864m.f252665f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Comments.Comment getItem(int i3) {
        if (i3 < 0 || i3 >= this.f252864m.f252665f.size()) {
            return null;
        }
        return this.f252864m.f252665f.get(i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        c cVar;
        if (QLog.isColorLevel()) {
            QLog.d("CommentsAdapter", 2, "getview position is: " + i3);
        }
        List<Comments.Comment> list = this.f252864m.f252665f;
        if (list != null && list.size() > 0) {
            if (view != null && (view.getTag() instanceof c)) {
                view2 = view;
                cVar = (c) view.getTag();
            } else {
                c cVar2 = new c();
                View inflate = this.f252862h.inflate(R.layout.axm, viewGroup, false);
                cVar2.f252870a = (ImageView) inflate.findViewById(R.id.dut);
                cVar2.f252871b = (TextView) inflate.findViewById(R.id.tv_name);
                cVar2.f252872c = (TextView) inflate.findViewById(R.id.k6s);
                cVar2.f252873d = (TextView) inflate.findViewById(R.id.k_f);
                cVar2.f252874e = (ImageView) inflate.findViewById(R.id.d7u);
                cVar2.f252875f = (ImageView) inflate.findViewById(R.id.c2r);
                cVar2.f252876g = (ImageView) inflate.findViewById(R.id.jte);
                inflate.setTag(R.id.b46, cVar2);
                view2 = inflate;
                cVar = cVar2;
            }
            cVar.f252871b.setText(this.f252864m.f252665f.get(i3).f252671i);
            if (this.f252864m.f252665f.get(i3).G <= 0 && this.f252864m.f252665f.get(i3).J <= 0) {
                cVar.a(this.f252864m.f252665f.get(i3).f252668e);
            } else {
                cVar.b(this.f252864m.f252665f.get(i3).F, this.f252864m.f252665f.get(i3).f252668e);
            }
            cVar.d(this.f252864m.f252665f.get(i3).f252669f);
            QQAppInterface qQAppInterface = ((BaseActivity) this.E).app;
            String str = this.f252864m.f252665f.get(i3).C;
            String valueOf = String.valueOf(this.f252864m.f252665f.get(i3).f252672m);
            if ((str == null || str.isEmpty()) && valueOf.equals(qQAppInterface.getCurrentAccountUin())) {
                cVar.f252870a.setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface, 32, valueOf, 3, cVar.f252870a.getResources().getDrawable(R.drawable.exy), cVar.f252870a.getResources().getDrawable(R.drawable.exy)));
            } else {
                ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage(cVar.f252870a, this.f252864m.f252665f.get(i3).C, cVar.f252870a.getResources().getDrawable(R.drawable.exy), cVar.f252870a.getResources().getDrawable(R.drawable.exy), null, true);
            }
            cVar.c(this.f252864m.f252665f.get(i3).K, this.G, this.F, this.H);
            cVar.f252870a.setOnClickListener(new ViewOnClickListenerC8141a(this.f252864m.f252665f.get(i3).f252672m, this.f252864m.f252665f.get(i3).E, this.f252864m.f252665f.get(i3).D));
            if (this.f252864m.f252665f.get(i3).f252670h == 2) {
                cVar.f252876g.setVisibility(0);
            }
            view2.setTag(R.id.b3x, this.f252864m.f252665f.get(i3));
            view2.setTag(R.id.b5_, this.f252864m);
            return view2;
        }
        if (this.C.a()) {
            View view3 = new View(this.E);
            view3.setLayoutParams(new AbsListView.LayoutParams(0, 0));
            return view3;
        }
        if (this.f252863i) {
            View inflate2 = (view != null && (view.getTag() instanceof String) && "badnet".equals((String) view.getTag())) ? view : this.f252862h.inflate(R.layout.axc, viewGroup, false);
            inflate2.setBackgroundColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            inflate2.findViewById(R.id.ee5).setOnClickListener(new b());
            inflate2.setTag("badnet");
            return inflate2;
        }
        if (view != null && (view.getTag() instanceof String) && GlobalUtil.DEF_STRING.equals((String) view.getTag())) {
            return view;
        }
        View inflate3 = this.f252862h.inflate(R.layout.axd, viewGroup, false);
        inflate3.setTag(GlobalUtil.DEF_STRING);
        return inflate3;
    }
}
