package com.tencent.biz.pubaccount.weishi.comment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ah;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.open.base.ToastUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B+\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001a\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J$\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/comment/h;", "Landroid/widget/PopupWindow;", "Landroid/view/View$OnKeyListener;", "", "b", "Landroid/view/View;", "anchorView", "", "text", "d", "v", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/biz/pubaccount/weishi/comment/m;", "e", "Lcom/tencent/biz/pubaccount/weishi/comment/m;", "onGetReportInfo", "", "f", "Ljava/util/Map;", "commentExtMap", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "getTextContent", "()Landroid/widget/TextView;", "setTextContent", "(Landroid/widget/TextView;)V", "textContent", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/comment/m;Ljava/util/Map;)V", "i", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class h extends PopupWindow implements View.OnKeyListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final m onGetReportInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> commentExtMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView textContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, m onGetReportInfo, Map<String, String> commentExtMap) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onGetReportInfo, "onGetReportInfo");
        Intrinsics.checkNotNullParameter(commentExtMap, "commentExtMap");
        this.context = context;
        this.onGetReportInfo = onGetReportInfo;
        this.commentExtMap = commentExtMap;
        b();
    }

    private final void b() {
        setContentView(LayoutInflater.from(this.context).inflate(R.layout.d0b, (ViewGroup) null));
        this.textContent = (TextView) getContentView().findViewById(R.id.p6j);
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        getContentView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.comment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.c(h.this, view);
            }
        });
        setFocusable(true);
        setInputMethodMode(1);
        setSoftInputMode(48);
        setClippingEnabled(false);
        getContentView().setOnKeyListener(this);
        setOutsideTouchable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(h this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.pubaccount.weishi.report.b.h(this$0.onGetReportInfo, this$0.commentExtMap);
        ToastUtil.a().b(R.string.x9u);
        this$0.dismiss();
    }

    public final void d(View anchorView, String text) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        com.tencent.biz.pubaccount.weishi.report.b.i(this.onGetReportInfo, this.commentExtMap);
        int measuredWidth = anchorView.getMeasuredWidth();
        ViewParent parent = anchorView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        TextView textView = this.textContent;
        if (textView != null) {
            textView.setText(text);
        }
        getContentView().measure(0, 0);
        int measuredWidth2 = getContentView().getMeasuredWidth();
        int i3 = measuredWidth - measuredWidth2;
        try {
            if (k.b(this.context, getContentView())) {
                showAsDropDown(anchorView, i3 / 2, -(viewGroup.getHeight() + ah.b(10.0f)), 8388611);
            }
        } catch (Throwable th5) {
            x.d(th5.getLocalizedMessage());
        }
        x.b("TextPopupWindow", "anchorWidth is " + measuredWidth + " tipWidth is " + measuredWidth2);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v3, int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return false;
        }
        dismiss();
        return true;
    }
}
