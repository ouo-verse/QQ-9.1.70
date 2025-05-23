package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.teamwork.s;
import com.tencent.pb.teamwork.TimDocSSOMsg$UinRightInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XBaseAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes18.dex */
public class s extends XBaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    List<b> f292319d;

    /* renamed from: e, reason: collision with root package name */
    Map<String, b> f292320e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    Context f292321f;

    /* renamed from: h, reason: collision with root package name */
    QQAppInterface f292322h;

    /* renamed from: i, reason: collision with root package name */
    View.OnClickListener f292323i;

    /* renamed from: m, reason: collision with root package name */
    int f292324m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public URLImageView f292325a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f292326b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f292327c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f292328d;

        /* renamed from: e, reason: collision with root package name */
        public TimDocSSOMsg$UinRightInfo f292329e;

        public a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public TimDocSSOMsg$UinRightInfo f292331a;

        /* renamed from: b, reason: collision with root package name */
        public String f292332b;

        /* renamed from: c, reason: collision with root package name */
        public int f292333c;

        /* renamed from: d, reason: collision with root package name */
        public String f292334d;

        /* renamed from: e, reason: collision with root package name */
        public String f292335e;
    }

    public s(QQAppInterface qQAppInterface, Context context, View.OnClickListener onClickListener, List<b> list) {
        this.f292322h = qQAppInterface;
        this.f292319d = list;
        this.f292321f = context;
        this.f292323i = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit g(String str, Function1 function1, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.f292320e.get(str).f292335e = str2;
        }
        return (Unit) function1.invoke(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit h(a aVar, String str) {
        aVar.f292326b.setText(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(b bVar, String str) {
        bVar.f292335e = str;
        notifyDataSetChanged();
        return null;
    }

    public void d(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f292319d.add(0, bVar);
        this.f292320e.put(bVar.f292332b, bVar);
    }

    public void e(String str) {
        this.f292319d.remove(this.f292320e.remove(str));
    }

    public void f(final String str, final Function1<String, Unit> function1) {
        b bVar = this.f292320e.get(str);
        if (bVar == null) {
            function1.invoke(str);
        } else {
            com.tencent.mobileqq.utils.ac.c0(this.f292322h, bVar.f292332b, bVar.f292334d, bVar.f292333c, new Function1() { // from class: com.tencent.mobileqq.teamwork.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit g16;
                    g16 = s.this.g(str, function1, (String) obj);
                    return g16;
                }
            });
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f292319d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f292319d.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        final a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f292321f).inflate(R.layout.c0a, (ViewGroup) null);
            aVar = new a();
            aVar.f292325a = (URLImageView) view.findViewById(R.id.f165682d51);
            aVar.f292326b = (TextView) view.findViewById(R.id.f97);
            aVar.f292327c = (TextView) view.findViewById(R.id.j1x);
            aVar.f292328d = (ImageView) view.findViewById(R.id.f164481za);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.f292324m == 2) {
            aVar.f292327c.setVisibility(8);
            aVar.f292328d.setVisibility(8);
        } else {
            aVar.f292327c.setVisibility(0);
            aVar.f292328d.setVisibility(0);
        }
        b bVar = (b) getItem(i3);
        String valueOf = String.valueOf(bVar.f292331a.uint64_uin.get());
        aVar.f292325a.setImageDrawable(FaceDrawable.getFaceDrawable(this.f292322h, 1, valueOf));
        f(valueOf, new Function1() { // from class: com.tencent.mobileqq.teamwork.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h16;
                h16 = s.h(s.a.this, (String) obj);
                return h16;
            }
        });
        int i16 = bVar.f292331a.uint32_right.get();
        if (i16 == 1) {
            aVar.f292327c.setText(R.string.hxe);
        } else if (i16 == 2) {
            aVar.f292327c.setText(R.string.hxf);
        } else {
            aVar.f292327c.setText(HardCodeUtil.qqStr(R.string.u0x));
        }
        aVar.f292329e = bVar.f292331a;
        view.setOnClickListener(this.f292323i);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public void j(int i3) {
        this.f292324m = i3;
    }

    public void k(String str) {
        final b bVar = this.f292320e.get(str);
        if (bVar == null) {
            return;
        }
        f(str, new Function1() { // from class: com.tencent.mobileqq.teamwork.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i3;
                i3 = s.this.i(bVar, (String) obj);
                return i3;
            }
        });
    }
}
