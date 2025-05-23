package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qzone.QzoneIPCModule;
import ij1.GuildFeedsHeaderData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002J\u00b6\u0001\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00042j\b\u0002\u0010\u0017\u001ad\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000ej\u0004\u0018\u0001`\u0016H&J\u00ac\u0001\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00042j\b\u0002\u0010\u0017\u001ad\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000ej\u0004\u0018\u0001`\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e0\u001d0\u001cH&J\b\u0010 \u001a\u00020\u0006H\u0016J\u0016\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u001d\u0018\u00010\u001cH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/n;", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "Lij1/g;", "", "enableUseCache", "", "refreshMode", "", "topFeedId", "topChannelId", MiniChatConstants.MINI_APP_TOP_TYPE, "topBusinessId", "forceScrollTop", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", QzoneIPCModule.RESULT_CODE, QAdRewardDefine$VideoParams.ISCACHE, "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/api/IFeedSectionRefreshApiCallback;", "callback", "P0", "C1", tl.h.F, DomainData.DOMAIN_NAME, "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "j", "p", "Lij1/d;", "X", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface k extends n, IDataDisplaySurface<ij1.g> {
    void C1(boolean enableUseCache, int refreshMode, @NotNull String topChannelId, int topType, @NotNull String topBusinessId, boolean forceScrollTop, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback);

    void P0(boolean enableUseCache, int refreshMode, @NotNull String topFeedId, @NotNull String topChannelId, int topType, @NotNull String topBusinessId, boolean forceScrollTop, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback);

    @Nullable
    MutableLiveData<UIStateData<GuildFeedsHeaderData>> X();

    void h();

    @NotNull
    MutableLiveData<UIStateData<List<ij1.g>>> j();

    void n(int refreshMode);

    int p();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static void a(@NotNull k kVar, boolean z16, int i3, @NotNull String topChannelId, int i16, @NotNull String topBusinessId, boolean z17, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> function4) {
            Intrinsics.checkNotNullParameter(topChannelId, "topChannelId");
            Intrinsics.checkNotNullParameter(topBusinessId, "topBusinessId");
        }

        public static /* synthetic */ void c(k kVar, boolean z16, int i3, String str, String str2, int i16, String str3, boolean z17, Function4 function4, int i17, Object obj) {
            String str4;
            String str5;
            int i18;
            String str6;
            boolean z18;
            Function4 function42;
            if (obj == null) {
                if ((i17 & 4) != 0) {
                    str4 = "";
                } else {
                    str4 = str;
                }
                if ((i17 & 8) != 0) {
                    str5 = "";
                } else {
                    str5 = str2;
                }
                if ((i17 & 16) != 0) {
                    i18 = 0;
                } else {
                    i18 = i16;
                }
                if ((i17 & 32) != 0) {
                    str6 = "";
                } else {
                    str6 = str3;
                }
                if ((i17 & 64) != 0) {
                    z18 = false;
                } else {
                    z18 = z17;
                }
                if ((i17 & 128) != 0) {
                    function42 = null;
                } else {
                    function42 = function4;
                }
                kVar.P0(z16, i3, str4, str5, i18, str6, z18, function42);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refresh");
        }

        public static void b(@NotNull k kVar) {
        }
    }
}
