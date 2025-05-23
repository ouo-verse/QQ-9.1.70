package com.tencent.magicbrush.ext_texture;

import android.graphics.SurfaceTexture;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.q8.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH\u0007J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0007R0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/magicbrush/ext_texture/MBExternalTextureMgr;", "", "", "name", "Lcom/tencent/luggage/wxa/q8/a;", "a", "type", "plugin", "", "", "id", "texId", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureLoad", "onSurfaceTextureUnload", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "pluginMap", "<init>", "()V", "lib-magicbrush-nano_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMBExternalTextureMgr.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MBExternalTextureMgr.kt\ncom/tencent/magicbrush/ext_texture/MBExternalTextureMgr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,27:1\n1#2:28\n*E\n"})
/* loaded from: classes9.dex */
public final class MBExternalTextureMgr {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final HashMap pluginMap;

    public MBExternalTextureMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.pluginMap = new HashMap();
        }
    }

    public final a a(String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        HashMap hashMap = this.pluginMap;
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Object obj = hashMap.get(lowerCase);
        Intrinsics.checkNotNull(obj);
        return (a) obj;
    }

    @Keep
    @NotNull
    public final SurfaceTexture onSurfaceTextureLoad(int id5, @NotNull String type, int texId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(id5), type, Integer.valueOf(texId));
        }
        Intrinsics.checkNotNullParameter(type, "type");
        SurfaceTexture surfaceTexture = new SurfaceTexture(texId);
        a aVar = (a) this.pluginMap.get(type);
        if (aVar != null) {
            aVar.a(id5, surfaceTexture);
        }
        return surfaceTexture;
    }

    @Keep
    public final void onSurfaceTextureUnload(int id5, @NotNull String type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, id5, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        a aVar = (a) this.pluginMap.get(type);
        if (aVar != null) {
            aVar.a(id5);
        }
    }

    public final void a(String type, a plugin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) type, (Object) plugin);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.pluginMap.get(type);
        this.pluginMap.put(type, plugin);
    }
}
