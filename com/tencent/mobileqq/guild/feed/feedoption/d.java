package com.tencent.mobileqq.guild.feed.feedoption;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.base.extension.o;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemCbData;
import com.tencent.mobileqq.qqguildsdk.data.genc.ar;
import com.tencent.mobileqq.qqguildsdk.data.genc.cx;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImpeachReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImpeachRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProImpeachCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003J*\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedoption/d;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "account", "", "onAccountChanged", "getLogTag", "init", "feedId", "Q1", "contentType", "scene", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProItemCbData;", "cbData", "O1", "Lmqq/app/AppRuntime;", "i", "Lmqq/app/AppRuntime;", "app", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends BaseViewModel implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AppRuntime app;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static ViewModelProvider.Factory C = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedoption/d$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new d();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedoption/d$b;", "", "Landroidx/lifecycle/ViewModelProvider$Factory;", "sViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "a", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setSViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedoption.d$b, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ViewModelProvider.Factory a() {
            return d.C;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(String feedId, String contentType, String scene, int i3, String str) {
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        Intrinsics.checkNotNullParameter(contentType, "$contentType");
        Intrinsics.checkNotNullParameter(scene, "$scene");
        Logger.f235387a.d().d("GuildFeedOptionViewModel", 1, "result:" + i3 + ", errMsg:" + str + ", feedId:" + feedId + ", contentType:" + contentType + ", scene:" + scene);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(String feedId, int i3, String str, boolean z16, GProImpeachRsp gProImpeachRsp) {
        boolean z17;
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        Logger.a d16 = Logger.f235387a.d();
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        d16.d("GuildFeedOptionViewModel", 1, "[doReport] feedId:" + feedId + ", isSuccess:" + z17 + ", retCode:" + i3 + ", errMsg:" + str + ", res:" + gProImpeachRsp);
    }

    public final void O1(@NotNull final String contentType, @NotNull final String feedId, @NotNull final String scene, @Nullable IGProItemCbData cbData) {
        IGPSService iGPSService;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Logger.f235387a.d().d("GuildFeedOptionViewModel", 1, "[doFeedbackOption] feedId:" + feedId + ", contentType:" + contentType + ", scene:" + scene + ", cbData:" + cbData);
        AppRuntime appRuntime = this.app;
        if (appRuntime != null && (iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")) != null) {
            ar arVar = new ar();
            arVar.h(feedId);
            arVar.j(scene);
            arVar.i("feed");
            arVar.g(contentType);
            cx cxVar = new cx();
            String str = null;
            if (cbData != null) {
                bArr = cbData.getCbExtData();
            } else {
                bArr = null;
            }
            cxVar.c(bArr);
            if (cbData != null) {
                str = cbData.getStatData();
            }
            cxVar.d(str);
            arVar.f(cxVar);
            iGPSService.reportFeedback(arVar, new em() { // from class: com.tencent.mobileqq.guild.feed.feedoption.b
                @Override // wh2.em
                public final void onResult(int i3, String str2) {
                    d.P1(feedId, contentType, scene, i3, str2);
                }
            });
        }
    }

    public final void Q1(@NotNull final String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        GProImpeachReq gProImpeachReq = new GProImpeachReq();
        gProImpeachReq.feed.idd = feedId;
        gProImpeachReq.impeachType = 0;
        o oVar = o.f214742a;
        QRouteApi api = QRoute.api(IGuildFeedMiscApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        ((IGuildFeedMiscApi) api).sendImpeachReq(gProImpeachReq, new IGProImpeachCallback() { // from class: com.tencent.mobileqq.guild.feed.feedoption.c
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProImpeachCallback
            public final void onResult(int i3, String str, boolean z16, GProImpeachRsp gProImpeachRsp) {
                d.R1(feedId, i3, str, z16, gProImpeachRsp);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedOptionViewModel";
    }

    public final void init() {
        AppRuntime m3 = ch.m();
        Intrinsics.checkNotNullExpressionValue(m3, "appRuntime()");
        this.app = m3;
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.app = ch.l();
    }
}
