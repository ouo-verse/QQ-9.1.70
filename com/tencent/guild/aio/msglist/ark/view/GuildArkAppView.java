package com.tencent.guild.aio.msglist.ark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.aio.BaseArkAppView;
import com.tencent.guild.aio.msglist.ark.ArkAppLoadLayout;
import com.tencent.guild.api.ark.IArkEnvironmentApi;
import com.tencent.guild.api.ark.IArkMultiProcApi;
import com.tencent.guild.api.ark.IGuildArkApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildArkAppView extends BaseArkAppView {

    /* renamed from: d, reason: collision with root package name */
    public ArkAppLoadLayout f111235d;

    /* renamed from: e, reason: collision with root package name */
    private String f111236e;

    /* renamed from: f, reason: collision with root package name */
    private MsgRecord f111237f;

    /* renamed from: h, reason: collision with root package name */
    private String f111238h;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArkViewModel f111239d;

        a(ArkViewModel arkViewModel) {
            this.f111239d = arkViewModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ArkViewModel arkViewModel = this.f111239d;
            if (arkViewModel != null) {
                arkViewModel.reinitArkContainer();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface c {
    }

    public GuildArkAppView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((IArkMultiProcApi) QRoute.api(IArkMultiProcApi.class)).initArkEnv();
        setOnTouchListener(this);
        VideoReport.setElementId(this, "em_click_ark");
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
    }

    @NonNull
    private Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", this.f111238h);
        hashMap.put("sgrp_channel_id", this.f111237f.getGuildId());
        hashMap.put("sgrp_sub_channel_id", this.f111237f.getChannelId());
        hashMap.put("sgrp_share_ark_source", 3);
        return hashMap;
    }

    private void f() {
        int i3;
        int i16;
        ArkViewModel viewModel = this.mViewImpl.getViewModel();
        if (viewModel != null) {
            if (viewModel instanceof tp0.a) {
                ArkViewModelBase.Size d16 = ((tp0.a) viewModel).d();
                if (d16 == null || (i16 = d16.height) <= 0) {
                    i16 = 0;
                }
                if (d16 == null || (i3 = d16.width) <= 0) {
                    i3 = 0;
                }
            } else {
                i3 = 0;
                i16 = 0;
            }
            ArkViewModelBase.Size containerHintSize = viewModel.getContainerHintSize();
            if (i16 <= 0) {
                i16 = (int) (containerHintSize.height * this.mViewImpl.mScale);
            }
            if (i3 <= 0) {
                i3 = (int) (containerHintSize.width * this.mViewImpl.mScale);
            }
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (i16 <= 0) {
            i16 = x.a(352.0f);
        }
        if (i3 <= 0) {
            i3 = ((IGuildArkApi) QRoute.api(IGuildArkApi.class)).getMaxWidth();
        }
        int a16 = x.a(8.0f);
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement.mBorderType == 2 && i3 > a16) {
            int i17 = a16 / 2;
            i3 -= i17;
            if (arkViewImplement.mAlignLeft) {
                ArkAppLoadLayout arkAppLoadLayout = this.f111235d;
                arkAppLoadLayout.setPadding(i17, arkAppLoadLayout.getPaddingTop(), this.f111235d.getPaddingRight(), this.f111235d.getPaddingBottom());
            } else {
                ArkAppLoadLayout arkAppLoadLayout2 = this.f111235d;
                arkAppLoadLayout2.setPadding(arkAppLoadLayout2.getPaddingLeft(), this.f111235d.getPaddingTop(), i17, this.f111235d.getPaddingBottom());
            }
        }
        ViewGroup.LayoutParams layoutParams = this.f111235d.getLayoutParams();
        layoutParams.height = i16;
        layoutParams.width = i3;
        if (QLog.isColorLevel()) {
            QLog.i(ArkTextureView.TAG, 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", this, Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    private void g(View view, int i3) {
        View findViewById;
        RelativeLayout relativeLayout = (RelativeLayout) view.getParent();
        if (relativeLayout != null && (findViewById = relativeLayout.findViewById(R.id.f164453yc)) != null) {
            findViewById.setVisibility(i3);
        }
    }

    public String d() {
        return this.f111236e;
    }

    public void e(tp0.a aVar, ArkAppLoadLayout arkAppLoadLayout, boolean z16) {
        if (aVar == null) {
            return;
        }
        this.f111235d = arkAppLoadLayout;
        if (arkAppLoadLayout != null) {
            arkAppLoadLayout.setArkView(this.mViewImpl);
        }
        this.mOnStartTemporaryDetach = aVar.isGpuRenderingEnabled();
        super.initArkView(aVar, z16);
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadFailed(String str, int i3, boolean z16) {
        int i16;
        if (this.f111235d == null) {
            return;
        }
        ArkViewModel viewModel = this.mViewImpl.getViewModel();
        if (viewModel != null && viewModel.GetAppScriptType() == 2 && !((IArkEnvironmentApi) QRoute.api(IArkEnvironmentApi.class)).isJSCLibExist()) {
            QLog.i(ArkTextureView.TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
            onLoading();
            return;
        }
        ArkAppLoadLayout arkAppLoadLayout = this.f111235d;
        if (z16) {
            arkAppLoadLayout.setOnClickListener(new a(viewModel));
        } else {
            arkAppLoadLayout.setOnClickListener(null);
        }
        f();
        setVisibility(8);
        arkAppLoadLayout.setVisibility(0);
        View findViewById = arkAppLoadLayout.findViewById(R.id.loading);
        View findViewById2 = arkAppLoadLayout.findViewById(R.id.i5h);
        g(arkAppLoadLayout, 0);
        requestLayout();
        if (findViewById != null) {
            findViewById.setVisibility(4);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
            TextView textView = (TextView) findViewById2.findViewById(R.id.i5p);
            if (textView != null) {
                if (str == null) {
                    textView.setText(getResources().getString(R.string.f170470s5));
                } else {
                    textView.setText(str);
                }
            }
            View findViewById3 = findViewById2.findViewById(R.id.i5l);
            if (findViewById3 != null) {
                if (z16) {
                    i16 = R.drawable.c_j;
                } else {
                    i16 = R.drawable.c_i;
                }
                findViewById3.setBackgroundDrawable(findViewById3.getResources().getDrawable(i16));
            }
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadSuccess() {
        super.onLoadSuccess();
        ArkAppLoadLayout arkAppLoadLayout = this.f111235d;
        if (arkAppLoadLayout != null) {
            arkAppLoadLayout.setVisibility(8);
            g(arkAppLoadLayout, 8);
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoading() {
        setVisibility(8);
        ArkAppLoadLayout arkAppLoadLayout = this.f111235d;
        if (arkAppLoadLayout == null) {
            return;
        }
        f();
        arkAppLoadLayout.setVisibility(0);
        View findViewById = arkAppLoadLayout.findViewById(R.id.loading);
        View findViewById2 = arkAppLoadLayout.findViewById(R.id.i5h);
        g(arkAppLoadLayout, 0);
        requestLayout();
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(4);
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            VideoReport.reportEvent("ev_sgrp_app_text_aio_channnel_ark_clk", c());
        }
        return super.onTouch(view, motionEvent);
    }

    public void setDataReportPgId(String str) {
        this.f111238h = "pg_sgrp_aio";
        if (str != null && str.equals(qn0.a.class.getName())) {
            this.f111238h = "pg_sgrp_sticky_post_info";
        }
    }

    public void setMsgRecord(MsgRecord msgRecord) {
        this.f111237f = msgRecord;
    }

    public void setViewKey(String str) {
        this.f111236e = str;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onFirstPaint() {
    }

    public void setCallback(b bVar) {
    }

    public void setOnVisibleChangeListener(c cVar) {
    }
}
