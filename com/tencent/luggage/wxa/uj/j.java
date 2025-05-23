package com.tencent.luggage.wxa.uj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final String f142489a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f142490b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f142491c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f142497b;

        public b(k kVar) {
            this.f142497b = kVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            j.this.c();
            this.f142497b.a(true);
            j.this.notifyDataSetChanged();
        }
    }

    public j(String appId, Context context, ArrayList phoneItems) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(phoneItems, "phoneItems");
        this.f142489a = appId;
        this.f142490b = context;
        this.f142491c = phoneItems;
    }

    public final ArrayList b() {
        return this.f142491c;
    }

    public final void c() {
        Iterator it = this.f142491c.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f142491c.size();
    }

    public final Context a() {
        return this.f142490b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object obj = this.f142491c.get(i3);
        Intrinsics.checkNotNullExpressionValue(obj, "phoneItems[position]");
        k kVar = (k) obj;
        holder.a(kVar);
        if (kVar.i()) {
            return;
        }
        holder.itemView.setOnClickListener(new b(kVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View v3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.dy5, parent, false);
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        return new a(this, v3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public final j f142492a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f142493b;

        /* renamed from: c, reason: collision with root package name */
        public final TextView f142494c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f142495d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j adapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(view, "view");
            this.f142492a = adapter;
            View findViewById = view.findViewById(R.id.f245309d);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.p\u2026anager_dialog_item_phone)");
            this.f142493b = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.f245409e);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.p\u2026nager_dialog_item_remark)");
            this.f142494c = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.f245109b);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.p\u2026anager_dialog_item_check)");
            this.f142495d = (ImageView) findViewById3;
        }

        public final void a(k phoneItem) {
            Intrinsics.checkNotNullParameter(phoneItem, "phoneItem");
            this.f142493b.setText(phoneItem.h());
            if (a(phoneItem.f())) {
                StringBuilder sb5 = new StringBuilder();
                int length = phoneItem.f().length() - 1;
                for (int i3 = 0; i3 < length; i3++) {
                    sb5.append(phoneItem.f().charAt(i3));
                    sb5.append(TokenParser.SP);
                }
                sb5.append(phoneItem.f().charAt(length));
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
                this.f142493b.setContentDescription(sb6);
            }
            if (phoneItem.j()) {
                this.f142494c.setText(this.f142492a.a().getString(R.string.z4j));
            } else {
                this.f142494c.setText("");
            }
            this.f142495d.setVisibility(phoneItem.i() ? 0 : 8);
            if (phoneItem.i()) {
                this.f142495d.setContentDescription(this.f142492a.a().getString(R.string.f161511xx));
            }
        }

        public final boolean a(String str) {
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (!Character.isDigit(str.charAt(i3))) {
                    return false;
                }
            }
            return true;
        }
    }
}
