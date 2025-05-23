package as;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import as.a;
import com.tencent.mobileqq.R;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends as.a {

    /* renamed from: e, reason: collision with root package name */
    public final int f26828e;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends a.AbstractC0067a<b> {

        /* renamed from: d, reason: collision with root package name */
        public final TextView f26829d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f26830e;

        /* renamed from: f, reason: collision with root package name */
        public final TextView f26831f;

        a(Context context, ViewGroup viewGroup) {
            super(context, viewGroup);
            this.f26829d = (TextView) this.f26825a.findViewById(R.id.jfb);
            this.f26830e = (ImageView) this.f26825a.findViewById(R.id.image);
            this.f26831f = (TextView) this.f26825a.findViewById(R.id.jh7);
        }

        @Override // as.a.AbstractC0067a
        protected View b(Context context, ViewGroup viewGroup) {
            return LayoutInflater.from(context).inflate(R.layout.b68, viewGroup, false);
        }

        @Override // as.a.AbstractC0067a
        public void c() {
            super.c();
            this.f26829d.setVisibility(4);
            this.f26830e.setVisibility(4);
        }

        @Override // as.a.AbstractC0067a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(b bVar, int i3) {
            super.a(bVar, i3);
            T t16 = this.f26826b;
            if (t16 != 0 && ((b) t16).f26828e != 0 && ((b) t16).f26822b != null) {
                this.f26830e.setVisibility(0);
                this.f26830e.setImageResource(((b) this.f26826b).f26828e);
                this.f26829d.setVisibility(0);
                this.f26829d.setText(((b) this.f26826b).f26822b);
                this.f26831f.setText(((b) this.f26826b).f26824d);
                return;
            }
            this.f26830e.setVisibility(4);
            this.f26829d.setVisibility(4);
            this.f26831f.setText("");
        }
    }

    public b(String str, int i3, int i16, int i17) {
        super(i17, str, i3);
        this.f26828e = i16;
    }

    @Override // as.a
    public a.AbstractC0067a a(Context context, ViewGroup viewGroup) {
        return new a(context, viewGroup);
    }

    @Override // as.a
    public Class<? extends a.AbstractC0067a> b() {
        return a.class;
    }

    @Override // as.a
    public String toString() {
        int i3 = this.f26821a;
        if (i3 == 0) {
            return "normal";
        }
        if (i3 == 1) {
            return "rewind";
        }
        if (i3 == 2) {
            return VideoConverterConfig.SoftwareConfig.PRESET_FAST;
        }
        if (i3 == 3) {
            return VideoConverterConfig.SoftwareConfig.PRESET_SLOW;
        }
        if (i3 == 8) {
            return "little fast";
        }
        if (i3 != 9) {
            return "";
        }
        return "very slow";
    }
}
