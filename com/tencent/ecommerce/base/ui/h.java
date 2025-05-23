package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010/\u001a\u00020.\u0012\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%\u0012\b\b\u0002\u0010-\u001a\u00020*\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR6\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\u0004\u0018\u0001`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR6\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\u0004\u0018\u0001`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001c\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/base/ui/h;", "Landroid/app/Dialog;", "", "initView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "D", "getLeftMessage", "setLeftMessage", "leftMessage", "E", "getRightMessage", "setRightMessage", "rightMessage", "Lkotlin/Function1;", "Landroid/view/View;", "Lcom/tencent/ecommerce/base/ui/ISimpleChatDialogClickListener;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "N", "()Lkotlin/jvm/functions/Function1;", "setLeftButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "leftButtonCallback", "G", "O", "P", "rightButtonCallback", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "H", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "I", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class h extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private String title;

    /* renamed from: D, reason: from kotlin metadata */
    private String leftMessage;

    /* renamed from: E, reason: from kotlin metadata */
    private String rightMessage;

    /* renamed from: F, reason: from kotlin metadata */
    private Function1<? super View, Unit> leftButtonCallback;

    /* renamed from: G, reason: from kotlin metadata */
    private Function1<? super View, Unit> rightButtonCallback;

    /* renamed from: H, reason: from kotlin metadata */
    private final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter;

    /* renamed from: I, reason: from kotlin metadata */
    private final RecyclerView.LayoutManager layoutManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/base/ui/ECSimpleListDialog$initView$2$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h.this.dismiss();
            Function1<View, Unit> N = h.this.N();
            if (N != null) {
                N.invoke(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/base/ui/ECSimpleListDialog$initView$3$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h.this.dismiss();
            Function1<View, Unit> O = h.this.O();
            if (O != null) {
                O.invoke(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public /* synthetic */ h(Context context, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, adapter, (i3 & 4) != 0 ? new LinearLayoutManager(context) : layoutManager);
    }

    public final Function1<View, Unit> N() {
        return this.leftButtonCallback;
    }

    public final Function1<View, Unit> O() {
        return this.rightButtonCallback;
    }

    public final void P(Function1<? super View, Unit> function1) {
        this.rightButtonCallback = function1;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cup);
        initView();
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public h(Context context, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, RecyclerView.LayoutManager layoutManager) {
        super(context, R.style.f243139);
        this.adapter = adapter;
        this.layoutManager = layoutManager;
        this.title = "";
        this.leftMessage = context.getString(R.string.wgw);
        this.rightMessage = context.getString(R.string.wi6);
    }

    private final void initView() {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        TextView textView = (TextView) findViewById(R.id.oer);
        isBlank = StringsKt__StringsJVMKt.isBlank(this.title);
        textView.setVisibility(isBlank ^ true ? 0 : 8);
        textView.setText(this.title);
        TextView textView2 = (TextView) findViewById(R.id.odr);
        isBlank2 = StringsKt__StringsJVMKt.isBlank(this.leftMessage);
        textView2.setVisibility(isBlank2 ^ true ? 0 : 8);
        textView2.setText(this.leftMessage);
        textView2.setOnClickListener(new a());
        TextView textView3 = (TextView) findViewById(R.id.f163120oe4);
        isBlank3 = StringsKt__StringsJVMKt.isBlank(this.rightMessage);
        textView3.setVisibility(isBlank3 ^ true ? 0 : 8);
        textView3.setText(this.rightMessage);
        textView3.setOnClickListener(new b());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.o8n);
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(this.layoutManager);
    }
}
