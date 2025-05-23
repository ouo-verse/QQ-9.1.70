package com.tencent.mobileqq.guild.media.core.data;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001\u0013B1\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004JS\u0010\u0010\u001a\u00020\u000e2K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bJ\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b!\u0010\u001a\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/MediaShareLoadInfo;", "", "", tl.h.F, "", "g", "b", "c", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "showAioTips", UIJsPlugin.EVENT_SHOW_TOAST, "tips", "", "callback", "i", "toString", "", "a", "I", "f", "()I", "shareType", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "sessionId", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "d", "()Lorg/json/JSONObject;", "queryJson", "e", "shareChannelId", "<init>", "(ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaShareLoadInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int shareType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sessionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final JSONObject queryJson;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String shareChannelId;

    public MediaShareLoadInfo() {
        this(0, null, null, null, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h() {
        int collectionSizeOrDefault;
        HashSet hashSet;
        List<p> list = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "getDataHub().userInfoList.anchors");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((p) next).f228098f == 0) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((p) it5.next()).f228093a);
        }
        hashSet = CollectionsKt___CollectionsKt.toHashSet(arrayList2);
        hashSet.add(ch.f());
        if (hashSet.size() <= 1) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String b() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.queryJson;
        if (jSONObject2 != null) {
            jSONObject = jSONObject2.optJSONObject("playAppInfo");
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("appId");
        if (optString == null) {
            return "";
        }
        return optString;
    }

    @NotNull
    public final String c() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.queryJson;
        if (jSONObject2 != null) {
            jSONObject = jSONObject2.optJSONObject("playAppInfo");
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("appName");
        if (optString == null) {
            return "";
        }
        return optString;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final JSONObject getQueryJson() {
        return this.queryJson;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getShareChannelId() {
        return this.shareChannelId;
    }

    /* renamed from: f, reason: from getter */
    public final int getShareType() {
        return this.shareType;
    }

    @NotNull
    public final String g() {
        JSONObject jSONObject;
        boolean z16;
        String str;
        JSONObject jSONObject2 = this.queryJson;
        String str2 = null;
        if (jSONObject2 != null) {
            jSONObject = jSONObject2.optJSONObject("playAppInfo");
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("appId");
        if (optString == null) {
            optString = "";
        }
        IGProLobbyAppInfo thirdAppInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
        if (optString.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return "";
        }
        if (thirdAppInfo != null) {
            str = thirdAppInfo.getAppId();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(optString, str)) {
            return "";
        }
        JSONObject jSONObject3 = this.queryJson;
        if (jSONObject3 != null) {
            str2 = jSONObject3.optString("query");
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public final void i(@NotNull Function3<? super Boolean, ? super Boolean, ? super String, Unit> callback) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        Intrinsics.checkNotNullParameter(callback, "callback");
        String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        boolean z19 = true;
        if (this.queryJson != null) {
            if (b().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (this.shareChannelId.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    if (E.length() == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18 && Intrinsics.areEqual(this.shareChannelId, E)) {
                        IGProLobbyAppInfo thirdAppInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
                        if (thirdAppInfo != null) {
                            str = thirdAppInfo.getAppId();
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "";
                        }
                        Logger.f235387a.d().d("QGMC.MediaShareLoadInfo", 1, "[showThirdAppLoadTips] currentAppId " + str + ", shareAppInfo: " + this);
                        if (Intrinsics.areEqual(b(), str)) {
                            if (str.length() <= 0) {
                                z19 = false;
                            }
                            if (z19) {
                                Boolean bool = Boolean.FALSE;
                                callback.invoke(bool, bool, "");
                                return;
                            }
                        }
                        CorountineFunKt.e(com.tencent.mobileqq.guild.media.core.j.b(), "showThirdAppLoadTips", null, null, null, new MediaShareLoadInfo$showThirdAppLoadTips$3(this, callback, null), 14, null);
                        return;
                    }
                }
            }
        }
        Boolean bool2 = Boolean.FALSE;
        callback.invoke(bool2, bool2, "");
        Logger.f235387a.d().d("QGMC.MediaShareLoadInfo", 1, "[showThirdAppLoadTips] no any session! queryJson " + getQueryJson() + ", shareChannelId " + getShareChannelId());
    }

    @NotNull
    public String toString() {
        return "shareType=" + this.shareType + ", sessionId=" + this.sessionId + ", queryJson=" + this.queryJson;
    }

    public MediaShareLoadInfo(int i3, @NotNull String sessionId, @Nullable JSONObject jSONObject, @NotNull String shareChannelId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(shareChannelId, "shareChannelId");
        this.shareType = i3;
        this.sessionId = sessionId;
        this.queryJson = jSONObject;
        this.shareChannelId = shareChannelId;
    }

    public /* synthetic */ MediaShareLoadInfo(int i3, String str, JSONObject jSONObject, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? null : jSONObject, (i16 & 8) != 0 ? "" : str2);
    }
}
