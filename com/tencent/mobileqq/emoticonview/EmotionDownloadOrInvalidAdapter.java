package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionDownloadOrInvalidAdapter extends EmotionDownloadOrUpdateAdapter {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmotionDownloadOrInvalidAdapter";
    protected int contentHight;
    protected IPanelInteractionListener interactionListener;

    public EmotionDownloadOrInvalidAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, int i3, int i16, int i17, EmoticonPackage emoticonPackage, EmoticonCallback emoticonCallback, int i18) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonPackage, emoticonCallback, i18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelInteractionListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonPackage, emoticonCallback, Integer.valueOf(i18));
        } else {
            this.isUpdatePanel = false;
            this.interactionListener = iPanelInteractionListener;
        }
    }

    private void initContentHeight() {
        if (this.contentHight == 0 && this.interactionListener != null) {
            if (getCurrentListView() != null) {
                int height = getCurrentListView().getHeight();
                this.contentHight = height;
                if (height == 0) {
                    this.contentHight = this.interactionListener.getPanelTargetHeight() - ((int) this.mContext.getResources().getDimension(R.dimen.f158749nw));
                    return;
                }
                return;
            }
            this.contentHight = this.interactionListener.getPanelTargetHeight() - ((int) this.mContext.getResources().getDimension(R.dimen.f158749nw));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public EmoticonPackage getEmoticonPackage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.emotionPkg;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter, com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        int panelTargetHeight;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getEmotionView position = " + i3);
        }
        this.holder = (EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder) viewHolder;
        if (view == null) {
            initContentHeight();
            View view2 = EmotionPanelViewPool.getInstance().getView(this.panelType);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, this.contentHight);
            if (view2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view form inflater");
                }
                view2 = LayoutInflater.from(this.mContext).inflate(R.layout.f168905h83, (ViewGroup) null);
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view form cache");
            }
            view2.setLayoutParams(layoutParams);
            this.holder.cover = (URLImageView) view2.findViewById(R.id.bat);
            this.holder.name = (TextView) view2.findViewById(R.id.bd5);
            this.holder.downloadBtn = (ProgressButton) view2.findViewById(R.id.f164944bd3);
            recycleView(this.panelType, view2);
            view2.setTag(this.holder);
            view = view2;
        }
        updateDownloadUI(this.holder);
        IPanelInteractionListener iPanelInteractionListener = this.interactionListener;
        if (iPanelInteractionListener != null && (panelTargetHeight = iPanelInteractionListener.getPanelTargetHeight() - ((int) this.mContext.getResources().getDimension(R.dimen.f158749nw))) != this.contentHight) {
            this.contentHight = panelTargetHeight;
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = this.contentHight;
                view.setLayoutParams(layoutParams2);
            }
        }
        return view;
    }
}
