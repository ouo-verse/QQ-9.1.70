package mx2;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBBoolField;
import mx2.d;
import nx2.i;
import tvideo.TVideoChannelList$VideoChannelData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends d {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    protected class a extends d.a {
        View I;
        TextView J;

        public a(@NonNull View view) {
            super(view);
            this.I = view.findViewById(R.id.ts9);
            this.J = (TextView) view.findViewById(R.id.tsa);
        }

        private void r(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData) {
            String str;
            if (TextUtils.isEmpty(tVideoChannelList$VideoChannelData.red_dot_text.get())) {
                this.I.setVisibility(0);
                this.J.setVisibility(4);
                return;
            }
            this.I.setVisibility(4);
            this.J.setVisibility(0);
            TextView textView = this.J;
            if (tVideoChannelList$VideoChannelData.red_dot_text.get() == null) {
                str = "";
            } else {
                str = tVideoChannelList$VideoChannelData.red_dot_text.get();
            }
            textView.setText(str);
        }

        @Override // mx2.d.a
        public void m(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData, int i3) {
            if (f.this.p0(tVideoChannelList$VideoChannelData)) {
                r(tVideoChannelList$VideoChannelData);
            } else {
                this.I.setVisibility(4);
                this.J.setVisibility(4);
            }
            super.m(tVideoChannelList$VideoChannelData, i3);
        }

        @Override // mx2.d.a
        protected void p(int i3) {
            d.a aVar = f.this.D;
            if (aVar != null) {
                aVar.q();
            }
            f fVar = f.this;
            fVar.E = i3;
            fVar.D = this;
            TextView textView = this.F;
            textView.setTextColor(textView.getContext().getColor(R.color.f158017al3));
            if (this.I.getVisibility() == 0 || this.J.getVisibility() == 0) {
                this.I.setVisibility(4);
                this.J.setVisibility(4);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mx2.d.a
        public void q() {
            TextView textView = this.F;
            textView.setTextColor(textView.getContext().getColor(R.color.al6));
            f fVar = f.this;
            i.b bVar = fVar.F;
            if (bVar != null) {
                bVar.a(fVar.C, this.F);
            }
        }
    }

    public f(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override // mx2.d
    protected String l0() {
        return "vertical";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ghb, viewGroup, false));
    }

    protected boolean p0(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData) {
        PBBoolField pBBoolField;
        if (tVideoChannelList$VideoChannelData != null && (pBBoolField = tVideoChannelList$VideoChannelData.show_red_dot) != null && pBBoolField.get()) {
            if (!qx2.a.c().d(tVideoChannelList$VideoChannelData.channel_id.get() + "", tVideoChannelList$VideoChannelData.red_dot_version.get())) {
                return true;
            }
        }
        return false;
    }

    public void q0(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData) {
        if (tVideoChannelList$VideoChannelData != null && tVideoChannelList$VideoChannelData.channel_id != null && tVideoChannelList$VideoChannelData.show_red_dot.get()) {
            tVideoChannelList$VideoChannelData.show_red_dot.set(false);
            qx2.a.c().o(tVideoChannelList$VideoChannelData.channel_id.get() + "", tVideoChannelList$VideoChannelData.red_dot_version.get());
        }
    }
}
