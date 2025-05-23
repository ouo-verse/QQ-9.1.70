package com.tencent.mobileqq.zootopia.portal.aigc.preview;

import com.tencent.ark.ark;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import org.json.JSONArray;
import org.json.JSONObject;
import qu4.q;
import qu4.r;
import uv4.az;
import wc3.LocalUgcPath;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u0006"}, d2 = {"Lorg/json/JSONObject;", "avatarCharacter", "Lwc3/c;", "localUgc", "", "c", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AigcPreviewBusinessSceneKt {
    public static final /* synthetic */ boolean b(JSONObject jSONObject, LocalUgcPath localUgcPath) {
        return c(jSONObject, localUgcPath);
    }

    public static final boolean d(File it) {
        String extension;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        extension = FilesKt__UtilsKt.getExtension(it);
        return Intrinsics.areEqual(ark.ARKMETADATA_JSON, extension);
    }

    public static final boolean c(JSONObject jSONObject, LocalUgcPath localUgcPath) {
        Object first;
        Sequence sequence;
        try {
            JSONArray slotArr = jSONObject.getJSONObject("avatar_info").getJSONArray("slot_arr");
            String local_ugc_texture_path = localUgcPath.getLocal_ugc_texture_path();
            az store_item = localUgcPath.getStore_item();
            File[] listFiles = new File(local_ugc_texture_path + "/ConfigData").listFiles(new FileFilter() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.a
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    boolean d16;
                    d16 = AigcPreviewBusinessSceneKt.d(file);
                    return d16;
                }
            });
            Intrinsics.checkNotNull(listFiles);
            first = ArraysKt___ArraysKt.first(listFiles);
            File file = (File) first;
            q[] qVarArr = store_item.f440297z.f429572a.f429578b;
            Intrinsics.checkNotNullExpressionValue(qVarArr, "newStoreItem.avatarCharacter.avatarInfo.slotArr");
            for (q newSlotInfo : qVarArr) {
                String valueOf = String.valueOf(newSlotInfo.f429639a);
                Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
                sequence = SequencesKt__SequenceBuilderKt.sequence(new AigcPreviewBusinessSceneKt$dressLocalUgcTexture$$inlined$asSequence$1(slotArr, null));
                Iterator it = sequence.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    Object next = it.next();
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(((JSONObject) next).optString(MiniAppReportManager2.KEY_SLOT_ID), valueOf)) {
                        break;
                    }
                    i3++;
                }
                Intrinsics.checkNotNullExpressionValue(newSlotInfo, "newSlotInfo");
                JSONObject s16 = r94.c.s(newSlotInfo);
                r rVar = newSlotInfo.f429643e;
                if (rVar != null && rVar.f429652i) {
                    s16.getJSONObject("item_data").put("local_ugc_texture_path", file);
                    s16.put("custom_data", new JSONObject("{\"color_config_id\":0,\"custom_color\":0,\"control_points\":[],\"ugc_id\":1}"));
                }
                if (i3 == -1) {
                    slotArr.mo162put(s16);
                } else {
                    slotArr.put(i3, s16);
                }
            }
            return true;
        } catch (Throwable th5) {
            QLog.e("AigcPreviewBusinessScene", 1, "fetchAvatarInfo error localUgc=" + localUgcPath, th5);
            return false;
        }
    }
}
