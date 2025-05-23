package com.tencent.mobileqq.zplan.friend.changerole.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipsLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zplan.friend.e;
import wh3.d;

/* loaded from: classes34.dex */
public class ZPlaneFriendSelectListView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f333701d;

    /* renamed from: e, reason: collision with root package name */
    private IndexBarTipsLayout f333702e;

    /* renamed from: f, reason: collision with root package name */
    private IndexBar f333703f;

    /* renamed from: h, reason: collision with root package name */
    private View f333704h;

    /* renamed from: i, reason: collision with root package name */
    private d f333705i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.zplan.friend.changerole.model.a f333706m;

    public ZPlaneFriendSelectListView(Context context) {
        super(context);
        g();
    }

    private void g() {
        this.f333704h = LayoutInflater.from(getContext()).inflate(R.layout.dce, (ViewGroup) this, true);
        this.f333701d = (RecyclerView) findViewById(R.id.pw8);
        this.f333702e = (IndexBarTipsLayout) findViewById(R.id.q1s);
        this.f333703f = (IndexBar) findViewById(R.id.q1t);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Integer num) {
        this.f333705i.w0(num.intValue());
    }

    public void setLiveDataAndObserverData(LifecycleOwner lifecycleOwner, com.tencent.mobileqq.zplan.friend.changerole.model.a aVar, e eVar) {
        this.f333706m = aVar;
        if (this.f333705i == null) {
            d dVar = new d(aVar, eVar);
            this.f333705i = dVar;
            this.f333701d.setAdapter(dVar);
            this.f333701d.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f333701d.addItemDecoration(new com.tencent.mobileqq.zplan.friend.changerole.view.itemview.a());
            this.f333701d.setItemAnimator(null);
            aVar.T1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.friend.changerole.view.widget.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZPlaneFriendSelectListView.this.h((Integer) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements IndexBar.a {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
        public void p1(String str, int i3, float f16) {
            int o06;
            ZPlaneFriendSelectListView.this.f333702e.setText(str, f16);
            if (ZPlaneFriendSelectListView.this.f333705i == null || (o06 = ZPlaneFriendSelectListView.this.f333705i.o0(str)) < 0) {
                return;
            }
            ZPlaneFriendSelectListView.this.f333701d.scrollToPosition(o06);
        }

        @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
        public void m(boolean z16) {
            if (z16) {
                ZPlaneFriendSelectListView.this.f333702e.setVisibility(0);
            } else {
                ZPlaneFriendSelectListView.this.f333702e.setVisibility(4);
            }
            if (z16) {
                return;
            }
            ZPlaneFriendSelectListView.this.f333703f.setChooseIndex(-1);
        }
    }

    public ZPlaneFriendSelectListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    private void f() {
        this.f333703f.setLetters(new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.f333703f.setOnIndexBarTouchListener(new a());
    }

    public ZPlaneFriendSelectListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        g();
    }
}
