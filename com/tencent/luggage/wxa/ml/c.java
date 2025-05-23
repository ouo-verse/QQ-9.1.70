package com.tencent.luggage.wxa.ml;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.ml.b {

    /* renamed from: g0, reason: collision with root package name */
    public final String f134623g0;

    /* renamed from: h0, reason: collision with root package name */
    public final String f134624h0;

    /* renamed from: i0, reason: collision with root package name */
    public AuthorizeItemListView f134625i0;

    /* renamed from: j0, reason: collision with root package name */
    public e f134626j0;

    /* renamed from: k0, reason: collision with root package name */
    public LinearLayout f134627k0;

    /* renamed from: l0, reason: collision with root package name */
    public Context f134628l0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f134629a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f134630b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ml.b f134631c;

        public a(ArrayList arrayList, d dVar, com.tencent.luggage.wxa.ml.b bVar) {
            this.f134629a = arrayList;
            this.f134630b = dVar;
            this.f134631c = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f134629a.size(); i3++) {
                if (((f) this.f134629a.get(i3)).f134646b == 2 || ((f) this.f134629a.get(i3)).f134646b == 3) {
                    arrayList.add(((f) this.f134629a.get(i3)).f134645a);
                }
            }
            w.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
            this.f134630b.a(1, arrayList);
            this.f134631c.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f134633a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f134634b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ml.b f134635c;

        public b(ArrayList arrayList, d dVar, com.tencent.luggage.wxa.ml.b bVar) {
            this.f134633a = arrayList;
            this.f134634b = dVar;
            this.f134635c = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f134633a.size(); i3++) {
                if (((f) this.f134633a.get(i3)).f134646b == 2 || ((f) this.f134633a.get(i3)).f134646b == 3) {
                    arrayList.add(((f) this.f134633a.get(i3)).f134645a);
                }
            }
            w.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
            this.f134634b.a(2, arrayList);
            this.f134635c.dismiss();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ml.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterfaceOnCancelListenerC6480c implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f134637a;

        public DialogInterfaceOnCancelListenerC6480c(d dVar) {
            this.f134637a = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            w.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
            this.f134637a.a(3, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a(int i3, ArrayList arrayList);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f134639a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f134640a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ImageView f134641b;

            public a(f fVar, ImageView imageView) {
                this.f134640a = fVar;
                this.f134641b = imageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = this.f134640a.f134646b;
                if (i3 == 2) {
                    this.f134641b.setImageResource(R.drawable.ojo);
                    this.f134640a.f134646b = 1;
                } else if (i3 == 1) {
                    this.f134641b.setImageResource(R.drawable.ojm);
                    this.f134640a.f134646b = 2;
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public ImageView f134643a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f134644b;

            public b() {
            }

            public /* synthetic */ b(a aVar) {
                this();
            }
        }

        public e(ArrayList arrayList) {
            this.f134639a = arrayList;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f getItem(int i3) {
            return (f) this.f134639a.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList arrayList = this.f134639a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            ArrayList arrayList = this.f134639a;
            a aVar = null;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            f item = getItem(i3);
            if (view == null) {
                bVar = new b(aVar);
                view2 = View.inflate(viewGroup.getContext(), R.layout.dzg, null);
                bVar.f134643a = (ImageView) view2.findViewById(R.id.sqi);
                bVar.f134644b = (TextView) view2.findViewById(R.id.sqh);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            int i16 = item.f134646b;
            if (i16 == 1) {
                bVar.f134643a.setImageResource(R.drawable.ojo);
            } else if (i16 == 3) {
                bVar.f134643a.setImageResource(R.drawable.ojn);
            } else {
                bVar.f134643a.setImageResource(R.drawable.ojm);
            }
            bVar.f134644b.setText(item.f134647c);
            ImageView imageView = bVar.f134643a;
            imageView.setOnClickListener(new a(item, imageView));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public String f134645a;

        /* renamed from: b, reason: collision with root package name */
        public int f134646b;

        /* renamed from: c, reason: collision with root package name */
        public String f134647c;
    }

    public c(Context context, List list, String str, String str2, d dVar) {
        super(context, R.style.ayk);
        this.f134628l0 = context;
        this.f134624h0 = w0.d(str);
        this.f134623g0 = str2;
        a(a(list), dVar);
    }

    public static ArrayList a(List list) {
        if (list instanceof ArrayList) {
            return (ArrayList) list;
        }
        return new ArrayList(list);
    }

    public final void a(ArrayList arrayList, d dVar) {
        if (arrayList != null && arrayList.size() > 0) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f134628l0).inflate(R.layout.dxk, (ViewGroup) null);
            setContentView(viewGroup);
            AppBrandSimpleImageLoader.instance().attach((ImageView) viewGroup.findViewById(R.id.stm), this.f134623g0, R.drawable.ojy, WxaIconTransformation.INSTANCE);
            ((TextView) viewGroup.findViewById(R.id.stq)).setText(this.f134628l0.getString(R.string.f16348239, this.f134624h0));
            this.f134625i0 = (AuthorizeItemListView) viewGroup.findViewById(R.id.sxk);
            e eVar = new e(arrayList);
            this.f134626j0 = eVar;
            this.f134625i0.setAdapter((ListAdapter) eVar);
            if (arrayList.size() > 5) {
                this.f134625i0.f152626a = arrayList.size();
                LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.sxx);
                this.f134627k0 = linearLayout;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.height = this.f134628l0.getResources().getDimensionPixelSize(R.dimen.ck6);
                this.f134627k0.setLayoutParams(layoutParams);
            }
            ((Button) viewGroup.findViewById(R.id.ytr)).setOnClickListener(new a(arrayList, dVar, this));
            ((Button) viewGroup.findViewById(R.id.yui)).setOnClickListener(new b(arrayList, dVar, this));
            setCanceledOnTouchOutside(false);
            setOnCancelListener(new DialogInterfaceOnCancelListenerC6480c(dVar));
            return;
        }
        throw new IllegalArgumentException("scopeInfoList is empty or null");
    }
}
