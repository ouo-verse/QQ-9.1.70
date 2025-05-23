package com.tencent.mobileqq.wechatguildreport.api.src;

import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b3\u00104R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u0019\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b\u001e\u0010\u0017R$\u0010$\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R$\u0010&\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b%\u0010\u0015\"\u0004\b\u0012\u0010\u0017R$\u0010)\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR$\u00102\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010.\u001a\u0004\b/\u00100\"\u0004\b!\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/wechatguildreport/api/src/a;", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$a;", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "a", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "getSceneId", "()Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "i", "(Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;)V", WadlProxyConsts.SCENE_ID, "", "b", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "e", "(Ljava/lang/Integer;)V", "iAdId", "", "c", "Ljava/lang/String;", "getTraceInfo", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "d", "getText", "j", "text", SecretUtils.DES, "f", "getIconUrl", "iconUrl", "g", "getJumpUrl", tl.h.F, WadlProxyConsts.KEY_JUMP_URL, "getBtnText", TuxUIConstants.POP_BTN_TEXT, "getRedType", "setRedType", "redType", "getType", "l", "type", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", ark.ARKMETADATA_JSON, "<init>", "(Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/json/JSONObject;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a implements IWeChatGuildApi.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IWeChatGuildApi.BIZ_TYPE_WX sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Integer iAdId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String traceInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String des;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String iconUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String jumpUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String btnText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Integer redType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Integer type;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private JSONObject json;

    public a(IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx, Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2, Integer num3, JSONObject jSONObject) {
        this.sceneId = biz_type_wx;
        this.iAdId = num;
        this.traceInfo = str;
        this.text = str2;
        this.des = str3;
        this.iconUrl = str4;
        this.jumpUrl = str5;
        this.btnText = str6;
        this.redType = num2;
        this.type = num3;
        this.json = jSONObject;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    /* renamed from: a, reason: from getter */
    public String getDes() {
        return this.des;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    /* renamed from: b, reason: from getter */
    public Integer getIAdId() {
        return this.iAdId;
    }

    public void c(String str) {
        this.btnText = str;
    }

    public void d(String str) {
        this.des = str;
    }

    public void e(Integer num) {
        this.iAdId = num;
    }

    public void f(String str) {
        this.iconUrl = str;
    }

    public void g(JSONObject jSONObject) {
        this.json = jSONObject;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    public JSONObject getJson() {
        return this.json;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    public String getJumpUrl() {
        return this.jumpUrl;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    public Integer getRedType() {
        return this.redType;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    public IWeChatGuildApi.BIZ_TYPE_WX getSceneId() {
        return this.sceneId;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    public String getText() {
        return this.text;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    public String getTraceInfo() {
        return this.traceInfo;
    }

    @Override // com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi.a
    public Integer getType() {
        return this.type;
    }

    public void h(String str) {
        this.jumpUrl = str;
    }

    public void i(IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx) {
        this.sceneId = biz_type_wx;
    }

    public void j(String str) {
        this.text = str;
    }

    public void k(String str) {
        this.traceInfo = str;
    }

    public void l(Integer num) {
        this.type = num;
    }

    public /* synthetic */ a(IWeChatGuildApi.BIZ_TYPE_WX biz_type_wx, Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2, Integer num3, JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : biz_type_wx, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : str5, (i3 & 128) != 0 ? null : str6, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : num3, (i3 & 1024) == 0 ? jSONObject : null);
    }
}
