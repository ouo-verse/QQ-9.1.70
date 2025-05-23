package com.tencent.mobileqq.resourcesgrab;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.resourcesgrab.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinEngine;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends com.tencent.mobileqq.mvvm.c<com.tencent.mobileqq.resourcesgrab.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    static ViewModelProvider.Factory f281280m;

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.mobileqq.resourcesgrab.strategy.c[] f281281i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements b.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.resourcesgrab.b.e
        public void a(HashSet<String> hashSet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                d.this.U1(hashSet);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashSet);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            }
            return new d(new com.tencent.mobileqq.resourcesgrab.b());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74684);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f281280m = new b();
        }
    }

    d(com.tencent.mobileqq.resourcesgrab.b bVar) {
        super(bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f281281i = new com.tencent.mobileqq.resourcesgrab.strategy.c[]{new com.tencent.mobileqq.resourcesgrab.strategy.a(), new com.tencent.mobileqq.resourcesgrab.strategy.b(), new com.tencent.mobileqq.resourcesgrab.strategy.d()};
            bVar.o();
        }
    }

    private List<c> N1(List<c> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            HashSet hashSet = new HashSet();
            for (c cVar : list) {
                if (!hashSet.contains(cVar.f281277b.mFileName)) {
                    arrayList.add(cVar);
                }
                hashSet.add(cVar.f281277b.mFileName);
            }
        }
        return arrayList;
    }

    private View.OnClickListener O1(View view) {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            Object invoke = declaredMethod.invoke(view, new Object[0]);
            Field declaredField = invoke.getClass().getDeclaredField("mOnClickListener");
            declaredField.setAccessible(true);
            return (View.OnClickListener) declaredField.get(invoke);
        } catch (Throwable th5) {
            QLog.d("ResourceGrabViewModel", 1, th5, new Object[0]);
            return null;
        }
    }

    private void P1(View view, List<c> list) {
        List<c> b16;
        Q1(view.getBackground(), list, 0);
        for (com.tencent.mobileqq.resourcesgrab.strategy.c cVar : this.f281281i) {
            if (cVar != null && (b16 = cVar.b(view)) != null && b16.size() > 0) {
                list.addAll(b16);
            }
        }
    }

    private void Q1(Drawable drawable, List<c> list, int i3) {
        if (drawable != null && drawable.getConstantState() != null && list != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof BaseConstantState) {
                list.add(new c(i3, ((BaseConstantState) constantState).skinData));
                if (QLog.isColorLevel()) {
                    QLog.d("ResourceGrabViewModel", 2, "getFileNameByConstantState BaseConstantState resourceNames -> " + list);
                    return;
                }
                return;
            }
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                if (QLog.isColorLevel()) {
                    QLog.d("ResourceGrabViewModel", 2, "getFileNameByConstantState DrawableContainerState");
                }
                for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (drawable2 != null) {
                        Q1(drawable2, list, i3);
                    }
                }
            }
        }
    }

    private void S1(View view, View.OnClickListener onClickListener) {
        if (onClickListener instanceof e) {
            if (QLog.isColorLevel()) {
                QLog.d("ResourceGrabViewModel", 2, "recovery onClick listener");
            }
            e eVar = (e) onClickListener;
            view.setOnClickListener(eVar.f281283d);
            view.setClickable(eVar.f281284e);
        }
    }

    private void T1(View view, List<c> list, View.OnClickListener onClickListener) {
        if (!(onClickListener instanceof e)) {
            if (QLog.isColorLevel()) {
                QLog.d("ResourceGrabViewModel", 2, "doReplace onClick listener");
            }
            view.setOnClickListener(new e(list, onClickListener, view.isClickable()));
            view.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(HashSet<String> hashSet) {
        try {
            ArrayList<FileInfo> arrayList = new ArrayList<>();
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                arrayList.add(new FileInfo(it.next()));
            }
            ((DataLineHandler) BaseActivity.sTopActivity.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).sendFiles(arrayList);
        } catch (Exception e16) {
            QLog.d("ResourceGrabViewModel", 2, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String M1(List<c> list) {
        List<c> N1 = N1(list);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("rootPath: ");
        sb5.append(SkinEngine.getInstances().getSkinRootPath());
        sb5.append("\n");
        int size = N1.size();
        for (int i3 = 0; i3 < size; i3++) {
            c cVar = N1.get(i3);
            if (cVar != null) {
                sb5.append(((com.tencent.mobileqq.resourcesgrab.b) this.mRepository).n(cVar.f281276a));
                sb5.append(":");
                sb5.append(cVar.f281277b.mFileName);
                if (i3 != size - 1) {
                    sb5.append("\n");
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ResourceGrabViewModel", 2, sb5.toString());
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R1(View view, boolean z16) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                R1(viewGroup.getChildAt(i3), z16);
            }
        }
        try {
            ArrayList arrayList = new ArrayList();
            P1(view, arrayList);
            if (arrayList.isEmpty()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ResourceGrabViewModel", 2, "doReplaceOnclickListener success fileName: " + arrayList + ", view: " + view);
            }
            View.OnClickListener O1 = O1(view);
            if (!z16) {
                S1(view, O1);
            } else {
                T1(view, arrayList, O1);
            }
        } catch (Throwable th5) {
            QLog.d("ResourceGrabViewModel", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W1(List<c> list) {
        ((com.tencent.mobileqq.resourcesgrab.b) this.mRepository).u(list, new a());
    }
}
