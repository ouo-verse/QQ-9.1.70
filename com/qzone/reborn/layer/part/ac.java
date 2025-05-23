package com.qzone.reborn.layer.part;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ac extends ap implements View.OnClickListener {
    public static final HashSet<String> J = new HashSet<>();
    private View G;
    private TextView H;
    private View I;

    private void N9() {
        J.add(this.mCurrentSelectedItem.getLayerVideoInfo().getPlayId());
        this.mCurrentSelectedItem.getLayerVideoInfo().setCurrentVideoUrl(this.mCurrentSelectedItem.getLayerVideoInfo().getVideoOriginUrl());
        if (this.mLayerViewModel.mRichMediaInfo.getValue() != null) {
            this.mLayerViewModel.mRichMediaInfo.getValue().setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
            MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = this.mLayerViewModel.mRichMediaInfo;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
    }

    protected boolean M9() {
        return F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "HIDE_ORIGINAL_PIC_BUTTON")) {
            this.G.setVisibility(8);
            this.I.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mCurrentSelectedItem != null && view.getId() == R.id.n8u) {
            N9();
            RFWLog.d(getLogTag(), RFWLog.USR, "origin_video_btn click");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.cfo, (ViewGroup) null);
        this.G = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.n8u);
        this.H = textView;
        textView.setOnClickListener(this);
        this.I = this.G.findViewById(R.id.n8t);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = ImmersiveUtils.dpToPx(160.0f);
        ((ViewGroup) view).addView(this.G, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        super.onLayerStateUpdate(rFWLayerState);
        if (M9()) {
            this.G.setVisibility(8);
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && rFWLayerItemMediaInfo.getLayerVideoInfo() != null && !TextUtils.isEmpty(this.mCurrentSelectedItem.getLayerVideoInfo().getVideoOriginUrl())) {
            this.G.setVisibility(0);
            if (!J.contains(this.mCurrentSelectedItem.getLayerVideoInfo().getPlayId())) {
                this.H.setVisibility(0);
                this.I.setVisibility(8);
                return;
            } else {
                this.H.setVisibility(8);
                this.I.setVisibility(0);
                return;
            }
        }
        this.G.setVisibility(8);
    }
}
