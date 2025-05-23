package com.tencent.biz.richframework.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class MultiTabViewPager extends ViewPagerCompat {
    public MultiTabViewPager(Context context) {
        super(context);
        clearGutterSize(this);
    }

    public static void clearGutterSize(ViewPager viewPager) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mDefaultGutterSize");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, 0);
            viewPager.requestLayout();
        } catch (Exception e16) {
            QLog.e("QCircleFolderTabViewPag", 1, "clearGutterSize:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public boolean canScroll(View view, boolean z16, int i3, int i16, int i17) {
        if (view != this && (view instanceof MultiPicViewPager) && ((MultiPicViewPager) view).isMultiPic()) {
            return true;
        }
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if ((recyclerView.getLayoutManager() instanceof LinearLayoutManager) && recyclerView.getLayoutManager().canScrollHorizontally()) {
                return true;
            }
        }
        return super.canScroll(view, z16, i3, i16, i17);
    }

    DataSetObserver getViewPagerObserver(ViewPager viewPager) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mObserver");
            declaredField.setAccessible(true);
            return (DataSetObserver) declaredField.get(viewPager);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat, androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter adapter = getAdapter();
        if (adapter != null) {
            setViewPagerObserver(adapter, null);
        }
        super.setAdapter(pagerAdapter);
        setViewPagerObserver(pagerAdapter, getViewPagerObserver(this));
    }

    void setViewPagerObserver(PagerAdapter pagerAdapter, DataSetObserver dataSetObserver) {
        try {
            Method declaredMethod = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", DataSetObserver.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(pagerAdapter, dataSetObserver);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public MultiTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        clearGutterSize(this);
    }
}
