package com.tencent.mobileqq.profilecard.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TabContainer extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String STRING_MORE = "\u66f4\u591a";
    private int imageMargin;
    private int imageSize;
    private int innerPaddingBottom;
    private int innerPaddingLeft;
    private int intervalMargin;
    private final ArrayList<LinearLayout> linearLayoutList;
    private final Context mContext;
    private boolean mIsNightTheme;
    private boolean mIsShowMore;
    private int marginLeft;
    private int marginTop;
    private int maxLine;
    private int moreArrowMargin;
    private int moreArrowSize;
    private int morePaddingLeft;
    private int morePaddingRight;
    private final ArrayList<Tab> tabList;
    private int textSize;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class Tab {
        static IPatchRedirector $redirector_ = null;
        public static final String FEMALE = "FEMALE";
        public static final String MALE = "MALE";
        public static final int TYPE_IMAGE = 1;
        public static final int TYPE_MORE = 3;
        public static final int TYPE_SEX = 2;
        public static final int TYPE_TEXT = 0;
        public String image;
        public String text;
        public int type;

        Tab(String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3));
                return;
            }
            this.text = str;
            this.image = str2;
            this.type = i3;
        }

        public static Tab create(String str) {
            return new Tab(str, "", 0);
        }

        public static Tab createImage(String str, String str2) {
            return new Tab(str, str2, 1);
        }

        public static Tab createMore(String str) {
            return new Tab(str, "", 3);
        }

        public static Tab createSex(String str, String str2) {
            return new Tab(str, str2, 2);
        }
    }

    public TabContainer(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private boolean discardTab(Tab tab, int i3, int i16) {
        if ((TextUtils.isEmpty(tab.text) && TextUtils.isEmpty(tab.image)) || i3 > i16) {
            return true;
        }
        return false;
    }

    private Tab getMoreTab() {
        return Tab.createMore(STRING_MORE);
    }

    private View getMoreView() {
        return getTabView(getMoreTab());
    }

    private int getMoreWidth() {
        return getTabWidth(getMoreTab());
    }

    private int getTabHeight() {
        return this.textSize + (this.innerPaddingBottom * 2);
    }

    private LinearLayout getTabView(Tab tab) {
        Drawable drawable = null;
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.mContext, R.layout.f168846h15, null);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.image);
        TextView textView = (TextView) linearLayout.findViewById(R.id.jfb);
        ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.ezw);
        textView.setText(tab.text);
        if (tab.type == 1 && !TextUtils.isEmpty(tab.image)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.color.ajr, null);
            obtain.mLoadingDrawable = drawable2;
            obtain.mFailedDrawable = drawable2;
            imageView.setImageDrawable(URLDrawable.getDrawable(tab.image, obtain));
            imageView.setVisibility(0);
        } else if (tab.type == 2 && !TextUtils.isEmpty(tab.image)) {
            if (Tab.MALE.equals(tab.image)) {
                drawable = getResources().getDrawable(R.drawable.ku5);
            } else if (Tab.FEMALE.equals(tab.image)) {
                drawable = getResources().getDrawable(R.drawable.f161829ku4);
            }
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            }
        } else if (tab.type == 3) {
            imageView2.setVisibility(0);
            linearLayout.setPadding(this.morePaddingLeft, 0, this.morePaddingRight, 0);
        }
        if (this.mIsNightTheme) {
            linearLayout.setBackgroundResource(R.drawable.kut);
            textView.setTextColor(Color.parseColor("#FFFFFF"));
        }
        return linearLayout;
    }

    private int getTabWidth(Tab tab) {
        int i3;
        int i16;
        int i17 = 0;
        if (!TextUtils.isEmpty(tab.text)) {
            Paint paint = new Paint();
            paint.setTextSize(this.textSize);
            i17 = (int) (0 + paint.measureText(tab.text));
        }
        int i18 = tab.type;
        if (i18 == 0) {
            i3 = this.innerPaddingLeft;
        } else {
            if (i18 != 1 && i18 != 2) {
                if (i18 == 3) {
                    i17 += this.moreArrowSize + this.moreArrowMargin;
                    i16 = this.morePaddingLeft + this.morePaddingRight;
                    return i17 + i16;
                }
                return i17;
            }
            i17 += this.imageSize + this.imageMargin;
            i3 = this.innerPaddingLeft;
        }
        i16 = i3 * 2;
        return i17 + i16;
    }

    private void init() {
        int size = this.linearLayoutList.size();
        if (size < this.maxLine) {
            while (size < this.maxLine) {
                LinearLayout linearLayout = new LinearLayout(this.mContext);
                this.linearLayoutList.add(linearLayout);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getTabHeight());
                int i3 = this.marginTop;
                layoutParams.topMargin = i3;
                layoutParams.bottomMargin = i3;
                addView(linearLayout, layoutParams);
                size++;
            }
        }
        for (int i16 = 0; i16 < this.maxLine; i16++) {
            this.linearLayoutList.get(i16).setVisibility(8);
        }
    }

    private void initDimen() {
        Resources resources = this.mContext.getResources();
        this.marginTop = (int) resources.getDimension(R.dimen.d8b);
        this.marginLeft = (int) resources.getDimension(R.dimen.d8a);
        this.innerPaddingLeft = (int) resources.getDimension(R.dimen.d89);
        this.intervalMargin = (int) resources.getDimension(R.dimen.d8_);
        this.innerPaddingBottom = (int) resources.getDimension(R.dimen.d87);
        this.imageSize = (int) resources.getDimension(R.dimen.d86);
        this.moreArrowSize = (int) resources.getDimension(R.dimen.d8d);
        this.imageMargin = (int) resources.getDimension(R.dimen.d85);
        this.moreArrowMargin = (int) resources.getDimension(R.dimen.d8c);
        this.morePaddingLeft = (int) resources.getDimension(R.dimen.d8e);
        this.morePaddingRight = (int) resources.getDimension(R.dimen.d8f);
        this.textSize = (int) (resources.getDimension(R.dimen.d8g) * 1.167d);
    }

    private void updateUI() {
        int i3;
        init();
        if (this.mIsShowMore) {
            this.tabList.add(getMoreTab());
        }
        int size = this.tabList.size();
        int screenWidth = ViewUtils.getScreenWidth() - (this.marginLeft * 2);
        int i16 = 0;
        for (int i17 = 0; i17 < this.maxLine && i16 != size; i17++) {
            LinearLayout linearLayout = this.linearLayoutList.get(i17);
            linearLayout.removeAllViewsInLayout();
            if (i17 == this.maxLine - 1 && this.mIsShowMore) {
                i3 = getMoreWidth() + this.intervalMargin;
            } else {
                i3 = 0;
            }
            boolean z16 = true;
            while (i16 < size) {
                Tab tab = this.tabList.get(i16);
                int tabWidth = getTabWidth(tab);
                if (!discardTab(tab, tabWidth, screenWidth)) {
                    if (!z16) {
                        tabWidth += this.intervalMargin;
                    }
                    i3 += tabWidth;
                    if (i3 > screenWidth) {
                        break;
                    }
                    LinearLayout tabView = getTabView(tab);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, getTabHeight());
                    if (z16) {
                        z16 = false;
                    } else {
                        layoutParams.leftMargin = this.intervalMargin;
                    }
                    linearLayout.addView(tabView, layoutParams);
                }
                i16++;
            }
            if (i17 == this.maxLine - 1 && this.mIsShowMore && i16 < size) {
                View moreView = getMoreView();
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, getTabHeight());
                if (z16) {
                    z16 = false;
                } else {
                    layoutParams2.leftMargin = this.intervalMargin;
                }
                linearLayout.addView(moreView, layoutParams2);
            }
            if (!z16) {
                linearLayout.setVisibility(0);
            }
        }
        invalidate();
    }

    public int getMaxLine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.maxLine;
    }

    public void setData(List<Tab> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            if (list == null) {
                return;
            }
            this.tabList.clear();
            this.tabList.addAll(list);
            updateUI();
        }
    }

    public void setIsShowMore(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.mIsShowMore = z16;
        }
    }

    public void setMaxLine(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.maxLine = i3;
        }
    }

    public void setNightTheme(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mIsNightTheme = z16;
        }
    }

    public TabContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TabContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.maxLine = 2;
        this.mIsShowMore = true;
        this.mIsNightTheme = false;
        this.linearLayoutList = new ArrayList<>();
        this.tabList = new ArrayList<>();
        this.mContext = context;
        setOrientation(1);
        initDimen();
    }
}
