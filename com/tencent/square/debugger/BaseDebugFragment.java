package com.tencent.square.debugger;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH$J\\\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000e26\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n0\u0011H\u0004J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0019H\u0004J\b\u0010\u001b\u001a\u00020\u0015H\u0016R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/square/debugger/BaseDebugFragment;", "Lcom/tencent/state/VasBaseSubFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "sh", "", "title", "Lkotlin/Function1;", "Lcom/tencent/square/debugger/FormSwitchItem;", "viewAction", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buttonView", "", "isChecked", "action", "qh", "Landroid/view/View$OnClickListener;", "ph", "onBackPressed", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "rh", "()Landroid/widget/LinearLayout;", "setMainView", "(Landroid/widget/LinearLayout;)V", "mainView", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class BaseDebugFragment extends VasBaseSubFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout mainView;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007\u00a8\u0006\t"}, d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged", "com/tencent/square/debugger/BaseDebugFragment$addSwitch$1$1$1", "com/tencent/square/debugger/BaseDebugFragment$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f373493d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2 f373494e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1 f373495f;

        a(String str, Function2 function2, Function1 function1) {
            this.f373493d = str;
            this.f373494e = function2;
            this.f373495f = function1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton buttonView, boolean z16) {
            Function2 function2 = this.f373494e;
            Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
            function2.invoke(buttonView, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        super.onBackPressed();
        popFragment(this);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        linearLayout.addView(new View(linearLayout.getContext()), new LinearLayout.LayoutParams(-1, ViewExtensionsKt.dip(linearLayout.getContext(), 80)));
        Unit unit = Unit.INSTANCE;
        this.mainView = linearLayout;
        sh();
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setFillViewport(true);
        scrollView.addView(this.mainView);
        return scrollView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ph(String title, View.OnClickListener action) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(action, "action");
        LinearLayout linearLayout = this.mainView;
        if (linearLayout != null) {
            Button button = new Button(linearLayout.getContext());
            button.setOnClickListener(action);
            button.setBackgroundColor(-16776961);
            button.setText(title);
            button.setTextColor(-1);
            button.setTextSize(12.0f);
            button.setIncludeFontPadding(false);
            Unit unit = Unit.INSTANCE;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(20, 5, 20, 5);
            linearLayout.addView(button, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void qh(String title, Function1<? super FormSwitchItem, Unit> viewAction, Function2<? super View, ? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(viewAction, "viewAction");
        Intrinsics.checkNotNullParameter(action, "action");
        LinearLayout linearLayout = this.mainView;
        if (linearLayout != null) {
            Context context = linearLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            FormSwitchItem formSwitchItem = new FormSwitchItem(context);
            formSwitchItem.setText(title);
            formSwitchItem.setOnCheckedChangeListener(new a(title, action, viewAction));
            viewAction.invoke(formSwitchItem);
            Unit unit = Unit.INSTANCE;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(20, 5, 20, 5);
            linearLayout.addView(formSwitchItem, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rh, reason: from getter */
    public final LinearLayout getMainView() {
        return this.mainView;
    }

    protected abstract void sh();
}
