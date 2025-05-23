package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends SimpleFilePresenter implements FileBrowserModelBase.c {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f208523d;

        a(String str) {
            this.f208523d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent();
            intent.setClass(b.this.f208461f, QQBrowserActivity.class);
            intent.putExtra("url", this.f208523d);
            b.this.f208461f.startActivity(intent);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.presenter.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class ViewOnClickListenerC7577b implements View.OnClickListener {
        ViewOnClickListenerC7577b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.f208460e.y0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f208526d;

        c(String str) {
            this.f208526d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent();
            intent.setClass(b.this.f208461f, QQBrowserActivity.class);
            intent.putExtra("url", this.f208526d);
            b.this.f208461f.startActivity(intent);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void I() {
        super.I();
        if (this.f208460e.T() == 2) {
            this.G.e(HardCodeUtil.qqStr(R.string.jey), new ViewOnClickListenerC7577b());
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = apk simple");
        }
        String string = BaseApplication.getContext().getString(R.string.beq);
        this.G.M(string, true);
        this.G.m0(false);
        if (this.f208460e.u() != 0 && this.f208460e.u() != 4 && !TextUtils.isEmpty(this.f208460e.v())) {
            this.G.M(string, false);
            if (!TextUtils.isEmpty(this.f208460e.t())) {
                this.G.d0(true, this.f208460e.v(), 0, new a(this.f208460e.t()));
            } else {
                this.G.d0(true, this.f208460e.v(), 0, null);
            }
        }
        this.G.U(R.drawable.e98);
        this.G.T(this.f208460e.s());
        this.f208460e.M0(this);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.c
    public void h(int i3, String str, String str2, Bundle bundle) {
        if (i3 != 0 && i3 != 4 && !TextUtils.isEmpty(str)) {
            this.G.M(BaseApplication.getContext().getString(R.string.beq), false);
            if (!TextUtils.isEmpty(str2)) {
                this.G.d0(true, str, 0, new c(str2));
            } else {
                this.G.d0(true, str, 0, null);
            }
        }
    }
}
