package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
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
public class BigEmotionUpdateAdapter extends EmotionDownloadOrUpdateAdapter {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "BigEmotionUpdateAdapter";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class BigEmotionUpdateViewHolder extends EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder {
        static IPatchRedirector $redirector_;
        public RelativeLayout[] contentViews;

        public BigEmotionUpdateViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public BigEmotionUpdateAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, int i17, EmoticonPackage emoticonPackage, EmoticonCallback emoticonCallback, int i18) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonPackage, emoticonCallback, i18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonPackage, emoticonCallback, Integer.valueOf(i18));
        } else {
            this.callback = emoticonCallback;
            this.isUpdatePanel = true;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter, com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        BigEmotionUpdateViewHolder bigEmotionUpdateViewHolder = (BigEmotionUpdateViewHolder) viewHolder;
        this.holder = bigEmotionUpdateViewHolder;
        int itemViewType = getItemViewType(i3);
        if (itemViewType == 0) {
            if (view == null) {
                View view4 = EmotionPanelViewPool.getInstance().getView(7);
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
                if (view4 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";itemtype = " + itemViewType + ";view from inflater");
                    }
                    view3 = LayoutInflater.from(this.mContext).inflate(R.layout.f168905h83, (ViewGroup) null);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";itemtype = " + itemViewType + ";view from cache");
                    }
                    view3 = view4;
                }
                view3.setLayoutParams(layoutParams);
                view3.setPadding(0, (int) (this.density * 10.0f), 0, 0);
                recycleView(7, view3);
                bigEmotionUpdateViewHolder.cover = (URLImageView) view3.findViewById(R.id.bat);
                bigEmotionUpdateViewHolder.name = (TextView) view3.findViewById(R.id.bd5);
                bigEmotionUpdateViewHolder.downloadBtn = (ProgressButton) view3.findViewById(R.id.f164944bd3);
                view3.setTag(bigEmotionUpdateViewHolder);
            } else {
                view3 = view;
            }
            updateDownloadUI(bigEmotionUpdateViewHolder);
            return view3;
        }
        if (view == null) {
            view2 = EmotionPanelViewPool.getInstance().getView(6);
            if (view2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";itemtype = " + itemViewType + ";view from inflater");
                }
                EmoticonPanelLinearLayout emoticonPanelLinearLayout = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, null));
                emoticonPanelLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                emoticonPanelLinearLayout.setOrientation(0);
                if (i3 == 1) {
                    emoticonPanelLinearLayout.setPadding(0, (int) (this.density * 16.0f), 0, 0);
                } else {
                    emoticonPanelLinearLayout.setPadding(0, (int) (this.density * 14.0f), 0, 0);
                }
                for (int i17 = 0; i17 < this.columnNum; i17++) {
                    RelativeLayout bigEmotionContentViewLayout = super.getBigEmotionContentViewLayout();
                    bigEmotionContentViewLayout.setVisibility(8);
                    emoticonPanelLinearLayout.addView(bigEmotionContentViewLayout);
                }
                view2 = emoticonPanelLinearLayout;
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";itemtype = " + itemViewType + ";view from cache");
            }
            ((EmoticonPanelLinearLayout) view2).setCallBack(this.callback);
            recycleView(6, view2);
            ViewGroup viewGroup2 = (ViewGroup) view2;
            bigEmotionUpdateViewHolder.contentViews = new RelativeLayout[this.columnNum];
            for (int i18 = 0; i18 < this.columnNum; i18++) {
                bigEmotionUpdateViewHolder.contentViews[i18] = (RelativeLayout) viewGroup2.getChildAt(i18);
            }
            view2.setTag(bigEmotionUpdateViewHolder);
        } else {
            view2 = view;
        }
        while (true) {
            int i19 = this.columnNum;
            if (i16 < i19) {
                int i26 = (i19 * i3) + i16;
                if (i26 > this.data.size() - 1) {
                    bigEmotionUpdateViewHolder.contentViews[i16].setTag(null);
                    bigEmotionUpdateViewHolder.contentViews[i16].setVisibility(8);
                } else {
                    super.updateBigEmotionContentViewData(bigEmotionUpdateViewHolder.contentViews[i16], this.data.get(i26));
                }
                i16++;
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
        return new BigEmotionUpdateViewHolder();
    }
}
