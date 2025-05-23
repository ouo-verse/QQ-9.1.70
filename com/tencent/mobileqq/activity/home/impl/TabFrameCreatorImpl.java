package com.tencent.mobileqq.activity.home.impl;

import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.ITabFrameCreator;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/activity/home/impl/TabFrameCreatorImpl;", "Lcom/tencent/mobileqq/activity/home/ITabFrameCreator;", "()V", "buildFrameByKey", "Lcom/tencent/mobileqq/app/Frame;", "key", "", "fragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class TabFrameCreatorImpl implements ITabFrameCreator {
    static IPatchRedirector $redirector_;

    public TabFrameCreatorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameCreator
    @Nullable
    public Frame buildFrameByKey(@NotNull String key, @NotNull FrameFragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Frame) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, (Object) fragment);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        switch (key.hashCode()) {
            case -1696487127:
                if (key.equals(TabDataHelper.TAB_META_DREAM)) {
                    return ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).newMetaDreamFrame(fragment);
                }
                break;
            case -1237531517:
                if (key.equals(TabDataHelper.TAB_CONVERSATION)) {
                    return new Conversation();
                }
                break;
            case -841706509:
                if (key.equals(TabDataHelper.TAB_NEW_WORLD)) {
                    return new QCircleFrame();
                }
                break;
            case 2332536:
                if (key.equals(TabDataHelper.TAB_LEBA)) {
                    return ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).newLebaFrame(fragment);
                }
                break;
            case 68174803:
                if (key.equals("GUILD")) {
                    return ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).newGuildMainFrame(fragment);
                }
                break;
            case 77564797:
                if (key.equals("QZONE")) {
                    return new QzoneFrame();
                }
                break;
            case 1669509120:
                if (key.equals(TabDataHelper.TAB_CONTACT)) {
                    return new Contacts();
                }
                break;
        }
        QLog.d("TabFrameCreatorImpl", 1, key + " is not support to create frame");
        return null;
    }
}
