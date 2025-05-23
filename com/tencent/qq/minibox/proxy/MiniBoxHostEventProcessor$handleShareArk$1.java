package com.tencent.qq.minibox.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.minigame.api.IArkShareForMiniBoxApi;
import com.tencent.mobileqq.minigame.api.OnSharePrepareListener;
import com.tencent.mobileqq.minigame.api.ShareAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCModule;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "shareAppInfo", "Lcom/tencent/mobileqq/minigame/api/ShareAppInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class MiniBoxHostEventProcessor$handleShareArk$1 extends Lambda implements Function1<ShareAppInfo, Unit> {
    final /* synthetic */ int $callbackId;
    final /* synthetic */ EIPCModule $eipcModule;
    final /* synthetic */ String $pkgName;
    final /* synthetic */ String $schema;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniBoxHostEventProcessor$handleShareArk$1(String str, String str2, EIPCModule eIPCModule, int i3) {
        super(1);
        this.$pkgName = str;
        this.$schema = str2;
        this.$eipcModule = eIPCModule;
        this.$callbackId = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EIPCModule eipcModule, int i3, MiniArkShareModel miniArkShareModel, JSONObject jSONObject, int i16) {
        Intrinsics.checkNotNullParameter(eipcModule, "$eipcModule");
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_SHARE_ARK_SHARE_TYPE", i16);
        if (jSONObject != null) {
            bundle.putString("KEY_SHARE_ARK_RET_JSON", jSONObject.toString());
        }
        if (miniArkShareModel != null) {
            bundle.putSerializable("KEY_SHARE_ARK_PREPARED_MODEL", miniArkShareModel);
        }
        eipcModule.callbackResult(i3, EIPCResult.createResult(0, bundle));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ShareAppInfo shareAppInfo) {
        invoke2(shareAppInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ShareAppInfo shareAppInfo) {
        Intrinsics.checkNotNullParameter(shareAppInfo, "shareAppInfo");
        ns3.b bVar = ns3.b.f421246a;
        String str = this.$pkgName;
        if (str == null) {
            str = "";
        }
        String str2 = this.$schema;
        MiniArkShareModel b16 = bVar.b(str, str2 != null ? str2 : "", shareAppInfo);
        if (b16 != null) {
            final EIPCModule eIPCModule = this.$eipcModule;
            final int i3 = this.$callbackId;
            ((IArkShareForMiniBoxApi) QRoute.api(IArkShareForMiniBoxApi.class)).prepareArkModel(b16, new OnSharePrepareListener() { // from class: com.tencent.qq.minibox.proxy.m
                @Override // com.tencent.mobileqq.minigame.api.OnSharePrepareListener
                public final void onSharePrepared(MiniArkShareModel miniArkShareModel, JSONObject jSONObject, int i16) {
                    MiniBoxHostEventProcessor$handleShareArk$1.b(EIPCModule.this, i3, miniArkShareModel, jSONObject, i16);
                }
            });
        }
    }
}
