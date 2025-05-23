package com.tencent.biz.pubaccount.weishi.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.subscribe.comment.MoreCommentPanel;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class p extends BaseAdapter {
    public static int H = 1;
    private String E;
    private stSimpleMetaFeed F;
    private m G;

    /* renamed from: d, reason: collision with root package name */
    private Context f80598d;

    /* renamed from: e, reason: collision with root package name */
    private List<stSimpleMetaComment> f80599e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Integer> f80600f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.subscribe.comment.m f80601h;

    /* renamed from: i, reason: collision with root package name */
    private String f80602i;

    /* renamed from: m, reason: collision with root package name */
    HashSet<Integer> f80603m = new HashSet<>();
    HashSet<Integer> C = new HashSet<>();
    private String D = WSPublicAccReport.SOP_NAME_FOCUS;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f80604d;

        a(int i3) {
            this.f80604d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.f80601h != null) {
                String str = p.this.f80602i;
                if (p.this.F != null) {
                    str = p.this.F.f25129id;
                }
                p.this.f80601h.onClick(view, 12, this.f80604d, str);
            }
        }
    }

    public p(Context context, com.tencent.biz.subscribe.comment.m mVar, m mVar2) {
        this.f80598d = context;
        if (this.f80599e == null) {
            x.i("comment", "create mComments ...");
            this.f80599e = new ArrayList();
        } else {
            x.i("comment", "\u590d\u7528 mComments ...");
        }
        this.f80601h = mVar;
        this.f80600f = new HashMap();
        this.G = mVar2;
    }

    public void d(int i3, stSimpleMetaComment stsimplemetacomment) {
        x.f("comment", "addComment ...2");
        if (stsimplemetacomment == null || i3 > this.f80599e.size()) {
            return;
        }
        this.f80599e.add(i3, stsimplemetacomment);
    }

    public void g() {
        this.f80599e.clear();
        this.f80600f.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f80599e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f80599e.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0099, code lost:
    
        if (r0 != false) goto L16;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        stSimpleMetaComment stsimplemetacomment = (stSimpleMetaComment) getItem(i3);
        if (stsimplemetacomment.isTempData) {
            if (!this.f80603m.contains(Integer.valueOf(stsimplemetacomment.hashCode()))) {
                this.f80603m.add(Integer.valueOf(stsimplemetacomment.hashCode()));
                String f16 = com.tencent.biz.pubaccount.weishi.report.b.f(this.D);
                if (!f16.equals("comment_tag")) {
                    f16 = f16 + H;
                }
                com.tencent.biz.pubaccount.weishi.report.b.s(this.D, i(), f16, this.F);
            } else {
                x.b("beacon-comment", "\u91cd\u590d\u7684position:" + i3 + ",\u4e0d\u4e0a\u62a5");
            }
            MoreCommentPanel moreCommentPanel = new MoreCommentPanel(this.f80598d);
            ((TextView) moreCommentPanel.findViewById(R.id.f166318f03)).setTextColor(-7829368);
            moreCommentPanel.setOnClickListener(new a(i3));
            moreCommentPanel.setHintText(stsimplemetacomment.wording);
            return moreCommentPanel;
        }
        if (view != null) {
            boolean z16 = view instanceof MoreCommentPanel;
            view2 = view;
        }
        WsCommentView wsCommentView = new WsCommentView(this.f80598d);
        wsCommentView.setOnCommentElementClickListener(this.f80601h);
        wsCommentView.setTag(wsCommentView);
        view2 = wsCommentView;
        WsCommentView wsCommentView2 = (WsCommentView) view2.getTag();
        wsCommentView2.setPosition(i3);
        wsCommentView2.setDisplayNum(3);
        Integer num = this.f80600f.get(stsimplemetacomment.f25128id);
        int intValue = num != null ? num.intValue() : 3;
        wsCommentView2.setReportParams(this.G);
        wsCommentView2.setData(stsimplemetacomment, intValue, this.f80602i);
        return view2;
    }

    public void h() {
        HashSet<Integer> hashSet = this.f80603m;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    public String i() {
        return this.E;
    }

    public boolean j(String str) {
        x.f("comment", "removeComment ...");
        if (!TextUtils.isEmpty(str)) {
            int size = this.f80599e.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                if (str.equals(this.f80599e.get(size).f25128id)) {
                    r1 = this.f80599e.remove(size) != null;
                    this.f80600f.remove(str);
                } else {
                    size--;
                }
            }
        }
        return r1;
    }

    public boolean k(String str, String str2) {
        x.f("comment", "removeCommentReply ...");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        for (stSimpleMetaComment stsimplemetacomment : this.f80599e) {
            if (str.equals(stsimplemetacomment.f25128id)) {
                for (int size = stsimplemetacomment.replyList.size() - 1; size >= 0; size--) {
                    if (str2.equals(stsimplemetacomment.replyList.get(size).f25131id)) {
                        return stsimplemetacomment.replyList.remove(size) != null;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public void l(String str, String str2) {
        this.D = str;
        this.E = str2;
    }

    public void n(String str) {
        this.f80602i = str;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public boolean q(String str, stSimpleMetaComment stsimplemetacomment) {
        x.f("comment", "updateComment ...");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = this.f80599e.size() - 1; size >= 0; size--) {
            if (str.equals(this.f80599e.get(size).f25128id)) {
                return this.f80599e.set(size, stsimplemetacomment) != null;
            }
        }
        return false;
    }

    public boolean r(String str, String str2, stSimpleMetaReply stsimplemetareply) {
        x.f("comment", "updateCommentReply ............. mComments.size:" + this.f80599e.size());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(stsimplemetareply.f25131id)) {
            return false;
        }
        for (stSimpleMetaComment stsimplemetacomment : this.f80599e) {
            if (str.equals(stsimplemetacomment.f25128id)) {
                for (int size = stsimplemetacomment.replyList.size() - 1; size >= 0; size--) {
                    if (str2.equals(stsimplemetacomment.replyList.get(size).f25131id)) {
                        return stsimplemetacomment.replyList.set(size, stsimplemetareply) != null;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public boolean f(Collection<stSimpleMetaComment> collection) {
        if (collection != null) {
            return this.f80599e.addAll(collection);
        }
        return false;
    }

    public void m(stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed != null) {
            this.F = stsimplemetafeed;
        }
    }

    public int o(stSimpleMetaComment stsimplemetacomment) {
        if (stsimplemetacomment == null || TextUtils.isEmpty(stsimplemetacomment.f25128id)) {
            return -1;
        }
        this.f80600f.put(stsimplemetacomment.f25128id, 3);
        notifyDataSetChanged();
        return 3;
    }

    public void p(stSimpleMetaComment stsimplemetacomment) {
        if (stsimplemetacomment == null || TextUtils.isEmpty(stsimplemetacomment.f25128id)) {
            return;
        }
        Integer num = this.f80600f.get(stsimplemetacomment.f25128id);
        this.f80600f.put(stsimplemetacomment.f25128id, Integer.valueOf(num != null ? 10 + num.intValue() : 10));
        notifyDataSetChanged();
    }

    public void e(String str, stSimpleMetaReply stsimplemetareply) {
        if (stsimplemetareply == null) {
            return;
        }
        x.f("comment", "addCommentReply :" + stsimplemetareply.wording + ",mComments size:" + this.f80599e.size());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (stSimpleMetaComment stsimplemetacomment : this.f80599e) {
            if (str.equals(stsimplemetacomment.f25128id)) {
                stsimplemetacomment.replyList.add(0, stsimplemetareply);
                return;
            }
        }
    }
}
