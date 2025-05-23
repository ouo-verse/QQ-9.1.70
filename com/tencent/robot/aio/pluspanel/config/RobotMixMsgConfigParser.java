package com.tencent.robot.aio.pluspanel.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y24.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/aio/pluspanel/config/RobotMixMsgConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Ly24/a;", "", DownloadInfo.spKey_Config, "", "d", "b", "", "content", "c", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotMixMsgConfigParser extends BaseConfigParser<a> {
    private final void d(a aVar, String str) {
        IntRange until;
        int collectionSizeOrDefault;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("uinwhitelist");
            if (optJSONArray != null) {
                until = RangesKt___RangesKt.until(0, optJSONArray.length());
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
                ArrayList<String> arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    arrayList.add(optJSONArray.optString(((IntIterator) it).nextInt()));
                }
                for (String it5 : arrayList) {
                    List<String> a16 = aVar.a();
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    a16.add(it5);
                }
            }
            QLog.i("RobotMixMsgConfigParser", 1, "parse config:" + aVar);
        } catch (JSONException e16) {
            QLog.e("RobotMixMsgConfigParser", 1, "parse error: " + e16.getMessage());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        a aVar = new a();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            d(aVar, new String(content, UTF_8));
        } else {
            QLog.i("RobotMixMsgConfigParser", 1, "parse empty content");
        }
        return aVar;
    }
}
