package at3;

import android.content.Intent;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.part.root.panel.mvx.config.c;
import com.tencent.guild.aio.util.ex.ContainerType;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.api.i;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mq0.e;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lat3/a;", "Lmq0/e;", "Landroid/view/View;", "v", "", "i", "", "g", h.F, "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "f", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003*\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003*\u00020\u0002H\u0002R\u0018\u0010\u000b\u001a\u00020\b*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u00020\b*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0011\u001a\u00020\u000e*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u00020\u0012*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lat3/a$a;", "", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "Landroid/content/Intent;", "b", "kotlin.jvm.PlatformType", "d", "c", "", "f", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;)Ljava/lang/String;", "channelId", h.F, "guildId", "Landroidx/fragment/app/FragmentActivity;", "e", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;)Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/guild/aio/util/ex/ContainerType;", "g", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;)Lcom/tencent/guild/aio/util/ex/ContainerType;", "containerType", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: at3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: at3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public /* synthetic */ class C0071a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f26920a;

            static {
                int[] iArr = new int[ContainerType.values().length];
                try {
                    iArr[ContainerType.STAND_TYPE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f26920a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Intent b(c cVar) {
            if (((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
                Intent d16 = d(cVar);
                Intrinsics.checkNotNullExpressionValue(d16, "createStandaloneIntent()");
                return d16;
            }
            if (C0071a.f26920a[g(cVar).ordinal()] == 1) {
                Intent d17 = d(cVar);
                Intrinsics.checkNotNullExpressionValue(d17, "createStandaloneIntent()");
                return d17;
            }
            Intent c16 = c(cVar);
            Intrinsics.checkNotNullExpressionValue(c16, "createGuildTabIntent()");
            return c16;
        }

        private final Intent c(c cVar) {
            LaunchGuildChatPieParam launchGuildChatPieParam = new LaunchGuildChatPieParam();
            Companion companion = a.INSTANCE;
            return ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(companion.e(cVar), launchGuildChatPieParam.l(companion.h(cVar)).b(companion.f(cVar)).r(true).o(1).f(true).k(BundleKt.bundleOf(TuplesKt.to(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1))).a());
        }

        private final Intent d(c cVar) {
            i iVar = new i();
            Companion companion = a.INSTANCE;
            return ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatActivityIntent(companion.e(cVar), iVar.b(companion.f(cVar)).f(companion.h(cVar)).e(BundleKt.bundleOf(TuplesKt.to(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1))).d(cVar.b().n()).a());
        }

        private final FragmentActivity e(c cVar) {
            FragmentActivity requireActivity = cVar.a().c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "mAIOContext.fragment.requireActivity()");
            return requireActivity;
        }

        private final String f(c cVar) {
            return com.tencent.guild.aio.util.a.b(cVar.b());
        }

        private final ContainerType g(c cVar) {
            return com.tencent.guild.aio.util.ex.a.c(cVar.a());
        }

        private final String h(c cVar) {
            return com.tencent.guild.aio.util.a.g(cVar.b());
        }

        Companion() {
        }
    }

    public a() {
        super(1);
    }

    private final void i(View v3) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        w.b(hashMap);
        VideoReport.setElementId(v3, "em_sgrp_aio_plus_shoot");
        VideoReport.setElementParams(v3, hashMap);
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", v3, hashMap);
    }

    @Override // mq0.e, lq0.f
    public void f(@NotNull View v3, @NotNull c panelParam) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        i(v3);
        FragmentActivity activity = panelParam.a().c().getActivity();
        if (activity == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onPlusPanelAppClick: activity is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.CameraAppInfo", 1, (String) it.next(), null);
            }
            return;
        }
        String b16 = com.tencent.guild.aio.util.a.b(panelParam.b());
        String g16 = com.tencent.guild.aio.util.a.g(panelParam.b());
        Intent b17 = INSTANCE.b(panelParam);
        if (GuildSplitViewUtils.f235370a.n(activity) && b17 != null) {
            b17.putExtra("isSplitViewMode", true);
        }
        ((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).openCameraSendMsg(b16, g16, activity, b17, true);
    }

    @Override // mq0.e
    public int g() {
        return R.drawable.guild_feed_publish_camera_icon_selector;
    }

    @Override // mq0.e
    public int h() {
        return R.string.f139390b5;
    }
}
