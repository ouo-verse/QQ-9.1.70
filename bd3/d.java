package bd3;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lbd3/d;", "Lbd3/e;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "", "getSmallHomeMasterUin", "d", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMasterUin", "(Ljava/lang/String;)V", "masterUin", "f", "a", "setMasterNickName", "masterNickName", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d implements e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZootopiaSource source;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String masterUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String masterNickName;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getMasterNickName() {
        return this.masterNickName;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getMasterUin() {
        return this.masterUin;
    }

    @Override // bd3.e
    @Nullable
    public String getSmallHomeMasterUin() {
        return this.masterUin;
    }

    @Override // bd3.e
    @Nullable
    public ZootopiaSource getSource() {
        return this.source;
    }
}
