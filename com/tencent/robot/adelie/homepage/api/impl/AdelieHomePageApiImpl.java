package com.tencent.robot.adelie.homepage.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.robot.adelie.AdelieFragmentActivity;
import com.tencent.robot.adelie.homepage.AdelieHomeMainFragment;
import com.tencent.robot.adelie.homepage.api.IAdelieHomePageApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/adelie/homepage/api/impl/AdelieHomePageApiImpl;", "Lcom/tencent/robot/adelie/homepage/api/IAdelieHomePageApi;", "()V", "startAdelieHomePage", "", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class AdelieHomePageApiImpl implements IAdelieHomePageApi {
    @Override // com.tencent.robot.adelie.homepage.api.IAdelieHomePageApi
    public void startAdelieHomePage(@Nullable Context context, @Nullable Bundle extras) {
        Intent intent = new Intent();
        if (extras != null) {
            intent.putExtras(extras);
        }
        boolean z16 = false;
        if (extras != null && extras.getBoolean("clear_top")) {
            z16 = true;
        }
        if (z16) {
            intent.addFlags(67108864);
        }
        AdelieFragmentActivity.INSTANCE.a(context, intent, AdelieHomeMainFragment.class);
    }
}
