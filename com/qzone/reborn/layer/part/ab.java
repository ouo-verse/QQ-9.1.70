package com.qzone.reborn.layer.part;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicLoadState;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import java.text.DecimalFormat;
import java.util.Objects;
import rk.QZoneLayerPicOriginState;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ab extends ap implements View.OnClickListener {
    private View G;
    private TextView H;
    private View I;
    private final Observer<RFWLayerPicLoadState> J = new a();
    private final LruCache<String, Boolean> K = new LruCache<>(50);
    private uk.g L;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private class a implements Observer<RFWLayerPicLoadState> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(RFWLayerPicLoadState rFWLayerPicLoadState) {
            ab abVar = ab.this;
            if (abVar.mCurrentSelectedItem == null || abVar.G == null || ab.this.I == null || !Objects.equals(rFWLayerPicLoadState.getPicId(), ab.this.mCurrentSelectedItem.getLayerPicInfo().getPicId())) {
                return;
            }
            ab.this.G.setVisibility(0);
            if (ab.this.mCurrentSelectedItem.getLayerPicInfo().getOriginPicInfo() == null || !rFWLayerPicLoadState.getSelectedPicInfo().getUrl().equals(ab.this.mCurrentSelectedItem.getLayerPicInfo().getOriginPicInfo().getUrl())) {
                ab.this.X9(false, rFWLayerPicLoadState.getPicId());
                ab abVar2 = ab.this;
                abVar2.W9(abVar2.mCurrentSelectedItem);
                return;
            }
            if (!rFWLayerPicLoadState.getPicLoadState().isFinishSuccess() && !ab.this.K.snapshot().containsKey(rFWLayerPicLoadState.getPicId())) {
                if (!rFWLayerPicLoadState.getPicLoadState().isRunning()) {
                    ab.this.X9(false, rFWLayerPicLoadState.getPicId());
                    return;
                } else {
                    if (ab.this.I.getVisibility() != 0) {
                        ab.this.H.setText("\u6b63\u5728\u52a0\u8f7d...");
                        ab.this.H.setVisibility(0);
                        ab.this.X9(false, rFWLayerPicLoadState.getPicId());
                        return;
                    }
                    return;
                }
            }
            if (ab.this.B9() != null) {
                ab.this.B9().v2();
            }
            ab.this.K.put(rFWLayerPicLoadState.getPicId(), Boolean.TRUE);
            ab.this.X9(true, rFWLayerPicLoadState.getPicId());
            ab.this.H.setVisibility(8);
        }
    }

    private void V9() {
        if (this.G == null) {
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && rFWLayerItemMediaInfo.getLayerPicInfo() != null && this.mCurrentSelectedItem.getLayerPicInfo().getOriginPicInfo() != null && !TextUtils.isEmpty(this.mCurrentSelectedItem.getLayerPicInfo().getOriginPicInfo().getUrl())) {
            S9();
            this.mCurrentSelectedItem.getLayerPicInfo().setCurrentPicInfo(this.mCurrentSelectedItem.getLayerPicInfo().getOriginPicInfo());
            if (this.mLayerViewModel.mRichMediaInfo.getValue() != null) {
                this.mLayerViewModel.mRichMediaInfo.getValue().setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
                MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = this.mLayerViewModel.mRichMediaInfo;
                mutableLiveData.setValue(mutableLiveData.getValue());
                return;
            }
            return;
        }
        this.G.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9(boolean z16, String str) {
        View view = this.I;
        if (view == null) {
            return;
        }
        view.setVisibility(z16 ? 0 : 8);
        QZoneLayerPicOriginState qZoneLayerPicOriginState = new QZoneLayerPicOriginState(str, z16);
        uk.g gVar = this.L;
        if (gVar != null) {
            gVar.N1(qZoneLayerPicOriginState);
        }
    }

    protected void S9() {
        if (B9() == null) {
            return;
        }
        B9().N2();
    }

    protected void T9() {
        if (B9() == null) {
            return;
        }
        B9().j9();
    }

    protected boolean U9() {
        return F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        View view;
        super.handleBroadcastMessage(str, obj);
        if (!TextUtils.equals(str, "HIDE_ORIGINAL_PIC_BUTTON") || (view = this.G) == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mCurrentSelectedItem != null && view.getId() == R.id.n8s) {
            V9();
            RFWLog.d(getLogTag(), RFWLog.USR, "origin_btn click");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        this.L = (uk.g) getViewModel(uk.g.class);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.cfn, (ViewGroup) null);
        this.G = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.n8s);
        this.H = textView;
        textView.setOnClickListener(this);
        this.I = this.G.findViewById(R.id.n8r);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = ImmersiveUtils.dpToPx(160.0f);
        ((ViewGroup) view).addView(this.G, layoutParams);
        if (AppSetting.f99565y) {
            View findViewById = this.G.findViewById(R.id.mhp);
            AccessibilityUtil.n(findViewById, true);
            findViewById.setAccessibilityTraversalAfter(R.id.mnu);
            findViewById.setAccessibilityTraversalBefore(R.id.n0g);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        super.onLayerStateUpdate(rFWLayerState);
        if (U9()) {
            this.G.setVisibility(8);
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && rFWLayerItemMediaInfo.getLayerPicInfo() != null && !TextUtils.isEmpty(this.mCurrentSelectedItem.getLayerPicInfo().getPicId())) {
            RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerPicLoadState.class, this.mCurrentSelectedItem.getLayerPicInfo().getPicId(), this.J);
        } else {
            RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerPicLoadState.class, "", this.J);
            this.G.setVisibility(8);
        }
    }

    public static String R9(long j3) {
        long j16 = j3 / 1024;
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        if (j16 <= 1024) {
            return j16 + "K";
        }
        float f16 = ((float) j16) / 1024.0f;
        if (f16 > 1024.0f) {
            return decimalFormat.format(f16 / 1024.0f) + "G";
        }
        return decimalFormat.format(f16) + "M";
    }

    public void W9(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        if (rFWLayerItemMediaInfo != null && rFWLayerItemMediaInfo.getLayerPicInfo() != null && rFWLayerItemMediaInfo.getLayerPicInfo().getOriginPicInfo() != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo.getLayerPicInfo().getOriginPicInfo().getUrl())) {
            this.G.setVisibility(0);
            if (this.mCurrentSelectedItem.getLayerPicInfo().getOriginPicInfo().getSize() > 0) {
                T9();
                String R9 = R9(this.mCurrentSelectedItem.getLayerPicInfo().getOriginPicInfo().getSize());
                RFWLog.i(getLogTag(), RFWLog.CLR, "photo info origin size " + R9);
                this.H.setText(HardCodeUtil.qqStr(R.string.rhm));
                this.H.setVisibility(0);
                return;
            }
            RFWLog.i(getLogTag(), RFWLog.USR, "photo info origin size is zero");
            this.H.setVisibility(8);
            return;
        }
        this.G.setVisibility(8);
    }
}
