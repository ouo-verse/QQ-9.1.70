package com.tencent.mobileqq.startup.task;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.libra.IPicLoader;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.album.api.IAlbumApi;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IVasAppIconStateManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.qbasealbum.inject.QBaseAlbumCustomize;
import com.tencent.qqnt.qbasealbum.inject.d;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.richframework.gallery.QQLayerUtil;
import com.tencent.richframework.gallery.part.QQVideoProviderPart;
import cooperation.peak.PeakConstants;
import dov.com.qq.im.ae.current.SessionWrap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J*\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/e;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "localMediaInfo", "qualityRaw", "", "l", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "business", "k", TtmlNode.ATTR_TTS_ORIGIN, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", tl.h.F, "i", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "blockUntilFinish", "d", "Z", "isFromFullScreenInput", "<init>", "()V", "e", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isFromFullScreenInput;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/e$a;", "", "", "ALBUM_CACHE_COUNT", "Ljava/lang/String;", "ALBUM_CACHE_LIMIT", "DISABLE_DEPRECATED_FIELD", "RELEASE_MEM_WHEN_EXIT", "SUPPORT_MAGNIFY_LONG_PIC", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.e$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/startup/task/e$b", "Lcom/tencent/qqnt/qbasealbum/inject/b;", "", "isDebugVersion", "isPublicVersion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.qqnt.qbasealbum.inject.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.b
        public boolean isDebugVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.b
        public boolean isPublicVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/startup/task/e$c", "Lcom/tencent/qqnt/qbasealbum/inject/f;", "Landroid/content/Context;", "context", "", "msg", "", "duration", "", UIJsPlugin.EVENT_SHOW_TOAST, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements com.tencent.qqnt.qbasealbum.inject.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.f
        public void showToast(@NotNull Context context, @Nullable CharSequence msg2, int duration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, msg2, Integer.valueOf(duration));
            } else {
                Intrinsics.checkNotNullParameter(context, "context");
                QQToast.makeText(context, msg2, duration).show();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/startup/task/e$d", "Lcom/tencent/qqnt/qbasealbum/inject/e;", "Ljava/lang/Runnable;", "runnable", "", "type", "", "execute", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements com.tencent.qqnt.qbasealbum.inject.e {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.e
        public void execute(@NotNull Runnable runnable, int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, type);
                return;
            }
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            int i3 = 32;
            if (type != 32) {
                i3 = 64;
                if (type != 64) {
                    i3 = 128;
                    if (type != 128) {
                        i3 = 16;
                    }
                }
            }
            ThreadManagerV2.excute(runnable, i3, null, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000W\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016\u00a8\u0006 "}, d2 = {"com/tencent/mobileqq/startup/task/e$e", "Lcom/tencent/qqnt/qbasealbum/inject/d;", "", "getServerTimeMillis", "Landroid/content/Context;", "context", "", "getStatusBarHeight", "", "o", "isNowThemeIsNight", "k", "Landroid/view/View;", "view", "", "f", "Lcom/tencent/libra/IPicLoader;", "getPicLoader", "Lcom/tencent/biz/richframework/part/Part;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isSupportMagnifyLongPic", "e", "a", "g", "Landroid/graphics/drawable/Drawable;", "j", "", "comment", "", "p", "Landroid/content/ComponentName;", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.e$e, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8614e implements com.tencent.qqnt.qbasealbum.inject.d {
        static IPatchRedirector $redirector_;

        C8614e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("disable_deprecated_field", true);
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        @Nullable
        public ComponentName b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (ComponentName) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return SplashActivity.getAliasComponent(BaseApplicationImpl.sApplication);
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
            }
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("album_release_mem_when_exit", true);
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public void f(@NotNull Context context, @NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            if (FontSettingManager.getFontLevel() > 16.0f) {
                FontSettingManager.resetViewSize2Normal(context, view);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public int g() {
            Integer intOrNull;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("album_cache_limit_count", ""));
                if (intOrNull != null) {
                    return intOrNull.intValue();
                }
                return d.a.p(this);
            }
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        @Nullable
        public IPicLoader getPicLoader() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (IPicLoader) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return new com.tencent.qqnt.aio.gallery.pic.a(((IPicAIOApi) QRoute.api(IPicAIOApi.class)).getPicLoader());
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public long getServerTimeMillis() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return NetConnInfoCenter.getServerTimeMillis();
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public int getStatusBarHeight(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).intValue();
            }
            Intrinsics.checkNotNullParameter(context, "context");
            return ImmersiveUtils.getStatusBarHeight(context);
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public boolean isCameraResReady() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
            }
            return d.a.j(this);
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public boolean isNowThemeIsNight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return QQTheme.isNowThemeIsNight();
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public boolean isSupportMagnifyLongPic() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("SUPPORT_MAGNIFY_LONG_PIC", true);
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        @Nullable
        public Drawable j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Drawable) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return QQLayerUtil.INSTANCE.tintDrawableSafely(ResourcesCompat.getDrawable(BaseApplication.context.getResources(), R.drawable.qui_image_broken, null), Color.parseColor("#4D4D4D"));
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public boolean k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return !Foreground.isCurrentProcessForeground();
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public boolean o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        @Nullable
        public CharSequence p(@NotNull String comment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (CharSequence) iPatchRedirector.redirect((short) 16, (Object) this, (Object) comment);
            }
            Intrinsics.checkNotNullParameter(comment, "comment");
            return new QQText(comment, 3).toPlainText(false);
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        @Nullable
        public Part q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Part) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return new QQVideoProviderPart(165);
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.d
        public int r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
            }
            return d.a.q(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/startup/task/e$f", "Lcom/tencent/qqnt/qbasealbum/inject/c;", "Landroid/content/Intent;", "intent", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "localMediaInfo", "", "qualityRaw", "business", "", "l", "i", "Landroid/os/Bundle;", "bundle", DomainData.DOMAIN_NAME, "comment", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/a;", "listener", tl.h.F, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f implements com.tencent.qqnt.qbasealbum.inject.c {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.c
        @Nullable
        public LocalMediaInfo c(@NotNull Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LocalMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            com.tencent.mobileqq.activity.photo.LocalMediaInfo localMediaInfo = (com.tencent.mobileqq.activity.photo.LocalMediaInfo) intent.getSerializableExtra(PeakConstants.VIDEO_EDIT_OLD_MEDIA);
            if (localMediaInfo != null) {
                return e.this.i(localMediaInfo);
            }
            return null;
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.c
        @Nullable
        public LocalMediaInfo d(@NotNull Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (LocalMediaInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            com.tencent.mobileqq.activity.photo.LocalMediaInfo localMediaInfo = (com.tencent.mobileqq.activity.photo.LocalMediaInfo) intent.getSerializableExtra(PeakConstants.VIDEO_EDIT_NEW_MEDIA);
            if (localMediaInfo != null) {
                return e.this.i(localMediaInfo);
            }
            return null;
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.c
        public void h(@NotNull Activity activity, @NotNull String comment, @NotNull com.tencent.qqnt.qbasealbum.preview.fragment.a listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, activity, comment, listener);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(listener, "listener");
            ((IPhotoPanelApi) QRoute.api(IPhotoPanelApi.class)).onUp(activity, comment, listener);
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.c
        public void i(@NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean qualityRaw, @Nullable String business) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, activity, localMediaInfo, Boolean.valueOf(qualityRaw), business);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
            QLog.d("AlbumInitTask", 1, "onPreviewEditClick busi: ", business);
            if (e.this.n(activity)) {
                QQToast.makeText(activity, "\u8be5\u529f\u80fd\u65e0\u6cd5\u5728\u5206\u5c4f\u6a21\u5f0f\u4e0b\u4f7f\u7528", 0).show();
                return;
            }
            activity.getIntent().putExtra("goEdit", true);
            activity.getIntent().putExtra("editFromPage", 2);
            activity.getIntent().putExtra(PeakConstants.USE_NEW_ALBUM, true);
            activity.getIntent().putExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, e.this.isFromFullScreenInput);
            if (com.tencent.qqnt.qbasealbum.ktx.b.o(localMediaInfo)) {
                e.this.m(activity, localMediaInfo, qualityRaw);
            } else {
                e.this.k(activity, localMediaInfo, business, qualityRaw);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.c
        public void l(@NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean qualityRaw, @Nullable String business) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, activity, localMediaInfo, Boolean.valueOf(qualityRaw), business);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
            QLog.d("AlbumInitTask", 1, "onPickerEditClick busi: ", business);
            if (e.this.n(activity)) {
                QQToast.makeText(activity, "\u8be5\u529f\u80fd\u65e0\u6cd5\u5728\u5206\u5c4f\u6a21\u5f0f\u4e0b\u4f7f\u7528", 0).show();
                return;
            }
            activity.getIntent().putExtra(PeakConstants.USE_NEW_ALBUM, true);
            activity.getIntent().putExtra("goEdit", true);
            activity.getIntent().putExtra("editFromPage", 1);
            activity.getIntent().putExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, e.this.isFromFullScreenInput);
            if (com.tencent.qqnt.qbasealbum.ktx.b.o(localMediaInfo)) {
                e.this.l(activity, localMediaInfo, qualityRaw);
            } else {
                e.this.j(activity, localMediaInfo);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqnt.qbasealbum.inject.c
        @Nullable
        public HashMap<String, LocalMediaInfo> m(@NotNull Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            HashMap hashMap = (HashMap) intent.getSerializableExtra(QAlbumConstants.ALL_MEDIA_PATHS);
            if (hashMap == null) {
                return null;
            }
            HashMap<String, LocalMediaInfo> hashMap2 = new HashMap<>();
            e eVar = e.this;
            for (Map.Entry entry : hashMap.entrySet()) {
                hashMap2.put(entry.getKey(), eVar.i((com.tencent.mobileqq.activity.photo.LocalMediaInfo) entry.getValue()));
            }
            return hashMap2;
        }

        @Override // com.tencent.qqnt.qbasealbum.inject.c
        public void n(@NotNull Activity activity, @NotNull Bundle bundle) {
            boolean z16;
            boolean z17;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intent intent = activity.getIntent();
            boolean z18 = false;
            boolean booleanExtra = intent.getBooleanExtra(PeakConstants.KEY_BACK_TO_INIT_CLASS, false);
            String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            String str = "";
            if (stringExtra == null) {
                stringExtra = "";
            }
            String stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            SessionWrap sessionWrap = (SessionWrap) intent.getParcelableExtra(AECameraConstants.ARG_SESSION_INFO);
            QLog.d("AlbumInitTask", 1, "onSendClick sessionWrap:" + sessionWrap + " className: " + stringExtra + " pkgName: " + stringExtra2 + " backToInitClass: " + booleanExtra);
            if (booleanExtra && sessionWrap != null) {
                if (stringExtra.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (stringExtra2.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        try {
                            j3 = Long.parseLong(sessionWrap.f394447d);
                        } catch (Exception unused) {
                            j3 = 0;
                        }
                        if (!Intrinsics.areEqual(SplashActivity.class.getName(), stringExtra)) {
                            Pair<Integer, String>[] allAlias = ((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).getAllAlias();
                            int length = allAlias.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                if (Intrinsics.areEqual(stringExtra, allAlias[i3].getSecond())) {
                                    z18 = true;
                                    break;
                                }
                                i3++;
                            }
                            if (!z18) {
                                Intent intent2 = new Intent();
                                intent2.setClassName(stringExtra2, stringExtra);
                                intent2.putExtras(bundle);
                                intent2.putExtra("key_chat_type", sessionWrap.f394451i);
                                String str2 = sessionWrap.f394452m;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                intent2.putExtra("key_peerId", str2);
                                String str3 = sessionWrap.f394448e;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                intent2.putExtra("key_chat_name", str3);
                                String str4 = sessionWrap.f394447d;
                                if (str4 != null) {
                                    str = str4;
                                }
                                intent2.putExtra("key_peerUin", str);
                                intent2.addFlags(603979776);
                                activity.startActivity(intent2);
                                return;
                            }
                        }
                        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
                        int i16 = sessionWrap.f394451i;
                        String str5 = sessionWrap.f394452m;
                        if (str5 == null) {
                            str5 = "";
                        }
                        String str6 = sessionWrap.f394448e;
                        if (str6 != null) {
                            str = str6;
                        }
                        iAIOStarterApi.navigateToAIO(activity, i16, str5, str, j3, bundle);
                        return;
                    }
                }
            }
            QLog.d("AlbumInitTask", 1, "onSendClick not jump target then return.");
            activity.setResult(-1, new Intent().putExtras(bundle));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61424);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.activity.photo.LocalMediaInfo h(LocalMediaInfo origin) {
        com.tencent.mobileqq.activity.photo.LocalMediaInfo localMediaInfo = new com.tencent.mobileqq.activity.photo.LocalMediaInfo();
        localMediaInfo._id = origin.get_id();
        localMediaInfo.path = origin.getPath();
        localMediaInfo.fileSize = origin.getFileSize();
        localMediaInfo.addedDate = origin.getAddedDate();
        localMediaInfo.modifiedDate = origin.getModifiedDate();
        localMediaInfo.orientation = origin.getOrientation();
        localMediaInfo.mDuration = com.tencent.qqnt.qbasealbum.ktx.b.f(origin);
        localMediaInfo.mChecked = origin.getMChecked();
        localMediaInfo.isSegment = origin.isSegment();
        localMediaInfo.selectStatus = origin.getSelectStatus();
        localMediaInfo.rotation = origin.getRotation();
        localMediaInfo.thumbWidth = origin.getThumbWidth();
        localMediaInfo.thumbHeight = origin.getThumbHeight();
        localMediaInfo.index = origin.getIndex();
        localMediaInfo.position = Integer.valueOf(origin.getPosition());
        localMediaInfo.mMimeType = origin.getMMimeType();
        localMediaInfo.mediaWidth = origin.getMediaWidth();
        localMediaInfo.mediaHeight = origin.getMediaHeight();
        localMediaInfo.mediaBitrate = origin.getMediaBitrate();
        localMediaInfo.isSystemMeidaStore = origin.isSystemMeidaStore();
        localMediaInfo.isRegionThumbUseNewDecoder = origin.isRegionThumbUseNewDecoder();
        localMediaInfo.panoramaPhotoType = origin.getPanoramaPhotoType();
        localMediaInfo.mMediaType = origin.getMMediaType();
        localMediaInfo.isVideoReady = origin.isVideoReady();
        localMediaInfo.materialID = origin.getMaterialID();
        localMediaInfo.materialName = origin.getMaterialName();
        localMediaInfo.filterID = origin.getFilterID();
        localMediaInfo.scheme = origin.getScheme();
        localMediaInfo.showCircleTakeSame = origin.getShowCircleTakeSame();
        localMediaInfo.missionID = origin.getMissionID();
        localMediaInfo.thumbnailProgress = origin.getThumbnailProgress();
        localMediaInfo.mediaOriginWidth = origin.getMediaOriginWidth();
        localMediaInfo.mediaOriginHeight = origin.getMediaOriginHeight();
        localMediaInfo.mediaOriginSize = origin.getMediaOriginSize();
        localMediaInfo.mediaOriginBitrate = origin.getMediaOriginBitrate();
        localMediaInfo.mOriginPath = origin.getMOriginPath();
        localMediaInfo.mKuolieId = origin.getMKuolieId();
        localMediaInfo.mKuolieCenterX = origin.getMKuolieCenterX();
        localMediaInfo.mKuolieCenterY = origin.getMKuolieCenterY();
        localMediaInfo.mKuolieRotate = origin.getMKuolieRotate();
        localMediaInfo.mKuolieWidthScale = origin.getMKuolieWidthScale();
        localMediaInfo.mKuolieHeightScale = origin.getMKuolieHeightScale();
        localMediaInfo.picPathBeforeEdit = origin.getPicPathBeforeEdit();
        localMediaInfo.videoMimeType = origin.getVideoMimeType();
        localMediaInfo.isHDRVideo = origin.isHDRVideo();
        return localMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalMediaInfo i(com.tencent.mobileqq.activity.photo.LocalMediaInfo origin) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo(false, 1, null);
        localMediaInfo.set_id(origin._id);
        localMediaInfo.setPath(origin.path);
        localMediaInfo.setFileSize(origin.fileSize);
        localMediaInfo.setAddedDate(origin.addedDate);
        localMediaInfo.setModifiedDate(origin.modifiedDate);
        localMediaInfo.setOrientation(origin.orientation);
        com.tencent.qqnt.qbasealbum.ktx.b.t(localMediaInfo, origin.mDuration);
        localMediaInfo.setMChecked(origin.mChecked);
        localMediaInfo.setSegment(origin.isSegment);
        localMediaInfo.setSelectStatus(origin.selectStatus);
        localMediaInfo.setRotation(origin.rotation);
        localMediaInfo.setThumbWidth(origin.thumbWidth);
        localMediaInfo.setThumbHeight(origin.thumbHeight);
        localMediaInfo.setIndex(origin.index);
        Integer num = origin.position;
        Intrinsics.checkNotNullExpressionValue(num, "origin.position");
        localMediaInfo.setPosition(num.intValue());
        localMediaInfo.setMMimeType(origin.mMimeType);
        localMediaInfo.setMediaWidth(origin.mediaWidth);
        localMediaInfo.setMediaHeight(origin.mediaHeight);
        localMediaInfo.setMediaBitrate(origin.mediaBitrate);
        localMediaInfo.setSystemMeidaStore(origin.isSystemMeidaStore);
        localMediaInfo.setRegionThumbUseNewDecoder(origin.isRegionThumbUseNewDecoder);
        localMediaInfo.setPanoramaPhotoType(origin.panoramaPhotoType);
        localMediaInfo.setMMediaType(origin.mMediaType);
        localMediaInfo.setVideoReady(origin.isVideoReady);
        localMediaInfo.setMaterialID(origin.materialID);
        localMediaInfo.setMaterialName(origin.materialName);
        localMediaInfo.setFilterID(origin.filterID);
        localMediaInfo.setScheme(origin.scheme);
        localMediaInfo.setShowCircleTakeSame(origin.showCircleTakeSame);
        localMediaInfo.setMissionID(origin.missionID);
        localMediaInfo.setThumbnailProgress(origin.thumbnailProgress);
        localMediaInfo.setMediaOriginWidth(origin.mediaOriginWidth);
        localMediaInfo.setMediaOriginHeight(origin.mediaOriginHeight);
        localMediaInfo.setMediaOriginSize(origin.mediaOriginSize);
        localMediaInfo.setMediaOriginBitrate(origin.mediaOriginBitrate);
        localMediaInfo.setMOriginPath(origin.mOriginPath);
        localMediaInfo.setMKuolieId(origin.mKuolieId);
        localMediaInfo.setMKuolieCenterX(origin.mKuolieCenterX);
        localMediaInfo.setMKuolieCenterY(origin.mKuolieCenterY);
        localMediaInfo.setMKuolieRotate(origin.mKuolieRotate);
        localMediaInfo.setMKuolieWidthScale(origin.mKuolieWidthScale);
        localMediaInfo.setMKuolieHeightScale(origin.mKuolieHeightScale);
        localMediaInfo.setPicPathBeforeEdit(origin.picPathBeforeEdit);
        localMediaInfo.setVideoMimeType(origin.videoMimeType);
        localMediaInfo.setHDRVideo(origin.isHDRVideo);
        return localMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Activity activity, LocalMediaInfo localMediaInfo) {
        Intent editPicActivityIntent = ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toEditPicActivityIntent(activity, null, localMediaInfo.getPath(), 2, new Bundle());
        if (this.isFromFullScreenInput) {
            activity.startActivityForResult(editPicActivityIntent, 10018);
        } else {
            activity.startActivity(editPicActivityIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Activity activity, LocalMediaInfo localMediaInfo, String business, boolean qualityRaw) {
        int i3;
        if (Intrinsics.areEqual(business, "FAST_IMAGE")) {
            activity.startActivity(((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toEditPicActivityIntent(activity, null, localMediaInfo.getPath(), 2, new Bundle()));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_multi_edit_pic", true);
        bundle.putBoolean(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
        if (qualityRaw) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        bundle.putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, i3);
        activity.startActivityForResult(((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toEditPicActivityIntent(activity, null, localMediaInfo.getPath(), 2, bundle), 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Activity activity, LocalMediaInfo localMediaInfo, boolean qualityRaw) {
        int i3 = 0;
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio")) {
            QQToast.makeText(activity, "\u89c6\u9891\u7f16\u8f91\u8d44\u6e90\u4e0b\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(activity.getIntent());
        if (qualityRaw) {
            i3 = 2;
        }
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, i3);
        intent.putExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 5);
        intent.putExtra(PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, true);
        ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToVideoEditPage(activity, intent, h(localMediaInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Activity activity, LocalMediaInfo localMediaInfo, boolean qualityRaw) {
        int i3 = 0;
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio")) {
            QQToast.makeText(activity, "\u89c6\u9891\u7f16\u8f91\u8d44\u6e90\u4e0b\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(activity.getIntent());
        if (qualityRaw) {
            i3 = 2;
        }
        activity.getIntent().putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, i3);
        intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, activity.getPackageName());
        intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, "com.tencent.mobileqq.activity.photo.SendPhotoActivity");
        intent.putExtra(PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, true);
        ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToVideoEditPage(activity, intent, h(localMediaInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(Activity activity) {
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                isInMultiWindowMode = activity.isInMultiWindowMode();
                return isInMultiWindowMode;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        IAlbumApi iAlbumApi = (IAlbumApi) QRoute.api(IAlbumApi.class);
        QBaseAlbumCustomize.Companion companion = QBaseAlbumCustomize.INSTANCE;
        QBaseAlbumCustomize.Builder builder = new QBaseAlbumCustomize.Builder();
        builder.b(new b());
        builder.f(new c());
        builder.e(new d());
        builder.d(new C8614e());
        builder.c(new f());
        Unit unit = Unit.INSTANCE;
        iAlbumApi.initAlbum(context, false, builder.a());
    }
}
