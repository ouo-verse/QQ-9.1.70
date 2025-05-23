package com.tencent.mobileqq.guild.mainframe.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.avbiz.Constants;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.m;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qr1.HashTagJumpParams;
import vh2.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\"\u0010\u0016\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\"\u0010\u0017\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\"\u0010\u0018\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J&\u0010\"\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 H\u0002J\"\u0010#\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/util/GuildHashTagJumpUtils;", "", "Lqr1/b;", "jumpParams", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hashTagJumpParams", "t", "", "channelId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "y", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "infoSource", "infoTarget", "params", "i", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "o", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "r", "Landroid/content/Context;", "context", "", "channelType", "Lkotlin/Function0;", "block", "u", "p", "type", "l", HippyTKDListViewAdapter.X, "b", "Z", "isJumping", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildHashTagJumpUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildHashTagJumpUtils f227677a = new GuildHashTagJumpUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isJumping;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/util/GuildHashTagJumpUtils$a;", "Lvh2/n;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "Lqr1/b;", "b", "Lqr1/b;", "getParams", "()Lqr1/b;", "setParams", "(Lqr1/b;)V", "params", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "c", "Lmqq/util/WeakReference;", "contextRef", "<init>", "(Ljava/lang/String;Lqr1/b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements n {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashTagJumpParams params;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Context> contextRef;

        public a(@NotNull String guildId, @NotNull HashTagJumpParams params) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(params, "params");
            this.guildId = guildId;
            this.params = params;
            this.contextRef = new WeakReference<>(this.params.getContext());
        }

        @Override // vh2.n
        public void a(int result, @NotNull String errMsg, @Nullable IGProChannelInfo channelInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            GuildHashTagJumpUtils.isJumping = false;
            Context context = this.contextRef.get();
            if (context == null) {
                QLog.w("Guild.jump.#.GuildHashTagJumpUtils", 1, "onFetchChannelInfo .activity is finish!! guildId=" + this.guildId + " channelId=" + this.params.getJumpChannelId());
                return;
            }
            if (result != 0) {
                if (result == 1) {
                    QQToast.makeText(context, errMsg, 0).show();
                } else {
                    QQToast.makeText(context, "\u8be5\u5b50\u9891\u9053\u5df2\u88ab\u5220\u9664", 0).show();
                }
                QLog.w("Guild.jump.#.GuildHashTagJumpUtils", 1, "onFetchChannelInfo error guildId=" + this.guildId + " channelId=" + this.params.getJumpChannelId() + " result=" + result + " errMsg=" + errMsg);
                return;
            }
            GuildHashTagJumpUtils guildHashTagJumpUtils = GuildHashTagJumpUtils.f227677a;
            IGProChannelInfo y16 = guildHashTagJumpUtils.y(this.params.getSourceChannelId());
            IGProChannelInfo y17 = guildHashTagJumpUtils.y(this.params.getJumpChannelId());
            if (y17 != null) {
                guildHashTagJumpUtils.i(y16, y17, this.params);
                return;
            }
            QQToast.makeText(context, "\u8be5\u5b50\u9891\u9053\u5df2\u88ab\u5220\u9664", 0).show();
            QLog.w("Guild.jump.#.GuildHashTagJumpUtils", 1, "onFetchChannelInfo succ. but still can't find target channel info" + this.guildId + " channelId=" + this.params.getJumpChannelId());
        }
    }

    GuildHashTagJumpUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(IGProChannelInfo infoSource, IGProChannelInfo infoTarget, HashTagJumpParams params) {
        j(infoSource, infoTarget, params);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(final IGProChannelInfo infoSource, final IGProChannelInfo infoTarget, final HashTagJumpParams params) {
        boolean contains;
        final Ref.IntRef intRef = new Ref.IntRef();
        int i3 = 3;
        intRef.element = 3;
        int transChannelType = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).transChannelType(params.getFactoryName());
        boolean z16 = false;
        contains = ArraysKt___ArraysKt.contains(new Integer[]{10, 11}, Integer.valueOf(transChannelType));
        if (contains) {
            p(infoSource, infoTarget, params);
            return;
        }
        if (transChannelType == 2) {
            n(infoSource, infoTarget, params);
            return;
        }
        if (transChannelType == 3) {
            Intent intent = new Intent();
            intent.putExtra("KEY_NEED_FINISH", true);
            Context context = params.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) context;
            activity.setResult(30004, intent);
            r(activity);
        } else {
            if (transChannelType == 1 && infoTarget.getType() == 2) {
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(intRef.element);
                s(params, infoTarget, infoSource);
            } else {
                if (transChannelType == 5) {
                    o(infoSource, infoTarget, params);
                    return;
                }
                if (transChannelType != 4 && transChannelType != 7) {
                    if (transChannelType != 1 && transChannelType != 8 && transChannelType != 9) {
                        if (transChannelType == 6) {
                            QQToast.makeText(params.getContext(), "K\u6b4c\u9891\u9053\u6682\u4e0d\u652f\u6301\u8df3\u8f6c\u5176\u4ed6\u9891\u9053", 0).show();
                        } else {
                            QLog.e("Guild.jump.#.GuildHashTagJumpUtils", 1, "handleJump called and not succeed, jumpChannelId:" + params.getJumpChannelId() + ", context:" + params.getContext());
                        }
                    } else {
                        if (infoSource == null) {
                            i3 = 9;
                        }
                        intRef.element = i3;
                        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(intRef.element);
                        s(params, infoTarget, infoSource);
                    }
                } else {
                    Context context2 = params.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                    ((Activity) context2).finish();
                    intRef.element = 9;
                }
            }
            if (!z16) {
                if (transChannelType == 7 && !q(params)) {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.util.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildHashTagJumpUtils.k(Ref.IntRef.this, params, infoTarget, infoSource);
                        }
                    }, 300L);
                    return;
                } else {
                    ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(intRef.element);
                    s(params, infoTarget, infoSource);
                    return;
                }
            }
            return;
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Ref.IntRef enterSource, HashTagJumpParams params, IGProChannelInfo infoTarget, IGProChannelInfo iGProChannelInfo) {
        Intrinsics.checkNotNullParameter(enterSource, "$enterSource");
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(infoTarget, "$infoTarget");
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(enterSource.element);
        f227677a.s(params, infoTarget, iGProChannelInfo);
    }

    private final String l(int type) {
        if (type != 2) {
            if (type != 5) {
                if (type != 8) {
                    return "";
                }
                return Constants.Business.QQ_META_ROOM;
            }
            return "\u76f4\u64ad\u5b50\u9891\u9053";
        }
        return "\u97f3\u89c6\u9891\u5b50\u9891\u9053";
    }

    @JvmStatic
    public static final void m(@NotNull HashTagJumpParams jumpParams) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jumpParams, "jumpParams");
        if (isJumping) {
            QLog.w("Guild.jump.#.GuildHashTagJumpUtils", 1, "handleJump is jumping sourceChannelId=" + jumpParams.getSourceChannelId() + " jumpChannelId=" + jumpParams.getJumpChannelId());
            return;
        }
        GuildJumpDebugUtils.a("Guild.jump.#.GuildHashTagJumpUtils", "GuildHashTagJumpUtils, handleJump jumpParams = ", jumpParams);
        Logger.f235387a.d().i("Guild.jump.#.GuildHashTagJumpUtils", 1, "handleJump sourceChannelId=" + jumpParams.getSourceChannelId() + " jumpChannelId=" + jumpParams.getJumpChannelId());
        if (jumpParams.getCheckSourceChannelIsValid() && Intrinsics.areEqual(jumpParams.getSourceChannelId(), jumpParams.getJumpChannelId())) {
            QQToast.makeText(jumpParams.getContext(), "\u5df2\u5728\u8be5\u5b50\u9891\u9053\u4e2d", 0).show();
            return;
        }
        GuildHashTagJumpUtils guildHashTagJumpUtils = f227677a;
        IGProChannelInfo y16 = guildHashTagJumpUtils.y(jumpParams.getSourceChannelId());
        IGProChannelInfo y17 = guildHashTagJumpUtils.y(jumpParams.getJumpChannelId());
        IGProGuildInfo z17 = guildHashTagJumpUtils.z(jumpParams.getJumpGuildId());
        if (z17 != null && z17.isMovePostSection()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && jumpParams.getOpenFeedSquare()) {
            guildHashTagJumpUtils.t(jumpParams);
            return;
        }
        if (y16 == null) {
            Logger.b bVar = new Logger.b();
            String str = "infoSource is null " + jumpParams.getSourceChannelId();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.#.GuildHashTagJumpUtils", 1, (String) it.next(), null);
            }
        }
        if (y17 == null) {
            if (y16 == null) {
                QQToast.makeText(jumpParams.getContext(), "\u8be5\u5b50\u9891\u9053\u5df2\u88ab\u5220\u9664", 0).show();
                return;
            }
            isJumping = true;
            b bVar2 = new b(y16.getGuildId(), jumpParams.getJumpChannelId(), 2000L);
            String guildId = y16.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "infoSource.guildId");
            bVar2.e(new a(guildId, jumpParams));
            return;
        }
        f227677a.i(y16, y17, jumpParams);
    }

    private final void n(final IGProChannelInfo infoSource, final IGProChannelInfo infoTarget, final HashTagJumpParams params) {
        Object liveGuildLiveRoomFragment = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getLiveGuildLiveRoomFragment(params.getContext());
        if (liveGuildLiveRoomFragment != null && (liveGuildLiveRoomFragment instanceof QPublicBaseFragment)) {
            if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).tryGetJumpChannelStatusCode((QPublicBaseFragment) liveGuildLiveRoomFragment) == 3) {
                x(params.getContext());
                return;
            }
            if (infoSource != null && infoSource.getType() == 5) {
                int type = infoTarget.getType();
                if (type != 2 && type != 5 && type != 8) {
                    Context context = params.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    r((Activity) context);
                    ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(10);
                    s(params, infoTarget, infoSource);
                    return;
                }
                u(params.getContext(), type, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.util.GuildHashTagJumpUtils$handleHashTagJumpOnLiveChannel$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        GuildHashTagJumpUtils guildHashTagJumpUtils = GuildHashTagJumpUtils.f227677a;
                        Context context2 = HashTagJumpParams.this.getContext();
                        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                        guildHashTagJumpUtils.r((Activity) context2);
                        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(10);
                        guildHashTagJumpUtils.s(HashTagJumpParams.this, infoTarget, infoSource);
                    }
                });
            }
        }
    }

    private final void o(IGProChannelInfo infoSource, IGProChannelInfo infoTarget, HashTagJumpParams params) {
        QLog.i("Guild.jump.#.GuildHashTagJumpUtils", 1, "[handleHashTagJumpOnLiveTopMsgDetail] ");
        if (((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).isSelfLiving()) {
            x(params.getContext());
            return;
        }
        GLiveChannelCore.f226698a.b("\u7cbe\u534e\u6d88\u606f\u8be6\u60c5\u8df3\u8f6c");
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(10);
        s(params, infoTarget, infoSource);
    }

    private final void p(final IGProChannelInfo infoSource, final IGProChannelInfo infoTarget, final HashTagJumpParams params) {
        String str;
        int type = infoTarget.getType();
        Context context = params.getContext();
        if (type != 2 && type != 5 && type != 8) {
            if (infoSource != null) {
                str = infoSource.getGuildId();
            } else {
                str = null;
            }
            IGProGuildInfo z16 = z(str);
            if (z16 != null && infoSource != null && com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().R && ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(context)) {
                GuildFloatWindowUtils.F(z16, infoSource, m.n(com.tencent.mobileqq.guild.media.core.j.c()), false, 0, 24, null);
                Context context2 = params.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                r((Activity) context2);
            } else {
                MediaChannelCore.INSTANCE.a().D("", "handleHashTagJumpOnMediaChannel no permission");
            }
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(14);
            s(params, infoTarget, infoSource);
            return;
        }
        u(params.getContext(), type, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.util.GuildHashTagJumpUtils$handleHashTagJumpOnMediaChannel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MediaChannelCore.INSTANCE.a().D("", "handleHashTagJumpOnMediaChannel");
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setChannelEnterSource(14);
                GuildHashTagJumpUtils.f227677a.s(HashTagJumpParams.this, infoTarget, infoSource);
            }
        });
    }

    private final boolean q(HashTagJumpParams params) {
        boolean isGuildTabSelected = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected();
        GuildAppReportSourceInfo appReportSourceInfo = params.getAppReportSourceInfo();
        if (appReportSourceInfo != null) {
            return appReportSourceInfo.getStartFromGuildTab();
        }
        return isGuildTabSelected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Activity activity) {
        if (AppSetting.t(activity)) {
            activity.onKeyDown(4, new KeyEvent(4, 4));
        } else {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(HashTagJumpParams params, IGProChannelInfo infoTarget, IGProChannelInfo infoSource) {
        String str;
        if (q(params)) {
            Context context = params.getContext();
            String guildId = infoTarget.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "infoTarget.guildId");
            GuildJumpUtil.u(context, guildId, infoTarget.getChannelUin(), params.getAppReportSourceInfo(), null, 16, null);
            return;
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(infoTarget.getGuildId(), infoTarget.getChannelUin());
        if (infoSource != null) {
            str = infoSource.getChannelUin();
        } else {
            str = null;
        }
        jumpGuildParam.setSourceChannelId(str);
        jumpGuildParam.setReportSourceInfo(params.getAppReportSourceInfo());
        JumpGuildParam.JoinInfoParam joinInfoParam = params.getJoinInfoParam();
        if (joinInfoParam != null) {
            jumpGuildParam.setJoinInfoParam(joinInfoParam);
        }
        Bundle bundle = jumpGuildParam.extras;
        if (bundle != null) {
            bundle.putBoolean("guild_is_need_jump_main_tab", true);
        }
        GuildJumpUtil.n(params.getContext(), jumpGuildParam);
    }

    private final void t(HashTagJumpParams hashTagJumpParams) {
        Bundle bundle;
        JumpGuildParam jumpGuildParam = new JumpGuildParam(hashTagJumpParams.getJumpGuildId(), hashTagJumpParams.getJumpChannelId());
        JumpGuildParam.JoinInfoParam joinInfoParam = hashTagJumpParams.getJoinInfoParam();
        if (joinInfoParam != null) {
            jumpGuildParam.setJoinInfoParam(joinInfoParam);
        }
        jumpGuildParam.extras.putBoolean("guild_is_need_jump_main_tab", true);
        if (GuildMainFrameUtils.q(hashTagJumpParams.getJumpChannelId()) && (bundle = jumpGuildParam.extras) != null) {
            bundle.putBoolean(JumpGuildParam.EXTRA_FEED_HOME_SELECTED_HOT_TAB, true);
        }
        QLog.d("Guild.jump.#.GuildHashTagJumpUtils", 1, "openFeedSquare, jumpParams:" + hashTagJumpParams);
        GuildJumpUtil.n(hashTagJumpParams.getContext(), jumpGuildParam);
    }

    private final void u(Context context, int channelType, final Function0<Unit> block) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(R.string.f1499113k);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026a_tag_jump_dialog_format)");
        String format = String.format(string, Arrays.copyOf(new Object[]{l(channelType)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, null, format, null, null);
        createCustomDialog.setNegativeButton(context.getString(R.string.cancel), 0, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.mainframe.util.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildHashTagJumpUtils.v(dialogInterface, i3);
            }
        });
        createCustomDialog.setPositiveButton(context.getString(R.string.d_d), 0, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.mainframe.util.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildHashTagJumpUtils.w(Function0.this, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function0 block, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    private final void x(Context context) {
        QQToast.makeText(context, "\u6b63\u5728\u76f4\u64ad\u4e2d\uff0c\u8bf7\u7ed3\u675f\u76f4\u64ad\u540e\u91cd\u8bd5", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProChannelInfo y(String channelId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(channelId);
    }

    private final IGProGuildInfo z(String guildId) {
        AppRuntime peekAppRuntime;
        if (guildId == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return null;
        }
        return ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(DialogInterface dialogInterface, int i3) {
    }
}
