package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes12.dex */
public class SystemEmoticonPanel extends RelativeLayout {
    static IPatchRedirector $redirector_;
    protected Context context;
    private DispatchKeyEventListener mDispatchKeyEventListener;
    protected boolean mIsHighDifinition;
    protected EmoticonPagerAdapter pageAdapter;
    protected EmoticonPagerRadioGroup pageRadioGroup;
    protected View root;
    protected ViewPager viewPager;

    /* loaded from: classes12.dex */
    public interface DispatchKeyEventListener {
        boolean dispatchKeyEvent(KeyEvent keyEvent);
    }

    public SystemEmoticonPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mIsHighDifinition = false;
            this.context = context;
        }
    }

    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        EmoticonPagerAdapter emoticonPagerAdapter = this.pageAdapter;
        if (emoticonPagerAdapter != null) {
            emoticonPagerAdapter.destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) keyEvent)).booleanValue();
        }
        DispatchKeyEventListener dispatchKeyEventListener = this.mDispatchKeyEventListener;
        if (dispatchKeyEventListener != null && dispatchKeyEventListener.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    protected int getLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return R.layout.hrm;
    }

    protected void initUI(Context context, EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) emoticonCallback);
            return;
        }
        this.pageRadioGroup = (EmoticonPagerRadioGroup) this.root.findViewById(R.id.f166754hv2);
        ViewPager viewPager = (ViewPager) this.root.findViewById(R.id.viewPager);
        this.viewPager = viewPager;
        this.pageRadioGroup.setViewPager(viewPager);
        this.pageAdapter = new EmoticonPagerAdapter();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new SystemEmoticonPanelViewBinder(context, emoticonCallback, 0));
        this.pageAdapter.setViewBinderList(arrayList);
        this.viewPager.setAdapter(this.pageAdapter);
        this.viewPager.setCurrentItem(0);
        this.pageRadioGroup.synButton(this.pageAdapter.getF373114d());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (action == 1 || action == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } catch (Exception e16) {
            QLog.e("SystemEmoticonPanel", 1, "onInterceptTouchEvent failed", e16);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCallBack(EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonCallback);
        } else {
            initUI(this.context, emoticonCallback);
        }
    }

    public void setDispatchKeyEventListener(DispatchKeyEventListener dispatchKeyEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dispatchKeyEventListener);
        } else {
            this.mDispatchKeyEventListener = dispatchKeyEventListener;
        }
    }

    public SystemEmoticonPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mIsHighDifinition = false;
            this.context = context;
        }
    }

    public SystemEmoticonPanel(Context context, EmoticonCallback emoticonCallback) {
        this(context, emoticonCallback, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) emoticonCallback);
    }

    public SystemEmoticonPanel(Context context, EmoticonCallback emoticonCallback, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, emoticonCallback, Boolean.valueOf(z16));
            return;
        }
        this.mIsHighDifinition = false;
        if (Build.VERSION.SDK_INT < 24) {
            try {
                Field declaredField = Class.forName("android.view.LayoutInflater").getDeclaredField("sConstructorMap");
                declaredField.setAccessible(true);
                ((HashMap) declaredField.get(LayoutInflater.from(context))).remove("androidx.viewpager.widget.ViewPager");
            } catch (ClassNotFoundException e16) {
                QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", e16);
            } catch (IllegalAccessException e17) {
                QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", e17);
            } catch (NoSuchFieldException e18) {
                QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", e18);
            }
        }
        this.root = LayoutInflater.from(context).inflate(getLayoutId(), this);
        this.mIsHighDifinition = z16;
        initUI(context, emoticonCallback);
    }
}
