package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.IPSiteModel$Goods;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* loaded from: classes12.dex */
public class IPSiteListGoodsAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private static int MAX_ITEM_SIZE;
    private String ipId;
    private Context mContext;
    private Drawable mDefaultDrawable;
    private List<Object> mGoodsList;
    private URLDrawable.URLDrawableListener mURLDrawableListener;
    private String netStr;
    private String uin;

    /* loaded from: classes12.dex */
    private class Holder {
        static IPatchRedirector $redirector_;
        ImageView cover;
        TextView desc;
        RelativeLayout itemLayout;
        TextView title;

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IPSiteListGoodsAdapter.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50427);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            MAX_ITEM_SIZE = 6;
        }
    }

    public IPSiteListGoodsAdapter(Context context, List<Object> list, URLDrawable.URLDrawableListener uRLDrawableListener, Drawable drawable, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, list, uRLDrawableListener, drawable, str, str2, str3);
            return;
        }
        this.mContext = context;
        this.mGoodsList = list;
        this.mURLDrawableListener = uRLDrawableListener;
        this.mDefaultDrawable = drawable;
        this.uin = str;
        this.ipId = str2;
        this.netStr = str3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        List<Object> list = this.mGoodsList;
        if (list != null) {
            int size = list.size();
            int i3 = MAX_ITEM_SIZE;
            if (size > i3) {
                return i3 + 1;
            }
            return size + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        Holder holder;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = view;
            view = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (i3 < getCount() - 1) {
                IPSiteModel$Goods iPSiteModel$Goods = (IPSiteModel$Goods) this.mGoodsList.get(i3);
                if (view == null) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.h8d, (ViewGroup) null, false);
                    holder = new Holder();
                    holder.itemLayout = (RelativeLayout) view;
                    holder.cover = (ImageView) view.findViewById(R.id.f164155l1);
                    holder.title = (TextView) view.findViewById(R.id.f164156l2);
                    holder.desc = (TextView) view.findViewById(R.id.f164154l0);
                    view.setTag(holder);
                } else {
                    holder = (Holder) view.getTag();
                }
                if (iPSiteModel$Goods != null) {
                    holder.cover.setImageDrawable(IPSiteUtil.getIPSiteDrawable(iPSiteModel$Goods.cover, this.mURLDrawableListener, this.mDefaultDrawable));
                    holder.title.setText(iPSiteModel$Goods.name);
                    if (!TextUtils.isEmpty(iPSiteModel$Goods.saleNum)) {
                        str = iPSiteModel$Goods.saleNum;
                    } else {
                        str = "0";
                    }
                    holder.desc.setText(str + this.mContext.getString(R.string.f208845dt));
                    holder.itemLayout.setOnClickListener(new View.OnClickListener(iPSiteModel$Goods) { // from class: com.tencent.mobileqq.emoticonview.IPSiteListGoodsAdapter.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ IPSiteModel$Goods val$goods;

                        {
                            this.val$goods = iPSiteModel$Goods;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IPSiteListGoodsAdapter.this, (Object) iPSiteModel$Goods);
                            }
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            EventCollector.getInstance().onViewClickedBefore(view3);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view3);
                            } else {
                                ((IBigEmotionService) QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(IPSiteListGoodsAdapter.this.mContext, this.val$goods.url, -1L, null, false, -1);
                                VasWebviewUtil.reportCommercialDrainage(IPSiteListGoodsAdapter.this.uin, "IP", "aio_productclk", "", 0, 0, 0, IPSiteListGoodsAdapter.this.netStr, IPSiteListGoodsAdapter.this.ipId, "", "", "", "", "", 0, 0, 0, 0);
                            }
                            EventCollector.getInstance().onViewClicked(view3);
                        }
                    });
                }
            } else {
                IPSiteModel$Goods iPSiteModel$Goods2 = (IPSiteModel$Goods) this.mGoodsList.get(0);
                RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
                relativeLayout.setBackgroundColor(Color.parseColor("#fafafa"));
                ViewGroup.LayoutParams layoutParams = new AbsListView.LayoutParams(com.tencent.mobileqq.EmotionUtils.a(75.0f, this.mContext.getResources()), com.tencent.mobileqq.EmotionUtils.a(75.0f, this.mContext.getResources()));
                relativeLayout.setMinimumWidth(com.tencent.mobileqq.EmotionUtils.a(75.0f, this.mContext.getResources()));
                relativeLayout.setMinimumHeight(com.tencent.mobileqq.EmotionUtils.a(75.0f, this.mContext.getResources()));
                relativeLayout.setLayoutParams(layoutParams);
                RelativeLayout relativeLayout2 = new RelativeLayout(this.mContext);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(15);
                layoutParams2.addRule(14);
                relativeLayout2.setLayoutParams(layoutParams2);
                TextView textView = new TextView(this.mContext);
                textView.setId(R.id.l_);
                textView.setTextSize(12.0f);
                textView.setTextColor(Color.parseColor("#777777"));
                textView.setText(this.mContext.getString(R.string.f209115ej));
                textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.mContext);
                imageView.setImageResource(R.drawable.nji);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(1, R.id.l_);
                layoutParams3.addRule(15);
                layoutParams3.leftMargin = com.tencent.mobileqq.EmotionUtils.a(2.0f, this.mContext.getResources());
                imageView.setLayoutParams(layoutParams3);
                relativeLayout2.addView(textView);
                relativeLayout2.addView(imageView);
                relativeLayout.addView(relativeLayout2);
                relativeLayout.setOnClickListener(new View.OnClickListener(iPSiteModel$Goods2) { // from class: com.tencent.mobileqq.emoticonview.IPSiteListGoodsAdapter.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ IPSiteModel$Goods val$goods;

                    {
                        this.val$goods = iPSiteModel$Goods2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IPSiteListGoodsAdapter.this, (Object) iPSiteModel$Goods2);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        EventCollector.getInstance().onViewClickedBefore(view3);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view3);
                        } else {
                            ((IBigEmotionService) QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(IPSiteListGoodsAdapter.this.mContext, this.val$goods.moreUrl, -1L, null, false, -1);
                            VasWebviewUtil.reportCommercialDrainage(IPSiteListGoodsAdapter.this.uin, "IP", "aio_productmore", "", 0, 0, 0, IPSiteListGoodsAdapter.this.netStr, IPSiteListGoodsAdapter.this.ipId, "", "", "", "", "", 0, 0, 0, 0);
                        }
                        EventCollector.getInstance().onViewClicked(view3);
                    }
                });
                view = relativeLayout;
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }
}
