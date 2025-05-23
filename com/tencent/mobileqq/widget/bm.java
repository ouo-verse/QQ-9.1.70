package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.ck;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\b*\u0001:\b\u0007\u0018\u0000 G2\u00020\u0001:\u0003HIJB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020C0B\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\bE\u0010FJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u00020\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001c\u0010&\u001a\n \u001d*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010*\u001a\n \u001d*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010,\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u001fR\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u0007R\u0016\u00105\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u0007R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/widget/bm;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "", "tipStr", "", "Z", "c0", "", "accountList", "d0", "url", "b0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", DKHippyEvent.EVENT_STOP, "onBackPressed", "Lcom/tencent/mobileqq/widget/bm$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/bm$c;", "mOnAccountClickListener", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "mContainer", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "mTitle", UserInfo.SEX_FEMALE, "mContent", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "mAccountListView", "Lcom/tencent/mobileqq/widget/BounceScrollView;", "H", "Lcom/tencent/mobileqq/widget/BounceScrollView;", "mBounceScrollView", "I", "mTipView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "J", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mFloatingView", "", "K", "mCanScroll", "L", "mShowLoginBtn", "Landroid/view/View$OnClickListener;", "M", "Landroid/view/View$OnClickListener;", "mTipViewOnClickListener", "com/tencent/mobileqq/widget/bm$e", "N", "Lcom/tencent/mobileqq/widget/bm$e;", "mSpanClickListener", "Landroid/view/OrientationEventListener;", "P", "Landroid/view/OrientationEventListener;", "mOrientationEventListener", "", "", "selectParams", "<init>", "(Landroid/content/Context;Ljava/util/Map;Lcom/tencent/mobileqq/widget/bm$c;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "b", "c", "d", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes20.dex */
public final class bm extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c mOnAccountClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private LinearLayout mContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView mTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView mContent;

    /* renamed from: G, reason: from kotlin metadata */
    private final RecyclerView mAccountListView;

    /* renamed from: H, reason: from kotlin metadata */
    private final BounceScrollView mBounceScrollView;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView mTipView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView mFloatingView;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mCanScroll;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mShowLoginBtn;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener mTipViewOnClickListener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private e mSpanClickListener;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private OrientationEventListener mOrientationEventListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/widget/bm$a", "Landroid/view/OrientationEventListener;", "", "orientation", "", "onOrientationChanged", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends OrientationEventListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bm f316742a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, bm bmVar) {
            super(context);
            this.f316742a = bmVar;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int orientation) {
            this.f316742a.c0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/widget/bm$c;", "", "account", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface c {
        void a(@NotNull Object account);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/widget/bm$d;", "Lcom/tencent/mobileqq/loginregister/utils/WebViewBridge$c;", "", "bridgeSeq", "", "event", "Landroid/os/Bundle;", "data", "", "a", "requestCode", QzoneIPCModule.RESULT_CODE, "b", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "Lmqq/util/WeakReference;", "contextRef", "Lcom/tencent/mobileqq/widget/bm;", "kotlin.jvm.PlatformType", "selectAccountDialogRef", "context", "selectAccountDialog", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/widget/bm;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements WebViewBridge.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Context> contextRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<bm> selectAccountDialogRef;

        public d(@Nullable Context context, @NotNull bm selectAccountDialog) {
            Intrinsics.checkNotNullParameter(selectAccountDialog, "selectAccountDialog");
            this.contextRef = new WeakReference<>(context);
            this.selectAccountDialogRef = new WeakReference<>(selectAccountDialog);
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void a(int bridgeSeq, @NotNull String event, @Nullable Bundle data) {
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView;
            Intrinsics.checkNotNullParameter(event, "event");
            if (!Intrinsics.areEqual("com.tencent.mobileqq.InvitationWebViewPlugin.unbindAccount", event)) {
                return;
            }
            WebViewBridge.f().n(bridgeSeq);
            if (data == null) {
                QLog.d("SelectAccountDialog", 2, "UnbindAccountCallBack data is null");
                return;
            }
            QLog.d("SelectAccountDialog", 2, "UnbindAccountCallBack");
            String string = data.getString("key_login_unbind_phone_account_data");
            if (QLog.isColorLevel()) {
                QLog.d("SelectAccountDialog", 2, "UnbindAccountCallBack accountDataStr : " + string);
            }
            List<AccountInfo> j3 = LoginUtil.f306390a.j(string);
            if (j3.isEmpty()) {
                bm bmVar = this.selectAccountDialogRef.get();
                if (bmVar != null && (qUSHalfScreenFloatingView = bmVar.mFloatingView) != null) {
                    qUSHalfScreenFloatingView.t();
                }
                QLog.d("SelectAccountDialog", 1, "UnbindAccountCallBack accountInfo is empty");
                return;
            }
            bm bmVar2 = this.selectAccountDialogRef.get();
            if (bmVar2 != null) {
                bmVar2.d0(j3);
            }
            ck.f306664a.f("0X800C236", String.valueOf(j3.size()));
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void b(int bridgeSeq, int requestCode, int resultCode, @Nullable Bundle data) {
            if (resultCode == 0) {
                WebViewBridge.f().n(bridgeSeq);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/widget/bm$e", "Lcom/tencent/mobileqq/util/LoginUtil$a;", "", "url", "", NodeProps.ON_CLICK, "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements LoginUtil.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f316746b;

        e(Context context) {
            this.f316746b = context;
        }

        @Override // com.tencent.mobileqq.util.LoginUtil.a
        public void onClick(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            bm.this.b0(this.f316746b, url);
            ck.f306664a.f("0X800C235", "");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/widget/bm$f", "Lcom/tencent/mobileqq/widget/qus/e;", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", "Landroid/view/View;", "createContentView", "", "showMode", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class f extends com.tencent.mobileqq.widget.qus.e {
        f() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            return bm.this.mCanScroll;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            return bm.this.mCanScroll;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        public View createContentView() {
            return bm.this.mContainer;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(@NotNull Context context, @NotNull Map<String, Object> selectParams, @NotNull c mOnAccountClickListener) {
        super(context, R.style.MenuDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectParams, "selectParams");
        Intrinsics.checkNotNullParameter(mOnAccountClickListener, "mOnAccountClickListener");
        this.mOnAccountClickListener = mOnAccountClickListener;
        View inflate = View.inflate(context, R.layout.f168821gy3, null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.mContainer = linearLayout;
        TextView textView = (TextView) linearLayout.findViewById(R.id.t7s);
        this.mTitle = textView;
        TextView textView2 = (TextView) this.mContainer.findViewById(R.id.t7p);
        this.mContent = textView2;
        this.mAccountListView = (RecyclerView) this.mContainer.findViewById(R.id.t7q);
        BounceScrollView bounceScrollView = (BounceScrollView) this.mContainer.findViewById(R.id.s86);
        this.mBounceScrollView = bounceScrollView;
        this.mTipView = (TextView) this.mContainer.findViewById(R.id.uem);
        this.mSpanClickListener = new e(context);
        Object obj = selectParams.get("key_dialog_title");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        textView.setText((String) obj);
        CharSequence charSequence = (CharSequence) selectParams.get("key_dialog_msg");
        String str = (String) selectParams.get("key_unbind_account_tip");
        this.mShowLoginBtn = Intrinsics.areEqual((Boolean) selectParams.get("key_unbind_account_show_login_btn"), Boolean.TRUE);
        this.mTipViewOnClickListener = (View.OnClickListener) selectParams.get("key_unbind_account_tip_view_on_click_listener");
        Z(context, str);
        if (TextUtils.isEmpty(textView2.getText())) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(charSequence);
        }
        Object obj2 = selectParams.get("key_unbind_account_list");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<*>");
        List<?> accountList = Collections.unmodifiableList((List) obj2);
        Intrinsics.checkNotNullExpressionValue(accountList, "accountList");
        d0(accountList);
        bounceScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.widget.bk
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Q;
                Q = bm.Q(bm.this, view, motionEvent);
                return Q;
            }
        });
        a aVar = new a(context, this);
        this.mOrientationEventListener = aVar;
        aVar.enable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q(bm this$0, View view, MotionEvent motionEvent) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            this$0.mCanScroll = true;
        } else if (num != null && num.intValue() == 1) {
            this$0.mCanScroll = false;
        }
        return false;
    }

    private final void Z(Context context, String tipStr) {
        if (this.mTipViewOnClickListener == null) {
            this.mTipView.setMovementMethod(LinkMovementMethod.getInstance());
            CharSequence f16 = LoginUtil.f306390a.f(tipStr, context, this.mSpanClickListener, ContextCompat.getColor(context, R.color.qui_common_bg_bottom_standard));
            if (TextUtils.isEmpty(f16)) {
                this.mTipView.setVisibility(8);
                return;
            } else {
                this.mTipView.setClickable(true);
                this.mTipView.setText(f16);
                return;
            }
        }
        if (TextUtils.isEmpty(tipStr)) {
            this.mTipView.setVisibility(8);
            return;
        }
        this.mTipView.setText(tipStr);
        this.mTipView.setOnClickListener(this.mTipViewOnClickListener);
        this.mTipView.setTextColor(context.getResources().getColor(R.color.qui_common_text_link_selector));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(bm this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(Context context, String url) {
        AppActivity appActivity = (AppActivity) context;
        WebViewBridge.f().k(appActivity, new d(context, this)).a(appActivity, com.tencent.mobileqq.util.l.d(url), null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        if (com.tencent.mobileqq.loginregister.z.b(getContext())) {
            com.tencent.mobileqq.loginregister.z.w(this.mFloatingView);
        } else {
            com.tencent.mobileqq.loginregister.z.A(this.mFloatingView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(List<?> accountList) {
        ViewGroup.LayoutParams layoutParams = this.mBounceScrollView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        if (accountList.size() > 4) {
            layoutParams.height = Utils.n(297.0f, getContext().getResources());
        } else {
            layoutParams.height = -2;
        }
        this.mBounceScrollView.setLayoutParams(layoutParams);
        com.tencent.mobileqq.adapter.ag agVar = new com.tencent.mobileqq.adapter.ag(accountList, this.mOnAccountClickListener, new View.OnTouchListener() { // from class: com.tencent.mobileqq.widget.bl
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean e06;
                e06 = bm.e0(bm.this, view, motionEvent);
                return e06;
            }
        }, this.mShowLoginBtn);
        this.mAccountListView.setAdapter(agVar);
        this.mAccountListView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        agVar.v0(accountList);
        this.mAccountListView.setVerticalScrollBarEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e0(bm this$0, View view, MotionEvent motionEvent) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            this$0.mCanScroll = true;
        } else if (num != null && num.intValue() == 1) {
            this$0.mCanScroll = false;
        }
        return false;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e3i);
        this.mAccountListView.setOverScrollMode(2);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        this.mFloatingView = qUSHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setQUSDragFloatController(new f());
        }
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setBackground(ContextCompat.getDrawable(relativeLayout.getContext(), R.drawable.jc9));
        relativeLayout.addView(new QUSHalfScreenDefaultHeaderView(relativeLayout.getContext()));
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mFloatingView;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.setHeaderView(relativeLayout);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mFloatingView;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.setIsHeightWrapContent(true);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mFloatingView;
        if (qUSHalfScreenFloatingView4 != null) {
            qUSHalfScreenFloatingView4.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.widget.bj
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    bm.a0(bm.this);
                }
            });
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.mFloatingView;
        if (qUSHalfScreenFloatingView5 != null) {
            qUSHalfScreenFloatingView5.setContentDescription(getContext().getResources().getString(R.string.f200324rt));
        }
        c0();
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        Window window = getWindow();
        if (window != null) {
            window.setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.qui_common_bg_bottom_standard));
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.mOrientationEventListener.enable();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mOrientationEventListener.disable();
    }
}
