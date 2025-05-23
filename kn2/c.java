package kn2;

import android.app.Activity;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.qqnt.kernel.nativeinterface.SearchChannelConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchMiniAppConditonFilter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JM\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\r\u0010\u000eJh\u0010 \u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH&JX\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH&\u00a8\u0006#"}, d2 = {"Lkn2/c;", "", "", "tabName", "", "tabMask", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "userSource", "perSearchId", "parentType", "sessionId", "", "a", "(Ljava/lang/String;JIILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Landroid/app/Activity;", "context", "keyword", "", "withLBS", "disableCorrectionQuery", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChannelConditonFilter;", "channelConditionFilter", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupConditonFilter;", "groupConditionFilter", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", "miniAppConditionFilter", "source", "pageNum", "pageMode", "Lkn2/b;", "callback", "b", "keyWord", "c", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface c {
    void a(@NotNull String tabName, long tabMask, int querySource, int userSource, @Nullable String perSearchId, @Nullable Integer parentType, @Nullable String sessionId);

    void b(@NotNull Activity context, @NotNull String keyword, boolean withLBS, boolean disableCorrectionQuery, @Nullable SearchChannelConditonFilter channelConditionFilter, @Nullable SearchGroupConditonFilter groupConditionFilter, @Nullable SearchMiniAppConditonFilter miniAppConditionFilter, @NotNull String source, int pageNum, int pageMode, @NotNull b callback);

    void c(@NotNull String keyWord, boolean disableCorrectionQuery, @Nullable SearchChannelConditonFilter channelConditionFilter, @Nullable SearchGroupConditonFilter groupConditionFilter, @Nullable SearchMiniAppConditonFilter miniAppConditionFilter, @NotNull String source, int pageNum, int pageMode, @NotNull b callback);
}
