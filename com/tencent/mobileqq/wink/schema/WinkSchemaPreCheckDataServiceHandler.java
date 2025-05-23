package com.tencent.mobileqq.wink.schema;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.intermediate.protocol.SHADOW_BACKEND_INTERFACE.GetMaterialInfoByIdsRsp;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheckDataServiceHandler;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "", "serviceId", "", "materialIds", "", ICustomDataEditor.NUMBER_PARAM_3, "(Ljava/lang/String;[Ljava/lang/String;)V", "Lcom/tencent/mobileqq/wink/intermediate/protocol/SHADOW_BACKEND_INTERFACE/GetMaterialInfoByIdsRsp;", "response", "R2", "Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheckDataServiceHandler$a;", "e", "Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheckDataServiceHandler$a;", "getCallback", "()Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheckDataServiceHandler$a;", "r3", "(Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheckDataServiceHandler$a;)V", "callback", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheckDataServiceHandler extends WinkDataServiceHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H&J\b\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheckDataServiceHandler$a;", "", "Ljava/util/HashMap;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/HashMap;", "materials", "", "a", "onFailed", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(@NotNull HashMap<String, MetaMaterial> materials);

        void onFailed();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheckDataServiceHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler
    protected void R2(@NotNull GetMaterialInfoByIdsRsp response) {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            Map<String, MetaMaterial> map = response.MaterialInfo;
            if (map != null && !map.isEmpty()) {
                HashMap<String, MetaMaterial> hashMap = new HashMap<>();
                for (String key : map.keySet()) {
                    MetaMaterial metaMaterial = map.get(key);
                    if (metaMaterial != null) {
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        hashMap.put(key, y53.b.b(metaMaterial));
                    }
                }
                a aVar = this.callback;
                if (aVar != null) {
                    aVar.a(hashMap);
                    return;
                }
                return;
            }
            a aVar2 = this.callback;
            if (aVar2 != null) {
                aVar2.onFailed();
            }
        } catch (Exception unused) {
            a aVar3 = this.callback;
            if (aVar3 != null) {
                aVar3.onFailed();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler
    public void n3(@Nullable String serviceId, @NotNull String... materialIds) {
        Intrinsics.checkNotNullParameter(materialIds, "materialIds");
        if (!NetworkUtil.isNetworkAvailable()) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        super.n3(serviceId, (String[]) Arrays.copyOf(materialIds, materialIds.length));
    }

    public final void r3(@Nullable a aVar) {
        this.callback = aVar;
    }
}
