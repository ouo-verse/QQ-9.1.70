package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SmallEmotionDownloadedAdapter extends BaseEmotionAdapter {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SmallEmotionDownloadedAdapter";
    public static final int TYPE_BTN = 1;
    public static final int TYPE_DATA = 0;
    private int businessType;
    protected EmoticonCallback callback;
    protected int emojiWidth;
    protected EmoticonPackage emotionPkg;
    private IPanelInteractionListener interactionListener;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class SmallEmotionDownloadedViewHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        URLImageView[] contentViews;
        LinearLayout linearLayout;

        public SmallEmotionDownloadedViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SmallEmotionDownloadedAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, int i3, int i16, int i17, EmoticonPackage emoticonPackage, EmoticonCallback emoticonCallback, int i18) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelInteractionListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonPackage, emoticonCallback, Integer.valueOf(i18));
            return;
        }
        this.businessType = i18;
        this.emotionPkg = emoticonPackage;
        this.callback = emoticonCallback;
        this.interactionListener = iPanelInteractionListener;
    }

    private boolean isKanDian() {
        if (this.businessType == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int count = super.getCount();
        if (count > 0) {
            if (!isKanDian()) {
                return count + 1;
            }
            return count;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public EmoticonPackage getEmoticonPackage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.emotionPkg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.widget.RelativeLayout, android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r13v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r13v8, types: [android.widget.LinearLayout, android.view.View, android.view.ViewGroup, com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout] */
    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        int i16;
        String currentAccountUin;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        int i17 = this.widthPixels;
        int i18 = (int) (this.density * 18.0f);
        int i19 = this.columnNum;
        this.emojiWidth = (i17 - (i18 * (i19 + 1))) / i19;
        SmallEmotionDownloadedViewHolder smallEmotionDownloadedViewHolder = (SmallEmotionDownloadedViewHolder) viewHolder;
        view = view;
        if (getItemViewType(i3) == 0) {
            if (view == 0) {
                EmoticonPanelLinearLayout view2 = EmotionPanelViewPool.getInstance().getView(this.panelType);
                if (view2 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view from inflater");
                    }
                    view2 = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.interactionListener), this.businessType);
                    view2.setPanelType(2);
                    view2.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                    view2.setOrientation(0);
                    view2.setPadding(0, (int) (this.density * 18.0f), 0, 0);
                    for (int i26 = 0; i26 < this.columnNum; i26++) {
                        URLImageView uRLImageView = new URLImageView(this.mContext);
                        int i27 = this.emojiWidth;
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i27, i27);
                        layoutParams.leftMargin = (int) (this.density * 18.0f);
                        uRLImageView.setLayoutParams(layoutParams);
                        uRLImageView.setVisibility(8);
                        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        uRLImageView.setAdjustViewBounds(false);
                        uRLImageView.setFocusable(true);
                        uRLImageView.setFocusableInTouchMode(true);
                        view2.addView(uRLImageView);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view from cache");
                }
                view2.setCallBack(this.callback);
                recycleView(this.panelType, view2);
                ViewGroup viewGroup2 = view2;
                smallEmotionDownloadedViewHolder.contentViews = new URLImageView[this.columnNum];
                for (int i28 = 0; i28 < this.columnNum; i28++) {
                    smallEmotionDownloadedViewHolder.contentViews[i28] = (URLImageView) viewGroup2.getChildAt(i28);
                }
                view2.setTag(smallEmotionDownloadedViewHolder);
                view = view2;
            }
            int i29 = 0;
            while (true) {
                int i36 = this.columnNum;
                if (i29 >= i36) {
                    break;
                }
                int i37 = (i36 * i3) + i29;
                EmoticonInfo emoticonInfo = null;
                if (i37 > this.data.size() - 1) {
                    smallEmotionDownloadedViewHolder.contentViews[i29].setTag(null);
                    smallEmotionDownloadedViewHolder.contentViews[i29].setVisibility(8);
                } else {
                    URLImageView uRLImageView2 = smallEmotionDownloadedViewHolder.contentViews[i29];
                    EmotionPanelData emotionPanelData = this.data.get(i37);
                    if (emotionPanelData instanceof EmoticonInfo) {
                        emoticonInfo = (EmoticonInfo) emotionPanelData;
                    }
                    if (emoticonInfo != null) {
                        smallEmotionDownloadedViewHolder.contentViews[i29].setTag(emoticonInfo);
                        uRLImageView2.setImageDrawable(emoticonInfo.getDrawable(this.mContext, this.density));
                        uRLImageView2.setVisibility(0);
                    }
                }
                i29++;
            }
        } else if (view == 0) {
            view = new RelativeLayout(this.mContext);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) (this.density * 57.0f)));
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13, -1);
            linearLayout.setLayoutParams(layoutParams2);
            boolean hasRecommendDressup = hasRecommendDressup(this.emotionPkg.epId, true);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            linearLayout.setOrientation(0);
            layoutParams3.gravity = 16;
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(14.0f);
            Context context = this.mContext;
            if (hasRecommendDressup) {
                i16 = R.string.f209535fo;
            } else {
                i16 = R.string.f209545fp;
            }
            textView.setText(context.getString(i16));
            textView.setTextColor(RichStatus.ACTION_COLOR_NORMAL);
            linearLayout.addView(textView, layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.leftMargin = (int) (this.density * 5.0f);
            layoutParams4.gravity = 16;
            ImageView imageView = new ImageView(this.mContext);
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.nji));
            linearLayout.addView(imageView, layoutParams4);
            view.addView(linearLayout);
            smallEmotionDownloadedViewHolder.linearLayout = linearLayout;
            linearLayout.setOnClickListener(new View.OnClickListener(hasRecommendDressup) { // from class: com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$hasRecommendDressup;

                {
                    this.val$hasRecommendDressup = hasRecommendDressup;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SmallEmotionDownloadedAdapter.this, Boolean.valueOf(hasRecommendDressup));
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    String currentAccountUin2;
                    String str2;
                    EventCollector.getInstance().onViewClickedBefore(view3);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view3);
                    } else {
                        IEmoticonMainPanelApp iEmoticonMainPanelApp = SmallEmotionDownloadedAdapter.this.app;
                        if (iEmoticonMainPanelApp == null) {
                            currentAccountUin2 = "";
                        } else {
                            currentAccountUin2 = iEmoticonMainPanelApp.getCurrentAccountUin();
                        }
                        String str3 = currentAccountUin2;
                        String str4 = SmallEmotionDownloadedAdapter.this.emotionPkg.epId;
                        if (this.val$hasRecommendDressup) {
                            str2 = "1";
                        } else {
                            str2 = "2";
                        }
                        VasWebviewUtil.reportCommercialDrainage(str3, "ep_mall", "0X8007192", null, 1, 0, 0, null, str4, str2);
                        IBigEmotionService iBigEmotionService = (IBigEmotionService) QRoute.api(IBigEmotionService.class);
                        SmallEmotionDownloadedAdapter smallEmotionDownloadedAdapter = SmallEmotionDownloadedAdapter.this;
                        Context context2 = smallEmotionDownloadedAdapter.mContext;
                        IEmoticonMainPanelApp iEmoticonMainPanelApp2 = smallEmotionDownloadedAdapter.app;
                        String account = iEmoticonMainPanelApp2.getAccount();
                        String valueOf = String.valueOf(SmallEmotionDownloadedAdapter.this.emotionPkg.epId);
                        boolean z16 = this.val$hasRecommendDressup;
                        EmoticonPackage emoticonPackage = SmallEmotionDownloadedAdapter.this.emotionPkg;
                        iBigEmotionService.openEmojiDetailPage(context2, iEmoticonMainPanelApp2, account, 0, valueOf, false, null, true, z16, emoticonPackage.extraFlags, emoticonPackage.epId);
                        ReportController.o(SmallEmotionDownloadedAdapter.this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", SmallEmotionDownloadedAdapter.this.emotionPkg.epId, "2", "");
                    }
                    EventCollector.getInstance().onViewClicked(view3);
                }
            });
            if (this.businessType == 2) {
                smallEmotionDownloadedViewHolder.linearLayout.setVisibility(8);
            } else {
                smallEmotionDownloadedViewHolder.linearLayout.setVisibility(0);
            }
            view.setTag(smallEmotionDownloadedViewHolder);
            IEmoticonMainPanelApp iEmoticonMainPanelApp = this.app;
            if (iEmoticonMainPanelApp == null) {
                currentAccountUin = "";
            } else {
                currentAccountUin = iEmoticonMainPanelApp.getCurrentAccountUin();
            }
            String str2 = currentAccountUin;
            String str3 = this.emotionPkg.epId;
            if (hasRecommendDressup) {
                str = "1";
            } else {
                str = "2";
            }
            VasWebviewUtil.reportCommercialDrainage(str2, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, str3, str);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        if (isKanDian() || i3 != getCount() - 1) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (isKanDian()) {
            return 1;
        }
        return 2;
    }

    public boolean hasRecommendDressup(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        EmoticonRecDressup emotionRecommend = EmoticonRecDressup.getEmotionRecommend(str, z16);
        if (emotionRecommend == null) {
            return false;
        }
        return emotionRecommend.hasRecommendDressup;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new SmallEmotionDownloadedViewHolder();
    }
}
