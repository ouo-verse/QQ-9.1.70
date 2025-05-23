package com.tencent.qqnt.chathistory.ui.file.c2c;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes23.dex */
interface p {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static final class a implements p {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final RecyclerView f353663a;

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView.ViewHolder f353664b;

        /* renamed from: c, reason: collision with root package name */
        private int f353665c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(RecyclerView recyclerView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView);
            } else {
                this.f353663a = recyclerView;
                this.f353665c = -1;
            }
        }

        @Override // com.tencent.qqnt.chathistory.ui.file.c2c.p
        public RecyclerView.ViewHolder a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            if (this.f353665c != this.f353663a.getAdapter().getItemViewType(i3)) {
                this.f353665c = this.f353663a.getAdapter().getItemViewType(i3);
                this.f353664b = this.f353663a.getAdapter().createViewHolder((ViewGroup) this.f353663a.getParent(), this.f353665c);
            }
            return this.f353664b;
        }
    }

    RecyclerView.ViewHolder a(int i3);
}
