package com.tencent.mobileqq.profile.stickynote.vas;

import QC.UniBusiGetOneItemWithCheckReq;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleFontItem;
import QC.UniBusiSimpleItemDetail;
import QC.UniBusiSimpleSigItem;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.SignatureTemplateDownloader;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRelativeLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends RecyclerView.Adapter<h> {
    private Context C;
    private UniBusiSimpleItemDetail D;
    private StickyNoteShopLayout F;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<UniBusiSimpleItemDetail> f260295d;

    /* renamed from: e, reason: collision with root package name */
    private StickyNoteShopLayout.b f260296e;

    /* renamed from: f, reason: collision with root package name */
    private int f260297f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f260298h;

    /* renamed from: i, reason: collision with root package name */
    private int f260299i = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f260300m = -1;
    private boolean E = false;
    private int G = 0;
    private final int H = 0;
    private final int I = 1;
    public g J = new b();
    private URLDrawable.URLDrawableListener K = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.profile.stickynote.vas.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class ViewOnClickListenerC8245a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ UniBusiSimpleItemDetail f260301d;

        ViewOnClickListenerC8245a(UniBusiSimpleItemDetail uniBusiSimpleItemDetail) {
            this.f260301d = uniBusiSimpleItemDetail;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.f260299i = this.f260301d.itemId;
            int i3 = a.this.F.f260286m;
            StickyNoteShopLayout unused = a.this.F;
            if (i3 == 2) {
                if (9 == a.this.f260297f) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_click", "", 0, "", str2);
            } else {
                if (9 == a.this.f260297f) {
                    str = "1";
                } else {
                    str = "2";
                }
                VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", str);
            }
            a.this.notifyDataSetChanged();
            a.this.D = this.f260301d;
            a.this.E = true;
            a aVar = a.this;
            int i16 = aVar.f260297f;
            UniBusiSimpleItemDetail uniBusiSimpleItemDetail = this.f260301d;
            aVar.I(i16, uniBusiSimpleItemDetail.itemId, uniBusiSimpleItemDetail.feeType, a.this.J);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements g {
        b() {
        }

        @Override // com.tencent.mobileqq.profile.stickynote.vas.a.g
        public void a(boolean z16, UniBusiGetOneItemWithCheckRsp uniBusiGetOneItemWithCheckRsp) {
            UniBusiSimpleItemDetail uniBusiSimpleItemDetail;
            if (a.this.D == null) {
                return;
            }
            if (!z16) {
                if (uniBusiGetOneItemWithCheckRsp == null || (uniBusiSimpleItemDetail = uniBusiGetOneItemWithCheckRsp.stDetail) == null) {
                    a.this.E = false;
                    QQToast.makeText(a.this.C, HardCodeUtil.qqStr(R.string.u_b), 0).show();
                    a.this.D = null;
                    a.this.f260299i = -1;
                    return;
                }
                if (uniBusiSimpleItemDetail.itemId == a.this.D.itemId) {
                    if (uniBusiGetOneItemWithCheckRsp.ret == 0) {
                        a.this.E = false;
                        a.this.E();
                        return;
                    } else {
                        if (a.this.E) {
                            a aVar = a.this;
                            aVar.P(aVar.C, a.this.D.stAidInfo.androidAid, a.this.D.stAidInfo.payType, a.this.D.stAidInfo.errMsg, a.this.D.stAidInfo.month);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            a.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f260304d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f260305e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f260306f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f260307h;

        c(Context context, String str, String str2, String str3) {
            this.f260304d = context;
            this.f260305e = str;
            this.f260306f = str2;
            this.f260307h = str3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            if (a.this.F.f260286m == 1) {
                str = "&g_ch=suixintie&actId=460973&isAskFriendPay=0";
            } else if (a.this.F.f260286m == 2) {
                str = "&g_ch=\u6269\u5217\u88c5\u626e&actId=466499&isAskFriendPay=0";
            } else {
                str = "";
            }
            VasH5PayUtil.openH5PayForResult((Activity) this.f260304d, this.f260305e + str, this.f260306f, this.f260307h, 0);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.E = false;
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f260310d;

        e(g gVar) {
            this.f260310d = gVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            g gVar = this.f260310d;
            if (gVar != null) {
                boolean z17 = false;
                if (obj instanceof UniBusiGetOneItemWithCheckRsp) {
                    UniBusiGetOneItemWithCheckRsp uniBusiGetOneItemWithCheckRsp = (UniBusiGetOneItemWithCheckRsp) obj;
                    if (uniBusiGetOneItemWithCheckRsp.ret == 0) {
                        z17 = true;
                    }
                    gVar.a(z17, uniBusiGetOneItemWithCheckRsp);
                    return;
                }
                gVar.a(false, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface g {
        void a(boolean z16, UniBusiGetOneItemWithCheckRsp uniBusiGetOneItemWithCheckRsp);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class h extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        public TextView f260313d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f260314e;

        /* renamed from: f, reason: collision with root package name */
        public RoundRelativeLayout f260315f;

        /* renamed from: h, reason: collision with root package name */
        public LinearLayout f260316h;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f260317i;

        public h(View view) {
            super(view);
            this.f260313d = (TextView) view.findViewById(R.id.tv_name);
            this.f260314e = (ImageView) view.findViewById(R.id.dex);
            this.f260315f = (RoundRelativeLayout) view.findViewById(R.id.f164600a83);
            this.f260316h = (LinearLayout) view.findViewById(R.id.gg7);
            this.f260317i = (ImageView) view.findViewById(R.id.xky);
        }
    }

    public a(Context context, ArrayList<UniBusiSimpleItemDetail> arrayList) {
        this.C = context;
        this.f260295d = arrayList;
        this.f260298h = context.getResources().getDrawable(R.drawable.f162110ao3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.image.URLDrawable] */
    private Drawable A(String str, String str2) {
        URL url;
        ?? r06 = this.f260298h;
        if (!TextUtils.isEmpty(str2)) {
            try {
                url = new URL(SignatureTemplateDownloader.PROTOCAL_SIGNATURE_COVER, str2, str);
            } catch (MalformedURLException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickyNoteVasAdapter", 2, e16.getMessage());
                }
                url = null;
            }
            if (url != null) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = this.f260298h;
                obtain.mFailedDrawable = drawable;
                obtain.mLoadingDrawable = drawable;
                obtain.mPlayGifImage = true;
                r06 = URLDrawable.getDrawable(url, obtain);
                r06.addHeader("my_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
                if (r06.getStatus() == 2) {
                    r06.restartDownload();
                }
                r06.setURLDrawableListener(this.K);
            }
        }
        return r06;
    }

    public static boolean D(int i3) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                return false;
            }
            return VasUtil.getSignedService(qQAppInterface).getVipStatus().isSVip();
        }
        return VasUtil.getSignedService(qQAppInterface).getVipStatus().isVip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Context context, String str, String str2, String str3, String str4) {
        String qqStr = HardCodeUtil.qqStr(R.string.mmr);
        String qqStr2 = HardCodeUtil.qqStr(R.string.i0f);
        if (!TextUtils.isEmpty(str2) && str2.contains("svip")) {
            qqStr2 = HardCodeUtil.qqStr(R.string.i0d);
        }
        DialogUtil.createCustomDialog(context, 230, qqStr, str3, HardCodeUtil.qqStr(R.string.j6l), qqStr2, new c(context, str, str2, str4), new d()).show();
    }

    public int B(int i3) {
        if (i3 != 0 && i3 != 1) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 21) {
                        if (i3 != 22) {
                            return R.drawable.d5o;
                        }
                        return R.drawable.d7q;
                    }
                    return R.drawable.f162144d91;
                }
                return R.drawable.f162145d92;
            }
            return R.drawable.d9f;
        }
        return R.drawable.d5n;
    }

    public int C() {
        ArrayList<UniBusiSimpleItemDetail> arrayList = this.f260295d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void E() {
        int i3;
        int i16;
        notifyDataSetChanged();
        StickyNoteShopLayout.b bVar = this.f260296e;
        if (bVar != null) {
            int i17 = this.f260297f;
            if (i17 == 5) {
                UniBusiSimpleItemDetail uniBusiSimpleItemDetail = this.D;
                UniBusiSimpleFontItem uniBusiSimpleFontItem = uniBusiSimpleItemDetail.stFontItem;
                if (uniBusiSimpleFontItem != null) {
                    i16 = uniBusiSimpleFontItem.fontType;
                } else {
                    i16 = 0;
                }
                bVar.oe(uniBusiSimpleItemDetail.itemId, i16);
                return;
            }
            if (i17 == 9) {
                UniBusiSimpleSigItem uniBusiSimpleSigItem = this.D.stSigItem;
                if (uniBusiSimpleSigItem != null && !TextUtils.isEmpty(uniBusiSimpleSigItem.fontColor)) {
                    i3 = Color.parseColor(this.D.stSigItem.fontColor);
                } else {
                    i3 = 16777215;
                }
                this.f260296e.i6(this.D.itemId, i3);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(h hVar, int i3) {
        boolean z16;
        boolean z17;
        ArrayList<UniBusiSimpleItemDetail> arrayList = this.f260295d;
        if (arrayList != null && arrayList.get(i3) != null) {
            UniBusiSimpleItemDetail uniBusiSimpleItemDetail = this.f260295d.get(i3);
            hVar.f260313d.setText(uniBusiSimpleItemDetail.name);
            int i16 = this.f260299i;
            int i17 = uniBusiSimpleItemDetail.itemId;
            if (i16 == i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.f260300m == i17) {
                z17 = true;
            } else {
                z17 = false;
            }
            hVar.f260317i.setVisibility(8);
            if (z17 && this.F.f260286m == 2) {
                hVar.f260317i.setVisibility(0);
            }
            QLog.d("StickyNoteVasAdapter", 1, " mAppId:" + this.f260297f);
            if (this.f260297f == 9) {
                RoundRelativeLayout roundRelativeLayout = hVar.f260315f;
                roundRelativeLayout.setBackgroundDrawable(z(roundRelativeLayout.getContext(), uniBusiSimpleItemDetail.itemBgColor, z16));
                int realWidth = (ScreenUtil.getRealWidth(hVar.itemView.getContext()) - ScreenUtil.dip2px(96.0f)) / 3;
                ViewGroup.LayoutParams layoutParams = hVar.f260314e.getLayoutParams();
                layoutParams.width = realWidth;
                layoutParams.height = (int) (realWidth * 0.57f);
                hVar.f260314e.setLayoutParams(layoutParams);
                hVar.f260314e.setImageDrawable(A(String.valueOf(uniBusiSimpleItemDetail.itemId), uniBusiSimpleItemDetail.image));
            } else {
                RoundRelativeLayout roundRelativeLayout2 = hVar.f260315f;
                roundRelativeLayout2.setBackgroundDrawable(y(roundRelativeLayout2.getContext(), A(String.valueOf(uniBusiSimpleItemDetail.itemId), uniBusiSimpleItemDetail.image), z16));
            }
            K(hVar.f260313d, uniBusiSimpleItemDetail.feeType);
            hVar.f260315f.setOnClickListener(new ViewOnClickListenerC8245a(uniBusiSimpleItemDetail));
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(hVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public h onCreateViewHolder(ViewGroup viewGroup, int i3) {
        h hVar = new h(View.inflate(viewGroup.getContext(), R.layout.bjo, null));
        if (i3 == 1) {
            hVar.f260316h.setVisibility(0);
        } else {
            hVar.f260316h.setVisibility(8);
        }
        return hVar;
    }

    public void H() {
        UniBusiSimpleItemDetail uniBusiSimpleItemDetail = this.D;
        if (uniBusiSimpleItemDetail != null && this.E) {
            this.E = false;
            I(this.f260297f, uniBusiSimpleItemDetail.itemId, uniBusiSimpleItemDetail.feeType, this.J);
        }
    }

    public void I(int i3, int i16, int i17, g gVar) {
        if (D(i17) && gVar != null) {
            gVar.a(true, null);
        } else {
            VasUtil.getService().getJceRequset().build("QC.UniBusinessUserInfoServer.UniBusinessUserInfoObj", "QcUniBusinessUserInfo.UniBusiGetOneItemWithCheck", "stReq", "stRsp").request("UniBusiGetOneItemWithCheck", new UniBusiGetOneItemWithCheckReq(IJce.Util.getLoginInfo(), i3, i16), new UniBusiGetOneItemWithCheckRsp(), new e(gVar), false);
        }
    }

    public void J(int i3) {
        this.G = i3;
        this.f260300m = i3;
        StickyNoteShopLayout stickyNoteShopLayout = this.F;
        if (stickyNoteShopLayout != null) {
            stickyNoteShopLayout.m(false);
        }
    }

    public void K(TextView textView, int i3) {
        textView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0f));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, B(i3), 0);
    }

    public void L(int i3) {
        this.f260297f = i3;
    }

    public void M(int i3) {
        this.f260299i = -1;
        if (this.f260295d == null) {
            return;
        }
        for (int i16 = 0; i16 < this.f260295d.size(); i16++) {
            if (this.f260295d.get(i16).itemId == i3) {
                this.f260299i = i3;
                this.D = this.f260295d.get(i16);
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void N(StickyNoteShopLayout.b bVar) {
        this.f260296e = bVar;
    }

    public void O(StickyNoteShopLayout stickyNoteShopLayout) {
        this.F = stickyNoteShopLayout;
    }

    public void Q(ArrayList<UniBusiSimpleItemDetail> arrayList, boolean z16) {
        ArrayList<UniBusiSimpleItemDetail> arrayList2;
        if (z16 && (arrayList2 = this.f260295d) != null) {
            arrayList2.addAll(arrayList);
        } else {
            this.f260295d = arrayList;
        }
        notifyDataSetChanged();
        if (this.G != 0) {
            if (this.f260295d != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f260295d.size()) {
                        break;
                    }
                    if (this.f260295d.get(i3).itemId == this.G) {
                        this.D = this.f260295d.get(i3);
                        break;
                    }
                    i3++;
                }
            }
            UniBusiSimpleItemDetail uniBusiSimpleItemDetail = this.D;
            if (uniBusiSimpleItemDetail != null) {
                this.E = true;
                I(this.f260297f, uniBusiSimpleItemDetail.itemId, -1, this.J);
            }
            this.G = 0;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size;
        ArrayList<UniBusiSimpleItemDetail> arrayList = this.f260295d;
        if (arrayList == null) {
            size = 0;
        } else {
            size = arrayList.size();
        }
        if (this.F.f260286m == 2) {
            return Math.min(size, 30);
        }
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == getItemCount() - 1) {
            return 1;
        }
        return 0;
    }

    public Drawable y(Context context, Drawable drawable, boolean z16) {
        if (!z16) {
            return drawable;
        }
        return new LayerDrawable(new Drawable[]{drawable, context.getResources().getDrawable(R.drawable.dhh)});
    }

    public Drawable z(Context context, String str, boolean z16) {
        int i3;
        if (!TextUtils.isEmpty(str)) {
            if (!str.contains("#")) {
                str = "#" + str;
            }
            i3 = Color.parseColor(str);
        } else {
            i3 = 14606046;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i3 - (-1291845632), i3 - Integer.MIN_VALUE});
        if (!z16) {
            return gradientDrawable;
        }
        return new LayerDrawable(new Drawable[]{gradientDrawable, context.getResources().getDrawable(R.drawable.dhh)});
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class f implements URLDrawable.URLDrawableListener {
        f() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            a.this.notifyDataSetChanged();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
