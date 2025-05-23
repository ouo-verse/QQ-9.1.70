package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010T\u001a\u00020S\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\"\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00101\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010!\u001a\u0004\b/\u0010#\"\u0004\b0\u0010%R\"\u00105\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010!\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\"\u00109\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010!\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R6\u0010C\u001a\u0016\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0002\u0018\u00010:j\u0004\u0018\u0001`<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR6\u0010G\u001a\u0016\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0002\u0018\u00010:j\u0004\u0018\u0001`<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010>\u001a\u0004\bE\u0010@\"\u0004\bF\u0010BR0\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010Hj\u0004\u0018\u0001`I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010Hj\u0004\u0018\u0001`P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010J\u001a\u0004\bQ\u0010L\"\u0004\bR\u0010N\u00a8\u0006W"}, d2 = {"Lcom/tencent/ecommerce/base/ui/g;", "Landroid/app/Dialog;", "", "initView", "P", "O", "N", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onBackPressed", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "titleView", "D", "getContentView", "setContentView", "contentView", "E", ExifInterface.LATITUDE_SOUTH, "setLeftView", "leftView", UserInfo.SEX_FEMALE, "X", "setRightView", "rightView", "", "G", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "", "H", "I", "getContentGravity", "()I", "Z", "(I)V", "contentGravity", "getContent", "Y", "content", "J", BdhLogUtil.LogTag.Tag_Req, "b0", "leftMessage", "K", "W", "f0", "rightMessage", "Lkotlin/Function1;", "Landroid/view/View;", "Lcom/tencent/ecommerce/base/ui/ISimpleChatDialogClickListener;", "L", "Lkotlin/jvm/functions/Function1;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lkotlin/jvm/functions/Function1;", "a0", "(Lkotlin/jvm/functions/Function1;)V", "leftButtonCallback", "M", "U", "e0", "rightButtonCallback", "Lkotlin/Function0;", "Lcom/tencent/ecommerce/base/ui/ISimpleChatDialogOnCreateListener;", "Lkotlin/jvm/functions/Function0;", "getOnCreateCallback", "()Lkotlin/jvm/functions/Function0;", "d0", "(Lkotlin/jvm/functions/Function0;)V", "onCreateCallback", "Lcom/tencent/ecommerce/base/ui/ISimpleChatDialogOnBackPressed;", "getOnBackPressed", "c0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public class g extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    public TextView titleView;

    /* renamed from: D, reason: from kotlin metadata */
    public TextView contentView;

    /* renamed from: E, reason: from kotlin metadata */
    public TextView leftView;

    /* renamed from: F, reason: from kotlin metadata */
    public TextView rightView;

    /* renamed from: G, reason: from kotlin metadata */
    private String title;

    /* renamed from: H, reason: from kotlin metadata */
    private int contentGravity;

    /* renamed from: I, reason: from kotlin metadata */
    private String content;

    /* renamed from: J, reason: from kotlin metadata */
    private String leftMessage;

    /* renamed from: K, reason: from kotlin metadata */
    private String rightMessage;

    /* renamed from: L, reason: from kotlin metadata */
    private Function1<? super View, Unit> leftButtonCallback;

    /* renamed from: M, reason: from kotlin metadata */
    private Function1<? super View, Unit> rightButtonCallback;

    /* renamed from: N, reason: from kotlin metadata */
    private Function0<Unit> onCreateCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private Function0<Unit> onBackPressed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Function1<View, Unit> Q = g.this.Q();
            if (Q != null) {
                Q.invoke(view);
            }
            g.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Function1<View, Unit> U = g.this.U();
            if (U != null) {
                U.invoke(view);
            }
            g.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private final void N() {
        boolean isBlank;
        boolean isBlank2;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.leftMessage);
        if (isBlank) {
            TextView textView = this.leftView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftView");
            }
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.leftView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftView");
            }
            textView2.setVisibility(0);
            TextView textView3 = this.leftView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftView");
            }
            textView3.setText(this.leftMessage);
            TextView textView4 = this.leftView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftView");
            }
            textView4.setOnClickListener(new a());
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(this.rightMessage);
        if (isBlank2) {
            TextView textView5 = this.rightView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightView");
            }
            textView5.setVisibility(8);
            return;
        }
        TextView textView6 = this.rightView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightView");
        }
        textView6.setVisibility(0);
        TextView textView7 = this.rightView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightView");
        }
        textView7.setText(this.rightMessage);
        TextView textView8 = this.rightView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightView");
        }
        textView8.setOnClickListener(new b());
    }

    private final void O() {
        TextView textView = this.contentView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        textView.setGravity(this.contentGravity);
        if (!TextUtils.isEmpty(this.content)) {
            TextView textView2 = this.contentView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
            }
            textView2.setText(this.content);
            return;
        }
        TextView textView3 = this.contentView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        textView3.setVisibility(8);
    }

    private final void P() {
        if (!TextUtils.isEmpty(this.title)) {
            TextView textView = this.titleView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
            }
            textView.setText(this.title);
            TextView textView2 = this.titleView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
            }
            textView2.setVisibility(0);
            return;
        }
        TextView textView3 = this.titleView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        textView3.setVisibility(8);
    }

    public final Function1<View, Unit> Q() {
        return this.leftButtonCallback;
    }

    /* renamed from: R, reason: from getter */
    public final String getLeftMessage() {
        return this.leftMessage;
    }

    public final TextView S() {
        TextView textView = this.leftView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftView");
        }
        return textView;
    }

    public final Function1<View, Unit> U() {
        return this.rightButtonCallback;
    }

    /* renamed from: W, reason: from getter */
    public final String getRightMessage() {
        return this.rightMessage;
    }

    public final TextView X() {
        TextView textView = this.rightView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightView");
        }
        return textView;
    }

    public final void Y(String str) {
        this.content = str;
    }

    public final void Z(int i3) {
        this.contentGravity = i3;
    }

    public final void a0(Function1<? super View, Unit> function1) {
        this.leftButtonCallback = function1;
    }

    public final void b0(String str) {
        this.leftMessage = str;
    }

    public final void c0(Function0<Unit> function0) {
        this.onBackPressed = function0;
    }

    public final void d0(Function0<Unit> function0) {
        this.onCreateCallback = function0;
    }

    public final void e0(Function1<? super View, Unit> function1) {
        this.rightButtonCallback = function1;
    }

    public final void f0(String str) {
        this.rightMessage = str;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        Function0<Unit> function0 = this.onBackPressed;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuo);
        initView();
        P();
        O();
        N();
        Function0<Unit> function0 = this.onCreateCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public g(Context context) {
        super(context, R.style.f243139);
        this.title = "";
        this.contentGravity = 3;
        this.content = "";
        this.leftMessage = context.getString(R.string.wgw);
        this.rightMessage = context.getString(R.string.wi6);
    }

    private final void initView() {
        this.titleView = (TextView) findViewById(R.id.ocd);
        this.contentView = (TextView) findViewById(R.id.nuq);
        this.leftView = (TextView) findViewById(R.id.odr);
        this.rightView = (TextView) findViewById(R.id.f163120oe4);
    }
}
