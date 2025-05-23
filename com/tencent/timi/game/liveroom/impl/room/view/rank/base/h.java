package com.tencent.timi.game.liveroom.impl.room.view.rank.base;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 #2\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\r\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0010R\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u0015\u0010\u0010R\"\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b\u001c\u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/h;", "", "Ld55/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lorg/json/JSONObject;", "b", "", "a", "Ld55/e;", "Ld55/e;", "configRsp", "Ljava/lang/String;", "currentTab", "c", "getAnchorUid", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "anchorUid", "d", "getQqLiveAnchorId", "qqLiveAnchorId", "e", "getRoomId", tl.h.F, "roomId", "f", "getQqLiveStreamSdkAppId", "qqLiveStreamSdkAppId", "g", "getQqLiveProgramId", "qqLiveProgramId", "getQqLiveZhiBoType", "qqLiveZhiBoType", "<init>", "(Ld55/e;Ljava/lang/String;)V", "i", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d55.e configRsp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String currentTab;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String anchorUid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qqLiveAnchorId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qqLiveStreamSdkAppId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qqLiveProgramId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qqLiveZhiBoType;

    public h(@NotNull d55.e configRsp, @NotNull String currentTab) {
        Intrinsics.checkNotNullParameter(configRsp, "configRsp");
        Intrinsics.checkNotNullParameter(currentTab, "currentTab");
        this.configRsp = configRsp;
        this.currentTab = currentTab;
        this.anchorUid = "";
        this.qqLiveAnchorId = "";
        this.roomId = "";
        this.qqLiveStreamSdkAppId = "";
        this.qqLiveProgramId = "";
        this.qqLiveZhiBoType = "";
    }

    private final JSONObject b(d55.h item) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", item.f393081b);
        jSONObject.put("type", item.f393080a);
        return jSONObject;
    }

    @NotNull
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        d55.h[] rankItems = this.configRsp.f393068c;
        if (rankItems != null) {
            Intrinsics.checkNotNullExpressionValue(rankItems, "rankItems");
            for (d55.h it : rankItems) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                jSONArray.mo162put(b(it));
            }
        }
        jSONObject.put(DownloadInfo.spKey_Config, jSONArray);
        jSONObject.put("currentTab", this.currentTab);
        jSONObject.put("anchorUid", this.anchorUid);
        jSONObject.put("qqliveAnchorId", this.qqLiveAnchorId);
        jSONObject.put("roomId", this.roomId);
        jSONObject.put("qqlivestreamSdkAppId", this.qqLiveStreamSdkAppId);
        jSONObject.put("qqliveProgramId", this.qqLiveProgramId);
        jSONObject.put("qqliveZhiboType", this.qqLiveZhiBoType);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ype)\n        }.toString()");
        return jSONObject2;
    }

    public final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.anchorUid = str;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qqLiveAnchorId = str;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qqLiveProgramId = str;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qqLiveStreamSdkAppId = str;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qqLiveZhiBoType = str;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.roomId = str;
    }
}
