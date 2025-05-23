package com.tencent.mobileqq.guild.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class QQGuildNameBaseFragment extends QQGuildTitleBarFragment {
    protected int T = 1;
    protected int U = 16;
    protected QUISingleLineInputView V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQGuildNameBaseFragment.this.onBackEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CharSequence d16 = QQGuildNameBaseFragment.this.V.d();
            if (d16 != null) {
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_complete_btn", "clck", new HashMap());
                QQGuildNameBaseFragment.this.Gh(d16.toString().trim());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    protected abstract String Dh();

    protected abstract String Eh();

    protected void Fh() {
        this.V.setContentText(Eh());
        CharSequence d16 = this.V.d();
        if (d16 != null) {
            this.V.setTextSelection(d16.length());
        }
        setRightButtonEnable(true);
    }

    protected abstract void Gh(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        QUISingleLineInputView qUISingleLineInputView = (QUISingleLineInputView) this.P.findViewById(R.id.wjt);
        this.V = qUISingleLineInputView;
        qUISingleLineInputView.setMaxWordCount(this.U);
        if (!TextUtils.isEmpty(Dh())) {
            this.V.setHint(Dh());
        }
        setLeftButton(R.string.f140850f3, new a());
        setTitle(getTitle());
        setRightButton(R.string.f143340lt, new b());
        if (!TextUtils.isEmpty(Eh())) {
            Fh();
        } else if (this.T > 0) {
            setRightButtonEnable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f0u;
    }

    protected abstract String getTitle();
}
