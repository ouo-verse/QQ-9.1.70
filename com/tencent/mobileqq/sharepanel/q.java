package com.tencent.mobileqq.sharepanel;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010F\u001a\u00020;\u0012\u0006\u0010G\u001a\u00020\u0002\u00a2\u0006\u0004\bH\u0010IJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0001H\u0016J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\u00012\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010,\u001a\u00020\u00012\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\u00012\u0006\u0010+\u001a\u00020-H\u0016J\u0010\u00100\u001a\u00020\u00012\u0006\u0010+\u001a\u00020/H\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u0010+\u001a\u000201H\u0016J\u0010\u00104\u001a\u00020\u00012\u0006\u0010+\u001a\u000203H\u0016J\u0010\u00107\u001a\u00020\u00012\u0006\u00106\u001a\u000205H\u0016J\b\u00108\u001a\u00020\tH\u0016J\b\u00109\u001a\u00020\tH\u0016R\"\u0010>\u001a\u0010\u0012\f\u0012\n <*\u0004\u0018\u00010;0;0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010=R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/q;", "Lcom/tencent/mobileqq/sharepanel/f;", "", "actionId", "", "", "modifyMap", "", NodeProps.VISIBLE, "", "b", NodeProps.ENABLED, "a", "s0", "", "title", "setTitle", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "q0", "channelId", "l0", "u0", "c0", "m0", "j0", "o0", "Lcom/tencent/mobileqq/sharepanel/e;", "filter", "g0", "Lcom/tencent/mobileqq/sharepanel/p;", "checker", "h0", "Lcom/tencent/mobileqq/sharepanel/n;", "handler", "k0", "Lcom/tencent/mobileqq/sharepanel/d;", "interceptor", "p0", "Lcom/tencent/mobileqq/sharepanel/b;", "callback", "f0", "Lcom/tencent/mobileqq/sharepanel/l;", "listener", "e0", "Lcom/tencent/mobileqq/sharepanel/k;", "n0", "Lcom/tencent/mobileqq/sharepanel/i;", "i0", "Lcom/tencent/mobileqq/sharepanel/j;", "t0", "Lcom/tencent/mobileqq/sharepanel/h;", "r0", "Lcom/tencent/mobileqq/sharepanel/model/d;", "params", "d0", "show", "dismiss", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "activityRef", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "sharePanelParam", "Lcom/tencent/mobileqq/sharepanel/launcher/a;", "c", "Lcom/tencent/mobileqq/sharepanel/launcher/a;", "sharePanelLaunch", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, WadlProxyConsts.SCENE_ID, "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class q implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FragmentActivity> activityRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SharePanelParam sharePanelParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.launcher.a sharePanelLaunch;

    public q(@NotNull FragmentActivity activity, @NotNull String sceneId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) sceneId);
            return;
        }
        this.activityRef = new WeakReference<>(activity);
        SharePanelParam sharePanelParam = new SharePanelParam();
        this.sharePanelParam = sharePanelParam;
        sharePanelParam.i0(sceneId);
    }

    private final void a(String actionId, Map<String, Integer> modifyMap, boolean enabled) {
        int i3;
        Integer num = modifyMap.get(actionId);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (enabled) {
            modifyMap.put(actionId, Integer.valueOf(i3 & (-3)));
        } else {
            modifyMap.put(actionId, Integer.valueOf(i3 | 2));
        }
    }

    private final void b(String actionId, Map<String, Integer> modifyMap, boolean visible) {
        int i3;
        Integer num = modifyMap.get(actionId);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (visible) {
            modifyMap.put(actionId, Integer.valueOf(i3 & (-2)));
        } else {
            modifyMap.put(actionId, Integer.valueOf(i3 | 1));
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f c0(@NotNull String actionId, boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, this, actionId, Boolean.valueOf(visible));
        }
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        b(actionId, this.sharePanelParam.c().b(), visible);
        com.tencent.mobileqq.sharepanel.launcher.a aVar = this.sharePanelLaunch;
        if (aVar != null) {
            aVar.b(this.sharePanelParam.c());
        }
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f d0(@NotNull com.tencent.mobileqq.sharepanel.model.d params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (f) iPatchRedirector.redirect((short) 22, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        this.sharePanelParam.h0(params);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        com.tencent.mobileqq.sharepanel.launcher.a aVar = this.sharePanelLaunch;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f e0(@NotNull l listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (f) iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sharePanelParam.c0(listener);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f f0(@NotNull b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (f) iPatchRedirector.redirect((short) 16, (Object) this, (Object) callback);
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.sharePanelParam.M(callback);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f g0(@NotNull e filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (f) iPatchRedirector.redirect((short) 12, (Object) this, (Object) filter);
        }
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.sharePanelParam.f0(filter);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f h0(@NotNull p checker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (f) iPatchRedirector.redirect((short) 13, (Object) this, (Object) checker);
        }
        Intrinsics.checkNotNullParameter(checker, "checker");
        this.sharePanelParam.l0(checker);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f i0(@NotNull i listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (f) iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sharePanelParam.V(listener);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f j0(@NotNull String channelId, boolean enabled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (f) iPatchRedirector.redirect((short) 10, this, channelId, Boolean.valueOf(enabled));
        }
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        a(channelId, this.sharePanelParam.c().c(), enabled);
        com.tencent.mobileqq.sharepanel.launcher.a aVar = this.sharePanelLaunch;
        if (aVar != null) {
            aVar.b(this.sharePanelParam.c());
        }
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f k0(@NotNull n handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (f) iPatchRedirector.redirect((short) 14, (Object) this, (Object) handler);
        }
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.sharePanelParam.d0(handler);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f l0(@NotNull String channelId, boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (f) iPatchRedirector.redirect((short) 6, this, channelId, Boolean.valueOf(visible));
        }
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        b(channelId, this.sharePanelParam.c().c(), visible);
        com.tencent.mobileqq.sharepanel.launcher.a aVar = this.sharePanelLaunch;
        if (aVar != null) {
            aVar.b(this.sharePanelParam.c());
        }
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f m0(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (f) iPatchRedirector.redirect((short) 9, (Object) this, visible);
        }
        Iterator<String> it = com.tencent.mobileqq.sharepanel.config.biz.b.f287223a.b(this.sharePanelParam.u()).c().iterator();
        while (it.hasNext()) {
            b(it.next(), this.sharePanelParam.c().b(), visible);
        }
        com.tencent.mobileqq.sharepanel.launcher.a aVar = this.sharePanelLaunch;
        if (aVar != null) {
            aVar.b(this.sharePanelParam.c());
        }
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f n0(@NotNull k listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (f) iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sharePanelParam.b0(listener);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f o0(@NotNull String actionId, boolean enabled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (f) iPatchRedirector.redirect((short) 11, this, actionId, Boolean.valueOf(enabled));
        }
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        a(actionId, this.sharePanelParam.c().b(), enabled);
        com.tencent.mobileqq.sharepanel.launcher.a aVar = this.sharePanelLaunch;
        if (aVar != null) {
            aVar.b(this.sharePanelParam.c());
        }
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f p0(@NotNull d interceptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (f) iPatchRedirector.redirect((short) 15, (Object) this, (Object) interceptor);
        }
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.sharePanelParam.G(interceptor);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f q0(@NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.sharePanelParam.e0(bitmap);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f r0(@NotNull h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (f) iPatchRedirector.redirect((short) 21, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sharePanelParam.a0(listener);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.sharePanelParam.N(true);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f setTitle(@NotNull CharSequence title) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) title);
        }
        Intrinsics.checkNotNullParameter(title, "title");
        this.sharePanelParam.m0(title);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (this.sharePanelLaunch == null) {
            this.sharePanelLaunch = com.tencent.mobileqq.sharepanel.launcher.b.f287360a.a();
        }
        FragmentActivity fragmentActivity = this.activityRef.get();
        if (fragmentActivity != null) {
            this.sharePanelParam.j0(new com.tencent.mobileqq.sharepanel.channel.h(fragmentActivity));
            com.tencent.mobileqq.sharepanel.launcher.a aVar = this.sharePanelLaunch;
            if (aVar != null) {
                aVar.a(fragmentActivity, this.sharePanelParam);
            }
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f t0(@NotNull j listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (f) iPatchRedirector.redirect((short) 20, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sharePanelParam.Z(listener);
        return this;
    }

    @Override // com.tencent.mobileqq.sharepanel.f
    @NotNull
    public f u0(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (f) iPatchRedirector.redirect((short) 7, (Object) this, visible);
        }
        Iterator<String> it = com.tencent.mobileqq.sharepanel.config.biz.b.f287223a.b(this.sharePanelParam.u()).d().iterator();
        while (it.hasNext()) {
            b(it.next(), this.sharePanelParam.c().c(), visible);
        }
        com.tencent.mobileqq.sharepanel.launcher.a aVar = this.sharePanelLaunch;
        if (aVar != null) {
            aVar.b(this.sharePanelParam.c());
        }
        return this;
    }
}
