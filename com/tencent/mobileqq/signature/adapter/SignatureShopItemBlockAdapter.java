package com.tencent.mobileqq.signature.adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b03.c;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.signature.SignatureShopControl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SignatureShopItemBlockAdapter extends MultiViewBlock<AvatarPendantItem> implements RecyclerView.OnChildAttachStateChangeListener {
    static IPatchRedirector $redirector_;
    private a C;
    private ImageView D;
    public int E;
    private String F;
    public int G;
    private c.e H;

    /* renamed from: m, reason: collision with root package name */
    private final SignatureShopControl f288418m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(AvatarPendantItem avatarPendantItem);

        void b(AvatarPendantItem avatarPendantItem, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        private View E;
        private View F;
        private ImageView G;
        private ImageView H;
        private ImageView I;
        private TextView J;
        private ImageView K;
        private ImageView L;
        private AvatarPendantItem M;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AvatarPendantItem f288423d;

            a(AvatarPendantItem avatarPendantItem) {
                this.f288423d = avatarPendantItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) avatarPendantItem);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    b.this.n(view, this.f288423d);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.signature.adapter.SignatureShopItemBlockAdapter$b$b, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public class ViewOnClickListenerC8597b implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AvatarPendantItem f288425d;

            ViewOnClickListenerC8597b(AvatarPendantItem avatarPendantItem) {
                this.f288425d = avatarPendantItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) avatarPendantItem);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
                    String str = this.f288425d.jumpUrl;
                    com.tencent.mobileqq.signature.report.a c16 = com.tencent.mobileqq.signature.report.a.c();
                    AvatarPendantItem avatarPendantItem = this.f288425d;
                    String d16 = c16.d(avatarPendantItem.itemId, SignatureShopItemBlockAdapter.this.G, avatarPendantItem.feeType, avatarPendantItem.strRuleid, "3002002");
                    if (!TextUtils.isEmpty(d16)) {
                        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                            str = str + "&trace_num=1&trace_detail=" + d16;
                        } else {
                            str = str + "?trace_num=1&trace_detail=" + d16;
                        }
                    }
                    intent.putExtra("url", str);
                    view.getContext().startActivity(intent);
                    com.tencent.mobileqq.signature.report.a.c().f(102, SignatureShopItemBlockAdapter.this.G, this.f288425d, "3002002");
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(View view, int i3) {
            super(view);
            URLDrawable uRLDrawable;
            URLDrawable uRLDrawable2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SignatureShopItemBlockAdapter.this, view, Integer.valueOf(i3));
                return;
            }
            if (i3 != 3 && i3 != 4) {
                this.E = view;
                this.F = view.findViewById(R.id.dop);
                this.G = (ImageView) this.E.findViewById(R.id.dq5);
                this.J = (TextView) this.E.findViewById(R.id.f5e);
                this.K = (ImageView) this.E.findViewById(R.id.f85324on);
                this.H = (ImageView) this.E.findViewById(R.id.f82204g9);
                this.I = (ImageView) this.E.findViewById(R.id.f115836x4);
                this.L = (ImageView) this.E.findViewById(R.id.f163978f6);
                this.F.setPivotX(0.0f);
                this.F.setPivotY(0.0f);
                float dpToPx = (SignatureShopItemBlockAdapter.this.getActivity().getResources().getDisplayMetrics().widthPixels - ViewUtils.dpToPx(16.0f)) / 3;
                float f16 = dpToPx / this.F.getLayoutParams().width;
                this.F.setScaleX(f16);
                this.F.setScaleY(f16);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (dpToPx * (this.F.getLayoutParams().height / this.F.getLayoutParams().width)));
                layoutParams.bottomMargin = ViewUtils.dpToPx(4.0f);
                layoutParams.topMargin = ViewUtils.dpToPx(4.0f);
                this.E.setLayoutParams(layoutParams);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mFailedDrawable = drawable;
                obtain.mLoadingDrawable = drawable;
                this.I.setImageDrawable(URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-using.png", obtain));
                if (i3 == 0) {
                    uRLDrawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-left-bg.png", obtain);
                    uRLDrawable2 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-right-hover.png", obtain);
                } else if (i3 == 1) {
                    uRLDrawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-center-bg.png", obtain);
                    uRLDrawable2 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-center-hover.png", obtain);
                } else if (i3 == 2) {
                    uRLDrawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-right-bg.png", obtain);
                    uRLDrawable2 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-left-hover.png", obtain);
                } else {
                    uRLDrawable = null;
                    uRLDrawable2 = null;
                }
                if (uRLDrawable2 != null) {
                    uRLDrawable2.startDownload();
                }
                this.E.setBackground(uRLDrawable);
                this.H.setBackground(uRLDrawable2);
                this.H.setVisibility(4);
            }
        }

        private boolean m(AvatarPendantItem avatarPendantItem) {
            this.L.setVisibility(4);
            if (TextUtils.isEmpty(avatarPendantItem.jumpUrl)) {
                return false;
            }
            this.L.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("SignatureShopItem", avatarPendantItem.imageUrl, new ApngOptions()));
            this.L.setVisibility(0);
            this.H.setVisibility(4);
            this.I.setVisibility(4);
            this.G.setVisibility(4);
            this.K.setVisibility(4);
            this.J.setText("");
            this.E.setOnClickListener(new ViewOnClickListenerC8597b(avatarPendantItem));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(View view, AvatarPendantItem avatarPendantItem) {
            if (avatarPendantItem.itemId == 0) {
                return;
            }
            o(avatarPendantItem);
            com.tencent.mobileqq.signature.report.a.c().f(102, SignatureShopItemBlockAdapter.this.G, avatarPendantItem, "3001007");
        }

        private void o(AvatarPendantItem avatarPendantItem) {
            if (this.H.getVisibility() == 0) {
                this.H.setVisibility(4);
                SignatureShopItemBlockAdapter.this.D = null;
                if (SignatureShopItemBlockAdapter.this.C != null) {
                    SignatureShopItemBlockAdapter.this.C.a(avatarPendantItem);
                    return;
                }
                return;
            }
            if (SignatureShopItemBlockAdapter.this.D != null) {
                SignatureShopItemBlockAdapter.this.D.setVisibility(4);
            }
            this.H.setVisibility(0);
            SignatureShopItemBlockAdapter.this.D = this.H;
            if (SignatureShopItemBlockAdapter.this.C != null) {
                SignatureShopItemBlockAdapter.this.C.b(avatarPendantItem, SignatureShopItemBlockAdapter.this.G);
            }
        }

        public void p(AvatarPendantItem avatarPendantItem) {
            URLDrawable drawable;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarPendantItem);
                return;
            }
            this.M = avatarPendantItem;
            if (avatarPendantItem.itemId <= 0) {
                return;
            }
            this.E.setTag(avatarPendantItem);
            if (m(avatarPendantItem)) {
                return;
            }
            this.E.setOnClickListener(new a(avatarPendantItem));
            AvatarPendantItem j3 = SignatureShopItemBlockAdapter.this.f288418m.j();
            if (j3 != null && j3.itemId == avatarPendantItem.itemId) {
                this.E.setSelected(true);
                this.H.setVisibility(0);
            } else {
                this.E.setSelected(false);
                this.H.setVisibility(4);
            }
            if (avatarPendantItem.isSetup) {
                this.I.setVisibility(0);
            } else {
                this.I.setVisibility(4);
            }
            ApngOptions apngOptions = new ApngOptions();
            Drawable drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
            apngOptions.setLoadingDrawable(drawable2);
            if (!TextUtils.isEmpty(avatarPendantItem.imageUrl)) {
                this.G.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(avatarPendantItem.imageUrl, apngOptions));
                this.G.setVisibility(0);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = drawable2;
            obtain.mLoadingDrawable = drawable2;
            int i3 = avatarPendantItem.feeType;
            if (i3 == 1) {
                drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeFree.png", obtain);
                str = "\u514d\u8d39";
            } else if (i3 == 4) {
                drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeVip.png", obtain);
                str = b8.a.f28043VIP;
            } else if (i3 == 5) {
                drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeSvip.png", obtain);
                str = "SVIP";
            } else if (i3 == 6) {
                drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeAct.png", obtain);
                str = "\u6d3b\u52a8";
            } else if (i3 == 14) {
                drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeXFSvip.png", obtain);
                str = "\u7eed\u8d39SVIP";
            } else if (i3 == 18) {
                drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeGame.png", obtain);
                str = "\u6e38\u620f";
            } else if (i3 == 22) {
                drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeYearSvip.png", obtain);
                str = "\u5e74SVIP";
            } else if (i3 != 41 && i3 != 42) {
                if (i3 == 2) {
                    int i16 = avatarPendantItem.price;
                    if (i16 / 100 > 0 && i16 / 100 < 10) {
                        drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-pricetag-" + (avatarPendantItem.price / 100) + ".png", obtain);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(avatarPendantItem.price / 100);
                        sb5.append("\u5143");
                        str = sb5.toString();
                    }
                }
                drawable = null;
                str = "";
            } else {
                drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeXianMian.png", obtain);
                str = "\u9650\u514d";
            }
            if (drawable != null) {
                this.K.setVisibility(0);
                this.K.setImageDrawable(drawable);
                this.J.setMaxWidth(ViewUtils.dpToPx(33.0f));
                this.K.setContentDescription(str);
            } else {
                this.K.setVisibility(4);
                this.J.setMaxWidth(ViewUtils.dpToPx(53.0f));
            }
            this.J.setText(avatarPendantItem.name);
            this.J.invalidate();
        }
    }

    public SignatureShopItemBlockAdapter(Bundle bundle, SignatureShopControl signatureShopControl) {
        super(bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) signatureShopControl);
            return;
        }
        this.F = "";
        this.G = 0;
        this.H = new c.e() { // from class: com.tencent.mobileqq.signature.adapter.SignatureShopItemBlockAdapter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SignatureShopItemBlockAdapter.this);
                }
            }

            @Override // b03.c.e
            public void a(b03.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable(aVar) { // from class: com.tencent.mobileqq.signature.adapter.SignatureShopItemBlockAdapter.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ b03.a f288420d;

                        {
                            this.f288420d = aVar;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) aVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            b03.a aVar2 = this.f288420d;
                            if (aVar2.f27626c) {
                                SignatureShopItemBlockAdapter.this.q0(aVar2);
                            }
                            SignatureShopItemBlockAdapter.this.p0(this.f288420d);
                            SignatureShopItemBlockAdapter.this.notifyLoadingComplete(true, this.f288420d.f27626c);
                        }
                    });
                }
            }

            @Override // b03.c.e
            public void onError(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.signature.adapter.SignatureShopItemBlockAdapter.1.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                SignatureShopItemBlockAdapter.this.notifyLoadingComplete(false, false);
                            }
                        }
                    });
                }
            }
        };
        this.f288418m = signatureShopControl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(b03.a aVar) {
        addAll(aVar.f27624a);
        this.E = aVar.f27625b;
        notifyItemRangeInserted(this.mDataList.size(), aVar.f27624a.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(b03.a aVar) {
        if (aVar.f27624a.size() % 3 == 1) {
            AvatarPendantItem avatarPendantItem = new AvatarPendantItem();
            AvatarPendantItem avatarPendantItem2 = new AvatarPendantItem();
            aVar.f27624a.add(avatarPendantItem);
            aVar.f27624a.add(avatarPendantItem2);
        } else if (aVar.f27624a.size() % 3 == 2) {
            aVar.f27624a.add(new AvatarPendantItem());
        }
        AvatarPendantItem avatarPendantItem3 = new AvatarPendantItem();
        avatarPendantItem3.itemId = -1;
        aVar.f27624a.add(avatarPendantItem3);
        AvatarPendantItem avatarPendantItem4 = new AvatarPendantItem();
        avatarPendantItem4.itemId = -2;
        aVar.f27624a.add(avatarPendantItem4);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
        }
        if (((AvatarPendantItem) this.mDataList.get(i3)).itemId == -1) {
            return 3;
        }
        if (((AvatarPendantItem) this.mDataList.get(i3)).itemId == -2) {
            return 4;
        }
        return i3 % 3;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 5;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) loadInfo);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) loadInfo);
            return;
        }
        super.loadMoreData(loadInfo);
        getLoadInfo().setCurrentState(3);
        c.h(9, this.E, 36, this.F, this.H);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewHolder, i3);
        } else if (viewHolder instanceof b) {
            ((b) viewHolder).p((AvatarPendantItem) this.mDataList.get(i3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
            return;
        }
        if (view.getTag() instanceof AvatarPendantItem) {
            AvatarPendantItem avatarPendantItem = (AvatarPendantItem) view.getTag();
            if (!TextUtils.isEmpty(avatarPendantItem.jumpUrl)) {
                com.tencent.mobileqq.signature.report.a.c().f(101, this.G, avatarPendantItem, "3002002");
            } else {
                com.tencent.mobileqq.signature.report.a.c().f(101, this.G, avatarPendantItem, "3001007");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewGroup, i3);
        }
        if (3 != i3 && 4 != i3) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168573fy4, viewGroup, false), i3);
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fuy, viewGroup, false), i3);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        } else {
            getBlockMerger().setNoMoreHint("\u6211\u662f\u6700\u540e\u7684\u5e95\u7ebf\uff5e");
        }
    }

    public void r0(b03.a aVar, int i3) {
        List<AvatarPendantItem> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, i3);
            return;
        }
        if (aVar != null && (list = aVar.f27624a) != null && list.size() > 0) {
            if (aVar instanceof b03.b) {
                this.F = ((b03.b) aVar).f27627d;
            }
            this.E = aVar.f27625b;
            this.G = i3;
            if (aVar.f27626c) {
                q0(aVar);
            }
            setDatas(aVar.f27624a);
            notifyLoadingComplete(true, aVar.f27626c);
        }
    }

    public void s0(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.C = aVar;
        }
    }
}
