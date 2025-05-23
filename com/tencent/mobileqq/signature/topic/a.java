package com.tencent.mobileqq.signature.topic;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.inject.ISignatureStatusManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f288444d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f288445e;

    /* renamed from: f, reason: collision with root package name */
    private XListView f288446f;

    /* renamed from: h, reason: collision with root package name */
    private List<ISignatureStatusManager.TopicInfo> f288447h;

    /* renamed from: i, reason: collision with root package name */
    private List<ISignatureStatusManager.TopicInfo> f288448i;

    /* renamed from: m, reason: collision with root package name */
    private b f288449m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.signature.topic.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class ViewOnClickListenerC8598a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISignatureStatusManager.TopicInfo f288450d;

        ViewOnClickListenerC8598a(ISignatureStatusManager.TopicInfo topicInfo) {
            this.f288450d = topicInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) topicInfo);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (a.this.f288449m != null) {
                    a.this.f288449m.rf(this.f288450d);
                }
                com.tencent.mobileqq.signature.report.a.c().q(102, this.f288450d.topicId);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void rf(ISignatureStatusManager.TopicInfo topicInfo);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f288452a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f288453b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f288454c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f288455d;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public a(Context context, XListView xListView, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, xListView, bVar);
            return;
        }
        this.f288444d = context;
        this.f288446f = xListView;
        this.f288449m = bVar;
        this.f288445e = LayoutInflater.from(context);
    }

    private float b(int i3) {
        return Math.round((i3 / 10000.0f) * 100.0f) / 100.0f;
    }

    private String d(ISignatureStatusManager.TopicInfo topicInfo) {
        if (topicInfo != null) {
            if (topicInfo.totalNum > 0 || topicInfo.friendNum > 0) {
                StringBuilder sb5 = new StringBuilder();
                int i3 = topicInfo.friendNum;
                if (i3 > 0) {
                    if (i3 >= 10000) {
                        sb5.append(b(i3));
                        sb5.append("\u4e07\u597d\u53cb");
                    } else {
                        sb5.append(i3);
                        sb5.append("\u4e2a\u597d\u53cb");
                    }
                }
                if (topicInfo.friendNum > 0 && topicInfo.totalNum > 0) {
                    sb5.append("\u3001");
                }
                int i16 = topicInfo.totalNum;
                if (i16 > 0) {
                    if (i16 >= 10000) {
                        sb5.append(b(i16));
                        sb5.append("\u4e07\u4eba\u6dfb\u52a0\u8be5\u8bdd\u9898");
                    } else {
                        sb5.append(i16);
                        sb5.append("\u4eba\u6dfb\u52a0\u8be5\u8bdd\u9898");
                    }
                }
                if (topicInfo.totalNum <= 0 && topicInfo.friendNum > 0) {
                    sb5.append("\u6dfb\u52a0\u8be5\u8bdd\u9898");
                }
                return sb5.toString();
            }
            return null;
        }
        return null;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ISignatureStatusManager.TopicInfo getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ISignatureStatusManager.TopicInfo) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        List<ISignatureStatusManager.TopicInfo> list = this.f288447h;
        if (list != null && i3 >= 0 && i3 < list.size()) {
            return this.f288447h.get(i3);
        }
        return null;
    }

    public boolean e(List<ISignatureStatusManager.TopicInfo> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16))).booleanValue();
        }
        if (list != this.f288447h) {
            this.f288447h = (ArrayList) list;
            z17 = true;
        }
        if (z16 && list != this.f288448i) {
            this.f288448i = (ArrayList) list;
        }
        return z17;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        List<ISignatureStatusManager.TopicInfo> list = this.f288447h;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        c cVar;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            view2 = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                view = this.f288445e.inflate(R.layout.hgb, (ViewGroup) this.f288446f, false);
                cVar = new c();
                cVar.f288455d = (ImageView) view.findViewById(R.id.f165899ln2);
                cVar.f288455d.setImageDrawable(URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/arno/qvip_sig_topic_add.png", (URLDrawable.URLDrawableOptions) null));
                cVar.f288453b = (TextView) view.findViewById(R.id.me6);
                cVar.f288454c = (TextView) view.findViewById(R.id.me7);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            ISignatureStatusManager.TopicInfo item = getItem(i3);
            if (item != null) {
                cVar.f288453b.setText(item.topicStr);
                cVar.f288452a = item.topicId;
                view.setOnClickListener(new ViewOnClickListenerC8598a(item));
                String d16 = d(item);
                if (TextUtils.isEmpty(d16)) {
                    cVar.f288454c.setVisibility(8);
                } else {
                    cVar.f288454c.setVisibility(0);
                    cVar.f288454c.setText(d16);
                }
                com.tencent.mobileqq.signature.report.a.c().q(101, item.topicId);
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
