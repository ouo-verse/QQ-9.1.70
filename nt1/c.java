package nt1;

import android.content.DialogInterface;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelThirdAppHelper;
import com.tencent.mobileqq.guild.media.core.notify.bb;
import com.tencent.mobileqq.guild.media.thirdapp.d;
import com.tencent.mobileqq.guild.media.thirdapp.g;
import com.tencent.mobileqq.guild.media.thirdapp.h;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QZoneShareManager;
import e12.e;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001&\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000f\u001a\u00020\u000eJ\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017J\u001e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000eR%\u0010%\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u00100\u00100\u001f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lnt1/c;", "Landroidx/lifecycle/ViewModel;", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "W1", "e2", "Lcom/tencent/mobileqq/guild/media/thirdapp/d;", "O1", "N1", "init", "X1", "Lcom/tencent/mobileqq/guild/media/thirdapp/e;", "T1", "S1", "", "U1", "", "isPortrait", "isLandView", "Lkotlin/Pair;", "", "Q1", "P1", "", "webViewLoadingTime", "h5LoadingTime", "Z1", "hintText", "actionText", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "d2", "Le12/e;", "kotlin.jvm.PlatformType", "i", "Le12/e;", "R1", "()Le12/e;", "refreshThirdAppContentLiveData", "nt1/c$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnt1/c$b;", "observer", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e<Boolean> refreshThirdAppContentLiveData = new e<>(Boolean.FALSE);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b observer = new b();

    private final d O1() {
        MediaChannelThirdAppHelper d06 = j.a().d0();
        IGProLobbyAppInfo thirdAppInfo = d06.getThirdAppInfo();
        IGProLobbyStateInfo lobbyRoomInfo = d06.getLobbyRoomInfo();
        if (thirdAppInfo == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("createMediaThirdAppInfo: thirdAppInfo is null.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.GuildMediaThirdAppViewModel", 1, (String) it.next(), null);
            }
            return null;
        }
        if (lobbyRoomInfo == null) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("createMediaThirdAppInfo: appRoomInfo is null.");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("QGMC.GuildMediaThirdAppViewModel", 1, (String) it5.next(), null);
            }
            return null;
        }
        return new d(thirdAppInfo, lobbyRoomInfo);
    }

    private final void W1() {
        ((IGPSService) ch.m().getRuntimeService(IGPSService.class, "")).addObserver(this.observer);
    }

    private final void a2() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, BaseApplication.getContext().getText(R.string.f1499313m), qBaseActivity.getString(R.string.f140850f3), qBaseActivity.getString(R.string.f142470jg), new DialogInterface.OnClickListener() { // from class: nt1.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    c.b2(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: nt1.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    c.c2(dialogInterface, i3);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(DialogInterface dialogInterface, int i3) {
        j.a().d0().o1();
    }

    private final void e2() {
        ((IGPSService) ch.m().getRuntimeService(IGPSService.class, "")).deleteObserver(this.observer);
    }

    public final void N1() {
        if (g.f229539a.c()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("handleThirdAppClosed: has no right to close app.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.GuildMediaThirdAppViewModel", 1, (String) it.next(), null);
            }
            a2();
        }
    }

    @NotNull
    public final Pair<Integer, Integer> P1(boolean isPortrait) {
        int i3;
        Pair<Integer, Integer> a16;
        com.tencent.mobileqq.guild.media.thirdapp.e appPreloadInfo = j.a().d0().getAppPreloadInfo();
        if (appPreloadInfo != null) {
            i3 = appPreloadInfo.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE java.lang.String();
        } else {
            i3 = 1;
        }
        if (isPortrait) {
            h hVar = h.f229540a;
            a16 = new Pair<>(Integer.valueOf(hVar.d()), Integer.valueOf(hVar.c()));
        } else {
            a16 = h.f229540a.a(i3);
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "getAppContentPreloadSize: " + i3 + ", " + a16;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.GuildMediaThirdAppViewModel", 1, (String) it.next(), null);
        }
        return a16;
    }

    @NotNull
    public final Pair<Integer, Integer> Q1(boolean isPortrait, boolean isLandView) {
        int i3;
        Pair<Integer, Integer> a16;
        IGProLobbyAppInfo appInfo;
        d S1 = S1();
        if (S1 != null && (appInfo = S1.getAppInfo()) != null) {
            i3 = appInfo.getScreenMode();
        } else {
            i3 = 1;
        }
        if (isPortrait) {
            h hVar = h.f229540a;
            a16 = new Pair<>(Integer.valueOf(hVar.d()), Integer.valueOf(hVar.c()));
        } else if (isLandView) {
            a16 = h.f229540a.b();
        } else {
            a16 = h.f229540a.a(i3);
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "getAppContentSize: " + i3 + ", " + a16;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.GuildMediaThirdAppViewModel", 1, (String) it.next(), null);
        }
        return a16;
    }

    @NotNull
    public final e<Boolean> R1() {
        return this.refreshThirdAppContentLiveData;
    }

    @Nullable
    public final d S1() {
        return O1();
    }

    @Nullable
    public final com.tencent.mobileqq.guild.media.thirdapp.e T1() {
        return j.a().d0().getAppPreloadInfo();
    }

    @NotNull
    public final String U1() {
        return j.a().d0().E1();
    }

    public final void X1() {
        e2();
    }

    public final void Z1(long webViewLoadingTime, long h5LoadingTime) {
        j.a().d0().l2(webViewLoadingTime, h5LoadingTime);
    }

    public final void d2(@NotNull String hintText, @NotNull String actionText, @NotNull String defaultText) {
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        j.d().i(new bb(hintText, actionText, defaultText));
    }

    public final void init() {
        W1();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0014J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\n"}, d2 = {"nt1/c$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "Ljava/util/HashSet;", "channelIds", "", "onChannelPermissionChanged", "channelUin", "onChannelInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            super.onChannelInfoUpdated(channelUin);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@Nullable String guildId, @Nullable HashSet<String> channelIds) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(DialogInterface dialogInterface, int i3) {
    }
}
