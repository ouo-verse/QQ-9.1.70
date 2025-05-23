package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class BaseEmotionAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_ = null;
    public static final int BIG_EMOTION_CONTENT_HIGHT = 72;
    public static final int BIG_EMOTION_IMG_HEIGHT = 56;
    public static final String TAG;
    protected IEmoticonMainPanelApp app;
    protected EmoticonCallback callback;
    protected int columnNum;
    protected EmotionPanelInfo curPanelInfo;
    protected EmotionPanelListView currentView;
    protected List<EmotionPanelData> data;
    protected List<EmotionPanelData> dataHasWhiteFace;
    protected List<EmotionPanelData> dataNoWhiteFace;
    protected float density;
    protected int emoticonTextColor;
    protected int emotionType;
    public boolean ignoreUIToken;
    protected Context mContext;
    protected int panelType;
    protected Map<Integer, ArrayList<View>> recycleViewMap;
    protected int widthPixels;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class ViewHolder {
        static IPatchRedirector $redirector_;

        public ViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32565);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            TAG = BaseAdapter.class.getSimpleName();
        }
    }

    public BaseEmotionAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback);
            return;
        }
        this.ignoreUIToken = false;
        this.data = Collections.emptyList();
        this.dataNoWhiteFace = new ArrayList();
        this.dataHasWhiteFace = new ArrayList();
        this.app = iEmoticonMainPanelApp;
        this.mContext = context;
        this.columnNum = i3;
        this.panelType = i16;
        this.emotionType = i17;
        this.callback = emoticonCallback;
        this.recycleViewMap = new ConcurrentHashMap();
        this.emoticonTextColor = this.mContext.getResources().getColor(R.color.f157877a40);
        this.density = this.mContext.getResources().getDisplayMetrics().density;
    }

    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "destory");
        }
        if (this.recycleViewMap.size() > 0) {
            for (Map.Entry<Integer, ArrayList<View>> entry : this.recycleViewMap.entrySet()) {
                int intValue = entry.getKey().intValue();
                ArrayList<View> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    for (int i3 = 0; i3 < value.size(); i3++) {
                        View view = value.get(i3);
                        if (view.getParent() != null) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        }
                        view.setTag(null);
                        if (view instanceof EmoticonPanelLinearLayout) {
                            ((EmoticonPanelLinearLayout) view).setCallBack(null);
                        }
                        if (EmotionPanelViewPool.widthPixels == ((Integer) view.getTag(R.id.f915255e)).intValue()) {
                            EmotionPanelViewPool.getInstance().release(intValue, view);
                        }
                    }
                }
            }
        }
        this.recycleViewMap.clear();
        this.currentView = null;
        if (this.callback != null) {
            this.callback = null;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        List<EmotionPanelData> list = this.data;
        if (list != null) {
            int size = list.size();
            int i3 = this.columnNum;
            int i16 = size / i3;
            if (size % i3 > 0) {
                return i16 + 1;
            }
            return i16;
        }
        QLog.e(TAG, 1, "get count len = 0");
        return 0;
    }

    public EmotionPanelListView getCurrentListView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EmotionPanelListView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.currentView;
    }

    public EmoticonPackage getEmoticonPackage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return null;
    }

    public abstract View getEmotionView(ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View emotionView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            emotionView = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (view == null) {
                viewHolder = newHolder();
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            emotionView = getEmotionView(viewHolder, i3, view, viewGroup);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return emotionView;
    }

    public abstract ViewHolder newHolder();

    public void onAdapterSelected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public void onAdapterUnselected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    public void onScrollStateChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
    }

    public void recycleView(int i3, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) view);
            return;
        }
        if (view == null) {
            return;
        }
        view.setTag(R.id.f915255e, Integer.valueOf(this.widthPixels));
        ArrayList<View> arrayList = this.recycleViewMap.get(Integer.valueOf(i3));
        if (arrayList == null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            arrayList2.add(view);
            this.recycleViewMap.put(Integer.valueOf(i3), arrayList2);
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public void refreshPanelData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public void setCurrentListView(EmotionPanelListView emotionPanelListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) emotionPanelListView);
        } else {
            this.currentView = emotionPanelListView;
        }
    }

    public void setData(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.data = list;
            super.notifyDataSetChanged();
        }
    }

    public void setWidthPixels(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.widthPixels = i3;
        }
    }
}
