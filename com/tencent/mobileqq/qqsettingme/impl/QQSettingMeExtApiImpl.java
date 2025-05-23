package com.tencent.mobileqq.qqsettingme.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqsettingme.IQQSettingMeExtApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqsettingme/impl/QQSettingMeExtApiImpl;", "Lcom/tencent/mobileqq/qqsettingme/IQQSettingMeExtApi;", "()V", "getVipLevelLayout", "", "getVipMedalLayout", "getVipNameplateLayout", "getVipView", "Landroid/view/View;", "context", "Landroid/content/Context;", "isV9", "", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class QQSettingMeExtApiImpl implements IQQSettingMeExtApi {
    @Override // com.tencent.mobileqq.qqsettingme.IQQSettingMeExtApi
    public int getVipLevelLayout() {
        return R.layout.f1272304;
    }

    @Override // com.tencent.mobileqq.qqsettingme.IQQSettingMeExtApi
    public int getVipMedalLayout() {
        return R.layout.f1272506;
    }

    @Override // com.tencent.mobileqq.qqsettingme.IQQSettingMeExtApi
    public int getVipNameplateLayout() {
        return R.layout.f1272405;
    }

    @Override // com.tencent.mobileqq.qqsettingme.IQQSettingMeExtApi
    public View getVipView(Context context, boolean isV9) {
        View inflate;
        if (isV9) {
            inflate = LayoutInflater.from(context).inflate(R.layout.f1272708, (ViewGroup) null);
            if (!(inflate instanceof View)) {
                return null;
            }
        } else {
            inflate = LayoutInflater.from(context).inflate(R.layout.f1272607, (ViewGroup) null);
            if (!(inflate instanceof View)) {
                return null;
            }
        }
        return inflate;
    }
}
