package com.tencent.mobileqq.pendant.adapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b03.c;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.pendant.AvatarPendantShopFragment;
import com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AvatarShopItemBlockAdapter extends MultiViewBlock<AvatarPendantItem> implements RecyclerView.OnChildAttachStateChangeListener {
    static IPatchRedirector $redirector_;
    private static final boolean K;
    private static final DownloadParams.DecodeHandler L;
    private b C;
    private ImageView D;
    public int E;
    private int F;
    private String G;
    private boolean H;
    public int I;
    private c.e J;

    /* renamed from: m, reason: collision with root package name */
    private final PendantAvatarShopLayout f257479m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class VH extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        private View E;
        private View F;
        private ImageView G;
        private ImageView H;
        private ImageView I;
        private ImageView J;
        private TextView K;
        private TextView L;
        private TextView M;
        private ViewGroup N;
        private ImageView P;
        private TextView Q;
        private ImageView R;
        private ImageView S;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AvatarPendantItem f257487d;

            a(AvatarPendantItem avatarPendantItem) {
                this.f257487d = avatarPendantItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VH.this, (Object) avatarPendantItem);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    VH.this.o(this.f257487d);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public class b implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AvatarPendantItem f257489d;

            b(AvatarPendantItem avatarPendantItem) {
                this.f257489d = avatarPendantItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VH.this, (Object) avatarPendantItem);
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
                    String str = this.f257489d.jumpUrl;
                    IPendantAvatarShopReport iPendantAvatarShopReport = (IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class);
                    int i3 = AvatarShopItemBlockAdapter.this.F;
                    AvatarPendantItem avatarPendantItem = this.f257489d;
                    String traceDetail = iPendantAvatarShopReport.getTraceDetail(i3, avatarPendantItem.itemId, AvatarShopItemBlockAdapter.this.I, avatarPendantItem.feeType, avatarPendantItem.strRuleid, "3002002");
                    if (!TextUtils.isEmpty(traceDetail)) {
                        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                            str = str + "&trace_num=1&trace_detail=" + traceDetail;
                        } else {
                            str = str + "?trace_num=1&trace_detail=" + traceDetail;
                        }
                    }
                    intent.putExtra("url", str);
                    view.getContext().startActivity(intent);
                    IPendantAvatarShopReport iPendantAvatarShopReport2 = (IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class);
                    AvatarPendantItem avatarPendantItem2 = this.f257489d;
                    iPendantAvatarShopReport2.onAdItem(102, avatarPendantItem2.itemId, AvatarShopItemBlockAdapter.this.I, avatarPendantItem2.strRuleid, "3002002");
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public class c implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AvatarPendantItem f257491d;

            c(AvatarPendantItem avatarPendantItem) {
                this.f257491d = avatarPendantItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VH.this, (Object) avatarPendantItem);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    VH.this.u(this.f257491d);
                    dialogInterface.dismiss();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public class d implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VH.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public class e implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AvatarPendantItem f257494d;

            e(AvatarPendantItem avatarPendantItem) {
                this.f257494d = avatarPendantItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VH.this, (Object) avatarPendantItem);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    VH.this.u(this.f257494d);
                    dialogInterface.dismiss();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public class f implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VH.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public class g implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            g() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VH.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        public VH(View view, int i3) {
            super(view);
            int i16;
            int dpToPx;
            URLDrawable uRLDrawable;
            URLDrawable uRLDrawable2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AvatarShopItemBlockAdapter.this, view, Integer.valueOf(i3));
                return;
            }
            if (i3 != 3 && i3 != 4) {
                this.E = view;
                this.R = (ImageView) view.findViewById(R.id.f624830y);
                this.F = this.E.findViewById(R.id.dop);
                this.H = (ImageView) this.E.findViewById(R.id.f236206x);
                this.G = (ImageView) this.E.findViewById(R.id.f164551a35);
                this.K = (TextView) this.E.findViewById(R.id.f5e);
                this.L = (TextView) this.E.findViewById(R.id.f27500ge);
                this.P = (ImageView) this.E.findViewById(R.id.f85324on);
                this.Q = (TextView) this.E.findViewById(R.id.f27510gf);
                this.M = (TextView) this.E.findViewById(R.id.uip);
                this.N = (ViewGroup) this.E.findViewById(R.id.uiq);
                this.I = (ImageView) this.E.findViewById(R.id.f82204g9);
                this.S = (ImageView) this.E.findViewById(R.id.f163978f6);
                this.J = (ImageView) this.E.findViewById(R.id.f115836x4);
                this.F.setPivotX(0.0f);
                this.F.setPivotY(0.0f);
                if (PadUtil.a(AvatarShopItemBlockAdapter.this.getActivity()) == DeviceType.FOLD) {
                    i16 = m.d();
                    dpToPx = ViewUtils.dpToPx(22.0f);
                } else {
                    i16 = AvatarShopItemBlockAdapter.this.getActivity().getResources().getDisplayMetrics().widthPixels;
                    dpToPx = ViewUtils.dpToPx(22.0f);
                }
                float f16 = (i16 - dpToPx) / 3;
                float f17 = f16 / this.F.getLayoutParams().width;
                this.F.setScaleX(f17);
                this.F.setScaleY(f17);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (f16 * (this.F.getLayoutParams().height / this.F.getLayoutParams().width)));
                layoutParams.bottomMargin = ViewUtils.dpToPx(4.0f);
                layoutParams.topMargin = ViewUtils.dpToPx(4.0f);
                this.E.setLayoutParams(layoutParams);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mFailedDrawable = drawable;
                obtain.mLoadingDrawable = drawable;
                this.J.setImageDrawable(URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-using.png", obtain));
                if (i3 == 0) {
                    uRLDrawable2 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-left-bg.png", obtain);
                    uRLDrawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-right-hover.png", obtain);
                } else if (i3 == 1) {
                    uRLDrawable2 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-center-bg.png", obtain);
                    uRLDrawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-center-hover.png", obtain);
                } else if (i3 == 2) {
                    uRLDrawable2 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-right-bg.png", obtain);
                    uRLDrawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/avatarstore-left-hover.png", obtain);
                } else {
                    uRLDrawable = null;
                    uRLDrawable2 = null;
                }
                if (uRLDrawable != null) {
                    uRLDrawable.startDownload();
                }
                this.E.setBackground(uRLDrawable2);
                this.I.setBackground(uRLDrawable);
                this.I.setVisibility(4);
                if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
                    this.K.setTextColor(-1);
                }
            }
        }

        private boolean n(AvatarPendantItem avatarPendantItem) {
            Drawable apngURLDrawable;
            this.S.setVisibility(4);
            if (TextUtils.isEmpty(avatarPendantItem.jumpUrl)) {
                return false;
            }
            if (AvatarShopItemBlockAdapter.K) {
                apngURLDrawable = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(avatarPendantItem.imageUrl).l(VasDynamicDrawableCache.INSTANCE).a();
            } else {
                apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(AvatarShopItemBlockAdapter.class.getName(), avatarPendantItem.imageUrl, new ApngOptions());
            }
            this.S.setImageDrawable(apngURLDrawable);
            this.S.setVisibility(0);
            this.I.setVisibility(4);
            this.J.setVisibility(4);
            this.H.setVisibility(4);
            this.R.setVisibility(4);
            this.P.setVisibility(4);
            this.K.setText("");
            this.E.setOnClickListener(new b(avatarPendantItem));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(AvatarPendantItem avatarPendantItem) {
            boolean z16;
            View view;
            if (avatarPendantItem.itemId == 0) {
                return;
            }
            if (AvatarShopItemBlockAdapter.this.H) {
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onSplendidShopItem(102, avatarPendantItem.itemId);
            } else {
                int i3 = avatarPendantItem.appid;
                if (i3 == 4) {
                    ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPendantItem(102, avatarPendantItem.itemId, AvatarShopItemBlockAdapter.this.I, avatarPendantItem.strRuleid);
                } else if (i3 == 23 && avatarPendantItem.feeType == -1) {
                    ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onQQShowItem(102, avatarPendantItem.itemId);
                } else {
                    ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPersonalItem(102, avatarPendantItem.itemId, AvatarShopItemBlockAdapter.this.I, avatarPendantItem.strRuleid);
                }
            }
            Fragment parentFragment = AvatarShopItemBlockAdapter.this.getParentFragment();
            boolean t16 = t();
            if (parentFragment instanceof AvatarPendantShopFragment) {
                z16 = ((AvatarPendantShopFragment) parentFragment).Eh().isUserWearPendant();
            } else {
                z16 = false;
            }
            boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
            boolean isNowElderMode = SimpleUIUtil.isNowElderMode();
            if (simpleUISwitch && !isNowElderMode && (view = this.E) != null && avatarPendantItem.appid == 4) {
                x(view, avatarPendantItem);
                return;
            }
            if (avatarPendantItem.appid == 4 && t16) {
                View view2 = this.E;
                if (view2 == null) {
                    return;
                }
                DialogUtil.createCenterTextDialog(view2.getContext(), 230, null, "\u5f53\u524d\u5934\u50cf\u7c7b\u578b\u4e0d\u652f\u6301\u4f7f\u7528\u6302\u4ef6\uff0c\u5982\u9700\u88c5\u626e\u6302\u4ef6\u5c06\u81ea\u52a8\u5207\u6362\u4e3a\u9ed8\u8ba4\u5934\u50cf\n", "\u53d6\u6d88", "\u786e\u8ba4", new c(avatarPendantItem), new d()).show();
                return;
            }
            if (AvatarShopItemBlockAdapter.this.H && z16) {
                if (this.E == null) {
                    return;
                }
                DialogUtil.createCenterTextDialog(this.E.getContext(), 230, null, "\u4f7f\u7528" + com.tencent.mobileqq.vip.api.b.a().getSplendidTitle() + "\u5934\u50cf\u540e\uff0c\u5c06\u4e0d\u518d\u5c55\u793a\u6b63\u5728\u4f7f\u7528\u7684\u5934\u50cf\u6302\u4ef6\uff0c\u786e\u8ba4\u4f7f\u7528\uff1f\n", "\u53d6\u6d88", "\u786e\u8ba4", new e(avatarPendantItem), new f()).show();
                return;
            }
            u(avatarPendantItem);
        }

        private SpannableStringBuilder p(int i3, int i16) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String str = "\u00a5" + (i3 / 100);
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(i16 - 1)), 0, 1, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(i16)), 1, str.length(), 33);
            return spannableStringBuilder;
        }

        private void q(AvatarPendantItem avatarPendantItem) {
            this.Q.setVisibility(8);
            this.L.setVisibility(8);
            this.N.setVisibility(8);
            if (avatarPendantItem.feeType != 2) {
                return;
            }
            if (r(avatarPendantItem) && avatarPendantItem.userCanDiscount) {
                w(avatarPendantItem);
            } else {
                int i3 = avatarPendantItem.price;
                if (i3 > 0) {
                    this.L.setText(p(i3, 6));
                    this.L.setVisibility(0);
                }
            }
            if (AvatarShopItemBlockAdapter.this.K0(avatarPendantItem)) {
                this.N.setVisibility(0);
                this.M.setText(p(avatarPendantItem.discountPrice, 5));
            }
        }

        private boolean r(AvatarPendantItem avatarPendantItem) {
            if (!AvatarShopItemBlockAdapter.this.K0(avatarPendantItem) && !s(avatarPendantItem)) {
                return false;
            }
            return true;
        }

        private boolean s(AvatarPendantItem avatarPendantItem) {
            if (avatarPendantItem.feeType != 49 && avatarPendantItem.discountReason != 6) {
                return false;
            }
            return true;
        }

        private boolean t() {
            Fragment parentFragment = AvatarShopItemBlockAdapter.this.getParentFragment();
            if (parentFragment instanceof AvatarPendantShopFragment) {
                return ((AvatarPendantShopFragment) parentFragment).Eh().isCurrentPreviewSplendidAvatar();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(AvatarPendantItem avatarPendantItem) {
            if (this.I.getVisibility() == 0) {
                this.I.setVisibility(4);
                AvatarShopItemBlockAdapter.this.D = null;
                if (AvatarShopItemBlockAdapter.this.C != null) {
                    AvatarShopItemBlockAdapter.this.C.a(avatarPendantItem);
                    return;
                }
                return;
            }
            if (AvatarShopItemBlockAdapter.this.D != null) {
                AvatarShopItemBlockAdapter.this.D.setVisibility(4);
            }
            this.I.setVisibility(0);
            AvatarShopItemBlockAdapter.this.D = this.I;
            if (AvatarShopItemBlockAdapter.this.C != null) {
                AvatarShopItemBlockAdapter.this.C.b(avatarPendantItem, AvatarShopItemBlockAdapter.this.H, AvatarShopItemBlockAdapter.this.I);
            }
        }

        private void w(AvatarPendantItem avatarPendantItem) {
            this.Q.getPaint().setFlags(16);
            this.Q.setText(p(avatarPendantItem.price, 5));
            this.Q.setVisibility(0);
        }

        private void x(View view, AvatarPendantItem avatarPendantItem) {
            DialogUtil.createCenterTextDialog(view.getContext(), 230, "\u6e29\u99a8\u63d0\u793a", "\u5f53\u524d\u5904\u4e8e\"\u4f53\u9a8c\u6a21\u5f0f\"\uff0c\u4e0d\u5c55\u793a\u88c5\u626e\u3002\u70b9\u51fb\"\u7acb\u5373\u5207\u6362\"\uff0c\u53ef\u5207\u6362\u4e3a\"\u666e\u901a\u6a21\u5f0f\"\n", "\u6211\u77e5\u9053\u4e86", "\u7acb\u5373\u5207\u6362", new DialogInterface.OnClickListener(view, avatarPendantItem) { // from class: com.tencent.mobileqq.pendant.adapter.AvatarShopItemBlockAdapter.VH.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f257484d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ AvatarPendantItem f257485e;

                {
                    this.f257484d = view;
                    this.f257485e = avatarPendantItem;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, VH.this, view, avatarPendantItem);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        ThemeSwitcher.startSwitch(ThemeUtil.getThemeId(), ThemeReporter.FROM_SIMPLE, new ThemeSwitchCallback() { // from class: com.tencent.mobileqq.pendant.adapter.AvatarShopItemBlockAdapter.VH.7.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                }
                            }

                            @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
                            public boolean postSwitch(int i16) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, i16)).booleanValue();
                                }
                                if (i16 == 0) {
                                    QQToast.makeText(AnonymousClass7.this.f257484d.getContext(), "\u5df2\u5f00\u542f\u666e\u901a\u6a21\u5f0f", 0).show();
                                }
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                VH.this.u(anonymousClass7.f257485e);
                                return false;
                            }
                        });
                        dialogInterface.dismiss();
                    }
                }
            }, new g()).show();
        }

        public void v(AvatarPendantItem avatarPendantItem) {
            Drawable apngURLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarPendantItem);
                return;
            }
            if (avatarPendantItem.itemId < 0) {
                return;
            }
            this.E.setTag(avatarPendantItem);
            if (n(avatarPendantItem)) {
                return;
            }
            this.E.setOnClickListener(new a(avatarPendantItem));
            AvatarPendantItem u16 = AvatarShopItemBlockAdapter.this.f257479m.u(AvatarShopItemBlockAdapter.this.F);
            if (u16 != null && u16.itemId == avatarPendantItem.itemId) {
                this.I.setVisibility(0);
            } else {
                this.I.setVisibility(4);
            }
            if (avatarPendantItem.isSetup) {
                this.J.setVisibility(0);
            } else {
                this.J.setVisibility(4);
            }
            if (!TextUtils.isEmpty(avatarPendantItem.imageUrl)) {
                if (VasNormalToggle.VAS_FEATURE_SHOP_AVIF.isEnable(false)) {
                    apngURLDrawable = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(avatarPendantItem.imageUrl).l(VasDynamicDrawableCache.INSTANCE).b(com.tencent.mobileqq.pendant.downloader.b.f257506a).a();
                } else if (AvatarShopItemBlockAdapter.K) {
                    apngURLDrawable = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(avatarPendantItem.imageUrl).l(VasDynamicDrawableCache.INSTANCE).a();
                } else {
                    ApngOptions apngOptions = new ApngOptions();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("key_draw_round", true);
                    apngOptions.setExtraInfo(bundle);
                    apngOptions.setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                    apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(AvatarShopItemBlockAdapter.class.getName(), avatarPendantItem.imageUrl, apngOptions);
                }
                if (avatarPendantItem.appid == 23 && !AvatarShopItemBlockAdapter.this.H) {
                    AvatarPendantItem.ZplanAvatarInfo zplanAvatarInfo = avatarPendantItem.zplanAvatarInfo;
                    if (zplanAvatarInfo != null && !TextUtils.isEmpty(zplanAvatarInfo.avatarPath)) {
                        ImageView imageView = this.R;
                        AvatarShopItemBlockAdapter avatarShopItemBlockAdapter = AvatarShopItemBlockAdapter.this;
                        String str = avatarPendantItem.zplanAvatarInfo.avatarPath;
                        int dpToPx = ViewUtils.dpToPx(126.0f);
                        AvatarPendantItem.ZplanAvatarInfo zplanAvatarInfo2 = avatarPendantItem.zplanAvatarInfo;
                        imageView.setImageDrawable(avatarShopItemBlockAdapter.A0(str, dpToPx, zplanAvatarInfo2.isDynamic, zplanAvatarInfo2.mode));
                    } else {
                        this.R.setImageDrawable(apngURLDrawable);
                    }
                    this.R.setVisibility(0);
                    this.H.setVisibility(4);
                } else {
                    this.H.setImageDrawable(apngURLDrawable);
                    this.H.setVisibility(0);
                    this.R.setVisibility(4);
                }
            } else {
                this.H.setVisibility(4);
                this.R.setVisibility(4);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            Drawable J0 = AvatarShopItemBlockAdapter.this.J0(avatarPendantItem, obtain);
            if (J0 != null) {
                this.P.setVisibility(0);
                this.P.setImageDrawable(J0);
                this.K.setMaxWidth(ViewUtils.dpToPx(33.0f));
            } else {
                this.P.setVisibility(8);
                this.K.setMaxWidth(ViewUtils.dpToPx(53.0f));
            }
            float F0 = AvatarShopItemBlockAdapter.this.F0(avatarPendantItem);
            ViewGroup.LayoutParams layoutParams = this.P.getLayoutParams();
            layoutParams.width = ViewUtils.dpToPx(F0);
            this.P.setLayoutParams(layoutParams);
            q(avatarPendantItem);
            this.K.setVisibility(8);
            this.K.setText(avatarPendantItem.name);
            this.E.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    float q16 = ah.q();
                    if (q16 < 0.01f) {
                        q16 = 1.0f;
                    }
                    int i3 = (int) (iArr[0] / q16);
                    iArr[0] = i3;
                    int i16 = (int) (iArr[1] / q16);
                    iArr[1] = i16;
                    return AvatarShopItemBlockAdapter.H0(bitmap, i3, i16);
                }
            }
            return AvatarShopItemBlockAdapter.H0(bitmap, 50, 50);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(AvatarPendantItem avatarPendantItem);

        void b(AvatarPendantItem avatarPendantItem, boolean z16, int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50273);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            K = ar.b("shouyouye", "2024-10-28", "vas_bug_fix_130862863").isEnable(true);
            L = new a();
        }
    }

    public AvatarShopItemBlockAdapter(Bundle bundle, PendantAvatarShopLayout pendantAvatarShopLayout) {
        super(bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) pendantAvatarShopLayout);
            return;
        }
        this.G = "";
        this.H = false;
        this.I = 0;
        this.J = new c.e() { // from class: com.tencent.mobileqq.pendant.adapter.AvatarShopItemBlockAdapter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarShopItemBlockAdapter.this);
                }
            }

            @Override // b03.c.e
            public void a(b03.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable(aVar) { // from class: com.tencent.mobileqq.pendant.adapter.AvatarShopItemBlockAdapter.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ b03.a f257481d;

                        {
                            this.f257481d = aVar;
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
                            b03.a aVar2 = this.f257481d;
                            if (aVar2.f27626c) {
                                AvatarShopItemBlockAdapter.this.z0(aVar2);
                            }
                            AvatarShopItemBlockAdapter.this.y0(this.f257481d);
                            AvatarShopItemBlockAdapter.this.notifyLoadingComplete(true, this.f257481d.f27626c);
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
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.pendant.adapter.AvatarShopItemBlockAdapter.1.2
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
                                AvatarShopItemBlockAdapter.this.notifyLoadingComplete(false, false);
                            }
                        }
                    });
                }
            }
        };
        this.f257479m = pendantAvatarShopLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable A0(String str, int i3, boolean z16, int i16) {
        if (z16) {
            return B0(str, i3, i16);
        }
        return C0(str);
    }

    private Drawable B0(String str, int i3, int i16) {
        if (i16 == 1) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mPlayGifImage = true;
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mGifRoundCorner = i3;
            obtain.mUseMemoryCache = true;
            return URLDrawable.getFileDrawable(str, obtain);
        }
        if (i16 == 0) {
            if (K) {
                return com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(str).l(VasDynamicDrawableCache.INSTANCE).a();
            }
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
            apngOptions.setUseCache(true);
            apngOptions.setExtraInfo(E0());
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, str);
        }
        return null;
    }

    private URLDrawable C0(String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mUseMemoryCache = true;
        URLDrawable fileDrawable = URLDrawable.getFileDrawable(str, obtain);
        fileDrawable.setDecodeHandler(L);
        return fileDrawable;
    }

    private void D0(AvatarPendantItem avatarPendantItem) {
        if (!TextUtils.isEmpty(avatarPendantItem.jumpUrl)) {
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onAdItem(101, avatarPendantItem.itemId, this.I, avatarPendantItem.strRuleid, "3002002");
            return;
        }
        if (this.H) {
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onSplendidShopItem(101, avatarPendantItem.itemId);
            return;
        }
        int i3 = avatarPendantItem.appid;
        if (i3 == 4) {
            if (PendantAvatarShopLayout.E == this.I) {
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPendantItem(101, avatarPendantItem.itemId, this.I, avatarPendantItem.strRuleid);
            }
        } else if (i3 == 23 && avatarPendantItem.feeType == -1) {
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onQQShowItem(101, avatarPendantItem.itemId);
        } else if (PendantAvatarShopLayout.E == this.I) {
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPersonalItem(101, avatarPendantItem.itemId, this.I, avatarPendantItem.strRuleid);
        }
    }

    private static Bundle E0() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_loop", 3);
        bundle.putBoolean("key_double_bitmap", true);
        bundle.putBoolean("key_get_reset_loop", false);
        bundle.putBoolean("key_stop_on_first", true);
        bundle.putString("key_name", "-face-");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float F0(AvatarPendantItem avatarPendantItem) {
        int i3;
        int i16 = avatarPendantItem.feeType;
        float f16 = 11.0f;
        if (i16 != 1) {
            if (i16 == 4) {
                f16 = 17.3f;
            } else {
                if (i16 != 5) {
                    if (i16 != 6) {
                        if (i16 == 14) {
                            f16 = 18.0f;
                        } else if (i16 != 18) {
                            if (i16 == 22) {
                                f16 = 16.7f;
                            } else if (i16 != 41 && i16 != 42) {
                                if (i16 == 2 && (i3 = avatarPendantItem.discountReason) > 0) {
                                    if (i3 != 6 && avatarPendantItem.discountPrice != 0) {
                                        if (K0(avatarPendantItem)) {
                                            f16 = 14.0f;
                                        }
                                    }
                                }
                                f16 = 17.0f;
                            }
                        }
                    }
                }
                f16 = 19.7f;
            }
        }
        return f16 * 1.25f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap H0(Bitmap bitmap, int i3, int i16) {
        float f16;
        if (bitmap == null) {
            return null;
        }
        float f17 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int width = bitmap.getWidth();
        if (width > 0) {
            float f18 = width;
            float f19 = i3;
            if (f18 < f17 * f19) {
                f17 = f18 / f19;
            }
        }
        int i17 = (i3 + i16) / 2;
        if (i17 < 35) {
            f16 = 2.0f;
        } else if (i17 < 50) {
            f16 = 3.0f;
        } else if (i17 < 64) {
            f16 = 5.0f;
        } else {
            f16 = 6.0f;
        }
        return I0(bitmap, (int) (f16 * f17), false, (int) (i3 * f17), (int) (i16 * f17));
    }

    private static Bitmap I0(Bitmap bitmap, float f16, boolean z16, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > height) {
                i19 = (width - height) / 2;
                i3 = i16;
                i17 = height;
                i18 = 0;
            } else if (height > width) {
                i16 = i3;
                i17 = width;
                i18 = (height - width) / 2;
                height = i17;
                i19 = 0;
            } else {
                i17 = height;
                i18 = 0;
                height = width;
                i19 = 0;
            }
            if (!z16) {
                f16 = i3;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(i19, i18, height + i19, i17 + i18);
            Rect rect2 = new Rect(0, 0, i3, i16);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable J0(AvatarPendantItem avatarPendantItem, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        int i3 = avatarPendantItem.feeType;
        if (i3 == 1) {
            return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/free.png", uRLDrawableOptions);
        }
        if (i3 == 4) {
            return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/vip-free.png", uRLDrawableOptions);
        }
        if (i3 == 5) {
            return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/svip-free.png", uRLDrawableOptions);
        }
        if (i3 == 6) {
            return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/act.png", uRLDrawableOptions);
        }
        if (i3 == 14) {
            return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/xf-svip.png", uRLDrawableOptions);
        }
        if (i3 == 18) {
            return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/game.png", uRLDrawableOptions);
        }
        if (i3 == 22) {
            return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/svip-year.png", uRLDrawableOptions);
        }
        if (i3 != 41 && i3 != 42) {
            if (K0(avatarPendantItem)) {
                return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/3cdb1219-a4b0-4fc5-8f92-0b80be1d93a3.png", uRLDrawableOptions);
            }
            int i16 = avatarPendantItem.feeType;
            if (i16 == 49) {
                return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/svip-free.png", uRLDrawableOptions);
            }
            if (i16 == 2 && avatarPendantItem.discountReason == 6) {
                return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/svip-free.png", uRLDrawableOptions);
            }
            return null;
        }
        return URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/qqgxh/limited.png", uRLDrawableOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K0(AvatarPendantItem avatarPendantItem) {
        if (avatarPendantItem.discountReason == 5 && avatarPendantItem.discountPrice > 0 && avatarPendantItem.feeType == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(b03.a aVar) {
        addAll(aVar.f27624a);
        this.E = aVar.f27625b;
        notifyItemRangeInserted(this.mDataList.size(), aVar.f27624a.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(b03.a aVar) {
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

    public void L0(b03.a aVar, int i3) {
        List<AvatarPendantItem> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, i3);
            return;
        }
        if (aVar != null && (list = aVar.f27624a) != null && list.size() > 0) {
            this.H = false;
            this.I = i3;
            this.F = aVar.f27624a.get(0).appid;
            if (aVar instanceof b03.b) {
                this.G = ((b03.b) aVar).f27627d;
            }
            this.E = aVar.f27625b;
            if (aVar.f27626c) {
                z0(aVar);
            }
            setDatas(aVar.f27624a);
            notifyLoadingComplete(true, aVar.f27626c);
        }
    }

    public void M0(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.C = bVar;
        }
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
        c.h(this.F, this.E, 36, this.G, this.J);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewHolder, i3);
        } else if (viewHolder instanceof VH) {
            ((VH) viewHolder).v((AvatarPendantItem) this.mDataList.get(i3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else if (view.getTag() instanceof AvatarPendantItem) {
            D0((AvatarPendantItem) view.getTag());
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
            return new VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fuz, viewGroup, false), i3);
        }
        return new VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fuy, viewGroup, false), i3);
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
}
