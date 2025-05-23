package com.tencent.open.agent.auth.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter;
import com.tencent.open.agent.util.g;
import hp3.GameCenterAuthPermission;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\"\u0010\u0013\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/open/agent/auth/api/impl/OpenAuthGameCenterPageReporterImpl;", "Lcom/tencent/open/agent/auth/api/IOpenAuthGameCenterPageReporter;", "Landroid/content/Intent;", "intent", "", "getRealAppId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "reportPageShow", "reportBackClick", "reportConfirmClick", "reportRefuseClick", "reportBackDialogShow", "reportBackDialogConfirmClick", "reportBackDialogCancelClick", "", "Lhp3/c;", "gameAuthItemList", "recordGameAuthItemList", "<init>", "()V", "Companion", "a", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class OpenAuthGameCenterPageReporterImpl implements IOpenAuthGameCenterPageReporter {

    @NotNull
    public static final String TAG = "OpenAuthGameCenterPageReporterImpl";

    private final String getRealAppId(Intent intent) {
        if (intent == null) {
            return "";
        }
        long longExtra = intent.getLongExtra("appId", 0L);
        long longExtra2 = intent.getLongExtra("key_proxy_appid", 0L);
        if (longExtra2 != 0) {
            longExtra = longExtra2;
        }
        return String.valueOf(longExtra);
    }

    @Override // com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter
    public void recordGameAuthItemList(@Nullable Activity activity, @Nullable List<GameCenterAuthPermission> gameAuthItemList) {
        Integer valueOf;
        if (activity == null) {
            return;
        }
        Intent intent = activity.getIntent();
        boolean z16 = true;
        if (intent != null && gameAuthItemList != null && !gameAuthItemList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(gameAuthItemList);
            if (!arrayList.isEmpty()) {
                hp3.b.e().s(getRealAppId(intent), arrayList);
                return;
            }
            return;
        }
        if (intent != null) {
            z16 = false;
        }
        if (gameAuthItemList == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(gameAuthItemList.size());
        }
        hd0.c.g(TAG, "recordGameAuthItemList intent = null? " + z16 + ", gameAuthItemList size= " + valueOf);
    }

    @Override // com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter
    public void reportBackClick() {
        g.O("0X800C353");
    }

    @Override // com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter
    public void reportBackDialogCancelClick() {
        g.O("0X800C358");
    }

    @Override // com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter
    public void reportBackDialogConfirmClick() {
        g.O("0X800C357");
    }

    @Override // com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter
    public void reportBackDialogShow() {
        g.O("0X800C356");
    }

    @Override // com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter
    public void reportConfirmClick() {
        g.O("0X800C354");
    }

    @Override // com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter
    public void reportPageShow(@Nullable Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        g.R(null, "0X800C352", new String[]{getRealAppId(intent), "", intent.getStringExtra("appName"), ""});
    }

    @Override // com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter
    public void reportRefuseClick() {
        g.O("0X800C355");
    }
}
