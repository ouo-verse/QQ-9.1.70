package com.tencent.hippykotlin.demo.pages.nearby.public_account;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.NBPBaseActivity;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;

/* loaded from: classes31.dex */
public final class QQStrangerPublicAccountActivity extends NBPBaseActivity {
    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        b.c(this, null, ComposableSingletons$QQStrangerPublicAccountActivityKt.f87lambda1, 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }
}
