package com.tencent.mobileqq.wechatguildreport.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.mobileqq.wechatguildreport.api.src.WechatGuildManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.vip.pb.TianShuAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J \u0010\"\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\nH\u0016J \u0010#\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\rH\u0016R\u001a\u0010)\u001a\u00020\u001f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wechatguildreport/api/impl/WeChatGuildApiImpl;", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi;", "", "requestTianshuConfig", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "type", "Lcooperation/vip/pb/TianShuAccess$AdPlacementInfo;", "getConfig", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$a;", "getConfigData", "", "isWeChatMsgAgentFlagSuc", "isWeChatMsgAgentOpen", "", "getWeChatAgentReportFlag", "report", "", "time", "reportClik", "reportClose", "getLastTime", "requestTianshuConfigIfNeeds", QCircleLpReportDc05507.KEY_CLEAR, "Landroid/content/Context;", "context", "openWeChatMiniApp", "Landroid/view/View$OnClickListener;", "closeClickListener", "Landroid/view/View;", "getQZoneWechatGuildNoticeBar", "isShowWechatGuildSettingItemRedDot", "", WadlProxyConsts.KEY_JUMP_URL, "tipsShowAtTopActivity", "handleUrl", "openWechat", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$b;", "listener", "addListener", "listenerId", "removeListener", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WeChatGuildApiImpl implements IWeChatGuildApi {
    private final String TAG = "WeChatGuildApiImpl";

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public int addListener(IWeChatGuildApi.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return WechatGuildManager.INSTANCE.a().addListener(listener);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void clear() {
        WechatGuildManager.INSTANCE.a().clear();
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public TianShuAccess.AdPlacementInfo getConfig(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return WechatGuildManager.INSTANCE.a().getConfig(type);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public IWeChatGuildApi.a getConfigData(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return WechatGuildManager.INSTANCE.a().getConfigData(type);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public long getLastTime(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return WechatGuildManager.INSTANCE.a().getLastTime(type);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public View getQZoneWechatGuildNoticeBar(Context context, View.OnClickListener closeClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        return WechatGuildManager.INSTANCE.a().getQZoneWechatGuildNoticeBar(context, closeClickListener);
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public int getWeChatAgentReportFlag() {
        return WechatGuildManager.INSTANCE.a().getWeChatAgentReportFlag();
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void handleUrl(Context context, String jumpUrl, boolean tipsShowAtTopActivity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        WechatGuildManager.INSTANCE.a().handleUrl(context, jumpUrl, tipsShowAtTopActivity);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public boolean isShowWechatGuildSettingItemRedDot() {
        return WechatGuildManager.INSTANCE.a().isShowWechatGuildSettingItemRedDot();
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    /* renamed from: isWeChatMsgAgentFlagSuc */
    public boolean getWeChatMsgAgentFlagSuc() {
        return WechatGuildManager.INSTANCE.a().getWeChatMsgAgentFlagSuc();
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public boolean isWeChatMsgAgentOpen() {
        return WechatGuildManager.INSTANCE.a().isWeChatMsgAgentOpen();
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void openWeChatMiniApp(IWeChatGuildApi.BIZ_TYPE_WX type, Context context) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        WechatGuildManager.INSTANCE.a().openWeChatMiniApp(type, context);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void openWechat(Context context, String jumpUrl, boolean tipsShowAtTopActivity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        WechatGuildManager.INSTANCE.a().openWechat(context, jumpUrl, tipsShowAtTopActivity);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void removeListener(int listenerId) {
        WechatGuildManager.INSTANCE.a().removeListener(listenerId);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void report(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        WechatGuildManager.INSTANCE.a().report(type);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void reportClik(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        WechatGuildManager.INSTANCE.a().reportClik(type);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void reportClose(IWeChatGuildApi.BIZ_TYPE_WX type) {
        Intrinsics.checkNotNullParameter(type, "type");
        WechatGuildManager.INSTANCE.a().reportClose(type);
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void requestTianshuConfig() {
        WechatGuildManager.INSTANCE.a().requestTianshuConfig();
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void requestTianshuConfigIfNeeds() {
        WechatGuildManager.INSTANCE.a().requestTianshuConfigIfNeeds();
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi
    public void report(IWeChatGuildApi.BIZ_TYPE_WX type, long time) {
        Intrinsics.checkNotNullParameter(type, "type");
        WechatGuildManager.INSTANCE.a().report(type, time);
    }
}
