package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SmallEmotionUpdateAdapter extends EmotionDownloadOrUpdateAdapter {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SmallEmotionUpdateAdapter";
    protected int emojiWidth;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class SmallEmotionUpdateViewHolder extends EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder {
        static IPatchRedirector $redirector_;
        public URLImageView[] contentViews;

        public SmallEmotionUpdateViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SmallEmotionUpdateAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, int i17, EmoticonPackage emoticonPackage, EmoticonCallback emoticonCallback, int i18) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonPackage, emoticonCallback, i18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonPackage, emoticonCallback, Integer.valueOf(i18));
        } else {
            this.emojiWidth = (this.widthPixels - (((int) (this.density * 18.0f)) * 8)) / 7;
            this.isUpdatePanel = true;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter, com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        View view2;
        EmoticonInfo emoticonInfo;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        SmallEmotionUpdateViewHolder smallEmotionUpdateViewHolder = (SmallEmotionUpdateViewHolder) viewHolder;
        this.holder = smallEmotionUpdateViewHolder;
        int itemViewType = getItemViewType(i3);
        if (itemViewType == 0) {
            if (view == null) {
                View view4 = EmotionPanelViewPool.getInstance().getView(7);
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
                if (view4 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";itemType = " + itemViewType + ";view from infalter");
                    }
                    view3 = LayoutInflater.from(this.mContext).inflate(R.layout.f168905h83, (ViewGroup) null);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";itemType = " + itemViewType + ";view from cache");
                    }
                    view3 = view4;
                }
                view3.setLayoutParams(layoutParams);
                view3.setPadding(0, (int) (this.density * 10.0f), 0, 0);
                recycleView(7, view3);
                smallEmotionUpdateViewHolder.cover = (URLImageView) view3.findViewById(R.id.bat);
                smallEmotionUpdateViewHolder.name = (TextView) view3.findViewById(R.id.bd5);
                smallEmotionUpdateViewHolder.downloadBtn = (ProgressButton) view3.findViewById(R.id.f164944bd3);
                view3.setTag(smallEmotionUpdateViewHolder);
            } else {
                view3 = view;
            }
            updateDownloadUI(smallEmotionUpdateViewHolder);
            return view3;
        }
        if (view == null) {
            view2 = EmotionPanelViewPool.getInstance().getView(2);
            if (view2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";itemType = " + itemViewType + ";view from infalter");
                }
                EmoticonPanelLinearLayout emoticonPanelLinearLayout = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, null));
                emoticonPanelLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                emoticonPanelLinearLayout.setOrientation(0);
                emoticonPanelLinearLayout.setPadding(0, (int) (this.density * 18.0f), 0, 0);
                for (int i16 = 0; i16 < this.columnNum; i16++) {
                    URLImageView uRLImageView = new URLImageView(this.mContext);
                    int i17 = this.emojiWidth;
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i17, i17);
                    layoutParams2.leftMargin = (int) (this.density * 18.0f);
                    uRLImageView.setLayoutParams(layoutParams2);
                    uRLImageView.setVisibility(8);
                    uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    uRLImageView.setAdjustViewBounds(false);
                    emoticonPanelLinearLayout.addView(uRLImageView);
                }
                view2 = emoticonPanelLinearLayout;
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";itemType = " + itemViewType + ";view from cache");
            }
            ((EmoticonPanelLinearLayout) view2).setCallBack(this.callback);
            recycleView(2, view2);
            ViewGroup viewGroup2 = (ViewGroup) view2;
            smallEmotionUpdateViewHolder.contentViews = new URLImageView[this.columnNum];
            for (int i18 = 0; i18 < this.columnNum; i18++) {
                smallEmotionUpdateViewHolder.contentViews[i18] = (URLImageView) viewGroup2.getChildAt(i18);
            }
            view2.setTag(smallEmotionUpdateViewHolder);
        } else {
            view2 = view;
        }
        int i19 = 0;
        while (true) {
            int i26 = this.columnNum;
            if (i19 < i26) {
                int i27 = (i26 * i3) + i19;
                if (i27 > this.data.size() - 1) {
                    smallEmotionUpdateViewHolder.contentViews[i19].setTag(null);
                    smallEmotionUpdateViewHolder.contentViews[i19].setVisibility(8);
                } else {
                    URLImageView uRLImageView2 = smallEmotionUpdateViewHolder.contentViews[i19];
                    EmotionPanelData emotionPanelData = this.data.get(i27);
                    if (emotionPanelData instanceof EmoticonInfo) {
                        emoticonInfo = (EmoticonInfo) emotionPanelData;
                    } else {
                        emoticonInfo = null;
                    }
                    if (emoticonInfo != null) {
                        smallEmotionUpdateViewHolder.contentViews[i19].setTag(emoticonInfo);
                        smallEmotionUpdateViewHolder.contentViews[i19].setOnClickListener(this);
                        uRLImageView2.setImageDrawable(emoticonInfo.getDrawable(this.mContext, this.density));
                        uRLImageView2.setVisibility(0);
                    }
                }
                i19++;
            } else {
                return view2;
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter, com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new SmallEmotionUpdateViewHolder();
    }
}
