package com.tencent.mobileqq.guild.media.thirdapp.container.vm;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.base.api.data.BaseParam;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.ThirdAppBarClickEvent;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.e;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.BaseApplication;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b*\u0002;>\u0018\u0000 I2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J:\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u001a\u0010!\u001a\u00020\r2\u0010\u0010 \u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010/\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00104\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00107\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R\u0018\u00109\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00108R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010:R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R(\u0010F\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020>0C0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerSurfaceVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVM;", "Landroid/view/Surface;", "surface", "", "newWidth", "newHeight", "", "t", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", HippyTKDListViewAdapter.X, "w", "", "webPageId", "width", "height", "Leipc/EIPCResultCallback;", "callback", "D", "", BdhLogUtil.LogTag.Tag_Conn, "context", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "y", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "e", "I", "surfaceHeight", "f", "surfaceWidth", h.F, "Z", "hasChangeOrientation", "i", "Lkotlin/Lazy;", "v", "()I", "displayWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "displayHeight", "Landroid/view/Surface;", "textureViewSurface", "Ljava/lang/String;", "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerSurfaceVM$c", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerSurfaceVM$c;", "thirdAppPortraitStatusObserver", "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerSurfaceVM$b", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerSurfaceVM$b;", "mAction", "", "Lkotlin/Pair;", "G", "Ljava/util/List;", "messageList", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildContainerSurfaceVM extends BaseVM<com.tencent.mobileqq.guild.media.thirdapp.container.intent.e, MviUIState, com.tencent.base.api.runtime.a<BaseParam>> {

    @NotNull
    private static final ArrayList<Integer> I;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Surface textureViewSurface;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String webPageId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c thirdAppPortraitStatusObserver;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> messageList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildOpenContainerLauncher.StartParams startParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int surfaceHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int surfaceWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasChangeOrientation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy displayWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy displayHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerSurfaceVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildContainerSurfaceVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerSurfaceVM$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ThirdAppBarClickEvent;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements o<ThirdAppBarClickEvent> {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f229455a;

            static {
                int[] iArr = new int[ThirdAppBarClickEvent.values().length];
                try {
                    iArr[ThirdAppBarClickEvent.MINIMIZE_LAND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ThirdAppBarClickEvent.FULL_LAND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f229455a = iArr;
            }
        }

        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ThirdAppBarClickEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            boolean z16 = true;
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "[ThirdAppBarClickEvent.onEventReceive] " + event);
            GuildContainerSurfaceVM guildContainerSurfaceVM = GuildContainerSurfaceVM.this;
            int i3 = a.f229455a[event.ordinal()];
            if (i3 != 1 && i3 != 2) {
                z16 = false;
            }
            guildContainerSurfaceVM.hasChangeOrientation = z16;
        }
    }

    static {
        ArrayList<Integer> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(30, 27);
        I = arrayListOf;
    }

    public GuildContainerSurfaceVM() {
        Lazy lazy;
        Lazy lazy2;
        List<Pair<String, b>> listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vm.GuildContainerSurfaceVM$displayWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int u16;
                u16 = GuildContainerSurfaceVM.this.u();
                return Integer.valueOf(u16);
            }
        });
        this.displayWidth = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vm.GuildContainerSurfaceVM$displayHeight$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
                return Integer.valueOf(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
            }
        });
        this.displayHeight = lazy2;
        this.webPageId = "";
        this.thirdAppPortraitStatusObserver = new c();
        b bVar = new b();
        this.mAction = bVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(Reflection.getOrCreateKotlinClass(MainProcessIntent.ContainerLifeIntent.class).getQualifiedName(), bVar));
        this.messageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B(Surface surface) {
        Logger logger = Logger.f235387a;
        logger.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "startRemoteWeb webPageId " + this.webPageId);
        GuildOpenContainerLauncher.StartParams startParams = null;
        if (lt1.a.d((com.tencent.base.api.runtime.a) getMContext())) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("isActivityUnavailable");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, (String) it.next(), null);
            }
            return;
        }
        FragmentActivity activity = ((com.tencent.base.api.runtime.a) getMContext()).c().getActivity();
        if (activity == null) {
            return;
        }
        Logger.a d16 = logger.d();
        Surface surface2 = this.textureViewSurface;
        RemoteWebRenderIPCServer.Companion companion = RemoteWebRenderIPCServer.INSTANCE;
        d16.d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "[startRemoteWeb], surface " + surface2 + " ,ipcStatus: " + companion.a().Q());
        RemoteWebRenderIPCServer a16 = companion.a();
        GuildOpenContainerLauncher.StartParams startParams2 = this.startParams;
        if (startParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
        } else {
            startParams = startParams2;
        }
        a16.h0(startParams.getUrl(), surface, this.webPageId, activity, z());
    }

    private final boolean C() {
        return !I.contains(Integer.valueOf(Build.VERSION.SDK_INT));
    }

    private final void D(String webPageId, Surface surface, int width, int height, EIPCResultCallback callback) {
        GuildMediaWebIPCServer.INSTANCE.a().v(webPageId, surface, width, height, !C(), callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "[handleAction] intent " + intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void F(GuildContainerSurfaceVM guildContainerSurfaceVM, String str, Surface surface, int i3, int i16, EIPCResultCallback eIPCResultCallback, int i17, Object obj) {
        int i18;
        int i19;
        if ((i17 & 4) != 0) {
            i18 = 0;
        } else {
            i18 = i3;
        }
        if ((i17 & 8) != 0) {
            i19 = 0;
        } else {
            i19 = i16;
        }
        if ((i17 & 16) != 0) {
            eIPCResultCallback = null;
        }
        guildContainerSurfaceVM.D(str, surface, i18, i19, eIPCResultCallback);
    }

    private final void t(final Surface surface, int newWidth, int newHeight) {
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        GuildOpenContainerLauncher.StartParams startParams2 = null;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        final String string = startParams.getExtra().getString("key_web_attach_web_page_id");
        if (string == null) {
            string = "";
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "createOrSwitchSurface, webPageId " + string + ",  toolExits " + isProcessRunning + ", surface " + this.textureViewSurface + ",  newWidth " + newWidth + ", newHeight " + newHeight);
        GuildOpenContainerLauncher.StartParams startParams3 = this.startParams;
        if (startParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams3 = null;
        }
        startParams3.getExtra().putInt("guild_webview_width", newWidth);
        GuildOpenContainerLauncher.StartParams startParams4 = this.startParams;
        if (startParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
        } else {
            startParams2 = startParams4;
        }
        startParams2.getExtra().putInt("guild_webview_height", newHeight);
        GuildMediaWebIPCServer.INSTANCE.a().i(string, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vm.GuildContainerSurfaceVM$createOrSwitchSurface$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                int i3;
                int i16;
                Logger logger = Logger.f235387a;
                GuildContainerSurfaceVM guildContainerSurfaceVM = GuildContainerSurfaceVM.this;
                logger.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "checkIfAttach isAttach " + z16 + ", surface " + guildContainerSurfaceVM.textureViewSurface + " ");
                if (!z16) {
                    GuildContainerSurfaceVM.this.B(surface);
                    return;
                }
                GuildContainerSurfaceVM guildContainerSurfaceVM2 = GuildContainerSurfaceVM.this;
                String str = string;
                Surface surface2 = surface;
                i3 = guildContainerSurfaceVM2.surfaceWidth;
                i16 = GuildContainerSurfaceVM.this.surfaceHeight;
                GuildContainerSurfaceVM.F(guildContainerSurfaceVM2, str, surface2, i3, i16, null, 16, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int u() {
        return ((Number) this.displayHeight.getValue()).intValue();
    }

    private final int v() {
        return ((Number) this.displayWidth.getValue()).intValue();
    }

    private final int w() {
        if (C()) {
            return u();
        }
        return this.surfaceHeight;
    }

    private final int x() {
        if (C()) {
            return v();
        }
        return this.surfaceWidth;
    }

    private final Bundle z() {
        Bundle bundle = new Bundle();
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        bundle.putAll(startParams.getExtra());
        bundle.putInt("key_web_view_width", x());
        bundle.putInt("key_web_view_height", w());
        bundle.putString("key_remote_view_type", "guildMedia");
        bundle.putString("key_remote_service_type", "guildMedia");
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<BaseParam> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "[onCreate] ");
        BaseParam h16 = context.h();
        Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher.StartParams");
        GuildOpenContainerLauncher.StartParams startParams = (GuildOpenContainerLauncher.StartParams) h16;
        this.startParams = startParams;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        this.webPageId = startParams.getWebPageId();
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.base.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        j.d().V(ThirdAppBarClickEvent.class, this.thirdAppPortraitStatusObserver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "[onDestroy]");
        this.textureViewSurface = null;
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.base.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        j.d().j(ThirdAppBarClickEvent.class, this.thirdAppPortraitStatusObserver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.guild.media.thirdapp.container.intent.e intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof e.SurfaceCreated) {
            e.SurfaceCreated surfaceCreated = (e.SurfaceCreated) intent;
            this.surfaceWidth = surfaceCreated.getWidth();
            this.surfaceHeight = surfaceCreated.getHeight();
            this.textureViewSurface = surfaceCreated.getSurface();
            t(surfaceCreated.getSurface(), this.surfaceWidth, this.surfaceHeight);
            lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_SURFACE_CREATED);
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "[SurfaceCreated]  surface " + this.textureViewSurface + " ");
            return;
        }
        if (intent instanceof e.SurfaceChanged) {
            e.SurfaceChanged surfaceChanged = (e.SurfaceChanged) intent;
            this.textureViewSurface = surfaceChanged.getSurface();
            this.surfaceWidth = surfaceChanged.getWidth();
            this.surfaceHeight = surfaceChanged.getHeight();
            if (!this.hasChangeOrientation) {
                F(this, this.webPageId, surfaceChanged.getSurface(), this.surfaceWidth, this.surfaceHeight, null, 16, null);
                lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_SURFACE_CHANGED);
            }
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "[SurfaceChanged]  surface " + this.textureViewSurface + ", hasChangeOrientation " + this.hasChangeOrientation);
            return;
        }
        if (intent instanceof e.SurfaceDestroy) {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVM", 1, "[SurfaceDestroy]  surface " + this.textureViewSurface + " ");
            this.textureViewSurface = null;
            this.surfaceWidth = 0;
            this.surfaceHeight = 0;
            this.hasChangeOrientation = false;
            lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_SURFACE_DESTROY);
        }
    }
}
