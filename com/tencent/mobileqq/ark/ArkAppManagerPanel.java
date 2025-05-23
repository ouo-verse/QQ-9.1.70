package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkMessageServerLogic;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public class ArkAppManagerPanel extends RelativeLayout implements View.OnClickListener, ViewPager.OnPageChangeListener, ArkMessageServerLogic.a {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f198855d;

    /* renamed from: e, reason: collision with root package name */
    private QQViewPager f198856e;

    /* renamed from: f, reason: collision with root package name */
    private EmoticonPagerRadioGroup f198857f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f198858h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f198859i;

    /* renamed from: m, reason: collision with root package name */
    private int f198860m;

    /* renamed from: com.tencent.mobileqq.ark.ArkAppManagerPanel$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ArkAppManagerPanel this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.getClass();
            throw null;
        }
    }

    public ArkAppManagerPanel(Context context) {
        super(context);
        this.f198860m = 0;
    }

    private void c(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f198860m = i3;
                    this.f198856e.setVisibility(8);
                    this.f198857f.setVisibility(8);
                    this.f198858h.setVisibility(8);
                    this.f198859i.setVisibility(0);
                    return;
                }
                return;
            }
            this.f198860m = i3;
            this.f198856e.setVisibility(0);
            this.f198857f.setVisibility(0);
            this.f198858h.setVisibility(8);
            this.f198859i.setVisibility(8);
            return;
        }
        this.f198860m = i3;
        this.f198856e.setVisibility(8);
        this.f198857f.setVisibility(8);
        this.f198858h.setVisibility(0);
        this.f198859i.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.ark.ArkMessageServerLogic.a
    public void a(final ArrayList<h> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size() - 7;
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
            h hVar = new h();
            hVar.f199497a = true;
            hVar.f199499c = null;
            hVar.f199500d = getResources().getString(R.string.c17);
            arrayList.add(hVar);
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.ArkAppManagerPanel.2
                @Override // java.lang.Runnable
                public void run() {
                    ArkAppManagerPanel.this.b(arrayList);
                }
            });
            return;
        }
        c(2);
    }

    public void b(ArrayList<h> arrayList) {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int i3 = this.f198860m;
        if (i3 == 1) {
            j jVar = (j) view.getTag();
            if (!TextUtils.isEmpty(jVar.f199502a)) {
                bi.c(this.f198855d, getContext(), "mqqapi://lightapp/open?app=" + jVar.f199502a).b();
                g.b(this.f198855d, jVar.f199502a, "ArkPanelAppIconClick", 1, 0, 0L, 0L, 0L, null, null);
            } else {
                Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", "https://ti.qq.com/ark/aioplus/index.html");
                getContext().startActivity(intent);
                g.b(this.f198855d, "com.tencent.ark.panel.more", "ArkPanelMoreIconClick", 1, 0, 0L, 0L, 0L, null, null);
            }
        } else if (i3 == 2) {
            c(0);
            ArkMessageServerLogic.a(this);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setPagerChangedListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f198857f.setPagerChangedListener(onPageChangeListener);
    }

    public ArkAppManagerPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f198860m = 0;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
