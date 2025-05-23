package com.tencent.mobileqq.mini.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.ui.WechatBindingAndAuthContentView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 !2\u00020\u0001:\u0003 !\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAccountBindingType", "Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView$AccountBindingType;", "mNotificationWxBindingTv", "Landroid/widget/TextView;", "mWxUnbindingBtn", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mWxUserDesTv", "mWxUserIconIv", "Landroid/widget/ImageView;", "mWxUserNameTv", "initView", "", "setBindUIInfo", "headImageUrl", "", "nickName", "setEmptyUserInfo", "setUnBindUIInfo", "setWxBindOrUnbindOnClickListener", "listener", "Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView$WxBindOrUnbindOnClickListener;", "AccountBindingType", "Companion", "WxBindOrUnbindOnClickListener", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class WechatBindingAndAuthContentView extends FrameLayout {
    private static final String TAG = "WechatBindingAndAuthContentView";
    private AccountBindingType mAccountBindingType;
    private TextView mNotificationWxBindingTv;
    private QUIButton mWxUnbindingBtn;
    private TextView mWxUserDesTv;
    private ImageView mWxUserIconIv;
    private TextView mWxUserNameTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView$AccountBindingType;", "", "(Ljava/lang/String;I)V", "ACCOUNT_UNBINDING_TYPE", "ACCOUNT_BINDING_TYPE", "ACCOUNT_EMPTY_USER_INFO_TYPE", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public enum AccountBindingType {
        ACCOUNT_UNBINDING_TYPE,
        ACCOUNT_BINDING_TYPE,
        ACCOUNT_EMPTY_USER_INFO_TYPE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView$WxBindOrUnbindOnClickListener;", "", NodeProps.ON_CLICK, "", "view", "Landroid/view/View;", "accountBindingType", "Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView$AccountBindingType;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface WxBindOrUnbindOnClickListener {
        void onClick(View view, AccountBindingType accountBindingType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WechatBindingAndAuthContentView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.djo, (ViewGroup) null);
        addView(inflate);
        this.mWxUserIconIv = (ImageView) inflate.findViewById(R.id.rk7);
        this.mWxUserNameTv = (TextView) inflate.findViewById(R.id.rk8);
        this.mWxUserDesTv = (TextView) inflate.findViewById(R.id.rk6);
        this.mWxUnbindingBtn = (QUIButton) inflate.findViewById(R.id.rk9);
        this.mNotificationWxBindingTv = (TextView) inflate.findViewById(R.id.rk5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWxBindOrUnbindOnClickListener$lambda$0(WxBindOrUnbindOnClickListener listener, WechatBindingAndAuthContentView this$0, View view) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        listener.onClick(view, this$0.mAccountBindingType);
    }

    public final void setBindUIInfo(String headImageUrl, String nickName) {
        Intrinsics.checkNotNullParameter(headImageUrl, "headImageUrl");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Drawable icon = MiniAppUtils.getIcon(getContext(), headImageUrl, true, 4);
        ImageView imageView = this.mWxUserIconIv;
        if (imageView != null) {
            imageView.setImageDrawable(icon);
        }
        TextView textView = this.mWxUserNameTv;
        if (textView != null) {
            textView.setText(nickName);
        }
        QUIButton qUIButton = this.mWxUnbindingBtn;
        if (qUIButton != null) {
            qUIButton.setText(R.string.xya);
        }
        TextView textView2 = this.mWxUserDesTv;
        if (textView2 != null) {
            textView2.setText(R.string.xzp);
        }
        TextView textView3 = this.mNotificationWxBindingTv;
        if (textView3 != null) {
            textView3.setText(R.string.xy7);
        }
        this.mAccountBindingType = AccountBindingType.ACCOUNT_BINDING_TYPE;
    }

    public final void setEmptyUserInfo() {
        ImageView imageView = this.mWxUserIconIv;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.iqn);
        }
        TextView textView = this.mWxUserNameTv;
        if (textView != null) {
            textView.setText(R.string.xzo);
        }
        QUIButton qUIButton = this.mWxUnbindingBtn;
        if (qUIButton != null) {
            qUIButton.setText(R.string.xya);
        }
        TextView textView2 = this.mWxUserDesTv;
        if (textView2 != null) {
            textView2.setText(R.string.xzt);
        }
        TextView textView3 = this.mNotificationWxBindingTv;
        if (textView3 != null) {
            textView3.setText(R.string.xy7);
        }
        this.mAccountBindingType = AccountBindingType.ACCOUNT_EMPTY_USER_INFO_TYPE;
    }

    public final void setUnBindUIInfo() {
        ImageView imageView = this.mWxUserIconIv;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.iqo);
        }
        TextView textView = this.mWxUserNameTv;
        if (textView != null) {
            textView.setText(R.string.xzq);
        }
        QUIButton qUIButton = this.mWxUnbindingBtn;
        if (qUIButton != null) {
            qUIButton.setText(R.string.xyg);
        }
        TextView textView2 = this.mWxUserDesTv;
        if (textView2 != null) {
            textView2.setText(R.string.xyh);
        }
        TextView textView3 = this.mNotificationWxBindingTv;
        if (textView3 != null) {
            textView3.setText(R.string.xy7);
        }
        this.mAccountBindingType = AccountBindingType.ACCOUNT_UNBINDING_TYPE;
    }

    public final void setWxBindOrUnbindOnClickListener(final WxBindOrUnbindOnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QUIButton qUIButton = this.mWxUnbindingBtn;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WechatBindingAndAuthContentView.setWxBindOrUnbindOnClickListener$lambda$0(WechatBindingAndAuthContentView.WxBindOrUnbindOnClickListener.this, this, view);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WechatBindingAndAuthContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WechatBindingAndAuthContentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAccountBindingType = AccountBindingType.ACCOUNT_UNBINDING_TYPE;
        initView(context);
    }
}
