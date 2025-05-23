package oi4;

import com.tencent.mobileqq.utils.abtest.IOnlineExpProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Loi4/a;", "Lcom/tencent/mobileqq/utils/abtest/IOnlineExpProvider;", "", "", "getRegisterExpNameList", "", "getBusinessProfiles", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements IOnlineExpProvider {
    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    @NotNull
    public Map<String, String> getBusinessProfiles() {
        return new HashMap();
    }

    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    @NotNull
    public List<String> getRegisterExpNameList() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }
}
