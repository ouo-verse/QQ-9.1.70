package com.tencent.mobileqq.richstatus.comment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CommentsView extends LinearLayout implements ViewGroup.OnHierarchyChangeListener {
    static IPatchRedirector $redirector_;
    private f C;
    private d D;
    private e E;

    /* renamed from: d, reason: collision with root package name */
    private int f282333d;

    /* renamed from: e, reason: collision with root package name */
    private int f282334e;

    /* renamed from: f, reason: collision with root package name */
    private int f282335f;

    /* renamed from: h, reason: collision with root package name */
    private LayoutInflater f282336h;

    /* renamed from: i, reason: collision with root package name */
    private List<CommentItem> f282337i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.richstatus.comment.utils.a<View> f282338m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.richstatus.comment.spannable.a f282339d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f282340e;

        a(com.tencent.mobileqq.richstatus.comment.spannable.a aVar, int i3) {
            this.f282339d = aVar;
            this.f282340e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CommentsView.this, aVar, Integer.valueOf(i3));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (this.f282339d.b() && CommentsView.this.D != null) {
                CommentsView.this.D.a(this.f282340e, view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.richstatus.comment.spannable.a f282342d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f282343e;

        b(com.tencent.mobileqq.richstatus.comment.spannable.a aVar, int i3) {
            this.f282342d = aVar;
            this.f282343e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CommentsView.this, aVar, Integer.valueOf(i3));
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else if (this.f282342d.b()) {
                if (CommentsView.this.E != null) {
                    CommentsView.this.E.a(this.f282343e, view);
                }
                z16 = true;
            } else {
                z16 = false;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends com.tencent.mobileqq.richstatus.comment.spannable.b {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f282345e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i3, String str) {
            super(i3);
            this.f282345e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CommentsView.this, Integer.valueOf(i3), str);
            }
        }

        @Override // android.text.style.ClickableSpan, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (CommentsView.this.C != null) {
                CommentsView.this.C.a(this.f282345e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void a(int i3, View view);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void a(int i3, View view);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface f {
        void a(String str);
    }

    public CommentsView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            f();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void d(View view, int i3) {
        com.tencent.mobileqq.richstatus.comment.bean.b bVar;
        String str;
        TextView textView = (TextView) view;
        int i16 = this.f282334e;
        com.tencent.mobileqq.richstatus.comment.spannable.a aVar = new com.tencent.mobileqq.richstatus.comment.spannable.a(i16, i16);
        CommentItem commentItem = this.f282337i.get(i3);
        if (commentItem != null && (bVar = commentItem.user) != null) {
            String str2 = bVar.f282323b;
            com.tencent.mobileqq.richstatus.comment.bean.b bVar2 = commentItem.toReplyUser;
            String str3 = "";
            if (bVar2 == null) {
                str = "";
            } else {
                str = bVar2.f282323b;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) j(str2, commentItem.user.f282322a));
            if (!TextUtils.isEmpty(str)) {
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.append((CharSequence) getContext().getString(R.string.h1e));
                spannableStringBuilder.append((CharSequence) " ");
                com.tencent.mobileqq.richstatus.comment.bean.b bVar3 = commentItem.toReplyUser;
                if (bVar3 != null) {
                    str3 = bVar3.f282322a;
                }
                spannableStringBuilder.append((CharSequence) j(str, str3));
            }
            spannableStringBuilder.append((CharSequence) MsgSummary.STR_COLON);
            String str4 = commentItem.content;
            if (!TextUtils.isEmpty(str4)) {
                spannableStringBuilder.append((CharSequence) str4);
            }
            textView.setText(new QQText(spannableStringBuilder, 3, 16));
            textView.setTextColor(this.f282335f);
            textView.setMovementMethod(aVar);
            textView.setOnClickListener(new a(aVar, i3));
            textView.setOnLongClickListener(new b(aVar, i3));
        }
    }

    private View e(int i3) {
        View a16 = this.f282338m.a();
        if (a16 == null) {
            if (this.f282336h == null) {
                this.f282336h = LayoutInflater.from(getContext());
            }
            a16 = this.f282336h.inflate(R.layout.aes, (ViewGroup) null, false);
        }
        d(a16, i3);
        return a16;
    }

    private void f() {
        this.f282338m = new com.tencent.mobileqq.richstatus.comment.utils.a<>();
        setOnHierarchyChangeListener(this);
        this.f282335f = getResources().getColor(R.color.f157983ai2);
    }

    private SpannableString j(String str, String str2) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new c(this.f282333d, str2), 0, spannableString.length(), 33);
        return spannableString;
    }

    protected void g(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) attributeSet);
            return;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.CommentsView, 0, 0);
        try {
            this.f282333d = obtainStyledAttributes.getColor(R.styleable.CommentsView_comment_item_color, getResources().getColor(R.color.aea));
            this.f282334e = obtainStyledAttributes.getColor(R.styleable.CommentsView_comment_item_selector_color, getResources().getColor(R.color.ac_));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void h(List<CommentItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f282337i = list;
        i();
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        List<CommentItem> list = this.f282337i;
        if (list != null && list.size() != 0) {
            setVisibility(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = BaseAIOUtils.f(2.0f, getResources());
            for (int i3 = 0; i3 < this.f282337i.size(); i3++) {
                if (getChildCount() > i3) {
                    d(getChildAt(i3), i3);
                } else {
                    View e16 = e(i3);
                    if (e16 == null) {
                        QLog.e("CommentsView", 1, "listView item layout is null, please check getView()...");
                        return;
                    }
                    addView(e16, i3, layoutParams);
                }
            }
            if (getChildCount() > this.f282337i.size()) {
                removeViews(this.f282337i.size(), getChildCount() - this.f282337i.size());
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        EventCollector.getInstance().onChildViewAdded(view, view2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view, (Object) view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        EventCollector.getInstance().onChildViewRemoved(view, view2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, (Object) view2);
        } else {
            this.f282338m.b(view2);
        }
    }

    public void setItemColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.f282333d = i3;
        }
    }

    public void setNormalTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f282335f = i3;
        }
    }

    public void setOnItemClickListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
        } else {
            this.D = dVar;
        }
    }

    public void setOnItemLongClickListener(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) eVar);
        } else {
            this.E = eVar;
        }
    }

    public void setOnSpanItemClick(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
        } else {
            this.C = fVar;
        }
    }

    public CommentsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            f();
            g(attributeSet);
        }
    }

    public CommentsView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            f();
            g(attributeSet);
        }
    }
}
