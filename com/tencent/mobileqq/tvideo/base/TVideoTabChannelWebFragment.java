package com.tencent.mobileqq.tvideo.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.tvideo.event.TVideoMultiTabPageBackEvent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import tvideo.TVideoChannelList$VideoChannelData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoTabChannelWebFragment extends QPublicBaseFragment implements SimpleEventReceiver {
    private WebViewFragment C;

    public static TVideoTabChannelWebFragment ph(String str) {
        TVideoTabChannelWebFragment tVideoTabChannelWebFragment = new TVideoTabChannelWebFragment();
        Intent intent = new Intent();
        intent.putExtra("url", str).putExtra("startOpenPageTime", System.currentTimeMillis());
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        tVideoTabChannelWebFragment.setArguments(bundle);
        return tVideoTabChannelWebFragment;
    }

    private void qh(@NonNull View view, TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData) {
        view.findViewById(R.id.jtx).setBackgroundColor(Color.parseColor(tVideoChannelList$VideoChannelData.channel_theme_co1or.get()));
    }

    private boolean rh() {
        WebViewFragment webViewFragment = this.C;
        if (webViewFragment != null && webViewFragment.getWebView() != null && this.C.getWebView().canGoBack()) {
            QLog.d("TVideoTabChannelWebFragment", 1, " doOnBackEvent ");
            this.C.doOnBackEvent();
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<Class>() { // from class: com.tencent.mobileqq.tvideo.base.TVideoTabChannelWebFragment.1
            {
                add(TVideoMultiTabPageBackEvent.class);
            }
        };
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        TVideoWebFragment tVideoWebFragment = new TVideoWebFragment();
        this.C = tVideoWebFragment;
        tVideoWebFragment.setArguments(getArguments());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.cks, this.C);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ghf, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof TVideoMultiTabPageBackEvent) || !isResumed() || getActivity() == null || rh()) {
            return;
        }
        gy2.c.u(false, false);
        getActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        TVideoChannelList$VideoChannelData c16 = ox2.b.e().c();
        if (c16 != null && !TextUtils.isEmpty(c16.channel_theme_co1or.get())) {
            try {
                qh(view, c16);
            } catch (Exception e16) {
                QLog.d("TVideoTabChannelWebFragment", 1, " setTopViewBackGround Exception = " + e16);
            }
        }
    }
}
