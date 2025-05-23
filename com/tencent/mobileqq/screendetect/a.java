package com.tencent.mobileqq.screendetect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.i;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private final LayoutInflater C;
    private ArrayList<ResultRecord> D;
    private long E;
    private RecyclerView F;
    private InterfaceC8526a G;

    /* renamed from: d, reason: collision with root package name */
    private int f282492d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f282493e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f282494f;

    /* renamed from: h, reason: collision with root package name */
    protected i f282495h;

    /* renamed from: i, reason: collision with root package name */
    private Hashtable<String, Bitmap> f282496i;

    /* renamed from: m, reason: collision with root package name */
    private final Context f282497m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.screendetect.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8526a {
        void onItemClick(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        b(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public RecentDynamicAvatarView f282499d;

        /* renamed from: e, reason: collision with root package name */
        public final TextView f282500e;

        /* renamed from: f, reason: collision with root package name */
        private InterfaceC8526a f282501f;

        public c(View view, InterfaceC8526a interfaceC8526a) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, view, interfaceC8526a);
                return;
            }
            this.f282499d = (RecentDynamicAvatarView) view.findViewById(R.id.icon);
            this.f282500e = (TextView) view.findViewById(R.id.nickname);
            this.f282501f = interfaceC8526a;
            view.setOnClickListener(this);
            view.setTag(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (this.f282501f != null && a.this.f282493e) {
                this.f282501f.onItemClick(view, getAdapterPosition() - 1);
            } else {
                InterfaceC8526a interfaceC8526a = this.f282501f;
                if (interfaceC8526a != null) {
                    interfaceC8526a.onItemClick(view, getAdapterPosition());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(Context context, QQAppInterface qQAppInterface, RecyclerView recyclerView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, recyclerView, Integer.valueOf(i3));
            return;
        }
        this.f282492d = -1;
        this.f282493e = true;
        this.f282496i = new Hashtable<>();
        this.E = 0L;
        this.f282497m = context;
        this.f282494f = qQAppInterface;
        this.F = recyclerView;
        this.C = LayoutInflater.from(context);
        this.D = new ArrayList<>();
        this.f282495h = new i(qQAppInterface, this, false);
        this.f282492d = i3;
        if (i3 == 1) {
            this.f282493e = false;
        }
    }

    private void q(c cVar, ResultRecord resultRecord, Drawable drawable) {
        int i3;
        if (drawable == null) {
            i iVar = this.f282495h;
            if (iVar != null) {
                drawable = iVar.e(resultRecord.type, resultRecord.uin);
            } else {
                drawable = null;
            }
        }
        Drawable drawable2 = drawable;
        if (s(resultRecord)) {
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotAdapter", 2, "bindview user:" + resultRecord.uin);
            }
            int intValue = ((Integer) i.n(this.f282494f, resultRecord.type, resultRecord.uin).first).intValue();
            boolean z16 = true;
            if (intValue == 103) {
                i3 = 1;
            } else {
                i3 = intValue;
            }
            RecentDynamicAvatarView recentDynamicAvatarView = cVar.f282499d;
            QQAppInterface qQAppInterface = this.f282494f;
            String str = resultRecord.uin;
            if (qQAppInterface.mAutomator.getInActionLoginB() != 1) {
                z16 = false;
            }
            recentDynamicAvatarView.setFaceDrawable(qQAppInterface, drawable2, i3, str, 100, false, z16, 0);
        } else {
            cVar.f282499d.setImageDrawable(drawable2);
        }
        cVar.f282500e.setText(resultRecord.name);
    }

    @Nullable
    private ResultRecord r(int i3) {
        if (i3 > 0 && this.f282493e) {
            return this.D.get(i3 - 1);
        }
        return this.D.get(i3);
    }

    private void v(c cVar, ResultRecord resultRecord, Drawable drawable) {
        if (cVar != null && resultRecord != null) {
            if (drawable == null) {
                drawable = this.f282495h.e(resultRecord.type, resultRecord.uin);
            }
            q(cVar, resultRecord, drawable);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (this.f282493e) {
            return this.D.size() + 1;
        }
        return this.D.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        if (i3 == 0 && this.f282493e) {
            return 0;
        }
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder, i3);
        } else if (viewHolder instanceof c) {
            q((c) viewHolder, r(i3), null);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
        }
        if (i3 == 0 && this.f282493e) {
            return new b(this.C.inflate(R.layout.cef, viewGroup, false));
        }
        return new c(this.C.inflate(R.layout.b1l, viewGroup, false), this.G);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        boolean z16;
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bitmap == null && i3 > 0) {
            return;
        }
        if (bitmap != null) {
            try {
                this.f282496i.put(i16 + ":" + str, bitmap);
            } catch (OutOfMemoryError e16) {
                System.gc();
                e16.printStackTrace();
                QLog.i("ScreenShotAdapter", 1, "onDecodeTaskCompleted error:" + e16.getMessage());
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.E;
        if (j3 > 0 && currentTimeMillis - j3 > 300) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 > 0 && !z16) {
            return;
        }
        synchronized (this.f282496i) {
            if (this.f282496i.size() == 0) {
                return;
            }
            if (i3 == 0) {
                this.E = 0L;
            } else {
                this.E = currentTimeMillis;
            }
            int childCount = this.F.getChildCount();
            boolean z17 = false;
            for (int i17 = 0; i17 < childCount; i17++) {
                RecyclerView.ViewHolder childViewHolder = this.F.getChildViewHolder(this.F.getChildAt(i17));
                if (childViewHolder instanceof c) {
                    c cVar = (c) childViewHolder;
                    ResultRecord r16 = r(cVar.getAdapterPosition());
                    if (r16 != null && (intValue = ((Integer) i.n(this.f282494f, r16.type, r16.uin).first).intValue()) != Integer.MIN_VALUE) {
                        Bitmap bitmap2 = this.f282496i.get(intValue + ":" + r16.uin);
                        if (bitmap2 != null) {
                            v(cVar, r16, new BitmapDrawable(this.f282497m.getResources(), bitmap2));
                            z17 = true;
                        }
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ScreenShotAdapter", 4, "decodecomplete|faceCache size = " + this.f282496i.size() + ", isNeedUpdateAvatar=" + z17);
            }
            this.f282496i.clear();
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        i iVar = this.f282495h;
        if (iVar != null) {
            iVar.r();
        }
    }

    protected boolean s(ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) resultRecord)).booleanValue();
        }
        int i3 = resultRecord.type;
        if (i3 != 0 && i3 != 1000 && i3 != 1004 && i3 != 1003 && i3 != 10004 && i3 != 1021 && i3 != 1022 && i3 != 1023 && i3 != 10008 && i3 != 10010) {
            return false;
        }
        return true;
    }

    public void t(List<ResultRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            return;
        }
        this.D.clear();
        this.D.addAll(list);
        notifyDataSetChanged();
    }

    public void u(InterfaceC8526a interfaceC8526a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) interfaceC8526a);
        } else {
            this.G = interfaceC8526a;
        }
    }
}
