package ak1;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0098\u0001\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012j\b\u0002\u0010\u0012\u001ad\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007j\u0004\u0018\u0001`\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lak1/b;", "", "", "enableUseCache", "isShowHeadRefresher", "forceScrollTop", "extendArgs", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "errMsg", "", QzoneIPCModule.RESULT_CODE, QAdRewardDefine$VideoParams.ISCACHE, "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/api/IFeedSectionRefreshApiCallback;", "callback", "X4", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, boolean z16, boolean z17, boolean z18, Object obj, Function4 function4, int i3, Object obj2) {
            Object obj3;
            Function4 function42;
            if (obj2 == null) {
                if ((i3 & 8) != 0) {
                    obj3 = null;
                } else {
                    obj3 = obj;
                }
                if ((i3 & 16) != 0) {
                    function42 = null;
                } else {
                    function42 = function4;
                }
                bVar.X4(z16, z17, z18, obj3, function42);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshData");
        }
    }

    void X4(boolean enableUseCache, boolean isShowHeadRefresher, boolean forceScrollTop, @Nullable Object extendArgs, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback);
}
