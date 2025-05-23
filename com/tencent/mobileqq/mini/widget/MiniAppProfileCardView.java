package com.tencent.mobileqq.mini.widget;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.mobileqq.minigame.report.ProfileCardReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes33.dex */
public class MiniAppProfileCardView extends BaseMiniAppProfileCardView {
    private static final String TAG = "MiniAppProfileCardView";
    private ColorStateList attrValue;
    private int colorInt;
    private boolean isTheme;
    protected HorzionAdapter mAdapter;
    private Context mContext;
    private boolean mIsOwner;
    protected LayoutInflater mLayoutInflater;
    protected HorizontalListView mListView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class HorzionAdapter extends BaseAdapter {
        private ArrayList<MiniAppInfo> miniAppInfoItems;
        private final Map<String, String> reportedMap = new HashMap();

        HorzionAdapter() {
        }

        private void reportExpo(final MiniAppInfo miniAppInfo) {
            if (this.reportedMap.get(miniAppInfo.appId) != null) {
                return;
            }
            Map<String, String> map = this.reportedMap;
            String str = miniAppInfo.appId;
            map.put(str, str);
            final int i3 = MiniAppProfileCardView.this.mIsOwner ? 2062 : LaunchScene.LAUNCH_SCENE_PROFILE_GUEST_CARD;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.widget.MiniAppProfileCardView.HorzionAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    ProfileCardReporter.reportMiniGameProfile(new MiniAppConfig(miniAppInfo), i3, "expo");
                }
            }, 64, null, true);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<MiniAppInfo> arrayList = this.miniAppInfoItems;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            ArrayList<MiniAppInfo> arrayList = this.miniAppInfoItems;
            if (arrayList != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            MiniAppProfileCardItemView miniAppProfileCardItemView;
            ArrayList<MiniAppInfo> arrayList = this.miniAppInfoItems;
            if (arrayList != null && arrayList.size() >= 1) {
                MiniAppInfo miniAppInfo = this.miniAppInfoItems.get(i3);
                if (view instanceof MiniAppProfileCardItemView) {
                    miniAppProfileCardItemView = (MiniAppProfileCardItemView) view;
                } else {
                    view = new MiniAppProfileCardItemView(MiniAppProfileCardView.this.mContext, null);
                    miniAppProfileCardItemView = view;
                }
                miniAppProfileCardItemView.setProfileType(MiniAppProfileCardView.this.mIsOwner);
                miniAppProfileCardItemView.setData(miniAppInfo, i3, new onItemClickListener() { // from class: com.tencent.mobileqq.mini.widget.MiniAppProfileCardView.HorzionAdapter.1
                    @Override // com.tencent.mobileqq.mini.widget.MiniAppProfileCardView.onItemClickListener
                    public void onItemClick(final int i16) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.widget.MiniAppProfileCardView.HorzionAdapter.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str;
                                if (HorzionAdapter.this.miniAppInfoItems != null && HorzionAdapter.this.miniAppInfoItems.size() >= 1 && i16 < HorzionAdapter.this.miniAppInfoItems.size()) {
                                    HorzionAdapter.this.miniAppInfoItems.add(0, (MiniAppInfo) HorzionAdapter.this.miniAppInfoItems.remove(i16));
                                    HorzionAdapter.this.notifyDataSetChanged();
                                    return;
                                }
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("onItemClick: positon: ");
                                sb5.append(i16);
                                sb5.append(" ,");
                                if (HorzionAdapter.this.miniAppInfoItems == null) {
                                    str = "miniAppInfoItems is null";
                                } else {
                                    str = "miniAppInfoItems.size(): " + HorzionAdapter.this.miniAppInfoItems.size();
                                }
                                sb5.append(str);
                                QLog.e(MiniAppProfileCardView.TAG, 1, sb5.toString());
                            }
                        });
                    }
                });
                reportExpo(miniAppInfo);
                if (MiniAppProfileCardView.this.isTheme) {
                    if (MiniAppProfileCardView.this.attrValue != null) {
                        miniAppProfileCardItemView.setTextColor(MiniAppProfileCardView.this.attrValue);
                    } else {
                        miniAppProfileCardItemView.setTextColor(MiniAppProfileCardView.this.colorInt);
                    }
                }
            }
            return view;
        }

        public void setData(ArrayList<MiniAppInfo> arrayList) {
            this.miniAppInfoItems = arrayList;
        }
    }

    /* loaded from: classes33.dex */
    public interface onItemClickListener {
        void onItemClick(int i3);
    }

    public MiniAppProfileCardView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.mLayoutInflater = from;
        from.inflate(R.layout.cbm, (ViewGroup) this, true);
        this.mListView = (HorizontalListView) findViewById(R.id.m0n);
        HorzionAdapter horzionAdapter = new HorzionAdapter();
        this.mAdapter = horzionAdapter;
        this.mListView.setAdapter((ListAdapter) horzionAdapter);
        this.mListView.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView
    public void setData(List<INTERFACE$StApiAppInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<MiniAppInfo> arrayList = new ArrayList<>();
        Iterator<INTERFACE$StApiAppInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(MiniAppInfo.from(it.next()));
        }
        setData(arrayList);
    }

    @Override // com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView
    public void setProfileType(boolean z16) {
        this.mIsOwner = z16;
    }

    @Override // com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView
    public void setTextColor(ColorStateList colorStateList) {
        this.isTheme = true;
        this.attrValue = colorStateList;
    }

    @Override // com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView
    public HorizontalListView getListView() {
        return this.mListView;
    }

    public MiniAppProfileCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @Override // com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView
    public void setTextColor(int i3) {
        this.isTheme = true;
        this.colorInt = i3;
    }

    public MiniAppProfileCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }

    public void setData(ArrayList<MiniAppInfo> arrayList) {
        HorzionAdapter horzionAdapter = this.mAdapter;
        if (horzionAdapter != null) {
            horzionAdapter.setData(arrayList);
        }
    }
}
