package com.tencent.mobileqq.remoteweb.view;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.GuildFeedFullScreenPresentation;
import com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.GuildFeedWebViewPresentation;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildWebViewPresentation;
import com.tencent.mobileqq.log.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.teamwork.app.TDocNativeViewPresentation;
import com.tencent.mobileqq.teamwork.app.TDocWebViewPresentation;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\fRF\u0010\u0016\u001a.\u0012\u0004\u0012\u00020\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u00110\u000fj\u0016\u0012\u0004\u0012\u00020\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0011`\u00128\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/RemoteRenderViewBuilder;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "data", "Lcom/tencent/mobileqq/remoteweb/view/b;", "d", "Landroid/hardware/display/VirtualDisplay;", "virtualDisplay", "Lcom/tencent/mobileqq/remoteweb/view/g;", "a", "", "useSystemMetrics", "b", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getS_REMOTE_PRESENTER_HASH_MAP", "()Ljava/util/HashMap;", "S_REMOTE_PRESENTER_HASH_MAP", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RemoteRenderViewBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RemoteRenderViewBuilder f281216a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_remoteweb_presenter_map.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<? extends g>> S_REMOTE_PRESENTER_HASH_MAP;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39793);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f281216a = new RemoteRenderViewBuilder();
        HashMap<String, Class<? extends g>> hashMap = new HashMap<>();
        S_REMOTE_PRESENTER_HASH_MAP = hashMap;
        hashMap.put("GuildFeedFullScreen", GuildFeedFullScreenPresentation.class);
        hashMap.put("GuildFeed", GuildFeedWebViewPresentation.class);
        hashMap.put("NativeTencentDoc", TDocNativeViewPresentation.class);
        hashMap.put("WebTencentDoc", TDocWebViewPresentation.class);
        hashMap.put("guildMedia", GuildWebViewPresentation.class);
        for (Map.Entry<String, Class<? extends g>> entry : hashMap.entrySet()) {
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            if (QLog.isColorLevel()) {
                a.InterfaceC7984a a16 = aVar.a();
                String key = entry.getKey();
                a16.d("RemoteWeb.RemoteRenderViewBuilder", 2, "key " + ((Object) key) + "  IRemoteRenderView class: " + entry.getValue());
            }
        }
    }

    RemoteRenderViewBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ VirtualDisplay c(RemoteRenderViewBuilder remoteRenderViewBuilder, Context context, Bundle bundle, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return remoteRenderViewBuilder.b(context, bundle, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final g a(@NotNull Context context, @NotNull Bundle data, @NotNull VirtualDisplay virtualDisplay) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (g) iPatchRedirector.redirect((short) 4, this, context, data, virtualDisplay);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(virtualDisplay, "virtualDisplay");
        String str = "";
        String string = data.getString("key_remote_view_type", "");
        if (string != null) {
            str = string;
        }
        Class<? extends g> cls = S_REMOTE_PRESENTER_HASH_MAP.get(str);
        if (cls != null) {
            try {
                Constructor<? extends g> declaredConstructor = cls.getDeclaredConstructor(Context.class, Display.class, Bundle.class);
                Intrinsics.checkNotNullExpressionValue(declaredConstructor, "remoteViewTypeClass.getD\u2026ss.java\n                )");
                declaredConstructor.setAccessible(true);
                gVar = declaredConstructor.newInstance(context, virtualDisplay.getDisplay(), data);
            } catch (IllegalAccessException e16) {
                com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                String str2 = "IllegalAccessException " + e16;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteRenderViewBuilder", 1, (String) it.next(), e16);
                }
            } catch (InstantiationException e17) {
                com.tencent.mobileqq.log.a aVar2 = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar2 = new a.b();
                String str3 = "InstantiationException " + e17;
                if (str3 instanceof String) {
                    bVar2.a().add(str3);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteRenderViewBuilder", 1, (String) it5.next(), e17);
                }
            } catch (NoSuchMethodException e18) {
                com.tencent.mobileqq.log.a aVar3 = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar3 = new a.b();
                String str4 = "NoSuchMethodException " + e18;
                if (str4 instanceof String) {
                    bVar3.a().add(str4);
                }
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteRenderViewBuilder", 1, (String) it6.next(), e18);
                }
            } catch (InvocationTargetException e19) {
                com.tencent.mobileqq.log.a aVar4 = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar4 = new a.b();
                String str5 = "InvocationTargetException " + e19;
                if (str5 instanceof String) {
                    bVar4.a().add(str5);
                }
                Iterator<T> it7 = bVar4.a().iterator();
                while (it7.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteRenderViewBuilder", 1, (String) it7.next(), e19);
                }
            }
            if (gVar != null) {
                Display display = virtualDisplay.getDisplay();
                Intrinsics.checkNotNullExpressionValue(display, "virtualDisplay.display");
                return new g(context, display, data);
            }
            return gVar;
        }
        gVar = null;
        if (gVar != null) {
        }
    }

    @NotNull
    public final VirtualDisplay b(@NotNull Context context, @NotNull Bundle data, boolean useSystemMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (VirtualDisplay) iPatchRedirector.redirect((short) 5, this, context, data, Boolean.valueOf(useSystemMetrics));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.densityDpi;
        Object systemService = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        DisplayManager displayManager = (DisplayManager) systemService;
        int i16 = displayMetrics.widthPixels;
        int i17 = displayMetrics.heightPixels;
        String str = "";
        String string = data.getString("key_remote_web_url", "");
        Surface surface = (Surface) data.getParcelable("key_surface");
        String string2 = data.getString("key_web_page_id");
        if (string2 != null) {
            str = string2;
        }
        int max = Math.max(0, data.getInt("key_web_view_width"));
        int max2 = Math.max(0, data.getInt("key_web_view_height"));
        if (max == 0) {
            max = i16;
        }
        if (max2 == 0) {
            max2 = i17;
        }
        if (!useSystemMetrics) {
            i16 = max;
        }
        if (!useSystemMetrics) {
            i17 = max2;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteRenderViewBuilder", 1, "[generateWebViewPresentation] surfaceId: " + str + ",densityDpi " + i3 + ",  width " + i16 + ", height: " + i17 + ",  webviewWidth " + max + ", webviewHeight: " + max2 + ",  url " + string);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        sb5.append(currentTimeMillis);
        VirtualDisplay createVirtualDisplay = displayManager.createVirtualDisplay(sb5.toString(), i16, i17, i3, surface, 0);
        Intrinsics.checkNotNullExpressionValue(createVirtualDisplay, "displayManager.createVir\u2026,\n            0\n        )");
        return createVirtualDisplay;
    }

    @NotNull
    public final b d(@NotNull Context context, @NotNull Bundle data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) data);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        VirtualDisplay c16 = c(this, context, data, false, 4, null);
        return new f(data, c16, a(context, data, c16));
    }
}
