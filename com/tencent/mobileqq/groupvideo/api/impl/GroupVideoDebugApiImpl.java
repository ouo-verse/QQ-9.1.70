package com.tencent.mobileqq.groupvideo.api.impl;

import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi;
import com.tencent.mobileqq.groupvideo.debug.GroupVideoDebugFragment;
import com.tencent.mobileqq.groupvideo.debug.GroupVideoManualApplyFragment;
import com.tencent.mobileqq.intervideo.groupvideo.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/api/impl/GroupVideoDebugApiImpl;", "Lcom/tencent/mobileqq/groupvideo/api/IGroupVideoDebugApi;", "Landroid/content/Context;", "context", "", "openDebugPage", "openPluginManualApply", "Lcom/tencent/mobileqq/intervideo/groupvideo/h;", "groupVideoManager", "setGroupVideoManager", "getGroupVideoManager", "Lcom/tencent/mobileqq/groupvideo/api/IGroupVideoDebugApi$a;", "manager", "setDebugPluginManager", "getDebugPluginManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/intervideo/groupvideo/h;", "debugPluginManager", "Lcom/tencent/mobileqq/groupvideo/api/IGroupVideoDebugApi$a;", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GroupVideoDebugApiImpl implements IGroupVideoDebugApi {
    static IPatchRedirector $redirector_;

    @Nullable
    private IGroupVideoDebugApi.a debugPluginManager;

    @Nullable
    private h groupVideoManager;

    public GroupVideoDebugApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi
    @Nullable
    public IGroupVideoDebugApi.a getDebugPluginManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IGroupVideoDebugApi.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.debugPluginManager;
    }

    @Override // com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi
    @Nullable
    public h getGroupVideoManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (h) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.groupVideoManager;
    }

    @Override // com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.debugPluginManager = null;
            this.groupVideoManager = null;
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi
    public void openDebugPage(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            QPublicFragmentActivity.start(context, GroupVideoDebugFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi
    public void openPluginManualApply(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            QPublicFragmentActivity.start(context, GroupVideoManualApplyFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi
    public void setDebugPluginManager(@NotNull IGroupVideoDebugApi.a manager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) manager);
        } else {
            Intrinsics.checkNotNullParameter(manager, "manager");
            this.debugPluginManager = manager;
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi
    public void setGroupVideoManager(@NotNull h groupVideoManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) groupVideoManager);
        } else {
            Intrinsics.checkNotNullParameter(groupVideoManager, "groupVideoManager");
            this.groupVideoManager = groupVideoManager;
        }
    }
}
