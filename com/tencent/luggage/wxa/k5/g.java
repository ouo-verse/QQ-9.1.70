package com.tencent.luggage.wxa.k5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g extends RecyclerView.ViewHolder {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends g {

        /* renamed from: a, reason: collision with root package name */
        public final LinearLayout f131494a;

        /* renamed from: b, reason: collision with root package name */
        public final ImageView f131495b;

        /* renamed from: c, reason: collision with root package name */
        public final TextView f131496c;

        /* renamed from: d, reason: collision with root package name */
        public final TextView f131497d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(ViewGroup parent) {
            super(r4, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dyn, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026ader_item, parent, false)");
            this.f131494a = (LinearLayout) this.itemView.findViewById(R.id.sto);
            this.f131495b = (ImageView) this.itemView.findViewById(R.id.f164380vl);
            this.f131496c = (TextView) this.itemView.findViewById(R.id.f164390w1);
            this.f131497d = (TextView) this.itemView.findViewById(R.id.f114816uc);
        }

        public final ImageView a() {
            return this.f131495b;
        }

        public final LinearLayout b() {
            return this.f131494a;
        }

        public final TextView c() {
            return this.f131496c;
        }

        public final TextView d() {
            return this.f131497d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends g {

        /* renamed from: a, reason: collision with root package name */
        public final Button f131498a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(ViewGroup parent) {
            super(r4, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dyp, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026nage_item, parent, false)");
            this.f131498a = (Button) this.itemView.findViewById(R.id.ywq);
        }

        public final Button a() {
            return this.f131498a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends g {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f131499a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(ViewGroup parent) {
            super(r4, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dyq, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026itle_item, parent, false)");
            this.f131499a = (TextView) this.itemView.findViewById(R.id.f26010cd);
        }

        public final TextView a() {
            return this.f131499a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends g {

        /* renamed from: a, reason: collision with root package name */
        public final ImageView f131500a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f131501b;

        /* renamed from: c, reason: collision with root package name */
        public final TextView f131502c;

        /* renamed from: d, reason: collision with root package name */
        public final TextView f131503d;

        /* renamed from: e, reason: collision with root package name */
        public final LinearLayout f131504e;

        /* renamed from: f, reason: collision with root package name */
        public final Button f131505f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d(ViewGroup parent) {
            super(r4, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dyo, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026info_item, parent, false)");
            this.f131500a = (ImageView) this.itemView.findViewById(R.id.f115336vr);
            this.f131501b = (TextView) this.itemView.findViewById(R.id.f115356vt);
            this.f131502c = (TextView) this.itemView.findViewById(R.id.f115326vq);
            this.f131503d = (TextView) this.itemView.findViewById(R.id.f115386vw);
            this.f131504e = (LinearLayout) this.itemView.findViewById(R.id.f115376vv);
            this.f131505f = (Button) this.itemView.findViewById(R.id.bfq);
        }

        public final Button a() {
            return this.f131505f;
        }

        public final LinearLayout b() {
            return this.f131504e;
        }

        public final TextView c() {
            return this.f131502c;
        }

        public final ImageView d() {
            return this.f131500a;
        }

        public final TextView e() {
            return this.f131501b;
        }

        public final TextView f() {
            return this.f131503d;
        }
    }

    public /* synthetic */ g(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    public g(View view) {
        super(view);
    }
}
