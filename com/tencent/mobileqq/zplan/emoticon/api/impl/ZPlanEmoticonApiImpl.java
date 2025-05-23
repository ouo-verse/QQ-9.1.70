package com.tencent.mobileqq.zplan.emoticon.api.impl;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000bH\u0096\u0001\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/api/impl/ZPlanEmoticonApiImpl;", "Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonApi;", "", "checkCreateRole", "Landroid/content/Context;", "context", "", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "Landroid/widget/RelativeLayout;", "generateZPlanAioPanelLayout", "getVersion", "", "friendUin", "jumpFromSource", "", "jumpToEmoticon", "Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonApi$b;", "zPlanEmoticonDetailRequestListener", "setZPlanEmoticonDetailView", "peerUin", "updateVersion", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonApiImpl implements IZPlanEmoticonApi {
    private final /* synthetic */ ZPlanEmoticonApi $$delegate_0 = ZPlanEmoticonApi.INSTANCE;

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public boolean checkCreateRole() {
        return this.$$delegate_0.checkCreateRole();
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public RelativeLayout generateZPlanAioPanelLayout(Context context, int sessionType) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.$$delegate_0.generateZPlanAioPanelLayout(context, sessionType);
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public int getVersion(int sessionType) {
        return this.$$delegate_0.getVersion(sessionType);
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public void jumpToEmoticon(Context context, String friendUin, String jumpFromSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(jumpFromSource, "jumpFromSource");
        this.$$delegate_0.jumpToEmoticon(context, friendUin, jumpFromSource);
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public void setZPlanEmoticonDetailView(IZPlanEmoticonApi.b zPlanEmoticonDetailRequestListener) {
        Intrinsics.checkNotNullParameter(zPlanEmoticonDetailRequestListener, "zPlanEmoticonDetailRequestListener");
        this.$$delegate_0.setZPlanEmoticonDetailView(zPlanEmoticonDetailRequestListener);
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public void updateVersion(int sessionType, String peerUin) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        this.$$delegate_0.updateVersion(sessionType, peerUin);
    }
}
