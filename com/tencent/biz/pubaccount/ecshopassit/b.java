package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.subscript.c;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.d;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends BaseAdapter implements c.b, View.OnClickListener {
    DragFrameLayout C;
    SwipListView D;
    EcshopCacheTool E;
    View F;

    /* renamed from: d, reason: collision with root package name */
    List<RecentShopParcel> f79625d;

    /* renamed from: e, reason: collision with root package name */
    LayoutInflater f79626e;

    /* renamed from: f, reason: collision with root package name */
    Context f79627f;

    /* renamed from: h, reason: collision with root package name */
    int f79628h;

    /* renamed from: i, reason: collision with root package name */
    int f79629i;

    /* renamed from: m, reason: collision with root package name */
    c f79630m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79631d;

        a(String str) {
            this.f79631d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b bVar = b.this;
            EcshopCacheTool ecshopCacheTool = bVar.E;
            if (ecshopCacheTool != null) {
                ecshopCacheTool.g(bVar.f79627f, this.f79631d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.ecshopassit.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0809b {

        /* renamed from: a, reason: collision with root package name */
        String f79633a;

        /* renamed from: b, reason: collision with root package name */
        View f79634b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f79635c;

        /* renamed from: d, reason: collision with root package name */
        SingleLineTextView f79636d;

        /* renamed from: e, reason: collision with root package name */
        DragTextView f79637e;

        /* renamed from: f, reason: collision with root package name */
        SingleLineTextView f79638f;

        /* renamed from: g, reason: collision with root package name */
        ImageView[] f79639g;

        /* renamed from: h, reason: collision with root package name */
        Button f79640h;

        C0809b() {
        }
    }

    public b(Context context, SwipListView swipListView, EcshopCacheTool ecshopCacheTool, String str) {
        this.f79627f = context;
        this.f79626e = LayoutInflater.from(context);
        int i3 = this.f79627f.getResources().getDisplayMetrics().widthPixels;
        this.f79628h = (i3 - 8) / 3;
        this.f79629i = (i3 - 8) % 3;
        this.f79630m = new c();
        this.D = swipListView;
        this.E = ecshopCacheTool;
        View inflate = View.inflate(context, R.layout.bbo, null);
        this.F = inflate.findViewById(R.id.bwr);
        inflate.findViewById(R.id.ah6).setOnClickListener(new a(str));
        this.D.addFooterView(inflate);
    }

    @Override // com.tencent.biz.pubaccount.subscript.c.b
    public boolean a(ImageView imageView) {
        if (this.D == null || imageView == null) {
            return false;
        }
        int intValue = ((Integer) imageView.getTag(R.id.h2y)).intValue();
        int firstVisiblePosition = this.D.getFirstVisiblePosition();
        int lastVisiblePosition = this.D.getLastVisiblePosition();
        if (intValue < firstVisiblePosition || intValue > lastVisiblePosition) {
            return false;
        }
        return true;
    }

    public void b(RecentShopParcel recentShopParcel) {
        boolean z16;
        String str;
        if (recentShopParcel != null && !TextUtils.isEmpty(recentShopParcel.f79609d)) {
            if (recentShopParcel.D == 1) {
                String str2 = ((EcshopWebActivity) this.f79627f).f79600d0;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                Intent intent = new Intent(this.f79627f, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str2);
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                this.f79627f.startActivity(intent);
                try {
                    this.E.f79584f.H2(134246437, null, null, null, null, ((EcshopWebActivity) this.f79627f).f79601e0, false);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            int i3 = recentShopParcel.C;
            String str3 = recentShopParcel.f79609d;
            Intent intent2 = new Intent(this.f79627f, (Class<?>) ChatActivity.class);
            intent2.putExtra("uintype", 1008);
            intent2.putExtra("uin", str3);
            intent2.putExtra("uinname", recentShopParcel.f79610e);
            intent2.putExtra("start_time", System.currentTimeMillis());
            intent2.putExtra("red_hot_count", i3);
            intent2.putExtra("jump_from", 1);
            int i16 = 0;
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            intent2.putExtra("has_unread_msg", z16);
            recentShopParcel.C = 0;
            if (this.E.f79582d.get(str3) != null) {
                i16 = this.E.f79582d.get(str3).intValue();
            }
            if (i16 > 0) {
                if (i16 / 1000 > 0) {
                    str = this.f79627f.getResources().getString(R.string.cfz) + new BigDecimal(i16 / 1000.0f).setScale(1, 4).floatValue() + "km";
                } else {
                    str = this.f79627f.getString(R.string.cfz) + i16 + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO;
                }
                intent2.putExtra("pub_account_type", "type_ecshop_account");
                intent2.putExtra("ecshop_distance_tip", str);
            }
            this.f79627f.startActivity(intent2);
            ReportController.o(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helper", "Clk_shopItem", 0, 0, str3, "", recentShopParcel.f79610e, "");
        }
    }

    public void c(String str) {
        C0809b c0809b;
        Bitmap b16;
        if (this.D != null && !TextUtils.isEmpty(str) && this.E != null) {
            int lastVisiblePosition = this.D.getLastVisiblePosition();
            for (int firstVisiblePosition = this.D.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                View childAt = this.D.getChildAt(firstVisiblePosition);
                if (childAt != null && (c0809b = (C0809b) childAt.getTag()) != null && str.equals(c0809b.f79633a) && (b16 = this.E.b(str)) != null) {
                    c0809b.f79635c.setImageBitmap(b16);
                }
            }
        }
    }

    public void d(DragFrameLayout dragFrameLayout) {
        this.C = dragFrameLayout;
    }

    public void destroy() {
        this.f79630m.a();
        this.D = null;
        List<RecentShopParcel> list = this.f79625d;
        if (list != null) {
            list.clear();
            this.f79625d = null;
        }
        this.E = null;
    }

    public void e(List<RecentShopParcel> list) {
        if (list != null && !list.isEmpty()) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
        }
        this.f79625d = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<RecentShopParcel> list = this.f79625d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<RecentShopParcel> list = this.f79625d;
        if (list == null) {
            return null;
        }
        return list.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        C0809b c0809b;
        byte b16;
        String str;
        String str2;
        int i16;
        int i17;
        C0809b c0809b2;
        String str3;
        C0809b c0809b3;
        int i18;
        int i19;
        Map<String, Integer> map;
        Integer num;
        EcshopCacheTool ecshopCacheTool;
        int i26 = 3;
        int i27 = 2;
        View view3 = null;
        Bitmap bitmap = null;
        if (view == null) {
            C0809b c0809b4 = new C0809b();
            View inflate = this.f79626e.inflate(R.layout.bbr, (ViewGroup) null);
            c0809b4.f79635c = (ImageView) inflate.findViewById(R.id.icon);
            c0809b4.f79639g = new ImageView[]{(ImageView) inflate.findViewById(R.id.df_), (ImageView) inflate.findViewById(R.id.dfa), (ImageView) inflate.findViewById(R.id.dfb)};
            c0809b4.f79636d = (SingleLineTextView) inflate.findViewById(R.id.f5e);
            c0809b4.f79638f = (SingleLineTextView) inflate.findViewById(R.id.f166327f13);
            DragTextView dragTextView = (DragTextView) inflate.findViewById(R.id.kik);
            c0809b4.f79637e = dragTextView;
            dragTextView.setDragViewType(0, inflate);
            c0809b4.f79637e.setOnModeChangeListener(this.C);
            c0809b4.f79640h = (Button) inflate.findViewById(R.id.f166236eq0);
            c0809b4.f79634b = inflate.findViewById(R.id.brc);
            c0809b4.f79638f.setExtendTextColor(this.f79627f.getResources().getColorStateList(R.color.skin_gray_group_item), 0);
            c0809b4.f79638f.setExtendTextSize(12.0f, 0);
            c0809b4.f79638f.setExtendTextPadding((int) (ah.q() * 5.0f), 2);
            inflate.setTag(c0809b4);
            EcshopCacheTool ecshopCacheTool2 = this.E;
            if (ecshopCacheTool2 != null && ecshopCacheTool2.f79585g) {
                inflate.findViewById(R.id.bmt).setVisibility(0);
                ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{RichStatus.ACTION_COLOR_NORMAL});
                inflate.findViewById(R.id.brc).setBackgroundResource(R.drawable.anw);
                c0809b4.f79638f.setExtendTextColor(colorStateList, 0);
                c0809b4.f79636d.setTextColor(Color.parseColor("#FF777777"));
                c0809b4.f79638f.setTextColor(Color.parseColor("#FF000000"));
            }
            c0809b = c0809b4;
            view2 = inflate;
        } else {
            view2 = view;
            c0809b = (C0809b) view.getTag();
        }
        RecentShopParcel recentShopParcel = (RecentShopParcel) getItem(i3);
        if (recentShopParcel != null) {
            if (recentShopParcel.G > recentShopParcel.F) {
                b16 = true;
            } else {
                b16 = false;
            }
            c0809b.f79633a = recentShopParcel.f79609d;
            if (recentShopParcel.f79614m != 0) {
                Drawable drawable = this.f79627f.getResources().getDrawable(recentShopParcel.f79614m);
                c0809b.f79636d.setCompoundDrawablePadding(BaseAIOUtils.f(6.0f, this.f79627f.getResources()));
                drawable.setBounds(0, 0, BaseAIOUtils.f(15.0f, this.f79627f.getResources()), BaseAIOUtils.f(15.0f, this.f79627f.getResources()));
                c0809b.f79636d.setCompoundDrawables(null, drawable);
            } else {
                c0809b.f79636d.setCompoundDrawables(null, null);
            }
            EcshopCacheTool ecshopCacheTool3 = this.E;
            if (ecshopCacheTool3 == null) {
                str = "";
            } else {
                str = ecshopCacheTool3.f79583e.get(recentShopParcel.f79609d);
            }
            if (!TextUtils.isEmpty(str) && (ecshopCacheTool = this.E) != null && ecshopCacheTool.f(str)) {
                str2 = recentShopParcel.f79610e + "(" + this.E.c(str) + ")";
            } else {
                str2 = recentShopParcel.f79610e;
            }
            c0809b.f79636d.setText(str2);
            c0809b.f79636d.setExtendText("", 1);
            if (!TextUtils.isEmpty(recentShopParcel.f79611f)) {
                c0809b.f79638f.setExtendText(recentShopParcel.f79611f, 0);
            } else {
                c0809b.f79638f.setExtendText("", 0);
            }
            c0809b.f79638f.setExtendText(" ", 2);
            int i28 = recentShopParcel.C;
            if (i28 > 0) {
                i16 = 3;
            } else {
                i16 = 0;
            }
            d.c(c0809b.f79637e, i16, i28, R.drawable.skin_tips_newmessage, 99, null);
            DragTextView dragTextView2 = c0809b.f79637e;
            int i29 = R.id.h2x;
            dragTextView2.setTag(R.id.h2x, recentShopParcel);
            EcshopCacheTool ecshopCacheTool4 = this.E;
            if (ecshopCacheTool4 != null) {
                bitmap = ecshopCacheTool4.b(recentShopParcel.f79609d);
            }
            if (bitmap != null) {
                c0809b.f79635c.setImageBitmap(bitmap);
            } else {
                EcshopCacheTool ecshopCacheTool5 = this.E;
                if (ecshopCacheTool5 != null) {
                    ecshopCacheTool5.h(this.f79627f, recentShopParcel.f79609d);
                }
            }
            c0809b.f79635c.setOnClickListener(this);
            c0809b.f79635c.setTag(-1, Integer.valueOf(i3));
            c0809b.f79635c.setTag(R.id.h2x, recentShopParcel);
            EcshopCacheTool ecshopCacheTool6 = this.E;
            if (ecshopCacheTool6 != null && (map = ecshopCacheTool6.f79582d) != null && (num = map.get(recentShopParcel.f79609d)) != null) {
                i17 = num.intValue();
            } else {
                i17 = 0;
            }
            if (i17 > 0) {
                if (i17 / 1000 > 0) {
                    c0809b2 = c0809b;
                    str3 = "[" + this.f79627f.getResources().getString(R.string.cfz) + new BigDecimal(i17 / 1000.0f).setScale(1, 4).floatValue() + "km]";
                } else {
                    c0809b2 = c0809b;
                    str3 = "[" + this.f79627f.getResources().getString(R.string.cfz) + i17 + "m]";
                }
            } else {
                c0809b2 = c0809b;
                str3 = "";
            }
            QQText qQText = new QQText(String.valueOf(recentShopParcel.f79612h).replaceFirst("^\\s+", ""), 3, 20);
            if (!TextUtils.isEmpty(str3)) {
                SpannableString spannableString = new SpannableString(str3);
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 132, 68)), 0, str3.length(), 33);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) qQText);
                c0809b3 = c0809b2;
                c0809b3.f79638f.setText(spannableStringBuilder);
            } else {
                c0809b3 = c0809b2;
                c0809b3.f79638f.setText(qQText);
            }
            if (b16 != false) {
                c0809b3.f79638f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.conversation_unsend_icon, 0);
            } else {
                c0809b3.f79638f.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            }
            c0809b3.f79640h.setTag(R.id.h2x, recentShopParcel);
            c0809b3.f79640h.setOnClickListener(this);
            float f16 = BaseAIOUtils.f(65.0f, this.f79627f.getResources());
            if (!TextUtils.isEmpty(recentShopParcel.f79613i) && b16 == false) {
                ArrayList arrayList = new ArrayList(Arrays.asList(recentShopParcel.f79613i.split(",")));
                int i36 = 0;
                while (i36 < i26) {
                    c0809b3.f79639g[i36].setTag(R.id.h2y, Integer.valueOf(i3));
                    ViewGroup.LayoutParams layoutParams = c0809b3.f79639g[i36].getLayoutParams();
                    int i37 = this.f79628h;
                    layoutParams.width = i37;
                    layoutParams.height = i37;
                    if (i36 == i27) {
                        layoutParams.width = i37 + this.f79629i;
                    }
                    c0809b3.f79639g[i36].setLayoutParams(layoutParams);
                    this.f79630m.b(((IPublicAccountHttpDownloader) QRoute.api(IPublicAccountHttpDownloader.class)).makeURL((String) arrayList.get(i36), 1), c0809b3.f79639g[i36], layoutParams.width, layoutParams.height, this);
                    i36++;
                    i29 = R.id.h2x;
                    arrayList = arrayList;
                    i26 = 3;
                    i27 = 2;
                }
                i18 = i29;
                i19 = 8;
                view2.findViewById(R.id.di8).setVisibility(0);
            } else {
                i18 = R.id.h2x;
                i19 = 8;
                view2.findViewById(R.id.di8).setVisibility(8);
            }
            c0809b3.f79634b.setTag(i18, recentShopParcel);
            c0809b3.f79634b.setOnClickListener(this);
            view2.setTag(-3, Integer.valueOf((int) f16));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0809b3.f79636d.getLayoutParams();
            if (recentShopParcel.D == 1) {
                c0809b3.f79638f.setExtendText("", 0);
                c0809b3.f79635c.setOnClickListener(this);
                ImageButton imageButton = (ImageButton) view2.findViewById(R.id.agb);
                imageButton.setVisibility(0);
                imageButton.setTag(i18, recentShopParcel);
                imageButton.setOnClickListener(this);
                String str4 = ((EcshopWebActivity) this.f79627f).f79599c0;
                if (!TextUtils.isEmpty(str4)) {
                    URLImageView uRLImageView = (URLImageView) view2.findViewById(R.id.f163981fi);
                    Drawable drawable2 = this.f79627f.getResources().getDrawable(R.drawable.cj9);
                    try {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mFailedDrawable = drawable2;
                        obtain.mLoadingDrawable = drawable2;
                        URLDrawable drawable3 = URLDrawable.getDrawable(str4, obtain);
                        if (drawable3 != null) {
                            if (drawable3.getStatus() == 2) {
                                drawable3.restartDownload();
                            }
                            uRLImageView.setImageDrawable(drawable3);
                            uRLImageView.setVisibility(0);
                        }
                    } catch (Exception unused) {
                    }
                }
                layoutParams2.rightMargin = BaseAIOUtils.f(6.0f, this.f79627f.getResources());
            } else {
                view2.findViewById(R.id.agb).setVisibility(i19);
                view2.findViewById(R.id.f163981fi).setVisibility(i19);
                layoutParams2.rightMargin = BaseAIOUtils.f(45.0f, this.f79627f.getResources());
            }
            c0809b3.f79636d.setLayoutParams(layoutParams2);
            view2.setOnClickListener(this);
            view2.setTag(-1, Integer.valueOf(i3));
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        RecentShopParcel recentShopParcel = (RecentShopParcel) view.getTag(R.id.h2x);
        if (id5 == R.id.brc) {
            b(recentShopParcel);
        } else if (id5 != R.id.f166236eq0 && id5 != R.id.agb) {
            if (id5 == R.id.icon) {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f79627f, IPublicAccountDetailActivity.ROUTE_NAME);
                activityURIRequest.extra().putString("uin", recentShopParcel.f79609d);
                activityURIRequest.extra().putString(IPublicAccountDetailActivity.REPORT_SRC_PARAM_TYPE, "");
                activityURIRequest.extra().putString(IPublicAccountDetailActivity.REPORT_SRC_PARAM_NAME, "");
                activityURIRequest.setFlags(67108864);
                QRoute.startUri(activityURIRequest, (o) null);
                ReportController.o(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helperhead", "Clk_shopItemhead", 0, 0, recentShopParcel.f79609d, "", recentShopParcel.f79610e, "");
            }
        } else {
            int i3 = recentShopParcel.C;
            this.f79625d.remove(recentShopParcel);
            notifyDataSetChanged();
            if (this.f79625d.isEmpty()) {
                this.F.setVisibility(0);
            }
            Intent intent = new Intent("action_shop_set_read");
            intent.putExtra("uin", recentShopParcel.f79609d);
            intent.putExtra("needDelete", true);
            intent.putExtra("unReadNum", i3);
            this.f79627f.sendBroadcast(intent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
