package com.tencent.mobileqq.aio.input.at.common.list.base;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class b<T> {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(@NonNull T t16, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(@NonNull T t16, int i3, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list);

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract RecyclerView.ViewHolder c(@NonNull ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@NonNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewHolder);
        }
    }
}
