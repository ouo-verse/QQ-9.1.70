package com.tencent.guild.aio.input.at.hashtag.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildHashtagListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    /* renamed from: d, reason: collision with root package name */
    private b f110883d;

    /* renamed from: e, reason: collision with root package name */
    private List<IGProCategoryChannelInfoList> f110884e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List<c> f110885f;

    /* renamed from: h, reason: collision with root package name */
    private h f110886h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f110887i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f110888a;

        static {
            int[] iArr = new int[HashTagViewType.values().length];
            f110888a = iArr;
            try {
                iArr[HashTagViewType.VIEW_TYPE_CHANNEL_ITEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f110888a[HashTagViewType.VIEW_TYPE_FEED_SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f110888a[HashTagViewType.VIEW_TYPE_GROUP_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f110888a[HashTagViewType.VIEW_TYPE_FEED_SECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f110888a[HashTagViewType.VIEW_TYPE_FEED_DIVIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
        void a(String str, String str2, HashTagViewType hashTagViewType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        HashTagViewType f110889a;

        /* renamed from: b, reason: collision with root package name */
        CharSequence f110890b;

        /* renamed from: c, reason: collision with root package name */
        String f110891c;

        /* renamed from: d, reason: collision with root package name */
        String f110892d;

        /* renamed from: e, reason: collision with root package name */
        int f110893e;

        /* renamed from: f, reason: collision with root package name */
        int f110894f;

        c(HashTagViewType hashTagViewType, CharSequence charSequence, IGProChannel iGProChannel) {
            this.f110889a = hashTagViewType;
            this.f110890b = charSequence;
            if (iGProChannel != null) {
                this.f110891c = String.valueOf(iGProChannel.getChannelId());
                this.f110892d = iGProChannel.getChannelName();
                this.f110893e = iGProChannel.getChannelType();
                this.f110894f = iGProChannel.getTextChannelInfo().getSubTypeId();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        LinearLayout f110895a;

        /* renamed from: b, reason: collision with root package name */
        TextView f110896b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f110897c;

        /* renamed from: d, reason: collision with root package name */
        View f110898d;

        /* renamed from: e, reason: collision with root package name */
        View f110899e;

        /* renamed from: f, reason: collision with root package name */
        HashTagViewType f110900f;

        d() {
        }
    }

    private void a(IGProCategoryChannelInfoList iGProCategoryChannelInfoList, List<c> list, IGProChannel iGProChannel) {
        boolean z16;
        String name;
        if (TextUtils.isEmpty(iGProCategoryChannelInfoList.getName())) {
            return;
        }
        if (iGProCategoryChannelInfoList.getCategoryType() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            list.add(new c(HashTagViewType.VIEW_TYPE_GROUP_NAME, "\u7248\u5757", null));
        }
        if (z16) {
            name = "\u70ed\u95e8";
        } else {
            name = iGProCategoryChannelInfoList.getName();
        }
        if (!z16) {
            iGProChannel = null;
        }
        list.add(new c(l(iGProCategoryChannelInfoList, true), name, iGProChannel));
    }

    private void b(List<IGProChannel> list, List<c> list2, HashTagViewType hashTagViewType) {
        if (list != null && !list.isEmpty()) {
            for (IGProChannel iGProChannel : list) {
                list2.add(new c(hashTagViewType, iGProChannel.getChannelName(), iGProChannel));
            }
        }
    }

    private static void c(d dVar, h hVar, int i3, int i16) {
        dVar.f110899e.setVisibility(8);
        dVar.f110895a.setVisibility(0);
        ViewGroup.LayoutParams k3 = k(dVar.f110895a.getLayoutParams());
        k3.width = -1;
        k3.height = hVar.f110931a.f110940b;
        dVar.f110895a.setLayoutParams(k3);
        dVar.f110895a.setBackgroundResource(hVar.f110933c.f110952b);
        dVar.f110898d.setVisibility(i3);
        dVar.f110896b.setTextSize(hVar.f110931a.f110949k);
        dVar.f110896b.setTextColor(hVar.f110932b.f110935a);
        dVar.f110896b.setTypeface(null, i16);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.f110896b.getLayoutParams();
        layoutParams.leftMargin = hVar.f110931a.f110947i;
        dVar.f110896b.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dVar.f110898d.getLayoutParams();
        layoutParams2.leftMargin = hVar.f110931a.f110946h;
        dVar.f110898d.setLayoutParams(layoutParams2);
    }

    private static void d(d dVar, h hVar) {
        dVar.f110899e.setVisibility(0);
        dVar.f110895a.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, hVar.f110931a.f110941c);
        int i3 = hVar.f110931a.f110946h;
        layoutParams.setMargins(i3, 0, i3, i3);
        dVar.f110899e.setLayoutParams(layoutParams);
        dVar.f110899e.setBackgroundResource(R.drawable.qui_common_border_light_bg);
    }

    private static void e(d dVar, h hVar) {
        dVar.f110899e.setVisibility(8);
        dVar.f110895a.setVisibility(0);
        ViewGroup.LayoutParams k3 = k(dVar.f110895a.getLayoutParams());
        k3.width = -1;
        k3.height = hVar.f110931a.f110939a;
        dVar.f110895a.setLayoutParams(k3);
        dVar.f110898d.setVisibility(8);
        dVar.f110896b.setTextSize(hVar.f110931a.f110948j);
        dVar.f110896b.setTextColor(hVar.f110932b.f110937c);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.f110896b.getLayoutParams();
        layoutParams.leftMargin = hVar.f110931a.f110946h;
        dVar.f110896b.setLayoutParams(layoutParams);
    }

    private static void f(d dVar, h hVar) {
        dVar.f110895a.setVisibility(0);
        dVar.f110896b.setSingleLine();
        dVar.f110896b.setEllipsize(TextUtils.TruncateAt.END);
        int i3 = a.f110888a[dVar.f110900f.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 5) {
                        d(dVar, hVar);
                        return;
                    }
                    return;
                }
                c(dVar, hVar, 0, 0);
                return;
            }
            e(dVar, hVar);
            return;
        }
        c(dVar, hVar, 0, 0);
    }

    private void g(View view, d dVar) {
        dVar.f110895a = (LinearLayout) view.findViewById(10000);
        dVar.f110897c = (ImageView) view.findViewById(10001);
        dVar.f110898d = view.findViewById(10003);
        dVar.f110896b = (TextView) view.findViewById(10002);
        dVar.f110899e = view.findViewById(10004);
        view.setTag(dVar);
    }

    private void h(List<IGProCategoryChannelInfoList> list, List<c> list2, IGProChannel iGProChannel) {
        if (list2 != null && list != null) {
            list2.clear();
            for (IGProCategoryChannelInfoList iGProCategoryChannelInfoList : list) {
                if (iGProCategoryChannelInfoList.getCategoryType() != 0 || !TextUtils.isEmpty(iGProCategoryChannelInfoList.getName())) {
                    ArrayList<IGProChannel> channelInfoList = iGProCategoryChannelInfoList.getChannelInfoList();
                    a(iGProCategoryChannelInfoList, list2, iGProChannel);
                    b(channelInfoList, list2, l(iGProCategoryChannelInfoList, false));
                    if (iGProCategoryChannelInfoList.getCategoryType() == 1 && list.size() != 1) {
                        list2.add(new c(HashTagViewType.VIEW_TYPE_FEED_DIVIDE, "", null));
                    }
                }
            }
        }
    }

    private void i(View view, ViewGroup viewGroup) {
        Object obj;
        int width = view.getWidth();
        int width2 = viewGroup.getWidth();
        if (width2 > 0 && width != width2) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("itemWidth = ");
                sb5.append(width);
                sb5.append(", parentWidth = ");
                sb5.append(width2);
                sb5.append(" item's layout_width = ");
                if (layoutParams != null) {
                    obj = Integer.valueOf(layoutParams.width);
                } else {
                    obj = "null";
                }
                sb5.append(obj);
                QLog.e("GuildHashtagListAdapter", 2, sb5.toString());
            }
            ViewGroup.LayoutParams k3 = k(layoutParams);
            k3.width = viewGroup.getWidth();
            view.setLayoutParams(k3);
        }
    }

    private void j(View view, c cVar) {
        if (!this.f110887i) {
            return;
        }
        VideoReport.setElementId(view, "em_sgrp_sub_channel_link");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, new HashMap<String, Object>(cVar) { // from class: com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagListAdapter.1
            final /* synthetic */ c val$uiData;

            {
                this.val$uiData = cVar;
                put("sgrp_sub_channel_id", cVar.f110891c);
                put("sgrp_subchannel_type", Integer.valueOf(cVar.f110893e));
            }
        });
    }

    private static ViewGroup.LayoutParams k(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(-1, -2);
        }
        return layoutParams;
    }

    private HashTagViewType l(IGProCategoryChannelInfoList iGProCategoryChannelInfoList, boolean z16) {
        if (iGProCategoryChannelInfoList.getCategoryType() == 1) {
            if (z16) {
                return HashTagViewType.VIEW_TYPE_FEED_SQUARE;
            }
            return HashTagViewType.VIEW_TYPE_FEED_SECTION;
        }
        if (iGProCategoryChannelInfoList.getCategoryType() == 0) {
            if (z16) {
                return HashTagViewType.VIEW_TYPE_GROUP_NAME;
            }
            return HashTagViewType.VIEW_TYPE_CHANNEL_ITEM;
        }
        return HashTagViewType.VIEW_TYPE_INVALID;
    }

    private View m(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(10000);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(10003);
        ImageView imageView = new ImageView(context);
        imageView.setId(10001);
        int i3 = this.f110886h.f110931a.f110944f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        frameLayout.addView(imageView, layoutParams);
        int i16 = this.f110886h.f110931a.f110945g;
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(i16, i16));
        View textView = new TextView(context);
        textView.setId(10002);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setId(10004);
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.addView(linearLayout);
        frameLayout2.addView(view);
        return frameLayout2;
    }

    private void n(d dVar, c cVar) {
        dVar.f110896b.setText(cVar.f110890b);
        HashTagViewType hashTagViewType = dVar.f110900f;
        if (hashTagViewType == HashTagViewType.VIEW_TYPE_CHANNEL_ITEM) {
            int h16 = GuildChannelIconUtil.h(cVar.f110893e, cVar.f110894f);
            ImageView imageView = dVar.f110897c;
            imageView.setImageDrawable(GuildUIUtils.w(imageView.getContext(), h16, Integer.valueOf(this.f110886h.f110932b.f110936b)));
        } else if (hashTagViewType == HashTagViewType.VIEW_TYPE_FEED_SQUARE || hashTagViewType == HashTagViewType.VIEW_TYPE_FEED_SECTION) {
            ImageView imageView2 = dVar.f110897c;
            imageView2.setImageDrawable(GuildUIUtils.w(imageView2.getContext(), R.drawable.guild_channel_feeds_p, Integer.valueOf(this.f110886h.f110932b.f110936b)));
        }
    }

    private static void s(c cVar, d dVar, h hVar) {
        HashTagViewType hashTagViewType = dVar.f110900f;
        HashTagViewType hashTagViewType2 = cVar.f110889a;
        if (hashTagViewType != hashTagViewType2) {
            dVar.f110900f = hashTagViewType2;
            f(dVar, hVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<c> list = this.f110885f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<c> list;
        if (i3 > -1 && (list = this.f110885f) != null && i3 < list.size()) {
            return this.f110885f.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            view = m(viewGroup.getContext());
        }
        c cVar = this.f110885f.get(i3);
        if (view.getTag() != null && (view.getTag() instanceof d)) {
            dVar = (d) view.getTag();
        } else {
            dVar = new d();
            g(view, dVar);
        }
        s(cVar, dVar, this.f110886h);
        i(view, viewGroup);
        n(dVar, cVar);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @UiThread
    public boolean o(List<IGProCategoryChannelInfoList> list, IGProChannel iGProChannel) {
        this.f110884e = list;
        if (this.f110885f == null) {
            this.f110885f = new ArrayList(getCount());
        }
        h(this.f110884e, this.f110885f, iGProChannel);
        notifyDataSetChanged();
        return !this.f110885f.isEmpty();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        c cVar;
        HashTagViewType hashTagViewType;
        b bVar;
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        Object item = getItem(i3);
        if (item != null && (((hashTagViewType = (cVar = (c) item).f110889a) == HashTagViewType.VIEW_TYPE_CHANNEL_ITEM || hashTagViewType == HashTagViewType.VIEW_TYPE_FEED_SQUARE || hashTagViewType == HashTagViewType.VIEW_TYPE_FEED_SECTION) && (bVar = this.f110883d) != null)) {
            bVar.a(cVar.f110891c, cVar.f110892d, hashTagViewType);
            j(view, cVar);
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    public void p(boolean z16) {
        this.f110887i = z16;
    }

    public void q(b bVar) {
        this.f110883d = bVar;
    }

    public void r(h hVar) {
        this.f110886h = hVar;
    }
}
