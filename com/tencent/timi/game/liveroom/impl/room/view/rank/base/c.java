package com.tencent.timi.game.liveroom.impl.room.view.rank.base;

import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.view.rank.RankViewModel;
import d55.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0015\u001a\u00020\u0002H\u0004J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0004J\b\u0010\u0018\u001a\u00020\u0002H\u0004J\b\u0010\u0019\u001a\u00020\u0002H\u0004J\b\u0010\u001a\u001a\u00020\fH\u0004J\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0017\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016\u00a2\u0006\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u0010\b\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b.\u0010/R$\u0010\u000b\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\"\u0010'\u001a\u0004\b0\u00101R$\u0010\t\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b \u0010-\u001a\u0004\b)\u0010/R$\u0010\r\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0004\u00102\u001a\u0004\b3\u00104\u00a8\u00067"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/c;", "", "", "name", "f", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/RankViewModel;", "viewModel", "", "roomId", "anchorId", "", "isAnchor", "", "roomType", "", "o", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView;", "rankWebView", "r", "url", "a", "c", "g", tl.h.F, "l", "i", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/RankViewModel$a;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ld55/j;", "e", "Ld55/e;", "d", "", "Ld55/h;", "k", "()[Ld55/h;", "Z", "isLoadUrl", "b", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/RankViewModel;", "rankViewModel", "<set-?>", "J", "j", "()J", "p", "()Z", "I", "getRoomType", "()I", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RankViewModel rankViewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long roomId = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long anchorId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    private final String f(String name) {
        String str = "javascript:window.__WEBVIEW_CHANGETAB(" + g(name) + ")";
        QLog.i("BaseRankViewModel", 1, "getCallJs:>>>" + str);
        return str;
    }

    @NotNull
    protected String a(@NotNull String url, @NotNull String name) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(name, "name");
        if (TextUtils.equals(name, "rankRule")) {
            str = "appId=" + c() + "&roomId=" + this.roomId + "&qqLiveZhiBoType=" + n() + "&isAnchor=" + this.isAnchor;
        } else {
            str = "appId=" + c() + "&qqliveAnchorId=" + this.anchorId + "&roomId=" + this.roomId + "&qqLiveZhiBoType=" + n() + "&isAnchor=" + this.isAnchor;
        }
        String a16 = com.tencent.qqlive.common.webview.a.a(url, str);
        Intrinsics.checkNotNullExpressionValue(a16, "appendArgs(url, appendArgs)");
        return a16;
    }

    /* renamed from: b, reason: from getter */
    public final long getAnchorId() {
        return this.anchorId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String c() {
        String qQLiveAppId = QQLiveSDKConfigHelper.getQQLiveAppId();
        Intrinsics.checkNotNullExpressionValue(qQLiveAppId, "getQQLiveAppId()");
        return qQLiveAppId;
    }

    @Nullable
    public d55.e d() {
        RankViewModel rankViewModel = this.rankViewModel;
        if (rankViewModel != null) {
            return rankViewModel.j();
        }
        return null;
    }

    @Nullable
    public final j e() {
        RankViewModel rankViewModel = this.rankViewModel;
        if (rankViewModel != null) {
            return rankViewModel.k();
        }
        return null;
    }

    @NotNull
    protected String g(@NotNull String name) {
        d55.e eVar;
        Intrinsics.checkNotNullParameter(name, "name");
        RankViewModel rankViewModel = this.rankViewModel;
        if (rankViewModel != null) {
            eVar = rankViewModel.j();
        } else {
            eVar = null;
        }
        if (eVar == null) {
            return "";
        }
        h hVar = new h(eVar, name);
        long j3 = this.anchorId;
        if (j3 > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(j3);
            hVar.d(sb5.toString());
        }
        hVar.c(l());
        long j16 = this.roomId;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(j16);
        hVar.h(sb6.toString());
        hVar.e(h());
        hVar.f(i());
        int n3 = n();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(n3);
        hVar.g(sb7.toString());
        return hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String h() {
        String str;
        BaseRoomInfo q16 = ((jg4.b) mm4.b.b(jg4.b.class)).q(this.roomId);
        if (q16 != null) {
            str = q16.getProgramId();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String i() {
        return QQLiveBusinessConfig.QQLIVE_APP_ID;
    }

    /* renamed from: j, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @Nullable
    public d55.h[] k() {
        d55.e j3;
        RankViewModel rankViewModel = this.rankViewModel;
        if (rankViewModel != null && (j3 = rankViewModel.j()) != null) {
            return j3.f393068c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String l() {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "api(IAccountRuntime::class.java).account");
        return account;
    }

    @NotNull
    public final String m() {
        String str;
        d55.e j3;
        RankViewModel rankViewModel = this.rankViewModel;
        if (rankViewModel != null && (j3 = rankViewModel.j()) != null) {
            str = j3.f393067b;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int n() {
        int i3 = this.roomType;
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public final void o(@NotNull RankViewModel viewModel, long roomId, long anchorId, boolean isAnchor, int roomType) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        QLog.i("BaseRankViewModel", 1, "initData: roomId:" + roomId + " anchorId:" + anchorId + " isAnchor:" + isAnchor + " roomType:" + roomType);
        this.rankViewModel = viewModel;
        this.roomId = roomId;
        this.anchorId = anchorId;
        this.isAnchor = isAnchor;
        this.roomType = roomType;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsAnchor() {
        return this.isAnchor;
    }

    public final void q(@NotNull RankViewModel.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        RankViewModel rankViewModel = this.rankViewModel;
        if (rankViewModel != null) {
            rankViewModel.n(callback);
        }
    }

    public final void r(@NotNull RankWebView rankWebView, @NotNull String name) {
        d55.e j3;
        String str;
        Intrinsics.checkNotNullParameter(rankWebView, "rankWebView");
        Intrinsics.checkNotNullParameter(name, "name");
        QLog.i("BaseRankViewModel", 1, "loadUrl: name:" + name);
        RankViewModel rankViewModel = this.rankViewModel;
        if (rankViewModel != null && (j3 = rankViewModel.j()) != null && (str = j3.f393067b) != null) {
            String a16 = a(str, name);
            QLog.i("BaseRankViewModel", 1, "loadUrl: url:" + str + " urlWithArgs:" + a16);
            if (!this.isLoadUrl) {
                rankWebView.loadUrl(a16);
                this.isLoadUrl = true;
            }
            rankWebView.loadUrl(f(name));
        }
    }
}
