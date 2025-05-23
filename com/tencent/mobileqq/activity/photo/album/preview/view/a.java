package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.richmediabrowser.view.recyclerview.DragView;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface a extends DragView.OnGestureChangeListener {
    void a();

    View b();

    View d();

    RelativeLayout.LayoutParams e();

    RelativeLayout.LayoutParams f();

    void g();

    void h();

    void k(int i3);

    void l(boolean z16);

    void onBackPressed();

    void p(View view);

    void q(CompoundButton compoundButton, boolean z16);

    void r();

    Class<? extends AbstractPhotoListActivity> s();
}
