package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b4\u00105R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000b\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u0003\u0010\u0017R$\u0010\"\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015\"\u0004\b\u0012\u0010\u0017R$\u0010$\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b#\u0010\u0015\"\u0004\b\u001d\u0010\u0017R$\u0010'\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R$\u0010)\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b(\u0010\u000e\"\u0004\b \u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000e\"\u0004\b*\u0010\u000fR$\u00103\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b\u0019\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/aq;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$a;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;", "a", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;", "getSceneId", "()Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;", "g", "(Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;)V", WadlProxyConsts.SCENE_ID, "", "b", "Ljava/lang/Integer;", "getIAdId", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "iAdId", "", "c", "Ljava/lang/String;", "getTraceInfo", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "d", "getText", tl.h.F, "text", "e", "getDes", SecretUtils.DES, "f", "getIconUrl", "iconUrl", "getJumpUrl", WadlProxyConsts.KEY_JUMP_URL, "getBtnText", "setBtnText", TuxUIConstants.POP_BTN_TEXT, "getRedType", "redType", "j", "getType", "type", "Lorg/json/JSONObject;", "k", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", ark.ARKMETADATA_JSON, "<init>", "(Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/json/JSONObject;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aq implements IAIOWeChatGuildApi.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IAIOWeChatGuildApi.BIZ_TYPE_WX sceneId;

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

    public aq(IAIOWeChatGuildApi.BIZ_TYPE_WX biz_type_wx, Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2, Integer num3, JSONObject jSONObject) {
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

    public void a(String str) {
        this.des = str;
    }

    public void b(Integer num) {
        this.iAdId = num;
    }

    public void c(String str) {
        this.iconUrl = str;
    }

    public void d(JSONObject jSONObject) {
        this.json = jSONObject;
    }

    public void e(String str) {
        this.jumpUrl = str;
    }

    public void f(Integer num) {
        this.redType = num;
    }

    public void g(IAIOWeChatGuildApi.BIZ_TYPE_WX biz_type_wx) {
        this.sceneId = biz_type_wx;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi.a
    public JSONObject getJson() {
        return this.json;
    }

    public void h(String str) {
        this.text = str;
    }

    public void i(String str) {
        this.traceInfo = str;
    }

    public void j(Integer num) {
        this.type = num;
    }

    public /* synthetic */ aq(IAIOWeChatGuildApi.BIZ_TYPE_WX biz_type_wx, Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2, Integer num3, JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : biz_type_wx, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : str5, (i3 & 128) != 0 ? null : str6, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : num3, (i3 & 1024) == 0 ? jSONObject : null);
    }
}
