package com.tencent.mobileqq.activity.aio.helper;

import android.os.Bundle;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/bb;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", "", "state", "onMoveToState", "", "interestedIn", "getId", "", "getTag", "", "d", "Z", "isFromUnbindGuildGroup", "e", "Ljava/lang/String;", "appId", "f", "guildid", tl.h.F, "appName", "<init>", "()V", "i", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class bb implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isFromUnbindGuildGroup;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String guildid;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appName = "";

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350636g1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "TroopUnbindGameGroupHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{3};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.i("TroopUnbindGameGroupHelper", 1, "[onCreate]");
        h.a.a(this, param);
        Bundle l3 = param.a().g().l();
        this.isFromUnbindGuildGroup = l3.getBoolean("isFromGuildBindGroup", false);
        this.appId = l3.getString("appid");
        this.guildid = l3.getString("guildId");
        String string = l3.getString("app_name", "\u6e38\u620f");
        Intrinsics.checkNotNullExpressionValue(string, "it.getString(TroopAbilit\u2026nts.PARAM_APP_NAME, \"\u6e38\u620f\")");
        this.appName = string;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        QLog.i("TroopUnbindGameGroupHelper", 1, "[onMoveToState] state = " + state);
    }
}
