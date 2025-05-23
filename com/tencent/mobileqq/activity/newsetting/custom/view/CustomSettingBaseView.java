package com.tencent.mobileqq.activity.newsetting.custom.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.newsetting.custom.group.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class CustomSettingBaseView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f183672d;

    /* renamed from: e, reason: collision with root package name */
    private QUIListItemAdapter f183673e;

    public CustomSettingBaseView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            h();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private Group[] d(Context context) {
        g(context);
        List<a> list = this.f183672d;
        if (list != null && !list.isEmpty()) {
            int size = this.f183672d.size();
            Group[] groupArr = new Group[size];
            for (int i3 = 0; i3 < size; i3++) {
                groupArr[i3] = this.f183672d.get(i3).d(this.f183673e);
            }
            return groupArr;
        }
        QLog.e("ChatSettingBaseView", 1, "[getListItemGroup] mGroupsList == null || mGroupsList.isEmpty().");
        return null;
    }

    private void h() {
        LayoutInflater.from(getContext()).inflate(f(), (ViewGroup) this, true);
        RecyclerView e16 = e(this);
        this.f183673e = new QUIListItemAdapter(c());
        e16.setVerticalScrollBarEnabled(false);
        e16.setPadding(0, 0, 0, 0);
        e16.setAdapter(this.f183673e);
        a(this);
        i();
    }

    private void i() {
        if (this.f183673e == null) {
            QLog.e("ChatSettingBaseView", 1, "[updateConfigItems] list item adapter should not be null.");
            return;
        }
        Group[] d16 = d(getContext());
        if (d16 != null && d16.length != 0) {
            this.f183673e.t0(d16);
        } else {
            QLog.e("ChatSettingBaseView", 1, "[updateConfigItems] listItemGroups == null || listItemGroups.length == 0.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T b(Class<T> cls) {
        String simpleName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cls);
        }
        List<a> list = this.f183672d;
        if (list != null && !list.isEmpty()) {
            Iterator<a> it = this.f183672d.iterator();
            while (it.hasNext()) {
                T t16 = (T) ((a) it.next());
                if (t16 == null) {
                    simpleName = null;
                } else {
                    simpleName = t16.getClass().getSimpleName();
                }
                if (TextUtils.equals(cls.getSimpleName(), simpleName)) {
                    return t16;
                }
            }
            return null;
        }
        QLog.e("ChatSettingBaseView", 1, "[findSettingGroup] mGroupsList == null || mGroupsList.isEmpty().");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QUIListItemStyle c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QUIListItemStyle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return QUIListItemStyle.Card;
    }

    protected abstract RecyclerView e(View view);

    protected abstract int f();

    /* JADX INFO: Access modifiers changed from: protected */
    public List<a> g(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        ArrayList arrayList = new ArrayList();
        this.f183672d = arrayList;
        return arrayList;
    }

    public CustomSettingBaseView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            h();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public CustomSettingBaseView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            h();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
