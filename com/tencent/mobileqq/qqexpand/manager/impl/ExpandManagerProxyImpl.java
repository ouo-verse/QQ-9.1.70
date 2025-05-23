package com.tencent.mobileqq.qqexpand.manager.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy;
import com.tencent.mobileqq.qqexpand.manager.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J,\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/manager/impl/ExpandManagerProxyImpl;", "Lcom/tencent/mobileqq/qqexpand/manager/IExpandManagerProxy;", "()V", "getExpandFriendDataCache", "Lcom/tencent/mobileqq/qqexpand/bean/chat/ExpandFriendData;", "appRuntime", "Lmqq/app/AppRuntime;", "uin", "", "loadDbIfNotExist", "", "getExpandFriendDataSingleAttribute", "", "matchUin", "attributeId", "", "getVoiceMaxDuration", "isResourceReady", "setExpandEntry", "", "updateExpandFriendData", "expandFriendData", "updateExpandFriendDataSingleAttribute", "content", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ExpandManagerProxyImpl implements IExpandManagerProxy {
    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy
    public ExpandFriendData getExpandFriendDataCache(AppRuntime appRuntime, String uin, boolean loadDbIfNotExist) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        c cVar = (c) appRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (cVar != null) {
            return cVar.o(uin, loadDbIfNotExist);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy
    public Object getExpandFriendDataSingleAttribute(AppRuntime appRuntime, String matchUin, int attributeId) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        c cVar = (c) appRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (cVar != null) {
            return cVar.q(matchUin, attributeId);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy
    public int getVoiceMaxDuration(AppRuntime appRuntime) {
        ExpandConfig e16;
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        ExpandManager expandManager = (ExpandManager) appRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (expandManager == null || (e16 = expandManager.e()) == null) {
            return 0;
        }
        return e16.voiceMaxLength;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy
    public boolean isResourceReady(AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        ExpandManager expandManager = (ExpandManager) appRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (expandManager != null) {
            return expandManager.isResourceReady();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy
    public void setExpandEntry(AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        ExpandManager expandManager = (ExpandManager) appRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (expandManager != null) {
            expandManager.W((QQAppInterface) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy
    public void updateExpandFriendData(AppRuntime appRuntime, ExpandFriendData expandFriendData) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(expandFriendData, "expandFriendData");
        c cVar = (c) appRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (cVar != null) {
            cVar.F(expandFriendData);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy
    public void updateExpandFriendDataSingleAttribute(AppRuntime appRuntime, String matchUin, int attributeId, Object content) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        c cVar = (c) appRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (cVar != null) {
            cVar.G(matchUin, attributeId, content);
        }
    }
}
