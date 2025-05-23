package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.f;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.MessageTypeSettingsViewModel;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowCollector;
import mqq.app.Constants;
import zf2.MessageSettingItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\nH\u0002J$\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0016\u0010&\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/MessageTypeSettingsFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initView", "initViewModel", "Ch", "", "Lzf2/c;", QCircleDaTongConstant.ElementParamValue.SETTINGS, "Dh", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "type", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "status", "Ah", "", "checked", "switchable", "yh", "vh", "", "index", "totalSize", "wh", "", "xh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "contentView", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "settingsContainer", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/MessageTypeSettingsViewModel;", "E", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/MessageTypeSettingsViewModel;", "viewModel", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MessageTypeSettingsFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup contentView;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout settingsContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private MessageTypeSettingsViewModel viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/MessageTypeSettingsViewModel$a;", "result", "", "a", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/MessageTypeSettingsViewModel$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    static final class b<T> implements FlowCollector {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(MessageTypeSettingsViewModel.UpdateItemResult updateItemResult, Continuation<? super Unit> continuation) {
            String string;
            if (updateItemResult.getIsSucceed()) {
                e status = updateItemResult.getStatus();
                if (status instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.a) {
                    string = MessageTypeSettingsFragment.this.getString(R.string.wvy, updateItemResult.getType().getText());
                } else if (status instanceof f) {
                    string = MessageTypeSettingsFragment.this.getString(R.string.wvz, updateItemResult.getType().getText());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                Intrinsics.checkNotNullExpressionValue(string, "when (result.status) {\n \u2026xt)\n                    }");
                QQToast.makeText(MessageTypeSettingsFragment.this.requireContext(), string, 2).show();
            } else {
                QQToast.makeText(MessageTypeSettingsFragment.this.requireContext(), MessageTypeSettingsFragment.this.getString(R.string.ww5), 1).show();
                MessageTypeSettingsFragment.this.Ah(updateItemResult.getType(), updateItemResult.getStatus());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(final MessageType type, final e status) {
        LinearLayout linearLayout = this.settingsContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsContainer");
            linearLayout = null;
        }
        FormSwitchSimpleItem formSwitchSimpleItem = (FormSwitchSimpleItem) linearLayout.findViewWithTag(xh(type));
        if (formSwitchSimpleItem != null) {
            formSwitchSimpleItem.setOnCheckedChangeListener(null);
            formSwitchSimpleItem.setChecked(vh(status));
            formSwitchSimpleItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.c
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    MessageTypeSettingsFragment.Bh(MessageTypeSettingsFragment.this, type, status, compoundButton, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(MessageTypeSettingsFragment this$0, MessageType type, e status, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(status, "$status");
        MessageTypeSettingsViewModel messageTypeSettingsViewModel = this$0.viewModel;
        if (messageTypeSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageTypeSettingsViewModel = null;
        }
        messageTypeSettingsViewModel.R1(type, this$0.yh(!z16, status.getSwitchable()), this$0.yh(z16, status.getSwitchable()));
    }

    private final void Ch() {
        MessageTypeSettingsViewModel messageTypeSettingsViewModel = this.viewModel;
        if (messageTypeSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageTypeSettingsViewModel = null;
        }
        messageTypeSettingsViewModel.N1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh(List<MessageSettingItem> settings) {
        int i3 = 0;
        int parseColor = ThemeUtil.isNowThemeIsNight(ECRuntimeManager.INSTANCE.b(), false, null) ? Color.parseColor("#262626") : -1;
        LinearLayout linearLayout = this.settingsContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        for (Object obj : settings) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final MessageSettingItem messageSettingItem = (MessageSettingItem) obj;
            final boolean switchable = messageSettingItem.getStatus().getSwitchable();
            if (switchable) {
                FormSwitchSimpleItem formSwitchSimpleItem = new FormSwitchSimpleItem(requireContext());
                formSwitchSimpleItem.setTag(xh(messageSettingItem.getType()));
                formSwitchSimpleItem.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                formSwitchSimpleItem.setFocusable(true);
                formSwitchSimpleItem.setBgType(wh(i3, settings.size()));
                formSwitchSimpleItem.setBackgroundColor(parseColor);
                formSwitchSimpleItem.setText(messageSettingItem.getType().getText());
                formSwitchSimpleItem.setChecked(vh(messageSettingItem.getStatus()));
                formSwitchSimpleItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.b
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                        MessageTypeSettingsFragment.Eh(MessageTypeSettingsFragment.this, messageSettingItem, switchable, compoundButton, z16);
                    }
                });
                LinearLayout linearLayout2 = this.settingsContainer;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsContainer");
                    linearLayout2 = null;
                }
                linearLayout2.addView(formSwitchSimpleItem);
            }
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(MessageTypeSettingsFragment this$0, MessageSettingItem data, boolean z16, CompoundButton compoundButton, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        MessageTypeSettingsViewModel messageTypeSettingsViewModel = this$0.viewModel;
        if (messageTypeSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageTypeSettingsViewModel = null;
        }
        messageTypeSettingsViewModel.R1(data.getType(), this$0.yh(!z17, z16), this$0.yh(z17, z16));
    }

    private final void initView() {
        String str;
        ViewGroup viewGroup = null;
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(ECRuntimeManager.INSTANCE.b(), false, null);
        int parseColor = isNowThemeIsNight ? Color.parseColor("#1A1A1A") : -1;
        if (isNowThemeIsNight) {
            str = "#0D0D0D";
        } else {
            str = "#F5F5F5";
        }
        int parseColor2 = Color.parseColor(str);
        int i3 = isNowThemeIsNight ? -1 : -16777216;
        ViewGroup viewGroup2 = this.contentView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            viewGroup2 = null;
        }
        viewGroup2.setBackgroundColor(parseColor2);
        ViewGroup viewGroup3 = this.contentView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            viewGroup3 = null;
        }
        NavBarCommon navBarCommon = (NavBarCommon) viewGroup3.findViewById(R.id.ogl);
        ViewGroup.LayoutParams layoutParams = navBarCommon.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).topMargin = ImmersiveUtils.getStatusBarHeight(requireContext());
        navBarCommon.setLayoutParams(layoutParams);
        navBarCommon.setTitle(getString(R.string.f169660ww4));
        navBarCommon.changeBg(!isNowThemeIsNight);
        navBarCommon.setBackgroundColor(parseColor);
        navBarCommon.setTitleColor(i3);
        navBarCommon.setOnItemSelectListener(new a());
        ViewGroup viewGroup4 = this.contentView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            viewGroup = viewGroup4;
        }
        View findViewById = viewGroup.findViewById(R.id.og6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.content)");
        this.settingsContainer = (LinearLayout) findViewById;
    }

    private final void initViewModel() {
        MessageTypeSettingsViewModel messageTypeSettingsViewModel = (MessageTypeSettingsViewModel) new d(MessageCenterModule.f263229a.j()).create(MessageTypeSettingsViewModel.class);
        this.viewModel = messageTypeSettingsViewModel;
        if (messageTypeSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageTypeSettingsViewModel = null;
        }
        LiveData<List<MessageSettingItem>> P1 = messageTypeSettingsViewModel.P1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends MessageSettingItem>, Unit> function1 = new Function1<List<? extends MessageSettingItem>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.MessageTypeSettingsFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MessageSettingItem> list) {
                invoke2((List<MessageSettingItem>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MessageSettingItem> result) {
                MessageTypeSettingsFragment messageTypeSettingsFragment = MessageTypeSettingsFragment.this;
                Intrinsics.checkNotNullExpressionValue(result, "result");
                messageTypeSettingsFragment.Dh(result);
            }
        };
        P1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessageTypeSettingsFragment.zh(Function1.this, obj);
            }
        });
        Lifecycle.State state = Lifecycle.State.STARTED;
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new MessageTypeSettingsFragment$initViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, state, null, this), 3, null);
    }

    private final boolean vh(e status) {
        return status instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.a;
    }

    private final int wh(int index, int totalSize) {
        if (totalSize == 1) {
            return 0;
        }
        if (index == 0) {
            return 1;
        }
        if (index == totalSize - 1) {
            return 3;
        }
        return 2;
    }

    private final String xh(MessageType type) {
        return "Switch_" + type.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.cvp, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.contentView = viewGroup;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
        Ch();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/MessageTypeSettingsFragment$a", "Lcom/tencent/mobileqq/widget/navbar/a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.widget.navbar.a {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View v3, int item) {
            FragmentActivity activity;
            if (item != 1 || (activity = MessageTypeSettingsFragment.this.getActivity()) == null) {
                return;
            }
            activity.finish();
        }
    }

    private final e yh(boolean checked, boolean switchable) {
        if (checked) {
            return new com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.a(switchable);
        }
        return new f(switchable);
    }
}
