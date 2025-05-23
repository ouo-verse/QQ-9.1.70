package com.tencent.ecommerce.biz.mainpage;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECMainPagePayConfigFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getContentLayoutId", "", "getBusinessDescription", "", "Bh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "<init>", "()V", "P", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMainPagePayConfigFragment extends ECBaseFragment {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f102943d;

        b(TextView textView) {
            this.f102943d = textView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            String str;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IECLocalConfig.a.h(ECLocalConfig.f100650f, "is_release_env", z16, null, 4, null);
            if (z16) {
                str = "\u6b63\u5f0f\u73af\u5883";
            } else {
                str = "\u6c99\u7bb1\u73af\u5883";
            }
            this.f102943d.setText(str);
            i.f(i.f101155b, "\u5df2\u5207\u6362\u5230 " + str, null, 0, 6, null);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECMainPagePayConfigFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.csz;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u7c73\u5927\u5e08\u652f\u4ed8\u73af\u5883\u8bbe\u7f6e");
        TextView textView = (TextView) view.findViewById(R.id.ny_);
        Switch r85 = (Switch) view.findViewById(R.id.o69);
        r85.setOnCheckedChangeListener(new b(textView));
        boolean c16 = IECLocalConfig.a.c(ECLocalConfig.f100650f, "is_release_env", true, null, 4, null);
        r85.setChecked(c16);
        if (c16) {
            str = "\u6b63\u5f0f\u73af\u5883";
        } else {
            str = "\u6c99\u7bb1\u73af\u5883";
        }
        textView.setText(str);
    }
}
