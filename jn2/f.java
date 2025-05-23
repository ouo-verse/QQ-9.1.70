package jn2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.search.i;
import com.tencent.mobileqq.search.j;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.search.util.aa;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.u;
import com.tencent.mobileqq.search.util.x;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import java.util.List;
import jn2.b;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends b<j, a> implements DecodeTaskCompletionListener {
    private int E;
    private final IFaceDecoder F;
    private boolean G;
    private b.a<j> H;
    private i.c I;
    private yx3.a J;
    private boolean K;
    boolean L = true;
    private final int D = ViewUtils.dip2px(36.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a extends RecyclerView.ViewHolder {
        ImageView E;
        ImageView F;
        View G;
        TextView H;

        public a(@NonNull View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.y1y);
            this.F = (ImageView) view.findViewById(R.id.y_b);
            this.G = view.findViewById(R.id.kmh);
            this.H = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public f(QQAppInterface qQAppInterface) {
        w0(ScreenUtils.getScreenWidth(MobileQQ.sMobileQQ), ScreenUtils.getScreenHeight(MobileQQ.sMobileQQ));
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.F = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
    }

    private void q0(a aVar, j jVar) {
        if (jVar.h() instanceof SearchHistory) {
            int i3 = ((SearchHistory) jVar.h()).type;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 1000) {
                        if (i3 != 10023) {
                            switch (i3) {
                                case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_FRIEND /* 56939 */:
                                case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_SELFUNBIND /* 56940 */:
                                case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_BIND /* 56941 */:
                                case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_UNBIND /* 56942 */:
                                    break;
                                default:
                                    aVar.F.setVisibility(8);
                                    return;
                            }
                        } else {
                            aVar.F.setVisibility(0);
                            aVar.F.setImageDrawable(ie0.a.f().o(aVar.F.getContext(), R.drawable.qui_channel, R.color.qui_common_icon_tertiary, 1000));
                            return;
                        }
                    }
                } else {
                    aVar.F.setVisibility(0);
                    aVar.F.setImageDrawable(ie0.a.f().o(aVar.F.getContext(), R.drawable.qui_group, R.color.qui_common_icon_tertiary, 1000));
                    return;
                }
            }
            aVar.F.setVisibility(0);
            aVar.F.setImageDrawable(ie0.a.f().o(aVar.F.getContext(), R.drawable.qui_user, R.color.qui_common_icon_tertiary, 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y1y) {
            if (this.H != null) {
                int adapterPosition = aVar.getAdapterPosition();
                EventCollector.getInstance().onViewClicked(view);
                this.H.a(view, getItem(adapterPosition), adapterPosition);
            }
        } else if (!t0() && this.C != null) {
            int adapterPosition2 = aVar.getAdapterPosition();
            EventCollector.getInstance().onViewClicked(view);
            this.C.a(view, getItem(adapterPosition2), adapterPosition2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void A0(b.a<j> aVar) {
        this.H = aVar;
    }

    public void B0(i.c cVar) {
        this.I = cVar;
    }

    public void C0(int i3) {
        if (!this.K) {
            return;
        }
        j item = getItem(i3);
        if (this.J != null && item != null) {
            QLog.d("HistorySearchEntryExpDAdapter", 1, "start delete item = " + af.a(item.f(), 2));
            this.J.deleteHistory(item);
            return;
        }
        QLog.d("HistorySearchEntryExpDAdapter", 1, "item = null, stop delete!!!");
        this.K = false;
    }

    public void D0() {
        this.L = !this.L;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jn2.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.notifyDataSetChanged();
            }
        });
    }

    @Override // jn2.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.L && !this.G) {
            return Math.min(this.f410656m.size(), 6);
        }
        return this.f410656m.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jn2.b
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void i0(@NonNull a aVar, int i3, @NonNull j jVar) {
        int i16;
        String g16;
        int i17;
        ImageView imageView = aVar.E;
        if (this.G) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        aVar.E.setTag(R.id.f26500dp, Integer.valueOf(i3));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(jVar.f());
        if (TextUtils.isEmpty(jVar.g())) {
            g16 = "";
        } else {
            g16 = jVar.g();
        }
        sb5.append(g16);
        String sb6 = sb5.toString();
        aVar.H.setText(sb6);
        View view = aVar.G;
        if (this.G) {
            i17 = R.drawable.kfv;
        } else {
            i17 = R.drawable.kfw;
        }
        view.setBackgroundResource(i17);
        aVar.H.setMaxWidth(this.E);
        if (this.G) {
            aVar.E.setVisibility(0);
        } else {
            aVar.E.setVisibility(8);
        }
        q0(aVar, jVar);
        View view2 = aVar.itemView;
        if (AppSetting.f99565y) {
            AccessibilityUtil.s(view2, sb6);
            AccessibilityUtil.s(aVar.E, HardCodeUtil.qqStr(R.string.f170822ak3) + sb6);
            AccessibilityUtil.n(aVar.H, false);
        }
        String i18 = x.i(jVar.h());
        u.i(aVar.E, i3, i18, jVar.f());
        u.j(aVar.itemView, i3, i18, jVar.f());
        aa.g("0X800C2C2", jVar, i3);
        i.c cVar = this.I;
        if (cVar != null) {
            cVar.a(jVar);
        }
    }

    public void o0() {
        this.K = true;
        C0(0);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        if (!this.F.isPausing() && str != null) {
            List<D> list = this.f410656m;
            for (int i17 = 0; i17 < list.size(); i17++) {
                j jVar = (j) list.get(i17);
                if ((jVar instanceof com.tencent.mobileqq.search.d) && str.equals(((com.tencent.mobileqq.search.d) jVar).h().uin)) {
                    notifyItemChanged(i17);
                    return;
                }
            }
        }
    }

    public int p0() {
        return this.f410656m.size();
    }

    public int r0(j jVar) {
        if (!(jVar instanceof com.tencent.mobileqq.search.d)) {
            return -1;
        }
        for (int i3 = 0; i3 < getItemCount(); i3++) {
            if (jVar == getItem(i3)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // jn2.b
    public void release() {
        super.release();
        this.H = null;
        this.G = false;
        IFaceDecoder iFaceDecoder = this.F;
        if (iFaceDecoder != null) {
            iFaceDecoder.setDecodeTaskCompletionListener(null);
        }
    }

    public boolean s0() {
        return this.L;
    }

    public boolean t0() {
        return this.G;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i2u, viewGroup, false));
    }

    public void w0(int i3, int i16) {
        this.E = (i3 / 2) - ViewUtils.dip2px(54.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jn2.b
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void k0(@NonNull final a aVar) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: jn2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.u0(aVar, view);
            }
        };
        aVar.itemView.setOnClickListener(onClickListener);
        aVar.E.setOnClickListener(onClickListener);
    }

    public void y0(yx3.a aVar) {
        this.J = aVar;
    }

    public void z0(boolean z16) {
        boolean z17 = this.G;
        if (!z17 || !z16) {
            if (!z17 && !z16) {
                return;
            }
            this.G = z16;
            notifyItemRangeChanged(0, getItemCount());
        }
    }
}
