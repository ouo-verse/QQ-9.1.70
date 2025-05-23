package com.tencent.qqnt.emoticon.api.impl;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.freesia.IConfigData;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.event.EmotionPanelMsgIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.c;
import com.tencent.qqnt.emoticon.api.IEmoticonApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.device.OfflineConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J#\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\f*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/emoticon/api/impl/EmoticonApiImpl;", "Lcom/tencent/qqnt/emoticon/api/IEmoticonApi;", "Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", "panelType", "", "showEmoticonPanel", "Ljava/lang/Class;", "getEmoticonSpanClass", "Lcom/tencent/freesia/IConfigData;", "T", "", VipFunCallConstants.KEY_GROUP, "loadConfig", "(Ljava/lang/String;)Lcom/tencent/freesia/IConfigData;", "Landroid/content/Context;", "ctx", "getDevicePerfLevel", "showZPlanEmoticonPanel", "showCompositeEmoticonPanel", "showAIEmoticonPanel", "<init>", "()V", "Companion", "a", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class EmoticonApiImpl implements IEmoticonApi<EmoticonSpan> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "EmoticonApi";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/emoticon/api/impl/EmoticonApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emoticon.api.impl.EmoticonApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21944);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmoticonApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void showEmoticonPanel(FragmentActivity fragmentActivity, int panelType) {
        c cVar = c.f352293a;
        cVar.a(fragmentActivity, new EmotionPanelMsgIntent.SetEmotionPanelDefaultType(panelType));
        cVar.a(fragmentActivity, new PanelContainerMsgIntent.ShowPanelMsgIntent(TAG, 1001, false, 0, 12, null));
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    public int getDevicePerfLevel(@NotNull Context ctx) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) ctx)).intValue();
        }
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            return OfflineConfig.getPhonePerfLevel(ctx);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getDevicePerfLevel] error! stack=", th5);
            return -1;
        }
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    @NotNull
    public Class<EmoticonSpan> getEmoticonSpanClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return EmoticonSpan.class;
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    @Nullable
    public <T extends IConfigData> T loadConfig(@NotNull String group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) group);
        }
        Intrinsics.checkNotNullParameter(group, "group");
        return (T) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(group);
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    public void showAIEmoticonPanel(@NotNull FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fragmentActivity);
        } else {
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
            showEmoticonPanel(fragmentActivity, 20);
        }
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    public void showCompositeEmoticonPanel(@NotNull FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fragmentActivity);
        } else {
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
            showEmoticonPanel(fragmentActivity, 18);
        }
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    public void showZPlanEmoticonPanel(@NotNull FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fragmentActivity);
        } else {
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
            showEmoticonPanel(fragmentActivity, 17);
        }
    }
}
