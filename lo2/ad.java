package lo2;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lo2.SearchSuggestItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B?\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0014\u001a\u00020\r\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\""}, d2 = {"Llo2/ad;", "Llo2/m;", "", "u", "", "Llo2/ao;", "b0", "Ljava/util/List;", "W", "()Ljava/util/List;", "setSearchSuggestList", "(Ljava/util/List;)V", "searchSuggestList", "", "c0", "Ljava/lang/String;", "X", "()Ljava/lang/String;", "setTraceId", "(Ljava/lang/String;)V", "traceId", "keyword", "", "parentGroupMask", "", "highLightWordList", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsResultItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "from", "<init>", "(Ljava/lang/String;JLjava/util/List;Lcom/tencent/qqnt/kernel/nativeinterface/UfsResultItem;ILjava/lang/String;)V", "d0", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ad extends m {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchSuggestItem> searchSuggestList;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String traceId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(@NotNull String keyword, long j3, @NotNull List<String> highLightWordList, @NotNull UfsResultItem item, int i3, @NotNull String traceId) {
        super(keyword, j3, highLightWordList, item, i3);
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(highLightWordList, "highLightWordList");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.searchSuggestList = new ArrayList();
        this.traceId = "";
        byte[] bArr = item.layoutContent;
        Intrinsics.checkNotNullExpressionValue(bArr, "item.layoutContent");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(bArr, UTF_8);
        this.traceId = traceId;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("items");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i16 = 0; i16 < length; i16++) {
                        JSONObject jsonItem = optJSONArray.optJSONObject(i16);
                        SearchSuggestItem.Companion companion = SearchSuggestItem.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(jsonItem, "jsonItem");
                        this.searchSuggestList.add(companion.a(jsonItem));
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("NetSearchTemplateSearchSuggestItem", 1, "parseLayoutExtensions  error:" + e16);
            }
        }
    }

    @NotNull
    public final List<SearchSuggestItem> W() {
        return this.searchSuggestList;
    }

    @Nullable
    /* renamed from: X, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    @NotNull
    public CharSequence u() {
        return "\u641c\u7d22\u5efa\u8bae";
    }
}
