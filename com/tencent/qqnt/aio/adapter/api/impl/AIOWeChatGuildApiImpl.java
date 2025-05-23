package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.mobileqq.wechatguildreport.api.src.WechatGuildManager;
import com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOWeChatGuildApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;", "type", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "translationType", "", "requestTianshuConfig", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$a;", "getConfigData", "", "isWeChatMsgAgentFlagSuc", "isWeChatMsgAgentOpen", "report", "", "time", "reportClik", "getLastTime", "requestTianshuConfigIfNeeds", QCircleLpReportDc05507.KEY_CLEAR, "Landroid/content/Context;", "context", "openWeChatMiniApp", "isShowWechatGuildSettingItemRedDot", "", WadlProxyConsts.KEY_JUMP_URL, "handleUrl", "openWechat", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOWeChatGuildApiImpl implements IAIOWeChatGuildApi {
    private final IWeChatGuildApi.BIZ_TYPE_WX translationType(IAIOWeChatGuildApi.BIZ_TYPE_WX type) {
        return IWeChatGuildApi.BIZ_TYPE_WX.INSTANCE.a(type.getValue());
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public void clear() {
        WechatGuildManager.INSTANCE.a().clear();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public IAIOWeChatGuildApi.a getConfigData(IAIOWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IWeChatGuildApi.a configData = WechatGuildManager.INSTANCE.a().getConfigData(translationType(type));
        if (configData == null) {
            return null;
        }
        aq aqVar = new aq(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx = configData.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String();
        aqVar.g(IAIOWeChatGuildApi.BIZ_TYPE_WX.INSTANCE.a(biz_type_wx != null ? biz_type_wx.getValue() : 0));
        aqVar.b(configData.getIAdId());
        aqVar.h(configData.getText());
        aqVar.a(configData.getCom.tencent.oskplayer.util.SecretUtils.DES java.lang.String());
        aqVar.c(configData.getIconUrl());
        aqVar.e(configData.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String());
        aqVar.i(configData.getCom.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO java.lang.String());
        aqVar.f(configData.getType());
        aqVar.j(configData.getRedType());
        aqVar.d(configData.getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String());
        return aqVar;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public long getLastTime(IAIOWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return WechatGuildManager.INSTANCE.a().getLastTime(translationType(type));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public void handleUrl(Context context, String jumpUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        WechatGuildManager.INSTANCE.a().handleUrl(context, jumpUrl, true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public boolean isShowWechatGuildSettingItemRedDot() {
        return WechatGuildManager.INSTANCE.a().isShowWechatGuildSettingItemRedDot();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public boolean isWeChatMsgAgentFlagSuc() {
        return WechatGuildManager.INSTANCE.a().getWeChatMsgAgentFlagSuc();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public boolean isWeChatMsgAgentOpen() {
        return WechatGuildManager.INSTANCE.a().isWeChatMsgAgentOpen();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public void openWeChatMiniApp(IAIOWeChatGuildApi.BIZ_TYPE_WX type, Context context) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        WechatGuildManager.INSTANCE.a().openWeChatMiniApp(translationType(type), context);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public void openWechat(Context context, String jumpUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        WechatGuildManager.INSTANCE.a().openWechat(context, jumpUrl, true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public void report(IAIOWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        WechatGuildManager.INSTANCE.a().report(translationType(type));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public void reportClik(IAIOWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        WechatGuildManager.INSTANCE.a().reportClik(translationType(type));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public void requestTianshuConfig() {
        WechatGuildManager.INSTANCE.a().requestTianshuConfig();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public void requestTianshuConfigIfNeeds() {
        WechatGuildManager.INSTANCE.a().requestTianshuConfigIfNeeds();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi
    public void report(IAIOWeChatGuildApi.BIZ_TYPE_WX type, long time) {
        Intrinsics.checkNotNullParameter(type, "type");
        WechatGuildManager.INSTANCE.a().report(translationType(type), time);
    }
}
