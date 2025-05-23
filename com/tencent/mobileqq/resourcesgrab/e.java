package com.tencent.mobileqq.resourcesgrab;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    View.OnClickListener f281283d;

    /* renamed from: e, reason: collision with root package name */
    boolean f281284e;

    /* renamed from: f, reason: collision with root package name */
    private List<c> f281285f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<c> list, View.OnClickListener onClickListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, onClickListener, Boolean.valueOf(z16));
            return;
        }
        this.f281285f = list;
        this.f281283d = onClickListener;
        this.f281284e = z16;
    }

    private void a(View view, BaseActivity baseActivity, List<c> list) {
        if (view instanceof ViewGroup) {
            Rect rect = new Rect();
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i3);
                    childAt.getGlobalVisibleRect(rect);
                    if (rect.contains(baseActivity.clickX, baseActivity.clickY)) {
                        List<c> c16 = c(childAt);
                        if (c16.size() > 0) {
                            list.addAll(c16);
                        }
                        a(childAt, baseActivity, list);
                        return;
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private void b(View view, List<c> list, Rect rect) {
        if (view.getParent() != null) {
            View view2 = (View) view.getParent();
            Rect rect2 = new Rect();
            view2.getGlobalVisibleRect(rect2);
            if (rect2.left - rect.left <= 20 && rect2.top - rect.top <= 20 && rect2.right - rect.right <= 20 && rect2.bottom - rect.bottom <= 20) {
                List<c> c16 = c(view2);
                if (c16.size() > 0) {
                    list.addAll(c16);
                }
                b(view2, list, rect);
            }
        }
    }

    private List<c> c(View view) {
        List<c> list;
        ArrayList arrayList = new ArrayList();
        try {
            Method declaredMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            Object invoke = declaredMethod.invoke(view, new Object[0]);
            Field declaredField = invoke.getClass().getDeclaredField("mOnClickListener");
            declaredField.setAccessible(true);
            View.OnClickListener onClickListener = (View.OnClickListener) declaredField.get(invoke);
            if ((onClickListener instanceof e) && (list = ((e) onClickListener).f281285f) != null && list.size() > 0) {
                arrayList.addAll(list);
            }
        } catch (Exception e16) {
            QLog.d("ResourceNameOnClickListener", 1, e16, new Object[0]);
        }
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ResourceNameOnClickListener", 2, "ResourceNameOnClickListener onLongClick");
            }
            if (view.getContext() instanceof Activity) {
                activity = (Activity) view.getContext();
            } else {
                activity = null;
            }
            if (activity == null) {
                activity = BaseActivity.sTopActivity;
            }
            if (activity instanceof BaseActivity) {
                Fragment findFragmentByTag = ((BaseActivity) activity).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
                if (findFragmentByTag instanceof ResourceGrabFragment) {
                    ResourceGrabFragment resourceGrabFragment = (ResourceGrabFragment) findFragmentByTag;
                    d dVar = (d) h.b(resourceGrabFragment, d.f281280m).get(d.class);
                    ArrayList arrayList = new ArrayList(this.f281285f);
                    try {
                        a(view, (BaseActivity) activity, arrayList);
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        b(view, arrayList, rect);
                    } catch (Exception e16) {
                        QLog.d("ResourceNameOnClickListener", 1, e16, new Object[0]);
                    }
                    resourceGrabFragment.xh(arrayList);
                    if (resourceGrabFragment.vh()) {
                        dVar.W1(arrayList);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
