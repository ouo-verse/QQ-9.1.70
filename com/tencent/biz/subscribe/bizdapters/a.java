package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFollowRcmd;
import NS_COMM.COMM;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends MultiViewBlock<CertifiedAccountMeta$StFollowRcmd> {
    public static String R = "BlankRecommendFeedsAdapter";
    public static int S = ImmersiveUtils.dpToPx(12.0f);
    private int J;
    private int K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.bizdapters.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class ViewOnClickListenerC0960a implements View.OnClickListener {
        ViewOnClickListenerC0960a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            StringBuilder sb5 = new StringBuilder(com.tencent.biz.subscribe.b.d(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
            if (a.this.k0() != null) {
                try {
                    sb5.append(URLEncoder.encode(a.this.k0().attachInfo.get(), "UTF-8"));
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
            } else {
                QLog.d(a.R, 2, "jump more recommend H5 page with no attach info!");
            }
            VSReporter.o("auth_follow", "clk_more", 0, 0, new String[0]);
            com.tencent.biz.subscribe.d.l(sb5.toString());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }

        public void b(CertifiedAccountMeta$StFollowRcmd certifiedAccountMeta$StFollowRcmd, int i3) {
            View view = this.itemView;
            if (view instanceof BlankRecommendItemView) {
                ((BlankRecommendItemView) view).setData(certifiedAccountMeta$StFollowRcmd);
                ((BlankRecommendItemView) this.itemView).setExtraTypeInfo(a.this.D());
                ((BlankRecommendItemView) this.itemView).setPos(i3);
            }
        }
    }

    public a(Bundle bundle) {
        super(bundle);
        this.J = ImmersiveUtils.dpToPx(20.0f);
        this.K = ImmersiveUtils.dpToPx(12.5f);
        this.L = true;
        this.M = true;
        this.N = false;
        this.P = true;
        this.Q = false;
    }

    private View i0(ViewGroup viewGroup) {
        int i3;
        VSReporter.o("auth_follow", "exp_more", 0, 0, new String[0]);
        View inflate = LayoutInflater.from(C()).inflate(R.layout.f167690li, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f166111bl1);
        if (linearLayout != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) linearLayout.getBackground();
            if (this.N) {
                i3 = -13224394;
            } else {
                i3 = -460552;
            }
            gradientDrawable.setColor(i3);
            linearLayout.setOnClickListener(new ViewOnClickListenerC0960a());
        }
        if (this.N) {
            ((TextView) inflate.findViewById(R.id.e_y)).setTextColor(-5723992);
        }
        return inflate;
    }

    private View j0(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(C()).inflate(R.layout.f167691lj, viewGroup, false);
        URLImageView uRLImageView = (URLImageView) inflate.findViewById(R.id.bct);
        if (uRLImageView != null) {
            uRLImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20191225193654_3xBYY4zCcy.png");
        }
        if (this.N) {
            if (uRLImageView != null) {
                uRLImageView.setColorFilter(-1728053248);
            }
            ((TextView) inflate.findViewById(R.id.eax)).setTextColor(-10132123);
            inflate.findViewById(R.id.f164999bn3).setBackgroundColor(-14540254);
        } else if (uRLImageView != null) {
            uRLImageView.clearColorFilter();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void G(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (view instanceof BlankRecommendItemView) {
            rect.top = this.J;
            int i3 = S;
            rect.left = i3;
            rect.right = i3;
            rect.bottom = this.K;
            return;
        }
        if (view.getId() == R.id.iau) {
            rect.top = ImmersiveUtils.dpToPx(19.5f);
            rect.left = 0;
            rect.right = 0;
            rect.bottom = -ImmersiveUtils.dpToPx(30.0f);
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int N(int i3) {
        return 1;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int P() {
        return 2;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public boolean R() {
        return false;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.f96195d.size();
        if (!this.Q) {
            if (size > 0) {
                if (this.L) {
                    size++;
                }
                if (this.M) {
                    return size + 1;
                }
                return size;
            }
            return 0;
        }
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.L) {
            i3--;
        }
        if (i3 == -1) {
            return 100000;
        }
        if (!ArrayUtils.isOutOfArrayIndex(i3, r())) {
            return 100002;
        }
        return 100001;
    }

    public COMM.StCommonExt k0() {
        if (H().b() != null) {
            return H().b();
        }
        return null;
    }

    public void l0(boolean z16) {
        this.N = z16;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.L) {
            i3--;
        }
        if (!ArrayUtils.isOutOfArrayIndex(i3, r())) {
            ((b) viewHolder).b(r().get(i3), i3);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 100000) {
            return new b(j0(viewGroup));
        }
        if (i3 == 100001) {
            return new b(i0(viewGroup));
        }
        BlankRecommendItemView blankRecommendItemView = new BlankRecommendItemView(viewGroup.getContext());
        blankRecommendItemView.setIsInNightMode(this.N);
        return new b(blankRecommendItemView);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void a0(Bundle bundle) {
    }
}
