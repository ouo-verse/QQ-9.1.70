package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.media.GuildMediaChannelViewModel;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.OpenPluginRuntime;
import com.tencent.mobileqq.guild.util.Logger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \r2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\"\u0010\u0018\u001a\u00020\u00028\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/b;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/e;", "runtime", "", "a", "", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "", "c", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "g", "f", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/e;", "e", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/e;", tl.h.F, "(Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/e;)V", "methodRuntime", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "b", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "d", "()Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "setChannelViewModel", "(Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;)V", "channelViewModel", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class o implements com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    protected OpenPluginRuntime methodRuntime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMediaChannelViewModel channelViewModel;

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public void a(@NotNull OpenPluginRuntime runtime) {
        Activity activity;
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        h(runtime);
        WeakReference<Activity> a16 = runtime.a();
        if (a16 != null) {
            activity = a16.get();
        } else {
            activity = null;
        }
        if (!(activity instanceof FragmentActivity)) {
            return;
        }
        this.channelViewModel = (GuildMediaChannelViewModel) com.tencent.mobileqq.mvvm.h.a(com.tencent.mobileqq.guild.media.presenter.g.f229131d).get(GuildMediaChannelViewModel.class);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: d, reason: from getter */
    public final GuildMediaChannelViewModel getChannelViewModel() {
        return this.channelViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final OpenPluginRuntime e() {
        OpenPluginRuntime openPluginRuntime = this.methodRuntime;
        if (openPluginRuntime != null) {
            return openPluginRuntime;
        }
        Intrinsics.throwUninitializedPropertyAccessException("methodRuntime");
        return null;
    }

    @NotNull
    public String f() {
        return "GuildOpenMediaBaseMethod";
    }

    public final void g(@NotNull ContainerMsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (this.methodRuntime == null) {
            Logger logger = Logger.f235387a;
            String f16 = f();
            Logger.b bVar = new Logger.b();
            bVar.a().add("");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(f16, 1, (String) it.next(), null);
            }
            return;
        }
        e().getHostProvider().b(intent);
    }

    protected final void h(@NotNull OpenPluginRuntime openPluginRuntime) {
        Intrinsics.checkNotNullParameter(openPluginRuntime, "<set-?>");
        this.methodRuntime = openPluginRuntime;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public void onDestroy() {
    }
}
