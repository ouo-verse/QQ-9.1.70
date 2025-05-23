package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$GetPortalRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$GetSubscriptionReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$GetSubscriptionRsp;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vip.n;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.ilive.util.ILiveEntranceUtilApi;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RelativeLiveFeedsAdapter extends MultiViewBlock<ly.a> {
    private static Drawable Y = new ColorDrawable(0);
    private int J;
    private int K;
    private boolean L;
    private int M;
    private boolean N;
    private boolean P;
    private int Q;
    private int R;
    private FolderRecommendTabFragment.FolderRecommendHeadItemView S;
    private int T;
    private int U;
    protected RecyclerView.LayoutManager V;
    CertifiedAccountRead$GetSubscriptionRsp.Bottom W;
    String X;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        public TextView f95753d;

        public b(View view) {
            super(view);
            if (view instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) view;
                if (frameLayout.getChildCount() > 0) {
                    View childAt = frameLayout.getChildAt(0);
                    if (childAt instanceof TextView) {
                        this.f95753d = (TextView) childAt;
                    }
                }
            }
        }

        public void b(String str) {
            TextView textView = this.f95753d;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends RecyclerView.ViewHolder {
        ImageView C;
        ImageView D;
        TextView E;
        TextView F;
        RelativeLayout G;
        ImageView H;
        TextView I;
        TextView J;
        ImageView K;
        TextView L;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f95755d;

        /* renamed from: e, reason: collision with root package name */
        RelativeLayout f95756e;

        /* renamed from: f, reason: collision with root package name */
        RoundImageView f95757f;

        /* renamed from: h, reason: collision with root package name */
        ImageView f95758h;

        /* renamed from: i, reason: collision with root package name */
        TextView f95759i;

        /* renamed from: m, reason: collision with root package name */
        RelativeLayout f95760m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ly.a f95761d;

            a(ly.a aVar) {
                this.f95761d = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                EventCollector.getInstance().onViewClickedBefore(view);
                CertifiedAccountRead$GetPortalRsp.RoomItem roomItem = this.f95761d.f415751b;
                String str8 = roomItem.room_id.get();
                if (RelativeLiveFeedsAdapter.this.T == 0) {
                    RelativeLiveFeedsAdapter.this.U = 6;
                    if (this.f95761d.f415752c) {
                        MobileReportManager.getInstance().reportActionLive(roomItem.room_id.get() + "", "25", "qq_live", "tab_page", "subscribe", 102, 1, System.currentTimeMillis(), roomItem.room_id.get() + "");
                    } else {
                        MobileReportManager.getInstance().reportActionLive(roomItem.room_id.get() + "", "25", "qq_live", "tab_page", "recommend_room", 102, 1, System.currentTimeMillis(), roomItem.room_id.get() + "");
                    }
                } else if (RelativeLiveFeedsAdapter.this.T == 1) {
                    RelativeLiveFeedsAdapter.this.U = 5;
                    MobileReportManager.getInstance().reportActionLive(str8 + "", "25", "qq_live", "find_page", "hot_push", 102, 1, System.currentTimeMillis(), str8 + "");
                }
                roomItem.portrait.get();
                String str9 = roomItem.pic_url.get();
                if (!roomItem.has()) {
                    str = "0";
                    str2 = str;
                    str3 = str2;
                    str4 = str3;
                } else {
                    if (!roomItem.room_type.has()) {
                        str5 = "0";
                    } else {
                        str5 = String.valueOf(roomItem.room_type.get());
                    }
                    if (!roomItem.game_id.has()) {
                        str6 = "0";
                    } else {
                        str6 = String.valueOf(roomItem.game_id.get());
                    }
                    if (!roomItem.game_tag_id.has()) {
                        str7 = "0";
                    } else {
                        str7 = String.valueOf(roomItem.game_tag_id);
                    }
                    if (roomItem.video_source.has()) {
                        str4 = String.valueOf(roomItem.video_source);
                        str = str5;
                    } else {
                        str = str5;
                        str4 = "0";
                    }
                    str2 = str6;
                    str3 = str7;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("RelativeFeedsAdapter", 2, "setClickListener roomType:" + str + ", gameId:" + str2 + ", gameTagId:" + str3 + ", videoSource:" + str4);
                }
                c cVar = c.this;
                RelativeLiveFeedsAdapter.this.s0(cVar.itemView.getContext(), str8, null, RelativeLiveFeedsAdapter.this.u0(), RelativeLiveFeedsAdapter.this.U, str9, str, str2, str3, str4);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public c(View view) {
            super(view);
            this.f95755d = (RelativeLayout) view.findViewById(R.id.ylo);
            this.f95756e = (RelativeLayout) view.findViewById(R.id.ylt);
            RoundImageView roundImageView = (RoundImageView) view.findViewById(R.id.yks);
            this.f95757f = roundImageView;
            roundImageView.setmRadius(ImmersiveUtils.dpToPx(8.0f), false);
            this.f95758h = (ImageView) view.findViewById(R.id.ymd);
            this.f95759i = (TextView) view.findViewById(R.id.swn);
            this.f95760m = (RelativeLayout) view.findViewById(R.id.tbm);
            this.C = (ImageView) view.findViewById(R.id.vr6);
            this.D = (ImageView) view.findViewById(R.id.vr7);
            this.E = (TextView) view.findViewById(R.id.vr5);
            this.F = (TextView) view.findViewById(R.id.vr8);
            this.G = (RelativeLayout) view.findViewById(R.id.vr9);
            ImageView imageView = (ImageView) view.findViewById(R.id.vr_);
            this.H = imageView;
            imageView.setColorFilter(1291845632);
            this.I = (TextView) view.findViewById(R.id.vra);
            this.J = (TextView) view.findViewById(R.id.ym5);
            this.K = (ImageView) view.findViewById(R.id.f165679x83);
            TextView textView = (TextView) view.findViewById(R.id.f9o);
            this.L = textView;
            textView.setTextColor(-6775116);
        }

        private boolean b(String str) {
            if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                return true;
            }
            return false;
        }

        private void e(CertifiedAccountRead$GetPortalRsp.RoomItem roomItem) {
            CertifiedAccountRead$GetPortalRsp.RoomGoodInfo roomGoodInfo = roomItem.good_info;
            this.f95760m.setVisibility(8);
            this.G.setVisibility(8);
            if (roomGoodInfo.has_good.get() == 0) {
                QLog.d("RelativeFeedsAdapter", 1, "current display has no goods message");
                return;
            }
            h(this.C, roomGoodInfo.pic_url.get());
            this.E.setText(roomGoodInfo.name.get());
            if (!TextUtils.isEmpty(roomGoodInfo.price.get())) {
                this.F.setText(j(Float.valueOf(roomGoodInfo.price.get())));
                this.f95760m.setVisibility(0);
            }
            if (roomGoodInfo.goods_num.get() > 0) {
                if (!TextUtils.isEmpty(roomGoodInfo.recomm_url.get())) {
                    h(this.H, roomGoodInfo.recomm_url.get());
                } else {
                    this.H.setImageDrawable(new ColorDrawable(1291845632));
                }
                this.I.setText(roomGoodInfo.goods_num.get() + "\n\u597d\u7269");
                this.G.setVisibility(0);
            }
        }

        private void f(CertifiedAccountRead$GetPortalRsp.RoomItem roomItem) {
            if (!roomItem.icon_info.has()) {
                return;
            }
            if (TextUtils.isEmpty(roomItem.icon_info.icon_url.get())) {
                this.f95758h.setVisibility(8);
            } else {
                this.f95758h.setImageDrawable(VasApngUtil.getApngURLDrawable(roomItem.icon_info.icon_url.get(), new int[]{2}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null));
                this.f95758h.setVisibility(0);
            }
            this.f95759i.setText("\u4eba\u6c14" + i(roomItem.icon_info.audience_num.get()) + "");
        }

        private void g() {
            if (RelativeLiveFeedsAdapter.this.N) {
                this.f95756e.setAlpha(0.7f);
                this.f95756e.setBackgroundColor(-16777216);
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
                    imageView.setImageDrawable(URLDrawable.getDrawable(str, RelativeLiveFeedsAdapter.Y, RelativeLiveFeedsAdapter.Y));
                    imageView.setTag(str);
                }
            }
        }

        public void c(c cVar, ly.a aVar) {
            this.itemView.setOnClickListener(new a(aVar));
        }

        public void d(ly.a aVar) {
            CertifiedAccountRead$GetPortalRsp.RoomItem roomItem = aVar.f415751b;
            if (roomItem == null) {
                return;
            }
            h(this.f95757f, roomItem.pic_url.get());
            g();
            this.J.setText(roomItem.title.get());
            if (!b(roomItem.portrait.get())) {
                return;
            }
            this.K.setImageDrawable(URLDrawable.getDrawable(roomItem.portrait.get()));
            this.L.setText(roomItem.nick.get());
            f(roomItem);
            e(roomItem);
            if (roomItem.room_id.has()) {
                if (RelativeLiveFeedsAdapter.this.T == 0) {
                    if (aVar.f415752c) {
                        MobileReportManager.getInstance().reportActionLive(roomItem.room_id.get() + "", "25", "qq_live", "tab_page", "subscribe", 101, 1, System.currentTimeMillis(), roomItem.room_id.get() + "");
                        return;
                    }
                    MobileReportManager.getInstance().reportActionLive(roomItem.room_id.get() + "", "25", "qq_live", "tab_page", "recommend_room", 101, 1, System.currentTimeMillis(), roomItem.room_id.get() + "");
                    return;
                }
                if (RelativeLiveFeedsAdapter.this.T == 1) {
                    MobileReportManager.getInstance().reportActionLive(roomItem.room_id.get() + "", "25", "qq_live", "find_page", "hot_push", 101, 1, System.currentTimeMillis(), roomItem.room_id.get() + "");
                }
            }
        }

        public String i(long j3) {
            StringBuilder sb5;
            if (10000 <= j3 && j3 < 1000000) {
                int i3 = (int) ((j3 / 1000) % 10);
                int i16 = (int) (j3 / 10000);
                if (i3 == 0) {
                    sb5 = new StringBuilder();
                    sb5.append("");
                    sb5.append(i16);
                } else {
                    sb5 = new StringBuilder();
                    sb5.append("");
                    sb5.append(i16);
                    sb5.append(".");
                    sb5.append(i3);
                }
                sb5.append("w");
                return sb5.toString();
            }
            if (j3 >= 1000000) {
                return "" + ((int) (j3 / 10000)) + "w";
            }
            return "" + j3;
        }

        public String j(Float f16) {
            if (10000.0f <= f16.floatValue() && f16.floatValue() < 1.0E8f) {
                int floatValue = (int) ((f16.floatValue() / 100.0f) % 100.0f);
                return "" + ((int) (f16.floatValue() / 10000.0f)) + "." + floatValue + "\u4e07";
            }
            if (f16.floatValue() >= 1.0E8f) {
                int floatValue2 = (int) ((f16.floatValue() / 1.0E7f) % 100.0f);
                return "" + ((int) (f16.floatValue() / 1.0E8f)) + "." + floatValue2 + "\u4ebf";
            }
            return "" + f16;
        }
    }

    public RelativeLiveFeedsAdapter(Bundle bundle) {
        super(bundle);
        this.J = ImmersiveUtils.dpToPx(16.0f);
        this.K = ImmersiveUtils.dpToPx(13.0f);
        this.L = true;
        this.M = -1;
        this.N = false;
        this.P = true;
        this.T = -1;
        this.U = 99;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(boolean z16, Object obj) {
        boolean z17;
        if (z16 && z16 && (obj instanceof CertifiedAccountRead$GetSubscriptionRsp)) {
            QLog.d("RelativeFeedsAdapter", 2, "isSuccess:" + z16 + " updateFeedsData:");
            CertifiedAccountRead$GetSubscriptionRsp certifiedAccountRead$GetSubscriptionRsp = (CertifiedAccountRead$GetSubscriptionRsp) obj;
            List<CertifiedAccountRead$GetPortalRsp.RoomLstItem> list = certifiedAccountRead$GetSubscriptionRsp.room_lst.get();
            CertifiedAccountRead$GetSubscriptionRsp.Bottom bottom = certifiedAccountRead$GetSubscriptionRsp.bottom.get();
            String str = certifiedAccountRead$GetSubscriptionRsp.page_info.get();
            H().n(str);
            if (this.S != null) {
                if (list != null && list.size() > 0) {
                    z17 = v0(false, list);
                    if (z17) {
                        this.S.y(false);
                        A0(list, bottom, str);
                        if (bottom != null) {
                            this.S.x(true, bottom.desc.get(), bottom.jump_url.get());
                        }
                    }
                } else {
                    z17 = false;
                }
                if (!z17) {
                    q();
                    this.S.y(true);
                    this.S.x(false, null, null);
                }
            }
        }
    }

    @NotNull
    private FrameLayout r0(ViewGroup viewGroup) {
        TextView textView = new TextView(viewGroup.getContext());
        textView.setTag("title");
        FrameLayout B = B(textView);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(1, 16.0f);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#989eb4"));
        textView.getPaint().setFakeBoldText(true);
        layoutParams.topMargin = ImmersiveUtils.dpToPx(10.0f);
        textView.setText(HardCodeUtil.qqStr(R.string.kaw));
        return B;
    }

    private RecyclerView.ViewHolder t0(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fs_, viewGroup, false);
        c cVar = new c(inflate);
        int i3 = inflate.getResources().getDisplayMetrics().widthPixels;
        this.Q = i3;
        int dpToPx = (int) ((i3 * 0.5f) - ViewUtils.dpToPx(8.5f));
        int dpToPx2 = dpToPx - ViewUtils.dpToPx(7.0f);
        this.R = dpToPx2;
        int dpToPx3 = dpToPx2 + ViewUtils.dpToPx(54.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.f95755d.getLayoutParams();
        layoutParams.width = dpToPx;
        layoutParams.height = dpToPx3;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) cVar.f95757f.getLayoutParams();
        int i16 = this.R;
        layoutParams2.width = i16;
        layoutParams2.height = i16;
        return cVar;
    }

    public void A0(List<CertifiedAccountRead$GetPortalRsp.RoomLstItem> list, CertifiedAccountRead$GetSubscriptionRsp.Bottom bottom, String str) {
        if (list == null) {
            return;
        }
        this.W = bottom;
        this.X = str;
        this.f96195d.clear();
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 < list.size()) {
                List<CertifiedAccountRead$GetPortalRsp.RoomItem> list2 = list.get(i3).room_lst.get();
                if (list2 != null && list2.size() != 0) {
                    if (i3 != 0 || this.T != 0) {
                        z16 = false;
                    }
                    this.f96195d.add(new ly.a(list.get(i3).tab_info.name.get(), null));
                    for (int i16 = 0; i16 < list2.size(); i16++) {
                        this.f96195d.add(new ly.a(null, list2.get(i16), z16));
                    }
                }
                i3++;
            } else {
                W(true);
                return;
            }
        }
    }

    public void B0(FolderRecommendTabFragment.FolderRecommendHeadItemView folderRecommendHeadItemView) {
        this.S = folderRecommendHeadItemView;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void G(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (this.L && (viewLayoutPosition == 0 || viewLayoutPosition == 1)) {
            rect.bottom = this.K;
        } else {
            rect.bottom = this.J;
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int N(int i3) {
        if (getItemViewType(i3) == 100000) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public String O() {
        return "RELATIVE_ADAPTER_UNIQUE_KEY";
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int P() {
        return 3;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
        CertifiedAccountRead$GetSubscriptionReq certifiedAccountRead$GetSubscriptionReq = new CertifiedAccountRead$GetSubscriptionReq();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (!TextUtils.isEmpty(qQAppInterface.getCurrentUin())) {
            certifiedAccountRead$GetSubscriptionReq.uin.set(Long.valueOf(qQAppInterface.getCurrentUin()).longValue());
        }
        certifiedAccountRead$GetSubscriptionReq.page_id.set(2);
        if (this.M != -1 && (bVar.f() || bVar.i())) {
            certifiedAccountRead$GetSubscriptionReq.page_info.set("");
        } else if (this.M != -1 && bVar.g()) {
            if (!TextUtils.isEmpty(H().d())) {
                certifiedAccountRead$GetSubscriptionReq.page_info.set(H().d());
            } else {
                certifiedAccountRead$GetSubscriptionReq.page_info.set("");
            }
        }
        n.request("QQLive.GetSubscriptionData", certifiedAccountRead$GetSubscriptionReq, CertifiedAccountRead$GetSubscriptionRsp.class, new BusinessObserver() { // from class: com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter.1
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, final boolean z16, final Object obj) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RelativeLiveFeedsAdapter.this.C0(z16, obj);
                    }
                });
            }
        });
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
        K().addOnScrollListener(new a());
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.f96142i) {
            return 4;
        }
        return this.f96195d.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 >= this.f96195d.size()) {
            return 100002;
        }
        if (((ly.a) this.f96195d.get(i3)).f415750a != null) {
            return 100000;
        }
        if (((ly.a) this.f96195d.get(i3)).f415751b == null) {
            return 100002;
        }
        return 100003;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.V = recyclerView.getLayoutManager();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @SuppressLint({"WrongConstant"})
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.L) {
            i3--;
        }
        if (!ArrayUtils.isOutOfArrayIndex(i3, r())) {
            if (viewHolder instanceof b) {
                ((b) viewHolder).b(((ly.a) this.f96195d.get(i3)).f415750a);
            }
            if (viewHolder instanceof c) {
                ly.a aVar = (ly.a) this.f96195d.get(i3);
                c cVar = (c) viewHolder;
                cVar.d(aVar);
                cVar.c(cVar, aVar);
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 100000) {
            return new b(r0(viewGroup));
        }
        if (i3 == 100003) {
            return t0(viewGroup);
        }
        return new b(new RelativeFeedItemView(viewGroup.getContext()));
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public void q0(List<CertifiedAccountRead$GetPortalRsp.RoomLstItem> list, CertifiedAccountRead$GetSubscriptionRsp.Bottom bottom, String str) {
        if (list == null) {
            return;
        }
        this.W = bottom;
        this.X = str;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 < list.size()) {
                List<CertifiedAccountRead$GetPortalRsp.RoomItem> list2 = list.get(i3).room_lst.get();
                if (list2 != null && list2.size() != 0) {
                    if (i3 != 0 || this.T != 0) {
                        z16 = false;
                    }
                    if (this.f96195d.size() > 0 && i3 != 0) {
                        this.f96195d.add(new ly.a(list.get(i3).tab_info.name.get(), null));
                    }
                    for (int i16 = 0; i16 < list2.size(); i16++) {
                        this.f96195d.add(new ly.a(null, list2.get(i16), z16));
                    }
                }
                i3++;
            } else {
                W(true);
                return;
            }
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.a.e
    public void r2(String str, a.d dVar) {
        super.r2(str, dVar);
        if (str.equals("share_key_subscribe_feeds_update") && dVar.f96169a != null && dVar.f96170b) {
            b0();
        }
    }

    public void s0(Context context, String str, String str2, ArrayList<String> arrayList, int i3, String str3, String str4, String str5, String str6, String str7) {
        n05.a aVar = new n05.a(context, "subscription", str, str2, false, arrayList, "", i3);
        aVar.f417949e = str3;
        aVar.f417957m = str4;
        aVar.f417958n = str5;
        aVar.f417959o = str6;
        aVar.f417960p = str7;
        ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).liveWatchEntranceJump(aVar);
    }

    public ArrayList<String> u0() {
        CertifiedAccountRead$GetPortalRsp.RoomItem roomItem;
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator it = this.f96195d.iterator();
        while (it.hasNext() && (roomItem = ((ly.a) it.next()).f415751b) != null) {
            try {
                arrayList.add(new String(roomItem.toByteArray(), "ISO8859_1"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        return arrayList;
    }

    public boolean v0(boolean z16, List<CertifiedAccountRead$GetPortalRsp.RoomLstItem> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).room_lst.size() > 0) {
                return true;
            }
        }
        return z16;
    }

    public void w0(int i3) {
        this.T = i3;
    }

    public void x0(int i3) {
        this.M = i3;
    }

    public void y0(boolean z16) {
        this.N = z16;
    }

    public void z0(boolean z16) {
        this.L = z16;
        notifyDataSetChanged();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            try {
                super.onScrollStateChanged(recyclerView, i3);
                RecyclerView.LayoutManager layoutManager = RelativeLiveFeedsAdapter.this.V;
                if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    staggeredGridLayoutManager.computeVerticalScrollExtent(new RecyclerView.State());
                    int[] iArr = new int[staggeredGridLayoutManager.getColumnCountForAccessibility(null, null)];
                    staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
                    if (RelativeLiveFeedsAdapter.this.I(iArr[0]) <= 0 && !RelativeLiveFeedsAdapter.this.P) {
                        RelativeLiveFeedsAdapter.this.P = true;
                        staggeredGridLayoutManager.invalidateSpanAssignments();
                    }
                    if (iArr[0] > 2) {
                        RelativeLiveFeedsAdapter.this.P = false;
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
