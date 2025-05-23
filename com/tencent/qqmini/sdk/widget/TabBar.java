package com.tencent.qqmini.sdk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TabBar extends LinearLayout {
    private static final String TAG = "minisdk-startTabBar";
    public static final int TEXT_DEFAULT_COLOR = DisplayUtil.parseColor("#7F000000");
    private TabBarInfo mInfo;
    public LinkedList<ItemHolder> mItemHolders;
    private IMiniAppContext mMiniAppContext;
    private OnTabItemClickListener mOnTabItemClickListener;
    private boolean needShow;
    private String selectUrl;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ItemHolder {
        public TextView badge;
        public View bottomBorder;
        public View bottomSelectedBorder;
        public TabBarInfo.ButtonInfo btnInfo;
        public View btnView;
        public ImageView icon;
        public Drawable iconDrawable;
        public boolean isSelected = false;
        public View redDot;
        public Drawable selectedDrawable;
        public TabBarInfo tabBarInfo;
        public View topBorder;
        public TextView txt;

        public static ItemHolder getItemHolder(View view, TabBarInfo.ButtonInfo buttonInfo, TabBarInfo tabBarInfo) {
            ItemHolder itemHolder = new ItemHolder();
            itemHolder.txt = (TextView) view.findViewById(R.id.mini_sdk_tab_text);
            itemHolder.icon = (ImageView) view.findViewById(R.id.mini_sdk_tab_icon);
            itemHolder.topBorder = view.findViewById(R.id.mini_sdk_tab_top_border);
            itemHolder.bottomBorder = view.findViewById(R.id.mini_sdk_tab_bottom_border);
            itemHolder.bottomSelectedBorder = view.findViewById(R.id.mini_sdk_tab_bottom_selected_border);
            itemHolder.redDot = view.findViewById(R.id.mini_sdk_tab_red_dot);
            TextView textView = (TextView) view.findViewById(R.id.mini_sdk_tab_badge);
            itemHolder.badge = textView;
            textView.setEllipsize(TextUtils.TruncateAt.END);
            itemHolder.badge.setMaxEms(3);
            itemHolder.badge.setSingleLine();
            itemHolder.btnView = view;
            itemHolder.tabBarInfo = tabBarInfo;
            itemHolder.btnInfo = buttonInfo;
            return itemHolder;
        }

        public void init() {
            if ("top".equals(this.tabBarInfo.position)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.txt.getLayoutParams();
                layoutParams.bottomMargin = DisplayUtil.dip2px(this.btnView.getContext(), 15.0f);
                layoutParams.topMargin = DisplayUtil.dip2px(this.btnView.getContext(), 15.0f);
                this.txt.setLayoutParams(layoutParams);
                this.txt.setTextSize(1, 15.0f);
                this.icon.setVisibility(8);
                this.topBorder.setVisibility(8);
                this.bottomBorder.setVisibility(0);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.txt.getLayoutParams();
                layoutParams2.bottomMargin = DisplayUtil.dip2px(this.btnView.getContext(), 5.0f);
                layoutParams2.topMargin = DisplayUtil.dip2px(this.btnView.getContext(), 0.0f);
                this.txt.setLayoutParams(layoutParams2);
                this.txt.setTextSize(1, 12.0f);
                this.bottomBorder.setVisibility(8);
                this.topBorder.setVisibility(0);
                this.icon.setVisibility(0);
            }
            this.txt.setText(this.btnInfo.text);
            if (!"top".equals(this.tabBarInfo.position)) {
                this.iconDrawable = new BitmapDrawable(this.btnView.getContext().getResources(), this.btnInfo.iconBitmap);
                this.selectedDrawable = new BitmapDrawable(this.btnView.getContext().getResources(), this.btnInfo.selectedBitmap);
            }
            invalidateStatus(false);
        }

        public void invalidateStatus(boolean z16) {
            this.isSelected = z16;
            this.btnView.setBackgroundColor(this.tabBarInfo.backgroundColor);
            if (!z16) {
                TextView textView = this.txt;
                int i3 = this.tabBarInfo.color;
                if (i3 == 0) {
                    i3 = TabBar.TEXT_DEFAULT_COLOR;
                }
                textView.setTextColor(i3);
                if ("top".equals(this.tabBarInfo.position)) {
                    this.bottomSelectedBorder.setVisibility(8);
                } else {
                    this.icon.setImageDrawable(this.iconDrawable);
                }
            } else {
                TextView textView2 = this.txt;
                int i16 = this.tabBarInfo.selectedColor;
                if (i16 == 0) {
                    i16 = TabBar.TEXT_DEFAULT_COLOR;
                }
                textView2.setTextColor(i16);
                if ("top".equals(this.tabBarInfo.position)) {
                    this.bottomSelectedBorder.setVisibility(0);
                } else {
                    this.icon.setImageDrawable(this.selectedDrawable);
                }
            }
            int i17 = 855638016;
            if ("top".equals(this.tabBarInfo.position)) {
                View view = this.bottomBorder;
                if (!"black".equals(this.tabBarInfo.borderStyle)) {
                    i17 = 872415231;
                }
                view.setBackgroundColor(i17);
                this.bottomSelectedBorder.setBackgroundColor(this.tabBarInfo.selectedColor);
                return;
            }
            View view2 = this.topBorder;
            if (!"black".equals(this.tabBarInfo.borderStyle)) {
                i17 = 872415231;
            }
            view2.setBackgroundColor(i17);
        }

        public void invalidateStatusSelf() {
            invalidateStatus(this.isSelected);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnTabItemClickListener {
        void onTabItemClick(int i3, String str, String str2);
    }

    public TabBar(Context context, IMiniAppContext iMiniAppContext) {
        super(context);
        this.mItemHolders = new LinkedList<>();
        this.needShow = true;
        this.selectUrl = "";
        this.mMiniAppContext = iMiniAppContext;
        init();
    }

    private void fillBtnsLayout(List<TabBarInfo.ButtonInfo> list) {
        removeAllViews();
        this.mItemHolders.clear();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                View btnView = getBtnView(list.get(i3), i3);
                if (btnView != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = 1.0f;
                    addView(btnView, layoutParams);
                }
            }
        }
    }

    public static int getDefaultTabBarHeight(Context context) {
        return DisplayUtil.dip2px(context, 54.0f);
    }

    private void init() {
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }

    private boolean isWhiteStyle(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.mInfo.borderStyle;
        }
        if (!str.equals("white") && !str.equalsIgnoreCase("#FFFFFF") && !str.equalsIgnoreCase("#FFFFFFFF")) {
            return false;
        }
        return true;
    }

    public View getBtnView(final TabBarInfo.ButtonInfo buttonInfo, final int i3) {
        if (buttonInfo != null && !TextUtils.isEmpty(buttonInfo.text)) {
            View itemView = getItemView();
            ItemHolder itemHolder = ItemHolder.getItemHolder(itemView, buttonInfo, this.mInfo);
            itemHolder.init();
            this.mItemHolders.add(itemHolder);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.TabBar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    if (TabBar.this.mOnTabItemClickListener != null) {
                        OnTabItemClickListener onTabItemClickListener = TabBar.this.mOnTabItemClickListener;
                        int i16 = i3;
                        TabBarInfo.ButtonInfo buttonInfo2 = buttonInfo;
                        onTabItemClickListener.onTabItemClick(i16, buttonInfo2.pagePath, buttonInfo2.text);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            return itemView;
        }
        return null;
    }

    public View getItemView() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        View view = new View(getContext());
        int i3 = R.id.mini_sdk_tab_top_border;
        view.setId(i3);
        relativeLayout.addView(view, new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5f)));
        View imageView = new ImageView(getContext());
        int i16 = R.id.mini_sdk_tab_icon;
        imageView.setId(i16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 30.0f), DisplayUtil.dip2px(getContext(), 30.0f));
        layoutParams.addRule(3, i3);
        layoutParams.topMargin = DisplayUtil.dip2px(getContext(), 2.0f);
        layoutParams.addRule(14, -1);
        relativeLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(getContext());
        textView.setId(R.id.mini_sdk_tab_badge);
        textView.setTextColor(-1);
        textView.setTextSize(1, 10.0f);
        textView.setPadding(DisplayUtil.dip2px(getContext(), 1.0f), 0, DisplayUtil.dip2px(getContext(), 1.0f), 0);
        textView.setBackgroundResource(R.drawable.mini_sdk_skin_tips_newmessage);
        textView.setVisibility(4);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setMaxEms(3);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(6, i16);
        layoutParams2.addRule(1, i16);
        relativeLayout.addView(textView, layoutParams2);
        View view2 = new View(getContext());
        view2.setId(R.id.mini_sdk_tab_red_dot);
        view2.setBackgroundResource(R.drawable.mini_sdk_red_dot);
        view2.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 10.0f), DisplayUtil.dip2px(getContext(), 10.0f));
        layoutParams3.addRule(6, i16);
        layoutParams3.addRule(1, i16);
        relativeLayout.addView(view2, layoutParams3);
        TextView textView2 = new TextView(getContext());
        int i17 = R.id.mini_sdk_tab_text;
        textView2.setId(i17);
        textView2.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(3, i16);
        layoutParams4.bottomMargin = DisplayUtil.dip2px(getContext(), 5.0f);
        relativeLayout.addView(textView2, layoutParams4);
        View view3 = new View(getContext());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, 0);
        layoutParams5.addRule(3, i17);
        relativeLayout.addView(view3, layoutParams5);
        View view4 = new View(getContext());
        int i18 = R.id.mini_sdk_tab_bottom_border;
        view4.setId(i18);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5f));
        layoutParams6.addRule(3, i17);
        relativeLayout.addView(view4, layoutParams6);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.addRule(8, i18);
        relativeLayout.addView(linearLayout, layoutParams7);
        View view5 = new View(getContext());
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0f));
        layoutParams8.weight = 1.0f;
        linearLayout.addView(view5, layoutParams8);
        View view6 = new View(getContext());
        view6.setId(R.id.mini_sdk_tab_bottom_selected_border);
        view6.setVisibility(8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0f));
        layoutParams9.weight = 3.0f;
        linearLayout.addView(view6, layoutParams9);
        View view7 = new View(getContext());
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0f));
        layoutParams10.weight = 1.0f;
        linearLayout.addView(view7, layoutParams10);
        return relativeLayout;
    }

    public boolean getNeedShow() {
        return this.needShow;
    }

    public void hideBadge(int i3) {
        if (i3 != -1 && i3 < this.mItemHolders.size()) {
            ItemHolder itemHolder = this.mItemHolders.get(i3);
            itemHolder.redDot.setVisibility(4);
            itemHolder.badge.setVisibility(4);
        }
    }

    public void hideTabBar(boolean z16) {
        TabBarInfo tabBarInfo;
        int height;
        if (getVisibility() != 8) {
            this.needShow = false;
            TabBarInfo tabBarInfo2 = this.mInfo;
            if (tabBarInfo2 != null) {
                tabBarInfo2.setShow(false);
            }
            if (z16 && (tabBarInfo = this.mInfo) != null) {
                if ("top".equals(tabBarInfo.position)) {
                    height = -getHeight();
                } else {
                    height = getHeight();
                }
                animate().translationY(height).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.tencent.qqmini.sdk.widget.TabBar.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        TabBar.this.setVisibility(8);
                        TabBar.this.animate().setListener(null);
                    }
                });
                return;
            }
            setVisibility(8);
        }
    }

    public void hideTabBarRedDot(int i3) {
        if (i3 != -1 && i3 < this.mItemHolders.size()) {
            this.mItemHolders.get(i3).redDot.setVisibility(4);
        }
    }

    public void removeTabBarBadge(int i3) {
        if (i3 != -1 && i3 < this.mItemHolders.size()) {
            this.mItemHolders.get(i3).badge.setVisibility(4);
        }
    }

    public void setInfo(TabBarInfo tabBarInfo, boolean z16) {
        List<TabBarInfo.ButtonInfo> list;
        this.mInfo = tabBarInfo;
        if (tabBarInfo == null) {
            return;
        }
        TabBarInfo m244clone = tabBarInfo.m244clone();
        this.mInfo = m244clone;
        if (m244clone != null) {
            fillBtnsLayout(m244clone.list);
            if (this.mItemHolders.size() > 0) {
                QMLog.d(TAG, " setInfo selectUrl = " + this.selectUrl);
                if (z16) {
                    if (TextUtils.isEmpty(this.selectUrl) && (list = this.mInfo.list) != null && !list.isEmpty()) {
                        this.selectUrl = this.mInfo.list.get(0).pagePath;
                        setTabSelected(this.mInfo.list.get(0).pagePath);
                        return;
                    } else {
                        setTabSelected(this.selectUrl);
                        return;
                    }
                }
                this.mItemHolders.getFirst().invalidateStatus(true);
            }
        }
    }

    public void setItemSelected(ItemHolder itemHolder) {
        if (itemHolder != null) {
            itemHolder.invalidateStatus(true);
            Iterator<ItemHolder> it = this.mItemHolders.iterator();
            while (it.hasNext()) {
                ItemHolder next = it.next();
                if (next != itemHolder) {
                    next.invalidateStatus(false);
                }
            }
        }
    }

    public void setOnTabItemClickListener(OnTabItemClickListener onTabItemClickListener) {
        this.mOnTabItemClickListener = onTabItemClickListener;
    }

    public void setTabBarBadge(int i3, String str) {
        if (i3 != -1 && i3 < this.mItemHolders.size() && str != null) {
            if (str.length() > 3) {
                str = MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            ItemHolder itemHolder = this.mItemHolders.get(i3);
            if (TextUtils.isEmpty(str)) {
                itemHolder.badge.setVisibility(4);
            } else {
                itemHolder.badge.setVisibility(0);
            }
            itemHolder.badge.setText(str);
            itemHolder.redDot.setVisibility(4);
        }
    }

    public void setTabBarItem(int i3, String str, Bitmap bitmap, Bitmap bitmap2) {
        if (i3 != -1 && i3 < this.mItemHolders.size()) {
            ItemHolder itemHolder = this.mItemHolders.get(i3);
            if (str != null) {
                itemHolder.txt.setText(str);
            }
            if (bitmap != null) {
                itemHolder.iconDrawable = new BitmapDrawable(getContext().getResources(), bitmap);
            }
            if (bitmap2 != null) {
                itemHolder.selectedDrawable = new BitmapDrawable(getContext().getResources(), bitmap2);
            }
            itemHolder.invalidateStatusSelf();
        }
    }

    public void setTabBarStyle(String str, String str2, String str3, String str4) {
        int parseColor;
        int parseColor2;
        int parseColor3;
        String str5;
        TabBarInfo tabBarInfo = this.mInfo;
        if (TextUtils.isEmpty(str)) {
            parseColor = this.mInfo.color;
        } else {
            parseColor = DisplayUtil.parseColor(str);
        }
        tabBarInfo.color = parseColor;
        TabBarInfo tabBarInfo2 = this.mInfo;
        if (TextUtils.isEmpty(str2)) {
            parseColor2 = this.mInfo.selectedColor;
        } else {
            parseColor2 = DisplayUtil.parseColor(str2);
        }
        tabBarInfo2.selectedColor = parseColor2;
        TabBarInfo tabBarInfo3 = this.mInfo;
        if (TextUtils.isEmpty(str3)) {
            parseColor3 = this.mInfo.backgroundColor;
        } else {
            parseColor3 = DisplayUtil.parseColor(str3);
        }
        tabBarInfo3.backgroundColor = parseColor3;
        TabBarInfo tabBarInfo4 = this.mInfo;
        if (isWhiteStyle(str4)) {
            str5 = "white";
        } else {
            str5 = "black";
        }
        tabBarInfo4.borderStyle = str5;
        Iterator<ItemHolder> it = this.mItemHolders.iterator();
        while (it.hasNext()) {
            it.next().invalidateStatusSelf();
        }
    }

    public void setTabSelected(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.selectUrl = str;
        String urlWithoutParams = AppBrandUtil.getUrlWithoutParams(str);
        Iterator<ItemHolder> it = this.mItemHolders.iterator();
        while (it.hasNext()) {
            ItemHolder next = it.next();
            if (next.btnInfo.pagePath.equals(urlWithoutParams)) {
                setItemSelected(next);
                return;
            }
        }
    }

    public void showTabBar(boolean z16) {
        TabBarInfo tabBarInfo;
        int height;
        if (getVisibility() != 0) {
            this.needShow = true;
            TabBarInfo tabBarInfo2 = this.mInfo;
            if (tabBarInfo2 != null) {
                tabBarInfo2.setShow(true);
            }
            setVisibility(0);
            if (z16 && (tabBarInfo = this.mInfo) != null) {
                if ("top".equals(tabBarInfo.position)) {
                    height = -getHeight();
                } else {
                    height = getHeight();
                }
                setTranslationY(height);
                animate().translationY(0.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
                return;
            }
            setTranslationY(0.0f);
        }
    }

    public void showTabBarRedDot(int i3) {
        if (i3 != -1 && i3 < this.mItemHolders.size()) {
            ItemHolder itemHolder = this.mItemHolders.get(i3);
            itemHolder.redDot.setVisibility(0);
            itemHolder.badge.setVisibility(4);
        }
    }
}
