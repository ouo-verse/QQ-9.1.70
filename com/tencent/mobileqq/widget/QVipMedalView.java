package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.BaseProfileDiamondWallComponent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QVipMedalView extends ViewGroup {

    /* renamed from: d, reason: collision with root package name */
    protected a f316122d;

    /* renamed from: e, reason: collision with root package name */
    protected int f316123e;

    /* renamed from: f, reason: collision with root package name */
    protected int f316124f;

    /* renamed from: h, reason: collision with root package name */
    protected List<ImageView> f316125h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f316126i;

    /* renamed from: m, reason: collision with root package name */
    private int f316127m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private MedalList f316128a;

        public int a() {
            MedalList medalList = this.f316128a;
            if (medalList != null) {
                return medalList.infoList.size();
            }
            return 0;
        }

        public int b(int i3) {
            MedalList medalList = this.f316128a;
            if (medalList != null && medalList.infoList.size() > i3) {
                return this.f316128a.infoList.get(i3).tipsTimes;
            }
            return 0;
        }

        public int c(int i3) {
            MedalList medalList = this.f316128a;
            if (medalList != null && medalList.infoList.size() > i3) {
                return this.f316128a.infoList.get(i3).type;
            }
            return 0;
        }

        public String d(int i3) {
            MedalList medalList = this.f316128a;
            if (medalList != null && medalList.infoList.size() > i3) {
                return this.f316128a.infoList.get(i3).value;
            }
            return null;
        }

        public int e(int i3) {
            MedalList medalList = this.f316128a;
            if (medalList != null && medalList.infoList.size() > i3) {
                return this.f316128a.infoList.get(i3).isRemind;
            }
            return 0;
        }

        public void f(MedalList medalList) {
            this.f316128a = medalList;
        }
    }

    public QVipMedalView(Context context) {
        this(context, null);
    }

    private void a(ImageView imageView, int i3, String str, int i16, int i17) {
        int i18;
        String str2;
        if (TextUtils.isEmpty(str)) {
            QLog.e("QVipSettingMe.QVipMedalView", 1, "bindData with null value!!");
            return;
        }
        FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(str).a();
        a16.setLoopCount(this.f316127m);
        a16.restart();
        imageView.setColorFilter(0);
        imageView.setImageDrawable(a16);
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            i18 = VipInfoHandler.J2(qQAppInterface, qQAppInterface.getCurrentUin(), false);
            str2 = qQAppInterface.getCurrentUin();
        } else {
            i18 = 98;
            str2 = "";
        }
        int i19 = i18;
        String str3 = str2;
        if (i16 != 0) {
            AnimatorHandler animatorHandler = new AnimatorHandler();
            Message obtain = Message.obtain();
            obtain.arg1 = 1;
            obtain.obj = imageView;
            obtain.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt(BaseProfileDiamondWallComponent.TIPS_TIMES, i17);
            obtain.setData(bundle);
            animatorHandler.removeMessages(obtain.what);
            animatorHandler.sendMessage(obtain);
            ReportController.o(qQAppInterface, "dc00898", "", str3, "0X800B2B3", "0X800B2B3", i19, 0, String.valueOf(i19), "", "", "");
            return;
        }
        ReportController.o(qQAppInterface, "dc00898", "", str3, "0X800B2B2", "0X800B2B2", i19, 0, String.valueOf(i19), "", "", "");
    }

    private void b() {
        a aVar = this.f316122d;
        if (aVar == null || aVar.a() == getChildCount()) {
            return;
        }
        AssertUtils.fail("consistency check failed ! adapter count=" + this.f316122d.a() + " view list size=" + this.f316125h.size() + " child count=" + getChildCount(), new Object[0]);
        int a16 = this.f316122d.a();
        removeAllViews();
        for (int i3 = 0; i3 < a16; i3++) {
            if (this.f316125h.size() > i3) {
                this.f316125h.get(i3).setImageDrawable(null);
            } else {
                this.f316125h.add(new ImageView(getContext()));
            }
            a(this.f316125h.get(i3), this.f316122d.c(i3), this.f316122d.d(i3), this.f316122d.e(i3), this.f316122d.b(i3));
            addView(this.f316125h.get(i3));
        }
    }

    protected void c() {
        this.f316123e = UIUtils.b(getContext(), 4.0f);
        this.f316125h = new ArrayList();
        setContentDescription(getContext().getResources().getString(R.string.f237587hg));
    }

    public void d(String str, int i3) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            ReportController.o(qQAppInterface, "dc00898", "", qQAppInterface.getCurrentUin(), str, str, i3, 0, String.valueOf(i3), "", "", "");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        a aVar = this.f316122d;
        if (aVar == null) {
            return;
        }
        int a16 = aVar.a();
        int paddingTop = getPaddingTop();
        int paddingBottom = i18 - getPaddingBottom();
        for (int i19 = 0; i19 < a16; i19++) {
            int paddingLeft = ((this.f316124f + this.f316123e) * i19) + getPaddingLeft();
            int i26 = this.f316124f + paddingLeft;
            if (i26 > i17 - i3) {
                if (i19 == 0) {
                    QLog.e("QVipMedalView", 1, "illegal size to layout the medal!! no one can layout");
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QVipMedalView", 1, "It only can layout " + i19 + "medal");
                    return;
                }
                return;
            }
            this.f316125h.get(i19).layout(paddingLeft, paddingTop, i26, paddingBottom);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.f316122d == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode2 == 1073741824) {
            this.f316124f = (size2 - getPaddingTop()) - getPaddingBottom();
        } else {
            int b16 = UIUtils.b(getContext(), 20.0f);
            this.f316124f = b16;
            size2 = b16 + getPaddingBottom() + getPaddingTop();
        }
        if (mode != 1073741824) {
            int a16 = this.f316122d.a();
            size = getPaddingRight() + (this.f316124f * a16) + ((a16 - 1) * this.f316123e) + getPaddingLeft();
        }
        int a17 = this.f316122d.a();
        b();
        for (int i17 = 0; i17 < a17; i17++) {
            this.f316125h.get(i17).measure(View.MeasureSpec.makeMeasureSpec(this.f316124f, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f316124f, 1073741824));
        }
        setMeasuredDimension(size, size2);
    }

    public void setAdapter(a aVar) {
        this.f316122d = aVar;
        removeAllViews();
        a aVar2 = this.f316122d;
        if (aVar2 != null) {
            int a16 = aVar2.a();
            for (int i3 = 0; i3 < a16; i3++) {
                if (this.f316125h.size() > i3) {
                    this.f316125h.get(i3).setImageDrawable(null);
                } else {
                    this.f316125h.add(new ImageView(getContext()));
                }
                a(this.f316125h.get(i3), this.f316122d.c(i3), this.f316122d.d(i3), this.f316122d.e(i3), this.f316122d.b(i3));
                addView(this.f316125h.get(i3));
            }
        }
        requestLayout();
    }

    public void setData(MedalList medalList) {
        if (this.f316122d == null) {
            this.f316122d = new a();
        }
        this.f316122d.f(medalList);
        setAdapter(this.f316122d);
    }

    public void setItemMargin(int i3) {
        this.f316123e = i3;
    }

    public void setItemWidth(int i3) {
        this.f316124f = i3;
    }

    public void setLoopCount(int i3) {
        this.f316127m = i3;
    }

    public QVipMedalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QVipMedalView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316126i = VasNormalToggle.VAS_BUG_111078711.isEnable(true);
        this.f316127m = Integer.MAX_VALUE;
        c();
    }
}
