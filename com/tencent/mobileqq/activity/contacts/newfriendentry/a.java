package com.tencent.mobileqq.activity.contacts.newfriendentry;

import android.graphics.Rect;
import android.graphics.drawable.PaintDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.msg.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends RecyclerView.Adapter<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f181652d;

    /* renamed from: e, reason: collision with root package name */
    private List<Object> f181653e;

    /* renamed from: f, reason: collision with root package name */
    private int f181654f;

    /* renamed from: h, reason: collision with root package name */
    PaintDrawable f181655h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contacts.newfriendentry.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7156a extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f181656d;

        public C7156a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f181656d = i3;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            } else {
                rect.right = this.f181656d;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public FixSizeImageView f181657d;

        /* renamed from: e, reason: collision with root package name */
        public FixSizeImageView f181658e;

        public b(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
            } else {
                this.f181657d = (FixSizeImageView) view.findViewById(R.id.head);
                this.f181658e = (FixSizeImageView) view.findViewById(R.id.enc);
            }
        }
    }

    public a(QQAppInterface qQAppInterface, List<Object> list, PaintDrawable paintDrawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, list, paintDrawable, Integer.valueOf(i3));
            return;
        }
        this.f181653e = new ArrayList();
        this.f181652d = qQAppInterface;
        if (list != null) {
            this.f181653e = list;
        }
        this.f181655h = paintDrawable;
        this.f181654f = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        List<Object> list = this.f181653e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void p(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
            return;
        }
        if (obj != null) {
            int size = this.f181653e.size();
            int i3 = this.f181654f;
            if (size == i3) {
                this.f181653e.remove(i3 - 1);
                notifyItemRemoved(this.f181654f - 1);
            }
            this.f181653e.add(0, obj);
            notifyItemInserted(0);
            int size2 = this.f181653e.size();
            int i16 = this.f181654f;
            if (size2 == i16) {
                notifyItemChanged(i16 - 1);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar, i3);
        } else {
            List<Object> list = this.f181653e;
            if (list != null && list.size() > 0) {
                Object obj = this.f181653e.get(i3);
                if (obj instanceof c) {
                    bVar.f181657d.setImageDrawable(FaceDrawable.getFaceDrawable(this.f181652d, 1, ((c) obj).e()));
                } else if (obj instanceof PhoneContact) {
                    bVar.f181657d.setImageDrawable(FaceDrawable.getFaceDrawable(this.f181652d, 11, ((PhoneContact) obj).unifiedCode));
                } else if (obj instanceof com.tencent.mobileqq.newfriend.msg.b) {
                    bVar.f181657d.setImageDrawable(FaceDrawable.getFaceDrawable(this.f181652d, 11, ((com.tencent.mobileqq.newfriend.msg.b) obj).f254021d.unifiedCode));
                }
                if (this.f181655h != null) {
                    if (i3 == this.f181654f - 1) {
                        bVar.f181658e.setVisibility(0);
                        bVar.f181658e.setBackgroundDrawable(this.f181655h);
                    } else {
                        bVar.f181658e.setVisibility(8);
                    }
                }
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(bVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup, i3);
        }
        return new b(LayoutInflater.from(this.f181652d.getApp()).inflate(R.layout.apj, (ViewGroup) null));
    }

    public void s(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
        } else {
            this.f181652d = qQAppInterface;
        }
    }

    public void t(List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            this.f181653e.clear();
            int size = list.size();
            int i3 = this.f181654f;
            if (size > i3) {
                this.f181653e.addAll(list.subList(0, i3));
            } else {
                this.f181653e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }
}
