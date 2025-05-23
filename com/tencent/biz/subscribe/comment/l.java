package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class l extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f96025d;

    /* renamed from: e, reason: collision with root package name */
    private List<CertifiedAccountMeta$StComment> f96026e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Integer> f96027f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private m f96028h;

    /* renamed from: i, reason: collision with root package name */
    private String f96029i;

    public l(Context context, m mVar) {
        this.f96025d = context;
        this.f96028h = mVar;
    }

    public void a(int i3, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
        if (certifiedAccountMeta$StComment != null && i3 <= this.f96026e.size()) {
            this.f96026e.add(i3, certifiedAccountMeta$StComment);
        }
    }

    public void b(String str, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        if (!TextUtils.isEmpty(str) && certifiedAccountMeta$StReply != null) {
            for (CertifiedAccountMeta$StComment certifiedAccountMeta$StComment : this.f96026e) {
                if (str.equals(certifiedAccountMeta$StComment.f24924id.get())) {
                    certifiedAccountMeta$StComment.vecReply.get().add(0, certifiedAccountMeta$StReply);
                    return;
                }
            }
        }
    }

    public boolean c(Collection<CertifiedAccountMeta$StComment> collection) {
        if (collection != null) {
            return this.f96026e.addAll(collection);
        }
        return false;
    }

    public void d() {
        this.f96026e.clear();
        this.f96027f.clear();
    }

    public boolean e(String str) {
        boolean z16 = false;
        if (!TextUtils.isEmpty(str)) {
            int size = this.f96026e.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                if (str.equals(this.f96026e.get(size).f24924id.get())) {
                    if (this.f96026e.remove(size) != null) {
                        z16 = true;
                    }
                    this.f96027f.remove(str);
                } else {
                    size--;
                }
            }
        }
        return z16;
    }

    public boolean f(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        for (CertifiedAccountMeta$StComment certifiedAccountMeta$StComment : this.f96026e) {
            if (str.equals(certifiedAccountMeta$StComment.f24924id.get())) {
                for (int size = certifiedAccountMeta$StComment.vecReply.size() - 1; size >= 0; size--) {
                    if (str2.equals(certifiedAccountMeta$StComment.vecReply.get(size).f24928id.get())) {
                        if (certifiedAccountMeta$StComment.vecReply.get().remove(size) == null) {
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public void g(String str) {
        this.f96029i = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f96026e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f96026e.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r1 != false) goto L6;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        CertifiedAccountMeta$StComment certifiedAccountMeta$StComment = (CertifiedAccountMeta$StComment) getItem(i3);
        if (view != null) {
            boolean z16 = view instanceof MoreCommentPanel;
            view2 = view;
        }
        CommentView commentView = new CommentView(this.f96025d);
        commentView.setOnCommentElementClickListener(this.f96028h);
        commentView.setTag(commentView);
        view2 = commentView;
        CommentView commentView2 = (CommentView) view2.getTag();
        commentView2.setPosition(i3);
        int i16 = 3;
        commentView2.setDisplayNum(3);
        Integer num = this.f96027f.get(certifiedAccountMeta$StComment.f24924id.get());
        if (num != null) {
            i16 = num.intValue();
        }
        commentView2.setData(certifiedAccountMeta$StComment, i16, this.f96029i);
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }

    public void h(int i3) {
        if (this.f96026e.size() > i3 + 1) {
            i(this.f96026e.get(i3));
        }
    }

    public void i(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
        if (certifiedAccountMeta$StComment != null && !TextUtils.isEmpty(certifiedAccountMeta$StComment.f24924id.get())) {
            this.f96027f.put(certifiedAccountMeta$StComment.f24924id.get(), Integer.valueOf(certifiedAccountMeta$StComment.vecReply.size()));
            notifyDataSetChanged();
        }
    }

    public int j(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
        if (certifiedAccountMeta$StComment != null && !TextUtils.isEmpty(certifiedAccountMeta$StComment.f24924id.get())) {
            this.f96027f.put(certifiedAccountMeta$StComment.f24924id.get(), 3);
            notifyDataSetChanged();
            return 3;
        }
        return -1;
    }

    public void k(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
        if (certifiedAccountMeta$StComment != null && !TextUtils.isEmpty(certifiedAccountMeta$StComment.f24924id.get())) {
            Integer num = this.f96027f.get(certifiedAccountMeta$StComment.f24924id.get());
            int i3 = 10;
            if (num != null) {
                i3 = 10 + num.intValue();
            }
            this.f96027f.put(certifiedAccountMeta$StComment.f24924id.get(), Integer.valueOf(i3));
            notifyDataSetChanged();
        }
    }

    public boolean l(String str, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = this.f96026e.size() - 1; size >= 0; size--) {
            if (str.equals(this.f96026e.get(size).f24924id.get())) {
                if (this.f96026e.set(size, certifiedAccountMeta$StComment) == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean m(String str, String str2, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(certifiedAccountMeta$StReply.f24928id.get())) {
            return false;
        }
        for (CertifiedAccountMeta$StComment certifiedAccountMeta$StComment : this.f96026e) {
            if (str.equals(certifiedAccountMeta$StComment.f24924id.get())) {
                for (int size = certifiedAccountMeta$StComment.vecReply.size() - 1; size >= 0; size--) {
                    if (str2.equals(certifiedAccountMeta$StComment.vecReply.get(size).f24928id.get())) {
                        if (certifiedAccountMeta$StComment.vecReply.get().set(size, certifiedAccountMeta$StReply) == null) {
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
