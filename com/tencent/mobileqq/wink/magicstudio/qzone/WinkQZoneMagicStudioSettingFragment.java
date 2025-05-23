package com.tencent.mobileqq.wink.magicstudio.qzone;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioSettingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View;", "contentView", "", "initView", "initViewModel", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onDestroyView", "", "onBackEvent", "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "magicStudioViewModel", "", "D", "Ljava/lang/String;", "settingPromptStr", "<init>", "()V", "E", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneMagicStudioSettingFragment extends QPublicBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneMagicStudioViewModel magicStudioViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String settingPromptStr = "\u5f00\u542f\u540e\uff0c\u4f60\u8fd1\u671f\u5728%s\u4e2d\u4e0a\u4f20\u8fc7\u7684\u7167\u7247\u5c06\u4f1a\u88ab\u4fdd\u5b58\u5e76\u5c55\u793a\u51fa\u6765\uff0c\u65b9\u4fbf\u4e0b\u6b21\u7acb\u5373\u4f7f\u7528\u8fd9\u4e9b\u7167\u7247";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioSettingFragment$a;", "", "", "magicStudioTitle", "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioSettingFragment;", "a", "PARAM_KEY_TITLE", "Ljava/lang/String;", "SETTING_PROMPT_STR", "TAG", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkQZoneMagicStudioSettingFragment a(@NotNull String magicStudioTitle) {
            Intrinsics.checkNotNullParameter(magicStudioTitle, "magicStudioTitle");
            WinkQZoneMagicStudioSettingFragment winkQZoneMagicStudioSettingFragment = new WinkQZoneMagicStudioSettingFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param_key_title", magicStudioTitle);
            winkQZoneMagicStudioSettingFragment.setArguments(bundle);
            return winkQZoneMagicStudioSettingFragment;
        }

        Companion() {
        }
    }

    private final void initView(View contentView) {
        final View findViewById = contentView.findViewById(R.id.f123337gd);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkQZoneMagicStudioSettingFragment.rh(WinkQZoneMagicStudioSettingFragment.this, findViewById, view);
                }
            });
        }
        final Switch r06 = (Switch) contentView.findViewById(R.id.f123367gg);
        if (r06 != null) {
            boolean b16 = m83.a.f416440a.b();
            r06.setChecked(b16);
            w53.b.a("WinkQZoneMagicStudioSettingFragment", "currentCheckValue:" + b16);
            m83.b.f416442a.C(r06, b16);
            r06.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.c
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    WinkQZoneMagicStudioSettingFragment.sh(Switch.this, this, compoundButton, z16);
                }
            });
        }
        ((TextView) contentView.findViewById(R.id.f123347ge)).setText(this.settingPromptStr);
    }

    private final void initViewModel() {
        this.magicStudioViewModel = WinkQZoneMagicStudioViewModel.INSTANCE.a(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(WinkQZoneMagicStudioSettingFragment this$0, View this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.onBackEvent();
        m83.b.f416442a.A(this_apply);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(Switch switchView, WinkQZoneMagicStudioSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(switchView, "$switchView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("WinkQZoneMagicStudioSettingFragment", "switchView isChecked:" + z16);
        m83.b.f416442a.B(switchView, z16);
        m83.a aVar = m83.a.f416440a;
        aVar.k(z16);
        ar.f326685a.s("qzone_magic_studio_enable_save_history", z16);
        if (!z16) {
            aVar.a(null, 0);
            WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel = this$0.magicStudioViewModel;
            if (winkQZoneMagicStudioViewModel != null) {
                winkQZoneMagicStudioViewModel.R1();
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i7c;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.popBackStack();
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e eVar = e.f326265a;
        View fragmentContentView = getFragmentContentView();
        Intrinsics.checkNotNullExpressionValue(fragmentContentView, "fragmentContentView");
        eVar.w(fragmentContentView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        String qqStr;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[1];
        Bundle arguments = getArguments();
        if (arguments == null || (qqStr = arguments.getString("param_key_title")) == null) {
            qqStr = HardCodeUtil.qqStr(R.string.f240847q_);
        }
        objArr[0] = qqStr;
        String format = String.format("\u5f00\u542f\u540e\uff0c\u4f60\u8fd1\u671f\u5728%s\u4e2d\u4e0a\u4f20\u8fc7\u7684\u7167\u7247\u5c06\u4f1a\u88ab\u4fdd\u5b58\u5e76\u5c55\u793a\u51fa\u6765\uff0c\u65b9\u4fbf\u4e0b\u6b21\u7acb\u5373\u4f7f\u7528\u8fd9\u4e9b\u7167\u7247", Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.settingPromptStr = format;
        initView(contentView);
        initViewModel();
        m83.b.f416442a.z(contentView, getActivity());
    }
}
