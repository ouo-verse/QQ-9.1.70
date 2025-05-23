package dj4;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0006B;\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR>\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Ldj4/a;", "", "", "e", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setCardRichText", "(Ljava/lang/String;)V", "cardRichText", "b", "setJumpUrl", WadlProxyConsts.KEY_JUMP_URL, "c", "setProductId", "productId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setReportInfo", "(Ljava/util/HashMap;)V", CacheTable.TABLE_NAME, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String cardRichText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String jumpUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String productId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private HashMap<String, String> reportInfo;

    public a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map) {
        this.cardRichText = str;
        this.jumpUrl = str2;
        this.productId = str3;
        HashMap<String, String> hashMap = new HashMap<>();
        this.reportInfo = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCardRichText() {
        return this.cardRichText;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    @NotNull
    public final HashMap<String, String> d() {
        return this.reportInfo;
    }

    public final boolean e() {
        if (!TextUtils.isEmpty(this.cardRichText) && !TextUtils.isEmpty(this.jumpUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "ProductInfo[ cardRichText=" + this.cardRichText + ", jumpUrl=" + this.jumpUrl + ", productId=" + this.productId + ", reportInfo=" + this.reportInfo + "], isValid=" + e();
    }
}
