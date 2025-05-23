package com.tencent.biz.qqcircle.immersive.utils;

import android.os.Bundle;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.tab.mixfeed.QFSMixLiveHallHippyFragment;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tencent.timi.game.api.ticket.IQQLiveTicketApi;
import com.tencent.timi.game.api.ticket.PSKey;
import com.tencent.timi.game.api.ticket.PSKeyCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/aj;", "", "Lcom/tencent/biz/qqcircle/beans/QCircleTabInfo;", "tabInfo", "", "tabIndex", "Lcom/tencent/biz/qqcircle/immersive/tab/mixfeed/QFSMixLiveHallHippyFragment;", "a", "", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final aj f90122a = new aj();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/aj$a;", "Lcom/tencent/timi/game/api/ticket/PSKeyCallback;", "", "Lcom/tencent/timi/game/api/ticket/PSKey;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "onTimeout", "a", "Ljava/lang/String;", "domain", "<init>", "(Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements PSKeyCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String domain;

        public a(@NotNull String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            this.domain = domain;
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onFailed(@Nullable String msg2) {
            QLog.d("QFSMixLiveFragmentUtil", 1, "update " + this.domain + " PSKey failed:" + msg2);
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onSuccess(@NotNull List<PSKey> pSKeys) {
            Intrinsics.checkNotNullParameter(pSKeys, "pSKeys");
            QLog.d("QFSMixLiveFragmentUtil", 1, "update " + this.domain + " PSKey success");
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onTimeout(@Nullable String msg2) {
            QLog.d("QFSMixLiveFragmentUtil", 1, "update " + this.domain + " PSKey timeout:" + msg2);
        }
    }

    aj() {
    }

    @NotNull
    public final QFSMixLiveHallHippyFragment a(@NotNull QCircleTabInfo tabInfo, int tabIndex) {
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_LIVE_HALL;
        openHippyInfo.framework = "react";
        openHippyInfo.from = "3";
        openHippyInfo.domain = QQLiveCookieConstants.QQ_LIVE_DOMAIN;
        openHippyInfo.url = "buffer=&from=3";
        openHippyInfo.updateJsBundleType = 0;
        openHippyInfo.isCustomNightMode = true;
        QFSMixLiveHallHippyFragment qFSMixLiveHallHippyFragment = new QFSMixLiveHallHippyFragment(tabInfo, tabIndex);
        Bundle bundle = new Bundle();
        bundle.putBundle("params", openHippyInfo.toBundle());
        qFSMixLiveHallHippyFragment.setArguments(bundle);
        return qFSMixLiveHallHippyFragment;
    }

    public final void b() {
        ((IQQLiveTicketApi) QRoute.api(IQQLiveTicketApi.class)).getPsKeysAsync(new String[]{QQLiveCookieConstants.QQ_LIVE_DOMAIN}, new a(QQLiveCookieConstants.QQ_LIVE_DOMAIN));
        ((IQQLiveTicketApi) QRoute.api(IQQLiveTicketApi.class)).getPsKeysAsync(new String[]{QQLiveCookieConstants.NOW_DOMAIN}, new a(QQLiveCookieConstants.NOW_DOMAIN));
    }
}
