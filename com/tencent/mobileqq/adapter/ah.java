package com.tencent.mobileqq.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mqq.os.MqqHandler;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ah extends BaseAdapter implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private XListView C;
    private View D;
    private View E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f187098d;

    /* renamed from: e, reason: collision with root package name */
    private SigCommentListActivity f187099e;

    /* renamed from: f, reason: collision with root package name */
    private LayoutInflater f187100f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<SignatureManager.SigCommentInfo> f187101h;

    /* renamed from: i, reason: collision with root package name */
    public int f187102i;

    /* renamed from: m, reason: collision with root package name */
    private SignatureManager f187103m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f187104a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ImageView f187105a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f187106b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f187107c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f187108d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f187109e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ah(SigCommentListActivity sigCommentListActivity, QQAppInterface qQAppInterface, XListView xListView, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sigCommentListActivity, qQAppInterface, xListView, view);
            return;
        }
        this.f187101h = new ArrayList<>();
        this.f187102i = -1;
        this.f187103m = null;
        this.f187099e = sigCommentListActivity;
        this.f187100f = LayoutInflater.from(sigCommentListActivity);
        this.C = xListView;
        this.f187098d = qQAppInterface;
        this.f187103m = (SignatureManager) qQAppInterface.getManager(QQManagerFactory.SIGNATURE_MANAGER);
        this.D = view;
    }

    private void c(String str, TextView textView) {
        SignatureManager signatureManager;
        RichStatus k3;
        if (!TextUtils.isEmpty(str) && (signatureManager = (SignatureManager) this.f187098d.getManager(QQManagerFactory.SIGNATURE_MANAGER)) != null && (k3 = signatureManager.k(str)) != null) {
            StringBuilder sb5 = new StringBuilder();
            if (!TextUtils.isEmpty(k3.actionText)) {
                sb5.append(k3.actionText);
                if (!TextUtils.isEmpty(k3.dataText)) {
                    sb5.append(k3.dataText);
                }
                sb5.append(TokenParser.SP);
            }
            if (!TextUtils.isEmpty(k3.getPlainText())) {
                sb5.append(k3.getPlainText());
            }
            textView.setText(sb5.toString());
        }
    }

    public List<SignatureManager.SigCommentInfo> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f187101h.size() == 0) {
            return null;
        }
        return (ArrayList) this.f187101h.clone();
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SignatureManager.SigCommentInfo getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SignatureManager.SigCommentInfo) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        ArrayList<SignatureManager.SigCommentInfo> arrayList = this.f187101h;
        if (arrayList != null && i3 >= 0 && i3 < arrayList.size()) {
            return this.f187101h.get(i3);
        }
        return null;
    }

    public void d(List<SignatureManager.SigCommentInfo> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16));
            return;
        }
        if (list != this.f187101h) {
            this.f187101h = (ArrayList) list;
        }
        this.F = z16;
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        View view = this.E;
        if (view != null) {
            ((a) view.getTag()).f187104a.setText(i3);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        ArrayList<SignatureManager.SigCommentInfo> arrayList = this.f187101h;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3 + (1 ^ (this.F ? 1 : 0));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        ArrayList<SignatureManager.SigCommentInfo> arrayList = this.f187101h;
        if (arrayList != null && arrayList.size() != 0) {
            if (i3 == this.f187101h.size()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            view2 = view;
            view = (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            int itemViewType = getItemViewType(i3);
            if (itemViewType == 0) {
                this.D.setLayoutParams(new AbsListView.LayoutParams(this.C.getWidth(), this.C.getHeight()));
                view = this.D;
            } else if (1 == itemViewType) {
                if (view == null) {
                    view = this.f187100f.inflate(R.layout.bz9, (ViewGroup) this.C, false);
                    bVar = new b();
                    bVar.f187105a = (ImageView) view.findViewById(R.id.iv9);
                    bVar.f187106b = (TextView) view.findViewById(R.id.iv_);
                    bVar.f187107c = (ImageView) view.findViewById(R.id.iv7);
                    bVar.f187108d = (TextView) view.findViewById(R.id.iv8);
                    bVar.f187109e = (TextView) view.findViewById(R.id.iva);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                SignatureManager.SigCommentInfo item = getItem(i3);
                if (item != null) {
                    String valueOf = String.valueOf(item.uin);
                    FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.f187098d, 1, valueOf);
                    if (faceDrawable != null) {
                        bVar.f187105a.setImageDrawable(faceDrawable);
                    }
                    bVar.f187106b.setText(com.tencent.mobileqq.utils.ac.H(this.f187098d, valueOf));
                    bVar.f187107c.setBackgroundResource(R.drawable.skin_card_icon_zan_sel);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(item.time * 1000);
                    int i16 = calendar.get(9);
                    String format = new SimpleDateFormat("hh:mm").format(new Date(item.time * 1000));
                    if (i16 == 0) {
                        str = HardCodeUtil.qqStr(R.string.tin) + format;
                    } else {
                        str = HardCodeUtil.qqStr(R.string.tik) + format;
                    }
                    bVar.f187108d.setText(str);
                    c(item.feedsid, bVar.f187109e);
                }
            } else if (2 == itemViewType) {
                if (view == null) {
                    View inflate = this.f187100f.inflate(R.layout.bfd, (ViewGroup) this.C, false);
                    inflate.setOnClickListener(this);
                    a aVar = new a();
                    inflate.setTag(aVar);
                    inflate.findViewById(R.id.eex).setVisibility(8);
                    aVar.f187104a = (TextView) inflate.findViewById(R.id.f0v);
                    this.E = inflate;
                }
                view = this.E;
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MqqHandler handler;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else if (this.E == view && (handler = this.f187098d.getHandler(SigCommentListActivity.class)) != null) {
            handler.sendMessageDelayed(handler.obtainMessage(0, 1, 0), 200L);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
