package com.tencent.mobileqq.minigame.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RecommendItemAdapter extends BaseAdapter {
    private final List<MiniAppInfo> dataList;
    private boolean isLandscape;

    /* renamed from: ls, reason: collision with root package name */
    private final OnRecommendItemClickListener f246830ls;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface OnRecommendItemClickListener {
        void onClick(MiniAppInfo miniAppInfo);

        void onExposure(MiniAppInfo miniAppInfo);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class RecommendItemHolder {
        public ImageView ivGameIcon;
        public TextView tvGameDesc;
        public TextView tvGameName;

        RecommendItemHolder(View view) {
            this.ivGameIcon = (ImageView) view.findViewById(R.id.y3l);
            this.tvGameName = (TextView) view.findViewById(R.id.k8b);
            this.tvGameDesc = (TextView) view.findViewById(R.id.f108166cd);
        }
    }

    public RecommendItemAdapter(List<MiniAppInfo> list, OnRecommendItemClickListener onRecommendItemClickListener) {
        ArrayList arrayList = new ArrayList();
        this.dataList = arrayList;
        arrayList.clear();
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f246830ls = onRecommendItemClickListener;
    }

    public static String getGameDesc(MiniAppInfo miniAppInfo) {
        String str;
        if (miniAppInfo.friendNum > 0) {
            return miniAppInfo.friendNum + "\u4e2a\u597d\u53cb\u5728\u73a9";
        }
        int i3 = miniAppInfo.userNum;
        if (i3 >= 10000) {
            str = (miniAppInfo.userNum / 10000) + "\u4e07";
        } else if (i3 > 0) {
            str = miniAppInfo.userNum + "";
        } else {
            str = "1";
        }
        return str + "\u4eba\u5728\u73a9";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getView$0(MiniAppInfo miniAppInfo, View view) {
        this.f246830ls.onClick(miniAppInfo);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.dataList.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        RecommendItemHolder recommendItemHolder;
        final MiniAppInfo miniAppInfo = (MiniAppInfo) getItem(i3);
        if (view == null) {
            view = View.inflate(BaseApplication.getContext(), R.layout.fid, null);
            recommendItemHolder = new RecommendItemHolder(view);
            view.setTag(recommendItemHolder);
        } else {
            recommendItemHolder = (RecommendItemHolder) view.getTag();
        }
        recommendItemHolder.ivGameIcon.setImageDrawable(MiniAppUtils.getIcon(BaseApplication.getContext(), miniAppInfo.iconUrl, true));
        recommendItemHolder.tvGameName.setText(miniAppInfo.name);
        recommendItemHolder.tvGameDesc.setText(getGameDesc(miniAppInfo));
        recommendItemHolder.tvGameName.setTextSize(1, this.isLandscape ? 12.0f : 14.0f);
        recommendItemHolder.tvGameDesc.setTextSize(1, this.isLandscape ? 8.5f : 10.0f);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RecommendItemAdapter.this.lambda$getView$0(miniAppInfo, view2);
            }
        });
        this.f246830ls.onExposure(miniAppInfo);
        return view;
    }

    public void setData(List<MiniAppInfo> list) {
        this.dataList.clear();
        if (list != null) {
            this.dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setIsLandscape(boolean z16) {
        this.isLandscape = z16;
    }
}
