package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.c;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Set;
import qb1.f;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileBaseTabView extends RelativeLayout implements a, f, c.a {
    boolean C;
    protected Runnable D;

    /* renamed from: d, reason: collision with root package name */
    public BaseFileAssistantActivity f206603d;

    /* renamed from: e, reason: collision with root package name */
    protected BaseQQAppInterface f206604e;

    /* renamed from: f, reason: collision with root package name */
    View f206605f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f206606h;

    /* renamed from: i, reason: collision with root package name */
    protected int f206607i;

    /* renamed from: m, reason: collision with root package name */
    private int f206608m;

    public QfileBaseTabView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(Runnable runnable) {
        o().runOnUiThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(int i3) {
        View inflate = ((LayoutInflater) this.f206603d.getSystemService("layout_inflater")).inflate(i3, (ViewGroup) null);
        this.f206605f = inflate;
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f206605f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        this.C = false;
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView.1
            @Override // java.lang.Runnable
            public void run() {
                QfileBaseTabView.this.C = true;
            }
        }, 2000L);
    }

    public void H() {
        if (this.D != null) {
            ThreadManager.getFileThreadHandler().removeCallbacks(this.D);
            this.D = null;
        }
    }

    @Override // qb1.f
    public boolean c() {
        if (this.D == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.widget.c.a
    public View getScrollableView() {
        return null;
    }

    public boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        o().I2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseFileAssistantActivity o() {
        return this.f206603d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (QLog.isColorLevel()) {
            QLog.i("QfileBaseTabView", 2, "onConfigurationChanged orientation[" + configuration.orientation + "]");
        }
        int i3 = configuration.orientation;
        if (i3 == this.f206608m) {
            return;
        }
        this.f206608m = i3;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onPause() {
        this.f206606h = false;
    }

    public int p() {
        return 0;
    }

    public ListView q() {
        return null;
    }

    public int r() {
        return this.f206607i;
    }

    public int[] s() {
        return null;
    }

    public void setEditbarButton(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        this.f206603d.H3(z16, z17, z18, z19, z26);
    }

    public void setExpandGroup(boolean z16) {
        this.f206606h = z16;
    }

    public void setFromWeiXin(boolean z16) {
        this.f206603d.M3(z16);
    }

    public void setSortType(int i3) {
        this.f206607i = i3;
    }

    protected boolean t() {
        return o().n3();
    }

    protected boolean u() {
        return o().p3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v() {
        if (!t() && !u()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w() {
        return this.C;
    }

    public boolean x(Set<FileInfo> set) {
        return false;
    }

    public QfileBaseTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QfileBaseTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f206606h = true;
        this.f206607i = -1;
        this.f206608m = 1;
        this.C = true;
        this.D = null;
        BaseFileAssistantActivity baseFileAssistantActivity = (BaseFileAssistantActivity) context;
        this.f206603d = baseFileAssistantActivity;
        this.f206604e = (BaseQQAppInterface) baseFileAssistantActivity.getAppRuntime();
        this.f206608m = getResources().getConfiguration().orientation;
    }

    public void A() {
    }

    public void B() {
    }

    public void C() {
    }

    public void D() {
    }

    public void b() {
    }

    public void e() {
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void f() {
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onRestart() {
    }

    public void onResume() {
    }

    public void y() {
    }

    public void z() {
    }

    @Override // qb1.f
    public void d(FileInfo fileInfo) {
    }

    public void h(FileManagerEntity fileManagerEntity) {
    }

    public void i(ArrayList<FileManagerEntity> arrayList) {
    }

    public void l(ArrayList<FileManagerEntity> arrayList) {
    }

    public void m(ArrayList<WeiYunFileInfo> arrayList) {
    }

    public void n(Set<FileInfo> set) {
    }

    public void setSelect(int i3) {
    }

    public void setPos(int i3, int i16) {
    }
}
