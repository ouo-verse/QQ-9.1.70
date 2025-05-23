package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.util.ar;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import qzone.QZIntimateSpaceMedal$MedalInfo;

/* loaded from: classes37.dex */
public class QZoneIntimateBadgePoolAnimView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public Context f57682d;

    /* renamed from: e, reason: collision with root package name */
    private final r f57683e;

    /* renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList<QZIntimateSpaceMedal$MedalInfo> f57684f;

    public QZoneIntimateBadgePoolAnimView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3, List<QZIntimateSpaceMedal$MedalInfo> list, boolean z16, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z16) {
            f();
            j();
            this.f57684f.clear();
        }
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        d(list);
        this.f57684f.addAll(list);
        i();
        int l3 = (int) (ar.l() * 0.13f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l3, l3);
        layoutParams.gravity = i3;
        Iterator<QZIntimateSpaceMedal$MedalInfo> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                QZIntimateSpaceMedal$MedalInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.icon.get())) {
                    boolean z17 = !TextUtils.isEmpty(str) && TextUtils.equals(str, next.f430331id.get());
                    if (QLog.isColorLevel()) {
                        QLog.d("QZoneIntimateBadgePoolAnimView", 2, "[addView] iconUrl = " + next.icon.get() + ", id = " + next.f430331id.get() + ", needHorizontalCenter = " + z17);
                    }
                    ImageView imageView = new ImageView(getContext());
                    imageView.setTag(R.id.n4r, Boolean.valueOf(z17));
                    imageView.setTag(R.id.n4d, next.f430331id.get());
                    com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(next.icon.get()).setTargetView(imageView).setRequestWidth(l3).setRequestHeight(l3).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans));
                    addView(imageView, layoutParams);
                }
            } else {
                QLog.d("QZoneIntimateBadgePoolAnimView", 1, "[addViewInMainHandler] size = " + list.size() + ", cosTime = " + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
        }
    }

    private void d(List<QZIntimateSpaceMedal$MedalInfo> list) {
        if (this.f57684f.isEmpty() || RFSafeListUtils.isEmpty(list)) {
            return;
        }
        Iterator<QZIntimateSpaceMedal$MedalInfo> it = this.f57684f.iterator();
        while (it.hasNext()) {
            QZIntimateSpaceMedal$MedalInfo next = it.next();
            if (next != null) {
                for (QZIntimateSpaceMedal$MedalInfo qZIntimateSpaceMedal$MedalInfo : list) {
                    if (TextUtils.equals(qZIntimateSpaceMedal$MedalInfo.f430331id.get(), next.f430331id.get())) {
                        QLog.d("QZoneIntimateBadgePoolAnimView", 1, "[filterRepeatedMedalInfo] repeated medal id = " + qZIntimateSpaceMedal$MedalInfo.f430331id.get() + ", addedUrl = " + next.icon.get() + ", newUrl = " + qZIntimateSpaceMedal$MedalInfo.icon.get());
                        g(next.f430331id.get());
                    }
                }
            }
        }
    }

    public void b(final int i3, final List<QZIntimateSpaceMedal$MedalInfo> list, final boolean z16, final String str) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.intimate.widget.QZoneIntimateBadgePoolAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneIntimateBadgePoolAnimView.this.c(i3, list, z16, str);
            }
        });
    }

    public r e() {
        return this.f57683e;
    }

    public void h() {
        r rVar = this.f57683e;
        if (rVar != null) {
            rVar.p();
        }
    }

    public void i() {
        r rVar = this.f57683e;
        if (rVar != null) {
            rVar.l();
        }
    }

    public void j() {
        r rVar = this.f57683e;
        if (rVar != null) {
            rVar.m();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f57683e.i(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f57683e.j(z16);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f57683e.k(i3, i16);
    }

    public QZoneIntimateBadgePoolAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void f() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            this.f57683e.d(getChildAt(i3));
        }
        removeAllViews();
    }

    private void g(String str) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && TextUtils.equals((String) childAt.getTag(R.id.n4d), str)) {
                QLog.d("QZoneIntimateBadgePoolAnimView", 1, "[removeSpecifiedViewWithId] medalId = " + str);
                this.f57683e.d(childAt);
                removeViewAt(i3);
                return;
            }
        }
    }

    public QZoneIntimateBadgePoolAnimView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f57684f = new CopyOnWriteArrayList<>();
        setWillNotDraw(false);
        this.f57682d = context;
        this.f57683e = new r(context, this);
    }
}
