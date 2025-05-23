package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StLiveGoods;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedListRsp;
import NS_COMM.COMM;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.utils.b;
import com.tencent.biz.subscribe.utils.j;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.ilive.util.ILiveEntranceUtilApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends FakerFeedsAdapter {

    /* renamed from: d0, reason: collision with root package name */
    private static Drawable f95776d0 = new ColorDrawable(0);
    private CertifiedAccountMeta$StFeed M;
    private d N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private boolean T;
    private int U;
    private int V;
    private boolean W;
    private boolean X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private FolderRecommendTabFragment.FolderRecommendHeadItemView f95777a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f95778b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f95779c0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.subscribe.part.block.base.b f95780a;

        a(com.tencent.biz.subscribe.part.block.base.b bVar) {
            this.f95780a = bVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetFeedListRsp certifiedAccountRead$StGetFeedListRsp) {
            boolean z17 = false;
            if (z16 && j3 == 0) {
                c.this.H().n(certifiedAccountRead$StGetFeedListRsp.livePageInfo.get());
                if (!this.f95780a.f() && !this.f95780a.i()) {
                    if (this.f95780a.g()) {
                        c cVar = c.this;
                        List<CertifiedAccountMeta$StFeed> list = certifiedAccountRead$StGetFeedListRsp.hotLive.get();
                        COMM.StCommonExt stCommonExt = certifiedAccountRead$StGetFeedListRsp.extInfo;
                        if (certifiedAccountRead$StGetFeedListRsp.isFinish.get() == 1) {
                            z17 = true;
                        }
                        cVar.E0(list, stCommonExt, z17, certifiedAccountRead$StGetFeedListRsp.adAttchInfo.get());
                        return;
                    }
                    return;
                }
                if (certifiedAccountRead$StGetFeedListRsp.hotLive.get() != null && certifiedAccountRead$StGetFeedListRsp.hotLive.get().size() != 0) {
                    if (c.this.f95777a0 != null) {
                        c.this.f95777a0.y(false);
                    }
                } else if (c.this.f95777a0 != null) {
                    c.this.q();
                    c.this.f95777a0.y(true);
                }
                c cVar2 = c.this;
                List<CertifiedAccountMeta$StFeed> list2 = certifiedAccountRead$StGetFeedListRsp.hotLive.get();
                COMM.StCommonExt stCommonExt2 = certifiedAccountRead$StGetFeedListRsp.extInfo;
                if (certifiedAccountRead$StGetFeedListRsp.isFinish.get() == 1) {
                    z17 = true;
                }
                cVar2.Q0(list2, stCommonExt2, z17, certifiedAccountRead$StGetFeedListRsp.adAttchInfo.get());
                c.this.f0("share_key_continue_feeds", new a.d(certifiedAccountRead$StGetFeedListRsp.hotLive.get()));
                return;
            }
            c.this.W(false);
            if ((this.f95780a.f() || this.f95780a.i()) && c.this.f95777a0 != null) {
                c.this.f95777a0.y(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements j.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StFeed f95782a;

        b(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            this.f95782a = certifiedAccountMeta$StFeed;
        }

        @Override // com.tencent.biz.subscribe.utils.j.f
        public void a(boolean z16, String str, boolean z17) {
            if (z16) {
                VSReporter.p(this.f95782a.poster.f24929id.get(), "auth_follow", "clk_unfollow", 0, 0, new String[0]);
                Iterator<CertifiedAccountMeta$StFeed> it = c.this.r().iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().poster.f24929id.get(), this.f95782a.poster.f24929id.get())) {
                        it.remove();
                    }
                }
                c.this.notifyDataSetChanged();
                QQToast.makeText(c.this.C(), 2, HardCodeUtil.qqStr(R.string.f170710zk), 0).show();
                if (c.this.r().size() < 5) {
                    c.this.b0();
                }
            }
            if (z17) {
                VSReporter.p(this.f95782a.poster.f24929id.get(), "auth_follow", "clk_cancel", 0, 0, new String[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a(View view, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e extends RecyclerView.ViewHolder {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StFeed f95786d;

            a(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
                this.f95786d = certifiedAccountMeta$StFeed;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                e eVar = e.this;
                if ((eVar.itemView instanceof RelativeFeedItemView) && c.this.N != null) {
                    c.this.N.a(e.this.itemView, this.f95786d);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class b implements View.OnLongClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ExtraTypeInfo f95788d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StFeed f95789e;

            /* compiled from: P */
            /* loaded from: classes5.dex */
            class a implements b.d {
                a() {
                }

                @Override // com.tencent.biz.subscribe.utils.b.d
                public void onResult(boolean z16) {
                    b bVar = b.this;
                    c.this.p0(bVar.f95789e);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.biz.subscribe.bizdapters.c$e$b$b, reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class C0962b implements b.c {
                C0962b() {
                }

                @Override // com.tencent.biz.subscribe.utils.b.c
                public void a(boolean z16) {
                    String str;
                    String str2 = b.this.f95789e.poster.f24929id.get();
                    if (z16) {
                        str = "cancel";
                    } else {
                        str = QCircleDaTongConstant.ElementParamValue.DISLIKE;
                    }
                    VSReporter.n(str2, "auth_feeds", str, 0, 0, "", e.this.getAdapterPosition() + "", b.this.f95789e.poster.nick.get(), b.this.f95789e.title.get());
                }
            }

            b(ExtraTypeInfo extraTypeInfo, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
                this.f95788d = extraTypeInfo;
                this.f95789e = certifiedAccountMeta$StFeed;
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
            
                if (r0 == 7002) goto L17;
             */
            @Override // android.view.View.OnLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onLongClick(View view) {
                CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
                EventCollector.getInstance().onViewLongClickedBefore(view);
                ExtraTypeInfo extraTypeInfo = this.f95788d;
                boolean z16 = true;
                if (extraTypeInfo != null) {
                    int i3 = extraTypeInfo.pageType;
                    if (i3 == 7003) {
                        c.this.R0(this.f95789e);
                    }
                    EventCollector.getInstance().onViewLongClicked(view);
                    return z16;
                }
                e eVar = e.this;
                if ((eVar.itemView instanceof RelativeFeedItemView) && (certifiedAccountMeta$StFeed = this.f95789e) != null) {
                    c.this.S0(certifiedAccountMeta$StFeed, new a(), new C0962b());
                    VSReporter.n(this.f95789e.poster.f24929id.get(), "auth_feeds", "press", 0, 0, "", e.this.getAdapterPosition() + "", this.f95789e.poster.nick.get(), this.f95789e.title.get());
                } else {
                    z16 = false;
                }
                EventCollector.getInstance().onViewLongClicked(view);
                return z16;
            }
        }

        public e(View view) {
            super(view);
        }

        private boolean b(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed2;
            View view = this.itemView;
            if (!(view instanceof BaseWidgetView) || (certifiedAccountMeta$StFeed2 = (CertifiedAccountMeta$StFeed) ((BaseWidgetView) view).f()) == null || certifiedAccountMeta$StFeed == null || TextUtils.isEmpty(certifiedAccountMeta$StFeed2.f24925id.get()) || TextUtils.isEmpty(certifiedAccountMeta$StFeed2.f24925id.get()) || !certifiedAccountMeta$StFeed2.f24925id.get().equals(certifiedAccountMeta$StFeed.f24925id.get()) || certifiedAccountMeta$StFeed2.likeInfo.count.get() != certifiedAccountMeta$StFeed.likeInfo.count.get()) {
                return false;
            }
            return true;
        }

        public void c(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, ExtraTypeInfo extraTypeInfo) {
            if (b(certifiedAccountMeta$StFeed)) {
                return;
            }
            View view = this.itemView;
            if (view instanceof RelativeFeedItemView) {
                ((RelativeFeedItemView) view).setIsInNightMode(c.this.W);
                ((RelativeFeedItemView) this.itemView).setExtraTypeInfo(extraTypeInfo);
                ((RelativeFeedItemView) this.itemView).setData(certifiedAccountMeta$StFeed);
                ((RelativeFeedItemView) this.itemView).setDataPosInList(getAdapterPosition());
            } else if (view instanceof RelativeAdFeedItemView) {
                ((RelativeAdFeedItemView) view).setIsInNightMode(c.this.W);
                ((RelativeAdFeedItemView) this.itemView).setExtraTypeInfo(extraTypeInfo);
                ((RelativeAdFeedItemView) this.itemView).setData(certifiedAccountMeta$StFeed);
            }
            if (c.this.N != null) {
                this.itemView.setOnClickListener(new a(certifiedAccountMeta$StFeed));
            }
            this.itemView.setOnLongClickListener(new b(extraTypeInfo, certifiedAccountMeta$StFeed));
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f extends RecyclerView.ViewHolder {
        ImageView C;
        ImageView D;
        TextView E;
        TextView F;
        LinearLayout G;
        ImageView H;
        TextView I;
        TextView J;
        ImageView K;
        TextView L;
        int M;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f95793d;

        /* renamed from: e, reason: collision with root package name */
        RelativeLayout f95794e;

        /* renamed from: f, reason: collision with root package name */
        RoundImageView f95795f;

        /* renamed from: h, reason: collision with root package name */
        ImageView f95796h;

        /* renamed from: i, reason: collision with root package name */
        TextView f95797i;

        /* renamed from: m, reason: collision with root package name */
        RelativeLayout f95798m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StFeed f95799d;

            a(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
                this.f95799d = certifiedAccountMeta$StFeed;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                PBStringField pBStringField;
                EventCollector.getInstance().onViewClickedBefore(view);
                CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f95799d;
                if (certifiedAccountMeta$StFeed == null) {
                    QLog.e("RelativeFeedsAdapter", 1, "onClick feed is null");
                } else {
                    CertifiedAccountMeta$StLive certifiedAccountMeta$StLive = certifiedAccountMeta$StFeed.live;
                    String str3 = "";
                    if (certifiedAccountMeta$StLive == null || !certifiedAccountMeta$StLive.roomId.has()) {
                        str = "";
                    } else {
                        str = String.valueOf(this.f95799d.live.roomId.get());
                    }
                    c.this.M0(str);
                    CertifiedAccountMeta$StLive certifiedAccountMeta$StLive2 = this.f95799d.live;
                    if (certifiedAccountMeta$StLive2 == null || (pBStringField = certifiedAccountMeta$StLive2.rtmpURL) == null || !pBStringField.has()) {
                        str2 = "";
                    } else {
                        str2 = this.f95799d.live.rtmpURL.get();
                    }
                    Iterator<CertifiedAccountMeta$StLive.RoomIcon> it = this.f95799d.live.roomIcon.get().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CertifiedAccountMeta$StLive.RoomIcon next = it.next();
                        if ("1:1".equals(next.size.get())) {
                            str3 = next.url.get();
                            break;
                        }
                    }
                    f fVar = f.this;
                    c.this.H0(fVar.itemView.getContext(), str, str2, c.this.K0(), c.this.f95779c0, str3, "0", "0", "0", "0");
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public f(View view) {
            super(view);
            this.M = 1;
            this.f95793d = (RelativeLayout) view.findViewById(R.id.ylo);
            this.f95794e = (RelativeLayout) view.findViewById(R.id.ylt);
            RoundImageView roundImageView = (RoundImageView) view.findViewById(R.id.yks);
            this.f95795f = roundImageView;
            roundImageView.setmRadius(ImmersiveUtils.dpToPx(8.0f), false);
            this.f95796h = (ImageView) view.findViewById(R.id.ymd);
            this.f95797i = (TextView) view.findViewById(R.id.swn);
            this.f95798m = (RelativeLayout) view.findViewById(R.id.tbm);
            this.C = (ImageView) view.findViewById(R.id.vr6);
            this.D = (ImageView) view.findViewById(R.id.vr7);
            this.E = (TextView) view.findViewById(R.id.vr5);
            this.F = (TextView) view.findViewById(R.id.vr8);
            this.G = (LinearLayout) view.findViewById(R.id.vr9);
            ImageView imageView = (ImageView) view.findViewById(R.id.vr_);
            this.H = imageView;
            imageView.setColorFilter(1291845632);
            this.I = (TextView) view.findViewById(R.id.vra);
            this.J = (TextView) view.findViewById(R.id.ym5);
            this.K = (ImageView) view.findViewById(R.id.f165679x83);
            this.L = (TextView) view.findViewById(R.id.f9o);
        }

        private void d(CertifiedAccountMeta$StLive certifiedAccountMeta$StLive) {
            List<CertifiedAccountMeta$StLiveGoods> list = certifiedAccountMeta$StLive.goodsInfo.get();
            if (list.isEmpty()) {
                QLog.d("RelativeFeedsAdapter", 1, "current display has no goods message");
                this.f95798m.setVisibility(8);
                this.G.setVisibility(8);
                return;
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                CertifiedAccountMeta$StLiveGoods certifiedAccountMeta$StLiveGoods = list.get(i3);
                String str = certifiedAccountMeta$StLiveGoods.imgUrl.get();
                if (i3 == 0) {
                    h(this.C, str);
                    this.E.setText(certifiedAccountMeta$StLiveGoods.name.get());
                    this.F.setText(i(certifiedAccountMeta$StLiveGoods.curPrice.get()));
                    this.f95798m.setVisibility(0);
                } else if (i3 == 1) {
                    h(this.H, str);
                    this.I.setText(certifiedAccountMeta$StLive.totalGoods.get() + "\n\u597d\u7269");
                    this.G.setVisibility(0);
                }
            }
        }

        private void e(CertifiedAccountMeta$StLive certifiedAccountMeta$StLive) {
            String str;
            Iterator<CertifiedAccountMeta$StLive.RoomIcon> it = certifiedAccountMeta$StLive.roomIcon.get().iterator();
            while (true) {
                if (it.hasNext()) {
                    CertifiedAccountMeta$StLive.RoomIcon next = it.next();
                    if ("1:1".equals(next.size.get())) {
                        str = next.url.get();
                        break;
                    }
                } else {
                    str = null;
                    break;
                }
            }
            h(this.f95795f, str);
        }

        private void f(CertifiedAccountMeta$StLive certifiedAccountMeta$StLive) {
            if (TextUtils.isEmpty(certifiedAccountMeta$StLive.typeIcon.get())) {
                this.f95796h.setVisibility(8);
            } else {
                this.f95796h.setImageDrawable(VasApngUtil.getApngURLDrawable(certifiedAccountMeta$StLive.typeIcon.get(), new int[]{2}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null));
                this.f95796h.setVisibility(0);
            }
            this.f95797i.setText("\u4eba\u6c14" + certifiedAccountMeta$StLive.viewer.get() + "");
        }

        private void g() {
            if (c.this.W) {
                this.f95794e.setAlpha(0.7f);
                this.f95794e.setBackgroundColor(-16777216);
                this.J.setTextColor(-1);
                this.L.setTextColor(-6775116);
            }
        }

        private void h(ImageView imageView, String str) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("RelativeFeedsAdapter", 1, "imageUrl got failed!");
                return;
            }
            if (imageView != null) {
                String str2 = (String) imageView.getTag();
                if (TextUtils.isEmpty(str2) || !str2.equals(str)) {
                    imageView.setImageDrawable(URLDrawable.getDrawable(str, c.f95776d0, c.f95776d0));
                    imageView.setTag(str);
                }
            }
        }

        public void b(f fVar, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            this.itemView.setOnClickListener(new a(certifiedAccountMeta$StFeed));
        }

        public void c(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            CertifiedAccountMeta$StLive certifiedAccountMeta$StLive;
            if (certifiedAccountMeta$StFeed == null || (certifiedAccountMeta$StLive = certifiedAccountMeta$StFeed.live) == null) {
                return;
            }
            e(certifiedAccountMeta$StLive);
            g();
            this.J.setText(certifiedAccountMeta$StLive.roomTitle.get());
            this.K.setImageDrawable(URLDrawable.getDrawable(certifiedAccountMeta$StLive.anchorIcon.get()));
            this.L.setText(certifiedAccountMeta$StLive.anchorName.get());
            f(certifiedAccountMeta$StLive);
            d(certifiedAccountMeta$StLive);
            CertifiedAccountMeta$StLive certifiedAccountMeta$StLive2 = certifiedAccountMeta$StFeed.live;
            if (certifiedAccountMeta$StLive2 != null && certifiedAccountMeta$StLive2.roomId.has()) {
                if (c.this.f95778b0 == 0) {
                    MobileReportManager.getInstance().reportActionLive(certifiedAccountMeta$StFeed.live.roomId.get() + "", "25", "qq_live", "tab_page", "subscribe", 101, 1, System.currentTimeMillis(), certifiedAccountMeta$StFeed.live.roomId.get() + "");
                    return;
                }
                if (c.this.f95778b0 == 1) {
                    MobileReportManager.getInstance().reportActionLive(certifiedAccountMeta$StFeed.live.roomId.get() + "", "25", "qq_live", "find_page", "hot_push", 101, 1, System.currentTimeMillis(), certifiedAccountMeta$StFeed.live.roomId.get() + "");
                    return;
                }
                if (c.this.f95778b0 == 2) {
                    MobileReportManager.getInstance().reportActionLive(certifiedAccountMeta$StFeed.live.roomId.get() + "", "25", "qq_live", "shopcart_page", "hot_push", 101, 1, System.currentTimeMillis(), certifiedAccountMeta$StFeed.live.roomId.get() + "");
                }
            }
        }

        public String i(int i3) {
            BigDecimal divide;
            String str;
            StringBuilder sb5 = new StringBuilder();
            BigDecimal bigDecimal = new BigDecimal(i3);
            if (i3 >= 10000000) {
                divide = bigDecimal.divide(new BigDecimal(1000000));
                str = "\u4e07";
            } else if (i3 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                divide = bigDecimal.divide(new BigDecimal(RealConnection.IDLE_CONNECTION_HEALTHY_NS));
                str = "\u4ebf";
            } else {
                divide = bigDecimal.divide(new BigDecimal(100));
                str = "";
            }
            sb5.append(new BigDecimal(divide.toPlainString()).setScale(2, 1).stripTrailingZeros().toPlainString());
            sb5.append(str);
            return sb5.toString();
        }
    }

    public c(Bundle bundle) {
        super(bundle);
        this.P = ImmersiveUtils.dpToPx(4.0f);
        this.Q = ImmersiveUtils.dpToPx(16.0f);
        this.R = ImmersiveUtils.dpToPx(13.0f);
        this.S = ImmersiveUtils.dpToPx(3.0f);
        this.T = true;
        this.V = -1;
        this.W = false;
        this.X = true;
        this.f95778b0 = -1;
        this.f95779c0 = 99;
    }

    private boolean F0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed.live.liveUin.get() != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    private FrameLayout G0(ViewGroup viewGroup) {
        TextView textView = new TextView(viewGroup.getContext());
        FrameLayout B = B(textView);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(1, 16.0f);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#222222"));
        textView.getPaint().setFakeBoldText(true);
        layoutParams.leftMargin = ImmersiveUtils.dpToPx(16.0f);
        layoutParams.rightMargin = ImmersiveUtils.dpToPx(16.0f);
        textView.setText(HardCodeUtil.qqStr(R.string.kaw));
        return B;
    }

    private RecyclerView.ViewHolder I0(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fs_, viewGroup, false);
        f fVar = new f(inflate);
        int i3 = inflate.getResources().getDisplayMetrics().widthPixels;
        this.Y = i3;
        int dpToPx = (int) ((i3 * 0.5f) - ViewUtils.dpToPx(8.5f));
        int dpToPx2 = dpToPx - ViewUtils.dpToPx(7.0f);
        this.Z = dpToPx2;
        int dpToPx3 = dpToPx2 + ViewUtils.dpToPx(54.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fVar.f95793d.getLayoutParams();
        layoutParams.width = dpToPx;
        layoutParams.height = dpToPx3;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) fVar.f95795f.getLayoutParams();
        int i16 = this.Z;
        layoutParams2.width = i16;
        layoutParams2.height = i16;
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(String str) {
        int i3 = this.f95778b0;
        if (i3 == 0) {
            this.f95779c0 = 6;
            MobileReportManager.getInstance().reportActionLive(str + "", "25", "qq_live", "tab_page", "subscribe", 102, 1, System.currentTimeMillis(), str + "");
            return;
        }
        if (i3 == 1) {
            this.f95779c0 = 5;
            MobileReportManager.getInstance().reportActionLive(str + "", "25", "qq_live", "find_page", "hot_push", 102, 1, System.currentTimeMillis(), str + "");
            return;
        }
        if (i3 == 2) {
            this.f95779c0 = 2;
            MobileReportManager.getInstance().reportActionLive(str + "", "25", "qq_live", "shopcart_page", "hot_push", 102, 1, System.currentTimeMillis(), str + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed == null) {
            return;
        }
        VSReporter.p(certifiedAccountMeta$StFeed.poster.f24929id.get(), "auth_follow", "press", 0, 0, new String[0]);
        j.d(C(), certifiedAccountMeta$StFeed.poster.f24929id.get(), new b(certifiedAccountMeta$StFeed));
    }

    public void D0(List<CertifiedAccountMeta$StFeed> list, COMM.StCommonExt stCommonExt, boolean z16) {
        E0(list, stCommonExt, z16, null);
    }

    public void E0(List<CertifiedAccountMeta$StFeed> list, COMM.StCommonExt stCommonExt, boolean z16, String str) {
        H().m(z16);
        H().k(stCommonExt);
        H().j(str);
        if (list != null && list.size() > 0) {
            p(list);
        }
        W(true);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void G(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (this.T && (viewLayoutPosition == 0 || viewLayoutPosition == 1)) {
            rect.bottom = this.R;
        } else {
            rect.bottom = this.Q;
        }
    }

    public void H0(Context context, String str, String str2, ArrayList<String> arrayList, int i3, String str3, String str4, String str5, String str6, String str7) {
        n05.a aVar = new n05.a(context, "subscription", str, str2, false, arrayList, "", i3);
        aVar.f417949e = str3;
        aVar.f417957m = str4;
        aVar.f417958n = str5;
        aVar.f417959o = str6;
        aVar.f417960p = str7;
        ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).liveWatchEntranceJump(aVar);
    }

    public CertifiedAccountMeta$StFeed J0() {
        if (r() != null && r().size() != 0) {
            int i3 = this.U;
            while (true) {
                i3++;
                if (i3 >= r().size()) {
                    break;
                }
                CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = r().get(i3);
                if (certifiedAccountMeta$StFeed != null && com.tencent.biz.subscribe.d.h(certifiedAccountMeta$StFeed.type.get())) {
                    this.U = i3;
                    return certifiedAccountMeta$StFeed;
                }
            }
        }
        return null;
    }

    public ArrayList<String> K0() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator it = this.f96195d.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new String(((CertifiedAccountMeta$StFeed) it.next()).toByteArray(), "ISO8859_1"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        return arrayList;
    }

    public void L0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (r() != null && r().size() != 0 && this.U <= r().size()) {
            for (int i3 = this.U; i3 >= 0; i3--) {
                CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed2 = r().get(i3);
                if (certifiedAccountMeta$StFeed2 != null && com.tencent.biz.subscribe.d.h(certifiedAccountMeta$StFeed2.type.get()) && certifiedAccountMeta$StFeed2.f24925id.get().equals(certifiedAccountMeta$StFeed.f24925id.get())) {
                    this.U = i3;
                    return;
                }
            }
            this.U = -1;
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int N(int i3) {
        if (getItemViewType(i3) == 100000) {
            return 1;
        }
        return 2;
    }

    public void N0(d dVar) {
        this.N = dVar;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public String O() {
        return "RELATIVE_ADAPTER_UNIQUE_KEY";
    }

    public void O0(boolean z16) {
        this.T = z16;
        notifyDataSetChanged();
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int P() {
        return 3;
    }

    public void P0(List<CertifiedAccountMeta$StFeed> list, COMM.StCommonExt stCommonExt, boolean z16) {
        Q0(list, stCommonExt, z16, null);
    }

    public void Q0(List<CertifiedAccountMeta$StFeed> list, COMM.StCommonExt stCommonExt, boolean z16, String str) {
        this.U = -1;
        n0();
        H().m(z16);
        H().k(stCommonExt);
        H().j(str);
        t((ArrayList) list);
        W(true);
    }

    public void S0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, b.d dVar, b.c cVar) {
        if (certifiedAccountMeta$StFeed == null) {
            return;
        }
        com.tencent.biz.subscribe.utils.b.a(C(), certifiedAccountMeta$StFeed, dVar, cVar);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
        GetSubscribeFeedListRequest getSubscribeFeedListRequest = null;
        if (this.V != -1 && (bVar.f() || bVar.i())) {
            getSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.V, H().c(), H().a(), (String) null);
        } else if (this.V != -1 && bVar.g()) {
            getSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.V, H().c(), H().a(), H().d());
        }
        if (getSubscribeFeedListRequest == null) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(getSubscribeFeedListRequest, new a(bVar));
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void W(boolean z16) {
        if (z() != null && A() != null) {
            H().l(4);
            z().setRefreshing(false);
            if (S()) {
                A().I(z16, H().e());
            } else if (A() != null && r() != null && r().size() == 0) {
                A().I(z16, false);
            }
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void a0(Bundle bundle) {
        K().addOnScrollListener(new C0961c());
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.f96142i) {
            return 4;
        }
        int size = this.f96195d.size();
        if (size > 0 && this.T) {
            return size + 1;
        }
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.T) {
            i3--;
        }
        if (i3 == -1) {
            return 100000;
        }
        if (F0(r().get(i3))) {
            return 100003;
        }
        if (!ArrayUtils.isOutOfArrayIndex(i3, r()) && r().get(i3).type.get() == 4) {
            return 1;
        }
        return 100002;
    }

    @Override // com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView.a
    public void k(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        p0(certifiedAccountMeta$StFeed);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @SuppressLint({"WrongConstant"})
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.T) {
            i3--;
        }
        if (!ArrayUtils.isOutOfArrayIndex(i3, r())) {
            if (viewHolder instanceof f) {
                CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = (CertifiedAccountMeta$StFeed) this.f96195d.get(i3);
                f fVar = (f) viewHolder;
                fVar.c(certifiedAccountMeta$StFeed);
                fVar.b(fVar, certifiedAccountMeta$StFeed);
            } else {
                ((e) viewHolder).c(r().get(i3), D());
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 100000) {
            return new e(G0(viewGroup));
        }
        if (i3 == 1) {
            return new e(new RelativeAdFeedItemView(viewGroup.getContext(), this));
        }
        if (i3 == 100003) {
            return I0(viewGroup);
        }
        return new e(new RelativeFeedItemView(viewGroup.getContext()));
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.a.e
    public void r2(String str, a.d dVar) {
        Object obj;
        super.r2(str, dVar);
        if (str.equals("share_key_subscribe_feeds_update") && (obj = dVar.f96169a) != null) {
            this.M = (CertifiedAccountMeta$StFeed) obj;
            if (dVar.f96170b) {
                b0();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.bizdapters.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0961c extends RecyclerView.OnScrollListener {
        C0961c() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            try {
                super.onScrollStateChanged(recyclerView, i3);
                RecyclerView.LayoutManager layoutManager = c.this.L;
                if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    staggeredGridLayoutManager.computeVerticalScrollExtent(new RecyclerView.State());
                    int[] iArr = new int[staggeredGridLayoutManager.getColumnCountForAccessibility(null, null)];
                    staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
                    if (c.this.I(iArr[0]) <= 0 && !c.this.X) {
                        c.this.X = true;
                        staggeredGridLayoutManager.invalidateSpanAssignments();
                    }
                    if (iArr[0] > 2) {
                        c.this.X = false;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("RelativeFeedsAdapter", 1, "onScrollStateChanged error", e16);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        }
    }
}
